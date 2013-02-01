/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.menu.model.MenuLink;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ 
/*     */ public abstract class AuthorityAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String authorityName;
/*     */   protected String displayRef;
/*     */   protected String propertedResource;
/*     */   protected String description;
/*     */   protected Integer authorityType;
/*     */   protected MenuLink menuLink;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  61 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  65 */     if (((id != null) && (this.id == null)) || (
/*  66 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  67 */       setDirty(true);
/*  68 */       this.oldValues.put("id", this.id);
/*     */     }
/*  70 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  74 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  78 */     if (((version != null) && (this.version == null)) || (
/*  79 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  80 */       setDirty(true);
/*  81 */       this.oldValues.put("version", this.version);
/*     */     }
/*  83 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getAuthorityName() {
/*  87 */     return this.authorityName;
/*     */   }
/*     */ 
/*     */   public void setAuthorityName(String authorityName) {
/*  91 */     if (((authorityName != null) && (this.authorityName == null)) || (
/*  92 */       (this.authorityName != null) && ((!this.authorityName.equals(authorityName)) || (authorityName == null)))) {
/*  93 */       setDirty(true);
/*  94 */       this.oldValues.put("authorityName", this.authorityName);
/*     */     }
/*  96 */     this.authorityName = authorityName;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/* 100 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/* 104 */     if (((displayRef != null) && (this.displayRef == null)) || (
/* 105 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/* 106 */       setDirty(true);
/* 107 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/* 109 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getPropertedResource() {
/* 113 */     return this.propertedResource;
/*     */   }
/*     */ 
/*     */   public void setPropertedResource(String propertedResource) {
/* 117 */     if (((propertedResource != null) && (this.propertedResource == null)) || (
/* 118 */       (this.propertedResource != null) && ((!this.propertedResource.equals(propertedResource)) || (propertedResource == null)))) {
/* 119 */       setDirty(true);
/* 120 */       this.oldValues.put("propertedResource", this.propertedResource);
/*     */     }
/* 122 */     this.propertedResource = propertedResource;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 126 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 130 */     if (((description != null) && (this.description == null)) || (
/* 131 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 132 */       setDirty(true);
/* 133 */       this.oldValues.put("description", this.description);
/*     */     }
/* 135 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Integer getAuthorityType() {
/* 139 */     return this.authorityType;
/*     */   }
/*     */ 
/*     */   public void setAuthorityType(Integer authorityType) {
/* 143 */     if (((authorityType != null) && (this.authorityType == null)) || (
/* 144 */       (this.authorityType != null) && ((!this.authorityType.equals(authorityType)) || (authorityType == null)))) {
/* 145 */       setDirty(true);
/* 146 */       this.oldValues.put("authorityType", this.authorityType);
/*     */     }
/* 148 */     this.authorityType = authorityType;
/*     */   }
/*     */ 
/*     */   public MenuLink getMenuLink() {
/* 152 */     return this.menuLink;
/*     */   }
/*     */ 
/*     */   public void setMenuLink(MenuLink menuLink) {
/* 156 */     if (((menuLink != null) && (this.menuLink == null)) || (
/* 157 */       (this.menuLink != null) && ((!this.menuLink.equals(menuLink)) || (menuLink == null)))) {
/* 158 */       setDirty(true);
/* 159 */       this.oldValues.put("menuLink", this.menuLink);
/*     */     }
/* 161 */     this.menuLink = menuLink;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 167 */     if (this == other) return true;
/* 168 */     if (other == null) return false;
/* 169 */     if (!(other instanceof Authority)) return false;
/* 170 */     Authority castOther = (Authority)other;
/*     */ 
/* 172 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 176 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 177 */     hcb.append(getId());
/* 178 */     hcb.append("Authority".hashCode());
/* 179 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 183 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 184 */     sb.append("id", this.id)
/* 185 */       .append("authorityName", this.authorityName)
/* 186 */       .append("displayRef", this.displayRef)
/* 187 */       .append("propertedResource", this.propertedResource)
/* 188 */       .append("description", this.description)
/* 189 */       .append("authorityType", this.authorityType);
/*     */ 
/* 191 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 195 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.model.original.AuthorityAbstract
 * JD-Core Version:    0.6.0
 */