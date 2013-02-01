/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class HiUserSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private HiUser hiUser;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 19 */     if (super.perExecute(this.hiUser) != null) return returnCommand();
/* 20 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 22 */     Filter filter = FilterFactory.getSimpleFilter("userName", this.hiUser.getUserName(), "=");
/* 23 */     List users = hiUserMgr.getObjects(filter);
/* 24 */     if (users.size() > 1) {
/* 25 */       throw new BusinessException(I18NUtil.getString("帐号重复") + "!");
/*    */     }
/* 27 */     hiUserMgr.saveHiUser(this.hiUser);
/* 28 */     super.postExecute(this.hiUser);
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiUser getHiUser() {
/* 33 */     return this.hiUser;
/*    */   }
/*    */ 
/*    */   public void setHiUser(HiUser hiUser) {
/* 37 */     this.hiUser = hiUser;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.HiUserSaveAction
 * JD-Core Version:    0.6.0
 */