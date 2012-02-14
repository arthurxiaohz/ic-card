/*    */ package org.hi.studio.core.tree;
/*    */ 
/*    */ import org.eclipse.jface.viewers.IStructuredContentProvider;
/*    */ import org.eclipse.jface.viewers.ITreeContentProvider;
/*    */ import org.eclipse.jface.viewers.Viewer;
/*    */ 
/*    */ public class HiViewContentProvider
/*    */   implements IStructuredContentProvider, ITreeContentProvider
/*    */ {
/*    */   public void inputChanged(Viewer v, Object oldInput, Object newInput)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void dispose()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Object[] getElements(Object parent)
/*    */   {
/* 27 */     if ((parent instanceof HiTreeParent)) {
/* 28 */       return ((HiTreeParent)parent).getChildren();
/*    */     }
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   public Object getParent(Object child)
/*    */   {
/* 36 */     if ((child instanceof HiTreeObject)) {
/* 37 */       return ((HiTreeObject)child).getParent();
/*    */     }
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   public Object[] getChildren(Object parent) {
/* 43 */     if ((parent instanceof HiTreeParent)) {
/* 44 */       return ((HiTreeParent)parent).getChildren();
/*    */     }
/* 46 */     return new Object[0];
/*    */   }
/*    */ 
/*    */   public boolean hasChildren(Object parent) {
/* 50 */     if ((parent instanceof HiTreeParent))
/* 51 */       return ((HiTreeParent)parent).hasChildren();
/* 52 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.tree.HiViewContentProvider
 * JD-Core Version:    0.6.0
 */