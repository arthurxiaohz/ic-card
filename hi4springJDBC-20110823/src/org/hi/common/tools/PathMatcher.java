/*    */ package org.hi.common.tools;
/*    */ 
/*    */ import org.springframework.util.AntPathMatcher;
/*    */ 
/*    */ public class PathMatcher
/*    */   implements Matcher
/*    */ {
/*    */   AntPathMatcher pathMatcher;
/*    */ 
/*    */   public PathMatcher()
/*    */   {
/* 18 */     this.pathMatcher = new AntPathMatcher();
/*    */   }
/*    */ 
/*    */   public void setPathSeparator(String pathSeparator)
/*    */   {
/* 26 */     this.pathMatcher.setPathSeparator(pathSeparator);
/*    */   }
/*    */ 
/*    */   public boolean isPattern(String str)
/*    */   {
/* 33 */     return this.pathMatcher.isPattern(str);
/*    */   }
/*    */ 
/*    */   public boolean match(String pattern, Object value)
/*    */   {
/* 41 */     if (!(value instanceof String)) {
/* 42 */       return false;
/*    */     }
/* 44 */     String str = (String)value;
/*    */ 
/* 46 */     return this.pathMatcher.match(pattern, str);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.tools.PathMatcher
 * JD-Core Version:    0.6.0
 */