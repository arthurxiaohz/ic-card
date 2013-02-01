/*     */ package org.hi.base.sysapp.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.sysapp.action.AppSettingPageInfo;
/*     */ import org.hi.base.sysapp.model.AppSetting;
/*     */ import org.hi.base.sysapp.service.AppSettingManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class AppSettingAction extends BaseAction
/*     */ {
/*     */   private AppSetting appSetting;
/*     */   private AppSettingPageInfo pageInfo;
/*     */   private List<AppSetting> appSettings;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveAppSetting()
/*     */     throws Exception
/*     */   {
/*  25 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*  26 */     if (super.perExecute(this.appSetting) != null) return returnCommand();
/*  27 */     appSettingMgr.saveAppSetting(this.appSetting);
/*  28 */     super.postExecute(this.appSetting);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAppSetting()
/*     */     throws Exception
/*     */   {
/*  37 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*  38 */     appSettingMgr.removeAppSettingById(this.appSetting.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllAppSetting()
/*     */     throws Exception
/*     */   {
/*  46 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer appSettingid = new Integer(ids[i]);
/*  55 */         appSettingMgr.removeAppSettingById(appSettingid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewAppSetting()
/*     */     throws Exception
/*     */   {
/*  67 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*  68 */     this.appSetting = appSettingMgr.getAppSettingById(this.appSetting.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String appSettingList()
/*     */     throws Exception
/*     */   {
/*  76 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new AppSettingPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.appSettings = appSettingMgr.getSecurityAppSettingList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public AppSetting getAppSetting()
/*     */   {
/*  89 */     return this.appSetting;
/*     */   }
/*     */ 
/*     */   public void setAppSetting(AppSetting appSetting) {
/*  93 */     this.appSetting = appSetting;
/*     */   }
/*     */ 
/*     */   public List<AppSetting> getAppSettings() {
/*  97 */     return this.appSettings;
/*     */   }
/*     */ 
/*     */   public void setAppSettings(List<AppSetting> appSettings) {
/* 101 */     this.appSettings = appSettings;
/*     */   }
/*     */ 
/*     */   public AppSettingPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(AppSettingPageInfo pageInfo) {
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

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.struts.AppSettingAction
 * JD-Core Version:    0.6.0
 */