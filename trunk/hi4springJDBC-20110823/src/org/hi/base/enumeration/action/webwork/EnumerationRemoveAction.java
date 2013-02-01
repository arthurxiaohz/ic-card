/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.model.Enumeration;
/*    */ import org.hi.base.enumeration.service.EnumerationManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationRemoveAction extends BaseAction
/*    */ {
/*    */   private Enumeration enumeration;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/* 14 */     enumerationMgr.removeEnumerationById(this.enumeration.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Enumeration getEnumeration() {
/* 19 */     return this.enumeration;
/*    */   }
/*    */ 
/*    */   public void setEnumeration(Enumeration enumeration) {
/* 23 */     this.enumeration = enumeration;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationRemoveAction
 * JD-Core Version:    0.6.0
 */