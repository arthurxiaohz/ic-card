/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.action.TimezonePageInfo;
/*    */ import org.hi.i18n.model.Timezone;
/*    */ import org.hi.i18n.service.TimezoneManager;
/*    */ 
/*    */ public class TimezoneListAction extends BaseAction
/*    */ {
/*    */   private Timezone timezone;
/*    */   private TimezonePageInfo pageInfo;
/*    */   private List<Timezone> timezones;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new TimezonePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.timezones = timezoneMgr.getTimezoneList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Timezone getTimezone() {
/* 30 */     return this.timezone;
/*    */   }
/*    */ 
/*    */   public void setTimezone(Timezone timezone) {
/* 34 */     this.timezone = timezone;
/*    */   }
/*    */ 
/*    */   public List<Timezone> getTimezones() {
/* 38 */     return this.timezones;
/*    */   }
/*    */ 
/*    */   public void setTimezones(List<Timezone> timezones) {
/* 42 */     this.timezones = timezones;
/*    */   }
/*    */ 
/*    */   public TimezonePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(TimezonePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.TimezoneListAction
 * JD-Core Version:    0.6.0
 */