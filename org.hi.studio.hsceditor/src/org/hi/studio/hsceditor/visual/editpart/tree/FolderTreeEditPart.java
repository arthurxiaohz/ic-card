/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class FolderTreeEditPart extends AbstractDBTreeEditPart
/*    */ {
/*    */   protected List<?> getModelChildren()
/*    */   {
/* 11 */     FolderModel model = (FolderModel)getModel();
/* 12 */     return model.getChildren();
/*    */   }
/*    */ 
/*    */   protected void refreshVisuals() {
/* 16 */     FolderModel model = (FolderModel)getModel();
/* 17 */     setWidgetText(model.name);
/* 18 */     setWidgetImage(DBPlugin.getImage("icons/folder.gif"));
/*    */   }
/*    */ 
/*    */   public static abstract class FolderModel
/*    */   {
/*    */     public String name;
/*    */     public RootModel root;
/*    */ 
/*    */     public FolderModel(String name, RootModel root)
/*    */     {
/* 32 */       this.name = name;
/* 33 */       this.root = root;
/*    */     }
/*    */ 
/*    */     public abstract List<?> getChildren();
/*    */ 
/*    */     public abstract void doEdit();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.FolderTreeEditPart
 * JD-Core Version:    0.6.0
 */