/*     */ package org.hi.i18n.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.action.LanguageCodePageInfo;
/*     */ import org.hi.i18n.model.LanguageCode;
/*     */ import org.hi.i18n.service.LanguageCodeManager;
/*     */ 
/*     */ public class LanguageCodeAction extends BaseAction
/*     */ {
/*     */   private LanguageCode languageCode;
/*     */   private LanguageCodePageInfo pageInfo;
/*     */   private List<LanguageCode> languageCodes;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveLanguageCode()
/*     */     throws Exception
/*     */   {
/*  25 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*  26 */     if (super.perExecute(this.languageCode) != null) return returnCommand();
/*  27 */     languageCodeMgr.saveLanguageCode(this.languageCode);
/*  28 */     super.postExecute(this.languageCode);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeLanguageCode()
/*     */     throws Exception
/*     */   {
/*  37 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*  38 */     languageCodeMgr.removeLanguageCodeById(this.languageCode.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllLanguageCode()
/*     */     throws Exception
/*     */   {
/*  46 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer languageCodeid = new Integer(ids[i]);
/*  55 */         languageCodeMgr.removeLanguageCodeById(languageCodeid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewLanguageCode()
/*     */     throws Exception
/*     */   {
/*  67 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*  68 */     this.languageCode = languageCodeMgr.getLanguageCodeById(this.languageCode.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String languageCodeList()
/*     */     throws Exception
/*     */   {
/*  76 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new LanguageCodePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.languageCodes = languageCodeMgr.getLanguageCodeList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public LanguageCode getLanguageCode()
/*     */   {
/*  89 */     return this.languageCode;
/*     */   }
/*     */ 
/*     */   public void setLanguageCode(LanguageCode languageCode) {
/*  93 */     this.languageCode = languageCode;
/*     */   }
/*     */ 
/*     */   public List<LanguageCode> getLanguageCodes() {
/*  97 */     return this.languageCodes;
/*     */   }
/*     */ 
/*     */   public void setLanguageCodes(List<LanguageCode> languageCodes) {
/* 101 */     this.languageCodes = languageCodes;
/*     */   }
/*     */ 
/*     */   public LanguageCodePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(LanguageCodePageInfo pageInfo) {
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
 * Qualified Name:     org.hi.i18n.action.struts.LanguageCodeAction
 * JD-Core Version:    0.6.0
 */