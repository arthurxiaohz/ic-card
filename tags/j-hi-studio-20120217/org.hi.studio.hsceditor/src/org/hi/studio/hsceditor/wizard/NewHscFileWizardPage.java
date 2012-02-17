/*    */ package org.hi.studio.hsceditor.wizard;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ import org.eclipse.swt.layout.GridData;
/*    */ import org.eclipse.swt.layout.GridLayout;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBSerializer;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class NewHscFileWizardPage extends WizardNewFileCreationPage
/*    */ {
/*    */   public NewHscFileWizardPage(IStructuredSelection selection)
/*    */   {
/* 23 */     super(DBPlugin.getResourceString("wizard.new.erd.title"), selection);
/* 24 */     setTitle(DBPlugin.getResourceString("wizard.new.erd.title"));
/* 25 */     setFileName("newservice.hmc");
/*    */   }
/*    */ 
/*    */   public void createControl(Composite parent) {
/* 29 */     super.createControl(parent);
/* 30 */     Composite composite = new Composite((Composite)getControl(), 0);
/* 31 */     GridLayout layout = new GridLayout(2, false);
/* 32 */     layout.marginWidth = 0;
/* 33 */     layout.marginHeight = 0;
/*    */ 
/* 35 */     composite.setLayout(layout);
/* 36 */     composite.setLayoutData(new GridData(768));
/*    */ 
/* 47 */     validatePage();
/*    */   }
/*    */ 
/*    */   protected void createLinkTarget() {
/*    */   }
/*    */ 
/*    */   protected boolean validatePage() {
/* 54 */     boolean valid = super.validatePage();
/* 55 */     if (valid) {
/* 56 */       String fileName = getFileName();
/* 57 */       if (!fileName.endsWith(".hmc")) {
/* 58 */         setErrorMessage(DBPlugin.getResourceString("error.erd.extension"));
/* 59 */         valid = false;
/*    */       }
/*    */     }
/* 62 */     if (valid) {
/* 63 */       setMessage(DBPlugin.getResourceString("wizard.new.erd.message"));
/*    */     }
/* 65 */     return valid;
/*    */   }
/*    */ 
/*    */   protected InputStream getInitialContents() {
/* 69 */     RootModel root = new RootModel();
/*    */     try
/*    */     {
/* 73 */       return VisualDBSerializer.serialize(root);
/*    */     }
/*    */     catch (Exception ex) {
/* 76 */       DBPlugin.logException(ex);
/* 77 */     }return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.wizard.NewHscFileWizardPage
 * JD-Core Version:    0.6.0
 */