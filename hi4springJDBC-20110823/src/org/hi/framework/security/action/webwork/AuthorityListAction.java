/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.AuthorityPageInfo;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AuthorityListAction extends BaseAction
/*    */ {
/*    */   private Authority authority;
/*    */   private AuthorityPageInfo pageInfo;
/*    */   private List<Authority> authoritys;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new AuthorityPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.authoritys = authorityMgr.getAuthorityList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Authority getAuthority() {
/* 30 */     return this.authority;
/*    */   }
/*    */ 
/*    */   public void setAuthority(Authority authority) {
/* 34 */     this.authority = authority;
/*    */   }
/*    */ 
/*    */   public List<Authority> getAuthoritys() {
/* 38 */     return this.authoritys;
/*    */   }
/*    */ 
/*    */   public void setAuthoritys(List<Authority> authoritys) {
/* 42 */     this.authoritys = authoritys;
/*    */   }
/*    */ 
/*    */   public AuthorityPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(AuthorityPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.AuthorityListAction
 * JD-Core Version:    0.6.0
 */