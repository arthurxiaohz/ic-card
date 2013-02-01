/*     */ package org.hi.i18n.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.action.TimezonePageInfo;
/*     */ import org.hi.i18n.model.Timezone;
/*     */ import org.hi.i18n.service.TimezoneManager;
/*     */ 
/*     */ public class TimezoneAction extends BaseAction
/*     */ {
/*     */   private Timezone timezone;
/*     */   private TimezonePageInfo pageInfo;
/*     */   private List<Timezone> timezones;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveTimezone()
/*     */     throws Exception
/*     */   {
/*  25 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/*  26 */     if (super.perExecute(this.timezone) != null) return returnCommand();
/*  27 */     timezoneMgr.saveTimezone(this.timezone);
/*  28 */     super.postExecute(this.timezone);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeTimezone()
/*     */     throws Exception
/*     */   {
/*  37 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/*  38 */     timezoneMgr.removeTimezoneById(this.timezone.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllTimezone()
/*     */     throws Exception
/*     */   {
/*  46 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer timezoneid = new Integer(ids[i]);
/*  55 */         timezoneMgr.removeTimezoneById(timezoneid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewTimezone()
/*     */     throws Exception
/*     */   {
/*  67 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/*  68 */     this.timezone = timezoneMgr.getTimezoneById(this.timezone.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String timezoneList()
/*     */     throws Exception
/*     */   {
/*  76 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new TimezonePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.timezones = timezoneMgr.getTimezoneList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Timezone getTimezone()
/*     */   {
/*  89 */     return this.timezone;
/*     */   }
/*     */ 
/*     */   public void setTimezone(Timezone timezone) {
/*  93 */     this.timezone = timezone;
/*     */   }
/*     */ 
/*     */   public List<Timezone> getTimezones() {
/*  97 */     return this.timezones;
/*     */   }
/*     */ 
/*     */   public void setTimezones(List<Timezone> timezones) {
/* 101 */     this.timezones = timezones;
/*     */   }
/*     */ 
/*     */   public TimezonePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(TimezonePageInfo pageInfo) {
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
 * Qualified Name:     org.hi.i18n.action.struts.TimezoneAction
 * JD-Core Version:    0.6.0
 */