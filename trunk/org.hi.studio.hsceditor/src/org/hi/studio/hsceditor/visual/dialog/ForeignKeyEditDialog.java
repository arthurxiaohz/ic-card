/*     */ package org.hi.studio.hsceditor.visual.dialog;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyMapping;
/*     */ 
/*     */ public class ForeignKeyEditDialog extends Dialog
/*     */ {
/*     */   private ForeignKeyMapping[] mappings;
/*     */   private String foreignKeyName;
/*     */   private ColumnModel[] columns;
/*     */   private ForeignKeyMapping[] result;
/*  29 */   private String mainEntityName = "";
/*     */ 
/*  31 */   private List<Combo> combos = new ArrayList();
/*     */   private Text keyName;
/*     */   private boolean logicalMode;
/*     */ 
/*     */   public ForeignKeyEditDialog(Shell shell, String foreignKeyName, ForeignKeyMapping[] mappings, ColumnModel[] columns, boolean logicalMode, String mainEntityName)
/*     */   {
/*  39 */     super(shell);
/*  40 */     setShellStyle(getShellStyle() | 0x10);
/*  41 */     this.foreignKeyName = foreignKeyName;
/*  42 */     this.mappings = mappings;
/*  43 */     this.columns = columns;
/*  44 */     this.logicalMode = logicalMode;
/*  45 */     this.mainEntityName = mainEntityName;
/*     */   }
/*     */ 
/*     */   protected void constrainShellSize() {
/*  49 */     Shell shell = getShell();
/*  50 */     shell.pack();
/*  51 */     shell.setSize(400, shell.getSize().y);
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent) {
/*  55 */     getShell().setText(DBPlugin.getResourceString("dialog.mapping.title"));
/*     */ 
/*  57 */     Composite composite = new Composite(parent, 0);
/*  58 */     composite.setLayout(new GridLayout(2, false));
/*  59 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/*  61 */     Label label = new Label(composite, 0);
/*  62 */     label.setText(DBPlugin.getResourceString("dialog.mapping.name"));
/*  63 */     this.keyName = new Text(composite, 2048);
/*  64 */     this.keyName.setLayoutData(new GridData(768));
/*  65 */     this.keyName.setText(this.foreignKeyName);
/*     */ 
/*  67 */     Group group = new Group(composite, 0);
/*  68 */     group.setText(DBPlugin.getResourceString("dialog.mapping.mapping"));
/*  69 */     group.setLayout(new GridLayout(3, false));
/*  70 */     GridData gd = new GridData(1808);
/*  71 */     gd.horizontalSpan = 2;
/*  72 */     group.setLayoutData(gd);
/*     */ 
/*  74 */     for (int i = 0; i < this.mappings.length; i++) {
/*  75 */       label = new Label(group, 2048);
/*  76 */       if (this.logicalMode)
/*  77 */         label.setText(this.mappings[i].getTarget().getLogicalName());
/*     */       else {
/*  79 */         label.setText(this.mappings[i].getTarget().getColumnName());
/*     */       }
/*  81 */       label.setLayoutData(new GridData(768));
/*     */ 
/*  83 */       label = new Label(group, 0);
/*  84 */       label.setText("=");
/*     */ 
/*  86 */       Combo combo = new Combo(group, 8);
/*  87 */       combo.setLayoutData(new GridData(768));
/*  88 */       for (int j = 0; j < this.columns.length; j++)
/*     */       {
/*  91 */         if (this.columns[j].getHiDataType() == 2) {
/*  92 */           if (this.logicalMode)
/*  93 */             combo.add(this.columns[j].getLogicalName());
/*     */           else {
/*  95 */             combo.add(this.columns[j].getColumnName());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 100 */       if (this.mappings[i].getRefer() != null) {
/* 101 */         if (this.logicalMode)
/* 102 */           combo.setText(this.mappings[i].getRefer().getLogicalName());
/*     */         else {
/* 104 */           combo.setText(this.mappings[i].getRefer().getColumnName());
/*     */         }
/*     */       }
/* 107 */       this.combos.add(combo);
/*     */     }
/*     */ 
/* 110 */     if (this.mappings.length == 0) {
/* 111 */       label = new Label(group, 0);
/* 112 */       label.setText(DBPlugin.getResourceString("dialog.mapping.noColumns"));
/* 113 */       gd = new GridData(768);
/* 114 */       gd.horizontalSpan = 3;
/*     */     }
/*     */ 
/* 117 */     return composite;
/*     */   }
/*     */ 
/*     */   protected void okPressed() {
/* 121 */     this.result = new ForeignKeyMapping[this.combos.size()];
/*     */ 
/* 124 */     for (int i = 0; i < this.mappings.length; i++) {
/* 125 */       this.mappings[i].getRefer().setParent(false);
/* 126 */       this.mappings[i].getRefer().setMainEntityName("");
/*     */     }
/*     */ 
/* 129 */     for (int i = 0; i < this.combos.size(); i++) {
/* 130 */       Combo combo = (Combo)this.combos.get(i);
/* 131 */       this.result[i] = new ForeignKeyMapping();
/* 132 */       this.result[i].setTarget(this.mappings[i].getTarget());
/* 133 */       String columnName = combo.getText();
/* 134 */       int index = 0;
/* 135 */       for (int j = 0; j < this.columns.length; j++) {
/* 136 */         if (this.logicalMode) {
/* 137 */           if (this.columns[j].getLogicalName().equals(columnName)) {
/* 138 */             index = j;
/* 139 */             break;
/*     */           }
/*     */         }
/* 142 */         else if (this.columns[j].getColumnName().equals(columnName)) {
/* 143 */           index = j;
/* 144 */           break;
/*     */         }
/*     */       }
/*     */ 
/* 148 */       this.result[i].setRefer(this.columns[index]);
/*     */ 
/* 151 */       this.columns[index].setParent(true);
/* 152 */       this.columns[index].setMainEntityName(getMainEntityName());
/* 153 */       this.columns[index].setHidden(true);
/*     */     }
/* 155 */     this.foreignKeyName = this.keyName.getText();
/*     */ 
/* 157 */     super.okPressed();
/*     */   }
/*     */ 
/*     */   public String getForeignKeyName() {
/* 161 */     return this.foreignKeyName;
/*     */   }
/*     */ 
/*     */   public ForeignKeyMapping[] getMapping() {
/* 165 */     return this.result;
/*     */   }
/*     */ 
/*     */   public String getMainEntityName() {
/* 169 */     return this.mainEntityName;
/*     */   }
/*     */ 
/*     */   public void setMainEntityName(String mainEntityName) {
/* 173 */     this.mainEntityName = mainEntityName;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.ForeignKeyEditDialog
 * JD-Core Version:    0.6.0
 */