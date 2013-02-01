/*     */ package org.hi.base.sysapp.message.sms.modem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.Vector;
/*     */ import javax.comm.CommPortIdentifier;
/*     */ import javax.comm.NoSuchPortException;
/*     */ import javax.comm.PortInUseException;
/*     */ import javax.comm.UnsupportedCommOperationException;
/*     */ 
/*     */ public class SmsPort
/*     */ {
/*  26 */   private final String OK = "OK";
/*  27 */   private final String ERROR = "ERROR";
/*  28 */   private final byte ESC = 27;
/*  29 */   private String smsPort = "COM4";
/*     */   private SerialConnection SerialConn;
/*     */ 
/*     */   public SmsPort(String smsPort)
/*     */   {
/*  34 */     if (smsPort != null) this.smsPort = smsPort;
/*  35 */     this.SerialConn = new SerialConnection();
/*     */   }
/*     */ 
/*     */   public SmsPort()
/*     */   {
/*  40 */     this.SerialConn = new SerialConnection();
/*     */   }
/*     */ 
/*     */   public void open(SerialParameters param)
/*     */     throws UnsupportedCommOperationException, IOException, PortInUseException, NoSuchPortException
/*     */   {
/*  46 */     this.SerialConn.open(param);
/*     */     try
/*     */     {
/*  49 */       init();
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void close() {
/*  56 */     this.SerialConn.close();
/*     */   }
/*     */ 
/*     */   public boolean isOpen()
/*     */   {
/*  61 */     return this.SerialConn.isOpen();
/*     */   }
/*     */ 
/*     */   public SerialConnection getSerialConn()
/*     */   {
/*  66 */     return this.SerialConn;
/*     */   }
/*     */ 
/*     */   public void sendCommand(String data)
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/*  74 */       this.SerialConn.write(data + "\r");
/*  75 */       Thread.sleep(100L);
/*     */     }
/*     */     catch (InterruptedException localInterruptedException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void sendData(byte[] data) throws IOException
/*     */   {
/*     */     try {
/*  85 */       this.SerialConn.write(data);
/*  86 */       Thread.sleep(100L);
/*     */     }
/*     */     catch (InterruptedException localInterruptedException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void sendData(String data) throws IOException
/*     */   {
/*     */     try {
/*  96 */       this.SerialConn.write(data);
/*  97 */       Thread.sleep(100L);
/*     */     }
/*     */     catch (InterruptedException localInterruptedException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public String receiveData() {
/*     */     try {
/* 106 */       return this.SerialConn.read();
/*     */     }
/*     */     catch (IOException ioexception) {
/*     */     }
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */   public void sendMessage(String mobileNum, String stMsg)
/*     */     throws Exception
/*     */   {
/* 117 */     PDU pdu = new PDU();
/* 118 */     String encodeMsg = pdu.encodeUCS2(stMsg);
/* 119 */     sendCommand("AT+CMGS=\"" + mobileNum + "\"");
/* 120 */     boolean b = true;
/* 121 */     int i = 0;
/* 122 */     while (b)
/*     */     {
/* 124 */       String ret = receiveData();
/* 125 */       if (ret.indexOf("ERROR") != -1)
/* 126 */         throw new Exception();
/* 127 */       if (ret.indexOf(">") != -1)
/*     */       {
/* 129 */         sendData(encodeMsg + '\032');
/* 130 */         break;
/*     */       }
/* 132 */       i++;
/* 133 */       Thread.sleep(200L);
/* 134 */       if (i > 10)
/* 135 */         throw new Exception();
/*     */     }
/* 137 */     i = 0;
/* 138 */     while (b)
/*     */     {
/* 140 */       String ret = receiveData();
/* 141 */       if (ret.indexOf("ERROR") != -1)
/* 142 */         throw new Exception();
/* 143 */       if (ret.indexOf("OK") != -1)
/*     */       {
/* 145 */         System.out.println("Send Success!");
/* 146 */         break;
/*     */       }
/* 148 */       i++;
/* 149 */       Thread.sleep(200L);
/* 150 */       if (i > 10)
/* 151 */         throw new Exception();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Vector receiveMessage()
/*     */     throws Exception
/*     */   {
/* 158 */     Vector v = new Vector();
/* 159 */     sendCommand("AT+CMGL=\"ALL\"");
/* 160 */     String ret = "";
/* 161 */     for (String dd = receiveData(); !dd.equals(""); dd = receiveData()) {
/* 162 */       ret = ret + dd;
/*     */     }
/* 164 */     if ((ret != null) && (!ret.trim().equals("")))
/*     */     {
/* 166 */       boolean b = false;
/* 167 */       String id = null;
/* 168 */       String time = null;
/* 169 */       String mobile = null;
/* 170 */       String msg = null;
/* 171 */       for (StringTokenizer st = new StringTokenizer(ret, "\n"); st.hasMoreTokens(); )
/*     */       {
/* 173 */         ret = st.nextToken().trim();
/* 174 */         if ((ret != null) && (!ret.equals(""))) {
/* 175 */           if ((b) && (ret.indexOf("OK") == -1) && (ret.toUpperCase().indexOf("+CMGL") == -1))
/*     */           {
/* 177 */             System.out.println(ret);
/*     */             try
/*     */             {
/* 180 */               deleteMessage(id);
/* 181 */               Date d = null;
/*     */               try
/*     */               {
/* 184 */                 DateFormat df = new SimpleDateFormat("yy/MM/dd,HH:mm:ss");
/* 185 */                 d = df.parse(time);
/*     */               }
/*     */               catch (ParseException e)
/*     */               {
/* 189 */                 System.err.println(e);
/*     */               }
/*     */               try
/*     */               {
/* 193 */                 PDU pdu = new PDU();
/* 194 */                 msg = pdu.decodeUCS2(ret.substring(0, ret.length()));
/*     */               }
/*     */               catch (Exception e)
/*     */               {
/* 198 */                 msg = null;
/*     */               }
/* 200 */               msg.trim().equals("");
/* 201 */               Sms s = new Sms(mobile, msg, d);
/* 202 */               v.add(s);
/* 203 */               b = false;
/* 204 */               id = null;
/* 205 */               time = null;
/* 206 */               mobile = null;
/* 207 */               msg = null;
/*     */             } catch (Exception localException1) {
/*     */             }
/*     */           } else {
/* 211 */             if ((ret == null) || (ret.equals("")) || (!ret.toUpperCase().startsWith("+CMGL")))
/*     */               continue;
/* 213 */             StringTokenizer st2 = new StringTokenizer(ret, ",");
/* 214 */             for (int i = 0; st2.hasMoreTokens(); i++)
/*     */             {
/* 216 */               String ret2 = st2.nextToken();
/* 217 */               switch (i)
/*     */               {
/*     */               case 0:
/* 220 */                 id = ret2.substring(7);
/* 221 */                 break;
/*     */               case 2:
/* 224 */                 mobile = ret2.substring(1, ret2.length() - 1);
/* 225 */                 break;
/*     */               case 3:
/* 228 */                 time = ret2;
/* 229 */                 break;
/*     */               case 4:
/* 232 */                 time = time + "," + ret2;
/* 233 */                 time = time.substring(1, time.length() - 1);
/* 234 */                 time = time.substring(0, time.indexOf("+"));
/*     */               case 1:
/*     */               }
/*     */             }
/*     */ 
/* 239 */             b = false;
/*     */             try
/*     */             {
/* 242 */               Integer.parseInt(id);
/* 243 */               b = true;
/*     */             } catch (NumberFormatException localNumberFormatException) {
/*     */             }
/* 246 */             if (b)
/* 247 */               System.out.println(ret);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 252 */     return v;
/*     */   }
/*     */ 
/*     */   public void deleteMessage(String id)
/*     */     throws Exception
/*     */   {
/* 258 */     for (String ret = ""; ret.indexOf("OK") == -1; )
/*     */     {
/* 260 */       sendCommand("AT+CMGD=" + id);
/* 261 */       Thread.sleep(1000L);
/* 262 */       ret = receiveData();
/* 263 */       System.out.println(ret);
/* 264 */       if (ret.indexOf("ERROR") != -1)
/* 265 */         throw new Exception();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void init()
/*     */     throws Exception
/*     */   {
/* 273 */     byte[] b2 = { 
/* 274 */       13, 10 };
/*     */ 
/* 276 */     int i = 0;
/* 277 */     boolean b = true;
/* 278 */     for (int j = 0; j < 5; j++)
/*     */     {
/* 280 */       sendData(b2);
/* 281 */       receiveData();
/*     */     }
/*     */ 
/* 284 */     sendCommand("AT+CMGF=1");
/* 285 */     while (b)
/*     */     {
/* 287 */       String ret = receiveData();
/* 288 */       Thread.sleep(100L);
/* 289 */       i++; if (i > 9)
/* 290 */         throw new Exception();
/* 291 */       if (ret.indexOf("ERROR") != -1)
/* 292 */         throw new Exception();
/* 293 */       if (ret.indexOf("OK") != -1)
/*     */         break;
/*     */     }
/* 296 */     sendCommand("AT+CSCS=\"CUSTOM\"");
/* 297 */     while (b)
/*     */     {
/* 299 */       String ret = receiveData();
/* 300 */       Thread.sleep(100L);
/* 301 */       i++; if (i > 9)
/* 302 */         throw new Exception();
/* 303 */       if (ret.indexOf("ERROR") != -1)
/* 304 */         throw new Exception();
/* 305 */       if (ret.indexOf("OK") != -1)
/*     */         break;
/*     */     }
/* 308 */     sendCommand("AT+CSMP=16,168,0,8");
/* 309 */     while (b)
/*     */     {
/* 311 */       String ret = receiveData();
/* 312 */       Thread.sleep(100L);
/* 313 */       i++; if (i > 9)
/* 314 */         throw new Exception();
/* 315 */       if (ret.indexOf("ERROR") != -1)
/* 316 */         throw new Exception();
/* 317 */       if (ret.indexOf("OK") != -1)
/*     */         break;
/*     */     }
/* 320 */     byte[] bt = { 
/* 321 */       27, 27 };
/*     */ 
/* 323 */     sendData(bt);
/* 324 */     for (int j = 0; j < 10; j++)
/* 325 */       receiveData();
/*     */   }
/*     */ 
/*     */   public synchronized SerialParameters detectSmsPort()
/*     */   {
/* 331 */     SerialParameters param = isGprsPort(this.smsPort);
/* 332 */     if (param != null)
/* 333 */       return param;
/* 334 */     CommPortIdentifier PortId = null;
/* 335 */     for (Enumeration e = CommPortIdentifier.getPortIdentifiers(); e.hasMoreElements(); )
/*     */     {
/* 337 */       PortId = (CommPortIdentifier)e.nextElement();
/* 338 */       if (PortId.getPortType() != 1)
/*     */         continue;
/* 340 */       param = isGprsPort(PortId.getName());
/* 341 */       if (param != null) {
/* 342 */         return param;
/*     */       }
/*     */     }
/*     */ 
/* 346 */     return null;
/*     */   }
/*     */ 
/*     */   public synchronized SerialParameters isGprsPort(String PortName)
/*     */   {
/* 351 */     SerialParameters param = new SerialParameters();
/* 352 */     SerialConnection conn = new SerialConnection();
/* 353 */     int[] staybaudRate = { 
/* 354 */       9600, 115200, 19200, 38400 };
/*     */ 
/* 356 */     for (int i = 0; i < staybaudRate.length; )
/*     */     {
/* 358 */       param.setName(PortName);
/* 359 */       param.setBaudRate(staybaudRate[i]);
/* 360 */       param.setDatabits(8);
/* 361 */       param.setStopbits(1);
/* 362 */       param.setParity(0);
/* 363 */       param.setFlowControlMode(0);
/*     */       try
/*     */       {
/* 366 */         conn.open(param);
/* 367 */         if (!conn.isOpen())
/* 368 */           return null;
/* 369 */         conn.write("AT\r");
/* 370 */         String result = conn.read();
/* 371 */         if (result.indexOf("OK") == -1)
/*     */         {
/* 373 */           conn.close();
/*     */         }
/*     */         else {
/* 376 */           conn.close();
/* 377 */           return param;
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 382 */         conn.close();
/*     */ 
/* 356 */         i++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 386 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.SmsPort
 * JD-Core Version:    0.6.0
 */