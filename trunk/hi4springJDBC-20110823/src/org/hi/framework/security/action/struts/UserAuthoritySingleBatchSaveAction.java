/*    */ package org.hi.framework.security.action.struts;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class UserAuthoritySingleBatchSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private List<UserAuthority> userAuthorities;
/*    */   private String userAuthorityIndex;
/* 19 */   private HiUser user = null;
/*    */ 
/* 21 */   public String execute() throws Exception { if (super.perExecute(null) != null) return returnCommand();
/* 22 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 23 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 24 */     if ((this.userAuthorityIndex == null) || (this.userAuthorityIndex.length() <= 0)) {
/* 25 */       return returnCommand();
/*    */     }
/* 27 */     String[] indexs = this.userAuthorityIndex.split(",");
/*    */ 
/* 29 */     if (this.user.getUserMgrType().intValue() == 1400) {
/* 30 */       throw new BusinessException(I18NUtil.getStringByParameter("超级管理员无需授权", this.user.getFullName()));
/*    */     }
/* 32 */     userAuthorityMgr.saveBatchSingleUserAuthority(indexs, this.userAuthorities, this.user);
/* 33 */     super.postExecute(null);
/* 34 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public String getUserAuthorityIndex()
/*    */   {
/* 39 */     return this.userAuthorityIndex;
/*    */   }
/*    */ 
/*    */   public void setUserAuthorityIndex(String userAuthorityIndex) {
/* 43 */     this.userAuthorityIndex = userAuthorityIndex;
/*    */   }
/*    */ 
/*    */   public HiUser getUser() {
/* 47 */     return this.user;
/*    */   }
/*    */ 
/*    */   public void setUser(HiUser user) {
/* 51 */     this.user = user;
/*    */   }
/*    */ 
/*    */   public List<UserAuthority> getUserAuthorities()
/*    */   {
/* 56 */     return this.userAuthorities;
/*    */   }
/*    */ 
/*    */   public void setUserAuthorities(List<UserAuthority> userAuthorities)
/*    */   {
/* 61 */     this.userAuthorities = userAuthorities;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.UserAuthoritySingleBatchSaveAction
 * JD-Core Version:    0.6.0
 */