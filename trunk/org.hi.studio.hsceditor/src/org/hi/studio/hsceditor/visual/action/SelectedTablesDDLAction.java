/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.jface.dialogs.Dialog;
/*    */ import org.eclipse.jface.dialogs.IDialogConstants;
/*    */ import org.eclipse.jface.viewers.ISelection;
/*    */ import org.eclipse.jface.viewers.IStructuredSelection;
/*    */ import org.eclipse.swt.graphics.Point;
/*    */ import org.eclipse.swt.layout.GridData;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.swt.widgets.Control;
/*    */ import org.eclipse.swt.widgets.Display;
/*    */ import org.eclipse.swt.widgets.Shell;
/*    */ import org.eclipse.swt.widgets.Text;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*    */ import org.hi.studio.hsceditor.dialect.IDialect;
/*    */ import org.hi.studio.hsceditor.visual.editpart.TableEditPart;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class SelectedTablesDDLAction extends AbstractDBAction
/*    */ {
/*    */   public SelectedTablesDDLAction(GraphicalViewer viewer)
/*    */   {
/* 29 */     super(DBPlugin.getResourceString("action.selectedTablesDDL"), viewer);
/*    */   }
/*    */ 
/*    */   public void run() {
/* 33 */     ISelection sel = getViewer().getSelection();
/* 34 */     if ((sel instanceof IStructuredSelection)) {
/* 35 */       List tableModels = new ArrayList();
/* 36 */       Object[] selected = ((IStructuredSelection)sel).toArray();
/* 37 */       for (Object obj : selected) {
/* 38 */         if ((obj instanceof TableEditPart)) {
/* 39 */           tableModels.add((TableModel)((TableEditPart)obj).getModel());
/*    */         }
/*    */       }
/*    */ 
/* 43 */       RootModel root = (RootModel)getViewer().getContents().getModel();
/* 44 */       IDialect dialect = DialectProvider.getDialect(root.getDialectName());
/*    */ 
/* 46 */       StringBuilder sb = new StringBuilder();
/*    */ 
/* 48 */       if (tableModels.isEmpty()) {
/* 49 */         sb.append(dialect.createDDL(root, false, false, true, true));
/*    */       }
/*    */       else {
/* 52 */         StringBuilder additions = new StringBuilder();
/* 53 */         for (TableModel tableModel : tableModels) {
/* 54 */           sb.append(dialect.createTableDDL(root, tableModel, 
/* 55 */             false, false, true, true, additions));
/*    */         }
/* 57 */         if (additions.length() > 0) {
/* 58 */           sb.append(System.getProperty("line.separator"));
/* 59 */           sb.append(additions.toString());
/*    */         }
/*    */       }
/*    */ 
/* 63 */       DDLDisplayDialog dialog = new DDLDisplayDialog(
/* 64 */         Display.getDefault().getActiveShell(), sb.toString());
/* 65 */       dialog.open();
/*    */     }
/*    */   }
/*    */ 
/*    */   private class DDLDisplayDialog extends Dialog {
/*    */     private String ddl;
/*    */ 
/*    */     protected DDLDisplayDialog(Shell parentShell, String ddl) {
/* 74 */       super();
/* 75 */       this.ddl = ddl;
/* 76 */       setShellStyle(getShellStyle() | 0x10);
/*    */     }
/*    */ 
/*    */     protected Point getInitialSize() {
/* 80 */       return new Point(600, 450);
/*    */     }
/*    */ 
/*    */     protected Control createDialogArea(Composite parent) {
/* 84 */       getShell().setText("DDL");
/*    */ 
/* 86 */       Text text = new Text(parent, 2818);
/* 87 */       text.setLayoutData(new GridData(1808));
/* 88 */       text.setText(this.ddl);
/* 89 */       text.setEditable(false);
/* 90 */       return text;
/*    */     }
/*    */ 
/*    */     protected void createButtonsForButtonBar(Composite parent) {
/* 94 */       createButton(parent, 0, IDialogConstants.OK_LABEL, true);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.SelectedTablesDDLAction
 * JD-Core Version:    0.6.0
 */