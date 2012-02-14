/*     */ package org.hi.studio.hsceditor.validator;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IMarker;
/*     */ import org.eclipse.core.resources.IResource;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class DiagramErrors
/*     */ {
/*  25 */   private List<DiagramError> errors = new ArrayList();
/*     */   public static final String ERROR_PREFIX = "[ERROR]";
/*     */   public static final String WARNING_PREFIX = "[WARN]";
/*     */ 
/*     */   private static String createColumnMessage(TableModel table, ColumnModel column, String message)
/*     */   {
/*  31 */     return "[" + table.getTableName() + "." + column.getColumnName() + "]" + message;
/*     */   }
/*     */ 
/*     */   private static String createColumnMessage(ColumnModel column, String message) {
/*  35 */     return "[" + column.getColumnName() + "]" + message;
/*     */   }
/*     */ 
/*     */   private static String createIndexMessage(TableModel table, IndexModel index, String message) {
/*  39 */     return "[" + table.getTableName() + "." + index.getIndexName() + "]" + message;
/*     */   }
/*     */ 
/*     */   private static String createIndexMessage(IndexModel index, String message) {
/*  43 */     return "[" + index.getIndexName() + "]" + message;
/*     */   }
/*     */ 
/*     */   private static String createTableMessage(TableModel table, String message) {
/*  47 */     return "[" + table.getTableName() + "]" + message;
/*     */   }
/*     */ 
/*     */   public void addError(String level, TableModel table, String message)
/*     */   {
/*  58 */     if (level.equals("ERROR")) {
/*  59 */       this.errors.add(new DiagramError(table, createTableMessage(table, message), level, null));
/*  60 */       addErrorMessageToModel(table, "[ERROR]" + message);
/*     */     }
/*  62 */     else if (level.equals("WARNING")) {
/*  63 */       this.errors.add(new DiagramError(table, createTableMessage(table, message), level, null));
/*  64 */       addErrorMessageToModel(table, "[WARN]" + message);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addError(String level, TableModel table, ColumnModel column, String message)
/*     */   {
/*  77 */     if (level.equals("ERROR")) {
/*  78 */       this.errors.add(new DiagramError(table, createColumnMessage(table, column, message), level, null));
/*  79 */       addErrorMessageToModel(table, "[ERROR]" + createColumnMessage(column, message));
/*     */     }
/*  81 */     else if (level.equals("WARNING")) {
/*  82 */       this.errors.add(new DiagramError(table, createColumnMessage(table, column, message), level, null));
/*  83 */       addErrorMessageToModel(table, "[WARN]" + createColumnMessage(column, message));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addError(String level, TableModel table, IndexModel index, String message)
/*     */   {
/*  96 */     if (level.equals("ERROR")) {
/*  97 */       this.errors.add(new DiagramError(table, createIndexMessage(table, index, message), level, null));
/*  98 */       addErrorMessageToModel(table, "[ERROR]" + createIndexMessage(index, message));
/*     */     }
/* 100 */     else if (level.equals("WARNING")) {
/* 101 */       this.errors.add(new DiagramError(table, createIndexMessage(table, index, message), level, null));
/* 102 */       addErrorMessageToModel(table, "[WARN]" + createIndexMessage(index, message));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void addErrorMessageToModel(TableModel table, String message) {
/* 107 */     String error = table.getError();
/* 108 */     if (error.length() > 0) {
/* 109 */       error = error + "\n";
/*     */     }
/* 111 */     error = error + message;
/* 112 */     table.setError(error);
/*     */   }
/*     */ 
/*     */   public List<DiagramError> getErrors()
/*     */   {
/* 121 */     return this.errors;
/*     */   }
/*     */   public static class DiagramError {
/*     */     private Object target;
/*     */     private String message;
/*     */     private String level;
/*     */ 
/* 131 */     private DiagramError(Object target, String message, String level) { this.target = target;
/* 132 */       this.message = message;
/* 133 */       this.level = level;
/*     */     }
/*     */ 
/*     */     public Object getTarget()
/*     */     {
/* 141 */       return this.target;
/*     */     }
/*     */ 
/*     */     public String getMessage()
/*     */     {
/* 149 */       return this.message;
/*     */     }
/*     */ 
/*     */     public String getLevel()
/*     */     {
/* 157 */       return this.level;
/*     */     }
/*     */ 
/*     */     public void addMarker(IFile file)
/*     */     {
/* 165 */       if (this.level == "ERROR")
/* 166 */         addMarker(file, 2, this.message);
/*     */       else
/* 168 */         addMarker(file, 1, this.message);
/*     */     }
/*     */ 
/*     */     private static void addMarker(IResource resource, int type, String message)
/*     */     {
/*     */       try
/*     */       {
/* 181 */         IMarker marker = resource.createMarker("org.eclipse.core.resources.problemmarker");
/* 182 */         Map map = new HashMap();
/* 183 */         map.put("severity", new Integer(type));
/* 184 */         map.put("message", message);
/*     */ 
/* 186 */         marker.setAttributes(map);
/*     */       } catch (CoreException ex) {
/* 188 */         DBPlugin.logException(ex);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.validator.DiagramErrors
 * JD-Core Version:    0.6.0
 */