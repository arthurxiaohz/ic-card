/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.acegisecurity.intercept.ObjectDefinitionSource;
/*    */ import org.acegisecurity.intercept.method.MethodDefinitionSource;
/*    */ import org.acegisecurity.intercept.method.MethodDefinitionSourceEditor;
/*    */ import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.model.PrivilegeResource;
/*    */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*    */ 
/*    */ public class DataMethodSecurityInterceptor extends MethodSecurityInterceptor
/*    */ {
/* 18 */   private boolean load = true;
/*    */ 
/* 20 */   private boolean isComplete = false;
/*    */ 
/*    */   public void setLoad(boolean load) throws IOException {
/* 23 */     this.load = load;
/* 24 */     setObjectDefinitionSource();
/*    */   }
/*    */   protected void setObjectDefinitionSource() throws IOException {
/* 27 */     if (!this.load) {
/* 28 */       return;
/*    */     }
/* 30 */     PrivilegeResourceManager prMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/* 31 */     Filter filter = FilterFactory.getSimpleFilter("businessLayer", null, "<>").addCondition("businessLayer", "", "<>", "AND");
/* 32 */     List privilegeResources = prMgr.getObjects(filter);
/* 33 */     if (privilegeResources.size() == 0) {
/* 34 */       return;
/*    */     }
/* 36 */     MethodDefinitionSourceEditor mdsEditor = new MethodDefinitionSourceEditor();
/* 37 */     StringBuffer sb = new StringBuffer();
/* 38 */     for (PrivilegeResource privilegeResource : privilegeResources) {
/* 39 */       sb.append(privilegeResource.getBusinessLayer()).append("=").append(privilegeResource.getAuthorityName());
/* 40 */       if ((privilegeResource.getBizExtAuthNames() != null) && (!privilegeResource.getBizExtAuthNames().trim().equals(""))) {
/* 41 */         sb.append(",").append(privilegeResource.getBizExtAuthNames());
/*    */       }
/* 43 */       sb.append("\n");
/*    */     }
/*    */ 
/* 46 */     mdsEditor.setAsText(sb.toString());
/* 47 */     setObjectDefinitionSource((MethodDefinitionSource)mdsEditor.getValue());
/* 48 */     this.isComplete = true;
/*    */   }
/*    */ 
/*    */   public ObjectDefinitionSource obtainObjectDefinitionSource() {
/* 52 */     if (!this.isComplete)
/* 53 */       return new SetupDefinitionSource();
/* 54 */     return super.obtainObjectDefinitionSource();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.DataMethodSecurityInterceptor
 * JD-Core Version:    0.6.0
 */