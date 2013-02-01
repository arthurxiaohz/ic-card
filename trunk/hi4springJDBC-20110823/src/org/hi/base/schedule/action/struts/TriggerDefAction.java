/*     */ package org.hi.base.schedule.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.schedule.action.TriggerDefPageInfo;
/*     */ import org.hi.base.schedule.model.TriggerDef;
/*     */ import org.hi.base.schedule.service.TriggerDefManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class TriggerDefAction extends BaseAction
/*     */ {
/*     */   private TriggerDef triggerDef;
/*     */   private TriggerDefPageInfo pageInfo;
/*     */   private List<TriggerDef> triggerDefs;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveTriggerDef()
/*     */     throws Exception
/*     */   {
/*  25 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/*  26 */     if (super.perExecute(this.triggerDef) != null) return returnCommand();
/*  27 */     triggerDefMgr.saveTriggerDef(this.triggerDef);
/*  28 */     super.postExecute(this.triggerDef);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeTriggerDef()
/*     */     throws Exception
/*     */   {
/*  37 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/*  38 */     triggerDefMgr.removeTriggerDefById(this.triggerDef.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllTriggerDef()
/*     */     throws Exception
/*     */   {
/*  46 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer triggerDefid = new Integer(ids[i]);
/*  55 */         triggerDefMgr.removeTriggerDefById(triggerDefid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewTriggerDef()
/*     */     throws Exception
/*     */   {
/*  67 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/*  68 */     this.triggerDef = triggerDefMgr.getTriggerDefById(this.triggerDef.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String triggerDefList()
/*     */     throws Exception
/*     */   {
/*  76 */     TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new TriggerDefPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.triggerDefs = triggerDefMgr.getSecurityTriggerDefList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public TriggerDef getTriggerDef()
/*     */   {
/*  89 */     return this.triggerDef;
/*     */   }
/*     */ 
/*     */   public void setTriggerDef(TriggerDef triggerDef) {
/*  93 */     this.triggerDef = triggerDef;
/*     */   }
/*     */ 
/*     */   public List<TriggerDef> getTriggerDefs() {
/*  97 */     return this.triggerDefs;
/*     */   }
/*     */ 
/*     */   public void setTriggerDefs(List<TriggerDef> triggerDefs) {
/* 101 */     this.triggerDefs = triggerDefs;
/*     */   }
/*     */ 
/*     */   public TriggerDefPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(TriggerDefPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.struts.TriggerDefAction
 * JD-Core Version:    0.6.0
 */