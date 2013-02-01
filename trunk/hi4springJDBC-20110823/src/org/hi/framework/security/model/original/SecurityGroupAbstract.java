/*     */ package org.hi.framework.security.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.model.SecurityGroup;
/*     */ 
/*     */ public abstract class SecurityGroupAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String groupName;
/*     */   protected String displayRef;
/*     */   protected String description;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  45 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  49 */     if (((id != null) && (this.id == null)) || (
/*  50 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  51 */       setDirty(true);
/*  52 */       this.oldValues.put("id", this.id);
/*     */     }
/*  54 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  58 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  62 */     if (((version != null) && (this.version == null)) || (
/*  63 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  64 */       setDirty(true);
/*  65 */       this.oldValues.put("version", this.version);
/*     */     }
/*  67 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getGroupName() {
/*  71 */     return this.groupName;
/*     */   }
/*     */ 
/*     */   public void setGroupName(String groupName) {
/*  75 */     if (((groupName != null) && (this.groupName == null)) || (
/*  76 */       (this.groupName != null) && ((!this.groupName.equals(groupName)) || (groupName == null)))) {
/*  77 */       setDirty(true);
/*  78 */       this.oldValues.put("groupName", this.groupName);
/*     */     }
/*  80 */     this.groupName = groupName;
/*     */   }
/*     */ 
/*     */   public String getDisplayRef() {
/*  84 */     return this.displayRef;
/*     */   }
/*     */ 
/*     */   public void setDisplayRef(String displayRef) {
/*  88 */     if (((displayRef != null) && (this.displayRef == null)) || (
/*  89 */       (this.displayRef != null) && ((!this.displayRef.equals(displayRef)) || (displayRef == null)))) {
/*  90 */       setDirty(true);
/*  91 */       this.oldValues.put("displayRef", this.displayRef);
/*     */     }
/*  93 */     this.displayRef = displayRef;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  97 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 101 */     if (((description != null) && (this.description == null)) || (
/* 102 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 103 */       setDirty(true);
/* 104 */       this.oldValues.put("description", this.description);
/*     */     }
/* 106 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 112 */     if (this == other) return true;
/* 113 */     if (other == null) return false;
/* 114 */     if (!(other instanceof SecurityGroup)) return false;
/* 115 */     SecurityGroup castOther = (SecurityGroup)other;
/*     */ 
/* 117 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 121 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 122 */     hcb.append(getId());
/* 123 */     hcb.append("SecurityGroup".hashCode());
/* 124 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 128 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 129 */     sb.append("id", this.id)
/* 130 */       .append("groupName", this.groupName)
/* 131 */       .append("displayRef", this.displayRef)
/* 132 */       .append("description", this.description);
/*     */ 
/* 134 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 138 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.original.SecurityGroupAbstract
 * JD-Core Version:    0.6.0
 */