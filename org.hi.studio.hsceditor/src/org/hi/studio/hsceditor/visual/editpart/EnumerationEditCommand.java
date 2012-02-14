/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import org.eclipse.gef.commands.Command;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*    */ 
/*    */ public class EnumerationEditCommand extends Command
/*    */ {
/*    */   private EnumerationModel model;
/*    */   private String oldEnumName;
/*    */   private String newEnumName;
/*    */   private String oldEnumDesc;
/*    */   private String newEnumDesc;
/*    */   private ColumnModel[] oldColumns;
/*    */   private ColumnModel[] newColumns;
/*    */ 
/*    */   public EnumerationEditCommand(EnumerationModel model, ColumnModel[] newColumns, String newEnumName, String newEnumDesc)
/*    */   {
/* 22 */     this.model = model;
/* 23 */     this.oldEnumName = model.getEnumName();
/* 24 */     this.newEnumName = newEnumName;
/* 25 */     this.oldEnumDesc = model.getEnumDesc();
/* 26 */     this.newEnumDesc = newEnumDesc;
/* 27 */     this.oldColumns = model.getColumns();
/* 28 */     this.newColumns = newColumns;
/*    */   }
/*    */ 
/*    */   public void execute()
/*    */   {
/* 33 */     this.model.setEnumName(this.newEnumName);
/* 34 */     this.model.setEnumDesc(this.newEnumDesc);
/* 35 */     this.model.setColumns(this.newColumns);
/*    */   }
/*    */ 
/*    */   public void undo() {
/* 39 */     this.model.setEnumName(this.oldEnumName);
/* 40 */     this.model.setEnumDesc(this.oldEnumDesc);
/* 41 */     this.model.setColumns(this.oldColumns);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.EnumerationEditCommand
 * JD-Core Version:    0.6.0
 */