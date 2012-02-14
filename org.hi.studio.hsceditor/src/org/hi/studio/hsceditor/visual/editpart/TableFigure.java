/*     */ package org.hi.studio.hsceditor.visual.editpart;
/*     */ 
/*     */ import org.eclipse.draw2d.AbstractBorder;
/*     */ import org.eclipse.draw2d.ColorConstants;
/*     */ import org.eclipse.draw2d.Figure;
/*     */ import org.eclipse.draw2d.Graphics;
/*     */ import org.eclipse.draw2d.IFigure;
/*     */ import org.eclipse.draw2d.Label;
/*     */ import org.eclipse.draw2d.LineBorder;
/*     */ import org.eclipse.draw2d.MarginBorder;
/*     */ import org.eclipse.draw2d.ToolbarLayout;
/*     */ import org.eclipse.draw2d.geometry.Insets;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ 
/*     */ public class TableFigure extends Figure
/*     */ {
/*     */   private Label name;
/*     */   private ColumnLayoutFigure columnFigure;
/*     */   private CompartmentFigure columnNameFigure;
/*     */   private CompartmentFigure columnTypeFigure;
/*  27 */   private boolean flag = true;
/*     */ 
/*     */   public TableFigure() {
/*  30 */     this.name = new Label();
/*  31 */     this.name.setBorder(new MarginBorder(2, 2, 0, 2));
/*     */ 
/*  33 */     this.columnNameFigure = new CompartmentFigure();
/*  34 */     this.columnTypeFigure = new CompartmentFigure();
/*  35 */     this.columnFigure = new ColumnLayoutFigure();
/*     */ 
/*  37 */     ToolbarLayout layout = new ToolbarLayout();
/*  38 */     setLayoutManager(layout);
/*     */ 
/*  40 */     setBorder(new LineBorder(ColorConstants.black, 1));
/*  41 */     setOpaque(true);
/*     */ 
/*  43 */     add(this.name);
/*  44 */     add(this.columnFigure);
/*     */ 
/*  46 */     this.columnFigure.add(this.columnNameFigure);
/*  47 */     this.columnFigure.add(this.columnTypeFigure);
/*     */   }
/*     */ 
/*     */   public void setTableName(String tableName) {
/*  51 */     this.name.setText(tableName);
/*     */   }
/*     */ 
/*     */   public void setErrorMessage(String message) {
/*  55 */     if ((message == null) || (message.length() == 0)) {
/*  56 */       this.name.setIcon(null);
/*  57 */       this.name.setToolTip(null);
/*     */     } else {
/*  59 */       if (message.indexOf("[ERROR]") >= 0)
/*  60 */         this.name.setIcon(DBPlugin.getImage("icons/error.gif"));
/*     */       else {
/*  62 */         this.name.setIcon(DBPlugin.getImage("icons/warning.gif"));
/*     */       }
/*  64 */       this.name.setToolTip(new Label(message));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setLinkedTable(boolean linked) {
/*  69 */     if (linked) {
/*  70 */       setForegroundColor(Display.getDefault().getSystemColor(15));
/*  71 */       ((LineBorder)getBorder()).setColor(Display.getDefault().getSystemColor(15));
/*     */     } else {
/*  73 */       setForegroundColor(Display.getDefault().getSystemColor(2));
/*  74 */       ((LineBorder)getBorder()).setColor(Display.getDefault().getSystemColor(2));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void add(IFigure figure, Object constraint, int index) {
/*  79 */     if ((figure instanceof ColumnFigure)) {
/*  80 */       if (this.flag) {
/*  81 */         this.columnNameFigure.add(figure);
/*  82 */         this.flag = false;
/*     */       } else {
/*  84 */         this.columnTypeFigure.add(figure);
/*  85 */         this.flag = true;
/*     */       }
/*     */     }
/*  88 */     else super.add(figure, constraint, index);
/*     */   }
/*     */ 
/*     */   public void remove(IFigure figure)
/*     */   {
/*  93 */     if ((figure instanceof ColumnFigure)) {
/*  94 */       this.columnNameFigure.remove(figure);
/*  95 */       this.columnTypeFigure.remove(figure);
/*     */     } else {
/*  97 */       super.remove(figure);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeAllColumns() {
/* 102 */     this.columnNameFigure.removeAll();
/* 103 */     this.columnTypeFigure.removeAll();
/*     */   }
/*     */ 
/*     */   public Label getLabel() {
/* 107 */     return this.name;
/*     */   }
/*     */ 
/*     */   private class ColumnLayoutFigure extends Figure {
/*     */     public ColumnLayoutFigure() {
/* 112 */       ToolbarLayout layout = new ToolbarLayout(true);
/* 113 */       layout.setMinorAlignment(1);
/* 114 */       layout.setStretchMinorAxis(false);
/* 115 */       layout.setSpacing(2);
/* 116 */       setLayoutManager(layout);
/* 117 */       setBorder(new TableFigure.CompartmentFigureBorder(TableFigure.this));
/*     */     }
/*     */   }
/*     */   public class CompartmentFigureBorder extends AbstractBorder {
/*     */     public CompartmentFigureBorder() {
/*     */     }
/*     */     public Insets getInsets(IFigure figure) {
/* 123 */       return new Insets(1, 0, 2, 0);
/*     */     }
/*     */     public void paint(IFigure figure, Graphics graphics, Insets insets) {
/* 126 */       graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(), tempRect.getTopRight());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.TableFigure
 * JD-Core Version:    0.6.0
 */