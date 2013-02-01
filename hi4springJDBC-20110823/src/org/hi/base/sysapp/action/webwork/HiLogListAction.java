/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.action.HiLogPageInfo;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.hi.base.sysapp.service.HiLogManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiLogListAction extends BaseAction
/*    */ {
/*    */   private HiLog hiLog;
/*    */   private HiLogPageInfo pageInfo;
/*    */   private List<HiLog> hiLogs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new HiLogPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.hiLogs = hiLogMgr.getSecurityHiLogList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiLog getHiLog() {
/* 30 */     return this.hiLog;
/*    */   }
/*    */ 
/*    */   public void setHiLog(HiLog hiLog) {
/* 34 */     this.hiLog = hiLog;
/*    */   }
/*    */ 
/*    */   public List<HiLog> getHiLogs() {
/* 38 */     return this.hiLogs;
/*    */   }
/*    */ 
/*    */   public void setHiLogs(List<HiLog> hiLogs) {
/* 42 */     this.hiLogs = hiLogs;
/*    */   }
/*    */ 
/*    */   public HiLogPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(HiLogPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.HiLogListAction
 * JD-Core Version:    0.6.0
 */