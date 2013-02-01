/*     */ package org.hi.base.schedule.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.schedule.model.JobDetailDef;
/*     */ import org.hi.base.schedule.model.TriggerDef;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public abstract class TriggerDefAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String triggerName;
/*     */   protected String triggerGroup;
/*     */   protected JobDetailDef jobDetail;
/*     */   protected Integer volatiled;
/*     */   protected Timestamp nextFireTime;
/*     */   protected Timestamp prevFireTime;
/*     */   protected Integer priority;
/*     */   protected Integer triggerStats;
/*     */   protected Timestamp startTime;
/*     */   protected Timestamp endTime;
/*     */   protected Integer misfireInstr;
/*     */   protected String cronExpression;
/*     */   protected Integer enabled;
/*     */   protected Integer timeZone;
/*     */   protected String description;
/* 111 */   protected HiUser creator = UserContextHelper.getUser();
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 115 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/* 119 */     if (((id != null) && (this.id == null)) || (
/* 120 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/* 121 */       setDirty(true);
/* 122 */       this.oldValues.put("id", this.id);
/*     */     }
/* 124 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/* 128 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/* 132 */     if (((version != null) && (this.version == null)) || (
/* 133 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/* 134 */       setDirty(true);
/* 135 */       this.oldValues.put("version", this.version);
/*     */     }
/* 137 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getTriggerName() {
/* 141 */     return this.triggerName;
/*     */   }
/*     */ 
/*     */   public void setTriggerName(String triggerName) {
/* 145 */     if (((triggerName != null) && (this.triggerName == null)) || (
/* 146 */       (this.triggerName != null) && ((!this.triggerName.equals(triggerName)) || (triggerName == null)))) {
/* 147 */       setDirty(true);
/* 148 */       this.oldValues.put("triggerName", this.triggerName);
/*     */     }
/* 150 */     this.triggerName = triggerName;
/*     */   }
/*     */ 
/*     */   public String getTriggerGroup() {
/* 154 */     return this.triggerGroup;
/*     */   }
/*     */ 
/*     */   public void setTriggerGroup(String triggerGroup) {
/* 158 */     if (((triggerGroup != null) && (this.triggerGroup == null)) || (
/* 159 */       (this.triggerGroup != null) && ((!this.triggerGroup.equals(triggerGroup)) || (triggerGroup == null)))) {
/* 160 */       setDirty(true);
/* 161 */       this.oldValues.put("triggerGroup", this.triggerGroup);
/*     */     }
/* 163 */     this.triggerGroup = triggerGroup;
/*     */   }
/*     */ 
/*     */   public JobDetailDef getJobDetail() {
/* 167 */     return this.jobDetail;
/*     */   }
/*     */ 
/*     */   public void setJobDetail(JobDetailDef jobDetail) {
/* 171 */     if (((jobDetail != null) && (this.jobDetail == null)) || (
/* 172 */       (this.jobDetail != null) && ((!this.jobDetail.equals(jobDetail)) || (jobDetail == null)))) {
/* 173 */       setDirty(true);
/* 174 */       this.oldValues.put("jobDetail", this.jobDetail);
/*     */     }
/* 176 */     this.jobDetail = jobDetail;
/*     */   }
/*     */ 
/*     */   public Integer getVolatiled() {
/* 180 */     return this.volatiled;
/*     */   }
/*     */ 
/*     */   public void setVolatiled(Integer volatiled) {
/* 184 */     if (((volatiled != null) && (this.volatiled == null)) || (
/* 185 */       (this.volatiled != null) && ((!this.volatiled.equals(volatiled)) || (volatiled == null)))) {
/* 186 */       setDirty(true);
/* 187 */       this.oldValues.put("volatiled", this.volatiled);
/*     */     }
/* 189 */     this.volatiled = volatiled;
/*     */   }
/*     */ 
/*     */   public Timestamp getNextFireTime() {
/* 193 */     return this.nextFireTime;
/*     */   }
/*     */ 
/*     */   public void setNextFireTime(Timestamp nextFireTime) {
/* 197 */     if (((nextFireTime != null) && (this.nextFireTime == null)) || (
/* 198 */       (this.nextFireTime != null) && ((!this.nextFireTime.equals(nextFireTime)) || (nextFireTime == null)))) {
/* 199 */       setDirty(true);
/* 200 */       this.oldValues.put("nextFireTime", this.nextFireTime);
/*     */     }
/* 202 */     this.nextFireTime = nextFireTime;
/*     */   }
/*     */ 
/*     */   public Timestamp getPrevFireTime() {
/* 206 */     return this.prevFireTime;
/*     */   }
/*     */ 
/*     */   public void setPrevFireTime(Timestamp prevFireTime) {
/* 210 */     if (((prevFireTime != null) && (this.prevFireTime == null)) || (
/* 211 */       (this.prevFireTime != null) && ((!this.prevFireTime.equals(prevFireTime)) || (prevFireTime == null)))) {
/* 212 */       setDirty(true);
/* 213 */       this.oldValues.put("prevFireTime", this.prevFireTime);
/*     */     }
/* 215 */     this.prevFireTime = prevFireTime;
/*     */   }
/*     */ 
/*     */   public Integer getPriority() {
/* 219 */     return this.priority;
/*     */   }
/*     */ 
/*     */   public void setPriority(Integer priority) {
/* 223 */     if (((priority != null) && (this.priority == null)) || (
/* 224 */       (this.priority != null) && ((!this.priority.equals(priority)) || (priority == null)))) {
/* 225 */       setDirty(true);
/* 226 */       this.oldValues.put("priority", this.priority);
/*     */     }
/* 228 */     this.priority = priority;
/*     */   }
/*     */ 
/*     */   public Integer getTriggerStats() {
/* 232 */     return this.triggerStats;
/*     */   }
/*     */ 
/*     */   public void setTriggerStats(Integer triggerStats) {
/* 236 */     if (((triggerStats != null) && (this.triggerStats == null)) || (
/* 237 */       (this.triggerStats != null) && ((!this.triggerStats.equals(triggerStats)) || (triggerStats == null)))) {
/* 238 */       setDirty(true);
/* 239 */       this.oldValues.put("triggerStats", this.triggerStats);
/*     */     }
/* 241 */     this.triggerStats = triggerStats;
/*     */   }
/*     */ 
/*     */   public Timestamp getStartTime() {
/* 245 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(Timestamp startTime) {
/* 249 */     if (((startTime != null) && (this.startTime == null)) || (
/* 250 */       (this.startTime != null) && ((!this.startTime.equals(startTime)) || (startTime == null)))) {
/* 251 */       setDirty(true);
/* 252 */       this.oldValues.put("startTime", this.startTime);
/*     */     }
/* 254 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public Timestamp getEndTime() {
/* 258 */     return this.endTime;
/*     */   }
/*     */ 
/*     */   public void setEndTime(Timestamp endTime) {
/* 262 */     if (((endTime != null) && (this.endTime == null)) || (
/* 263 */       (this.endTime != null) && ((!this.endTime.equals(endTime)) || (endTime == null)))) {
/* 264 */       setDirty(true);
/* 265 */       this.oldValues.put("endTime", this.endTime);
/*     */     }
/* 267 */     this.endTime = endTime;
/*     */   }
/*     */ 
/*     */   public Integer getMisfireInstr() {
/* 271 */     return this.misfireInstr;
/*     */   }
/*     */ 
/*     */   public void setMisfireInstr(Integer misfireInstr) {
/* 275 */     if (((misfireInstr != null) && (this.misfireInstr == null)) || (
/* 276 */       (this.misfireInstr != null) && ((!this.misfireInstr.equals(misfireInstr)) || (misfireInstr == null)))) {
/* 277 */       setDirty(true);
/* 278 */       this.oldValues.put("misfireInstr", this.misfireInstr);
/*     */     }
/* 280 */     this.misfireInstr = misfireInstr;
/*     */   }
/*     */ 
/*     */   public String getCronExpression() {
/* 284 */     return this.cronExpression;
/*     */   }
/*     */ 
/*     */   public void setCronExpression(String cronExpression) {
/* 288 */     if (((cronExpression != null) && (this.cronExpression == null)) || (
/* 289 */       (this.cronExpression != null) && ((!this.cronExpression.equals(cronExpression)) || (cronExpression == null)))) {
/* 290 */       setDirty(true);
/* 291 */       this.oldValues.put("cronExpression", this.cronExpression);
/*     */     }
/* 293 */     this.cronExpression = cronExpression;
/*     */   }
/*     */ 
/*     */   public Integer getEnabled() {
/* 297 */     return this.enabled;
/*     */   }
/*     */ 
/*     */   public void setEnabled(Integer enabled) {
/* 301 */     if (((enabled != null) && (this.enabled == null)) || (
/* 302 */       (this.enabled != null) && ((!this.enabled.equals(enabled)) || (enabled == null)))) {
/* 303 */       setDirty(true);
/* 304 */       this.oldValues.put("enabled", this.enabled);
/*     */     }
/* 306 */     this.enabled = enabled;
/*     */   }
/*     */ 
/*     */   public Integer getTimeZone() {
/* 310 */     return this.timeZone;
/*     */   }
/*     */ 
/*     */   public void setTimeZone(Integer timeZone) {
/* 314 */     if (((timeZone != null) && (this.timeZone == null)) || (
/* 315 */       (this.timeZone != null) && ((!this.timeZone.equals(timeZone)) || (timeZone == null)))) {
/* 316 */       setDirty(true);
/* 317 */       this.oldValues.put("timeZone", this.timeZone);
/*     */     }
/* 319 */     this.timeZone = timeZone;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 323 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 327 */     if (((description != null) && (this.description == null)) || (
/* 328 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 329 */       setDirty(true);
/* 330 */       this.oldValues.put("description", this.description);
/*     */     }
/* 332 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 336 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 340 */     if (((creator != null) && (this.creator == null)) || (
/* 341 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 342 */       setDirty(true);
/* 343 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 345 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 351 */     if (this == other) return true;
/* 352 */     if (other == null) return false;
/* 353 */     if (!(other instanceof TriggerDef)) return false;
/* 354 */     TriggerDef castOther = (TriggerDef)other;
/*     */ 
/* 356 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 360 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 361 */     hcb.append(getId());
/* 362 */     hcb.append("TriggerDef".hashCode());
/* 363 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 367 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 368 */     sb.append("id", this.id)
/* 369 */       .append("triggerName", this.triggerName)
/* 370 */       .append("triggerGroup", this.triggerGroup)
/* 371 */       .append("priority", this.priority)
/* 372 */       .append("triggerStats", this.triggerStats)
/* 373 */       .append("misfireInstr", this.misfireInstr)
/* 374 */       .append("cronExpression", this.cronExpression)
/* 375 */       .append("timeZone", this.timeZone)
/* 376 */       .append("description", this.description);
/*     */ 
/* 378 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 382 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.model.original.TriggerDefAbstract
 * JD-Core Version:    0.6.0
 */