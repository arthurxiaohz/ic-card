/*    */ package org.hi.metadata.hsc.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FilenameFilter;
/*    */ 
/*    */ public class ServiceFilenameFilter
/*    */   implements FilenameFilter
/*    */ {
/*    */   public boolean accept(File dir, String name)
/*    */   {
/* 13 */     return name.endsWith("hsc.xml");
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.util.ServiceFilenameFilter
 * JD-Core Version:    0.6.0
 */