/*     */ package org.hi.framework.web.webwork;
/*     */ 
/*     */ import com.opensymphony.xwork.ActionContext;
/*     */ import com.opensymphony.xwork.ActionInvocation;
/*     */ import com.opensymphony.xwork.interceptor.AroundInterceptor;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.SynchronizationData;
/*     */ 
/*     */ public class LoadObjectInterceptor extends AroundInterceptor
/*     */ {
/*     */   protected void after(ActionInvocation dispatcher, String result)
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void before(ActionInvocation invocation)
/*     */     throws Exception
/*     */   {
/*  41 */     BaseAction action = (BaseAction)invocation.getAction();
/*  42 */     if (!(action instanceof SynchronizationData)) {
/*  43 */       return;
/*     */     }
/*  45 */     PropertyDescriptor[] actionProperties = PropertyUtils.getPropertyDescriptors(action);
/*     */ 
/*  47 */     for (PropertyDescriptor actionDescriptor : actionProperties)
/*     */     {
/*  50 */       Class ObjClazz = actionDescriptor.getPropertyType();
/*  51 */       if ((!BaseObject.class.isAssignableFrom(ObjClazz)) && (!Collection.class.isAssignableFrom(ObjClazz)))
/*     */       {
/*     */         continue;
/*     */       }
/*  55 */       String propertyName = actionDescriptor.getName();
/*  56 */       Object mergeObject = null;
/*     */ 
/*  59 */       if (BaseObject.class.isAssignableFrom(ObjClazz)) {
/*  60 */         BaseObject obj = (BaseObject)BeanUtil.getPropertyValue(action, propertyName);
/*     */ 
/*  62 */         if (obj == null) {
/*     */           continue;
/*     */         }
/*  65 */         mergeObject = assemblingObject(obj, action, invocation);
/*     */       }
/*     */ 
/*  70 */       if (Collection.class.isAssignableFrom(ObjClazz)) {
/*  71 */         Collection obj = (Collection)BeanUtil.getPropertyValue(action, propertyName);
/*     */ 
/*  73 */         if (obj == null) {
/*     */           continue;
/*     */         }
/*  76 */         if (obj.size() == 0) {
/*  77 */           mergeObject = obj;
/*     */         }
/*     */         else {
/*  80 */           mergeObject = new ArrayList();
/*  81 */           for (Iterator iter = obj.iterator(); iter.hasNext(); ) {
/*  82 */             Object element = iter.next();
/*     */ 
/*  85 */             if (!BaseObject.class.isAssignableFrom(element.getClass())) {
/*  86 */               mergeObject = obj;
/*  87 */               break;
/*     */             }
/*     */ 
/*  90 */             BaseObject baseObject = (BaseObject)element;
/*     */ 
/*  93 */             ((Collection)mergeObject).add(assemblingObject(baseObject, action, invocation));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 106 */         BeanUtil.setPropertyValue(action, propertyName, mergeObject);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private BaseObject assemblingObject(BaseObject obj, BaseAction action, ActionInvocation invocation)
/*     */     throws InstantiationException, IllegalAccessException, BusinessException
/*     */   {
/* 117 */     if (obj.getPrimarykey() == null) {
/* 118 */       ObjectNew(obj, null);
/* 119 */       return obj;
/*     */     }
/*     */ 
/* 122 */     BaseObject persistence = loadObject(obj);
/*     */ 
/* 124 */     merageObject(persistence, obj, null, action, invocation);
/*     */ 
/* 126 */     return persistence;
/*     */   }
/*     */ 
/*     */   private void ObjectNew(BaseObject obj, BaseObject parentObj) {
/* 130 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(obj);
/*     */ 
/* 133 */     obj.setDirty(true);
/*     */ 
/* 136 */     for (PropertyDescriptor descriptor : properties) {
/* 137 */       String propertyName = descriptor.getName();
/* 138 */       Object domainObject = BeanUtil.getPropertyValue(obj, propertyName);
/*     */ 
/* 140 */       if (descriptor.getWriteMethod() == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 144 */       if (domainObject == null) {
/*     */         continue;
/*     */       }
/* 147 */       if (parentObj == domainObject) {
/*     */         continue;
/*     */       }
/* 150 */       if ((domainObject instanceof BaseObject)) {
/* 151 */         BaseObject bo = (BaseObject)domainObject;
/* 152 */         if (bo.getPrimarykey() == null) {
/* 153 */           BeanUtil.setPropertyValue(obj, propertyName, null);
/*     */         } else {
/* 155 */           Object val = loadObject(bo);
/* 156 */           if (val == null)
/* 157 */             BeanUtil.setPropertyValue(obj, propertyName, null);
/*     */           else {
/* 159 */             BeanUtil.setPropertyValue(obj, propertyName, val);
/*     */           }
/*     */         }
/*     */       }
/* 163 */       if ((domainObject instanceof Collection)) {
/* 164 */         Collection coll = (Collection)domainObject;
/* 165 */         if (coll == null) {
/*     */           continue;
/*     */         }
/* 168 */         for (Iterator localIterator = coll.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 169 */           if (object != null)
/* 170 */             ObjectNew((BaseObject)object, obj); }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void merageObject(BaseObject pObj, BaseObject vObj, BaseObject parentObj, BaseAction action, ActionInvocation invocation)
/*     */     throws InstantiationException, IllegalAccessException, BusinessException
/*     */   {
/* 178 */     boolean equalsClass = vObj.getClass().equals(pObj.getClass());
/*     */ 
/* 180 */     Set v_PropertyNams = new HashSet();
/* 181 */     if (!equalsClass) {
/* 182 */       PropertyDescriptor[] v_properties = PropertyUtils.getPropertyDescriptors(vObj);
/* 183 */       for (PropertyDescriptor v_descriptor : v_properties) {
/* 184 */         v_PropertyNams.add(v_descriptor.getName());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 189 */     vObj.setDirty(false);
/* 190 */     pObj.setDirty(false);
/*     */ 
/* 192 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pObj);
/* 193 */     for (PropertyDescriptor descriptor : properties) {
/* 194 */       String propertyName = descriptor.getName();
/* 195 */       Class clazz = descriptor.getPropertyType();
/*     */ 
/* 197 */       if (descriptor.getWriteMethod() == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 201 */       if ((!equalsClass) && (!v_PropertyNams.contains(propertyName))) {
/*     */         continue;
/*     */       }
/* 204 */       Set parameterNames = invocation.getInvocationContext().getParameters().keySet();
/*     */ 
/* 206 */       Object v_value = BeanUtil.getPropertyValue(vObj, propertyName);
/* 207 */       if ((v_value == null) && (notIncludParameterName(parameterNames, propertyName))) {
/*     */         continue;
/*     */       }
/* 210 */       if ((clazz.isInterface()) && (!(v_value instanceof Collection))) {
/*     */         continue;
/*     */       }
/* 213 */       if ((parentObj != null) && (v_value == parentObj)) {
/*     */         continue;
/*     */       }
/* 216 */       if (propertyName.equals("dirty"))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 222 */       Object p_value = BeanUtil.getPropertyValue(pObj, propertyName);
/*     */ 
/* 225 */       if ((propertyName.equals("version")) && (v_value != null) && (!v_value.equals(p_value))) {
/* 226 */         action.setErrorObject(vObj);
/*     */       }
/*     */ 
/* 230 */       if ((parentObj != null) && (propertyName.equals("version")) && (v_value == null)) {
/* 231 */         v_value = p_value;
/*     */       }
/*     */ 
/* 234 */       if ((!(v_value instanceof Collection)) && (!(v_value instanceof BaseObject))) {
/* 235 */         BeanUtil.setPropertyValue(pObj, propertyName, v_value);
/*     */       }
/*     */ 
/* 239 */       if ((v_value instanceof BaseObject)) {
/* 240 */         BaseObject v_bo_obj = (BaseObject)v_value;
/* 241 */         BaseObject p_bo_obj = (BaseObject)p_value;
/* 242 */         if (v_bo_obj.getPrimarykey() == null) {
/*     */           continue;
/*     */         }
/* 245 */         if ((p_value != null) && (v_bo_obj.getPrimarykey().equals(p_bo_obj.getPrimarykey()))) {
/*     */           continue;
/*     */         }
/* 248 */         Object val = null;
/* 249 */         if (Integer.parseInt(v_bo_obj.getPrimarykey().toString()) >= 0) {
/* 250 */           val = loadObject(v_bo_obj);
/*     */         }
/*     */ 
/* 254 */         BeanUtil.setPropertyValue(pObj, propertyName, val);
/*     */       }
/*     */ 
/* 257 */       if ((p_value instanceof Collection)) {
/* 258 */         List p_coll = (List)p_value;
/* 259 */         List _v_coll = (List)v_value;
/* 260 */         List v_coll = new ArrayList();
/*     */         BaseObject element;
/* 262 */         for (Iterator iter = _v_coll.iterator(); iter.hasNext(); ) {
/* 263 */           element = (BaseObject)iter.next();
/* 264 */           if (element == null) {
/*     */             continue;
/*     */           }
/* 267 */           element.setParentEntity(pObj);
/* 268 */           v_coll.add(element);
/*     */         }
/*     */ 
/* 271 */         if (p_coll.size() == 0) {
/* 272 */           for (element = v_coll.iterator(); element.hasNext(); ) { Object object = element.next();
/* 273 */             if (object == null)
/*     */               continue;
/* 275 */             ObjectNew((BaseObject)object, pObj);
/* 276 */             p_coll.add(object);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 281 */           int p_index = p_coll.size();
/* 282 */           int v_index = v_coll.size();
/* 283 */           int length = v_index - p_index;
/* 284 */           for (int i = 0; i < v_index - length; i++) {
/* 285 */             merageObject((BaseObject)p_coll.get(i), (BaseObject)v_coll.get(i), pObj, action, invocation);
/*     */           }
/* 287 */           for (int i = 0; i < length; i++) {
/* 288 */             ObjectNew((BaseObject)v_coll.get(v_index - length + i), pObj);
/* 289 */             p_coll.add(v_coll.get(v_index - length + i));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private BaseObject loadObject(BaseObject obj) {
/* 297 */     Serializable id = obj.getPrimarykey();
/* 298 */     ManagerImpl manager = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/* 299 */     Object value = manager.getObjectById(obj.getClass(), id);
/* 300 */     if (value == null)
/* 301 */       return null;
/* 302 */     return (BaseObject)value;
/*     */   }
/*     */ 
/*     */   private boolean notIncludParameterName(Set<String> parameterNames, String propertyName) {
/* 306 */     for (String parameterName : parameterNames) {
/* 307 */       if (parameterName.contains(propertyName))
/* 308 */         return false;
/*     */     }
/* 310 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.webwork.LoadObjectInterceptor
 * JD-Core Version:    0.6.0
 */