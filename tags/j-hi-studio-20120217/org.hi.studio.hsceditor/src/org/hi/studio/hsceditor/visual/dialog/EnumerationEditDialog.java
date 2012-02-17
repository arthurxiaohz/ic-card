/*     */ package org.hi.studio.hsceditor.visual.dialog;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.jface.viewers.ArrayContentProvider;
/*     */ import org.eclipse.jface.viewers.CellEditor;
/*     */ import org.eclipse.jface.viewers.ICellModifier;
/*     */ import org.eclipse.jface.viewers.ILabelProviderListener;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.jface.viewers.ITableLabelProvider;
/*     */ import org.eclipse.jface.viewers.TableViewer;
/*     */ import org.eclipse.jface.viewers.TextCellEditor;
/*     */ import org.eclipse.swt.events.KeyAdapter;
/*     */ import org.eclipse.swt.events.KeyEvent;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Item;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Table;
/*     */ import org.eclipse.swt.widgets.TableItem;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationValueModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ 
/*     */ public class EnumerationEditDialog extends Dialog
/*     */ {
/*     */   private List<EnumerationValueModel> columns;
/*     */   private TableViewer viewer;
/*     */   private RootModel root;
/*     */   private String enumName;
/*     */   private String enumDesc;
/*     */   private Text enumNameText;
/*     */   private Text enumDescText;
/*  79 */   String[] colNames = { "label", "value", "code" };
/*     */ 
/*     */   public String getEnumName()
/*     */   {
/*  52 */     return this.enumName;
/*     */   }
/*     */ 
/*     */   public void setEnumName(String enumName)
/*     */   {
/*  57 */     this.enumName = StringUtil.upperFirstChar(enumName);
/*     */   }
/*     */ 
/*     */   public String getEnumDesc() {
/*  61 */     return this.enumDesc;
/*     */   }
/*     */ 
/*     */   public void setEnumDesc(String enumDesc) {
/*  65 */     this.enumDesc = enumDesc;
/*     */   }
/*     */ 
/*     */   public List<EnumerationValueModel> getColumns()
/*     */   {
/*  72 */     return this.columns;
/*     */   }
/*     */ 
/*     */   public void setColumns(List<EnumerationValueModel> columns) {
/*  76 */     this.columns = columns;
/*     */   }
/*     */ 
/*     */   public EnumerationEditDialog(Shell parentShell, List<EnumerationValueModel> columns, String enumName, String enumDesc, RootModel root)
/*     */   {
/*  82 */     super(parentShell);
/*  83 */     this.columns = columns;
/*  84 */     this.enumName = enumName;
/*  85 */     this.enumDesc = enumDesc;
/*  86 */     this.root = root;
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize()
/*     */   {
/*  92 */     return new Point(400, 300);
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/*  98 */     Composite rootComp = new Composite(parent, 0);
/*  99 */     rootComp.setLayout(new GridLayout(4, false));
/* 100 */     rootComp.setLayoutData(UIUtils.createGridData(4));
/*     */ 
/* 102 */     Label label = new Label(rootComp, 0);
/* 103 */     label.setText("枚举名：");
/* 104 */     label.setLayoutData(new GridData(128));
/* 105 */     this.enumNameText = new Text(rootComp, 2048);
/* 106 */     this.enumNameText.setText(this.enumName);
/* 107 */     this.enumNameText.setLayoutData(new GridData(768));
/*     */ 
/* 109 */     UIUtils.createLabel(rootComp, "描述：", false);
/* 110 */     this.enumDescText = new Text(rootComp, 2048);
/* 111 */     this.enumDescText.setText(this.enumDesc);
/* 112 */     this.enumDescText.setLayoutData(new GridData(768));
/*     */ 
/* 115 */     Composite btnComp = new Composite(parent, 0);
/* 116 */     btnComp.setLayout(new GridLayout(2, false));
/* 117 */     btnComp.setLayoutData(UIUtils.createGridData(2));
/*     */ 
/* 119 */     Button btnAddColumn = new Button(btnComp, 8);
/* 120 */     btnAddColumn.setText("添加枚举值");
/* 121 */     btnAddColumn.setLayoutData(new GridData(768));
/* 122 */     btnAddColumn.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e)
/*     */       {
/* 129 */         EnumerationValueModel model = new EnumerationValueModel();
/* 130 */         EnumerationEditDialog.this.columns.add(model);
/* 131 */         EnumerationEditDialog.this.viewer.refresh(false);
/*     */ 
/* 133 */         EnumerationEditDialog.this.viewer.editElement(model, 0);
/*     */       }
/*     */     });
/* 138 */     Button btnDeleteColumn = new Button(btnComp, 8);
/* 139 */     btnDeleteColumn.setText("删除枚举值");
/* 140 */     btnDeleteColumn.setLayoutData(new GridData(768));
/* 141 */     btnDeleteColumn.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e)
/*     */       {
/* 146 */         IStructuredSelection selection = (IStructuredSelection)EnumerationEditDialog.this.viewer
/* 147 */           .getSelection();
/* 148 */         EnumerationValueModel model = (EnumerationValueModel)selection.getFirstElement();
/* 149 */         if (model == null) {
/* 150 */           MessageDialog.openConfirm(null, "请选择一行", "请选择一行");
/* 151 */           return;
/*     */         }
/*     */ 
/* 154 */         EnumerationEditDialog.this.columns.remove(model);
/* 155 */         EnumerationEditDialog.this.viewer.refresh(false);
/*     */       }
/*     */     });
/* 161 */     this.viewer = new TableViewer(parent, 65540);
/* 162 */     Table table = this.viewer.getTable();
/* 163 */     table.setLinesVisible(true);
/* 164 */     table.setHeaderVisible(true);
/*     */ 
/* 166 */     this.viewer.setColumnProperties(this.colNames);
/* 167 */     CellEditor[] cellEditors = new CellEditor[4];
/* 168 */     cellEditors[0] = new TextCellEditor(table);
/* 169 */     cellEditors[1] = cellEditors[0];
/* 170 */     cellEditors[2] = cellEditors[0];
/*     */ 
/* 172 */     cellEditors[0].getControl().addKeyListener(new KeyAdapter()
/*     */     {
/*     */       public void keyPressed(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent e)
/*     */       {
/*     */       }
/*     */     });
/* 192 */     this.viewer.setCellEditors(cellEditors);
/*     */ 
/* 194 */     this.viewer.setCellModifier(new ICellModifier() {
/*     */       public boolean canModify(Object element, String property) {
/* 196 */         return true;
/*     */       }
/*     */ 
/*     */       public Object getValue(Object element, String property)
/*     */       {
/* 201 */         int index = -1;
/* 202 */         for (int i = 0; i < EnumerationEditDialog.this.colNames.length; i++) {
/* 203 */           if (EnumerationEditDialog.this.colNames[i].equals(property)) {
/* 204 */             index = i;
/* 205 */             break;
/*     */           }
/*     */         }
/* 208 */         EnumerationValueModel model = (EnumerationValueModel)element;
/* 209 */         switch (index) {
/*     */         case 0:
/* 211 */           return model.getEnumLabel();
/*     */         case 1:
/* 213 */           return model.getEnumValue();
/*     */         case 2:
/* 215 */           return model.getEnumCode();
/*     */         }
/* 217 */         return null;
/*     */       }
/*     */ 
/*     */       public void modify(Object element, String property, Object value) {
/* 221 */         System.out.println("Modify: " + element + ", " + property + 
/* 222 */           ", " + value);
/*     */ 
/* 224 */         int index = -1;
/* 225 */         for (int i = 0; i < EnumerationEditDialog.this.colNames.length; i++) {
/* 226 */           if (EnumerationEditDialog.this.colNames[i].equals(property)) {
/* 227 */             index = i;
/* 228 */             break;
/*     */           }
/*     */         }
/* 231 */         EnumerationValueModel model = null;
/* 232 */         if ((element instanceof Item)) {
/* 233 */           TableItem item = (TableItem)element;
/* 234 */           model = (EnumerationValueModel)item.getData();
/*     */         } else {
/* 236 */           model = (EnumerationValueModel)element;
/*     */         }
/* 238 */         switch (index) {
/*     */         case 0:
/* 240 */           model.setEnumLabel((String)value);
/* 241 */           break;
/*     */         case 1:
/* 243 */           model.setEnumValue((String)value);
/* 244 */           break;
/*     */         case 2:
/* 246 */           model.setEnumCode((String)value);
/*     */         }
/*     */ 
/* 249 */         EnumerationEditDialog.this.viewer.update(model, null);
/*     */       }
/*     */     });
/* 254 */     UIUtils.createColumn(table, "label", 150, false);
/* 255 */     UIUtils.createColumn(table, "value", 150, false);
/* 256 */     UIUtils.createColumn(table, "code", 150, false);
/*     */ 
/* 258 */     this.viewer.getControl().setLayoutData(new GridData(1808));
/* 259 */     this.viewer.setContentProvider(new ArrayContentProvider());
/* 260 */     this.viewer.setLabelProvider(new ITableLabelProvider()
/*     */     {
/*     */       public Image getColumnImage(Object element, int columnIndex) {
/* 263 */         return null;
/*     */       }
/*     */ 
/*     */       public String getColumnText(Object element, int columnIndex) {
/* 267 */         EnumerationValueModel column = (EnumerationValueModel)element;
/* 268 */         if (columnIndex == 0)
/* 269 */           return column.getEnumLabel();
/* 270 */         if (columnIndex == 1)
/* 271 */           return column.getEnumValue();
/* 272 */         if (columnIndex == 2) {
/* 273 */           return column.getEnumCode();
/*     */         }
/* 275 */         return null;
/*     */       }
/*     */ 
/*     */       public void addListener(ILabelProviderListener listener) {
/*     */       }
/*     */ 
/*     */       public void dispose() {
/*     */       }
/*     */ 
/*     */       public boolean isLabelProperty(Object element, String property) {
/* 285 */         return false;
/*     */       }
/*     */ 
/*     */       public void removeListener(ILabelProviderListener listener)
/*     */       {
/*     */       }
/*     */     });
/* 291 */     this.viewer.setInput(this.columns);
/*     */ 
/* 293 */     return rootComp;
/*     */   }
/*     */ 
/*     */   protected void okPressed() {
/* 297 */     setEnumName(this.enumNameText.getText());
/* 298 */     setEnumDesc(this.enumDescText.getText());
/*     */ 
/* 301 */     super.okPressed();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.EnumerationEditDialog
 * JD-Core Version:    0.6.0
 */