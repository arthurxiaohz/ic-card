/*    */ package org.hi.base.sysapp;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.AppSetting;
/*    */ import org.hi.base.sysapp.service.AppSettingManager;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ 
/*    */ public class AppSettingHelper
/*    */ {
/*    */   public static String getValue(String groupName, String appKey)
/*    */   {
/* 24 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/* 25 */     if (appSettingMgr.getSecurityAppSettingToChach() != null) {
/* 26 */       List cache = appSettingMgr.getSecurityAppSettingToChach();
/* 27 */       for (AppSetting appSetting : cache) {
/* 28 */         if ((appSetting.getAppGroup().equals(groupName)) && (appSetting.getAppName().equals(appKey)))
/* 29 */           return appSetting.getAppValue();
/*    */       }
/*    */     }
/* 32 */     Filter filter = FilterFactory.getSimpleFilter("appGroup", groupName, "=")
/* 33 */       .addCondition("appName", appKey, "=");
/* 34 */     List result = appSettingMgr.getObjects(filter);
/*    */ 
/* 36 */     if (result.size() == 0) {
/* 37 */       return null;
/*    */     }
/* 39 */     AppSetting bean = (AppSetting)result.get(0);
/* 40 */     return bean.getAppValue();
/*    */   }
/*    */ 
/*    */   public static Set<String> getValues(String groupName)
/*    */   {
/* 49 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/*    */ 
/* 51 */     if (appSettingMgr.getSecurityAppSettingToChach() != null) {
/* 52 */       List cache = appSettingMgr.getSecurityAppSettingToChach();
/* 53 */       Set values = new LinkedHashSet();
/* 54 */       for (AppSetting appSetting : cache) {
/* 55 */         if (appSetting.getAppGroup().equals(groupName))
/* 56 */           values.add(appSetting.getAppValue());
/*    */       }
/* 58 */       return values;
/*    */     }
/*    */ 
/* 61 */     Filter filter = FilterFactory.getSimpleFilter("appGroup", groupName, "=");
/* 62 */     List settings = appSettingMgr.getObjects(filter);
/*    */ 
/* 64 */     Set result = new HashSet();
/* 65 */     if (settings.size() == 0) {
/* 66 */       return result;
/*    */     }
/* 68 */     for (Iterator iter = result.iterator(); iter.hasNext(); ) {
/* 69 */       AppSetting appSetting = (AppSetting)iter.next();
/* 70 */       result.add(appSetting.getAppValue());
/*    */     }
/*    */ 
/* 73 */     return result;
/*    */   }
/*    */ 
/*    */   public static List<AppSetting> getGroup(String groupName) {
/* 77 */     AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
/* 78 */     if (appSettingMgr.getSecurityAppSettingToChach() != null) {
/* 79 */       List cache = appSettingMgr.getSecurityAppSettingToChach();
/* 80 */       List values = new ArrayList();
/* 81 */       for (AppSetting appSetting : cache) {
/* 82 */         if (appSetting.getAppGroup().equals(groupName))
/* 83 */           values.add(appSetting);
/*    */       }
/* 85 */       return values;
/*    */     }
/*    */ 
/* 88 */     Filter filter = FilterFactory.getSimpleFilter("appGroup", groupName, "=");
/* 89 */     return appSettingMgr.getObjects(filter);
/*    */   }
/*    */ 
/*    */   public static String getValue(List<AppSetting> group, String appKey) {
/* 93 */     for (AppSetting appSetting : group) {
/* 94 */       if (appSetting.getAppName().equals(appKey))
/* 95 */         return appSetting.getAppValue();
/*    */     }
/* 97 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.AppSettingHelper
 * JD-Core Version:    0.6.0
 */