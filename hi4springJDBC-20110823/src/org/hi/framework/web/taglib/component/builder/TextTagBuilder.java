/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ 
/*    */ public class TextTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 22 */     String html = bean.getDefaultValue();
/* 23 */     return html + "&nbsp;&nbsp;";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.TextTagBuilder
 * JD-Core Version:    0.6.0
 */