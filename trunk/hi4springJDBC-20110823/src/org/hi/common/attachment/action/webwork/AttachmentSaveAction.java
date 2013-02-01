/*    */ package org.hi.common.attachment.action.webwork;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.attachment.action.cust.FtpUtil;
/*    */ import org.hi.common.attachment.model.Attachment;
/*    */ import org.hi.common.attachment.service.AttachmentManager;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class AttachmentSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Attachment attachment;
/*    */   private File image;
/*    */   private String imageFileName;
/*    */   private String imageContentType;
/* 22 */   private String maxSize = HiConfigHolder.getProperty("hi.upload.ftp.maxSize") == null ? "100" : HiConfigHolder.getProperty("hi.upload.ftp.maxSize");
/*    */ 
/*    */   public File getImage() {
/* 25 */     return this.image;
/*    */   }
/*    */ 
/*    */   public void setImage(File image) {
/* 29 */     this.image = image;
/*    */   }
/*    */ 
/*    */   public String getImageContentType() {
/* 33 */     return this.imageContentType;
/*    */   }
/*    */ 
/*    */   public void setImageContentType(String imageContentType) {
/* 37 */     this.imageContentType = imageContentType;
/*    */   }
/*    */ 
/*    */   public String getImageFileName() {
/* 41 */     return this.imageFileName;
/*    */   }
/*    */ 
/*    */   public void setImageFileName(String imageFileName) {
/* 45 */     this.imageFileName = imageFileName;
/*    */   }
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 52 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 53 */     FtpUtil ftpUtil = new FtpUtil();
/* 54 */     if (super.perExecute(this.attachment) != null) return returnCommand();
/*    */ 
/* 56 */     if (this.image != null) {
/* 57 */       if (this.image.length() / 1024.0D / 1024.0D > new Double(this.maxSize).doubleValue()) {
/* 58 */         throw new BusinessException(I18NUtil.getStringByParameter("上传文件过大", "Attachment", this.maxSize));
/*    */       }
/* 60 */       String imagePath = "";
/* 61 */       if (this.attachment.getAttachmentType().intValue() == 2)
/* 62 */         imagePath = ftpUtil.saveFileToFTP(this.image, this.imageFileName, this.attachment.getAttachDesc());
/*    */       else {
/* 64 */         imagePath = ftpUtil.saveFile(this.image, this.imageFileName, this.attachment.getAttachDesc());
/*    */       }
/* 66 */       this.attachment.setAttachmentPath(imagePath);
/* 67 */       this.attachment.setFileSize(Double.valueOf(this.image.length() / 1024.0D));
/* 68 */       this.attachment.setFileType(this.imageContentType);
/* 69 */       this.attachment.setFileName(this.imageFileName);
/* 70 */       attachmentMgr.saveObject(this.attachment);
/*    */     }
/*    */ 
/* 74 */     super.postExecute(this.attachment);
/* 75 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Attachment getAttachment() {
/* 79 */     return this.attachment;
/*    */   }
/*    */ 
/*    */   public void setAttachment(Attachment attachment) {
/* 83 */     this.attachment = attachment;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.action.webwork.AttachmentSaveAction
 * JD-Core Version:    0.6.0
 */