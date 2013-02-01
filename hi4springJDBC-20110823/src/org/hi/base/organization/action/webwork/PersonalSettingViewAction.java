/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class PersonalSettingViewAction extends BaseAction
/*    */ {
/*    */   private HiUser hiUser;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 16 */     this.hiUser = hiUserMgr.getHiUserById(UserContextHelper.getUser().getId());
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiUser getHiUser() {
/* 21 */     return this.hiUser;
/*    */   }
/*    */ 
/*    */   public void setHiUser(HiUser hiUser) {
/* 25 */     this.hiUser = hiUser;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.PersonalSettingViewAction
 * JD-Core Version:    0.6.0
 */