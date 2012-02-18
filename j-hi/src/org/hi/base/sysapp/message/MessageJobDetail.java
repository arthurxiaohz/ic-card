package org.hi.base.sysapp.message;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.schedule.quartz.JobDetail;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;



public class MessageJobDetail extends JobDetail {

	public void execute() {
		MessageProviderManager providerMgr = (MessageProviderManager)SpringContextHolder.getBean(MessageProviderManager.SPRING_BEAN_ID);
		List<Message> messages;
		Timestamp crrentTime = new Timestamp(new Date().getTime());
		
		if(providerMgr.isCache()){
			messages = providerMgr.getMessages();
		}
		else{
			MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
			Filter filter = FilterFactory.getSimpleFilter("isSent", YesNo.YESNO_NO, Filter.OPERATOR_EQ).
			addCondition("sendDate", crrentTime, Filter.OPERATOR_LESS_EQ, Filter.RELATION_AND);
			messages = mesgMgr.getObjects(filter);
		}
		
		MessageProvider provider;
		for (Message message : messages) {
			synchronized(messages){
				if(message.getSendDate().before(crrentTime)){
					provider = providerMgr.getProvider(message.getMessageType().toString());
					provider.sendMessage(message);
			}
			}
		}
	}

}
