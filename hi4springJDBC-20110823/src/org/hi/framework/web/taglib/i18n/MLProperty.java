/*    */ package org.hi.framework.web.taglib.i18n;
/*    */ 
/*    */ import com.opensymphony.util.TextUtils;
/*    */ import com.opensymphony.webwork.components.Component;
/*    */ import com.opensymphony.webwork.views.jsp.PropertyTag;
/*    */ import com.opensymphony.xwork.util.OgnlValueStack;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import org.hi.common.util.BeanUtil;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class MLProperty extends PropertyTag
/*    */ {
/*    */   private String value;
/*    */ 
/*    */   public int doStartTag()
/*    */     throws JspException
/*    */   {
/* 30 */     this.component = getBean(getStack(), (HttpServletRequest)this.pageContext.getRequest(), (HttpServletResponse)this.pageContext.getResponse());
/* 31 */     populateParams();
/* 32 */     String returnStr = this.component.getStack().findValue(this.value, String.class).toString();
/* 33 */     String languageCode = I18NUtil.getUserLanguageCode();
/*    */     try {
/* 35 */       this.pageContext.getOut().print(TextUtils.htmlEncode(I18NUtil.getStringByLanguage(returnStr, languageCode)));
/*    */     }
/*    */     catch (IOException e) {
/* 38 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 41 */     return 6;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 49 */     super.setValue(value);
/* 50 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 55 */     String abc = "<ml><value>fssasdfsadf</value><languageCode>zh_cn</languageCode></ml><ml><value>asdf</value><languageCode>en_us</languageCode></ml>   ";
/* 56 */     List result = new ArrayList();
/* 57 */     List subValues = StringUtils.subStringList(abc, "<ml>", "</ml>");
/* 58 */     for (String subValue : subValues) {
/* 59 */       String subXML = "<ml>" + subValue + "</ml>";
/*    */       try {
/* 61 */         Object obj = BeanUtil.getXML2Bean(subXML, MLBean.class);
/* 62 */         result.add((MLBean)obj);
/*    */ 
/* 64 */         System.out.println(((MLBean)obj).getVl());
/* 65 */         System.out.println(((MLBean)obj).getLg());
/*    */       } catch (Exception e) {
/* 67 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.i18n.MLProperty
 * JD-Core Version:    0.6.0
 */