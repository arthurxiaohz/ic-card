/*    */ package org.hi.common.scripting.bsh;
/*    */ 
/*    */ import bsh.EvalError;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class BeanShellFactory
/*    */ {
/*    */   public static BeanShellWrapper createBeanShell(Map<String, Object> model)
/*    */     throws EvalError
/*    */   {
/* 16 */     return new BeanShellWrapper(model);
/*    */   }
/*    */ 
/*    */   public static BeanShellWrapper createBeanShell(String name, Object obj) throws EvalError {
/* 20 */     return new BeanShellWrapper(name, obj);
/*    */   }
/*    */ 
/*    */   public static BeanShellWrapper createBeanShell() throws EvalError {
/* 24 */     return new BeanShellWrapper();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.scripting.bsh.BeanShellFactory
 * JD-Core Version:    0.6.0
 */