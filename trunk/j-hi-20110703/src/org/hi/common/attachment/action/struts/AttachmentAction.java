package org.hi.common.attachment.action.struts;

import java.io.File;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

import org.hi.common.attachment.action.AttachmentPageInfo;
import org.hi.common.attachment.action.cust.FtpUtil;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;

public class AttachmentAction extends BaseAction{
	
	private Attachment attachment;
	private AttachmentPageInfo pageInfo;
	private List<Attachment> attachments;
	private String orderIndexs;
	
	private File image;
    private String imageFileName;
    /**
     * 上传文件的文件类型
     */
    private String imageContentType;
    
    /**
     * 设置上传文件的大小
     */
    private   String maxSize= HiConfigHolder.getProperty("hi.upload.ftp.maxSize") == null ? "100" : HiConfigHolder.getProperty("hi.upload.ftp.maxSize");
	/**
	 * 新增/修改保存附件
	 */
	public String saveAttachment() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		FtpUtil ftpUtil =  new FtpUtil();
		if(super.perExecute(attachment)!= null) return returnCommand();
		
		if (image != null) {
			if (image.length()/1024d/1024d > new Double(maxSize))
				throw new BusinessException(I18NUtil.getStringByParameter("上传文件过大", "Attachment", maxSize));
			
			String imagePath = "";
			if (attachment.getAttachmentType() == 2)
				imagePath = ftpUtil.saveFileToFTP(image, imageFileName,attachment.getAttachDesc());
			else
				imagePath =  ftpUtil.saveFile(image, imageFileName,attachment.getAttachDesc());
			
			attachment.setAttachmentPath(imagePath);
			attachment.setFileSize( image.length()/1024d ); 
			attachment.setFileType(imageContentType);
			attachment.setFileName(imageFileName);
			attachmentMgr.saveObject(attachment);
		}
		
	
		super.postExecute(attachment);
		return returnCommand();
	}
	
	
	/**
	 * 删除附件
	 */
	public String removeAttachment() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		attachmentMgr.removeAttachmentById(attachment.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些附件
	 */
	public String removeAllAttachment() throws Exception {
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
	
	/**
	 *查看附件
	 */
	public String viewAttachment() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		attachment = attachmentMgr.getAttachmentById(attachment.getId());
		return returnCommand();
	}
	
	/**
	 * 附件列表
	 */
	public String attachmentList() throws Exception {
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}


	public File getImage() {
		return image;
	}


	public void setImage(File image) {
		this.image = image;
	}


	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}


	public String getImageContentType() {
		return imageContentType;
	}


	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	public String getMaxSize() {
		return maxSize;
	}


	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}
	
	
	
}
