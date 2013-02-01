/*     */ package org.hi.base.sysapp.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.sysapp.model.Message;
/*     */ import org.hi.base.sysapp.model.MessageParameter;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class MessageParameterAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String parameterKey;
/*     */   protected String parameterValue;
/*     */   protected Message message;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  46 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  50 */     if (((id != null) && (this.id == null)) || (
/*  51 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  52 */       setDirty(true);
/*  53 */       this.oldValues.put("id", this.id);
/*     */     }
/*  55 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/*  59 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/*  63 */     if (((version != null) && (this.version == null)) || (
/*  64 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/*  65 */       setDirty(true);
/*  66 */       this.oldValues.put("version", this.version);
/*     */     }
/*  68 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getParameterKey() {
/*  72 */     return this.parameterKey;
/*     */   }
/*     */ 
/*     */   public void setParameterKey(String parameterKey) {
/*  76 */     if (((parameterKey != null) && (this.parameterKey == null)) || (
/*  77 */       (this.parameterKey != null) && ((!this.parameterKey.equals(parameterKey)) || (parameterKey == null)))) {
/*  78 */       setDirty(true);
/*  79 */       this.oldValues.put("parameterKey", this.parameterKey);
/*     */     }
/*  81 */     this.parameterKey = parameterKey;
/*     */   }
/*     */ 
/*     */   public String getParameterValue() {
/*  85 */     return this.parameterValue;
/*     */   }
/*     */ 
/*     */   public void setParameterValue(String parameterValue) {
/*  89 */     if (((parameterValue != null) && (this.parameterValue == null)) || (
/*  90 */       (this.parameterValue != null) && ((!this.parameterValue.equals(parameterValue)) || (parameterValue == null)))) {
/*  91 */       setDirty(true);
/*  92 */       this.oldValues.put("parameterValue", this.parameterValue);
/*     */     }
/*  94 */     this.parameterValue = parameterValue;
/*     */   }
/*     */ 
/*     */   public Message getMessage() {
/*  98 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(Message message) {
/* 102 */     if (((message != null) && (this.message == null)) || (
/* 103 */       (this.message != null) && ((!this.message.equals(message)) || (message == null)))) {
/* 104 */       setDirty(true);
/* 105 */       this.oldValues.put("message", this.message);
/*     */     }
/* 107 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity() {
/* 111 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent) {
/* 115 */     this.message = ((Message)parent);
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 121 */     if (this == other) return true;
/* 122 */     if (other == null) return false;
/* 123 */     if (!(other instanceof MessageParameter)) return false;
/* 124 */     MessageParameter castOther = (MessageParameter)other;
/*     */ 
/* 126 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 130 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 131 */     hcb.append(getId());
/* 132 */     hcb.append("MessageParameter".hashCode());
/* 133 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 137 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 138 */     sb.append("id", this.id)
/* 139 */       .append("parameterKey", this.parameterKey)
/* 140 */       .append("parameterValue", this.parameterValue);
/*     */ 
/* 142 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 146 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.model.original.MessageParameterAbstract
 * JD-Core Version:    0.6.0
 */