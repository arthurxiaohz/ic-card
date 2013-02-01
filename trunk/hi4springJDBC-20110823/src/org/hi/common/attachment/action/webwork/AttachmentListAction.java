/*    */ package org.hi.common.attachment.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.attachment.action.AttachmentPageInfo;
/*    */ import org.hi.common.attachment.model.Attachment;
/*    */ import org.hi.common.attachment.service.AttachmentManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AttachmentListAction extends BaseAction
/*    */ {
/*    */   private Attachment attachment;
/*    */   private AttachmentPageInfo pageInfo;
/*    */   private List<Attachment> attachments;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 23 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 24 */     this.pageInfo = (this.pageInfo == null ? new AttachmentPageInfo() : this.pageInfo);
/* 25 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 27 */     this.attachments = attachmentMgr.getAttachmentList(sarchPageInfo);
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Attachment getAttachment() {
/* 33 */     return this.attachment;
/*    */   }
/*    */ 
/*    */   public void setAttachment(Attachment attachment) {
/* 37 */     this.attachment = attachment;
/*    */   }
/*    */ 
/*    */   public List<Attachment> getAttachments() {
/* 41 */     return this.attachments;
/*    */   }
/*    */ 
/*    */   public void setAttachments(List<Attachment> attachments) {
/* 45 */     this.attachments = attachments;
/*    */   }
/*    */ 
/*    */   public AttachmentPageInfo getPageInfo() {
/* 49 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(AttachmentPageInfo pageInfo) {
/* 53 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.action.webwork.AttachmentListAction
 * JD-Core Version:    0.6.0
 */