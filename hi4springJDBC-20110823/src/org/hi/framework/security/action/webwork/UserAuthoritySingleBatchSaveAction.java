/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class UserAuthoritySingleBatchSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private List<UserAuthority> userAuthorities;
/*    */   private String userAuthorityIndex;
/* 21 */   private HiUser user = null;
/*    */ 
/* 23 */   public String execute() throws Exception { if (super.perExecute(null) != null) return returnCommand();
/* 24 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 25 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 26 */     if ((this.userAuthorityIndex == null) || (this.userAuthorityIndex.length() <= 0)) {
/* 27 */       return returnCommand();
/*    */     }
/* 29 */     String[] indexs = this.userAuthorityIndex.split(",");
/*    */ 
/* 31 */     if (this.user.getUserMgrType().intValue() == 1400) {
/* 32 */       throw new BusinessException(I18NUtil.getStringByParameter("超级管理员无需授权", "Role", this.user.getFullName()));
/*    */     }
/* 34 */     userAuthorityMgr.saveBatchSingleUserAuthority(indexs, this.userAuthorities, this.user);
/* 35 */     super.postExecute(null);
/* 36 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public String getUserAuthorityIndex()
/*    */   {
/* 41 */     return this.userAuthorityIndex;
/*    */   }
/*    */ 
/*    */   public void setUserAuthorityIndex(String userAuthorityIndex) {
/* 45 */     this.userAuthorityIndex = userAuthorityIndex;
/*    */   }
/*    */ 
/*    */   public HiUser getUser() {
/* 49 */     return this.user;
/*    */   }
/*    */ 
/*    */   public void setUser(HiUser user) {
/* 53 */     this.user = user;
/*    */   }
/*    */ 
/*    */   public List<UserAuthority> getUserAuthorities()
/*    */   {
/* 58 */     return this.userAuthorities;
/*    */   }
/*    */ 
/*    */   public void setUserAuthorities(List<UserAuthority> userAuthorities)
/*    */   {
/* 63 */     this.userAuthorities = userAuthorities;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserAuthoritySingleBatchSaveAction
 * JD-Core Version:    0.6.0
 */