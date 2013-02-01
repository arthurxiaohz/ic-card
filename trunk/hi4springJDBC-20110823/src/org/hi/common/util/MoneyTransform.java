/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class MoneyTransform
/*     */ {
/*     */   public static String getChnmoney(String strNum)
/*     */   {
/*   5 */     int s = 0;
/*     */ 
/*   7 */     String input = strNum;
/*   8 */     String output = "";
/*   9 */     if (strNum.equals("")) {
/*  10 */       return null;
/*     */     }
/*     */ 
/*  13 */     int length = input.length();
/*  14 */     int pstn = input.indexOf('.');
/*     */     String subInput;
/*     */     int subLength;
/*     */     String subInput;
/*  16 */     if (pstn == -1)
/*     */     {
/*  18 */       int subLength = length;
/*  19 */       subInput = input;
/*     */     }
/*     */     else
/*     */     {
/*  23 */       subLength = pstn;
/*  24 */       subInput = input.substring(0, subLength);
/*     */     }
/*     */ 
/*  27 */     char[] array = new char[4];
/*  28 */     char[] array2 = { '仟', '佰', '拾' };
/*  29 */     char[] array3 = { '亿', '万', '元', 35282, '分' };
/*     */ 
/*  31 */     int n = subLength / 4;
/*  32 */     int m = subLength % 4;
/*     */ 
/*  34 */     if (m != 0)
/*     */     {
/*  36 */       for (int i = 0; i < 4 - m; i++)
/*     */       {
/*  38 */         subInput = '0' + subInput;
/*     */       }
/*  40 */       n++;
/*     */     }
/*  42 */     int k = n;
/*     */ 
/*  44 */     for (int i = 0; i < n; i++)
/*     */     {
/*  46 */       int p = 0;
/*  47 */       String change = subInput.substring(4 * i, 4 * (i + 1));
/*  48 */       array = change.toCharArray();
/*     */ 
/*  50 */       for (int j = 0; j < 4; j++)
/*     */       {
/*  52 */         output = output + formatC(array[j]);
/*  53 */         if (j < 3)
/*     */         {
/*  55 */           output = output + array2[j];
/*     */         }
/*  57 */         p++;
/*     */       }
/*     */ 
/*  60 */       if (p != 0) output = output + array3[(3 - k)];
/*     */ 
/*  63 */       String[] str = { "零仟", "零佰", "零拾" };
/*     */       int q;
/*  64 */       for (s = 0; s < 3; s++)
/*     */       {
/*     */         while (true)
/*     */         {
/*  68 */           int q = output.indexOf(str[s]);
/*  69 */           if (q == -1) break;
/*  70 */           output = output.substring(0, q) + "零" + output.substring(q + str[s].length());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */       while (true)
/*     */       {
/*  77 */         int q = output.indexOf("零零");
/*  78 */         if (q == -1) break;
/*  79 */         output = output.substring(0, q) + "零" + output.substring(q + 2);
/*     */       }
/*     */       int q;
/*  83 */       String[] str1 = { "零亿", "零万", "零元" };
/*  84 */       for (s = 0; s < 3; s++)
/*     */       {
/*     */         while (true)
/*     */         {
/*  88 */           q = output.indexOf(str1[s]);
/*  89 */           if (q == -1) break;
/*  90 */           output = output.substring(0, q) + output.substring(q + 1);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  95 */       k--;
/*     */     }
/*     */ 
/*  98 */     if (pstn != -1)
/*     */     {
/* 100 */       for (i = 1; i < length - pstn; i++)
/*     */       {
/* 102 */         if (input.charAt(pstn + i) != '0')
/*     */         {
/* 104 */           output = output + formatC(input.charAt(pstn + i));
/* 105 */           output = output + array3[(2 + i)];
/*     */         }
/* 107 */         else if (i < 2) {
/* 108 */           output = output + "零";
/*     */         } else {
/* 110 */           output = output;
/*     */         }
/*     */       }
/*     */     }
/* 113 */     if (output.substring(0, 1).equals("零"))
/* 114 */       output = output.substring(1);
/* 115 */     if (output.substring(output.length() - 1, output.length()).equals("零"))
/* 116 */       output = output.substring(0, output.length() - 1);
/* 117 */     return output += "整";
/*     */   }
/*     */ 
/*     */   public static String get3Eng(String strNum)
/*     */   {
/* 122 */     String strEng = "";
/* 123 */     String[] str = { "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
/* 124 */     String[] str1 = { "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
/* 125 */     String[] str2 = { "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY", "HUNDRED" };
/* 126 */     int length = strNum.length();
/* 127 */     int num = Integer.parseInt(strNum);
/* 128 */     int b = num / 100;
/* 129 */     int t = num % 100 / 10;
/* 130 */     int g = num % 100 % 10;
/* 131 */     if (b != 0) {
/* 132 */       strEng = strEng + str[b] + " " + str2[9];
/*     */     }
/*     */ 
/* 135 */     if (t == 0) {
/* 136 */       if (g != 0) {
/* 137 */         if (b != 0) {
/* 138 */           strEng = strEng + " AND ";
/*     */         }
/* 140 */         strEng = strEng + str[g];
/*     */       }
/* 142 */     } else if (t == 1) {
/* 143 */       if (b != 0) {
/* 144 */         strEng = strEng + " AND ";
/* 145 */         num %= 100;
/*     */       }
/* 147 */       strEng = strEng + str1[(num - 10)];
/* 148 */     } else if (t != 1) {
/* 149 */       if (g != 0) {
/* 150 */         if (b != 0) {
/* 151 */           strEng = strEng + " AND ";
/*     */         }
/* 153 */         strEng = strEng + str2[(t - 1)] + "-" + str[g];
/*     */       } else {
/* 155 */         if (b != 0) {
/* 156 */           strEng = strEng + " AND ";
/*     */         }
/* 158 */         strEng = strEng + str2[(t - 1)] + str[g];
/*     */       }
/*     */     }
/* 161 */     return strEng;
/*     */   }
/*     */ 
/*     */   public static String getCent(String strNum) {
/* 165 */     String strEng = "";
/* 166 */     String[] str = { "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
/* 167 */     String[] str1 = { "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
/* 168 */     String[] str2 = { "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY", "HUNDRED" };
/* 169 */     String[] str3 = { "CENTS", "", "DOLLARS", "", "HUNDRED", "THOUSAND", "", "", "MILLION", "", "", "BILLION", "", "" };
/* 170 */     if (strNum.equals("")) {
/* 171 */       return null;
/*     */     }
/*     */ 
/* 174 */     int length = strNum.length();
/* 175 */     if (length != 3) {
/* 176 */       return "输入的位数错误！";
/*     */     }
/* 178 */     int cent = Integer.parseInt(strNum.substring(1, 3));
/* 179 */     if (cent == 0) {
/* 180 */       return strEng;
/*     */     }
/* 182 */     if (cent < 10) {
/* 183 */       strEng = str3[0] + " " + strEng + str[cent];
/* 184 */     } else if ((cent >= 10) && (cent <= 19)) {
/* 185 */       strEng = str3[0] + " " + strEng + str1[(cent - 10)];
/* 186 */     } else if (cent > 19) {
/* 187 */       int jiao = cent / 10;
/* 188 */       int fen = cent % 10;
/* 189 */       if (fen != 0)
/* 190 */         strEng = str3[0] + " " + strEng + str2[(jiao - 1)] + "-" + str[fen];
/*     */       else {
/* 192 */         strEng = str3[0] + " " + strEng + str2[(jiao - 1)] + str[fen];
/*     */       }
/*     */     }
/* 195 */     return strEng;
/*     */   }
/*     */ 
/*     */   public static String getEngmoney(String strNum) {
/* 199 */     String strNumber = "";
/* 200 */     String[] str3 = { "CENTS", "", "DOLLARS", "", "HUNDRED", "THOUSAND", "", "", "MILLION", "", "", "BILLION", "", "" };
/* 201 */     String strEng = "";
/* 202 */     strNumber = strNum;
/* 203 */     int pointbz = strNumber.indexOf(".");
/* 204 */     if (pointbz < 0) {
/* 205 */       strNumber = strNumber + ".00";
/* 206 */     } else if (pointbz > 0) {
/* 207 */       int k = strNum.length() - pointbz;
/* 208 */       if (k == 2)
/* 209 */         strNumber = strNumber + "0";
/* 210 */       else if (k == 1) {
/* 211 */         strNumber = strNumber + "00";
/*     */       }
/*     */     }
/* 214 */     int length = strNumber.length();
/* 215 */     if (length > 16) {
/* 216 */       return "您输入的值过大系统无法处理！";
/*     */     }
/* 218 */     String strb = "";
/* 219 */     String strm = "";
/* 220 */     String strq = "";
/* 221 */     String stry = "";
/* 222 */     String strf = "";
/*     */ 
/* 224 */     if (length == 3) {
/* 225 */       strf = getCent(strNumber);
/* 226 */       strEng = strEng + strf;
/* 227 */     } else if ((length > 3) && (length < 7)) {
/* 228 */       stry = get3Eng(strNumber.substring(0, length - 3));
/* 229 */       strf = getCent(strNumber.substring(length - 3, length));
/* 230 */       strEng = strEng + stry + " " + str3[2];
/* 231 */       if (!strf.equals(""))
/* 232 */         strEng = strEng + " AND " + strf;
/*     */     }
/* 234 */     else if ((length > 6) && (length < 10)) {
/* 235 */       strq = get3Eng(strNumber.substring(0, length - 6));
/* 236 */       stry = get3Eng(strNumber.substring(length - 6, length - 3));
/* 237 */       strf = getCent(strNumber.substring(length - 3, length));
/* 238 */       strEng = strEng + strq + " " + str3[5];
/* 239 */       if (stry.equals(""))
/* 240 */         strEng = strEng + " " + stry;
/*     */       else {
/* 242 */         strEng = strEng + " " + stry + " " + str3[2];
/*     */       }
/* 244 */       if (!strf.equals(""))
/* 245 */         strEng = strEng + " AND " + strf;
/*     */     }
/* 247 */     else if ((length > 9) && (length < 13)) {
/* 248 */       strm = get3Eng(strNumber.substring(0, length - 9));
/* 249 */       strq = get3Eng(strNumber.substring(length - 9, length - 6));
/* 250 */       stry = get3Eng(strNumber.substring(length - 6, length - 3));
/* 251 */       strf = getCent(strNumber.substring(length - 3, length));
/* 252 */       strEng = strEng + strm + " " + str3[8];
/* 253 */       if (!strq.equals("")) {
/* 254 */         strEng = strEng + " " + strq + " " + str3[5];
/*     */       }
/* 256 */       if (!stry.equals(""))
/* 257 */         strEng = strEng + " " + stry + " " + str3[2];
/*     */       else {
/* 259 */         strEng = strEng + " " + str3[2];
/*     */       }
/* 261 */       if (!strf.equals(""))
/* 262 */         strEng = strEng + " AND " + strf;
/*     */     }
/* 264 */     else if ((length > 12) && (length < 16)) {
/* 265 */       strb = get3Eng(strNumber.substring(0, length - 12));
/* 266 */       strm = get3Eng(strNumber.substring(length - 12, length - 9));
/* 267 */       strq = get3Eng(strNumber.substring(length - 9, length - 6));
/* 268 */       stry = get3Eng(strNumber.substring(length - 6, length - 3));
/* 269 */       strf = getCent(strNumber.substring(length - 3, length));
/* 270 */       strEng = strEng + strb + " " + str3[11];
/* 271 */       if (!strm.equals("")) {
/* 272 */         strEng = strEng + " " + strm + " " + str3[8];
/*     */       }
/* 274 */       if (!strq.equals("")) {
/* 275 */         strEng = strEng + " " + strq + " " + str3[5];
/*     */       }
/* 277 */       if (!stry.equals(""))
/* 278 */         strEng = strEng + " " + stry + " " + str3[2];
/*     */       else {
/* 280 */         strEng = strEng + " " + str3[2];
/*     */       }
/* 282 */       if (!strf.equals("")) {
/* 283 */         strEng = strEng + " AND " + strf;
/*     */       }
/*     */     }
/*     */ 
/* 287 */     return strEng + " ONLY";
/*     */   }
/*     */ 
/*     */   public static String formatC(char x)
/*     */   {
/* 292 */     String a = "";
/* 293 */     switch (x) {
/*     */     case '0':
/* 295 */       a = "零";
/* 296 */       break;
/*     */     case '1':
/* 297 */       a = "壹";
/* 298 */       break;
/*     */     case '2':
/* 299 */       a = "贰";
/* 300 */       break;
/*     */     case '3':
/* 301 */       a = "叁";
/* 302 */       break;
/*     */     case '4':
/* 303 */       a = "肆";
/* 304 */       break;
/*     */     case '5':
/* 305 */       a = "伍";
/* 306 */       break;
/*     */     case '6':
/* 307 */       a = "陆";
/* 308 */       break;
/*     */     case '7':
/* 309 */       a = "柒";
/* 310 */       break;
/*     */     case '8':
/* 311 */       a = "捌";
/* 312 */       break;
/*     */     case '9':
/* 313 */       a = "玖";
/*     */     }
/*     */ 
/* 316 */     return a;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 323 */     System.out.println(getChnmoney("20088000"));
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.util.MoneyTransform
 * JD-Core Version:    0.6.0
 */