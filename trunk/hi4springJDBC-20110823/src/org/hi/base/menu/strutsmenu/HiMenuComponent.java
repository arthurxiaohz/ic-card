/*     */ package org.hi.base.menu.strutsmenu;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.sf.navigator.menu.MenuComponent;
/*     */ 
/*     */ public class HiMenuComponent extends MenuComponent
/*     */ {
/*     */   private static final long serialVersionUID = -7663899286675884527L;
/*     */   protected String checkbox;
/*     */   protected String iconarr;
/*     */   protected boolean leaf;
/*     */   protected Object targetObject;
/*     */   protected WebDynamicMenuDefine define;
/*     */   protected String jsFunctionName;
/*     */ 
/*     */   public HiMenuComponent(WebDynamicMenuDefine define)
/*     */   {
/*  49 */     this.define = define;
/*     */   }
/*     */ 
/*     */   public String getCheckbox() {
/*  53 */     return this.checkbox;
/*     */   }
/*     */ 
/*     */   public void setCheckbox(String checkbox) {
/*  57 */     this.checkbox = checkbox;
/*     */   }
/*     */ 
/*     */   public String getIconarr() {
/*  61 */     return this.iconarr;
/*     */   }
/*     */ 
/*     */   public void setIconarr(String iconarr) {
/*  65 */     this.iconarr = iconarr;
/*     */   }
/*     */ 
/*     */   public boolean getLeaf() {
/*  69 */     return this.leaf;
/*     */   }
/*     */ 
/*     */   public void setLeaf(boolean leaf) {
/*  73 */     this.leaf = leaf;
/*     */   }
/*     */ 
/*     */   public void removeMenuComponent(MenuComponent menuComponent) {
/*  77 */     if (!this.menuComponents.contains(menuComponent)) {
/*  78 */       this.menuComponents.remove(menuComponent);
/*  79 */       menuComponent = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object getTargetObject() {
/*  84 */     return this.targetObject;
/*     */   }
/*     */ 
/*     */   public void setTargetObject(Object targetObject) {
/*  88 */     this.targetObject = targetObject;
/*     */   }
/*     */ 
/*     */   public static long getSerialVersionUID() {
/*  92 */     return -7663899286675884527L;
/*     */   }
/*     */ 
/*     */   public String getJsFunctionName() {
/*  96 */     return this.jsFunctionName;
/*     */   }
/*     */ 
/*     */   public void setJsFunctionName(String jsFunctionName) {
/* 100 */     this.jsFunctionName = jsFunctionName;
/*     */   }
/*     */ 
/*     */   public WebDynamicMenuDefine getDefine() {
/* 104 */     return this.define;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.HiMenuComponent
 * JD-Core Version:    0.6.0
 */