/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.Role;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ 
/*     */ public abstract class RoleAuthorityAbstract extends BaseObject
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
/*  54 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  58 */     if (((id != null) && (this.id == null)) || (
/*  59 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  60 */       setDirty(true);
/*  61 */       this.oldValues.put("id", this.id);
/*     */     }
/*  63 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  67 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  71 */     if (((version != null) && (this.version == null)) || (
/*  72 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  73 */       setDirty(true);
/*  74 */       this.oldValues.put("version", this.version);
/*     */     }
/*  76 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public Role getRole() {
/*  80 */     return this.role;
/*     */   }
/*     */ 
/*     */   public void setRole(Role role) {
/*  84 */     if (((role != null) && (this.role == null)) || (
/*  85 */       (this.role != null) && ((!this.role.equals(role)) || (role == null)))) {
/*  86 */       setDirty(true);
/*  87 */       this.oldValues.put("role", this.role);
/*     */     }
/*  89 */     this.role = role;
/*     */   }
/*     */ 
/*     */   public Authority getAuthority() {
/*  93 */     return this.authority;
/*     */   }
/*     */ 
/*     */   public void setAuthority(Authority authority) {
/*  97 */     if (((authority != null) && (this.authority == null)) || (
/*  98 */       (this.authority != null) && ((!this.authority.equals(authority)) || (authority == null)))) {
/*  99 */       setDirty(true);
/* 100 */       this.oldValues.put("authority", this.authority);
/*     */     }
/* 102 */     this.authority = authority;
/*     */   }
/*     */ 
/*     */   public HiOrg getOrg() {
/* 106 */     return this.org;
/*     */   }
/*     */ 
/*     */   public void setOrg(HiOrg org) {
/* 110 */     if (((org != null) && (this.org == null)) || (
/* 111 */       (this.org != null) && ((!this.org.equals(org)) || (org == null)))) {
/* 112 */       setDirty(true);
/* 113 */       this.oldValues.put("org", this.org);
/*     */     }
/* 115 */     this.org = org;
/*     */   }
/*     */ 
/*     */   public Integer getScope() {
/* 119 */     return this.scope;
/*     */   }
/*     */ 
/*     */   public void setScope(Integer scope) {
/* 123 */     if (((scope != null) && (this.scope == null)) || (
/* 124 */       (this.scope != null) && ((!this.scope.equals(scope)) || (scope == null)))) {
/* 125 */       setDirty(true);
/* 126 */       this.oldValues.put("scope", this.scope);
/*     */     }
/* 128 */     this.scope = scope;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 134 */     if (this == other) return true;
/* 135 */     if (other == null) return false;
/* 136 */     if (!(other instanceof RoleAuthority)) return false;
/* 137 */     RoleAuthority castOther = (RoleAuthority)other;
/*     */ 
/* 139 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 143 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 144 */     hcb.append(getId());
/* 145 */     hcb.append("RoleAuthority".hashCode());
/* 146 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 150 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 151 */     sb.append("id", this.id);
/*     */ 
/* 153 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 157 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.model.original.RoleAuthorityAbstract
 * JD-Core Version:    0.6.0
 */