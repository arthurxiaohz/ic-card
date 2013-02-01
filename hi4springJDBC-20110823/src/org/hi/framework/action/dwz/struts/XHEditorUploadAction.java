/*    */ package org.hi.framework.action.dwz.struts;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.attachment.action.cust.FtpUtil;
/*    */ import org.hi.common.attachment.model.Attachment;
/*    */ import org.hi.common.attachment.service.AttachmentManager;
/*    */ import org.hi.common.util.JSONObject;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class XHEditorUploadAction extends BaseAction
/*    */ {
/*    */   private File filedata;
/*    */   private String filedataContentType;
/*    */   private String filedataFileName;
/*    */   private String json;
/* 22 */   private String maxSize = HiConfigHolder.getProperty("hi.upload.ftp.maxSize") == null ? "100" : HiConfigHolder.getProperty("hi.upload.ftp.maxSize");
/*    */ 
/*    */   public String execute() throws Exception {
/* 25 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 26 */     FtpUtil ftpUtil = new FtpUtil();
/* 27 */     if (this.filedata != null) {
/* 28 */       if (this.filedata.length() / 1024.0D / 1024.0D > new Double(this.maxSize).doubleValue()) {
/* 29 */         JSONObject jsonObject = new JSONObject("err", I18NUtil.getStringByParameter("上传文件过大", "Attachment", this.maxSize));
/* 30 */         jsonObject.addJSONObject("msg", "");
/* 31 */         this.json = jsonObject.toString();
/* 32 */         return "json";
/*    */       }
/*    */ 
/* 35 */       Attachment attachment = new Attachment();
/* 36 */       String filedataPath = "";
/*    */ 
/* 38 */       filedataPath = ftpUtil.saveFile(this.filedata, this.filedataFileName, "xhEditor");
/*    */ 
/* 40 */       attachment.setAttachmentPath(filedataPath);
/* 41 */       attachment.setFileSize(Double.valueOf(this.filedata.length() / 1024.0D));
/* 42 */       attachment.setFileType(this.filedataContentType);
/* 43 */       attachment.setFileName(this.filedataFileName);
/* 44 */       attachmentMgr.saveObject(attachment);
/*    */ 
/* 46 */       JSONObject jsonObject = new JSONObject("err", "");
/* 47 */       jsonObject.addJSONObject("msg", filedataPath);
/* 48 */       this.json = jsonObject.toString();
/* 49 */       return "json";
/*    */     }
/*    */ 
/* 52 */     JSONObject jsonObject = new JSONObject("err", I18NUtil.getString("文件件为空"));
/* 53 */     jsonObject.addJSONObject("msg", "");
/* 54 */     this.json = jsonObject.toString();
/* 55 */     return "json";
/*    */   }
/*    */ 
/*    */   public File getFiledata() {
/* 59 */     return this.filedata;
/*    */   }
/*    */ 
/*    */   public void setFiledata(File filedata) {
/* 63 */     this.filedata = filedata;
/*    */   }
/*    */ 
/*    */   public String getFiledataContentType() {
/* 67 */     return this.filedataContentType;
/*    */   }
/*    */ 
/*    */   public void setFiledataContentType(String filedataContentType) {
/* 71 */     this.filedataContentType = filedataContentType;
/*    */   }
/*    */ 
/*    */   public String getFiledataFileName() {
/* 75 */     return this.filedataFileName;
/*    */   }
/*    */ 
/*    */   public void setFiledataFileName(String filedataFileName) {
/* 79 */     this.filedataFileName = filedataFileName;
/*    */   }
/*    */ 
/*    */   public String getJson() {
/* 83 */     return this.json;
/*    */   }
/*    */ 
/*    */   public void setJson(String json) {
/* 87 */     this.json = json;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.action.dwz.struts.XHEditorUploadAction
 * JD-Core Version:    0.6.0
 */