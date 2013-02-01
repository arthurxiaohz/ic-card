/*   */ package org.hi.framework.dao.impl;
/*   */ 
/*   */ public abstract class AbstractSQLServerDialect extends HiAbstractDialect
/*   */ {
/*   */   protected String getFeildToString(String fieldName, FilterBean filterBean)
/*   */   {
/* 6 */     return fieldName;
/*   */   }
/*   */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.impl.AbstractSQLServerDialect
 * JD-Core Version:    0.6.0
 */