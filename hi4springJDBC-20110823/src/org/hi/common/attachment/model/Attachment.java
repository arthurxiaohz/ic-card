/*    */ package org.hi.common.attachment.model;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import org.hi.common.attachment.model.original.AttachmentAbstract;
/*    */ 
/*    */ public class Attachment extends AttachmentAbstract
/*    */ {
/* 10 */   private String icoPath = "common/sysimage/file/";
/* 11 */   private String errorImg = "common/sysimage/file/unknow.gif";
/* 12 */   private DecimalFormat df = new DecimalFormat("#.##");
/*    */ 
/*    */   public String getFileNameImage() {
/* 15 */     return getImage() + this.fileName;
/*    */   }
/*    */ 
/*    */   public String getImageICO()
/*    */   {
/* 21 */     String extFileName = "unknow";
/* 22 */     if ((getFileName() != null) && (getFileName().lastIndexOf(".") > 0))
/* 23 */       extFileName = getFileName().substring(this.fileName.lastIndexOf(".") + 1);
/* 24 */     return this.icoPath + extFileName + ".gif";
/*    */   }
/*    */ 
/*    */   private String getImage()
/*    */   {
/* 33 */     String extFileName = "unknow";
/* 34 */     if ((getFileName() != null) && (getFileName().lastIndexOf(".") > 0))
/* 35 */       extFileName = getFileName().substring(this.fileName.lastIndexOf(".") + 1);
/* 36 */     return "<image src='" + this.icoPath + extFileName + ".gif" + 
/* 37 */       "' border='0' onerror=javascript:this.src='" + this.errorImg + "' />";
/*    */   }
/*    */ 
/*    */   public String getDetailInfo()
/*    */   {
/* 45 */     return getImage() + getFileName() + "  大小:" + getFileSize() + "KB ";
/*    */   }
/*    */ 
/*    */   public String getAttachmentSize()
/*    */   {
/* 53 */     if ((getFileSize() == null) || (getFileSize().doubleValue() == 0.0D))
/* 54 */       return "0KB";
/* 55 */     if (getFileSize().doubleValue() > 1024.0D) {
/* 56 */       return this.df.format(getFileSize().doubleValue() / 1024.0D) + "MB";
/*    */     }
/* 58 */     return this.df.format(getFileSize()) + "KB ";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.model.Attachment
 * JD-Core Version:    0.6.0
 */