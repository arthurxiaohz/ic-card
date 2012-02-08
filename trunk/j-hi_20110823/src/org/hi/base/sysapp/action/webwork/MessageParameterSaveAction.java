package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.base.sysapp.service.MessageParameterManager;
import org.hi.framework.web.SynchronizationData;

public class MessageParameterSaveAction extends BaseAction implements SynchronizationData{
	private MessageParameter messageParameter;
	
	public String execute() throws Exception {
		if(super.perExecute(messageParameter)!= null) return returnCommand();
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		messageParameterMgr.saveMessageParameter(messageParameter);
		super.postExecute(messageParameter);
		return returnCommand();
	}
	
	public MessageParameter getMessageParameter() {
		return messageParameter;
	}

	public void setMessageParameter(MessageParameter messageParameter) {
		this.messageParameter = messageParameter;
	}

}
