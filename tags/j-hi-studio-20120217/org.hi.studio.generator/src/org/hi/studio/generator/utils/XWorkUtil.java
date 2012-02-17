/*    */ package org.hi.studio.generator.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.util.List;
/*    */ import org.hi.generator.ant.NoOpEntityResolver;
/*    */ import org.hi.studio.core.log.ExceptionManager;
/*    */ import org.jdom.Content;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ import org.jdom.output.Format;
/*    */ import org.jdom.output.XMLOutputter;
/*    */ import org.jdom.xpath.XPath;
/*    */ 
/*    */ public class XWorkUtil
/*    */ {
/*    */   public static void writeXWorkFile(String filePath, String includeFile)
/*    */   {
/*    */     try
/*    */     {
/* 23 */       File xworkFile = new File(filePath);
/* 24 */       if (!xworkFile.exists())
/*    */       {
/* 26 */         return;
/*    */       }
/*    */ 
/* 29 */       SAXBuilder builder = new SAXBuilder();
/* 30 */       builder.setEntityResolver(new NoOpEntityResolver());
/*    */ 
/* 33 */       Document doc = builder.build(filePath);
/* 34 */       Element root = doc.getRootElement();
/* 35 */       String patten = "//include[@file='" + includeFile + "']";
/*    */ 
/* 37 */       XPath xPath = XPath.newInstance(patten);
/* 38 */       List test = xPath.selectNodes(root);
/* 39 */       if (test.size() <= 0)
/*    */       {
/* 41 */         Element elem = new Element("include");
/* 42 */         elem.setAttribute("file", includeFile);
/*    */ 
/* 44 */         root.addContent(elem);
/*    */ 
/* 46 */         Format format = Format.getPrettyFormat();
/*    */ 
/* 48 */         XMLOutputter outputter = new XMLOutputter(format);
/*    */ 
/* 51 */         FileOutputStream output = new FileOutputStream(filePath);
/* 52 */         outputter.output(doc, output);
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 57 */       ExceptionManager.logError(e, "");
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void deleteXWorkIncludeFile(String filePath, String includeFile)
/*    */   {
/*    */     try
/*    */     {
/* 65 */       File xworkFile = new File(filePath);
/* 66 */       if (!xworkFile.exists())
/*    */       {
/* 68 */         return;
/*    */       }
/*    */ 
/* 71 */       SAXBuilder builder = new SAXBuilder();
/* 72 */       builder.setEntityResolver(new NoOpEntityResolver());
/*    */ 
/* 75 */       Document doc = builder.build(filePath);
/* 76 */       Element root = doc.getRootElement();
/* 77 */       String patten = "//include[@file='" + includeFile + "']";
/*    */ 
/* 79 */       XPath xPath = XPath.newInstance(patten);
/* 80 */       List test = xPath.selectNodes(root);
/* 81 */       if (test.size() > 0)
/*    */       {
/* 83 */         root.removeContent((Content)test.get(0));
/*    */ 
/* 85 */         Format format = Format.getPrettyFormat();
/*    */ 
/* 87 */         XMLOutputter outputter = new XMLOutputter(format);
/*    */ 
/* 90 */         FileOutputStream output = new FileOutputStream(filePath);
/* 91 */         outputter.output(doc, output);
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 96 */       ExceptionManager.logError(e, "");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.utils.XWorkUtil
 * JD-Core Version:    0.6.0
 */