/*     */ package org.hi.base.report.excel.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.report.excel.model.ExcelCell;
/*     */ import org.hi.base.report.excel.model.ExcelSheet;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class ExcelCellAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected ExcelSheet excelSheet;
/*     */   protected String cellColumn;
/*     */   protected Integer cellRow;
/*     */   protected String variableName;
/*     */   protected String constant;
/*     */   protected Integer isEnumeration;
/*     */   protected Integer reportDataType;
/*     */   protected Integer stretchingType;
/*     */   protected String conditionCell;
/*     */   protected String description;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  85 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  89 */     if (((id != null) && (this.id == null)) || (
/*  90 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  91 */       setDirty(true);
/*  92 */       this.oldValues.put("id", this.id);
/*     */     }
/*  94 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  98 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/* 102 */     if (((version != null) && (this.version == null)) || (
/* 103 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/* 104 */       setDirty(true);
/* 105 */       this.oldValues.put("version", this.version);
/*     */     }
/* 107 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public ExcelSheet getExcelSheet() {
/* 111 */     return this.excelSheet;
/*     */   }
/*     */ 
/*     */   public void setExcelSheet(ExcelSheet excelSheet) {
/* 115 */     if (((excelSheet != null) && (this.excelSheet == null)) || (
/* 116 */       (this.excelSheet != null) && ((!this.excelSheet.equals(excelSheet)) || (excelSheet == null)))) {
/* 117 */       setDirty(true);
/* 118 */       this.oldValues.put("excelSheet", this.excelSheet);
/*     */     }
/* 120 */     this.excelSheet = excelSheet;
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity() {
/* 124 */     return this.excelSheet;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent) {
/* 128 */     this.excelSheet = ((ExcelSheet)parent);
/*     */   }
/*     */ 
/*     */   public String getCellColumn() {
/* 132 */     return this.cellColumn;
/*     */   }
/*     */ 
/*     */   public void setCellColumn(String cellColumn) {
/* 136 */     if (((cellColumn != null) && (this.cellColumn == null)) || (
/* 137 */       (this.cellColumn != null) && ((!this.cellColumn.equals(cellColumn)) || (cellColumn == null)))) {
/* 138 */       setDirty(true);
/* 139 */       this.oldValues.put("cellColumn", this.cellColumn);
/*     */     }
/* 141 */     this.cellColumn = cellColumn;
/*     */   }
/*     */ 
/*     */   public Integer getCellRow() {
/* 145 */     return this.cellRow;
/*     */   }
/*     */ 
/*     */   public void setCellRow(Integer cellRow) {
/* 149 */     if (((cellRow != null) && (this.cellRow == null)) || (
/* 150 */       (this.cellRow != null) && ((!this.cellRow.equals(cellRow)) || (cellRow == null)))) {
/* 151 */       setDirty(true);
/* 152 */       this.oldValues.put("cellRow", this.cellRow);
/*     */     }
/* 154 */     this.cellRow = cellRow;
/*     */   }
/*     */ 
/*     */   public String getVariableName() {
/* 158 */     return this.variableName;
/*     */   }
/*     */ 
/*     */   public void setVariableName(String variableName) {
/* 162 */     if (((variableName != null) && (this.variableName == null)) || (
/* 163 */       (this.variableName != null) && ((!this.variableName.equals(variableName)) || (variableName == null)))) {
/* 164 */       setDirty(true);
/* 165 */       this.oldValues.put("variableName", this.variableName);
/*     */     }
/* 167 */     this.variableName = variableName;
/*     */   }
/*     */ 
/*     */   public String getConstant() {
/* 171 */     return this.constant;
/*     */   }
/*     */ 
/*     */   public void setConstant(String constant) {
/* 175 */     if (((constant != null) && (this.constant == null)) || (
/* 176 */       (this.constant != null) && ((!this.constant.equals(constant)) || (constant == null)))) {
/* 177 */       setDirty(true);
/* 178 */       this.oldValues.put("constant", this.constant);
/*     */     }
/* 180 */     this.constant = constant;
/*     */   }
/*     */ 
/*     */   public Integer getIsEnumeration() {
/* 184 */     return this.isEnumeration;
/*     */   }
/*     */ 
/*     */   public void setIsEnumeration(Integer isEnumeration) {
/* 188 */     if (((isEnumeration != null) && (this.isEnumeration == null)) || (
/* 189 */       (this.isEnumeration != null) && ((!this.isEnumeration.equals(isEnumeration)) || (isEnumeration == null)))) {
/* 190 */       setDirty(true);
/* 191 */       this.oldValues.put("isEnumeration", this.isEnumeration);
/*     */     }
/* 193 */     this.isEnumeration = isEnumeration;
/*     */   }
/*     */ 
/*     */   public Integer getReportDataType() {
/* 197 */     return this.reportDataType;
/*     */   }
/*     */ 
/*     */   public void setReportDataType(Integer reportDataType) {
/* 201 */     if (((reportDataType != null) && (this.reportDataType == null)) || (
/* 202 */       (this.reportDataType != null) && ((!this.reportDataType.equals(reportDataType)) || (reportDataType == null)))) {
/* 203 */       setDirty(true);
/* 204 */       this.oldValues.put("reportDataType", this.reportDataType);
/*     */     }
/* 206 */     this.reportDataType = reportDataType;
/*     */   }
/*     */ 
/*     */   public Integer getStretchingType() {
/* 210 */     return this.stretchingType;
/*     */   }
/*     */ 
/*     */   public void setStretchingType(Integer stretchingType) {
/* 214 */     if (((stretchingType != null) && (this.stretchingType == null)) || (
/* 215 */       (this.stretchingType != null) && ((!this.stretchingType.equals(stretchingType)) || (stretchingType == null)))) {
/* 216 */       setDirty(true);
/* 217 */       this.oldValues.put("stretchingType", this.stretchingType);
/*     */     }
/* 219 */     this.stretchingType = stretchingType;
/*     */   }
/*     */ 
/*     */   public String getConditionCell() {
/* 223 */     return this.conditionCell;
/*     */   }
/*     */ 
/*     */   public void setConditionCell(String conditionCell) {
/* 227 */     if (((conditionCell != null) && (this.conditionCell == null)) || (
/* 228 */       (this.conditionCell != null) && ((!this.conditionCell.equals(conditionCell)) || (conditionCell == null)))) {
/* 229 */       setDirty(true);
/* 230 */       this.oldValues.put("conditionCell", this.conditionCell);
/*     */     }
/* 232 */     this.conditionCell = conditionCell;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 236 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 240 */     if (((description != null) && (this.description == null)) || (
/* 241 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 242 */       setDirty(true);
/* 243 */       this.oldValues.put("description", this.description);
/*     */     }
/* 245 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 251 */     if (this == other) return true;
/* 252 */     if (other == null) return false;
/* 253 */     if (!(other instanceof ExcelCell)) return false;
/* 254 */     ExcelCell castOther = (ExcelCell)other;
/*     */ 
/* 256 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 260 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 261 */     hcb.append(getId());
/* 262 */     hcb.append("ExcelCell".hashCode());
/* 263 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 267 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 268 */     sb.append("id", this.id)
/* 269 */       .append("cellColumn", this.cellColumn)
/* 270 */       .append("cellRow", this.cellRow)
/* 271 */       .append("variableName", this.variableName)
/* 272 */       .append("constant", this.constant)
/* 273 */       .append("conditionCell", this.conditionCell)
/* 274 */       .append("description", this.description);
/*     */ 
/* 276 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 280 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.model.original.ExcelCellAbstract
 * JD-Core Version:    0.6.0
 */