/*    */ package org.hi.framework.security.action;
/*    */ 
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class RolePageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected String f_roleName;
/*    */   protected String f_roleName_op;
/*    */   protected String f_displayRef;
/*    */   protected String f_displayRef_op;
/*    */   protected String f_description;
/*    */   protected String f_description_op;
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
/*    */   public String getF_roleName() {
/* 39 */     return this.f_roleName;
/*    */   }
/*    */ 
/*    */   public void setF_roleName(String f_roleName) {
/* 43 */     this.f_roleName = f_roleName;
/*    */   }
/*    */ 
/*    */   public String getF_roleName_op() {
/* 47 */     return this.f_roleName_op;
/*    */   }
/*    */ 
/*    */   public void setF_roleName_op(String f_roleName_op) {
/* 51 */     this.f_roleName_op = f_roleName_op;
/*    */   }
/*    */ 
/*    */   public String getF_displayRef() {
/* 55 */     return this.f_displayRef;
/*    */   }
/*    */ 
/*    */   public void setF_displayRef(String f_displayRef) {
/* 59 */     this.f_displayRef = f_displayRef;
/*    */   }
/*    */ 
/*    */   public String getF_displayRef_op() {
/* 63 */     return this.f_displayRef_op;
/*    */   }
/*    */ 
/*    */   public void setF_displayRef_op(String f_displayRef_op) {
/* 67 */     this.f_displayRef_op = f_displayRef_op;
/*    */   }
/*    */ 
/*    */   public String getF_description() {
/* 71 */     return this.f_description;
/*    */   }
/*    */ 
/*    */   public void setF_description(String f_description) {
/* 75 */     this.f_description = f_description;
/*    */   }
/*    */ 
/*    */   public String getF_description_op() {
/* 79 */     return this.f_description_op;
/*    */   }
/*    */ 
/*    */   public void setF_description_op(String f_description_op) {
/* 83 */     this.f_description_op = f_description_op;
/*    */   }
/*    */ 
/*    */   public HiUserPageInfo getCreator() {
/* 87 */     return this.creator;
/*    */   }
/*    */ 
/*    */   public void setCreator(HiUserPageInfo creator) {
/* 91 */     this.creator = creator;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.RolePageInfo
 * JD-Core Version:    0.6.0
 */