/*     */ package org.hi.base.sysapp.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.sysapp.model.Message;
/*     */ import org.hi.base.sysapp.model.MessageParameter;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public abstract class MessageAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String receivers;
/*     */   protected String receiverNames;
/*     */   protected String sender;
/*     */   protected Integer messageType;
/*     */   protected String messageText;
/*     */   protected Timestamp createDate;
/*     */   protected Timestamp sendDate;
/*     */   protected Integer isSent;
/*     */   protected String description;
/*  82 */   protected HiUser creator = UserContextHelper.getUser();
/*     */   private List<MessageParameter> messageParameters;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  88 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  92 */     if (((id != null) && (this.id == null)) || (
/*  93 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/*  94 */       setDirty(true);
/*  95 */       this.oldValues.put("id", this.id);
/*     */     }
/*  97 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/* 101 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/* 105 */     if (((version != null) && (this.version == null)) || (
/* 106 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/* 107 */       setDirty(true);
/* 108 */       this.oldValues.put("version", this.version);
/*     */     }
/* 110 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getReceivers() {
/* 114 */     return this.receivers;
/*     */   }
/*     */ 
/*     */   public void setReceivers(String receivers) {
/* 118 */     if (((receivers != null) && (this.receivers == null)) || (
/* 119 */       (this.receivers != null) && ((!this.receivers.equals(receivers)) || (receivers == null)))) {
/* 120 */       setDirty(true);
/* 121 */       this.oldValues.put("receivers", this.receivers);
/*     */     }
/* 123 */     this.receivers = receivers;
/*     */   }
/*     */ 
/*     */   public String getReceiverNames() {
/* 127 */     return this.receiverNames;
/*     */   }
/*     */ 
/*     */   public void setReceiverNames(String receiverNames) {
/* 131 */     if (((receiverNames != null) && (this.receiverNames == null)) || (
/* 132 */       (this.receiverNames != null) && ((!this.receiverNames.equals(receiverNames)) || (receiverNames == null)))) {
/* 133 */       setDirty(true);
/* 134 */       this.oldValues.put("receiverNames", this.receiverNames);
/*     */     }
/* 136 */     this.receiverNames = receiverNames;
/*     */   }
/*     */ 
/*     */   public String getSender() {
/* 140 */     return this.sender;
/*     */   }
/*     */ 
/*     */   public void setSender(String sender) {
/* 144 */     if (((sender != null) && (this.sender == null)) || (
/* 145 */       (this.sender != null) && ((!this.sender.equals(sender)) || (sender == null)))) {
/* 146 */       setDirty(true);
/* 147 */       this.oldValues.put("sender", this.sender);
/*     */     }
/* 149 */     this.sender = sender;
/*     */   }
/*     */ 
/*     */   public Integer getMessageType() {
/* 153 */     return this.messageType;
/*     */   }
/*     */ 
/*     */   public void setMessageType(Integer messageType) {
/* 157 */     if (((messageType != null) && (this.messageType == null)) || (
/* 158 */       (this.messageType != null) && ((!this.messageType.equals(messageType)) || (messageType == null)))) {
/* 159 */       setDirty(true);
/* 160 */       this.oldValues.put("messageType", this.messageType);
/*     */     }
/* 162 */     this.messageType = messageType;
/*     */   }
/*     */ 
/*     */   public String getMessageText() {
/* 166 */     return this.messageText;
/*     */   }
/*     */ 
/*     */   public void setMessageText(String messageText) {
/* 170 */     if (((messageText != null) && (this.messageText == null)) || (
/* 171 */       (this.messageText != null) && ((!this.messageText.equals(messageText)) || (messageText == null)))) {
/* 172 */       setDirty(true);
/* 173 */       this.oldValues.put("messageText", this.messageText);
/*     */     }
/* 175 */     this.messageText = messageText;
/*     */   }
/*     */ 
/*     */   public Timestamp getCreateDate() {
/* 179 */     return this.createDate;
/*     */   }
/*     */ 
/*     */   public void setCreateDate(Timestamp createDate) {
/* 183 */     if (((createDate != null) && (this.createDate == null)) || (
/* 184 */       (this.createDate != null) && ((!this.createDate.equals(createDate)) || (createDate == null)))) {
/* 185 */       setDirty(true);
/* 186 */       this.oldValues.put("createDate", this.createDate);
/*     */     }
/* 188 */     this.createDate = createDate;
/*     */   }
/*     */ 
/*     */   public Timestamp getSendDate() {
/* 192 */     return this.sendDate;
/*     */   }
/*     */ 
/*     */   public void setSendDate(Timestamp sendDate) {
/* 196 */     if (((sendDate != null) && (this.sendDate == null)) || (
/* 197 */       (this.sendDate != null) && ((!this.sendDate.equals(sendDate)) || (sendDate == null)))) {
/* 198 */       setDirty(true);
/* 199 */       this.oldValues.put("sendDate", this.sendDate);
/*     */     }
/* 201 */     this.sendDate = sendDate;
/*     */   }
/*     */ 
/*     */   public Integer getIsSent() {
/* 205 */     return this.isSent;
/*     */   }
/*     */ 
/*     */   public void setIsSent(Integer isSent) {
/* 209 */     if (((isSent != null) && (this.isSent == null)) || (
/* 210 */       (this.isSent != null) && ((!this.isSent.equals(isSent)) || (isSent == null)))) {
/* 211 */       setDirty(true);
/* 212 */       this.oldValues.put("isSent", this.isSent);
/*     */     }
/* 214 */     this.isSent = isSent;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 218 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 222 */     if (((description != null) && (this.description == null)) || (
/* 223 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 224 */       setDirty(true);
/* 225 */       this.oldValues.put("description", this.description);
/*     */     }
/* 227 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 231 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 235 */     if (((creator != null) && (this.creator == null)) || (
/* 236 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 237 */       setDirty(true);
/* 238 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 240 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public void setMessageParameters(List<MessageParameter> messageParameters)
/*     */   {
/* 245 */     this.messageParameters = messageParameters;
/*     */   }
/*     */ 
/*     */   public List<MessageParameter> getMessageParameters() {
/* 249 */     return this.messageParameters;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other) {
/* 253 */     if (this == other) return true;
/* 254 */     if (other == null) return false;
/* 255 */     if (!(other instanceof Message)) return false;
/* 256 */     Message castOther = (Message)other;
/*     */ 
/* 258 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 262 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 263 */     hcb.append(getId());
/* 264 */     hcb.append("Message".hashCode());
/* 265 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 269 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 270 */     sb.append("id", this.id)
/* 271 */       .append("receivers", this.receivers)
/* 272 */       .append("receiverNames", this.receiverNames)
/* 273 */       .append("sender", this.sender)
/* 274 */       .append("messageText", this.messageText)
/* 275 */       .append("description", this.description);
/*     */ 
/* 277 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 281 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.model.original.MessageAbstract
 * JD-Core Version:    0.6.0
 */