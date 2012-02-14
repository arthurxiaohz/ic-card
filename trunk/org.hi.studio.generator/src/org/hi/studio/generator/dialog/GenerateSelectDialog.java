/*     */ package org.hi.studio.generator.dialog;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.jface.viewers.CheckboxTableViewer;
/*     */ import org.eclipse.jface.viewers.IStructuredContentProvider;
/*     */ import org.eclipse.jface.viewers.ITableLabelProvider;
/*     */ import org.eclipse.jface.viewers.LabelProvider;
/*     */ import org.eclipse.jface.viewers.Viewer;
/*     */ import org.eclipse.jface.viewers.ViewerSorter;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Table;
/*     */ import org.eclipse.ui.ISharedImages;
/*     */ import org.eclipse.ui.IWorkbench;
/*     */ import org.eclipse.ui.PlatformUI;
/*     */ import org.hi.generator.ant.GenBaseDataTask;
/*     */ import org.hi.generator.ant.GenDLLTask;
/*     */ import org.hi.generator.ant.GenJavaTask;
/*     */ import org.hi.generator.ant.GenORMTask;
/*     */ import org.hi.generator.ant.GenPageTask;
/*     */ import org.hi.generator.ant.GenSecurityTask;
/*     */ import org.hi.generator.ant.GenSpringContextTask;
/*     */ import org.hi.generator.ant.GenTestTask;
/*     */ import org.hi.generator.ant.GenViewConfigTask;
/*     */ import org.hi.generator.ant.HiGeneraterToolTask;
/*     */ import org.hi.generator.ant.HiTask;
/*     */ 
/*     */ public class GenerateSelectDialog extends Dialog
/*     */ {
/*     */   private CheckboxTableViewer viewer;
/*     */   private HiGeneraterToolTask tasks;
/*     */ 
/*     */   public HiGeneraterToolTask getTasks()
/*     */   {
/*  88 */     return this.tasks;
/*     */   }
/*     */ 
/*     */   public void setTasks(HiGeneraterToolTask tasks) {
/*  92 */     this.tasks = tasks;
/*     */   }
/*     */ 
/*     */   public GenerateSelectDialog(Shell parentShell) {
/*  96 */     super(parentShell);
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize()
/*     */   {
/* 101 */     return new Point(400, 300);
/*     */   }
/*     */ 
/*     */   protected Control createButtonBar(Composite parent) {
/* 105 */     Control result = super.createButtonBar(parent);
/*     */ 
/* 108 */     return result;
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/* 114 */     Composite composite = new Composite(parent, 0);
/*     */ 
/* 116 */     GridLayout layout = new GridLayout();
/* 117 */     layout.numColumns = 2;
/* 118 */     composite.setLayout(layout);
/* 119 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/* 121 */     this.viewer = CheckboxTableViewer.newCheckList(composite, 770);
/* 122 */     this.viewer.setContentProvider(new ViewContentProvider());
/* 123 */     this.viewer.setLabelProvider(new ViewLabelProvider());
/* 124 */     this.viewer.setSorter(new NameSorter());
/* 125 */     this.viewer.setInput("");
/*     */ 
/* 127 */     this.viewer.getTable().setLayoutData(new GridData(1808));
/*     */ 
/* 130 */     this.viewer.setAllChecked(false);
/*     */ 
/* 132 */     Composite compositeButton = new Composite(composite, 0);
/* 133 */     layout = new GridLayout();
/* 134 */     layout.numColumns = 1;
/* 135 */     compositeButton.setLayout(layout);
/*     */ 
/* 137 */     Button bok = new Button(compositeButton, 0);
/* 138 */     bok.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e)
/*     */       {
/* 143 */         GenerateSelectDialog.this.viewer.setAllChecked(true);
/* 144 */         super.widgetSelected(e);
/*     */       }
/*     */     });
/* 149 */     bok.setText("全部");
/* 150 */     Button bcl = new Button(compositeButton, 0);
/*     */ 
/* 152 */     bcl.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e)
/*     */       {
/* 157 */         GenerateSelectDialog.this.viewer.setAllChecked(false);
/* 158 */         super.widgetSelected(e);
/*     */       }
/*     */     });
/* 162 */     bcl.setText("取消");
/*     */ 
/* 164 */     return this.viewer.getControl();
/*     */   }
/*     */ 
/*     */   protected void okPressed()
/*     */   {
/* 169 */     Object[] tasks = this.viewer.getCheckedElements();
/* 170 */     for (int i = 0; i < tasks.length; i++) {
/* 171 */       getTasks().generators.add(tasks[i]);
/*     */     }
/*     */ 
/* 174 */     super.okPressed();
/*     */   }
/*     */ 
/*     */   class NameSorter extends ViewerSorter
/*     */   {
/*     */     NameSorter()
/*     */     {
/*     */     }
/*     */ 
/*     */     public int compare(Viewer viewer, Object e1, Object e2)
/*     */     {
/*  76 */       HiTask obj1 = (HiTask)e1;
/*  77 */       HiTask obj2 = (HiTask)e2;
/*     */ 
/*  79 */       return super.compare(viewer, obj1.getSort(), obj2.getSort());
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
/*  44 */       return new HiTask[] { new GenBaseDataTask(GenerateSelectDialog.this.getTasks()), 
/*  45 */         new GenSpringContextTask(GenerateSelectDialog.this.getTasks()), 
/*  46 */         new GenDLLTask(GenerateSelectDialog.this.getTasks()), 
/*  47 */         new GenJavaTask(GenerateSelectDialog.this.getTasks()), 
/*  48 */         new GenORMTask(GenerateSelectDialog.this.getTasks()), 
/*  49 */         new GenPageTask(GenerateSelectDialog.this.getTasks()), 
/*  50 */         new GenSecurityTask(GenerateSelectDialog.this.getTasks()), 
/*  51 */         new GenViewConfigTask(GenerateSelectDialog.this.getTasks()), 
/*  52 */         new GenTestTask(GenerateSelectDialog.this.getTasks()) };
/*     */     }
/*     */   }
/*     */ 
/*     */   class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
/*     */     ViewLabelProvider() {
/*     */     }
/*     */ 
/*     */     public String getColumnText(Object obj, int index) {
/*  60 */       return ((HiTask)obj).getName();
/*     */     }
/*     */ 
/*     */     public Image getColumnImage(Object obj, int index)
/*     */     {
/*  65 */       return getImage(obj);
/*     */     }
/*     */     public Image getImage(Object obj) {
/*  68 */       return PlatformUI.getWorkbench()
/*  69 */         .getSharedImages().getImage("IMG_OBJ_ELEMENTS");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.dialog.GenerateSelectDialog
 * JD-Core Version:    0.6.0
 */