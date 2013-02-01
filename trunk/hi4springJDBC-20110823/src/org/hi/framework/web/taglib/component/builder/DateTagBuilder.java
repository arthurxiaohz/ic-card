/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ 
/*    */ public class DateTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 21 */     String defaultValue = bean.getDefaultValue();
/* 22 */     String dateFormat = bean.getDateFormat() == null ? "yyyy-MM-dd" : bean.getDateFormat();
/* 23 */     if (defaultValue == null)
/* 24 */       defaultValue = "";
/* 25 */     return "<input type=\"text\" name=\"" + bean.getName() + "\" value=\"" + defaultValue + "\"" + " onFocus=\"WdatePicker({dateFmt:'" + dateFormat + "'})\"" + 
/* 26 */       BuilderTools.getParameters(bean.getParameters()) + "/>";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.DateTagBuilder
 * JD-Core Version:    0.6.0
 */