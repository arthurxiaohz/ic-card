/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AuthorityRemoveAllAction extends BaseAction
/*    */ {
/*    */   private Authority authority;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer authorityid = new Integer(ids[i]);
/* 24 */         authorityMgr.removeAuthorityById(authorityid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Authority getAuthority() {
/* 33 */     return this.authority;
/*    */   }
/*    */ 
/*    */   public void setAuthority(Authority authority) {
/* 37 */     this.authority = authority;
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
 * Qualified Name:     org.hi.framework.security.action.webwork.AuthorityRemoveAllAction
 * JD-Core Version:    0.6.0
 */