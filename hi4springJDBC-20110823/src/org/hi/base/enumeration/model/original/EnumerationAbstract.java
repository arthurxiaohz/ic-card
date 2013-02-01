/*     */ package org.hi.base.enumeration.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
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
/*     */ public abstract class EnumerationAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String enName;
/*     */   protected String displayRef;
/*     */   protected String description;
/*  48 */   protected Integer enumerationType = Integer.valueOf(0);
/*     */ 
/*  53 */   protected HiUser creator = UserContextHelper.getUser();
/*     */   private List<EnumerationValue> enumerationValues;
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
/*     */   public String getEnName() {
/*  84 */     return this.enName;
/*     */   }
/*     */ 
/*     */   public void setEnName(String enName) {
/*  88 */     if (((enName != null) && (this.enName == null)) || (
/*  89 */       (this.enName != null) && ((!this.enName.equals(enName)) || (enName == null)))) {
/*  90 */       setDirty(true);
/*  91 */       this.oldValues.put("enName", this.enName);
/*     */     }
/*  93 */     this.enName = enName;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/*  97 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/* 101 */     if (((displayRef != null) && (this.displayRef == null)) || (
/* 102 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/* 103 */       setDirty(true);
/* 104 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/* 106 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 110 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 114 */     if (((description != null) && (this.description == null)) || (
/* 115 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 116 */       setDirty(true);
/* 117 */       this.oldValues.put("description", this.description);
/*     */     }
/* 119 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Integer getEnumerationType() {
/* 123 */     return this.enumerationType;
/*     */   }
/*     */ 
/*     */   public void setEnumerationType(Integer enumerationType) {
/* 127 */     if (((enumerationType != null) && (this.enumerationType == null)) || (
/* 128 */       (this.enumerationType != null) && ((!this.enumerationType.equals(enumerationType)) || (enumerationType == null)))) {
/* 129 */       setDirty(true);
/* 130 */       this.oldValues.put("enumerationType", this.enumerationType);
/*     */     }
/* 132 */     this.enumerationType = enumerationType;
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
/*     */   public void setEnumerationValues(List<EnumerationValue> enumerationValues)
/*     */   {
/* 150 */     this.enumerationValues = enumerationValues;
/*     */   }
/*     */ 
/*     */   public List<EnumerationValue> getEnumerationValues() {
/* 154 */     return this.enumerationValues;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other) {
/* 158 */     if (this == other) return true;
/* 159 */     if (other == null) return false;
/* 160 */     if (!(other instanceof Enumeration)) return false;
/* 161 */     Enumeration castOther = (Enumeration)other;
/*     */ 
/* 163 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 167 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 168 */     hcb.append(getId());
/* 169 */     hcb.append("Enumeration".hashCode());
/* 170 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 174 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 175 */     sb.append("id", this.id)
/* 176 */       .append("enName", this.enName)
/* 177 */       .append("displayRef", this.displayRef)
/* 178 */       .append("description", this.description)
/* 179 */       .append("enumerationType", this.enumerationType);
/*     */ 
/* 181 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 185 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.model.original.EnumerationAbstract
 * JD-Core Version:    0.6.0
 */