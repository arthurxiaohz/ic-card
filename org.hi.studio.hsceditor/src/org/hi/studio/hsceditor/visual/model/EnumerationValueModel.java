/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import org.hi.studio.core.utils.StringUtil;
/*    */ 
/*    */ public class EnumerationValueModel extends ColumnModel
/*    */ {
/* 11 */   private String enumValue = "";
/* 12 */   private String enumLabel = "";
/* 13 */   private String enumCode = "";
/*    */ 
/*    */   public String getEnumCode() {
/* 16 */     return this.enumCode;
/*    */   }
/*    */   public void setEnumCode(String enumCode) {
/* 19 */     this.enumCode = enumCode;
/*    */   }
/*    */   public String getEnumValue() {
/* 22 */     return this.enumValue;
/*    */   }
/*    */ 
/*    */   public void setEnumValue(String enumValue) {
/* 26 */     this.enumValue = StringUtil.lowerFirstChar(enumValue);
/*    */   }
/*    */   public String getEnumLabel() {
/* 29 */     return this.enumLabel;
/*    */   }
/*    */   public void setEnumLabel(String enumLabel) {
/* 32 */     this.enumLabel = enumLabel;
/*    */   }
/*    */ 
/*    */   public EnumerationValueModel toNewColumn() {
/* 36 */     EnumerationValueModel newModel = new EnumerationValueModel();
/* 37 */     newModel.setEnumValue(getEnumValue());
/* 38 */     newModel.setEnumLabel(getEnumLabel());
/* 39 */     newModel.setEnumCode(getEnumCode());
/*    */ 
/* 41 */     return newModel;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.EnumerationValueModel
 * JD-Core Version:    0.6.0
 */