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
/*     */ import org.hi.i18n.model.Language;
/*     */ import org.hi.i18n.model.LanguageStr;
/*     */ 
/*     */ public abstract class LanguageStrAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected Language language;
/*     */   protected String languageCode;
/*     */   protected String value;
/*  48 */   protected HiUser creator = UserContextHelper.getUser();
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  52 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  56 */     if (((id != null) && (this.id == null)) || (
/*  57 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  58 */       setDirty(true);
/*  59 */       this.oldValues.put("id", this.id);
/*     */     }
/*  61 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  65 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  69 */     if (((version != null) && (this.version == null)) || (
/*  70 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  71 */       setDirty(true);
/*  72 */       this.oldValues.put("version", this.version);
/*     */     }
/*  74 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public Language getLanguage() {
/*  78 */     return this.language;
/*     */   }
/*     */ 
/*     */   public void setLanguage(Language language) {
/*  82 */     if (((language != null) && (this.language == null)) || (
/*  83 */       (this.language != null) && ((!this.language.equals(language)) || (language == null)))) {
/*  84 */       setDirty(true);
/*  85 */       this.oldValues.put("language", this.language);
/*     */     }
/*  87 */     this.language = language;
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity() {
/*  91 */     return this.language;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent) {
/*  95 */     this.language = ((Language)parent);
/*     */   }
/*     */ 
/*     */   public String getLanguageCode() {
/*  99 */     return this.languageCode;
/*     */   }
/*     */ 
/*     */   public void setLanguageCode(String languageCode) {
/* 103 */     if (((languageCode != null) && (this.languageCode == null)) || (
/* 104 */       (this.languageCode != null) && ((!this.languageCode.equals(languageCode)) || (languageCode == null)))) {
/* 105 */       setDirty(true);
/* 106 */       this.oldValues.put("languageCode", this.languageCode);
/*     */     }
/* 108 */     this.languageCode = languageCode;
/*     */   }
/*     */ 
/*     */   public String getValue() {
/* 112 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value) {
/* 116 */     if (((value != null) && (this.value == null)) || (
/* 117 */       (this.value != null) && ((!this.value.equals(value)) || (value == null)))) {
/* 118 */       setDirty(true);
/* 119 */       this.oldValues.put("value", this.value);
/*     */     }
/* 121 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 125 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 129 */     if (((creator != null) && (this.creator == null)) || (
/* 130 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 131 */       setDirty(true);
/* 132 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 134 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 140 */     if (this == other) return true;
/* 141 */     if (other == null) return false;
/* 142 */     if (!(other instanceof LanguageStr)) return false;
/* 143 */     LanguageStr castOther = (LanguageStr)other;
/*     */ 
/* 145 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 149 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 150 */     hcb.append(getId());
/* 151 */     hcb.append("LanguageStr".hashCode());
/* 152 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 156 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 157 */     sb.append("id", this.id)
/* 158 */       .append("languageCode", this.languageCode)
/* 159 */       .append("value", this.value);
/*     */ 
/* 161 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 165 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.model.original.LanguageStrAbstract
 * JD-Core Version:    0.6.0
 */