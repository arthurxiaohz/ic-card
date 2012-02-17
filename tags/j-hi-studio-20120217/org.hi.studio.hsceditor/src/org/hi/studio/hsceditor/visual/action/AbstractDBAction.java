/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.jface.action.Action;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ 
/*    */ public class AbstractDBAction extends Action
/*    */ {
/*    */   private GraphicalViewer viewer;
/*    */ 
/*    */   public AbstractDBAction(String name, GraphicalViewer viewer)
/*    */   {
/* 23 */     super(name);
/* 24 */     this.viewer = viewer;
/*    */   }
/*    */ 
/*    */   protected GraphicalViewer getViewer()
/*    */   {
/* 33 */     return this.viewer;
/*    */   }
/*    */ 
/*    */   public void update(IStructuredSelection sel)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.AbstractDBAction
 * JD-Core Version:    0.6.0
 */