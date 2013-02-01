/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.apache.commons.collections.map.LinkedMap;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ import org.hi.framework.web.taglib.component.TagBuilder;
/*     */ import org.hi.framework.web.taglib.component.TagBuilderFactory;
/*     */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*     */ 
/*     */ public class EntitySelectTag extends AbstractTag
/*     */ {
/*     */   private String entityName;
/*     */   private String title;
/*     */   private String key;
/*     */   private String filterName;
/*     */   private String filterStr;
/*     */   private String defaultValue;
/*     */   private String pageInfo;
/*     */   private String isAll;
/*     */   private String pattern;
/*     */   private String onEvent;
/*     */ 
/*     */   public int doEndTag()
/*     */     throws JspException
/*     */   {
/*  37 */     evaluateParams();
/*     */ 
/*  39 */     TagBuilder builder = TagBuilderFactory.getEntityTagBuilder();
/*  40 */     SelectTagBean bean = new SelectTagBean();
/*  41 */     bean.setDefaultValue(getDefaultValue(getName()));
/*  42 */     bean.setOnEvent(this.onEvent);
/*  43 */     Map resultMapping = new LinkedMap();
/*  44 */     if (needAll())
/*  45 */       resultMapping.put("", "全部");
/*  46 */     Filter filter = getFilterObject();
/*     */     try {
/*  48 */       bean.setMapping(getContext(filter, resultMapping));
/*     */     } catch (ClassNotFoundException e1) {
/*  50 */       e1.printStackTrace();
/*     */     }
/*  52 */     bean.setParameters(getParameters());
/*  53 */     String html = builder.build(bean);
/*     */     try {
/*  55 */       this.pageContext.getOut().print(html);
/*     */     } catch (IOException e) {
/*  57 */       e.printStackTrace();
/*     */     }
/*  59 */     bean.setParameters(getParameters());
/*  60 */     return 6;
/*     */   }
/*     */ 
/*     */   public Map getContext(Filter filter, Map resultMapping) throws ClassNotFoundException {
/*  64 */     List result = loadObjects(filter);
/*  65 */     if ((result == null) || (result.size() == 0))
/*  66 */       return resultMapping;
/*  67 */     for (Iterator i = result.iterator(); i.hasNext(); ) {
/*  68 */       Object element = i.next();
/*  69 */       Object key = BeanUtil.getPropertyValue(element, this.key);
/*     */ 
/*  71 */       StringBuffer sb = new StringBuffer("");
/*  72 */       if ((this.pattern == null) || (this.pattern.trim().equals(""))) {
/*  73 */         sb.append(BeanUtil.getPropertyValue(element, this.title).toString());
/*     */       }
/*     */       else
/*     */       {
/*  77 */         List titleUnits = StringUtils.strToArrayList(this.title, this.pattern);
/*  78 */         int step = 0;
/*  79 */         for (String titleUnit : titleUnits) {
/*  80 */           if (step > 0) {
/*  81 */             sb.append(this.pattern);
/*     */           }
/*  83 */           sb.append(BeanUtil.getPropertyValue(element, titleUnit).toString());
/*     */ 
/*  85 */           step++;
/*     */         }
/*     */       }
/*     */ 
/*  89 */       resultMapping.put(key, sb.toString());
/*     */     }
/*     */ 
/*  92 */     return resultMapping;
/*     */   }
/*     */ 
/*     */   private boolean needAll() {
/*  96 */     return (this.isAll != null) && ("true".equals(this.isAll));
/*     */   }
/*     */ 
/*     */   public List loadObjects(Filter filter) throws ClassNotFoundException
/*     */   {
/* 101 */     ManagerImpl manager = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/* 102 */     List result = manager.getObjects(Class.forName(this.entityName), filter);
/* 103 */     return result;
/*     */   }
/*     */ 
/*     */   public Filter getFilterObject() {
/* 107 */     Filter filter = null;
/* 108 */     if ((this.filterName != null) && (!this.filterName.trim().equals(""))) {
/* 109 */       Object obj = this.pageContext.getRequest().getAttribute(this.filterName);
/* 110 */       if ((obj != null) && ((obj instanceof Filter))) {
/* 111 */         filter = (Filter)obj;
/*     */       }
/*     */     }
/* 114 */     Filter pageFilter = getPageInfoFilter();
/* 115 */     if ((pageFilter != null) && (filter != null))
/* 116 */       return filter.addFilter(pageFilter);
/* 117 */     if ((pageFilter != null) && (filter == null)) {
/* 118 */       return pageFilter;
/*     */     }
/* 120 */     return filter;
/*     */   }
/*     */ 
/*     */   private Filter getPageInfoFilter() {
/* 124 */     Filter filter = null;
/* 125 */     if ((this.pageInfo == null) || (this.pageInfo.trim().equals("")) || (this.filterStr == null) || (this.filterStr.trim().equals("")))
/* 126 */       return filter;
/* 127 */     PageInfoView pageInfo = null;
/*     */     try {
/* 129 */       pageInfo = (PageInfoView)Class.forName(this.pageInfo).newInstance();
/*     */     } catch (InstantiationException e) {
/* 131 */       e.printStackTrace();
/*     */     } catch (IllegalAccessException e) {
/* 133 */       e.printStackTrace();
/*     */     } catch (ClassNotFoundException e) {
/* 135 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 138 */     String[] propertyArray = StringUtils.strToStrArray(this.filterStr);
/* 139 */     for (String property : propertyArray) {
/* 140 */       String propertyName = property.substring(0, property.indexOf("="));
/* 141 */       String propertyValue = property.substring(property.indexOf("=") + 1);
/* 142 */       BeanUtil.ognlPropertyValue(pageInfo, propertyName, propertyValue);
/*     */     }
/* 144 */     filter = PageInfoUtil.populateFilter(pageInfo);
/* 145 */     return filter;
/*     */   }
/*     */ 
/*     */   private String getDefaultValue(String fieldName) {
/* 149 */     int pointIndex = 0;
/* 150 */     pointIndex = fieldName.indexOf(".");
/* 151 */     if ((pointIndex <= 1) || (pointIndex + 1 >= fieldName.length()))
/* 152 */       return "";
/* 153 */     String beanName = fieldName.substring(0, fieldName.indexOf("."));
/* 154 */     String beanFieldName = fieldName.substring(fieldName.indexOf(".") + 1);
/*     */ 
/* 156 */     Object bean = this.pageContext.getRequest().getAttribute(beanName);
/* 157 */     if (bean == null)
/* 158 */       return "";
/* 159 */     Object returnValue = BeanUtil.getPropertyValue(bean, beanFieldName);
/* 160 */     if (returnValue != null) {
/* 161 */       return returnValue.toString();
/*     */     }
/* 163 */     return "";
/*     */   }
/*     */ 
/*     */   public String getDefaultValue()
/*     */   {
/* 168 */     return this.defaultValue;
/*     */   }
/*     */   public void setDefaultValue(String defaultValue) {
/* 171 */     this.defaultValue = defaultValue;
/*     */   }
/*     */   public String getEntityName() {
/* 174 */     return this.entityName;
/*     */   }
/*     */   public void setEntityName(String entityName) {
/* 177 */     this.entityName = entityName;
/*     */   }
/*     */   public String getFilterName() {
/* 180 */     return this.filterName;
/*     */   }
/*     */   public void setFilterName(String filterName) {
/* 183 */     this.filterName = filterName;
/*     */   }
/*     */   public String getTitle() {
/* 186 */     return this.title;
/*     */   }
/*     */   public void setTitle(String title) {
/* 189 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getKey() {
/* 193 */     return this.key;
/*     */   }
/*     */ 
/*     */   public void setKey(String key) {
/* 197 */     this.key = key;
/*     */   }
/*     */ 
/*     */   public String getPageInfo() {
/* 201 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(String pageInfo) {
/* 205 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getFilterStr() {
/* 209 */     return this.filterStr;
/*     */   }
/*     */ 
/*     */   public void setFilterStr(String filterStr) {
/* 213 */     this.filterStr = filterStr;
/*     */   }
/*     */ 
/*     */   public String getIsAll() {
/* 217 */     return this.isAll;
/*     */   }
/*     */ 
/*     */   public void setIsAll(String isAll) {
/* 221 */     this.isAll = isAll;
/*     */   }
/*     */ 
/*     */   public String getPattern() {
/* 225 */     return this.pattern;
/*     */   }
/*     */ 
/*     */   public void setPattern(String pattern) {
/* 229 */     this.pattern = pattern;
/*     */   }
/*     */ 
/*     */   public String getOnEvent() {
/* 233 */     return this.onEvent;
/*     */   }
/*     */ 
/*     */   public void setOnEvent(String onEvent) {
/* 237 */     this.onEvent = onEvent;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.EntitySelectTag
 * JD-Core Version:    0.6.0
 */