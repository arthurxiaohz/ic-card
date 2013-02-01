/*    */ package org.hi.framework.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.core.io.Resource;
/*    */ 
/*    */ public abstract class DataInputStreamUtil
/*    */ {
/* 12 */   private static Log log = LogFactory.getLog(DataInputStreamUtil.class);
/*    */ 
/*    */   public static StringBuffer getInputStreameSegment(Resource resource, String start, String end)
/*    */     throws IOException
/*    */   {
/* 31 */     BufferedReader dis = new BufferedReader(new InputStreamReader(resource.getInputStream()));
/* 32 */     StringBuffer sb = new StringBuffer();
/*    */ 
/* 34 */     boolean isStart = false;
/* 35 */     boolean findEndTag = false;
/*    */     String line;
/*    */     try
/*    */     {
/*    */       String line;
/* 37 */       while ((line = dis.readLine()) != null)
/*    */       {
/*    */         String line;
/* 39 */         if (line.trim().equals(start))
/* 40 */           isStart = true;
/* 41 */         if ((line.trim().startsWith("#")) || (!isStart) || (line.trim().equals("")))
/*    */           continue;
/* 43 */         if (line.trim().equals(end)) {
/* 44 */           findEndTag = true;
/* 45 */           break;
/*    */         }
/* 47 */         if (!line.trim().equals(start))
/* 48 */           sb.append(line);
/* 49 */         sb.append("\n");
/*    */       }
/*    */ 
/* 52 */       if (!isStart) {
/* 53 */         log.debug("not find start tag: " + start + " in URL:" + resource.getURL());
/*    */       }
/* 55 */       if (!findEndTag)
/* 56 */         log.debug("not find end tag:  " + end + "  in URL:" + resource.getURL());
/*    */     }
/*    */     finally
/*    */     {
/* 60 */       dis.close();
/*    */     }
/* 62 */     return sb;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.util.DataInputStreamUtil
 * JD-Core Version:    0.6.0
 */