/*    */ package org.hi.common.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.xml.validation.Schema;
/*    */ import javax.xml.validation.SchemaFactory;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ public class SchemaUtil
/*    */ {
/*    */   static Schema getSchema(String schemaResourceName)
/*    */     throws SAXException
/*    */   {
/* 15 */     SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
/*    */     try {
/* 17 */       return sf.newSchema(new File(schemaResourceName));
/*    */     } catch (SAXException se) {
/*    */     }
/* 20 */     throw se;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.SchemaUtil
 * JD-Core Version:    0.6.0
 */