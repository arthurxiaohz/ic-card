/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class ForeignKeyMapping
/*    */ {
/*    */   private ColumnModel target;
/*    */   private ColumnModel refer;
/*    */ 
/*    */   public ColumnModel getRefer()
/*    */   {
/* 11 */     return this.refer;
/*    */   }
/*    */ 
/*    */   public void setRefer(ColumnModel refer) {
/* 15 */     if (refer == null) {
/* 16 */       System.out.println("test");
/*    */     }
/*    */ 
/* 19 */     this.refer = refer;
/*    */   }
/*    */ 
/*    */   public ColumnModel getTarget() {
/* 23 */     return this.target;
/*    */   }
/*    */ 
/*    */   public void setTarget(ColumnModel target) {
/* 27 */     this.target = target;
/*    */   }
/*    */ 
/*    */   public ForeignKeyMapping clone() {
/* 31 */     ForeignKeyMapping temp = new ForeignKeyMapping();
/* 32 */     temp.setRefer(getRefer());
/* 33 */     temp.setTarget(getTarget());
/* 34 */     return temp;
/*    */   }
/*    */ 
/*    */   public String getDisplayString(boolean logicalMode) {
/* 38 */     StringBuffer sb = new StringBuffer();
/* 39 */     if (logicalMode) {
/* 40 */       if (getRefer() == null)
/* 41 */         sb.append(DBPlugin.getResourceString("label.undef"));
/*    */       else {
/* 43 */         sb.append(getRefer().getLogicalName());
/*    */       }
/* 45 */       sb.append("=");
/* 46 */       sb.append(getTarget().getLogicalName());
/*    */     } else {
/* 48 */       if (getRefer() == null)
/* 49 */         sb.append(DBPlugin.getResourceString("label.undef"));
/*    */       else {
/* 51 */         sb.append(getRefer().getColumnName());
/*    */       }
/* 53 */       sb.append("=");
/* 54 */       sb.append(getTarget().getColumnName());
/*    */     }
/* 56 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.ForeignKeyMapping
 * JD-Core Version:    0.6.0
 */