/*     */ package org.hi.studio.hsceditor.visual.editpart;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.draw2d.IFigure;
/*     */ import org.eclipse.gef.EditDomain;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.EditPartViewer;
/*     */ import org.eclipse.gef.NodeEditPart;
/*     */ import org.eclipse.gef.commands.CommandStack;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.hi.studio.core.constants.HiDataType;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.dialog.EnumerationEditDialog;
/*     */ import org.hi.studio.hsceditor.visual.dialog.TableEditDialog;
/*     */ import org.hi.studio.hsceditor.visual.generate.HiServiceGenerator;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationValueModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyMapping;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class TableEditPart extends AbstractDBEntityEditPart
/*     */   implements NodeEditPart
/*     */ {
/*     */   protected IFigure createFigure()
/*     */   {
/*  31 */     TableFigure figure = new TableFigure();
/*  32 */     updateFigure(figure);
/*  33 */     return figure;
/*     */   }
/*     */ 
/*     */   private void updateFigure(TableFigure figure) {
/*  37 */     TableModel model = (TableModel)getModel();
/*  38 */     RootModel root = (RootModel)getParent().getModel();
/*     */ 
/*  44 */     if ((model instanceof EnumerationModel))
/*     */     {
/*  46 */       EnumerationModel emunModle = (EnumerationModel)model;
/*  47 */       figure.setTableName(emunModle.getEnumDesc() + ":" + emunModle.getEnumName());
/*     */ 
/*  49 */       figure.setErrorMessage(model.getError());
/*  50 */       figure.removeAllColumns();
/*     */ 
/*  53 */       figure.setBackgroundColor(DBPlugin.getDefault().getColor(new RGB(255, 255, 0)));
/*     */     }
/*     */     else
/*     */     {
/*  57 */       figure.setTableName(model.getLogicalName());
/*     */ 
/*  59 */       figure.setErrorMessage(model.getError());
/*  60 */       figure.removeAllColumns();
/*  61 */       figure.setLinkedTable(model.isLinkedTable());
/*  62 */       figure.setBackgroundColor(DBPlugin.getDefault().getColor(model.getBackgroundColor()));
/*     */     }
/*     */ 
/*  65 */     ColumnModel[] columns = model.getColumns();
/*  66 */     for (int i = 0; i < columns.length; i++) {
/*  67 */       ColumnFigure[] figures = createColumnFigure(root, model, columns[i]);
/*  68 */       figure.add(figures[0]);
/*  69 */       figure.add(figures[1]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private ColumnFigure[] createColumnFigure(RootModel root, TableModel table, ColumnModel model)
/*     */   {
/*  75 */     StringBuffer sb = new StringBuffer();
/*     */ 
/*  77 */     ColumnFigure label1 = new ColumnFigure();
/*  78 */     ColumnFigure label2 = new ColumnFigure();
/*     */ 
/*  80 */     if ((table instanceof EnumerationModel)) {
/*  81 */       EnumerationValueModel valueModel = (EnumerationValueModel)model;
/*     */ 
/*  83 */       label1.setText(valueModel.getEnumLabel() + ":");
/*  84 */       label2.setText(valueModel.getEnumValue());
/*     */     } else {
/*  86 */       String[] hiTypes = HiDataType.HI_TYPES;
/*  87 */       sb.append(hiTypes[model.getHiDataType()]);
/*     */ 
/*  89 */       label1.setText(model.getDescription() + ":" + model.getColumnName());
/*  90 */       label2.setText(sb.toString());
/*  91 */       label2.setUnderline(model.isPrimaryKey());
/*  92 */       label1.setUnderline(model.isPrimaryKey());
/*     */     }
/*     */ 
/*  96 */     List connections = table.getModelSourceConnections();
/*  97 */     for (int i = 0; i < connections.size(); i++) {
/*  98 */       AbstractDBConnectionModel obj = (AbstractDBConnectionModel)connections.get(i);
/*  99 */       if ((obj instanceof ForeignKeyModel)) {
/* 100 */         ForeignKeyMapping[] mappings = ((ForeignKeyModel)obj).getMapping();
/* 101 */         for (int j = 0; j < mappings.length; j++) {
/* 102 */           if ((mappings[j].getRefer() == null) || 
/* 103 */             (!mappings[j].getRefer().getColumnName().equals(model.getColumnName()))) continue;
/* 104 */           label1.setText(label1.getText());
/* 105 */           break;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 111 */     return new ColumnFigure[] { label1, label2 };
/*     */   }
/*     */ 
/*     */   protected void refreshVisuals()
/*     */   {
/* 116 */     super.refreshVisuals();
/* 117 */     updateFigure((TableFigure)getFigure());
/* 118 */     refreshChildren();
/*     */   }
/*     */ 
/*     */   protected void createConnection(AbstractDBConnectionModel conn) {
/* 122 */     if ((conn instanceof ForeignKeyModel)) {
/* 123 */       TableModel table = (TableModel)getModel();
/* 124 */       List sources = table.getModelSourceConnections();
/* 125 */       String fkName = table.getTableName() + "_FK_";
/* 126 */       int count = 1;
/*     */ 
/* 128 */       for (int i = 0; i < sources.size(); i++) {
/* 129 */         AbstractDBConnectionModel obj = (AbstractDBConnectionModel)sources.get(i);
/* 130 */         if ((!(obj instanceof ForeignKeyModel)) || 
/* 131 */           (!((ForeignKeyModel)obj).getForeignKeyName().equals(fkName + count))) continue;
/* 132 */         count++;
/* 133 */         break;
/*     */       }
/*     */ 
/* 137 */       fkName = fkName + count;
/*     */ 
/* 140 */       ((ForeignKeyModel)conn).setForeignKeyName(fkName);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void doubleClicked() {
/* 145 */     TableModel model = (TableModel)getModel();
/*     */ 
/* 147 */     if ((model instanceof EnumerationModel)) {
/* 148 */       EnumerationModel enumModel = (EnumerationModel)model;
/* 149 */       List columnModels = new ArrayList();
/* 150 */       for (int i = 0; i < enumModel.getColumns().length; i++)
/*     */       {
/* 153 */         columnModels.add(((EnumerationValueModel)enumModel.getColumns()[i]).toNewColumn());
/*     */       }
/* 155 */       RootModel root = (RootModel)getParent().getModel();
/* 156 */       EnumerationEditDialog dialog = new EnumerationEditDialog(Display.getDefault().getActiveShell(), columnModels, 
/* 157 */         enumModel.getEnumName(), enumModel.getEnumDesc(), root);
/* 158 */       if (dialog.open() == 0) {
/* 159 */         List columns = dialog.getColumns();
/*     */ 
/* 162 */         getViewer().getEditDomain().getCommandStack().execute(
/* 163 */           new EnumerationEditCommand(enumModel, 
/* 164 */           (ColumnModel[])columns.toArray(new ColumnModel[columns.size()]), 
/* 165 */           dialog.getEnumName(), dialog.getEnumDesc()));
/*     */         try
/*     */         {
/* 171 */           HiServiceGenerator.generate(root);
/*     */         } catch (Exception e) {
/* 173 */           e.printStackTrace();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/* 180 */     else if (model.isLinkedTable()) {
/* 181 */       UIUtils.openAlertDialog(DBPlugin.getResourceString("error.edit.linkedTable"));
/*     */     } else {
/* 183 */       RootModel root = (RootModel)getParent().getModel();
/* 184 */       openTableEditDialog(getViewer(), model, root);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void openTableEditDialog(EditPartViewer viewer, TableModel model, RootModel root)
/*     */   {
/* 199 */     openTableEditDialog(viewer, model, root, null);
/*     */   }
/*     */ 
/*     */   public static void openTableEditDialog(EditPartViewer viewer, TableModel model, RootModel root, ColumnModel editColumn)
/*     */   {
/* 219 */     TableEditDialog dialog = new TableEditDialog(viewer.getControl().getShell(), 
/* 220 */       root, model, editColumn, false, null);
/*     */ 
/* 223 */     if (dialog.open() == 0) {
/* 224 */       List columns = dialog.getResultColumns();
/* 225 */       List indices = dialog.getResultIncices();
/*     */ 
/* 228 */       viewer.getEditDomain().getCommandStack().execute(
/* 229 */         new AbstractDBEntityEditPart.TableEditCommand(model, 
/* 230 */         dialog.getTableName(), 
/* 231 */         dialog.getTableLogicalName(), 
/* 232 */         dialog.getTableDescription(), 
/* 233 */         (ColumnModel[])columns.toArray(new ColumnModel[columns.size()]), 
/* 234 */         (IndexModel[])indices.toArray(new IndexModel[indices.size()]), 
/* 235 */         dialog.getExtendServiceName(), dialog.getExtendEntityName(), dialog.isDeleted(), dialog.isCreator()));
/*     */       try
/*     */       {
/* 241 */         HiServiceGenerator.generate(root);
/*     */       } catch (Exception e) {
/* 243 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void openTableEditDialog(EditPartViewer viewer, TableModel model, RootModel root, IndexModel editIndex)
/*     */   {
/* 260 */     TableEditDialog dialog = new TableEditDialog(viewer.getControl().getShell(), 
/* 261 */       root, model.getTableName(), model.getLogicalName(), model.getDescription(), 
/* 262 */       model.getColumns(), null, model.getIndices(), true, editIndex, 
/* 263 */       model.getExtendServiceName(), model.getExtendEntityName(), model.isDeleted());
/*     */ 
/* 265 */     if (dialog.open() == 0) {
/* 266 */       List columns = dialog.getResultColumns();
/* 267 */       List indices = dialog.getResultIncices();
/*     */ 
/* 269 */       viewer.getEditDomain().getCommandStack().execute(
/* 270 */         new AbstractDBEntityEditPart.TableEditCommand(model, 
/* 271 */         dialog.getTableName(), 
/* 272 */         dialog.getTableLogicalName(), 
/* 273 */         dialog.getTableDescription(), 
/* 274 */         (ColumnModel[])columns.toArray(new ColumnModel[columns.size()]), 
/* 275 */         (IndexModel[])indices.toArray(new IndexModel[indices.size()]), 
/* 276 */         dialog.getExtendServiceName(), dialog.getExtendEntityName(), dialog.isDeleted(), dialog.isCreator()));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.TableEditPart
 * JD-Core Version:    0.6.0
 */