/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.AuthorityPageInfo;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.service.AuthorityManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class AuthorityAction extends BaseAction
/*     */ {
/*     */   private Authority authority;
/*     */   private AuthorityPageInfo pageInfo;
/*     */   private List<Authority> authoritys;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveAuthority()
/*     */     throws Exception
/*     */   {
/*  25 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  26 */     if (super.perExecute(this.authority) != null) return returnCommand();
/*  27 */     authorityMgr.saveAuthority(this.authority);
/*  28 */     super.postExecute(this.authority);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAuthority()
/*     */     throws Exception
/*     */   {
/*  37 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  38 */     authorityMgr.removeAuthorityById(this.authority.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllAuthority()
/*     */     throws Exception
/*     */   {
/*  46 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer authorityid = new Integer(ids[i]);
/*  55 */         authorityMgr.removeAuthorityById(authorityid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewAuthority()
/*     */     throws Exception
/*     */   {
/*  67 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  68 */     this.authority = authorityMgr.getAuthorityById(this.authority.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String authorityList()
/*     */     throws Exception
/*     */   {
/*  76 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new AuthorityPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.authoritys = authorityMgr.getAuthorityList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Authority getAuthority()
/*     */   {
/*  89 */     return this.authority;
/*     */   }
/*     */ 
/*     */   public void setAuthority(Authority authority) {
/*  93 */     this.authority = authority;
/*     */   }
/*     */ 
/*     */   public List<Authority> getAuthoritys() {
/*  97 */     return this.authoritys;
/*     */   }
/*     */ 
/*     */   public void setAuthoritys(List<Authority> authoritys) {
/* 101 */     this.authoritys = authoritys;
/*     */   }
/*     */ 
/*     */   public AuthorityPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(AuthorityPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.AuthorityAction
 * JD-Core Version:    0.6.0
 */