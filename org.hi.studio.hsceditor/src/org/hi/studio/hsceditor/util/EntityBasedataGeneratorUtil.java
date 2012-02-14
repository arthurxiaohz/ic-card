/*    */ package org.hi.studio.hsceditor.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class EntityBasedataGeneratorUtil
/*    */ {
/*    */   public static Integer generateEntityBasedata(RootModel root)
/*    */   {
/* 16 */     Integer entityBasedata = Integer.valueOf(Integer.valueOf(root.getBaseData()).intValue() + 100);
/*    */ 
/* 18 */     for (Iterator it = root.getChildren().iterator(); it.hasNext(); ) {
/* 19 */       TableModel tempModel = (TableModel)it.next();
/* 20 */       System.out.println(tempModel.getEntityBaseData());
/* 21 */       if ((tempModel.getEntityBaseData() == null) || 
/* 22 */         (tempModel.getEntityBaseData().equals("")) || 
/* 23 */         (Integer.valueOf(entityBasedata.intValue()).intValue() > Integer.valueOf(tempModel.getEntityBaseData()).intValue())) continue;
/* 24 */       entityBasedata = Integer.valueOf(Integer.valueOf(tempModel.getEntityBaseData()).intValue() + 100);
/*    */     }
/*    */ 
/* 28 */     return entityBasedata;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.EntityBasedataGeneratorUtil
 * JD-Core Version:    0.6.0
 */