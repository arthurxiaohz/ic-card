/*     */ package org.hi.base.sysapp.action;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import org.hi.base.organization.action.HiUserPageInfo;
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class HiLogPageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected Timestamp f_operateDate;
/*     */   protected String f_operateDate_op;
/*     */   protected Timestamp f_operateDate01;
/*     */   protected String f_operateDate01_op;
/*     */   protected String f_action;
/*     */   protected String f_action_op;
/*     */   protected String f_actionContext;
/*     */   protected String f_actionContext_op;
/*     */   protected HiUserPageInfo operator;
/*     */ 
/*     */   public Integer getF_id()
/*     */   {
/*  25 */     return this.f_id;
/*     */   }
/*     */ 
/*     */   public void setF_id(Integer f_id) {
/*  29 */     this.f_id = f_id;
/*     */   }
/*     */ 
/*     */   public String getF_id_op() {
/*  33 */     return this.f_id_op;
/*     */   }
/*     */ 
/*     */   public void setF_id_op(String f_id_op) {
/*  37 */     this.f_id_op = f_id_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_operateDate() {
/*  41 */     return this.f_operateDate;
/*     */   }
/*     */ 
/*     */   public void setF_operateDate(Timestamp f_operateDate) {
/*  45 */     this.f_operateDate = f_operateDate;
/*     */   }
/*     */ 
/*     */   public String getF_operateDate_op() {
/*  49 */     return this.f_operateDate_op;
/*     */   }
/*     */ 
/*     */   public void setF_operateDate_op(String f_operateDate_op) {
/*  53 */     this.f_operateDate_op = f_operateDate_op;
/*     */   }
/*     */   public Timestamp getF_operateDate01() {
/*  56 */     return this.f_operateDate01;
/*     */   }
/*     */ 
/*     */   public void setF_operateDate01(Timestamp f_operateDate01) {
/*  60 */     this.f_operateDate01 = f_operateDate01;
/*     */   }
/*     */ 
/*     */   public String getF_operateDate01_op() {
/*  64 */     return this.f_operateDate01_op;
/*     */   }
/*     */ 
/*     */   public void setF_operateDate01_op(String f_operateDate01_op) {
/*  68 */     this.f_operateDate01_op = f_operateDate01_op;
/*     */   }
/*     */ 
/*     */   public String getF_action() {
/*  72 */     return this.f_action;
/*     */   }
/*     */ 
/*     */   public void setF_action(String f_action) {
/*  76 */     this.f_action = f_action;
/*     */   }
/*     */ 
/*     */   public String getF_action_op() {
/*  80 */     return this.f_action_op;
/*     */   }
/*     */ 
/*     */   public void setF_action_op(String f_action_op) {
/*  84 */     this.f_action_op = f_action_op;
/*     */   }
/*     */ 
/*     */   public String getF_actionContext() {
/*  88 */     return this.f_actionContext;
/*     */   }
/*     */ 
/*     */   public void setF_actionContext(String f_actionContext) {
/*  92 */     this.f_actionContext = f_actionContext;
/*     */   }
/*     */ 
/*     */   public String getF_actionContext_op() {
/*  96 */     return this.f_actionContext_op;
/*     */   }
/*     */ 
/*     */   public void setF_actionContext_op(String f_actionContext_op) {
/* 100 */     this.f_actionContext_op = f_actionContext_op;
/*     */   }
/*     */ 
/*     */   public HiUserPageInfo getOperator() {
/* 104 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(HiUserPageInfo operator) {
/* 108 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.HiLogPageInfo
 * JD-Core Version:    0.6.0
 */