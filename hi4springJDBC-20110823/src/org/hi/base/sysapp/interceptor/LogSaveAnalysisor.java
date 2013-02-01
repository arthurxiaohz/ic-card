/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import org.hi.common.util.BeanUtil;
/*    */ import org.hi.framework.model.BaseObject;
/*    */ import org.hi.framework.service.Manager;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ import org.hi.metadata.hsc.context.service.Field;
/*    */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*    */ 
/*    */ public class LogSaveAnalysisor extends AbstractLogAnalysisor
/*    */ {
/*    */   public String perProcess(Object[] args, Entity entity, Manager manager)
/*    */   {
/* 18 */     StringBuffer savesb = new StringBuffer();
/* 19 */     StringBuffer parameters = new StringBuffer();
/*    */ 
/* 21 */     for (int i = 0; i < args.length; i++) {
/* 22 */       if ((args[i] instanceof BaseObject)) {
/* 23 */         BaseObject bo = (BaseObject)args[i];
/* 24 */         if (!bo.isDirty()) continue;
/* 25 */         if (!savesb.toString().contains("数据信息:")) {
/* 26 */           savesb.append("数据信息:");
/*    */         }
/* 28 */         if ((bo.getVersion() == null) && (bo.getPrimarykey() == null)) {
/* 29 */           savesb.append("插入").append("[");
/* 30 */           Field lkFKField = null;
/* 31 */           for (Field field : entity.getField()) {
/* 32 */             String fieldLabel = field.getFieldLabel();
/* 33 */             String fieldName = field.getFieldName();
/* 34 */             if (field.getFieldType() == 6)
/*    */             {
/* 36 */               if (field.getLookupEntity().isIsLkForeignKey()) {
/* 37 */                 lkFKField = field;
/* 38 */                 continue;
/*    */               }
/*    */ 
/* 41 */               if (lkFKField != null) {
/* 42 */                 fieldName = lkFKField.getFieldName();
/*    */               }
/*    */             }
/* 45 */             Object propertyValue = BeanUtil.getPropertyValue(bo, fieldName);
/* 46 */             String value = getPropertyValueToString(field, lkFKField, propertyValue);
/* 47 */             if (value != null)
/* 48 */               savesb.append(fieldLabel).append(":").append(value).append(";");
/*    */           }
/*    */         }
/*    */         else {
/* 52 */           savesb.append("更新");
/* 53 */           if (bo.getDataSymbol() != null)
/* 54 */             savesb.append("<").append(bo.getDataSymbol()).append(">");
/* 55 */           savesb.append("[");
/* 56 */           Field lkFKField = null;
/* 57 */           for (Field field : entity.getField()) {
/* 58 */             String fieldLabel = field.getFieldLabel();
/* 59 */             String fieldName = field.getFieldName();
/* 60 */             if (field.getFieldType() == 6)
/*    */             {
/* 62 */               if (field.getLookupEntity().isIsLkForeignKey()) {
/* 63 */                 lkFKField = field;
/* 64 */                 continue;
/*    */               }
/*    */ 
/* 67 */               if (lkFKField != null)
/* 68 */                 fieldName = lkFKField.getFieldName();
/*    */             }
/* 70 */             if (!bo.hasOldValue(fieldName))
/*    */               continue;
/* 72 */             Object propertyValue = BeanUtil.getPropertyValue(bo, fieldName);
/* 73 */             String oldValue = getPropertyValueToString(field, lkFKField, bo.getOldValue(fieldName));
/* 74 */             String newValue = getPropertyValueToString(field, lkFKField, propertyValue);
/* 75 */             if (newValue != null)
/* 76 */               savesb.append(fieldLabel).append(":").append(oldValue).append("->").append(newValue).append(";");
/*    */           }
/* 78 */           savesb.append("]");
/*    */         }
/*    */       }
/*    */ 
/* 82 */       if ((!(args[i] instanceof String)) || 
/* 83 */         (args[i] == null)) continue;
/* 84 */       if (!parameters.toString().contains("参数信息:")) {
/* 85 */         parameters.append("参数信息:");
/*    */       }
/* 87 */       parameters.append(args[i]);
/*    */     }
/*    */ 
/* 92 */     if ((savesb.toString().equals("")) && (parameters.toString().equals("")))
/* 93 */       return null;
/* 94 */     return parameters;
/*    */   }
/*    */ 
/*    */   public String postProcess(Object result) {
/* 98 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogSaveAnalysisor
 * JD-Core Version:    0.6.0
 */