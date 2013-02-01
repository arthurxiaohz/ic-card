/*     */ package org.hi.framework.web;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.paging.impl.PageInfoImpl;
/*     */ 
/*     */ public class PageInfoUtil
/*     */ {
/*     */   public static PageInfo populate(PageInfoView pageInfoView, Action action)
/*     */   {
/*  49 */     if (pageInfoView == null) {
/*  50 */       pageInfoView = new PageInfoView();
/*     */     }
/*  52 */     PageInfo pageInfo = new PageInfoImpl();
/*     */ 
/*  55 */     if (pageInfoView.getCurrentPage() != 1) {
/*  56 */       pageInfoView.setIsFristPage(false);
/*     */     }
/*  58 */     if (pageInfoView.getIsFristPage()) {
/*  59 */       pageInfoView.setCurrentPage(1);
/*     */     }
/*  61 */     if (pageInfoView.getIsLastPage()) {
/*  62 */       pageInfoView.setCurrentPage(pageInfoView.getTotalPage());
/*     */     }
/*  64 */     pageInfoView.setStartRowPosition((pageInfoView.getCurrentPage() - 1) * pageInfoView.getPageSize());
/*     */ 
/*  66 */     int realRecords = pageInfoView.getStartRowPosition() + pageInfoView.getPageSize();
/*     */ 
/*  69 */     realRecords = (pageInfoView.getMaxRecords() != 0) && (pageInfoView.getMaxRecords() < realRecords) ? pageInfoView.getMaxRecords() : realRecords;
/*     */ 
/*  71 */     pageInfoView.setEndRowPosition(realRecords);
/*  72 */     pageInfo.setPage(pageInfoView);
/*     */ 
/*  76 */     Filter filter = null;
/*  77 */     filter = populateFilter(pageInfoView, "");
/*     */ 
/*  79 */     if (HiConfigHolder.getViewMode().equals("classic")) {
/*  80 */       sessionProcess(action, pageInfoView, filter);
/*     */     }
/*     */ 
/*  83 */     if (filter == null) {
/*  84 */       filter = FilterFactory.getSimpleFilter(null, null, null);
/*     */     }
/*  86 */     pageInfo.setFilter(filter);
/*     */ 
/*  90 */     Sorter sorter = null;
/*  91 */     if (BeanUtil.getPropertyValueToStr(pageInfoView, "sorterName") != null) {
/*  92 */       String sorterName = BeanUtil.getPropertyValueToStr(pageInfoView, "sorterName");
/*  93 */       String direction = BeanUtil.getPropertyValueToStr(pageInfoView, "sorterDirection");
/*  94 */       sorter = SorterFactory.getSimpleSort(sorterName, direction);
/*     */     }
/*     */ 
/*  97 */     pageInfo.setSorter(sorter);
/*     */ 
/*  99 */     return pageInfo;
/*     */   }
/*     */ 
/*     */   protected static void sessionProcess(Action action, PageInfoView pageInfoView, Filter filter)
/*     */   {
/* 105 */     if (action == null) {
/* 106 */       return;
/*     */     }
/* 108 */     HttpSession session = action.getSession();
/* 109 */     String prefix = "Hi_ListPageInfo_";
/* 110 */     String actionClassName = action.getClass().getName();
/* 111 */     String sessionAttributeName = prefix + actionClassName;
/* 112 */     boolean isUpdate = false;
/* 113 */     for (Enumeration en = session.getAttributeNames(); en.hasMoreElements(); ) {
/* 114 */       String attribName = (String)en.nextElement();
/* 115 */       if (!attribName.startsWith(prefix)) {
/*     */         continue;
/*     */       }
/* 118 */       if (!attribName.equals(sessionAttributeName)) {
/* 119 */         isUpdate = true;
/* 120 */         session.removeAttribute(attribName);
/* 121 */         session.setAttribute(sessionAttributeName, pageInfoView);
/* 122 */         break;
/*     */       }
/*     */ 
/* 126 */       if ((attribName.equals(sessionAttributeName)) && (filter == null) && (pageInfoView.getSorterName() == null) && (pageInfoView.getIsFristPage())) {
/* 127 */         isUpdate = true;
/* 128 */         PageInfoView o_pageView = (PageInfoView)session.getAttribute(sessionAttributeName);
/*     */ 
/* 130 */         PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pageInfoView);
/* 131 */         for (PropertyDescriptor descriptor : properties) {
/* 132 */           String propertyName = descriptor.getName();
/* 133 */           if (!propertyName.startsWith("f_"))
/*     */             continue;
/* 135 */           Object o_value = BeanUtil.getPropertyValue(o_pageView, propertyName);
/* 136 */           BeanUtil.setPropertyValue(pageInfoView, propertyName, o_value);
/*     */         }
/*     */ 
/* 139 */         pageInfoView.setCurrentPage(o_pageView.getCurrentPage());
/* 140 */         pageInfoView.setEndRowPosition(o_pageView.getEndRowPosition());
/* 141 */         pageInfoView.setMaxRecords(o_pageView.getMaxRecords());
/* 142 */         pageInfoView.setPageSize(o_pageView.getPageSize());
/* 143 */         pageInfoView.setSorterDirection(o_pageView.getSorterDirection());
/* 144 */         pageInfoView.setSorterName(o_pageView.getSorterName());
/* 145 */         pageInfoView.setStartRowPosition(o_pageView.getStartRowPosition());
/* 146 */         pageInfoView.setTotalPage(o_pageView.getTotalPage());
/* 147 */         pageInfoView.setTotalRecords(o_pageView.getTotalRecords());
/*     */ 
/* 149 */         filter = populateFilter(o_pageView, "");
/* 150 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 154 */     if (!isUpdate)
/* 155 */       session.setAttribute(sessionAttributeName, pageInfoView);
/*     */   }
/*     */ 
/*     */   public static PageInfo populate(PageInfoView pageInfoView)
/*     */   {
/* 165 */     return populate(pageInfoView, null);
/*     */   }
/*     */ 
/*     */   public static Filter populateFilter(PageInfoView pageInfoView)
/*     */   {
/* 176 */     return populateFilter(pageInfoView, "");
/*     */   }
/*     */ 
/*     */   protected static Filter populateFilter(PageInfoView pageInfoView, String prefix)
/*     */   {
/* 188 */     Filter filter = null;
/* 189 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pageInfoView);
/*     */ 
/* 192 */     Map nameAndpd = new LinkedHashMap();
/* 193 */     for (PropertyDescriptor descriptor : properties) {
/* 194 */       String propertyName = descriptor.getName();
/* 195 */       if (propertyName.startsWith("f_")) {
/* 196 */         nameAndpd.put(propertyName, descriptor);
/*     */       }
/*     */     }
/*     */ 
/* 200 */     Set propertyNames = nameAndpd.keySet();
/*     */     Object filterValue;
/*     */     String operator;
/* 202 */     for (String propertyName : propertyNames)
/*     */     {
/* 205 */       if (propertyName.endsWith("_op"))
/*     */       {
/*     */         continue;
/*     */       }
/* 209 */       filterValue = BeanUtil.getPropertyValue(pageInfoView, propertyName);
/* 210 */       if (filterValue == null)
/*     */         continue;
/* 212 */       if ((filterValue instanceof String)) {
/* 213 */         String valStr = (String)filterValue;
/* 214 */         if (valStr.trim().equals("")) {
/*     */           continue;
/*     */         }
/* 217 */         filterValue = StringUtils.trimRight(valStr);
/*     */       }
/*     */ 
/* 220 */       operator = propertyName + "_op";
/* 221 */       String operatorValue = BeanUtil.getPropertyValueToStr(pageInfoView, operator);
/* 222 */       if ((operatorValue != null) && (operatorValue.trim().equals(""))) {
/* 223 */         operatorValue = null;
/*     */       }
/*     */ 
/* 227 */       int manyIndex = propertyName.lastIndexOf("0");
/*     */       String filterName;
/* 228 */       if (manyIndex < 0)
/* 229 */         filterName = propertyName.substring("f_".length());
/*     */       else {
/* 231 */         filterName = propertyName.substring("f_".length(), manyIndex);
/*     */       }
/*     */ 
/* 234 */       String filterName = filterName.replaceAll("[$]", ".");
/*     */ 
/* 236 */       if (filter == null)
/* 237 */         filter = FilterFactory.getSimpleFilter(prefix + filterName, filterValue, operatorValue);
/*     */       else {
/* 239 */         filter.addCondition(prefix + filterName, filterValue, operatorValue);
/*     */       }
/*     */     }
/*     */ 
/* 243 */     for (PropertyDescriptor descriptor : properties) {
/* 244 */       String propertyName = descriptor.getName();
/* 245 */       Object obj = BeanUtil.getPropertyValue(pageInfoView, propertyName);
/* 246 */       if ((obj != null) && ((obj instanceof PageInfoView))) {
/* 247 */         PageInfoView pageInfo = (PageInfoView)obj;
/* 248 */         String pageInfoPrefix = propertyName + ".";
/* 249 */         if (!prefix.trim().equals("")) {
/* 250 */           pageInfoPrefix = prefix + pageInfoPrefix;
/*     */         }
/* 252 */         if (filter == null)
/* 253 */           filter = FilterFactory.getSimpleFilter(null, null, null);
/* 254 */         filter.addFilter(populateFilter(pageInfo, pageInfoPrefix));
/*     */       }
/*     */     }
/*     */ 
/* 258 */     return (Filter)filter;
/*     */   }
/*     */ 
/*     */   public static void POJOLookupNull(Object obj)
/*     */   {
/* 268 */     POJOLookupNull(obj, null);
/*     */   }
/*     */ 
/*     */   public static void POJOLookupNull(Object obj, String propertyNames)
/*     */   {
/* 278 */     POJOLookupNull(obj, propertyNames, null);
/*     */   }
/*     */ 
/*     */   private static void POJOLookupNull(Object obj, String propertyNames, Object parentObj)
/*     */   {
/* 283 */     Set proNames = null;
/* 284 */     if (propertyNames != null) {
/* 285 */       List pros = StringUtils.strToArrayList(propertyNames);
/* 286 */       proNames = new HashSet();
/* 287 */       for (String propery : pros) {
/* 288 */         proNames.add(propery);
/*     */       }
/*     */     }
/* 291 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(obj);
/* 292 */     for (PropertyDescriptor descriptor : properties) {
/* 293 */       String propertyName = descriptor.getName();
/* 294 */       Object domainObject = BeanUtil.getPropertyValue(obj, propertyName);
/*     */ 
/* 296 */       if (domainObject == null) {
/*     */         continue;
/*     */       }
/* 299 */       if ((domainObject instanceof BaseObject)) {
/* 300 */         if ((proNames != null) && (proNames.contains(propertyName))) {
/*     */           continue;
/*     */         }
/* 303 */         if (parentObj != null) {
/*     */           continue;
/*     */         }
/* 306 */         BeanUtil.setPropertyValue(obj, propertyName, null);
/*     */       }
/*     */ 
/* 309 */       if ((domainObject instanceof Collection)) {
/* 310 */         Collection coll = (Collection)domainObject;
/* 311 */         if (coll == null) {
/*     */           continue;
/*     */         }
/* 314 */         for (Iterator localIterator2 = coll.iterator(); localIterator2.hasNext(); ) { Object object = localIterator2.next();
/* 315 */           POJOLookupNull(object, propertyNames, obj);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.PageInfoUtil
 * JD-Core Version:    0.6.0
 */