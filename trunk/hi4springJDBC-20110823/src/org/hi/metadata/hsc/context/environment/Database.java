/*    */ package org.hi.metadata.hsc.context.environment;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"dbtype", "connection"})
/*    */ @XmlRootElement(name="database")
/*    */ public class Database
/*    */ {
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String dbtype;
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected Connection connection;
/*    */ 
/*    */   public String getDbtype()
/*    */   {
/* 60 */     return this.dbtype;
/*    */   }
/*    */ 
/*    */   public void setDbtype(String value)
/*    */   {
/* 72 */     this.dbtype = value;
/*    */   }
/*    */ 
/*    */   public Connection getConnection()
/*    */   {
/* 84 */     return this.connection;
/*    */   }
/*    */ 
/*    */   public void setConnection(Connection value)
/*    */   {
/* 96 */     this.connection = value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.environment.Database
 * JD-Core Version:    0.6.0
 */