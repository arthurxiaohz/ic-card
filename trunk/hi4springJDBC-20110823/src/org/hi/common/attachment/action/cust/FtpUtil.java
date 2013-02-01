/*     */ package org.hi.common.attachment.action.cust;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import sun.net.TelnetInputStream;
/*     */ import sun.net.TelnetOutputStream;
/*     */ import sun.net.ftp.FtpClient;
/*     */ 
/*     */ public class FtpUtil
/*     */ {
/*  25 */   FtpClient ftpClient = null;
/*     */ 
/*  30 */   private String ftpip = HiConfigHolder.getProperty("hi.upload.ftp.ip");
/*     */ 
/*  34 */   private String ftpUser = HiConfigHolder.getProperty("hi.upload.ftp.userName");
/*     */ 
/*  38 */   private String ftpPassword = HiConfigHolder.getProperty("hi.upload.ftp.password");
/*     */ 
/*  42 */   private String ftpRoot = HiConfigHolder.getProperty("hi.upload.ftp.root");
/*     */ 
/*     */   public void connectServer() throws IOException
/*     */   {
/*  46 */     connectServer(this.ftpip, this.ftpUser, this.ftpPassword, this.ftpRoot);
/*     */   }
/*     */ 
/*     */   public String saveFile(File file, String fileName, String moduleName, String contextPath)
/*     */     throws IOException
/*     */   {
/*  58 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*     */     String prefix;
/*     */     String prefix;
/*  60 */     if (contextPath == null)
/*  61 */       prefix = org.hi.framework.web.ServletContext.getServletContext().getRealPath("/");
/*     */     else {
/*  63 */       prefix = contextPath;
/*     */     }
/*  65 */     String contextFilePath = HiConfigHolder.getRootUpload() + "/" + 
/*  66 */       moduleName + "/" + formatter.format(new Date()) + 
/*  67 */       "/";
/*  68 */     String filePath = prefix + "/" + contextFilePath;
/*  69 */     String formatedFileName = formatFileName(filePath, fileName);
/*     */ 
/*  71 */     File dest = new File(filePath + formatedFileName);
/*     */ 
/*  73 */     FileUtils.copyFile(file, dest);
/*     */ 
/*  75 */     return contextFilePath + formatedFileName;
/*     */   }
/*     */ 
/*     */   private String formatFileName(String filePath, String fileName)
/*     */   {
/*  85 */     String preName = "";
/*  86 */     String extName = "";
/*  87 */     String formatedFielName = fileName;
/*  88 */     if (fileName.indexOf(".") < 0) {
/*  89 */       preName = fileName;
/*     */     }
/*     */     else {
/*  92 */       preName = fileName.substring(0, fileName.lastIndexOf("."));
/*  93 */       extName = fileName.substring(fileName.lastIndexOf("."));
/*     */     }
/*  95 */     int i = 1;
/*  96 */     File file = new File(filePath + fileName);
/*  97 */     while (file.exists())
/*     */     {
/*  99 */       formatedFielName = preName + "(" + i + ")" + extName;
/* 100 */       i++;
/* 101 */       file = new File(filePath + formatedFielName);
/*     */     }
/*     */ 
/* 105 */     return formatedFielName;
/*     */   }
/*     */ 
/*     */   public String saveInputStream(InputStream inputStream, String fileName, String moduleName, String contextPath)
/*     */     throws IOException
/*     */   {
/* 119 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*     */     String prefix;
/*     */     String prefix;
/* 121 */     if (contextPath == null)
/* 122 */       prefix = org.hi.framework.web.ServletContext.getServletContext().getRealPath("/");
/*     */     else {
/* 124 */       prefix = contextPath;
/*     */     }
/*     */ 
/* 127 */     String contextFilePath = HiConfigHolder.getRootUpload() + "/" + 
/* 128 */       moduleName + "/" + formatter.format(new Date()) + 
/* 129 */       "/";
/* 130 */     String filePath = prefix + "/" + contextFilePath;
/* 131 */     String formatedFileName = formatFileName(filePath, fileName);
/*     */ 
/* 134 */     File dest = new File(filePath + formatedFileName);
/*     */ 
/* 136 */     File forder = new File(filePath);
/* 137 */     if (!forder.exists()) {
/* 138 */       forder.mkdirs();
/*     */     }
/*     */ 
/* 142 */     FileOutputStream fileoutputstream = new FileOutputStream(dest);
/* 143 */     byte[] ba = (byte[])null;
/* 144 */     int length = inputStream.available();
/*     */ 
/* 146 */     ba = new byte[length];
/* 147 */     inputStream.read(ba);
/*     */ 
/* 150 */     fileoutputstream.write(ba);
/* 151 */     fileoutputstream.close();
/*     */ 
/* 153 */     return contextFilePath + formatedFileName;
/*     */   }
/*     */ 
/*     */   public String saveInputStreamToFTP(InputStream inputStream, String fileName, String moduleName)
/*     */     throws IOException
/*     */   {
/* 166 */     if ((moduleName == null) || (moduleName.equals(""))) {
/* 167 */       moduleName = "common";
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 172 */       connectServer(this.ftpip, this.ftpUser, this.ftpPassword, this.ftpRoot);
/*     */ 
/* 174 */       fileName = uploadIS(inputStream, moduleName, fileName);
/*     */     }
/*     */     catch (IOException e) {
/* 177 */       throw e;
/*     */     }
/*     */     finally {
/* 180 */       closeServer();
/*     */     }
/*     */ 
/* 183 */     return moduleName + "/" + fileName;
/*     */   }
/*     */ 
/*     */   public String uploadIS(InputStream is, String path, String filename)
/*     */     throws IOException
/*     */   {
/* 199 */     String newFileName = filename;
/* 200 */     TelnetOutputStream os = null;
/*     */     try {
/* 202 */       isDirExist(path);
/* 203 */       newFileName = formatFTPFileName(path, filename);
/* 204 */       os = this.ftpClient.put(newFileName);
/* 205 */       byte[] bytes = new byte[1024];
/*     */       int c;
/* 207 */       while ((c = is.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/* 208 */         os.write(bytes, 0, c);
/*     */       }
/*     */     } finally {
/* 211 */       if (is != null) {
/* 212 */         is.close();
/*     */       }
/* 214 */       if (os != null) {
/* 215 */         os.close();
/*     */       }
/*     */     }
/* 218 */     return newFileName;
/*     */   }
/*     */ 
/*     */   public String saveFile(File file, String fileName, String moduleName)
/*     */     throws IOException
/*     */   {
/* 232 */     return saveFile(file, fileName, moduleName, null);
/*     */   }
/*     */ 
/*     */   public String saveFileToFTP(File file, String fileName, String moduleName)
/*     */     throws IOException
/*     */   {
/* 244 */     if ((moduleName == null) || (moduleName.equals(""))) {
/* 245 */       moduleName = "common";
/*     */     }
/*     */     try
/*     */     {
/* 249 */       connectServer(this.ftpip, this.ftpUser, this.ftpPassword, this.ftpRoot);
/*     */ 
/* 251 */       fileName = upload(file, moduleName, fileName);
/*     */     }
/*     */     catch (IOException e) {
/* 254 */       throw e;
/*     */     }
/*     */     finally {
/* 257 */       closeServer();
/*     */     }
/*     */ 
/* 260 */     return moduleName + "/" + fileName;
/*     */   }
/*     */ 
/*     */   public File ftpDownload(String path)
/*     */     throws IOException
/*     */   {
/* 271 */     File file = new File("tempfile/" + new Date().getTime());
/* 272 */     FtpUtil ftp = new FtpUtil();
/*     */     try
/*     */     {
/* 276 */       ftp.connectServer(this.ftpip, this.ftpUser, this.ftpPassword, this.ftpRoot);
/*     */ 
/* 278 */       ftp.download(path, file);
/*     */     }
/*     */     catch (IOException e) {
/* 281 */       throw e;
/*     */     }
/*     */     finally {
/* 284 */       ftp.closeServer();
/*     */     }
/*     */ 
/* 287 */     return file;
/*     */   }
/*     */ 
/*     */   public void connectServer(String server, String user, String password, String path)
/*     */     throws IOException
/*     */   {
/* 307 */     this.ftpClient = new FtpClient();
/* 308 */     this.ftpClient.openServer(server);
/* 309 */     this.ftpClient.login(user, password);
/*     */ 
/* 311 */     if (path.length() != 0) this.ftpClient.cd(path);
/*     */ 
/* 313 */     this.ftpClient.binary();
/*     */   }
/*     */ 
/*     */   private void isDirExist(String dir)
/*     */   {
/*     */     try
/*     */     {
/* 321 */       this.ftpClient.cd(dir);
/*     */     }
/*     */     catch (IOException e1) {
/* 324 */       this.ftpClient.sendServer("MKD " + dir + "\r\n");
/*     */       try
/*     */       {
/* 327 */         this.ftpClient.readServerResponse();
/* 328 */         this.ftpClient.cd(dir);
/*     */       }
/*     */       catch (IOException e) {
/* 331 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String upload(File file_in, String path, String fileName)
/*     */     throws IOException
/*     */   {
/* 350 */     String newFileName = fileName;
/* 351 */     TelnetOutputStream os = null;
/* 352 */     FileInputStream is = null;
/*     */     try {
/* 354 */       if (!file_in.exists());
/*     */       do
/*     */         return "";
/* 355 */       while (file_in.length() == 0L);
/* 356 */       isDirExist(path);
/* 357 */       newFileName = formatFTPFileName(path, fileName);
/* 358 */       os = this.ftpClient.put(newFileName);
/* 359 */       is = new FileInputStream(file_in);
/* 360 */       byte[] bytes = new byte[1024];
/*     */       int c;
/* 362 */       while ((c = is.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/* 363 */         os.write(bytes, 0, c);
/*     */       }
/*     */     } finally {
/* 366 */       if (is != null) {
/* 367 */         is.close();
/*     */       }
/* 369 */       if (os != null)
/* 370 */         os.close();
/*     */     }
/* 366 */     if (is != null) {
/* 367 */       is.close();
/*     */     }
/* 369 */     if (os != null) {
/* 370 */       os.close();
/*     */     }
/*     */ 
/* 373 */     return newFileName;
/*     */   }
/*     */ 
/*     */   private String formatFTPFileName(String path, String fileName)
/*     */   {
/* 383 */     String preName = "";
/* 384 */     String extName = "";
/* 385 */     String formatedFielName = fileName;
/*     */ 
/* 387 */     if (fileName.indexOf(".") < 0) {
/* 388 */       preName = fileName;
/*     */     }
/*     */     else {
/* 391 */       preName = fileName.substring(0, fileName.lastIndexOf("."));
/* 392 */       extName = fileName.substring(fileName.lastIndexOf("."));
/*     */     }
/* 394 */     List fileList = getFileList(path);
/* 395 */     int i = 1;
/*     */ 
/* 397 */     while ((fileList != null) && (fileList.contains(formatedFielName)))
/*     */     {
/* 399 */       formatedFielName = preName + "(" + i + ")" + extName;
/* 400 */       i++;
/*     */     }
/*     */ 
/* 403 */     return formatedFielName;
/*     */   }
/*     */ 
/*     */   public String upload(File file)
/*     */     throws Exception
/*     */   {
/* 415 */     String newname = "";
/*     */ 
/* 417 */     return upload(file, "", newname);
/*     */   }
/*     */ 
/*     */   public OutputStream download(String filename, File outfile)
/*     */     throws IOException
/*     */   {
/* 431 */     long result = 0L;
/* 432 */     TelnetInputStream is = null;
/* 433 */     ByteArrayOutputStream byteos = null;
/*     */     try
/*     */     {
/* 437 */       is = this.ftpClient.get(filename);
/* 438 */       byteos = new ByteArrayOutputStream();
/*     */ 
/* 440 */       byte[] bytes = new byte[1024];
/*     */       int c;
/* 442 */       while ((c = is.read(bytes)) != -1)
/*     */       {
/*     */         int c;
/* 443 */         byteos.write(bytes, 0, c);
/* 444 */         result += c;
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 448 */       e.printStackTrace();
/*     */     }
/*     */     finally {
/* 451 */       if (is != null) {
/* 452 */         is.close();
/*     */       }
/*     */     }
/*     */ 
/* 456 */     return byteos;
/*     */   }
/*     */ 
/*     */   public List getFileList(String path)
/*     */   {
/* 464 */     List list = new ArrayList();
/*     */     try
/*     */     {
/* 467 */       DataInputStream dis = new DataInputStream(this.ftpClient.nameList(path));
/* 468 */       String filename = "";
/* 469 */       while ((filename = dis.readLine()) != null)
/*     */       {
/* 471 */         list.add(filename);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 476 */       e.printStackTrace();
/*     */     }
/* 478 */     return list;
/*     */   }
/*     */ 
/*     */   public void closeServer()
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 491 */       if (this.ftpClient != null)
/*     */       {
/* 493 */         this.ftpClient.closeServer();
/*     */       }
/*     */     } catch (IOException e) {
/* 496 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.attachment.action.cust.FtpUtil
 * JD-Core Version:    0.6.0
 */