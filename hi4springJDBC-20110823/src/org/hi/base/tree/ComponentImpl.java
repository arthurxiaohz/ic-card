/*    */ package org.hi.base.tree;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ComponentImpl extends AbstractComponent
/*    */ {
/* 17 */   protected List<Component> components = Collections.synchronizedList(new ArrayList());
/* 18 */   protected List<Component> allComponents = Collections.synchronizedList(new ArrayList());
/*    */   protected Component parentComponent;
/*    */   private TreeManager treeMgr;
/*    */ 
/*    */   ComponentImpl(Component component, TreeManager treeMgr)
/*    */   {
/* 23 */     setComponentName(component.getComponentName());
/* 24 */     setTarget(component.getTarget());
/* 25 */     setTargetParent(component.getTargetParent());
/* 26 */     this.treeMgr = treeMgr;
/*    */   }
/*    */ 
/*    */   public void addComponent(ComponentImpl childComponent)
/*    */   {
/* 34 */     if ((childComponent.getComponentName() == null) || (childComponent.getComponentName().equals(""))) {
/* 35 */       childComponent.setComponentName(getComponentName() + this.components.size());
/*    */     }
/*    */ 
/* 38 */     if (!this.components.contains(childComponent)) {
/* 39 */       this.components.add(childComponent);
/* 40 */       if (!this.allComponents.contains(childComponent)) {
/* 41 */         this.allComponents.add(childComponent);
/*    */       }
/* 43 */       childComponent.setParentComponent(this);
/*    */     }
/*    */   }
/*    */ 
/*    */   void setParentComponent(ComponentImpl parentComponent)
/*    */   {
/* 52 */     if (parentComponent != null)
/*    */     {
/* 54 */       if (!parentComponent.getComponents().contains(this)) {
/* 55 */         parentComponent.addComponent(this);
/*    */       }
/*    */ 
/* 58 */       List children = this.treeMgr.getChildren(this);
/* 59 */       if (children != null) {
/* 60 */         for (Iterator it = children.iterator(); it.hasNext(); ) {
/* 61 */           ComponentImpl child = (ComponentImpl)it.next();
/*    */ 
/* 63 */           if (!this.treeMgr.get_component().allComponents.contains(child)) {
/* 64 */             this.treeMgr.get_component().allComponents.add(child);
/*    */           }
/* 66 */           addComponent(child);
/*    */         }
/*    */       }
/*    */     }
/* 70 */     this.parentComponent = parentComponent;
/*    */   }
/*    */ 
/*    */   public Component getParentComponent() {
/* 74 */     return this.parentComponent;
/*    */   }
/*    */ 
/*    */   public List<Component> getComponents()
/*    */   {
/* 83 */     return this.components;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 87 */     return getComponentName();
/*    */   }
/*    */ 
/*    */   public List<Component> getAllComponents()
/*    */   {
/* 96 */     return this.allComponents;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.tree.ComponentImpl
 * JD-Core Version:    0.6.0
 */