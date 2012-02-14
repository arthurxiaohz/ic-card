/*     */ package org.hi.studio.hsceditor.visual.dialog;
/*     */ 
/*     */ import java.util.List;
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
/*     */ public class ServiceSelectDialog extends Dialog
/*     */ {
/*     */   private TreeViewer viewer;
/*     */   private List<HiTreeObject> treeObjects;
/*     */   private Action doubleClickAction;
/*     */   private Action selectChangeAction;
/*  43 */   private boolean isEnumeration = false;
/*     */ 
/*     */   protected ServiceSelectDialog(Shell parentShell, boolean isEnumeration) {
/*  46 */     super(parentShell);
/*  47 */     this.isEnumeration = isEnumeration;
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize()
/*     */   {
/*  52 */     return new Point(400, 300);
/*     */   }
/*     */ 
/*     */   protected Control createButtonBar(Composite parent) {
/*  56 */     Control result = super.createButtonBar(parent);
/*  57 */     getButton(0).setEnabled(false);
/*     */ 
/*  59 */     return result;
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/*  65 */     Composite composite = new Composite(parent, 0);
/*  66 */     composite.setLayout(new GridLayout());
/*  67 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/*  69 */     this.viewer = new TreeViewer(composite, 770);
/*  70 */     this.viewer.setContentProvider(new HiViewContentProvider());
/*  71 */     this.viewer.setLabelProvider(new HiViewLabelProvider());
/*  72 */     this.viewer.setSorter(new HiNameSorter());
/*     */ 
/*  74 */     this.viewer.getTree().setLayoutData(new GridData(1808));
/*     */ 
/*  78 */     HiTreeParent root = HiServiceRender.renderServiceTree(HiProjectUtil.getCurrentProject(), this.isEnumeration, false);
/*     */ 
/*  81 */     this.viewer.setInput(root);
/*     */ 
/*  83 */     this.viewer.addDoubleClickListener(new IDoubleClickListener() {
/*     */       public void doubleClick(DoubleClickEvent event) {
/*  85 */         ISelection selection = ServiceSelectDialog.this.viewer.getSelection();
/*  86 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/*  87 */         if (ServiceSelectDialog.this.isEnumeration) {
/*  88 */           if (((obj instanceof HiTreeObject)) && 
/*  89 */             ((((HiTreeObject)obj).getTreeObj() instanceof Entity))) {
/*  90 */             ServiceSelectDialog.this.setTreeObjects(((IStructuredSelection)selection).toList());
/*  91 */             ServiceSelectDialog.this.close();
/*     */           }
/*     */ 
/*     */         }
/*  96 */         else if (((obj instanceof HiTreeObject)) && 
/*  97 */           ((((HiTreeObject)obj).getTreeObj() instanceof Field))) {
/*  98 */           ServiceSelectDialog.this.setTreeObjects(((IStructuredSelection)selection).toList());
/*  99 */           ServiceSelectDialog.this.close();
/*     */         }
/*     */       }
/*     */     });
/* 108 */     this.viewer.addSelectionChangedListener(new ISelectionChangedListener() {
/*     */       public void selectionChanged(SelectionChangedEvent event) {
/* 110 */         ISelection selection = ServiceSelectDialog.this.viewer.getSelection();
/* 111 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/*     */ 
/* 113 */         if ((obj instanceof HiTreeObject))
/* 114 */           if (ServiceSelectDialog.this.isEnumeration) {
/* 115 */             if ((((HiTreeObject)obj).getTreeObj() instanceof Entity))
/* 116 */               ServiceSelectDialog.this.getButton(0).setEnabled(true);
/*     */             else {
/* 118 */               ServiceSelectDialog.this.getButton(0).setEnabled(false);
/*     */             }
/*     */           }
/* 121 */           else if ((((HiTreeObject)obj).getTreeObj() instanceof Field))
/* 122 */             ServiceSelectDialog.this.getButton(0).setEnabled(true);
/*     */           else
/* 124 */             ServiceSelectDialog.this.getButton(0).setEnabled(false);
/*     */       }
/*     */     });
/* 132 */     return this.viewer.getControl();
/*     */   }
/*     */ 
/*     */   protected void okPressed() {
/* 136 */     ISelection selection = this.viewer.getSelection();
/* 137 */     setTreeObjects(((IStructuredSelection)selection).toList());
/* 138 */     super.okPressed();
/*     */   }
/*     */ 
/*     */   public List<HiTreeObject> getTreeObjects() {
/* 142 */     return this.treeObjects;
/*     */   }
/*     */ 
/*     */   public void setTreeObjects(List<HiTreeObject> treeObjects) {
/* 146 */     this.treeObjects = treeObjects;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.ServiceSelectDialog
 * JD-Core Version:    0.6.0
 */