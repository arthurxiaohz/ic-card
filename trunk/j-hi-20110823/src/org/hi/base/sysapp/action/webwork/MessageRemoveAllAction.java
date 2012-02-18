package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;

public class MessageRemoveAllAction extends BaseAction{
	private Message message;
	private String orderIndexs;
	
	public String execute() throws Exception {
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
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
