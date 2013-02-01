/*    */ package org.hi.base.sysapp.message.sms.modem;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Sms
/*    */ {
/*    */   private String mobileNumber;
/*    */   private String Message;
/*    */   private Date date;
/*    */ 
/*    */   public Sms(String mobileNum, String msg)
/*    */   {
/* 19 */     this.mobileNumber = null;
/* 20 */     this.Message = null;
/* 21 */     this.date = null;
/* 22 */     this.mobileNumber = mobileNum;
/* 23 */     this.Message = msg;
/* 24 */     this.date = new Date();
/*    */   }
/*    */ 
/*    */   public Sms(String mobileNum, String msg, Date d)
/*    */   {
/* 29 */     this.mobileNumber = null;
/* 30 */     this.Message = null;
/* 31 */     this.date = null;
/* 32 */     this.mobileNumber = mobileNum;
/* 33 */     this.Message = msg;
/* 34 */     this.date = d;
/*    */   }
/*    */ 
/*    */   public String getMobileNumber()
/*    */   {
/* 39 */     return this.mobileNumber;
/*    */   }
/*    */ 
/*    */   public String getMessage()
/*    */   {
/* 44 */     return this.Message;
/*    */   }
/*    */ 
/*    */   public Date getDate()
/*    */   {
/* 49 */     return this.date;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.Sms
 * JD-Core Version:    0.6.0
 */