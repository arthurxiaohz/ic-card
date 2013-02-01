/*     */ package org.hi.base.sysapp.message.sms.modem;
/*     */ 
/*     */ class PDU
/*     */ {
/*  12 */   private final String ISO = "iso-8859-1";
/*  13 */   private final String UNI = "unicode";
/*     */   private String sSMCAddr;
/*     */   private String sDestAddr;
/*     */   private String sTime;
/*     */ 
/*     */   public void setSMCAddr(String sValue)
/*     */   {
/*  24 */     this.sSMCAddr = sValue;
/*     */   }
/*     */ 
/*     */   public String getSMCAddr()
/*     */   {
/*  29 */     return this.sSMCAddr;
/*     */   }
/*     */ 
/*     */   public void setDestAddr(String sValue)
/*     */   {
/*  34 */     this.sDestAddr = sValue;
/*     */   }
/*     */ 
/*     */   public String getDestAddr()
/*     */   {
/*  39 */     return this.sDestAddr;
/*     */   }
/*     */ 
/*     */   private void setTime(String sValue)
/*     */   {
/*  44 */     this.sTime = sValue;
/*     */   }
/*     */ 
/*     */   public String getTime()
/*     */   {
/*  49 */     return this.sTime;
/*     */   }
/*     */ 
/*     */   private String int2hex(int i)
/*     */     throws Exception
/*     */   {
/*  55 */     if (i > 0) {
/*  56 */       if (i < 16) {
/*  57 */         return "0" + Integer.toHexString(i).toUpperCase();
/*     */       }
/*  59 */       return Integer.toHexString(i);
/*  60 */     }if (i < 0) {
/*  61 */       return Integer.toHexString(i).substring(6, 8).toUpperCase();
/*     */     }
/*  63 */     return "00";
/*     */   }
/*     */ 
/*     */   private int hex2int(String s)
/*     */     throws Exception
/*     */   {
/*  69 */     getClass();
/*  70 */     byte[] b = s.getBytes("iso-8859-1");
/*  71 */     int r = 0;
/*  72 */     if ((b[0] >= 48) && (b[0] <= 57))
/*  73 */       r = (b[0] - 48) * 16;
/*     */     else
/*  75 */       r = (b[0] - 65 + 10) * 16;
/*  76 */     if ((b[1] >= 48) && (b[1] <= 57))
/*  77 */       r += b[1] - 48;
/*     */     else
/*  79 */       r += b[1] - 65 + 10;
/*  80 */     return r;
/*     */   }
/*     */ 
/*     */   private String InvertStr(String s)
/*     */     throws Exception
/*     */   {
/*  86 */     byte[] b = s.getBytes("iso-8859-1");
/*  87 */     for (int i = 0; i < b.length; i += 2)
/*     */     {
/*  89 */       byte t = b[i];
/*  90 */       b[i] = b[(i + 1)];
/*  91 */       b[(i + 1)] = t;
/*     */     }
/*     */ 
/*  94 */     return new String(b, "iso-8859-1");
/*     */   }
/*     */ 
/*     */   public String encode(String sData)
/*     */     throws Exception
/*     */   {
/* 100 */     String sResult = "";
/* 101 */     int iLen = getSMCAddr().length();
/* 102 */     iLen = ((iLen & 0x1) != 0 ? iLen + 1 : iLen) / 2 + 1;
/* 103 */     sResult = sResult + int2hex(iLen);
/* 104 */     sResult = sResult + "91";
/* 105 */     String s = getSMCAddr();
/* 106 */     if (s.length() % 2 == 1)
/* 107 */       s = s + "F";
/* 108 */     sResult = sResult + InvertStr(s);
/* 109 */     sResult = sResult + "11";
/* 110 */     sResult = sResult + "00";
/* 111 */     s = getDestAddr();
/* 112 */     sResult = sResult + int2hex(s.length());
/* 113 */     sResult = sResult + "91";
/* 114 */     if (s.length() % 2 == 1)
/* 115 */       s = s + "F";
/* 116 */     sResult = sResult + InvertStr(s);
/* 117 */     sResult = sResult + "00";
/* 118 */     sResult = sResult + "08";
/* 119 */     sResult = sResult + "00";
/* 120 */     if (sData.equals(""))
/* 121 */       sData = " ";
/* 122 */     sResult = sResult + int2hex(sData.length() * 2);
/* 123 */     byte[] b = sData.getBytes("unicode");
/* 124 */     for (int i = 2; i < b.length; i += 2) {
/* 125 */       sResult = sResult + int2hex(b[(i + 1)]) + int2hex(b[i]);
/*     */     }
/* 127 */     return sResult;
/*     */   }
/*     */ 
/*     */   private String decode7(int[] data)
/*     */     throws Exception
/*     */   {
/* 133 */     int iLen = data.length;
/* 134 */     int i = 0;
/* 135 */     int iByte = 0;
/* 136 */     int iLeft = 0;
/* 137 */     int iDst = 0;
/* 138 */     byte[] r = new byte[iLen];
/* 139 */     for (; i < iLen; i++)
/*     */     {
/* 141 */       byte b = (byte)((data[i] << iByte | iLeft) & 0x7F);
/* 142 */       iLeft = data[i] >> 7 - iByte;
/* 143 */       iDst++;
/* 144 */       iByte++; if (iByte == 7)
/*     */       {
/* 146 */         data[i] = iLeft;
/* 147 */         iDst++;
/* 148 */         iByte = 0;
/* 149 */         iLeft = 0;
/*     */       }
/* 151 */       r[i] = b;
/*     */     }
/*     */ 
/* 154 */     return new String(r);
/*     */   }
/*     */ 
/*     */   private String decode16(int[] data)
/*     */     throws Exception
/*     */   {
/* 160 */     byte[] r = new byte[data.length + 2];
/* 161 */     r[0] = -1;
/* 162 */     r[1] = -2;
/* 163 */     int i = 0;
/* 164 */     for (int j = 0; j < data.length / 2; j++)
/*     */     {
/* 166 */       r[(i + 2)] = (byte)data[(i + 1)];
/* 167 */       r[(i + 3)] = (byte)data[i];
/* 168 */       i += 2;
/*     */     }
/*     */ 
/* 171 */     return new String(r, "unicode");
/*     */   }
/*     */ 
/*     */   public String decodePDU(String sPDU)
/*     */     throws Exception
/*     */   {
/* 177 */     String sResult = "";
/* 178 */     String sLen = sPDU.substring(0, 2);
/* 179 */     int iLen = hex2int(sLen) - 1;
/* 180 */     int iOffset = 0;
/* 181 */     String sTemp = InvertStr(sPDU.substring(4, iLen * 2));
/* 182 */     if (sPDU.charAt((iLen + 1) * 2) == 'F')
/* 183 */       setSMCAddr(sTemp.substring(0, sTemp.length() - 2));
/*     */     else
/* 185 */       setSMCAddr(sTemp);
/* 186 */     iOffset = iLen * 2 + 4;
/* 187 */     sTemp = sPDU.substring(iOffset, iOffset + 2);
/* 188 */     int iRe = hex2int(sTemp);
/* 189 */     iOffset += 2;
/* 190 */     sLen = sPDU.substring(iOffset, iOffset + 2);
/* 191 */     iLen = hex2int(sLen);
/* 192 */     iOffset += 4;
/* 193 */     if (iRe == 0)
/*     */     {
/* 195 */       sTemp = "";
/*     */     }
/*     */     else {
/* 198 */       if (iLen % 2 == 0)
/*     */       {
/* 200 */         sTemp = sPDU.substring(iOffset, iOffset + iLen);
/* 201 */         iOffset += iLen + 2;
/*     */       }
/*     */       else {
/* 204 */         sTemp = sPDU.substring(iOffset, iOffset + iLen + 1);
/* 205 */         iOffset += iLen + 1 + 2;
/*     */       }
/* 207 */       sTemp = InvertStr(sTemp).substring(0, iLen);
/*     */     }
/* 209 */     setDestAddr(sTemp);
/* 210 */     sTemp = sPDU.substring(iOffset, iOffset + 2);
/* 211 */     int iCode = hex2int(sTemp);
/* 212 */     iOffset += 2;
/* 213 */     sTemp = sPDU.substring(iOffset, iOffset + 14);
/* 214 */     setTime(InvertStr(sTemp));
/* 215 */     iOffset += 14;
/* 216 */     sLen = sPDU.substring(iOffset, iOffset + 2);
/* 217 */     iLen = hex2int(sLen);
/* 218 */     iOffset += 2;
/* 219 */     sTemp = sPDU.substring(iOffset, iOffset + iLen * 2);
/* 220 */     int[] iArrResult = new int[iLen];
/* 221 */     int i = 0;
/* 222 */     for (int j = 0; i < sTemp.length(); j++)
/*     */     {
/* 224 */       iArrResult[j] = hex2int(sTemp.substring(i, i + 2));
/* 225 */       i += 2;
/*     */     }
/*     */ 
/* 228 */     if (iCode == 0) {
/* 229 */       sResult = decode7(iArrResult);
/*     */     }
/* 231 */     else if (iCode == 8)
/* 232 */       sResult = decode16(iArrResult);
/*     */     else
/* 234 */       sResult = "";
/* 235 */     return sResult;
/*     */   }
/*     */ 
/*     */   public String encodeUCS2(String sData)
/*     */     throws Exception
/*     */   {
/* 241 */     String sResult = "";
/* 242 */     byte[] b = sData.getBytes("unicode");
/* 243 */     for (int i = 2; i < b.length; i += 2) {
/* 244 */       sResult = sResult + int2hex(b[(i + 1)]) + int2hex(b[i]);
/*     */     }
/* 246 */     return sResult;
/*     */   }
/*     */ 
/*     */   public String decodeUCS2(String sData)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 254 */       int iLen = sData.length() / 2;
/* 255 */       int[] iArrResult = new int[iLen];
/* 256 */       int i = 0;
/* 257 */       for (int j = 0; i < sData.length(); j++)
/*     */       {
/* 259 */         iArrResult[j] = hex2int(sData.substring(i, i + 2));
/* 260 */         i += 2;
/*     */       }
/*     */ 
/* 263 */       return decode16(iArrResult);
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 267 */     throw e;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.PDU
 * JD-Core Version:    0.6.0
 */