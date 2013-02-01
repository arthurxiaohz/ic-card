/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.PrivilegeResourcePageInfo;
/*     */ import org.hi.framework.security.model.PrivilegeResource;
/*     */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class PrivilegeResourceAction extends BaseAction
/*     */ {
/*     */   private PrivilegeResource privilegeResource;
/*     */   private PrivilegeResourcePageInfo pageInfo;
/*     */   private List<PrivilegeResource> privilegeResources;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String savePrivilegeResource()
/*     */     throws Exception
/*     */   {
/*  25 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/*  26 */     if (super.perExecute(this.privilegeResource) != null) return returnCommand();
/*  27 */     privilegeResourceMgr.savePrivilegeResource(this.privilegeResource);
/*  28 */     super.postExecute(this.privilegeResource);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removePrivilegeResource()
/*     */     throws Exception
/*     */   {
/*  37 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/*  38 */     privilegeResourceMgr.removePrivilegeResourceById(this.privilegeResource.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllPrivilegeResource()
/*     */     throws Exception
/*     */   {
/*  46 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer privilegeResourceid = new Integer(ids[i]);
/*  55 */         privilegeResourceMgr.removePrivilegeResourceById(privilegeResourceid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewPrivilegeResource()
/*     */     throws Exception
/*     */   {
/*  67 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/*  68 */     this.privilegeResource = privilegeResourceMgr.getPrivilegeResourceById(this.privilegeResource.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String privilegeResourceList()
/*     */     throws Exception
/*     */   {
/*  76 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new PrivilegeResourcePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.privilegeResources = privilegeResourceMgr.getPrivilegeResourceList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public PrivilegeResource getPrivilegeResource()
/*     */   {
/*  89 */     return this.privilegeResource;
/*     */   }
/*     */ 
/*     */   public void setPrivilegeResource(PrivilegeResource privilegeResource) {
/*  93 */     this.privilegeResource = privilegeResource;
/*     */   }
/*     */ 
/*     */   public List<PrivilegeResource> getPrivilegeResources() {
/*  97 */     return this.privilegeResources;
/*     */   }
/*     */ 
/*     */   public void setPrivilegeResources(List<PrivilegeResource> privilegeResources) {
/* 101 */     this.privilegeResources = privilegeResources;
/*     */   }
/*     */ 
/*     */   public PrivilegeResourcePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(PrivilegeResourcePageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.struts.PrivilegeResourceAction
 * JD-Core Version:    0.6.0
 */