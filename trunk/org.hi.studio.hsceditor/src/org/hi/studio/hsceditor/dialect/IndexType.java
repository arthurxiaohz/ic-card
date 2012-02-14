/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class IndexType
/*    */   implements IIndexType, Serializable
/*    */ {
/*    */   private String name;
/*    */ 
/*    */   public IndexType(String name)
/*    */   {
/*  9 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 13 */     return this.name;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.IndexType
 * JD-Core Version:    0.6.0
 */