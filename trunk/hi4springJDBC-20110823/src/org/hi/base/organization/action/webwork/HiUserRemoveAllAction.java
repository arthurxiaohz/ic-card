/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiUserRemoveAllAction extends BaseAction
/*    */ {
/*    */   private HiUser hiUser;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer hiUserid = new Integer(ids[i]);
/* 24 */         hiUserMgr.removeHiUserById(hiUserid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
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
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.HiUserRemoveAllAction
 * JD-Core Version:    0.6.0
 */