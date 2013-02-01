/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.apache.commons.collections.map.LinkedMap;
/*     */ import org.hi.base.enumeration.EnumerationHelper;
/*     */ import org.hi.common.tools.Matcher;
/*     */ import org.hi.common.tools.NumberMatcher;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.web.taglib.component.TagBuilder;
/*     */ import org.hi.framework.web.taglib.component.TagBuilderFactory;
/*     */ import org.hi.framework.web.taglib.component.bean.SelectTagBean;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class SelectTag extends AbstractTag
/*     */ {
/*     */   public static final String SELECT_TAG_TYPE_SELECT = "select";
/*     */   public static final String SELECT_TAG_TYPE_RADIO = "radio";
/*     */   public static final String SELECT_TAG_TYPE_CHECKBOX = "checkbox";
/*     */   private String emu;
/*     */   private String defaultValue;
/*     */   private String maxIndex;
/*     */   private String name;
/*     */   private String onclick;
/*     */   private String isLabel;
/*     */   private String type;
/*     */   private String multiple;
/*     */   private String filterPattern;
/*     */   private String pattern;
/*     */   private String isBr;
/*     */   private String allSelected;
/*     */   private String isNull;
/*     */ 
/*     */   public String getEmu()
/*     */   {
/*  63 */     return this.emu;
/*     */   }
/*     */ 
/*     */   public void setEmu(String emu) {
/*  67 */     this.emu = emu;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  71 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  75 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getOnclick() {
/*  79 */     return this.onclick;
/*     */   }
/*     */ 
/*     */   public void setOnclick(String onclick) {
/*  83 */     this.onclick = onclick;
/*     */   }
/*     */ 
/*     */   public String getIsNull() {
/*  87 */     return this.isNull;
/*     */   }
/*     */ 
/*     */   public void setIsNull(String isNull) {
/*  91 */     this.isNull = isNull;
/*     */   }
/*     */ 
/*     */   public int doEndTag() throws JspException {
/*  95 */     evaluateParams();
/*     */ 
/*  97 */     TagBuilder builder = TagBuilderFactory.getSelectTagBuilder();
/*  98 */     SelectTagBean bean = new SelectTagBean();
/*  99 */     Map mapping = getEnumValueMap();
/* 100 */     Map resultMapping = new LinkedMap();
/* 101 */     if (needNull())
/* 102 */       resultMapping.put("", "");
/* 103 */     resultMapping.putAll(mapping);
/* 104 */     bean.setName(getName());
/* 105 */     bean.setMapping(resultMapping);
/* 106 */     bean.setBr(needBr());
/* 107 */     bean.setDefaultValue(getDefaultValue(getName()));
/* 108 */     bean.setLabel(needLabel());
/* 109 */     bean.setMultiple(needMultiple());
/* 110 */     bean.setAllSelected(needAllSelected());
/* 111 */     bean.setType(this.type == null ? "select" : this.type);
/* 112 */     bean.setParameters(getParameters());
/* 113 */     String html = builder.build(bean);
/*     */     try {
/* 115 */       this.pageContext.getOut().print(html);
/*     */     } catch (IOException e) {
/* 117 */       e.printStackTrace();
/*     */     }
/* 119 */     return 6;
/*     */   }
/*     */ 
/*     */   protected Map getEnumValueMap() {
/* 123 */     int maxIndexTmp = 2147483647;
/* 124 */     if ((this.maxIndex != null) && (!"".equals(this.maxIndex))) {
/* 125 */       maxIndexTmp = Integer.parseInt(this.maxIndex);
/*     */     }
/*     */ 
/* 128 */     Map mapping = EnumerationHelper.getEnumerationValueMap(getEmu(), getPattern(), getTitle());
/* 129 */     if ((this.filterPattern == null) || (this.filterPattern.trim().equals(""))) {
/* 130 */       if ((this.maxIndex != null) && (!"".equals(this.maxIndex))) {
/* 131 */         Map result = new LinkedHashMap();
/* 132 */         Set keys = mapping.keySet();
/* 133 */         for (Integer id : keys) {
/* 134 */           if (id.intValue() > maxIndexTmp)
/*     */             continue;
/* 136 */           result.put(id, (String)mapping.get(id));
/*     */         }
/* 138 */         return result;
/*     */       }
/* 140 */       return mapping;
/*     */     }
/* 142 */     Map result = new LinkedHashMap();
/* 143 */     Matcher matcher = new NumberMatcher();
/* 144 */     String[] patterns = this.filterPattern.split(",");
/* 145 */     Set keys = mapping.keySet();
/* 146 */     for (Integer id : keys) {
/* 147 */       if (id.intValue() > maxIndexTmp)
/*     */         continue;
/* 149 */       for (int i = 0; i < patterns.length; i++) {
/* 150 */         String pattern = patterns[i];
/*     */ 
/* 152 */         if ((matcher.isPattern(pattern)) && (matcher.match(pattern, id))) {
/* 153 */           result.put(id, I18NUtil.getString((String)mapping.get(id), getEmu()));
/* 154 */           break;
/*     */         }
/*     */ 
/* 157 */         if ((!matcher.isPattern(pattern)) && (pattern.equals(id.toString()))) {
/* 158 */           result.put(id, I18NUtil.getString((String)mapping.get(id), getEmu()));
/* 159 */           break;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 165 */     return result;
/*     */   }
/*     */ 
/*     */   protected String getDefaultValue(String fieldName)
/*     */   {
/* 170 */     int pointIndex = 0;
/* 171 */     pointIndex = fieldName.indexOf(".");
/* 172 */     if ((pointIndex <= 1) || (pointIndex + 1 >= fieldName.length()))
/* 173 */       return "";
/* 174 */     String beanName = fieldName.substring(0, fieldName.indexOf("."));
/* 175 */     String beanFieldName = fieldName.substring(fieldName.indexOf(".") + 1);
/* 176 */     Object bean = this.pageContext.getAttribute(beanName);
/*     */ 
/* 178 */     if (bean == null) {
/* 179 */       bean = this.pageContext.getRequest().getAttribute(beanName);
/*     */     }
/* 181 */     if (bean == null)
/* 182 */       return this.defaultValue != null ? this.defaultValue : "";
/* 183 */     String selectedValue = getSelectedValue();
/* 184 */     if (selectedValue != null)
/* 185 */       return selectedValue;
/* 186 */     Object returnValue = BeanUtil.getPropertyValue(bean, beanFieldName);
/* 187 */     if (returnValue != null) {
/* 188 */       return returnValue.toString();
/*     */     }
/* 190 */     return this.defaultValue != null ? this.defaultValue : "";
/*     */   }
/*     */ 
/*     */   protected String getSelectedValue()
/*     */   {
/* 195 */     if (this.value == null) return null;
/* 196 */     int pointIndex = 0;
/* 197 */     pointIndex = this.value.indexOf(".");
/* 198 */     if ((pointIndex <= 1) || (pointIndex + 1 >= this.value.length()))
/* 199 */       return null;
/* 200 */     String beanName = this.value.substring(0, this.value.indexOf("."));
/* 201 */     String beanFieldName = this.value.substring(this.value.indexOf(".") + 1);
/* 202 */     Object bean = this.pageContext.getRequest().getAttribute(beanName);
/* 203 */     if (bean == null) return null;
/*     */ 
/* 205 */     Object selectedValue = BeanUtil.getPropertyValue(bean, beanFieldName);
/* 206 */     if (selectedValue == null) return null;
/*     */ 
/* 208 */     return selectedValue.toString();
/*     */   }
/*     */ 
/*     */   private boolean needLabel() {
/* 212 */     return (getIsLabel() != null) && ("true".equals(getIsLabel()));
/*     */   }
/*     */ 
/*     */   private boolean needBr() {
/* 216 */     return (getIsBr() != null) && ("true".equals(getIsBr()));
/*     */   }
/*     */   private boolean needMultiple() {
/* 219 */     return (getMultiple() != null) && ("true".equals(getMultiple()));
/*     */   }
/*     */   private boolean needAllSelected() {
/* 222 */     return (getAllSelected() != null) && ("true".equals(getAllSelected()));
/*     */   }
/*     */ 
/*     */   private boolean needNull() {
/* 226 */     return (getIsNull() != null) && ("true".equals(getIsNull()));
/*     */   }
/*     */   public String getDefaultValue() {
/* 229 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */   public void setDefaultValue(String defaultValue) {
/* 233 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ 
/*     */   public String getIsLabel() {
/* 237 */     return this.isLabel;
/*     */   }
/*     */ 
/*     */   public void setIsLabel(String isLabel) {
/* 241 */     this.isLabel = isLabel;
/*     */   }
/*     */ 
/*     */   public String getMultiple() {
/* 245 */     return this.multiple;
/*     */   }
/*     */ 
/*     */   public void setMultiple(String multiple) {
/* 249 */     this.multiple = multiple;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 253 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 257 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getFilterPattern() {
/* 261 */     return this.filterPattern;
/*     */   }
/*     */ 
/*     */   public void setFilterPattern(String filterPattern) {
/* 265 */     this.filterPattern = filterPattern;
/*     */   }
/*     */ 
/*     */   public String getPattern()
/*     */   {
/* 270 */     return this.pattern;
/*     */   }
/*     */ 
/*     */   public void setPattern(String pattern) {
/* 274 */     this.pattern = pattern;
/*     */   }
/*     */ 
/*     */   public String getIsBr() {
/* 278 */     return this.isBr;
/*     */   }
/*     */ 
/*     */   public void setIsBr(String isBr) {
/* 282 */     this.isBr = isBr;
/*     */   }
/*     */ 
/*     */   public String getAllSelected() {
/* 286 */     return this.allSelected;
/*     */   }
/*     */ 
/*     */   public void setAllSelected(String allSelected) {
/* 290 */     this.allSelected = allSelected;
/*     */   }
/*     */ 
/*     */   public String getMaxIndex() {
/* 294 */     return this.maxIndex;
/*     */   }
/*     */ 
/*     */   public void setMaxIndex(String maxIndex) {
/* 298 */     this.maxIndex = maxIndex;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.SelectTag
 * JD-Core Version:    0.6.0
 */