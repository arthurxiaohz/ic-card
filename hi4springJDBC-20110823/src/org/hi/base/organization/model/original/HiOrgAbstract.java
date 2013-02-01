/*     */ package org.hi.base.organization.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class HiOrgAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String orgName;
/*     */   protected String orgNum;
/*     */   protected HiUser manager;
/*     */   protected HiOrg parentOrg;
/*     */   protected String address;
/*     */   protected String description;
/*     */   protected HiUser creator;
/*  67 */   protected Integer deleted = Integer.valueOf(0);
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  75 */     if (((id != null) && (this.id == null)) || (
/*  76 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  77 */       setDirty(true);
/*  78 */       this.oldValues.put("id", this.id);
/*     */     }
/*  80 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  84 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  88 */     if (((version != null) && (this.version == null)) || (
/*  89 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  90 */       setDirty(true);
/*  91 */       this.oldValues.put("version", this.version);
/*     */     }
/*  93 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getOrgName() {
/*  97 */     return this.orgName;
/*     */   }
/*     */ 
/*     */   public void setOrgName(String orgName) {
/* 101 */     if (((orgName != null) && (this.orgName == null)) || (
/* 102 */       (this.orgName != null) && ((!this.orgName.equals(orgName)) || (orgName == null)))) {
/* 103 */       setDirty(true);
/* 104 */       this.oldValues.put("orgName", this.orgName);
/*     */     }
/* 106 */     this.orgName = orgName;
/*     */   }
/*     */ 
/*     */   public String getOrgNum() {
/* 110 */     return this.orgNum;
/*     */   }
/*     */ 
/*     */   public void setOrgNum(String orgNum) {
/* 114 */     if (((orgNum != null) && (this.orgNum == null)) || (
/* 115 */       (this.orgNum != null) && ((!this.orgNum.equals(orgNum)) || (orgNum == null)))) {
/* 116 */       setDirty(true);
/* 117 */       this.oldValues.put("orgNum", this.orgNum);
/*     */     }
/* 119 */     this.orgNum = orgNum;
/*     */   }
/*     */ 
/*     */   public HiUser getManager() {
/* 123 */     return this.manager;
/*     */   }
/*     */ 
/*     */   public void setManager(HiUser manager) {
/* 127 */     if (((manager != null) && (this.manager == null)) || (
/* 128 */       (this.manager != null) && ((!this.manager.equals(manager)) || (manager == null)))) {
/* 129 */       setDirty(true);
/* 130 */       this.oldValues.put("manager", this.manager);
/*     */     }
/* 132 */     this.manager = manager;
/*     */   }
/*     */ 
/*     */   public HiOrg getParentOrg() {
/* 136 */     return this.parentOrg;
/*     */   }
/*     */ 
/*     */   public void setParentOrg(HiOrg parentOrg) {
/* 140 */     if (((parentOrg != null) && (this.parentOrg == null)) || (
/* 141 */       (this.parentOrg != null) && ((!this.parentOrg.equals(parentOrg)) || (parentOrg == null)))) {
/* 142 */       setDirty(true);
/* 143 */       this.oldValues.put("parentOrg", this.parentOrg);
/*     */     }
/* 145 */     this.parentOrg = parentOrg;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 149 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 153 */     if (((address != null) && (this.address == null)) || (
/* 154 */       (this.address != null) && ((!this.address.equals(address)) || (address == null)))) {
/* 155 */       setDirty(true);
/* 156 */       this.oldValues.put("address", this.address);
/*     */     }
/* 158 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 162 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 166 */     if (((description != null) && (this.description == null)) || (
/* 167 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 168 */       setDirty(true);
/* 169 */       this.oldValues.put("description", this.description);
/*     */     }
/* 171 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 175 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 179 */     if (((creator != null) && (this.creator == null)) || (
/* 180 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 181 */       setDirty(true);
/* 182 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 184 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Integer getDeleted() {
/* 188 */     return this.deleted;
/*     */   }
/*     */ 
/*     */   public void setDeleted(Integer deleted) {
/* 192 */     if (((deleted != null) && (this.deleted == null)) || (
/* 193 */       (this.deleted != null) && ((!this.deleted.equals(deleted)) || (deleted == null)))) {
/* 194 */       setDirty(true);
/* 195 */       this.oldValues.put("deleted", this.deleted);
/*     */     }
/* 197 */     this.deleted = deleted;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 203 */     if (this == other) return true;
/* 204 */     if (other == null) return false;
/* 205 */     if (!(other instanceof HiOrg)) return false;
/* 206 */     HiOrg castOther = (HiOrg)other;
/*     */ 
/* 208 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 212 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 213 */     hcb.append(getId());
/* 214 */     hcb.append("HiOrg".hashCode());
/* 215 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 219 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 220 */     sb.append("id", this.id)
/* 221 */       .append("orgName", this.orgName)
/* 222 */       .append("orgNum", this.orgNum)
/* 223 */       .append("address", this.address)
/* 224 */       .append("description", this.description)
/* 225 */       .append("deleted", this.deleted);
/*     */ 
/* 227 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 231 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.model.original.HiOrgAbstract
 * JD-Core Version:    0.6.0
 */