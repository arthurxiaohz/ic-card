/*     */ package org.hi.base.report.excel.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.report.excel.model.ExcelCell;
/*     */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*     */ import org.hi.base.report.excel.model.ExcelSheet;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class ExcelSheetAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected ExcelReportDesign excelReportDesign;
/*     */   protected String sheetName;
/*  43 */   protected Double sequence = new Double(9999.0D);
/*     */   protected String description;
/*     */   private List<ExcelCell> excelCells;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  53 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  57 */     if (((id != null) && (this.id == null)) || (
/*  58 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  59 */       setDirty(true);
/*  60 */       this.oldValues.put("id", this.id);
/*     */     }
/*  62 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  66 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  70 */     if (((version != null) && (this.version == null)) || (
/*  71 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  72 */       setDirty(true);
/*  73 */       this.oldValues.put("version", this.version);
/*     */     }
/*  75 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public ExcelReportDesign getExcelReportDesign() {
/*  79 */     return this.excelReportDesign;
/*     */   }
/*     */ 
/*     */   public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
/*  83 */     if (((excelReportDesign != null) && (this.excelReportDesign == null)) || (
/*  84 */       (this.excelReportDesign != null) && ((!this.excelReportDesign.equals(excelReportDesign)) || (excelReportDesign == null)))) {
/*  85 */       setDirty(true);
/*  86 */       this.oldValues.put("excelReportDesign", this.excelReportDesign);
/*     */     }
/*  88 */     this.excelReportDesign = excelReportDesign;
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity() {
/*  92 */     return this.excelReportDesign;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent) {
/*  96 */     this.excelReportDesign = ((ExcelReportDesign)parent);
/*     */   }
/*     */ 
/*     */   public String getSheetName() {
/* 100 */     return this.sheetName;
/*     */   }
/*     */ 
/*     */   public void setSheetName(String sheetName) {
/* 104 */     if (((sheetName != null) && (this.sheetName == null)) || (
/* 105 */       (this.sheetName != null) && ((!this.sheetName.equals(sheetName)) || (sheetName == null)))) {
/* 106 */       setDirty(true);
/* 107 */       this.oldValues.put("sheetName", this.sheetName);
/*     */     }
/* 109 */     this.sheetName = sheetName;
/*     */   }
/*     */ 
/*     */   public Double getSequence() {
/* 113 */     return this.sequence;
/*     */   }
/*     */ 
/*     */   public void setSequence(Double sequence) {
/* 117 */     if (((sequence != null) && (this.sequence == null)) || (
/* 118 */       (this.sequence != null) && ((!this.sequence.equals(sequence)) || (sequence == null)))) {
/* 119 */       setDirty(true);
/* 120 */       this.oldValues.put("sequence", this.sequence);
/*     */     }
/* 122 */     this.sequence = sequence;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 126 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 130 */     if (((description != null) && (this.description == null)) || (
/* 131 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 132 */       setDirty(true);
/* 133 */       this.oldValues.put("description", this.description);
/*     */     }
/* 135 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public void setExcelCells(List<ExcelCell> excelCells)
/*     */   {
/* 140 */     this.excelCells = excelCells;
/*     */   }
/*     */ 
/*     */   public List<ExcelCell> getExcelCells() {
/* 144 */     return this.excelCells;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other) {
/* 148 */     if (this == other) return true;
/* 149 */     if (other == null) return false;
/* 150 */     if (!(other instanceof ExcelSheet)) return false;
/* 151 */     ExcelSheet castOther = (ExcelSheet)other;
/*     */ 
/* 153 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 157 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 158 */     hcb.append(getId());
/* 159 */     hcb.append("ExcelSheet".hashCode());
/* 160 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 164 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 165 */     sb.append("id", this.id)
/* 166 */       .append("sheetName", this.sheetName)
/* 167 */       .append("sequence", this.sequence)
/* 168 */       .append("description", this.description);
/*     */ 
/* 170 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 174 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.model.original.ExcelSheetAbstract
 * JD-Core Version:    0.6.0
 */