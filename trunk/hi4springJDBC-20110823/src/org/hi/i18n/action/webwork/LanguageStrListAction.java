/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.action.LanguageStrPageInfo;
/*    */ import org.hi.i18n.model.LanguageStr;
/*    */ import org.hi.i18n.service.LanguageStrManager;
/*    */ 
/*    */ public class LanguageStrListAction extends BaseAction
/*    */ {
/*    */   private LanguageStr languageStr;
/*    */   private LanguageStrPageInfo pageInfo;
/*    */   private List<LanguageStr> languageStrs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new LanguageStrPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.languageStrs = languageStrMgr.getLanguageStrList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageStr getLanguageStr() {
/* 30 */     return this.languageStr;
/*    */   }
/*    */ 
/*    */   public void setLanguageStr(LanguageStr languageStr) {
/* 34 */     this.languageStr = languageStr;
/*    */   }
/*    */ 
/*    */   public List<LanguageStr> getLanguageStrs() {
/* 38 */     return this.languageStrs;
/*    */   }
/*    */ 
/*    */   public void setLanguageStrs(List<LanguageStr> languageStrs) {
/* 42 */     this.languageStrs = languageStrs;
/*    */   }
/*    */ 
/*    */   public LanguageStrPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(LanguageStrPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageStrListAction
 * JD-Core Version:    0.6.0
 */