/*     */ package org.hi.base.menu.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.menu.model.Menu;
/*     */ import org.hi.base.menu.model.MenuLink;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ 
/*     */ public abstract class MenuLinkAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String linkUrl;
/*     */   protected String displayRef;
/*     */   protected String description;
/*     */   protected Authority authority;
/*  54 */   protected Double sequence = new Double(9999.0D);
/*     */   protected Menu menu;
/*  64 */   protected Integer menuLinkType = new Integer(0);
/*     */   protected HiUser creator;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  73 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  77 */     if (((id != null) && (this.id == null)) || (
/*  78 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  79 */       setDirty(true);
/*  80 */       this.oldValues.put("id", this.id);
/*     */     }
/*  82 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  86 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  90 */     if (((version != null) && (this.version == null)) || (
/*  91 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  92 */       setDirty(true);
/*  93 */       this.oldValues.put("version", this.version);
/*     */     }
/*  95 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getLinkUrl() {
/*  99 */     return this.linkUrl;
/*     */   }
/*     */ 
/*     */   public void setLinkUrl(String linkUrl) {
/* 103 */     if (((linkUrl != null) && (this.linkUrl == null)) || (
/* 104 */       (this.linkUrl != null) && ((!this.linkUrl.equals(linkUrl)) || (linkUrl == null)))) {
/* 105 */       setDirty(true);
/* 106 */       this.oldValues.put("linkUrl", this.linkUrl);
/*     */     }
/* 108 */     this.linkUrl = linkUrl;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/* 112 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/* 116 */     if (((displayRef != null) && (this.displayRef == null)) || (
/* 117 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/* 118 */       setDirty(true);
/* 119 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/* 121 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 125 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 129 */     if (((description != null) && (this.description == null)) || (
/* 130 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 131 */       setDirty(true);
/* 132 */       this.oldValues.put("description", this.description);
/*     */     }
/* 134 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Authority getAuthority() {
/* 138 */     return this.authority;
/*     */   }
/*     */ 
/*     */   public void setAuthority(Authority authority) {
/* 142 */     if (((authority != null) && (this.authority == null)) || (
/* 143 */       (this.authority != null) && ((!this.authority.equals(authority)) || (authority == null)))) {
/* 144 */       setDirty(true);
/* 145 */       this.oldValues.put("authority", this.authority);
/*     */     }
/* 147 */     this.authority = authority;
/*     */   }
/*     */ 
/*     */   public Double getSequence() {
/* 151 */     return this.sequence;
/*     */   }
/*     */ 
/*     */   public void setSequence(Double sequence) {
/* 155 */     if (((sequence != null) && (this.sequence == null)) || (
/* 156 */       (this.sequence != null) && ((!this.sequence.equals(sequence)) || (sequence == null)))) {
/* 157 */       setDirty(true);
/* 158 */       this.oldValues.put("sequence", this.sequence);
/*     */     }
/* 160 */     this.sequence = sequence;
/*     */   }
/*     */ 
/*     */   public Menu getMenu() {
/* 164 */     return this.menu;
/*     */   }
/*     */ 
/*     */   public void setMenu(Menu menu) {
/* 168 */     if (((menu != null) && (this.menu == null)) || (
/* 169 */       (this.menu != null) && ((!this.menu.equals(menu)) || (menu == null)))) {
/* 170 */       setDirty(true);
/* 171 */       this.oldValues.put("menu", this.menu);
/*     */     }
/* 173 */     this.menu = menu;
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity() {
/* 177 */     return this.menu;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent) {
/* 181 */     this.menu = ((Menu)parent);
/*     */   }
/*     */ 
/*     */   public Integer getMenuLinkType() {
/* 185 */     return this.menuLinkType;
/*     */   }
/*     */ 
/*     */   public void setMenuLinkType(Integer menuLinkType) {
/* 189 */     if (((menuLinkType != null) && (this.menuLinkType == null)) || (
/* 190 */       (this.menuLinkType != null) && ((!this.menuLinkType.equals(menuLinkType)) || (menuLinkType == null)))) {
/* 191 */       setDirty(true);
/* 192 */       this.oldValues.put("menuLinkType", this.menuLinkType);
/*     */     }
/* 194 */     this.menuLinkType = menuLinkType;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 198 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 202 */     if (((creator != null) && (this.creator == null)) || (
/* 203 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 204 */       setDirty(true);
/* 205 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 207 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 213 */     if (this == other) return true;
/* 214 */     if (other == null) return false;
/* 215 */     if (!(other instanceof MenuLink)) return false;
/* 216 */     MenuLink castOther = (MenuLink)other;
/*     */ 
/* 218 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 222 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 223 */     hcb.append(getId());
/* 224 */     hcb.append("MenuLink".hashCode());
/* 225 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 229 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 230 */     sb.append("id", this.id)
/* 231 */       .append("linkUrl", this.linkUrl)
/* 232 */       .append("displayRef", this.displayRef)
/* 233 */       .append("description", this.description)
/* 234 */       .append("sequence", this.sequence)
/* 235 */       .append("menuLinkType", this.menuLinkType);
/*     */ 
/* 237 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 241 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.model.original.MenuLinkAbstract
 * JD-Core Version:    0.6.0
 */