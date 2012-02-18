package org.hi.common.attachment.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.common.attachment.model.Attachment;

public abstract class AttachmentAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 文件名
	 */	
 	protected  String fileName;

 	 /**
	 * 文件类型
	 */	
 	protected  String fileType;

 	 /**
	 * 文件大小(
	 */	
 	protected  Double fileSize;

 	 /**
	 * oneservertwoftp
	 */	
 	protected  Integer attachmentType = 1;

 	 /**
	 * 附件
	 */	
 	protected  String attachmentPath;

 	 /**
	 * 所属组件
	 */	
 	protected  String attachDesc;


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
    		if((id != null && this.id == null) || 
				this.id != null && (!this.id.equals(id) || id == null)){
        		this.setDirty(true);
        		this.oldValues.put("id", this.id);
        	}
        this.id = id;
    }
    
     public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
    		if((version != null && this.version == null) || 
				this.version != null && (!this.version.equals(version) || version == null)){
        		this.setDirty(true);
        		this.oldValues.put("version", this.version);
        	}
        this.version = version;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
    		if((fileName != null && this.fileName == null) || 
				this.fileName != null && (!this.fileName.equals(fileName) || fileName == null)){
        		this.setDirty(true);
        		this.oldValues.put("fileName", this.fileName);
        	}
        this.fileName = fileName;
    }
    
    public String getFileType() {
        return this.fileType;
    }
    
    public void setFileType(String fileType) {
    		if((fileType != null && this.fileType == null) || 
				this.fileType != null && (!this.fileType.equals(fileType) || fileType == null)){
        		this.setDirty(true);
        		this.oldValues.put("fileType", this.fileType);
        	}
        this.fileType = fileType;
    }
    
    public Double getFileSize() {
        return this.fileSize;
    }
    
    public void setFileSize(Double fileSize) {
    		if((fileSize != null && this.fileSize == null) || 
				this.fileSize != null && (!this.fileSize.equals(fileSize) || fileSize == null)){
        		this.setDirty(true);
        		this.oldValues.put("fileSize", this.fileSize);
        	}
        this.fileSize = fileSize;
    }
    
    public Integer getAttachmentType() {
        return this.attachmentType;
    }
    
    public void setAttachmentType(Integer attachmentType) {
    		if((attachmentType != null && this.attachmentType == null) || 
				this.attachmentType != null && (!this.attachmentType.equals(attachmentType) || attachmentType == null)){
        		this.setDirty(true);
        		this.oldValues.put("attachmentType", this.attachmentType);
        	}
        this.attachmentType = attachmentType;
    }
    
    public String getAttachmentPath() {
        return this.attachmentPath;
    }
    
    public void setAttachmentPath(String attachmentPath) {
    		if((attachmentPath != null && this.attachmentPath == null) || 
				this.attachmentPath != null && (!this.attachmentPath.equals(attachmentPath) || attachmentPath == null)){
        		this.setDirty(true);
        		this.oldValues.put("attachmentPath", this.attachmentPath);
        	}
        this.attachmentPath = attachmentPath;
    }
    
    public String getAttachDesc() {
        return this.attachDesc;
    }
    
    public void setAttachDesc(String attachDesc) {
    		if((attachDesc != null && this.attachDesc == null) || 
				this.attachDesc != null && (!this.attachDesc.equals(attachDesc) || attachDesc == null)){
        		this.setDirty(true);
        		this.oldValues.put("attachDesc", this.attachDesc);
        	}
        this.attachDesc = attachDesc;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Attachment) ) return false;
		 Attachment castOther = ( Attachment ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Attachment".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("fileName", this.fileName)
		.append("fileType", this.fileType)
		.append("fileSize", this.fileSize)
		.append("attachmentType", this.attachmentType)
		.append("attachmentPath", this.attachmentPath)
		.append("attachDesc", this.attachDesc);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}