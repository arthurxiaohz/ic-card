/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.action.AppSettingPageInfo;
/*    */ import org.hi.base.sysapp.model.AppSetting;
/*    */ import org.hi.base.sysapp.service.AppSettingManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AppSettingListAction extends BaseAction
/*    */ {
/*    */   private AppSetting appSetting;
/*    */   private AppSettingPageInfo pageInfo;
/*    */   private List<AppSetting> appSettings;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new AppSettingPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.appSettings = appSettingMgr.getSecurityAppSettingList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public AppSetting getAppSetting() {
/* 30 */     return this.appSetting;
/*    */   }
/*    */ 
/*    */   public void setAppSetting(AppSetting appSetting) {
/* 34 */     this.appSetting = appSetting;
/*    */   }
/*    */ 
/*    */   public List<AppSetting> getAppSettings() {
/* 38 */     return this.appSettings;
/*    */   }
/*    */ 
/*    */   public void setAppSettings(List<AppSetting> appSettings) {
/* 42 */     this.appSettings = appSettings;
/*    */   }
/*    */ 
/*    */   public AppSettingPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(AppSettingPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.AppSettingListAction
 * JD-Core Version:    0.6.0
 */