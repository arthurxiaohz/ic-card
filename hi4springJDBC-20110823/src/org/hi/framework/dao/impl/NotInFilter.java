/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.dao.NotFilter;
/*    */ 
/*    */ public class NotInFilter extends InFilter
/*    */   implements NotFilter
/*    */ {
/*    */   public InFilter addCondition(String name, Object val, String op, String relation)
/*    */   {
/* 23 */     super.addCondition(name, val, op, relation);
/* 24 */     FilterBean condition = (FilterBean)this.conditions.get(this.conditions.size() - 1);
/* 25 */     condition.setNot(true);
/*    */ 
/* 27 */     return this;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.NotInFilter
 * JD-Core Version:    0.6.0
 */