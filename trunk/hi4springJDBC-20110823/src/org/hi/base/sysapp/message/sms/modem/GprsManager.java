/*    */ package org.hi.base.sysapp.message.sms.modem;
/*    */ 
/*    */ public class GprsManager
/*    */ {
/* 15 */   private final byte ESC = 27;
/*    */   private SmsPort sp;
/* 17 */   private static GprsManager instance = new GprsManager();
/*    */ 
/*    */   private GprsManager()
/*    */   {
/* 21 */     this.sp = null;
/*    */   }
/*    */ 
/*    */   public static GprsManager getInstance()
/*    */   {
/* 26 */     return instance;
/*    */   }
/*    */ 
/*    */   public SmsPort getConnection(String smsPort)
/*    */   {
/* 31 */     if ((this.sp == null) || (!this.sp.isOpen()))
/*    */     {
/* 33 */       this.sp = new SmsPort(smsPort);
/* 34 */       SerialParameters param = this.sp.detectSmsPort();
/* 35 */       if (param != null)
/*    */       {
/*    */         try
/*    */         {
/* 39 */           this.sp.open(param);
/*    */         } catch (Exception localException) {
/*    */         }
/* 42 */         if (this.sp.isOpen())
/* 43 */           return this.sp;
/*    */       }
/* 45 */       this.sp = null;
/*    */     }
/* 47 */     return this.sp;
/*    */   }
/*    */ 
/*    */   public void clearConnection()
/*    */     throws Exception
/*    */   {
/* 53 */     byte[] b = { 
/* 54 */       27, 27, 27 };
/*    */ 
/* 56 */     byte[] b2 = { 
/* 57 */       13, 10 };
/*    */ 
/* 59 */     if (this.sp.isOpen())
/*    */     {
/* 61 */       this.sp.sendData(b);
/*    */       try
/*    */       {
/* 64 */         Thread.sleep(1000L);
/*    */       } catch (InterruptedException localInterruptedException) {
/*    */       }
/* 67 */       this.sp.receiveData();
/* 68 */       for (int i = 0; i < 5; i++)
/*    */       {
/* 70 */         this.sp.sendCommand("AT");
/* 71 */         this.sp.receiveData();
/*    */       }
/*    */ 
/* 74 */       for (int i = 0; i < 5; i++)
/*    */       {
/* 76 */         this.sp.sendData(b2);
/* 77 */         this.sp.receiveData();
/*    */       }
/*    */ 
/* 80 */       this.sp.close();
/* 81 */       this.sp = null;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.GprsManager
 * JD-Core Version:    0.6.0
 */