/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.GroupRole;
/*     */ import org.hi.framework.security.model.Role;
/*     */ import org.hi.framework.security.model.SecurityGroup;
/*     */ 
/*     */ public abstract class GroupRoleAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected SecurityGroup securityGroup;
/*     */   protected Role role;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  42 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  46 */     if (((id != null) && (this.id == null)) || (
/*  47 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  48 */       setDirty(true);
/*  49 */       this.oldValues.put("id", this.id);
/*     */     }
/*  51 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  55 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  59 */     if (((version != null) && (this.version == null)) || (
/*  60 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  61 */       setDirty(true);
/*  62 */       this.oldValues.put("version", this.version);
/*     */     }
/*  64 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public SecurityGroup getSecurityGroup() {
/*  68 */     return this.securityGroup;
/*     */   }
/*     */ 
/*     */   public void setSecurityGroup(SecurityGroup securityGroup) {
/*  72 */     if (((securityGroup != null) && (this.securityGroup == null)) || (
/*  73 */       (this.securityGroup != null) && ((!this.securityGroup.equals(securityGroup)) || (securityGroup == null)))) {
/*  74 */       setDirty(true);
/*  75 */       this.oldValues.put("securityGroup", this.securityGroup);
/*     */     }
/*  77 */     this.securityGroup = securityGroup;
/*     */   }
/*     */ 
/*     */   public Role getRole() {
/*  81 */     return this.role;
/*     */   }
/*     */ 
/*     */   public void setRole(Role role) {
/*  85 */     if (((role != null) && (this.role == null)) || (
/*  86 */       (this.role != null) && ((!this.role.equals(role)) || (role == null)))) {
/*  87 */       setDirty(true);
/*  88 */       this.oldValues.put("role", this.role);
/*     */     }
/*  90 */     this.role = role;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/*  96 */     if (this == other) return true;
/*  97 */     if (other == null) return false;
/*  98 */     if (!(other instanceof GroupRole)) return false;
/*  99 */     GroupRole castOther = (GroupRole)other;
/*     */ 
/* 101 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 105 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 106 */     hcb.append(getId());
/* 107 */     hcb.append("GroupRole".hashCode());
/* 108 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 112 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 113 */     sb.append("id", this.id);
/*     */ 
/* 115 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 119 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.model.original.GroupRoleAbstract
 * JD-Core Version:    0.6.0
 */