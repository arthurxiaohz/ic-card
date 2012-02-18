package org.hi.common.attachment.action.struts;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.hi.SpringContextHolder;
import org.hi.common.attachment.action.cust.FtpUtil;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;
import org.hi.framework.web.struts.BaseAction;

public class AttachmentViewAction extends BaseAction{
	private Attachment attachment;
	private String fileName="";
	private InputStream inputStream;
	private String downloadFile = "";
	private String contentType="application/octet-stream;charset=gb2312";
 

	public String getContentType() {
		return contentType;
	}

	public String getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/* 查看上传的附件
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		attachment = attachmentMgr.getAttachmentById(attachment.getId());
		
		fileName = attachment.getFileName();
		
		File file = null;
		if (attachment.getAttachmentType()==1)
		{
		    file = new File( this.getRequest().getRealPath("/")+ attachment.getAttachmentPath() );
			inputStream = new FileInputStream(file);
		}
		else
		{
			inputStream =  FtpUtil.getFtpDownloadClient().download( attachment.getAttachmentPath()); 
		}		 
		
		fileName =  new String(attachment.getFileName().getBytes("GBK"),"iso8859-1");
		
		
		return DOWNLOAD;
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	 
}
