/*     */ package org.hi.studio.hsceditor.visual.editpart;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import org.eclipse.gef.commands.Command;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class TableEditCommand extends Command
/*     */ {
/*     */   private TableModel model;
/*     */   private String oldTableName;
/*     */   private String newTableName;
/*     */   private String oldTableLogicalName;
/*     */   private String newTableLogicalName;
/*     */   private String oldTableDescription;
/*     */   private String newTableDescription;
/*     */   private ColumnModel[] oldColumns;
/*     */   private ColumnModel[] newColumns;
/*     */   private IndexModel[] oldIndices;
/*     */   private IndexModel[] newIndices;
/*     */   private String oldExtendServiceName;
/*     */   private String newExtendServiceName;
/*     */   private String oldExtendEntityName;
/*     */   private String newExtendEntityName;
/*     */   private boolean oldIsDeleted;
/*     */   private boolean isDeleted;
/*     */ 
/*     */   public boolean isOldIsDeleted()
/*     */   {
/*  34 */     return this.oldIsDeleted;
/*     */   }
/*     */ 
/*     */   public void setOldIsDeleted(boolean oldIsDeleted) {
/*  38 */     this.oldIsDeleted = oldIsDeleted;
/*     */   }
/*     */ 
/*     */   public boolean isDeleted() {
/*  42 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setDeleted(boolean isDeleted) {
/*  46 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public TableEditCommand(TableModel model, String newTableName, String newTableLogicalName, String newTableDescription, ColumnModel[] newColumns, IndexModel[] newIndices, String extServiceName, String extEntityName, boolean isDeleted)
/*     */   {
/*  52 */     this.model = model;
/*  53 */     this.oldTableName = model.getTableName();
/*  54 */     this.newTableName = newTableName;
/*  55 */     this.oldTableLogicalName = model.getLogicalName();
/*  56 */     this.newTableLogicalName = newTableLogicalName;
/*  57 */     this.oldTableDescription = model.getDescription();
/*  58 */     this.newTableDescription = newTableDescription;
/*  59 */     this.oldColumns = model.getColumns();
/*  60 */     this.newColumns = newColumns;
/*  61 */     this.oldIndices = model.getIndices();
/*  62 */     this.newIndices = newIndices;
/*     */ 
/*  64 */     this.newExtendServiceName = extServiceName;
/*  65 */     this.oldExtendServiceName = model.getExtendServiceName();
/*  66 */     this.newExtendEntityName = extEntityName;
/*  67 */     this.oldExtendEntityName = model.getExtendEntityName();
/*     */ 
/*  69 */     this.isDeleted = isDeleted;
/*  70 */     this.oldIsDeleted = model.isDeleted();
/*     */   }
/*     */ 
/*     */   public void execute()
/*     */   {
/*  78 */     this.model.setTableName(this.newTableName);
/*  79 */     this.model.setLogicalName(this.newTableLogicalName);
/*  80 */     this.model.setDescription(this.newTableDescription);
/*  81 */     this.model.setColumns(this.newColumns);
/*  82 */     this.model.setIndices(this.newIndices);
/*     */ 
/*  84 */     this.model.setExtendServiceName(this.newExtendServiceName);
/*  85 */     this.model.setExtendEntityName(this.newExtendEntityName);
/*     */ 
/*  87 */     this.model.setDeleted(this.isDeleted);
/*     */   }
/*     */ 
/*     */   public void undo()
/*     */   {
/*  94 */     this.model.setTableName(this.oldTableName);
/*  95 */     this.model.setLogicalName(this.oldTableLogicalName);
/*  96 */     this.model.setDescription(this.oldTableDescription);
/*  97 */     this.model.setColumns(this.oldColumns);
/*  98 */     this.model.setIndices(this.oldIndices);
/*     */ 
/* 100 */     this.model.setExtendServiceName(this.oldExtendServiceName);
/* 101 */     this.model.setExtendEntityName(this.oldExtendEntityName);
/*     */ 
/* 103 */     this.model.setDeleted(this.oldIsDeleted);
/*     */   }
/*     */ 
/*     */   public void dispose()
/*     */   {
/* 108 */     super.dispose();
/*     */   }
/*     */ 
/*     */   public boolean canUndo()
/*     */   {
/* 114 */     System.out.println("a");
/* 115 */     return super.canUndo();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.TableEditCommand
 * JD-Core Version:    0.6.0
 */