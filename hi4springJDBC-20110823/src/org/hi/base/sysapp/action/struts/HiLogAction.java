/*     */ package org.hi.base.sysapp.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.sysapp.action.HiLogPageInfo;
/*     */ import org.hi.base.sysapp.model.HiLog;
/*     */ import org.hi.base.sysapp.service.HiLogManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class HiLogAction extends BaseAction
/*     */ {
/*     */   private HiLog hiLog;
/*     */   private HiLogPageInfo pageInfo;
/*     */   private List<HiLog> hiLogs;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveHiLog()
/*     */     throws Exception
/*     */   {
/*  25 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/*  26 */     if (super.perExecute(this.hiLog) != null) return returnCommand();
/*  27 */     hiLogMgr.saveHiLog(this.hiLog);
/*  28 */     super.postExecute(this.hiLog);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeHiLog()
/*     */     throws Exception
/*     */   {
/*  37 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/*  38 */     hiLogMgr.removeHiLogById(this.hiLog.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllHiLog()
/*     */     throws Exception
/*     */   {
/*  46 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer hiLogid = new Integer(ids[i]);
/*  55 */         hiLogMgr.removeHiLogById(hiLogid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewHiLog()
/*     */     throws Exception
/*     */   {
/*  67 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/*  68 */     this.hiLog = hiLogMgr.getHiLogById(this.hiLog.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String hiLogList()
/*     */     throws Exception
/*     */   {
/*  76 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new HiLogPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.hiLogs = hiLogMgr.getSecurityHiLogList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public HiLog getHiLog()
/*     */   {
/*  89 */     return this.hiLog;
/*     */   }
/*     */ 
/*     */   public void setHiLog(HiLog hiLog) {
/*  93 */     this.hiLog = hiLog;
/*     */   }
/*     */ 
/*     */   public List<HiLog> getHiLogs() {
/*  97 */     return this.hiLogs;
/*     */   }
/*     */ 
/*     */   public void setHiLogs(List<HiLog> hiLogs) {
/* 101 */     this.hiLogs = hiLogs;
/*     */   }
/*     */ 
/*     */   public HiLogPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(HiLogPageInfo pageInfo) {
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
 * Qualified Name:     org.hi.base.sysapp.action.struts.HiLogAction
 * JD-Core Version:    0.6.0
 */