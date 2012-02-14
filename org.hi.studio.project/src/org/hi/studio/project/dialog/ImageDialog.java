/*    */ package org.hi.studio.project.dialog;
/*    */ 
/*    */ import org.eclipse.jface.dialogs.Dialog;
/*    */ import org.eclipse.swt.events.PaintEvent;
/*    */ import org.eclipse.swt.events.PaintListener;
/*    */ import org.eclipse.swt.graphics.GC;
/*    */ import org.eclipse.swt.graphics.Image;
/*    */ import org.eclipse.swt.widgets.Button;
/*    */ import org.eclipse.swt.widgets.Canvas;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.swt.widgets.Control;
/*    */ import org.eclipse.swt.widgets.Shell;
/*    */ 
/*    */ public class ImageDialog extends Dialog
/*    */ {
/*    */   private Image image;
/*    */ 
/*    */   public ImageDialog(Shell parentShell, Image image)
/*    */   {
/* 20 */     super(parentShell);
/* 21 */     this.image = image;
/*    */   }
/*    */   protected Control createDialogArea(Composite parent) {
/* 24 */     Composite comp = new Composite(parent, 0);
/* 25 */     Canvas canvas = new Canvas(comp, 2048);
/*    */ 
/* 27 */     canvas.setBounds(0, 0, 800, 600);
/* 28 */     canvas.addPaintListener(new PaintListener()
/*    */     {
/*    */       public void paintControl(PaintEvent e)
/*    */       {
/* 32 */         e.gc.drawImage(ImageDialog.this.image, 0, 0);
/*    */       }
/*    */     });
/* 35 */     if (this.image != null) {
/* 36 */       canvas.redraw();
/*    */     }
/* 38 */     return comp;
/*    */   }
/*    */ 
/*    */   protected Button createButton(Composite parent, int id, String label, boolean defaultButton)
/*    */   {
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   protected void initializeBounds()
/*    */   {
/* 51 */     super.createButton((Composite)getButtonBar(), 0, "确定", true);
/* 52 */     super.initializeBounds();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.dialog.ImageDialog
 * JD-Core Version:    0.6.0
 */