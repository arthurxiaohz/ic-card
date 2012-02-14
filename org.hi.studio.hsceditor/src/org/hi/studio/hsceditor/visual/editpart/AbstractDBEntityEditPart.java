/*     */ package org.hi.studio.hsceditor.visual.editpart;
/*     */ 
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.eclipse.draw2d.ChopboxAnchor;
/*     */ import org.eclipse.draw2d.ConnectionAnchor;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.eclipse.gef.ConnectionEditPart;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.EditPolicy;
/*     */ import org.eclipse.gef.GraphicalEditPart;
/*     */ import org.eclipse.gef.NodeEditPart;
/*     */ import org.eclipse.gef.Request;
/*     */ import org.eclipse.gef.commands.Command;
/*     */ import org.eclipse.gef.editpolicies.ComponentEditPolicy;
/*     */ import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
/*     */ import org.eclipse.gef.editpolicies.LayoutEditPolicy;
/*     */ import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
/*     */ import org.eclipse.gef.requests.CreateConnectionRequest;
/*     */ import org.eclipse.gef.requests.CreateRequest;
/*     */ import org.eclipse.gef.requests.GroupRequest;
/*     */ import org.eclipse.gef.requests.ReconnectRequest;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public abstract class AbstractDBEntityEditPart extends AbstractDBEditPart
/*     */   implements NodeEditPart
/*     */ {
/*     */   protected void refreshVisuals()
/*     */   {
/*  43 */     Object model = getModel();
/*  44 */     if ((model instanceof AbstractDBEntityModel)) {
/*  45 */       Rectangle constraint = ((AbstractDBEntityModel)model).getConstraint();
/*  46 */       ((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), constraint);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void createEditPolicies() {
/*  51 */     installEditPolicy("ComponentEditPolicy", new TableComponentEditPolicy(null));
/*  52 */     installEditPolicy("GraphicalNodeEditPolicy", new NodeEditPolicy(null));
/*  53 */     installEditPolicy("LayoutEditPolicy", new EntityLayoutEditPolicy(null));
/*     */   }
/*     */ 
/*     */   protected List<AbstractDBConnectionModel> getModelSourceConnections()
/*     */   {
/*  58 */     return ((AbstractDBEntityModel)getModel()).getModelSourceConnections();
/*     */   }
/*     */ 
/*     */   protected List<AbstractDBConnectionModel> getModelTargetConnections() {
/*  62 */     return ((AbstractDBEntityModel)getModel()).getModelTargetConnections();
/*     */   }
/*     */ 
/*     */   public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
/*  66 */     return new ChopboxAnchor(getFigure());
/*     */   }
/*     */ 
/*     */   public ConnectionAnchor getSourceConnectionAnchor(Request request) {
/*  70 */     return new ChopboxAnchor(getFigure());
/*     */   }
/*     */ 
/*     */   public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
/*  74 */     return new ChopboxAnchor(getFigure());
/*     */   }
/*     */ 
/*     */   public ConnectionAnchor getTargetConnectionAnchor(Request request) {
/*  78 */     return new ChopboxAnchor(getFigure());
/*     */   }
/*     */ 
/*     */   public void propertyChange(PropertyChangeEvent evt)
/*     */   {
/*  83 */     refreshVisuals();
/*  84 */     refreshSourceConnections();
/*  85 */     refreshTargetConnections();
/*     */ 
/*  87 */     invokePropertyChangeListener(evt, getSourceConnections());
/*  88 */     invokePropertyChangeListener(evt, getTargetConnections());
/*     */   }
/*     */ 
/*     */   private void invokePropertyChangeListener(PropertyChangeEvent evt, List<PropertyChangeListener> listeners) {
/*  92 */     for (PropertyChangeListener listener : listeners)
/*  93 */       listener.propertyChange(evt);
/*     */   }
/*     */ 
/*     */   protected void createConnection(AbstractDBConnectionModel conn)
/*     */   {
/*     */   }
/*     */ 
/*     */   private class CreateConnectionCommand extends Command
/*     */   {
/*     */     private AbstractDBEntityModel source;
/*     */     private AbstractDBEntityModel target;
/*     */     private AbstractDBConnectionModel connection;
/*     */ 
/*     */     private CreateConnectionCommand()
/*     */     {
/*     */     }
/*     */ 
/*     */     public AbstractDBConnectionModel getConnectionModel()
/*     */     {
/* 218 */       return this.connection;
/*     */     }
/*     */ 
/*     */     public boolean canExecute() {
/* 222 */       if ((this.source == null) || (this.target == null)) {
/* 223 */         return false;
/*     */       }
/* 225 */       if (((this.source instanceof EnumerationModel)) || ((this.target instanceof EnumerationModel))) {
/* 226 */         return false;
/*     */       }
/*     */ 
/* 229 */       if (this.source == this.target) {
/* 230 */         return false;
/*     */       }
/*     */ 
/* 234 */       List list = this.source.getModelSourceConnections();
/* 235 */       if (list.size() > 0)
/*     */       {
/* 238 */         return false;
/*     */       }
/*     */ 
/* 241 */       list = this.source.getModelTargetConnections();
/* 242 */       for (Iterator it = list.iterator(); it.hasNext(); ) {
/* 243 */         AbstractDBConnectionModel conn = (AbstractDBConnectionModel)it.next();
/* 244 */         if (((this.source == conn.getSource()) && (this.target == conn.getTarget())) || (
/* 245 */           (this.target == conn.getSource()) && (this.source == conn.getTarget())))
/*     */         {
/* 248 */           return false;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 254 */       return true;
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 259 */       if (canExecute())
/*     */       {
/* 262 */         ColumnModel fColumnModel = new ColumnModel();
/* 263 */         String logicalName = StringUtil.lowerFirstChar(((TableModel)this.target).getLogicalName());
/* 264 */         fColumnModel.setColumnName(logicalName);
/* 265 */         fColumnModel.setLogicalName(logicalName);
/* 266 */         fColumnModel.setDescription(logicalName);
/* 267 */         fColumnModel.setParent(true);
/* 268 */         fColumnModel.setMainEntityName(((TableModel)this.target).getLogicalName());
/* 269 */         fColumnModel.setHidden(true);
/* 270 */         fColumnModel.setListDisplay(false);
/* 271 */         fColumnModel.setHiDataType(2);
/*     */ 
/* 273 */         ColumnModel[] oldColumns = ((TableModel)this.source).getColumns();
/* 274 */         ColumnModel[] newColumns = new ColumnModel[oldColumns.length + 1];
/*     */ 
/* 277 */         for (int i = 0; i < oldColumns.length; i++) {
/* 278 */           newColumns[i] = oldColumns[i].toNewColumn();
/*     */         }
/*     */ 
/* 281 */         newColumns[oldColumns.length] = fColumnModel;
/*     */ 
/* 283 */         ((TableModel)this.source).setColumns(newColumns);
/*     */ 
/* 285 */         ((ForeignKeyModel)this.connection).setForeignKeyColumn(fColumnModel);
/* 286 */         ((ForeignKeyModel)this.connection).setTargetIdColumn(((TableModel)this.target).getPrimaryKeyColumns()[0]);
/*     */ 
/* 288 */         AbstractDBEntityEditPart.this.createConnection(this.connection);
/* 289 */         this.connection.attachSource();
/* 290 */         this.connection.attachTarget();
/*     */       }
/*     */     }
/*     */ 
/*     */     public void setConnection(Object model)
/*     */     {
/* 296 */       this.connection = ((AbstractDBConnectionModel)model);
/*     */     }
/*     */ 
/*     */     public void setSource(Object model) {
/* 300 */       this.source = ((AbstractDBEntityModel)model);
/* 301 */       this.connection.setSource(this.source);
/*     */     }
/*     */ 
/*     */     public void setTarget(Object model) {
/* 305 */       this.target = ((AbstractDBEntityModel)model);
/* 306 */       this.connection.setTarget(this.target);
/*     */     }
/*     */ 
/*     */     public void undo()
/*     */     {
/* 314 */       ColumnModel column = ((ForeignKeyModel)this.connection).getForeignKeyColumn();
/* 315 */       TableModel sourceTableModel = (TableModel)this.connection.getSource();
/*     */ 
/* 317 */       ColumnModel[] oldColumns = sourceTableModel.getColumns();
/* 318 */       ColumnModel[] newColumns = new ColumnModel[oldColumns.length - 1];
/* 319 */       int j = 0;
/* 320 */       for (int i = 0; i < oldColumns.length; i++)
/*     */       {
/* 322 */         if (!oldColumns[i].getColumnName().equals(column.getColumnName())) {
/* 323 */           newColumns[j] = oldColumns[i].toNewColumn();
/* 324 */           j++;
/*     */         }
/*     */       }
/*     */ 
/* 328 */       sourceTableModel.setColumns(newColumns);
/*     */ 
/* 330 */       this.connection.detachSource();
/* 331 */       this.connection.detachTarget();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class DeleteCommand extends Command
/*     */   {
/*     */     private RootModel root;
/*     */     private AbstractDBEntityModel model;
/* 116 */     private List<AbstractDBConnectionModel> sourceConnections = new ArrayList();
/* 117 */     private List<AbstractDBConnectionModel> targetConnections = new ArrayList();
/*     */ 
/*     */     private DeleteCommand() {  }
/*     */ 
/* 120 */     public void execute() { this.sourceConnections.addAll(this.model.getModelSourceConnections());
/* 121 */       this.targetConnections.addAll(this.model.getModelTargetConnections());
/* 122 */       for (int i = 0; i < this.sourceConnections.size(); i++) {
/* 123 */         AbstractDBConnectionModel model = (AbstractDBConnectionModel)this.sourceConnections.get(i);
/* 124 */         model.detachSource();
/* 125 */         model.detachTarget();
/*     */       }
/* 127 */       for (int i = 0; i < this.targetConnections.size(); i++) {
/* 128 */         AbstractDBConnectionModel model = (AbstractDBConnectionModel)this.targetConnections.get(i);
/* 129 */         model.detachSource();
/* 130 */         model.detachTarget();
/*     */       }
/* 132 */       this.root.removeChild(this.model); }
/*     */ 
/*     */     public void setRootModel(Object root)
/*     */     {
/* 136 */       this.root = ((RootModel)root);
/*     */     }
/*     */ 
/*     */     public void setTargetModel(Object model) {
/* 140 */       this.model = ((AbstractDBEntityModel)model);
/*     */     }
/*     */ 
/*     */     public void undo() {
/* 144 */       this.root.addChild(this.model);
/* 145 */       for (int i = 0; i < this.sourceConnections.size(); i++) {
/* 146 */         AbstractDBConnectionModel model = (AbstractDBConnectionModel)this.sourceConnections.get(i);
/* 147 */         model.attachSource();
/* 148 */         model.attachTarget();
/*     */       }
/* 150 */       for (int i = 0; i < this.targetConnections.size(); i++) {
/* 151 */         AbstractDBConnectionModel model = (AbstractDBConnectionModel)this.targetConnections.get(i);
/* 152 */         model.attachSource();
/* 153 */         model.attachTarget();
/*     */       }
/* 155 */       this.sourceConnections.clear();
/* 156 */       this.targetConnections.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class EntityLayoutEditPolicy extends LayoutEditPolicy
/*     */   {
/*     */     private EntityLayoutEditPolicy()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected Command getMoveChildrenCommand(Request request)
/*     */     {
/* 419 */       return null;
/*     */     }
/*     */ 
/*     */     protected EditPolicy createChildEditPolicy(EditPart child) {
/* 423 */       return new NonResizableEditPolicy();
/*     */     }
/*     */ 
/*     */     protected Command getCreateCommand(CreateRequest request) {
/* 427 */       return null;
/*     */     }
/*     */ 
/*     */     protected Command getDeleteDependantCommand(Request request) {
/* 431 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class NodeEditPolicy extends GraphicalNodeEditPolicy
/*     */   {
/*     */     private NodeEditPolicy()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
/*     */     {
/* 164 */       AbstractDBEntityModel model = (AbstractDBEntityModel)getHost().getModel();
/*     */ 
/* 168 */       AbstractDBEntityEditPart.CreateConnectionCommand command = (AbstractDBEntityEditPart.CreateConnectionCommand)request.getStartCommand();
/* 169 */       command.setTarget(model);
/* 170 */       return command;
/*     */     }
/*     */ 
/*     */     protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
/* 174 */       AbstractDBConnectionModel conn = (AbstractDBConnectionModel)request.getNewObject();
/* 175 */       AbstractDBEntityModel model = (AbstractDBEntityModel)getHost().getModel();
/*     */ 
/* 179 */       AbstractDBEntityEditPart.CreateConnectionCommand command = new AbstractDBEntityEditPart.CreateConnectionCommand(AbstractDBEntityEditPart.this, null);
/* 180 */       command.setConnection(conn);
/* 181 */       command.setSource(model);
/* 182 */       request.setStartCommand(command);
/* 183 */       return command;
/*     */     }
/*     */ 
/*     */     protected Command getReconnectTargetCommand(ReconnectRequest request) {
/* 187 */       AbstractDBConnectionModel conn = (AbstractDBConnectionModel)request.getConnectionEditPart().getModel();
/* 188 */       AbstractDBEntityModel model = (AbstractDBEntityModel)getHost().getModel();
/*     */ 
/* 192 */       AbstractDBEntityEditPart.ReconnectTargetCommand command = new AbstractDBEntityEditPart.ReconnectTargetCommand(AbstractDBEntityEditPart.this, null);
/* 193 */       command.setConnection(conn);
/* 194 */       command.setTarget(model);
/* 195 */       return command;
/*     */     }
/*     */ 
/*     */     protected Command getReconnectSourceCommand(ReconnectRequest request) {
/* 199 */       AbstractDBConnectionModel conn = (AbstractDBConnectionModel)request.getConnectionEditPart().getModel();
/* 200 */       AbstractDBEntityModel model = (AbstractDBEntityModel)getHost().getModel();
/*     */ 
/* 204 */       AbstractDBEntityEditPart.ReconnectSourceCommand command = new AbstractDBEntityEditPart.ReconnectSourceCommand(AbstractDBEntityEditPart.this, null);
/* 205 */       command.setConnection(conn);
/* 206 */       command.setSource(model);
/* 207 */       return command;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class ReconnectSourceCommand extends Command
/*     */   {
/*     */     private AbstractDBEntityModel source;
/*     */     private AbstractDBEntityModel oldSource;
/*     */     private AbstractDBConnectionModel connection;
/*     */ 
/*     */     private ReconnectSourceCommand()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 385 */       this.connection.detachSource();
/* 386 */       this.connection.setSource(this.source);
/* 387 */       this.connection.attachSource();
/*     */     }
/*     */ 
/*     */     public void setConnection(Object model) {
/* 391 */       this.connection = ((AbstractDBConnectionModel)model);
/* 392 */       this.oldSource = this.connection.getSource();
/*     */     }
/*     */ 
/*     */     public void setSource(Object model) {
/* 396 */       this.source = ((AbstractDBEntityModel)model);
/*     */     }
/*     */ 
/*     */     public boolean canExecute() {
/* 400 */       if ((this.connection.getTarget() == null) || (this.source == null)) {
/* 401 */         return false;
/*     */       }
/*     */ 
/* 404 */       return !this.connection.getTarget().equals(this.source);
/*     */     }
/*     */ 
/*     */     public void undo()
/*     */     {
/* 410 */       this.connection.detachSource();
/* 411 */       this.connection.setSource(this.oldSource);
/* 412 */       this.connection.attachSource();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class ReconnectTargetCommand extends Command
/*     */   {
/*     */     private AbstractDBEntityModel target;
/*     */     private AbstractDBEntityModel oldTarget;
/*     */     private AbstractDBConnectionModel connection;
/*     */ 
/*     */     private ReconnectTargetCommand()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 347 */       this.connection.detachTarget();
/* 348 */       this.connection.setTarget(this.target);
/* 349 */       this.connection.attachTarget();
/*     */     }
/*     */ 
/*     */     public void setConnection(Object model) {
/* 353 */       this.connection = ((AbstractDBConnectionModel)model);
/* 354 */       this.oldTarget = this.connection.getTarget();
/*     */     }
/*     */ 
/*     */     public void setTarget(Object model) {
/* 358 */       this.target = ((AbstractDBEntityModel)model);
/*     */     }
/*     */ 
/*     */     public boolean canExecute() {
/* 362 */       if ((this.connection.getSource() == null) || (this.target == null)) {
/* 363 */         return false;
/*     */       }
/*     */ 
/* 366 */       return !this.connection.getSource().equals(this.target);
/*     */     }
/*     */ 
/*     */     public void undo()
/*     */     {
/* 372 */       this.connection.detachTarget();
/* 373 */       this.connection.setTarget(this.oldTarget);
/* 374 */       this.connection.attachTarget();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class TableComponentEditPolicy extends ComponentEditPolicy
/*     */   {
/*     */     private TableComponentEditPolicy()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected Command createDeleteCommand(GroupRequest deleteRequest)
/*     */     {
/* 103 */       AbstractDBEntityEditPart.DeleteCommand command = new AbstractDBEntityEditPart.DeleteCommand(AbstractDBEntityEditPart.this, null);
/* 104 */       command.setRootModel(getHost().getParent().getModel());
/* 105 */       command.setTargetModel(getHost().getModel());
/* 106 */       return command;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static class TableEditCommand extends Command
/*     */   {
/*     */     private TableModel model;
/*     */     private String oldTableName;
/*     */     private String newTableName;
/*     */     private String oldTableLogicalName;
/*     */     private String newTableLogicalName;
/*     */     private String oldTableDescription;
/*     */     private String newTableDescription;
/*     */     private ColumnModel[] oldColumns;
/*     */     private ColumnModel[] newColumns;
/*     */     private IndexModel[] oldIndices;
/*     */     private IndexModel[] newIndices;
/*     */     private String oldExtendServiceName;
/*     */     private String newExtendServiceName;
/*     */     private String oldExtendEntityName;
/*     */     private String newExtendEntityName;
/*     */     private boolean oldIsDeleted;
/*     */     private boolean isDeleted;
/*     */     private boolean oldIsCreator;
/*     */     private boolean isCreator;
/*     */ 
/*     */     public boolean isDeleted()
/*     */     {
/* 461 */       return this.isDeleted;
/*     */     }
/*     */ 
/*     */     public void setDeleted(boolean isDeleted) {
/* 465 */       this.isDeleted = isDeleted;
/*     */     }
/*     */ 
/*     */     public boolean isOldIsDeleted() {
/* 469 */       return this.oldIsDeleted;
/*     */     }
/*     */ 
/*     */     public void setOldIsDeleted(boolean oldIsDeleted) {
/* 473 */       this.oldIsDeleted = oldIsDeleted;
/*     */     }
/*     */ 
/*     */     public boolean isOldIsCreator()
/*     */     {
/* 481 */       return this.oldIsCreator;
/*     */     }
/*     */ 
/*     */     public void setOldIsCreator(boolean oldIsCreator) {
/* 485 */       this.oldIsCreator = oldIsCreator;
/*     */     }
/*     */ 
/*     */     public boolean isCreator() {
/* 489 */       return this.isCreator;
/*     */     }
/*     */ 
/*     */     public void setCreator(boolean isCreator) {
/* 493 */       this.isCreator = isCreator;
/*     */     }
/*     */ 
/*     */     public TableEditCommand(TableModel model, String newTableName, String newTableLogicalName, String newTableDescription, ColumnModel[] newColumns, IndexModel[] newIndices, String extServiceName, String extEntityName, boolean isDeleted, boolean isCreator)
/*     */     {
/* 499 */       this.model = model;
/* 500 */       this.oldTableName = model.getTableName();
/* 501 */       this.newTableName = newTableName;
/* 502 */       this.oldTableLogicalName = model.getLogicalName();
/* 503 */       this.newTableLogicalName = newTableLogicalName;
/* 504 */       this.oldTableDescription = model.getDescription();
/* 505 */       this.newTableDescription = newTableDescription;
/* 506 */       this.oldColumns = model.getColumns();
/* 507 */       this.newColumns = newColumns;
/* 508 */       this.oldIndices = model.getIndices();
/* 509 */       this.newIndices = newIndices;
/*     */ 
/* 511 */       this.newExtendServiceName = extServiceName;
/* 512 */       this.oldExtendServiceName = model.getExtendServiceName();
/* 513 */       this.newExtendEntityName = extEntityName;
/* 514 */       this.oldExtendEntityName = model.getExtendEntityName();
/*     */ 
/* 516 */       this.isDeleted = isDeleted;
/* 517 */       this.oldIsDeleted = model.isDeleted();
/*     */ 
/* 519 */       this.isCreator = isCreator;
/* 520 */       this.oldIsCreator = model.isCreator();
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 526 */       this.model.setTableName(this.newTableName);
/* 527 */       this.model.setLogicalName(this.newTableLogicalName);
/* 528 */       this.model.setDescription(this.newTableDescription);
/* 529 */       this.model.setColumns(this.newColumns);
/* 530 */       this.model.setIndices(this.newIndices);
/*     */ 
/* 532 */       this.model.setExtendServiceName(this.newExtendServiceName);
/* 533 */       this.model.setExtendEntityName(this.newExtendEntityName);
/* 534 */       this.model.setDeleted(this.isDeleted);
/* 535 */       this.model.setCreator(this.isCreator);
/*     */     }
/*     */ 
/*     */     public void undo() {
/* 539 */       this.model.setTableName(this.oldTableName);
/* 540 */       this.model.setLogicalName(this.oldTableLogicalName);
/* 541 */       this.model.setDescription(this.oldTableDescription);
/* 542 */       this.model.setColumns(this.oldColumns);
/* 543 */       this.model.setIndices(this.oldIndices);
/*     */ 
/* 545 */       this.model.setExtendServiceName(this.oldExtendServiceName);
/* 546 */       this.model.setExtendEntityName(this.oldExtendEntityName);
/* 547 */       this.model.setDeleted(this.oldIsDeleted);
/* 548 */       this.model.setCreator(this.oldIsCreator);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.AbstractDBEntityEditPart
 * JD-Core Version:    0.6.0
 */