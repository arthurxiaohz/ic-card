/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.model.Enumeration;
/*    */ import org.hi.base.enumeration.service.EnumerationManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Enumeration enumeration;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.enumeration) != null) return returnCommand();
/* 14 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/* 15 */     enumerationMgr.saveEnumeration(this.enumeration);
/* 16 */     super.postExecute(this.enumeration);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Enumeration getEnumeration() {
/* 21 */     return this.enumeration;
/*    */   }
/*    */ 
/*    */   public void setEnumeration(Enumeration enumeration) {
/* 25 */     this.enumeration = enumeration;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationSaveAction
 * JD-Core Version:    0.6.0
 */