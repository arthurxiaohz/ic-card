/*     */ package org.hi.framework.service.impl;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.attachment.model.Attachment;
/*     */ import org.hi.common.attachment.service.AttachmentManager;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.dao.DAO;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.paging.Page;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.PostRemoveObjectCallback;
/*     */ import org.hi.framework.service.PreSaveObjectCallback;
/*     */ import org.springframework.beans.factory.NoSuchBeanDefinitionException;
/*     */ 
/*     */ public abstract class AbstractBaseManager
/*     */   implements Manager
/*     */ {
/*  31 */   protected DAO dao = null;
/*     */ 
/*  33 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public void setDAO(DAO dao) {
/*  36 */     this.dao = dao;
/*     */   }
/*     */ 
/*     */   public DAO getDAO() {
/*  40 */     return this.dao;
/*     */   }
/*     */ 
/*     */   public void saveObject(Object obj)
/*     */   {
/*  47 */     preSaveObject(obj);
/*  48 */     this.dao.saveObject(obj);
/*  49 */     postSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void preSaveObject(Object obj)
/*     */   {
/*  59 */     PreSaveObjectCallback callback = null;
/*     */     try {
/*  61 */       callback = (PreSaveObjectCallback)SpringContextHolder.getBean(PreSaveObjectCallback.class);
/*     */     }
/*     */     catch (NoSuchBeanDefinitionException localNoSuchBeanDefinitionException) {
/*     */     }
/*  65 */     if (callback != null)
/*  66 */       callback.savePreObjectProcess(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void removeObjectById(Class clazz, Serializable id)
/*     */   {
/*  78 */     Object obj = getObjectById(clazz, id);
/*  79 */     removeObject(obj);
/*     */   }
/*     */ 
/*     */   public void removeObject(Object obj)
/*     */   {
/*  86 */     preRemoveObject(obj);
/*     */ 
/*  88 */     if ((obj instanceof BaseObject)) {
/*  89 */       BaseObject bo = (BaseObject)obj;
/*  90 */       if (!bo.isDeletedFlag())
/*     */       {
/*  92 */         if (!(obj instanceof Attachment)) {
/*  93 */           processAttachment((BaseObject)obj);
/*     */         }
/*  95 */         this.dao.removeObject(obj);
/*     */       }
/*     */       else {
/*  98 */         BeanUtil.setPropertyValue(obj, "deleted", new Integer(1));
/*  99 */         this.dao.saveObject(obj);
/*     */       }
/*     */     }
/*     */     else {
/* 103 */       this.dao.removeObject(obj);
/*     */     }
/*     */ 
/* 106 */     postRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   private void processAttachment(Object obj) {
/* 110 */     if (!(obj instanceof BaseObject)) {
/* 111 */       return;
/*     */     }
/* 113 */     PropertyDescriptor[] actionProperties = PropertyUtils.getPropertyDescriptors(obj);
/* 114 */     for (int i = 0; i < actionProperties.length; i++) {
/* 115 */       PropertyDescriptor propertyDescriptor = actionProperties[i];
/* 116 */       Class ObjClazz = propertyDescriptor.getPropertyType();
/* 117 */       String propertyName = propertyDescriptor.getName();
/*     */ 
/* 120 */       if (Collection.class.isAssignableFrom(ObjClazz)) {
/* 121 */         Collection coll = (Collection)BeanUtil.getPropertyValue(obj, propertyName);
/* 122 */         if ((coll == null) || (coll.size() == 0))
/*     */           continue;
/* 124 */         for (Iterator localIterator = coll.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 125 */           processAttachment(object);
/*     */         }
/*     */       }
/*     */ 
/* 129 */       if (Attachment.class.isAssignableFrom(ObjClazz)) {
/* 130 */         Attachment att = (Attachment)BeanUtil.getPropertyValue(obj, propertyName);
/* 131 */         removeAttachment(att);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void removeAttachment(Attachment att) {
/* 137 */     if ((att == null) || (att.getAttachmentPath() == null)) {
/* 138 */       return;
/*     */     }
/*     */ 
/* 141 */     String prefix = org.hi.framework.web.ServletContext.getServletContext().getRealPath("/");
/* 142 */     File attFile = new File(prefix + att.getAttachmentPath());
/* 143 */     if (!attFile.isFile())
/* 144 */       return;
/* 145 */     attFile.delete();
/* 146 */     AttachmentManager attMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 147 */     attMgr.removeObject(att);
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/* 165 */     PostRemoveObjectCallback callback = null;
/*     */     try {
/* 167 */       callback = (PostRemoveObjectCallback)SpringContextHolder.getBean(PostRemoveObjectCallback.class);
/*     */     }
/*     */     catch (NoSuchBeanDefinitionException localNoSuchBeanDefinitionException) {
/*     */     }
/* 171 */     if (callback != null)
/* 172 */       callback.removePostObjectProcess(obj);
/*     */   }
/*     */ 
/*     */   public Object getObjectById(Class clazz, Serializable id)
/*     */   {
/* 177 */     Object obj = this.dao.getObjectById(clazz, id);
/* 178 */     if (obj == null)
/*     */       try {
/* 180 */         obj = clazz.newInstance();
/*     */       } catch (InstantiationException e) {
/* 182 */         e.printStackTrace();
/*     */       } catch (IllegalAccessException e) {
/* 184 */         e.printStackTrace();
/*     */       }
/* 186 */     return obj;
/*     */   }
/*     */ 
/*     */   public Object getUniqueObject(Class clazz, Filter filter) {
/* 190 */     Filter delFilter = deletedFilter(clazz);
/*     */ 
/* 193 */     if ((delFilter != null) && (filter != null))
/* 194 */       filter.addFilter(delFilter);
/* 195 */     if (filter == null) {
/* 196 */       filter = delFilter;
/*     */     }
/* 198 */     return this.dao.getUniqueObject(clazz, filter);
/*     */   }
/*     */ 
/*     */   public List getObjects(Class clazz) {
/* 202 */     Filter delFilter = deletedFilter(clazz);
/* 203 */     if (delFilter == null) {
/* 204 */       return this.dao.getObjects(clazz);
/*     */     }
/* 206 */     return this.dao.getObjects(clazz, delFilter);
/*     */   }
/*     */ 
/*     */   public List getObjects(Class clazz, Filter filter) {
/* 210 */     Filter delFilter = deletedFilter(clazz);
/* 211 */     if ((delFilter != null) && (filter != null))
/* 212 */       filter.addFilter(delFilter);
/* 213 */     if (filter == null)
/* 214 */       filter = delFilter;
/* 215 */     return this.dao.getObjects(clazz, filter);
/*     */   }
/*     */ 
/*     */   public List getObjects(Class clazz, Filter filter, Sorter soter) {
/* 219 */     Filter delFilter = deletedFilter(clazz);
/* 220 */     if ((delFilter != null) && (filter != null))
/* 221 */       filter.addFilter(delFilter);
/* 222 */     if (filter == null)
/* 223 */       filter = delFilter;
/* 224 */     return this.dao.getObjects(clazz, filter, soter);
/*     */   }
/*     */ 
/*     */   public List getObjects(Class clazz, Filter filter, Sorter sorter, Page page) {
/* 228 */     Filter delFilter = deletedFilter(clazz);
/* 229 */     if ((delFilter != null) && (filter != null))
/* 230 */       filter.addFilter(delFilter);
/* 231 */     if (filter == null)
/* 232 */       filter = delFilter;
/* 233 */     return this.dao.getObjects(clazz, filter, sorter, page);
/*     */   }
/*     */ 
/*     */   public List getObjects(Class clazz, PageInfo pageInfo) {
/* 237 */     Filter delFilter = deletedFilter(clazz);
/* 238 */     if (delFilter != null)
/* 239 */       pageInfo.setFilter(delFilter);
/* 240 */     return this.dao.getObjects(clazz, pageInfo);
/*     */   }
/*     */ 
/*     */   public int getObjectCount(Class clazz) {
/* 244 */     return getObjectCount(clazz, null);
/*     */   }
/*     */ 
/*     */   public int getObjectCount(Class clazz, Filter filter) {
/* 248 */     Filter delFilter = deletedFilter(clazz);
/* 249 */     if ((delFilter != null) && (filter != null))
/* 250 */       filter.addFilter(delFilter);
/* 251 */     if (filter == null)
/* 252 */       filter = delFilter;
/* 253 */     return this.dao.getObjectCount(clazz, filter);
/*     */   }
/*     */ 
/*     */   public List getList(PageInfo pageInfo, Filter securityFilter)
/*     */   {
/* 264 */     return null;
/*     */   }
/*     */ 
/*     */   private Filter deletedFilter(Class clazz)
/*     */   {
/* 269 */     if (BeanUtil.hasPropertyName(BeanUtil.CreateObject(clazz.getName()), "deleted")) {
/* 270 */       Filter filter = FilterFactory.getSimpleFilter("deleted", new Integer(1), "<>")
/* 271 */         .addCondition("deleted", null, "=", "OR");
/* 272 */       return filter;
/*     */     }
/* 274 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.service.impl.AbstractBaseManager
 * JD-Core Version:    0.6.0
 */