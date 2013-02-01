/*    */ package org.hi.framework.dao.springjdbc;
/*    */ 
/*    */ import java.util.Properties;
/*    */ import javax.sql.DataSource;
/*    */ import org.hi.common.util.BeanUtil;
/*    */ import org.springframework.beans.factory.InitializingBean;
/*    */ 
/*    */ public class SpringJDBCHiSessionFactory
/*    */   implements InitializingBean
/*    */ {
/*    */   private boolean sqlShow;
/*    */   private SpringJDBCHiDialect dialect;
/*    */   private DataSource dataSource;
/*    */   private Properties properties;
/*    */ 
/*    */   public Properties getProperties()
/*    */   {
/* 18 */     return this.properties;
/*    */   }
/*    */ 
/*    */   public void setProperties(Properties properties) {
/* 22 */     this.properties = properties;
/*    */   }
/*    */   public boolean isSqlShow() {
/* 25 */     return this.sqlShow;
/*    */   }
/*    */   public void setSqlShow(boolean sqlShow) {
/* 28 */     this.sqlShow = sqlShow;
/*    */   }
/*    */   public DataSource getDataSource() {
/* 31 */     return this.dataSource;
/*    */   }
/*    */   public void setDataSource(DataSource dataSource) {
/* 34 */     this.dataSource = dataSource;
/*    */   }
/*    */ 
/*    */   public SpringJDBCHiDialect getDialect() {
/* 38 */     return this.dialect;
/*    */   }
/*    */ 
/*    */   public void afterPropertiesSet() throws Exception
/*    */   {
/* 43 */     if (this.dialect == null) {
/* 44 */       String dialectValue = this.properties.getProperty("springjdbc.dialect");
/* 45 */       if (dialectValue != null)
/* 46 */         this.dialect = ((SpringJDBCHiDialect)BeanUtil.CreateObject(dialectValue));
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.SpringJDBCHiSessionFactory
 * JD-Core Version:    0.6.0
 */