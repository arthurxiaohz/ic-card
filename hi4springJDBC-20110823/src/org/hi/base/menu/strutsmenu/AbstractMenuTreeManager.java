/*     */ package org.hi.base.menu.strutsmenu;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public abstract class AbstractMenuTreeManager
/*     */ {
/*     */   protected static final String MENAU_CONFIG = "/WEB-INF/config/himenu-config.xml";
/*  29 */   protected String menuConfig = "/WEB-INF/config/himenu-config.xml";
/*     */   protected String menuType;
/*  31 */   protected ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/*     */   protected static Map menuMap;
/*  37 */   private static Map<String, HiMenuComponent> cacheMap = Collections.synchronizedMap(new HashMap());
/*     */ 
/*     */   public HiMenuComponent getMenu(String name, Map keys, HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/*  50 */     if (HiConfigHolder.getMenuConfig() != null) {
/*  51 */       this.menuConfig = HiConfigHolder.getMenuConfig();
/*     */     }
/*     */ 
/*  54 */     boolean reload = HiConfigHolder.getMenuReload();
/*  55 */     if ((reload) || (menuMap == null)) {
/*  56 */       menuMap = (Map)new XmlUtil().read(getInputStream(request));
/*     */     }
/*  58 */     HiMenuComponent menu = null;
/*  59 */     WebDynamicMenuDefine rootMenudefine = null;
/*  60 */     if (menuMap.get(name) != null) {
/*  61 */       rootMenudefine = (WebDynamicMenuDefine)menuMap.get(name);
/*  62 */       request.setAttribute("javascript", rootMenudefine.getJavascript());
/*     */ 
/*  64 */       if ((rootMenudefine.isCache()) && (cacheMap.get(rootMenudefine.getMenuName()) != null)) {
/*  65 */         return (HiMenuComponent)cacheMap.get(rootMenudefine.getMenuName());
/*     */       }
/*  67 */       menu = new HiMenuComponent(rootMenudefine);
/*  68 */       menu.setTitle(rootMenudefine.getTitle());
/*  69 */       menu.setName(rootMenudefine.getMenuName());
/*  70 */       menu = subMenuAdd(menu, menuMap, name, request, rootMenudefine.getChildvalue(), keys);
/*     */     }
/*     */ 
/*  74 */     refactorMenu(menu);
/*     */ 
/*  76 */     if (rootMenudefine.isCache()) {
/*  77 */       cacheMap.put(rootMenudefine.getMenuName(), menu);
/*     */     }
/*  79 */     return menu;
/*     */   }
/*     */ 
/*     */   protected void refactorMenu(HiMenuComponent menu)
/*     */   {
/*     */   }
/*     */ 
/*     */   public abstract HiMenuComponent subMenuAdd(HiMenuComponent paramHiMenuComponent, Map paramMap1, String paramString1, HttpServletRequest paramHttpServletRequest, String paramString2, Map paramMap2)
/*     */     throws Exception;
/*     */ 
/*     */   protected Collection getSubMenuList(HttpServletRequest request, String parent, WebDynamicMenuDefine menudefine, Map<String, String> map)
/*     */     throws Exception
/*     */   {
/* 115 */     if (menudefine == null) return new ArrayList();
/* 116 */     Filter filter = null;
/* 117 */     Sorter sorter = null;
/*     */ 
/* 119 */     Class clazz = Class.forName(menudefine.getBeanName());
/* 120 */     Object bean = BeanUtil.CreateObject(clazz.getName());
/* 121 */     String propertyName = menudefine.getChild();
/*     */ 
/* 124 */     if ((parent == null) || (parent.trim().equals("")) || (parent.trim().equals("0")))
/*     */     {
/* 126 */       if ((propertyName != null) && (!propertyName.equals(""))) {
/* 127 */         parent = menudefine.getChildvalue();
/* 128 */         Class propertyClass = BeanUtil.getProperyClass(bean, propertyName);
/* 129 */         if (BaseObject.class.isAssignableFrom(propertyClass)) {
/* 130 */           propertyClass = Integer.class;
/*     */         }
/* 132 */         Object p_value = propertyClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { parent });
/* 133 */         filter = FilterFactory.getSimpleFilter(menudefine.getChild(), p_value, "=");
/* 134 */         filter.addCondition(menudefine.getChild(), null, "=", "OR");
/*     */       }
/*     */       else {
/* 137 */         filter = FilterFactory.getSimpleFilter(null, null);
/*     */       }
/*     */     }
/*     */     else {
/* 141 */       Class propertyClass = BeanUtil.getProperyClass(bean, propertyName);
/* 142 */       if (BaseObject.class.isAssignableFrom(propertyClass)) {
/* 143 */         propertyClass = Integer.class;
/*     */       }
/* 145 */       Object p_value = propertyClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { parent });
/*     */ 
/* 147 */       filter = FilterFactory.getSimpleFilter(menudefine.getChild(), p_value, "=");
/*     */     }
/*     */ 
/* 152 */     Object processor = null;
/* 153 */     if ((menudefine.getFilter() != null) && (!menudefine.getFilter().equals(""))) {
/* 154 */       String filterName = menudefine.getFilter();
/* 155 */       processor = BeanUtil.CreateObject(filterName.trim());
/* 156 */       if ((processor instanceof MenuFilterProcessor)) {
/* 157 */         MenuFilterProcessor process = (MenuFilterProcessor)processor;
/* 158 */         filter.addFilter(process.getFilter(map));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 163 */     if ((menudefine.getSort() != null) && (!menudefine.getSort().trim().equals(""))) {
/* 164 */       sorter = SorterFactory.getSimpleSort(menudefine.getSort().trim());
/*     */     }
/*     */ 
/* 167 */     Collection coll = this.bMgr.getObjects(clazz, filter, sorter);
/*     */ 
/* 169 */     if ((processor != null) && ((processor instanceof MenuCollectionProcessor))) {
/* 170 */       MenuCollectionProcessor process = (MenuCollectionProcessor)processor;
/* 171 */       return process.getCollection(coll, map);
/*     */     }
/* 173 */     return coll;
/*     */   }
/*     */ 
/*     */   protected void setAttrbute(HiMenuComponent menu, HiMenuComponent submenu, BaseObject bean, WebDynamicMenuDefine menudefine, HttpServletRequest request, int namei, boolean isLoad)
/*     */     throws Exception
/*     */   {
/* 193 */     submenu.setTargetObject(bean);
/*     */ 
/* 196 */     submenu.setName(menu.getName() + String.valueOf(namei));
/*     */ 
/* 199 */     String bundle = menudefine.getBundle();
/* 200 */     if ((bundle != null) && (!bundle.trim().equals(""))) {
/* 201 */       bundle = Resource.message(bundle, request.getLocale(), BeanUtil.getPropertyValueToStr(bean, menudefine.getTitleField()));
/* 202 */       if ((StringUtils.isInclude(bundle, request.getLocale().toString())) && (StringUtils.isInclude(bundle, "?")))
/* 203 */         bundle = (String)BeanUtil.getPropertyValue(bean, menudefine.getTitleField());
/* 204 */       submenu.setTitle(bundle);
/*     */     }
/*     */     else {
/* 207 */       bundle = (String)BeanUtil.getPropertyValue(bean, menudefine.getTitleField());
/* 208 */       submenu.setTitle(bundle);
/*     */     }
/*     */ 
/* 212 */     String action = menudefine.getAction();
/*     */ 
/* 214 */     if (action != null) {
/* 215 */       if (StringUtils.isInclude(action, "{js}")) {
/* 216 */         String setAction = processAction(bean, action);
/* 217 */         if (setAction != null)
/* 218 */           submenu.setJsFunctionName("javascript:" + 
/* 219 */             actionStr(bean, setAction, request));
/*     */       } else {
/* 221 */         String setAction = processAction(bean, action);
/* 222 */         if (setAction != null) {
/* 223 */           submenu.setAction(actionStr(bean, setAction, request));
/*     */         }
/*     */       }
/*     */     }
/* 227 */     if (menudefine.getTarget() != null) {
/* 228 */       submenu.setTarget(menudefine.getTarget());
/*     */     }
/*     */ 
/* 231 */     if (menudefine.getCheckbox()) {
/* 232 */       submenu.setCheckbox(String.valueOf(bean.getPrimarykey()));
/*     */     }
/*     */ 
/* 236 */     if (menudefine.getIconmap() != null) {
/* 237 */       HashMap iconmap = menudefine.getIconmap();
/* 238 */       String iconStrArr = "[";
/* 239 */       for (Iterator i = iconmap.keySet().iterator(); i.hasNext(); ) {
/* 240 */         String iconpath = (String)i.next();
/* 241 */         String setAction = (String)iconmap.get(iconpath);
/* 242 */         if (StringUtils.isInclude(setAction, "{js}")) {
/* 243 */           setAction = "javascript:" + setAction;
/*     */         }
/* 245 */         setAction = processAction(bean, setAction);
/*     */ 
/* 247 */         if (!iconStrArr.equals("[")) {
/* 248 */           iconStrArr = iconStrArr + ",";
/*     */         }
/* 250 */         iconStrArr = iconStrArr + "[\\\"" + iconpath + "\\\",\\\"" + 
/* 251 */           actionStr(bean, setAction, request) + "\\\"]";
/*     */       }
/*     */ 
/* 254 */       iconStrArr = iconStrArr + "]";
/* 255 */       if (isLoad)
/* 256 */         iconStrArr = iconStrArr.replaceAll("&", "&amp;");
/* 257 */       submenu.setIconarr(iconStrArr);
/*     */     }
/*     */ 
/* 261 */     submenu.setLeaf(isLeaf(menudefine, bean));
/*     */   }
/*     */ 
/*     */   protected boolean isLeaf(WebDynamicMenuDefine menudefine, BaseObject bean)
/*     */     throws Exception
/*     */   {
/* 270 */     boolean leaf = false;
/* 271 */     if (menudefine.getLeafMethod() != null) {
/* 272 */       String methodName = menudefine.getLeafMethod();
/* 273 */       Method leafMethod = bean.getClass().getMethod(methodName, new Class[0]);
/* 274 */       Object val = leafMethod.invoke(bean, new Object[0]);
/* 275 */       leaf = new Boolean(val.toString()).booleanValue();
/*     */     }
/*     */ 
/* 278 */     return leaf;
/*     */   }
/*     */ 
/*     */   protected String processAction(BaseObject bean, String action)
/*     */   {
/* 283 */     if (action == null) {
/* 284 */       return null;
/*     */     }
/* 286 */     String actionLower = action.toLowerCase();
/*     */ 
/* 289 */     if (StringUtils.isInclude(actionLower, "{js}")) {
/* 290 */       return StringUtils.delString(action, "{js}");
/*     */     }
/*     */ 
/* 294 */     if (StringUtils.isInclude(actionLower, "{url}")) {
/* 295 */       return StringUtils.delString(action, "{url}");
/*     */     }
/*     */ 
/* 299 */     if (StringUtils.isInclude(actionLower, "{property}")) {
/* 300 */       String setAction = StringUtils.delString(action, "{property}");
/* 301 */       setAction = BeanUtil.getPropertyValueToStr(bean, setAction);
/* 302 */       return processAction(bean, setAction);
/*     */     }
/*     */ 
/* 305 */     return action;
/*     */   }
/*     */ 
/*     */   protected String actionStr(BaseObject bean, String action, HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/* 317 */     if (!StringUtils.isInclude(action, "[#")) {
/* 318 */       return action;
/*     */     }
/* 320 */     String result = action;
/* 321 */     List properties = StringUtils.subStringList(action, "[#", "]");
/* 322 */     for (String property : properties) {
/* 323 */       Object val = null;
/*     */ 
/* 325 */       if (BeanUtil.hasPropertyName(bean, property))
/* 326 */         val = BeanUtil.getPropertyValue(bean, property);
/*     */       else {
/* 328 */         val = request.getParameter(property);
/*     */       }
/* 330 */       if (val == null) val = "";
/* 331 */       result = StringUtils.replace(result, "[#" + property + "]", val.toString());
/*     */     }
/*     */ 
/* 334 */     return result.replaceAll("&", "&amp;");
/*     */   }
/*     */ 
/*     */   protected InputStream getInputStream(HttpServletRequest request)
/*     */   {
/* 339 */     return request.getSession().getServletContext().getResourceAsStream(this.menuConfig);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.AbstractMenuTreeManager
 * JD-Core Version:    0.6.0
 */