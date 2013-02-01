/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.action.JobDetailDefPageInfo;
/*    */ import org.hi.base.schedule.model.JobDetailDef;
/*    */ import org.hi.base.schedule.service.JobDetailDefManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class JobDetailDefListAction extends BaseAction
/*    */ {
/*    */   private JobDetailDef jobDetailDef;
/*    */   private JobDetailDefPageInfo pageInfo;
/*    */   private List<JobDetailDef> jobDetailDefs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new JobDetailDefPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.jobDetailDefs = jobDetailDefMgr.getJobDetailDefList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public JobDetailDef getJobDetailDef() {
/* 30 */     return this.jobDetailDef;
/*    */   }
/*    */ 
/*    */   public void setJobDetailDef(JobDetailDef jobDetailDef) {
/* 34 */     this.jobDetailDef = jobDetailDef;
/*    */   }
/*    */ 
/*    */   public List<JobDetailDef> getJobDetailDefs() {
/* 38 */     return this.jobDetailDefs;
/*    */   }
/*    */ 
/*    */   public void setJobDetailDefs(List<JobDetailDef> jobDetailDefs) {
/* 42 */     this.jobDetailDefs = jobDetailDefs;
/*    */   }
/*    */ 
/*    */   public JobDetailDefPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(JobDetailDefPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.JobDetailDefListAction
 * JD-Core Version:    0.6.0
 */