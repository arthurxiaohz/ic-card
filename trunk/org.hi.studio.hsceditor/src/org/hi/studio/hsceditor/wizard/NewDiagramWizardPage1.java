/*    */ package org.hi.studio.hsceditor.wizard;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ import org.eclipse.swt.layout.GridData;
/*    */ import org.eclipse.swt.layout.GridLayout;
/*    */ import org.eclipse.swt.widgets.Combo;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.swt.widgets.Label;
/*    */ import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBSerializer;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class NewDiagramWizardPage1 extends WizardNewFileCreationPage
/*    */ {
/*    */   private Combo combo;
/*    */   private NewDiagramWizardPage2 page2;
/*    */ 
/*    */   public NewDiagramWizardPage1(IStructuredSelection selection, NewDiagramWizardPage2 page2)
/*    */   {
/* 24 */     super(DBPlugin.getResourceString("wizard.new.erd.title"), selection);
/* 25 */     setTitle(DBPlugin.getResourceString("wizard.new.erd.title"));
/* 26 */     setFileName("newfile.hsc");
/* 27 */     this.page2 = page2;
/*    */   }
/*    */ 
/*    */   public void createControl(Composite parent) {
/* 31 */     super.createControl(parent);
/* 32 */     Composite composite = new Composite((Composite)getControl(), 0);
/* 33 */     GridLayout layout = new GridLayout(2, false);
/* 34 */     layout.marginWidth = 0;
/* 35 */     layout.marginHeight = 0;
/*    */ 
/* 37 */     composite.setLayout(layout);
/* 38 */     composite.setLayoutData(new GridData(768));
/*    */ 
/* 40 */     Label label = new Label(composite, 0);
/* 41 */     label.setText(DBPlugin.getResourceString("wizard.new.erd.dialect"));
/*    */ 
/* 43 */     this.combo = new Combo(composite, 8);
/* 44 */     String[] dialectNames = DialectProvider.getDialectNames();
/* 45 */     for (int i = 0; i < dialectNames.length; i++) {
/* 46 */       this.combo.add(dialectNames[i]);
/*    */     }
/* 48 */     this.combo.setText(dialectNames[0]);
/* 49 */     validatePage();
/*    */   }
/*    */ 
/*    */   protected void createLinkTarget() {
/*    */   }
/*    */ 
/*    */   protected boolean validatePage() {
/* 56 */     boolean valid = super.validatePage();
/* 57 */     if (valid) {
/* 58 */       String fileName = getFileName();
/* 59 */       if (!fileName.endsWith(".hsc")) {
/* 60 */         setErrorMessage(DBPlugin.getResourceString("error.erd.extension"));
/* 61 */         valid = false;
/*    */       }
/*    */     }
/* 64 */     if (valid) {
/* 65 */       setMessage(DBPlugin.getResourceString("wizard.new.erd.message"));
/*    */     }
/* 67 */     return valid;
/*    */   }
/*    */ 
/*    */   protected InputStream getInitialContents() {
/* 71 */     RootModel root = new RootModel();
/* 72 */     root.setDialectName(this.combo.getText());
/*    */     try
/*    */     {
/* 75 */       this.page2.importTables(root);
/* 76 */       return VisualDBSerializer.serialize(root);
/*    */     }
/*    */     catch (Exception ex) {
/* 79 */       DBPlugin.logException(ex);
/* 80 */     }return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.wizard.NewDiagramWizardPage1
 * JD-Core Version:    0.6.0
 */