/*    */ package org.hi.studio.hsceditor.visual.dialog;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.eclipse.jface.dialogs.Dialog;
/*    */ import org.eclipse.jface.viewers.ArrayContentProvider;
/*    */ import org.eclipse.jface.viewers.ILabelProviderListener;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ import org.eclipse.jface.viewers.ITableLabelProvider;
/*    */ import org.eclipse.jface.viewers.TableViewer;
/*    */ import org.eclipse.swt.graphics.Image;
/*    */ import org.eclipse.swt.graphics.Point;
/*    */ import org.eclipse.swt.layout.GridData;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.swt.widgets.Control;
/*    */ import org.eclipse.swt.widgets.Shell;
/*    */ import org.eclipse.swt.widgets.Table;
/*    */ import org.hi.studio.hsceditor.dialect.IColumnType;
/*    */ import org.hi.studio.hsceditor.util.UIUtils;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ 
/*    */ public class ColumnSelectDialog extends Dialog
/*    */ {
/*    */   private List<ColumnModel> columns;
/*    */   private ColumnModel selectedColumn;
/*    */   private TableViewer viewer;
/*    */ 
/*    */   public ColumnSelectDialog(Shell parentShell, List<ColumnModel> columns)
/*    */   {
/* 31 */     super(parentShell);
/* 32 */     this.columns = columns;
/*    */   }
/*    */ 
/*    */   protected Point getInitialSize()
/*    */   {
/* 37 */     return new Point(400, 300);
/*    */   }
/*    */ 
/*    */   protected Control createDialogArea(Composite parent) {
/* 41 */     this.viewer = new TableViewer(parent, 65540);
/* 42 */     Table table = this.viewer.getTable();
/* 43 */     table.setLinesVisible(true);
/* 44 */     table.setHeaderVisible(true);
/*    */ 
/* 46 */     UIUtils.createColumn(table, "dialog.table.columnName", 150, false);
/* 47 */     UIUtils.createColumn(table, "dialog.table.columnType", 150, false);
/*    */ 
/* 49 */     this.viewer.getControl().setLayoutData(new GridData(1808));
/* 50 */     this.viewer.setContentProvider(new ArrayContentProvider());
/* 51 */     this.viewer.setLabelProvider(new ITableLabelProvider()
/*    */     {
/*    */       public Image getColumnImage(Object element, int columnIndex) {
/* 54 */         return null;
/*    */       }
/*    */ 
/*    */       public String getColumnText(Object element, int columnIndex) {
/* 58 */         ColumnModel column = (ColumnModel)element;
/* 59 */         if (columnIndex == 0)
/* 60 */           return column.getColumnName();
/* 61 */         if (columnIndex == 1) {
/* 62 */           StringBuilder sb = new StringBuilder();
/* 63 */           sb.append(column.getColumnType().getName());
/* 64 */           if (column.getColumnType().supportSize()) {
/* 65 */             sb.append("(").append(column).append(")");
/*    */           }
/* 67 */           return sb.toString();
/*    */         }
/* 69 */         return null;
/*    */       }
/*    */ 
/*    */       public void addListener(ILabelProviderListener listener) {
/*    */       }
/*    */ 
/*    */       public void dispose() {
/*    */       }
/*    */ 
/*    */       public boolean isLabelProperty(Object element, String property) {
/* 79 */         return false;
/*    */       }
/*    */ 
/*    */       public void removeListener(ILabelProviderListener listener)
/*    */       {
/*    */       }
/*    */     });
/* 85 */     this.viewer.setInput(this.columns);
/*    */ 
/* 87 */     return this.viewer.getControl();
/*    */   }
/*    */ 
/*    */   protected void okPressed() {
/* 91 */     this.selectedColumn = ((ColumnModel)((IStructuredSelection)this.viewer.getSelection()).getFirstElement());
/* 92 */     super.okPressed();
/*    */   }
/*    */ 
/*    */   public ColumnModel getSelectedColumn() {
/* 96 */     return this.selectedColumn;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.ColumnSelectDialog
 * JD-Core Version:    0.6.0
 */