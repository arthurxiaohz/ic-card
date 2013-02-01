/*     */ package org.hi.i18n.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.action.LanguageStrPageInfo;
/*     */ import org.hi.i18n.model.LanguageStr;
/*     */ import org.hi.i18n.service.LanguageStrManager;
/*     */ 
/*     */ public class LanguageStrAction extends BaseAction
/*     */ {
/*     */   private LanguageStr languageStr;
/*     */   private LanguageStrPageInfo pageInfo;
/*     */   private List<LanguageStr> languageStrs;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveLanguageStr()
/*     */     throws Exception
/*     */   {
/*  25 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/*  26 */     if (super.perExecute(this.languageStr) != null) return returnCommand();
/*  27 */     languageStrMgr.saveLanguageStr(this.languageStr);
/*  28 */     super.postExecute(this.languageStr);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeLanguageStr()
/*     */     throws Exception
/*     */   {
/*  37 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/*  38 */     languageStrMgr.removeLanguageStrById(this.languageStr.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllLanguageStr()
/*     */     throws Exception
/*     */   {
/*  46 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer languageStrid = new Integer(ids[i]);
/*  55 */         languageStrMgr.removeLanguageStrById(languageStrid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewLanguageStr()
/*     */     throws Exception
/*     */   {
/*  67 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/*  68 */     this.languageStr = languageStrMgr.getLanguageStrById(this.languageStr.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String languageStrList()
/*     */     throws Exception
/*     */   {
/*  76 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new LanguageStrPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.languageStrs = languageStrMgr.getLanguageStrList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public LanguageStr getLanguageStr()
/*     */   {
/*  89 */     return this.languageStr;
/*     */   }
/*     */ 
/*     */   public void setLanguageStr(LanguageStr languageStr) {
/*  93 */     this.languageStr = languageStr;
/*     */   }
/*     */ 
/*     */   public List<LanguageStr> getLanguageStrs() {
/*  97 */     return this.languageStrs;
/*     */   }
/*     */ 
/*     */   public void setLanguageStrs(List<LanguageStr> languageStrs) {
/* 101 */     this.languageStrs = languageStrs;
/*     */   }
/*     */ 
/*     */   public LanguageStrPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(LanguageStrPageInfo pageInfo) {
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
 * Qualified Name:     org.hi.i18n.action.struts.LanguageStrAction
 * JD-Core Version:    0.6.0
 */