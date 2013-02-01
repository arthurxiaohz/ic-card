/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class ChineseNumber
/*     */ {
/*  17 */   private static final String[] BEFORE_SCALE = { "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "" };
/*  18 */   private static final String[] AFTER_SCALE = { "角", "分" };
/*     */   private static final String DEFAULT_PATH_SEPARATOR = ".";
/*  21 */   private static final Map<String, String> NUMBER_MAPPING = new HashMap();
/*     */ 
/*  23 */   static { NUMBER_MAPPING.put("0", "零");
/*  24 */     NUMBER_MAPPING.put("1", "壹");
/*  25 */     NUMBER_MAPPING.put("2", "贰");
/*  26 */     NUMBER_MAPPING.put("3", "叁");
/*  27 */     NUMBER_MAPPING.put("4", "肆");
/*  28 */     NUMBER_MAPPING.put("5", "伍");
/*  29 */     NUMBER_MAPPING.put("6", "陆");
/*  30 */     NUMBER_MAPPING.put("7", "柒");
/*  31 */     NUMBER_MAPPING.put("8", "捌");
/*  32 */     NUMBER_MAPPING.put("9", "玖"); }
/*     */ 
/*     */   public static String getChineseNumber(String number)
/*     */   {
/*  36 */     return getChineseNumber(number, null, null);
/*     */   }
/*     */ 
/*     */   public static String getChineseNumber(String number, String unit, String postfix) {
/*  40 */     String[] numbers = StringUtils.strToStrArray(number, ".");
/*  41 */     if (numbers.length > 2) {
/*  42 */       new BusinessException(I18NUtil.getString("数字格式错误!"));
/*     */     }
/*  44 */     int length = numbers[0].length();
/*  45 */     int isZero = 0;
/*  46 */     StringBuffer result = new StringBuffer();
/*     */ 
/*  48 */     for (int i = 0; i < length; i++) {
/*  49 */       String digit = String.valueOf(numbers[0].charAt(i));
/*     */ 
/*  51 */       boolean allZero = true;
/*  52 */       for (int j = i; j < length; j++) {
/*  53 */         if (numbers[0].charAt(j) != '0') {
/*  54 */           allZero = false;
/*  55 */           break;
/*     */         }
/*     */       }
/*     */ 
/*  59 */       if (allZero) {
/*  60 */         boolean hasValue = false;
/*  61 */         for (int z = i; z >= 0; z--) {
/*  62 */           if ((numbers[0].charAt(z) != '0') && (length - z <= 7) && (length - z >= 5)) {
/*  63 */             hasValue = true;
/*  64 */             break;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  69 */         if (((length - i > 4) && (length <= 8)) || ((hasValue) && (length - i > 4)))
/*  70 */           result.append(BEFORE_SCALE[8]);
/*  71 */         if (length - i < 9) break;
/*  72 */         result.append(BEFORE_SCALE[4]);
/*  73 */         break;
/*     */       }
/*     */ 
/*  76 */       if ((length < 9) && (length - i == 5)) {
/*  77 */         if ((!digit.equals("0")) && (isZero > 0))
/*  78 */           result.append((String)NUMBER_MAPPING.get("0"));
/*  79 */         if (digit.equals("0")) {
/*  80 */           result.append(BEFORE_SCALE[8]);
/*  81 */           if (isZero <= 0) continue;
/*  82 */           result.append((String)NUMBER_MAPPING.get("0"));
/*  83 */           continue;
/*     */         }
/*     */       }
/*  86 */       if ((digit.equals("0")) && (length > 9) && (length - i == 9)) {
/*  87 */         result.append(BEFORE_SCALE[4]);
/*     */       }
/*     */       else
/*     */       {
/*  91 */         if ((isZero < 1) || (!digit.equals("0"))) {
/*  92 */           if (digit.equals("0")) {
/*  93 */             if ((length - i != 6) && (length - i != 7))
/*  94 */               result.append((String)NUMBER_MAPPING.get(digit));
/*     */           }
/*  96 */           else result.append((String)NUMBER_MAPPING.get(digit));
/*     */ 
/*  99 */           if (!digit.equals("0")) {
/* 100 */             result.append(BEFORE_SCALE[(BEFORE_SCALE.length - length + i)]);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 105 */         if (digit.equals("0"))
/* 106 */           isZero++;
/*     */         else
/* 108 */           isZero = 0; 
/*     */       }
/*     */     }
/* 110 */     result.append(unit == null ? "圆" : result.append(unit));
/*     */ 
/* 112 */     if (numbers.length == 1) {
/* 113 */       result.append(postfix == null ? "整" : result.append(postfix));
/* 114 */       return result.toString();
/*     */     }
/*     */ 
/* 117 */     length = numbers[1].length();
/* 118 */     for (int j = 0; j < length; j++) {
/* 119 */       if (j > 2) {
/*     */         break;
/*     */       }
/* 122 */       if (numbers[1].charAt(j) == '0')
/*     */         continue;
/* 124 */       result.append((String)NUMBER_MAPPING.get(String.valueOf(numbers[1].charAt(j))));
/* 125 */       result.append(AFTER_SCALE[j]);
/*     */     }
/*     */ 
/* 128 */     result.append(postfix == null ? "整" : result.append(postfix));
/*     */ 
/* 130 */     return result.toString();
/*     */   }
/*     */   public static String getChineseNumber(int number) {
/* 133 */     return getChineseNumber(new Integer(number));
/*     */   }
/*     */ 
/*     */   public static String getChineseNumber(int number, String unit, String postfix) {
/* 137 */     return getChineseNumber(new Integer(number), unit, postfix);
/*     */   }
/*     */   public static String getChineseNumber(Long number) {
/* 140 */     return getChineseNumber(number.toString(), null, null);
/*     */   }
/*     */   public static String getChineseNumber(Integer number) {
/* 143 */     return getChineseNumber(number.toString(), null, null);
/*     */   }
/*     */   public static String getChineseNumber(Integer number, String unit, String postfix) {
/* 146 */     return getChineseNumber(number.toString(), unit, postfix);
/*     */   }
/*     */   public static String getChineseNumber(Long number, String unit, String postfix) {
/* 149 */     return getChineseNumber(number.toString(), unit, postfix);
/*     */   }
/*     */   public static String getChineseNumber(long number) {
/* 152 */     return getChineseNumber(new Long(number));
/*     */   }
/*     */ 
/*     */   public static String getChineseNumber(long number, String unit, String postfix) {
/* 156 */     return getChineseNumber(new Long(number), unit, postfix);
/*     */   }
/*     */ 
/*     */   public static String getChineseNumber(double number, String unit, String postfix) {
/* 160 */     DecimalFormat f = (DecimalFormat)DecimalFormat.getInstance();
/* 161 */     f.applyLocalizedPattern("#.##");
/* 162 */     return getChineseNumber(f.format(number), unit, postfix);
/*     */   }
/*     */   public static String getChineseNumber(double number) {
/* 165 */     return getChineseNumber(number, null, null);
/*     */   }
/*     */   public static String getChineseNumber(Double number) {
/* 168 */     return getChineseNumber(number.doubleValue());
/*     */   }
/*     */ 
/*     */   public static String getChineseNumber(Double number, String unit, String postfix) {
/* 172 */     return getChineseNumber(number.doubleValue(), unit, postfix);
/*     */   }
/*     */   public static void main(String[] args) {
/* 175 */     System.out.println(getChineseNumber(205008));
/* 176 */     System.out.println(getChineseNumber(1020090090.99D));
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.ChineseNumber
 * JD-Core Version:    0.6.0
 */