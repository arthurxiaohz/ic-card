/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.action.EnumerationValuePageInfo;
/*    */ import org.hi.base.enumeration.model.EnumerationValue;
/*    */ import org.hi.base.enumeration.service.EnumerationValueManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationValueListAction extends BaseAction
/*    */ {
/*    */   private EnumerationValue enumerationValue;
/*    */   private EnumerationValuePageInfo pageInfo;
/*    */   private List<EnumerationValue> enumerationValues;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new EnumerationValuePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.enumerationValues = enumerationValueMgr.getSecurityEnumerationValueList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public EnumerationValue getEnumerationValue() {
/* 30 */     return this.enumerationValue;
/*    */   }
/*    */ 
/*    */   public void setEnumerationValue(EnumerationValue enumerationValue) {
/* 34 */     this.enumerationValue = enumerationValue;
/*    */   }
/*    */ 
/*    */   public List<EnumerationValue> getEnumerationValues() {
/* 38 */     return this.enumerationValues;
/*    */   }
/*    */ 
/*    */   public void setEnumerationValues(List<EnumerationValue> enumerationValues) {
/* 42 */     this.enumerationValues = enumerationValues;
/*    */   }
/*    */ 
/*    */   public EnumerationValuePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(EnumerationValuePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationValueListAction
 * JD-Core Version:    0.6.0
 */