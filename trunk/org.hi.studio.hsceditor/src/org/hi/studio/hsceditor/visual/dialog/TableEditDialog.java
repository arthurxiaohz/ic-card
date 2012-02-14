/*      */ package org.hi.studio.hsceditor.visual.dialog;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import org.eclipse.jface.dialogs.Dialog;
/*      */ import org.eclipse.jface.dialogs.MessageDialog;
/*      */ import org.eclipse.swt.events.FocusAdapter;
/*      */ import org.eclipse.swt.events.FocusEvent;
/*      */ import org.eclipse.swt.events.FocusListener;
/*      */ import org.eclipse.swt.events.ModifyEvent;
/*      */ import org.eclipse.swt.events.ModifyListener;
/*      */ import org.eclipse.swt.events.SelectionAdapter;
/*      */ import org.eclipse.swt.events.SelectionEvent;
/*      */ import org.eclipse.swt.events.SelectionListener;
/*      */ import org.eclipse.swt.graphics.Point;
/*      */ import org.eclipse.swt.layout.GridData;
/*      */ import org.eclipse.swt.layout.GridLayout;
/*      */ import org.eclipse.swt.widgets.Button;
/*      */ import org.eclipse.swt.widgets.Combo;
/*      */ import org.eclipse.swt.widgets.Composite;
/*      */ import org.eclipse.swt.widgets.Control;
/*      */ import org.eclipse.swt.widgets.Group;
/*      */ import org.eclipse.swt.widgets.Label;
/*      */ import org.eclipse.swt.widgets.Shell;
/*      */ import org.eclipse.swt.widgets.TabFolder;
/*      */ import org.eclipse.swt.widgets.TabItem;
/*      */ import org.eclipse.swt.widgets.Table;
/*      */ import org.eclipse.swt.widgets.TableItem;
/*      */ import org.eclipse.swt.widgets.Text;
/*      */ import org.hi.metadata.hsc.context.service.Entity;
/*      */ import org.hi.metadata.hsc.context.service.Field;
/*      */ import org.hi.metadata.hsc.context.service.Service;
/*      */ import org.hi.studio.core.constants.HiDataType;
/*      */ import org.hi.studio.core.tree.HiTreeObject;
/*      */ import org.hi.studio.core.tree.HiTreeParent;
/*      */ import org.hi.studio.core.utils.StringUtil;
/*      */ import org.hi.studio.hsceditor.DBPlugin;
/*      */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*      */ import org.hi.studio.hsceditor.dialect.IDialect;
/*      */ import org.hi.studio.hsceditor.dialect.IIndexType;
/*      */ import org.hi.studio.hsceditor.dialect.IndexType;
/*      */ import org.hi.studio.hsceditor.util.FilterUtil;
/*      */ import org.hi.studio.hsceditor.util.UIUtils;
/*      */ import org.hi.studio.hsceditor.util.ValidatorUtil;
/*      */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*      */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*      */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*      */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*      */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*      */ 
/*      */ public class TableEditDialog extends Dialog
/*      */ {
/*      */   private String tableName;
/*      */   private boolean isDeleted;
/*      */   private boolean isCreator;
/*      */   private String tableLogicalName;
/*      */   private String tableDescription;
/*   68 */   private java.util.List<ColumnModel> columnModels = new ArrayList();
/*   69 */   private int editColumnIndex = -1;
/*      */   private Text txtTableName;
/*      */   private Text txtTableLogicalName;
/*      */   private Text txtTableDescription;
/*      */   private Table tblColumns;
/*      */   private Text txtColumnName;
/*      */   private Text txtColumnLogicalName;
/*      */   private Combo cmbColumnType;
/*   80 */   private String[] hiTypes = HiDataType.HI_TYPES;
/*      */   private Text txtColumnSize;
/*      */   private Text txtColumnScale;
/*      */   private Button chkIsPK;
/*      */   private Button chkIsSearch;
/*      */   private Button chkIsListDisplay;
/*      */   private Button chkIsReadOnly;
/*      */   private Button chkIsHidden;
/*      */   private Button chkIsFull;
/*      */   private Button chkIsMainLookup;
/*      */   private Button chkIsParent;
/*      */   private Button deleted;
/*      */   private Button creator;
/*      */   private TableModel tableModel;
/*      */   private Text defaultValue;
/*      */   private Combo hivalidator;
/*      */   private Text txtColumnDescription;
/*      */   private Text lookupText;
/*      */   private Button lookupBtn;
/*      */   private Text txtExtendEntityName;
/*      */   private Text txtExtendServiceName;
/*  119 */   private String extendEntityName = "";
/*  120 */   private String extendServiceName = "";
/*      */   private org.eclipse.swt.widgets.List indexList;
/*      */   private Text indexName;
/*      */   private Combo indexType;
/*      */   private org.eclipse.swt.widgets.List selectedColumns;
/*  128 */   private java.util.List<IndexModel> indexModels = new ArrayList();
/*  129 */   private int editIndexIndex = -1;
/*      */   private RootModel rootModel;
/*      */   private IDialect dialect;
/*  135 */   private FocusListener validateNameListener = new FocusAdapter()
/*      */   {
/*      */     public void focusLost(FocusEvent e) {
/*  138 */       String columnName = TableEditDialog.this.txtColumnName.getText();
/*  139 */       if ((columnName.length() <= 2) && (!columnName.equalsIgnoreCase("id"))) {
/*  140 */         MessageDialog.openWarning(null, "属性名必须大于2个字符", "属性名必须大于2个字符");
/*  141 */         return;
/*      */       }
/*      */ 
/*  144 */       if ((e.widget instanceof Text)) {
/*  145 */         String name = ((Text)e.widget).getText();
/*  146 */         if (FilterUtil.validate(name)) {
/*  147 */           MessageDialog.openWarning(null, "'" + name + "'为系统保留关键字或者非法字符", "'" + name + "'为系统保留关键字或者非法字符");
/*      */ 
/*  149 */           return;
/*      */         }
/*      */       }
/*      */     }
/*  135 */   };
/*      */ 
/*  156 */   private FocusListener updateColumnListener = new FocusAdapter() {
/*      */     public void focusLost(FocusEvent e) {
/*  158 */       TableEditDialog.this.updateColumn();
/*      */     }
/*      */ 
/*      */     public void focusGained(FocusEvent e)
/*      */     {
/*  163 */       String columnName = TableEditDialog.this.txtColumnName.getText();
/*      */ 
/*  165 */       if (StringUtil.startsWith(columnName, "column_"))
/*  166 */         TableEditDialog.this.txtColumnName.setText("");
/*      */     }
/*  156 */   };
/*      */ 
/*  173 */   private SelectionListener updateColumnListener2 = new SelectionAdapter() {
/*      */     public void widgetSelected(SelectionEvent e) {
/*  175 */       TableEditDialog.this.updateColumn();
/*      */     }
/*  173 */   };
/*      */ 
/*  179 */   private SelectionListener updateValidatorListener = new SelectionAdapter() {
/*      */     public void widgetSelected(SelectionEvent e) {
/*  181 */       TableEditDialog.this.hivalidator.setToolTipText(ValidatorUtil.getValidatorDesc(TableEditDialog.this.hivalidator.getText()));
/*  182 */       TableEditDialog.this.updateColumn();
/*      */     }
/*  179 */   };
/*      */   private Button btnDelColumn;
/*      */   private Button btnUpColumn;
/*      */   private Button btnDownColumn;
/*      */   private Button btnAddColumn;
/*      */   private Button addIndex;
/*      */   private Button delIndex;
/*      */   private Button indexUpButton;
/*      */   private Button indexDownButton;
/*      */   private Button indexAddButton;
/*      */   private Button indexRemoveButton;
/*  198 */   private boolean indexEditing = false;
/*      */ 
/*      */   public TableEditDialog(Shell parentShell, RootModel rootModel, String tableName, String tableLogicalName, String tableDescription, ColumnModel[] columns, ColumnModel editColumn, IndexModel[] indices, boolean indexEditing, IndexModel editIndex, String extServiceName, String extEntityName, boolean isDeleted)
/*      */   {
/*  216 */     super(parentShell);
/*  217 */     setShellStyle(getShellStyle() | 0x10);
/*  218 */     this.tableName = tableName;
/*  219 */     this.tableLogicalName = tableLogicalName;
/*  220 */     this.tableDescription = tableDescription;
/*      */ 
/*  222 */     this.extendServiceName = extServiceName;
/*  223 */     this.extendEntityName = extEntityName;
/*      */ 
/*  225 */     this.isDeleted = isDeleted;
/*      */ 
/*  227 */     this.rootModel = rootModel;
/*  228 */     this.dialect = DialectProvider.getDialect(rootModel.getDialectName());
/*      */ 
/*  230 */     for (int i = 0; i < columns.length; i++)
/*      */     {
/*  233 */       this.columnModels.add(columns[i].toNewColumn());
/*  234 */       if ((editColumn != null) && (editColumn == columns[i])) {
/*  235 */         this.editColumnIndex = i;
/*      */       }
/*      */     }
/*  238 */     for (int i = 0; i < indices.length; i++) {
/*  239 */       this.indexModels.add(indices[i]);
/*  240 */       if ((editIndex != null) && (indices[i] == editIndex)) {
/*  241 */         this.editIndexIndex = i;
/*      */       }
/*      */     }
/*      */ 
/*  245 */     this.indexEditing = indexEditing;
/*      */   }
/*      */ 
/*      */   public TableEditDialog(Shell parentShell, RootModel rootModel, AbstractDBEntityModel model, ColumnModel editColumn, boolean indexEditing, IndexModel editIndex) {
/*  249 */     super(parentShell);
/*  250 */     TableModel tableMode = (TableModel)model;
/*      */ 
/*  252 */     this.tableModel = tableMode;
/*      */ 
/*  254 */     setShellStyle(getShellStyle() | 0x10);
/*  255 */     this.tableName = tableMode.getTableName();
/*  256 */     this.tableLogicalName = tableMode.getLogicalName();
/*  257 */     this.tableDescription = tableMode.getDescription();
/*      */ 
/*  259 */     this.extendServiceName = tableMode.getExtendServiceName();
/*  260 */     this.extendEntityName = tableMode.getExtendEntityName();
/*      */ 
/*  262 */     this.isDeleted = tableMode.isDeleted();
/*      */ 
/*  264 */     this.isCreator = tableMode.isCreator();
/*      */ 
/*  266 */     this.rootModel = rootModel;
/*  267 */     this.dialect = DialectProvider.getDialect(rootModel.getDialectName());
/*  268 */     ColumnModel[] columns = tableMode.getColumns();
/*  269 */     for (int i = 0; i < columns.length; i++)
/*      */     {
/*  272 */       this.columnModels.add(columns[i].toNewColumn());
/*  273 */       if ((editColumn != null) && (editColumn == columns[i])) {
/*  274 */         this.editColumnIndex = i;
/*      */       }
/*      */     }
/*      */ 
/*  278 */     IndexModel[] indices = tableMode.getIndices();
/*  279 */     for (int i = 0; i < indices.length; i++) {
/*  280 */       this.indexModels.add(indices[i]);
/*  281 */       if ((editIndex != null) && (indices[i] == editIndex)) {
/*  282 */         this.editIndexIndex = i;
/*      */       }
/*      */     }
/*      */ 
/*  286 */     this.indexEditing = indexEditing;
/*      */   }
/*      */ 
/*      */   protected void constrainShellSize()
/*      */   {
/*  291 */     Shell shell = getShell();
/*  292 */     shell.pack();
/*  293 */     shell.setSize(shell.getSize().x, 450);
/*      */   }
/*      */ 
/*      */   protected Control createDialogArea(Composite parent) {
/*  297 */     getShell().setText(DBPlugin.getResourceString("编辑实体"));
/*      */ 
/*  299 */     TabFolder tabFolder = new TabFolder(parent, 0);
/*  300 */     tabFolder.setLayoutData(new GridData(1808));
/*      */ 
/*  305 */     TabItem tab1 = new TabItem(tabFolder, 0);
/*  306 */     tab1.setText(DBPlugin.getResourceString("实体"));
/*      */ 
/*  308 */     Composite composite1 = new Composite(tabFolder, 0);
/*  309 */     composite1.setLayout(new GridLayout(2, false));
/*  310 */     composite1.setLayoutData(new GridData(1808));
/*  311 */     tab1.setControl(composite1);
/*      */ 
/*  313 */     UIUtils.createLabel(composite1, "editor.table.entity.entityname", true);
/*  314 */     this.txtTableLogicalName = new Text(composite1, 2048);
/*  315 */     this.txtTableLogicalName.setLayoutData(new GridData(768));
/*  316 */     this.txtTableLogicalName.setText(this.tableLogicalName);
/*  317 */     this.txtTableLogicalName.addModifyListener(new ModifyListener() {
/*      */       public void modifyText(ModifyEvent e) {
/*  319 */         TableEditDialog.this.txtTableName.setText(TableEditDialog.this.txtTableLogicalName.getText());
/*      */       }
/*      */     });
/*  323 */     this.txtTableLogicalName.addFocusListener(this.validateNameListener);
/*      */ 
/*  325 */     UIUtils.createLabel(composite1, "editor.table.entity.tablename", true);
/*      */ 
/*  327 */     this.txtTableName = new Text(composite1, 2048);
/*  328 */     this.txtTableName.setLayoutData(new GridData(768));
/*  329 */     this.txtTableName.setText(this.tableName);
/*  330 */     this.txtTableName.addFocusListener(this.validateNameListener);
/*      */ 
/*  332 */     UIUtils.createLabel(composite1, "editor.table.entity.extends", true);
/*      */ 
/*  334 */     Composite extComposite = new Composite(composite1, 0);
/*  335 */     extComposite.setLayout(new GridLayout(5, false));
/*  336 */     extComposite.setLayoutData(new GridData(768));
/*      */ 
/*  338 */     UIUtils.createLabel(extComposite, "editor.table.entity.service", false);
/*  339 */     this.txtExtendServiceName = new Text(extComposite, 2048);
/*  340 */     this.txtExtendServiceName.setLayoutData(new GridData(768));
/*  341 */     this.txtExtendServiceName.setEditable(false);
/*  342 */     if (this.extendServiceName != null) {
/*  343 */       this.txtExtendServiceName.setText(this.extendServiceName);
/*      */     }
/*      */ 
/*  346 */     UIUtils.createLabel(extComposite, "editor.table.entity.entity", false);
/*  347 */     this.txtExtendEntityName = new Text(extComposite, 2048);
/*  348 */     this.txtExtendEntityName.setLayoutData(new GridData(768));
/*  349 */     this.txtExtendEntityName.setEditable(false);
/*  350 */     if (this.extendEntityName != null) {
/*  351 */       this.txtExtendEntityName.setText(this.extendEntityName);
/*      */     }
/*      */ 
/*  354 */     Button btnExtendTable = new Button(extComposite, 8);
/*  355 */     btnExtendTable.setText(DBPlugin.getResourceString("editor.table.entity.extends.button"));
/*  356 */     btnExtendTable.setToolTipText(DBPlugin.getResourceString("editor.table.entity.extends.desc"));
/*      */ 
/*  358 */     btnExtendTable.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  361 */         EntitySelectDialog dialog = new EntitySelectDialog(TableEditDialog.this.getShell(), true);
/*  362 */         if (dialog.open() == 0) {
/*  363 */           Entity entity = (Entity)dialog.getTreeObj().getTreeObj();
/*  364 */           Service service = (Service)dialog.getTreeObj().getParent().getTreeObj();
/*      */ 
/*  366 */           TableEditDialog.this.txtExtendServiceName.setText(service.getServiceName());
/*  367 */           TableEditDialog.this.txtExtendEntityName.setText(entity.getEntityName());
/*      */         }
/*      */       }
/*      */     });
/*  372 */     Label templabel = new Label(composite1, 0);
/*  373 */     templabel.setLayoutData(new GridData(128));
/*  374 */     templabel.setText("");
/*  375 */     Composite extComposite2 = new Composite(composite1, 0);
/*  376 */     extComposite2.setLayout(new GridLayout(5, false));
/*  377 */     extComposite2.setLayoutData(new GridData(768));
/*      */ 
/*  379 */     this.deleted = new Button(extComposite2, 32);
/*  380 */     this.deleted.setText(DBPlugin.getResourceString("editor.table.entity.deleteflag"));
/*  381 */     this.deleted.setSelection(isDeleted());
/*  382 */     this.deleted.setToolTipText(DBPlugin.getResourceString("editor.table.entity.deleteflag.desc"));
/*      */ 
/*  384 */     this.creator = new Button(extComposite2, 32);
/*  385 */     this.creator.setText(DBPlugin.getResourceString("editor.table.entity.creator"));
/*  386 */     this.creator.setSelection(isCreator());
/*  387 */     this.creator.setToolTipText(DBPlugin.getResourceString("editor.table.entity.creator.desc"));
/*      */ 
/*  389 */     UIUtils.createLabel(composite1, "editor.table.entity.desc", true);
/*      */ 
/*  391 */     this.txtTableDescription = new Text(composite1, 2818);
/*  392 */     this.txtTableDescription.setLayoutData(new GridData(1808));
/*  393 */     this.txtTableDescription.setText(this.tableDescription);
/*      */ 
/*  398 */     TabItem tab2 = new TabItem(tabFolder, 0);
/*  399 */     tab2.setText(DBPlugin.getResourceString("属性"));
/*      */ 
/*  401 */     Composite composite2 = new Composite(tabFolder, 0);
/*  402 */     composite2.setLayout(new GridLayout());
/*  403 */     composite2.setLayoutData(new GridData(1808));
/*  404 */     tab2.setControl(composite2);
/*      */ 
/*  406 */     Composite tableArea = new Composite(composite2, 0);
/*  407 */     GridLayout layout = new GridLayout(2, false);
/*  408 */     layout.horizontalSpacing = 0;
/*  409 */     layout.verticalSpacing = 0;
/*  410 */     layout.marginHeight = 0;
/*  411 */     layout.marginWidth = 0;
/*  412 */     tableArea.setLayout(layout);
/*  413 */     tableArea.setLayoutData(new GridData(1808));
/*      */ 
/*  415 */     this.tblColumns = new Table(tableArea, 67588);
/*  416 */     this.tblColumns.setLayoutData(new GridData(1808));
/*  417 */     this.tblColumns.setHeaderVisible(true);
/*      */ 
/*  419 */     UIUtils.createColumn(this.tblColumns, "描述", 150, false);
/*  420 */     UIUtils.createColumn(this.tblColumns, "属性名", 150, false);
/*  421 */     UIUtils.createColumn(this.tblColumns, "类型", 150, false);
/*  422 */     UIUtils.createColumn(this.tblColumns, "主键", 100, false);
/*  423 */     UIUtils.createColumn(this.tblColumns, "非空", 100, false);
/*      */ 
/*  428 */     for (int i = 0; i < this.columnModels.size(); i++) {
/*  429 */       ColumnModel model = (ColumnModel)this.columnModels.get(i);
/*  430 */       TableItem item = new TableItem(this.tblColumns, 0);
/*  431 */       updateTableItem(item, model);
/*      */     }
/*      */ 
/*  434 */     this.tblColumns.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  436 */         TableEditDialog.this.tableSelectionChanged();
/*      */       }
/*      */     });
/*  440 */     Composite buttons = new Composite(tableArea, 0);
/*      */ 
/*  442 */     GridLayout buttonsLayout = new GridLayout(1, false);
/*  443 */     buttonsLayout.horizontalSpacing = 0;
/*  444 */     buttonsLayout.verticalSpacing = 0;
/*  445 */     buttonsLayout.marginHeight = 0;
/*  446 */     buttonsLayout.marginWidth = 2;
/*  447 */     buttons.setLayout(buttonsLayout);
/*  448 */     buttons.setLayoutData(new GridData(2));
/*      */ 
/*  450 */     this.btnAddColumn = new Button(buttons, 8);
/*  451 */     this.btnAddColumn.setToolTipText("新增属性");
/*  452 */     this.btnAddColumn.setText(DBPlugin.getResourceString("新增属性"));
/*  453 */     this.btnAddColumn.setLayoutData(new GridData(768));
/*  454 */     this.btnAddColumn.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  456 */         ColumnModel column = new ColumnModel();
/*  457 */         column.setColumnName("column_" + (TableEditDialog.this.columnModels.size() + 1));
/*      */ 
/*  459 */         column.setLogicalName("column" + (TableEditDialog.this.columnModels.size() + 1));
/*  460 */         column.setDescription("column_" + (TableEditDialog.this.columnModels.size() + 1));
/*  461 */         column.setHiDataType(1);
/*      */ 
/*  464 */         column.setSize("30");
/*  465 */         TableEditDialog.this.columnModels.add(column);
/*      */ 
/*  467 */         TableItem item = new TableItem(TableEditDialog.this.tblColumns, 0);
/*  468 */         TableEditDialog.this.updateTableItem(item, column);
/*      */ 
/*  471 */         TableEditDialog.this.tblColumns.select(TableEditDialog.this.columnModels.size() - 1);
/*  472 */         TableEditDialog.this.tableSelectionChanged();
/*      */ 
/*  475 */         TableEditDialog.this.txtColumnName.setFocus();
/*      */       }
/*      */     });
/*  480 */     this.btnDelColumn = new Button(buttons, 8);
/*  481 */     this.btnDelColumn.setText(DBPlugin.getResourceString("删除属性"));
/*  482 */     this.btnDelColumn.setLayoutData(new GridData(768));
/*  483 */     this.btnDelColumn.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  485 */         ColumnModel model = (ColumnModel)TableEditDialog.this.columnModels.get(TableEditDialog.this.tblColumns.getSelectionIndex());
/*      */ 
/*  487 */         if ((model.isPrimaryKey()) || (model.isParent())) {
/*  488 */           MessageDialog.openWarning(TableEditDialog.this.getShell(), "主键和外键不能被直接删除", "主键和外键不能被直接删除");
/*      */         }
/*      */         else
/*      */         {
/*  493 */           int i = TableEditDialog.this.tblColumns.getSelectionIndex();
/*  494 */           ColumnModel column = (ColumnModel)TableEditDialog.this.columnModels.get(i);
/*      */ 
/*  496 */           if ((column.getHiDataType() == 6) && 
/*  497 */             ("id".equals(column.getLkFieldName())) && 
/*  498 */             (TableEditDialog.this.columnModels.size() != i + 1)) {
/*  499 */             int t = i + 1;
/*  500 */             column = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*  501 */             while ((column.getHiDataType() == 6) && (!
/*  502 */               "id".equals(column.getLkFieldName())))
/*      */             {
/*  504 */               TableEditDialog.this.columnModels.remove(t);
/*  505 */               TableEditDialog.this.tblColumns.remove(t);
/*  506 */               if (TableEditDialog.this.columnModels.size() == t)
/*      */               {
/*      */                 break;
/*      */               }
/*      */ 
/*  512 */               column = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*  518 */           TableEditDialog.this.columnModels.remove(i);
/*  519 */           TableEditDialog.this.tblColumns.remove(i);
/*  520 */           TableEditDialog.this.disableColumnForm();
/*  521 */           TableEditDialog.this.updateButtons();
/*      */         }
/*      */       }
/*      */     });
/*  527 */     this.btnUpColumn = new Button(buttons, 8);
/*  528 */     this.btnUpColumn.setText(DBPlugin.getResourceString("上移"));
/*  529 */     this.btnUpColumn.setLayoutData(new GridData(768));
/*  530 */     this.btnUpColumn.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  532 */         int i = TableEditDialog.this.tblColumns.getSelectionIndex();
/*      */ 
/*  534 */         ColumnModel upcolumn = (ColumnModel)TableEditDialog.this.columnModels.get(i - 1);
/*  535 */         ColumnModel column = (ColumnModel)TableEditDialog.this.columnModels.get(i);
/*  536 */         if ((column.getHiDataType() == 6) && (("id".equals(upcolumn.getLkFieldName())) || 
/*  537 */           ("id".equals(column.getLkFieldName())))) {
/*  538 */           MessageDialog.openError(null, "lookup字段不能够移出当前组", "lookup字段不能够移出当前组");
/*  539 */           return;
/*  540 */         }if ((upcolumn.getHiDataType() == 6) && 
/*  541 */           (column.getHiDataType() != 6))
/*      */         {
/*  543 */           int t = i;
/*  544 */           while (upcolumn.getHiDataType() == 6) {
/*  545 */             t--;
/*  546 */             if (t < 0) break;
/*  547 */             upcolumn = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */           }
/*      */ 
/*  553 */           TableEditDialog.this.columnModels.remove(i);
/*  554 */           TableEditDialog.this.columnModels.add(t + 1, column);
/*      */         }
/*      */         else
/*      */         {
/*  558 */           TableEditDialog.this.columnModels.remove(i);
/*  559 */           TableEditDialog.this.columnModels.add(i - 1, column);
/*      */         }
/*      */ 
/*  565 */         TableEditDialog.this.tblColumns.removeAll();
/*  566 */         for (int j = 0; j < TableEditDialog.this.columnModels.size(); j++) {
/*  567 */           ColumnModel model = (ColumnModel)TableEditDialog.this.columnModels.get(j);
/*  568 */           TableItem item = new TableItem(TableEditDialog.this.tblColumns, 0);
/*  569 */           TableEditDialog.this.updateTableItem(item, model);
/*      */         }
/*  571 */         TableEditDialog.this.tblColumns.setSelection(i - 1);
/*      */ 
/*  573 */         TableEditDialog.this.editColumnIndex -= 1;
/*      */ 
/*  575 */         TableEditDialog.this.updateButtons();
/*      */       }
/*      */     });
/*  579 */     this.btnDownColumn = new Button(buttons, 8);
/*  580 */     this.btnDownColumn.setText(DBPlugin.getResourceString("下移"));
/*  581 */     this.btnDownColumn.setLayoutData(new GridData(768));
/*  582 */     this.btnDownColumn.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  584 */         int i = TableEditDialog.this.tblColumns.getSelectionIndex();
/*      */ 
/*  587 */         ColumnModel downcolumn = (ColumnModel)TableEditDialog.this.columnModels.get(i + 1);
/*  588 */         ColumnModel column = (ColumnModel)TableEditDialog.this.columnModels.get(i);
/*  589 */         if ((column.getHiDataType() == 6) && (("id".equals(column.getLkFieldName())) || 
/*  590 */           (downcolumn.getHiDataType() != 6) || 
/*  591 */           ("id".equals(downcolumn.getLkFieldName())))) {
/*  592 */           MessageDialog.openError(null, "lookup字段不能够移出当前组", "lookup字段不能够移出当前组");
/*  593 */           return;
/*  594 */         }if ((downcolumn.getHiDataType() == 6) && 
/*  595 */           (column.getHiDataType() != 6))
/*      */         {
/*  597 */           int t = i;
/*  598 */           while (downcolumn.getHiDataType() == 6) {
/*  599 */             t++;
/*  600 */             if (TableEditDialog.this.columnModels.size() == t)
/*      */             {
/*      */               break;
/*      */             }
/*  604 */             downcolumn = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */           }
/*      */ 
/*  607 */           TableEditDialog.this.columnModels.remove(i);
/*  608 */           TableEditDialog.this.columnModels.add(t - 1, column);
/*      */         }
/*      */         else
/*      */         {
/*  612 */           TableEditDialog.this.columnModels.remove(i);
/*  613 */           TableEditDialog.this.columnModels.add(i + 1, column);
/*      */         }
/*      */ 
/*  619 */         TableEditDialog.this.tblColumns.removeAll();
/*  620 */         for (int j = 0; j < TableEditDialog.this.columnModels.size(); j++) {
/*  621 */           ColumnModel model = (ColumnModel)TableEditDialog.this.columnModels.get(j);
/*  622 */           TableItem item = new TableItem(TableEditDialog.this.tblColumns, 0);
/*  623 */           TableEditDialog.this.updateTableItem(item, model);
/*      */         }
/*  625 */         TableEditDialog.this.tblColumns.setSelection(i + 1);
/*  626 */         TableEditDialog.this.editColumnIndex += 1;
/*  627 */         TableEditDialog.this.updateButtons();
/*      */       }
/*      */     });
/*  632 */     Group group = new Group(composite2, 0);
/*  633 */     group.setText(DBPlugin.getResourceString("编辑属性"));
/*  634 */     group.setLayoutData(new GridData(768));
/*  635 */     group.setLayout(new GridLayout(6, false));
/*      */ 
/*  637 */     UIUtils.createLabel(group, "editor.table.attribute.attrname", true);
/*  638 */     this.txtColumnName = new Text(group, 2048);
/*  639 */     this.txtColumnName.setLayoutData(new GridData(768));
/*  640 */     this.txtColumnName.addFocusListener(this.updateColumnListener);
/*  641 */     this.txtColumnName.addFocusListener(this.validateNameListener);
/*      */ 
/*  643 */     UIUtils.createLabel(group, "editor.table.attribute.type", true);
/*  644 */     this.cmbColumnType = new Combo(group, 16777308);
/*  645 */     this.cmbColumnType.setLayoutData(new GridData(768));
/*      */ 
/*  647 */     this.cmbColumnType.setItems(this.hiTypes);
/*  648 */     this.cmbColumnType.setVisibleItemCount(this.hiTypes.length);
/*      */ 
/*  660 */     this.cmbColumnType.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  663 */         TableEditDialog.this.enableCheckForm();
/*  664 */         TableEditDialog.this.txtColumnSize.setText("");
/*  665 */         TableEditDialog.this.txtColumnScale.setText("");
/*  666 */         TableEditDialog.this.txtColumnSize.setEditable(false);
/*  667 */         TableEditDialog.this.txtColumnScale.setEditable(false);
/*  668 */         TableEditDialog.this.lookupBtn.setEnabled(false);
/*      */ 
/*  671 */         TableEditDialog.this.chkIsListDisplay.setSelection(true);
/*  672 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 9) {
/*  673 */           TableEditDialog.this.chkIsListDisplay.setSelection(false);
/*      */         }
/*      */ 
/*  676 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 1)
/*      */         {
/*  678 */           TableEditDialog.this.txtColumnSize.setEditable(true);
/*  679 */           TableEditDialog.this.txtColumnSize.setText("30");
/*      */         }
/*  681 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 3)
/*      */         {
/*  683 */           TableEditDialog.this.txtColumnSize.setEditable(true);
/*  684 */           TableEditDialog.this.txtColumnScale.setEditable(true);
/*      */ 
/*  686 */           TableEditDialog.this.txtColumnSize.setText("18");
/*  687 */           TableEditDialog.this.txtColumnScale.setText("2");
/*      */         }
/*      */ 
/*  690 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 6)
/*      */         {
/*  692 */           TableEditDialog.this.lookupBtn.setText("选择带回项");
/*  693 */           TableEditDialog.this.lookupBtn.setEnabled(true);
/*  694 */           TableEditDialog.this.defaultValue.setEditable(false);
/*      */         }
/*  696 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 7)
/*      */         {
/*  698 */           TableEditDialog.this.lookupBtn.setText("选择枚举项");
/*  699 */           TableEditDialog.this.lookupBtn.setEnabled(true);
/*      */         }
/*      */ 
/*  702 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 9)
/*      */         {
/*  704 */           TableEditDialog.this.disableCheckForm();
/*      */         }
/*      */ 
/*  709 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 3) {
/*  710 */           TableEditDialog.this.hivalidator.setText("float");
/*      */         }
/*  712 */         if (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 2) {
/*  713 */           TableEditDialog.this.hivalidator.setText("integer");
/*      */         }
/*  715 */         if ((TableEditDialog.this.cmbColumnType.getSelectionIndex() == 8) || 
/*  716 */           (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 9) || 
/*  717 */           (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 7) || 
/*  718 */           (TableEditDialog.this.cmbColumnType.getSelectionIndex() == 6))
/*      */         {
/*  720 */           TableEditDialog.this.hivalidator.setText("");
/*  721 */           TableEditDialog.this.hivalidator.setEnabled(false);
/*      */         }
/*      */       }
/*      */     });
/*  728 */     this.cmbColumnType.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  735 */     Label label = new Label(group, 0);
/*  736 */     label.setText(DBPlugin.getResourceString("editor.table.attribute.default"));
/*  737 */     label.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.default.desc"));
/*  738 */     label.setLayoutData(new GridData(128));
/*  739 */     this.defaultValue = new Text(group, 2048);
/*  740 */     this.defaultValue.setLayoutData(new GridData(768));
/*  741 */     this.defaultValue.addFocusListener(this.updateColumnListener);
/*      */ 
/*  743 */     UIUtils.createLabel(group, "editor.table.attribute.desc", true);
/*  744 */     this.txtColumnDescription = new Text(group, 2048);
/*  745 */     this.txtColumnDescription.setLayoutData(new GridData(768));
/*  746 */     this.txtColumnDescription.addFocusListener(this.updateColumnListener);
/*      */ 
/*  748 */     Label vlabel = new Label(group, 0);
/*  749 */     vlabel.setText(DBPlugin.getResourceString("editor.table.attribute.check"));
/*  750 */     vlabel.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.check.desc"));
/*  751 */     vlabel.setLayoutData(new GridData(128));
/*      */ 
/*  753 */     this.hivalidator = new Combo(group, 16777308);
/*  754 */     this.hivalidator.setLayoutData(new GridData(768));
/*  755 */     this.hivalidator.setItems((String[])ValidatorUtil.getValidatorList().toArray(new String[ValidatorUtil.getValidatorList().size()]));
/*  756 */     this.hivalidator.setVisibleItemCount(10);
/*  757 */     this.hivalidator.addSelectionListener(this.updateValidatorListener);
/*      */ 
/*  765 */     Label labelL = new Label(group, 0);
/*  766 */     labelL.setText(DBPlugin.getResourceString("editor.table.attribute.length"));
/*  767 */     labelL.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.length.desc"));
/*  768 */     labelL.setLayoutData(new GridData(128));
/*  769 */     this.txtColumnSize = new Text(group, 2048);
/*  770 */     this.txtColumnSize.setLayoutData(new GridData(768));
/*  771 */     this.txtColumnSize.addFocusListener(this.updateColumnListener);
/*      */ 
/*  773 */     UIUtils.createLabel(group, "editor.table.attribute.precision", true);
/*  774 */     this.txtColumnScale = new Text(group, 2048);
/*  775 */     this.txtColumnScale.setLayoutData(new GridData(768));
/*  776 */     this.txtColumnScale.addFocusListener(this.updateColumnListener);
/*      */ 
/*  780 */     UIUtils.createLabel(group, "带回项：", false);
/*  781 */     this.lookupText = new Text(group, 2048);
/*  782 */     this.lookupText.setLayoutData(new GridData(768));
/*  783 */     this.lookupText.addFocusListener(this.updateColumnListener);
/*  784 */     this.lookupText.setEditable(false);
/*      */ 
/*  786 */     this.lookupBtn = new Button(group, 8);
/*      */ 
/*  788 */     this.lookupBtn.setText(DBPlugin.getResourceString("选择带回项"));
/*  789 */     this.lookupBtn.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  792 */         ColumnModel columnModel = (ColumnModel)TableEditDialog.this.columnModels.get(TableEditDialog.this.editColumnIndex);
/*      */ 
/*  794 */         boolean isEnumeration = true;
/*  795 */         if ((columnModel.getHiDataType() == 6) || 
/*  796 */           (columnModel.getHiDataType() == 8)) {
/*  797 */           isEnumeration = false;
/*      */         }
/*      */ 
/*  800 */         ServiceSelectDialog dialog = new ServiceSelectDialog(TableEditDialog.this.getShell(), isEnumeration);
/*  801 */         if (dialog.open() == 0) {
/*  802 */           java.util.List treeObjs = dialog.getTreeObjects();
/*      */ 
/*  804 */           if (isEnumeration) {
/*  805 */             if (treeObjs.size() > 0)
/*      */             {
/*  807 */               HiTreeObject treeObj = (HiTreeObject)treeObjs.get(0);
/*      */ 
/*  809 */               String entityName = ((Entity)treeObj.getTreeObj()).getEntityName();
/*  810 */               columnModel.setLkEntityName(entityName);
/*      */ 
/*  813 */               TableEditDialog.this.tableSelectionChanged();
/*      */             }
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  819 */             ColumnModel newColumnModel = new ColumnModel();
/*      */ 
/*  822 */             newColumnModel.setMainLookup(true);
/*      */ 
/*  824 */             String entityName = "";
/*  825 */             String serviceName = "";
/*  826 */             for (Iterator it = treeObjs.iterator(); it.hasNext(); )
/*      */             {
/*  828 */               HiTreeObject treeObj = (HiTreeObject)it.next();
/*  829 */               Field field = (Field)treeObj.getTreeObj();
/*      */ 
/*  831 */               newColumnModel.setColumnName(field.getFieldName());
/*  832 */               newColumnModel.setLogicalName(field.getFieldName());
/*  833 */               newColumnModel.setDescription(field.getFieldLabel());
/*      */ 
/*  837 */               newColumnModel.setHiDataType(6);
/*      */ 
/*  839 */               newColumnModel.setHidden(field.isIsHidden());
/*  840 */               newColumnModel.setListDisplay(field.isIsListDisplay());
/*      */ 
/*  842 */               entityName = ((Entity)treeObj.getParent().getTreeObj()).getEntityName();
/*  843 */               newColumnModel.setLkEntityName(entityName);
/*  844 */               newColumnModel.setLkFieldName(field.getFieldName());
/*  845 */               serviceName = ((Service)treeObj.getParent().getParent().getTreeObj()).getServiceName();
/*  846 */               newColumnModel.setLkServiceName(serviceName);
/*      */ 
/*  848 */               newColumnModel.setReadOnly(field.isIsReadOnly());
/*  849 */               newColumnModel.setSearch(field.isIsSearch());
/*  850 */               newColumnModel.setSize(String.valueOf(field.getLength()));
/*      */ 
/*  853 */               if ((!columnModel.getLkServiceName().equals("")) && (!columnModel.getLkEntityName().equals("")) && (
/*  854 */                 (!columnModel.getLkServiceName().equals(serviceName)) || (!columnModel.getLkEntityName().equals(entityName)))) {
/*  855 */                 MessageDialog.openError(null, "lookup错误", "lookup编辑时只能查找带回相同服务相同实体！");
/*  856 */                 return;
/*      */               }
/*      */ 
/*  861 */               TableEditDialog.this.columnModels.add(TableEditDialog.this.editColumnIndex + 1, newColumnModel);
/*  862 */               TableItem item = new TableItem(TableEditDialog.this.tblColumns, 0, TableEditDialog.this.editColumnIndex + 1);
/*      */ 
/*  864 */               TableEditDialog.this.updateTableItem(item, newColumnModel);
/*      */ 
/*  867 */               newColumnModel = new ColumnModel();
/*      */             }
/*      */ 
/*  874 */             columnModel.setFull(false);
/*      */ 
/*  876 */             columnModel.setHiDataType(6);
/*  877 */             columnModel.setListDisplay(false);
/*      */ 
/*  879 */             columnModel.setHidden(true);
/*      */ 
/*  881 */             columnModel.setLkEntityName(entityName);
/*  882 */             columnModel.setLkFieldName("id");
/*  883 */             columnModel.setLkServiceName(serviceName);
/*  884 */             columnModel.setReadOnly(true);
/*  885 */             columnModel.setLkForeignKey(true);
/*      */ 
/*  887 */             TableItem item = TableEditDialog.this.tblColumns.getItem(TableEditDialog.this.editColumnIndex);
/*  888 */             TableEditDialog.this.updateTableItem(item, columnModel);
/*  889 */             TableEditDialog.this.tableSelectionChanged();
/*      */           }
/*      */         }
/*      */       }
/*      */     });
/*  896 */     Composite checks = new Composite(group, 0);
/*  897 */     checks.setLayout(new GridLayout(5, false));
/*  898 */     checks.setLayoutData(UIUtils.createGridData(6));
/*      */ 
/*  900 */     this.chkIsPK = new Button(checks, 32);
/*  901 */     this.chkIsPK.setText("主键");
/*  902 */     this.chkIsPK.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  904 */     this.chkIsSearch = new Button(checks, 32);
/*  905 */     this.chkIsSearch.setText(DBPlugin.getResourceString("editor.table.attribute.search"));
/*  906 */     this.chkIsSearch.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.search.desc"));
/*  907 */     this.chkIsSearch.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e)
/*      */       {
/*  911 */         TableEditDialog.this.chkIsHidden.setSelection(false);
/*      */       }
/*      */     });
/*  915 */     this.chkIsSearch.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  917 */     this.chkIsListDisplay = new Button(checks, 32);
/*  918 */     this.chkIsListDisplay.setText(DBPlugin.getResourceString("editor.table.attribute.list"));
/*  919 */     this.chkIsListDisplay.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.list.desc"));
/*  920 */     this.chkIsListDisplay.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e)
/*      */       {
/*  924 */         TableEditDialog.this.chkIsHidden.setSelection(false);
/*      */       }
/*      */     });
/*  930 */     this.chkIsListDisplay.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  932 */     this.chkIsReadOnly = new Button(checks, 32);
/*  933 */     this.chkIsReadOnly.setText(DBPlugin.getResourceString("editor.table.attribute.readyonly"));
/*  934 */     this.chkIsReadOnly.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.readyonly.desc"));
/*  935 */     this.chkIsReadOnly.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  938 */         TableEditDialog.this.chkIsFull.setSelection(false);
/*      */       }
/*      */     });
/*  942 */     this.chkIsReadOnly.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  944 */     this.chkIsHidden = new Button(checks, 32);
/*  945 */     this.chkIsHidden.setText(DBPlugin.getResourceString("editor.table.attribute.hide"));
/*  946 */     this.chkIsHidden.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.hide.desc"));
/*  947 */     this.chkIsHidden.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  950 */         TableEditDialog.this.chkIsSearch.setSelection(false);
/*  951 */         TableEditDialog.this.chkIsListDisplay.setSelection(false);
/*      */       }
/*      */     });
/*  955 */     this.chkIsHidden.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  957 */     this.chkIsFull = new Button(checks, 32);
/*  958 */     this.chkIsFull.setText(DBPlugin.getResourceString("editor.table.attribute.required"));
/*  959 */     this.chkIsFull.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.required.desc"));
/*  960 */     this.chkIsFull.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e) {
/*  963 */         TableEditDialog.this.chkIsReadOnly.setSelection(false);
/*      */       }
/*      */     });
/*  967 */     this.chkIsFull.addSelectionListener(this.updateColumnListener2);
/*      */ 
/*  969 */     this.chkIsMainLookup = new Button(checks, 32);
/*  970 */     this.chkIsMainLookup.setText(DBPlugin.getResourceString("editor.table.attribute.mainlookup"));
/*  971 */     this.chkIsMainLookup.setToolTipText(DBPlugin.getResourceString("editor.table.attribute.mainlookup.desc"));
/*  972 */     this.chkIsMainLookup.addSelectionListener(new SelectionAdapter()
/*      */     {
/*      */       public void widgetSelected(SelectionEvent e)
/*      */       {
/*  976 */         if (TableEditDialog.this.chkIsMainLookup.getSelection()) {
/*  977 */           int i = TableEditDialog.this.tblColumns.getSelectionIndex();
/*  978 */           int t = i - 1;
/*  979 */           ColumnModel column = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */ 
/*  981 */           while ((column.getHiDataType() == 6) && (!
/*  982 */             "id".equals(column.getLkFieldName()))) {
/*  983 */             column.setMainLookup(false);
/*  984 */             t--;
/*  985 */             column = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */           }
/*      */ 
/*  988 */           t = i;
/*  989 */           column = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */ 
/*  991 */           while (column.getHiDataType() == 6) {
/*  992 */             column.setMainLookup(false);
/*  993 */             t++;
/*  994 */             if ((t >= TableEditDialog.this.columnModels.size()) || 
/*  995 */               ("id".equals(column.getLkFieldName()))) break;
/*  996 */             column = (ColumnModel)TableEditDialog.this.columnModels.get(t);
/*      */           }
/*      */         }
/*      */       }
/*      */     });
/* 1005 */     this.chkIsMainLookup.addSelectionListener(this.updateColumnListener2);
/*      */ 
/* 1007 */     this.chkIsParent = new Button(checks, 32);
/* 1008 */     this.chkIsParent.setText("外键");
/* 1009 */     this.chkIsParent.setEnabled(false);
/*      */ 
/* 1012 */     if (this.columnModels.size() == 1)
/*      */     {
/* 1014 */       tabFolder.setSelection(tab1);
/*      */     }
/* 1016 */     else tabFolder.setSelection(tab2);
/*      */ 
/* 1019 */     if (this.editColumnIndex >= 0) {
/* 1020 */       this.tblColumns.select(this.editColumnIndex);
/* 1021 */       tableSelectionChanged();
/*      */     } else {
/* 1023 */       this.tblColumns.select(this.columnModels.size() - 1);
/* 1024 */       tableSelectionChanged();
/*      */     }
/*      */ 
/* 1028 */     updateButtons();
/*      */ 
/* 1036 */     Composite composite3 = new Composite(tabFolder, 0);
/* 1037 */     composite3.setLayout(new GridLayout(2, false));
/* 1038 */     composite3.setLayoutData(new GridData(1808));
/*      */ 
/* 1041 */     Composite indexArea = new Composite(composite3, 0);
/* 1042 */     indexArea.setLayout(layout);
/* 1043 */     indexArea.setLayoutData(UIUtils.createGridData(2, 1808));
/*      */ 
/* 1045 */     this.indexList = new org.eclipse.swt.widgets.List(indexArea, 2816);
/* 1046 */     this.indexList.setLayoutData(new GridData(1808));
/* 1047 */     for (IndexModel index : this.indexModels) {
/* 1048 */       this.indexList.add(index.toString());
/*      */     }
/* 1050 */     this.indexList.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1052 */         TableEditDialog.this.indexSelectionChanged();
/*      */       }
/*      */     });
/* 1056 */     Composite indexButtons = new Composite(indexArea, 0);
/* 1057 */     indexButtons.setLayout(buttonsLayout);
/* 1058 */     indexButtons.setLayoutData(new GridData(2));
/*      */ 
/* 1060 */     this.addIndex = new Button(indexButtons, 8);
/* 1061 */     this.addIndex.setText(DBPlugin.getResourceString("dialog.table.addIndex"));
/* 1062 */     this.addIndex.setLayoutData(new GridData(768));
/* 1063 */     this.addIndex.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent selectionevent) {
/* 1065 */         IndexModel indexModel = new IndexModel();
/* 1066 */         indexModel.setIndexType(new IndexType("UNIQUE"));
/* 1067 */         indexModel.setIndexName("IDX_" + TableEditDialog.this.txtTableName.getText() + "_" + (TableEditDialog.this.indexModels.size() + 1));
/* 1068 */         TableEditDialog.this.indexModels.add(indexModel);
/* 1069 */         TableEditDialog.this.indexList.add(indexModel.toString());
/*      */       }
/*      */     });
/* 1073 */     this.delIndex = new Button(indexButtons, 8);
/* 1074 */     this.delIndex.setText(DBPlugin.getResourceString("dialog.table.removeIndex"));
/* 1075 */     this.delIndex.setLayoutData(new GridData(768));
/* 1076 */     this.delIndex.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent selectionevent) {
/* 1078 */         int index = TableEditDialog.this.indexList.getSelectionIndex();
/* 1079 */         TableEditDialog.this.indexList.remove(index);
/* 1080 */         TableEditDialog.this.indexModels.remove(index);
/* 1081 */         TableEditDialog.this.disableIndexForm();
/*      */       }
/*      */     });
/* 1085 */     new Label(composite3, 0).setText(DBPlugin.getResourceString("dialog.table.editIndex.indexName"));
/* 1086 */     this.indexName = new Text(composite3, 2048);
/* 1087 */     this.indexName.setLayoutData(new GridData(768));
/* 1088 */     this.indexName.addFocusListener(new FocusAdapter() {
/*      */       public void focusLost(FocusEvent e) {
/* 1090 */         IndexModel model = (IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex);
/* 1091 */         model.setIndexName(TableEditDialog.this.indexName.getText());
/* 1092 */         TableEditDialog.this.indexList.setItem(TableEditDialog.this.editIndexIndex, model.toString());
/*      */       }
/*      */     });
/* 1096 */     new Label(composite3, 0).setText(DBPlugin.getResourceString("dialog.table.editIndex.indexType"));
/* 1097 */     this.indexType = new Combo(composite3, 8);
/*      */ 
/* 1102 */     this.indexType.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1104 */         IndexModel model = (IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex);
/* 1105 */         model.setIndexType(TableEditDialog.this.dialect.getIndexType(TableEditDialog.this.indexType.getText()));
/* 1106 */         TableEditDialog.this.indexList.setItem(TableEditDialog.this.editIndexIndex, model.toString());
/*      */       }
/*      */     });
/* 1110 */     Group indexColumn = new Group(composite3, 0);
/* 1111 */     indexColumn.setText(DBPlugin.getResourceString("dialog.table.editIndex.indexColumns"));
/* 1112 */     indexColumn.setLayout(new GridLayout(2, false));
/* 1113 */     indexColumn.setLayoutData(UIUtils.createGridData(3));
/*      */ 
/* 1115 */     this.selectedColumns = new org.eclipse.swt.widgets.List(indexColumn, 2816);
/* 1116 */     this.selectedColumns.setLayoutData(UIUtils.createGridDataWithColspan(1, 80));
/* 1117 */     this.selectedColumns.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1119 */         TableEditDialog.this.updateIndexColumnButtons();
/*      */       }
/*      */     });
/* 1123 */     Composite indexColumnButtons = new Composite(indexColumn, 0);
/* 1124 */     indexColumnButtons.setLayout(buttonsLayout);
/* 1125 */     indexColumnButtons.setLayoutData(new GridData(2));
/*      */ 
/* 1127 */     this.indexAddButton = new Button(indexColumnButtons, 8);
/* 1128 */     this.indexAddButton.setLayoutData(new GridData(768));
/* 1129 */     this.indexAddButton.setText(DBPlugin.getResourceString("dialog.table.addColumn"));
/* 1130 */     this.indexAddButton.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1132 */         ColumnSelectDialog dialog = new ColumnSelectDialog(TableEditDialog.this.getShell(), TableEditDialog.this.columnModels);
/* 1133 */         if ((dialog.open() == 0) && 
/* 1134 */           (dialog.getSelectedColumn() != null)) {
/* 1135 */           String columnName = dialog.getSelectedColumn().getColumnName();
/* 1136 */           IndexModel model = (IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex);
/* 1137 */           model.getColumns().add(columnName);
/* 1138 */           TableEditDialog.this.selectedColumns.add(columnName);
/*      */ 
/* 1140 */           TableEditDialog.this.indexList.setItem(TableEditDialog.this.editIndexIndex, model.toString());
/*      */ 
/* 1142 */           TableEditDialog.this.updateIndexColumnButtons();
/*      */         }
/*      */       }
/*      */     });
/* 1148 */     this.indexRemoveButton = new Button(indexColumnButtons, 8);
/* 1149 */     this.indexRemoveButton.setLayoutData(new GridData(768));
/* 1150 */     this.indexRemoveButton.setText(DBPlugin.getResourceString("dialog.table.removeColumn"));
/* 1151 */     this.indexRemoveButton.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1153 */         int index = TableEditDialog.this.selectedColumns.getSelectionIndex();
/* 1154 */         if (index > 0) {
/* 1155 */           IndexModel model = (IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex);
/* 1156 */           model.getColumns().remove(index);
/* 1157 */           TableEditDialog.this.selectedColumns.remove(index);
/*      */ 
/* 1159 */           TableEditDialog.this.updateIndexColumnButtons();
/*      */         }
/*      */       }
/*      */     });
/* 1164 */     this.indexUpButton = new Button(indexColumnButtons, 8);
/* 1165 */     this.indexUpButton.setText(DBPlugin.getResourceString("dialog.table.upColumn"));
/* 1166 */     this.indexUpButton.setLayoutData(new GridData(768));
/* 1167 */     this.indexUpButton.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1169 */         int index = TableEditDialog.this.selectedColumns.getSelectionIndex();
/* 1170 */         if (index > 0) {
/* 1171 */           IndexModel model = (IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex);
/* 1172 */           String columnName = (String)model.getColumns().get(index);
/*      */ 
/* 1174 */           model.getColumns().remove(index);
/* 1175 */           model.getColumns().add(index - 1, columnName);
/*      */ 
/* 1177 */           TableEditDialog.this.selectedColumns.remove(index);
/* 1178 */           TableEditDialog.this.selectedColumns.add(columnName, index - 1);
/* 1179 */           TableEditDialog.this.selectedColumns.select(index - 1);
/*      */ 
/* 1181 */           TableEditDialog.this.indexList.setItem(TableEditDialog.this.editIndexIndex, model.toString());
/* 1182 */           TableEditDialog.this.updateIndexColumnButtons();
/*      */         }
/*      */       }
/*      */     });
/* 1187 */     this.indexDownButton = new Button(indexColumnButtons, 8);
/* 1188 */     this.indexDownButton.setText(DBPlugin.getResourceString("dialog.table.downColumn"));
/* 1189 */     this.indexDownButton.setLayoutData(new GridData(768));
/* 1190 */     this.indexDownButton.addSelectionListener(new SelectionAdapter() {
/*      */       public void widgetSelected(SelectionEvent e) {
/* 1192 */         int index = TableEditDialog.this.selectedColumns.getSelectionIndex();
/* 1193 */         if (index < ((IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex)).getColumns().size() - 1) {
/* 1194 */           IndexModel model = (IndexModel)TableEditDialog.this.indexModels.get(TableEditDialog.this.editIndexIndex);
/* 1195 */           String columnName = (String)model.getColumns().get(index);
/*      */ 
/* 1197 */           model.getColumns().remove(index);
/* 1198 */           model.getColumns().add(index + 1, columnName);
/*      */ 
/* 1200 */           TableEditDialog.this.selectedColumns.remove(index);
/* 1201 */           TableEditDialog.this.selectedColumns.add(columnName, index + 1);
/* 1202 */           TableEditDialog.this.selectedColumns.select(index + 1);
/*      */ 
/* 1204 */           TableEditDialog.this.indexList.setItem(TableEditDialog.this.editIndexIndex, model.toString());
/* 1205 */           TableEditDialog.this.updateIndexColumnButtons();
/*      */         }
/*      */       }
/*      */     });
/* 1210 */     if (this.indexEditing)
/*      */     {
/* 1212 */       if (this.editIndexIndex >= 0) {
/* 1213 */         this.indexList.select(this.editIndexIndex);
/* 1214 */         indexSelectionChanged();
/*      */       } else {
/* 1216 */         disableIndexForm();
/*      */       }
/*      */     }
/* 1219 */     else disableIndexForm();
/*      */ 
/* 1222 */     return tabFolder;
/*      */   }
/*      */ 
/*      */   private void indexSelectionChanged() {
/* 1226 */     this.editIndexIndex = this.indexList.getSelectionIndex();
/* 1227 */     if (this.editIndexIndex >= 0) {
/* 1228 */       IndexModel model = (IndexModel)this.indexModels.get(this.editIndexIndex);
/* 1229 */       this.indexName.setEnabled(true);
/* 1230 */       this.indexType.setEnabled(true);
/* 1231 */       this.selectedColumns.setEnabled(true);
/* 1232 */       this.selectedColumns.removeAll();
/*      */ 
/* 1234 */       this.indexName.setText(model.getIndexName());
/* 1235 */       this.indexType.setText(model.getIndexType().getName());
/*      */ 
/* 1237 */       this.indexAddButton.setEnabled(true);
/* 1238 */       this.delIndex.setEnabled(true);
/*      */ 
/* 1240 */       for (String columnName : model.getColumns())
/* 1241 */         this.selectedColumns.add(columnName);
/*      */     }
/*      */     else {
/* 1244 */       disableIndexForm();
/*      */     }
/*      */   }
/*      */ 
/*      */   private void updateIndexColumnButtons()
/*      */   {
/* 1253 */     this.indexRemoveButton.setEnabled(false);
/* 1254 */     this.indexUpButton.setEnabled(false);
/* 1255 */     this.indexDownButton.setEnabled(false);
/*      */ 
/* 1257 */     int index = this.selectedColumns.getSelectionIndex();
/* 1258 */     if (index >= 0) {
/* 1259 */       this.indexRemoveButton.setEnabled(true);
/* 1260 */       if (index > 0)
/* 1261 */         this.indexUpButton.setEnabled(true);
/* 1262 */       else if (index < this.selectedColumns.getItemCount() - 1)
/* 1263 */         this.indexDownButton.setEnabled(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void updateButtons()
/*      */   {
/* 1272 */     this.btnDelColumn.setEnabled(false);
/* 1273 */     this.btnUpColumn.setEnabled(false);
/* 1274 */     this.btnDownColumn.setEnabled(false);
/* 1275 */     int index = this.tblColumns.getSelectionIndex();
/* 1276 */     if (index >= 0) {
/* 1277 */       this.btnDelColumn.setEnabled(true);
/* 1278 */       if (index > 0) {
/* 1279 */         this.btnUpColumn.setEnabled(true);
/*      */       }
/* 1281 */       if (index < this.columnModels.size() - 1)
/* 1282 */         this.btnDownColumn.setEnabled(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void disableColumnForm()
/*      */   {
/* 1291 */     this.editColumnIndex = -1;
/*      */ 
/* 1310 */     this.defaultValue.setText("");
/* 1311 */     this.hivalidator.setText("");
/*      */ 
/* 1313 */     this.txtColumnName.setEnabled(false);
/*      */ 
/* 1315 */     this.lookupText.setEnabled(false);
/* 1316 */     this.lookupBtn.setEnabled(false);
/* 1317 */     this.cmbColumnType.setEnabled(false);
/* 1318 */     this.txtColumnSize.setEnabled(false);
/* 1319 */     this.txtColumnScale.setEnabled(false);
/*      */ 
/* 1321 */     this.txtColumnDescription.setEnabled(false);
/*      */ 
/* 1323 */     this.defaultValue.setEnabled(false);
/* 1324 */     this.hivalidator.setEnabled(false);
/*      */ 
/* 1326 */     disableCheckForm();
/*      */   }
/*      */ 
/*      */   private void disableCheckForm()
/*      */   {
/* 1341 */     this.chkIsPK.setEnabled(false);
/* 1342 */     this.chkIsSearch.setEnabled(false);
/* 1343 */     this.chkIsListDisplay.setEnabled(false);
/* 1344 */     this.chkIsReadOnly.setEnabled(false);
/* 1345 */     this.chkIsHidden.setEnabled(false);
/* 1346 */     this.chkIsFull.setEnabled(false);
/* 1347 */     this.chkIsMainLookup.setEnabled(false);
/*      */   }
/*      */ 
/*      */   private void enableCheckForm()
/*      */   {
/* 1355 */     this.chkIsSearch.setEnabled(true);
/* 1356 */     this.chkIsListDisplay.setEnabled(true);
/* 1357 */     this.chkIsReadOnly.setEnabled(true);
/* 1358 */     this.chkIsHidden.setEnabled(true);
/* 1359 */     this.chkIsFull.setEnabled(true);
/* 1360 */     this.chkIsMainLookup.setEnabled(true);
/*      */   }
/*      */ 
/*      */   private void disableIndexForm()
/*      */   {
/* 1367 */     this.editIndexIndex = -1;
/* 1368 */     this.indexName.setText("");
/* 1369 */     this.indexType.setText("");
/* 1370 */     this.selectedColumns.removeAll();
/*      */ 
/* 1372 */     this.indexName.setEnabled(false);
/* 1373 */     this.indexType.setEnabled(false);
/* 1374 */     this.selectedColumns.setEnabled(false);
/*      */ 
/* 1376 */     this.delIndex.setEnabled(false);
/* 1377 */     this.indexAddButton.setEnabled(false);
/* 1378 */     this.indexRemoveButton.setEnabled(false);
/* 1379 */     this.indexUpButton.setEnabled(false);
/* 1380 */     this.indexDownButton.setEnabled(false);
/*      */   }
/*      */ 
/*      */   private void updateColumn() {
/* 1384 */     if ((this.editColumnIndex != -1) && (this.cmbColumnType.getSelectionIndex() != -1)) {
/* 1385 */       ColumnModel model = (ColumnModel)this.columnModels.get(this.editColumnIndex);
/*      */ 
/* 1390 */       String columnName = this.txtColumnName.getText();
/* 1391 */       if (columnName.length() > 2) {
/* 1392 */         String firstChar = columnName.substring(0, 2);
/* 1393 */         columnName = firstChar.toLowerCase() + columnName.substring(2);
/*      */ 
/* 1395 */         this.txtColumnName.setText(columnName);
/*      */ 
/* 1397 */         model.setColumnName(columnName);
/*      */       }
/*      */ 
/* 1402 */       String[] lkString = StringUtil.split(this.lookupText.getText(), "|");
/* 1403 */       if (lkString.length == 3) {
/* 1404 */         model.setLkServiceName(lkString[0]);
/* 1405 */         model.setLkEntityName(lkString[1]);
/* 1406 */         model.setLkFieldName(lkString[2]);
/*      */       }
/*      */ 
/* 1418 */       int columnIndex = this.cmbColumnType.getSelectionIndex();
/* 1419 */       model.setHiDataType(columnIndex);
/*      */ 
/* 1421 */       model.setSize(this.txtColumnSize.getText());
/* 1422 */       model.setScale(this.txtColumnScale.getText());
/*      */ 
/* 1424 */       model.setPrimaryKey(this.chkIsPK.getSelection());
/*      */ 
/* 1427 */       model.setSearch(this.chkIsSearch.getSelection());
/* 1428 */       model.setListDisplay(this.chkIsListDisplay.getSelection());
/* 1429 */       model.setReadOnly(this.chkIsReadOnly.getSelection());
/* 1430 */       model.setHidden(this.chkIsHidden.getSelection());
/* 1431 */       model.setFull(this.chkIsFull.getSelection());
/* 1432 */       model.setMainLookup(this.chkIsMainLookup.getSelection());
/*      */ 
/* 1436 */       model.setDescription(this.txtColumnDescription.getText());
/*      */ 
/* 1438 */       model.setDefaultValue(this.defaultValue.getText());
/* 1439 */       model.setHiValidator(this.hivalidator.getText());
/*      */ 
/* 1441 */       TableItem item = this.tblColumns.getItem(this.editColumnIndex);
/* 1442 */       updateTableItem(item, model);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void tableSelectionChanged()
/*      */   {
/* 1453 */     int index = this.tblColumns.getSelectionIndex();
/* 1454 */     if (index >= 0) {
/* 1455 */       ColumnModel model = (ColumnModel)this.columnModels.get(index);
/* 1456 */       this.txtColumnName.setText(model.getColumnName());
/*      */ 
/* 1460 */       String lookupString = model.getLkServiceName() + 
/* 1461 */         "|" + model.getLkEntityName() + 
/* 1462 */         "|" + model.getLkFieldName();
/*      */ 
/* 1464 */       this.lookupText.setText(lookupString);
/*      */ 
/* 1472 */       this.cmbColumnType.setText(this.hiTypes[model.getHiDataType()]);
/*      */ 
/* 1474 */       this.txtColumnSize.setText(String.valueOf(model.getSize()));
/* 1475 */       this.txtColumnScale.setText(String.valueOf(model.getScale()));
/*      */ 
/* 1477 */       this.txtColumnDescription.setText(model.getDescription());
/* 1478 */       this.defaultValue.setText(model.getDefaultValue());
/* 1479 */       this.hivalidator.setText(model.getHiValidator());
/*      */ 
/* 1481 */       this.chkIsPK.setSelection(model.isPrimaryKey());
/* 1482 */       this.chkIsSearch.setSelection(model.isSearch());
/* 1483 */       this.chkIsListDisplay.setSelection(model.isListDisplay());
/* 1484 */       this.chkIsReadOnly.setSelection(model.isReadOnly());
/* 1485 */       this.chkIsHidden.setSelection(model.isHidden());
/* 1486 */       this.chkIsFull.setSelection(model.isFull());
/* 1487 */       this.chkIsMainLookup.setSelection(model.isMainLookup());
/* 1488 */       this.chkIsParent.setSelection(model.isParent());
/*      */ 
/* 1491 */       if ((model.getHiDataType() == 6) || 
/* 1492 */         (model.getHiDataType() == 7))
/* 1493 */         this.lookupBtn.setEnabled(true);
/*      */       else {
/* 1495 */         this.lookupBtn.setEnabled(false);
/*      */       }
/*      */ 
/* 1498 */       this.txtColumnSize.setEditable(false);
/* 1499 */       this.txtColumnScale.setEditable(false);
/*      */ 
/* 1501 */       if (model.getHiDataType() == 1)
/*      */       {
/* 1503 */         this.txtColumnSize.setEditable(true);
/*      */       }
/* 1505 */       if (model.getHiDataType() == 3)
/*      */       {
/* 1507 */         this.txtColumnSize.setEditable(true);
/* 1508 */         this.txtColumnScale.setEditable(true);
/*      */       }
/*      */ 
/* 1514 */       this.editColumnIndex = index;
/*      */ 
/* 1517 */       if ((!model.isPrimaryKey()) && (!model.isParent())) {
/* 1518 */         this.txtColumnName.setEnabled(true);
/*      */ 
/* 1523 */         this.cmbColumnType.setEnabled(true);
/*      */ 
/* 1529 */         this.txtColumnDescription.setEnabled(true);
/* 1530 */         this.defaultValue.setEnabled(true);
/* 1531 */         this.hivalidator.setEnabled(true);
/* 1532 */         this.txtColumnSize.setEnabled(true);
/* 1533 */         this.txtColumnScale.setEnabled(true);
/*      */ 
/* 1535 */         this.chkIsPK.setEnabled(false);
/* 1536 */         this.chkIsSearch.setEnabled(true);
/* 1537 */         this.chkIsListDisplay.setEnabled(true);
/* 1538 */         this.chkIsReadOnly.setEnabled(true);
/* 1539 */         this.chkIsHidden.setEnabled(true);
/* 1540 */         this.chkIsFull.setEnabled(true);
/* 1541 */         this.chkIsMainLookup.setEnabled(true);
/*      */ 
/* 1543 */         if (model.getHiDataType() == 6) {
/* 1544 */           this.defaultValue.setEnabled(false);
/* 1545 */           this.lookupBtn.setEnabled(false);
/* 1546 */           this.cmbColumnType.setEnabled(false);
/*      */ 
/* 1548 */           this.hivalidator.setEnabled(false);
/*      */         }
/*      */ 
/* 1551 */         if ((model.getHiDataType() == 6) && (model.getLkEntityName().equals(""))) {
/* 1552 */           this.lookupBtn.setEnabled(true);
/*      */         }
/*      */ 
/* 1557 */         if ("id".equals(model.getLkFieldName())) {
/* 1558 */           disableCheckForm();
/*      */ 
/* 1562 */           this.lookupBtn.setEnabled(true);
/*      */         }
/*      */ 
/* 1566 */         if (model.getHiDataType() == 9) {
/* 1567 */           disableCheckForm();
/*      */         }
/*      */ 
/* 1570 */         if ((this.cmbColumnType.getSelectionIndex() == 8) || 
/* 1571 */           (this.cmbColumnType.getSelectionIndex() == 9) || 
/* 1572 */           (this.cmbColumnType.getSelectionIndex() == 7) || 
/* 1573 */           (this.cmbColumnType.getSelectionIndex() == 6))
/*      */         {
/* 1575 */           this.hivalidator.setText("");
/* 1576 */           this.hivalidator.setEnabled(false);
/*      */         }
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1596 */         disableColumnForm();
/*      */       }
/*      */     }
/*      */     else {
/* 1600 */       disableColumnForm();
/*      */     }
/* 1602 */     updateButtons();
/*      */   }
/*      */ 
/*      */   protected void okPressed()
/*      */   {
/* 1607 */     int index = -1;
/* 1608 */     java.util.List nameList = new ArrayList();
/* 1609 */     boolean isMainLookup = false;
/* 1610 */     int lookupIdIndex = -1;
/* 1611 */     for (ColumnModel model : this.columnModels) {
/* 1612 */       index++;
/* 1613 */       if ((model.isPrimaryKey()) || (model.isParent()) || 
/* 1614 */         (model.getHiDataType() != 6)) continue;
/* 1615 */       if (model.getLkEntityName().equals("")) {
/* 1616 */         MessageDialog.openError(null, "lookup字段有错误", "lookup字段：" + model.getColumnName() + "必需带回一个实体！");
/* 1617 */         this.tblColumns.select(index);
/* 1618 */         tableSelectionChanged();
/* 1619 */         return;
/*      */       }
/* 1621 */       if ("id".equals(model.getLkFieldName()))
/*      */       {
/* 1623 */         if (nameList.size() > 0)
/*      */         {
/* 1625 */           if (!isMainLookup) {
/* 1626 */             MessageDialog.openError(null, "lookup字段有错误", "lookup字段:" + ((ColumnModel)this.columnModels.get(lookupIdIndex)).getColumnName() + "必需得有一个主带回项");
/* 1627 */             this.tblColumns.select(lookupIdIndex);
/* 1628 */             tableSelectionChanged();
/* 1629 */             return;
/*      */           }
/* 1631 */           nameList.clear();
/*      */         }
/* 1633 */         isMainLookup = false;
/* 1634 */         lookupIdIndex = index;
/*      */       }
/*      */       else {
/* 1637 */         if (nameList.contains(model.getLkFieldName())) {
/* 1638 */           MessageDialog.openError(null, "lookup字段有错误", "lookup字段：" + model.getColumnName() + "不能带回同一项！");
/* 1639 */           this.tblColumns.select(index);
/* 1640 */           tableSelectionChanged();
/* 1641 */           return;
/*      */         }
/* 1643 */         nameList.add(model.getLkFieldName());
/* 1644 */         if (isMainLookup) {
/* 1645 */           if (model.isMainLookup()) {
/* 1646 */             MessageDialog.openError(null, "lookup字段有错误", "lookup字段:" + ((ColumnModel)this.columnModels.get(lookupIdIndex)).getColumnName() + "不能有多个主带回项！");
/* 1647 */             this.tblColumns.select(lookupIdIndex);
/* 1648 */             tableSelectionChanged();
/* 1649 */             return;
/*      */           }
/*      */         }
/* 1652 */         else isMainLookup = model.isMainLookup();
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1658 */     if (nameList.size() > 0)
/*      */     {
/* 1660 */       if (!isMainLookup) {
/* 1661 */         MessageDialog.openError(null, "lookup字段有错误", "lookup字段:" + ((ColumnModel)this.columnModels.get(lookupIdIndex)).getColumnName() + "必需得有一个主带回项");
/* 1662 */         this.tblColumns.select(lookupIdIndex);
/* 1663 */         tableSelectionChanged();
/* 1664 */         return;
/*      */       }
/* 1666 */       nameList.clear();
/*      */     }
/*      */ 
/* 1669 */     this.tableName = StringUtil.upperFirstChar(this.txtTableName.getText());
/* 1670 */     this.tableLogicalName = StringUtil.upperFirstChar(this.txtTableLogicalName.getText());
/* 1671 */     this.tableDescription = this.txtTableDescription.getText();
/*      */ 
/* 1673 */     this.extendServiceName = this.txtExtendServiceName.getText();
/* 1674 */     this.extendEntityName = this.txtExtendEntityName.getText();
/*      */ 
/* 1676 */     this.isDeleted = this.deleted.getSelection();
/* 1677 */     this.isCreator = this.creator.getSelection();
/*      */ 
/* 1679 */     super.okPressed();
/*      */   }
/*      */ 
/*      */   public String getTableName()
/*      */   {
/* 1689 */     return this.tableName;
/*      */   }
/*      */ 
/*      */   public String getTableLogicalName()
/*      */   {
/* 1698 */     return this.tableLogicalName;
/*      */   }
/*      */ 
/*      */   public String getTableDescription()
/*      */   {
/* 1707 */     return this.tableDescription;
/*      */   }
/*      */ 
/*      */   public java.util.List<ColumnModel> getResultColumns()
/*      */   {
/* 1716 */     return this.columnModels;
/*      */   }
/*      */ 
/*      */   public java.util.List<IndexModel> getResultIncices()
/*      */   {
/* 1725 */     return this.indexModels;
/*      */   }
/*      */ 
/*      */   private void updateTableItem(TableItem item, ColumnModel model)
/*      */   {
/* 1735 */     item.setText(0, model.getDescription());
/* 1736 */     item.setText(1, model.getColumnName());
/*      */ 
/* 1739 */     item.setText(2, this.hiTypes[model.getHiDataType()]);
/*      */ 
/* 1741 */     item.setText(3, String.valueOf(model.isPrimaryKey()));
/* 1742 */     item.setText(4, String.valueOf(model.isNotNull()));
/*      */   }
/*      */ 
/*      */   public String getExtendEntityName()
/*      */   {
/* 1748 */     return this.extendEntityName;
/*      */   }
/*      */ 
/*      */   public void setExtendEntityName(String extendEntityName) {
/* 1752 */     this.extendEntityName = extendEntityName;
/*      */   }
/*      */ 
/*      */   public String getExtendServiceName() {
/* 1756 */     return this.extendServiceName;
/*      */   }
/*      */ 
/*      */   public void setExtendServiceName(String extendServiceName) {
/* 1760 */     this.extendServiceName = extendServiceName;
/*      */   }
/*      */ 
/*      */   public boolean isDeleted() {
/* 1764 */     return this.isDeleted;
/*      */   }
/*      */ 
/*      */   public void setDeleted(boolean isDeleted) {
/* 1768 */     this.isDeleted = isDeleted;
/*      */   }
/*      */ 
/*      */   public boolean isCreator() {
/* 1772 */     return this.isCreator;
/*      */   }
/*      */ 
/*      */   public void setCreator(boolean isCreator) {
/* 1776 */     this.isCreator = isCreator;
/*      */   }
/*      */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.TableEditDialog
 * JD-Core Version:    0.6.0
 */