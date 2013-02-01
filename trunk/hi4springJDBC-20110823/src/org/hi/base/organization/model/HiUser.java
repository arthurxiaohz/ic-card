/*    */ package org.hi.base.organization.model;
/*    */ 
/*    */ import org.hi.base.organization.model.original.HiUserAbstract;
/*    */ 
/*    */ public class HiUser extends HiUserAbstract
/*    */ {
/*    */   public boolean isSupperManager()
/*    */   {
/* 10 */     if (this.userMgrType == null)
/* 11 */       return false;
/* 12 */     return this.userMgrType.equals(Integer.valueOf(1400));
/*    */   }
/*    */ 
/*    */   public String getDataSymbol() {
/* 16 */     return this.fullName;
/*    */   }
/*    */ 
/*    */   public Integer getUserMgrType() {
/* 20 */     if (this.userMgrType == null)
/* 21 */       return Integer.valueOf(1402);
/* 22 */     return this.userMgrType;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.model.HiUser
 * JD-Core Version:    0.6.0
 */