/*     */ package org.hi.framework.web.struts;
/*     */ 
/*     */ import com.opensymphony.xwork2.ActionContext;
/*     */ import com.opensymphony.xwork2.ActionInvocation;
/*     */ import com.opensymphony.xwork2.ActionProxy;
/*     */ import com.opensymphony.xwork2.interceptor.PrepareInterceptor;
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
/*     */ public class LoadObjectInterceptor extends PrepareInterceptor
/*     */ {
/*     */   public String doIntercept(ActionInvocation invocation)
/*     */     throws Exception
/*     */   {
/*  40 */     BaseAction action = (BaseAction)invocation.getAction();
/*  41 */     String actionName = invocation.getProxy().getActionName();
/*  42 */     String methodName = invocation.getProxy().getMethod();
/*  43 */     if ((actionName.toUpperCase().indexOf("SAVE") < 0) && (methodName.toUpperCase().indexOf("UPDATE") < 0) && (!(action instanceof SynchronizationData))) {
/*  44 */       String result = invocation.invoke();
/*  45 */       return result;
/*     */     }
/*     */ 
/*  48 */     PropertyDescriptor[] actionProperties = PropertyUtils.getPropertyDescriptors(action);
/*     */ 
/*  50 */     for (PropertyDescriptor actionDescriptor : actionProperties)
/*     */     {
/*  53 */       Class ObjClazz = actionDescriptor.getPropertyType();
/*  54 */       if ((!BaseObject.class.isAssignableFrom(ObjClazz)) && (!Collection.class.isAssignableFrom(ObjClazz)))
/*     */       {
/*     */         continue;
/*     */       }
/*  58 */       String propertyName = actionDescriptor.getName();
/*  59 */       Object mergeObject = null;
/*     */ 
/*  62 */       if (BaseObject.class.isAssignableFrom(ObjClazz)) {
/*  63 */         BaseObject obj = (BaseObject)BeanUtil.getPropertyValue(action, propertyName);
/*     */ 
/*  65 */         if (obj == null) {
/*     */           continue;
/*     */         }
/*  68 */         mergeObject = assemblingObject(obj, action, invocation);
/*     */       }
/*     */ 
/*  73 */       if (Collection.class.isAssignableFrom(ObjClazz)) {
/*  74 */         Collection obj = (Collection)BeanUtil.getPropertyValue(action, propertyName);
/*     */ 
/*  76 */         if (obj == null) {
/*     */           continue;
/*     */         }
/*  79 */         if (obj.size() == 0) {
/*  80 */           mergeObject = obj;
/*     */         }
/*     */         else {
/*  83 */           mergeObject = new ArrayList();
/*  84 */           for (Iterator iter = obj.iterator(); iter.hasNext(); ) {
/*  85 */             Object element = iter.next();
/*     */ 
/*  88 */             if (!BaseObject.class.isAssignableFrom(element.getClass())) {
/*  89 */               mergeObject = obj;
/*  90 */               break;
/*     */             }
/*     */ 
/*  93 */             BaseObject baseObject = (BaseObject)element;
/*     */ 
/*  96 */             ((Collection)mergeObject).add(assemblingObject(baseObject, action, invocation));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 109 */         BeanUtil.setPropertyValue(action, propertyName, mergeObject);
/*     */       }
/*     */     }
/* 112 */     String result = invocation.invoke();
/* 113 */     return result;
/*     */   }
/*     */ 
/*     */   private BaseObject assemblingObject(BaseObject obj, BaseAction action, ActionInvocation invocation)
/*     */     throws InstantiationException, IllegalAccessException, BusinessException
/*     */   {
/* 122 */     if (obj.getPrimarykey() == null) {
/* 123 */       ObjectNew(obj, null);
/* 124 */       return obj;
/*     */     }
/*     */ 
/* 127 */     BaseObject persistence = loadObject(obj);
/*     */ 
/* 129 */     merageObject(persistence, obj, null, action, invocation);
/*     */ 
/* 131 */     return persistence;
/*     */   }
/*     */ 
/*     */   private void ObjectNew(BaseObject obj, BaseObject parentObj) {
/* 135 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(obj);
/*     */ 
/* 138 */     obj.setDirty(true);
/*     */ 
/* 141 */     for (PropertyDescriptor descriptor : properties) {
/* 142 */       String propertyName = descriptor.getName();
/* 143 */       Object domainObject = BeanUtil.getPropertyValue(obj, propertyName);
/*     */ 
/* 145 */       if (descriptor.getWriteMethod() == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 149 */       if (domainObject == null) {
/*     */         continue;
/*     */       }
/* 152 */       if (parentObj == domainObject) {
/*     */         continue;
/*     */       }
/* 155 */       if ((domainObject instanceof BaseObject)) {
/* 156 */         BaseObject bo = (BaseObject)domainObject;
/* 157 */         if (bo.getPrimarykey() == null) {
/* 158 */           BeanUtil.setPropertyValue(obj, propertyName, null);
/*     */         } else {
/* 160 */           Object val = loadObject(bo);
/* 161 */           if (val == null)
/* 162 */             BeanUtil.setPropertyValue(obj, propertyName, null);
/*     */           else {
/* 164 */             BeanUtil.setPropertyValue(obj, propertyName, val);
/*     */           }
/*     */         }
/*     */       }
/* 168 */       if ((domainObject instanceof Collection)) {
/* 169 */         Collection coll = (Collection)domainObject;
/* 170 */         if (coll == null) {
/*     */           continue;
/*     */         }
/* 173 */         for (Iterator localIterator = coll.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 174 */           if (object != null)
/* 175 */             ObjectNew((BaseObject)object, obj); }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void merageObject(BaseObject pObj, BaseObject vObj, BaseObject parentObj, BaseAction action, ActionInvocation invocation)
/*     */     throws InstantiationException, IllegalAccessException, BusinessException
/*     */   {
/* 183 */     boolean equalsClass = vObj.getClass().equals(pObj.getClass());
/*     */ 
/* 185 */     Set v_PropertyNams = new HashSet();
/* 186 */     if (!equalsClass) {
/* 187 */       PropertyDescriptor[] v_properties = PropertyUtils.getPropertyDescriptors(vObj);
/* 188 */       for (PropertyDescriptor v_descriptor : v_properties) {
/* 189 */         v_PropertyNams.add(v_descriptor.getName());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 194 */     vObj.setDirty(false);
/* 195 */     pObj.setDirty(false);
/*     */ 
/* 197 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pObj);
/* 198 */     for (PropertyDescriptor descriptor : properties) {
/* 199 */       String propertyName = descriptor.getName();
/* 200 */       Class clazz = descriptor.getPropertyType();
/*     */ 
/* 202 */       if (descriptor.getWriteMethod() == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 206 */       if ((!equalsClass) && (!v_PropertyNams.contains(propertyName))) {
/*     */         continue;
/*     */       }
/* 209 */       Set parameterNames = invocation.getInvocationContext().getParameters().keySet();
/*     */ 
/* 211 */       Object v_value = BeanUtil.getPropertyValue(vObj, propertyName);
/* 212 */       if ((v_value == null) && (notIncludParameterName(parameterNames, propertyName))) {
/*     */         continue;
/*     */       }
/* 215 */       if ((clazz.isInterface()) && (!(v_value instanceof Collection))) {
/*     */         continue;
/*     */       }
/* 218 */       if ((parentObj != null) && (v_value == parentObj)) {
/*     */         continue;
/*     */       }
/* 221 */       if (propertyName.equals("dirty"))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 227 */       Object p_value = BeanUtil.getPropertyValue(pObj, propertyName);
/*     */ 
/* 230 */       if ((propertyName.equals("version")) && (v_value != null) && (!v_value.equals(p_value))) {
/* 231 */         action.setErrorObject(vObj);
/*     */       }
/*     */ 
/* 235 */       if ((parentObj != null) && (propertyName.equals("version")) && (v_value == null)) {
/* 236 */         v_value = p_value;
/*     */       }
/*     */ 
/* 239 */       if ((!(v_value instanceof Collection)) && (!(v_value instanceof BaseObject))) {
/* 240 */         BeanUtil.setPropertyValue(pObj, propertyName, v_value);
/*     */       }
/*     */ 
/* 244 */       if ((v_value instanceof BaseObject)) {
/* 245 */         BaseObject v_bo_obj = (BaseObject)v_value;
/* 246 */         BaseObject p_bo_obj = (BaseObject)p_value;
/* 247 */         if (v_bo_obj.getPrimarykey() == null) {
/*     */           continue;
/*     */         }
/* 250 */         if ((p_value != null) && (v_bo_obj.getPrimarykey().equals(p_bo_obj.getPrimarykey()))) {
/*     */           continue;
/*     */         }
/* 253 */         Object val = null;
/* 254 */         if (Integer.parseInt(v_bo_obj.getPrimarykey().toString()) >= 0) {
/* 255 */           val = loadObject(v_bo_obj);
/*     */         }
/*     */ 
/* 259 */         BeanUtil.setPropertyValue(pObj, propertyName, val);
/*     */       }
/*     */ 
/* 262 */       if ((p_value instanceof Collection)) {
/* 263 */         List p_coll = (List)p_value;
/* 264 */         List _v_coll = (List)v_value;
/* 265 */         List v_coll = new ArrayList();
/*     */         BaseObject element;
/* 267 */         for (Iterator iter = _v_coll.iterator(); iter.hasNext(); ) {
/* 268 */           element = (BaseObject)iter.next();
/* 269 */           if (element == null) {
/*     */             continue;
/*     */           }
/* 272 */           element.setParentEntity(pObj);
/* 273 */           v_coll.add(element);
/*     */         }
/*     */ 
/* 276 */         if (p_coll.size() == 0) {
/* 277 */           for (element = v_coll.iterator(); element.hasNext(); ) { Object object = element.next();
/* 278 */             if (object == null)
/*     */               continue;
/* 280 */             ObjectNew((BaseObject)object, pObj);
/* 281 */             p_coll.add(object);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 286 */           int p_index = p_coll.size();
/* 287 */           int v_index = v_coll.size();
/* 288 */           int length = v_index - p_index;
/* 289 */           for (int i = 0; i < v_index - length; i++) {
/* 290 */             merageObject((BaseObject)p_coll.get(i), (BaseObject)v_coll.get(i), pObj, action, invocation);
/*     */           }
/* 292 */           for (int i = 0; i < length; i++) {
/* 293 */             ObjectNew((BaseObject)v_coll.get(v_index - length + i), pObj);
/* 294 */             p_coll.add(v_coll.get(v_index - length + i));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private BaseObject loadObject(BaseObject obj) {
/* 302 */     Serializable id = obj.getPrimarykey();
/* 303 */     ManagerImpl manager = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/* 304 */     Object value = manager.getObjectById(obj.getClass(), id);
/* 305 */     if (value == null)
/* 306 */       return null;
/* 307 */     return (BaseObject)value;
/*     */   }
/*     */ 
/*     */   private boolean notIncludParameterName(Set<String> parameterNames, String propertyName) {
/* 311 */     for (String parameterName : parameterNames) {
/* 312 */       if (parameterName.contains(propertyName))
/* 313 */         return false;
/*     */     }
/* 315 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.struts.LoadObjectInterceptor
 * JD-Core Version:    0.6.0
 */