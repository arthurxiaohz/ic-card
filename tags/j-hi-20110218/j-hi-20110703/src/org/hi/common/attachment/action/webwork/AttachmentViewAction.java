package org.hi.common.attachment.action.webwork;

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
import org.hi.framework.web.webwork.BaseAction;

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

	/* 根据Type的类型，type=1就获得附件的输入流并查看附件的内容，否则就得到下载附件的输入流
	 * @see com.opensymphony.xwork.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		attachment = attachmentMgr.getAttachmentById(attachment.getId());
		
		fileName = attachment.getFileName();
		fileName = new String(fileName.getBytes("gb2312"),"iso8859-1").toString();
		File file = null;
		if (attachment.getAttachmentType()==1)
		{
		    file = new File( this.getRequest().getRealPath("/")+ attachment.getAttachmentPath() );
			inputStream = new FileInputStream(file);
			return returnCommand();
		}
		else
		{
			 FtpUtil ftp = new FtpUtil();    
			    try {
			    	
			         //连接ftp服务器    
			         ftp.connectServer();    
			         /** 下载文件到file对象中 */    
			         OutputStream os =   ftp.download( attachment.getAttachmentPath(), file);    
			          inputStream = new ByteArrayInputStream(((ByteArrayOutputStream)os).toByteArray());
			        
			         
			    } catch (IOException e) {    
			       throw e;
			    }finally    
			    {    
			       ftp.closeServer();    
			    }   
		}		 
		
		fileName =  attachment.getFileName();
		
		return DOWNLOAD;
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	 
}
