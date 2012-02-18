package org.hi.base.sysapp.model;

import java.util.ArrayList;
import java.util.List;

import org.hi.base.sysapp.model.original.MessageAbstract;


public class Message extends MessageAbstract{

	public void putMessageParameter(String key, String value){
		MessageParameter messageParameter = new MessageParameter();
		messageParameter.setParameterKey(key);
		messageParameter.setParameterValue(value);
		if(this.getMessageParameters() == null){
			List<MessageParameter> messageParameters = new ArrayList<MessageParameter>();
			this.setMessageParameters(messageParameters);
		}
		
		this.getMessageParameters().add(messageParameter);
	}
	

}