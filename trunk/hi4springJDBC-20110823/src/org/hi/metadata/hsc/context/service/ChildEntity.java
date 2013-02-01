/*     */ package org.hi.metadata.hsc.context.service;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"childServiceName", "childEntityName", "childForeignKey"})
/*     */ @XmlRootElement(name="childEntity")
/*     */ public class ChildEntity
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String childServiceName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String childEntityName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String childForeignKey;
/*     */ 
/*     */   public String getChildServiceName()
/*     */   {
/*  64 */     return this.childServiceName;
/*     */   }
/*     */ 
/*     */   public void setChildServiceName(String value)
/*     */   {
/*  76 */     this.childServiceName = value;
/*     */   }
/*     */ 
/*     */   public String getChildEntityName()
/*     */   {
/*  88 */     return this.childEntityName;
/*     */   }
/*     */ 
/*     */   public void setChildEntityName(String value)
/*     */   {
/* 100 */     this.childEntityName = value;
/*     */   }
/*     */ 
/*     */   public String getChildForeignKey()
/*     */   {
/* 112 */     return this.childForeignKey;
/*     */   }
/*     */ 
/*     */   public void setChildForeignKey(String value)
/*     */   {
/* 124 */     this.childForeignKey = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.ChildEntity
 * JD-Core Version:    0.6.0
 */