/*    */ package org.hi.studio.generator.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class FileUtil
/*    */ {
/*    */   public static void createDir(String dir)
/*    */   {
/*  7 */     File outputDirFile = new File(dir);
/*  8 */     if (!outputDirFile.exists())
/*  9 */       outputDirFile.mkdirs();
/*    */   }
/*    */ 
/*    */   public static boolean exists(String filePath) {
/* 13 */     File filePathFile = new File(filePath);
/* 14 */     return filePathFile.exists();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.utils.FileUtil
 * JD-Core Version:    0.6.0
 */