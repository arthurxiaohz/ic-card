/*     */ package org.hi.studio.project.dialog;
/*     */ 
/*     */ import org.eclipse.jface.action.Action;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.jface.viewers.CheckboxTableViewer;
/*     */ import org.eclipse.jface.viewers.IStructuredContentProvider;
/*     */ import org.eclipse.jface.viewers.ITableLabelProvider;
/*     */ import org.eclipse.jface.viewers.LabelProvider;
/*     */ import org.eclipse.jface.viewers.Viewer;
/*     */ import org.eclipse.jface.viewers.ViewerSorter;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Table;
/*     */ import org.eclipse.ui.ISharedImages;
/*     */ import org.eclipse.ui.IWorkbench;
/*     */ import org.eclipse.ui.PlatformUI;
/*     */ 
/*     */ public class GenerateSelectDialog extends Dialog
/*     */ {
/*     */   private CheckboxTableViewer viewer;
/*     */   private Action doubleClickAction;
/*     */   private Action selectChangeAction;
/*     */ 
/*     */   public GenerateSelectDialog(Shell parentShell)
/*     */   {
/*  65 */     super(parentShell);
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize()
/*     */   {
/*  70 */     return new Point(400, 300);
/*     */   }
/*     */ 
/*     */   protected Control createButtonBar(Composite parent) {
/*  74 */     Control result = super.createButtonBar(parent);
/*     */ 
/*  77 */     return result;
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/*  83 */     Composite composite = new Composite(parent, 0);
/*  84 */     composite.setLayout(new GridLayout());
/*  85 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/*  87 */     this.viewer = CheckboxTableViewer.newCheckList(composite, 770);
/*  88 */     this.viewer.setContentProvider(new ViewContentProvider());
/*  89 */     this.viewer.setLabelProvider(new ViewLabelProvider());
/*  90 */     this.viewer.setSorter(new NameSorter());
/*  91 */     this.viewer.setInput("");
/*     */ 
/*  93 */     this.viewer.getTable().setLayoutData(new GridData(1808));
/*     */ 
/* 126 */     return this.viewer.getControl();
/*     */   }
/*     */ 
/*     */   protected void okPressed()
/*     */   {
/* 134 */     super.okPressed();
/*     */   }
/*     */ 
/*     */   class NameSorter extends ViewerSorter
/*     */   {
/*     */     NameSorter()
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   class ViewContentProvider
/*     */     implements IStructuredContentProvider
/*     */   {
/*     */     ViewContentProvider()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void inputChanged(Viewer v, Object oldInput, Object newInput)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void dispose()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Object[] getElements(Object parent)
/*     */     {
/*  40 */       return new String[] { "One", "Two", "Three" };
/*     */     }
/*     */   }
/*     */   class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
/*     */     ViewLabelProvider() {
/*     */     }
/*  45 */     public String getColumnText(Object obj, int index) { return getText(obj); }
/*     */ 
/*     */     public Image getColumnImage(Object obj, int index) {
/*  48 */       return getImage(obj);
/*     */     }
/*     */     public Image getImage(Object obj) {
/*  51 */       return PlatformUI.getWorkbench()
/*  52 */         .getSharedImages().getImage("IMG_OBJ_ELEMENTS");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.dialog.GenerateSelectDialog
 * JD-Core Version:    0.6.0
 */