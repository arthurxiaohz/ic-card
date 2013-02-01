/*     */ package org.hi.base.menu.strutsmenu;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.hi.base.menu.model.Menu;
/*     */ import org.hi.base.menu.model.MenuLink;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContext;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class SysMenuTreeManager extends AbstractMenuTreeManager
/*     */ {
/*     */   protected void refactorMenu(HiMenuComponent menu)
/*     */   {
/*  31 */     for (Iterator iter = menu.getComponents().iterator(); iter.hasNext(); ) {
/*  32 */       HiMenuComponent component = (HiMenuComponent)iter.next();
/*     */ 
/*  34 */       refactorMenu(component);
/*     */ 
/*  36 */       Object obj = component.getTargetObject();
/*  37 */       if ((obj instanceof MenuLink)) {
/*     */         continue;
/*     */       }
/*  40 */       if ((component.getComponents() == null) || (component.getComponents().size() == 0)) {
/*  41 */         menu.removeMenuComponent(component);
/*  42 */         iter.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public HiMenuComponent subMenuAdd(HiMenuComponent menu, Map menuMap, String menuName, HttpServletRequest request, String parent, Map map)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  65 */       WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine)menuMap.get(menuName);
/*  66 */       Collection list = new ArrayList();
/*     */ 
/*  68 */       if (menudefine.isSecurity())
/*  69 */         list = getSubMenuListBySecurity(request, parent, menudefine, map);
/*     */       else
/*  71 */         list = getSubMenuList(request, parent, menudefine, map);
/*  72 */       int namei = 0;
/*     */ 
/*  77 */       for (Iterator iter = list.iterator(); iter.hasNext(); ) {
/*  78 */         BaseObject bean = (BaseObject)iter.next();
/*     */ 
/*  80 */         HiMenuComponent submenu = new HiMenuComponent(menudefine);
/*     */ 
/*  84 */         setAttrbute(menu, submenu, bean, menudefine, request, namei++, false);
/*     */ 
/*  87 */         if (!menudefine.isNeedShow()) {
/*  88 */           submenu = menu;
/*     */         }
/*  90 */         if (menudefine.getSubmenuName() != null)
/*     */         {
/*  92 */           submenu = 
/*  93 */             subMenuAdd(
/*  94 */             submenu, 
/*  96 */             menuMap, 
/*  97 */             menudefine.getSubmenuName(), 
/*  98 */             request, BeanUtil.getPropertyValue(bean, menudefine.getParent()).toString(), map);
/*     */         }
/*     */ 
/* 101 */         if (menudefine.isNeedShow()) {
/* 102 */           menu.addMenuComponent(submenu);
/*     */         }
/*     */       }
/*     */ 
/* 106 */       menudefine.nextSubmenuName();
/* 107 */       if (menudefine.getSubmenuName() != null) {
/* 108 */         subMenuAdd(
/* 109 */           menu, 
/* 110 */           menuMap, 
/* 111 */           menudefine.getSubmenuName(), 
/* 112 */           request, parent, map);
/*     */       }
/* 114 */       menudefine.previousSubmenuName();
/*     */ 
/* 116 */       return menu;
/*     */     } catch (Exception e) {
/*     */     }
/* 119 */     throw e;
/*     */   }
/*     */ 
/*     */   private Collection getSubMenuListBySecurity(HttpServletRequest request, String parent, WebDynamicMenuDefine menudefine, Map<String, String> map)
/*     */     throws Exception
/*     */   {
/* 135 */     if ((menudefine == null) || (UserContextHelper.getUser() == null)) return new ArrayList();
/* 136 */     Filter filter = null;
/* 137 */     Sorter sorter = null;
/*     */ 
/* 140 */     if ((parent == null) || (parent.trim().equals("")) || (parent.trim().equals("0"))) {
/* 141 */       filter = FilterFactory.getSimpleFilter(menudefine.getChild(), menudefine.getChildvalue(), "=");
/* 142 */       filter.addCondition(menudefine.getChild(), null, "=", "OR");
/*     */     }
/*     */     else {
/* 145 */       filter = FilterFactory.getSimpleFilter(menudefine.getChild(), new Integer(parent), "=");
/*     */     }
/*     */ 
/* 148 */     Object processor = null;
/* 149 */     if ((menudefine.getFilter() != null) && (!menudefine.getFilter().equals(""))) {
/* 150 */       String filterName = menudefine.getFilter();
/* 151 */       processor = BeanUtil.CreateObject(filterName.trim());
/* 152 */       if ((processor instanceof MenuFilterProcessor)) {
/* 153 */         MenuFilterProcessor process = (MenuFilterProcessor)processor;
/* 154 */         filter.addFilter(process.getFilter(map));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 159 */     if ((menudefine.getSort() != null) && (!menudefine.getSort().trim().equals(""))) {
/* 160 */       sorter = SorterFactory.getSimpleSort(menudefine.getSort().trim());
/* 161 */       sorter.addSort("id");
/*     */     }
/*     */ 
/* 164 */     Class clazz = Class.forName(menudefine.getBeanName());
/* 165 */     if ((clazz.equals(MenuLink.class)) && (HiConfigHolder.getPublished()))
/* 166 */       filter.addCondition("menuLinkType", new Integer(1), "<>", "AND");
/* 167 */     Collection noSecurityList = this.bMgr.getObjects(clazz, filter, sorter);
/*     */ 
/* 170 */     if ((UserContextHelper.getUser().getUserMgrType() != null) && (UserContextHelper.getUser().getUserMgrType().intValue() == 1400))
/*     */     {
/* 172 */       if ((processor != null) && ((processor instanceof MenuCollectionProcessor))) {
/* 173 */         MenuCollectionProcessor process = (MenuCollectionProcessor)processor;
/* 174 */         return process.getCollection(noSecurityList, map);
/*     */       }
/* 176 */       return noSecurityList;
/*     */     }
/*     */ 
/* 179 */     Collection securityList = new ArrayList();
/* 180 */     for (Iterator localIterator = noSecurityList.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 181 */       if ((object instanceof Menu)) {
/* 182 */         Menu menu = (Menu)object;
/* 183 */         filter = FilterFactory.getSimpleFilter("menu.id", menu.getId(), "=");
/* 184 */         Collection chiledList = this.bMgr.getObjects(MenuLink.class, filter);
/* 185 */         Filter menuFilter = FilterFactory.getSimpleFilter("parentMenu.id", menu.getId(), "=");
/* 186 */         chiledList.addAll(this.bMgr.getObjects(Menu.class, menuFilter));
/*     */ 
/* 188 */         if (hasSecuritys(chiledList)) {
/* 189 */           securityList.add(object);
/*     */         }
/*     */       }
/* 192 */       if ((!(object instanceof MenuLink)) || 
/* 193 */         (!hasSecuritys(object))) continue;
/* 194 */       securityList.add(object);
/*     */     }
/*     */ 
/* 199 */     if ((processor != null) && ((processor instanceof MenuCollectionProcessor))) {
/* 200 */       MenuCollectionProcessor process = (MenuCollectionProcessor)processor;
/* 201 */       return process.getCollection(securityList, map);
/*     */     }
/*     */ 
/* 204 */     return securityList;
/*     */   }
/*     */ 
/*     */   private boolean hasSecuritys(Collection objectList)
/*     */   {
/* 214 */     if ((UserContextHelper.getUser().getUserMgrType() != null) && (UserContextHelper.getUser().getUserMgrType().intValue() == 1400))
/* 215 */       return true;
/* 216 */     for (Iterator localIterator = objectList.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 217 */       if (hasSecuritys(object)) {
/* 218 */         return true;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean hasSecuritys(Object object)
/*     */   {
/* 233 */     if ((UserContextHelper.getUser().getUserMgrType() != null) && (UserContextHelper.getUser().getUserMgrType().intValue() == 1400))
/* 234 */       return true;
/* 235 */     if ((object instanceof Menu))
/* 236 */       return true;
/* 237 */     if ((object instanceof MenuLink)) {
/* 238 */       MenuLink menuLink = (MenuLink)object;
/* 239 */       Set links = UserContextHelper.getUserContext().getUserMenuUrls();
/* 240 */       String url = menuLink.getLinkUrl();
/* 241 */       if (StringUtils.isIncludes(url, "?"))
/* 242 */         url = url.substring(0, url.indexOf("?"));
/* 243 */       if (links.contains(url))
/* 244 */         return true;
/*     */     }
/* 246 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.SysMenuTreeManager
 * JD-Core Version:    0.6.0
 */