/*     */ package org.hi.studio.hsceditor.visual.action;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.eclipse.core.resources.IContainer;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IResource;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.gef.EditDomain;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.GraphicalViewer;
/*     */ import org.eclipse.gef.commands.Command;
/*     */ import org.eclipse.gef.commands.CommandStack;
/*     */ import org.eclipse.jdt.internal.ui.wizards.TypedElementSelectionValidator;
/*     */ import org.eclipse.jdt.internal.ui.wizards.buildpaths.FolderSelectionDialog;
/*     */ import org.eclipse.jface.action.Action;
/*     */ import org.eclipse.jface.viewers.Viewer;
/*     */ import org.eclipse.jface.viewers.ViewerFilter;
/*     */ import org.eclipse.jface.wizard.Wizard;
/*     */ import org.eclipse.jface.wizard.WizardDialog;
/*     */ import org.eclipse.jface.wizard.WizardPage;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.eclipse.ui.IFileEditorInput;
/*     */ import org.eclipse.ui.dialogs.ISelectionStatusValidator;
/*     */ import org.eclipse.ui.model.WorkbenchContentProvider;
/*     */ import org.eclipse.ui.model.WorkbenchLabelProvider;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*     */ import org.hi.studio.hsceditor.visual.editor.VisualDBSerializer;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class ImportFromDiagramAction extends Action
/*     */ {
/*     */   private GraphicalViewer viewer;
/*     */ 
/*     */   public ImportFromDiagramAction(GraphicalViewer viewer)
/*     */   {
/*  54 */     super(DBPlugin.getResourceString("action.importFromDiagram"));
/*  55 */     this.viewer = viewer;
/*     */   }
/*     */ 
/*     */   public void run() {
/*  59 */     IFileEditorInput input = (IFileEditorInput)UIUtils.getActiveEditor().getEditorInput();
/*  60 */     IFile file = input.getFile();
/*  61 */     RootModel root = (RootModel)this.viewer.getContents().getModel();
/*     */ 
/*  63 */     ImportFromDiagramWizard wizard = new ImportFromDiagramWizard(
/*  64 */       root, file, this.viewer.getEditDomain().getCommandStack());
/*  65 */     WizardDialog dialog = new WizardDialog(
/*  66 */       this.viewer.getControl().getShell(), wizard);
/*  67 */     dialog.open();
/*     */   }
/*     */   private static class ImportFromDiagramWizard extends Wizard {
/*     */     private ImportFromDiagramAction.ImportFromDiagramWizardPage page;
/*     */     private RootModel model;
/*     */     private IFile file;
/*     */     private CommandStack stack;
/*     */ 
/*  79 */     public ImportFromDiagramWizard(RootModel model, IFile file, CommandStack stack) { setNeedsProgressMonitor(true);
/*  80 */       setWindowTitle(DBPlugin.getResourceString("wizard.new.import.title"));
/*  81 */       this.model = model;
/*  82 */       this.file = file;
/*  83 */       this.stack = stack; }
/*     */ 
/*     */     public void addPages()
/*     */     {
/*  87 */       this.page = new ImportFromDiagramAction.ImportFromDiagramWizardPage(this.file, this.model);
/*  88 */       addPage(this.page);
/*     */     }
/*     */ 
/*     */     public boolean performFinish() {
/*  92 */       TableModel[] tables = this.page.getSelectedTableModel();
/*  93 */       IFile file = this.page.getSelectedFile();
/*     */ 
/*  95 */       this.stack.execute(new Command(tables, file) {
/*     */         public void execute() {
/*  97 */           for (TableModel table : this.val$tables) {
/*  98 */             TableModel oldTable = ImportFromDiagramAction.ImportFromDiagramWizard.this.model.getTable(table.getTableName());
/*     */ 
/* 100 */             stripConnections(this.val$tables, table.getModelSourceConnections());
/* 101 */             stripConnections(this.val$tables, table.getModelTargetConnections());
/*     */ 
/* 103 */             if (oldTable != null) {
/* 104 */               ImportFromDiagramAction.ImportFromDiagramWizard.this.model.removeChild(oldTable);
/* 105 */               for (AbstractDBConnectionModel conn : oldTable.getModelTargetConnections()) {
/* 106 */                 conn.setTarget(table);
/* 107 */                 table.addTargetConnection(conn);
/*     */               }
/* 109 */               table.setConstraint(oldTable.getConstraint());
/*     */             }
/*     */ 
/* 112 */             table.setLinkedPath(this.val$file.getFullPath().toString());
/* 113 */             ImportFromDiagramAction.ImportFromDiagramWizard.this.model.addChild(table);
/*     */           }
/*     */         }
/*     */ 
/*     */         private void stripConnections(TableModel[] importModels, java.util.List<AbstractDBConnectionModel> conns)
/*     */         {
/* 120 */           for (AbstractDBConnectionModel conn : (AbstractDBConnectionModel[])conns.toArray(new AbstractDBConnectionModel[conns.size()])) {
/* 121 */             conn.getSource().removeSourceConnection(conn);
/* 122 */             conn.getTarget().removeTargetConnection(conn);
/*     */           }
/*     */         }
/*     */ 
/*     */         public boolean canUndo() {
/* 127 */           return false;
/*     */         }
/*     */       });
/* 131 */       return true;
/*     */     }
/*     */   }
/*     */   private static class ImportFromDiagramWizardPage extends WizardPage {
/*     */     private IFile self;
/*     */     private RootModel root;
/*     */     private RootModel selectedRootModel;
/*     */     private Text file;
/*     */     private org.eclipse.swt.widgets.List list;
/*     */ 
/* 145 */     public ImportFromDiagramWizardPage(IFile self, RootModel root) { super();
/* 146 */       setTitle(DBPlugin.getResourceString("wizard.importFromDiagram.title"));
/* 147 */       setMessage(DBPlugin.getResourceString("wizard.importFromDiagram.message"));
/* 148 */       this.self = self;
/* 149 */       this.root = root; }
/*     */ 
/*     */     public void createControl(Composite parent)
/*     */     {
/* 153 */       Composite composite = new Composite(parent, 0);
/* 154 */       composite.setLayout(new GridLayout(3, false));
/* 155 */       composite.setLayoutData(new GridData(1808));
/*     */ 
/* 157 */       UIUtils.createLabel(composite, DBPlugin.getResourceString("wizard.importFromDiagram.erdFile"), false);
/* 158 */       this.file = new Text(composite, 2048);
/* 159 */       this.file.setLayoutData(new GridData(768));
/* 160 */       this.file.setEditable(false);
/*     */ 
/* 162 */       Button browse = new Button(composite, 8);
/* 163 */       browse.setText(DBPlugin.getResourceString("button.browse"));
/* 164 */       browse.addSelectionListener(new SelectionAdapter() {
/*     */         public void widgetSelected(SelectionEvent e) {
/* 166 */           ImportFromDiagramAction.ImportFromDiagramWizardPage.this.selectFile();
/*     */         }
/*     */       });
/* 170 */       UIUtils.createLabel(composite, DBPlugin.getResourceString("wizard.new.import.tables"), false);
/* 171 */       this.list = new org.eclipse.swt.widgets.List(composite, 2562);
/* 172 */       this.list.setLayoutData(new GridData(1808));
/*     */ 
/* 174 */       this.list.addSelectionListener(new SelectionAdapter() {
/*     */         public void widgetSelected(SelectionEvent e) {
/* 176 */           String[] selectedTableNames = ImportFromDiagramAction.ImportFromDiagramWizardPage.this.list.getSelection();
/* 177 */           for (String tableName : selectedTableNames) {
/* 178 */             TableModel table = ImportFromDiagramAction.ImportFromDiagramWizardPage.this.root.getTable(tableName);
/* 179 */             if ((table != null) && (!table.isLinkedTable())) {
/* 180 */               ImportFromDiagramAction.ImportFromDiagramWizardPage.this.setErrorMessage(DBPlugin.getResourceString("wizard.importFromDiagram.error.existTable"));
/* 181 */               ImportFromDiagramAction.ImportFromDiagramWizardPage.this.setPageComplete(false);
/* 182 */               return;
/*     */             }
/* 184 */             ImportFromDiagramAction.ImportFromDiagramWizardPage.this.setErrorMessage(null);
/* 185 */             ImportFromDiagramAction.ImportFromDiagramWizardPage.this.setPageComplete(true);
/*     */           }
/*     */         }
/*     */       });
/* 190 */       setControl(composite);
/*     */     }
/*     */ 
/*     */     private void selectFile() {
/*     */       try {
/* 195 */         IResource init = null;
/* 196 */         if (!this.file.getText().equals("")) {
/* 197 */           init = getSelectedFile();
/*     */         }
/* 199 */         Class[] acceptedClasses = { IFile.class };
/* 200 */         ISelectionStatusValidator validator = new TypedElementSelectionValidator(acceptedClasses, false);
/*     */ 
/* 202 */         IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();
/* 203 */         FolderSelectionDialog dialog = new FolderSelectionDialog(
/* 204 */           getShell(), 
/* 205 */           new WorkbenchLabelProvider(), 
/* 206 */           new WorkbenchContentProvider());
/*     */ 
/* 208 */         ViewerFilter filter = new ViewerFilter()
/*     */         {
/*     */           public boolean select(Viewer viewer, Object parentElement, Object element) {
/* 211 */             if ((element instanceof IContainer)) {
/* 212 */               return true;
/*     */             }
/*     */ 
/* 215 */             return ((element instanceof IFile)) && (!element.equals(ImportFromDiagramAction.ImportFromDiagramWizardPage.this.self)) && 
/* 215 */               (((IFile)element).getName().endsWith(".erd"));
/*     */           }
/*     */         };
/* 219 */         dialog.setTitle(DBPlugin.getResourceString("wizard.generate.browse.title"));
/* 220 */         dialog.setMessage(DBPlugin.getResourceString("wizard.generate.browse.message"));
/* 221 */         dialog.addFilter(filter);
/* 222 */         dialog.setInput(wsroot);
/* 223 */         dialog.setValidator(validator);
/* 224 */         dialog.setInitialSelection(init);
/* 225 */         if (dialog.open() == 0) {
/* 226 */           IFile selectedFile = (IFile)dialog.getFirstResult();
/* 227 */           this.file.setText(selectedFile.getFullPath().toString());
/*     */ 
/* 229 */           this.selectedRootModel = VisualDBSerializer.deserialize(selectedFile.getContents());
/* 230 */           this.list.removeAll();
/* 231 */           for (AbstractDBEntityModel entity : this.selectedRootModel.getChildren()) {
/* 232 */             if ((entity instanceof TableModel))
/* 233 */               this.list.add(((TableModel)entity).getTableName());
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 239 */         DBPlugin.logException(ex);
/*     */       }
/*     */     }
/*     */ 
/*     */     public IFile getSelectedFile() {
/* 244 */       String outputDir = this.file.getText();
/* 245 */       IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();
/* 246 */       return (IFile)wsroot.findMember(outputDir);
/*     */     }
/*     */ 
/*     */     public TableModel[] getSelectedTableModel() {
/* 250 */       if (this.selectedRootModel == null) {
/* 251 */         return new TableModel[0];
/*     */       }
/* 253 */       java.util.List result = new ArrayList();
/* 254 */       for (String tableName : this.list.getSelection()) {
/* 255 */         result.add(this.selectedRootModel.getTable(tableName));
/*     */       }
/* 257 */       return (TableModel[])result.toArray(new TableModel[result.size()]);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.ImportFromDiagramAction
 * JD-Core Version:    0.6.0
 */