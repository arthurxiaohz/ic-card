/*    */ package org.hi.studio.hsceditor.util;
/*    */ 
/*    */ import java.io.Closeable;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ public class IOUtils
/*    */ {
/*    */   public static void close(Closeable closeable)
/*    */   {
/* 10 */     if (closeable != null)
/*    */       try {
/* 12 */         closeable.close();
/*    */       }
/*    */       catch (Exception localException) {
/*    */       }
/*    */   }
/*    */ 
/*    */   public static void copyStream(InputStream in, OutputStream out) {
/*    */     try {
/* 20 */       byte[] buf = new byte[in.available()];
/* 21 */       in.read(buf);
/* 22 */       out.write(buf);
/*    */     } catch (Exception ex) {
/* 24 */       throw new RuntimeException(ex);
/*    */     } finally {
/* 26 */       close(in);
/* 27 */       close(out);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static String loadStream(InputStream in, String charset) {
/*    */     try {
/* 33 */       byte[] buf = new byte[in.available()];
/* 34 */       in.read(buf);
/* 35 */       String str = new String(buf, charset);
/*    */       return str;
/*    */     } catch (Exception ex) {
/* 37 */       throw new RuntimeException(ex);
/*    */     } finally {
/* 39 */       close(in);
/* 40 */     }throw localObject;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.IOUtils
 * JD-Core Version:    0.6.0
 */