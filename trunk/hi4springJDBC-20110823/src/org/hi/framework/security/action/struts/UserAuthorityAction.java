/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.UserAuthorityPageInfo;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.service.UserAuthorityManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class UserAuthorityAction extends BaseAction
/*     */ {
/*     */   private UserAuthority userAuthority;
/*     */   private UserAuthorityPageInfo pageInfo;
/*     */   private List<UserAuthority> userAuthoritys;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveUserAuthority()
/*     */     throws Exception
/*     */   {
/*  25 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  26 */     if (super.perExecute(this.userAuthority) != null) return returnCommand();
/*  27 */     userAuthorityMgr.saveUserAuthority(this.userAuthority);
/*  28 */     super.postExecute(this.userAuthority);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeUserAuthority()
/*     */     throws Exception
/*     */   {
/*  37 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  38 */     userAuthorityMgr.removeUserAuthorityById(this.userAuthority.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllUserAuthority()
/*     */     throws Exception
/*     */   {
/*  46 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer userAuthorityid = new Integer(ids[i]);
/*  55 */         userAuthorityMgr.removeUserAuthorityById(userAuthorityid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewUserAuthority()
/*     */     throws Exception
/*     */   {
/*  67 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  68 */     this.userAuthority = userAuthorityMgr.getUserAuthorityById(this.userAuthority.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String userAuthorityList()
/*     */     throws Exception
/*     */   {
/*  76 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new UserAuthorityPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.userAuthoritys = userAuthorityMgr.getUserAuthorityList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public UserAuthority getUserAuthority()
/*     */   {
/*  89 */     return this.userAuthority;
/*     */   }
/*     */ 
/*     */   public void setUserAuthority(UserAuthority userAuthority) {
/*  93 */     this.userAuthority = userAuthority;
/*     */   }
/*     */ 
/*     */   public List<UserAuthority> getUserAuthoritys() {
/*  97 */     return this.userAuthoritys;
/*     */   }
/*     */ 
/*     */   public void setUserAuthoritys(List<UserAuthority> userAuthoritys) {
/* 101 */     this.userAuthoritys = userAuthoritys;
/*     */   }
/*     */ 
/*     */   public UserAuthorityPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(UserAuthorityPageInfo pageInfo) {
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
 * Qualified Name:     org.hi.framework.security.action.struts.UserAuthorityAction
 * JD-Core Version:    0.6.0
 */