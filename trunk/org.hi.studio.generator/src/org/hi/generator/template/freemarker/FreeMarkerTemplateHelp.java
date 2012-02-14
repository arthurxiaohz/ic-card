/*     */ package org.hi.generator.template.freemarker;
/*     */ 
/*     */ import freemarker.cache.FileTemplateLoader;
/*     */ import freemarker.cache.TemplateLoader;
/*     */ import freemarker.template.Configuration;
/*     */ import freemarker.template.SimpleHash;
/*     */ import freemarker.template.Template;
/*     */ import freemarker.template.TemplateException;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.io.Writer;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.generator.template.TemplateHelp;
/*     */ import org.hi.generator.template.TemplateHelpFactory;
/*     */ 
/*     */ public class FreeMarkerTemplateHelp extends TemplateHelp
/*     */ {
/*  39 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*  41 */   protected Configuration freeMarkerEngine = new Configuration();
/*  42 */   protected SimpleHash context = new SimpleHash();
/*     */ 
/*     */   public FreeMarkerTemplateHelp(String templateDir) {
/*  45 */     setTemplateRootDir(templateDir);
/*     */ 
/*  47 */     TemplateLoader loader = null;
/*     */     try {
/*  49 */       loader = new FileTemplateLoader(new File(templateDir));
/*     */     } catch (IOException localIOException) {
/*  51 */       this.log.error("not found template directory in " + templateDir);
/*     */     }
/*  53 */     this.freeMarkerEngine.setTemplateLoader(loader);
/*     */   }
/*     */ 
/*     */   public void process(String templetFilename, Writer writer)
/*     */   {
/*     */     try
/*     */     {
/*  62 */       Template template = this.freeMarkerEngine.getTemplate(templetFilename, TemplateHelpFactory.getTemplateFileEncoding());
/*  63 */       template.process(this.context, writer);
/*  64 */       writer.close();
/*     */     } catch (TemplateException e) {
/*  66 */       this.log.error("Problem pasre template file :" + templetFilename);
/*  67 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  69 */       this.log.error("not found template file:" + templetFilename);
/*  70 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void process(String templetFilename, String outputFilename) {
/*  75 */     Writer out = null;
/*     */     try {
/*  77 */       out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilename), TemplateHelpFactory.getTemplateFileEncoding()));
/*     */     } catch (UnsupportedEncodingException e) {
/*  79 */       this.log.error("Problem writer output  file :" + outputFilename);
/*  80 */       e.printStackTrace();
/*     */     } catch (FileNotFoundException e) {
/*  82 */       this.log.error("not found output  file:" + outputFilename);
/*  83 */       e.printStackTrace();
/*     */     }
/*  85 */     process(templetFilename, out);
/*     */   }
/*     */ 
/*     */   public void put(String key, Object value)
/*     */   {
/*  92 */     if ((value instanceof Map)) {
/*  93 */       value = new SimpleHash((Map)value);
/*     */     }
/*  95 */     this.context.put(key, value);
/*     */   }
/*     */ 
/*     */   public void loadTemplateDir(String templateDir)
/*     */     throws IOException
/*     */   {
/* 102 */     this.freeMarkerEngine.setDirectoryForTemplateLoading(new File(templateDir));
/*     */   }
/*     */ 
/*     */   public void put(Map<String, Object> map)
/*     */   {
/* 110 */     if (map == null) {
/* 111 */       return;
/*     */     }
/* 113 */     Set keySet = map.keySet();
/* 114 */     for (Iterator i = keySet.iterator(); i.hasNext(); ) {
/* 115 */       String key = (String)i.next();
/* 116 */       this.context.put(key, map.get(key));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.template.freemarker.FreeMarkerTemplateHelp
 * JD-Core Version:    0.6.0
 */