/*    */ package org.hi.studio.core.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import org.hi.studio.core.template.TemplateHelp;
/*    */ 
/*    */ public class TemplateUtil
/*    */ {
/*    */   public static void batchGenerator(TemplateHelp template, String sourcePath, String targetPath)
/*    */     throws Exception
/*    */   {
/* 12 */     File source = new File(sourcePath);
/* 13 */     if ((source.exists()) && (source.isDirectory())) {
/* 14 */       File[] fileArray = source.listFiles();
/* 15 */       for (File file : fileArray)
/* 16 */         if (!file.isDirectory()) {
/* 17 */           FileWriter writer = new FileWriter(new File(targetPath + "/" + file.getName()));
/* 18 */           template.process(file.getName(), writer);
/*    */         }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.utils.TemplateUtil
 * JD-Core Version:    0.6.0
 */