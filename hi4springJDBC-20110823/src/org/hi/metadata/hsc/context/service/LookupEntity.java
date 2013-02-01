/*     */ package org.hi.metadata.hsc.context.service;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"lkServiceName", "lkEntityName", "isLkForeignKey", "mainLkFieldName"})
/*     */ @XmlRootElement(name="lookupEntity")
/*     */ public class LookupEntity
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String lkServiceName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String lkEntityName;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isLkForeignKey;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String mainLkFieldName;
/*     */ 
/*     */   public String getLkServiceName()
/*     */   {
/*  68 */     return this.lkServiceName;
/*     */   }
/*     */ 
/*     */   public void setLkServiceName(String value)
/*     */   {
/*  80 */     this.lkServiceName = value;
/*     */   }
/*     */ 
/*     */   public String getLkEntityName()
/*     */   {
/*  92 */     return this.lkEntityName;
/*     */   }
/*     */ 
/*     */   public void setLkEntityName(String value)
/*     */   {
/* 104 */     this.lkEntityName = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsLkForeignKey()
/*     */   {
/* 112 */     return this.isLkForeignKey;
/*     */   }
/*     */ 
/*     */   public void setIsLkForeignKey(boolean value)
/*     */   {
/* 120 */     this.isLkForeignKey = value;
/*     */   }
/*     */ 
/*     */   public String getMainLkFieldName()
/*     */   {
/* 132 */     return this.mainLkFieldName;
/*     */   }
/*     */ 
/*     */   public void setMainLkFieldName(String value)
/*     */   {
/* 144 */     this.mainLkFieldName = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.LookupEntity
 * JD-Core Version:    0.6.0
 */