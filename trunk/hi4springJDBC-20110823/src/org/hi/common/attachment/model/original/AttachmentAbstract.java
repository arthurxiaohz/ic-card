/*     */ package org.hi.common.attachment.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.common.attachment.model.Attachment;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class AttachmentAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String fileName;
/*     */   protected String fileType;
/*     */   protected Double fileSize;
/*  46 */   protected Integer attachmentType = Integer.valueOf(1);
/*     */   protected String attachmentPath;
/*     */   protected String attachDesc;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  60 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  64 */     if (((id != null) && (this.id == null)) || (
/*  65 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  66 */       setDirty(true);
/*  67 */       this.oldValues.put("id", this.id);
/*     */     }
/*  69 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  73 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  77 */     if (((version != null) && (this.version == null)) || (
/*  78 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  79 */       setDirty(true);
/*  80 */       this.oldValues.put("version", this.version);
/*     */     }
/*  82 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getFileName() {
/*  86 */     return this.fileName;
/*     */   }
/*     */ 
/*     */   public void setFileName(String fileName) {
/*  90 */     if (((fileName != null) && (this.fileName == null)) || (
/*  91 */       (this.fileName != null) && ((!this.fileName.equals(fileName)) || (fileName == null)))) {
/*  92 */       setDirty(true);
/*  93 */       this.oldValues.put("fileName", this.fileName);
/*     */     }
/*  95 */     this.fileName = fileName;
/*     */   }
/*     */ 
/*     */   public String getFileType() {
/*  99 */     return this.fileType;
/*     */   }
/*     */ 
/*     */   public void setFileType(String fileType) {
/* 103 */     if (((fileType != null) && (this.fileType == null)) || (
/* 104 */       (this.fileType != null) && ((!this.fileType.equals(fileType)) || (fileType == null)))) {
/* 105 */       setDirty(true);
/* 106 */       this.oldValues.put("fileType", this.fileType);
/*     */     }
/* 108 */     this.fileType = fileType;
/*     */   }
/*     */ 
/*     */   public Double getFileSize() {
/* 112 */     return this.fileSize;
/*     */   }
/*     */ 
/*     */   public void setFileSize(Double fileSize) {
/* 116 */     if (((fileSize != null) && (this.fileSize == null)) || (
/* 117 */       (this.fileSize != null) && ((!this.fileSize.equals(fileSize)) || (fileSize == null)))) {
/* 118 */       setDirty(true);
/* 119 */       this.oldValues.put("fileSize", this.fileSize);
/*     */     }
/* 121 */     this.fileSize = fileSize;
/*     */   }
/*     */ 
/*     */   public Integer getAttachmentType() {
/* 125 */     return this.attachmentType;
/*     */   }
/*     */ 
/*     */   public void setAttachmentType(Integer attachmentType) {
/* 129 */     if (((attachmentType != null) && (this.attachmentType == null)) || (
/* 130 */       (this.attachmentType != null) && ((!this.attachmentType.equals(attachmentType)) || (attachmentType == null)))) {
/* 131 */       setDirty(true);
/* 132 */       this.oldValues.put("attachmentType", this.attachmentType);
/*     */     }
/* 134 */     this.attachmentType = attachmentType;
/*     */   }
/*     */ 
/*     */   public String getAttachmentPath() {
/* 138 */     return this.attachmentPath;
/*     */   }
/*     */ 
/*     */   public void setAttachmentPath(String attachmentPath) {
/* 142 */     if (((attachmentPath != null) && (this.attachmentPath == null)) || (
/* 143 */       (this.attachmentPath != null) && ((!this.attachmentPath.equals(attachmentPath)) || (attachmentPath == null)))) {
/* 144 */       setDirty(true);
/* 145 */       this.oldValues.put("attachmentPath", this.attachmentPath);
/*     */     }
/* 147 */     this.attachmentPath = attachmentPath;
/*     */   }
/*     */ 
/*     */   public String getAttachDesc() {
/* 151 */     return this.attachDesc;
/*     */   }
/*     */ 
/*     */   public void setAttachDesc(String attachDesc) {
/* 155 */     if (((attachDesc != null) && (this.attachDesc == null)) || (
/* 156 */       (this.attachDesc != null) && ((!this.attachDesc.equals(attachDesc)) || (attachDesc == null)))) {
/* 157 */       setDirty(true);
/* 158 */       this.oldValues.put("attachDesc", this.attachDesc);
/*     */     }
/* 160 */     this.attachDesc = attachDesc;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 166 */     if (this == other) return true;
/* 167 */     if (other == null) return false;
/* 168 */     if (!(other instanceof Attachment)) return false;
/* 169 */     Attachment castOther = (Attachment)other;
/*     */ 
/* 171 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 175 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 176 */     hcb.append(getId());
/* 177 */     hcb.append("Attachment".hashCode());
/* 178 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 182 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 183 */     sb.append("id", this.id)
/* 184 */       .append("fileName", this.fileName)
/* 185 */       .append("fileType", this.fileType)
/* 186 */       .append("fileSize", this.fileSize)
/* 187 */       .append("attachmentType", this.attachmentType)
/* 188 */       .append("attachmentPath", this.attachmentPath)
/* 189 */       .append("attachDesc", this.attachDesc);
/*     */ 
/* 191 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 195 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.model.original.AttachmentAbstract
 * JD-Core Version:    0.6.0
 */