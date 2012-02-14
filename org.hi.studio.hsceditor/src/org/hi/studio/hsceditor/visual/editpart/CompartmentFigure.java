/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import org.eclipse.draw2d.Figure;
/*    */ import org.eclipse.draw2d.ToolbarLayout;
/*    */ 
/*    */ public class CompartmentFigure extends Figure
/*    */ {
/*    */   public CompartmentFigure()
/*    */   {
/*  9 */     ToolbarLayout layout = new ToolbarLayout();
/* 10 */     layout.setMinorAlignment(1);
/* 11 */     layout.setStretchMinorAxis(false);
/* 12 */     layout.setSpacing(2);
/* 13 */     setLayoutManager(layout);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.CompartmentFigure
 * JD-Core Version:    0.6.0
 */