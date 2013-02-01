/*    */ package org.hi.base.organization.model;
/*    */ 
/*    */ import org.hi.base.organization.model.original.HiOrgAbstract;
/*    */ import org.hi.base.tree.Component;
/*    */ 
/*    */ public class HiOrg extends HiOrgAbstract
/*    */   implements Component
/*    */ {
/*    */   public String getComponentName()
/*    */   {
/* 10 */     return this.orgName + ":" + this.id;
/*    */   }
/*    */ 
/*    */   public Component getTarget()
/*    */   {
/* 15 */     return this;
/*    */   }
/*    */ 
/*    */   public Component getTargetParent()
/*    */   {
/* 20 */     return this.parentOrg;
/*    */   }
/*    */ 
/*    */   public String getDataSymbol() {
/* 24 */     return this.orgNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.model.HiOrg
 * JD-Core Version:    0.6.0
 */