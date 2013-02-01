/*     */ package org.hi.base.sysapp.action;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import org.hi.base.organization.action.HiUserPageInfo;
/*     */ import org.hi.framework.web.PageInfoView;
/*     */ 
/*     */ public class MessagePageInfo extends PageInfoView
/*     */ {
/*     */   protected Integer f_id;
/*     */   protected String f_id_op;
/*     */   protected String f_receivers;
/*     */   protected String f_receivers_op;
/*     */   protected String f_receiverNames;
/*     */   protected String f_receiverNames_op;
/*     */   protected String f_sender;
/*     */   protected String f_sender_op;
/*     */   protected Integer f_messageType;
/*     */   protected String f_messageType_op;
/*     */   protected String f_messageText;
/*     */   protected String f_messageText_op;
/*     */   protected Timestamp f_createDate;
/*     */   protected String f_createDate_op;
/*     */   protected Timestamp f_createDate01;
/*     */   protected String f_createDate01_op;
/*     */   protected Timestamp f_sendDate;
/*     */   protected String f_sendDate_op;
/*     */   protected Timestamp f_sendDate01;
/*     */   protected String f_sendDate01_op;
/*     */   protected Integer f_isSent;
/*     */   protected String f_isSent_op;
/*     */   protected String f_description;
/*     */   protected String f_description_op;
/*     */   protected HiUserPageInfo creator;
/*     */ 
/*     */   public Integer getF_id()
/*     */   {
/*  39 */     return this.f_id;
/*     */   }
/*     */ 
/*     */   public void setF_id(Integer f_id) {
/*  43 */     this.f_id = f_id;
/*     */   }
/*     */ 
/*     */   public String getF_id_op() {
/*  47 */     return this.f_id_op;
/*     */   }
/*     */ 
/*     */   public void setF_id_op(String f_id_op) {
/*  51 */     this.f_id_op = f_id_op;
/*     */   }
/*     */ 
/*     */   public String getF_receivers() {
/*  55 */     return this.f_receivers;
/*     */   }
/*     */ 
/*     */   public void setF_receivers(String f_receivers) {
/*  59 */     this.f_receivers = f_receivers;
/*     */   }
/*     */ 
/*     */   public String getF_receivers_op() {
/*  63 */     return this.f_receivers_op;
/*     */   }
/*     */ 
/*     */   public void setF_receivers_op(String f_receivers_op) {
/*  67 */     this.f_receivers_op = f_receivers_op;
/*     */   }
/*     */ 
/*     */   public String getF_receiverNames() {
/*  71 */     return this.f_receiverNames;
/*     */   }
/*     */ 
/*     */   public void setF_receiverNames(String f_receiverNames) {
/*  75 */     this.f_receiverNames = f_receiverNames;
/*     */   }
/*     */ 
/*     */   public String getF_receiverNames_op() {
/*  79 */     return this.f_receiverNames_op;
/*     */   }
/*     */ 
/*     */   public void setF_receiverNames_op(String f_receiverNames_op) {
/*  83 */     this.f_receiverNames_op = f_receiverNames_op;
/*     */   }
/*     */ 
/*     */   public String getF_sender() {
/*  87 */     return this.f_sender;
/*     */   }
/*     */ 
/*     */   public void setF_sender(String f_sender) {
/*  91 */     this.f_sender = f_sender;
/*     */   }
/*     */ 
/*     */   public String getF_sender_op() {
/*  95 */     return this.f_sender_op;
/*     */   }
/*     */ 
/*     */   public void setF_sender_op(String f_sender_op) {
/*  99 */     this.f_sender_op = f_sender_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_messageType() {
/* 103 */     return this.f_messageType;
/*     */   }
/*     */ 
/*     */   public void setF_messageType(Integer f_messageType) {
/* 107 */     this.f_messageType = f_messageType;
/*     */   }
/*     */ 
/*     */   public String getF_messageType_op() {
/* 111 */     return this.f_messageType_op;
/*     */   }
/*     */ 
/*     */   public void setF_messageType_op(String f_messageType_op) {
/* 115 */     this.f_messageType_op = f_messageType_op;
/*     */   }
/*     */ 
/*     */   public String getF_messageText() {
/* 119 */     return this.f_messageText;
/*     */   }
/*     */ 
/*     */   public void setF_messageText(String f_messageText) {
/* 123 */     this.f_messageText = f_messageText;
/*     */   }
/*     */ 
/*     */   public String getF_messageText_op() {
/* 127 */     return this.f_messageText_op;
/*     */   }
/*     */ 
/*     */   public void setF_messageText_op(String f_messageText_op) {
/* 131 */     this.f_messageText_op = f_messageText_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_createDate() {
/* 135 */     return this.f_createDate;
/*     */   }
/*     */ 
/*     */   public void setF_createDate(Timestamp f_createDate) {
/* 139 */     this.f_createDate = f_createDate;
/*     */   }
/*     */ 
/*     */   public String getF_createDate_op() {
/* 143 */     return this.f_createDate_op;
/*     */   }
/*     */ 
/*     */   public void setF_createDate_op(String f_createDate_op) {
/* 147 */     this.f_createDate_op = f_createDate_op;
/*     */   }
/*     */   public Timestamp getF_createDate01() {
/* 150 */     return this.f_createDate01;
/*     */   }
/*     */ 
/*     */   public void setF_createDate01(Timestamp f_createDate01) {
/* 154 */     this.f_createDate01 = f_createDate01;
/*     */   }
/*     */ 
/*     */   public String getF_createDate01_op() {
/* 158 */     return this.f_createDate01_op;
/*     */   }
/*     */ 
/*     */   public void setF_createDate01_op(String f_createDate01_op) {
/* 162 */     this.f_createDate01_op = f_createDate01_op;
/*     */   }
/*     */ 
/*     */   public Timestamp getF_sendDate() {
/* 166 */     return this.f_sendDate;
/*     */   }
/*     */ 
/*     */   public void setF_sendDate(Timestamp f_sendDate) {
/* 170 */     this.f_sendDate = f_sendDate;
/*     */   }
/*     */ 
/*     */   public String getF_sendDate_op() {
/* 174 */     return this.f_sendDate_op;
/*     */   }
/*     */ 
/*     */   public void setF_sendDate_op(String f_sendDate_op) {
/* 178 */     this.f_sendDate_op = f_sendDate_op;
/*     */   }
/*     */   public Timestamp getF_sendDate01() {
/* 181 */     return this.f_sendDate01;
/*     */   }
/*     */ 
/*     */   public void setF_sendDate01(Timestamp f_sendDate01) {
/* 185 */     this.f_sendDate01 = f_sendDate01;
/*     */   }
/*     */ 
/*     */   public String getF_sendDate01_op() {
/* 189 */     return this.f_sendDate01_op;
/*     */   }
/*     */ 
/*     */   public void setF_sendDate01_op(String f_sendDate01_op) {
/* 193 */     this.f_sendDate01_op = f_sendDate01_op;
/*     */   }
/*     */ 
/*     */   public Integer getF_isSent() {
/* 197 */     return this.f_isSent;
/*     */   }
/*     */ 
/*     */   public void setF_isSent(Integer f_isSent) {
/* 201 */     this.f_isSent = f_isSent;
/*     */   }
/*     */ 
/*     */   public String getF_isSent_op() {
/* 205 */     return this.f_isSent_op;
/*     */   }
/*     */ 
/*     */   public void setF_isSent_op(String f_isSent_op) {
/* 209 */     this.f_isSent_op = f_isSent_op;
/*     */   }
/*     */ 
/*     */   public String getF_description() {
/* 213 */     return this.f_description;
/*     */   }
/*     */ 
/*     */   public void setF_description(String f_description) {
/* 217 */     this.f_description = f_description;
/*     */   }
/*     */ 
/*     */   public String getF_description_op() {
/* 221 */     return this.f_description_op;
/*     */   }
/*     */ 
/*     */   public void setF_description_op(String f_description_op) {
/* 225 */     this.f_description_op = f_description_op;
/*     */   }
/*     */ 
/*     */   public HiUserPageInfo getCreator() {
/* 229 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUserPageInfo creator) {
/* 233 */     this.creator = creator;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.MessagePageInfo
 * JD-Core Version:    0.6.0
 */