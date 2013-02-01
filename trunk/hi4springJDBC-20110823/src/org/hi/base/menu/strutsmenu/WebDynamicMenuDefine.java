/*     */ package org.hi.base.menu.strutsmenu;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.hi.common.util.StringUtils;
/*     */ 
/*     */ public class WebDynamicMenuDefine
/*     */ {
/*     */   private String beanName;
/*     */   private String[] submenuName;
/*  25 */   private int submpoint = 0;
/*     */   private HashMap keymap;
/*     */   private String MenuName;
/*     */   private String Title;
/*     */   private String TitleField;
/*  48 */   private boolean needShow = true;
/*     */   private String parent;
/*     */   private String child;
/*     */   private String childvalue;
/*     */   private String sort;
/*     */   private String action;
/*     */   private String bundle;
/*     */   private String target;
/*  91 */   private boolean checkbox = false;
/*     */   private HashMap iconmap;
/*     */   private String leafMethod;
/* 103 */   private boolean security = false;
/*     */ 
/* 108 */   private String javascript = "";
/*     */ 
/* 114 */   private boolean cache = false;
/*     */   private String filter;
/*     */ 
/*     */   public String getParent()
/*     */   {
/* 123 */     return this.parent;
/*     */   }
/*     */ 
/*     */   public void setParent(String parent) {
/* 127 */     this.parent = parent;
/*     */   }
/*     */ 
/*     */   public String getChild() {
/* 131 */     return this.child;
/*     */   }
/*     */ 
/*     */   public void setChild(String child) {
/* 135 */     this.child = child;
/*     */   }
/*     */ 
/*     */   public String getChildvalue() {
/* 139 */     return this.childvalue;
/*     */   }
/*     */ 
/*     */   public void setChildValue(String childvalue) {
/* 143 */     this.childvalue = childvalue;
/*     */   }
/*     */ 
/*     */   public String getMenuName()
/*     */   {
/* 148 */     return this.MenuName;
/*     */   }
/*     */ 
/*     */   public String getBeanName() {
/* 152 */     return this.beanName;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 156 */     return this.Title;
/*     */   }
/*     */ 
/*     */   public void setMenuName(String string)
/*     */   {
/* 161 */     this.MenuName = string;
/*     */   }
/*     */ 
/*     */   public void setBeanName(String beanname)
/*     */   {
/* 166 */     this.beanName = beanname;
/*     */   }
/*     */ 
/*     */   public void setTitle(String string)
/*     */   {
/* 171 */     this.Title = string;
/*     */   }
/*     */ 
/*     */   public String getSubmenuName()
/*     */   {
/* 176 */     if ((this.submpoint >= this.submenuName.length) || (this.submpoint < 0)) {
/* 177 */       return null;
/*     */     }
/* 179 */     return this.submenuName[this.submpoint];
/*     */   }
/*     */ 
/*     */   public void setSubmenuName(String string) {
/* 183 */     this.submenuName = StringUtils.strToStrArray(string);
/*     */   }
/*     */ 
/*     */   public void nextSubmenuName() {
/* 187 */     this.submpoint += 1;
/*     */   }
/*     */ 
/*     */   public void previousSubmenuName() {
/* 191 */     this.submpoint -= 1;
/*     */   }
/*     */   public HashMap getKeymap() {
/* 194 */     return this.keymap;
/*     */   }
/*     */ 
/*     */   public String getTitleField()
/*     */   {
/* 199 */     return this.TitleField;
/*     */   }
/*     */ 
/*     */   public void setKeymap(HashMap map)
/*     */   {
/* 204 */     this.keymap = map;
/*     */   }
/*     */ 
/*     */   public void setTitleField(String string)
/*     */   {
/* 209 */     this.TitleField = string;
/*     */   }
/*     */ 
/*     */   public boolean isNeedShow()
/*     */   {
/* 214 */     return this.needShow;
/*     */   }
/*     */ 
/*     */   public void setNeedShow(boolean b)
/*     */   {
/* 219 */     this.needShow = b;
/*     */   }
/*     */ 
/*     */   public String getSort() {
/* 223 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(String sort)
/*     */   {
/* 228 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public String getAction() {
/* 232 */     return this.action;
/*     */   }
/*     */ 
/*     */   public void setAction(String action) {
/* 236 */     this.action = action;
/*     */   }
/*     */ 
/*     */   public String getBundle() {
/* 240 */     return this.bundle;
/*     */   }
/*     */ 
/*     */   public void setBundle(String bundle) {
/* 244 */     this.bundle = bundle;
/*     */   }
/*     */ 
/*     */   public String getTarget() {
/* 248 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/* 252 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public boolean getCheckbox() {
/* 256 */     return this.checkbox;
/*     */   }
/*     */ 
/*     */   public void setCheckbox(boolean checkbox) {
/* 260 */     this.checkbox = checkbox;
/*     */   }
/*     */ 
/*     */   public HashMap getIconmap() {
/* 264 */     return this.iconmap;
/*     */   }
/*     */ 
/*     */   public void setIconmap(HashMap iconmap) {
/* 268 */     this.iconmap = iconmap;
/*     */   }
/*     */ 
/*     */   public String getLeafMethod() {
/* 272 */     return this.leafMethod;
/*     */   }
/*     */ 
/*     */   public void setLeafMethod(String leafMethod) {
/* 276 */     this.leafMethod = leafMethod;
/*     */   }
/*     */ 
/*     */   public boolean isSecurity() {
/* 280 */     return this.security;
/*     */   }
/*     */ 
/*     */   public void setSecurity(boolean security) {
/* 284 */     this.security = security;
/*     */   }
/*     */ 
/*     */   public String getJavascript() {
/* 288 */     return this.javascript;
/*     */   }
/*     */ 
/*     */   public void setJavascript(String javascript) {
/* 292 */     this.javascript = javascript;
/*     */   }
/*     */ 
/*     */   public boolean isCache() {
/* 296 */     return this.cache;
/*     */   }
/*     */ 
/*     */   public void setCache(boolean cache) {
/* 300 */     this.cache = cache;
/*     */   }
/*     */ 
/*     */   public String getFilter() {
/* 304 */     return this.filter;
/*     */   }
/*     */ 
/*     */   public void setFilter(String filter) {
/* 308 */     this.filter = filter;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.WebDynamicMenuDefine
 * JD-Core Version:    0.6.0
 */