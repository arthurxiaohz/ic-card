/*    */ package org.hi.framework.web.taglib;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.TagSupport;
/*    */ import org.hi.framework.web.taglib.component.bean.Token;
/*    */ 
/*    */ public class TokenTag extends TagSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private HttpSession session;
/* 40 */   private String mothed = "post";
/*    */ 
/* 42 */   public int doEndTag() throws JspException { JspWriter jspOut = this.pageContext.getOut();
/*    */     try {
/* 44 */       if (this.mothed.equals("get"))
/* 45 */         jspOut.print("token=" + new Token().getTokenString(this.pageContext.getSession()));
/*    */       else
/* 47 */         jspOut.print("<input type=\"hidden\" name=\"token\" value=\"" + new Token().getTokenString(this.pageContext.getSession()) + "\">");
/*    */     } catch (IOException e) {
/* 49 */       e.printStackTrace();
/*    */     }
/* 51 */     return 6; }
/*    */ 
/*    */   public void release() {
/* 54 */     this.session = null;
/* 55 */     this.mothed = null;
/* 56 */     super.release();
/*    */   }
/*    */   public HttpSession getSession() {
/* 59 */     return this.session;
/*    */   }
/*    */ 
/*    */   public void setSession(HttpSession session) {
/* 63 */     this.session = session;
/*    */   }
/*    */   public String getMothed() {
/* 66 */     return this.mothed;
/*    */   }
/*    */   public void setMothed(String mothed) {
/* 69 */     this.mothed = mothed;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.TokenTag
 * JD-Core Version:    0.6.0
 */