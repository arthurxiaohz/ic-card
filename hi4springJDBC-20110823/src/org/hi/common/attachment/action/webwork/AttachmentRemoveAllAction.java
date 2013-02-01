/*    */ package org.hi.common.attachment.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.attachment.model.Attachment;
/*    */ import org.hi.common.attachment.service.AttachmentManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AttachmentRemoveAllAction extends BaseAction
/*    */ {
/*    */   private Attachment attachment;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 17 */     AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
/*    */ 
/* 19 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 21 */       String[] ids = this.orderIndexs.split(",");
/* 22 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 24 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 26 */         Integer attachmentid = new Integer(ids[i]);
/* 27 */         attachmentMgr.removeAttachmentById(attachmentid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 32 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Attachment getAttachment() {
/* 36 */     return this.attachment;
/*    */   }
/*    */ 
/*    */   public void setAttachment(Attachment attachment) {
/* 40 */     this.attachment = attachment;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 44 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 48 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.action.webwork.AttachmentRemoveAllAction
 * JD-Core Version:    0.6.0
 */