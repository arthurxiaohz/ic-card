/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.NotFilter;
/*    */ 
/*    */ public class NotLikeFilter extends LikeFilter
/*    */   implements NotFilter
/*    */ {
/*    */   public Filter addCondition(String name, String val, String op, String relation, int controler)
/*    */   {
/* 14 */     super.addCondition(name, val, op, relation, controler);
/* 15 */     FilterBean condition = (FilterBean)this.conditions.get(this.conditions.size() - 1);
/* 16 */     condition.setNot(true);
/* 17 */     return this;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.NotLikeFilter
 * JD-Core Version:    0.6.0
 */