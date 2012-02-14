/*     */ package org.hi.studio.hsceditor.util;
/*     */ 
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.MessageBox;
/*     */ import org.eclipse.swt.widgets.Table;
/*     */ import org.eclipse.swt.widgets.TableColumn;
/*     */ import org.eclipse.ui.IEditorPart;
/*     */ import org.eclipse.ui.IWorkbench;
/*     */ import org.eclipse.ui.IWorkbenchPage;
/*     */ import org.eclipse.ui.IWorkbenchWindow;
/*     */ import org.eclipse.ui.PlatformUI;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*     */ 
/*     */ public class UIUtils
/*     */ {
/*     */   public static GridData createGridData(int colspan)
/*     */   {
/*  32 */     GridData gd = new GridData(768);
/*  33 */     gd.horizontalSpan = colspan;
/*  34 */     return gd;
/*     */   }
/*     */ 
/*     */   public static GridData createGridData(int colspan, int option) {
/*  38 */     GridData gd = new GridData(option);
/*  39 */     gd.horizontalSpan = colspan;
/*  40 */     return gd;
/*     */   }
/*     */ 
/*     */   public static GridData createGridDataWithWidth(int width) {
/*  44 */     GridData gd = new GridData();
/*  45 */     gd.widthHint = width;
/*  46 */     return gd;
/*     */   }
/*     */ 
/*     */   public static GridData createGridDataWithColspan(int colspan, int height) {
/*  50 */     GridData gd = new GridData(768);
/*  51 */     gd.horizontalSpan = colspan;
/*  52 */     gd.heightHint = height;
/*  53 */     return gd;
/*     */   }
/*     */ 
/*     */   public static GridData createGridDataWithRowspan(int rowspan, int width) {
/*  57 */     GridData gd = new GridData(1040);
/*  58 */     gd.verticalSpan = rowspan;
/*  59 */     gd.widthHint = width;
/*  60 */     return gd;
/*     */   }
/*     */ 
/*     */   public static void createColumn(Table table, String key, int width, boolean isTipText)
/*     */   {
/*  71 */     TableColumn column = new TableColumn(table, 0);
/*  72 */     column.setText(DBPlugin.getResourceString(key));
/*  73 */     if (isTipText)
/*  74 */       column.setToolTipText(DBPlugin.getResourceString(key + ".desc"));
/*  75 */     column.setWidth(width);
/*     */   }
/*     */ 
/*     */   public static Label createLabel(Composite parent, String key, boolean isTipText)
/*     */   {
/*  95 */     Label label = new Label(parent, 0);
/*     */ 
/*  97 */     label.setLayoutData(new GridData(128));
/*  98 */     label.setText(DBPlugin.getResourceString(key));
/*  99 */     if (isTipText)
/* 100 */       label.setToolTipText(DBPlugin.getResourceString(key + ".desc"));
/* 101 */     return label;
/*     */   }
/*     */ 
/*     */   public static void openAlertDialog(String messageKey)
/*     */   {
/* 111 */     MessageBox box = new MessageBox(Display.getCurrent().getActiveShell(), 1);
/* 112 */     box.setMessage(DBPlugin.getResourceString(messageKey));
/* 113 */     box.setText(DBPlugin.getResourceString("dialog.alert.title"));
/* 114 */     box.open();
/*     */   }
/*     */ 
/*     */   public static VisualDBEditor getActiveEditor()
/*     */   {
/* 123 */     IWorkbench workbench = PlatformUI.getWorkbench();
/* 124 */     IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
/* 125 */     IWorkbenchPage page = window.getActivePage();
/* 126 */     IEditorPart editorPart = page.getActiveEditor();
/* 127 */     if ((editorPart instanceof VisualDBEditor)) {
/* 128 */       return (VisualDBEditor)editorPart;
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.UIUtils
 * JD-Core Version:    0.6.0
 */