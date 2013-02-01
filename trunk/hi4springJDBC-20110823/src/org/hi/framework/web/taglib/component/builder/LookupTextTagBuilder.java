/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*    */ 
/*    */ public class LookupTextTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 10 */     SelectTagBean selectBean = (SelectTagBean)bean;
/* 11 */     return "<span onclick=\"lookupPOP('" + selectBean.getLookup() + "')\" style=\"cursor: hand\">查找带回</span>";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.LookupTextTagBuilder
 * JD-Core Version:    0.6.0
 */