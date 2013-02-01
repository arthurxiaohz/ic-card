/*    */ package org.hi.framework.web.taglib.component.bean;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ 
/*    */ public class SelectTagBean extends TagInfoBean
/*    */ {
/*    */   private Map mapping;
/*    */   private String lookup;
/*    */   private boolean isBr;
/*    */   private boolean allSelected;
/*    */ 
/*    */   public Map getMapping()
/*    */   {
/* 21 */     return this.mapping;
/*    */   }
/*    */ 
/*    */   public void setMapping(Map mapping) {
/* 25 */     this.mapping = mapping;
/*    */   }
/*    */ 
/*    */   public String getLookup() {
/* 29 */     return this.lookup;
/*    */   }
/*    */ 
/*    */   public void setLookup(String lookup) {
/* 33 */     this.lookup = lookup;
/*    */   }
/*    */ 
/*    */   public boolean isBr() {
/* 37 */     return this.isBr;
/*    */   }
/*    */ 
/*    */   public void setBr(boolean isBr) {
/* 41 */     this.isBr = isBr;
/*    */   }
/*    */ 
/*    */   public boolean isAllSelected() {
/* 45 */     return this.allSelected;
/*    */   }
/*    */ 
/*    */   public void setAllSelected(boolean allSelected) {
/* 49 */     this.allSelected = allSelected;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.bean.SelectTagBean
 * JD-Core Version:    0.6.0
 */