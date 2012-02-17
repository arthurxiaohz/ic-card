/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import org.eclipse.draw2d.IFigure;
/*    */ import org.eclipse.draw2d.SWTGraphics;
/*    */ import org.eclipse.draw2d.geometry.Rectangle;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.gef.editparts.ScalableRootEditPart;
/*    */ import org.eclipse.gef.editparts.ZoomManager;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ import org.eclipse.swt.graphics.GC;
/*    */ import org.eclipse.swt.graphics.Image;
/*    */ import org.eclipse.swt.graphics.ImageData;
/*    */ import org.eclipse.swt.graphics.ImageLoader;
/*    */ import org.eclipse.swt.widgets.Display;
/*    */ import org.eclipse.swt.widgets.FileDialog;
/*    */ import org.eclipse.ui.IEditorPart;
/*    */ import org.eclipse.ui.IWorkbench;
/*    */ import org.eclipse.ui.IWorkbenchPage;
/*    */ import org.eclipse.ui.IWorkbenchWindow;
/*    */ import org.eclipse.ui.PlatformUI;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class SaveAsImageAction extends AbstractDBAction
/*    */ {
/*    */   public SaveAsImageAction(GraphicalViewer viewer)
/*    */   {
/* 27 */     super(DBPlugin.getResourceString("action.saveAsImage"), viewer);
/* 28 */     setImageDescriptor(DBPlugin.getImageDescriptor("icons/save_as_image.gif"));
/*    */   }
/*    */ 
/*    */   public void update(IStructuredSelection sel)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void run() {
/* 36 */     ScalableRootEditPart rootEditPart = (ScalableRootEditPart)getViewer().getRootEditPart();
/* 37 */     double zoom = rootEditPart.getZoomManager().getZoom();
/*    */     try
/*    */     {
/* 40 */       FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), 8192);
/* 41 */       dialog.setFileName(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getTitle() + ".jpg");
/* 42 */       String file = dialog.open();
/* 43 */       if (file != null) {
/* 44 */         IFigure figure = rootEditPart.getLayer("Printable Layers");
/*    */ 
/* 46 */         Rectangle rectangle = figure.getBounds();
/*    */ 
/* 48 */         Image image = new Image(Display.getDefault(), rectangle.width + 50, rectangle.height + 50);
/* 49 */         GC gc = new GC(image);
/* 50 */         SWTGraphics graphics = new SWTGraphics(gc);
/* 51 */         figure.paint(graphics);
/*    */ 
/* 53 */         ImageLoader loader = new ImageLoader();
/* 54 */         loader.data = new ImageData[] { image.getImageData() };
/*    */ 
/* 56 */         if (file.endsWith(".bmp")) {
/* 57 */           loader.save(file, 0);
/* 58 */         } else if (file.endsWith(".gif")) {
/* 59 */           loader.save(file, 2);
/* 60 */         } else if ((file.endsWith(".jpg")) || (file.endsWith(".jpeg"))) {
/* 61 */           loader.save(file, 4);
/* 62 */         } else if (file.endsWith(".png")) {
/* 63 */           loader.save(file, 5);
/* 64 */         } else if (file.endsWith(".tiff")) {
/* 65 */           loader.save(file, 6);
/*    */         } else {
/* 67 */           file = file + ".bmp";
/* 68 */           loader.save(file, 0);
/*    */         }
/*    */ 
/* 71 */         image.dispose();
/* 72 */         gc.dispose();
/*    */       }
/*    */     } catch (Exception localException) {
/*    */     }
/*    */     finally {
/* 77 */       rootEditPart.getZoomManager().setZoom(zoom);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.SaveAsImageAction
 * JD-Core Version:    0.6.0
 */