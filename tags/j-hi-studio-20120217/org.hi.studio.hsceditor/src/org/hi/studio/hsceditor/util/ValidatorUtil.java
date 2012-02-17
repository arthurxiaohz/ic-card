/*    */ package org.hi.studio.hsceditor.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.JDOMException;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ 
/*    */ public class ValidatorUtil
/*    */ {
/* 22 */   private static List<String> validatorList = null;
/*    */ 
/* 24 */   private static Map<String, String> validatorMap = null;
/*    */ 
/*    */   public static List<String> getValidatorList()
/*    */   {
/* 31 */     if (validatorList != null) {
/* 32 */       return validatorList;
/*    */     }
/* 34 */     populateValidator();
/*    */ 
/* 36 */     return validatorList;
/*    */   }
/*    */ 
/*    */   public static String getValidatorDesc(String validatorName)
/*    */   {
/* 45 */     if (validatorMap == null) {
/* 46 */       populateValidator();
/*    */     }
/*    */ 
/* 49 */     return (String)validatorMap.get(validatorName);
/*    */   }
/*    */ 
/*    */   private static void populateValidator()
/*    */   {
/* 61 */     validatorList = new ArrayList();
/* 62 */     validatorMap = new HashMap();
/* 63 */     SAXBuilder builder = new SAXBuilder();
/* 64 */     Document doc = new Document();
/*    */     try {
/* 66 */       InputStream in = null;
/* 67 */       in = ValidatorUtil.class.getResourceAsStream("/hivalidator.xml");
/* 68 */       doc = builder.build(in);
/* 69 */       in.close();
/*    */     } catch (JDOMException e) {
/* 71 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 73 */       e.printStackTrace();
/*    */     }
/* 75 */     Iterator itr = doc.getRootElement().getChildren().iterator();
/* 76 */     while (itr.hasNext())
/*    */     {
/* 78 */       Element elem = (Element)itr.next();
/* 79 */       String name = elem.getAttributeValue("name");
/* 80 */       String desc = elem.getText();
/* 81 */       validatorList.add(name);
/* 82 */       validatorMap.put(name, desc);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.ValidatorUtil
 * JD-Core Version:    0.6.0
 */