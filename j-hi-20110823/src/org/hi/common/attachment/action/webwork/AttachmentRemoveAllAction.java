package org.hi.common.attachment.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;

public class AttachmentRemoveAllAction extends BaseAction{
	private Attachment attachment;
	private String orderIndexs;
	
	/* 删除指定的某些附件记录
	 * @see com.opensymphony.xwork.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer attachmentid = new Integer( ids[i] );
				attachmentMgr.removeAttachmentById(attachmentid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
