/*    */ package org.hi.metadata.hsc.context.service;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"extendServiceName", "extendEntityName"})
/*    */ @XmlRootElement(name="extendEntity")
/*    */ public class ExtendEntity
/*    */ {
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String extendServiceName;
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String extendEntityName;
/*    */ 
/*    */   public String getExtendServiceName()
/*    */   {
/* 60 */     return this.extendServiceName;
/*    */   }
/*    */ 
/*    */   public void setExtendServiceName(String value)
/*    */   {
/* 72 */     this.extendServiceName = value;
/*    */   }
/*    */ 
/*    */   public String getExtendEntityName()
/*    */   {
/* 84 */     return this.extendEntityName;
/*    */   }
/*    */ 
/*    */   public void setExtendEntityName(String value)
/*    */   {
/* 96 */     this.extendEntityName = value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.ExtendEntity
 * JD-Core Version:    0.6.0
 */