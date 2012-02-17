/*    */ package org.hi.generator.template;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.Map;
/*    */ 
/*    */ public abstract class TemplateHelp
/*    */ {
/*    */   private String templateRootDir;
/*    */   private String fileSuffix;
/*    */ 
/*    */   public abstract void process(String paramString, Writer paramWriter);
/*    */ 
/*    */   public abstract void process(String paramString1, String paramString2);
/*    */ 
/*    */   public abstract void put(String paramString, Object paramObject);
/*    */ 
/*    */   public abstract void put(Map<String, Object> paramMap);
/*    */ 
/*    */   public abstract void loadTemplateDir(String paramString)
/*    */     throws IOException;
/*    */ 
/*    */   public String getTemplateRootDir()
/*    */   {
/* 67 */     return this.templateRootDir;
/*    */   }
/*    */ 
/*    */   public void setTemplateRootDir(String templateRootDir)
/*    */   {
/* 75 */     this.templateRootDir = templateRootDir;
/*    */   }
/*    */ 
/*    */   public String getFileSuffix()
/*    */   {
/* 83 */     return this.fileSuffix;
/*    */   }
/*    */ 
/*    */   public void setFileSuffix(String fileSuffix)
/*    */   {
/* 91 */     this.fileSuffix = fileSuffix;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.template.TemplateHelp
 * JD-Core Version:    0.6.0
 */