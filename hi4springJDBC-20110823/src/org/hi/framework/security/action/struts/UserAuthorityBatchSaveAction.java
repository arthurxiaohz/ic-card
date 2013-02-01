/*    */ package org.hi.framework.security.action.struts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class UserAuthorityBatchSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private List<UserAuthority> userAuthorities;
/*    */   private String userIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     if (super.perExecute(null) != null) return returnCommand();
/* 21 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 22 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 24 */     if ((this.userIndexs == null) && (this.userIndexs.length() <= 0)) {
/* 25 */       return returnCommand();
/*    */     }
/* 27 */     List users = new ArrayList();
/* 28 */     String[] ids = this.userIndexs.split(",");
/* 29 */     for (int i = 0; i < ids.length; i++)
/*    */     {
/* 31 */       if (ids[i].length() <= 0)
/*    */         continue;
/* 33 */       Integer userid = new Integer(ids[i]);
/* 34 */       HiUser user = userMgr.getHiUserById(userid);
/*    */ 
/* 36 */       if (user.getUserMgrType().intValue() != 1400) {
/* 37 */         users.add(user);
/*    */       }
/*    */     }
/*    */ 
/* 41 */     userAuthorityMgr.saveBatchUserAuthority(users, this.userAuthorities);
/* 42 */     super.postExecute(null);
/* 43 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public List<UserAuthority> getUserAuthorities() {
/* 47 */     return this.userAuthorities;
/*    */   }
/*    */ 
/*    */   public void setUserAuthorities(List<UserAuthority> userAuthorities) {
/* 51 */     this.userAuthorities = userAuthorities;
/*    */   }
/*    */ 
/*    */   public String getUserIndexs() {
/* 55 */     return this.userIndexs;
/*    */   }
/*    */ 
/*    */   public void setUserIndexs(String userIndexs) {
/* 59 */     this.userIndexs = userIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.UserAuthorityBatchSaveAction
 * JD-Core Version:    0.6.0
 */