/*    */ package org.hi.studio.hsceditor.util;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*    */ import org.hi.metadata.hsc.context.service.Field;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ 
/*    */ public class ServiceTool
/*    */ {
/*    */   public static Entity getParentEntityByEntity(Entity entity, Map<String, Service> serviceMap)
/*    */   {
/* 16 */     mergeEntity(entity, entity, serviceMap);
/*    */ 
/* 18 */     return entity;
/*    */   }
/*    */ 
/*    */   protected static Entity mergeEntity(Entity targetEntity, Entity sourceEntity, Map<String, Service> serviceMap) {
/* 22 */     ExtendEntity extendEntityDef = sourceEntity.getExtendEntity();
/*    */ 
/* 25 */     if ((extendEntityDef == null) || (extendEntityDef.getExtendEntityName() == null) || (extendEntityDef.getExtendEntityName().trim().equals(""))) {
/* 26 */       return targetEntity;
/*    */     }
/* 28 */     Service service = (Service)serviceMap.get(extendEntityDef.getExtendServiceName());
/* 29 */     Entity tempEntity = getEntityByName(service, extendEntityDef.getExtendEntityName());
/* 30 */     for (Field field : tempEntity.getField()) {
/* 31 */       targetEntity.getField().add(field);
/*    */     }
/* 33 */     return mergeEntity(targetEntity, tempEntity, serviceMap);
/*    */   }
/*    */ 
/*    */   public static Entity getEntityByName(Service service, String entityName)
/*    */   {
/* 45 */     List entities = service.getEntity();
/* 46 */     for (Entity entity : entities) {
/* 47 */       if (entity.getEntityType() == 2)
/*    */         continue;
/* 49 */       if (entity.getEntityName().equals(entityName)) {
/* 50 */         return entity;
/*    */       }
/*    */     }
/* 53 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.ServiceTool
 * JD-Core Version:    0.6.0
 */