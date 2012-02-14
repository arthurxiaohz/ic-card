/*    */ package org.hi.studio.hsceditor.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.eclipse.swt.graphics.Color;
/*    */ import org.eclipse.swt.graphics.RGB;
/*    */ import org.eclipse.swt.widgets.Display;
/*    */ 
/*    */ public class ColorRegistry
/*    */ {
/* 12 */   private Map<RGB, Color> colors = new HashMap();
/*    */ 
/*    */   public Color getColor(RGB rgb) {
/* 15 */     Color color = (Color)this.colors.get(rgb);
/* 16 */     if (color == null) {
/* 17 */       color = new Color(Display.getDefault(), rgb);
/* 18 */       this.colors.put(rgb, color);
/*    */     }
/* 20 */     return color;
/*    */   }
/*    */ 
/*    */   public void dispose() {
/* 24 */     for (Color color : this.colors.values()) {
/* 25 */       color.dispose();
/*    */     }
/* 27 */     this.colors.clear();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.ColorRegistry
 * JD-Core Version:    0.6.0
 */