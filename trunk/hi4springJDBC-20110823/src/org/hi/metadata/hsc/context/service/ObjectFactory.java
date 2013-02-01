/*     */ package org.hi.metadata.hsc.context.service;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  34 */   private static final QName _DefaultValue_QNAME = new QName("", "defaultValue");
/*  35 */   private static final QName _FieldType_QNAME = new QName("", "fieldType");
/*  36 */   private static final QName _IsFull_QNAME = new QName("", "isFull");
/*  37 */   private static final QName _IsParent_QNAME = new QName("", "isParent");
/*  38 */   private static final QName _IsListDisplay_QNAME = new QName("", "isListDisplay");
/*  39 */   private static final QName _EnuLabel_QNAME = new QName("", "enuLabel");
/*  40 */   private static final QName _EntityLabel_QNAME = new QName("", "entityLabel");
/*  41 */   private static final QName _FieldLabel_QNAME = new QName("", "fieldLabel");
/*  42 */   private static final QName _IsSearch_QNAME = new QName("", "isSearch");
/*  43 */   private static final QName _ExtendServiceName_QNAME = new QName("", "extendServiceName");
/*  44 */   private static final QName _Scale_QNAME = new QName("", "scale");
/*  45 */   private static final QName _BaseData_QNAME = new QName("", "baseData");
/*  46 */   private static final QName _EnuValue_QNAME = new QName("", "enuValue");
/*  47 */   private static final QName _IsReadOnly_QNAME = new QName("", "isReadOnly");
/*  48 */   private static final QName _EntityBaseData_QNAME = new QName("", "entityBaseData");
/*  49 */   private static final QName _MainLkFieldName_QNAME = new QName("", "mainLkFieldName");
/*  50 */   private static final QName _IsMainLookup_QNAME = new QName("", "isMainLookup");
/*  51 */   private static final QName _LkServiceName_QNAME = new QName("", "lkServiceName");
/*  52 */   private static final QName _EnumerationEntity_QNAME = new QName("", "enumerationEntity");
/*  53 */   private static final QName _IsLkForeignKey_QNAME = new QName("", "isLkForeignKey");
/*  54 */   private static final QName _Length_QNAME = new QName("", "length");
/*  55 */   private static final QName _ChildServiceName_QNAME = new QName("", "childServiceName");
/*  56 */   private static final QName _FieldName_QNAME = new QName("", "fieldName");
/*  57 */   private static final QName _EntityType_QNAME = new QName("", "entityType");
/*  58 */   private static final QName _TableName_QNAME = new QName("", "tableName");
/*  59 */   private static final QName _EnuCode_QNAME = new QName("", "enuCode");
/*  60 */   private static final QName _ChildForeignKey_QNAME = new QName("", "childForeignKey");
/*  61 */   private static final QName _EntityName_QNAME = new QName("", "entityName");
/*  62 */   private static final QName _Validator_QNAME = new QName("", "validator");
/*  63 */   private static final QName _PackageName_QNAME = new QName("", "packageName");
/*  64 */   private static final QName _IsHidden_QNAME = new QName("", "isHidden");
/*  65 */   private static final QName _ServiceName_QNAME = new QName("", "serviceName");
/*  66 */   private static final QName _Description_QNAME = new QName("", "description");
/*  67 */   private static final QName _LkEntityName_QNAME = new QName("", "lkEntityName");
/*  68 */   private static final QName _ChildEntityName_QNAME = new QName("", "childEntityName");
/*  69 */   private static final QName _IsPrimaryKey_QNAME = new QName("", "isPrimaryKey");
/*  70 */   private static final QName _ExtendEntityName_QNAME = new QName("", "extendEntityName");
/*     */ 
/*     */   public ChildEntity createChildEntity()
/*     */   {
/*  84 */     return new ChildEntity();
/*     */   }
/*     */ 
/*     */   public ExtendEntity createExtendEntity()
/*     */   {
/*  92 */     return new ExtendEntity();
/*     */   }
/*     */ 
/*     */   public Field createField()
/*     */   {
/* 100 */     return new Field();
/*     */   }
/*     */ 
/*     */   public Service createService()
/*     */   {
/* 108 */     return new Service();
/*     */   }
/*     */ 
/*     */   public Entity createEntity()
/*     */   {
/* 116 */     return new Entity();
/*     */   }
/*     */ 
/*     */   public LookupEntity createLookupEntity()
/*     */   {
/* 124 */     return new LookupEntity();
/*     */   }
/*     */ 
/*     */   public Enumeration createEnumeration()
/*     */   {
/* 132 */     return new Enumeration();
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="defaultValue")
/*     */   public JAXBElement<String> createDefaultValue(String value)
/*     */   {
/* 141 */     return new JAXBElement(_DefaultValue_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="fieldType")
/*     */   public JAXBElement<Integer> createFieldType(Integer value)
/*     */   {
/* 150 */     return new JAXBElement(_FieldType_QNAME, Integer.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isFull", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsFull(Boolean value)
/*     */   {
/* 159 */     return new JAXBElement(_IsFull_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isParent", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsParent(Boolean value)
/*     */   {
/* 168 */     return new JAXBElement(_IsParent_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isListDisplay", defaultValue="true")
/*     */   public JAXBElement<Boolean> createIsListDisplay(Boolean value)
/*     */   {
/* 177 */     return new JAXBElement(_IsListDisplay_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="enuLabel")
/*     */   public JAXBElement<String> createEnuLabel(String value)
/*     */   {
/* 186 */     return new JAXBElement(_EnuLabel_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="entityLabel")
/*     */   public JAXBElement<String> createEntityLabel(String value)
/*     */   {
/* 195 */     return new JAXBElement(_EntityLabel_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="fieldLabel")
/*     */   public JAXBElement<String> createFieldLabel(String value)
/*     */   {
/* 204 */     return new JAXBElement(_FieldLabel_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isSearch", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsSearch(Boolean value)
/*     */   {
/* 213 */     return new JAXBElement(_IsSearch_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="extendServiceName")
/*     */   public JAXBElement<String> createExtendServiceName(String value)
/*     */   {
/* 222 */     return new JAXBElement(_ExtendServiceName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="scale")
/*     */   public JAXBElement<Integer> createScale(Integer value)
/*     */   {
/* 231 */     return new JAXBElement(_Scale_QNAME, Integer.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="baseData")
/*     */   public JAXBElement<Integer> createBaseData(Integer value)
/*     */   {
/* 240 */     return new JAXBElement(_BaseData_QNAME, Integer.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="enuValue")
/*     */   public JAXBElement<String> createEnuValue(String value)
/*     */   {
/* 249 */     return new JAXBElement(_EnuValue_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isReadOnly", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsReadOnly(Boolean value)
/*     */   {
/* 258 */     return new JAXBElement(_IsReadOnly_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="entityBaseData")
/*     */   public JAXBElement<Integer> createEntityBaseData(Integer value)
/*     */   {
/* 267 */     return new JAXBElement(_EntityBaseData_QNAME, Integer.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="mainLkFieldName")
/*     */   public JAXBElement<String> createMainLkFieldName(String value)
/*     */   {
/* 276 */     return new JAXBElement(_MainLkFieldName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isMainLookup", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsMainLookup(Boolean value)
/*     */   {
/* 285 */     return new JAXBElement(_IsMainLookup_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="lkServiceName")
/*     */   public JAXBElement<String> createLkServiceName(String value)
/*     */   {
/* 294 */     return new JAXBElement(_LkServiceName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="enumerationEntity")
/*     */   public JAXBElement<String> createEnumerationEntity(String value)
/*     */   {
/* 303 */     return new JAXBElement(_EnumerationEntity_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isLkForeignKey", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsLkForeignKey(Boolean value)
/*     */   {
/* 312 */     return new JAXBElement(_IsLkForeignKey_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="length")
/*     */   public JAXBElement<Integer> createLength(Integer value)
/*     */   {
/* 321 */     return new JAXBElement(_Length_QNAME, Integer.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="childServiceName")
/*     */   public JAXBElement<String> createChildServiceName(String value)
/*     */   {
/* 330 */     return new JAXBElement(_ChildServiceName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="fieldName")
/*     */   public JAXBElement<String> createFieldName(String value)
/*     */   {
/* 339 */     return new JAXBElement(_FieldName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="entityType")
/*     */   public JAXBElement<Integer> createEntityType(Integer value)
/*     */   {
/* 348 */     return new JAXBElement(_EntityType_QNAME, Integer.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="tableName")
/*     */   public JAXBElement<String> createTableName(String value)
/*     */   {
/* 357 */     return new JAXBElement(_TableName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="enuCode")
/*     */   public JAXBElement<String> createEnuCode(String value)
/*     */   {
/* 366 */     return new JAXBElement(_EnuCode_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="childForeignKey")
/*     */   public JAXBElement<String> createChildForeignKey(String value)
/*     */   {
/* 375 */     return new JAXBElement(_ChildForeignKey_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="entityName")
/*     */   public JAXBElement<String> createEntityName(String value)
/*     */   {
/* 384 */     return new JAXBElement(_EntityName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="validator")
/*     */   public JAXBElement<String> createValidator(String value)
/*     */   {
/* 393 */     return new JAXBElement(_Validator_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="packageName")
/*     */   public JAXBElement<String> createPackageName(String value)
/*     */   {
/* 402 */     return new JAXBElement(_PackageName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isHidden", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsHidden(Boolean value)
/*     */   {
/* 411 */     return new JAXBElement(_IsHidden_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="serviceName")
/*     */   public JAXBElement<String> createServiceName(String value)
/*     */   {
/* 420 */     return new JAXBElement(_ServiceName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="description")
/*     */   public JAXBElement<String> createDescription(String value)
/*     */   {
/* 429 */     return new JAXBElement(_Description_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="lkEntityName")
/*     */   public JAXBElement<String> createLkEntityName(String value)
/*     */   {
/* 438 */     return new JAXBElement(_LkEntityName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="childEntityName")
/*     */   public JAXBElement<String> createChildEntityName(String value)
/*     */   {
/* 447 */     return new JAXBElement(_ChildEntityName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="isPrimaryKey", defaultValue="false")
/*     */   public JAXBElement<Boolean> createIsPrimaryKey(Boolean value)
/*     */   {
/* 456 */     return new JAXBElement(_IsPrimaryKey_QNAME, Boolean.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="extendEntityName")
/*     */   public JAXBElement<String> createExtendEntityName(String value)
/*     */   {
/* 465 */     return new JAXBElement(_ExtendEntityName_QNAME, String.class, null, value);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.service.ObjectFactory
 * JD-Core Version:    0.6.0
 */