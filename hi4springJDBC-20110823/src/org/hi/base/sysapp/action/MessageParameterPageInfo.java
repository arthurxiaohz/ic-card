/*    */ package org.hi.base.sysapp.action;
/*    */ 
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class MessageParameterPageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected String f_parameterKey;
/*    */   protected String f_parameterKey_op;
/*    */   protected String f_parameterValue;
/*    */   protected String f_parameterValue_op;
/*    */   protected MessagePageInfo message;
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
/*    */   public String getF_parameterKey() {
/* 37 */     return this.f_parameterKey;
/*    */   }
/*    */ 
/*    */   public void setF_parameterKey(String f_parameterKey) {
/* 41 */     this.f_parameterKey = f_parameterKey;
/*    */   }
/*    */ 
/*    */   public String getF_parameterKey_op() {
/* 45 */     return this.f_parameterKey_op;
/*    */   }
/*    */ 
/*    */   public void setF_parameterKey_op(String f_parameterKey_op) {
/* 49 */     this.f_parameterKey_op = f_parameterKey_op;
/*    */   }
/*    */ 
/*    */   public String getF_parameterValue() {
/* 53 */     return this.f_parameterValue;
/*    */   }
/*    */ 
/*    */   public void setF_parameterValue(String f_parameterValue) {
/* 57 */     this.f_parameterValue = f_parameterValue;
/*    */   }
/*    */ 
/*    */   public String getF_parameterValue_op() {
/* 61 */     return this.f_parameterValue_op;
/*    */   }
/*    */ 
/*    */   public void setF_parameterValue_op(String f_parameterValue_op) {
/* 65 */     this.f_parameterValue_op = f_parameterValue_op;
/*    */   }
/*    */ 
/*    */   public MessagePageInfo getMessage() {
/* 69 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(MessagePageInfo message) {
/* 73 */     this.message = message;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.MessageParameterPageInfo
 * JD-Core Version:    0.6.0
 */