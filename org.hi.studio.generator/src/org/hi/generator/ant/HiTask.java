/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public abstract class HiTask extends HiBaseTask
/*    */ {
/*    */   protected HiGeneraterToolTask parent;
/* 13 */   protected final Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   public HiTask(HiGeneraterToolTask parent) {
/* 16 */     setParent(parent);
/*    */   }
/*    */   public abstract String getName();
/*    */ 
/*    */   public abstract Integer getSort();
/*    */ 
/* 24 */   public HiGeneraterToolTask getParent() { return this.parent; }
/*    */ 
/*    */   public void setParent(HiGeneraterToolTask parent)
/*    */   {
/* 28 */     this.parent = parent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.HiTask
 * JD-Core Version:    0.6.0
 */