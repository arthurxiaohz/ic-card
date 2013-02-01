/*    */ package org.hi.framework.dao.hibernate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.io.Serializable;
/*    */ import java.io.StringReader;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.usertype.UserType;
/*    */ 
/*    */ public class StringClobType
/*    */   implements UserType
/*    */ {
/*    */   public int[] sqlTypes()
/*    */   {
/* 17 */     return new int[] { 2005 };
/*    */   }
/*    */ 
/*    */   public Class returnedClass() {
/* 21 */     return String.class;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object x, Object y) {
/* 25 */     return (x == y) || ((x != null) && (y != null) && (x.equals(y)));
/*    */   }
/*    */ 
/*    */   public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException
/*    */   {
/* 30 */     Reader reader = rs.getCharacterStream(names[0]);
/* 31 */     if (reader == null)
/* 32 */       return null;
/* 33 */     StringBuffer sb = new StringBuffer();
/*    */     try {
/* 35 */       char[] charbuf = new char[4096];
/* 36 */       for (int i = reader.read(charbuf); i > 0; i = reader.read(charbuf))
/* 37 */         sb.append(charbuf, 0, i);
/*    */     }
/*    */     catch (IOException e) {
/* 40 */       throw new SQLException(e.getMessage());
/*    */     }
/* 42 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException
/*    */   {
/* 47 */     if (value != null) {
/* 48 */       StringReader r = new StringReader((String)value);
/* 49 */       st.setCharacterStream(index, r, ((String)value).length());
/*    */     } else {
/* 51 */       st.setNull(index, sqlTypes()[0]);
/*    */     }
/*    */   }
/*    */ 
/*    */   public Object deepCopy(Object value) {
/* 56 */     if (value == null)
/* 57 */       return null;
/* 58 */     return new String((String)value);
/*    */   }
/*    */ 
/*    */   public boolean isMutable() {
/* 62 */     return false;
/*    */   }
/*    */ 
/*    */   public int hashCode(Object arg0)
/*    */     throws HibernateException
/*    */   {
/* 69 */     return 0;
/*    */   }
/*    */ 
/*    */   public Serializable disassemble(Object arg0)
/*    */     throws HibernateException
/*    */   {
/* 76 */     return null;
/*    */   }
/*    */ 
/*    */   public Object assemble(Serializable arg0, Object arg1)
/*    */     throws HibernateException
/*    */   {
/* 85 */     return null;
/*    */   }
/*    */ 
/*    */   public Object replace(Object arg0, Object arg1, Object arg2)
/*    */     throws HibernateException
/*    */   {
/* 94 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.StringClobType
 * JD-Core Version:    0.6.0
 */