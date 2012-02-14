/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import org.eclipse.gef.editparts.AbstractTreeEditPart;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBModel;
/*    */ 
/*    */ public class AbstractDBTreeEditPart extends AbstractTreeEditPart
/*    */   implements PropertyChangeListener
/*    */ {
/*    */   public void activate()
/*    */   {
/* 15 */     super.activate();
/* 16 */     if ((getModel() instanceof AbstractDBModel))
/* 17 */       ((AbstractDBModel)getModel()).addPropertyChangeListener(this);
/*    */   }
/*    */ 
/*    */   public void deactivate()
/*    */   {
/* 22 */     super.deactivate();
/* 23 */     if ((getModel() instanceof AbstractDBModel))
/* 24 */       ((AbstractDBModel)getModel()).removePropertyChangeListener(this);
/*    */   }
/*    */ 
/*    */   public void propertyChange(PropertyChangeEvent evt)
/*    */   {
/* 29 */     String propName = evt.getPropertyName();
/* 30 */     if ("p_source_connection".equals(propName))
/* 31 */       refreshChildren();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.AbstractDBTreeEditPart
 * JD-Core Version:    0.6.0
 */