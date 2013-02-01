/*     */ package org.hi.base.menu.strutsmenu;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ 
/*     */ public class WebDynamicTreeManager extends AbstractMenuTreeManager
/*     */ {
/*     */   public HiMenuComponent subMenuAdd(HiMenuComponent menu, Map menuMap, String menuName, HttpServletRequest request, String parent, Map map)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  40 */       WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine)menuMap.get(menuName);
/*  41 */       if (menudefine == null)
/*  42 */         throw new BusinessException(menuName + "菜单未定义");
/*  43 */       Collection list = getSubMenuList(request, parent, menudefine, map);
/*  44 */       int namei = 0;
/*     */ 
/*  46 */       for (Iterator iter = list.iterator(); iter.hasNext(); ) {
/*  47 */         BaseObject bean = (BaseObject)iter.next();
/*     */ 
/*  49 */         HiMenuComponent submenu = new HiMenuComponent(menudefine);
/*     */ 
/*  52 */         setAttrbute(menu, submenu, bean, menudefine, request, namei++, false);
/*     */ 
/*  55 */         if (!menudefine.isNeedShow()) {
/*  56 */           submenu = menu;
/*     */         }
/*  58 */         if (menudefine.getSubmenuName() != null)
/*     */         {
/*  60 */           submenu = 
/*  61 */             subMenuAdd(
/*  62 */             submenu, 
/*  64 */             menuMap, 
/*  65 */             menudefine.getSubmenuName(), 
/*  66 */             request, BeanUtil.getPropertyValue(bean, menudefine.getParent()).toString(), map);
/*     */         }
/*     */ 
/*  69 */         if (menudefine.isNeedShow()) {
/*  70 */           menu.addMenuComponent(submenu);
/*     */         }
/*     */       }
/*     */ 
/*  74 */       menudefine.nextSubmenuName();
/*  75 */       if (menudefine.getSubmenuName() != null) {
/*  76 */         subMenuAdd(
/*  77 */           menu, 
/*  78 */           menuMap, 
/*  79 */           menudefine.getSubmenuName(), 
/*  80 */           request, parent, map);
/*     */       }
/*  82 */       menudefine.previousSubmenuName();
/*     */ 
/*  84 */       return menu;
/*     */     } catch (Exception e) {
/*     */     }
/*  87 */     throw e;
/*     */   }
/*     */ 
/*     */   public HiMenuComponent getLoadMenu(String name, Map keys, String menuType, HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/* 103 */     this.menuType = menuType;
/* 104 */     String parent = null;
/* 105 */     Map menuMap = (Map)new XmlUtil().read(getInputStream(request));
/* 106 */     WebDynamicMenuDefine rootMenudefine = (WebDynamicMenuDefine)menuMap.get(name);
/* 107 */     HiMenuComponent menu = new HiMenuComponent(rootMenudefine);
/*     */ 
/* 109 */     if (menuMap.get(name) != null) {
/* 110 */       menu.setTitle(rootMenudefine.getTitle());
/* 111 */       menu.setName(rootMenudefine.getMenuName());
/*     */ 
/* 113 */       for (Iterator iter = rootMenudefine.getKeymap().keySet().iterator(); iter.hasNext(); ) {
/* 114 */         String key = (String)iter.next();
/* 115 */         Object obj = keys.get(rootMenudefine.getKeymap().get(key));
/* 116 */         if (obj != null)
/* 117 */           parent = obj.toString();
/*     */       }
/* 119 */       menu = submenuLoadAdd(menu, menuMap, name, request, parent, keys);
/*     */     }
/* 121 */     request.setAttribute("javascript", rootMenudefine.getJavascript());
/* 122 */     return menu;
/*     */   }
/*     */ 
/*     */   private HiMenuComponent submenuLoadAdd(HiMenuComponent menu, Map menuMap, String menuName, HttpServletRequest request, String parent, Map map)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 146 */       WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine)menuMap.get(menuName);
/* 147 */       Collection list = getSubMenuList(request, parent, menudefine, map);
/* 148 */       int namei = 0;
/* 149 */       for (Iterator iter = list.iterator(); iter.hasNext(); ) {
/* 150 */         BaseObject bean = (BaseObject)iter.next();
/*     */ 
/* 152 */         HiMenuComponent submenu = new HiMenuComponent(menudefine);
/*     */ 
/* 154 */         setAttrbute(menu, submenu, bean, menudefine, request, namei++, true);
/*     */ 
/* 157 */         if (!menudefine.isNeedShow()) {
/* 158 */           submenu = menu;
/*     */         }
/* 160 */         if (menudefine.getSubmenuName() != null)
/*     */         {
/* 162 */           subMenuUrlAdd(
/* 163 */             submenu, 
/* 164 */             getSubMenuInfo(menudefine, bean), 
/* 165 */             menuMap, 
/* 166 */             menudefine.getSubmenuName(), request, parent, list);
/*     */         }
/*     */ 
/* 169 */         if (menudefine.isNeedShow())
/* 170 */           menu.addMenuComponent(submenu);
/*     */         else {
/* 172 */           menu = 
/* 173 */             submenuLoadAdd(
/* 174 */             submenu, 
/* 176 */             menuMap, 
/* 177 */             menudefine.getSubmenuName(), request, parent, map);
/*     */         }
/*     */       }
/*     */ 
/* 181 */       menudefine.nextSubmenuName();
/* 182 */       if (menudefine.getSubmenuName() != null) {
/* 183 */         submenuLoadAdd(
/* 184 */           menu, 
/* 186 */           menuMap, 
/* 187 */           menudefine.getSubmenuName(), request, parent, map);
/*     */       }
/* 189 */       menudefine.previousSubmenuName();
/*     */ 
/* 192 */       return menu;
/*     */     } catch (Exception e) {
/*     */     }
/* 195 */     throw e;
/*     */   }
/*     */ 
/*     */   private void subMenuUrlAdd(HiMenuComponent submenu, HashMap map, Map menuMap, String menuName, HttpServletRequest request, String parent, Collection list)
/*     */   {
/* 216 */     WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine)menuMap.get(menuName);
/* 217 */     if (list.size() > 0) {
/* 218 */       String location = "";
/* 219 */       String adjust = "&";
/* 220 */       if ("subMenu".equals(this.menuType))
/* 221 */         adjust = "&amp;";
/* 222 */       location = location + adjust + "menuName=" + menudefine.getMenuName();
/* 223 */       for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
/* 224 */         String lkey = (String)iterator.next();
/* 225 */         location = location + adjust + lkey + "=" + map.get(lkey);
/*     */       }
/* 227 */       String actionSuffix = HiConfigHolder.getViewFrameworkSuffix();
/* 228 */       submenu.setForward(request.getContextPath() + "/loadTree." + actionSuffix + "?type=subMenu" + location);
/*     */     }
/*     */   }
/*     */ 
/*     */   private HashMap getSubMenuInfo(WebDynamicMenuDefine menudefine, BaseObject bean)
/*     */     throws Exception
/*     */   {
/* 241 */     HashMap map = new HashMap();
/* 242 */     for (Iterator iter = menudefine.getKeymap().keySet().iterator(); iter.hasNext(); ) {
/* 243 */       String key = (String)iter.next();
/* 244 */       map.put(menudefine.getKeymap().get(key), BeanUtil.getPropertyValue(bean, key).toString());
/*     */     }
/* 246 */     return map;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.WebDynamicTreeManager
 * JD-Core Version:    0.6.0
 */