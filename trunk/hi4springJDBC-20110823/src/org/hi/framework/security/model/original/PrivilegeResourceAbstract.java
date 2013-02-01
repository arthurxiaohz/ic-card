/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.PrivilegeResource;
/*     */ 
/*     */ public abstract class PrivilegeResourceAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String authorityName;
/*     */   protected String viewLayer;
/*     */   protected String veiwExtAuthNames;
/*     */   protected String businessLayer;
/*     */   protected String bizExtAuthNames;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  55 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  59 */     if (((id != null) && (this.id == null)) || (
/*  60 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  61 */       setDirty(true);
/*  62 */       this.oldValues.put("id", this.id);
/*     */     }
/*  64 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  68 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  72 */     if (((version != null) && (this.version == null)) || (
/*  73 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  74 */       setDirty(true);
/*  75 */       this.oldValues.put("version", this.version);
/*     */     }
/*  77 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getAuthorityName() {
/*  81 */     return this.authorityName;
/*     */   }
/*     */ 
/*     */   public void setAuthorityName(String authorityName) {
/*  85 */     if (((authorityName != null) && (this.authorityName == null)) || (
/*  86 */       (this.authorityName != null) && ((!this.authorityName.equals(authorityName)) || (authorityName == null)))) {
/*  87 */       setDirty(true);
/*  88 */       this.oldValues.put("authorityName", this.authorityName);
/*     */     }
/*  90 */     this.authorityName = authorityName;
/*     */   }
/*     */ 
/*     */   public String getViewLayer() {
/*  94 */     return this.viewLayer;
/*     */   }
/*     */ 
/*     */   public void setViewLayer(String viewLayer) {
/*  98 */     if (((viewLayer != null) && (this.viewLayer == null)) || (
/*  99 */       (this.viewLayer != null) && ((!this.viewLayer.equals(viewLayer)) || (viewLayer == null)))) {
/* 100 */       setDirty(true);
/* 101 */       this.oldValues.put("viewLayer", this.viewLayer);
/*     */     }
/* 103 */     this.viewLayer = viewLayer;
/*     */   }
/*     */ 
/*     */   public String getVeiwExtAuthNames() {
/* 107 */     return this.veiwExtAuthNames;
/*     */   }
/*     */ 
/*     */   public void setVeiwExtAuthNames(String veiwExtAuthNames) {
/* 111 */     if (((veiwExtAuthNames != null) && (this.veiwExtAuthNames == null)) || (
/* 112 */       (this.veiwExtAuthNames != null) && ((!this.veiwExtAuthNames.equals(veiwExtAuthNames)) || (veiwExtAuthNames == null)))) {
/* 113 */       setDirty(true);
/* 114 */       this.oldValues.put("veiwExtAuthNames", this.veiwExtAuthNames);
/*     */     }
/* 116 */     this.veiwExtAuthNames = veiwExtAuthNames;
/*     */   }
/*     */ 
/*     */   public String getBusinessLayer() {
/* 120 */     return this.businessLayer;
/*     */   }
/*     */ 
/*     */   public void setBusinessLayer(String businessLayer) {
/* 124 */     if (((businessLayer != null) && (this.businessLayer == null)) || (
/* 125 */       (this.businessLayer != null) && ((!this.businessLayer.equals(businessLayer)) || (businessLayer == null)))) {
/* 126 */       setDirty(true);
/* 127 */       this.oldValues.put("businessLayer", this.businessLayer);
/*     */     }
/* 129 */     this.businessLayer = businessLayer;
/*     */   }
/*     */ 
/*     */   public String getBizExtAuthNames() {
/* 133 */     return this.bizExtAuthNames;
/*     */   }
/*     */ 
/*     */   public void setBizExtAuthNames(String bizExtAuthNames) {
/* 137 */     if (((bizExtAuthNames != null) && (this.bizExtAuthNames == null)) || (
/* 138 */       (this.bizExtAuthNames != null) && ((!this.bizExtAuthNames.equals(bizExtAuthNames)) || (bizExtAuthNames == null)))) {
/* 139 */       setDirty(true);
/* 140 */       this.oldValues.put("bizExtAuthNames", this.bizExtAuthNames);
/*     */     }
/* 142 */     this.bizExtAuthNames = bizExtAuthNames;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 148 */     if (this == other) return true;
/* 149 */     if (other == null) return false;
/* 150 */     if (!(other instanceof PrivilegeResource)) return false;
/* 151 */     PrivilegeResource castOther = (PrivilegeResource)other;
/*     */ 
/* 153 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 157 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 158 */     hcb.append(getId());
/* 159 */     hcb.append("PrivilegeResource".hashCode());
/* 160 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 164 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 165 */     sb.append("id", this.id)
/* 166 */       .append("authorityName", this.authorityName)
/* 167 */       .append("viewLayer", this.viewLayer)
/* 168 */       .append("veiwExtAuthNames", this.veiwExtAuthNames)
/* 169 */       .append("businessLayer", this.businessLayer)
/* 170 */       .append("bizExtAuthNames", this.bizExtAuthNames);
/*     */ 
/* 172 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 176 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.original.PrivilegeResourceAbstract
 * JD-Core Version:    0.6.0
 */