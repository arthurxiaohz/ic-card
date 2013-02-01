/*     */ package org.hi.base.sysapp.interceptor;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.enumeration.EnumerationHelper;
/*     */ import org.hi.base.enumeration.model.EnumerationValue;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*     */ 
/*     */ public class LogRemoveAnalysisor extends AbstractLogAnalysisor
/*     */ {
/*     */   public String perProcess(Object[] args, Entity entity, Manager manager)
/*     */   {
/*  26 */     ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/*  27 */     StringBuffer info = new StringBuffer();
/*  28 */     info.append("记录信息:");
/*     */ 
/*  30 */     for (int i = 0; i < args.length; i++) {
/*  31 */       BaseObject bo = null;
/*  32 */       if ((args[i] instanceof Integer)) {
/*  33 */         Integer id = (Integer)args[i];
/*  34 */         bo = (BaseObject)bMgr.getObjectById(manager.getModelClass(), id);
/*     */       }
/*  36 */       if ((args[i] instanceof BaseObject)) {
/*  37 */         bo = (BaseObject)args[i];
/*     */       }
/*  39 */       if (bo == null) {
/*  40 */         info.append("无  ");
/*     */       }
/*     */       else
/*     */       {
/*  44 */         Field lkFKField = null;
/*  45 */         String fieldLabel = null;
/*  46 */         String value = null;
/*  47 */         for (Field field : entity.getField()) {
/*  48 */           fieldLabel = field.getFieldLabel();
/*  49 */           if ((field.getFieldName().equals("version")) || (field.getFieldName().equals("deleted"))) {
/*     */             continue;
/*     */           }
/*  52 */           if (field.getFieldType() == 6) {
/*  53 */             if (field.getLookupEntity().isIsLkForeignKey()) {
/*  54 */               lkFKField = field;
/*     */             }
/*     */             else
/*     */             {
/*  58 */               Object lkPerValue = BeanUtil.getPropertyValue(bo, lkFKField.getFieldName() + "." + field.getLookupEntity().getMainLkFieldName());
/*  59 */               if (lkPerValue == null) {
/*  60 */                 value = "null";
/*  61 */                 info.append(fieldLabel).append(":").append(value).append(";");
/*     */               }
/*     */               else
/*     */               {
/*  65 */                 if ((lkPerValue instanceof Date)) {
/*  66 */                   Date date = (Date)lkPerValue;
/*  67 */                   value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
/*     */                 }
/*  69 */                 else if ((lkPerValue instanceof Timestamp)) {
/*  70 */                   Timestamp time = (Timestamp)lkPerValue;
/*  71 */                   Date date = new Date(time.getTime());
/*  72 */                   value = StringUtils.DateToStr(date, "yyyy-MM-dd");
/*     */                 }
/*     */                 else {
/*  75 */                   value = lkPerValue.toString().equals("") ? "null" : lkPerValue.toString();
/*     */                 }
/*     */ 
/*  78 */                 info.append(fieldLabel).append(":").append(value).append(";");
/*     */               }
/*     */             }
/*     */           } else {
/*  82 */             Object _value = BeanUtil.getPropertyValue(bo, field.getFieldName());
/*  83 */             if ((_value == null) || (((_value instanceof String)) && (_value.equals("")))) {
/*  84 */               value = "null";
/*     */             }
/*  88 */             else if (field.getFieldType() == 7) {
/*  89 */               EnumerationValue enuValue = EnumerationHelper.getEnumerationValue((Integer)_value);
/*  90 */               value = enuValue.getDescription();
/*     */             }
/*  93 */             else if ((_value instanceof Date)) {
/*  94 */               Date date = (Date)_value;
/*  95 */               value = StringUtils.DateToStr(date, "yyyy-MM-dd");
/*     */             }
/*  97 */             else if ((_value instanceof Timestamp)) {
/*  98 */               Timestamp time = (Timestamp)_value;
/*  99 */               Date date = new Date(time.getTime());
/* 100 */               value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
/*     */             }
/*     */             else {
/* 103 */               value = _value.toString();
/* 104 */               if (value.length() > 200) {
/* 105 */                 value = value.substring(0, 200) + "...";
/*     */               }
/*     */             }
/* 108 */             info.append(fieldLabel).append(":").append(value).append(";");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 113 */     return info.toString();
/*     */   }
/*     */ 
/*     */   public String postProcess(Object result) {
/* 117 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogRemoveAnalysisor
 * JD-Core Version:    0.6.0
 */