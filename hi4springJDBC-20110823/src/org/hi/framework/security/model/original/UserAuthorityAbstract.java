/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ 
/*     */ public abstract class UserAuthorityAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected HiUser securityUser;
/*     */   protected Authority authority;
/*     */   protected HiOrg org;
/*     */   protected Integer scope;
/*     */   protected RoleAuthority roleAuthority;
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
/*     */   public HiUser getSecurityUser() {
/*  86 */     return this.securityUser;
/*     */   }
/*     */ 
/*     */   public void setSecurityUser(HiUser securityUser) {
/*  90 */     if (((securityUser != null) && (this.securityUser == null)) || (
/*  91 */       (this.securityUser != null) && ((!this.securityUser.equals(securityUser)) || (securityUser == null)))) {
/*  92 */       setDirty(true);
/*  93 */       this.oldValues.put("securityUser", this.securityUser);
/*     */     }
/*  95 */     this.securityUser = securityUser;
/*     */   }
/*     */ 
/*     */   public Authority getAuthority() {
/*  99 */     return this.authority;
/*     */   }
/*     */ 
/*     */   public void setAuthority(Authority authority) {
/* 103 */     if (((authority != null) && (this.authority == null)) || (
/* 104 */       (this.authority != null) && ((!this.authority.equals(authority)) || (authority == null)))) {
/* 105 */       setDirty(true);
/* 106 */       this.oldValues.put("authority", this.authority);
/*     */     }
/* 108 */     this.authority = authority;
/*     */   }
/*     */ 
/*     */   public HiOrg getOrg() {
/* 112 */     return this.org;
/*     */   }
/*     */ 
/*     */   public void setOrg(HiOrg org) {
/* 116 */     if (((org != null) && (this.org == null)) || (
/* 117 */       (this.org != null) && ((!this.org.equals(org)) || (org == null)))) {
/* 118 */       setDirty(true);
/* 119 */       this.oldValues.put("org", this.org);
/*     */     }
/* 121 */     this.org = org;
/*     */   }
/*     */ 
/*     */   public Integer getScope() {
/* 125 */     return this.scope;
/*     */   }
/*     */ 
/*     */   public void setScope(Integer scope) {
/* 129 */     if (((scope != null) && (this.scope == null)) || (
/* 130 */       (this.scope != null) && ((!this.scope.equals(scope)) || (scope == null)))) {
/* 131 */       setDirty(true);
/* 132 */       this.oldValues.put("scope", this.scope);
/*     */     }
/* 134 */     this.scope = scope;
/*     */   }
/*     */ 
/*     */   public RoleAuthority getRoleAuthority() {
/* 138 */     return this.roleAuthority;
/*     */   }
/*     */ 
/*     */   public void setRoleAuthority(RoleAuthority roleAuthority) {
/* 142 */     if (((roleAuthority != null) && (this.roleAuthority == null)) || (
/* 143 */       (this.roleAuthority != null) && ((!this.roleAuthority.equals(roleAuthority)) || (roleAuthority == null)))) {
/* 144 */       setDirty(true);
/* 145 */       this.oldValues.put("roleAuthority", this.roleAuthority);
/*     */     }
/* 147 */     this.roleAuthority = roleAuthority;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 153 */     if (this == other) return true;
/* 154 */     if (other == null) return false;
/* 155 */     if (!(other instanceof UserAuthority)) return false;
/* 156 */     UserAuthority castOther = (UserAuthority)other;
/*     */ 
/* 158 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 162 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 163 */     hcb.append(getId());
/* 164 */     hcb.append("UserAuthority".hashCode());
/* 165 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 169 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 170 */     sb.append("id", this.id);
/*     */ 
/* 172 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 176 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.model.original.UserAuthorityAbstract
 * JD-Core Version:    0.6.0
 */