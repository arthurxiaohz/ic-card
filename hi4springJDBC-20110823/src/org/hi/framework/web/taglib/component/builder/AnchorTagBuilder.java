/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ 
/*    */ public class AnchorTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 22 */     String html = "<a href=\"" + bean.getUrl() + "\"  >" + bean.getDefaultValue() + 
/* 23 */       "</a>&nbsp;&nbsp;";
/* 24 */     return html;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.AnchorTagBuilder
 * JD-Core Version:    0.6.0
 */