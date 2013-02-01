/*    */ package org.hi.common.util;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.GregorianCalendar;
/*    */ 
/*    */ public class CalendarUtil
/*    */ {
/*    */   public static Timestamp getDateFor00(Calendar calendar)
/*    */   {
/* 22 */     calendar.set(11, 0);
/* 23 */     calendar.set(12, 0);
/* 24 */     calendar.set(13, 0);
/* 25 */     calendar.set(14, 0);
/* 26 */     return new Timestamp(calendar.getTimeInMillis());
/*    */   }
/*    */   public static Timestamp getDateFor23(Calendar calendar) {
/* 29 */     calendar.set(11, 23);
/* 30 */     calendar.set(12, 59);
/* 31 */     calendar.set(13, 59);
/* 32 */     calendar.set(14, 999);
/* 33 */     return new Timestamp(calendar.getTimeInMillis());
/*    */   }
/*    */ 
/*    */   public static Timestamp getDateFor00(Date date) {
/* 37 */     if (date == null)
/* 38 */       return null;
/* 39 */     Calendar calendar = new GregorianCalendar();
/* 40 */     calendar.setTime(date);
/* 41 */     return getDateFor00(calendar);
/*    */   }
/*    */ 
/*    */   public static Timestamp getDateFor23(Date date) {
/* 45 */     if (date == null)
/* 46 */       return null;
/* 47 */     Calendar calendar = new GregorianCalendar();
/* 48 */     calendar.setTime(date);
/* 49 */     return getDateFor23(calendar);
/*    */   }
/*    */ 
/*    */   public static Timestamp getDateFor00(Timestamp timestamp) {
/* 53 */     if (timestamp == null)
/* 54 */       return null;
/* 55 */     Calendar calendar = new GregorianCalendar();
/* 56 */     calendar.setTime(new Date(timestamp.getTime()));
/* 57 */     return getDateFor00(calendar);
/*    */   }
/*    */ 
/*    */   public static Timestamp getDateFor23(Timestamp timestamp) {
/* 61 */     if (timestamp == null)
/* 62 */       return null;
/* 63 */     Calendar calendar = new GregorianCalendar();
/* 64 */     calendar.setTime(new Date(timestamp.getTime()));
/* 65 */     return getDateFor23(calendar);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.util.CalendarUtil
 * JD-Core Version:    0.6.0
 */