/*    */ package org.hi.i18n.action;
/*    */ 
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class LanguageStrPageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected String f_languageCode;
/*    */   protected String f_languageCode_op;
/*    */   protected String f_value;
/*    */   protected String f_value_op;
/*    */   protected LanguagePageInfo language;
/*    */   protected HiUserPageInfo creator;
/*    */ 
/*    */   public Integer getF_id()
/*    */   {
/* 23 */     return this.f_id;
/*    */   }
/*    */ 
/*    */   public void setF_id(Integer f_id) {
/* 27 */     this.f_id = f_id;
/*    */   }
/*    */ 
/*    */   public String getF_id_op() {
/* 31 */     return this.f_id_op;
/*    */   }
/*    */ 
/*    */   public void setF_id_op(String f_id_op) {
/* 35 */     this.f_id_op = f_id_op;
/*    */   }
/*    */ 
/*    */   public String getF_languageCode() {
/* 39 */     return this.f_languageCode;
/*    */   }
/*    */ 
/*    */   public void setF_languageCode(String f_languageCode) {
/* 43 */     this.f_languageCode = f_languageCode;
/*    */   }
/*    */ 
/*    */   public String getF_languageCode_op() {
/* 47 */     return this.f_languageCode_op;
/*    */   }
/*    */ 
/*    */   public void setF_languageCode_op(String f_languageCode_op) {
/* 51 */     this.f_languageCode_op = f_languageCode_op;
/*    */   }
/*    */ 
/*    */   public String getF_value() {
/* 55 */     return this.f_value;
/*    */   }
/*    */ 
/*    */   public void setF_value(String f_value) {
/* 59 */     this.f_value = f_value;
/*    */   }
/*    */ 
/*    */   public String getF_value_op() {
/* 63 */     return this.f_value_op;
/*    */   }
/*    */ 
/*    */   public void setF_value_op(String f_value_op) {
/* 67 */     this.f_value_op = f_value_op;
/*    */   }
/*    */ 
/*    */   public LanguagePageInfo getLanguage() {
/* 71 */     return this.language;
/*    */   }
/*    */ 
/*    */   public void setLanguage(LanguagePageInfo language) {
/* 75 */     this.language = language;
/*    */   }
/*    */   public HiUserPageInfo getCreator() {
/* 78 */     return this.creator;
/*    */   }
/*    */ 
/*    */   public void setCreator(HiUserPageInfo creator) {
/* 82 */     this.creator = creator;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.LanguageStrPageInfo
 * JD-Core Version:    0.6.0
 */