/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*    */ 
/*    */ public class LookupTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 10 */     SelectTagBean selectBean = (SelectTagBean)bean;
/* 11 */     String lookup = selectBean.getLookup();
/* 12 */     String prefix = lookup.substring(0, lookup.indexOf("_") + 1);
/* 13 */     String lookupName = lookup.substring(prefix.length());
/* 14 */     return "<span onclick=\"" + prefix + "lookupPOP('" + lookupName + "')\"><img src=\"/images/lookup.gif\" width=\"18\" height=\"17\" border=\"0\" style=\"cursor: hand\"/></span>";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.LookupTagBuilder
 * JD-Core Version:    0.6.0
 */