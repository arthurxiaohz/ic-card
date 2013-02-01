/*     */ package org.hi.base.organization.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.action.HiOrgPageInfo;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.service.HiOrgManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class HiOrgAction extends BaseAction
/*     */ {
/*     */   private HiOrg hiOrg;
/*     */   private HiOrgPageInfo pageInfo;
/*     */   private List<HiOrg> hiOrgs;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveHiOrg()
/*     */     throws Exception
/*     */   {
/*  25 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  26 */     if (super.perExecute(this.hiOrg) != null) return returnCommand();
/*  27 */     hiOrgMgr.saveHiOrg(this.hiOrg);
/*  28 */     super.postExecute(this.hiOrg);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeHiOrg()
/*     */     throws Exception
/*     */   {
/*  37 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  38 */     hiOrgMgr.removeHiOrgById(this.hiOrg.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllHiOrg()
/*     */     throws Exception
/*     */   {
/*  46 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer hiOrgid = new Integer(ids[i]);
/*  55 */         hiOrgMgr.removeHiOrgById(hiOrgid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewHiOrg()
/*     */     throws Exception
/*     */   {
/*  67 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  68 */     this.hiOrg = hiOrgMgr.getHiOrgById(this.hiOrg.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String hiOrgList()
/*     */     throws Exception
/*     */   {
/*  76 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new HiOrgPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.hiOrgs = hiOrgMgr.getSecurityHiOrgList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public HiOrg getHiOrg()
/*     */   {
/*  89 */     return this.hiOrg;
/*     */   }
/*     */ 
/*     */   public void setHiOrg(HiOrg hiOrg) {
/*  93 */     this.hiOrg = hiOrg;
/*     */   }
/*     */ 
/*     */   public List<HiOrg> getHiOrgs() {
/*  97 */     return this.hiOrgs;
/*     */   }
/*     */ 
/*     */   public void setHiOrgs(List<HiOrg> hiOrgs) {
/* 101 */     this.hiOrgs = hiOrgs;
/*     */   }
/*     */ 
/*     */   public HiOrgPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(HiOrgPageInfo pageInfo) {
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

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.action.struts.HiOrgAction
 * JD-Core Version:    0.6.0
 */