/*    */ package org.hi.i18n.action;
/*    */ 
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class TimezonePageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected Integer f_timezone;
/*    */   protected String f_timezone_op;
/*    */   protected String f_description;
/*    */   protected String f_description_op;
/*    */   protected HiUserPageInfo creator;
/*    */ 
/*    */   public Integer getF_id()
/*    */   {
/* 21 */     return this.f_id;
/*    */   }
/*    */ 
/*    */   public void setF_id(Integer f_id) {
/* 25 */     this.f_id = f_id;
/*    */   }
/*    */ 
/*    */   public String getF_id_op() {
/* 29 */     return this.f_id_op;
/*    */   }
/*    */ 
/*    */   public void setF_id_op(String f_id_op) {
/* 33 */     this.f_id_op = f_id_op;
/*    */   }
/*    */ 
/*    */   public Integer getF_timezone() {
/* 37 */     return this.f_timezone;
/*    */   }
/*    */ 
/*    */   public void setF_timezone(Integer f_timezone) {
/* 41 */     this.f_timezone = f_timezone;
/*    */   }
/*    */ 
/*    */   public String getF_timezone_op() {
/* 45 */     return this.f_timezone_op;
/*    */   }
/*    */ 
/*    */   public void setF_timezone_op(String f_timezone_op) {
/* 49 */     this.f_timezone_op = f_timezone_op;
/*    */   }
/*    */ 
/*    */   public String getF_description() {
/* 53 */     return this.f_description;
/*    */   }
/*    */ 
/*    */   public void setF_description(String f_description) {
/* 57 */     this.f_description = f_description;
/*    */   }
/*    */ 
/*    */   public String getF_description_op() {
/* 61 */     return this.f_description_op;
/*    */   }
/*    */ 
/*    */   public void setF_description_op(String f_description_op) {
/* 65 */     this.f_description_op = f_description_op;
/*    */   }
/*    */ 
/*    */   public HiUserPageInfo getCreator() {
/* 69 */     return this.creator;
/*    */   }
/*    */ 
/*    */   public void setCreator(HiUserPageInfo creator) {
/* 73 */     this.creator = creator;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.TimezonePageInfo
 * JD-Core Version:    0.6.0
 */