/*     */ package org.hi.base.report.excel.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*     */ import org.hi.base.report.excel.model.ExcelSheet;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public abstract class ExcelReportDesignAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String reportName;
/*     */   protected String reportNum;
/*     */   protected String template;
/*  49 */   protected Date createDate = new Date();
/*     */   protected Integer enabled;
/*     */   protected String actionName;
/*     */   protected String description;
/*  70 */   protected HiUser creator = UserContextHelper.getUser();
/*     */   private List<ExcelSheet> excelSheets;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  79 */     if (((id != null) && (this.id == null)) || (
/*  80 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  81 */       setDirty(true);
/*  82 */       this.oldValues.put("id", this.id);
/*     */     }
/*  84 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  88 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  92 */     if (((version != null) && (this.version == null)) || (
/*  93 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  94 */       setDirty(true);
/*  95 */       this.oldValues.put("version", this.version);
/*     */     }
/*  97 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getReportName() {
/* 101 */     return this.reportName;
/*     */   }
/*     */ 
/*     */   public void setReportName(String reportName) {
/* 105 */     if (((reportName != null) && (this.reportName == null)) || (
/* 106 */       (this.reportName != null) && ((!this.reportName.equals(reportName)) || (reportName == null)))) {
/* 107 */       setDirty(true);
/* 108 */       this.oldValues.put("reportName", this.reportName);
/*     */     }
/* 110 */     this.reportName = reportName;
/*     */   }
/*     */ 
/*     */   public String getReportNum() {
/* 114 */     return this.reportNum;
/*     */   }
/*     */ 
/*     */   public void setReportNum(String reportNum) {
/* 118 */     if (((reportNum != null) && (this.reportNum == null)) || (
/* 119 */       (this.reportNum != null) && ((!this.reportNum.equals(reportNum)) || (reportNum == null)))) {
/* 120 */       setDirty(true);
/* 121 */       this.oldValues.put("reportNum", this.reportNum);
/*     */     }
/* 123 */     this.reportNum = reportNum;
/*     */   }
/*     */ 
/*     */   public String getTemplate() {
/* 127 */     return this.template;
/*     */   }
/*     */ 
/*     */   public void setTemplate(String template) {
/* 131 */     if (((template != null) && (this.template == null)) || (
/* 132 */       (this.template != null) && ((!this.template.equals(template)) || (template == null)))) {
/* 133 */       setDirty(true);
/* 134 */       this.oldValues.put("template", this.template);
/*     */     }
/* 136 */     this.template = template;
/*     */   }
/*     */ 
/*     */   public Date getCreateDate() {
/* 140 */     return this.createDate;
/*     */   }
/*     */ 
/*     */   public void setCreateDate(Date createDate) {
/* 144 */     if (((createDate != null) && (this.createDate == null)) || (
/* 145 */       (this.createDate != null) && ((!this.createDate.equals(createDate)) || (createDate == null)))) {
/* 146 */       setDirty(true);
/* 147 */       this.oldValues.put("createDate", this.createDate);
/*     */     }
/* 149 */     this.createDate = createDate;
/*     */   }
/*     */ 
/*     */   public Integer getEnabled() {
/* 153 */     return this.enabled;
/*     */   }
/*     */ 
/*     */   public void setEnabled(Integer enabled) {
/* 157 */     if (((enabled != null) && (this.enabled == null)) || (
/* 158 */       (this.enabled != null) && ((!this.enabled.equals(enabled)) || (enabled == null)))) {
/* 159 */       setDirty(true);
/* 160 */       this.oldValues.put("enabled", this.enabled);
/*     */     }
/* 162 */     this.enabled = enabled;
/*     */   }
/*     */ 
/*     */   public String getActionName() {
/* 166 */     return this.actionName;
/*     */   }
/*     */ 
/*     */   public void setActionName(String actionName) {
/* 170 */     if (((actionName != null) && (this.actionName == null)) || (
/* 171 */       (this.actionName != null) && ((!this.actionName.equals(actionName)) || (actionName == null)))) {
/* 172 */       setDirty(true);
/* 173 */       this.oldValues.put("actionName", this.actionName);
/*     */     }
/* 175 */     this.actionName = actionName;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 179 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 183 */     if (((description != null) && (this.description == null)) || (
/* 184 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 185 */       setDirty(true);
/* 186 */       this.oldValues.put("description", this.description);
/*     */     }
/* 188 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 192 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 196 */     if (((creator != null) && (this.creator == null)) || (
/* 197 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 198 */       setDirty(true);
/* 199 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 201 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public void setExcelSheets(List<ExcelSheet> excelSheets)
/*     */   {
/* 206 */     this.excelSheets = excelSheets;
/*     */   }
/*     */ 
/*     */   public List<ExcelSheet> getExcelSheets() {
/* 210 */     return this.excelSheets;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other) {
/* 214 */     if (this == other) return true;
/* 215 */     if (other == null) return false;
/* 216 */     if (!(other instanceof ExcelReportDesign)) return false;
/* 217 */     ExcelReportDesign castOther = (ExcelReportDesign)other;
/*     */ 
/* 219 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 223 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 224 */     hcb.append(getId());
/* 225 */     hcb.append("ExcelReportDesign".hashCode());
/* 226 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 230 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 231 */     sb.append("id", this.id)
/* 232 */       .append("reportName", this.reportName)
/* 233 */       .append("reportNum", this.reportNum)
/* 234 */       .append("template", this.template)
/* 235 */       .append("actionName", this.actionName)
/* 236 */       .append("description", this.description);
/*     */ 
/* 238 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 242 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.model.original.ExcelReportDesignAbstract
 * JD-Core Version:    0.6.0
 */