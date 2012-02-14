/*     */ package org.hi.studio.hsceditor.visual.generate;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.eclipse.core.resources.IContainer;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IResource;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.core.runtime.NullProgressMonitor;
/*     */ import org.eclipse.jface.dialogs.IDialogSettings;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.jface.wizard.Wizard;
/*     */ import org.eclipse.jface.wizard.WizardDialog;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*     */ import org.hi.studio.hsceditor.dialect.IDialect;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ 
/*     */ public class DDLGenerater
/*     */   implements IGenerator
/*     */ {
/*     */   public String getGeneratorName()
/*     */   {
/*  32 */     return "DDL";
/*     */   }
/*     */ 
/*     */   public void execute(IFile erdFile, RootModel root)
/*     */   {
/*  37 */     WizardDialog dialog = new WizardDialog(null, new DDLWizard(erdFile, root));
/*  38 */     dialog.open();
/*     */   }
/*     */ 
/*     */   private static boolean isSupportedEncoding(String encoding)
/*     */   {
/*     */     try
/*     */     {
/* 203 */       new String(new byte[0], encoding);
/*     */     } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   private class DDLWizard extends Wizard
/*     */   {
/*     */     private IFile erdFile;
/*     */     private RootModel root;
/*     */     private DDLGenerater.DDLWizardPage page;
/*     */ 
/*     */     public DDLWizard(IFile erdFile, RootModel root)
/*     */     {
/*  48 */       this.erdFile = erdFile;
/*  49 */       this.root = root;
/*  50 */       setWindowTitle(DDLGenerater.this.getGeneratorName());
/*     */ 
/*  52 */       IDialogSettings settings = DBPlugin.getDefault().getDialogSettings();
/*  53 */       IDialogSettings section = settings.getSection("DDLWizard");
/*  54 */       if (section == null) {
/*  55 */         section = settings.addNewSection("DDLWizard");
/*  56 */         section.put("schema", false);
/*  57 */         section.put("drop", false);
/*  58 */         section.put("alterTable", true);
/*  59 */         section.put("comment", true);
/*  60 */         section.put("encoding", System.getProperty("file.encoding"));
/*     */       }
/*  62 */       setDialogSettings(section);
/*     */     }
/*     */ 
/*     */     public void addPages() {
/*  66 */       this.page = new DDLGenerater.DDLWizardPage(DDLGenerater.this, this.erdFile);
/*  67 */       addPage(this.page);
/*     */     }
/*     */ 
/*     */     public boolean performFinish() {
/*     */       try {
/*  72 */         IPath path = this.page.getOutputFolderResource().getFullPath();
/*  73 */         path = path.append(DDLGenerater.DDLWizardPage.access$0(this.page).getText());
/*     */ 
/*  75 */         String ddl = DialectProvider.getDialect(this.root.getDialectName()).createDDL(
/*  76 */           this.root, DDLGenerater.DDLWizardPage.access$1(this.page).getSelection(), DDLGenerater.DDLWizardPage.access$2(this.page).getSelection(), 
/*  77 */           DDLGenerater.DDLWizardPage.access$3(this.page).getSelection(), DDLGenerater.DDLWizardPage.access$4(this.page).getSelection());
/*     */ 
/*  79 */         IDialogSettings section = getDialogSettings();
/*  80 */         section.put("schema", DDLGenerater.DDLWizardPage.access$1(this.page).getSelection());
/*  81 */         section.put("drop", DDLGenerater.DDLWizardPage.access$2(this.page).getSelection());
/*  82 */         section.put("alterTable", DDLGenerater.DDLWizardPage.access$3(this.page).getSelection());
/*  83 */         section.put("comment", DDLGenerater.DDLWizardPage.access$4(this.page).getSelection());
/*  84 */         section.put("encoding", DDLGenerater.DDLWizardPage.access$5(this.page).getText());
/*     */ 
/*  86 */         IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();
/*  87 */         IFile file = wsroot.getFile(path);
/*     */ 
/*  89 */         if (file.exists()) {
/*  90 */           if (!MessageDialog.openConfirm(null, DBPlugin.getResourceString("wizard.generate.ddl.confirm.title"), 
/*  91 */             DBPlugin.getDefault().createMessage("wizard.generate.ddl.confirm.message", 
/*  92 */             new String[] { DDLGenerater.DDLWizardPage.access$0(this.page).getText() }))) {
/*  93 */             return false;
/*     */           }
/*     */         }
/*     */ 
/*  97 */         if (file.exists()) {
/*  98 */           file.setContents(new ByteArrayInputStream(ddl.getBytes(DDLGenerater.DDLWizardPage.access$5(this.page).getText())), 
/*  99 */             true, true, new NullProgressMonitor());
/* 100 */           file.setCharset(DDLGenerater.DDLWizardPage.access$5(this.page).getText(), null);
/*     */         } else {
/* 102 */           file.create(new ByteArrayInputStream(ddl.getBytes(DDLGenerater.DDLWizardPage.access$5(this.page).getText())), 
/* 103 */             true, new NullProgressMonitor());
/* 104 */           file.setCharset(DDLGenerater.DDLWizardPage.access$5(this.page).getText(), null);
/*     */         }
/*     */ 
/* 107 */         file.getParent().refreshLocal(1, new NullProgressMonitor());
/*     */ 
/* 109 */         return true;
/*     */       }
/*     */       catch (Exception ex) {
/* 112 */         DBPlugin.logException(ex);
/* 113 */       }return false;
/*     */     }
/*     */   }
/*     */   private class DDLWizardPage extends FolderSelectWizardPage { private Text filename;
/*     */     private Button comment;
/*     */     private Button drop;
/*     */     private Button alterTable;
/*     */     private Button schema;
/*     */     private Text encoding;
/*     */ 
/* 128 */     public DDLWizardPage(IFile erdFile) { super(DBPlugin.getResourceString("wizard.generate.ddl.title"));
/* 129 */       setDescription(DBPlugin.getResourceString("wizard.generate.ddl.description")); }
/*     */ 
/*     */     public void createControl(Composite parent)
/*     */     {
/* 133 */       super.createControl(parent);
/*     */ 
/* 135 */       IDialogSettings section = getDialogSettings();
/* 136 */       Composite composite = (Composite)getControl();
/*     */ 
/* 138 */       Label label = new Label(composite, 0);
/* 139 */       label.setText(DBPlugin.getResourceString("wizard.generate.ddl.filename"));
/*     */ 
/* 141 */       this.filename = new Text(composite, 2048);
/* 142 */       this.filename.setLayoutData(new GridData(768));
/* 143 */       this.filename.setText(this.erdFile.getName().replaceFirst("\\.erd$", ".ddl"));
/* 144 */       this.filename.addModifyListener(new ModifyListener() {
/*     */         public void modifyText(ModifyEvent e) {
/* 146 */           DDLGenerater.DDLWizardPage.this.doValidate();
/*     */         }
/*     */       });
/* 150 */       new Label(composite, 0);
/*     */ 
/* 152 */       new Label(composite, 0).setText(DBPlugin.getResourceString("wizard.generate.ddl.encoding"));
/* 153 */       this.encoding = new Text(composite, 2048);
/* 154 */       this.encoding.setLayoutData(new GridData(768));
/* 155 */       this.encoding.setText(section.get("encoding"));
/* 156 */       this.encoding.addModifyListener(new ModifyListener() {
/*     */         public void modifyText(ModifyEvent e) {
/* 158 */           DDLGenerater.DDLWizardPage.this.doValidate();
/*     */         }
/*     */       });
/* 162 */       this.schema = new Button(composite, 32);
/* 163 */       this.schema.setText(DBPlugin.getResourceString("wizard.generate.ddl.schema"));
/* 164 */       this.schema.setLayoutData(UIUtils.createGridData(2));
/* 165 */       this.schema.setSelection(section.getBoolean("schema"));
/*     */ 
/* 167 */       this.drop = new Button(composite, 32);
/* 168 */       this.drop.setText(DBPlugin.getResourceString("wizard.generate.ddl.dropTable"));
/* 169 */       this.drop.setLayoutData(UIUtils.createGridData(2));
/* 170 */       this.drop.setSelection(section.getBoolean("drop"));
/*     */ 
/* 172 */       this.alterTable = new Button(composite, 32);
/* 173 */       this.alterTable.setText(DBPlugin.getResourceString("wizard.generate.ddl.alterTable"));
/* 174 */       this.alterTable.setLayoutData(UIUtils.createGridData(2));
/* 175 */       this.alterTable.setSelection(section.getBoolean("alterTable"));
/*     */ 
/* 177 */       this.comment = new Button(composite, 32);
/* 178 */       this.comment.setText(DBPlugin.getResourceString("wizard.generate.ddl.comment"));
/* 179 */       this.comment.setLayoutData(UIUtils.createGridData(2));
/* 180 */       this.comment.setSelection(section.getBoolean("comment"));
/*     */     }
/*     */ 
/*     */     protected void doValidate()
/*     */     {
/* 185 */       super.doValidate();
/* 186 */       if (this.filename.getText().length() == 0) {
/* 187 */         setErrorMessage(DBPlugin.getResourceString("wizard.generate.ddl.error.filename"));
/* 188 */         setPageComplete(false);
/* 189 */         return;
/*     */       }
/* 191 */       if (!DDLGenerater.access$0(this.encoding.getText())) {
/* 192 */         setErrorMessage(DBPlugin.getResourceString("wizard.generate.ddl.error.encoding"));
/* 193 */         setPageComplete(false);
/* 194 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.DDLGenerater
 * JD-Core Version:    0.6.0
 */