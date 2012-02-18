package org.hi.base.sysapp.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;

public class MessageProviderManager {
	
	public static final String SPRING_BEAN_ID = "org.hi.message.MessageProviderManager";
	protected Map<String, MessageProvider> providers;
	protected boolean cache;
	
	private static List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());
	
	public boolean isCache() {
		return cache;
	}


	public void setCache(boolean cache) {
		this.cache = cache;
		
		MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		Filter filter = FilterFactory.getSimpleFilter("isSent", YesNo.YESNO_NO, Filter.OPERATOR_EQ);
		messages = Collections.synchronizedList(mesgMgr.getObjects(filter));
	}


	public Map<String, MessageProvider> getProviders() {
		return providers;
	}


	public void setProviders(Map<String, MessageProvider> providers) {
		this.providers = providers;
	}


	public MessageProvider getProvider(String providerType){
		return providers.get(providerType);
	}
	
	public synchronized void addMessage(Message message){
		messages.add(message);
	}
	
	public synchronized void removeMessage(Message message){
		messages.remove(message);
	}
	
	public synchronized List<Message> getMessages(){
		return messages;
	}
}
