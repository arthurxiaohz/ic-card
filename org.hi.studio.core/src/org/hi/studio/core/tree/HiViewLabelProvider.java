/*    */ package org.hi.studio.core.tree;
/*    */ 
/*    */ import org.eclipse.jface.viewers.LabelProvider;
/*    */ import org.eclipse.swt.graphics.Image;
/*    */ import org.hi.studio.core.utils.ImageUtil;
/*    */ 
/*    */ public class HiViewLabelProvider extends LabelProvider
/*    */ {
/*    */   public String getText(Object obj)
/*    */   {
/* 10 */     return obj.toString();
/*    */   }
/*    */ 
/*    */   public Image getImage(Object obj)
/*    */   {
/* 18 */     return ImageUtil.getInstance().getImage(((HiTreeObject)obj).getImagePath());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.tree.HiViewLabelProvider
 * JD-Core Version:    0.6.0
 */