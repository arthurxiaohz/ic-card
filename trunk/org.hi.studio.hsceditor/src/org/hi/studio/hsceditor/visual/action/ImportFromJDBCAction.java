/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.eclipse.core.runtime.NullProgressMonitor;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.jface.wizard.Wizard;
/*    */ import org.eclipse.jface.wizard.WizardDialog;
/*    */ import org.eclipse.swt.widgets.Control;
/*    */ import org.eclipse.swt.widgets.MessageBox;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.util.UIUtils;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.wizard.NewDiagramWizardPage2;
/*    */ 
/*    */ public class ImportFromJDBCAction extends AbstractDBAction
/*    */ {
/*    */   public ImportFromJDBCAction(GraphicalViewer viewer)
/*    */   {
/* 22 */     super(DBPlugin.getResourceString("action.importFromDB"), viewer);
/*    */   }
/*    */ 
/*    */   public void run() {
/* 26 */     ImportFromJDBCWizard wizard = new ImportFromJDBCWizard();
/* 27 */     WizardDialog dialog = new WizardDialog(
/* 28 */       getViewer().getControl().getShell(), wizard);
/* 29 */     dialog.open();
/*    */   }
/*    */ 
/*    */   private class ImportFromJDBCWizard extends Wizard
/*    */   {
/*    */     private NewDiagramWizardPage2 page;
/*    */ 
/*    */     public ImportFromJDBCWizard() {
/* 38 */       setNeedsProgressMonitor(true);
/* 39 */       setWindowTitle(DBPlugin.getResourceString("wizard.new.import.title"));
/*    */     }
/*    */ 
/*    */     public void addPages() {
/* 43 */       RootModel root = (RootModel)ImportFromJDBCAction.this.getViewer().getContents().getModel();
/* 44 */       this.page = new NewDiagramWizardPage2(root);
/* 45 */       addPage(this.page);
/*    */     }
/*    */ 
/*    */     public boolean performFinish() {
/* 49 */       RootModel root = (RootModel)ImportFromJDBCAction.this.getViewer().getContents().getModel();
/*    */       try {
/* 51 */         this.page.importTables(root);
/* 52 */         UIUtils.getActiveEditor().doSave(new NullProgressMonitor());
/* 53 */         return true;
/*    */       } catch (SQLException ex) {
/* 55 */         DBPlugin.logException(ex);
/* 56 */         MessageBox msg = new MessageBox(getShell());
/* 57 */         msg.setMessage(ex.getMessage());
/* 58 */         msg.open();
/* 59 */       }return false;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.ImportFromJDBCAction
 * JD-Core Version:    0.6.0
 */