/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.context.UserContext;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class PersonalSettingSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private HiUser hiUser;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 22 */     if (super.perExecute(this.hiUser) != null) return returnCommand();
/* 23 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 25 */     Filter filter = FilterFactory.getSimpleFilter("userName", this.hiUser.getUserName(), "=");
/* 26 */     List users = hiUserMgr.getObjects(filter);
/* 27 */     if (users.size() > 1) {
/* 28 */       throw new BusinessException(I18NUtil.getString("帐号重复") + "!");
/*    */     }
/*    */ 
/* 32 */     MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder)SpringContextHolder.getBean("passwordEncoder");
/* 33 */     String newPassword = getRequest().getParameter("hiUser.newPassword");
/* 34 */     String password = passwordEncoder.encodePassword(newPassword, null);
/*    */ 
/* 36 */     if ((!newPassword.equals("")) && (!newPassword.equals(this.hiUser.getPassword()))) {
/* 37 */       this.hiUser.setPassword(password);
/*    */     }
/*    */ 
/* 40 */     hiUserMgr.saveObject(this.hiUser);
/* 41 */     super.postExecute(this.hiUser);
/*    */ 
/* 44 */     HiUser currentUser = UserContextHelper.getUser();
/* 45 */     if (currentUser.getId().equals(this.hiUser.getId())) {
/* 46 */       UserContext userContext = UserContextHelper.getUserContext();
/* 47 */       userContext.setUser(this.hiUser);
/*    */     }
/* 49 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiUser getHiUser() {
/* 53 */     return this.hiUser;
/*    */   }
/*    */ 
/*    */   public void setHiUser(HiUser hiUser) {
/* 57 */     this.hiUser = hiUser;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.PersonalSettingSaveAction
 * JD-Core Version:    0.6.0
 */