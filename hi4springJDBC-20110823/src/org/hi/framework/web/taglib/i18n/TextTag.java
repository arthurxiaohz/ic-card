/*     */ package org.hi.framework.web.taglib.i18n;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.web.taglib.AbstractTag;
/*     */ import org.hi.i18n.model.Language;
/*     */ import org.hi.i18n.service.LanguageManager;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class TextTag extends AbstractTag
/*     */ {
/*     */   public String key;
/*     */   private String languageCode;
/*     */   public String parameterValues;
/*     */   public String parameterLanguageKeys;
/*     */   public String entity;
/*     */ 
/*     */   public int doEndTag()
/*     */     throws JspException
/*     */   {
/*  32 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  33 */     List parameterValues = getParameterValues();
/*  34 */     String _languageCode = "";
/*  35 */     String returnStr = "";
/*  36 */     if ((this.key != null) || (!this.key.equals("")))
/*     */     {
/*  38 */       if ((this.languageCode == null) || (this.languageCode.equals("")))
/*  39 */         _languageCode = I18NUtil.getUserLanguageCode();
/*     */       else
/*  41 */         _languageCode = this.languageCode;
/*  42 */       if ((this.entity != null) && (!this.entity.equals("")))
/*     */       {
/*  44 */         returnStr = languageMgr.getLanguageStr(this.key, this.entity, _languageCode);
/*     */       }
/*     */       else {
/*  47 */         returnStr = languageMgr.getLanguageStr(this.key, _languageCode);
/*     */       }
/*     */ 
/*  51 */       returnStr = I18NUtil.replaceParameterValues(returnStr, parameterValues);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  57 */       this.pageContext.getOut().print(returnStr);
/*     */     } catch (IOException e) {
/*  59 */       e.printStackTrace();
/*     */     }
/*  61 */     return 6;
/*     */   }
/*     */ 
/*     */   private List<String> getParameterValues()
/*     */   {
/*  71 */     if ((this.parameterValues != null) && (!this.parameterValues.equals("")))
/*     */     {
/*  73 */       List valueList = new ArrayList();
/*  74 */       String[] parameterValue_arr = this.parameterValues.split(",");
/*  75 */       for (int i = 0; i < parameterValue_arr.length; i++) {
/*  76 */         valueList.add(parameterValue_arr[i]);
/*     */       }
/*     */ 
/*  79 */       return valueList;
/*     */     }
/*  81 */     if ((this.parameterLanguageKeys != null) && (!this.parameterLanguageKeys.equals("")))
/*     */     {
/*  83 */       LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  84 */       List valueList = new ArrayList();
/*  85 */       String[] parameterLanguageKey_arr = this.parameterLanguageKeys.split(",");
/*  86 */       for (int i = 0; i < parameterLanguageKey_arr.length; i++) {
/*  87 */         String languageStr = languageMgr.getLanguageStr(parameterLanguageKey_arr[i], this.languageCode);
/*  88 */         valueList.add(languageStr);
/*     */       }
/*  90 */       return valueList;
/*     */     }
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   public String getKey()
/*     */   {
/*  99 */     return this.key;
/*     */   }
/*     */ 
/*     */   public void setKey(String key)
/*     */   {
/* 104 */     this.key = key;
/*     */   }
/*     */ 
/*     */   public String getLanguageCode()
/*     */   {
/* 109 */     return this.languageCode;
/*     */   }
/*     */ 
/*     */   public void setLanguageCode(String languageCode)
/*     */   {
/* 114 */     this.languageCode = languageCode;
/*     */   }
/*     */ 
/*     */   public String getParameterLanguageKeys()
/*     */   {
/* 122 */     return this.parameterLanguageKeys;
/*     */   }
/*     */ 
/*     */   public void setParameterLanguageKeys(String parameterLanguageKeys)
/*     */   {
/* 128 */     this.parameterLanguageKeys = parameterLanguageKeys;
/*     */   }
/*     */ 
/*     */   public void setParameterValues(String parameterValues)
/*     */   {
/* 134 */     this.parameterValues = parameterValues;
/*     */   }
/*     */ 
/*     */   public String getEntity() {
/* 138 */     return this.entity;
/*     */   }
/*     */ 
/*     */   public void setEntity(String entity)
/*     */   {
/* 144 */     this.entity = entity;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.i18n.TextTag
 * JD-Core Version:    0.6.0
 */