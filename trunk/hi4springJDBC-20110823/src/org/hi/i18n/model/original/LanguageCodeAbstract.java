/*     */ package org.hi.i18n.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.i18n.model.LanguageCode;
/*     */ 
/*     */ public abstract class LanguageCodeAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String languageCode;
/*     */   protected String description;
/*  42 */   protected HiUser creator = UserContextHelper.getUser();
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  46 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  50 */     if (((id != null) && (this.id == null)) || (
/*  51 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  52 */       setDirty(true);
/*  53 */       this.oldValues.put("id", this.id);
/*     */     }
/*  55 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  59 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  63 */     if (((version != null) && (this.version == null)) || (
/*  64 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  65 */       setDirty(true);
/*  66 */       this.oldValues.put("version", this.version);
/*     */     }
/*  68 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getLanguageCode() {
/*  72 */     return this.languageCode;
/*     */   }
/*     */ 
/*     */   public void setLanguageCode(String languageCode) {
/*  76 */     if (((languageCode != null) && (this.languageCode == null)) || (
/*  77 */       (this.languageCode != null) && ((!this.languageCode.equals(languageCode)) || (languageCode == null)))) {
/*  78 */       setDirty(true);
/*  79 */       this.oldValues.put("languageCode", this.languageCode);
/*     */     }
/*  81 */     this.languageCode = languageCode;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  85 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/*  89 */     if (((description != null) && (this.description == null)) || (
/*  90 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/*  91 */       setDirty(true);
/*  92 */       this.oldValues.put("description", this.description);
/*     */     }
/*  94 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/*  98 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 102 */     if (((creator != null) && (this.creator == null)) || (
/* 103 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 104 */       setDirty(true);
/* 105 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 107 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 113 */     if (this == other) return true;
/* 114 */     if (other == null) return false;
/* 115 */     if (!(other instanceof LanguageCode)) return false;
/* 116 */     LanguageCode castOther = (LanguageCode)other;
/*     */ 
/* 118 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 122 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 123 */     hcb.append(getId());
/* 124 */     hcb.append("LanguageCode".hashCode());
/* 125 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 129 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 130 */     sb.append("id", this.id)
/* 131 */       .append("languageCode", this.languageCode)
/* 132 */       .append("description", this.description);
/*     */ 
/* 134 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 138 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.model.original.LanguageCodeAbstract
 * JD-Core Version:    0.6.0
 */