/*    */ package org.hi.base.sysapp.message.sms.modem;
/*    */ 
/*    */ public class SerialParameters
/*    */ {
/*    */   private String name;
/*    */   private String model;
/*    */   private int baudRate;
/*    */   private int databits;
/*    */   private int stopbits;
/*    */   private int parity;
/*    */   private int flowControlMode;
/*    */ 
/*    */   public SerialParameters()
/*    */   {
/* 22 */     this.name = null;
/* 23 */     this.model = "unknown";
/* 24 */     this.baudRate = 0;
/* 25 */     this.databits = 0;
/* 26 */     this.stopbits = 0;
/* 27 */     this.parity = 0;
/* 28 */     this.flowControlMode = 0;
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 33 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 38 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setBaudRate(int baudRate)
/*    */   {
/* 43 */     this.baudRate = baudRate;
/*    */   }
/*    */ 
/*    */   public int getBaudRate()
/*    */   {
/* 48 */     return this.baudRate;
/*    */   }
/*    */ 
/*    */   public void setDatabits(int databits)
/*    */   {
/* 53 */     this.databits = databits;
/*    */   }
/*    */ 
/*    */   public int getDatabits()
/*    */   {
/* 58 */     return this.databits;
/*    */   }
/*    */ 
/*    */   public void setStopbits(int Stopbits)
/*    */   {
/* 63 */     this.stopbits = Stopbits;
/*    */   }
/*    */ 
/*    */   public int getStopbits()
/*    */   {
/* 68 */     return this.stopbits;
/*    */   }
/*    */ 
/*    */   public void setParity(int parity)
/*    */   {
/* 73 */     this.parity = parity;
/*    */   }
/*    */ 
/*    */   public int getParity()
/*    */   {
/* 78 */     return this.parity;
/*    */   }
/*    */ 
/*    */   public void setFlowControlMode(int flowControlMode)
/*    */   {
/* 83 */     this.flowControlMode = flowControlMode;
/*    */   }
/*    */ 
/*    */   public int getFlowControlMode()
/*    */   {
/* 88 */     return this.flowControlMode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.SerialParameters
 * JD-Core Version:    0.6.0
 */