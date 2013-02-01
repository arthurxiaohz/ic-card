/*    */ package org.hi.framework.web.taglib;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.BodyContent;
/*    */ import javax.servlet.jsp.tagext.BodyTagSupport;
/*    */ import org.hi.common.util.DesUtils;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ 
/*    */ public class URLTag extends BodyTagSupport
/*    */ {
/* 15 */   private String encrypt = "true";
/*    */ 
/*    */   public int doEndTag() throws JspException
/*    */   {
/* 19 */     BodyContent bodyContent = getBodyContent();
/* 20 */     String url = bodyContent.getString();
/*    */ 
/* 22 */     if ((this.encrypt != null) && (this.encrypt.equals("false"))) {
/* 23 */       return writerBody(url);
/*    */     }
/* 25 */     if ((!HiConfigHolder.getPublished()) || (!HiConfigHolder.getUrlEncrypt())) {
/* 26 */       return writerBody(url);
/*    */     }
/*    */ 
/* 29 */     if (!StringUtils.isIncludes(url, "?")) {
/* 30 */       return writerBody(url);
/*    */     }
/* 32 */     String[] divs = url.split("[?]");
/*    */     try
/*    */     {
/* 35 */       DesUtils des = new DesUtils();
/* 36 */       div1 = des.encrypt(divs[1]);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */       String div1;
/* 39 */       throw new JspException(e);
/*    */     }
/*    */     String div1;
/* 42 */     String newUrl = divs[0] + "?" + div1;
/* 43 */     bodyContent.clearBody();
/*    */ 
/* 45 */     return writerBody(newUrl);
/*    */   }
/*    */ 
/*    */   private int writerBody(String bodyStr) throws JspException
/*    */   {
/* 50 */     JspWriter jspOut = this.pageContext.getOut();
/*    */     try {
/* 52 */       jspOut.print(bodyStr);
/*    */     } catch (IOException e) {
/* 54 */       throw new JspException(e);
/*    */     }
/* 56 */     return super.doEndTag();
/*    */   }
/*    */ 
/*    */   public String getEncrypt() {
/* 60 */     return this.encrypt;
/*    */   }
/*    */ 
/*    */   public void setEncrypt(String encrypt) {
/* 64 */     this.encrypt = encrypt;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.URLTag
 * JD-Core Version:    0.6.0
 */