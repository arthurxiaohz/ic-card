/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import javax.xml.bind.Marshaller;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.xml.serialize.OutputFormat;
/*     */ import org.apache.xml.serialize.XMLSerializer;
/*     */ 
/*     */ public class JAXBUtil
/*     */ {
/*  25 */   protected static final Log log = LogFactory.getLog("org.hi.common.util.JAXBUtil");
/*     */ 
/*     */   public static Object loadObect(Class clzz, String fileName) throws JAXBException, FileNotFoundException
/*     */   {
/*  29 */     JAXBContext jc = JAXBContext.newInstance(clzz.getPackage().getName(), clzz.getClassLoader());
/*  30 */     Unmarshaller u = jc.createUnmarshaller();
/*     */     try
/*     */     {
/*  33 */       obj = u.unmarshal(new FileInputStream(fileName));
/*     */     }
/*     */     catch (FileNotFoundException e)
/*     */     {
/*     */       Object obj;
/*  35 */       log.error("not found xml file  in " + fileName);
/*  36 */       throw e;
/*     */     }
/*     */     Object obj;
/*  38 */     return obj;
/*     */   }
/*     */ 
/*     */   public static Object loadObect(Class clzz, InputStream inputStream) throws JAXBException
/*     */   {
/*  43 */     JAXBContext jc = JAXBContext.newInstance(clzz.getPackage().getName(), clzz.getClassLoader());
/*  44 */     Unmarshaller u = jc.createUnmarshaller();
/*     */ 
/*  46 */     Object obj = u.unmarshal(inputStream);
/*  47 */     return obj;
/*     */   }
/*     */ 
/*     */   public static Object loadObect(Class clzz, Reader reader) throws JAXBException
/*     */   {
/*  52 */     JAXBContext jc = JAXBContext.newInstance(clzz.getPackage().getName(), clzz.getClassLoader());
/*  53 */     Unmarshaller u = jc.createUnmarshaller();
/*     */ 
/*  55 */     Object obj = u.unmarshal(reader);
/*  56 */     return obj;
/*     */   }
/*     */ 
/*     */   public static File writeObject(Class clzz, Object obj, String fileName) throws JAXBException, IOException {
/*  60 */     return writeObject(clzz, obj, fileName, null);
/*     */   }
/*     */ 
/*     */   public static File writeObject(Class clzz, Object obj, String fileName, String[] cDatas) throws JAXBException, IOException {
/*  64 */     File f = new File(fileName);
/*     */ 
/*  66 */     JAXBContext context = JAXBContext.newInstance(clzz.getPackage().getName(), clzz.getClassLoader());
/*  67 */     Marshaller m = context.createMarshaller();
/*     */ 
/*  69 */     m.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*     */ 
/*  71 */     if (cDatas != null) {
/*  72 */       XMLSerializer serializer = getXMLSerializer(cDatas, f);
/*  73 */       m.marshal(obj, serializer.asContentHandler());
/*     */     }
/*     */     else {
/*  76 */       m.marshal(obj, f);
/*  77 */     }return f;
/*     */   }
/*     */ 
/*     */   public static OutputStream toOutputStream(Class clzz, Object obj, OutputStream os) throws JAXBException, IOException {
/*  81 */     return toOutputStream(clzz, obj, null);
/*     */   }
/*     */ 
/*     */   public static OutputStream toOutputStream(Class clzz, Object obj, OutputStream os, String[] cDatas) throws JAXBException, IOException {
/*  85 */     if (os == null) {
/*  86 */       os = new BufferedOutputStream(System.out);
/*     */     }
/*  88 */     JAXBContext context = JAXBContext.newInstance(clzz.getPackage().getName(), clzz.getClassLoader());
/*  89 */     Marshaller m = context.createMarshaller();
/*     */ 
/*  91 */     m.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  92 */     if (cDatas != null) {
/*  93 */       XMLSerializer serializer = getXMLSerializer(cDatas, os);
/*  94 */       m.marshal(obj, serializer.asContentHandler());
/*     */     }
/*     */     else {
/*  97 */       m.marshal(obj, os);
/*  98 */     }return os;
/*     */   }
/*     */ 
/*     */   private static XMLSerializer getXMLSerializer(String[] cDatas, OutputStream os) throws FileNotFoundException {
/* 102 */     OutputFormat of = new OutputFormat();
/* 103 */     of.setCDataElements(cDatas);
/* 104 */     of.setPreserveSpace(true);
/* 105 */     of.setOmitXMLDeclaration(true);
/*     */ 
/* 107 */     XMLSerializer serializer = new XMLSerializer(of);
/* 108 */     serializer.setOutputByteStream(os);
/* 109 */     return serializer;
/*     */   }
/*     */ 
/*     */   private static XMLSerializer getXMLSerializer(String[] cDatas, File f) throws FileNotFoundException {
/* 113 */     OutputFormat of = new OutputFormat();
/* 114 */     of.setCDataElements(cDatas);
/* 115 */     of.setPreserveSpace(true);
/* 116 */     of.setOmitXMLDeclaration(true);
/* 117 */     XMLSerializer serializer = new XMLSerializer(of);
/* 118 */     serializer.setOutputByteStream(new FileOutputStream(f));
/* 119 */     return serializer;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.JAXBUtil
 * JD-Core Version:    0.6.0
 */