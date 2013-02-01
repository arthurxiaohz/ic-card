/*    */ package org.hi.metadata.hsc.context.service;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"parentServiceName", "parentEntityName"})
/*    */ @XmlRootElement(name="parentEntity")
/*    */ public class ParentEntity
/*    */ {
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String parentServiceName;
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String parentEntityName;
/*    */ 
/*    */   public String getParentServiceName()
/*    */   {
/* 60 */     return this.parentServiceName;
/*    */   }
/*    */ 
/*    */   public void setParentServiceName(String value)
/*    */   {
/* 72 */     this.parentServiceName = value;
/*    */   }
/*    */ 
/*    */   public String getParentEntityName()
/*    */   {
/* 84 */     return this.parentEntityName;
/*    */   }
/*    */ 
/*    */   public void setParentEntityName(String value)
/*    */   {
/* 96 */     this.parentEntityName = value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.ParentEntity
 * JD-Core Version:    0.6.0
 */