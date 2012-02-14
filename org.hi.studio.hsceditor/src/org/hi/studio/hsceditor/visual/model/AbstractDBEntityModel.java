/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.eclipse.draw2d.geometry.Rectangle;
/*    */ import org.eclipse.ui.views.properties.IPropertyDescriptor;
/*    */ import org.eclipse.ui.views.properties.IPropertySource;
/*    */ 
/*    */ public class AbstractDBEntityModel extends AbstractDBModel
/*    */   implements IPropertySource
/*    */ {
/*    */   private Rectangle constraint;
/* 13 */   private List<AbstractDBConnectionModel> sourceConnections = new ArrayList();
/* 14 */   private List<AbstractDBConnectionModel> targetConnections = new ArrayList();
/*    */   public static final String P_CONSTRAINT = "p_constraint";
/*    */   public static final String P_SOURCE_CONNECTION = "p_source_connection";
/*    */   public static final String P_TARGET_CONNECTION = "p_target_connection";
/*    */ 
/*    */   public Rectangle getConstraint()
/*    */   {
/* 21 */     return this.constraint;
/*    */   }
/*    */ 
/*    */   public void setConstraint(Rectangle constraint) {
/* 25 */     this.constraint = constraint;
/* 26 */     firePropertyChange("p_constraint", null, constraint);
/*    */   }
/*    */ 
/*    */   public Object getEditableValue()
/*    */   {
/* 38 */     return this;
/*    */   }
/*    */ 
/*    */   public IPropertyDescriptor[] getPropertyDescriptors() {
/* 42 */     return new IPropertyDescriptor[0];
/*    */   }
/*    */ 
/*    */   public Object getPropertyValue(Object id) {
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */   public boolean isPropertySet(Object id) {
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */   public void resetPropertyValue(Object id) {
/*    */   }
/*    */ 
/*    */   public void setPropertyValue(Object id, Object value) {
/*    */   }
/*    */ 
/*    */   public void addSourceConnection(AbstractDBConnectionModel connx) {
/* 60 */     this.sourceConnections.add(connx);
/* 61 */     firePropertyChange("p_source_connection", null, connx);
/*    */   }
/*    */ 
/*    */   public void addTargetConnection(AbstractDBConnectionModel connx) {
/* 65 */     this.targetConnections.add(connx);
/* 66 */     firePropertyChange("p_target_connection", null, connx);
/*    */   }
/*    */ 
/*    */   public List<AbstractDBConnectionModel> getModelSourceConnections() {
/* 70 */     return this.sourceConnections;
/*    */   }
/*    */ 
/*    */   public List<AbstractDBConnectionModel> getModelTargetConnections() {
/* 74 */     return this.targetConnections;
/*    */   }
/*    */ 
/*    */   public void removeSourceConnection(Object connx) {
/* 78 */     this.sourceConnections.remove(connx);
/* 79 */     firePropertyChange("p_source_connection", connx, null);
/*    */   }
/*    */ 
/*    */   public void removeTargetConnection(Object connx) {
/* 83 */     this.targetConnections.remove(connx);
/* 84 */     firePropertyChange("p_target_connection", connx, null);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel
 * JD-Core Version:    0.6.0
 */