/*     */ package org.hi.studio.hsceditor.visual.dialog;
/*     */ 
/*     */ import org.eclipse.jface.action.Action;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.jface.viewers.DoubleClickEvent;
/*     */ import org.eclipse.jface.viewers.IDoubleClickListener;
/*     */ import org.eclipse.jface.viewers.ISelection;
/*     */ import org.eclipse.jface.viewers.ISelectionChangedListener;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.jface.viewers.SelectionChangedEvent;
/*     */ import org.eclipse.jface.viewers.TreeViewer;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Tree;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.studio.core.tree.HiNameSorter;
/*     */ import org.hi.studio.core.tree.HiTreeObject;
/*     */ import org.hi.studio.core.tree.HiTreeParent;
/*     */ import org.hi.studio.core.tree.HiViewContentProvider;
/*     */ import org.hi.studio.core.tree.HiViewLabelProvider;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.hsceditor.util.HiServiceRender;
/*     */ 
/*     */ public class EntitySelectDialog extends Dialog
/*     */ {
/*     */   private TreeViewer viewer;
/*     */   private HiTreeObject treeObj;
/*     */   private Action doubleClickAction;
/*     */   private Action selectChangeAction;
/*     */   private boolean isExtend;
/*     */ 
/*     */   protected EntitySelectDialog(Shell parentShell, boolean isExtend)
/*     */   {
/*  46 */     super(parentShell);
/*     */ 
/*  48 */     this.isExtend = isExtend;
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize()
/*     */   {
/*  53 */     return new Point(400, 300);
/*     */   }
/*     */ 
/*     */   protected Control createButtonBar(Composite parent) {
/*  57 */     Control result = super.createButtonBar(parent);
/*  58 */     getButton(0).setEnabled(false);
/*     */ 
/*  60 */     return result;
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/*  66 */     Composite composite = new Composite(parent, 0);
/*  67 */     composite.setLayout(new GridLayout());
/*  68 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/*  70 */     this.viewer = new TreeViewer(composite, 770);
/*  71 */     this.viewer.setContentProvider(new HiViewContentProvider());
/*  72 */     this.viewer.setLabelProvider(new HiViewLabelProvider());
/*  73 */     this.viewer.setSorter(new HiNameSorter());
/*     */ 
/*  75 */     this.viewer.getTree().setLayoutData(new GridData(1808));
/*     */ 
/*  79 */     HiTreeParent root = HiServiceRender.renderServiceTree(HiProjectUtil.getCurrentProject(), false, this.isExtend);
/*     */ 
/*  82 */     this.viewer.setInput(root);
/*     */ 
/*  84 */     this.viewer.addDoubleClickListener(new IDoubleClickListener() {
/*     */       public void doubleClick(DoubleClickEvent event) {
/*  86 */         ISelection selection = EntitySelectDialog.this.viewer.getSelection();
/*  87 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/*  88 */         if ((obj instanceof HiTreeObject)) {
/*  89 */           if ((((HiTreeObject)obj).getTreeObj() instanceof Field)) {
/*  90 */             EntitySelectDialog.this.setTreeObj(((HiTreeObject)obj).getParent());
/*  91 */             EntitySelectDialog.this.close();
/*     */           }
/*     */ 
/*  94 */           if ((((HiTreeObject)obj).getTreeObj() instanceof Entity)) {
/*  95 */             EntitySelectDialog.this.setTreeObj((HiTreeObject)obj);
/*  96 */             EntitySelectDialog.this.close();
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/* 103 */     this.viewer.addSelectionChangedListener(new ISelectionChangedListener() {
/*     */       public void selectionChanged(SelectionChangedEvent event) {
/* 105 */         ISelection selection = EntitySelectDialog.this.viewer.getSelection();
/* 106 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/*     */ 
/* 108 */         if ((obj instanceof HiTreeObject))
/* 109 */           if (((((HiTreeObject)obj).getTreeObj() instanceof Field)) || 
/* 110 */             ((((HiTreeObject)obj).getTreeObj() instanceof Entity)))
/* 111 */             EntitySelectDialog.this.getButton(0).setEnabled(true);
/*     */           else
/* 113 */             EntitySelectDialog.this.getButton(0).setEnabled(false);
/*     */       }
/*     */     });
/* 120 */     return this.viewer.getControl();
/*     */   }
/*     */ 
/*     */   protected void okPressed() {
/* 124 */     ISelection selection = this.viewer.getSelection();
/*     */ 
/* 126 */     HiTreeObject obj = (HiTreeObject)((IStructuredSelection)selection).getFirstElement();
/* 127 */     setTreeObj(obj);
/*     */ 
/* 129 */     super.okPressed();
/*     */   }
/*     */ 
/*     */   public HiTreeObject getTreeObj() {
/* 133 */     return this.treeObj;
/*     */   }
/*     */ 
/*     */   public void setTreeObj(HiTreeObject treeObj) {
/* 137 */     this.treeObj = treeObj;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.EntitySelectDialog
 * JD-Core Version:    0.6.0
 */