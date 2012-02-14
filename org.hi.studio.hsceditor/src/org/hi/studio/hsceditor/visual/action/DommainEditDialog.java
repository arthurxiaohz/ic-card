/*     */ package org.hi.studio.hsceditor.visual.action;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.jface.viewers.ArrayContentProvider;
/*     */ import org.eclipse.jface.viewers.ILabelProviderListener;
/*     */ import org.eclipse.jface.viewers.ISelectionChangedListener;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.jface.viewers.ITableLabelProvider;
/*     */ import org.eclipse.jface.viewers.SelectionChangedEvent;
/*     */ import org.eclipse.jface.viewers.StructuredSelection;
/*     */ import org.eclipse.jface.viewers.TableViewer;
/*     */ import org.eclipse.swt.events.FocusAdapter;
/*     */ import org.eclipse.swt.events.FocusEvent;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Table;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*     */ import org.hi.studio.hsceditor.dialect.IColumnType;
/*     */ import org.hi.studio.hsceditor.dialect.IDialect;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.DommainModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class DommainEditDialog extends Dialog
/*     */ {
/*     */   private TableViewer viewer;
/*     */   private RootModel rootModel;
/*     */   private IDialect dialect;
/*  49 */   private List<DommainModel> result = new ArrayList();
/*  50 */   private DommainModel editingModel = null;
/*     */   private Text dommainName;
/*     */   private Combo columnType;
/*     */   private Text columnSize;
/*     */   private Button removeButton;
/*     */   private Button addButton;
/*     */ 
/*     */   protected DommainEditDialog(Shell parentShell, RootModel rootModel, DommainModel editDommain)
/*     */   {
/*  59 */     super(parentShell);
/*  60 */     setShellStyle(getShellStyle() | 0x10);
/*  61 */     for (DommainModel model : rootModel.getDommains()) {
/*  62 */       DommainModel clonedModel = model.clone();
/*  63 */       if ((editDommain != null) && (model == editDommain)) {
/*  64 */         this.editingModel = clonedModel;
/*     */       }
/*  66 */       this.result.add(clonedModel);
/*     */     }
/*  68 */     this.rootModel = rootModel;
/*  69 */     this.dialect = DialectProvider.getDialect(rootModel.getDialectName());
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize() {
/*  73 */     Point point = super.getInitialSize();
/*  74 */     point.y = 350;
/*  75 */     return point;
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent) {
/*  79 */     getShell().setText(DBPlugin.getResourceString("dialog.dommain.title"));
/*     */ 
/*  81 */     Composite composite = new Composite(parent, 0);
/*  82 */     composite.setLayout(new GridLayout(2, false));
/*  83 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/*  85 */     this.viewer = 
/*  86 */       new TableViewer(composite, 
/*  86 */       68354);
/*  87 */     Table table = this.viewer.getTable();
/*  88 */     table.setLinesVisible(true);
/*  89 */     table.setHeaderVisible(true);
/*  90 */     table.setLayoutData(new GridData(1808));
/*     */ 
/*  92 */     UIUtils.createColumn(table, "dialog.dommain.name", 150, false);
/*  93 */     UIUtils.createColumn(table, "dialog.dommain.type", 150, false);
/*     */ 
/*  95 */     this.viewer.setContentProvider(new ArrayContentProvider());
/*  96 */     this.viewer.setLabelProvider(new ITableLabelProvider() {
/*     */       public Image getColumnImage(Object element, int columnIndex) {
/*  98 */         return null;
/*     */       }
/*     */       public String getColumnText(Object element, int columnIndex) {
/* 101 */         DommainModel model = (DommainModel)element;
/* 102 */         if (columnIndex == 0)
/* 103 */           return model.getName();
/* 104 */         if (columnIndex == 1) {
/* 105 */           String type = model.getType().getName();
/* 106 */           if (model.getType().supportSize()) {
/* 107 */             type = type + "(" + model.getSize() + ")";
/*     */           }
/* 109 */           return type;
/*     */         }
/* 111 */         return null;
/*     */       }
/*     */       public void addListener(ILabelProviderListener listener) {
/*     */       }
/*     */       public void dispose() {
/*     */       }
/*     */       public boolean isLabelProperty(Object element, String property) {
/* 118 */         return false;
/*     */       }
/*     */ 
/*     */       public void removeListener(ILabelProviderListener listener)
/*     */       {
/*     */       }
/*     */     });
/* 124 */     this.viewer.setInput(this.result);
/*     */ 
/* 126 */     Composite buttons = new Composite(composite, 0);
/* 127 */     GridLayout buttonsLayout = new GridLayout(1, false);
/* 128 */     buttonsLayout.horizontalSpacing = 0;
/* 129 */     buttonsLayout.verticalSpacing = 0;
/* 130 */     buttonsLayout.marginHeight = 0;
/* 131 */     buttonsLayout.marginWidth = 2;
/* 132 */     buttons.setLayout(buttonsLayout);
/* 133 */     buttons.setLayoutData(new GridData(2));
/*     */ 
/* 135 */     this.addButton = new Button(buttons, 8);
/* 136 */     this.addButton.setText(DBPlugin.getResourceString("dialog.dommain.addDommain"));
/* 137 */     this.addButton.setLayoutData(new GridData(768));
/* 138 */     this.addButton.addSelectionListener(new SelectionAdapter() {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 140 */         DommainModel dommain = new DommainModel();
/* 141 */         dommain.setName(DBPlugin.getResourceString("dialog.dommain.name"));
/* 142 */         IColumnType defaultType = DommainEditDialog.this.dialect.getDefaultColumnType();
/* 143 */         dommain.setType(defaultType);
/* 144 */         dommain.setSize(defaultType.supportSize() ? "0" : "");
/* 145 */         dommain.setId(DommainEditDialog.this.getDommainId());
/* 146 */         DommainEditDialog.this.result.add(dommain);
/* 147 */         DommainEditDialog.this.viewer.refresh();
/*     */       }
/*     */     });
/* 151 */     this.removeButton = new Button(buttons, 8);
/* 152 */     this.removeButton.setText(DBPlugin.getResourceString("dialog.dommain.removeDommain"));
/* 153 */     this.removeButton.setLayoutData(new GridData(768));
/* 154 */     this.removeButton.addSelectionListener(new SelectionAdapter() {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 156 */         IStructuredSelection sel = (IStructuredSelection)DommainEditDialog.this.viewer.getSelection();
/*     */ 
/* 159 */         List dommains = sel.toList();
/* 160 */         for (DommainModel dommain : dommains) {
/* 161 */           for (AbstractDBEntityModel entity : DommainEditDialog.this.rootModel.getChildren()) {
/* 162 */             if ((entity instanceof TableModel)) {
/* 163 */               TableModel table = (TableModel)entity;
/* 164 */               for (ColumnModel column : table.getColumns()) {
/* 165 */                 if ((column.getDommain() != null) && (dommain.getId().equals(column.getDommain().getId()))) {
/* 166 */                   UIUtils.openAlertDialog("dialog.alert.dommain.delete.error");
/* 167 */                   return;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 174 */         DommainEditDialog.this.result.removeAll(dommains);
/* 175 */         DommainEditDialog.this.viewer.refresh();
/*     */       }
/*     */     });
/* 179 */     Composite editArea = new Composite(composite, 0);
/* 180 */     editArea.setLayout(new GridLayout(4, false));
/* 181 */     editArea.setLayoutData(UIUtils.createGridData(2));
/*     */ 
/* 183 */     new Label(editArea, 0).setText(DBPlugin.getResourceString("dialog.dommain.editDommain.name"));
/* 184 */     this.dommainName = new Text(editArea, 2048);
/* 185 */     this.dommainName.setLayoutData(UIUtils.createGridData(3));
/* 186 */     this.dommainName.addFocusListener(new FocusAdapter() {
/*     */       public void focusLost(FocusEvent e) {
/* 188 */         DommainEditDialog.this.applyToDommainModel();
/*     */       }
/*     */     });
/* 192 */     new Label(editArea, 0).setText(DBPlugin.getResourceString("dialog.dommain.editDommain.type"));
/* 193 */     this.columnType = new Combo(editArea, 8);
/* 194 */     for (int i = 0; i < this.dialect.getColumnTypes().length; i++) {
/* 195 */       IColumnType type = this.dialect.getColumnTypes()[i];
/* 196 */       this.columnType.add(type.toString());
/*     */     }
/* 198 */     this.columnType.addSelectionListener(new SelectionAdapter() {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 200 */         DommainEditDialog.this.applyToDommainModel();
/*     */       }
/*     */     });
/* 203 */     this.columnType.setLayoutData(UIUtils.createGridData(1));
/*     */ 
/* 205 */     new Label(editArea, 0).setText(DBPlugin.getResourceString("dialog.dommain.editDommain.size"));
/* 206 */     this.columnSize = new Text(editArea, 2048);
/* 207 */     this.columnSize.addFocusListener(new FocusAdapter() {
/*     */       public void focusLost(FocusEvent e) {
/* 209 */         DommainEditDialog.this.applyToDommainModel();
/*     */       }
/*     */     });
/* 212 */     GridData gd = new GridData();
/* 213 */     gd.widthHint = 80;
/* 214 */     this.columnSize.setLayoutData(gd);
/*     */ 
/* 216 */     this.viewer.addSelectionChangedListener(new ISelectionChangedListener() {
/*     */       public void selectionChanged(SelectionChangedEvent event) {
/* 218 */         DommainEditDialog.this.updateComponents();
/*     */       }
/*     */     });
/* 221 */     if (this.editingModel != null) {
/* 222 */       this.viewer.setSelection(new StructuredSelection(this.editingModel));
/*     */     }
/*     */ 
/* 225 */     updateComponents();
/* 226 */     return composite;
/*     */   }
/*     */ 
/*     */   private void updateComponents() {
/* 230 */     IStructuredSelection sel = (IStructuredSelection)this.viewer.getSelection();
/* 231 */     this.removeButton.setEnabled(!sel.isEmpty());
/* 232 */     if (sel.isEmpty()) {
/* 233 */       this.editingModel = null;
/* 234 */       this.dommainName.setEnabled(false);
/* 235 */       this.dommainName.setText("");
/* 236 */       this.columnType.setEnabled(false);
/* 237 */       this.columnType.setText("");
/* 238 */       this.columnSize.setEnabled(false);
/* 239 */       this.columnSize.setText("");
/*     */     } else {
/* 241 */       this.editingModel = ((DommainModel)sel.getFirstElement());
/* 242 */       this.dommainName.setEnabled(true);
/* 243 */       this.dommainName.setText(this.editingModel.getName());
/* 244 */       this.columnType.setEnabled(true);
/* 245 */       this.columnType.setText(this.editingModel.getType().toString());
/* 246 */       this.columnSize.setEnabled(this.editingModel.getType().supportSize());
/* 247 */       this.columnSize.setText(this.editingModel.getSize());
/*     */     }
/*     */   }
/*     */ 
/*     */   private void applyToDommainModel() {
/* 252 */     this.editingModel.setName(this.dommainName.getText());
/* 253 */     this.editingModel.setType(this.dialect.getColumnTypes()[this.columnType.getSelectionIndex()]);
/* 254 */     this.editingModel.setSize(this.columnSize.getText());
/* 255 */     this.columnSize.setEnabled(this.editingModel.getType().supportSize());
/* 256 */     this.viewer.refresh();
/*     */   }
/*     */ 
/*     */   private String getDommainId() {
/* 260 */     return String.valueOf(new Date().getTime()) + this.result.size();
/*     */   }
/*     */ 
/*     */   public List<DommainModel> getResult() {
/* 264 */     return this.result;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.DommainEditDialog
 * JD-Core Version:    0.6.0
 */