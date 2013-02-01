/*     */ package org.hi.base.organization.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.action.HiUserPageInfo;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiUserManager;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.context.UserContext;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class HiUserAction extends BaseAction
/*     */ {
/*     */   private HiUser hiUser;
/*     */   private HiUserPageInfo pageInfo;
/*     */   private List<HiUser> hiUsers;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveHiUser()
/*     */     throws Exception
/*     */   {
/*  32 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  33 */     Filter filter = FilterFactory.getSimpleFilter("userName", this.hiUser.getUserName(), "=");
/*  34 */     List users = hiUserMgr.getObjects(filter);
/*  35 */     if (users.size() > 1) {
/*  36 */       throw new BusinessException(I18NUtil.getString("帐号重复") + "!");
/*     */     }
/*  38 */     if (super.perExecute(this.hiUser) != null) return returnCommand();
/*     */ 
/*  40 */     hiUserMgr.saveHiUser(this.hiUser);
/*  41 */     super.postExecute(this.hiUser);
/*  42 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeHiUser()
/*     */     throws Exception
/*     */   {
/*  50 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  51 */     hiUserMgr.removeHiUserById(this.hiUser.getId());
/*  52 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllHiUser()
/*     */     throws Exception
/*     */   {
/*  59 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  60 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  62 */       String[] ids = this.orderIndexs.split(",");
/*  63 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  65 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  67 */         Integer hiUserid = new Integer(ids[i]);
/*  68 */         hiUserMgr.removeHiUserById(hiUserid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  73 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewHiUser()
/*     */     throws Exception
/*     */   {
/*  80 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  81 */     this.hiUser = hiUserMgr.getHiUserById(this.hiUser.getId());
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String hiUserList()
/*     */     throws Exception
/*     */   {
/*  89 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  90 */     this.pageInfo = (this.pageInfo == null ? new HiUserPageInfo() : this.pageInfo);
/*  91 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  93 */     this.hiUsers = hiUserMgr.getSecurityHiUserList(sarchPageInfo);
/*     */ 
/*  95 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String currentUser()
/*     */     throws Exception
/*     */   {
/* 102 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 103 */     this.hiUser = hiUserMgr.getHiUserById(UserContextHelper.getUser().getId());
/* 104 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String saveUserPassword()
/*     */     throws Exception
/*     */   {
/* 112 */     if (super.perExecute(this.hiUser) != null) return returnCommand();
/* 113 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*     */ 
/* 115 */     Filter filter = FilterFactory.getSimpleFilter("userName", this.hiUser.getUserName(), "=");
/* 116 */     List users = hiUserMgr.getObjects(filter);
/* 117 */     if (users.size() > 1) {
/* 118 */       throw new BusinessException(I18NUtil.getString("帐号重复") + "!");
/*     */     }
/* 120 */     MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder)SpringContextHolder.getBean("passwordEncoder");
/* 121 */     String newPassword = getRequest().getParameter("hiUser.newPassword");
/* 122 */     String password = passwordEncoder.encodePassword(newPassword, null);
/*     */ 
/* 124 */     if ((!newPassword.equals("")) && (!newPassword.equals(this.hiUser.getPassword()))) {
/* 125 */       this.hiUser.setPassword(password);
/*     */     }
/*     */ 
/* 128 */     hiUserMgr.saveObject(this.hiUser);
/* 129 */     super.postExecute(this.hiUser);
/*     */ 
/* 132 */     HiUser currentUser = UserContextHelper.getUser();
/* 133 */     if (currentUser.getId().equals(this.hiUser.getId())) {
/* 134 */       UserContext userContext = UserContextHelper.getUserContext();
/* 135 */       userContext.setUser(this.hiUser);
/*     */     }
/*     */ 
/* 138 */     return returnCommand();
/*     */   }
/*     */   public HiUser getHiUser() {
/* 141 */     return this.hiUser;
/*     */   }
/*     */ 
/*     */   public void setHiUser(HiUser hiUser) {
/* 145 */     this.hiUser = hiUser;
/*     */   }
/*     */ 
/*     */   public List<HiUser> getHiUsers() {
/* 149 */     return this.hiUsers;
/*     */   }
/*     */ 
/*     */   public void setHiUsers(List<HiUser> hiUsers) {
/* 153 */     this.hiUsers = hiUsers;
/*     */   }
/*     */ 
/*     */   public HiUserPageInfo getPageInfo() {
/* 157 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(HiUserPageInfo pageInfo) {
/* 161 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 165 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 169 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.action.struts.HiUserAction
 * JD-Core Version:    0.6.0
 */