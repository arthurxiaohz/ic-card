/*     */ package org.hi.studio.hsceditor.visual.generate;
/*     */ 
/*     */ import org.eclipse.core.resources.IContainer;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IResource;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.jdt.internal.ui.wizards.TypedElementSelectionValidator;
/*     */ import org.eclipse.jdt.internal.ui.wizards.buildpaths.FolderSelectionDialog;
/*     */ import org.eclipse.jface.viewers.Viewer;
/*     */ import org.eclipse.jface.viewers.ViewerFilter;
/*     */ import org.eclipse.jface.wizard.WizardPage;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.eclipse.ui.dialogs.ISelectionStatusValidator;
/*     */ import org.eclipse.ui.model.WorkbenchContentProvider;
/*     */ import org.eclipse.ui.model.WorkbenchLabelProvider;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ 
/*     */ public class FolderSelectWizardPage extends WizardPage
/*     */ {
/*     */   private Text txtOutputFolder;
/*     */   protected IFile erdFile;
/*     */ 
/*     */   public FolderSelectWizardPage(IFile erdFile, String pageName)
/*     */   {
/*  40 */     super(pageName);
/*  41 */     setTitle(pageName);
/*  42 */     this.erdFile = erdFile;
/*     */   }
/*     */ 
/*     */   public IResource getOutputFolderResource() {
/*  46 */     String outputDir = this.txtOutputFolder.getText();
/*  47 */     IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();
/*  48 */     return wsroot.findMember(outputDir);
/*     */   }
/*     */ 
/*     */   public void createControl(Composite parent) {
/*  52 */     Composite composite = new Composite(parent, 0);
/*  53 */     composite.setLayout(new GridLayout(3, false));
/*  54 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/*  56 */     Label label = new Label(composite, 0);
/*  57 */     label.setText(DBPlugin.getResourceString("wizard.generate.folder"));
/*  58 */     this.txtOutputFolder = new Text(composite, 2048);
/*  59 */     this.txtOutputFolder.setLayoutData(new GridData(768));
/*  60 */     this.txtOutputFolder.setText(this.erdFile.getParent().getFullPath().toString());
/*  61 */     this.txtOutputFolder.addModifyListener(new ModifyListener() {
/*     */       public void modifyText(ModifyEvent e) {
/*  63 */         FolderSelectWizardPage.this.doValidate();
/*     */       }
/*     */     });
/*  67 */     Button button = new Button(composite, 8);
/*  68 */     button.setText(DBPlugin.getResourceString("button.browse"));
/*  69 */     button.addSelectionListener(new SelectionAdapter() {
/*     */       public void widgetSelected(SelectionEvent e) {
/*  71 */         FolderSelectWizardPage.this.selectFolder();
/*     */       }
/*     */     });
/*  75 */     setControl(composite);
/*     */   }
/*     */ 
/*     */   protected void doValidate() {
/*  79 */     setErrorMessage(null);
/*  80 */     setPageComplete(true);
/*     */   }
/*     */ 
/*     */   private void selectFolder()
/*     */   {
/*     */     try
/*     */     {
/*  90 */       IResource init = null;
/*  91 */       if (!this.txtOutputFolder.getText().equals("")) {
/*  92 */         init = getOutputFolderResource();
/*     */       }
/*  94 */       Class[] acceptedClasses = { IProject.class, IFolder.class };
/*  95 */       ISelectionStatusValidator validator = new TypedElementSelectionValidator(acceptedClasses, false);
/*     */ 
/*  97 */       IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();
/*  98 */       FolderSelectionDialog dialog = new FolderSelectionDialog(
/*  99 */         getShell(), 
/* 100 */         new WorkbenchLabelProvider(), 
/* 101 */         new WorkbenchContentProvider());
/*     */ 
/* 103 */       ViewerFilter filter = new ViewerFilter()
/*     */       {
/*     */         public boolean select(Viewer viewer, Object parentElement, Object element) {
/* 106 */           return element instanceof IContainer;
/*     */         }
/*     */       };
/* 110 */       dialog.setTitle(DBPlugin.getResourceString("wizard.generate.browse.title"));
/* 111 */       dialog.setMessage(DBPlugin.getResourceString("wizard.generate.browse.message"));
/* 112 */       dialog.addFilter(filter);
/* 113 */       dialog.setInput(wsroot);
/* 114 */       dialog.setValidator(validator);
/* 115 */       dialog.setInitialSelection(init);
/* 116 */       if (dialog.open() == 0)
/* 117 */         this.txtOutputFolder.setText(getFolderName(dialog.getFirstResult()));
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 121 */       DBPlugin.logException(ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getFolderName(Object result) throws CoreException {
/* 126 */     if ((result instanceof IContainer)) {
/* 127 */       IContainer folder = (IContainer)result;
/* 128 */       return folder.getFullPath().toString();
/*     */     }
/* 130 */     return "";
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.FolderSelectWizardPage
 * JD-Core Version:    0.6.0
 */