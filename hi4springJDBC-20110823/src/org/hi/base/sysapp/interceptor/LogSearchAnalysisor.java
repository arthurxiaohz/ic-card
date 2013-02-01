/*     */ package org.hi.base.sysapp.interceptor;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.hi.base.enumeration.EnumerationHelper;
/*     */ import org.hi.base.enumeration.model.EnumerationValue;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterBean;
/*     */ import org.hi.framework.dao.impl.LikeFilter;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.metadata.hsc.HSCHelper;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ 
/*     */ public class LogSearchAnalysisor extends AbstractLogAnalysisor
/*     */ {
/*     */   public String perProcess(Object[] args, Entity entity, Manager manager)
/*     */   {
/*  32 */     StringBuffer conditions = new StringBuffer("筛选条件:");
/*  33 */     StringBuffer parameters = new StringBuffer("参数信息:");
/*  34 */     boolean hasParameter = false;
/*  35 */     for (int i = 0; i < args.length; i++) {
/*  36 */       if ((args[i] instanceof PageInfo)) {
/*  37 */         PageInfo pageInfo = (PageInfo)args[i];
/*  38 */         getFilerInfo(pageInfo.getFilter(), entity, conditions);
/*     */       }
/*  40 */       if ((args[i] instanceof Filter)) {
/*  41 */         Filter filter = (Filter)args[i];
/*  42 */         getFilerInfo(filter, entity, conditions);
/*     */       }
/*  44 */       if ((!(args[i] instanceof String)) || 
/*  45 */         (args[i] == null)) continue;
/*  46 */       parameters.append(args[i]);
/*  47 */       hasParameter = true;
/*     */     }
/*     */ 
/*  52 */     if (hasParameter) {
/*  53 */       conditions.append("\n").append(parameters);
/*     */     }
/*  55 */     return conditions.toString();
/*     */   }
/*     */ 
/*     */   protected void getFilerInfo(Filter filter, Entity entity, StringBuffer conditions) {
/*  59 */     if (filter.getConditions().size() == 0) {
/*  60 */       conditions.append("无");
/*  61 */       return;
/*     */     }
/*  63 */     List filterBeans = filter.getConditions();
/*  64 */     for (int i = 0; i < filterBeans.size(); i++) {
/*  65 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*  66 */       if (i > 0)
/*  67 */         conditions.append(" ").append(filterBean.getRelations()).append(" ");
/*  68 */       String name = null;
/*  69 */       Object value = filterBean.getValue();
/*     */       try {
/*  71 */         Field field = HSCHelper.getField(org.hi.framework.web.ServletContext.getServletContext().getRealPath(""), entity, filterBean.getFieldName());
/*  72 */         name = field.getFieldLabel();
/*  73 */         if (value != null) {
/*  74 */           if (field.getFieldType() == 7) {
/*  75 */             EnumerationValue enuValue = EnumerationHelper.getEnumerationValue((Integer)value);
/*  76 */             value = enuValue.getDescription();
/*     */           }
/*  78 */           if ((value instanceof Date)) {
/*  79 */             Date date = (Date)value;
/*  80 */             value = StringUtils.DateToStr(date, "yyyy-MM-dd");
/*     */           }
/*  82 */           if ((value instanceof Timestamp)) {
/*  83 */             Timestamp time = (Timestamp)value;
/*  84 */             Date date = new Date(time.getTime());
/*  85 */             value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/*  90 */         name = filterBean.getFieldName();
/*     */       }
/*     */ 
/*  93 */       conditions.append(name).append(" ");
/*     */ 
/*  95 */       if (filterBean.isNot()) {
/*  96 */         conditions.append("NO ");
/*     */       }
/*  98 */       String operater = filterBean.getOperater();
/*  99 */       conditions.append(operater).append(" ");
/*     */ 
/* 101 */       int lkControler = filterBean.getLikeControler();
/* 102 */       if ((operater.equals("LIKE")) && ((LikeFilter.LIKE_CONTROLER_LEFT == lkControler) || 
/* 103 */         (LikeFilter.LIKE_CONTROLER_ALL == lkControler))) {
/* 104 */         conditions.append("%");
/*     */       }
/*     */ 
/* 107 */       conditions.append(value);
/*     */ 
/* 109 */       if ((!operater.equals("LIKE")) || ((LikeFilter.LIKE_CONTROLER_RIGHT != lkControler) && 
/* 110 */         (LikeFilter.LIKE_CONTROLER_ALL != lkControler))) continue;
/* 111 */       conditions.append("%");
/*     */     }
/*     */   }
/*     */ 
/*     */   public String postProcess(Object result) {
/* 116 */     String count = null;
/* 117 */     if (result == null) count = "0";
/*     */ 
/* 119 */     if ((result instanceof Collection)) {
/* 120 */       Collection coll = (Collection)result;
/* 121 */       count = String.valueOf(coll.size());
/*     */     }
/* 123 */     else if ((result instanceof Array)) {
/* 124 */       count = String.valueOf(Array.getLength(result));
/*     */     } else {
/* 126 */       count = "1";
/* 127 */     }return "\n记录数:" + count;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogSearchAnalysisor
 * JD-Core Version:    0.6.0
 */