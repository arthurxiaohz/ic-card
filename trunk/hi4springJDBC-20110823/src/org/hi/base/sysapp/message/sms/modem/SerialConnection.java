/*     */ package org.hi.base.sysapp.message.sms.modem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.comm.CommPortIdentifier;
/*     */ import javax.comm.NoSuchPortException;
/*     */ import javax.comm.PortInUseException;
/*     */ import javax.comm.SerialPort;
/*     */ import javax.comm.UnsupportedCommOperationException;
/*     */ 
/*     */ public class SerialConnection
/*     */ {
/*  17 */   private final String ISO = "iso8859-1";
/*     */   private SerialParameters params;
/*     */   private InputStream input;
/*     */   private OutputStream output;
/*     */   private boolean bOpen;
/*     */   private CommPortIdentifier PortId;
/*     */   private SerialPort sPort;
/*     */ 
/*     */   public synchronized void open(SerialParameters param)
/*     */     throws UnsupportedCommOperationException, IOException, PortInUseException, NoSuchPortException
/*     */   {
/*  32 */     SerialParameters oldparam = new SerialParameters();
/*     */     try
/*     */     {
/*  35 */       this.PortId = CommPortIdentifier.getPortIdentifier(param.getName());
/*     */     }
/*     */     catch (NoSuchPortException e)
/*     */     {
/*  39 */       throw e;
/*     */     }
/*     */     try
/*     */     {
/*  43 */       this.sPort = ((SerialPort)this.PortId.open("sms", 2000));
/*     */     }
/*     */     catch (PortInUseException e)
/*     */     {
/*  47 */       throw e;
/*     */     }
/*  49 */     oldparam.setBaudRate(this.sPort.getBaudRate());
/*  50 */     oldparam.setDatabits(this.sPort.getDataBits());
/*  51 */     oldparam.setStopbits(this.sPort.getStopBits());
/*  52 */     oldparam.setFlowControlMode(this.sPort.getFlowControlMode());
/*  53 */     oldparam.setParity(this.sPort.getParity());
/*     */     try
/*     */     {
/*  56 */       this.sPort.setSerialPortParams(param.getBaudRate(), param.getDatabits(), param.getStopbits(), param.getParity());
/*  57 */       this.sPort.setFlowControlMode(param.getFlowControlMode());
/*     */     }
/*     */     catch (UnsupportedCommOperationException e)
/*     */     {
/*  61 */       this.sPort.setSerialPortParams(oldparam.getBaudRate(), oldparam.getDatabits(), oldparam.getStopbits(), oldparam.getParity());
/*  62 */       this.sPort.setFlowControlMode(oldparam.getFlowControlMode());
/*  63 */       this.sPort.close();
/*  64 */       throw e;
/*     */     }
/*     */     try
/*     */     {
/*  68 */       this.input = this.sPort.getInputStream();
/*  69 */       this.output = this.sPort.getOutputStream();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  73 */       this.sPort.close();
/*  74 */       throw e;
/*     */     }
/*     */     try
/*     */     {
/*  78 */       this.sPort.enableReceiveTimeout(300);
/*     */     } catch (UnsupportedCommOperationException localUnsupportedCommOperationException1) {
/*     */     }
/*  81 */     this.params = param;
/*  82 */     this.bOpen = true;
/*     */   }
/*     */ 
/*     */   public SerialParameters getParameters()
/*     */   {
/*  87 */     return this.params;
/*     */   }
/*     */ 
/*     */   public synchronized void close()
/*     */   {
/*  92 */     if (!this.bOpen)
/*  93 */       return;
/*  94 */     if (this.sPort != null)
/*     */     {
/*     */       try
/*     */       {
/*  98 */         this.input.close();
/*  99 */         this.output.close();
/*     */       } catch (IOException localIOException) {
/*     */       }
/* 102 */       this.sPort.close();
/*     */     }
/* 104 */     this.params = null;
/* 105 */     this.bOpen = false;
/*     */   }
/*     */ 
/*     */   public boolean isOpen()
/*     */   {
/* 110 */     return this.bOpen;
/*     */   }
/*     */ 
/*     */   public void write(String data)
/*     */     throws IOException
/*     */   {
/* 116 */     write(data.getBytes("iso8859-1"));
/*     */   }
/*     */ 
/*     */   public synchronized void write(byte[] data)
/*     */     throws IOException
/*     */   {
/* 122 */     this.output.write(data);
/*     */   }
/*     */ 
/*     */   public synchronized String read()
/*     */     throws IOException
/*     */   {
/* 128 */     StringBuffer buf = new StringBuffer();
/* 129 */     int iData = 0;
/*     */     do
/*     */     {
/* 132 */       iData = this.input.read();
/* 133 */       if (iData != -1)
/* 134 */         buf.append((char)iData); 
/*     */     }
/* 135 */     while (iData != -1);
/* 136 */     return new String(buf);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.SerialConnection
 * JD-Core Version:    0.6.0
 */