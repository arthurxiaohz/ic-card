/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.model.TriggerDef;
/*    */ import org.hi.base.schedule.service.TriggerDefManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class TriggerDefRemoveAction extends BaseAction
/*    */ {
/*    */   private TriggerDef triggerDef;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/* 14 */     triggerDefMgr.removeTriggerDefById(this.triggerDef.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public TriggerDef getTriggerDef() {
/* 19 */     return this.triggerDef;
/*    */   }
/*    */ 
/*    */   public void setTriggerDef(TriggerDef triggerDef) {
/* 23 */     this.triggerDef = triggerDef;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.TriggerDefRemoveAction
 * JD-Core Version:    0.6.0
 */