/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.StringBufferInputStream;
/*    */ import org.xml.sax.EntityResolver;
/*    */ import org.xml.sax.InputSource;
/*    */ 
/*    */ public class NoOpEntityResolver
/*    */   implements EntityResolver
/*    */ {
/*    */   public InputSource resolveEntity(String publicId, String systemId)
/*    */   {
/* 10 */     return new InputSource(new StringBufferInputStream(""));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.NoOpEntityResolver
 * JD-Core Version:    0.6.0
 */