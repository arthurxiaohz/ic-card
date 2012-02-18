package org.hi.common.attachment.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.common.attachment.action.AttachmentPageInfo;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;

public class AttachmentListAction extends BaseAction{
	private Attachment attachment;
	private AttachmentPageInfo pageInfo;
	private List<Attachment> attachments;
	
	/* 查看附件列表
	 * @see com.opensymphony.xwork.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		pageInfo = pageInfo == null ? new AttachmentPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		attachments = attachmentMgr.getAttachmentList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public AttachmentPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(AttachmentPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
