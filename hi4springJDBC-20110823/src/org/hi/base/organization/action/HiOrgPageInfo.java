/*     */ package org.hi.base.organization.action;
/*     */ 
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class HiOrgPageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected String f_orgName;
/*     */   protected String f_orgName_op;
/*     */   protected String f_orgNum;
/*     */   protected String f_orgNum_op;
/*     */   protected String f_address;
/*     */   protected String f_address_op;
/*     */   protected String f_description;
/*     */   protected String f_description_op;
/*     */   protected Integer f_deleted;
/*     */   protected String f_deleted_op;
/*     */   protected HiUserPageInfo manager;
/*     */   protected HiOrgPageInfo parentOrg;
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
/*     */   public String getF_orgName() {
/*  44 */     return this.f_orgName;
/*     */   }
/*     */ 
/*     */   public void setF_orgName(String f_orgName) {
/*  48 */     this.f_orgName = f_orgName;
/*     */   }
/*     */ 
/*     */   public String getF_orgName_op() {
/*  52 */     return this.f_orgName_op;
/*     */   }
/*     */ 
/*     */   public void setF_orgName_op(String f_orgName_op) {
/*  56 */     this.f_orgName_op = f_orgName_op;
/*     */   }
/*     */ 
/*     */   public String getF_orgNum() {
/*  60 */     return this.f_orgNum;
/*     */   }
/*     */ 
/*     */   public void setF_orgNum(String f_orgNum) {
/*  64 */     this.f_orgNum = f_orgNum;
/*     */   }
/*     */ 
/*     */   public String getF_orgNum_op() {
/*  68 */     return this.f_orgNum_op;
/*     */   }
/*     */ 
/*     */   public void setF_orgNum_op(String f_orgNum_op) {
/*  72 */     this.f_orgNum_op = f_orgNum_op;
/*     */   }
/*     */ 
/*     */   public String getF_address() {
/*  76 */     return this.f_address;
/*     */   }
/*     */ 
/*     */   public void setF_address(String f_address) {
/*  80 */     this.f_address = f_address;
/*     */   }
/*     */ 
/*     */   public String getF_address_op() {
/*  84 */     return this.f_address_op;
/*     */   }
/*     */ 
/*     */   public void setF_address_op(String f_address_op) {
/*  88 */     this.f_address_op = f_address_op;
/*     */   }
/*     */ 
/*     */   public String getF_description() {
/*  92 */     return this.f_description;
/*     */   }
/*     */ 
/*     */   public void setF_description(String f_description) {
/*  96 */     this.f_description = f_description;
/*     */   }
/*     */ 
/*     */   public String getF_description_op() {
/* 100 */     return this.f_description_op;
/*     */   }
/*     */ 
/*     */   public void setF_description_op(String f_description_op) {
/* 104 */     this.f_description_op = f_description_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_deleted() {
/* 108 */     return this.f_deleted;
/*     */   }
/*     */ 
/*     */   public void setF_deleted(Integer f_deleted) {
/* 112 */     this.f_deleted = f_deleted;
/*     */   }
/*     */ 
/*     */   public String getF_deleted_op() {
/* 116 */     return this.f_deleted_op;
/*     */   }
/*     */ 
/*     */   public void setF_deleted_op(String f_deleted_op) {
/* 120 */     this.f_deleted_op = f_deleted_op;
/*     */   }
/*     */ 
/*     */   public HiUserPageInfo getManager() {
/* 124 */     return this.manager;
/*     */   }
/*     */ 
/*     */   public void setManager(HiUserPageInfo manager) {
/* 128 */     this.manager = manager;
/*     */   }
/*     */   public HiOrgPageInfo getParentOrg() {
/* 131 */     return this.parentOrg;
/*     */   }
/*     */ 
/*     */   public void setParentOrg(HiOrgPageInfo parentOrg) {
/* 135 */     this.parentOrg = parentOrg;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.action.HiOrgPageInfo
 * JD-Core Version:    0.6.0
 */