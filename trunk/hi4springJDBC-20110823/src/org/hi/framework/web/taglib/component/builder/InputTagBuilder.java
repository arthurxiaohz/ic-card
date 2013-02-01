/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ 
/*    */ public class InputTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 21 */     return "<input type=\"text\" name=\"" + bean.getName() + "\" value=\"" + bean.getDefaultValue() + "\"" + 
/* 22 */       BuilderTools.getParameters(bean.getParameters()) + "/>";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.InputTagBuilder
 * JD-Core Version:    0.6.0
 */