/*     */ package org.hi.generator.template;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class TemplateHelpFactory
/*     */ {
/*     */   public static final String TEMPLATE_HELP_IMPL = "org.hi.generator.template.TemplateHelp";
/*     */   public static final String TEMPLATE_FILE_SUFFIX = "template.file.suffix";
/*     */   public static final String TEMPATE_ENTITY_STEP = "template.entity.step";
/*     */   public static final String TEMPATE_ENTITY_ENCODEING = "template.file.encoding";
/*  40 */   protected static final Log logger = LogFactory.getLog("org.hi.generater.template.TemplateHelpFactory");
/*  41 */   private static String fileSuffix = null;
/*  42 */   private static String encoding = null;
/*     */ 
/*     */   public static TemplateHelp newInstance(String templateRootDir)
/*     */   {
/*  53 */     Properties props = getProperties();
/*  54 */     if (props.containsKey("org.hi.generator.template.TemplateHelp")) {
/*  55 */       String templateHelpClassName = props.getProperty("org.hi.generator.template.TemplateHelp").trim();
/*     */       try
/*     */       {
/*  58 */         Class clzz = Class.forName(templateHelpClassName);
/*  59 */         Constructor constructor = clzz.getConstructor(new Class[] { String.class });
/*  60 */         TemplateHelp templateHelp = (TemplateHelp)constructor.newInstance(new Object[] { templateRootDir });
/*  61 */         return templateHelp;
/*     */       } catch (IllegalArgumentException e) {
/*  63 */         e.printStackTrace();
/*     */       } catch (InstantiationException e) {
/*  65 */         e.printStackTrace();
/*     */       } catch (IllegalAccessException e) {
/*  67 */         e.printStackTrace();
/*     */       } catch (InvocationTargetException e) {
/*  69 */         e.printStackTrace();
/*     */       } catch (ClassNotFoundException e) {
/*  71 */         e.printStackTrace();
/*     */       } catch (SecurityException e) {
/*  73 */         e.printStackTrace();
/*     */       } catch (NoSuchMethodException e) {
/*  75 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  80 */       logger.error("not found property org.hi.generator.template.TemplateHelp in file :template.properties");
/*  81 */       return null;
/*     */     }
/*     */ 
/*  84 */     return null;
/*     */   }
/*     */ 
/*     */   private static Properties getProperties()
/*     */   {
/*  93 */     InputStream in = TemplateHelpFactory.class.getResourceAsStream("template.properties");
/*  94 */     Properties props = new Properties();
/*     */     try {
/*  96 */       logger.info("loading properties file :template.properties");
/*  97 */       props.load(in);
/*  98 */       in.close();
/*     */     } catch (IOException e) {
/* 100 */       logger.error("Unable to load template.properties", e);
/*     */     }
/*     */ 
/* 103 */     if (props == null);
/* 108 */     return props;
/*     */   }
/*     */ 
/*     */   public static String getTemplateFileEncoding()
/*     */   {
/* 116 */     if (encoding != null) {
/* 117 */       return encoding;
/*     */     }
/* 119 */     Properties props = getProperties();
/*     */ 
/* 121 */     if (props.containsKey("template.file.encoding")) {
/* 122 */       encoding = props.getProperty("template.file.encoding").trim();
/* 123 */       return encoding;
/*     */     }
/*     */ 
/* 126 */     logger.error("not found property template.file.encodingin file :template.properties");
/*     */ 
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   public static String getTemplateFileSuffix() {
/* 133 */     if (fileSuffix != null) {
/* 134 */       return fileSuffix;
/*     */     }
/* 136 */     Properties props = getProperties();
/*     */ 
/* 138 */     if (props.containsKey("template.file.suffix")) {
/* 139 */       fileSuffix = props.getProperty("template.file.suffix").trim();
/* 140 */       return fileSuffix;
/*     */     }
/*     */ 
/* 143 */     logger.error("not found property template.file.suffixin file :template.properties");
/*     */ 
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   public static int getEntityStep()
/*     */   {
/* 151 */     Properties props = getProperties();
/* 152 */     int result = 0;
/*     */ 
/* 154 */     if (props.containsKey("template.entity.step")) {
/* 155 */       String resultStrValue = props.getProperty("template.entity.step").trim();
/*     */       try {
/* 157 */         Integer.parseInt(resultStrValue);
/*     */       }
/*     */       catch (NumberFormatException localNumberFormatException) {
/* 160 */         logger.error("problem! property template.file.suffixvalue:" + resultStrValue + "in file:template.properties");
/* 161 */         throw new NumberFormatException();
/*     */       }
/*     */     }
/*     */     else {
/* 165 */       logger.error("not found property template.entity.stepin file:template.properties");
/*     */     }
/*     */ 
/* 168 */     return result;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.template.TemplateHelpFactory
 * JD-Core Version:    0.6.0
 */