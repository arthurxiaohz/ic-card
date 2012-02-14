/*    */ package org.hi.studio.project.utils;
/*    */ 
/*    */ import org.eclipse.swt.custom.SashForm;
/*    */ import org.eclipse.swt.graphics.Point;
/*    */ import org.eclipse.swt.layout.GridData;
/*    */ import org.eclipse.swt.layout.GridLayout;
/*    */ import org.eclipse.swt.widgets.Button;
/*    */ import org.eclipse.swt.widgets.Combo;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.swt.widgets.Group;
/*    */ import org.eclipse.swt.widgets.Label;
/*    */ import org.eclipse.swt.widgets.Text;
/*    */ 
/*    */ public class GuiHelper
/*    */ {
/*    */   public static Composite createSwordComp(Composite parent, int style, GridData gd, GridLayout layout)
/*    */   {
/* 19 */     Composite comp = new Composite(parent, style);
/* 20 */     if (layout != null)
/* 21 */       comp.setLayout(layout);
/* 22 */     if (gd != null)
/* 23 */       comp.setLayoutData(gd);
/* 24 */     return comp;
/*    */   }
/*    */ 
/*    */   public static Text createSwordText(Composite parent, int style, GridData gd)
/*    */   {
/* 29 */     Text swordtext = new Text(parent, style);
/* 30 */     if (gd != null)
/* 31 */       swordtext.setLayoutData(gd);
/* 32 */     return swordtext;
/*    */   }
/*    */ 
/*    */   public static void createSwordLabel(Composite parent, int style, String text)
/*    */   {
/* 37 */     Label swordlabel = new Label(parent, style);
/* 38 */     if (text != null)
/* 39 */       swordlabel.setText(text);
/*    */   }
/*    */ 
/*    */   public static Combo createSwordCombo(Composite parent, int style, GridData gd, GridLayout layout)
/*    */   {
/* 45 */     Combo swordcombo = new Combo(parent, style);
/* 46 */     if (layout != null)
/* 47 */       swordcombo.setLayout(layout);
/* 48 */     if (gd != null)
/* 49 */       swordcombo.setLayoutData(gd);
/* 50 */     return swordcombo;
/*    */   }
/*    */ 
/*    */   public static Button createSwordButton(Composite parent, int style, String text, GridData gd)
/*    */   {
/* 56 */     Button swordbutton = new Button(parent, style);
/* 57 */     if (text != null)
/* 58 */       swordbutton.setText(text);
/* 59 */     if (gd != null)
/* 60 */       swordbutton.setLayoutData(gd);
/* 61 */     return swordbutton;
/*    */   }
/*    */ 
/*    */   public static SashForm createSwordSashForm(Composite parent, int style, Point size, GridData gd, GridLayout layout)
/*    */   {
/* 67 */     SashForm swordsash = new SashForm(parent, style);
/* 68 */     if (layout != null)
/* 69 */       swordsash.setLayout(layout);
/* 70 */     if (gd != null)
/* 71 */       swordsash.setLayoutData(gd);
/* 72 */     if (size != null)
/* 73 */       swordsash.setSize(size);
/* 74 */     return swordsash;
/*    */   }
/*    */ 
/*    */   public static Group createSwordGroup(Composite parent, int style, GridData gd, GridLayout layout, String text)
/*    */   {
/* 80 */     Group swordGroup = new Group(parent, style);
/* 81 */     if (layout != null)
/* 82 */       swordGroup.setLayout(layout);
/* 83 */     if (gd != null)
/* 84 */       swordGroup.setLayoutData(gd);
/* 85 */     if (text != null)
/* 86 */       swordGroup.setText(text);
/* 87 */     return swordGroup;
/*    */   }
/*    */ 
/*    */   protected static GridData gdhfill() {
/* 91 */     return new GridData(768);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.utils.GuiHelper
 * JD-Core Version:    0.6.0
 */