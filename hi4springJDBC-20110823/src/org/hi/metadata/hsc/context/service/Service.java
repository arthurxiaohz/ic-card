/*     */ package org.hi.metadata.hsc.context.service;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"serviceName", "description", "baseData", "packageName", "entity"})
/*     */ @XmlRootElement(name="service")
/*     */ public class Service
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String serviceName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String description;
/*     */   protected int baseData;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String packageName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected List<Entity> entity;
/*     */ 
/*     */   public String getServiceName()
/*     */   {
/*  73 */     return this.serviceName;
/*     */   }
/*     */ 
/*     */   public void setServiceName(String value)
/*     */   {
/*  85 */     this.serviceName = value;
/*     */   }
/*     */ 
/*     */   public String getDescription()
/*     */   {
/*  97 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String value)
/*     */   {
/* 109 */     this.description = value;
/*     */   }
/*     */ 
/*     */   public int getBaseData()
/*     */   {
/* 117 */     return this.baseData;
/*     */   }
/*     */ 
/*     */   public void setBaseData(int value)
/*     */   {
/* 125 */     this.baseData = value;
/*     */   }
/*     */ 
/*     */   public String getPackageName()
/*     */   {
/* 137 */     return this.packageName;
/*     */   }
/*     */ 
/*     */   public void setPackageName(String value)
/*     */   {
/* 149 */     this.packageName = value;
/*     */   }
/*     */ 
/*     */   public List<Entity> getEntity()
/*     */   {
/* 175 */     if (this.entity == null) {
/* 176 */       this.entity = new ArrayList();
/*     */     }
/* 178 */     return this.entity;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.Service
 * JD-Core Version:    0.6.0
 */