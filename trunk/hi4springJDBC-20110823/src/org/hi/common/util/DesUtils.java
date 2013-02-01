/*     */ package org.hi.common.util;
/*     */ 
/*     */ import com.sun.crypto.provider.SunJCE;
/*     */ import java.io.PrintStream;
/*     */ import java.security.Key;
/*     */ import java.security.Security;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ 
/*     */ public class DesUtils
/*     */ {
/*  16 */   private static String strDefaultKey = ".hi.";
/*     */ 
/*  19 */   private Cipher encryptCipher = null;
/*     */ 
/*  22 */   private Cipher decryptCipher = null;
/*     */ 
/*     */   public static String byteArr2HexStr(byte[] arrB)
/*     */     throws Exception
/*     */   {
/*  35 */     int iLen = arrB.length;
/*     */ 
/*  37 */     StringBuffer sb = new StringBuffer(iLen * 2);
/*  38 */     for (int i = 0; i < iLen; i++) {
/*  39 */       int intTmp = arrB[i];
/*     */ 
/*  41 */       while (intTmp < 0) {
/*  42 */         intTmp += 256;
/*     */       }
/*     */ 
/*  45 */       if (intTmp < 16) {
/*  46 */         sb.append("0");
/*     */       }
/*  48 */       sb.append(Integer.toString(intTmp, 16));
/*     */     }
/*  50 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static byte[] hexStr2ByteArr(String strIn)
/*     */     throws Exception
/*     */   {
/*  65 */     byte[] arrB = strIn.getBytes();
/*  66 */     int iLen = arrB.length;
/*     */ 
/*  69 */     byte[] arrOut = new byte[iLen / 2];
/*  70 */     for (int i = 0; i < iLen; i += 2) {
/*  71 */       String strTmp = new String(arrB, i, 2);
/*  72 */       arrOut[(i / 2)] = (byte)Integer.parseInt(strTmp, 16);
/*     */     }
/*  74 */     return arrOut;
/*     */   }
/*     */ 
/*     */   public DesUtils()
/*     */     throws Exception
/*     */   {
/*  83 */     this(strDefaultKey);
/*     */   }
/*     */ 
/*     */   public DesUtils(String strKey)
/*     */     throws Exception
/*     */   {
/*  94 */     Security.addProvider(new SunJCE());
/*  95 */     Key key = getKey(strKey.getBytes());
/*     */ 
/*  97 */     this.encryptCipher = Cipher.getInstance("DES");
/*  98 */     this.encryptCipher.init(1, key);
/*     */ 
/* 100 */     this.decryptCipher = Cipher.getInstance("DES");
/* 101 */     this.decryptCipher.init(2, key);
/*     */   }
/*     */ 
/*     */   public byte[] encrypt(byte[] arrB)
/*     */     throws Exception
/*     */   {
/* 113 */     return this.encryptCipher.doFinal(arrB);
/*     */   }
/*     */ 
/*     */   public String encrypt(String strIn)
/*     */     throws Exception
/*     */   {
/* 125 */     return byteArr2HexStr(encrypt(strIn.getBytes()));
/*     */   }
/*     */ 
/*     */   public byte[] decrypt(byte[] arrB)
/*     */     throws Exception
/*     */   {
/* 137 */     return this.decryptCipher.doFinal(arrB);
/*     */   }
/*     */ 
/*     */   public String decrypt(String strIn)
/*     */     throws Exception
/*     */   {
/* 149 */     return new String(decrypt(hexStr2ByteArr(strIn)));
/*     */   }
/*     */ 
/*     */   private Key getKey(byte[] arrBTmp)
/*     */     throws Exception
/*     */   {
/* 162 */     byte[] arrB = new byte[8];
/*     */ 
/* 165 */     for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); i++) {
/* 166 */       arrB[i] = arrBTmp[i];
/*     */     }
/*     */ 
/* 170 */     Key key = new SecretKeySpec(arrB, "DES");
/*     */ 
/* 172 */     return key;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/*     */     try {
/* 177 */       String test = "enumeration.id=-1";
/* 178 */       DesUtils des = new DesUtils();
/* 179 */       System.out.println("加密前的字符：" + test);
/* 180 */       System.out.println("加密后的字符：" + des.encrypt(test));
/* 181 */       System.out.println("解密后的字符：" + des.decrypt(des.encrypt(test)));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.DesUtils
 * JD-Core Version:    0.6.0
 */