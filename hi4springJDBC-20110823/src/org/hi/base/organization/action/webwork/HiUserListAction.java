/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiUserListAction extends BaseAction
/*    */ {
/*    */   private HiUser hiUser;
/*    */   private HiUserPageInfo pageInfo;
/*    */   private List<HiUser> hiUsers;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new HiUserPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.hiUsers = hiUserMgr.getSecurityHiUserList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiUser getHiUser() {
/* 30 */     return this.hiUser;
/*    */   }
/*    */ 
/*    */   public void setHiUser(HiUser hiUser) {
/* 34 */     this.hiUser = hiUser;
/*    */   }
/*    */ 
/*    */   public List<HiUser> getHiUsers() {
/* 38 */     return this.hiUsers;
/*    */   }
/*    */ 
/*    */   public void setHiUsers(List<HiUser> hiUsers) {
/* 42 */     this.hiUsers = hiUsers;
/*    */   }
/*    */ 
/*    */   public HiUserPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(HiUserPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.HiUserListAction
 * JD-Core Version:    0.6.0
 */