/*     */ package org.hi.base.menu.action;
/*     */ 
/*     */ import org.hi.base.organization.action.HiUserPageInfo;
/*     */ import org.hi.framework.security.action.AuthorityPageInfo;
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class MenuLinkPageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected String f_linkUrl;
/*     */   protected String f_linkUrl_op;
/*     */   protected String f_displayRef;
/*     */   protected String f_displayRef_op;
/*     */   protected String f_description;
/*     */   protected String f_description_op;
/*     */   protected Double f_sequence;
/*     */   protected String f_sequence_op;
/*     */   protected Integer f_menuLinkType;
/*     */   protected String f_menuLinkType_op;
/*     */   protected AuthorityPageInfo authority;
/*     */   protected MenuPageInfo menu;
/*     */   protected HiUserPageInfo creator;
/*     */ 
/*     */   public Integer getF_id()
/*     */   {
/*  31 */     return this.f_id;
/*     */   }
/*     */ 
/*     */   public void setF_id(Integer f_id) {
/*  35 */     this.f_id = f_id;
/*     */   }
/*     */ 
/*     */   public String getF_id_op() {
/*  39 */     return this.f_id_op;
/*     */   }
/*     */ 
/*     */   public void setF_id_op(String f_id_op) {
/*  43 */     this.f_id_op = f_id_op;
/*     */   }
/*     */ 
/*     */   public String getF_linkUrl() {
/*  47 */     return this.f_linkUrl;
/*     */   }
/*     */ 
/*     */   public void setF_linkUrl(String f_linkUrl) {
/*  51 */     this.f_linkUrl = f_linkUrl;
/*     */   }
/*     */ 
/*     */   public String getF_linkUrl_op() {
/*  55 */     return this.f_linkUrl_op;
/*     */   }
/*     */ 
/*     */   public void setF_linkUrl_op(String f_linkUrl_op) {
/*  59 */     this.f_linkUrl_op = f_linkUrl_op;
/*     */   }
/*     */ 
/*     */   public String getF_displayRef() {
/*  63 */     return this.f_displayRef;
/*     */   }
/*     */ 
/*     */   public void setF_displayRef(String f_displayRef) {
/*  67 */     this.f_displayRef = f_displayRef;
/*     */   }
/*     */ 
/*     */   public String getF_displayRef_op() {
/*  71 */     return this.f_displayRef_op;
/*     */   }
/*     */ 
/*     */   public void setF_displayRef_op(String f_displayRef_op) {
/*  75 */     this.f_displayRef_op = f_displayRef_op;
/*     */   }
/*     */ 
/*     */   public String getF_description() {
/*  79 */     return this.f_description;
/*     */   }
/*     */ 
/*     */   public void setF_description(String f_description) {
/*  83 */     this.f_description = f_description;
/*     */   }
/*     */ 
/*     */   public String getF_description_op() {
/*  87 */     return this.f_description_op;
/*     */   }
/*     */ 
/*     */   public void setF_description_op(String f_description_op) {
/*  91 */     this.f_description_op = f_description_op;
/*     */   }
/*     */ 
/*     */   public Double getF_sequence() {
/*  95 */     return this.f_sequence;
/*     */   }
/*     */ 
/*     */   public void setF_sequence(Double f_sequence) {
/*  99 */     this.f_sequence = f_sequence;
/*     */   }
/*     */ 
/*     */   public String getF_sequence_op() {
/* 103 */     return this.f_sequence_op;
/*     */   }
/*     */ 
/*     */   public void setF_sequence_op(String f_sequence_op) {
/* 107 */     this.f_sequence_op = f_sequence_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_menuLinkType() {
/* 111 */     return this.f_menuLinkType;
/*     */   }
/*     */ 
/*     */   public void setF_menuLinkType(Integer f_menuLinkType) {
/* 115 */     this.f_menuLinkType = f_menuLinkType;
/*     */   }
/*     */ 
/*     */   public String getF_menuLinkType_op() {
/* 119 */     return this.f_menuLinkType_op;
/*     */   }
/*     */ 
/*     */   public void setF_menuLinkType_op(String f_menuLinkType_op) {
/* 123 */     this.f_menuLinkType_op = f_menuLinkType_op;
/*     */   }
/*     */ 
/*     */   public AuthorityPageInfo getAuthority() {
/* 127 */     return this.authority;
/*     */   }
/*     */ 
/*     */   public void setAuthority(AuthorityPageInfo authority) {
/* 131 */     this.authority = authority;
/*     */   }
/*     */   public MenuPageInfo getMenu() {
/* 134 */     return this.menu;
/*     */   }
/*     */ 
/*     */   public void setMenu(MenuPageInfo menu) {
/* 138 */     this.menu = menu;
/*     */   }
/*     */   public HiUserPageInfo getCreator() {
/* 141 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUserPageInfo creator) {
/* 145 */     this.creator = creator;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.MenuLinkPageInfo
 * JD-Core Version:    0.6.0
 */