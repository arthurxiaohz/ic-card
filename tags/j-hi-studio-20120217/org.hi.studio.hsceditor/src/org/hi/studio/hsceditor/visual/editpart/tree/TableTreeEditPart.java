/*     */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*     */ 
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.RootEditPart;
/*     */ import org.eclipse.gef.editparts.AbstractEditPart;
/*     */ import org.eclipse.jface.resource.CompositeImageDescriptor;
/*     */ import org.eclipse.jface.resource.ImageRegistry;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.editpart.TableEditPart;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class TableTreeEditPart extends AbstractDBTreeEditPart
/*     */ {
/*     */   private static final String IMAGE_TABLE_ERROR = "image_table_error";
/*     */   private static final String IMAGE_TABLE_WARNING = "image_table_warning";
/*     */ 
/*     */   static
/*     */   {
/*  54 */     DBPlugin.getDefault().getImageRegistry().put("image_table_error", 
/*  55 */       new OverlayImageDescriptor("icons/table.gif", "icons/ovr_error.gif"));
/*     */ 
/*  57 */     DBPlugin.getDefault().getImageRegistry().put("image_table_warning", 
/*  58 */       new OverlayImageDescriptor("icons/table.gif", "icons/ovr_warning.gif"));
/*     */   }
/*     */ 
/*     */   protected List<Object> getModelChildren() {
/*  62 */     List list = new ArrayList();
/*  63 */     ColumnModel[] columns = ((TableModel)getModel()).getColumns();
/*  64 */     for (int i = 0; i < columns.length; i++) {
/*  65 */       list.add(columns[i]);
/*     */     }
/*  67 */     list.add(new FolderTreeEditPart.FolderModel(DBPlugin.getResourceString("label.index"), null) {
/*     */       public void doEdit() {
/*  69 */         TableModel table = (TableModel)TableTreeEditPart.this.getModel();
/*  70 */         if (table.isLinkedTable()) {
/*  71 */           UIUtils.openAlertDialog(DBPlugin.getResourceString("error.edit.linkedTable"));
/*  72 */           return;
/*     */         }
/*  74 */         TableEditPart.openTableEditDialog(
/*  75 */           TableTreeEditPart.this.getViewer(), table, (RootModel)TableTreeEditPart.this.getRoot().getContents().getModel(), 
/*  76 */           null);
/*     */       }
/*     */ 
/*     */       public List<?> getChildren() {
/*  80 */         IndexModel[] indices = ((TableModel)TableTreeEditPart.this.getModel()).getIndices();
/*  81 */         List list = new ArrayList();
/*  82 */         for (IndexModel indexModel : indices) {
/*  83 */           list.add(indexModel);
/*     */         }
/*  85 */         return list;
/*     */       }
/*     */     });
/*  88 */     return list;
/*     */   }
/*     */ 
/*     */   protected void refreshVisuals() {
/*  92 */     TableModel model = (TableModel)getModel();
/*  93 */     setWidgetText(model.getTableName() + "(" + model.getLogicalName() + ")");
/*     */ 
/*  95 */     if (model.getError().length() == 0)
/*  96 */       setWidgetImage(DBPlugin.getImage("icons/table.gif"));
/*  97 */     else if (model.getError().indexOf("[ERROR]") >= 0)
/*  98 */       setWidgetImage(DBPlugin.getImage("image_table_error"));
/*     */     else {
/* 100 */       setWidgetImage(DBPlugin.getImage("image_table_warning"));
/*     */     }
/*     */ 
/* 104 */     List children = getChildren();
/* 105 */     for (AbstractEditPart child : children)
/* 106 */       child.refresh();
/*     */   }
/*     */ 
/*     */   public void propertyChange(PropertyChangeEvent evt)
/*     */   {
/* 111 */     super.propertyChange(evt);
/* 112 */     String propName = evt.getPropertyName();
/* 113 */     TableModel model = (TableModel)getModel();
/*     */ 
/* 115 */     if (("p_logical_name".equals(propName)) || 
/* 116 */       ("p_table_name".equals(propName))) {
/* 117 */       setWidgetText(model.getTableName() + "(" + model.getLogicalName() + ")");
/*     */     }
/* 119 */     else if ("p_error".equals(propName)) {
/* 120 */       refreshVisuals();
/*     */     }
/* 122 */     if (("p_columns".equals(propName)) || ("p_indices".equals(propName))) {
/* 123 */       refreshChildren();
/*     */ 
/* 125 */       List children = getChildren();
/* 126 */       for (AbstractEditPart child : children)
/* 127 */         child.refresh();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static class OverlayImageDescriptor extends CompositeImageDescriptor
/*     */   {
/*     */     private String baseImageKey;
/*     */     private String overlayImageKey;
/*     */ 
/*     */     public OverlayImageDescriptor(String baseImageKey, String overlayImageKey)
/*     */     {
/*  35 */       this.baseImageKey = baseImageKey;
/*  36 */       this.overlayImageKey = overlayImageKey;
/*     */     }
/*     */ 
/*     */     protected void drawCompositeImage(int arg0, int arg1) {
/*  40 */       Image baseImage = DBPlugin.getImage(this.baseImageKey);
/*  41 */       drawImage(baseImage.getImageData(), 0, 0);
/*     */ 
/*  43 */       Image overlayImage = DBPlugin.getImage(this.overlayImageKey);
/*  44 */       drawImage(overlayImage.getImageData(), 0, 8);
/*     */     }
/*     */ 
/*     */     protected Point getSize() {
/*  48 */       return new Point(16, 16);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.TableTreeEditPart
 * JD-Core Version:    0.6.0
 */