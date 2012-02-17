/*    */ package org.hi.studio.core.tree;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class HiTreeParent extends HiTreeObject
/*    */ {
/*    */   private ArrayList children;
/*    */ 
/*    */   public HiTreeParent(String name)
/*    */   {
/*  8 */     super(name);
/*  9 */     this.children = new ArrayList();
/*    */   }
/*    */   public void addChild(HiTreeObject child) {
/* 12 */     this.children.add(child);
/* 13 */     child.setParent(this);
/*    */   }
/*    */   public void removeChild(HiTreeObject child) {
/* 16 */     this.children.remove(child);
/* 17 */     child.setParent(null);
/*    */   }
/*    */   public HiTreeObject[] getChildren() {
/* 20 */     return (HiTreeObject[])this.children.toArray(new HiTreeObject[this.children.size()]);
/*    */   }
/*    */   public boolean hasChildren() {
/* 23 */     return this.children.size() > 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.tree.HiTreeParent
 * JD-Core Version:    0.6.0
 */