/*     */ package org.hi.base.sysapp.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.sysapp.model.AppSetting;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public abstract class AppSettingAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String appGroup;
/*     */   protected String appName;
/*     */   protected String appValue;
/*     */   protected String description;
/*  53 */   protected HiUser creator = UserContextHelper.getUser();
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
/*     */   public String getAppGroup() {
/*  84 */     return this.appGroup;
/*     */   }
/*     */ 
/*     */   public void setAppGroup(String appGroup) {
/*  88 */     if (((appGroup != null) && (this.appGroup == null)) || (
/*  89 */       (this.appGroup != null) && ((!this.appGroup.equals(appGroup)) || (appGroup == null)))) {
/*  90 */       setDirty(true);
/*  91 */       this.oldValues.put("appGroup", this.appGroup);
/*     */     }
/*  93 */     this.appGroup = appGroup;
/*     */   }
/*     */ 
/*     */   public String getAppName() {
/*  97 */     return this.appName;
/*     */   }
/*     */ 
/*     */   public void setAppName(String appName) {
/* 101 */     if (((appName != null) && (this.appName == null)) || (
/* 102 */       (this.appName != null) && ((!this.appName.equals(appName)) || (appName == null)))) {
/* 103 */       setDirty(true);
/* 104 */       this.oldValues.put("appName", this.appName);
/*     */     }
/* 106 */     this.appName = appName;
/*     */   }
/*     */ 
/*     */   public String getAppValue() {
/* 110 */     return this.appValue;
/*     */   }
/*     */ 
/*     */   public void setAppValue(String appValue) {
/* 114 */     if (((appValue != null) && (this.appValue == null)) || (
/* 115 */       (this.appValue != null) && ((!this.appValue.equals(appValue)) || (appValue == null)))) {
/* 116 */       setDirty(true);
/* 117 */       this.oldValues.put("appValue", this.appValue);
/*     */     }
/* 119 */     this.appValue = appValue;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 123 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 127 */     if (((description != null) && (this.description == null)) || (
/* 128 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 129 */       setDirty(true);
/* 130 */       this.oldValues.put("description", this.description);
/*     */     }
/* 132 */     this.description = description;
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
/*     */   public boolean equals(Object other)
/*     */   {
/* 151 */     if (this == other) return true;
/* 152 */     if (other == null) return false;
/* 153 */     if (!(other instanceof AppSetting)) return false;
/* 154 */     AppSetting castOther = (AppSetting)other;
/*     */ 
/* 156 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 160 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 161 */     hcb.append(getId());
/* 162 */     hcb.append("AppSetting".hashCode());
/* 163 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 167 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 168 */     sb.append("id", this.id)
/* 169 */       .append("appGroup", this.appGroup)
/* 170 */       .append("appName", this.appName)
/* 171 */       .append("appValue", this.appValue)
/* 172 */       .append("description", this.description);
/*     */ 
/* 174 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 178 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.model.original.AppSettingAbstract
 * JD-Core Version:    0.6.0
 */