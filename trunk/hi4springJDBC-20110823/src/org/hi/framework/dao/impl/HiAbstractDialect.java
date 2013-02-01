/*     */ package org.hi.framework.dao.impl;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.dao.DAO;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.HiDialect;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.metadata.hsc.HSCHelper;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ 
/*     */ public abstract class HiAbstractDialect
/*     */   implements HiDialect
/*     */ {
/*  23 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   protected void setupConditions(List<Entity> entities, StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*     */   {
/*  27 */     for (int i = 0; i < filterBeans.size(); i++) {
/*  28 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*  29 */       String operater = filterBean.getOperater();
/*  30 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0))
/*  31 */         mainSb.append("( ");
/*  32 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0))
/*  33 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*  34 */       if (i > 0) {
/*  35 */         mainSb.append(" ").append(filterBean.getRelations()).append(" ");
/*     */       }
/*  37 */       if ((aliasName != null) && (!aliasName.trim().equals("")))
/*     */       {
/*  40 */         String tableName = aliasName;
/*  41 */         if (entities.size() > 1) {
/*  42 */           String fieldName = filterBean.getFieldName();
/*  43 */           if (fieldName.contains("."))
/*  44 */             fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  45 */           for (int j = entities.size() - 1; j >= 0; j--) {
/*  46 */             List allFields = ((Entity)entities.get(j)).getField();
/*  47 */             for (Field field : allFields) {
/*  48 */               if (field.getFieldName().equals(fieldName)) {
/*  49 */                 tableName = ((Entity)entities.get(j)).getTableName();
/*  50 */                 break;
/*     */               }
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  58 */         if (!filterBean.getFieldName().contains(".")) {
/*  59 */           String fieldName = tableName + "." + filterBean.getFieldName();
/*  60 */           mainSb.append(fieldName).append(" ");
/*     */         }
/*     */         else {
/*  63 */           String[] fieldNames = filterBean.getFieldName().split("[.]");
/*  64 */           String fieldName = fieldNames[(fieldNames.length - 2)] + "." + fieldNames[(fieldNames.length - 1)];
/*  65 */           mainSb.append(fieldName).append(" ");
/*     */         }
/*     */       }
/*     */ 
/*  69 */       Object val = filterBean.getValue();
/*  70 */       if (val == null) {
/*  71 */         if (operater.equals("="))
/*  72 */           mainSb.append("IS NULL ");
/*     */         else
/*  74 */           mainSb.append("IS NOT NULL ");
/*     */       }
/*     */       else {
/*  77 */         mainSb.append(operater).append(" ");
/*     */ 
/*  79 */         if (filterBean.isNot()) {
/*  80 */           mainSb.append("NOT ");
/*     */         }
/*     */ 
/*  84 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  85 */           val = (String)filterBean.getValue();
/*     */ 
/*  87 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  88 */             val = "%" + val;
/*  89 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  90 */             val = val + "%";
/*  91 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  92 */             val = "%" + val + "%";
/*  93 */           filterBean.setValue(val);
/*     */         }
/*     */ 
/*  96 */         if (operater.equals("IN")) {
/*  97 */           mainSb.append("(");
/*  98 */           List coll = (List)filterBean.getValue();
/*  99 */           for (int j = 0; j < coll.size(); j++) {
/* 100 */             if (j > 0)
/* 101 */               mainSb.append(",");
/* 102 */             mainSb.append(setupConditionValue(coll.get(i)));
/*     */           }
/*     */ 
/* 105 */           mainSb.append(") ");
/*     */         }
/* 108 */         else if ((filterBean.getValue() instanceof BaseObject)) {
/* 109 */           mainSb.append(((BaseObject)filterBean.getValue()).getPrimarykey());
/*     */         } else {
/* 111 */           mainSb.append(setupConditionValue(filterBean.getValue()));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected abstract String getFeildToString(String paramString, FilterBean paramFilterBean);
/*     */ 
/*     */   protected String setupConditionValue(Object val) {
/* 118 */     if ((val instanceof String))
/* 119 */       return "'" + val + "'";
/* 120 */     if ((val instanceof Date))
/* 121 */       return "'" + StringUtils.DateToStr((Date)val, "yyyy-MM-dd") + "'";
/* 122 */     if ((val instanceof Timestamp)) {
/* 123 */       Timestamp timestamp = (Timestamp)val;
/* 124 */       return "'" + StringUtils.DateToStr(new Date(timestamp.getTime()), "yyyy-MM-dd hh:mm:ss") + "'";
/*     */     }
/*     */ 
/* 127 */     return val.toString();
/*     */   }
/*     */ 
/*     */   public String getFilterSQL(Filter filter, Manager manager)
/*     */   {
/* 132 */     if (manager.getDAO().getDialect() == null) {
/* 133 */       return null;
/*     */     }
/* 135 */     Entity entity = null;
/*     */     try
/*     */     {
/* 138 */       entity = HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), manager.getClass());
/*     */     } catch (Exception e) {
/* 140 */       this.log.error("not found Entity Define by className:" + manager.getClass().getName());
/*     */     }
/* 142 */     List entities = getSuperClassName(entity, null, null);
/*     */ 
/* 144 */     StringBuffer mainSb = new StringBuffer("");
/* 145 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/* 146 */       String tableName = entity.getTableName();
/* 147 */       String aliasName = (filter == null) || (filter.getAliasName() == null) ? tableName : filter.getAliasName();
/* 148 */       List filterBeans = filter.getConditions();
/*     */ 
/* 150 */       List filterGroup = filter.getFilterGroup();
/*     */ 
/* 152 */       if (filterGroup.size() < 2)
/* 153 */         setupConditions(entities, mainSb, filterBeans, aliasName, null);
/*     */       else {
/* 155 */         for (int i = 0; i < filterGroup.size(); i++) {
/* 156 */           List filtergroup = (List)filterGroup.get(i);
/* 157 */           setupConditions(entities, mainSb, filtergroup, aliasName, Integer.valueOf(i));
/* 158 */           mainSb.append(") ");
/*     */         }
/*     */       }
/*     */     }
/* 162 */     return mainSb.toString();
/*     */   }
/*     */ 
/*     */   private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity)
/*     */   {
/* 170 */     if (entitis == null) {
/* 171 */       entitis = new ArrayList();
/*     */     }
/* 173 */     String servletRootPath = SpringContextHolder.getServletContext().getRealPath("");
/* 174 */     Entity entity = null;
/*     */     try {
/* 176 */       if (obj != null) {
/* 177 */         if ((obj instanceof BaseObject))
/* 178 */           entity = HSCHelper.getEntity(servletRootPath, obj.getClass());
/* 179 */         if ((obj instanceof Class))
/* 180 */           entity = HSCHelper.getEntity(servletRootPath, (Class)obj);
/* 181 */         if ((obj instanceof Entity))
/* 182 */           entity = (Entity)obj;
/*     */       }
/*     */       else {
/* 185 */         entity = superEntity;
/*     */       }
/* 187 */       ExtendEntity extendEntity = entity.getExtendEntity();
/* 188 */       if ((extendEntity != null) && (extendEntity.getExtendEntityName() != null) && (!extendEntity.getExtendEntityName().trim().equals("")))
/*     */       {
/* 190 */         getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
/*     */       }
/*     */     } catch (Exception localException) {
/*     */     }
/* 194 */     if (entity != null) {
/* 195 */       entitis.add(entity);
/*     */     }
/* 197 */     return entitis;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.HiAbstractDialect
 * JD-Core Version:    0.6.0
 */