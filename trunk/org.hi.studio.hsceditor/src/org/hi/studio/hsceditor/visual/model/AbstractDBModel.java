/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyChangeSupport;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public abstract class AbstractDBModel
/*    */   implements Serializable
/*    */ {
/*  9 */   private PropertyChangeSupport listeners = new PropertyChangeSupport(this);
/*    */ 
/*    */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/* 12 */     this.listeners.addPropertyChangeListener(listener);
/*    */   }
/*    */ 
/*    */   public void firePropertyChange(String propName, Object oldValue, Object newValue) {
/* 16 */     this.listeners.firePropertyChange(propName, oldValue, newValue);
/*    */   }
/*    */ 
/*    */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 20 */     this.listeners.removePropertyChangeListener(listener);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.AbstractDBModel
 * JD-Core Version:    0.6.0
 */