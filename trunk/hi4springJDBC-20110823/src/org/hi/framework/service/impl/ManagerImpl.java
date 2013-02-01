/*     */ package org.hi.framework.service.impl;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import org.hi.framework.dao.DAO;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.paging.Page;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.paging.impl.PageImpl;
/*     */ import org.hi.framework.paging.impl.PageInfoImpl;
/*     */ import org.hi.framework.security.acegi.MethodConfigAttributeDefHolder;
/*     */ 
/*     */ public class ManagerImpl extends AbstractBaseManager
/*     */ {
/*  17 */   protected Class modelClass = null;
/*     */ 
/*     */   public Class getModelClass()
/*     */   {
/*  23 */     return this.modelClass;
/*     */   }
/*     */ 
/*     */   public void setModelClass(Class modelClass) {
/*  27 */     this.modelClass = modelClass;
/*     */   }
/*     */ 
/*     */   public void removeObjectById(Serializable id)
/*     */   {
/*  34 */     removeObjectById(this.modelClass, id);
/*     */   }
/*     */ 
/*     */   public Object getObjectById(Serializable id)
/*     */   {
/*  41 */     return getObjectById(this.modelClass, id);
/*     */   }
/*     */ 
/*     */   public Object getUniqueObject(Filter filter)
/*     */   {
/*  48 */     return getUniqueObject(this.modelClass, filter);
/*     */   }
/*     */ 
/*     */   public List getObjects()
/*     */   {
/*  55 */     return getObjects(this.modelClass);
/*     */   }
/*     */ 
/*     */   public List getObjects(Filter filter)
/*     */   {
/*  62 */     return getObjects(this.modelClass, filter);
/*     */   }
/*     */ 
/*     */   public List getObjects(Filter filter, Sorter sorter)
/*     */   {
/*  69 */     return getObjects(this.modelClass, filter, sorter);
/*     */   }
/*     */ 
/*     */   public List getObjects(Filter filter, Sorter sorter, Page page)
/*     */   {
/*  76 */     return getObjects(this.modelClass, filter, sorter, page);
/*     */   }
/*     */ 
/*     */   public List getObjects(PageInfo pageInfo)
/*     */   {
/*  83 */     return getObjects(this.modelClass, pageInfo);
/*     */   }
/*     */ 
/*     */   public List getList(PageInfo pageInfo)
/*     */   {
/*  90 */     return getObjects(this.modelClass, pageInfo);
/*     */   }
/*     */ 
/*     */   public int getObjectCount() {
/*  94 */     return getObjectCount(this.modelClass);
/*     */   }
/*     */ 
/*     */   public int getObjectCount(Filter filter) {
/*  98 */     return this.dao.getObjectCount(this.modelClass, filter);
/*     */   }
/*     */ 
/*     */   public List<Object> getObjectsForLookup(Class clazz, String value, String searchFields_str, String authorityNames)
/*     */   {
/* 110 */     return getObjectsForLookup(clazz, value, searchFields_str, authorityNames, null);
/*     */   }
/*     */ 
/*     */   public List<Object> getObjectsForLookup(Class clazz, String value, String searchFields_str, String authorityNames, PageInfo pageInfo)
/*     */   {
/* 123 */     String[] searchFields = searchFields_str.split(",");
/*     */ 
/* 125 */     Filter filter = null;
/*     */ 
/* 127 */     if ((value != null) && (!value.equals(""))) {
/* 128 */       for (int i = 0; i < searchFields.length; i++)
/*     */       {
/* 130 */         if (filter == null)
/* 131 */           filter = FilterFactory.getSimpleFilter(searchFields[i], value);
/*     */         else
/* 133 */           filter.addCondition(searchFields[i], value, null, "OR");
/*     */       }
/*     */     }
/* 136 */     if ((authorityNames != null) && (!authorityNames.equals("")))
/*     */     {
/* 138 */       MethodConfigAttributeDefHolder.createConfigAttributeDefinition(authorityNames);
/* 139 */       Filter privileteFilter = FilterFactory.getSecurityFilter();
/* 140 */       MethodConfigAttributeDefHolder.setConfigAttributeDefinition(null);
/* 141 */       if (filter == null)
/* 142 */         filter = privileteFilter;
/*     */       else {
/* 144 */         filter.addFilter(privileteFilter, "AND");
/*     */       }
/*     */     }
/*     */ 
/* 148 */     if (pageInfo == null) {
/* 149 */       pageInfo = new PageInfoImpl();
/* 150 */       Page page = new PageImpl();
/* 151 */       pageInfo.setFilter(filter);
/* 152 */       pageInfo.setPage(page);
/*     */     }
/*     */     else {
/* 155 */       pageInfo.setFilter(filter);
/*     */     }
/* 157 */     List list = getObjects(clazz, pageInfo);
/*     */ 
/* 159 */     return list;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.service.impl.ManagerImpl
 * JD-Core Version:    0.6.0
 */