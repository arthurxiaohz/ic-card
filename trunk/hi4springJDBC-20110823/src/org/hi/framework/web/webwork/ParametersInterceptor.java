/*    */ package org.hi.framework.web.webwork;
/*    */ 
/*    */ import com.opensymphony.xwork.ActionContext;
/*    */ import com.opensymphony.xwork.ActionInvocation;
/*    */ import com.opensymphony.xwork.interceptor.NoParameters;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.hi.common.util.DesUtils;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ 
/*    */ public class ParametersInterceptor extends com.opensymphony.xwork.interceptor.ParametersInterceptor
/*    */ {
/*    */   protected void before(ActionInvocation invocation)
/*    */     throws Exception
/*    */   {
/* 19 */     if ((invocation.getAction() instanceof NoParameters)) {
/* 20 */       super.before(invocation);
/* 21 */       return;
/*    */     }
/*    */ 
/* 24 */     if ((!HiConfigHolder.getPublished()) || (!HiConfigHolder.getUrlEncrypt())) {
/* 25 */       super.before(invocation);
/* 26 */       return;
/*    */     }
/*    */ 
/* 29 */     ActionContext ac = invocation.getInvocationContext();
/* 30 */     HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork.dispatcher.HttpServletRequest");
/* 31 */     String urlQueryString = request.getQueryString();
/* 32 */     if ((urlQueryString == null) || (urlQueryString.equals(""))) {
/* 33 */       super.before(invocation);
/* 34 */       return;
/*    */     }
/* 36 */     if (StringUtils.isIncludes(urlQueryString, "=,&")) {
/* 37 */       super.before(invocation);
/* 38 */       return;
/*    */     }
/*    */ 
/* 41 */     DesUtils des = new DesUtils();
/* 42 */     String parametersStr = des.decrypt(urlQueryString);
/* 43 */     String[] parameterStr = parametersStr.split("[&]");
/* 44 */     Map parameters = ac.getParameters();
/* 45 */     for (int i = 0; i < parameterStr.length; i++) {
/* 46 */       String[] keyValue = parameterStr[i].split("[=]");
/*    */ 
/* 49 */       if (keyValue.length < 2) {
/*    */         continue;
/*    */       }
/* 52 */       String key = keyValue[0];
/* 53 */       String value = keyValue[1];
/* 54 */       if ((key == null) || (value == null) || (key.length() == 0) || (value.length() == 0))
/*    */         continue;
/* 56 */       parameters.put(key, value);
/*    */     }
/* 58 */     parameters.remove(urlQueryString);
/* 59 */     parameters.put("org.hi.framework.web.webwork.BaseAction.uncode_parameter_key", urlQueryString);
/*    */ 
/* 62 */     super.before(invocation);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.webwork.ParametersInterceptor
 * JD-Core Version:    0.6.0
 */