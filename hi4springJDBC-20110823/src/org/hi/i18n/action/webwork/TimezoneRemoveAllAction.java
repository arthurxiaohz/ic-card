/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.Timezone;
/*    */ import org.hi.i18n.service.TimezoneManager;
/*    */ 
/*    */ public class TimezoneRemoveAllAction extends BaseAction
/*    */ {
/*    */   private Timezone timezone;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer timezoneid = new Integer(ids[i]);
/* 24 */         timezoneMgr.removeTimezoneById(timezoneid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Timezone getTimezone() {
/* 33 */     return this.timezone;
/*    */   }
/*    */ 
/*    */   public void setTimezone(Timezone timezone) {
/* 37 */     this.timezone = timezone;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.TimezoneRemoveAllAction
 * JD-Core Version:    0.6.0
 */