/*     */ package org.hi.base.enumeration.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.enumeration.action.EnumerationPageInfo;
/*     */ import org.hi.base.enumeration.model.Enumeration;
/*     */ import org.hi.base.enumeration.service.EnumerationManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class EnumerationAction extends BaseAction
/*     */ {
/*     */   private Enumeration enumeration;
/*     */   private EnumerationPageInfo pageInfo;
/*     */   private List<Enumeration> enumerations;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveEnumeration()
/*     */     throws Exception
/*     */   {
/*  30 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/*     */ 
/*  32 */     if (super.perExecute(this.enumeration) != null) return returnCommand();
/*     */ 
/*  34 */     enumerationMgr.saveEnumeration(this.enumeration);
/*  35 */     super.postExecute(this.enumeration);
/*  36 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeEnumeration()
/*     */     throws Exception
/*     */   {
/*  44 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/*  45 */     enumerationMgr.removeEnumerationById(this.enumeration.getId());
/*  46 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllEnumeration()
/*     */     throws Exception
/*     */   {
/*  53 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/*  54 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  56 */       String[] ids = this.orderIndexs.split(",");
/*  57 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  59 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  61 */         Integer enumerationid = new Integer(ids[i]);
/*  62 */         enumerationMgr.removeEnumerationById(enumerationid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  67 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewEnumeration()
/*     */     throws Exception
/*     */   {
/*  74 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/*  75 */     this.enumeration = enumerationMgr.getEnumerationById(this.enumeration.getId());
/*  76 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String enumerationList()
/*     */     throws Exception
/*     */   {
/*  83 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/*  84 */     this.pageInfo = (this.pageInfo == null ? new EnumerationPageInfo() : this.pageInfo);
/*  85 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  87 */     this.enumerations = enumerationMgr.getSecurityEnumerationList(sarchPageInfo);
/*     */ 
/*  89 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Enumeration getEnumeration()
/*     */   {
/*  96 */     return this.enumeration;
/*     */   }
/*     */ 
/*     */   public void setEnumeration(Enumeration enumeration) {
/* 100 */     this.enumeration = enumeration;
/*     */   }
/*     */ 
/*     */   public List<Enumeration> getEnumerations() {
/* 104 */     return this.enumerations;
/*     */   }
/*     */ 
/*     */   public void setEnumerations(List<Enumeration> enumerations) {
/* 108 */     this.enumerations = enumerations;
/*     */   }
/*     */ 
/*     */   public EnumerationPageInfo getPageInfo() {
/* 112 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(EnumerationPageInfo pageInfo) {
/* 116 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 120 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 124 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.action.struts.EnumerationAction
 * JD-Core Version:    0.6.0
 */