/*     */ package org.hi.base.schedule.action;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import org.hi.base.organization.action.HiUserPageInfo;
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class TriggerDefPageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected String f_triggerName;
/*     */   protected String f_triggerName_op;
/*     */   protected String f_triggerGroup;
/*     */   protected String f_triggerGroup_op;
/*     */   protected Integer f_volatiled;
/*     */   protected String f_volatiled_op;
/*     */   protected Timestamp f_nextFireTime;
/*     */   protected String f_nextFireTime_op;
/*     */   protected Timestamp f_nextFireTime01;
/*     */   protected String f_nextFireTime01_op;
/*     */   protected Timestamp f_prevFireTime;
/*     */   protected String f_prevFireTime_op;
/*     */   protected Timestamp f_prevFireTime01;
/*     */   protected String f_prevFireTime01_op;
/*     */   protected Integer f_priority;
/*     */   protected String f_priority_op;
/*     */   protected Integer f_triggerStats;
/*     */   protected String f_triggerStats_op;
/*     */   protected Timestamp f_startTime;
/*     */   protected String f_startTime_op;
/*     */   protected Timestamp f_startTime01;
/*     */   protected String f_startTime01_op;
/*     */   protected Timestamp f_endTime;
/*     */   protected String f_endTime_op;
/*     */   protected Timestamp f_endTime01;
/*     */   protected String f_endTime01_op;
/*     */   protected Integer f_misfireInstr;
/*     */   protected String f_misfireInstr_op;
/*     */   protected String f_cronExpression;
/*     */   protected String f_cronExpression_op;
/*     */   protected Integer f_enabled;
/*     */   protected String f_enabled_op;
/*     */   protected Integer f_timeZone;
/*     */   protected String f_timeZone_op;
/*     */   protected String f_description;
/*     */   protected String f_description_op;
/*     */   protected JobDetailDefPageInfo jobDetail;
/*     */   protected HiUserPageInfo creator;
/*     */ 
/*     */   public Integer getF_id()
/*     */   {
/*  55 */     return this.f_id;
/*     */   }
/*     */ 
/*     */   public void setF_id(Integer f_id) {
/*  59 */     this.f_id = f_id;
/*     */   }
/*     */ 
/*     */   public String getF_id_op() {
/*  63 */     return this.f_id_op;
/*     */   }
/*     */ 
/*     */   public void setF_id_op(String f_id_op) {
/*  67 */     this.f_id_op = f_id_op;
/*     */   }
/*     */ 
/*     */   public String getF_triggerName() {
/*  71 */     return this.f_triggerName;
/*     */   }
/*     */ 
/*     */   public void setF_triggerName(String f_triggerName) {
/*  75 */     this.f_triggerName = f_triggerName;
/*     */   }
/*     */ 
/*     */   public String getF_triggerName_op() {
/*  79 */     return this.f_triggerName_op;
/*     */   }
/*     */ 
/*     */   public void setF_triggerName_op(String f_triggerName_op) {
/*  83 */     this.f_triggerName_op = f_triggerName_op;
/*     */   }
/*     */ 
/*     */   public String getF_triggerGroup() {
/*  87 */     return this.f_triggerGroup;
/*     */   }
/*     */ 
/*     */   public void setF_triggerGroup(String f_triggerGroup) {
/*  91 */     this.f_triggerGroup = f_triggerGroup;
/*     */   }
/*     */ 
/*     */   public String getF_triggerGroup_op() {
/*  95 */     return this.f_triggerGroup_op;
/*     */   }
/*     */ 
/*     */   public void setF_triggerGroup_op(String f_triggerGroup_op) {
/*  99 */     this.f_triggerGroup_op = f_triggerGroup_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_volatiled() {
/* 103 */     return this.f_volatiled;
/*     */   }
/*     */ 
/*     */   public void setF_volatiled(Integer f_volatiled) {
/* 107 */     this.f_volatiled = f_volatiled;
/*     */   }
/*     */ 
/*     */   public String getF_volatiled_op() {
/* 111 */     return this.f_volatiled_op;
/*     */   }
/*     */ 
/*     */   public void setF_volatiled_op(String f_volatiled_op) {
/* 115 */     this.f_volatiled_op = f_volatiled_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_nextFireTime() {
/* 119 */     return this.f_nextFireTime;
/*     */   }
/*     */ 
/*     */   public void setF_nextFireTime(Timestamp f_nextFireTime) {
/* 123 */     this.f_nextFireTime = f_nextFireTime;
/*     */   }
/*     */ 
/*     */   public String getF_nextFireTime_op() {
/* 127 */     return this.f_nextFireTime_op;
/*     */   }
/*     */ 
/*     */   public void setF_nextFireTime_op(String f_nextFireTime_op) {
/* 131 */     this.f_nextFireTime_op = f_nextFireTime_op;
/*     */   }
/*     */   public Timestamp getF_nextFireTime01() {
/* 134 */     return this.f_nextFireTime01;
/*     */   }
/*     */ 
/*     */   public void setF_nextFireTime01(Timestamp f_nextFireTime01) {
/* 138 */     this.f_nextFireTime01 = f_nextFireTime01;
/*     */   }
/*     */ 
/*     */   public String getF_nextFireTime01_op() {
/* 142 */     return this.f_nextFireTime01_op;
/*     */   }
/*     */ 
/*     */   public void setF_nextFireTime01_op(String f_nextFireTime01_op) {
/* 146 */     this.f_nextFireTime01_op = f_nextFireTime01_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_prevFireTime() {
/* 150 */     return this.f_prevFireTime;
/*     */   }
/*     */ 
/*     */   public void setF_prevFireTime(Timestamp f_prevFireTime) {
/* 154 */     this.f_prevFireTime = f_prevFireTime;
/*     */   }
/*     */ 
/*     */   public String getF_prevFireTime_op() {
/* 158 */     return this.f_prevFireTime_op;
/*     */   }
/*     */ 
/*     */   public void setF_prevFireTime_op(String f_prevFireTime_op) {
/* 162 */     this.f_prevFireTime_op = f_prevFireTime_op;
/*     */   }
/*     */   public Timestamp getF_prevFireTime01() {
/* 165 */     return this.f_prevFireTime01;
/*     */   }
/*     */ 
/*     */   public void setF_prevFireTime01(Timestamp f_prevFireTime01) {
/* 169 */     this.f_prevFireTime01 = f_prevFireTime01;
/*     */   }
/*     */ 
/*     */   public String getF_prevFireTime01_op() {
/* 173 */     return this.f_prevFireTime01_op;
/*     */   }
/*     */ 
/*     */   public void setF_prevFireTime01_op(String f_prevFireTime01_op) {
/* 177 */     this.f_prevFireTime01_op = f_prevFireTime01_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_priority() {
/* 181 */     return this.f_priority;
/*     */   }
/*     */ 
/*     */   public void setF_priority(Integer f_priority) {
/* 185 */     this.f_priority = f_priority;
/*     */   }
/*     */ 
/*     */   public String getF_priority_op() {
/* 189 */     return this.f_priority_op;
/*     */   }
/*     */ 
/*     */   public void setF_priority_op(String f_priority_op) {
/* 193 */     this.f_priority_op = f_priority_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_triggerStats() {
/* 197 */     return this.f_triggerStats;
/*     */   }
/*     */ 
/*     */   public void setF_triggerStats(Integer f_triggerStats) {
/* 201 */     this.f_triggerStats = f_triggerStats;
/*     */   }
/*     */ 
/*     */   public String getF_triggerStats_op() {
/* 205 */     return this.f_triggerStats_op;
/*     */   }
/*     */ 
/*     */   public void setF_triggerStats_op(String f_triggerStats_op) {
/* 209 */     this.f_triggerStats_op = f_triggerStats_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_startTime() {
/* 213 */     return this.f_startTime;
/*     */   }
/*     */ 
/*     */   public void setF_startTime(Timestamp f_startTime) {
/* 217 */     this.f_startTime = f_startTime;
/*     */   }
/*     */ 
/*     */   public String getF_startTime_op() {
/* 221 */     return this.f_startTime_op;
/*     */   }
/*     */ 
/*     */   public void setF_startTime_op(String f_startTime_op) {
/* 225 */     this.f_startTime_op = f_startTime_op;
/*     */   }
/*     */   public Timestamp getF_startTime01() {
/* 228 */     return this.f_startTime01;
/*     */   }
/*     */ 
/*     */   public void setF_startTime01(Timestamp f_startTime01) {
/* 232 */     this.f_startTime01 = f_startTime01;
/*     */   }
/*     */ 
/*     */   public String getF_startTime01_op() {
/* 236 */     return this.f_startTime01_op;
/*     */   }
/*     */ 
/*     */   public void setF_startTime01_op(String f_startTime01_op) {
/* 240 */     this.f_startTime01_op = f_startTime01_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_endTime() {
/* 244 */     return this.f_endTime;
/*     */   }
/*     */ 
/*     */   public void setF_endTime(Timestamp f_endTime) {
/* 248 */     this.f_endTime = f_endTime;
/*     */   }
/*     */ 
/*     */   public String getF_endTime_op() {
/* 252 */     return this.f_endTime_op;
/*     */   }
/*     */ 
/*     */   public void setF_endTime_op(String f_endTime_op) {
/* 256 */     this.f_endTime_op = f_endTime_op;
/*     */   }
/*     */   public Timestamp getF_endTime01() {
/* 259 */     return this.f_endTime01;
/*     */   }
/*     */ 
/*     */   public void setF_endTime01(Timestamp f_endTime01) {
/* 263 */     this.f_endTime01 = f_endTime01;
/*     */   }
/*     */ 
/*     */   public String getF_endTime01_op() {
/* 267 */     return this.f_endTime01_op;
/*     */   }
/*     */ 
/*     */   public void setF_endTime01_op(String f_endTime01_op) {
/* 271 */     this.f_endTime01_op = f_endTime01_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_misfireInstr() {
/* 275 */     return this.f_misfireInstr;
/*     */   }
/*     */ 
/*     */   public void setF_misfireInstr(Integer f_misfireInstr) {
/* 279 */     this.f_misfireInstr = f_misfireInstr;
/*     */   }
/*     */ 
/*     */   public String getF_misfireInstr_op() {
/* 283 */     return this.f_misfireInstr_op;
/*     */   }
/*     */ 
/*     */   public void setF_misfireInstr_op(String f_misfireInstr_op) {
/* 287 */     this.f_misfireInstr_op = f_misfireInstr_op;
/*     */   }
/*     */ 
/*     */   public String getF_cronExpression() {
/* 291 */     return this.f_cronExpression;
/*     */   }
/*     */ 
/*     */   public void setF_cronExpression(String f_cronExpression) {
/* 295 */     this.f_cronExpression = f_cronExpression;
/*     */   }
/*     */ 
/*     */   public String getF_cronExpression_op() {
/* 299 */     return this.f_cronExpression_op;
/*     */   }
/*     */ 
/*     */   public void setF_cronExpression_op(String f_cronExpression_op) {
/* 303 */     this.f_cronExpression_op = f_cronExpression_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_enabled() {
/* 307 */     return this.f_enabled;
/*     */   }
/*     */ 
/*     */   public void setF_enabled(Integer f_enabled) {
/* 311 */     this.f_enabled = f_enabled;
/*     */   }
/*     */ 
/*     */   public String getF_enabled_op() {
/* 315 */     return this.f_enabled_op;
/*     */   }
/*     */ 
/*     */   public void setF_enabled_op(String f_enabled_op) {
/* 319 */     this.f_enabled_op = f_enabled_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_timeZone() {
/* 323 */     return this.f_timeZone;
/*     */   }
/*     */ 
/*     */   public void setF_timeZone(Integer f_timeZone) {
/* 327 */     this.f_timeZone = f_timeZone;
/*     */   }
/*     */ 
/*     */   public String getF_timeZone_op() {
/* 331 */     return this.f_timeZone_op;
/*     */   }
/*     */ 
/*     */   public void setF_timeZone_op(String f_timeZone_op) {
/* 335 */     this.f_timeZone_op = f_timeZone_op;
/*     */   }
/*     */ 
/*     */   public String getF_description() {
/* 339 */     return this.f_description;
/*     */   }
/*     */ 
/*     */   public void setF_description(String f_description) {
/* 343 */     this.f_description = f_description;
/*     */   }
/*     */ 
/*     */   public String getF_description_op() {
/* 347 */     return this.f_description_op;
/*     */   }
/*     */ 
/*     */   public void setF_description_op(String f_description_op) {
/* 351 */     this.f_description_op = f_description_op;
/*     */   }
/*     */ 
/*     */   public JobDetailDefPageInfo getJobDetail() {
/* 355 */     return this.jobDetail;
/*     */   }
/*     */ 
/*     */   public void setJobDetail(JobDetailDefPageInfo jobDetail) {
/* 359 */     this.jobDetail = jobDetail;
/*     */   }
/*     */   public HiUserPageInfo getCreator() {
/* 362 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUserPageInfo creator) {
/* 366 */     this.creator = creator;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.schedule.action.TriggerDefPageInfo
 * JD-Core Version:    0.6.0
 */