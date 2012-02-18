package org.hi.base.sysapp.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.sysapp.action.MessagePageInfo;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;

public class MessageAction extends BaseAction{
	private Message message;
	private MessagePageInfo pageInfo;
	private List<Message> messages;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存消息
	 */
	public String saveMessage() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		if(super.perExecute(message)!= null) return returnCommand();
		messageMgr.saveMessage(message);
		super.postExecute(message);
		return returnCommand();
	}
	
	
	/**
	 * 删除消息
	 */
	public String removeMessage() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		messageMgr.removeMessageById(message.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些消息
	 */
	public String removeAllMessage() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer messageid = new Integer( ids[i] );
				messageMgr.removeMessageById(messageid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看消息
	 */
	public String viewMessage() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		message = messageMgr.getMessageById(message.getId());
		return returnCommand();
	}
	
	/**
	 * 消息列表
	 */
	public String messageList() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		pageInfo = pageInfo == null ? new MessagePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
