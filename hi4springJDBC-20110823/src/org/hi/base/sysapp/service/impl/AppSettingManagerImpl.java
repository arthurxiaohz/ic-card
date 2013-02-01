/*    */ package org.hi.base.sysapp.service.impl;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.AppSetting;
/*    */ import org.hi.base.sysapp.service.AppSettingManager;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class AppSettingManagerImpl extends ManagerImpl
/*    */   implements AppSettingManager
/*    */ {
/* 14 */   private List<AppSetting> appSettingCache = null;
/*    */ 
/*    */   protected void preSaveObject(Object obj) {
/* 17 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 22 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 28 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 33 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveAppSetting(AppSetting appSetting)
/*    */   {
/* 39 */     saveObject(appSetting);
/*    */   }
/*    */ 
/*    */   public void removeAppSettingById(Integer id)
/*    */   {
/* 44 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public AppSetting getAppSettingById(Integer id)
/*    */   {
/* 49 */     return (AppSetting)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<AppSetting> getAppSettingList(PageInfo pageInfo) {
/* 53 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityAppSetting(AppSetting appSetting) {
/* 57 */     saveObject(appSetting);
/*    */   }
/*    */   public void removeSecurityAppSettingById(Integer id) {
/* 60 */     removeObjectById(id);
/*    */   }
/*    */   public AppSetting getSecurityAppSettingById(Integer id) {
/* 63 */     return (AppSetting)getObjectById(id);
/*    */   }
/*    */   public List<AppSetting> getSecurityAppSettingList(PageInfo pageInfo) {
/* 66 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public List<AppSetting> getSecurityAppSettingToChach() {
/* 70 */     if (!HiConfigHolder.getPublished()) {
/* 71 */       return null;
/*    */     }
/* 73 */     if (this.appSettingCache != null) {
/* 74 */       return this.appSettingCache;
/*    */     }
/* 76 */     this.appSettingCache = new ArrayList();
/* 77 */     List _appSettings = getObjects();
/* 78 */     for (AppSetting appSetting : _appSettings) {
/* 79 */       AppSetting _appSetting = new AppSetting();
/* 80 */       _appSetting.setAppGroup(appSetting.getAppGroup());
/* 81 */       _appSetting.setAppName(appSetting.getAppName());
/* 82 */       _appSetting.setAppValue(appSetting.getAppValue());
/* 83 */       _appSetting.setDescription(appSetting.getDescription());
/* 84 */       this.appSettingCache.add(_appSetting);
/*    */     }
/*    */ 
/* 87 */     return this.appSettingCache;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.service.impl.AppSettingManagerImpl
 * JD-Core Version:    0.6.0
 */