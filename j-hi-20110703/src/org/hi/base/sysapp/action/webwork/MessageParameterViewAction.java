package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.MessageParameter;
import org.hi.base.sysapp.service.MessageParameterManager;

public class MessageParameterViewAction extends BaseAction{
	private MessageParameter messageParameter;
	
	public String execute() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		messageParameter = messageParameterMgr.getMessageParameterById(messageParameter.getId());
		return returnCommand();
	}
	
	public MessageParameter getMessageParameter() {
		return messageParameter;
	}

	public void setMessageParameter(MessageParameter messageParameter) {
		this.messageParameter = messageParameter;
	}
}
