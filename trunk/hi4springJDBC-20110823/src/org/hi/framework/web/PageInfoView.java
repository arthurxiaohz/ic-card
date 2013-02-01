/*    */ package org.hi.framework.web;
/*    */ 
/*    */ import org.hi.framework.paging.impl.PageImpl;
/*    */ 
/*    */ public class PageInfoView extends PageImpl
/*    */ {
/*    */   private static final long serialVersionUID = 7389809057021954833L;
/*    */   private String sorterName;
/*    */   private String sorterDirection;
/*    */ 
/*    */   public String getSorterDirection()
/*    */   {
/* 24 */     return this.sorterDirection;
/*    */   }
/*    */   public void setSorterDirection(String sorterDirection) {
/* 27 */     this.sorterDirection = sorterDirection;
/*    */   }
/*    */   public String getSorterName() {
/* 30 */     return this.sorterName;
/*    */   }
/*    */   public void setSorterName(String sorterName) {
/* 33 */     this.sorterName = sorterName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.PageInfoView
 * JD-Core Version:    0.6.0
 */