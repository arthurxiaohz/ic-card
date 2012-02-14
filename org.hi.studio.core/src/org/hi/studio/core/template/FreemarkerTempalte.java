/*    */ package org.hi.studio.core.template;
/*    */ 
/*    */ import freemarker.template.Configuration;
/*    */ import freemarker.template.Template;
/*    */ import freemarker.template.TemplateException;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class FreemarkerTempalte
/*    */   implements TemplateHelp
/*    */ {
/* 15 */   private Configuration config = new Configuration();
/* 16 */   private Map valueMap = new HashMap();
/* 17 */   private String encoding = "UTF-8";
/*    */ 
/* 19 */   public FreemarkerTempalte() { if (this.config != null)
/* 20 */       this.config.setDefaultEncoding("UTF-8"); }
/*    */ 
/*    */   public void process(String templateFile, Writer writer)
/*    */   {
/*    */     try {
/* 25 */       Template freemarkTemplate = this.config.getTemplate(templateFile, getEncoding());
/* 26 */       freemarkTemplate.process(this.valueMap, writer);
/*    */     } catch (IOException e) {
/* 28 */       e.printStackTrace();
/*    */     } catch (TemplateException e) {
/* 30 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setTemplateDir(String tempateDir)
/*    */   {
/*    */     try
/*    */     {
/* 38 */       if (this.config != null)
/* 39 */         this.config.setDirectoryForTemplateLoading(new File(tempateDir));
/*    */     } catch (IOException e) {
/* 41 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void put(Object obj1, Object obj2) {
/* 46 */     this.valueMap.put(obj1, obj2);
/*    */   }
/*    */ 
/*    */   public void setMap(Map valueMap) {
/* 50 */     this.valueMap = valueMap;
/*    */   }
/*    */ 
/*    */   public String getTemplateDir()
/*    */   {
/* 55 */     return null;
/*    */   }
/*    */   public String getEncoding() {
/* 58 */     return this.encoding;
/*    */   }
/*    */   public void setEncoding(String encoding) {
/* 61 */     this.encoding = encoding;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.template.FreemarkerTempalte
 * JD-Core Version:    0.6.0
 */