/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.UserAuthorityPageInfo;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserAuthorityListAction extends BaseAction
/*    */ {
/*    */   private UserAuthority userAuthority;
/*    */   private UserAuthorityPageInfo pageInfo;
/*    */   private List<UserAuthority> userAuthoritys;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new UserAuthorityPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.userAuthoritys = userAuthorityMgr.getUserAuthorityList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserAuthority getUserAuthority() {
/* 30 */     return this.userAuthority;
/*    */   }
/*    */ 
/*    */   public void setUserAuthority(UserAuthority userAuthority) {
/* 34 */     this.userAuthority = userAuthority;
/*    */   }
/*    */ 
/*    */   public List<UserAuthority> getUserAuthoritys() {
/* 38 */     return this.userAuthoritys;
/*    */   }
/*    */ 
/*    */   public void setUserAuthoritys(List<UserAuthority> userAuthoritys) {
/* 42 */     this.userAuthoritys = userAuthoritys;
/*    */   }
/*    */ 
/*    */   public UserAuthorityPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(UserAuthorityPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserAuthorityListAction
 * JD-Core Version:    0.6.0
 */