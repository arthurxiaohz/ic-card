/*     */ package org.hi.base.schedule.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.schedule.action.JobDetailDefPageInfo;
/*     */ import org.hi.base.schedule.model.JobDetailDef;
/*     */ import org.hi.base.schedule.service.JobDetailDefManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class JobDetailDefAction extends BaseAction
/*     */ {
/*     */   private JobDetailDef jobDetailDef;
/*     */   private JobDetailDefPageInfo pageInfo;
/*     */   private List<JobDetailDef> jobDetailDefs;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveJobDetailDef()
/*     */     throws Exception
/*     */   {
/*  25 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/*  26 */     if (super.perExecute(this.jobDetailDef) != null) return returnCommand();
/*  27 */     jobDetailDefMgr.saveJobDetailDef(this.jobDetailDef);
/*  28 */     super.postExecute(this.jobDetailDef);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeJobDetailDef()
/*     */     throws Exception
/*     */   {
/*  37 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/*  38 */     jobDetailDefMgr.removeJobDetailDefById(this.jobDetailDef.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllJobDetailDef()
/*     */     throws Exception
/*     */   {
/*  46 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer jobDetailDefid = new Integer(ids[i]);
/*  55 */         jobDetailDefMgr.removeJobDetailDefById(jobDetailDefid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewJobDetailDef()
/*     */     throws Exception
/*     */   {
/*  67 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/*  68 */     this.jobDetailDef = jobDetailDefMgr.getJobDetailDefById(this.jobDetailDef.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String jobDetailDefList()
/*     */     throws Exception
/*     */   {
/*  76 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new JobDetailDefPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.jobDetailDefs = jobDetailDefMgr.getSecurityJobDetailDefList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public JobDetailDef getJobDetailDef()
/*     */   {
/*  89 */     return this.jobDetailDef;
/*     */   }
/*     */ 
/*     */   public void setJobDetailDef(JobDetailDef jobDetailDef) {
/*  93 */     this.jobDetailDef = jobDetailDef;
/*     */   }
/*     */ 
/*     */   public List<JobDetailDef> getJobDetailDefs() {
/*  97 */     return this.jobDetailDefs;
/*     */   }
/*     */ 
/*     */   public void setJobDetailDefs(List<JobDetailDef> jobDetailDefs) {
/* 101 */     this.jobDetailDefs = jobDetailDefs;
/*     */   }
/*     */ 
/*     */   public JobDetailDefPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(JobDetailDefPageInfo pageInfo) {
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
 * Qualified Name:     org.hi.base.schedule.action.struts.JobDetailDefAction
 * JD-Core Version:    0.6.0
 */