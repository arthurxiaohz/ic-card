/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import javax.servlet.jsp.tagext.TagSupport;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ 
/*     */ public abstract class AbstractTag extends TagSupport
/*     */ {
/*  18 */   protected Map parameters = new HashMap();
/*     */   protected String cssClass;
/*     */   protected String cssStyle;
/*     */   protected String id;
/*  25 */   protected String size = "15";
/*     */   protected String title;
/*     */   protected String disabled;
/*     */   protected String label;
/*     */   protected String labelPosition;
/*     */   protected String requiredposition;
/*     */   protected String name;
/*     */   protected String required;
/*     */   protected String tabindex;
/*     */   protected String value;
/*     */   protected String template;
/*     */   protected String theme;
/*     */   protected String templateDir;
/*     */   protected String onclick;
/*     */   protected String ondblclick;
/*     */   protected String onmousedown;
/*     */   protected String onmouseup;
/*     */   protected String onmouseover;
/*     */   protected String onmousemove;
/*     */   protected String onmouseout;
/*     */   protected String onfocus;
/*     */   protected String onblur;
/*     */   protected String onkeypress;
/*     */   protected String onkeydown;
/*     */   protected String onkeyup;
/*     */   protected String onselect;
/*     */   protected String onchange;
/*     */   protected String accesskey;
/*     */   protected String tooltip;
/*     */   protected String tooltipConfig;
/*     */ 
/*     */   public String getAccesskey()
/*     */   {
/*  86 */     return this.accesskey;
/*     */   }
/*     */ 
/*     */   public void setAccesskey(String accesskey) {
/*  90 */     this.accesskey = accesskey;
/*     */   }
/*     */ 
/*     */   public String getCssClass() {
/*  94 */     return this.cssClass;
/*     */   }
/*     */ 
/*     */   public void setCssClass(String cssClass) {
/*  98 */     this.cssClass = cssClass;
/*     */   }
/*     */ 
/*     */   public String getCssStyle() {
/* 102 */     return this.cssStyle;
/*     */   }
/*     */ 
/*     */   public void setCssStyle(String cssStyle) {
/* 106 */     this.cssStyle = cssStyle;
/*     */   }
/*     */ 
/*     */   public String getDisabled() {
/* 110 */     return this.disabled;
/*     */   }
/*     */ 
/*     */   public void setDisabled(String disabled) {
/* 114 */     this.disabled = disabled;
/*     */   }
/*     */ 
/*     */   public String getLabel() {
/* 118 */     return this.label;
/*     */   }
/*     */ 
/*     */   public void setLabel(String label) {
/* 122 */     this.label = label;
/*     */   }
/*     */ 
/*     */   public String getLabelPosition() {
/* 126 */     return this.labelPosition;
/*     */   }
/*     */ 
/*     */   public void setLabelPosition(String labelPosition) {
/* 130 */     this.labelPosition = labelPosition;
/*     */   }
/*     */ 
/*     */   public String getId() {
/* 134 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/* 138 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 142 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 146 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getOnblur() {
/* 150 */     return this.onblur;
/*     */   }
/*     */ 
/*     */   public void setOnblur(String onblur) {
/* 154 */     this.onblur = onblur;
/*     */   }
/*     */ 
/*     */   public String getOnchange() {
/* 158 */     return this.onchange;
/*     */   }
/*     */ 
/*     */   public void setOnchange(String onchange) {
/* 162 */     this.onchange = onchange;
/*     */   }
/*     */ 
/*     */   public String getOnclick() {
/* 166 */     return this.onclick;
/*     */   }
/*     */ 
/*     */   public void setOnclick(String onclick) {
/* 170 */     this.onclick = onclick;
/*     */   }
/*     */ 
/*     */   public String getOndblclick() {
/* 174 */     return this.ondblclick;
/*     */   }
/*     */ 
/*     */   public void setOndblclick(String ondblclick) {
/* 178 */     this.ondblclick = ondblclick;
/*     */   }
/*     */ 
/*     */   public String getOnfocus() {
/* 182 */     return this.onfocus;
/*     */   }
/*     */ 
/*     */   public void setOnfocus(String onfocus) {
/* 186 */     this.onfocus = onfocus;
/*     */   }
/*     */ 
/*     */   public String getOnkeydown() {
/* 190 */     return this.onkeydown;
/*     */   }
/*     */ 
/*     */   public void setOnkeydown(String onkeydown) {
/* 194 */     this.onkeydown = onkeydown;
/*     */   }
/*     */ 
/*     */   public String getOnkeypress() {
/* 198 */     return this.onkeypress;
/*     */   }
/*     */ 
/*     */   public void setOnkeypress(String onkeypress) {
/* 202 */     this.onkeypress = onkeypress;
/*     */   }
/*     */ 
/*     */   public String getOnkeyup() {
/* 206 */     return this.onkeyup;
/*     */   }
/*     */ 
/*     */   public void setOnkeyup(String onkeyup) {
/* 210 */     this.onkeyup = onkeyup;
/*     */   }
/*     */ 
/*     */   public String getOnmousedown() {
/* 214 */     return this.onmousedown;
/*     */   }
/*     */ 
/*     */   public void setOnmousedown(String onmousedown) {
/* 218 */     this.onmousedown = onmousedown;
/*     */   }
/*     */ 
/*     */   public String getOnmousemove() {
/* 222 */     return this.onmousemove;
/*     */   }
/*     */ 
/*     */   public void setOnmousemove(String onmousemove) {
/* 226 */     this.onmousemove = onmousemove;
/*     */   }
/*     */ 
/*     */   public String getOnmouseout() {
/* 230 */     return this.onmouseout;
/*     */   }
/*     */ 
/*     */   public void setOnmouseout(String onmouseout) {
/* 234 */     this.onmouseout = onmouseout;
/*     */   }
/*     */ 
/*     */   public String getOnmouseover() {
/* 238 */     return this.onmouseover;
/*     */   }
/*     */ 
/*     */   public void setOnmouseover(String onmouseover) {
/* 242 */     this.onmouseover = onmouseover;
/*     */   }
/*     */ 
/*     */   public String getOnmouseup() {
/* 246 */     return this.onmouseup;
/*     */   }
/*     */ 
/*     */   public void setOnmouseup(String onmouseup) {
/* 250 */     this.onmouseup = onmouseup;
/*     */   }
/*     */ 
/*     */   public String getOnselect() {
/* 254 */     return this.onselect;
/*     */   }
/*     */ 
/*     */   public void setOnselect(String onselect) {
/* 258 */     this.onselect = onselect;
/*     */   }
/*     */ 
/*     */   public String getRequired() {
/* 262 */     return this.required;
/*     */   }
/*     */ 
/*     */   public void setRequired(String required) {
/* 266 */     this.required = required;
/*     */   }
/*     */ 
/*     */   public String getRequiredposition() {
/* 270 */     return this.requiredposition;
/*     */   }
/*     */ 
/*     */   public void setRequiredposition(String requiredposition) {
/* 274 */     this.requiredposition = requiredposition;
/*     */   }
/*     */ 
/*     */   public String getTabindex() {
/* 278 */     return this.tabindex;
/*     */   }
/*     */ 
/*     */   public void setTabindex(String tabindex) {
/* 282 */     this.tabindex = tabindex;
/*     */   }
/*     */ 
/*     */   public String getTemplate() {
/* 286 */     return this.template;
/*     */   }
/*     */ 
/*     */   public void setTemplate(String template) {
/* 290 */     this.template = template;
/*     */   }
/*     */ 
/*     */   public String getTemplateDir() {
/* 294 */     return this.templateDir;
/*     */   }
/*     */ 
/*     */   public void setTemplateDir(String templateDir) {
/* 298 */     this.templateDir = templateDir;
/*     */   }
/*     */ 
/*     */   public String getTheme() {
/* 302 */     return this.theme;
/*     */   }
/*     */ 
/*     */   public void setTheme(String theme) {
/* 306 */     this.theme = theme;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 310 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 314 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getTooltip() {
/* 318 */     return this.tooltip;
/*     */   }
/*     */ 
/*     */   public void setTooltip(String tooltip) {
/* 322 */     this.tooltip = tooltip;
/*     */   }
/*     */ 
/*     */   public String getTooltipConfig() {
/* 326 */     return this.tooltipConfig;
/*     */   }
/*     */ 
/*     */   public void setTooltipConfig(String tooltipConfig) {
/* 330 */     this.tooltipConfig = tooltipConfig;
/*     */   }
/*     */ 
/*     */   public String getValue() {
/* 334 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value) {
/* 338 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public String getSize() {
/* 342 */     return this.size;
/*     */   }
/*     */ 
/*     */   public void setSize(String size) {
/* 346 */     this.size = size;
/*     */   }
/*     */ 
/*     */   protected String findString(String expr) {
/* 350 */     return findValue(expr, String.class);
/*     */   }
/*     */ 
/*     */   protected String findValue(String expr, Class toType) {
/* 354 */     return expr;
/*     */   }
/*     */ 
/*     */   public void evaluateParams()
/*     */   {
/* 359 */     addParameter("templateDir", getTemplateDir());
/*     */ 
/* 361 */     if (this.name != null) {
/* 362 */       addParameter("name", findString(this.name));
/*     */     }
/*     */ 
/* 365 */     if (this.id != null) {
/* 366 */       addParameter("id", findString(this.id));
/*     */     }
/*     */ 
/* 369 */     if (this.label != null) {
/* 370 */       addParameter("label", findString(this.label));
/*     */     }
/*     */ 
/* 373 */     if (this.labelPosition != null) {
/* 374 */       addParameter("labelposition", findString(this.labelPosition));
/*     */     }
/*     */ 
/* 377 */     if (this.requiredposition != null) {
/* 378 */       addParameter("requiredposition", findString(this.requiredposition));
/*     */     }
/*     */ 
/* 381 */     if (this.required != null) {
/* 382 */       addParameter("required", findValue(this.required, Boolean.class));
/*     */     }
/*     */ 
/* 385 */     if (this.disabled != null) {
/* 386 */       addParameter("disabled", findValue(this.disabled, Boolean.class));
/*     */     }
/*     */ 
/* 389 */     if (this.tabindex != null) {
/* 390 */       addParameter("tabindex", findString(this.tabindex));
/*     */     }
/*     */ 
/* 393 */     if (this.onclick != null) {
/* 394 */       addParameter("onclick", findString(this.onclick));
/*     */     }
/*     */ 
/* 397 */     if (this.ondblclick != null) {
/* 398 */       addParameter("ondblclick", findString(this.ondblclick));
/*     */     }
/*     */ 
/* 401 */     if (this.onmousedown != null) {
/* 402 */       addParameter("onmousedown", findString(this.onmousedown));
/*     */     }
/*     */ 
/* 405 */     if (this.onmouseup != null) {
/* 406 */       addParameter("onmouseup", findString(this.onmouseup));
/*     */     }
/*     */ 
/* 409 */     if (this.onmouseover != null) {
/* 410 */       addParameter("onmouseover", findString(this.onmouseover));
/*     */     }
/*     */ 
/* 413 */     if (this.onmousemove != null) {
/* 414 */       addParameter("onmousemove", findString(this.onmousemove));
/*     */     }
/*     */ 
/* 417 */     if (this.onmouseout != null) {
/* 418 */       addParameter("onmouseout", findString(this.onmouseout));
/*     */     }
/*     */ 
/* 421 */     if (this.onfocus != null) {
/* 422 */       addParameter("onfocus", findString(this.onfocus));
/*     */     }
/*     */ 
/* 425 */     if (this.onblur != null) {
/* 426 */       addParameter("onblur", findString(this.onblur));
/*     */     }
/*     */ 
/* 429 */     if (this.onkeypress != null) {
/* 430 */       addParameter("onkeypress", findString(this.onkeypress));
/*     */     }
/*     */ 
/* 433 */     if (this.onkeydown != null) {
/* 434 */       addParameter("onkeydown", findString(this.onkeydown));
/*     */     }
/*     */ 
/* 437 */     if (this.onkeyup != null) {
/* 438 */       addParameter("onkeyup", findString(this.onkeyup));
/*     */     }
/*     */ 
/* 441 */     if (this.onselect != null) {
/* 442 */       addParameter("onselect", findString(this.onselect));
/*     */     }
/*     */ 
/* 445 */     if (this.onchange != null) {
/* 446 */       addParameter("onchange", findString(this.onchange));
/*     */     }
/*     */ 
/* 449 */     if (this.accesskey != null) {
/* 450 */       addParameter("accesskey", findString(this.accesskey));
/*     */     }
/*     */ 
/* 453 */     if (this.cssClass != null) {
/* 454 */       addParameter("class", findString(this.cssClass));
/*     */     }
/*     */ 
/* 457 */     if (this.cssStyle != null) {
/* 458 */       addParameter("style", findString(this.cssStyle));
/*     */     }
/*     */ 
/* 461 */     if (this.title != null)
/* 462 */       addParameter("title", findString(this.title));
/*     */   }
/*     */ 
/*     */   public Map getParameters()
/*     */   {
/* 471 */     return this.parameters;
/*     */   }
/*     */ 
/*     */   public void addAllParameters(Map params)
/*     */   {
/* 479 */     this.parameters.putAll(params);
/*     */   }
/*     */ 
/*     */   public void addParameter(String key, Object value)
/*     */   {
/* 492 */     if (key != null) {
/* 493 */       Map params = getParameters();
/*     */ 
/* 495 */       if (value == null)
/* 496 */         params.remove(key);
/*     */       else
/* 498 */         params.put(key, value);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object getParameter(String parameterName)
/*     */   {
/* 504 */     return getParameter(parameterName, null);
/*     */   }
/*     */   public Object getParameter(String parameterName, String prefix) {
/* 507 */     Object value = this.pageContext.getRequest().getParameter(parameterName);
/* 508 */     if (value != null) {
/* 509 */       return value;
/*     */     }
/* 511 */     if (parameterName.indexOf(".") > 0) {
/* 512 */       String attributeName = parameterName.substring(0, parameterName.indexOf("."));
/* 513 */       if ((attributeName != null) && (this.pageContext.getRequest().getAttribute(attributeName) != null)) {
/* 514 */         value = BeanUtil.getPropertyValue(this.pageContext.getRequest().getAttribute(attributeName), parameterName.substring(parameterName.indexOf(".") + 1));
/*     */       }
/*     */     }
/*     */ 
/* 518 */     if (value != null) {
/* 519 */       return value;
/*     */     }
/* 521 */     if (prefix == null) {
/* 522 */       return null;
/*     */     }
/* 524 */     Object attribute = this.pageContext.getRequest().getAttribute(prefix);
/* 525 */     return BeanUtil.getPropertyValue(attribute, parameterName);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.AbstractTag
 * JD-Core Version:    0.6.0
 */