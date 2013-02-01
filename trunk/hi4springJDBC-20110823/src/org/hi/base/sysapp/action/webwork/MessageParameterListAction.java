/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.action.MessageParameterPageInfo;
/*    */ import org.hi.base.sysapp.model.MessageParameter;
/*    */ import org.hi.base.sysapp.service.MessageParameterManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageParameterListAction extends BaseAction
/*    */ {
/*    */   private MessageParameter messageParameter;
/*    */   private MessageParameterPageInfo pageInfo;
/*    */   private List<MessageParameter> messageParameters;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new MessageParameterPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.messageParameters = messageParameterMgr.getSecurityMessageParameterList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MessageParameter getMessageParameter() {
/* 30 */     return this.messageParameter;
/*    */   }
/*    */ 
/*    */   public void setMessageParameter(MessageParameter messageParameter) {
/* 34 */     this.messageParameter = messageParameter;
/*    */   }
/*    */ 
/*    */   public List<MessageParameter> getMessageParameters() {
/* 38 */     return this.messageParameters;
/*    */   }
/*    */ 
/*    */   public void setMessageParameters(List<MessageParameter> messageParameters) {
/* 42 */     this.messageParameters = messageParameters;
/*    */   }
/*    */ 
/*    */   public MessageParameterPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(MessageParameterPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageParameterListAction
 * JD-Core Version:    0.6.0
 */