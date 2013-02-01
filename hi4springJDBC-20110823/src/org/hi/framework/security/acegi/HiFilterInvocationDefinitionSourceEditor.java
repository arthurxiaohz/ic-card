/*     */ package org.hi.framework.security.acegi;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.acegisecurity.intercept.web.FilterInvocationDefinitionDecorator;
/*     */ import org.acegisecurity.intercept.web.FilterInvocationDefinitionSourceEditor;
/*     */ import org.acegisecurity.intercept.web.FilterInvocationDefinitionSourceMapping;
/*     */ import org.acegisecurity.intercept.web.PathBasedFilterInvocationDefinitionMap;
/*     */ import org.acegisecurity.util.StringSplitUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.util.StringUtils;
/*     */ 
/*     */ public class HiFilterInvocationDefinitionSourceEditor extends FilterInvocationDefinitionSourceEditor
/*     */ {
/*  21 */   protected static final Log logger = LogFactory.getLog(FilterInvocationDefinitionSourceEditor.class);
/*     */ 
/*  23 */   public void setAsText(String s) throws IllegalArgumentException { FilterInvocationDefinitionDecorator source = new FilterInvocationDefinitionDecorator();
/*     */ 
/*  25 */     if ((s == null) || ("".equals(s)))
/*     */     {
/*  27 */       source.setDecorated(new HiRegExpBasedFilterInvocationDefinitionMap());
/*     */     }
/*     */     else {
/*  30 */       if (s.lastIndexOf("PATTERN_TYPE_APACHE_ANT") != -1) {
/*  31 */         source.setDecorated(new PathBasedFilterInvocationDefinitionMap());
/*     */ 
/*  33 */         if (logger.isDebugEnabled())
/*  34 */           logger.debug("Detected PATTERN_TYPE_APACHE_ANT directive; using Apache Ant style path expressions");
/*     */       }
/*     */       else
/*     */       {
/*  38 */         source.setDecorated(new HiRegExpBasedFilterInvocationDefinitionMap());
/*     */       }
/*     */ 
/*  41 */       if (s.lastIndexOf("CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON") != -1) {
/*  42 */         if (logger.isDebugEnabled()) {
/*  43 */           logger.debug("Detected CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON directive; Instructing mapper to convert URLs to lowercase before comparison");
/*     */         }
/*     */ 
/*  47 */         source.setConvertUrlToLowercaseBeforeComparison(true);
/*     */       }
/*     */ 
/*  50 */       BufferedReader br = new BufferedReader(new StringReader(s));
/*  51 */       int counter = 0;
/*     */ 
/*  54 */       List mappings = new ArrayList();
/*     */       while (true)
/*     */       {
/*  57 */         counter++;
/*     */         try
/*     */         {
/*  60 */           line = br.readLine();
/*     */         }
/*     */         catch (IOException ioe)
/*     */         {
/*     */           String line;
/*  62 */           throw new IllegalArgumentException(ioe.getMessage());
/*     */         }
/*     */ 
/*  65 */         if (line == null)
/*     */         {
/*     */           break;
/*     */         }
/*  69 */         String line = line.trim();
/*     */ 
/*  71 */         if (logger.isDebugEnabled()) {
/*  72 */           logger.debug("Line " + counter + ": " + line);
/*     */         }
/*     */ 
/*  75 */         if (line.startsWith("//"))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/*  80 */         if (line.lastIndexOf("CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON") != -1)
/*     */         {
/*  82 */           if ((line.lastIndexOf("PATTERN_TYPE_APACHE_ANT") != -1) || (line.lastIndexOf("=") != -1)) {
/*  83 */             throw new IllegalArgumentException("Line appears to be malformed: " + line);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  88 */         if (line.lastIndexOf("PATTERN_TYPE_APACHE_ANT") != -1)
/*     */         {
/*  90 */           if ((line.lastIndexOf("CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON") != -1) || 
/*  91 */             (line.lastIndexOf("=") != -1)) {
/*  92 */             throw new IllegalArgumentException("Line appears to be malformed: " + line);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  97 */         if (line.lastIndexOf('=') == -1)
/*     */         {
/*     */           continue;
/*     */         }
/* 101 */         if (line.lastIndexOf("==") != -1) {
/* 102 */           throw new IllegalArgumentException("Only single equals should be used in line " + line);
/*     */         }
/*     */ 
/* 107 */         String name = StringSplitUtils.substringBeforeLast(line, "=");
/* 108 */         String value = StringSplitUtils.substringAfterLast(line, "=");
/*     */ 
/* 110 */         if ((!StringUtils.hasText(name)) || (!StringUtils.hasText(value))) {
/* 111 */           throw new IllegalArgumentException("Failed to parse a valid name/value pair from " + line);
/*     */         }
/*     */ 
/* 115 */         if ((source.isConvertUrlToLowercaseBeforeComparison()) && 
/* 116 */           ((source.getDecorated() instanceof PathBasedFilterInvocationDefinitionMap)))
/*     */         {
/* 119 */           for (int i = 0; i < name.length(); i++) {
/* 120 */             String character = name.substring(i, i + 1);
/*     */ 
/* 122 */             if (!character.toLowerCase().equals(character)) {
/* 123 */               throw new IllegalArgumentException("You are using the CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON with Ant Paths, yet you have specified an uppercase character in line: " + 
/* 125 */                 line + 
/* 126 */                 " (character '" + character + "')");
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 131 */         FilterInvocationDefinitionSourceMapping mapping = new FilterInvocationDefinitionSourceMapping();
/* 132 */         mapping.setUrl(name);
/*     */ 
/* 134 */         String[] tokens = 
/* 135 */           StringUtils.commaDelimitedListToStringArray(value);
/*     */ 
/* 137 */         for (int i = 0; i < tokens.length; i++) {
/* 138 */           mapping.addConfigAttribute(tokens[i].trim());
/*     */         }
/*     */ 
/* 141 */         mappings.add(mapping);
/*     */       }
/*     */       String line;
/* 143 */       source.setMappings(mappings);
/*     */     }
/*     */ 
/* 146 */     setValue(source.getDecorated());
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.HiFilterInvocationDefinitionSourceEditor
 * JD-Core Version:    0.6.0
 */