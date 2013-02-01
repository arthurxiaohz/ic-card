/*     */ package org.hi.base.sysapp.message.sms.modem;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Vector;
/*     */ import org.hi.base.sysapp.message.sms.SmsListener;
/*     */ 
/*     */ public class GprsSmsSend extends Thread
/*     */ {
/*     */   private Vector messengers;
/*  21 */   private static GprsSmsSend instance = null;
/*     */   private Vector smsList;
/*     */   private int i;
/*     */   private boolean bSendSms;
/*     */   private int sendCount;
/*     */   private String smsPort;
/*     */ 
/*     */   private GprsSmsSend()
/*     */   {
/*  31 */     this.messengers = new Vector();
/*  32 */     this.smsList = new Vector();
/*  33 */     this.i = 0;
/*  34 */     this.bSendSms = true;
/*  35 */     this.sendCount = 0;
/*  36 */     start();
/*     */   }
/*     */ 
/*     */   public static GprsSmsSend getInstance()
/*     */   {
/*  41 */     if (instance == null)
/*  42 */       instance = new GprsSmsSend();
/*  43 */     return instance;
/*     */   }
/*     */ 
/*     */   public void setMessenger(SmsListener messenger)
/*     */   {
/*  48 */     this.messengers.add(messenger);
/*     */   }
/*     */ 
/*     */   public void removeMessenger(SmsListener messenger)
/*     */   {
/*  53 */     this.messengers.remove(messenger);
/*     */   }
/*     */ 
/*     */   public void addQueue(Sms msg)
/*     */   {
/*  58 */     this.smsList.add(msg);
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*     */     while (true) {
/*  64 */       if (this.bSendSms)
/*     */       {
/*  66 */         Sms msg = null;
/*     */         try
/*     */         {
/*  69 */           if (this.smsList.size() != 0)
/*  70 */             msg = (Sms)this.smsList.remove(0);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*  74 */           System.err.println(e);
/*     */         }
/*  76 */         if (msg != null)
/*  77 */           sendMsg(msg);
/*  78 */         if (++this.sendCount <= 10)
/*     */           continue;
/*  80 */         this.bSendSms = false;
/*  81 */         this.sendCount = 0; continue;
/*     */       }
/*     */ 
/*  85 */       readMsg();
/*     */       try
/*     */       {
/*  88 */         Thread.sleep(10000L);
/*     */       } catch (Exception localException1) {
/*     */       }
/*  91 */       this.bSendSms = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void sendMsg(Sms msg)
/*     */   {
/*  98 */     GprsManager manger = GprsManager.getInstance();
/*     */     try
/*     */     {
/* 101 */       SmsPort sp = manger.getConnection(this.smsPort);
/* 102 */       sp.sendMessage(msg.getMobileNumber(), msg.getMessage());
/* 103 */       this.i = 0;
/* 104 */       Thread.sleep(3000L);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       this.i += 1;
/* 109 */       if (this.i > 10)
/*     */         try
/*     */         {
/* 112 */           manger.clearConnection(); } catch (Exception localException1) {  }
/*     */ 
/* 115 */       GregorianCalendar calendar = new GregorianCalendar();
/* 116 */       calendar.setTime(msg.getDate());
/* 117 */       calendar.add(12, 360);
/* 118 */       Date endkeepDate = calendar.getTime();
/* 119 */       if ((!endkeepDate.after(new Date())) || (msg.getMobileNumber() == null) || (msg.getMobileNumber().equals("")));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void readMsg() {
/* 127 */     GprsManager manger = GprsManager.getInstance();
/* 128 */     SmsPort sp = manger.getConnection(this.smsPort);
/*     */     try
/*     */     {
/* 131 */       if (sp != null)
/*     */       {
/* 133 */         Vector v = sp.receiveMessage();
/* 134 */         if ((v != null) && (v.size() > 0))
/*     */         {
/* 136 */           for (int i = 0; i < this.messengers.size(); i++)
/*     */           {
/* 138 */             SmsListener messenger = (SmsListener)this.messengers.get(i);
/* 139 */             messenger.SmsArrive(v);
/*     */           }
/*     */         }
/*     */ 
/* 143 */         Thread.sleep(3000L);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       this.i += 1;
/* 149 */       if (this.i > 10)
/*     */         try
/*     */         {
/* 152 */           manger.clearConnection();
/*     */         }
/*     */         catch (Exception localException1) {
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   public SerialParameters getParameters() {
/* 160 */     return GprsManager.getInstance().getConnection(this.smsPort).getSerialConn().getParameters();
/*     */   }
/*     */ 
/*     */   public void setSmsPort(String smsPort) {
/* 164 */     this.smsPort = smsPort;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.GprsSmsSend
 * JD-Core Version:    0.6.0
 */