/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.action.LanguageCodePageInfo;
/*    */ import org.hi.i18n.model.LanguageCode;
/*    */ import org.hi.i18n.service.LanguageCodeManager;
/*    */ 
/*    */ public class LanguageCodeListAction extends BaseAction
/*    */ {
/*    */   private LanguageCode languageCode;
/*    */   private LanguageCodePageInfo pageInfo;
/*    */   private List<LanguageCode> languageCodes;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new LanguageCodePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.languageCodes = languageCodeMgr.getLanguageCodeList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageCode getLanguageCode() {
/* 30 */     return this.languageCode;
/*    */   }
/*    */ 
/*    */   public void setLanguageCode(LanguageCode languageCode) {
/* 34 */     this.languageCode = languageCode;
/*    */   }
/*    */ 
/*    */   public List<LanguageCode> getLanguageCodes() {
/* 38 */     return this.languageCodes;
/*    */   }
/*    */ 
/*    */   public void setLanguageCodes(List<LanguageCode> languageCodes) {
/* 42 */     this.languageCodes = languageCodes;
/*    */   }
/*    */ 
/*    */   public LanguageCodePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(LanguageCodePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageCodeListAction
 * JD-Core Version:    0.6.0
 */