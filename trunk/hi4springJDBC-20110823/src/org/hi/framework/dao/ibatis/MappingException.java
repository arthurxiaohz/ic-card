/*    */ package org.hi.framework.dao.ibatis;
/*    */ 
/*    */ public class MappingException extends RuntimeException
/*    */ {
/*    */   private final String path;
/*    */   private final String type;
/*    */ 
/*    */   public MappingException(String customMessage, String type, String path, Throwable cause)
/*    */   {
/*  7 */     super(customMessage, cause);
/*  8 */     this.type = type;
/*  9 */     this.path = path;
/*    */   }
/*    */   public MappingException(String type, String path, Throwable cause) {
/* 12 */     this("Could not parse mapping document from " + type + (path == null ? "" : new StringBuilder(" ").append(path).toString()), type, path, cause);
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 16 */     return this.type;
/*    */   }
/*    */ 
/*    */   public String getPath() {
/* 20 */     return this.path;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.MappingException
 * JD-Core Version:    0.6.0
 */