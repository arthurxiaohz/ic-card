/*     */ package org.hi.common.attachment.service.impl;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import org.hi.common.attachment.action.cust.FtpUtil;
/*     */ import org.hi.common.attachment.model.Attachment;
/*     */ import org.hi.common.attachment.service.AttachmentManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class AttachmentManagerImpl extends ManagerImpl
/*     */   implements AttachmentManager
/*     */ {
/*     */   protected void preSaveObject(Object obj)
/*     */   {
/*  17 */     super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  22 */     super.postSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  27 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  32 */     super.postRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   public void saveAttachment(Attachment attachment)
/*     */   {
/*  37 */     saveObject(attachment);
/*     */   }
/*     */ 
/*     */   public void removeAttachmentById(Integer id)
/*     */   {
/*  42 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public Attachment getAttachmentById(Integer id)
/*     */   {
/*  47 */     return (Attachment)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<Attachment> getAttachmentList(PageInfo pageInfo) {
/*  51 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public Attachment uploadFile(File file, int saveType, String fileName, String forder) throws IOException
/*     */   {
/*  56 */     return uploadFile(file, saveType, fileName, forder, null);
/*     */   }
/*     */ 
/*     */   public Attachment uploadFile(File file, int saveType, String fileName, String forder, String contextPath)
/*     */     throws IOException
/*     */   {
/*  64 */     String filePath = "";
/*  65 */     if ((forder == null) || (forder.equals("")))
/*  66 */       forder = "attachment";
/*  67 */     Attachment attachment = new Attachment();
/*  68 */     if (saveType == 2)
/*  69 */       attachment.setAttachmentType(Integer.valueOf(2));
/*     */     else {
/*  71 */       attachment.setAttachmentType(Integer.valueOf(1));
/*     */     }
/*  73 */     FtpUtil ftpUtil = new FtpUtil();
/*     */ 
/*  75 */     if (attachment.getAttachmentType().intValue() == 1)
/*  76 */       filePath = ftpUtil.saveFile(file, fileName, forder, contextPath);
/*     */     else {
/*  78 */       filePath = ftpUtil.saveFileToFTP(file, fileName, forder);
/*     */     }
/*  80 */     attachment.setAttachmentPath(filePath);
/*  81 */     attachment.setFileSize(Double.valueOf(file.length() / 1024.0D));
/*  82 */     attachment.setFileType("");
/*  83 */     attachment.setFileName(file.getName());
/*  84 */     saveObject(attachment);
/*     */ 
/*  86 */     return attachment;
/*     */   }
/*     */ 
/*     */   public Attachment uploadFile(InputStream inputStream, int saveType, String fileName, String forder)
/*     */     throws IOException
/*     */   {
/*  92 */     return uploadFile(inputStream, saveType, fileName, forder, null);
/*     */   }
/*     */ 
/*     */   public Attachment uploadFile(InputStream inputStream, int saveType, String fileName, String forder, String contextPath) throws IOException {
/*  96 */     String path = "";
/*  97 */     int size = inputStream.available();
/*  98 */     if ((forder == null) || (forder.equals("")))
/*  99 */       forder = "attachment";
/* 100 */     Attachment attachment = new Attachment();
/* 101 */     if (saveType == 2)
/* 102 */       attachment.setAttachmentType(Integer.valueOf(2));
/*     */     else {
/* 104 */       attachment.setAttachmentType(Integer.valueOf(1));
/*     */     }
/* 106 */     FtpUtil ftpUtil = new FtpUtil();
/*     */ 
/* 108 */     if (attachment.getAttachmentType().intValue() == 1)
/* 109 */       path = ftpUtil.saveInputStream(inputStream, fileName, forder, contextPath);
/*     */     else {
/* 111 */       path = ftpUtil.saveInputStreamToFTP(inputStream, fileName, forder);
/*     */     }
/* 113 */     attachment.setAttachmentPath(path);
/* 114 */     attachment.setFileSize(Double.valueOf(size / 1024.0D));
/* 115 */     attachment.setFileType("");
/* 116 */     attachment.setFileName(fileName);
/* 117 */     saveObject(attachment);
/*     */ 
/* 119 */     return attachment;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.attachment.service.impl.AttachmentManagerImpl
 * JD-Core Version:    0.6.0
 */