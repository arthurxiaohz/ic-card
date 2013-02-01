/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.apache.commons.collections.map.LinkedMap;
/*     */ import org.apache.commons.lang.StringEscapeUtils;
/*     */ import org.hi.base.enumeration.EnumerationHelper;
/*     */ import org.hi.common.tools.Matcher;
/*     */ import org.hi.common.tools.NumberMatcher;
/*     */ import org.hi.framework.web.taglib.component.TagBuilder;
/*     */ import org.hi.framework.web.taglib.component.TagBuilderFactory;
/*     */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*     */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class SearchListTag extends AbstractTag
/*     */ {
/*     */   private String name;
/*     */   private String emu;
/*     */   private String defaultValue;
/*     */   private String id;
/*     */   private String lookup;
/*     */   private String needSelect;
/*     */   private String br;
/*     */   private String isDate;
/*     */   private String dateFormat;
/*     */   private String filterPattern;
/*     */   private String pattern;
/*     */ 
/*     */   public String getFilterPattern()
/*     */   {
/*  45 */     return this.filterPattern;
/*     */   }
/*     */ 
/*     */   public void setFilterPattern(String filterPattern) {
/*  49 */     this.filterPattern = filterPattern;
/*     */   }
/*     */ 
/*     */   public String getDateFormat() {
/*  53 */     return this.dateFormat;
/*     */   }
/*     */ 
/*     */   public void setDateFormat(String dateFormat) {
/*  57 */     this.dateFormat = dateFormat;
/*     */   }
/*     */ 
/*     */   public String getIsDate() {
/*  61 */     return this.isDate;
/*     */   }
/*     */ 
/*     */   public void setIsDate(String isDate) {
/*  65 */     this.isDate = isDate;
/*     */   }
/*     */ 
/*     */   public int doEndTag() throws JspException {
/*  69 */     StringBuffer sb = new StringBuffer();
/*  70 */     evaluateParams();
/*  71 */     if (needSelect()) {
/*  72 */       sb.append(buildSelect());
/*     */     }
/*  74 */     sb.append(builderInput());
/*     */ 
/*  76 */     if (isDateInput()) {
/*  77 */       sb = new StringBuffer();
/*  78 */       sb.append(builderDateInput());
/*     */     }
/*  80 */     if (isLookUp()) {
/*  81 */       sb.append(builderLookup());
/*     */     }
/*  83 */     if (isEmu()) {
/*  84 */       sb = new StringBuffer();
/*  85 */       sb.append(buildSelectElement());
/*     */     }
/*  87 */     if (needBR())
/*  88 */       sb.append("<br/>");
/*     */     try
/*     */     {
/*  91 */       this.pageContext.getOut().print(sb.toString());
/*     */     } catch (IOException e) {
/*  93 */       e.printStackTrace();
/*     */     }
/*  95 */     return 6;
/*     */   }
/*     */   private String buildSelectElement() {
/*  98 */     TagBuilder builder = TagBuilderFactory.getSelectTagBuilder();
/*  99 */     SelectTagBean bean = new SelectTagBean();
/* 100 */     Map emuMapping = getEnumValueMap();
/* 101 */     Map resultMapping = new LinkedMap();
/* 102 */     resultMapping.put("", I18NUtil.getString("全部"));
/* 103 */     resultMapping.putAll(emuMapping);
/* 104 */     bean.setName(getName());
/* 105 */     bean.setType("select");
/* 106 */     bean.setMultiple(false);
/* 107 */     bean.setMapping(resultMapping);
/* 108 */     bean.setDefaultValue(getPageDefaultValue());
/* 109 */     bean.setParameters(getParameters());
/* 110 */     String html = builder.build(bean);
/* 111 */     return html;
/*     */   }
/*     */ 
/*     */   protected Map getEnumValueMap() {
/* 115 */     Map mapping = EnumerationHelper.getEnumerationValueMap(getEmu(), getPattern(), getTitle());
/* 116 */     if ((this.filterPattern == null) || (this.filterPattern.trim().equals(""))) {
/* 117 */       return mapping;
/*     */     }
/* 119 */     Map result = new LinkedHashMap();
/* 120 */     Matcher matcher = new NumberMatcher();
/* 121 */     String[] patterns = this.filterPattern.split(",");
/* 122 */     Set keys = mapping.keySet();
/* 123 */     for (Integer id : keys) {
/* 124 */       for (int i = 0; i < patterns.length; i++) {
/* 125 */         String pattern = patterns[i];
/*     */ 
/* 127 */         if ((matcher.isPattern(pattern)) && (matcher.match(pattern, id))) {
/* 128 */           result.put(id, I18NUtil.getString((String)mapping.get(id), getEmu()));
/* 129 */           break;
/*     */         }
/*     */ 
/* 132 */         if ((!matcher.isPattern(pattern)) && (pattern.equals(id.toString()))) {
/* 133 */           result.put(id, I18NUtil.getString((String)mapping.get(id), getEmu()));
/* 134 */           break;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 140 */     return result;
/*     */   }
/*     */ 
/*     */   private boolean isEmu()
/*     */   {
/* 145 */     return getEmu() != null;
/*     */   }
/*     */   private boolean isLookUp() {
/* 148 */     return getLookup() != null;
/*     */   }
/*     */ 
/*     */   private String builderLookup() {
/* 152 */     TagBuilder builder = TagBuilderFactory.getLookupTagBuilder();
/* 153 */     SelectTagBean bean = new SelectTagBean();
/* 154 */     bean.setName(getName());
/* 155 */     bean.setLookup(this.lookup);
/* 156 */     bean.setParameters(getParameters());
/* 157 */     return builder.build(bean);
/*     */   }
/*     */ 
/*     */   private String builderDateInput() {
/* 161 */     TagBuilder builder = TagBuilderFactory.getDateTagBuilder();
/* 162 */     TagInfoBean bean = new TagInfoBean();
/* 163 */     bean.setName(getName());
/* 164 */     bean.setDateFormat(this.dateFormat);
/* 165 */     bean.setDefaultValue(getPageDefaultValue());
/* 166 */     bean.setParameters(getParameters());
/* 167 */     return builder.build(bean);
/*     */   }
/*     */ 
/*     */   private String builderInput() {
/* 171 */     TagBuilder builder = TagBuilderFactory.getInputTagBuilder();
/* 172 */     TagInfoBean bean = new TagInfoBean();
/* 173 */     bean.setName(getName());
/* 174 */     bean.setDefaultValue(getPageDefaultValue());
/* 175 */     bean.setParameters(getParameters());
/* 176 */     return builder.build(bean);
/*     */   }
/*     */ 
/*     */   private boolean isDateInput() {
/* 180 */     return (getIsDate() != null) && ("true".equals(getIsDate()));
/*     */   }
/*     */ 
/*     */   private boolean needBR() {
/* 184 */     return (getBr() == null) || ("true".equals(getBr()));
/*     */   }
/*     */ 
/*     */   private String buildSelect() {
/* 188 */     TagBuilder builder = TagBuilderFactory.getSelectTagBuilder();
/* 189 */     SelectTagBean bean = new SelectTagBean();
/* 190 */     Map map = new LinkedHashMap();
/* 191 */     map.put("", I18NUtil.getString("操作符"));
/* 192 */     map.put("&lt;", I18NUtil.getString("小于"));
/* 193 */     map.put("&gt;", I18NUtil.getString("大于"));
/* 194 */     map.put("=", I18NUtil.getString("等于"));
/* 195 */     map.put("&lt;=", I18NUtil.getString("小于等于"));
/* 196 */     map.put("&gt;=", I18NUtil.getString("大于等于"));
/* 197 */     bean.setMapping(map);
/* 198 */     bean.setType("select");
/* 199 */     bean.setMultiple(false);
/* 200 */     bean.setName(getName() + "_op");
/*     */ 
/* 202 */     bean.setDefaultValue(getParameter(bean.getName()) == null ? "" : StringEscapeUtils.escapeHtml(getParameter(bean.getName()).toString()));
/* 203 */     return builder.build(bean);
/*     */   }
/*     */ 
/*     */   private String getPageDefaultValue() {
/* 207 */     Object value = getParameter(getName());
/*     */ 
/* 209 */     return value == null ? "" : value.toString();
/*     */   }
/*     */ 
/*     */   private boolean needSelect() {
/* 213 */     boolean needSelect = false;
/* 214 */     if ("true".equals(getNeedSelect())) {
/* 215 */       needSelect = true;
/*     */     }
/* 217 */     return needSelect;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 221 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 225 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getNeedSelect() {
/* 229 */     return this.needSelect;
/*     */   }
/*     */ 
/*     */   public void setNeedSelect(String needSelect) {
/* 233 */     this.needSelect = needSelect;
/*     */   }
/*     */ 
/*     */   public String getBr() {
/* 237 */     return this.br;
/*     */   }
/*     */ 
/*     */   public void setBr(String br) {
/* 241 */     this.br = br;
/*     */   }
/*     */ 
/*     */   public String getId() {
/* 245 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/* 249 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getLookup() {
/* 253 */     return this.lookup;
/*     */   }
/*     */ 
/*     */   public void setLookup(String lookup) {
/* 257 */     this.lookup = lookup;
/*     */   }
/*     */ 
/*     */   public void setEmu(String emu)
/*     */   {
/* 263 */     this.emu = emu;
/*     */   }
/*     */ 
/*     */   public String getDefaultValue() {
/* 267 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */   public void setDefaultValue(String defaultValue) {
/* 271 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ 
/*     */   public String getEmu() {
/* 275 */     return this.emu;
/*     */   }
/*     */ 
/*     */   public String getPattern() {
/* 279 */     return this.pattern;
/*     */   }
/*     */ 
/*     */   public void setPattern(String pattern) {
/* 283 */     this.pattern = pattern;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.SearchListTag
 * JD-Core Version:    0.6.0
 */