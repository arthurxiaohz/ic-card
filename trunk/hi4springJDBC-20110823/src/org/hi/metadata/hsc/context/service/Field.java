/*     */ package org.hi.metadata.hsc.context.service;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"fieldName", "fieldLabel", "isPrimaryKey", "isReadOnly", "isSearch", "isListDisplay", "isHidden", "isFull", "isMainLookup", "isParent", "fieldType", "length", "scale", "defaultValue", "validator", "enumerationEntity", "lookupEntity"})
/*     */ @XmlRootElement(name="field")
/*     */ public class Field
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String fieldName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String fieldLabel;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isPrimaryKey;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isReadOnly;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isSearch;
/*     */ 
/*     */   @XmlElement(defaultValue="true")
/*     */   protected boolean isListDisplay;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isHidden;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isFull;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isMainLookup;
/*     */ 
/*     */   @XmlElement(defaultValue="false")
/*     */   protected boolean isParent;
/*     */   protected int fieldType;
/*     */   protected int length;
/*     */   protected int scale;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String defaultValue;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String validator;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String enumerationEntity;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected LookupEntity lookupEntity;
/*     */ 
/*     */   public String getFieldName()
/*     */   {
/* 117 */     return this.fieldName;
/*     */   }
/*     */ 
/*     */   public void setFieldName(String value)
/*     */   {
/* 129 */     this.fieldName = value;
/*     */   }
/*     */ 
/*     */   public String getFieldLabel()
/*     */   {
/* 141 */     return this.fieldLabel;
/*     */   }
/*     */ 
/*     */   public void setFieldLabel(String value)
/*     */   {
/* 153 */     this.fieldLabel = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsPrimaryKey()
/*     */   {
/* 161 */     return this.isPrimaryKey;
/*     */   }
/*     */ 
/*     */   public void setIsPrimaryKey(boolean value)
/*     */   {
/* 169 */     this.isPrimaryKey = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsReadOnly()
/*     */   {
/* 177 */     return this.isReadOnly;
/*     */   }
/*     */ 
/*     */   public void setIsReadOnly(boolean value)
/*     */   {
/* 185 */     this.isReadOnly = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsSearch()
/*     */   {
/* 193 */     return this.isSearch;
/*     */   }
/*     */ 
/*     */   public void setIsSearch(boolean value)
/*     */   {
/* 201 */     this.isSearch = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsListDisplay()
/*     */   {
/* 209 */     return this.isListDisplay;
/*     */   }
/*     */ 
/*     */   public void setIsListDisplay(boolean value)
/*     */   {
/* 217 */     this.isListDisplay = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsHidden()
/*     */   {
/* 225 */     return this.isHidden;
/*     */   }
/*     */ 
/*     */   public void setIsHidden(boolean value)
/*     */   {
/* 233 */     this.isHidden = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsFull()
/*     */   {
/* 241 */     return this.isFull;
/*     */   }
/*     */ 
/*     */   public void setIsFull(boolean value)
/*     */   {
/* 249 */     this.isFull = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsMainLookup()
/*     */   {
/* 257 */     return this.isMainLookup;
/*     */   }
/*     */ 
/*     */   public void setIsMainLookup(boolean value)
/*     */   {
/* 265 */     this.isMainLookup = value;
/*     */   }
/*     */ 
/*     */   public boolean isIsParent()
/*     */   {
/* 273 */     return this.isParent;
/*     */   }
/*     */ 
/*     */   public void setIsParent(boolean value)
/*     */   {
/* 281 */     this.isParent = value;
/*     */   }
/*     */ 
/*     */   public int getFieldType()
/*     */   {
/* 289 */     return this.fieldType;
/*     */   }
/*     */ 
/*     */   public void setFieldType(int value)
/*     */   {
/* 297 */     this.fieldType = value;
/*     */   }
/*     */ 
/*     */   public int getLength()
/*     */   {
/* 305 */     return this.length;
/*     */   }
/*     */ 
/*     */   public void setLength(int value)
/*     */   {
/* 313 */     this.length = value;
/*     */   }
/*     */ 
/*     */   public int getScale()
/*     */   {
/* 321 */     return this.scale;
/*     */   }
/*     */ 
/*     */   public void setScale(int value)
/*     */   {
/* 329 */     this.scale = value;
/*     */   }
/*     */ 
/*     */   public String getDefaultValue()
/*     */   {
/* 341 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */   public void setDefaultValue(String value)
/*     */   {
/* 353 */     this.defaultValue = value;
/*     */   }
/*     */ 
/*     */   public String getValidator()
/*     */   {
/* 365 */     return this.validator;
/*     */   }
/*     */ 
/*     */   public void setValidator(String value)
/*     */   {
/* 377 */     this.validator = value;
/*     */   }
/*     */ 
/*     */   public String getEnumerationEntity()
/*     */   {
/* 389 */     return this.enumerationEntity;
/*     */   }
/*     */ 
/*     */   public void setEnumerationEntity(String value)
/*     */   {
/* 401 */     this.enumerationEntity = value;
/*     */   }
/*     */ 
/*     */   public LookupEntity getLookupEntity()
/*     */   {
/* 413 */     return this.lookupEntity;
/*     */   }
/*     */ 
/*     */   public void setLookupEntity(LookupEntity value)
/*     */   {
/* 425 */     this.lookupEntity = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.Field
 * JD-Core Version:    0.6.0
 */