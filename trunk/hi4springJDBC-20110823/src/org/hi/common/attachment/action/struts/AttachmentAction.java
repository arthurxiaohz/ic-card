/*     */ package org.hi.common.attachment.action.struts;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.attachment.action.AttachmentPageInfo;
/*     */ import org.hi.common.attachment.action.cust.FtpUtil;
/*     */ import org.hi.common.attachment.model.Attachment;
/*     */ import org.hi.common.attachment.service.AttachmentManager;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class AttachmentAction extends BaseAction
/*     */ {
/*     */   private Attachment attachment;
/*     */   private AttachmentPageInfo pageInfo;
/*     */   private List<Attachment> attachments;
/*     */   private String orderIndexs;
/*     */   private File image;
/*     */   private String imageFileName;
/*     */   private String imageContentType;
/*  36 */   private String maxSize = HiConfigHolder.getProperty("hi.upload.ftp.maxSize") == null ? "100" : HiConfigHolder.getProperty("hi.upload.ftp.maxSize");
/*     */ 
/*     */   public String saveAttachment()
/*     */     throws Exception
/*     */   {
/*  41 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/*  42 */     FtpUtil ftpUtil = new FtpUtil();
/*  43 */     if (super.perExecute(this.attachment) != null) return returnCommand();
/*     */ 
/*  45 */     if (this.image != null) {
/*  46 */       if (this.image.length() / 1024.0D / 1024.0D > new Double(this.maxSize).doubleValue()) {
/*  47 */         throw new BusinessException(I18NUtil.getStringByParameter("上传文件过大", "Attachment", this.maxSize));
/*     */       }
/*  49 */       String imagePath = "";
/*  50 */       if (this.attachment.getAttachmentType().intValue() == 2)
/*  51 */         imagePath = ftpUtil.saveFileToFTP(this.image, this.imageFileName, this.attachment.getAttachDesc());
/*     */       else {
/*  53 */         imagePath = ftpUtil.saveFile(this.image, this.imageFileName, this.attachment.getAttachDesc());
/*     */       }
/*  55 */       this.attachment.setAttachmentPath(imagePath);
/*  56 */       this.attachment.setFileSize(Double.valueOf(this.image.length() / 1024.0D));
/*  57 */       this.attachment.setFileType(this.imageContentType);
/*  58 */       this.attachment.setFileName(this.imageFileName);
/*  59 */       attachmentMgr.saveObject(this.attachment);
/*     */     }
/*     */ 
/*  63 */     super.postExecute(this.attachment);
/*  64 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAttachment()
/*     */     throws Exception
/*     */   {
/*  72 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/*  73 */     attachmentMgr.removeAttachmentById(this.attachment.getId());
/*  74 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllAttachment()
/*     */     throws Exception
/*     */   {
/*  81 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/*  82 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  84 */       String[] ids = this.orderIndexs.split(",");
/*  85 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  87 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  89 */         Integer attachmentid = new Integer(ids[i]);
/*  90 */         attachmentMgr.removeAttachmentById(attachmentid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  95 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewAttachment()
/*     */     throws Exception
/*     */   {
/* 102 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 103 */     this.attachment = attachmentMgr.getAttachmentById(this.attachment.getId());
/* 104 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String attachmentList()
/*     */     throws Exception
/*     */   {
/* 111 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 112 */     this.pageInfo = (this.pageInfo == null ? new AttachmentPageInfo() : this.pageInfo);
/* 113 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/* 115 */     this.attachments = attachmentMgr.getAttachmentList(sarchPageInfo);
/*     */ 
/* 117 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Attachment getAttachment()
/*     */   {
/* 124 */     return this.attachment;
/*     */   }
/*     */ 
/*     */   public void setAttachment(Attachment attachment) {
/* 128 */     this.attachment = attachment;
/*     */   }
/*     */ 
/*     */   public List<Attachment> getAttachments() {
/* 132 */     return this.attachments;
/*     */   }
/*     */ 
/*     */   public void setAttachments(List<Attachment> attachments) {
/* 136 */     this.attachments = attachments;
/*     */   }
/*     */ 
/*     */   public AttachmentPageInfo getPageInfo() {
/* 140 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(AttachmentPageInfo pageInfo) {
/* 144 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 148 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 152 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ 
/*     */   public File getImage()
/*     */   {
/* 157 */     return this.image;
/*     */   }
/*     */ 
/*     */   public void setImage(File image)
/*     */   {
/* 162 */     this.image = image;
/*     */   }
/*     */ 
/*     */   public String getImageFileName()
/*     */   {
/* 167 */     return this.imageFileName;
/*     */   }
/*     */ 
/*     */   public void setImageFileName(String imageFileName)
/*     */   {
/* 172 */     this.imageFileName = imageFileName;
/*     */   }
/*     */ 
/*     */   public String getImageContentType()
/*     */   {
/* 177 */     return this.imageContentType;
/*     */   }
/*     */ 
/*     */   public void setImageContentType(String imageContentType)
/*     */   {
/* 182 */     this.imageContentType = imageContentType;
/*     */   }
/*     */ 
/*     */   public String getMaxSize()
/*     */   {
/* 187 */     return this.maxSize;
/*     */   }
/*     */ 
/*     */   public void setMaxSize(String maxSize)
/*     */   {
/* 192 */     this.maxSize = maxSize;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.attachment.action.struts.AttachmentAction
 * JD-Core Version:    0.6.0
 */