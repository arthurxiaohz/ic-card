/*      */ package org.hi.framework.dao.springjdbc;
/*      */ 
/*      */ import java.sql.Timestamp;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ 
/*      */ class ValueClass2JDBCType
/*      */ {
/*      */   private Object value;
/*      */   private Class clazz;
/*      */   private String propertyName;
/* 1249 */   private static Map CLASS_TYPE = new HashMap();
/*      */ 
/* 1251 */   static { CLASS_TYPE.put(Integer.class, Integer.valueOf(2));
/* 1252 */     CLASS_TYPE.put(Double.class, Integer.valueOf(2));
/* 1253 */     CLASS_TYPE.put(String.class, Integer.valueOf(-1));
/* 1254 */     CLASS_TYPE.put(Date.class, Integer.valueOf(91));
/* 1255 */     CLASS_TYPE.put(Timestamp.class, Integer.valueOf(91)); }
/*      */ 
/*      */   public ValueClass2JDBCType(Class clazz, Object value, String propertyName)
/*      */   {
/* 1259 */     this.clazz = clazz;
/* 1260 */     this.value = value;
/* 1261 */     this.propertyName = propertyName;
/*      */   }
/*      */   public int getJDBCType() {
/* 1264 */     return Integer.parseInt(CLASS_TYPE.get(this.clazz).toString());
/*      */   }
/*      */ 
/*      */   public Object getValue() {
/* 1268 */     return this.value;
/*      */   }
/*      */   public Class getClazz() {
/* 1271 */     return this.clazz;
/*      */   }
/*      */   public String getPropertyName() {
/* 1274 */     return this.propertyName;
/*      */   }
/*      */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.ValueClass2JDBCType
 * JD-Core Version:    0.6.0
 */