/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public class InFilter extends AbstractFilter
/*    */ {
/*    */   private static final long serialVersionUID = 3988800758696951324L;
/*    */ 
/*    */   public InFilter addCondition(String name, Object val)
/*    */   {
/* 34 */     return addCondition(name, val, "IN", "AND");
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public InFilter addCondition(String name, Object val, String op) {
/* 40 */     return addCondition(name, val, "IN", "AND");
/*    */   }
/*    */ 
/*    */   public InFilter addCondition(String name, Object val, String op, String relation)
/*    */   {
/* 56 */     op = "IN";
/*    */ 
/* 58 */     if ((name == null) || (name.trim().equals("")) || (val == null)) {
/* 59 */       this.log.fatal("addCondition method of name or value is null");
/* 60 */       return this;
/*    */     }
/*    */ 
/* 63 */     if ((val instanceof Collection)) {
/* 64 */       Collection vals = (Collection)val;
/*    */ 
/* 66 */       if (vals.size() == 0) {
/* 67 */         return this;
/*    */       }
/* 69 */       FilterBean condition = new FilterBean();
/*    */ 
/* 71 */       if (relation == null) {
/* 72 */         relation = "AND";
/*    */       }
/*    */ 
/* 75 */       condition.setRelations(relation);
/*    */ 
/* 77 */       condition.setFieldName(name);
/*    */ 
/* 79 */       condition.setOperater(op);
/* 80 */       condition.setValue(val);
/*    */ 
/* 82 */       this.conditions.add(condition);
/*    */     }
/*    */     else {
/* 85 */       this.log.fatal("this is filter value not Collection Class");
/* 86 */       return this;
/*    */     }
/*    */ 
/* 89 */     return this;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.impl.InFilter
 * JD-Core Version:    0.6.0
 */