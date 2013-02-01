/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.action.EnumerationPageInfo;
/*    */ import org.hi.base.enumeration.model.Enumeration;
/*    */ import org.hi.base.enumeration.service.EnumerationManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationListAction extends BaseAction
/*    */ {
/*    */   private Enumeration enumeration;
/*    */   private EnumerationPageInfo pageInfo;
/*    */   private List<Enumeration> enumerations;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 21 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/* 22 */     this.pageInfo = (this.pageInfo == null ? new EnumerationPageInfo() : this.pageInfo);
/* 23 */     this.pageInfo.setF_enumerationType(Integer.valueOf(0));
/* 24 */     this.pageInfo.setF_enumerationType_op("=");
/*    */ 
/* 26 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 28 */     this.enumerations = enumerationMgr.getSecurityEnumerationList(sarchPageInfo);
/*    */ 
/* 30 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Enumeration getEnumeration() {
/* 34 */     return this.enumeration;
/*    */   }
/*    */ 
/*    */   public void setEnumeration(Enumeration enumeration) {
/* 38 */     this.enumeration = enumeration;
/*    */   }
/*    */ 
/*    */   public List<Enumeration> getEnumerations() {
/* 42 */     return this.enumerations;
/*    */   }
/*    */ 
/*    */   public void setEnumerations(List<Enumeration> enumerations) {
/* 46 */     this.enumerations = enumerations;
/*    */   }
/*    */ 
/*    */   public EnumerationPageInfo getPageInfo() {
/* 50 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(EnumerationPageInfo pageInfo) {
/* 54 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationListAction
 * JD-Core Version:    0.6.0
 */