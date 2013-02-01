/*    */ package org.hi.common.attachment.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.attachment.model.Attachment;
/*    */ import org.hi.common.attachment.service.AttachmentManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AttachmentRemoveAction extends BaseAction
/*    */ {
/*    */   private Attachment attachment;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 16 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/* 17 */     attachmentMgr.removeAttachmentById(this.attachment.getId());
/* 18 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Attachment getAttachment() {
/* 22 */     return this.attachment;
/*    */   }
/*    */ 
/*    */   public void setAttachment(Attachment attachment) {
/* 26 */     this.attachment = attachment;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.attachment.action.webwork.AttachmentRemoveAction
 * JD-Core Version:    0.6.0
 */