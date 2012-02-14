/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.eclipse.core.resources.IFile;
/*    */ import org.eclipse.core.resources.IFolder;
/*    */ import org.eclipse.core.runtime.IPath;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.ui.actions.SelectionAction;
/*    */ import org.eclipse.ui.ISharedImages;
/*    */ import org.eclipse.ui.IWorkbench;
/*    */ import org.eclipse.ui.PlatformUI;
/*    */ import org.hi.studio.core.utils.HiProjectUtil;
/*    */ import org.hi.studio.generator.utils.GenerateUtil;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*    */ import org.hi.studio.hsceditor.visual.editpart.TableEditPart;
/*    */ import org.hi.studio.hsceditor.visual.model.ICloneableModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class GeneratorEntityAction extends SelectionAction
/*    */ {
/*    */   public GeneratorEntityAction(VisualDBEditor editor, PasteAction pasteAction)
/*    */   {
/* 36 */     super(editor);
/*    */ 
/* 38 */     setId("org.hi.generate");
/* 39 */     setActionDefinitionId("org.hi.generate");
/* 40 */     setText("生成实体代码");
/* 41 */     ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
/* 42 */     setImageDescriptor(sharedImages.getImageDescriptor("IMG_TOOL_COPY"));
/* 43 */     setDisabledImageDescriptor(sharedImages.getImageDescriptor("IMG_TOOL_COPY_DISABLED"));
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 51 */     String entityNames = "";
/* 52 */     RootModel tempModel = null;
/*    */ 
/* 54 */     List selection = getSelectedObjects();
/* 55 */     new ArrayList();
/* 56 */     for (int i = 0; i < selection.size(); i++) {
/* 57 */       TableEditPart editPart = (TableEditPart)selection.get(i);
/*    */ 
/* 59 */       tempModel = (RootModel)editPart.getParent().getModel();
/* 60 */       entityNames = entityNames + ((TableModel)editPart.getModel()).getLogicalName() + ",";
/*    */     }
/*    */ 
/* 64 */     IFolder descfolder = HiProjectUtil.getWebContentDir(
/* 65 */       HiProjectUtil.getCurrentProject());
/* 66 */     IFile original = descfolder.getFile("WEB-INF/metadata/" + 
/* 67 */       tempModel.getServiceName() + ".hsc.xml");
/*    */ 
/* 71 */     GenerateUtil.generateHsc(original.getLocation().toString(), entityNames);
/*    */ 
/* 73 */     HiProjectUtil.refreshWorkspace();
/*    */   }
/*    */ 
/*    */   protected boolean calculateEnabled()
/*    */   {
/* 79 */     List selected = getSelectedObjects();
/* 80 */     if (selected.isEmpty()) {
/* 81 */       return true;
/*    */     }
/* 83 */     for (int i = 0; i < selected.size(); i++) {
/* 84 */       if (!(selected.get(i) instanceof EditPart)) {
/* 85 */         return false;
/*    */       }
/* 87 */       EditPart editPart = (EditPart)selected.get(i);
/* 88 */       if (ICloneableModel.class.isAssignableFrom(editPart.getModel().getClass())) {
/* 89 */         return true;
/*    */       }
/*    */     }
/* 92 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.GeneratorEntityAction
 * JD-Core Version:    0.6.0
 */