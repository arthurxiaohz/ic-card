/*     */ package org.hi.framework.mvc.action.struts;
/*     */ 
/*     */ import com.opensymphony.xwork2.ActionContext;
/*     */ import com.opensymphony.xwork2.ActionInvocation;
/*     */ import com.opensymphony.xwork2.inject.Inject;
/*     */ import com.opensymphony.xwork2.util.ValueStack;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.apache.struts2.dispatcher.Dispatcher;
/*     */ import org.apache.struts2.dispatcher.StrutsResultSupport;
/*     */ import org.apache.struts2.dispatcher.mapper.ActionMapper;
/*     */ import org.apache.struts2.dispatcher.mapper.ActionMapping;
/*     */ 
/*     */ public class CommonStrutsResult extends StrutsResultSupport
/*     */ {
/*  20 */   private String resultType = "dispatcher";
/*     */   protected ActionMapper actionMapper;
/*     */ 
/*     */   @Inject
/*     */   public void setActionMapper(ActionMapper mapper)
/*     */   {
/*  26 */     this.actionMapper = mapper;
/*     */   }
/*     */ 
/*     */   protected void doExecute(String finalLocation, ActionInvocation invocation)
/*     */     throws Exception
/*     */   {
/*  32 */     this.resultType = ((String)invocation.getStack().findValue("resultType"));
/*  33 */     if (this.resultType.equals("redirect"))
/*  34 */       redirect(finalLocation, invocation);
/*  35 */     else if (this.resultType.equals("redirect-action"))
/*  36 */       redirectAction(finalLocation, invocation);
/*     */     else
/*  38 */       dispatcher(finalLocation, invocation);
/*     */   }
/*     */ 
/*     */   private void redirectAction(String finalLocation, ActionInvocation invocation) throws Exception
/*     */   {
/*  43 */     redirect(finalLocation, invocation);
/*     */   }
/*     */ 
/*     */   private void redirect(String finalLocation, ActionInvocation invocation) throws Exception {
/*  47 */     ActionContext ctx = invocation.getInvocationContext();
/*  48 */     HttpServletRequest request = (HttpServletRequest)ctx.get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  49 */     HttpServletResponse response = (HttpServletResponse)ctx.get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
/*     */ 
/*  51 */     if (isPathUrl(finalLocation)) {
/*  52 */       if (!finalLocation.startsWith("/")) {
/*  53 */         ActionMapping mapping = this.actionMapper.getMapping(
/*  54 */           request, Dispatcher.getInstance().getConfigurationManager());
/*  55 */         String namespace = null;
/*  56 */         if (mapping != null) {
/*  57 */           namespace = mapping.getNamespace();
/*     */         }
/*     */ 
/*  60 */         if ((namespace != null) && (namespace.length() > 0) && (!"/".equals(namespace)))
/*  61 */           finalLocation = namespace + "/" + finalLocation;
/*     */         else {
/*  63 */           finalLocation = "/" + finalLocation;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  68 */       finalLocation = response.encodeRedirectURL(finalLocation);
/*     */     }
/*     */ 
/*  72 */     response.sendRedirect(finalLocation);
/*     */   }
/*     */ 
/*     */   private static boolean isPathUrl(String url) {
/*  76 */     return url.indexOf(':') == -1;
/*     */   }
/*     */ 
/*     */   private void dispatcher(String finalLocation, ActionInvocation invocation) throws Exception {
/*  80 */     PageContext pageContext = ServletActionContext.getPageContext();
/*     */ 
/*  82 */     if (pageContext != null) {
/*  83 */       pageContext.include(finalLocation);
/*     */     } else {
/*  85 */       HttpServletRequest request = ServletActionContext.getRequest();
/*  86 */       HttpServletResponse response = ServletActionContext.getResponse();
/*  87 */       RequestDispatcher dispatcher = request.getRequestDispatcher(finalLocation);
/*     */ 
/*  90 */       if (dispatcher == null) {
/*  91 */         response.sendError(404, "result '" + finalLocation + "' not found");
/*     */ 
/*  93 */         return;
/*     */       }
/*     */ 
/*  99 */       if ((!response.isCommitted()) && (request.getAttribute("javax.servlet.include.servlet_path") == null)) {
/* 100 */         request.setAttribute("webwork.view_uri", finalLocation);
/* 101 */         request.setAttribute("webwork.request_uri", request.getRequestURI());
/*     */ 
/* 103 */         dispatcher.forward(request, response);
/*     */       } else {
/* 105 */         dispatcher.include(request, response);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getResultType()
/*     */   {
/* 113 */     return this.resultType;
/*     */   }
/*     */ 
/*     */   public void setResultType(String resultType)
/*     */   {
/* 119 */     this.resultType = resultType;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.mvc.action.struts.CommonStrutsResult
 * JD-Core Version:    0.6.0
 */