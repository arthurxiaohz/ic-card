/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import org.hi.studio.hsceditor.dialect.IColumnType;
/*    */ 
/*    */ public class DommainModel
/*    */   implements Cloneable
/*    */ {
/*    */   private String id;
/*    */   private String name;
/*    */   private IColumnType type;
/*    */   private String size;
/*    */ 
/*    */   public String getId()
/*    */   {
/* 17 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(String id) {
/* 21 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 25 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 29 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public IColumnType getType() {
/* 33 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(IColumnType type) {
/* 37 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getSize() {
/* 41 */     return this.size;
/*    */   }
/*    */ 
/*    */   public void setSize(String size) {
/* 45 */     this.size = size;
/*    */   }
/*    */ 
/*    */   public DommainModel clone() {
/* 49 */     DommainModel model = new DommainModel();
/* 50 */     model.setId(getId());
/* 51 */     model.setName(getName());
/* 52 */     model.setType(getType());
/* 53 */     model.setSize(getSize());
/* 54 */     return model;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 58 */     StringBuilder sb = new StringBuilder();
/* 59 */     sb.append(getName());
/* 60 */     sb.append(" - ");
/* 61 */     sb.append(getType().getName());
/* 62 */     if (getType().supportSize()) {
/* 63 */       sb.append("(");
/* 64 */       sb.append(getSize());
/* 65 */       sb.append(")");
/*    */     }
/* 67 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.DommainModel
 * JD-Core Version:    0.6.0
 */