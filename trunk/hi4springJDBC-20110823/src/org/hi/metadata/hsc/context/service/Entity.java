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
/*     */ @XmlType(name="", propOrder={"entityName", "entityType", "tableName", "entityLabel", "entityBaseData", "field", "enumeration", "childEntity", "extendEntity"})
/*     */ @XmlRootElement(name="entity")
/*     */ public class Entity
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String entityName;
/*     */   protected int entityType;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String tableName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String entityLabel;
/*     */   protected int entityBaseData;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected List<Field> field;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected List<Enumeration> enumeration;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected List<ChildEntity> childEntity;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected ExtendEntity extendEntity;
/*     */ 
/*     */   public String getEntityName()
/*     */   {
/*  88 */     return this.entityName;
/*     */   }
/*     */ 
/*     */   public void setEntityName(String value)
/*     */   {
/* 100 */     this.entityName = value;
/*     */   }
/*     */ 
/*     */   public int getEntityType()
/*     */   {
/* 108 */     return this.entityType;
/*     */   }
/*     */ 
/*     */   public void setEntityType(int value)
/*     */   {
/* 116 */     this.entityType = value;
/*     */   }
/*     */ 
/*     */   public String getTableName()
/*     */   {
/* 128 */     return this.tableName;
/*     */   }
/*     */ 
/*     */   public void setTableName(String value)
/*     */   {
/* 140 */     this.tableName = value;
/*     */   }
/*     */ 
/*     */   public String getEntityLabel()
/*     */   {
/* 152 */     return this.entityLabel;
/*     */   }
/*     */ 
/*     */   public void setEntityLabel(String value)
/*     */   {
/* 164 */     this.entityLabel = value;
/*     */   }
/*     */ 
/*     */   public int getEntityBaseData()
/*     */   {
/* 172 */     return this.entityBaseData;
/*     */   }
/*     */ 
/*     */   public void setEntityBaseData(int value)
/*     */   {
/* 180 */     this.entityBaseData = value;
/*     */   }
/*     */ 
/*     */   public List<Field> getField()
/*     */   {
/* 206 */     if (this.field == null) {
/* 207 */       this.field = new ArrayList();
/*     */     }
/* 209 */     return this.field;
/*     */   }
/*     */ 
/*     */   public List<Enumeration> getEnumeration()
/*     */   {
/* 235 */     if (this.enumeration == null) {
/* 236 */       this.enumeration = new ArrayList();
/*     */     }
/* 238 */     return this.enumeration;
/*     */   }
/*     */ 
/*     */   public List<ChildEntity> getChildEntity()
/*     */   {
/* 264 */     if (this.childEntity == null) {
/* 265 */       this.childEntity = new ArrayList();
/*     */     }
/* 267 */     return this.childEntity;
/*     */   }
/*     */ 
/*     */   public ExtendEntity getExtendEntity()
/*     */   {
/* 279 */     return this.extendEntity;
/*     */   }
/*     */ 
/*     */   public void setExtendEntity(ExtendEntity value)
/*     */   {
/* 291 */     this.extendEntity = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.Entity
 * JD-Core Version:    0.6.0
 */