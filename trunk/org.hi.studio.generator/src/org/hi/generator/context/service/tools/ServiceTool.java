/*     */ package org.hi.generator.context.service.tools;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.generator.ant.HiGeneraterToolTask;
/*     */ import org.hi.generator.template.TemplateHelpFactory;
/*     */ import org.hi.metadata.hsc.context.service.ChildEntity;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ 
/*     */ public class ServiceTool
/*     */ {
/*  33 */   public static int ENTITY_STEP = 100;
/*  34 */   protected final Log log = LogFactory.getLog(getClass());
/*  35 */   private Map<Entity, EntityExtend> entityExtends = new HashMap();
/*     */   private static ServiceTool serviceTool;
/*     */   private static HiGeneraterToolTask parentTask;
/*     */ 
/*     */   public static ServiceTool newInstance(HiGeneraterToolTask parentTask)
/*     */   {
/*  42 */     if (serviceTool == null) {
/*  43 */       serviceTool = new ServiceTool();
/*  44 */       parentTask = parentTask;
/*  45 */       int i_step = TemplateHelpFactory.getEntityStep();
/*  46 */       if (i_step != 0)
/*  47 */         ENTITY_STEP = i_step;
/*     */     }
/*  49 */     return serviceTool;
/*     */   }
/*     */ 
/*     */   public Field getPKField(Entity entity) {
/*  53 */     List fields = entity.getField();
/*  54 */     for (Iterator iter = fields.iterator(); iter.hasNext(); ) {
/*  55 */       Field field = (Field)iter.next();
/*  56 */       if (field.isIsPrimaryKey())
/*  57 */         return field;
/*     */     }
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean hasPK(Entity entity)
/*     */   {
/*  64 */     return getPKField(entity) != null;
/*     */   }
/*     */ 
/*     */   public List getToString(Entity entity)
/*     */   {
/*  75 */     List result = new ArrayList();
/*  76 */     for (Iterator iter = entity.getField().iterator(); iter.hasNext(); ) {
/*  77 */       Field field = (Field)iter.next();
/*  78 */       if ((!field.isIsPrimaryKey()) && (field.getFieldType() != 1) && 
/*  79 */         (field.getFieldType() != 2) && (field.getFieldType() != 3)) continue;
/*  80 */       String propertyName = field.getFieldName();
/*  81 */       String toStrProperty = ".append(\"" + propertyName + "\", this." + propertyName + ")";
/*  82 */       result.add(toStrProperty);
/*     */     }
/*     */ 
/*  86 */     String lastProperty = (String)result.get(result.size() - 1);
/*  87 */     result.remove(result.size() - 1);
/*  88 */     lastProperty = lastProperty + ";";
/*  89 */     result.add(lastProperty);
/*  90 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean hasChild(Entity entity)
/*     */   {
/*  95 */     return (entity.getChildEntity() != null) && (entity.getChildEntity().size() != 0);
/*     */   }
/*     */ 
/*     */   public List<Entity> getChild(Entity entity, Map<String, Service> allServices)
/*     */   {
/* 107 */     List result = new ArrayList();
/* 108 */     List childs = entity.getChildEntity();
/* 109 */     for (ChildEntity child : childs) {
/* 110 */       String serviceName = child.getChildServiceName();
/* 111 */       String entityName = child.getChildEntityName();
/* 112 */       Service service = (Service)allServices.get(serviceName);
/* 113 */       List entities = service.getEntity();
/* 114 */       for (Entity entity2 : entities) {
/* 115 */         if (entity2.getEntityName().equals(entityName))
/* 116 */           result.add(entity2);
/*     */       }
/*     */     }
/* 119 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean hasExtendEntity(Entity entity)
/*     */   {
/* 129 */     if (entity.getEntityType() != 3)
/* 130 */       return false;
/* 131 */     ExtendEntity extendEntity = entity.getExtendEntity();
/* 132 */     if (extendEntity == null)
/* 133 */       return false;
/* 134 */     String extendServiceName = extendEntity.getExtendServiceName();
/* 135 */     String extendEntityName = extendEntity.getExtendEntityName();
/*     */ 
/* 138 */     return (extendServiceName != null) && (extendServiceName != null) && (!extendEntityName.trim().equals("")) && (!extendEntityName.trim().equals(""));
/*     */   }
/*     */ 
/*     */   public String getFieldType(Field field)
/*     */   {
/* 149 */     int fieldType = field.getFieldType();
/* 150 */     if (fieldType == 0) {
/* 151 */       this.log.error("problem field :" + field.getFieldName() + " fieldType = 0");
/*     */     }
/* 153 */     switch (fieldType) {
/*     */     case 1:
/* 155 */       return "String";
/*     */     case 2:
/* 157 */       return "Integer";
/*     */     case 3:
/* 159 */       return "Double";
/*     */     case 4:
/* 161 */       return "Date";
/*     */     case 5:
/* 163 */       return "Timestamp";
/*     */     case 6:
/* 165 */       return field.getLookupEntity().getLkEntityName();
/*     */     case 7:
/* 167 */       return "Integer";
/*     */     case 8:
/* 169 */       return field.getLookupEntity().getLkEntityName();
/*     */     case 9:
/* 171 */       return "String";
/*     */     }
/*     */ 
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */   public int getSeedData(Service service, Entity entity)
/*     */   {
/* 184 */     if (entity.getEntityBaseData() != 0) {
/* 185 */       return entity.getEntityBaseData();
/*     */     }
/*     */ 
/* 188 */     if (this.entityExtends.get(entity) == null) {
/* 189 */       EntityExtend entityExtend = new EntityExtend();
/* 190 */       entityExtend.setEntity(entity);
/* 191 */       List entities = service.getEntity();
/* 192 */       int start = 0;
/* 193 */       for (int i = 0; i < entities.size(); i++) {
/* 194 */         if (((Entity)entities.get(i)).equals(entity))
/* 195 */           start = i;
/*     */       }
/* 197 */       entityExtend.setStartSeedData(service.getBaseData() + start * ENTITY_STEP);
/* 198 */       this.entityExtends.put(entity, entityExtend);
/*     */     }
/*     */ 
/* 201 */     return ((EntityExtend)this.entityExtends.get(entity)).getStartSeedData();
/*     */   }
/*     */ 
/*     */   public boolean hasLookupEntity(Entity entity)
/*     */   {
/* 210 */     List fields = entity.getField();
/* 211 */     for (Field field : fields) {
/* 212 */       LookupEntity lookupEntity = field.getLookupEntity();
/* 213 */       if ((lookupEntity.getLkServiceName() != null) && (lookupEntity.getLkServiceName().trim().equals("")) && (lookupEntity.getLkEntityName() != null) && (lookupEntity.getLkEntityName().trim().equals("")))
/* 214 */         return true;
/*     */     }
/* 216 */     return false;
/*     */   }
/*     */ 
/*     */   public Entity getLookupEntity(Field field, Map<String, Service> allServices)
/*     */   {
/* 227 */     if ((field.getFieldType() != 6) && (field.getFieldType() != 8))
/* 228 */       return null;
/* 229 */     String lkServiceName = field.getLookupEntity().getLkServiceName();
/* 230 */     String lkEntityName = field.getLookupEntity().getLkEntityName();
/*     */ 
/* 232 */     Service service = (Service)allServices.get(lkServiceName);
/* 233 */     if (service == null) {
/* 234 */       return null;
/*     */     }
/* 236 */     Entity entity = getEntityByName(service, lkEntityName);
/* 237 */     if (entity != null) {
/* 238 */       return entity;
/*     */     }
/* 240 */     return getEntityByName(allServices, lkEntityName);
/*     */   }
/*     */ 
/*     */   public Entity getEntityByName(Service service, String entityName)
/*     */   {
/* 252 */     List entities = service.getEntity();
/* 253 */     for (Entity entity : entities) {
/* 254 */       if (entity.getEntityType() == 2)
/*     */         continue;
/* 256 */       if (entity.getEntityName().equals(entityName)) {
/* 257 */         return entity;
/*     */       }
/*     */     }
/* 260 */     return null;
/*     */   }
/*     */ 
/*     */   public Entity getEntityByName(Map<String, Service> allServices, String entityName) {
/* 264 */     Set serviceNameSet = allServices.keySet();
/* 265 */     for (String serviceName : serviceNameSet) {
/* 266 */       Service service = (Service)allServices.get(serviceName);
/* 267 */       Entity entity = getEntityByName(service, entityName);
/* 268 */       if (entity != null) {
/* 269 */         return entity;
/*     */       }
/*     */     }
/* 272 */     return null;
/*     */   }
/*     */ 
/*     */   public Service getEntityService(Entity entity, List<Service> allServices)
/*     */   {
/* 282 */     for (Service service : allServices)
/*     */     {
/* 284 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*     */         continue;
/*     */       }
/* 287 */       for (Entity tagEntity : service.getEntity()) {
/* 288 */         if (tagEntity.getEntityName().equals(entity.getEntityName())) {
/* 289 */           return service;
/*     */         }
/*     */       }
/*     */     }
/* 293 */     return null;
/*     */   }
/*     */ 
/*     */   public List<List<Field>> getLookupJsonCol(Entity entity)
/*     */   {
/* 302 */     List fields = entity.getField();
/* 303 */     List result = new ArrayList();
/* 304 */     List lkElement = new ArrayList();
/* 305 */     String lkEntityName = "";
/*     */ 
/* 307 */     for (Field field : fields)
/*     */     {
/* 309 */       if ((field.getFieldType() != 6) && (field.getFieldType() != 8)) {
/*     */         continue;
/*     */       }
/* 312 */       if (field.getLookupEntity().isIsLkForeignKey())
/*     */       {
/* 314 */         lkEntityName = field.getLookupEntity().getLkEntityName();
/* 315 */         lkElement = new ArrayList();
/* 316 */         lkElement.add(field);
/* 317 */         result.add(lkElement);
/*     */       }
/* 320 */       else if (field.getLookupEntity().getLkEntityName().equals(lkEntityName)) {
/* 321 */         lkElement.add(field);
/*     */       }
/*     */     }
/* 323 */     return result;
/*     */   }
/*     */ 
/*     */   public String getJSType(Entity entity, Field field) {
/* 327 */     if (field.getFieldType() == 4)
/* 328 */       return "date";
/* 329 */     if (field.getFieldType() == 5)
/* 330 */       return "datetime";
/* 331 */     if (field.getFieldType() == 7)
/* 332 */       return "Eum\",\"selectName\":\"" + StringUtils.lowerFrist(field.getEnumerationEntity());
/* 333 */     if (field.getFieldType() == 3)
/* 334 */       return "text";
/* 335 */     if (field.getFieldType() == 2)
/* 336 */       return "text";
/* 337 */     if (field.getFieldType() == 1)
/* 338 */       return "text";
/* 339 */     if (field.getFieldType() == 9)
/* 340 */       return "text";
/* 341 */     if ((field.getFieldType() == 6) || (field.getFieldType() == 8))
/* 342 */       return "lookup\",\"lookupName\":\"" + StringUtils.lowerFrist(new StringBuilder(String.valueOf(getLookupFKFiled(entity, field).getFieldName())).append("\",\"isMainLookup\":\"").append(field.isIsMainLookup()).append("\",\"field\":\"").append(StringUtils.lowerFrist(field.getFieldName())).toString());
/* 343 */     return null;
/*     */   }
/*     */ 
/*     */   public int displayCount(Entity entity)
/*     */   {
/* 352 */     return getDisplayFields(entity).size();
/*     */   }
/*     */ 
/*     */   public List<Field> getDisplayFields(Entity entity)
/*     */   {
/* 361 */     List fields = new ArrayList();
/* 362 */     for (Field field : entity.getField()) {
/* 363 */       if (field.isIsListDisplay())
/* 364 */         fields.add(field);
/*     */     }
/* 366 */     return fields;
/*     */   }
/*     */ 
/*     */   public List<List<Field>> getSearchFields(Entity entity)
/*     */   {
/* 375 */     List fields = new ArrayList();
/* 376 */     for (Field field : entity.getField()) {
/* 377 */       if (field.isIsSearch())
/* 378 */         fields.add(field);
/*     */     }
/* 380 */     List fields2 = new ArrayList();
/* 381 */     int _size = fields.size();
/* 382 */     int step = _size % 2 > 0 ? _size / 2 + 1 : _size / 2;
/* 383 */     for (int i = 0; i < step; i++) {
/* 384 */       List field2 = new ArrayList();
/* 385 */       field2.add((Field)fields.get(i * 2));
/* 386 */       if (i * 2 + 1 >= _size) {
/* 387 */         Field field = new Field();
/* 388 */         field.setFieldLabel("");
/* 389 */         field.setFieldName("");
/* 390 */         field2.add(field);
/*     */       }
/*     */       else {
/* 393 */         field2.add((Field)fields.get(i * 2 + 1));
/* 394 */       }fields2.add(field2);
/*     */     }
/* 396 */     return fields2;
/*     */   }
/*     */ 
/*     */   public Map<String, Field> getLookupSearchMap(Entity entity) {
/* 400 */     Map result = new HashMap();
/* 401 */     Field pkField = null;
/* 402 */     for (Field field : entity.getField()) {
/* 403 */       if (field.getFieldType() == 6) {
/* 404 */         if (field.getLookupEntity().isIsLkForeignKey()) {
/* 405 */           pkField = field;
/*     */         }
/* 407 */         if (field.isIsSearch())
/* 408 */           result.put(field.getFieldName(), pkField);
/*     */       }
/*     */     }
/* 411 */     return result;
/*     */   }
/*     */ 
/*     */   public Field getLookupFKFiled(Entity entity, Field field) {
/* 415 */     Field fkField = null;
/* 416 */     for (Field field1 : entity.getField()) {
/* 417 */       if ((field1.getFieldType() != 6) && (field1.getFieldType() != 8))
/*     */         continue;
/* 419 */       if (field1.getLookupEntity().isIsLkForeignKey()) {
/* 420 */         fkField = field1;
/*     */       }
/* 422 */       if (field1.getFieldName().equals(field.getFieldName())) {
/*     */         break;
/*     */       }
/*     */     }
/* 426 */     return fkField;
/*     */   }
/*     */ 
/*     */   public List<Field> getFullField(Entity entity)
/*     */   {
/* 435 */     List result = new ArrayList();
/* 436 */     List fields = entity.getField();
/* 437 */     for (Field field : fields) {
/* 438 */       if (field.isIsFull())
/* 439 */         result.add(field);
/*     */     }
/* 441 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Field> getEditField(Entity entity)
/*     */   {
/* 446 */     List result = new ArrayList();
/* 447 */     List fields = entity.getField();
/*     */ 
/* 449 */     for (Field field : fields) {
/* 450 */       if (!field.isIsHidden())
/* 451 */         result.add(field);
/*     */     }
/* 453 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Field> getHiddenField(Entity entity)
/*     */   {
/* 462 */     List result = new ArrayList();
/* 463 */     Map lookupGroups = getLookGroup(entity);
/* 464 */     List fields = entity.getField();
/* 465 */     Set lkForeignSet = new HashSet();
/* 466 */     for (Field field : fields) {
/* 467 */       if (field.isIsHidden())
/* 468 */         if (field.getFieldType() == 6) {
/* 469 */           List lookups = (List)lookupGroups.get(field);
/* 470 */           if (lookups.size() == 1) {
/* 471 */             Field lookupField = (Field)lookups.get(0);
/* 472 */             if ((lookupField.isIsHidden()) && (lookupField.getLookupEntity().isIsLkForeignKey()) && (!lkForeignSet.contains(lookupField))) {
/* 473 */               lkForeignSet.add(lookupField);
/* 474 */               result.add(lookupField);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 479 */             for (Field lookupField : lookups)
/* 480 */               if ((lookupField.isIsHidden()) && (!lookupField.getLookupEntity().isIsLkForeignKey()) && (!lkForeignSet.contains(lookupField))) {
/* 481 */                 lkForeignSet.add(lookupField);
/* 482 */                 result.add(lookupField);
/*     */               }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 488 */           result.add(field);
/*     */         }
/*     */     }
/* 491 */     return result;
/*     */   }
/*     */ 
/*     */   public Map<Field, List<Field>> getLookGroup(Entity entity)
/*     */   {
/* 500 */     Map result = new HashMap();
/* 501 */     List fields = entity.getField();
/* 502 */     List lookupGroup = null;
/* 503 */     for (Field field : fields)
/*     */     {
/* 505 */       if ((field.getFieldType() != 6) && (field.getFieldType() != 8)) {
/*     */         continue;
/*     */       }
/* 508 */       if (field.getLookupEntity().isIsLkForeignKey()) {
/* 509 */         lookupGroup = new ArrayList();
/*     */       }
/* 511 */       lookupGroup.add(field);
/* 512 */       result.put(field, lookupGroup);
/*     */     }
/* 514 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Field> getWithoutKeyword(Entity entity)
/*     */   {
/* 524 */     List result = new ArrayList();
/* 525 */     return result;
/*     */   }
/*     */ 
/*     */   public Entity getParentEntity(Entity child, Map<String, Service> allServices)
/*     */   {
/* 535 */     Entity parent = null;
/* 536 */     List fields = child.getField();
/* 537 */     for (Field field : fields)
/* 538 */       if ((field.isIsParent()) && (field.getFieldType() == 6))
/*     */       {
/* 540 */         return getLookupEntity(field, allServices);
/*     */       }
/* 542 */     return parent;
/*     */   }
/*     */ 
/*     */   public boolean hasInEntity(String entityName, List<String> entityNames)
/*     */   {
/* 552 */     if (entityNames == null)
/* 553 */       return true;
/* 554 */     for (String element : entityNames) {
/* 555 */       if (element.equals(entityName)) {
/* 556 */         return true;
/*     */       }
/*     */     }
/* 559 */     return false;
/*     */   }
/*     */ 
/*     */   public List<Field> getLookupField(Entity entity)
/*     */   {
/* 569 */     List result = new ArrayList();
/* 570 */     List fields = entity.getField();
/* 571 */     for (Field field : fields) {
/* 572 */       if ((field.getFieldType() != 6) && (field.getFieldType() != 8)) {
/*     */         continue;
/*     */       }
/* 575 */       boolean hasInclude = false;
/* 576 */       for (Field resultField : result) {
/* 577 */         if (resultField.getLookupEntity().getLkEntityName().equals(field.getLookupEntity().getLkEntityName())) {
/* 578 */           hasInclude = true;
/* 579 */           break;
/*     */         }
/*     */       }
/* 582 */       if (!hasInclude) {
/* 583 */         result.add(field);
/*     */       }
/*     */     }
/* 586 */     return result;
/*     */   }
/*     */ 
/*     */   public String getValidator(Field field) {
/* 590 */     if ((field.getValidator() == null) || (field.getValidator().equals("")))
/* 591 */       return null;
/* 592 */     return field.getValidator();
/*     */   }
/*     */ 
/*     */   public List<Field> getSortField(Entity entity) {
/* 596 */     List result = new ArrayList();
/* 597 */     List lookupFields = new ArrayList();
/* 598 */     List fields = entity.getField();
/* 599 */     for (Field field : fields) {
/* 600 */       if ((field.getFieldType() == 6) || (field.getFieldType() == 8)) {
/* 601 */         lookupFields.add(field);
/*     */       }
/*     */       else
/* 604 */         result.add(field);
/*     */     }
/* 606 */     if (lookupFields.size() > 0) {
/* 607 */       result.addAll(lookupFields);
/*     */     }
/* 609 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Field> getLookFields(Field pkField, Entity entity) {
/* 613 */     Map groups = getLookGroup(entity);
/* 614 */     return (List)groups.get(pkField);
/*     */   }
/*     */ 
/*     */   public Field getField(Map<String, Service> allServices, Field field) {
/* 618 */     Entity entity = getLookupEntity(field, allServices);
/* 619 */     for (Field _field : entity.getField()) {
/* 620 */       if (field.getLookupEntity().getMainLkFieldName().equals(_field.getFieldName()))
/* 621 */         return _field;
/*     */     }
/* 623 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.context.service.tools.ServiceTool
 * JD-Core Version:    0.6.0
 */