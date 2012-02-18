package org.hi.base.sysapp.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.sysapp.action.MessageParameterPageInfo;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.base.sysapp.service.MessageParameterManager;

public class MessageParameterAction extends BaseAction{
	private MessageParameter messageParameter;
	private MessageParameterPageInfo pageInfo;
	private List<MessageParameter> messageParameters;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı�����Ϣ����
	 */
	public String saveMessageParameter() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		if(super.perExecute(messageParameter)!= null) return returnCommand();
		messageParameterMgr.saveMessageParameter(messageParameter);
		super.postExecute(messageParameter);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����Ϣ����
	 */
	public String removeMessageParameter() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		messageParameterMgr.removeMessageParameterById(messageParameter.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��Ϣ����
	 */
	public String removeAllMessageParameter() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer messageParameterid = new Integer( ids[i] );
				messageParameterMgr.removeMessageParameterById(messageParameterid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��Ϣ����
	 */
	public String viewMessageParameter() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		messageParameter = messageParameterMgr.getMessageParameterById(messageParameter.getId());
		return returnCommand();
	}
	
	/**
	 * ��Ϣ�����б�
	 */
	public String messageParameterList() throws Exception {
		MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
		pageInfo = pageInfo == null ? new MessageParameterPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
