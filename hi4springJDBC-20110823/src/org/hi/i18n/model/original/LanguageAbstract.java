/*     */ package org.hi.i18n.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
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
/*     */ public abstract class LanguageAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String keyStr;
/*     */   protected String service;
/*     */   protected String entity;
/*  48 */   protected Integer isSystem = Integer.valueOf(0);
/*     */ 
/*  53 */   protected HiUser creator = UserContextHelper.getUser();
/*     */   private List<LanguageStr> languageStrs;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  62 */     if (((id != null) && (this.id == null)) || (
/*  63 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  64 */       setDirty(true);
/*  65 */       this.oldValues.put("id", this.id);
/*     */     }
/*  67 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  71 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  75 */     if (((version != null) && (this.version == null)) || (
/*  76 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  77 */       setDirty(true);
/*  78 */       this.oldValues.put("version", this.version);
/*     */     }
/*  80 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getKeyStr() {
/*  84 */     return this.keyStr;
/*     */   }
/*     */ 
/*     */   public void setKeyStr(String keyStr) {
/*  88 */     if (((keyStr != null) && (this.keyStr == null)) || (
/*  89 */       (this.keyStr != null) && ((!this.keyStr.equals(keyStr)) || (keyStr == null)))) {
/*  90 */       setDirty(true);
/*  91 */       this.oldValues.put("keyStr", this.keyStr);
/*     */     }
/*  93 */     this.keyStr = keyStr;
/*     */   }
/*     */ 
/*     */   public String getService() {
/*  97 */     return this.service;
/*     */   }
/*     */ 
/*     */   public void setService(String service) {
/* 101 */     if (((service != null) && (this.service == null)) || (
/* 102 */       (this.service != null) && ((!this.service.equals(service)) || (service == null)))) {
/* 103 */       setDirty(true);
/* 104 */       this.oldValues.put("service", this.service);
/*     */     }
/* 106 */     this.service = service;
/*     */   }
/*     */ 
/*     */   public String getEntity() {
/* 110 */     return this.entity;
/*     */   }
/*     */ 
/*     */   public void setEntity(String entity) {
/* 114 */     if (((entity != null) && (this.entity == null)) || (
/* 115 */       (this.entity != null) && ((!this.entity.equals(entity)) || (entity == null)))) {
/* 116 */       setDirty(true);
/* 117 */       this.oldValues.put("entity", this.entity);
/*     */     }
/* 119 */     this.entity = entity;
/*     */   }
/*     */ 
/*     */   public Integer getIsSystem() {
/* 123 */     return this.isSystem;
/*     */   }
/*     */ 
/*     */   public void setIsSystem(Integer isSystem) {
/* 127 */     if (((isSystem != null) && (this.isSystem == null)) || (
/* 128 */       (this.isSystem != null) && ((!this.isSystem.equals(isSystem)) || (isSystem == null)))) {
/* 129 */       setDirty(true);
/* 130 */       this.oldValues.put("isSystem", this.isSystem);
/*     */     }
/* 132 */     this.isSystem = isSystem;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 136 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 140 */     if (((creator != null) && (this.creator == null)) || (
/* 141 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 142 */       setDirty(true);
/* 143 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 145 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public void setLanguageStrs(List<LanguageStr> languageStrs)
/*     */   {
/* 150 */     this.languageStrs = languageStrs;
/*     */   }
/*     */ 
/*     */   public List<LanguageStr> getLanguageStrs() {
/* 154 */     return this.languageStrs;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other) {
/* 158 */     if (this == other) return true;
/* 159 */     if (other == null) return false;
/* 160 */     if (!(other instanceof Language)) return false;
/* 161 */     Language castOther = (Language)other;
/*     */ 
/* 163 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 167 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 168 */     hcb.append(getId());
/* 169 */     hcb.append("Language".hashCode());
/* 170 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 174 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 175 */     sb.append("id", this.id)
/* 176 */       .append("keyStr", this.keyStr)
/* 177 */       .append("service", this.service)
/* 178 */       .append("entity", this.entity)
/* 179 */       .append("isSystem", this.isSystem);
/*     */ 
/* 181 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 185 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.model.original.LanguageAbstract
 * JD-Core Version:    0.6.0
 */