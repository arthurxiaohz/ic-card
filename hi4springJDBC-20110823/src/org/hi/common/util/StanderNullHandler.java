/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import ognl.NullHandler;
/*     */ import ognl.Ognl;
/*     */ import ognl.OgnlRuntime;
/*     */ 
/*     */ class StanderNullHandler
/*     */   implements NullHandler
/*     */ {
/*     */   public Object nullMethodResult(Map context, Object target, String methodName, Object[] args)
/*     */   {
/* 727 */     return null;
/*     */   }
/*     */ 
/*     */   public Object nullPropertyValue(Map context, Object target, Object property) {
/*     */     try {
/* 732 */       String propName = property.toString();
/* 733 */       Class clazz = OgnlRuntime.getPropertyDescriptor(target.getClass(), propName).getPropertyType();
/*     */ 
/* 735 */       if (Collection.class.isAssignableFrom(clazz))
/* 736 */         return new ArrayList();
/* 737 */       if (clazz == Map.class) {
/* 738 */         return new HashMap();
/*     */       }
/*     */ 
/* 741 */       Object param = clazz.newInstance();
/* 742 */       Ognl.setValue(propName, context, target, param);
/* 743 */       return param;
/*     */     } catch (Exception e) {
/* 745 */       e.printStackTrace();
/*     */     }
/* 747 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.StanderNullHandler
 * JD-Core Version:    0.6.0
 */