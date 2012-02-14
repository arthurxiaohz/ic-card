/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import java.beans.PropertyChangeListener;
/*    */ import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBModel;
/*    */ 
/*    */ public abstract class AbstractDBEditPart extends AbstractGraphicalEditPart
/*    */   implements PropertyChangeListener, IDoubleClickSupport
/*    */ {
/*    */   public void activate()
/*    */   {
/* 13 */     super.activate();
/* 14 */     ((AbstractDBModel)getModel()).addPropertyChangeListener(this);
/*    */   }
/*    */ 
/*    */   public void deactivate() {
/* 18 */     super.deactivate();
/* 19 */     ((AbstractDBModel)getModel()).removePropertyChangeListener(this);
/*    */   }
/*    */ 
/*    */   public void doubleClicked()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.AbstractDBEditPart
 * JD-Core Version:    0.6.0
 */