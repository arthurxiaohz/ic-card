package org.hi.base.sysapp.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.enumeration.model.YesNo;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.base.organization.model.HiUser;

public abstract class MessageAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 接收者
	 */	
 	protected  String receivers;

 	 /**
	 * 收信人
	 */	
 	protected  String receiverNames;

 	 /**
	 * 发信人
	 */	
 	protected  String sender;

 	 /**
	 * 消息类型
	 * 
	 */	
 	protected  Integer messageType;

 	 /**
	 * 消息正文
	 */	
 	protected  String messageText;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createDate;

 	 /**
	 * 发送时间
	 */	
 	protected  Timestamp sendDate;

 	 /**
	 * 已发送
	 * 
	 */	
 	protected  Integer isSent;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = 
				org.hi.framework.security.context.UserContextHelper.getUser()
			;

	private  List<MessageParameter> messageParameters;

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
    
    public String getReceivers() {
        return this.receivers;
    }
    
    public void setReceivers(String receivers) {
    		if((receivers != null && this.receivers == null) || 
				this.receivers != null && (!this.receivers.equals(receivers) || receivers == null)){
        		this.setDirty(true);
        		this.oldValues.put("receivers", this.receivers);
        	}
        this.receivers = receivers;
    }
    
    public String getReceiverNames() {
        return this.receiverNames;
    }
    
    public void setReceiverNames(String receiverNames) {
    		if((receiverNames != null && this.receiverNames == null) || 
				this.receiverNames != null && (!this.receiverNames.equals(receiverNames) || receiverNames == null)){
        		this.setDirty(true);
        		this.oldValues.put("receiverNames", this.receiverNames);
        	}
        this.receiverNames = receiverNames;
    }
    
    public String getSender() {
        return this.sender;
    }
    
    public void setSender(String sender) {
    		if((sender != null && this.sender == null) || 
				this.sender != null && (!this.sender.equals(sender) || sender == null)){
        		this.setDirty(true);
        		this.oldValues.put("sender", this.sender);
        	}
        this.sender = sender;
    }
    
    public Integer getMessageType() {
        return this.messageType;
    }
    
    public void setMessageType(Integer messageType) {
    		if((messageType != null && this.messageType == null) || 
				this.messageType != null && (!this.messageType.equals(messageType) || messageType == null)){
        		this.setDirty(true);
        		this.oldValues.put("messageType", this.messageType);
        	}
        this.messageType = messageType;
    }
    
    public String getMessageText() {
        return this.messageText;
    }
    
    public void setMessageText(String messageText) {
    		if((messageText != null && this.messageText == null) || 
				this.messageText != null && (!this.messageText.equals(messageText) || messageText == null)){
        		this.setDirty(true);
        		this.oldValues.put("messageText", this.messageText);
        	}
        this.messageText = messageText;
    }
    
    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
    		if((createDate != null && this.createDate == null) || 
				this.createDate != null && (!this.createDate.equals(createDate) || createDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("createDate", this.createDate);
        	}
        this.createDate = createDate;
    }
    
    public Timestamp getSendDate() {
        return this.sendDate;
    }
    
    public void setSendDate(Timestamp sendDate) {
    		if((sendDate != null && this.sendDate == null) || 
				this.sendDate != null && (!this.sendDate.equals(sendDate) || sendDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("sendDate", this.sendDate);
        	}
        this.sendDate = sendDate;
    }
    
    public Integer getIsSent() {
        return this.isSent;
    }
    
    public void setIsSent(Integer isSent) {
    		if((isSent != null && this.isSent == null) || 
				this.isSent != null && (!this.isSent.equals(isSent) || isSent == null)){
        		this.setDirty(true);
        		this.oldValues.put("isSent", this.isSent);
        	}
        this.isSent = isSent;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
    		if((description != null && this.description == null) || 
				this.description != null && (!this.description.equals(description) || description == null)){
        		this.setDirty(true);
        		this.oldValues.put("description", this.description);
        	}
        this.description = description;
    }
    
    public HiUser getCreator() {
        return this.creator;
    }
    
    public void setCreator(HiUser creator) {
    		if((creator != null && this.creator == null) || 
				this.creator != null && (!this.creator.equals(creator) || creator == null)){
        		this.setDirty(true);
        		this.oldValues.put("creator", this.creator);
        	}
        this.creator = creator;
    }
    

    public void setMessageParameters(List<MessageParameter> messageParameters) {
        this.messageParameters = messageParameters;
    }

    public List<MessageParameter> getMessageParameters() {
        return this.messageParameters;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Message) ) return false;
		 Message castOther = ( Message ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Message".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("receivers", this.receivers)
		.append("receiverNames", this.receiverNames)
		.append("sender", this.sender)
		.append("messageText", this.messageText)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}