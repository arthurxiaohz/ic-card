/*    */ package org.hi.base.schedule.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.context.ScheduleDefChangeEvent;
/*    */ import org.hi.base.schedule.model.JobDetailDef;
/*    */ import org.hi.base.schedule.model.TriggerDef;
/*    */ import org.hi.base.schedule.service.JobDetailDefManager;
/*    */ import org.hi.base.schedule.service.TriggerDefManager;
/*    */ import org.hi.framework.model.BaseObject;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ import org.springframework.context.ApplicationEventPublisher;
/*    */ import org.springframework.context.ApplicationEventPublisherAware;
/*    */ 
/*    */ public class TriggerDefManagerImpl extends ManagerImpl
/*    */   implements TriggerDefManager, ApplicationEventPublisherAware
/*    */ {
/*    */   private ApplicationEventPublisher applicationEventPublisher;
/*    */ 
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 23 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 28 */     super.postSaveObject(obj);
/* 29 */     if (((BaseObject)obj).isDirty())
/* 30 */       publishEvent(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 35 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 40 */     super.postRemoveObject(obj);
/* 41 */     publishEvent(obj);
/*    */   }
/*    */ 
/*    */   public void saveTriggerDef(TriggerDef triggerDef)
/*    */   {
/* 46 */     String jobClassName = triggerDef.getJobDetailName();
/* 47 */     JobDetailDef jobDetailDef = triggerDef.getJobDetail();
/* 48 */     if (jobDetailDef == null) jobDetailDef = new JobDetailDef();
/* 49 */     if (!jobClassName.equals(jobDetailDef.getJobClassName())) {
/* 50 */       JobDetailDefManager jobDefMrg = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/* 51 */       jobDetailDef.setJobClassName(jobClassName);
/* 52 */       jobDetailDef.setJobName(jobClassName);
/* 53 */       jobDefMrg.saveObject(jobDetailDef);
/*    */     }
/* 55 */     triggerDef.setJobDetail(jobDetailDef);
/* 56 */     saveObject(triggerDef);
/*    */   }
/*    */ 
/*    */   public void removeTriggerDefById(Integer id) {
/* 60 */     TriggerDef triggerDef = (TriggerDef)getObjectById(id);
/* 61 */     if (triggerDef != null) {
/* 62 */       JobDetailDefManager jobDefMrg = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/* 63 */       jobDefMrg.removeObject(triggerDef.getJobDetail());
/* 64 */       removeObjectById(id);
/*    */     }
/*    */   }
/*    */ 
/*    */   public TriggerDef getTriggerDefById(Integer id)
/*    */   {
/* 70 */     return (TriggerDef)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<TriggerDef> getTriggerDefList(PageInfo pageInfo) {
/* 74 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
/* 78 */     this.applicationEventPublisher = applicationEventPublisher;
/*    */   }
/*    */ 
/*    */   protected void publishEvent(Object obj) {
/* 82 */     if ((this.applicationEventPublisher != null) && ((obj instanceof TriggerDef))) {
/* 83 */       ScheduleDefChangeEvent event = new ScheduleDefChangeEvent(obj);
/* 84 */       this.applicationEventPublisher.publishEvent(event);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void saveSecurityTriggerDef(TriggerDef triggerDef) {
/* 89 */     saveObject(triggerDef);
/*    */   }
/*    */   public void removeSecurityTriggerDefById(Integer id) {
/* 92 */     removeObjectById(id);
/*    */   }
/*    */   public TriggerDef getSecurityTriggerDefById(Integer id) {
/* 95 */     return (TriggerDef)getObjectById(id);
/*    */   }
/*    */   public List<TriggerDef> getSecurityTriggerDefList(PageInfo pageInfo) {
/* 98 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.schedule.service.impl.TriggerDefManagerImpl
 * JD-Core Version:    0.6.0
 */