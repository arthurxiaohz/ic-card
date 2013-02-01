/*    */ package org.hi.framework.web.struts;
/*    */ 
/*    */ import com.opensymphony.xwork2.ActionContext;
/*    */ import com.opensymphony.xwork2.ActionInvocation;
/*    */ import com.opensymphony.xwork2.interceptor.NoParameters;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.hi.common.util.DesUtils;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ 
/*    */ public class ParametersInterceptor extends com.opensymphony.xwork2.interceptor.ParametersInterceptor
/*    */ {
/*    */   public String doIntercept(ActionInvocation invocation)
/*    */     throws Exception
/*    */   {
/* 19 */     if ((invocation.getAction() instanceof NoParameters)) {
/* 20 */       return super.doIntercept(invocation);
/*    */     }
/* 22 */     if ((!HiConfigHolder.getPublished()) || (!HiConfigHolder.getUrlEncrypt())) {
/* 23 */       return super.doIntercept(invocation);
/*    */     }
/*    */ 
/* 26 */     ActionContext ac = invocation.getInvocationContext();
/* 27 */     HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/* 28 */     String urlQueryString = request.getQueryString();
/* 29 */     if ((urlQueryString == null) || (urlQueryString.equals(""))) {
/* 30 */       return super.doIntercept(invocation);
/*    */     }
/* 32 */     if (StringUtils.isIncludes(urlQueryString, "=,&")) {
/* 33 */       return super.doIntercept(invocation);
/*    */     }
/*    */ 
/* 36 */     DesUtils des = new DesUtils();
/* 37 */     String parametersStr = des.decrypt(urlQueryString);
/* 38 */     String[] parameterStr = parametersStr.split("[&]");
/* 39 */     Map parameters = ac.getParameters();
/* 40 */     for (int i = 0; i < parameterStr.length; i++) {
/* 41 */       String[] keyValue = parameterStr[i].split("[=]");
/*    */ 
/* 43 */       if (keyValue.length < 2) {
/*    */         continue;
/*    */       }
/* 46 */       String key = keyValue[0];
/* 47 */       String value = keyValue[1];
/* 48 */       if ((key == null) || (value == null) || (key.length() == 0) || (value.length() == 0))
/*    */         continue;
/* 50 */       parameters.put(key, value);
/*    */     }
/* 52 */     parameters.remove(urlQueryString);
/* 53 */     parameters.put("org.hi.framework.web.webwork.BaseAction.uncode_parameter_key", urlQueryString);
/*    */ 
/* 56 */     return super.doIntercept(invocation);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.struts.ParametersInterceptor
 * JD-Core Version:    0.6.0
 */