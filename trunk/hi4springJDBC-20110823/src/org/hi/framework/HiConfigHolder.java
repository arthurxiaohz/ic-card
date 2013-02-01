/*     */ package org.hi.framework;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Properties;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.sysapp.message.MessageProviderManager;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.context.HiFrameworkConfig;
/*     */ import org.hi.framework.web.WebContextName;
/*     */ 
/*     */ public class HiConfigHolder
/*     */ {
/*     */   private static final int PAGE_SIZE = 10;
/*     */   public static final int PAGE_MAXRECORDS = 0;
/*  24 */   private static WebContextName webContextName = null;
/*  25 */   private static MessageProviderManager providerFactory = null;
/*     */   private static Properties properties;
/*     */ 
/*     */   public static Properties getProperties()
/*     */   {
/*  29 */     if (properties != null)
/*  30 */       return properties;
/*  31 */     HiFrameworkConfig config = null;
/*     */     try {
/*  33 */       config = (HiFrameworkConfig)SpringContextHolder.getBean("hiConfig");
/*     */     } catch (Throwable localThrowable) {
/*     */     }
/*  36 */     if (config != null) {
/*  37 */       properties = config.getConfig();
/*  38 */       return properties;
/*     */     }
/*  40 */     InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("hiFrameworkConfig.properties");
/*  41 */     Properties _properties = new Properties();
/*     */     try {
/*  43 */       _properties.load(in);
/*     */     } catch (FileNotFoundException e) {
/*  45 */       e.printStackTrace();
/*     */       try
/*     */       {
/*  51 */         if (in != null)
/*  52 */           in.close();
/*     */       } catch (IOException e) {
/*  54 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  47 */       e.printStackTrace();
/*     */       try
/*     */       {
/*  51 */         if (in != null)
/*  52 */           in.close();
/*     */       } catch (IOException e) {
/*  54 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  51 */         if (in != null)
/*  52 */           in.close();
/*     */       } catch (IOException e) {
/*  54 */         e.printStackTrace();
/*     */       }
/*     */     }
/*  57 */     properties = _properties;
/*  58 */     return properties;
/*     */   }
/*     */ 
/*     */   public static String getProperty(String key)
/*     */   {
/*  63 */     return getProperties().getProperty(key);
/*     */   }
/*     */ 
/*     */   public static boolean getFrameworkConfigReload()
/*     */   {
/*  71 */     String reload = getProperties().getProperty("hi.config.reload");
/*  72 */     if (reload == null) {
/*  73 */       return false;
/*     */     }
/*  75 */     return Boolean.parseBoolean(reload);
/*     */   }
/*     */ 
/*     */   private static void ObjectNull() {
/*  79 */     if (getFrameworkConfigReload())
/*  80 */       properties = null;
/*     */   }
/*     */ 
/*     */   public static int getPageSize()
/*     */   {
/*  88 */     String pageSize = getProperties().getProperty("hi.pageinfo.pagesize");
/*  89 */     if (pageSize == null)
/*  90 */       return 10;
/*  91 */     ObjectNull();
/*  92 */     return Integer.parseInt(pageSize);
/*     */   }
/*     */ 
/*     */   public static int getMaxRecords()
/*     */   {
/* 100 */     String maxRecords = getProperties().getProperty("hi.pageinfo.maxrecords");
/* 101 */     if (maxRecords == null)
/* 102 */       return 0;
/* 103 */     ObjectNull();
/* 104 */     return Integer.parseInt(maxRecords);
/*     */   }
/*     */ 
/*     */   public static String getMenuConfig()
/*     */   {
/* 112 */     String menuConfig = getProperties().getProperty("hi.menu.menuconfig");
/* 113 */     ObjectNull();
/* 114 */     return menuConfig;
/*     */   }
/*     */ 
/*     */   public static boolean getMenuReload()
/*     */   {
/* 122 */     String reload = getProperties().getProperty("hi.menu.reload");
/* 123 */     if (reload == null)
/* 124 */       return true;
/* 125 */     ObjectNull();
/* 126 */     return Boolean.parseBoolean(reload);
/*     */   }
/*     */ 
/*     */   public static String getSecurityOrgShowMode()
/*     */   {
/* 136 */     String mode = getProperties().getProperty("hi.security.page.org.show.mode");
/* 137 */     ObjectNull();
/* 138 */     if ((mode == null) || (mode.trim().equals("")))
/* 139 */       return "lookup";
/* 140 */     if ((!mode.equals("lookup")) && (!mode.equals("dropdown")))
/* 141 */       return "lookup";
/* 142 */     return mode;
/*     */   }
/*     */ 
/*     */   public static String getViewFrameworkSuffix()
/*     */   {
/* 150 */     String actionSuffix = getProperties().getProperty("hi.view.framework.action.suffix");
/* 151 */     ObjectNull();
/* 152 */     if ((actionSuffix == null) || (actionSuffix.trim().equals("")))
/* 153 */       return "action";
/* 154 */     return actionSuffix;
/*     */   }
/*     */ 
/*     */   public static String getSecurityFilterCalss() {
/* 158 */     String className = getProperties().getProperty("hi.pageinfo.securityfilterclass");
/* 159 */     ObjectNull();
/* 160 */     if ((className == null) || (className.trim().equals("")))
/* 161 */       return "org.hi.framework.dao.impl.SecurityFilterImpl";
/* 162 */     return className;
/*     */   }
/*     */ 
/*     */   public static String getTagBuilderClass(String builderKey)
/*     */   {
/* 167 */     String className = getProperties().getProperty(builderKey);
/* 168 */     ObjectNull();
/* 169 */     return className;
/*     */   }
/*     */ 
/*     */   public static int getCurrnetMiddlePage() {
/* 173 */     String currnetMiddlePage = getProperties().getProperty("hi.pageinfo.currnetmiddlepag");
/* 174 */     ObjectNull();
/* 175 */     if ((currnetMiddlePage == null) || (currnetMiddlePage.trim().equals("")))
/* 176 */       return Integer.parseInt("5");
/* 177 */     return Integer.parseInt(currnetMiddlePage);
/*     */   }
/*     */ 
/*     */   public static boolean getPublished()
/*     */   {
/* 185 */     String published = getProperties().getProperty("hi.depolyment.published");
/* 186 */     ObjectNull();
/* 187 */     if ((published == null) || (published.trim().equals("")))
/* 188 */       return false;
/* 189 */     return Boolean.parseBoolean(published);
/*     */   }
/*     */ 
/*     */   public static String getRootUpload() {
/* 193 */     String upload = getProperties().getProperty("hi.depolyment.rootupload");
/* 194 */     ObjectNull();
/* 195 */     if ((upload == null) || (upload.trim().equals("")))
/* 196 */       return "upload";
/* 197 */     return upload;
/*     */   }
/*     */ 
/*     */   public static String getJarFile() {
/* 201 */     String jarFile = getProperties().getProperty("hi.jarfiles");
/* 202 */     ObjectNull();
/* 203 */     if ((jarFile == null) || (jarFile.trim().equals("")))
/* 204 */       return null;
/* 205 */     return jarFile;
/*     */   }
/*     */ 
/*     */   public static String getWebContextName() {
/* 209 */     if (webContextName != null) {
/* 210 */       return webContextName.getContextName();
/*     */     }
/* 212 */     String webContextClassName = getProperties().getProperty("hi.view.framework.web.contextName");
/* 213 */     ObjectNull();
/* 214 */     if ((webContextClassName == null) || (webContextClassName.trim().equals(""))) {
/* 215 */       webContextClassName = "org.hi.framework.web.ContextName.ContextNameDefault";
/*     */     }
/* 217 */     webContextName = (WebContextName)BeanUtil.CreateObject(webContextClassName);
/*     */ 
/* 219 */     return webContextName.getContextName();
/*     */   }
/*     */ 
/*     */   public static String getMaxLimit() {
/* 223 */     String maxCode = getProperties().getProperty("hi.pageinfo.maxlimitrecode");
/* 224 */     ObjectNull();
/* 225 */     if ((maxCode == null) || (maxCode.trim().equals("")))
/* 226 */       return "100000";
/* 227 */     return maxCode;
/*     */   }
/*     */ 
/*     */   public static MessageProviderManager getMessageProviderFactory() {
/* 231 */     if (providerFactory != null) {
/* 232 */       return providerFactory;
/*     */     }
/* 234 */     String providerFactoryClassName = getProperties().getProperty("hi.message.providerfactory");
/* 235 */     ObjectNull();
/* 236 */     if ((providerFactoryClassName == null) || (providerFactoryClassName.trim().equals("")))
/* 237 */       providerFactoryClassName = "org.hi.base.sysapp.message.MessageProviderFactory";
/* 238 */     providerFactory = (MessageProviderManager)BeanUtil.CreateObject(providerFactoryClassName);
/* 239 */     return providerFactory;
/*     */   }
/*     */ 
/*     */   public static boolean getVerifyCode()
/*     */   {
/* 244 */     String verifycode = getProperties().getProperty("hi.security.page.verifycode");
/* 245 */     ObjectNull();
/* 246 */     if ((verifycode == null) || (verifycode.trim().equals("")))
/* 247 */       return false;
/* 248 */     return Boolean.parseBoolean(verifycode);
/*     */   }
/*     */ 
/*     */   public static boolean getUrlEncrypt() {
/* 252 */     String urlEncrypt = getProperties().getProperty("hi.security.page.urlencrypt");
/* 253 */     ObjectNull();
/* 254 */     if ((urlEncrypt == null) || (urlEncrypt.trim().equals("")))
/* 255 */       return true;
/* 256 */     return Boolean.parseBoolean(urlEncrypt);
/*     */   }
/*     */ 
/*     */   public static String getMVCActionName() {
/* 260 */     String actionName = getProperties().getProperty("hi.mvc.action.name");
/* 261 */     ObjectNull();
/* 262 */     if ((actionName == null) || (actionName.trim().equals("")))
/* 263 */       return "hi.action";
/* 264 */     return actionName;
/*     */   }
/*     */ 
/*     */   public static String getI18NLanguage() {
/* 268 */     ObjectNull();
/* 269 */     return getProperties().getProperty("hi.i18n.defaultLanguage");
/*     */   }
/*     */ 
/*     */   public static String getViewMode() {
/* 273 */     String modeName = getProperties().getProperty("hi.view.framework.mode");
/* 274 */     ObjectNull();
/* 275 */     if ((modeName == null) || (modeName.trim().equals("")))
/* 276 */       return "classic";
/* 277 */     return modeName;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.HiConfigHolder
 * JD-Core Version:    0.6.0
 */