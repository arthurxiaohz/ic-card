/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.PrivilegeResourcePageInfo;
/*    */ import org.hi.framework.security.model.PrivilegeResource;
/*    */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class PrivilegeResourceListAction extends BaseAction
/*    */ {
/*    */   private PrivilegeResource privilegeResource;
/*    */   private PrivilegeResourcePageInfo pageInfo;
/*    */   private List<PrivilegeResource> privilegeResources;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new PrivilegeResourcePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.privilegeResources = privilegeResourceMgr.getPrivilegeResourceList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public PrivilegeResource getPrivilegeResource() {
/* 30 */     return this.privilegeResource;
/*    */   }
/*    */ 
/*    */   public void setPrivilegeResource(PrivilegeResource privilegeResource) {
/* 34 */     this.privilegeResource = privilegeResource;
/*    */   }
/*    */ 
/*    */   public List<PrivilegeResource> getPrivilegeResources() {
/* 38 */     return this.privilegeResources;
/*    */   }
/*    */ 
/*    */   public void setPrivilegeResources(List<PrivilegeResource> privilegeResources) {
/* 42 */     this.privilegeResources = privilegeResources;
/*    */   }
/*    */ 
/*    */   public PrivilegeResourcePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(PrivilegeResourcePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.PrivilegeResourceListAction
 * JD-Core Version:    0.6.0
 */