/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ import org.hi.base.enumeration.EnumerationHelper;
/*    */ import org.hi.base.enumeration.model.EnumerationValue;
/*    */ import org.hi.common.util.BeanUtil;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.metadata.hsc.context.service.Field;
/*    */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*    */ 
/*    */ public abstract class AbstractLogAnalysisor
/*    */   implements LogAnalysisor
/*    */ {
/*    */   protected String getPropertyValueToString(Field field, Field lkFKField, Object propertyValue)
/*    */   {
/* 18 */     String value = null;
/* 19 */     if ((field.getFieldName().equals("version")) || (field.getFieldName().equals("deleted"))) {
/* 20 */       return null;
/*    */     }
/* 22 */     if (field.getFieldType() == 6)
/*    */     {
/* 24 */       if (propertyValue == null) return "null";
/* 25 */       Object lkPerValue = BeanUtil.getPropertyValue(propertyValue, field.getLookupEntity().getMainLkFieldName());
/* 26 */       if (lkPerValue == null) {
/* 27 */         return "null";
/*    */       }
/*    */ 
/* 30 */       if ((lkPerValue instanceof Date)) {
/* 31 */         Date date = (Date)lkPerValue;
/* 32 */         value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
/*    */       }
/* 34 */       else if ((lkPerValue instanceof Timestamp)) {
/* 35 */         Timestamp time = (Timestamp)lkPerValue;
/* 36 */         Date date = new Date(time.getTime());
/* 37 */         value = StringUtils.DateToStr(date, "yyyy-MM-dd");
/*    */       }
/*    */       else {
/* 40 */         value = lkPerValue.toString().equals("") ? "null" : lkPerValue.toString();
/*    */       }
/*    */ 
/* 43 */       return value;
/*    */     }
/*    */ 
/* 46 */     Object _value = propertyValue;
/* 47 */     if ((_value == null) || (((_value instanceof String)) && (_value.equals("")))) {
/* 48 */       value = "null";
/*    */     }
/* 52 */     else if (field.getFieldType() == 7) {
/* 53 */       EnumerationValue enuValue = EnumerationHelper.getEnumerationValue((Integer)_value);
/* 54 */       value = enuValue.getDescription();
/*    */     }
/* 57 */     else if ((_value instanceof Date)) {
/* 58 */       Date date = (Date)_value;
/* 59 */       value = StringUtils.DateToStr(date, "yyyy-MM-dd");
/*    */     }
/* 61 */     else if ((_value instanceof Timestamp)) {
/* 62 */       Timestamp time = (Timestamp)_value;
/* 63 */       Date date = new Date(time.getTime());
/* 64 */       value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
/*    */     }
/*    */     else {
/* 67 */       value = _value.toString();
/* 68 */       if (value.length() > 200) {
/* 69 */         value = value.substring(0, 200) + "...";
/*    */       }
/*    */     }
/* 72 */     return value;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object logProcessor) {
/* 76 */     return getClass().equals(logProcessor.getClass());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.AbstractLogAnalysisor
 * JD-Core Version:    0.6.0
 */