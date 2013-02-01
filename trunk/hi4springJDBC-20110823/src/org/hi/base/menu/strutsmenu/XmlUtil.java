/*     */ package org.hi.base.menu.strutsmenu;
/*     */ 
/*     */ import java.beans.XMLDecoder;
/*     */ import java.beans.XMLEncoder;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class XmlUtil
/*     */ {
/*  27 */   private Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public String getXml(Object obj)
/*     */     throws Exception
/*     */   {
/*  36 */     String result = "";
/*  37 */     String pre = String.valueOf(System.currentTimeMillis());
/*  38 */     File tmp = null;
/*     */     try {
/*  40 */       tmp = File.createTempFile(pre, ".tmp");
/*  41 */       write(obj, tmp.getAbsolutePath());
/*  42 */       BufferedReader in = 
/*  43 */         new BufferedReader(new FileReader(tmp.getAbsolutePath()));
/*     */       String str;
/*  45 */       while ((str = in.readLine()) != null)
/*     */       {
/*     */         String str;
/*  46 */         result = result + str;
/*     */       }
/*  48 */       in.close();
/*     */     } catch (IOException e) {
/*  50 */       this.log.error(e, e);
/*     */       try
/*     */       {
/*  53 */         if (tmp != null)
/*  54 */           tmp.delete();
/*     */       }
/*     */       catch (RuntimeException localRuntimeException)
/*     */       {
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  53 */         if (tmp != null)
/*  54 */           tmp.delete();
/*     */       }
/*     */       catch (RuntimeException localRuntimeException1) {
/*     */       }
/*     */     }
/*  59 */     return result;
/*     */   }
/*     */ 
/*     */   public Object getObjFromXml(String xml)
/*     */     throws Exception
/*     */   {
/*  70 */     Object result = null;
/*  71 */     String pre = String.valueOf(System.currentTimeMillis());
/*  72 */     File tmp = null;
/*     */     try {
/*  74 */       tmp = File.createTempFile(pre, ".tmp");
/*     */ 
/*  76 */       BufferedWriter in = 
/*  77 */         new BufferedWriter(new FileWriter(tmp.getAbsolutePath()));
/*  78 */       in.write(xml);
/*  79 */       in.close();
/*  80 */       result = read(tmp.getAbsolutePath());
/*     */     } catch (IOException e) {
/*  82 */       this.log.error(e, e);
/*     */       try
/*     */       {
/*  85 */         if (tmp != null)
/*  86 */           tmp.delete();
/*     */       }
/*     */       catch (RuntimeException localRuntimeException)
/*     */       {
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  85 */         if (tmp != null)
/*  86 */           tmp.delete();
/*     */       }
/*     */       catch (RuntimeException localRuntimeException1) {
/*     */       }
/*     */     }
/*  91 */     return result;
/*     */   }
/*     */ 
/*     */   public void write(Object obj, String fileName)
/*     */     throws FileNotFoundException
/*     */   {
/*     */     try
/*     */     {
/* 103 */       dowrite(obj, new FileOutputStream(fileName));
/*     */     }
/*     */     catch (FileNotFoundException e) {
/* 106 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void dowrite(Object obj, OutputStream io) {
/* 111 */     XMLEncoder encoder = null;
/*     */     try
/*     */     {
/* 114 */       encoder = new XMLEncoder(io);
/* 115 */       encoder.writeObject(obj);
/*     */     } catch (Exception e) {
/* 117 */       this.log.error(e, e);
/*     */       try
/*     */       {
/* 120 */         if (encoder != null)
/* 121 */           encoder.close();
/*     */       }
/*     */       catch (Exception e1) {
/* 124 */         this.log.error(e1, e1);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 120 */         if (encoder != null)
/* 121 */           encoder.close();
/*     */       }
/*     */       catch (Exception e1) {
/* 124 */         this.log.error(e1, e1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object read(String fileName)
/*     */     throws FileNotFoundException
/*     */   {
/* 137 */     FileInputStream in = new FileInputStream(fileName);
/* 138 */     return read(in);
/*     */   }
/*     */ 
/*     */   public Object read(InputStream in) throws FileNotFoundException
/*     */   {
/* 143 */     XMLDecoder decoder = null;
/*     */     try
/*     */     {
/* 146 */       decoder = new XMLDecoder(in);
/*     */ 
/* 148 */       Object x = decoder.readObject();
/*     */ 
/* 150 */       Object localObject2 = x;
/*     */       return localObject2;
/*     */     } finally {
/*     */       try {
/* 153 */         if (decoder != null)
/* 154 */           decoder.close();
/*     */       }
/*     */       catch (Exception e1) {
/* 157 */         this.log.error(e1, e1);
/*     */       }
/*     */     }
/* 159 */     throw localObject1;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.XmlUtil
 * JD-Core Version:    0.6.0
 */