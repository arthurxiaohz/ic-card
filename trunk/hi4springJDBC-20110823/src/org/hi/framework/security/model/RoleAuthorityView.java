/*     */ package org.hi.framework.security.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class RoleAuthorityView extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected Role role;
/*     */   protected Authority authority;
/*     */   protected HiOrg org;
/*     */   protected Integer scope;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  28 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  32 */     if (((id != null) && (this.id == null)) || (
/*  33 */       (this.id != null) && ((!this.id.equals(id)) || (id == null))))
/*  34 */       setDirty(true);
/*  35 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  39 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  43 */     if (((version != null) && (this.version == null)) || (
/*  44 */       (this.version != null) && ((!this.version.equals(version)) || (version == null))))
/*  45 */       setDirty(true);
/*  46 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public Role getRole() {
/*  50 */     return this.role;
/*     */   }
/*     */ 
/*     */   public void setRole(Role role) {
/*  54 */     if (((role != null) && (this.role == null)) || (
/*  55 */       (this.role != null) && ((!this.role.equals(role)) || (role == null))))
/*  56 */       setDirty(true);
/*  57 */     this.role = role;
/*     */   }
/*     */ 
/*     */   public Authority getAuthority() {
/*  61 */     return this.authority;
/*     */   }
/*     */ 
/*     */   public void setAuthority(Authority authority) {
/*  65 */     if (((authority != null) && (this.authority == null)) || (
/*  66 */       (this.authority != null) && ((!this.authority.equals(authority)) || (authority == null))))
/*  67 */       setDirty(true);
/*  68 */     this.authority = authority;
/*     */   }
/*     */ 
/*     */   public HiOrg getOrg() {
/*  72 */     return this.org;
/*     */   }
/*     */ 
/*     */   public void setOrg(HiOrg org) {
/*  76 */     if (((org != null) && (this.org == null)) || (
/*  77 */       (this.org != null) && ((!this.org.equals(org)) || (org == null))))
/*  78 */       setDirty(true);
/*  79 */     this.org = org;
/*     */   }
/*     */ 
/*     */   public Integer getScope() {
/*  83 */     return this.scope;
/*     */   }
/*     */ 
/*     */   public void setScope(Integer scope) {
/*  87 */     if (((scope != null) && (this.scope == null)) || (
/*  88 */       (this.scope != null) && ((!this.scope.equals(scope)) || (scope == null))))
/*  89 */       setDirty(true);
/*  90 */     this.scope = scope;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/*  96 */     if (this == other) return true;
/*  97 */     if (other == null) return false;
/*  98 */     if (!(other instanceof RoleAuthority)) return false;
/*  99 */     RoleAuthority castOther = (RoleAuthority)other;
/*     */ 
/* 101 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 105 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 106 */     hcb.append(getId());
/*     */ 
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.RoleAuthorityView
 * JD-Core Version:    0.6.0
 */