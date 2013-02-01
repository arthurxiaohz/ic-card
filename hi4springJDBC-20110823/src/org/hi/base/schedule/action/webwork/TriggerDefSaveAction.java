/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.model.TriggerDef;
/*    */ import org.hi.base.schedule.service.TriggerDefManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class TriggerDefSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private TriggerDef triggerDef;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.triggerDef) != null) return returnCommand();
/* 14 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/* 15 */     triggerDefMgr.saveTriggerDef(this.triggerDef);
/* 16 */     super.postExecute(this.triggerDef);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public TriggerDef getTriggerDef() {
/* 21 */     return this.triggerDef;
/*    */   }
/*    */ 
/*    */   public void setTriggerDef(TriggerDef triggerDef) {
/* 25 */     this.triggerDef = triggerDef;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.TriggerDefSaveAction
 * JD-Core Version:    0.6.0
 */