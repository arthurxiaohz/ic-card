/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.framework.dao.Filter;
/*    */ 
/*    */ public class SimpleFilter extends AbstractFilter
/*    */ {
/*    */   private static final long serialVersionUID = 6104162353423716952L;
/*    */ 
/*    */   public Filter addCondition(String name, Object val)
/*    */   {
/* 23 */     if (((val instanceof String)) && (val != null)) {
/* 24 */       String strVal = (String)val;
/* 25 */       if (strVal.trim().length() == 0) {
/* 26 */         return this;
/*    */       }
/* 28 */       return addCondition(name, val, "LIKE");
/*    */     }
/* 30 */     return addCondition(name, val, "=");
/*    */   }
/*    */ 
/*    */   public Filter addCondition(String name, Object val, String op)
/*    */   {
/* 37 */     return addCondition(name, val, op, "AND");
/*    */   }
/*    */ 
/*    */   public Filter addCondition(String name, Object val, String op, String relation)
/*    */   {
/* 46 */     if ((name == null) || (name.trim().equals(""))) {
/* 47 */       this.log.debug("addCondition method of name  is null");
/* 48 */       return this;
/*    */     }
/*    */ 
/* 51 */     FilterBean condition = new FilterBean();
/*    */ 
/* 53 */     if (relation == null) {
/* 54 */       relation = "AND";
/*    */     }
/* 56 */     condition.setRelations(relation);
/*    */ 
/* 58 */     if (op == null) {
/* 59 */       if ((val instanceof String))
/* 60 */         op = "LIKE";
/*    */       else {
/* 62 */         op = "=";
/*    */       }
/*    */     }
/* 65 */     condition.setOperater(op);
/* 66 */     condition.setValue(val);
/*    */ 
/* 69 */     condition.setFieldName(name);
/* 70 */     this.conditions.add(condition);
/* 71 */     return this;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.impl.SimpleFilter
 * JD-Core Version:    0.6.0
 */