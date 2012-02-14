/*     */ package org.hi.studio.hsceditor.visual.model;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.eclipse.ui.views.properties.IPropertyDescriptor;
/*     */ import org.eclipse.ui.views.properties.TextPropertyDescriptor;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ 
/*     */ public class ForeignKeyModel extends AbstractDBConnectionModel
/*     */ {
/*  16 */   private String foreignKeyName = "";
/*  17 */   private Map<ColumnModel, ColumnModel> references = new HashMap();
/*     */   public static final String P_FOREIGN_KEY_NAME = "p_foreign_key_name";
/*     */   public static final String P_FOREIGN_KEY_MAPPING = "p_foreign_key_mapping";
/*     */   private ColumnModel foreignKeyColumn;
/*     */   private ColumnModel targetIdColumn;
/*     */ 
/*     */   public void setForeignKeyName(String foreignKeyName)
/*     */   {
/*  31 */     this.foreignKeyName = foreignKeyName;
/*  32 */     firePropertyChange("p_foreign_key_name", null, foreignKeyName);
/*     */   }
/*     */ 
/*     */   public String getForeignKeyName() {
/*  36 */     return this.foreignKeyName;
/*     */   }
/*     */ 
/*     */   public String getForeignColumnName()
/*     */   {
/*  48 */     return this.foreignKeyColumn.getColumnName();
/*     */   }
/*     */ 
/*     */   public void setMapping(ForeignKeyMapping[] mapping) {
/*  52 */     this.references.clear();
/*  53 */     for (int i = 0; i < mapping.length; i++) {
/*  54 */       this.references.put(mapping[i].getTarget(), mapping[i].getRefer());
/*     */ 
/*  56 */       if (mapping[i].getRefer() == null) {
/*  57 */         System.out.println("test");
/*     */       }
/*     */     }
/*  60 */     firePropertyChange("p_foreign_key_mapping", null, mapping);
/*     */   }
/*     */ 
/*     */   public ForeignKeyMapping[] getMapping() {
/*  64 */     List list = new ArrayList();
/*     */ 
/*  66 */     TableModel target = (TableModel)getTarget();
/*  67 */     ColumnModel[] targetColumns = target.getColumns();
/*  68 */     for (int i = 0; i < targetColumns.length; i++) {
/*  69 */       if (targetColumns[i].isPrimaryKey()) {
/*  70 */         ForeignKeyMapping mapping = new ForeignKeyMapping();
/*  71 */         mapping.setTarget(targetColumns[i]);
/*  72 */         ColumnModel referColumn = (ColumnModel)this.references.get(targetColumns[i]);
/*  73 */         TableModel source = (TableModel)getSource();
/*     */ 
/*  80 */         ColumnModel[] sourceColumns = source.getColumns();
/*  81 */         if (referColumn != null) {
/*  82 */           for (int j = 0; j < sourceColumns.length; j++)
/*  83 */             if (sourceColumns[j] == referColumn) {
/*  84 */               mapping.setRefer(referColumn);
/*  85 */               break;
/*     */             }
/*     */         }
/*  88 */         else if (sourceColumns.length > list.size()) {
/*  89 */           mapping.setRefer(sourceColumns[list.size()]);
/*     */         }
/*  91 */         list.add(mapping);
/*     */       }
/*     */     }
/*     */ 
/*  95 */     return (ForeignKeyMapping[])list.toArray(new ForeignKeyMapping[list.size()]);
/*     */   }
/*     */ 
/*     */   public IPropertyDescriptor[] getPropertyDescriptors() {
/*  99 */     List descriptoes = new ArrayList();
/*     */ 
/* 101 */     descriptoes.add(
/* 102 */       new TextPropertyDescriptor("p_foreign_key_name", 
/* 102 */       DBPlugin.getResourceString("property.foreignKeyName")));
/*     */ 
/* 106 */     return (IPropertyDescriptor[])descriptoes.toArray(new IPropertyDescriptor[descriptoes.size()]);
/*     */   }
/*     */ 
/*     */   public Object getPropertyValue(Object id) {
/* 110 */     if (id == "p_foreign_key_name") {
/* 111 */       return getForeignKeyName();
/*     */     }
/*     */ 
/* 116 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isPropertySet(Object id)
/*     */   {
/* 123 */     return id == "p_foreign_key_name";
/*     */   }
/*     */ 
/*     */   public void setPropertyValue(Object id, Object value)
/*     */   {
/* 129 */     if (id == "p_foreign_key_name")
/* 130 */       setForeignKeyName((String)value);
/*     */   }
/*     */ 
/*     */   public ColumnModel getForeignKeyColumn()
/*     */   {
/* 138 */     return this.foreignKeyColumn;
/*     */   }
/*     */ 
/*     */   public void setForeignKeyColumn(ColumnModel foreignKeyColumn) {
/* 142 */     this.foreignKeyColumn = foreignKeyColumn;
/*     */   }
/*     */ 
/*     */   public ColumnModel getTargetIdColumn() {
/* 146 */     return this.targetIdColumn;
/*     */   }
/*     */ 
/*     */   public void setTargetIdColumn(ColumnModel targetIdColumn) {
/* 150 */     this.targetIdColumn = targetIdColumn;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.ForeignKeyModel
 * JD-Core Version:    0.6.0
 */