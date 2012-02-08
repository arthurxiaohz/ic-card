package org.hi.base.sysapp.message.shortmessage;

import org.hi.base.sysapp.message.AbstractMessageProvider;
import org.hi.base.sysapp.model.Message;
import org.hi.framework.web.BusinessException;


public class HiShortMessageProvider extends AbstractMessageProvider {
	
	
	@Override
	public String[] getAllReceivers() {
		return null;
	}

	public void sendMessage(Message message) throws BusinessException {
	}

	public String getReceivers(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
