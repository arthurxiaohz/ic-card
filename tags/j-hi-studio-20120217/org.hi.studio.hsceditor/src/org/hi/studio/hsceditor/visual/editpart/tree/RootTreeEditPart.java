/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBOutlinePage;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class RootTreeEditPart extends AbstractDBTreeEditPart
/*    */ {
/*    */   protected List<FolderTreeEditPart.FolderModel> getModelChildren()
/*    */   {
/* 20 */     List children = new ArrayList();
/* 21 */     children.add(new FolderTreeEditPart.FolderModel(DBPlugin.getResourceString("Hi Entity"), (RootModel)getModel()) {
/*    */       public List<?> getChildren() {
/* 23 */         String filterText = VisualDBOutlinePage.getFilterText();
/* 24 */         if (filterText.length() == 0) {
/* 25 */           return this.root.getChildren();
/*    */         }
/*    */ 
/* 28 */         List result = new ArrayList();
/* 29 */         for (AbstractDBEntityModel entity : this.root.getChildren()) {
/* 30 */           if ((!(entity instanceof TableModel)) || 
/* 31 */             (!((TableModel)entity).getTableName().startsWith(filterText))) continue;
/* 32 */           result.add(entity);
/*    */         }
/*    */ 
/* 36 */         return result;
/*    */       }
/*    */ 
/*    */       public void doEdit()
/*    */       {
/*    */       }
/*    */     });
/* 53 */     return children;
/*    */   }
/*    */ 
/*    */   public void propertyChange(PropertyChangeEvent evt) {
/* 57 */     String propName = evt.getPropertyName();
/* 58 */     if (("p_children".equals(propName)) || ("p_dommains".equals(propName)))
/* 59 */       refreshChildren();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.RootTreeEditPart
 * JD-Core Version:    0.6.0
 */