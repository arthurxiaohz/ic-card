package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.action.MessagePageInfo;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;

public class MessageListAction extends BaseAction{
	private Message message;
	private MessagePageInfo pageInfo;
	private List<Message> messages;
	
	public String execute() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		pageInfo = pageInfo == null ? new MessagePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		messages = messageMgr.getSecurityMessageList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public MessagePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(MessagePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
