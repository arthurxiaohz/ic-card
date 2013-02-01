/*     */ package org.hi.metadata.hsc.context.service;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"enuValue", "enuLabel", "enuCode"})
/*     */ @XmlRootElement(name="enumeration")
/*     */ public class Enumeration
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String enuValue;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String enuLabel;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String enuCode;
/*     */ 
/*     */   public String getEnuValue()
/*     */   {
/*  64 */     return this.enuValue;
/*     */   }
/*     */ 
/*     */   public void setEnuValue(String value)
/*     */   {
/*  76 */     this.enuValue = value;
/*     */   }
/*     */ 
/*     */   public String getEnuLabel()
/*     */   {
/*  88 */     return this.enuLabel;
/*     */   }
/*     */ 
/*     */   public void setEnuLabel(String value)
/*     */   {
/* 100 */     this.enuLabel = value;
/*     */   }
/*     */ 
/*     */   public String getEnuCode()
/*     */   {
/* 112 */     return this.enuCode;
/*     */   }
/*     */ 
/*     */   public void setEnuCode(String value)
/*     */   {
/* 124 */     this.enuCode = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.Enumeration
 * JD-Core Version:    0.6.0
 */