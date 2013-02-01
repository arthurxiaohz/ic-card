/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.AppSetting;
/*    */ import org.hi.base.sysapp.service.AppSettingManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AppSettingRemoveAllAction extends BaseAction
/*    */ {
/*    */   private AppSetting appSetting;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer appSettingid = new Integer(ids[i]);
/* 24 */         appSettingMgr.removeAppSettingById(appSettingid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public AppSetting getAppSetting() {
/* 33 */     return this.appSetting;
/*    */   }
/*    */ 
/*    */   public void setAppSetting(AppSetting appSetting) {
/* 37 */     this.appSetting = appSetting;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.AppSettingRemoveAllAction
 * JD-Core Version:    0.6.0
 */