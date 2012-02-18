package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.action.MessageParameterPageInfo;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.base.sysapp.service.MessageParameterManager;

public class MessageParameterListAction extends BaseAction{
	private MessageParameter messageParameter;
	private MessageParameterPageInfo pageInfo;
	private List<MessageParameter> messageParameters;
	
	public String execute() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		pageInfo = pageInfo == null ? new MessageParameterPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		messageParameters = messageParameterMgr.getSecurityMessageParameterList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public MessageParameter getMessageParameter() {
		return messageParameter;
	}

	public void setMessageParameter(MessageParameter messageParameter) {
		this.messageParameter = messageParameter;
	}
	
	public List<MessageParameter> getMessageParameters() {
		return messageParameters;
	}

	public void setMessageParameters(List<MessageParameter> messageParameters) {
		this.messageParameters = messageParameters;
	}

	public MessageParameterPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(MessageParameterPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
