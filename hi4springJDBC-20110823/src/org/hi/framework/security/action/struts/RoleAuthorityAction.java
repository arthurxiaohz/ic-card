/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.RoleAuthorityPageInfo;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ import org.hi.framework.security.service.RoleAuthorityManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class RoleAuthorityAction extends BaseAction
/*     */ {
/*     */   private RoleAuthority roleAuthority;
/*     */   private RoleAuthorityPageInfo pageInfo;
/*     */   private List<RoleAuthority> roleAuthoritys;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveRoleAuthority()
/*     */     throws Exception
/*     */   {
/*  25 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  26 */     if (super.perExecute(this.roleAuthority) != null) return returnCommand();
/*  27 */     roleAuthorityMgr.saveRoleAuthority(this.roleAuthority);
/*  28 */     super.postExecute(this.roleAuthority);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeRoleAuthority()
/*     */     throws Exception
/*     */   {
/*  37 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  38 */     roleAuthorityMgr.removeRoleAuthorityById(this.roleAuthority.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllRoleAuthority()
/*     */     throws Exception
/*     */   {
/*  46 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer roleAuthorityid = new Integer(ids[i]);
/*  55 */         roleAuthorityMgr.removeRoleAuthorityById(roleAuthorityid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewRoleAuthority()
/*     */     throws Exception
/*     */   {
/*  67 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  68 */     this.roleAuthority = roleAuthorityMgr.getRoleAuthorityById(this.roleAuthority.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String roleAuthorityList()
/*     */     throws Exception
/*     */   {
/*  76 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new RoleAuthorityPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.roleAuthoritys = roleAuthorityMgr.getRoleAuthorityList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public RoleAuthority getRoleAuthority()
/*     */   {
/*  89 */     return this.roleAuthority;
/*     */   }
/*     */ 
/*     */   public void setRoleAuthority(RoleAuthority roleAuthority) {
/*  93 */     this.roleAuthority = roleAuthority;
/*     */   }
/*     */ 
/*     */   public List<RoleAuthority> getRoleAuthoritys() {
/*  97 */     return this.roleAuthoritys;
/*     */   }
/*     */ 
/*     */   public void setRoleAuthoritys(List<RoleAuthority> roleAuthoritys) {
/* 101 */     this.roleAuthoritys = roleAuthoritys;
/*     */   }
/*     */ 
/*     */   public RoleAuthorityPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(RoleAuthorityPageInfo pageInfo) {
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
 * Qualified Name:     org.hi.framework.security.action.struts.RoleAuthorityAction
 * JD-Core Version:    0.6.0
 */