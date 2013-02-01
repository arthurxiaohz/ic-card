/*     */ package org.hi.i18n.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.web.taglib.i18n.MLBean;
/*     */ import org.hi.i18n.model.Language;
/*     */ import org.hi.i18n.model.LanguageCode;
/*     */ import org.hi.i18n.service.LanguageCodeManager;
/*     */ import org.hi.i18n.service.LanguageManager;
/*     */ 
/*     */ public class I18NUtil
/*     */ {
/*     */   public static String getString(String key)
/*     */   {
/*  27 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  28 */     return languageMgr.getLanguageStr(key, getUserLanguageCode());
/*     */   }
/*     */ 
/*     */   public static String getString(String key, String entity)
/*     */   {
/*  40 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  41 */     return languageMgr.getLanguageStr(key, entity, getUserLanguageCode());
/*     */   }
/*     */ 
/*     */   public static String getString(String key, List<String> parameterValues)
/*     */   {
/*  52 */     return getString(key, null, parameterValues);
/*     */   }
/*     */ 
/*     */   public static String getString(String key, String entity, List<String> parameterValues)
/*     */   {
/*  65 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  66 */     String languageStr = languageMgr.getLanguageStr(key, entity, getUserLanguageCode());
/*     */ 
/*  68 */     return replaceParameterValues(languageStr, parameterValues);
/*     */   }
/*     */ 
/*     */   public static String getStringByParameter(String key, String parameterValues)
/*     */   {
/*  79 */     return getStringByParameter(key, null, parameterValues);
/*     */   }
/*     */ 
/*     */   public static String getStringByParameter(String key, String entity, String parameterValues)
/*     */   {
/*  91 */     if ((parameterValues == null) || (parameterValues.equals(""))) {
/*  92 */       return getString(key, entity);
/*     */     }
/*  94 */     List _parameterValues = StringUtils.strToArrayList(parameterValues);
/*  95 */     return getString(key, entity, _parameterValues);
/*     */   }
/*     */ 
/*     */   public static String getStringByLanguage(String xmlString, String languageCode)
/*     */   {
/* 101 */     if ((xmlString == null) || (xmlString.length() == 0) || (languageCode == null) || (languageCode.length() == 0))
/* 102 */       return "";
/* 103 */     List mlBeans = getMLBeansByLanguageStr(xmlString);
/* 104 */     if ((mlBeans != null) && (mlBeans.size() > 0)) {
/* 105 */       for (MLBean mlBean : mlBeans)
/* 106 */         if (languageCode.equals(mlBean.getLg()))
/* 107 */           return mlBean.getVl();
/*     */     }
/* 109 */     return "";
/*     */   }
/*     */ 
/*     */   public static List<MLBean> getMLBeansByLanguageStr(String xmlString)
/*     */   {
/* 114 */     List result = new ArrayList();
/* 115 */     List subValues = StringUtils.subStringList(xmlString, "<ml>", "</ml>");
/* 116 */     for (String subValue : subValues) {
/* 117 */       String subXML = "<ml>" + subValue + "</ml>";
/*     */       try {
/* 119 */         Object obj = BeanUtil.getXML2Bean(subXML, MLBean.class);
/* 120 */         result.add((MLBean)obj);
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 124 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/* 128 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getUserLanguageCode() {
/* 132 */     String userLanguageCode = HiConfigHolder.getI18NLanguage();
/*     */ 
/* 135 */     if ((userLanguageCode == null) || (userLanguageCode.trim().equals(""))) {
/* 136 */       String language = System.getProperties().getProperty("user.language");
/* 137 */       String country = System.getProperties().getProperty("user.country");
/* 138 */       userLanguageCode = language + "_" + country;
/*     */     }
/*     */ 
/* 141 */     Integer languageCodeID = null;
/* 142 */     if (UserContextHelper.getUser() != null)
/* 143 */       languageCodeID = UserContextHelper.getUser().getCountry();
/* 144 */     LanguageCodeManager languageMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/* 145 */     if ((languageCodeID != null) && (languageCodeID.intValue() > 0))
/*     */     {
/* 147 */       LanguageCode languageCode = languageMgr.getLanguageCodeById(languageCodeID);
/* 148 */       if ((languageCode != null) && (languageCode.getLanguageCode() != null) && (languageCode.getLanguageCode().trim().length() > 0)) {
/* 149 */         userLanguageCode = languageCode.getLanguageCode();
/*     */       }
/*     */     }
/* 152 */     return userLanguageCode;
/*     */   }
/*     */ 
/*     */   public static String replaceParameterValues(String mlString, List<String> parameterValues)
/*     */   {
/* 163 */     if ((mlString == null) || (mlString.equals("")) || (parameterValues == null) || (parameterValues.size() == 0))
/* 164 */       return mlString;
/* 165 */     int position = 0;
/* 166 */     for (String parameterValue : parameterValues) {
/* 167 */       position++;
/* 168 */       if (mlString.indexOf("{") < 0)
/* 169 */         mlString = mlString + parameterValue;
/*     */       else {
/* 171 */         mlString = mlString.replaceFirst("\\{" + position + "\\}", parameterValue);
/*     */       }
/*     */     }
/*     */ 
/* 175 */     int leftParameterFlag = mlString.indexOf("{");
/* 176 */     int rightParameter = mlString.indexOf("}");
/*     */ 
/* 178 */     while ((leftParameterFlag >= 0) && (rightParameter > leftParameterFlag))
/*     */     {
/* 180 */       String parameterIndex = mlString.substring(leftParameterFlag + 1, rightParameter);
/* 181 */       mlString = mlString.replaceFirst("\\{" + parameterIndex + "\\}", "");
/*     */ 
/* 183 */       leftParameterFlag = mlString.indexOf("{");
/* 184 */       rightParameter = mlString.indexOf("}");
/*     */     }
/*     */ 
/* 187 */     return mlString;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 194 */     Enumeration enum2 = System.getProperties().propertyNames();
/* 195 */     String language = System.getProperties().getProperty("user.language");
/* 196 */     String country = System.getProperties().getProperty("user.country");
/*     */ 
/* 199 */     System.out.println(language + "_" + country);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.util.I18NUtil
 * JD-Core Version:    0.6.0
 */