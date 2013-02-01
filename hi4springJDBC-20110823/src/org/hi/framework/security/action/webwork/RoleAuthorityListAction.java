/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.RoleAuthorityPageInfo;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.service.RoleAuthorityManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class RoleAuthorityListAction extends BaseAction
/*    */ {
/*    */   private RoleAuthority roleAuthority;
/*    */   private RoleAuthorityPageInfo pageInfo;
/*    */   private List<RoleAuthority> roleAuthoritys;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new RoleAuthorityPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.roleAuthoritys = roleAuthorityMgr.getRoleAuthorityList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public RoleAuthority getRoleAuthority() {
/* 30 */     return this.roleAuthority;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthority(RoleAuthority roleAuthority) {
/* 34 */     this.roleAuthority = roleAuthority;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> getRoleAuthoritys() {
/* 38 */     return this.roleAuthoritys;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthoritys(List<RoleAuthority> roleAuthoritys) {
/* 42 */     this.roleAuthoritys = roleAuthoritys;
/*    */   }
/*    */ 
/*    */   public RoleAuthorityPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(RoleAuthorityPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleAuthorityListAction
 * JD-Core Version:    0.6.0
 */