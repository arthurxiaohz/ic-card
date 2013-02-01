/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.UserRolePageInfo;
/*     */ import org.hi.framework.security.model.UserRole;
/*     */ import org.hi.framework.security.service.UserRoleManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class UserRoleAction extends BaseAction
/*     */ {
/*     */   private UserRole userRole;
/*     */   private UserRolePageInfo pageInfo;
/*     */   private List<UserRole> userRoles;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveUserRole()
/*     */     throws Exception
/*     */   {
/*  25 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*  26 */     if (super.perExecute(this.userRole) != null) return returnCommand();
/*  27 */     userRoleMgr.saveUserRole(this.userRole);
/*  28 */     super.postExecute(this.userRole);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeUserRole()
/*     */     throws Exception
/*     */   {
/*  37 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*  38 */     userRoleMgr.removeUserRoleById(this.userRole.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllUserRole()
/*     */     throws Exception
/*     */   {
/*  46 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer userRoleid = new Integer(ids[i]);
/*  55 */         userRoleMgr.removeUserRoleById(userRoleid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewUserRole()
/*     */     throws Exception
/*     */   {
/*  67 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*  68 */     this.userRole = userRoleMgr.getUserRoleById(this.userRole.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String userRoleList()
/*     */     throws Exception
/*     */   {
/*  76 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new UserRolePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.userRoles = userRoleMgr.getUserRoleList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public UserRole getUserRole()
/*     */   {
/*  89 */     return this.userRole;
/*     */   }
/*     */ 
/*     */   public void setUserRole(UserRole userRole) {
/*  93 */     this.userRole = userRole;
/*     */   }
/*     */ 
/*     */   public List<UserRole> getUserRoles() {
/*  97 */     return this.userRoles;
/*     */   }
/*     */ 
/*     */   public void setUserRoles(List<UserRole> userRoles) {
/* 101 */     this.userRoles = userRoles;
/*     */   }
/*     */ 
/*     */   public UserRolePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(UserRolePageInfo pageInfo) {
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.struts.UserRoleAction
 * JD-Core Version:    0.6.0
 */