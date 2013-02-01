/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.AppSetting;
/*    */ import org.hi.base.sysapp.service.AppSettingManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AppSettingSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private AppSetting appSetting;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.appSetting) != null) return returnCommand();
/* 14 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/* 15 */     appSettingMgr.saveAppSetting(this.appSetting);
/* 16 */     super.postExecute(this.appSetting);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public AppSetting getAppSetting() {
/* 21 */     return this.appSetting;
/*    */   }
/*    */ 
/*    */   public void setAppSetting(AppSetting appSetting) {
/* 25 */     this.appSetting = appSetting;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.AppSettingSaveAction
 * JD-Core Version:    0.6.0
 */