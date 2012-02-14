/*     */ package org.hi.studio.core.utils;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ 
/*     */ public class FileUtil
/*     */ {
/*     */   public static void copyDirectory(String sourceDirName, String destinationDirName)
/*     */     throws Exception
/*     */   {
/*  50 */     copyDirectory(new File(sourceDirName), new File(destinationDirName));
/*     */   }
/*     */ 
/*     */   public static void copyDirectory(File source, File destination)
/*     */     throws Exception
/*     */   {
/*  58 */     if ((source.exists()) && (source.isDirectory())) {
/*  59 */       if (!destination.exists())
/*  60 */         destination.mkdirs();
/*  61 */       File[] fileArray = source.listFiles();
/*  62 */       for (int i = 0; i < fileArray.length; i++)
/*  63 */         if (fileArray[i].isDirectory())
/*  64 */           copyDirectory(fileArray[i], 
/*  65 */             new File(destination.getPath() + 
/*  65 */             File.separator + fileArray[i].getName()));
/*     */         else
/*  67 */           copyFile(fileArray[i], 
/*  68 */             new File(destination.getPath() + 
/*  68 */             File.separator + fileArray[i].getName()));
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void deltree(String directory)
/*     */   {
/*  77 */     deltree(new File(directory));
/*     */   }
/*     */ 
/*     */   public static void deltree(File directory)
/*     */   {
/*  84 */     if ((directory.exists()) && (directory.isDirectory())) {
/*  85 */       File[] fileArray = directory.listFiles();
/*  86 */       for (int i = 0; i < fileArray.length; i++) {
/*  87 */         if (fileArray[i].isDirectory())
/*  88 */           deltree(fileArray[i]);
/*     */         else
/*  90 */           fileArray[i].delete();
/*     */       }
/*  92 */       directory.delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String getPath(String fullFileName)
/*     */   {
/* 100 */     int pos = fullFileName.lastIndexOf("/");
/* 101 */     if (pos == -1)
/* 102 */       pos = fullFileName.lastIndexOf("\\");
/* 103 */     String shortFileName = fullFileName.substring(0, pos);
/* 104 */     return shortFileName;
/*     */   }
/*     */ 
/*     */   public static String getShortFileName(String fullFileName)
/*     */   {
/* 111 */     int pos = fullFileName.lastIndexOf("/");
/* 112 */     if (pos == -1)
/* 113 */       pos = fullFileName.lastIndexOf("\\");
/* 114 */     String shortFileName = fullFileName.substring(pos + 1, fullFileName
/* 115 */       .length());
/* 116 */     return shortFileName;
/*     */   }
/*     */ 
/*     */   public static boolean exists(String fileName)
/*     */   {
/* 123 */     File file = new File(fileName);
/* 124 */     return file.exists();
/*     */   }
/*     */ 
/*     */   public static String[] listDirs(String fileName)
/*     */     throws IOException
/*     */   {
/* 131 */     return listDirs(new File(fileName));
/*     */   }
/*     */ 
/*     */   public static String[] listDirs(File file)
/*     */     throws IOException
/*     */   {
/* 138 */     List dirs = new ArrayList();
/* 139 */     File[] fileArray = file.listFiles();
/* 140 */     for (int i = 0; i < fileArray.length; i++) {
/* 141 */       if (fileArray[i].isDirectory())
/* 142 */         dirs.add(fileArray[i].getName());
/*     */     }
/* 144 */     return (String[])dirs.toArray(new String[0]);
/*     */   }
/*     */ 
/*     */   public static String[] listFiles(String fileName)
/*     */     throws IOException
/*     */   {
/* 151 */     return listFiles(new File(fileName));
/*     */   }
/*     */ 
/*     */   public static String[] listFiles(File file)
/*     */     throws IOException
/*     */   {
/* 158 */     List files = new ArrayList();
/* 159 */     File[] fileArray = file.listFiles();
/* 160 */     for (int i = 0; i < fileArray.length; i++) {
/* 161 */       if (fileArray[i].isFile())
/* 162 */         files.add(fileArray[i].getName());
/*     */     }
/* 164 */     return (String[])files.toArray(new String[0]);
/*     */   }
/*     */ 
/*     */   public static void mkdirs(String pathName)
/*     */   {
/* 171 */     File file = new File(pathName);
/* 172 */     if (!file.exists())
/* 173 */       file.mkdirs();
/*     */   }
/*     */ 
/*     */   public static String read(String fileName)
/*     */     throws IOException
/*     */   {
/* 180 */     return read(new File(fileName));
/*     */   }
/*     */ 
/*     */   public static String read(File file)
/*     */     throws IOException
/*     */   {
/* 187 */     BufferedReader br = new BufferedReader(new FileReader(file));
/* 188 */     StringBuffer sb = new StringBuffer();
/* 189 */     for (String line = null; (line = br.readLine()) != null; ) {
/* 190 */       sb.append(line).append('\n');
/*     */     }
/* 192 */     br.close();
/* 193 */     return sb.toString().trim();
/*     */   }
/*     */ 
/*     */   public static String readByEncoding(String fileName, String encoding)
/*     */     throws IOException
/*     */   {
/* 201 */     return readByEncoding(new File(fileName), encoding);
/*     */   }
/*     */ 
/*     */   public static String readByEncoding(File file, String encoding)
/*     */     throws IOException
/*     */   {
/* 209 */     InputStreamReader br = new InputStreamReader(new FileInputStream(file), 
/* 210 */       encoding);
/* 211 */     FileInputStream fis = new FileInputStream(file);
/* 212 */     char[] strings = new char[fis.available()];
/* 213 */     new StringBuffer();
/*     */ 
/* 215 */     br.read(strings);
/* 216 */     br.close();
/* 217 */     String returnString = new String(strings);
/* 218 */     return returnString.trim();
/*     */   }
/*     */ 
/*     */   public static void writeByEncoding(File file, String s, String encoding)
/*     */     throws IOException
/*     */   {
/* 226 */     if (file.getParent() != null)
/* 227 */       mkdirs(file.getParent());
/* 228 */     OutputStreamWriter bw = new OutputStreamWriter(
/* 229 */       new FileOutputStream(file), encoding);
/* 230 */     bw.flush();
/* 231 */     bw.write(s);
/* 232 */     bw.close();
/*     */   }
/*     */ 
/*     */   public static void writeByEncoding(String fileName, String s, String encoding)
/*     */     throws IOException
/*     */   {
/* 240 */     writeByEncoding(new File(fileName), s, encoding); } 
/*     */   // ERROR //
/*     */   public static void writeString2FileForJspDesigner(String content, File file) throws Exception { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ifnonnull +6 -> 7
/*     */     //   4: ldc 240
/*     */     //   6: astore_0
/*     */     //   7: aconst_null
/*     */     //   8: astore_2
/*     */     //   9: aload_1
/*     */     //   10: invokevirtual 30	java/io/File:exists	()Z
/*     */     //   13: ifne +14 -> 27
/*     */     //   16: aload_1
/*     */     //   17: invokevirtual 242	java/io/File:createNewFile	()Z
/*     */     //   20: pop
/*     */     //   21: aload_1
/*     */     //   22: aload_1
/*     */     //   23: invokevirtual 245	java/io/File:renameTo	(Ljava/io/File;)Z
/*     */     //   26: pop
/*     */     //   27: new 219	java/io/FileOutputStream
/*     */     //   30: dup
/*     */     //   31: aload_1
/*     */     //   32: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
/*     */     //   35: astore_2
/*     */     //   36: new 249	java/io/ByteArrayInputStream
/*     */     //   39: dup
/*     */     //   40: aload_0
/*     */     //   41: invokevirtual 251	java/lang/String:getBytes	()[B
/*     */     //   44: invokespecial 255	java/io/ByteArrayInputStream:<init>	([B)V
/*     */     //   47: astore_3
/*     */     //   48: sipush 1024
/*     */     //   51: newarray byte
/*     */     //   53: astore 4
/*     */     //   55: aload_3
/*     */     //   56: aload 4
/*     */     //   58: invokevirtual 258	java/io/ByteArrayInputStream:read	([B)I
/*     */     //   61: istore 5
/*     */     //   63: iload 5
/*     */     //   65: iconst_m1
/*     */     //   66: if_icmpne +6 -> 72
/*     */     //   69: goto +46 -> 115
/*     */     //   72: aload_2
/*     */     //   73: aload 4
/*     */     //   75: iconst_0
/*     */     //   76: iload 5
/*     */     //   78: invokevirtual 261	java/io/FileOutputStream:write	([BII)V
/*     */     //   81: aload_2
/*     */     //   82: invokevirtual 264	java/io/FileOutputStream:flush	()V
/*     */     //   85: goto -30 -> 55
/*     */     //   88: astore_3
/*     */     //   89: new 17	java/lang/Exception
/*     */     //   92: dup
/*     */     //   93: aload_3
/*     */     //   94: invokespecial 265	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
/*     */     //   97: athrow
/*     */     //   98: astore 6
/*     */     //   100: aload_2
/*     */     //   101: ifnull +11 -> 112
/*     */     //   104: aload_2
/*     */     //   105: invokevirtual 268	java/io/FileOutputStream:close	()V
/*     */     //   108: goto +4 -> 112
/*     */     //   111: pop
/*     */     //   112: aload 6
/*     */     //   114: athrow
/*     */     //   115: aload_2
/*     */     //   116: ifnull +11 -> 127
/*     */     //   119: aload_2
/*     */     //   120: invokevirtual 268	java/io/FileOutputStream:close	()V
/*     */     //   123: goto +4 -> 127
/*     */     //   126: pop
/*     */     //   127: return
/*     */     //
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   9	88	88	java/lang/Exception
/*     */     //   9	98	98	finally
/*     */     //   104	108	111	java/lang/Exception
/*     */     //   119	123	126	java/lang/Exception } 
/* 280 */   public static void copyFile(File source, File destination) { if (!source.exists()) {
/* 281 */       return;
/*     */     }
/*     */ 
/* 284 */     if ((destination.getParentFile() != null) && 
/* 285 */       (!destination.getParentFile().exists()))
/*     */     {
/* 287 */       destination.getParentFile().mkdirs();
/*     */     }
/*     */     try
/*     */     {
/* 291 */       FileInputStream fis = new FileInputStream(source);
/* 292 */       FileOutputStream fos = new FileOutputStream(destination);
/*     */ 
/* 294 */       byte[] buffer = new byte[4096];
/* 295 */       int n = 0;
/*     */ 
/* 297 */       while ((n = fis.read(buffer)) != -1) {
/* 298 */         fos.write(buffer, 0, n);
/*     */       }
/*     */ 
/* 301 */       fis.close();
/* 302 */       fos.close();
/*     */     } catch (Exception e) {
/* 304 */       ExceptionManager.logError(e, "");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyFile(String sourceFileName, String destinationFileName)
/*     */   {
/* 316 */     copyFile(new File(sourceFileName), new File(destinationFileName));
/*     */   }
/*     */ 
/*     */   public static boolean fileExisted(String strFullPath)
/*     */   {
/* 323 */     if (strFullPath == null) {
/* 324 */       return false;
/*     */     }
/* 326 */     return new File(strFullPath).exists();
/*     */   }
/*     */ 
/*     */   public static List getChildFileByExtension(File fileFolder, String extension)
/*     */   {
/* 338 */     List listFile = new ArrayList();
/* 339 */     if (fileFolder.isDirectory()) {
/* 340 */       File[] files = fileFolder.listFiles();
/* 341 */       for (int i = 0; i < files.length; i++) {
/* 342 */         listFile.addAll(getChildFileByExtension(files[i], extension));
/*     */       }
/*     */ 
/*     */     }
/* 346 */     else if (fileFolder.getName().endsWith("." + extension)) {
/* 347 */       listFile.add(fileFolder.getAbsolutePath());
/*     */     }
/*     */ 
/* 354 */     return listFile;
/*     */   }
/*     */ 
/*     */   public static List getChildFileByExtension(String fileFolder, String extension)
/*     */   {
/* 359 */     return getChildFileByExtension(new File(fileFolder), extension);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.utils.FileUtil
 * JD-Core Version:    0.6.0
 */