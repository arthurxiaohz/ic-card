/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.eclipse.ui.views.properties.IPropertyDescriptor;
/*    */ import org.eclipse.ui.views.properties.IPropertySource;
/*    */ 
/*    */ public class AbstractDBConnectionModel extends AbstractDBModel
/*    */   implements IPropertySource
/*    */ {
/*    */   private AbstractDBEntityModel source;
/*    */   private AbstractDBEntityModel target;
/*    */ 
/*    */   public void attachSource()
/*    */   {
/* 12 */     if (!this.source.getModelSourceConnections().contains(this))
/* 13 */       this.source.addSourceConnection(this);
/*    */   }
/*    */ 
/*    */   public void attachTarget()
/*    */   {
/* 18 */     if (!this.target.getModelTargetConnections().contains(this))
/* 19 */       this.target.addTargetConnection(this);
/*    */   }
/*    */ 
/*    */   public void detachSource()
/*    */   {
/* 24 */     if (this.source != null)
/* 25 */       this.source.removeSourceConnection(this);
/*    */   }
/*    */ 
/*    */   public void detachTarget()
/*    */   {
/* 30 */     if (this.target != null)
/* 31 */       this.target.removeTargetConnection(this);
/*    */   }
/*    */ 
/*    */   public AbstractDBEntityModel getSource()
/*    */   {
/* 36 */     return this.source;
/*    */   }
/*    */ 
/*    */   public AbstractDBEntityModel getTarget() {
/* 40 */     return this.target;
/*    */   }
/*    */ 
/*    */   public void setSource(AbstractDBEntityModel model) {
/* 44 */     this.source = model;
/*    */   }
/*    */ 
/*    */   public void setTarget(AbstractDBEntityModel model) {
/* 48 */     this.target = model;
/*    */   }
/*    */ 
/*    */   public Object getEditableValue() {
/* 52 */     return this;
/*    */   }
/*    */ 
/*    */   public IPropertyDescriptor[] getPropertyDescriptors() {
/* 56 */     return new IPropertyDescriptor[0];
/*    */   }
/*    */ 
/*    */   public Object getPropertyValue(Object id) {
/* 60 */     return null;
/*    */   }
/*    */ 
/*    */   public boolean isPropertySet(Object id) {
/* 64 */     return false;
/*    */   }
/*    */ 
/*    */   public void resetPropertyValue(Object id)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void setPropertyValue(Object id, Object value)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel
 * JD-Core Version:    0.6.0
 */