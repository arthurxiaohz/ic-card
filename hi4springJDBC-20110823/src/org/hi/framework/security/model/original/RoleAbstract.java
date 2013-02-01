/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.security.model.Role;
/*     */ 
/*     */ public abstract class RoleAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String roleName;
/*     */   protected String displayRef;
/*     */   protected String description;
/*  47 */   protected HiUser creator = UserContextHelper.getUser();
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  51 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  55 */     if (((id != null) && (this.id == null)) || (
/*  56 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  57 */       setDirty(true);
/*  58 */       this.oldValues.put("id", this.id);
/*     */     }
/*  60 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  64 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  68 */     if (((version != null) && (this.version == null)) || (
/*  69 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  70 */       setDirty(true);
/*  71 */       this.oldValues.put("version", this.version);
/*     */     }
/*  73 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getRoleName() {
/*  77 */     return this.roleName;
/*     */   }
/*     */ 
/*     */   public void setRoleName(String roleName) {
/*  81 */     if (((roleName != null) && (this.roleName == null)) || (
/*  82 */       (this.roleName != null) && ((!this.roleName.equals(roleName)) || (roleName == null)))) {
/*  83 */       setDirty(true);
/*  84 */       this.oldValues.put("roleName", this.roleName);
/*     */     }
/*  86 */     this.roleName = roleName;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/*  90 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/*  94 */     if (((displayRef != null) && (this.displayRef == null)) || (
/*  95 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/*  96 */       setDirty(true);
/*  97 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/*  99 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 103 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 107 */     if (((description != null) && (this.description == null)) || (
/* 108 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 109 */       setDirty(true);
/* 110 */       this.oldValues.put("description", this.description);
/*     */     }
/* 112 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 116 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 120 */     if (((creator != null) && (this.creator == null)) || (
/* 121 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 122 */       setDirty(true);
/* 123 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 125 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 131 */     if (this == other) return true;
/* 132 */     if (other == null) return false;
/* 133 */     if (!(other instanceof Role)) return false;
/* 134 */     Role castOther = (Role)other;
/*     */ 
/* 136 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 140 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 141 */     hcb.append(getId());
/* 142 */     hcb.append("Role".hashCode());
/* 143 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 147 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 148 */     sb.append("id", this.id)
/* 149 */       .append("roleName", this.roleName)
/* 150 */       .append("displayRef", this.displayRef)
/* 151 */       .append("description", this.description);
/*     */ 
/* 153 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 157 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.original.RoleAbstract
 * JD-Core Version:    0.6.0
 */