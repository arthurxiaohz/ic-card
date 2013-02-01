/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.AppSetting;
/*    */ import org.hi.base.sysapp.service.AppSettingManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AppSettingRemoveAction extends BaseAction
/*    */ {
/*    */   private AppSetting appSetting;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/* 14 */     appSettingMgr.removeAppSettingById(this.appSetting.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public AppSetting getAppSetting() {
/* 19 */     return this.appSetting;
/*    */   }
/*    */ 
/*    */   public void setAppSetting(AppSetting appSetting) {
/* 23 */     this.appSetting = appSetting;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.AppSettingRemoveAction
 * JD-Core Version:    0.6.0
 */