/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.action.TriggerDefPageInfo;
/*    */ import org.hi.base.schedule.model.TriggerDef;
/*    */ import org.hi.base.schedule.service.TriggerDefManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class TriggerDefListAction extends BaseAction
/*    */ {
/*    */   private TriggerDef triggerDef;
/*    */   private TriggerDefPageInfo pageInfo;
/*    */   private List<TriggerDef> triggerDefs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new TriggerDefPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.triggerDefs = triggerDefMgr.getTriggerDefList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public TriggerDef getTriggerDef() {
/* 30 */     return this.triggerDef;
/*    */   }
/*    */ 
/*    */   public void setTriggerDef(TriggerDef triggerDef) {
/* 34 */     this.triggerDef = triggerDef;
/*    */   }
/*    */ 
/*    */   public List<TriggerDef> getTriggerDefs() {
/* 38 */     return this.triggerDefs;
/*    */   }
/*    */ 
/*    */   public void setTriggerDefs(List<TriggerDef> triggerDefs) {
/* 42 */     this.triggerDefs = triggerDefs;
/*    */   }
/*    */ 
/*    */   public TriggerDefPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(TriggerDefPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.TriggerDefListAction
 * JD-Core Version:    0.6.0
 */