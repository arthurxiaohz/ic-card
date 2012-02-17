/*    */ package org.hi.studio.hsceditor.wizard;
/*    */ 
/*    */ import org.eclipse.core.resources.IFile;
/*    */ import org.eclipse.core.runtime.IPath;
/*    */ import org.eclipse.jface.viewers.ISelection;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ import org.eclipse.jface.wizard.Wizard;
/*    */ import org.eclipse.ui.INewWizard;
/*    */ import org.eclipse.ui.IWorkbench;
/*    */ import org.eclipse.ui.IWorkbenchPage;
/*    */ import org.eclipse.ui.IWorkbenchWindow;
/*    */ import org.eclipse.ui.PartInitException;
/*    */ import org.eclipse.ui.ide.IDE;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class NewDiagramWizard extends Wizard
/*    */   implements INewWizard
/*    */ {
/*    */   private NewDiagramWizardPage1 page1;
/*    */   private NewDiagramWizardPage2 page2;
/*    */   private IWorkbench workbench;
/*    */   private ISelection selection;
/*    */   private IPath path;
/*    */ 
/*    */   public NewDiagramWizard()
/*    */   {
/* 26 */     setNeedsProgressMonitor(true);
/* 27 */     setWindowTitle(DBPlugin.getResourceString("wizard.new.erd.title"));
/*    */   }
/*    */ 
/*    */   public void init(IWorkbench workbench, IStructuredSelection selection) {
/* 31 */     this.selection = selection;
/* 32 */     this.workbench = workbench;
/*    */   }
/*    */ 
/*    */   public void addPages() {
/* 36 */     this.page2 = new NewDiagramWizardPage2();
/* 37 */     this.page1 = new NewDiagramWizardPage1((IStructuredSelection)this.selection, this.page2);
/* 38 */     addPage(this.page1);
/* 39 */     addPage(this.page2);
/*    */ 
/* 41 */     this.page1.setContainerFullPath(this.path);
/*    */   }
/*    */ 
/*    */   public void setServiceFolder(IPath path) {
/* 45 */     this.path = path;
/*    */   }
/*    */ 
/*    */   public boolean performFinish() {
/*    */     try {
/* 50 */       IFile file = this.page1.createNewFile();
/* 51 */       if (file == null)
/* 52 */         return false;
/*    */       try
/*    */       {
/* 55 */         IWorkbenchPage page = this.workbench.getActiveWorkbenchWindow().getActivePage();
/* 56 */         IDE.openEditor(page, file, true);
/*    */       } catch (PartInitException ex) {
/* 58 */         DBPlugin.logException(ex);
/* 59 */         return false;
/*    */       }
/*    */     } catch (Exception ex) {
/* 62 */       ex.printStackTrace();
/*    */     }
/*    */ 
/* 65 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.wizard.NewDiagramWizard
 * JD-Core Version:    0.6.0
 */