/*     */ package org.hi.framework.mvc.action.webwork;
/*     */ 
/*     */ import com.opensymphony.webwork.ServletActionContext;
/*     */ import com.opensymphony.webwork.dispatcher.WebWorkResultSupport;
/*     */ import com.opensymphony.webwork.dispatcher.mapper.ActionMapper;
/*     */ import com.opensymphony.webwork.dispatcher.mapper.ActionMapperFactory;
/*     */ import com.opensymphony.webwork.dispatcher.mapper.ActionMapping;
/*     */ import com.opensymphony.webwork.views.util.UrlHelper;
/*     */ import com.opensymphony.xwork.ActionContext;
/*     */ import com.opensymphony.xwork.ActionInvocation;
/*     */ import com.opensymphony.xwork.ActionProxy;
/*     */ import com.opensymphony.xwork.config.entities.ActionConfig;
/*     */ import com.opensymphony.xwork.config.entities.ResultConfig;
/*     */ import com.opensymphony.xwork.util.OgnlValueStack;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ 
/*     */ public class CommonWebworkResult extends WebWorkResultSupport
/*     */ {
/*  26 */   private String resultType = "dispatcher";
/*     */ 
/*     */   protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception
/*     */   {
/*  30 */     this.resultType = ((String)invocation.getStack().findValue("resultType"));
/*  31 */     if (this.resultType.equals("redirect"))
/*  32 */       redirect(finalLocation, invocation);
/*  33 */     else if (this.resultType.equals("redirect-action"))
/*  34 */       redirectAction(finalLocation, invocation);
/*     */     else
/*  36 */       dispatcher(finalLocation, invocation);
/*     */   }
/*     */ 
/*     */   private void redirectAction(String finalLocation, ActionInvocation invocation) throws Exception
/*     */   {
/*  41 */     String actionName = null;
/*  42 */     String namespace = null;
/*  43 */     String method = null;
/*  44 */     List prohibitedResultParam = Arrays.asList(new String[] { 
/*  45 */       "location", "namespace", "method", "encode", "parse", "location", 
/*  46 */       "prependServletContext" });
/*     */ 
/*  48 */     actionName = conditionalParse(actionName, invocation);
/*  49 */     if (namespace == null)
/*  50 */       namespace = invocation.getProxy().getNamespace();
/*     */     else {
/*  52 */       namespace = conditionalParse(namespace, invocation);
/*     */     }
/*  54 */     if (method == null) {
/*  55 */       method = "";
/*     */     }
/*     */     else {
/*  58 */       method = conditionalParse(method, invocation);
/*     */     }
/*     */ 
/*  61 */     Map requestParameters = new HashMap();
/*  62 */     ResultConfig resultConfig = (ResultConfig)invocation.getProxy().getConfig().getResults().get(
/*  63 */       invocation.getResultCode());
/*  64 */     Map resultConfigParams = resultConfig.getParams();
/*  65 */     for (Iterator i = resultConfigParams.entrySet().iterator(); i.hasNext(); ) {
/*  66 */       Map.Entry e = (Map.Entry)i.next();
/*  67 */       if (!prohibitedResultParam.contains(e.getKey())) {
/*  68 */         requestParameters.put(e.getKey().toString(), 
/*  69 */           e.getValue() == null ? "" : 
/*  70 */           conditionalParse(e.getValue().toString(), invocation));
/*     */       }
/*     */     }
/*     */ 
/*  74 */     ActionMapper mapper = ActionMapperFactory.getMapper();
/*  75 */     StringBuffer tmpLocation = new StringBuffer(mapper.getUriFromActionMapping(new ActionMapping(actionName, namespace, method, null)));
/*  76 */     UrlHelper.buildParametersString(requestParameters, tmpLocation, "&");
/*     */ 
/*  78 */     this.location = tmpLocation.toString();
/*  79 */     redirect(finalLocation, invocation);
/*     */   }
/*     */ 
/*     */   private void redirect(String finalLocation, ActionInvocation invocation) throws Exception {
/*  83 */     ActionContext ctx = invocation.getInvocationContext();
/*  84 */     HttpServletRequest request = (HttpServletRequest)ctx.get("com.opensymphony.xwork.dispatcher.HttpServletRequest");
/*  85 */     HttpServletResponse response = (HttpServletResponse)ctx.get("com.opensymphony.xwork.dispatcher.HttpServletResponse");
/*     */ 
/*  87 */     if (isPathUrl(finalLocation)) {
/*  88 */       if (!finalLocation.startsWith("/")) {
/*  89 */         String namespace = ActionMapperFactory.getMapper().getMapping(request).getNamespace();
/*     */ 
/*  91 */         if ((namespace != null) && (namespace.length() > 0) && (!"/".equals(namespace)))
/*  92 */           finalLocation = namespace + "/" + finalLocation;
/*     */         else {
/*  94 */           finalLocation = "/" + finalLocation;
/*     */         }
/*     */       }
/*     */ 
/*  98 */       finalLocation = response.encodeRedirectURL(finalLocation);
/*     */     }
/*     */ 
/* 101 */     response.sendRedirect(finalLocation);
/*     */   }
/*     */ 
/*     */   private static boolean isPathUrl(String url) {
/* 105 */     return url.indexOf(':') == -1;
/*     */   }
/*     */ 
/*     */   private void dispatcher(String finalLocation, ActionInvocation invocation) throws Exception {
/* 109 */     PageContext pageContext = ServletActionContext.getPageContext();
/*     */ 
/* 111 */     if (pageContext != null) {
/* 112 */       pageContext.include(finalLocation);
/*     */     } else {
/* 114 */       HttpServletRequest request = ServletActionContext.getRequest();
/* 115 */       HttpServletResponse response = ServletActionContext.getResponse();
/* 116 */       RequestDispatcher dispatcher = request.getRequestDispatcher(finalLocation);
/*     */ 
/* 119 */       if (dispatcher == null) {
/* 120 */         response.sendError(404, "result '" + finalLocation + "' not found");
/*     */ 
/* 122 */         return;
/*     */       }
/*     */ 
/* 128 */       if ((!response.isCommitted()) && (request.getAttribute("javax.servlet.include.servlet_path") == null)) {
/* 129 */         request.setAttribute("webwork.view_uri", finalLocation);
/* 130 */         request.setAttribute("webwork.request_uri", request.getRequestURI());
/*     */ 
/* 132 */         dispatcher.forward(request, response);
/*     */       } else {
/* 134 */         dispatcher.include(request, response);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getResultType()
/*     */   {
/* 142 */     return this.resultType;
/*     */   }
/*     */ 
/*     */   public void setResultType(String resultType)
/*     */   {
/* 148 */     this.resultType = resultType;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.mvc.action.webwork.CommonWebworkResult
 * JD-Core Version:    0.6.0
 */