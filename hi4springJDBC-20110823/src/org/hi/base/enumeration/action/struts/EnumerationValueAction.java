/*     */ package org.hi.base.enumeration.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.enumeration.action.EnumerationValuePageInfo;
/*     */ import org.hi.base.enumeration.model.EnumerationValue;
/*     */ import org.hi.base.enumeration.service.EnumerationValueManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class EnumerationValueAction extends BaseAction
/*     */ {
/*     */   private EnumerationValue enumerationValue;
/*     */   private EnumerationValuePageInfo pageInfo;
/*     */   private List<EnumerationValue> enumerationValues;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveEnumerationValue()
/*     */     throws Exception
/*     */   {
/*  25 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/*     */ 
/*  27 */     if (super.perExecute(this.enumerationValue) != null) return returnCommand();
/*  28 */     enumerationValueMgr.saveEnumerationValue(this.enumerationValue);
/*  29 */     super.postExecute(this.enumerationValue);
/*  30 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeEnumerationValue()
/*     */     throws Exception
/*     */   {
/*  38 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/*  39 */     enumerationValueMgr.removeEnumerationValueById(this.enumerationValue.getId());
/*  40 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllEnumerationValue()
/*     */     throws Exception
/*     */   {
/*  47 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/*  48 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  50 */       String[] ids = this.orderIndexs.split(",");
/*  51 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  53 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  55 */         Integer enumerationValueid = new Integer(ids[i]);
/*  56 */         enumerationValueMgr.removeEnumerationValueById(enumerationValueid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  61 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewEnumerationValue()
/*     */     throws Exception
/*     */   {
/*  68 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/*  69 */     this.enumerationValue = enumerationValueMgr.getEnumerationValueById(this.enumerationValue.getId());
/*  70 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String enumerationValueList()
/*     */     throws Exception
/*     */   {
/*  77 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/*  78 */     this.pageInfo = (this.pageInfo == null ? new EnumerationValuePageInfo() : this.pageInfo);
/*  79 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  81 */     this.enumerationValues = enumerationValueMgr.getSecurityEnumerationValueList(sarchPageInfo);
/*     */ 
/*  83 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public EnumerationValue getEnumerationValue()
/*     */   {
/*  90 */     return this.enumerationValue;
/*     */   }
/*     */ 
/*     */   public void setEnumerationValue(EnumerationValue enumerationValue) {
/*  94 */     this.enumerationValue = enumerationValue;
/*     */   }
/*     */ 
/*     */   public List<EnumerationValue> getEnumerationValues() {
/*  98 */     return this.enumerationValues;
/*     */   }
/*     */ 
/*     */   public void setEnumerationValues(List<EnumerationValue> enumerationValues) {
/* 102 */     this.enumerationValues = enumerationValues;
/*     */   }
/*     */ 
/*     */   public EnumerationValuePageInfo getPageInfo() {
/* 106 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(EnumerationValuePageInfo pageInfo) {
/* 110 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 114 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 118 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.action.struts.EnumerationValueAction
 * JD-Core Version:    0.6.0
 */