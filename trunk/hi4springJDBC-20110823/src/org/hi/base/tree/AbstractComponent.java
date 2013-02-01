/*    */ package org.hi.base.tree;
/*    */ 
/*    */ public abstract class AbstractComponent
/*    */   implements Component
/*    */ {
/*    */   private String componentName;
/*    */   private Component targetParent;
/*    */   private Component target;
/*    */ 
/*    */   public String getComponentName()
/*    */   {
/* 20 */     return this.componentName;
/*    */   }
/*    */ 
/*    */   public Component getTarget()
/*    */   {
/* 27 */     return this.target;
/*    */   }
/*    */ 
/*    */   public Component getTargetParent()
/*    */   {
/* 34 */     return this.targetParent;
/*    */   }
/*    */ 
/*    */   public void setComponentName(String componentName) {
/* 38 */     this.componentName = componentName;
/*    */   }
/*    */ 
/*    */   public void setTarget(Component target) {
/* 42 */     this.target = target;
/*    */   }
/*    */ 
/*    */   public void setTargetParent(Component targetParent) {
/* 46 */     this.targetParent = targetParent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.tree.AbstractComponent
 * JD-Core Version:    0.6.0
 */