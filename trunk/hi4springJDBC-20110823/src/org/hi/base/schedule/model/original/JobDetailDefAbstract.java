/*     */ package org.hi.base.schedule.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.schedule.model.JobDetailDef;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public abstract class JobDetailDefAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String jobName;
/*     */   protected String jobGroup;
/*     */   protected String jobClassName;
/*     */   protected Integer durable;
/*     */   protected Integer volatiled;
/*     */   protected Integer shouldRecover;
/*     */   protected String description;
/*  71 */   protected HiUser creator = UserContextHelper.getUser();
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  79 */     if (((id != null) && (this.id == null)) || (
/*  80 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  81 */       setDirty(true);
/*  82 */       this.oldValues.put("id", this.id);
/*     */     }
/*  84 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  88 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  92 */     if (((version != null) && (this.version == null)) || (
/*  93 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  94 */       setDirty(true);
/*  95 */       this.oldValues.put("version", this.version);
/*     */     }
/*  97 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getJobName() {
/* 101 */     return this.jobName;
/*     */   }
/*     */ 
/*     */   public void setJobName(String jobName) {
/* 105 */     if (((jobName != null) && (this.jobName == null)) || (
/* 106 */       (this.jobName != null) && ((!this.jobName.equals(jobName)) || (jobName == null)))) {
/* 107 */       setDirty(true);
/* 108 */       this.oldValues.put("jobName", this.jobName);
/*     */     }
/* 110 */     this.jobName = jobName;
/*     */   }
/*     */ 
/*     */   public String getJobGroup() {
/* 114 */     return this.jobGroup;
/*     */   }
/*     */ 
/*     */   public void setJobGroup(String jobGroup) {
/* 118 */     if (((jobGroup != null) && (this.jobGroup == null)) || (
/* 119 */       (this.jobGroup != null) && ((!this.jobGroup.equals(jobGroup)) || (jobGroup == null)))) {
/* 120 */       setDirty(true);
/* 121 */       this.oldValues.put("jobGroup", this.jobGroup);
/*     */     }
/* 123 */     this.jobGroup = jobGroup;
/*     */   }
/*     */ 
/*     */   public String getJobClassName() {
/* 127 */     return this.jobClassName;
/*     */   }
/*     */ 
/*     */   public void setJobClassName(String jobClassName) {
/* 131 */     if (((jobClassName != null) && (this.jobClassName == null)) || (
/* 132 */       (this.jobClassName != null) && ((!this.jobClassName.equals(jobClassName)) || (jobClassName == null)))) {
/* 133 */       setDirty(true);
/* 134 */       this.oldValues.put("jobClassName", this.jobClassName);
/*     */     }
/* 136 */     this.jobClassName = jobClassName;
/*     */   }
/*     */ 
/*     */   public Integer getDurable() {
/* 140 */     return this.durable;
/*     */   }
/*     */ 
/*     */   public void setDurable(Integer durable) {
/* 144 */     if (((durable != null) && (this.durable == null)) || (
/* 145 */       (this.durable != null) && ((!this.durable.equals(durable)) || (durable == null)))) {
/* 146 */       setDirty(true);
/* 147 */       this.oldValues.put("durable", this.durable);
/*     */     }
/* 149 */     this.durable = durable;
/*     */   }
/*     */ 
/*     */   public Integer getVolatiled() {
/* 153 */     return this.volatiled;
/*     */   }
/*     */ 
/*     */   public void setVolatiled(Integer volatiled) {
/* 157 */     if (((volatiled != null) && (this.volatiled == null)) || (
/* 158 */       (this.volatiled != null) && ((!this.volatiled.equals(volatiled)) || (volatiled == null)))) {
/* 159 */       setDirty(true);
/* 160 */       this.oldValues.put("volatiled", this.volatiled);
/*     */     }
/* 162 */     this.volatiled = volatiled;
/*     */   }
/*     */ 
/*     */   public Integer getShouldRecover() {
/* 166 */     return this.shouldRecover;
/*     */   }
/*     */ 
/*     */   public void setShouldRecover(Integer shouldRecover) {
/* 170 */     if (((shouldRecover != null) && (this.shouldRecover == null)) || (
/* 171 */       (this.shouldRecover != null) && ((!this.shouldRecover.equals(shouldRecover)) || (shouldRecover == null)))) {
/* 172 */       setDirty(true);
/* 173 */       this.oldValues.put("shouldRecover", this.shouldRecover);
/*     */     }
/* 175 */     this.shouldRecover = shouldRecover;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 179 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 183 */     if (((description != null) && (this.description == null)) || (
/* 184 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 185 */       setDirty(true);
/* 186 */       this.oldValues.put("description", this.description);
/*     */     }
/* 188 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 192 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 196 */     if (((creator != null) && (this.creator == null)) || (
/* 197 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 198 */       setDirty(true);
/* 199 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 201 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 207 */     if (this == other) return true;
/* 208 */     if (other == null) return false;
/* 209 */     if (!(other instanceof JobDetailDef)) return false;
/* 210 */     JobDetailDef castOther = (JobDetailDef)other;
/*     */ 
/* 212 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 216 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 217 */     hcb.append(getId());
/* 218 */     hcb.append("JobDetailDef".hashCode());
/* 219 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 223 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 224 */     sb.append("id", this.id)
/* 225 */       .append("jobName", this.jobName)
/* 226 */       .append("jobGroup", this.jobGroup)
/* 227 */       .append("jobClassName", this.jobClassName)
/* 228 */       .append("description", this.description);
/*     */ 
/* 230 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 234 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.model.original.JobDetailDefAbstract
 * JD-Core Version:    0.6.0
 */