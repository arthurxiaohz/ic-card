/*     */ package org.hi.framework.web.taglib.i18n;
/*     */ 
/*     */ import com.opensymphony.util.TextUtils;
/*     */ import com.opensymphony.webwork.components.Component;
/*     */ import com.opensymphony.webwork.views.jsp.PropertyTag;
/*     */ import com.opensymphony.xwork.util.OgnlValueStack;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.i18n.model.LanguageCode;
/*     */ import org.hi.i18n.service.LanguageCodeManager;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class MLText extends PropertyTag
/*     */ {
/*     */   private String value;
/*  30 */   LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*     */ 
/*     */   public int doStartTag() throws JspException
/*     */   {
/*  34 */     List allLanguageCodes = this.languageCodeMgr.getObjects();
/*     */ 
/*  36 */     this.component = getBean(getStack(), (HttpServletRequest)this.pageContext.getRequest(), (HttpServletResponse)this.pageContext.getResponse());
/*  37 */     populateParams();
/*  38 */     String textValue = this.component.getStack().findValue(this.value, String.class).toString();
/*  39 */     String returnHTML = "<input type=\"text\" class=\"EditTableDataText\" id=\"" + this.value + "\" name=\"" + this.value + "\" value=\"" + TextUtils.htmlEncode(textValue) + "\">";
/*  40 */     String languageCode = I18NUtil.getUserLanguageCode();
/*     */ 
/*  42 */     if ((allLanguageCodes != null) && (allLanguageCodes.size() > 0))
/*     */     {
/*  44 */       StringBuffer sb = new StringBuffer();
/*  45 */       sb.append("<input type=\"text\"  id=\"" + this.value + ".mlstring." + languageCode + ".display\" value=\"" + I18NUtil.getStringByLanguage(textValue, languageCode) + "\"  onchange=\"setMlStringByLangCode(this,'" + this.value + "','" + languageCode + "')\"  >");
/*  46 */       sb.append("<a href=\"#\"> <image src=\"images/mls.png\"  border=0; onclick=\"showMlStringForm('timezone.description');\" /></a>");
/*  47 */       sb.append("<br>");
/*  48 */       sb.append("<div class=\"SuggestList\" id=\"" + this.value + ".form\">");
/*  49 */       sb.append("<div class=\"SuggestMain\" >");
/*  50 */       sb.append("<ul>");
/*  51 */       sb.append("<table class=\"mlform_table\" >");
/*  52 */       sb.append("<input type=\"hidden\" name=\"" + this.value + "\" value=\"" + textValue + "\" />");
/*     */ 
/*  55 */       for (LanguageCode languageCodeBean : allLanguageCodes) {
/*  56 */         sb.append("<tr><td>");
/*  57 */         sb.append(languageCodeBean.getDescription() + ":");
/*  58 */         sb.append("</td>");
/*  59 */         sb.append("<td><input type=\"text\" id=\"" + this.value + ".mlstring." + languageCodeBean.getLanguageCode() + "\" name=\"" + this.value + ".mlstring\" value=\"" + I18NUtil.getStringByLanguage(textValue, languageCodeBean.getLanguageCode()) + "\" /></td>");
/*  60 */         sb.append("</tr>");
/*     */       }
/*     */ 
/*  63 */       sb.append("<tr>");
/*  64 */       sb.append("<td>\t<input type=\"button\" value=\"OK\" onclick=\"setMlString('" + this.value + "')\"/></td>");
/*  65 */       sb.append("<td>\t<input type=\"button\" value=\"Cancel\" onclick=\"hideMlStringForm('" + this.value + "')\"/></td>");
/*  66 */       sb.append("</tr>");
/*     */ 
/*  68 */       sb.append("</table>");
/*  69 */       sb.append("</ul>");
/*  70 */       sb.append("</div>");
/*  71 */       sb.append("</div>");
/*     */ 
/*  73 */       returnHTML = sb.toString();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  78 */       this.pageContext.getOut().print(returnHTML);
/*     */     }
/*     */     catch (IOException e) {
/*  81 */       e.printStackTrace();
/*     */     }
/*     */ 
/*  84 */     return 6;
/*     */   }
/*     */ 
/*     */   public String getValue() {
/*  88 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value) {
/*  92 */     super.setValue(value);
/*  93 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  98 */     String abc = "<ml><value>fssasdfsadf</value><languageCode>zh_cn</languageCode></ml><ml><value>asdf</value><languageCode>en_us</languageCode></ml>   ";
/*  99 */     List result = new ArrayList();
/* 100 */     List subValues = StringUtils.subStringList(abc, "<ml>", "</ml>");
/* 101 */     for (String subValue : subValues) {
/* 102 */       String subXML = "<ml>" + subValue + "</ml>";
/*     */       try {
/* 104 */         Object obj = BeanUtil.getXML2Bean(subXML, MLBean.class);
/* 105 */         result.add((MLBean)obj);
/*     */ 
/* 107 */         System.out.println(((MLBean)obj).getVl());
/* 108 */         System.out.println(((MLBean)obj).getLg());
/*     */       } catch (Exception e) {
/* 110 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.i18n.MLText
 * JD-Core Version:    0.6.0
 */