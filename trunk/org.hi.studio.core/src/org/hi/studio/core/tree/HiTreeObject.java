/*    */ package org.hi.studio.core.tree;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.eclipse.core.resources.IProject;
/*    */ import org.eclipse.core.runtime.PlatformObject;
/*    */ import org.hi.studio.core.constants.ImageConstants;
/*    */ 
/*    */ public class HiTreeObject extends PlatformObject
/*    */ {
/*    */   private String name;
/*    */   private HiTreeParent parent;
/* 14 */   private String imagePath = ImageConstants.IMAGE_ERROR;
/*    */   private Object treeObj;
/*    */ 
/*    */   public String getImagePath()
/*    */   {
/* 17 */     return this.imagePath;
/*    */   }
/*    */ 
/*    */   public void setImagePath(String imagePath) {
/* 21 */     this.imagePath = imagePath;
/*    */   }
/*    */ 
/*    */   public Object getTreeObj()
/*    */   {
/* 28 */     return this.treeObj;
/*    */   }
/*    */ 
/*    */   public void setTreeObj(Object treeObj) {
/* 32 */     this.treeObj = treeObj;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 36 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public HiTreeObject(String name) {
/* 40 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 44 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setParent(HiTreeParent parent) {
/* 48 */     this.parent = parent;
/*    */   }
/*    */ 
/*    */   public HiTreeParent getParent() {
/* 52 */     return this.parent;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 57 */     if (this.name.indexOf(File.separator) != -1) {
/* 58 */       return this.name.substring(this.name.lastIndexOf(File.separator) + 1);
/*    */     }
/*    */ 
/* 61 */     return getName();
/*    */   }
/*    */ 
/*    */   public Object getAdapter(Class key) {
/* 65 */     if ((getTreeObj() instanceof IProject)) {
/* 66 */       return ((IProject)getTreeObj()).getAdapter(key);
/*    */     }
/* 68 */     return getParent().getAdapter(key);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.tree.HiTreeObject
 * JD-Core Version:    0.6.0
 */