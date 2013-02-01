/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import javax.servlet.jsp.tagext.BodyTagSupport;
/*     */ import org.hi.common.util.DesUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ 
/*     */ public class ActionTag extends BodyTagSupport
/*     */ {
/*  13 */   private String encrypt = "true";
/*     */   private String formName;
/*     */   private String resultType;
/*     */   private String resultValue;
/*     */   private String clazz;
/*     */   private String method;
/*     */ 
/*     */   public int doEndTag()
/*     */     throws JspException
/*     */   {
/*  21 */     boolean _encrypt = true;
/*     */ 
/*  23 */     if ((this.encrypt != null) && (this.encrypt.equals("false"))) {
/*  24 */       _encrypt = false;
/*     */     }
/*  26 */     if ((!HiConfigHolder.getPublished()) || (!HiConfigHolder.getUrlEncrypt())) {
/*  27 */       _encrypt = false;
/*     */     }
/*     */ 
/*  30 */     String context = null;
/*     */ 
/*  32 */     String _resultType = "&resultType=" + this.resultType;
/*  33 */     String _actionMethod = "&actionMethod=" + this.method;
/*  34 */     context = "actionName=" + this.clazz + "&resultValue=" + this.resultValue + _resultType + _actionMethod;
/*  35 */     if (_encrypt)
/*  36 */       context = encrypt(context);
/*  37 */     if (this.formName == null)
/*     */     {
/*  39 */       context = HiConfigHolder.getMVCActionName() + "?" + context;
/*     */     }
/*     */     else {
/*  42 */       context = "commonAction('" + this.formName + "','" + HiConfigHolder.getMVCActionName() + "?" + context + "')";
/*     */     }
/*     */ 
/*  46 */     return writerBody(context);
/*     */   }
/*     */ 
/*     */   private String encrypt(String context) throws JspException
/*     */   {
/*     */     try {
/*  52 */       DesUtils des = new DesUtils();
/*  53 */       return des.encrypt(context);
/*     */     } catch (Exception e) {
/*     */     }
/*  56 */     throw new JspException(e);
/*     */   }
/*     */ 
/*     */   private int writerBody(String bodyStr) throws JspException
/*     */   {
/*  61 */     JspWriter jspOut = this.pageContext.getOut();
/*     */     try {
/*  63 */       jspOut.print(bodyStr);
/*     */     } catch (IOException e) {
/*  65 */       throw new JspException(e);
/*     */     }
/*  67 */     return super.doEndTag();
/*     */   }
/*     */ 
/*     */   public String getEncrypt()
/*     */   {
/*  72 */     return this.encrypt;
/*     */   }
/*     */ 
/*     */   public void setEncrypt(String encrypt) {
/*  76 */     this.encrypt = encrypt;
/*     */   }
/*     */ 
/*     */   public String getFormName() {
/*  80 */     return this.formName;
/*     */   }
/*     */ 
/*     */   public void setFormName(String formName) {
/*  84 */     this.formName = formName;
/*     */   }
/*     */ 
/*     */   public String getResultType() {
/*  88 */     return this.resultType;
/*     */   }
/*     */ 
/*     */   public void setResultType(String resultType) {
/*  92 */     this.resultType = resultType;
/*     */   }
/*     */ 
/*     */   public String getResultValue() {
/*  96 */     return this.resultValue;
/*     */   }
/*     */ 
/*     */   public void setResultValue(String resultValue) {
/* 100 */     this.resultValue = resultValue;
/*     */   }
/*     */ 
/*     */   public String getClazz() {
/* 104 */     return this.clazz;
/*     */   }
/*     */ 
/*     */   public void setClazz(String clazz) {
/* 108 */     this.clazz = clazz;
/*     */   }
/*     */ 
/*     */   public String getMethod() {
/* 112 */     return this.method;
/*     */   }
/*     */ 
/*     */   public void setMethod(String method) {
/* 116 */     this.method = method;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.ActionTag
 * JD-Core Version:    0.6.0
 */