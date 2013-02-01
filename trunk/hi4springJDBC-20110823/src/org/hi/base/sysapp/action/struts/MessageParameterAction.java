/*     */ package org.hi.base.sysapp.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.sysapp.action.MessageParameterPageInfo;
/*     */ import org.hi.base.sysapp.model.MessageParameter;
/*     */ import org.hi.base.sysapp.service.MessageParameterManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class MessageParameterAction extends BaseAction
/*     */ {
/*     */   private MessageParameter messageParameter;
/*     */   private MessageParameterPageInfo pageInfo;
/*     */   private List<MessageParameter> messageParameters;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveMessageParameter()
/*     */     throws Exception
/*     */   {
/*  25 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/*  26 */     if (super.perExecute(this.messageParameter) != null) return returnCommand();
/*  27 */     messageParameterMgr.saveMessageParameter(this.messageParameter);
/*  28 */     super.postExecute(this.messageParameter);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeMessageParameter()
/*     */     throws Exception
/*     */   {
/*  37 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/*  38 */     messageParameterMgr.removeMessageParameterById(this.messageParameter.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllMessageParameter()
/*     */     throws Exception
/*     */   {
/*  46 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer messageParameterid = new Integer(ids[i]);
/*  55 */         messageParameterMgr.removeMessageParameterById(messageParameterid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewMessageParameter()
/*     */     throws Exception
/*     */   {
/*  67 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/*  68 */     this.messageParameter = messageParameterMgr.getMessageParameterById(this.messageParameter.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String messageParameterList()
/*     */     throws Exception
/*     */   {
/*  76 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new MessageParameterPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.messageParameters = messageParameterMgr.getSecurityMessageParameterList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public MessageParameter getMessageParameter()
/*     */   {
/*  89 */     return this.messageParameter;
/*     */   }
/*     */ 
/*     */   public void setMessageParameter(MessageParameter messageParameter) {
/*  93 */     this.messageParameter = messageParameter;
/*     */   }
/*     */ 
/*     */   public List<MessageParameter> getMessageParameters() {
/*  97 */     return this.messageParameters;
/*     */   }
/*     */ 
/*     */   public void setMessageParameters(List<MessageParameter> messageParameters) {
/* 101 */     this.messageParameters = messageParameters;
/*     */   }
/*     */ 
/*     */   public MessageParameterPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(MessageParameterPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.struts.MessageParameterAction
 * JD-Core Version:    0.6.0
 */