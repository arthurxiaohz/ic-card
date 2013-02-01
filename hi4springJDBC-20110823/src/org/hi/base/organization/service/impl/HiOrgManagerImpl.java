/*    */ package org.hi.base.organization.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.base.organization.service.HiOrgManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.context.SecurityOrgFilterEvent;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ import org.springframework.context.ApplicationEventPublisher;
/*    */ import org.springframework.context.ApplicationEventPublisherAware;
/*    */ 
/*    */ public class HiOrgManagerImpl extends ManagerImpl
/*    */   implements HiOrgManager, ApplicationEventPublisherAware
/*    */ {
/*    */   private ApplicationEventPublisher applicationEventPublisher;
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 19 */     if (((obj instanceof HiOrg)) && (((HiOrg)obj).isDirty()))
/* 20 */       publishEvent(obj);
/* 21 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj) {
/* 25 */     if ((obj instanceof HiOrg))
/* 26 */       publishEvent(obj);
/* 27 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void publishEvent(Object obj) {
/* 31 */     if (this.applicationEventPublisher != null) {
/* 32 */       SecurityOrgFilterEvent event = new SecurityOrgFilterEvent(obj);
/* 33 */       this.applicationEventPublisher.publishEvent(event);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
/* 38 */     this.applicationEventPublisher = applicationEventPublisher;
/*    */   }
/*    */ 
/*    */   protected void preSaveObject(Object obj) {
/* 42 */     HiOrg org = (HiOrg)obj;
/* 43 */     if (org.getCreator() == null)
/* 44 */       org.setCreator(UserContextHelper.getUser());
/* 45 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 50 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveHiOrg(HiOrg HiOrg)
/*    */   {
/* 55 */     saveObject(HiOrg);
/*    */   }
/*    */ 
/*    */   public void removeHiOrgById(Integer id)
/*    */   {
/* 60 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public HiOrg getHiOrgById(Integer id)
/*    */   {
/* 65 */     return (HiOrg)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<HiOrg> getHiOrgList(PageInfo pageInfo) {
/* 69 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityHiOrg(HiOrg hiOrg) {
/* 73 */     saveObject(hiOrg);
/*    */   }
/*    */   public void removeSecurityHiOrgById(Integer id) {
/* 76 */     removeObjectById(id);
/*    */   }
/*    */   public HiOrg getSecurityHiOrgById(Integer id) {
/* 79 */     return (HiOrg)getObjectById(id);
/*    */   }
/*    */   public List<HiOrg> getSecurityHiOrgList(PageInfo pageInfo) {
/* 82 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.service.impl.HiOrgManagerImpl
 * JD-Core Version:    0.6.0
 */