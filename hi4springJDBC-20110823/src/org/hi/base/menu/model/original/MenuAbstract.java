/*     */ package org.hi.base.menu.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.menu.model.Menu;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class MenuAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String menuName;
/*     */   protected String displayRef;
/*     */   protected String description;
/*     */   protected Menu parentMenu;
/*  52 */   protected Double sequence = new Double(9999.0D);
/*     */ 
/*  57 */   protected Integer menuType = new Integer(0);
/*     */   protected HiUser creator;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  66 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  70 */     if (((id != null) && (this.id == null)) || (
/*  71 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  72 */       setDirty(true);
/*  73 */       this.oldValues.put("id", this.id);
/*     */     }
/*  75 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  79 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  83 */     if (((version != null) && (this.version == null)) || (
/*  84 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  85 */       setDirty(true);
/*  86 */       this.oldValues.put("version", this.version);
/*     */     }
/*  88 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getMenuName() {
/*  92 */     return this.menuName;
/*     */   }
/*     */ 
/*     */   public void setMenuName(String menuName) {
/*  96 */     if (((menuName != null) && (this.menuName == null)) || (
/*  97 */       (this.menuName != null) && ((!this.menuName.equals(menuName)) || (menuName == null)))) {
/*  98 */       setDirty(true);
/*  99 */       this.oldValues.put("menuName", this.menuName);
/*     */     }
/* 101 */     this.menuName = menuName;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/* 105 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/* 109 */     if (((displayRef != null) && (this.displayRef == null)) || (
/* 110 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/* 111 */       setDirty(true);
/* 112 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/* 114 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 118 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 122 */     if (((description != null) && (this.description == null)) || (
/* 123 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 124 */       setDirty(true);
/* 125 */       this.oldValues.put("description", this.description);
/*     */     }
/* 127 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Menu getParentMenu() {
/* 131 */     return this.parentMenu;
/*     */   }
/*     */ 
/*     */   public void setParentMenu(Menu parentMenu) {
/* 135 */     if (((parentMenu != null) && (this.parentMenu == null)) || (
/* 136 */       (this.parentMenu != null) && ((!this.parentMenu.equals(parentMenu)) || (parentMenu == null)))) {
/* 137 */       setDirty(true);
/* 138 */       this.oldValues.put("parentMenu", this.parentMenu);
/*     */     }
/* 140 */     this.parentMenu = parentMenu;
/*     */   }
/*     */ 
/*     */   public Double getSequence() {
/* 144 */     return this.sequence;
/*     */   }
/*     */ 
/*     */   public void setSequence(Double sequence) {
/* 148 */     if (((sequence != null) && (this.sequence == null)) || (
/* 149 */       (this.sequence != null) && ((!this.sequence.equals(sequence)) || (sequence == null)))) {
/* 150 */       setDirty(true);
/* 151 */       this.oldValues.put("sequence", this.sequence);
/*     */     }
/* 153 */     this.sequence = sequence;
/*     */   }
/*     */ 
/*     */   public Integer getMenuType() {
/* 157 */     return this.menuType;
/*     */   }
/*     */ 
/*     */   public void setMenuType(Integer menuType) {
/* 161 */     if (((menuType != null) && (this.menuType == null)) || (
/* 162 */       (this.menuType != null) && ((!this.menuType.equals(menuType)) || (menuType == null)))) {
/* 163 */       setDirty(true);
/* 164 */       this.oldValues.put("menuType", this.menuType);
/*     */     }
/* 166 */     this.menuType = menuType;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 170 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 174 */     if (((creator != null) && (this.creator == null)) || (
/* 175 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 176 */       setDirty(true);
/* 177 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 179 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 185 */     if (this == other) return true;
/* 186 */     if (other == null) return false;
/* 187 */     if (!(other instanceof Menu)) return false;
/* 188 */     Menu castOther = (Menu)other;
/*     */ 
/* 190 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 194 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 195 */     hcb.append(getId());
/* 196 */     hcb.append("Menu".hashCode());
/* 197 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 201 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 202 */     sb.append("id", this.id)
/* 203 */       .append("menuName", this.menuName)
/* 204 */       .append("displayRef", this.displayRef)
/* 205 */       .append("description", this.description)
/* 206 */       .append("sequence", this.sequence)
/* 207 */       .append("menuType", this.menuType);
/*     */ 
/* 209 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 213 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.model.original.MenuAbstract
 * JD-Core Version:    0.6.0
 */