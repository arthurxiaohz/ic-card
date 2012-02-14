/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import org.eclipse.gef.commands.Command;
/*    */ import org.eclipse.gef.editparts.AbstractConnectionEditPart;
/*    */ import org.eclipse.gef.editpolicies.ComponentEditPolicy;
/*    */ import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
/*    */ import org.eclipse.gef.requests.GroupRequest;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBModel;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public abstract class AbstractDBConnectionEditPart extends AbstractConnectionEditPart
/*    */   implements PropertyChangeListener, IDoubleClickSupport
/*    */ {
/*    */   protected void createEditPolicies()
/*    */   {
/* 22 */     installEditPolicy("ComponentEditPolicy", new EntityComponentEditPolicy(null));
/* 23 */     installEditPolicy("Connection Endpoint Policy", new ConnectionEndpointEditPolicy());
/*    */   }
/*    */ 
/*    */   public void activate()
/*    */   {
/* 28 */     super.activate();
/* 29 */     ((AbstractDBModel)getModel()).addPropertyChangeListener(this);
/*    */   }
/*    */ 
/*    */   public void deactivate() {
/* 33 */     super.deactivate();
/* 34 */     ((AbstractDBModel)getModel()).removePropertyChangeListener(this);
/*    */   }
/*    */ 
/*    */   public void propertyChange(PropertyChangeEvent evt)
/*    */   {
/* 86 */     refreshVisuals();
/*    */   }
/*    */ 
/*    */   public void doubleClicked()
/*    */   {
/*    */   }
/*    */ 
/*    */   private class DeleteCommand extends Command
/*    */   {
/*    */     private AbstractDBConnectionModel model;
/*    */ 
/*    */     private DeleteCommand()
/*    */     {
/*    */     }
/*    */ 
/*    */     public void setModel(AbstractDBConnectionModel model)
/*    */     {
/* 55 */       this.model = model;
/*    */     }
/*    */ 
/*    */     public void execute()
/*    */     {
/* 61 */       ColumnModel column = ((ForeignKeyModel)this.model).getForeignKeyColumn();
/* 62 */       TableModel sourceTableModel = (TableModel)this.model.getSource();
/*    */ 
/* 64 */       ColumnModel[] oldColumns = sourceTableModel.getColumns();
/* 65 */       ColumnModel[] newColumns = new ColumnModel[oldColumns.length - 1];
/* 66 */       int j = 0;
/* 67 */       for (int i = 0; i < oldColumns.length; i++)
/*    */       {
/* 69 */         if (!oldColumns[i].getColumnName().equals(column.getColumnName())) {
/* 70 */           newColumns[j] = oldColumns[i].toNewColumn();
/* 71 */           j++;
/*    */         }
/*    */       }
/*    */ 
/* 75 */       sourceTableModel.setColumns(newColumns);
/*    */ 
/* 77 */       this.model.detachSource();
/* 78 */       this.model.detachTarget();
/*    */     }
/*    */   }
/*    */ 
/*    */   private class EntityComponentEditPolicy extends ComponentEditPolicy
/*    */   {
/*    */     private EntityComponentEditPolicy()
/*    */     {
/*    */     }
/*    */ 
/*    */     protected Command createDeleteCommand(GroupRequest deleteRequest)
/*    */     {
/* 42 */       AbstractDBConnectionEditPart.DeleteCommand command = new AbstractDBConnectionEditPart.DeleteCommand(AbstractDBConnectionEditPart.this, null);
/* 43 */       command.setModel((AbstractDBConnectionModel)AbstractDBConnectionEditPart.this.getModel());
/* 44 */       return command;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.AbstractDBConnectionEditPart
 * JD-Core Version:    0.6.0
 */