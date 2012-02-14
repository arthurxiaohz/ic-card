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
/*    */ public class NewHscFileWizard extends Wizard
/*    */   implements INewWizard
/*    */ {
/*    */   private NewHscFileWizardPage page1;
/*    */   private IWorkbench workbench;
/*    */   private ISelection selection;
/*    */   private IPath path;
/*    */ 
/*    */   public NewHscFileWizard()
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
/* 36 */     this.page1 = new NewHscFileWizardPage((IStructuredSelection)this.selection);
/* 37 */     addPage(this.page1);
/*    */ 
/* 39 */     this.page1.setContainerFullPath(this.path);
/*    */   }
/*    */ 
/*    */   public void setServiceFolder(IPath path) {
/* 43 */     this.path = path;
/*    */   }
/*    */ 
/*    */   public boolean canFinish()
/*    */   {
/* 49 */     this.page1.getFileName();
/*    */ 
/* 56 */     return super.canFinish();
/*    */   }
/*    */ 
/*    */   public boolean performFinish() {
/*    */     try {
/* 61 */       IFile file = this.page1.createNewFile();
/* 62 */       if (file == null)
/* 63 */         return false;
/*    */       try
/*    */       {
/* 66 */         IWorkbenchPage page = this.workbench.getActiveWorkbenchWindow().getActivePage();
/* 67 */         IDE.openEditor(page, file, true);
/*    */       } catch (PartInitException ex) {
/* 69 */         DBPlugin.logException(ex);
/* 70 */         return false;
/*    */       }
/*    */     } catch (Exception ex) {
/* 73 */       ex.printStackTrace();
/*    */     }
/*    */ 
/* 76 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.wizard.NewHscFileWizard
 * JD-Core Version:    0.6.0
 */