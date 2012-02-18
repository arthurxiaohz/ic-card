package org.hi.common.attachment.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hi.common.attachment.action.cust.FtpUtil;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.impl.ManagerImpl;

public class AttachmentManagerImpl extends ManagerImpl implements AttachmentManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveAttachment(Attachment attachment){
    	saveObject(attachment);
    
    }

    public void removeAttachmentById(Integer id){
    	removeObjectById(id);
    	
    }

    public Attachment getAttachmentById(Integer id){
   		return (Attachment) getObjectById(id);
    }

    public List<Attachment> getAttachmentList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    
    public  Attachment uploadFile(File file,int saveType,String fileName,String forder) throws IOException {
    	return uploadFile( file, saveType, fileName, forder,  null);
    }
    
	/* 上传附件并生成一个attachment对象，如果saveType为1保存到服务器上，2保存到ftp上。
	 * 如果forder为null或则""就保存到attachment目录下。
	 * @see org.hi.common.attachment.service.AttachmentManager#uploadFile(java.io.File, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Attachment uploadFile(File file,int saveType,String fileName,String forder, String contextPath) throws IOException {
		String filePath="";
		if (forder == null || forder.equals(""))
			forder = "attachment";
		Attachment attachment =  new Attachment();
		if (saveType == 2)
			attachment.setAttachmentType(2);
		else
			attachment.setAttachmentType(1);
		
		  
		
		if (attachment.getAttachmentType() == 1)
			filePath =  FtpUtil.getOSFileClient().saveFile(file, fileName,forder,contextPath);
		else
			filePath = FtpUtil.getFtpUploadClient().saveFileToFTP(file, fileName ,forder);
		
		attachment.setAttachmentPath(filePath);
		attachment.setFileSize( file.length()/1024d ); 
		attachment.setFileType( "");
		attachment.setFileName(file.getName());
		this.saveObject(attachment);
		
	  return attachment;
		
	}
	
	
	public  Attachment uploadFile(InputStream inputStream,int saveType,String fileName,String forder) throws IOException {
    	return uploadFile( inputStream, saveType, fileName, forder,  null);
    }
    
    public Attachment uploadFile(InputStream inputStream,int saveType,String fileName,String forder, String contextPath) throws IOException {
		String path="";
		int size = inputStream.available();
		if (forder == null || forder.equals(""))
			forder = "attachment";
		Attachment attachment =  new Attachment();
		if (saveType == 2)
			attachment.setAttachmentType(2);
		else
			attachment.setAttachmentType(1);
		
		
		if (attachment.getAttachmentType() == 1)
			path =  FtpUtil.getOSFileClient().saveInputStream(inputStream, fileName,forder,contextPath);
		else
			path = FtpUtil.getFtpUploadClient().saveInputStreamToFTP(inputStream, fileName ,forder);
		
		attachment.setAttachmentPath( path);
		attachment.setFileSize( size/1024d ); 
		attachment.setFileType( "");
		attachment.setFileName(fileName);
		this.saveObject(attachment);
		
	  return attachment;
		
	}
    
}
