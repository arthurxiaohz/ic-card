/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import org.eclipse.core.resources.IFile;
/*    */ import org.eclipse.core.runtime.CoreException;
/*    */ import org.eclipse.gef.EditDomain;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.gef.commands.Command;
/*    */ import org.eclipse.gef.commands.CommandStack;
/*    */ import org.eclipse.jface.action.Action;
/*    */ import org.eclipse.ui.IFileEditorInput;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.util.UIUtils;
/*    */ import org.hi.studio.hsceditor.validator.DiagramErrors;
/*    */ import org.hi.studio.hsceditor.validator.DiagramErrors.DiagramError;
/*    */ import org.hi.studio.hsceditor.validator.DiagramValidator;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class ValidateAction extends Action
/*    */ {
/*    */   private GraphicalViewer viewer;
/*    */ 
/*    */   public ValidateAction(GraphicalViewer viewer)
/*    */   {
/* 27 */     super(DBPlugin.getResourceString("action.validation.executeValidation"));
/* 28 */     this.viewer = viewer;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 34 */     CommandStack stack = this.viewer.getEditDomain().getCommandStack();
/* 35 */     stack.execute(new Command("Validation") {
/*    */       public boolean canUndo() {
/* 37 */         return false;
/*    */       }
/*    */ 
/*    */       public void execute() {
/*    */         try {
/* 42 */           RootModel model = (RootModel)ValidateAction.this.viewer.getContents().getModel();
/* 43 */           IFile file = ((IFileEditorInput)UIUtils.getActiveEditor().getEditorInput()).getFile();
/*    */ 
/* 45 */           file.deleteMarkers("org.eclipse.core.resources.problemmarker", false, 0);
/* 46 */           DiagramErrors errors = new DiagramValidator(model).doValidate();
/* 47 */           for (DiagramErrors.DiagramError error : errors.getErrors())
/* 48 */             error.addMarker(file);
/*    */         }
/*    */         catch (CoreException ex) {
/* 51 */           DBPlugin.logException(ex);
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.ValidateAction
 * JD-Core Version:    0.6.0
 */