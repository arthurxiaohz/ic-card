/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.action.HiOrgPageInfo;
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.base.organization.service.HiOrgManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiOrgListAction extends BaseAction
/*    */ {
/*    */   private HiOrg hiOrg;
/*    */   private HiOrgPageInfo pageInfo;
/*    */   private List<HiOrg> hiOrgs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new HiOrgPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.hiOrgs = hiOrgMgr.getSecurityHiOrgList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiOrg getHiOrg() {
/* 30 */     return this.hiOrg;
/*    */   }
/*    */ 
/*    */   public void setHiOrg(HiOrg hiOrg) {
/* 34 */     this.hiOrg = hiOrg;
/*    */   }
/*    */ 
/*    */   public List<HiOrg> getHiOrgs() {
/* 38 */     return this.hiOrgs;
/*    */   }
/*    */ 
/*    */   public void setHiOrgs(List<HiOrg> hiOrgs) {
/* 42 */     this.hiOrgs = hiOrgs;
/*    */   }
/*    */ 
/*    */   public HiOrgPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(HiOrgPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.HiOrgListAction
 * JD-Core Version:    0.6.0
 */