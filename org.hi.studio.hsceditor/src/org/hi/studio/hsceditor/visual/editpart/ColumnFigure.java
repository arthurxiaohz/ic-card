/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import org.eclipse.draw2d.Graphics;
/*    */ import org.eclipse.draw2d.Label;
/*    */ import org.eclipse.draw2d.geometry.Rectangle;
/*    */ 
/*    */ public class ColumnFigure extends Label
/*    */ {
/*    */   private boolean underline;
/*    */ 
/*    */   public void setUnderline(boolean underline)
/*    */   {
/* 15 */     this.underline = underline;
/*    */   }
/*    */ 
/*    */   protected void paintFigure(Graphics graphics) {
/* 19 */     super.paintFigure(graphics);
/*    */ 
/* 21 */     if (this.underline) {
/* 22 */       Rectangle bounds = getBounds();
/* 23 */       graphics.drawLine(
/* 24 */         bounds.x + 1, bounds.y + bounds.height - 1, 
/* 25 */         bounds.x + bounds.width - 2, bounds.y + bounds.height - 1);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.ColumnFigure
 * JD-Core Version:    0.6.0
 */