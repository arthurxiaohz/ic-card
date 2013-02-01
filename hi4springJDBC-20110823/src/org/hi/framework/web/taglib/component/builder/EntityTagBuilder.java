/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.hi.framework.web.taglib.component.TagBuilder;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*    */ 
/*    */ public class EntityTagBuilder
/*    */   implements TagBuilder
/*    */ {
/*    */   public String build(TagInfoBean bean)
/*    */   {
/* 19 */     SelectTagBean selectBean = (SelectTagBean)bean;
/* 20 */     Map mapping = selectBean.getMapping();
/* 21 */     StringBuffer sb = new StringBuffer();
/*    */ 
/* 23 */     sb.append("<select");
/* 24 */     sb.append(BuilderTools.getParameters(bean.getParameters()));
/*    */ 
/* 26 */     if ((bean.getOnEvent() != null) && (!bean.getOnEvent().trim().equals(""))) {
/* 27 */       String onEvent = "onchange=\"javascript:" + bean.getOnEvent() + "\"";
/* 28 */       sb.append(" " + onEvent);
/*    */     }
/*    */ 
/* 31 */     sb.append(" >");
/*    */ 
/* 33 */     Iterator it = mapping.keySet().iterator();
/* 34 */     while (it.hasNext()) {
/* 35 */       Object key = it.next();
/* 36 */       String value = (String)mapping.get(key);
/* 37 */       String selected = "";
/* 38 */       if ((selectBean.getDefaultValue() != null) && 
/* 39 */         (selectBean.getDefaultValue().equals(key.toString()))) {
/* 40 */         selected = "selected";
/*    */       }
/* 42 */       sb.append(" <option " + selected + " value=\"" + key + "\">");
/* 43 */       sb.append(value + "</option>");
/*    */     }
/* 45 */     sb.append("</select>");
/* 46 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.EntityTagBuilder
 * JD-Core Version:    0.6.0
 */