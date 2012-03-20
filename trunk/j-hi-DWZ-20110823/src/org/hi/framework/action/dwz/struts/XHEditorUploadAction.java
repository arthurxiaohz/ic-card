package org.hi.framework.action.dwz.struts;

import java.io.File;

import org.hi.SpringContextHolder;
import org.hi.common.attachment.action.cust.FtpUtil;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;
import org.hi.common.util.JSONObject;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class XHEditorUploadAction extends BaseAction{
	 private File filedata;
	 private String filedataContentType;
	 private String filedataFileName;
	 private String json;
	    /**
	     * 设置上传文件的大小
	     */
	    private   String maxSize= HiConfigHolder.getProperty("hi.upload.ftp.maxSize") == null ? "100" : HiConfigHolder.getProperty("hi.upload.ftp.maxSize");

	public String execute() throws Exception {
		AttachmentManager attachmentMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		FtpUtil ftpUtil =  new FtpUtil();
		if (filedata != null) {
			if (filedata.length()/1024d/1024d > new Double(maxSize)){
				JSONObject jsonObject = new JSONObject("err", I18NUtil.getStringByParameter("上传文件过大", "Attachment", maxSize));
				jsonObject.addJSONObject("msg", "");
				json = jsonObject.toString();
				return "json";
			}
			
			Attachment attachment = new Attachment();
			String filedataPath = "";
		   
			filedataPath =  ftpUtil.saveFile(filedata, filedataFileName,"xhEditor");
			
			attachment.setAttachmentPath(filedataPath);
			attachment.setFileSize( filedata.length()/1024d ); 
			attachment.setFileType(filedataContentType);
			attachment.setFileName(filedataFileName);
			attachmentMgr.saveObject(attachment);
			
			JSONObject jsonObject = new JSONObject("err", "");
			jsonObject.addJSONObject("msg", filedataPath);
			json = jsonObject.toString();
			return "json";
			
		}
		JSONObject jsonObject = new JSONObject("err", I18NUtil.getString("文件件为空"));
		jsonObject.addJSONObject("msg", "");
		json = jsonObject.toString();
		return "json";
	}

	public File getFiledata() {
		return filedata;
	}

	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}

	public String getFiledataContentType() {
		return filedataContentType;
	}

	public void setFiledataContentType(String filedataContentType) {
		this.filedataContentType = filedataContentType;
	}

	public String getFiledataFileName() {
		return filedataFileName;
	}

	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
}
