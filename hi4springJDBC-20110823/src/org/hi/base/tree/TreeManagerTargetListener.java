/*    */ package org.hi.base.tree;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.context.HiEvent;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ import org.springframework.context.ApplicationEvent;
/*    */ import org.springframework.context.ApplicationListener;
/*    */ 
/*    */ public class TreeManagerTargetListener extends TreeManager
/*    */   implements ApplicationListener
/*    */ {
/*    */   public void onApplicationEvent(ApplicationEvent event)
/*    */   {
/* 25 */     if ((event instanceof HiEvent)) {
/* 26 */       HiEvent hiEvent = (HiEvent)event;
/* 27 */       Object source = hiEvent.getSource();
/*    */ 
/* 29 */       if (((source instanceof Component)) && (source.getClass().equals(getTargetClass()))) {
/* 30 */         ManagerImpl manager = getBusinessManager();
/* 31 */         List targets = manager.getObjects(getTargetClass());
/* 32 */         this.targets = targets;
/* 33 */         loadTree();
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.tree.TreeManagerTargetListener
 * JD-Core Version:    0.6.0
 */