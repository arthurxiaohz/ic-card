/*     */ package org.hi.studio.hsceditor.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ 
/*     */ public class FilterUtil
/*     */ {
/*  21 */   private static List<String> filterList = null;
/*     */ 
/*     */   public static boolean validate(String validateName)
/*     */   {
/*  29 */     if (StringUtil.isValidatedName(validateName)) {
/*  30 */       return true;
/*     */     }
/*     */ 
/*  33 */     List filters = readKeyFormXml();
/*     */ 
/*  35 */     for (Iterator it = filters.iterator(); it.hasNext(); ) {
/*  36 */       String filterName = (String)it.next();
/*  37 */       if (match(filterName, validateName.toUpperCase())) {
/*  38 */         return true;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   private static boolean match(String pattern, Object value)
/*     */   {
/*  54 */     if (!(value instanceof String)) {
/*  55 */       return false;
/*     */     }
/*  57 */     String str = (String)value;
/*     */ 
/*  59 */     if ((pattern == null) || (pattern.trim().equals("")) || (str == null) || (str.trim().equals(""))) {
/*  60 */       return false;
/*     */     }
/*  62 */     pattern = pattern.replaceAll("[.]", "\\\\.");
/*  63 */     StringBuffer sb = new StringBuffer("");
/*  64 */     for (int i = 0; i < pattern.length(); i++) {
/*  65 */       char subChar = pattern.charAt(i);
/*  66 */       switch (subChar) {
/*     */       case '*':
/*  68 */         sb.append(".*");
/*  69 */         break;
/*     */       case '?':
/*  71 */         sb.append(".{1}");
/*  72 */         break;
/*     */       default:
/*  74 */         sb.append(subChar);
/*     */       }
/*     */     }
/*     */ 
/*  78 */     pattern = sb.toString();
/*     */ 
/*  80 */     return Pattern.matches(pattern, str);
/*     */   }
/*     */ 
/*     */   private static List<String> readKeyFormXml()
/*     */   {
/*  90 */     if (filterList != null)
/*     */     {
/*  92 */       return filterList;
/*     */     }
/*     */ 
/*  95 */     filterList = new ArrayList();
/*  96 */     SAXBuilder builder = new SAXBuilder();
/*  97 */     Document doc = new Document();
/*     */     try {
/*  99 */       InputStream in = null;
/* 100 */       in = FilterUtil.class.getResourceAsStream("/hifilter.xml");
/* 101 */       doc = builder.build(in);
/* 102 */       in.close();
/*     */     } catch (JDOMException e) {
/* 104 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 106 */       e.printStackTrace();
/*     */     }
/* 108 */     Iterator itr = doc.getRootElement().getChildren().iterator();
/* 109 */     while (itr.hasNext())
/*     */     {
/* 111 */       Element elem = (Element)itr.next();
/* 112 */       String name = elem.getText();
/* 113 */       filterList.add(name);
/*     */     }
/*     */ 
/* 116 */     return filterList;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.FilterUtil
 * JD-Core Version:    0.6.0
 */