/*     */ package org.hi.common.attachment.action.struts;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.attachment.action.cust.FtpUtil;
/*     */ import org.hi.common.attachment.model.Attachment;
/*     */ import org.hi.common.attachment.service.AttachmentManager;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class AttachmentViewAction extends BaseAction
/*     */ {
/*     */   private Attachment attachment;
/*  19 */   private String fileName = "";
/*     */   private InputStream inputStream;
/*  21 */   private String downloadFile = "";
/*  22 */   private String contentType = "application/octet-stream;charset=gb2312";
/*     */ 
/*     */   public String getContentType()
/*     */   {
/*  26 */     return this.contentType;
/*     */   }
/*     */ 
/*     */   public String getDownloadFile() {
/*  30 */     return this.downloadFile;
/*     */   }
/*     */ 
/*     */   public void setDownloadFile(String downloadFile) {
/*  34 */     this.downloadFile = downloadFile;
/*     */   }
/*     */ 
/*     */   public void setContentType(String contentType) {
/*  38 */     this.contentType = contentType;
/*     */   }
/*     */ 
/*     */   public String getFileName() {
/*  42 */     return this.fileName;
/*     */   }
/*     */ 
/*     */   public void setFileName(String fileName) {
/*  46 */     this.fileName = fileName;
/*     */   }
/*     */ 
/*     */   public InputStream getInputStream() {
/*  50 */     return this.inputStream;
/*     */   }
/*     */ 
/*     */   public void setInputStream(InputStream inputStream) {
/*  54 */     this.inputStream = inputStream;
/*     */   }
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  61 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/*  62 */     this.attachment = attachmentMgr.getAttachmentById(this.attachment.getId());
/*     */ 
/*  64 */     this.fileName = this.attachment.getFileName();
/*  65 */     this.fileName = new String(this.fileName.getBytes("gb2312"), "iso8859-1").toString();
/*  66 */     File file = null;
/*  67 */     if (this.attachment.getAttachmentType().intValue() == 1)
/*     */     {
/*  69 */       file = new File(getRequest().getRealPath("/") + this.attachment.getAttachmentPath());
/*  70 */       this.inputStream = new FileInputStream(file);
/*  71 */       return returnCommand();
/*     */     }
/*     */ 
/*  75 */     FtpUtil ftp = new FtpUtil();
/*     */     try
/*     */     {
/*  79 */       ftp.connectServer();
/*     */ 
/*  81 */       OutputStream os = ftp.download(this.attachment.getAttachmentPath(), file);
/*  82 */       this.inputStream = new ByteArrayInputStream(((ByteArrayOutputStream)os).toByteArray());
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  86 */       throw e;
/*     */     }
/*     */     finally {
/*  89 */       ftp.closeServer();
/*     */     }
/*     */ 
/*  93 */     this.fileName = this.attachment.getFileName();
/*     */ 
/*  95 */     return "download";
/*     */   }
/*     */ 
/*     */   public Attachment getAttachment() {
/*  99 */     return this.attachment;
/*     */   }
/*     */ 
/*     */   public void setAttachment(Attachment attachment) {
/* 103 */     this.attachment = attachment;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.action.struts.AttachmentViewAction
 * JD-Core Version:    0.6.0
 */