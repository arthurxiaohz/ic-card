/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.framework.dao.Filter;
/*    */ 
/*    */ public class LikeFilter extends SimpleFilter
/*    */ {
/*  9 */   public static int LIKE_CONTROLER_ALL = 0;
/*    */ 
/* 13 */   public static int LIKE_CONTROLER_LEFT = 1;
/*    */ 
/* 17 */   public static int LIKE_CONTROLER_RIGHT = 2;
/*    */ 
/*    */   public Filter addCondition(String name, String val, String op, String relation, int controler)
/*    */   {
/* 23 */     if ((name == null) || (name.trim().equals(""))) {
/* 24 */       this.log.fatal("addCondition method of name  is null");
/* 25 */       return this;
/*    */     }
/* 27 */     if ((val == null) || (!(val instanceof String))) {
/* 28 */       this.log.fatal("NotLikeFilter addCondition method of value  is null or not String");
/* 29 */       return this;
/*    */     }
/*    */ 
/* 32 */     FilterBean condition = new FilterBean();
/*    */ 
/* 34 */     if (relation == null) {
/* 35 */       relation = "AND";
/*    */     }
/* 37 */     condition.setRelations(relation);
/*    */ 
/* 39 */     if (op == null) {
/* 40 */       op = "LIKE";
/*    */     }
/* 42 */     condition.setOperater(op);
/* 43 */     condition.setValue(val);
/* 44 */     condition.setLikeControler(controler);
/*    */ 
/* 46 */     condition.setFieldName(name);
/* 47 */     this.conditions.add(condition);
/* 48 */     return this;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.LikeFilter
 * JD-Core Version:    0.6.0
 */