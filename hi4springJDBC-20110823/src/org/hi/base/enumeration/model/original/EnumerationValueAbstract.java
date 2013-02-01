/*     */ package org.hi.base.enumeration.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.enumeration.model.Enumeration;
/*     */ import org.hi.base.enumeration.model.EnumerationValue;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public abstract class EnumerationValueAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String valueName;
/*     */   protected String displayRef;
/*     */   protected String description;
/*     */   protected String valueCode;
/*     */   protected Enumeration enumeration;
/*  58 */   protected HiUser creator = UserContextHelper.getUser();
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  62 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  66 */     if (((id != null) && (this.id == null)) || (
/*  67 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  68 */       setDirty(true);
/*  69 */       this.oldValues.put("id", this.id);
/*     */     }
/*  71 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  75 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  79 */     if (((version != null) && (this.version == null)) || (
/*  80 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  81 */       setDirty(true);
/*  82 */       this.oldValues.put("version", this.version);
/*     */     }
/*  84 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getValueName() {
/*  88 */     return this.valueName;
/*     */   }
/*     */ 
/*     */   public void setValueName(String valueName) {
/*  92 */     if (((valueName != null) && (this.valueName == null)) || (
/*  93 */       (this.valueName != null) && ((!this.valueName.equals(valueName)) || (valueName == null)))) {
/*  94 */       setDirty(true);
/*  95 */       this.oldValues.put("valueName", this.valueName);
/*     */     }
/*  97 */     this.valueName = valueName;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/* 101 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/* 105 */     if (((displayRef != null) && (this.displayRef == null)) || (
/* 106 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/* 107 */       setDirty(true);
/* 108 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/* 110 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 114 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 118 */     if (((description != null) && (this.description == null)) || (
/* 119 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 120 */       setDirty(true);
/* 121 */       this.oldValues.put("description", this.description);
/*     */     }
/* 123 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public String getValueCode() {
/* 127 */     return this.valueCode;
/*     */   }
/*     */ 
/*     */   public void setValueCode(String valueCode) {
/* 131 */     if (((valueCode != null) && (this.valueCode == null)) || (
/* 132 */       (this.valueCode != null) && ((!this.valueCode.equals(valueCode)) || (valueCode == null)))) {
/* 133 */       setDirty(true);
/* 134 */       this.oldValues.put("valueCode", this.valueCode);
/*     */     }
/* 136 */     this.valueCode = valueCode;
/*     */   }
/*     */ 
/*     */   public Enumeration getEnumeration() {
/* 140 */     return this.enumeration;
/*     */   }
/*     */ 
/*     */   public void setEnumeration(Enumeration enumeration) {
/* 144 */     if (((enumeration != null) && (this.enumeration == null)) || (
/* 145 */       (this.enumeration != null) && ((!this.enumeration.equals(enumeration)) || (enumeration == null)))) {
/* 146 */       setDirty(true);
/* 147 */       this.oldValues.put("enumeration", this.enumeration);
/*     */     }
/* 149 */     this.enumeration = enumeration;
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity() {
/* 153 */     return this.enumeration;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent) {
/* 157 */     this.enumeration = ((Enumeration)parent);
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 161 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 165 */     if (((creator != null) && (this.creator == null)) || (
/* 166 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 167 */       setDirty(true);
/* 168 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 170 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 176 */     if (this == other) return true;
/* 177 */     if (other == null) return false;
/* 178 */     if (!(other instanceof EnumerationValue)) return false;
/* 179 */     EnumerationValue castOther = (EnumerationValue)other;
/*     */ 
/* 181 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 185 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 186 */     hcb.append(getId());
/* 187 */     hcb.append("EnumerationValue".hashCode());
/* 188 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 192 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 193 */     sb.append("id", this.id)
/* 194 */       .append("valueName", this.valueName)
/* 195 */       .append("displayRef", this.displayRef)
/* 196 */       .append("description", this.description)
/* 197 */       .append("valueCode", this.valueCode);
/*     */ 
/* 199 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 203 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.model.original.EnumerationValueAbstract
 * JD-Core Version:    0.6.0
 */