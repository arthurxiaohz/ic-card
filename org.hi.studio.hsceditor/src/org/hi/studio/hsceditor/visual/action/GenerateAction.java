/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.ui.IFileEditorInput;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*    */ import org.hi.studio.hsceditor.visual.generate.IGenerator;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class GenerateAction extends AbstractDBAction
/*    */ {
/*    */   private IGenerator generater;
/*    */   private VisualDBEditor editor;
/*    */ 
/*    */   public GenerateAction(IGenerator generater, GraphicalViewer viewer, VisualDBEditor editor)
/*    */   {
/* 20 */     super(generater.getGeneratorName(), viewer);
/* 21 */     this.generater = generater;
/* 22 */     this.editor = editor;
/*    */   }
/*    */ 
/*    */   public void run() {
/* 26 */     RootModel root = (RootModel)getViewer().getContents().getModel();
/* 27 */     IFileEditorInput input = (IFileEditorInput)this.editor.getEditorInput();
/* 28 */     this.generater.execute(input.getFile(), root);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.GenerateAction
 * JD-Core Version:    0.6.0
 */