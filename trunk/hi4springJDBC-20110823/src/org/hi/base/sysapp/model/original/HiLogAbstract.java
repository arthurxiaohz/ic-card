/*     */ package org.hi.base.sysapp.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.sysapp.model.HiLog;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class HiLogAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected HiUser operator;
/*     */   protected Timestamp operateDate;
/*     */   protected String action;
/*     */   protected String actionContext;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  51 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  55 */     if (((id != null) && (this.id == null)) || (
/*  56 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  57 */       setDirty(true);
/*  58 */       this.oldValues.put("id", this.id);
/*     */     }
/*  60 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  64 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  68 */     if (((version != null) && (this.version == null)) || (
/*  69 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  70 */       setDirty(true);
/*  71 */       this.oldValues.put("version", this.version);
/*     */     }
/*  73 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public HiUser getOperator() {
/*  77 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(HiUser operator) {
/*  81 */     if (((operator != null) && (this.operator == null)) || (
/*  82 */       (this.operator != null) && ((!this.operator.equals(operator)) || (operator == null)))) {
/*  83 */       setDirty(true);
/*  84 */       this.oldValues.put("operator", this.operator);
/*     */     }
/*  86 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Timestamp getOperateDate() {
/*  90 */     return this.operateDate;
/*     */   }
/*     */ 
/*     */   public void setOperateDate(Timestamp operateDate) {
/*  94 */     if (((operateDate != null) && (this.operateDate == null)) || (
/*  95 */       (this.operateDate != null) && ((!this.operateDate.equals(operateDate)) || (operateDate == null)))) {
/*  96 */       setDirty(true);
/*  97 */       this.oldValues.put("operateDate", this.operateDate);
/*     */     }
/*  99 */     this.operateDate = operateDate;
/*     */   }
/*     */ 
/*     */   public String getAction() {
/* 103 */     return this.action;
/*     */   }
/*     */ 
/*     */   public void setAction(String action) {
/* 107 */     if (((action != null) && (this.action == null)) || (
/* 108 */       (this.action != null) && ((!this.action.equals(action)) || (action == null)))) {
/* 109 */       setDirty(true);
/* 110 */       this.oldValues.put("action", this.action);
/*     */     }
/* 112 */     this.action = action;
/*     */   }
/*     */ 
/*     */   public String getActionContext() {
/* 116 */     return this.actionContext;
/*     */   }
/*     */ 
/*     */   public void setActionContext(String actionContext) {
/* 120 */     if (((actionContext != null) && (this.actionContext == null)) || (
/* 121 */       (this.actionContext != null) && ((!this.actionContext.equals(actionContext)) || (actionContext == null)))) {
/* 122 */       setDirty(true);
/* 123 */       this.oldValues.put("actionContext", this.actionContext);
/*     */     }
/* 125 */     this.actionContext = actionContext;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 131 */     if (this == other) return true;
/* 132 */     if (other == null) return false;
/* 133 */     if (!(other instanceof HiLog)) return false;
/* 134 */     HiLog castOther = (HiLog)other;
/*     */ 
/* 136 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 140 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 141 */     hcb.append(getId());
/* 142 */     hcb.append("HiLog".hashCode());
/* 143 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 147 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 148 */     sb.append("id", this.id)
/* 149 */       .append("action", this.action)
/* 150 */       .append("actionContext", this.actionContext);
/*     */ 
/* 152 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 156 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.model.original.HiLogAbstract
 * JD-Core Version:    0.6.0
 */