/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.Timezone;
/*    */ import org.hi.i18n.service.TimezoneManager;
/*    */ 
/*    */ public class TimezoneSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Timezone timezone;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/* 14 */     if (super.perExecute(this.timezone) != null) return returnCommand();
/* 15 */     timezoneMgr.saveTimezone(this.timezone);
/* 16 */     super.postExecute(this.timezone);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Timezone getTimezone() {
/* 21 */     return this.timezone;
/*    */   }
/*    */ 
/*    */   public void setTimezone(Timezone timezone) {
/* 25 */     this.timezone = timezone;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.TimezoneSaveAction
 * JD-Core Version:    0.6.0
 */