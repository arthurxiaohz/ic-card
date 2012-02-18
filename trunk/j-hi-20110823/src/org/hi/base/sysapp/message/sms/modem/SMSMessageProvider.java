package org.hi.base.sysapp.message.sms.modem;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.base.sysapp.message.AbstractMessageProvider;
import org.hi.base.sysapp.message.sms.SmsListener;
import org.hi.base.sysapp.message.sms.SmsMessenger;
import org.hi.base.sysapp.model.Message;
import org.hi.framework.web.BusinessException;

public class SMSMessageProvider extends AbstractMessageProvider implements
		SmsMessenger, SmsListener {

	public Vector eventQ;
	protected String smsPort = "COM4";
	
	public String getSmsPort() {
		return smsPort;
	}

	public void setSmsPort(String smsPort) {
		this.smsPort = smsPort;
		GprsSmsSend.getInstance().setSmsPort(smsPort);
	}

	public SMSMessageProvider() {
		eventQ = new Vector();
		GprsSmsSend.getInstance().setMessenger(this);
	}

	public void addListener(Object o) {
		eventQ.add(o);
	}

	public void removeListener(Object o) {
		eventQ.remove(o);
	}

	public SerialParameters getParameter() {
		return GprsSmsSend.getInstance().getParameters();
	}
	
	/*---   实现AbstractMessageProvider    ---*/	
	public void send(String usermobile, String stMessage) {
		Sms msg = new Sms(usermobile, stMessage);
		GprsSmsSend.getInstance().addQueue(msg);
	}

	/*--- 实现SmsListener ***/
	public void SmsArrive(Vector v) {
		for (int i = 0; i < eventQ.size(); i++)
			((SmsListener) eventQ.get(i)).SmsArrive(v);

	}
	/*---   实现AbstractMessageProvider    ---*/	 
	public String[] getAllReceivers() {
		List<String> receivers = new ArrayList<String>();
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		List<HiUser> users = userMgr.getObjects();
		String userMobile = null;
		for (HiUser user : users) {
			userMobile = user.getMobile();
			if(userMobile != null && userMobile.length()==11)
				receivers.add(userMobile);
		}
		return receivers.toArray(new String[receivers.size()]);
	}
	
	public String getReceivers(String ids) {
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		StringBuffer sb = new StringBuffer("");
		String[] users = ids.split(",");
		for (String userId : users) {
			HiUser  user = (HiUser)userMgr.getObjectById(new Integer(userId));
			String userMobile = user.getMobile();
			if(userMobile != null && userMobile.length()==11)
				sb.append(userMobile).append(",");
		}
		return sb.toString();
	}
	
	/*---   实现MessageProvider    --*/	
	public void sendMessage(Message message) throws BusinessException {
		if(message.getReceivers() == null && this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_ALL) == null)
			return;
		
		if(message.getMessageText() == null || message.getMessageText().trim().equals(""))
			return;
		
		//设置收件人
		String pValue = this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_ALL);
		String[] receivers = null;
		if(pValue != null){							
			if(Boolean.valueOf(pValue)){			//如果有all参数,则all优先
				receivers = this.getAllReceivers();
			}
		}
		else{
			receivers = message.getReceivers().split(",");
		}
		if(receivers == null && receivers.length > 0 )	//如果处理后仍没有收件人,则返回
			return;
		
		for (String userMobile : receivers){
			send(userMobile, message.getMessageText());
		}
		
	}

	public static void main(String[] args) {
		SMSMessageProvider p = new SMSMessageProvider();
		Message message = new Message();
		message.setReceivers("13681365106");
		message.setMessageText("您好!");
		p.sendMessage(message);
	}

}
