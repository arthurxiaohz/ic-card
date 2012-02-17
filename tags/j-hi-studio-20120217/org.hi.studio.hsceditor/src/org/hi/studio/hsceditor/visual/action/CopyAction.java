/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.ui.actions.Clipboard;
/*    */ import org.eclipse.gef.ui.actions.SelectionAction;
/*    */ import org.eclipse.ui.ISharedImages;
/*    */ import org.eclipse.ui.IWorkbench;
/*    */ import org.eclipse.ui.PlatformUI;
/*    */ import org.eclipse.ui.actions.ActionFactory;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*    */ import org.hi.studio.hsceditor.visual.model.ICloneableModel;
/*    */ 
/*    */ public class CopyAction extends SelectionAction
/*    */ {
/*    */   private PasteAction pasteAction;
/*    */ 
/*    */   public CopyAction(VisualDBEditor editor, PasteAction pasteAction)
/*    */   {
/* 27 */     super(editor);
/*    */ 
/* 29 */     setId(ActionFactory.COPY.getId());
/* 30 */     setActionDefinitionId(ActionFactory.COPY.getId());
/* 31 */     setText(DBPlugin.getResourceString("action.copy"));
/* 32 */     ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
/* 33 */     setImageDescriptor(sharedImages.getImageDescriptor("IMG_TOOL_COPY"));
/* 34 */     setDisabledImageDescriptor(sharedImages.getImageDescriptor("IMG_TOOL_COPY_DISABLED"));
/*    */ 
/* 36 */     this.pasteAction = pasteAction;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 41 */     List selection = getSelectedObjects();
/* 42 */     List copied = new ArrayList();
/* 43 */     for (int i = 0; i < selection.size(); i++) {
/* 44 */       EditPart editPart = (EditPart)selection.get(i);
/* 45 */       ICloneableModel cloneable = (ICloneableModel)editPart.getModel();
/* 46 */       copied.add(cloneable.clone());
/*    */     }
/* 48 */     Clipboard.getDefault().setContents(copied);
/*    */ 
/* 50 */     this.pasteAction.update();
/*    */   }
/*    */ 
/*    */   protected boolean calculateEnabled()
/*    */   {
/* 55 */     List selected = getSelectedObjects();
/* 56 */     if (selected.isEmpty()) {
/* 57 */       return true;
/*    */     }
/* 59 */     for (int i = 0; i < selected.size(); i++) {
/* 60 */       if (!(selected.get(i) instanceof EditPart)) {
/* 61 */         return false;
/*    */       }
/* 63 */       EditPart editPart = (EditPart)selected.get(i);
/* 64 */       if (ICloneableModel.class.isAssignableFrom(editPart.getModel().getClass())) {
/* 65 */         return true;
/*    */       }
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.CopyAction
 * JD-Core Version:    0.6.0
 */