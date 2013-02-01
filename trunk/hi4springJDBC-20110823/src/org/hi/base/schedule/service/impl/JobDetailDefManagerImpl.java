/*    */ package org.hi.base.schedule.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.schedule.model.JobDetailDef;
/*    */ import org.hi.base.schedule.service.JobDetailDefManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ import org.springframework.context.ApplicationEventPublisher;
/*    */ 
/*    */ public class JobDetailDefManagerImpl extends ManagerImpl
/*    */   implements JobDetailDefManager
/*    */ {
/*    */   private ApplicationEventPublisher applicationEventPublisher;
/*    */ 
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 21 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 26 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 33 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 38 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveJobDetailDef(JobDetailDef jobDetailDef)
/*    */   {
/* 45 */     saveObject(jobDetailDef);
/*    */   }
/*    */ 
/*    */   public void removeJobDetailDefById(Integer id)
/*    */   {
/* 50 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public JobDetailDef getJobDetailDefById(Integer id)
/*    */   {
/* 55 */     return (JobDetailDef)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<JobDetailDef> getJobDetailDefList(PageInfo pageInfo) {
/* 59 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityJobDetailDef(JobDetailDef jobDetailDef)
/*    */   {
/* 74 */     saveObject(jobDetailDef);
/*    */   }
/*    */   public void removeSecurityJobDetailDefById(Integer id) {
/* 77 */     removeObjectById(id);
/*    */   }
/*    */   public JobDetailDef getSecurityJobDetailDefById(Integer id) {
/* 80 */     return (JobDetailDef)getObjectById(id);
/*    */   }
/*    */   public List<JobDetailDef> getSecurityJobDetailDefList(PageInfo pageInfo) {
/* 83 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.service.impl.JobDetailDefManagerImpl
 * JD-Core Version:    0.6.0
 */