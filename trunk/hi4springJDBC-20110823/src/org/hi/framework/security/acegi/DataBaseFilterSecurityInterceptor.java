/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.acegisecurity.intercept.ObjectDefinitionSource;
/*    */ import org.acegisecurity.intercept.web.FilterInvocationDefinitionSource;
/*    */ import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.model.PrivilegeResource;
/*    */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*    */ import org.hi.framework.web.ServletContext;
/*    */ 
/*    */ public class DataBaseFilterSecurityInterceptor extends FilterSecurityInterceptor
/*    */ {
/* 29 */   private boolean load = true;
/* 30 */   private boolean isComplete = false;
/*    */ 
/*    */   public void setLoad(boolean load) throws IOException {
/* 33 */     this.load = load;
/* 34 */     setObjectDefinitionSource();
/*    */   }
/*    */ 
/*    */   protected void setObjectDefinitionSource() throws IOException {
/* 38 */     if (!this.load) {
/* 39 */       return;
/*    */     }
/* 41 */     PrivilegeResourceManager prMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/* 42 */     Filter filter = FilterFactory.getSimpleFilter("viewLayer", null, "<>").addCondition("viewLayer", "", "<>", "AND");
/* 43 */     List privilegeResources = prMgr.getObjects(filter);
/* 44 */     if (privilegeResources.size() == 0) {
/* 45 */       return;
/*    */     }
/* 47 */     HiFilterInvocationDefinitionSourceEditor fidsEditor = new HiFilterInvocationDefinitionSourceEditor();
/* 48 */     StringBuffer sb = new StringBuffer();
/* 49 */     for (PrivilegeResource privilegeResource : privilegeResources) {
/* 50 */       sb.append(privilegeResource.getViewLayer()).append("=").append(privilegeResource.getAuthorityName());
/* 51 */       if ((privilegeResource.getVeiwExtAuthNames() != null) && (!privilegeResource.getVeiwExtAuthNames().trim().equals(""))) {
/* 52 */         sb.append(",").append(privilegeResource.getVeiwExtAuthNames());
/*    */       }
/* 54 */       sb.append("\n");
/*    */     }
/*    */ 
/* 57 */     fidsEditor.setAsText(sb.toString());
/* 58 */     setObjectDefinitionSource((FilterInvocationDefinitionSource)fidsEditor.getValue());
/* 59 */     this.isComplete = true;
/*    */   }
/*    */ 
/*    */   public ObjectDefinitionSource obtainObjectDefinitionSource() {
/* 63 */     if (!this.isComplete)
/* 64 */       return new SetupDefinitionSource();
/* 65 */     return super.obtainObjectDefinitionSource();
/*    */   }
/*    */ 
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 71 */     ServletContext.setRequest((HttpServletRequest)request);
/* 72 */     ServletContext.setResponse((HttpServletResponse)response);
/* 73 */     super.doFilter(request, response, chain);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.DataBaseFilterSecurityInterceptor
 * JD-Core Version:    0.6.0
 */