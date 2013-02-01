/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ 
/*     */ public class FileUtil
/*     */ {
/*     */   public static void copyFile(File in, File out)
/*     */     throws IOException
/*     */   {
/*  21 */     FileInputStream fis = new FileInputStream(in);
/*  22 */     FileOutputStream fos = new FileOutputStream(out);
/*  23 */     byte[] buf = new byte[1024];
/*  24 */     int i = 0;
/*  25 */     while ((i = fis.read(buf)) != -1) {
/*  26 */       fos.write(buf, 0, i);
/*     */     }
/*  28 */     fis.close();
/*  29 */     fos.close();
/*     */   }
/*     */ 
/*     */   public static String fileToStr(File in)
/*     */     throws IOException
/*     */   {
/*  38 */     FileInputStream fis = new FileInputStream(in);
/*  39 */     String outStr = "";
/*  40 */     byte[] buf = new byte[(int)in.length()];
/*  41 */     int i = 0;
/*  42 */     while ((i = fis.read(buf)) != -1) {
/*  43 */       outStr = outStr + new String(buf, "utf-8");
/*     */     }
/*  45 */     fis.close();
/*  46 */     return outStr;
/*     */   }
/*     */ 
/*     */   public static String fileToStr(String in)
/*     */     throws IOException
/*     */   {
/*  55 */     return fileToStr(new File(in));
/*     */   }
/*     */ 
/*     */   public static List fileToList(String fileName)
/*     */     throws IOException
/*     */   {
/*  66 */     File file = new File(fileName);
/*  67 */     return fileToList(file);
/*     */   }
/*     */ 
/*     */   public static List fileToList(File file)
/*     */     throws IOException
/*     */   {
/*  78 */     List list = new ArrayList();
/*     */ 
/*  80 */     FileReader fileread = new FileReader(file);
/*  81 */     BufferedReader bufread = new BufferedReader(fileread);
/*  82 */     int counter = 0;
/*     */     String read;
/*  83 */     while ((read = bufread.readLine()) != null)
/*     */     {
/*     */       String read;
/*  85 */       if (!read.equals(""))
/*  86 */         list.add(read);
/*     */     }
/*  88 */     return list;
/*     */   }
/*     */ 
/*     */   public static Properties getProperties(String propertiesFile)
/*     */   {
/*  93 */     Properties props = new Properties();
/*  94 */     InputStream is = null;
/*     */     try {
/*  96 */       is = new FileInputStream(propertiesFile);
/*  97 */       getProperties(is);
/*     */     }
/*     */     catch (Exception ex) {
/* 100 */       ex.printStackTrace();
/*     */     }
/* 102 */     return props;
/*     */   }
/*     */ 
/*     */   public static Properties getProperties(InputStream in) {
/* 106 */     Properties props = new Properties();
/*     */     try {
/* 108 */       props.load(in);
/*     */     }
/*     */     catch (Exception ex) {
/* 111 */       ex.printStackTrace();
/*     */     }
/* 113 */     return props;
/*     */   }
/*     */ 
/*     */   public static void createDir(String dir) {
/* 117 */     File outputDirFile = new File(dir);
/* 118 */     if (!outputDirFile.exists())
/* 119 */       outputDirFile.mkdirs();
/*     */   }
/*     */ 
/*     */   public static boolean exists(String filePath) {
/* 123 */     File filePathFile = new File(filePath);
/* 124 */     return filePathFile.exists();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.FileUtil
 * JD-Core Version:    0.6.0
 */