/*     */ package org.hi.base.report.excel.action;
/*     */ 
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class ExcelCellPageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected String f_cellColumn;
/*     */   protected String f_cellColumn_op;
/*     */   protected Integer f_cellRow;
/*     */   protected String f_cellRow_op;
/*     */   protected String f_variableName;
/*     */   protected String f_variableName_op;
/*     */   protected String f_constant;
/*     */   protected String f_constant_op;
/*     */   protected Integer f_isEnumeration;
/*     */   protected String f_isEnumeration_op;
/*     */   protected Integer f_reportDataType;
/*     */   protected String f_reportDataType_op;
/*     */   protected Integer f_stretchingType;
/*     */   protected String f_stretchingType_op;
/*     */   protected String f_condition;
/*     */   protected String f_condition_op;
/*     */   protected String f_description;
/*     */   protected String f_description_op;
/*     */   protected ExcelSheetPageInfo excelSheet;
/*     */ 
/*     */   public Integer getF_id()
/*     */   {
/*  35 */     return this.f_id;
/*     */   }
/*     */ 
/*     */   public void setF_id(Integer f_id) {
/*  39 */     this.f_id = f_id;
/*     */   }
/*     */ 
/*     */   public String getF_id_op() {
/*  43 */     return this.f_id_op;
/*     */   }
/*     */ 
/*     */   public void setF_id_op(String f_id_op) {
/*  47 */     this.f_id_op = f_id_op;
/*     */   }
/*     */ 
/*     */   public String getF_cellColumn() {
/*  51 */     return this.f_cellColumn;
/*     */   }
/*     */ 
/*     */   public void setF_cellColumn(String f_cellColumn) {
/*  55 */     this.f_cellColumn = f_cellColumn;
/*     */   }
/*     */ 
/*     */   public String getF_cellColumn_op() {
/*  59 */     return this.f_cellColumn_op;
/*     */   }
/*     */ 
/*     */   public void setF_cellColumn_op(String f_cellColumn_op) {
/*  63 */     this.f_cellColumn_op = f_cellColumn_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_cellRow() {
/*  67 */     return this.f_cellRow;
/*     */   }
/*     */ 
/*     */   public void setF_cellRow(Integer f_cellRow) {
/*  71 */     this.f_cellRow = f_cellRow;
/*     */   }
/*     */ 
/*     */   public String getF_cellRow_op() {
/*  75 */     return this.f_cellRow_op;
/*     */   }
/*     */ 
/*     */   public void setF_cellRow_op(String f_cellRow_op) {
/*  79 */     this.f_cellRow_op = f_cellRow_op;
/*     */   }
/*     */ 
/*     */   public String getF_variableName() {
/*  83 */     return this.f_variableName;
/*     */   }
/*     */ 
/*     */   public void setF_variableName(String f_variableName) {
/*  87 */     this.f_variableName = f_variableName;
/*     */   }
/*     */ 
/*     */   public String getF_variableName_op() {
/*  91 */     return this.f_variableName_op;
/*     */   }
/*     */ 
/*     */   public void setF_variableName_op(String f_variableName_op) {
/*  95 */     this.f_variableName_op = f_variableName_op;
/*     */   }
/*     */ 
/*     */   public String getF_constant() {
/*  99 */     return this.f_constant;
/*     */   }
/*     */ 
/*     */   public void setF_constant(String f_constant) {
/* 103 */     this.f_constant = f_constant;
/*     */   }
/*     */ 
/*     */   public String getF_constant_op() {
/* 107 */     return this.f_constant_op;
/*     */   }
/*     */ 
/*     */   public void setF_constant_op(String f_constant_op) {
/* 111 */     this.f_constant_op = f_constant_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_isEnumeration() {
/* 115 */     return this.f_isEnumeration;
/*     */   }
/*     */ 
/*     */   public void setF_isEnumeration(Integer f_isEnumeration) {
/* 119 */     this.f_isEnumeration = f_isEnumeration;
/*     */   }
/*     */ 
/*     */   public String getF_isEnumeration_op() {
/* 123 */     return this.f_isEnumeration_op;
/*     */   }
/*     */ 
/*     */   public void setF_isEnumeration_op(String f_isEnumeration_op) {
/* 127 */     this.f_isEnumeration_op = f_isEnumeration_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_reportDataType() {
/* 131 */     return this.f_reportDataType;
/*     */   }
/*     */ 
/*     */   public void setF_reportDataType(Integer f_reportDataType) {
/* 135 */     this.f_reportDataType = f_reportDataType;
/*     */   }
/*     */ 
/*     */   public String getF_reportDataType_op() {
/* 139 */     return this.f_reportDataType_op;
/*     */   }
/*     */ 
/*     */   public void setF_reportDataType_op(String f_reportDataType_op) {
/* 143 */     this.f_reportDataType_op = f_reportDataType_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_stretchingType() {
/* 147 */     return this.f_stretchingType;
/*     */   }
/*     */ 
/*     */   public void setF_stretchingType(Integer f_stretchingType) {
/* 151 */     this.f_stretchingType = f_stretchingType;
/*     */   }
/*     */ 
/*     */   public String getF_stretchingType_op() {
/* 155 */     return this.f_stretchingType_op;
/*     */   }
/*     */ 
/*     */   public void setF_stretchingType_op(String f_stretchingType_op) {
/* 159 */     this.f_stretchingType_op = f_stretchingType_op;
/*     */   }
/*     */ 
/*     */   public String getF_condition() {
/* 163 */     return this.f_condition;
/*     */   }
/*     */ 
/*     */   public void setF_condition(String f_condition) {
/* 167 */     this.f_condition = f_condition;
/*     */   }
/*     */ 
/*     */   public String getF_condition_op() {
/* 171 */     return this.f_condition_op;
/*     */   }
/*     */ 
/*     */   public void setF_condition_op(String f_condition_op) {
/* 175 */     this.f_condition_op = f_condition_op;
/*     */   }
/*     */ 
/*     */   public String getF_description() {
/* 179 */     return this.f_description;
/*     */   }
/*     */ 
/*     */   public void setF_description(String f_description) {
/* 183 */     this.f_description = f_description;
/*     */   }
/*     */ 
/*     */   public String getF_description_op() {
/* 187 */     return this.f_description_op;
/*     */   }
/*     */ 
/*     */   public void setF_description_op(String f_description_op) {
/* 191 */     this.f_description_op = f_description_op;
/*     */   }
/*     */ 
/*     */   public ExcelSheetPageInfo getExcelSheet() {
/* 195 */     return this.excelSheet;
/*     */   }
/*     */ 
/*     */   public void setExcelSheet(ExcelSheetPageInfo excelSheet) {
/* 199 */     this.excelSheet = excelSheet;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.ExcelCellPageInfo
 * JD-Core Version:    0.6.0
 */