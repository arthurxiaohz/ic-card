/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import org.eclipse.draw2d.ConnectionLocator;
/*    */ import org.eclipse.draw2d.IFigure;
/*    */ import org.eclipse.draw2d.Label;
/*    */ import org.eclipse.draw2d.PolygonDecoration;
/*    */ import org.eclipse.draw2d.PolylineConnection;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.RootEditPart;
/*    */ import org.eclipse.swt.widgets.Display;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.ForeignKeyMapping;
/*    */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class ForeignKeyEditPart extends AbstractDBConnectionEditPart
/*    */ {
/*    */   private Label label;
/*    */   private ManhattanConnectionRouter router;
/*    */ 
/*    */   protected IFigure createFigure()
/*    */   {
/* 27 */     PolylineConnection connection = new PolylineConnection();
/* 28 */     this.router = new ManhattanConnectionRouter();
/*    */ 
/* 30 */     connection.setConnectionRouter(this.router);
/*    */ 
/* 32 */     PolygonDecoration decoration = new PolygonDecoration();
/* 33 */     connection.setTargetDecoration(decoration);
/*    */ 
/* 35 */     this.label = new Label();
/* 36 */     this.label.setLabelAlignment(2);
/* 37 */     this.label.setOpaque(true);
/* 38 */     this.label.setBackgroundColor(Display.getDefault().getSystemColor(1));
/* 39 */     updateConnection(connection);
/* 40 */     connection.add(this.label, new ConnectionLocator(connection, 4));
/*    */ 
/* 42 */     return connection;
/*    */   }
/*    */ 
/*    */   private void updateConnection(PolylineConnection connection) {
/* 46 */     ((RootModel)getRoot().getContents().getModel());
/* 47 */     ForeignKeyModel model = (ForeignKeyModel)getModel();
/* 48 */     ForeignKeyMapping[] mapping = model.getMapping();
/* 49 */     new StringBuffer();
/*    */ 
/* 63 */     if ((model.getForeignKeyColumn() != null) && 
/* 64 */       (model.getTargetIdColumn() != null)) {
/* 65 */       this.label.setText(model.getTargetIdColumn().getColumnName() + "=" + model.getForeignKeyColumn().getColumnName());
/*    */     }
/*    */ 
/* 68 */     connection.setLineStyle(2);
/* 69 */     for (int i = 0; i < mapping.length; i++) {
/* 70 */       if ((mapping[i].getRefer() != null) && (mapping[i].getRefer().isPrimaryKey())) {
/* 71 */         connection.setLineStyle(1);
/* 72 */         break;
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 77 */     int count = 0;
/*    */ 
/* 79 */     for (AbstractDBConnectionModel conn : model.getSource().getModelSourceConnections()) {
/* 80 */       if (conn == model) {
/*    */         break;
/*    */       }
/* 83 */       if (conn.getTarget() == model.getTarget()) {
/* 84 */         count++;
/*    */       }
/*    */     }
/*    */ 
/* 88 */     this.router.setDuplicationCount(count);
/*    */   }
/*    */ 
/*    */   protected void refreshVisuals() {
/* 92 */     super.refreshVisuals();
/* 93 */     updateConnection((PolylineConnection)getFigure());
/*    */   }
/*    */ 
/*    */   public void doubleClicked()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.ForeignKeyEditPart
 * JD-Core Version:    0.6.0
 */