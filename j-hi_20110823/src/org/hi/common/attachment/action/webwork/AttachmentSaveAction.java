package org.hi.common.attachment.action.webwork;

import java.io.File;

import org.hi.SpringContextHolder;
import org.hi.common.attachment.action.cust.FtpUtil;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class AttachmentSaveAction extends BaseAction implements SynchronizationData{
	private Attachment attachment;
	
	private File image;
    private String imageFileName;
    private String imageContentType;
    
    private   String maxSize= HiConfigHolder.getProperty("hi.upload.ftp.maxSize") == null ? "100" : HiConfigHolder.getProperty("hi.upload.ftp.maxSize");
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/* 新增/修改保存附件表
	 * @see com.opensymphony.xwork.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		FtpUtil ftpUtil =  new FtpUtil();
		if(super.perExecute(attachment)!= null) return returnCommand();
		
		if (image != null) {
			if (image.length()/1024d/1024d > new Double(maxSize))
				throw new BusinessException(I18NUtil.getStringByParameter("上传文件过大", "Attachment", maxSize));
			
			String imagePath = "";
			if (attachment.getAttachmentType() == 2)
				imagePath = FtpUtil.getFtpUploadClient().saveFileToFTP(image, imageFileName,attachment.getAttachDesc());
			else
				imagePath =   FtpUtil.getOSFileClient().saveFile(image, imageFileName,attachment.getAttachDesc());
			
			attachment.setAttachmentPath(imagePath);
			attachment.setFileSize( image.length()/1024d ); 
			attachment.setFileType(imageContentType);
			attachment.setFileName(imageFileName);
			attachmentMgr.saveObject(attachment);
		}
		
	
		super.postExecute(attachment);
		return returnCommand();
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

}
