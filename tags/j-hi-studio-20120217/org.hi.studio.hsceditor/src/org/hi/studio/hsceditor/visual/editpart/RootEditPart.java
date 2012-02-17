/*     */ package org.hi.studio.hsceditor.visual.editpart;
/*     */ 
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.draw2d.IFigure;
/*     */ import org.eclipse.draw2d.Layer;
/*     */ import org.eclipse.draw2d.XYLayout;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.eclipse.gef.EditDomain;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.EditPartViewer;
/*     */ import org.eclipse.gef.EditPolicy;
/*     */ import org.eclipse.gef.Request;
/*     */ import org.eclipse.gef.commands.Command;
/*     */ import org.eclipse.gef.commands.CommandStack;
/*     */ import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
/*     */ import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
/*     */ import org.eclipse.gef.requests.CreateRequest;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.hi.studio.hsceditor.util.EntityBasedataGeneratorUtil;
/*     */ import org.hi.studio.hsceditor.visual.dialog.EnumerationEditDialog;
/*     */ import org.hi.studio.hsceditor.visual.dialog.ServiceEditDialog;
/*     */ import org.hi.studio.hsceditor.visual.dialog.TableEditDialog;
/*     */ import org.hi.studio.hsceditor.visual.generate.HiServiceGenerator;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationValueModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class RootEditPart extends AbstractDBEditPart
/*     */ {
/*     */   protected IFigure createFigure()
/*     */   {
/*  37 */     Layer figure = new Layer();
/*  38 */     figure.setLayoutManager(new XYLayout());
/*  39 */     return figure;
/*     */   }
/*     */ 
/*     */   protected void createEditPolicies() {
/*  43 */     installEditPolicy("LayoutEditPolicy", new RootEditPolicy(null));
/*     */   }
/*     */ 
/*     */   protected List<AbstractDBEntityModel> getModelChildren() {
/*  47 */     return ((RootModel)getModel()).getChildren();
/*     */   }
/*     */ 
/*     */   public void propertyChange(PropertyChangeEvent evt) {
/*  51 */     if (evt.getPropertyName().equals("p_children")) {
/*  52 */       refreshChildren();
/*     */     }
/*  54 */     if (evt.getPropertyName().equals("p_mode"))
/*     */     {
/*  56 */       List children = getChildren();
/*  57 */       for (AbstractDBEntityEditPart part : children) {
/*  58 */         part.refresh();
/*     */ 
/*  60 */         List conns = part.getSourceConnections();
/*  61 */         for (AbstractDBConnectionEditPart conn : conns)
/*  62 */           conn.refresh();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void doubleClicked()
/*     */   {
/* 262 */     RootModel model = (RootModel)getModel();
/*     */ 
/* 264 */     ServiceEditDialog serviceEditDialog = new ServiceEditDialog(Display.getDefault().getActiveShell(), model.getServiceName(), model.getPackageName(), model.getBaseData(), model.getDescription(), false);
/*     */ 
/* 266 */     if (serviceEditDialog.open() == 0)
/* 267 */       getViewer().getEditDomain().getCommandStack().execute(
/* 268 */         new RootEditCommand(model, serviceEditDialog.getHiBasicData(), 
/* 269 */         serviceEditDialog.getHiPackage(), serviceEditDialog.getHiDesc()));
/*     */   }
/*     */ 
/*     */   private class ChangeConstraintCommand extends Command
/*     */   {
/*     */     private AbstractDBEntityModel model;
/*     */     private Rectangle constraint;
/*     */     private Rectangle oldConstraint;
/*     */ 
/*     */     private ChangeConstraintCommand()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 112 */       this.model.setConstraint(this.constraint);
/*     */     }
/*     */ 
/*     */     public void setConstraint(Rectangle constraint) {
/* 116 */       this.constraint = constraint;
/*     */     }
/*     */ 
/*     */     public void setModel(AbstractDBEntityModel model) {
/* 120 */       this.model = model;
/* 121 */       this.oldConstraint = model.getConstraint();
/*     */     }
/*     */ 
/*     */     public void undo() {
/* 125 */       this.model.setConstraint(this.oldConstraint);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class CreateCommand extends Command
/*     */   {
/*     */     private RootModel root;
/*     */     private AbstractDBEntityModel model;
/*     */ 
/*     */     private CreateCommand()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 150 */       ((TableModel)this.model).setEntityBaseData(EntityBasedataGeneratorUtil.generateEntityBasedata(this.root).toString());
/*     */ 
/* 152 */       if ((this.model instanceof EnumerationModel)) {
/* 153 */         EnumerationModel enumModel = (EnumerationModel)this.model;
/*     */ 
/* 155 */         List columnModels = new ArrayList();
/* 156 */         for (int i = 0; i < ((EnumerationModel)this.model).getColumns().length; i++)
/*     */         {
/* 159 */           columnModels.add(((EnumerationValueModel)enumModel.getColumns()[i]).toNewColumn());
/*     */         }
/*     */ 
/* 162 */         EnumerationEditDialog dialog = new EnumerationEditDialog(Display.getDefault().getActiveShell(), columnModels, 
/* 163 */           enumModel.getEnumName(), enumModel.getEnumDesc(), this.root);
/* 164 */         if (dialog.open() == 0) {
/* 165 */           List columns = dialog.getColumns();
/*     */ 
/* 168 */           RootEditPart.this.getViewer().getEditDomain().getCommandStack().execute(
/* 169 */             new EnumerationEditCommand(enumModel, 
/* 170 */             (ColumnModel[])columns.toArray(new ColumnModel[columns.size()]), 
/* 171 */             dialog.getEnumName(), dialog.getEnumDesc()));
/*     */           try
/*     */           {
/* 176 */             this.root.addChild(this.model);
/* 177 */             HiServiceGenerator.generate(this.root);
/*     */           } catch (Exception e) {
/* 179 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 195 */         TableEditDialog dialog = new TableEditDialog(Display.getDefault().getActiveShell(), 
/* 196 */           this.root, (TableModel)this.model, null, false, null);
/* 197 */         if (dialog.open() == 0) {
/* 198 */           List columns = dialog.getResultColumns();
/* 199 */           List indices = dialog.getResultIncices();
/*     */ 
/* 201 */           RootEditPart.this.getViewer().getEditDomain().getCommandStack().execute(
/* 202 */             new TableEditCommand((TableModel)this.model, 
/* 203 */             dialog.getTableName(), 
/* 204 */             dialog.getTableLogicalName(), 
/* 205 */             dialog.getTableDescription(), 
/* 206 */             (ColumnModel[])columns.toArray(new ColumnModel[columns.size()]), 
/* 207 */             (IndexModel[])indices.toArray(new IndexModel[indices.size()]), 
/* 208 */             dialog.getExtendServiceName(), dialog.getExtendEntityName(), dialog.isDeleted()));
/*     */           try
/*     */           {
/* 213 */             this.root.addChild(this.model);
/* 214 */             HiServiceGenerator.generate(this.root);
/*     */           } catch (Exception e) {
/* 216 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     public void setRootModel(Object root)
/*     */     {
/* 227 */       this.root = ((RootModel)root);
/*     */     }
/*     */ 
/*     */     public void setModel(Object model) {
/* 231 */       this.model = ((AbstractDBEntityModel)model);
/*     */ 
/* 233 */       if (((this.model instanceof TableModel)) && (!(model instanceof EnumerationModel))) {
/* 234 */         ((TableModel)this.model).setTableName("Entity" + (this.root.getChildren().size() + 1));
/* 235 */         ((TableModel)this.model).setLogicalName("Entity" + (this.root.getChildren().size() + 1));
/* 236 */         ((TableModel)this.model).setDescription("Entity" + (this.root.getChildren().size() + 1));
/*     */ 
/* 239 */         ColumnModel idColumn = new ColumnModel();
/* 240 */         idColumn.setColumnName("id");
/* 241 */         idColumn.setLogicalName("id");
/* 242 */         idColumn.setHiDataType(2);
/* 243 */         idColumn.setPrimaryKey(true);
/* 244 */         idColumn.setListDisplay(false);
/* 245 */         idColumn.setHidden(true);
/* 246 */         idColumn.setReadOnly(true);
/* 247 */         idColumn.setDescription("id");
/* 248 */         idColumn.setSize("20");
/*     */ 
/* 250 */         ((TableModel)this.model).setColumns(new ColumnModel[] { idColumn });
/*     */       }
/*     */     }
/*     */ 
/*     */     public void undo()
/*     */     {
/* 256 */       this.root.removeChild(this.model);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static class RootEditCommand extends Command
/*     */   {
/*     */     private RootModel model;
/*     */     private String oldHiBaseData;
/*     */     private String newHiBaseData;
/*     */     private String oldHiPackage;
/*     */     private String newHiPackage;
/*     */     private String oldHiDesc;
/*     */     private String newHiDesc;
/*     */ 
/*     */     public RootEditCommand(RootModel model, String hiBaseData, String hiPackage, String hiDesc)
/*     */     {
/* 286 */       this.model = model;
/* 287 */       this.oldHiBaseData = model.getBaseData();
/* 288 */       this.newHiBaseData = hiBaseData;
/* 289 */       this.oldHiPackage = model.getPackageName();
/* 290 */       this.newHiPackage = hiPackage;
/* 291 */       this.oldHiDesc = model.getDescription();
/* 292 */       this.newHiDesc = hiDesc;
/*     */     }
/*     */ 
/*     */     public void execute() {
/* 296 */       this.model.setBaseData(this.newHiBaseData);
/* 297 */       this.model.setPackageName(this.newHiPackage);
/* 298 */       this.model.setDescription(this.newHiDesc);
/*     */     }
/*     */ 
/*     */     public void undo()
/*     */     {
/* 304 */       this.model.setBaseData(this.oldHiBaseData);
/* 305 */       this.model.setPackageName(this.oldHiPackage);
/* 306 */       this.model.setDescription(this.oldHiDesc);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class RootEditPolicy extends XYLayoutEditPolicy
/*     */   {
/*     */     private RootEditPolicy()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected EditPolicy createChildEditPolicy(EditPart child)
/*     */     {
/*  72 */       return new NonResizableEditPolicy();
/*     */     }
/*     */ 
/*     */     protected Command createAddCommand(EditPart child, Object constraint) {
/*  76 */       return null;
/*     */     }
/*     */ 
/*     */     protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
/*  80 */       RootEditPart.ChangeConstraintCommand command = new RootEditPart.ChangeConstraintCommand(RootEditPart.this, null);
/*  81 */       command.setModel((AbstractDBEntityModel)child.getModel());
/*  82 */       command.setConstraint((Rectangle)constraint);
/*  83 */       return command;
/*     */     }
/*     */ 
/*     */     protected Command getCreateCommand(CreateRequest request) {
/*  87 */       RootEditPart.CreateCommand command = new RootEditPart.CreateCommand(RootEditPart.this, null);
/*  88 */       Rectangle constraint = (Rectangle)getConstraintFor(request);
/*  89 */       constraint.width = -1;
/*  90 */       constraint.height = -1;
/*  91 */       AbstractDBEntityModel model = (AbstractDBEntityModel)request.getNewObject();
/*  92 */       model.setConstraint(constraint);
/*     */ 
/*  94 */       command.setRootModel(getHost().getModel());
/*  95 */       command.setModel(model);
/*  96 */       return command;
/*     */     }
/*     */ 
/*     */     protected Command getDeleteDependantCommand(Request request) {
/* 100 */       return null;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.RootEditPart
 * JD-Core Version:    0.6.0
 */