/*     */ package org.hi.framework.web.taglib.component.builder;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.web.taglib.component.TagBuilder;
/*     */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*     */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*     */ 
/*     */ public class SelectTagBuilder
/*     */   implements TagBuilder
/*     */ {
/*     */   public String build(TagInfoBean bean)
/*     */   {
/*  33 */     SelectTagBean selectBean = (SelectTagBean)bean;
/*  34 */     Map mapping = selectBean.getMapping();
/*     */ 
/*  36 */     Set values = new LinkedHashSet();
/*     */ 
/*  38 */     String key = selectBean.getDefaultValue().trim();
/*     */ 
/*  40 */     if (key != null)
/*     */     {
/*  42 */       values = StringUtils.strToSet(key);
/*     */     }
/*     */ 
/*  48 */     if (selectBean.isLabel())
/*     */     {
/*  50 */       if ((key == null) || (key.trim().equals(""))) {
/*  51 */         return "";
/*     */       }
/*     */ 
/*  54 */       StringBuffer sb = new StringBuffer("");
/*  55 */       int i = 0;
/*  56 */       for (String value : values) {
/*  57 */         Object obj = mapping.get(new Integer(value));
/*     */ 
/*  59 */         if (i > 0) {
/*  60 */           sb.append(",");
/*     */         }
/*  62 */         if (obj != null) {
/*  63 */           sb.append(obj);
/*     */         }
/*  65 */         i++;
/*     */       }
/*     */ 
/*  68 */       return sb.toString();
/*     */     }
/*     */ 
/*  71 */     if (selectBean.getType().equals("select")) {
/*  72 */       return buildSelect(selectBean, bean, values);
/*     */     }
/*  74 */     if ((selectBean.getType().equals("checkbox")) || (selectBean.getType().equals("radio"))) {
/*  75 */       return buildCheck(selectBean, bean, values, selectBean.getType());
/*     */     }
/*  77 */     return "";
/*     */   }
/*     */ 
/*     */   protected String buildSelect(SelectTagBean selectBean, TagInfoBean bean, Set values)
/*     */   {
/*  82 */     Map mapping = selectBean.getMapping();
/*  83 */     StringBuffer sb = new StringBuffer();
/*  84 */     sb.append("<select");
/*  85 */     sb.append(" name=\"" + selectBean.getName() + "\" ");
/*  86 */     sb.append(BuilderTools.getParameters(bean.getParameters()));
/*  87 */     if (selectBean.isMultiple())
/*  88 */       sb.append(" multiple=\"multiple\"");
/*  89 */     sb.append(" >");
/*     */ 
/*  91 */     Iterator it = mapping.keySet().iterator();
/*  92 */     while (it.hasNext()) {
/*  93 */       Object keyValue = it.next();
/*  94 */       String value = (String)mapping.get(keyValue);
/*  95 */       String selected = "";
/*  96 */       if ((selectBean.getDefaultValue() != null) && 
/*  97 */         (values.contains(keyValue.toString()))) {
/*  98 */         selected = "selected";
/*     */       }
/* 100 */       if ((selectBean.isMultiple()) && ((bean instanceof SelectTagBean)) && (values.size() == 0) && (((SelectTagBean)bean).isAllSelected())) {
/* 101 */         selected = "selected";
/*     */       }
/* 103 */       sb.append(" <option " + selected + " value=\"" + keyValue + "\">");
/* 104 */       sb.append(value + "</option>");
/*     */     }
/* 106 */     sb.append("</select>");
/* 107 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   protected String buildCheck(SelectTagBean selectBean, TagInfoBean bean, Set<String> values, String type) {
/* 111 */     Map mapping = selectBean.getMapping();
/* 112 */     StringBuffer sb = new StringBuffer();
/* 113 */     Iterator it = mapping.keySet().iterator();
/* 114 */     while (it.hasNext()) {
/* 115 */       Object keyValue = it.next();
/* 116 */       String value = (String)mapping.get(keyValue);
/* 117 */       String selected = "";
/* 118 */       if ((((bean instanceof SelectTagBean)) && (values.size() == 0) && (((SelectTagBean)bean).isAllSelected())) || (
/* 119 */         (selectBean.getDefaultValue() != null) && (values.contains(keyValue.toString())))) {
/* 120 */         selected = "checked";
/*     */       }
/* 122 */       sb.append("<label ").append(BuilderTools.getParameters(bean.getParameters())).append(">");
/* 123 */       sb.append("<input type=\"" + type + "\" name=\"" + bean.getName() + "\" value=\"" + keyValue + "\" ");
/* 124 */       sb.append(BuilderTools.getParameters(bean.getParameters()));
/* 125 */       sb.append(selected).append(" ");
/* 126 */       sb.append("/>" + value);
/* 127 */       sb.append("</label>");
/* 128 */       if (((bean instanceof SelectTagBean)) && (((SelectTagBean)bean).isBr())) {
/* 129 */         sb.append("<br>");
/*     */       }
/*     */     }
/* 132 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.SelectTagBuilder
 * JD-Core Version:    0.6.0
 */