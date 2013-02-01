/*     */ package org.hi.base.menu.action;
/*     */ 
/*     */ import org.hi.base.organization.action.HiUserPageInfo;
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class MenuPageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected String f_menuName;
/*     */   protected String f_menuName_op;
/*     */   protected String f_displayRef;
/*     */   protected String f_displayRef_op;
/*     */   protected String f_description;
/*     */   protected String f_description_op;
/*     */   protected Double f_sequence;
/*     */   protected String f_sequence_op;
/*     */   protected Integer f_menuType;
/*     */   protected String f_menuType_op;
/*     */   protected MenuPageInfo parentMenu;
/*     */   protected HiUserPageInfo creator;
/*     */ 
/*     */   public Integer getF_id()
/*     */   {
/*  28 */     return this.f_id;
/*     */   }
/*     */ 
/*     */   public void setF_id(Integer f_id) {
/*  32 */     this.f_id = f_id;
/*     */   }
/*     */ 
/*     */   public String getF_id_op() {
/*  36 */     return this.f_id_op;
/*     */   }
/*     */ 
/*     */   public void setF_id_op(String f_id_op) {
/*  40 */     this.f_id_op = f_id_op;
/*     */   }
/*     */ 
/*     */   public String getF_menuName() {
/*  44 */     return this.f_menuName;
/*     */   }
/*     */ 
/*     */   public void setF_menuName(String f_menuName) {
/*  48 */     this.f_menuName = f_menuName;
/*     */   }
/*     */ 
/*     */   public String getF_menuName_op() {
/*  52 */     return this.f_menuName_op;
/*     */   }
/*     */ 
/*     */   public void setF_menuName_op(String f_menuName_op) {
/*  56 */     this.f_menuName_op = f_menuName_op;
/*     */   }
/*     */ 
/*     */   public String getF_displayRef() {
/*  60 */     return this.f_displayRef;
/*     */   }
/*     */ 
/*     */   public void setF_displayRef(String f_displayRef) {
/*  64 */     this.f_displayRef = f_displayRef;
/*     */   }
/*     */ 
/*     */   public String getF_displayRef_op() {
/*  68 */     return this.f_displayRef_op;
/*     */   }
/*     */ 
/*     */   public void setF_displayRef_op(String f_displayRef_op) {
/*  72 */     this.f_displayRef_op = f_displayRef_op;
/*     */   }
/*     */ 
/*     */   public String getF_description() {
/*  76 */     return this.f_description;
/*     */   }
/*     */ 
/*     */   public void setF_description(String f_description) {
/*  80 */     this.f_description = f_description;
/*     */   }
/*     */ 
/*     */   public String getF_description_op() {
/*  84 */     return this.f_description_op;
/*     */   }
/*     */ 
/*     */   public void setF_description_op(String f_description_op) {
/*  88 */     this.f_description_op = f_description_op;
/*     */   }
/*     */ 
/*     */   public Double getF_sequence() {
/*  92 */     return this.f_sequence;
/*     */   }
/*     */ 
/*     */   public void setF_sequence(Double f_sequence) {
/*  96 */     this.f_sequence = f_sequence;
/*     */   }
/*     */ 
/*     */   public String getF_sequence_op() {
/* 100 */     return this.f_sequence_op;
/*     */   }
/*     */ 
/*     */   public void setF_sequence_op(String f_sequence_op) {
/* 104 */     this.f_sequence_op = f_sequence_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_menuType() {
/* 108 */     return this.f_menuType;
/*     */   }
/*     */ 
/*     */   public void setF_menuType(Integer f_menuType) {
/* 112 */     this.f_menuType = f_menuType;
/*     */   }
/*     */ 
/*     */   public String getF_menuType_op() {
/* 116 */     return this.f_menuType_op;
/*     */   }
/*     */ 
/*     */   public void setF_menuType_op(String f_menuType_op) {
/* 120 */     this.f_menuType_op = f_menuType_op;
/*     */   }
/*     */ 
/*     */   public MenuPageInfo getParentMenu() {
/* 124 */     return this.parentMenu;
/*     */   }
/*     */ 
/*     */   public void setParentMenu(MenuPageInfo parentMenu) {
/* 128 */     this.parentMenu = parentMenu;
/*     */   }
/*     */   public HiUserPageInfo getCreator() {
/* 131 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUserPageInfo creator) {
/* 135 */     this.creator = creator;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.action.MenuPageInfo
 * JD-Core Version:    0.6.0
 */