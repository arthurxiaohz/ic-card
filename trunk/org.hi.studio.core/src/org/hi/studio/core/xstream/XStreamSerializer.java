/*    */ package org.hi.studio.core.xstream;
/*    */ 
/*    */ import com.thoughtworks.xstream.XStream;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.Reader;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ 
/*    */ public class XStreamSerializer
/*    */ {
/*    */   public static String serialize(Object obj, ClassLoader loader)
/*    */   {
/* 14 */     XStream xstream = new XStream();
/* 15 */     xstream.setClassLoader(loader);
/* 16 */     return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xstream.toXML(obj);
/*    */   }
/*    */ 
/*    */   public static InputStream serializeStream(Object obj, ClassLoader loader) throws UnsupportedEncodingException {
/* 20 */     String xml = serialize(obj, loader);
/* 21 */     return new ByteArrayInputStream(xml.getBytes("UTF-8"));
/*    */   }
/*    */ 
/*    */   public static Object deserialize(String xml, ClassLoader loader) {
/* 25 */     XStream xstream = new XStream();
/* 26 */     xstream.setClassLoader(loader);
/* 27 */     return xstream.fromXML(xml);
/*    */   }
/*    */ 
/*    */   public static Object deserialize(Reader reader, ClassLoader loader) {
/* 31 */     XStream xstream = new XStream();
/* 32 */     xstream.setClassLoader(loader);
/* 33 */     return xstream.fromXML(reader);
/*    */   }
/*    */ 
/*    */   public static Object deserialize(InputStream in, ClassLoader loader) throws UnsupportedEncodingException {
/* 37 */     XStream xstream = new XStream();
/* 38 */     xstream.setClassLoader(loader);
/* 39 */     return xstream.fromXML(new InputStreamReader(in, "UTF-8"));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.xstream.XStreamSerializer
 * JD-Core Version:    0.6.0
 */