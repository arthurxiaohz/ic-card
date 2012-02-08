package org.hi.common.attachment.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;

public class AttachmentRemoveAction extends BaseAction{
	private Attachment attachment;
	
	/* 删除指定的附件表记录
	 * @see com.opensymphony.xwork.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		attachmentMgr.removeAttachmentById(attachment.getId());
		return returnCommand();
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
}
