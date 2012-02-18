package org.hi.base.sysapp.message.mail;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.base.sysapp.message.AbstractMessageProvider;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.framework.web.BusinessException;
import org.hi.i18n.util.I18NUtil;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


public class JavaMailMessageProvider extends AbstractMessageProvider {
	
	protected static final String MESSAGE_PARAMETER_BCC = "BCC";
	protected static final String MESSAGE_PARAMETER_CC = "CC";
	
	protected String host;
	protected int port;
	protected String encoding;
	protected String userName;
	protected String password;
	protected String from;

	public void sendMessage(Message message) throws BusinessException {
		if(message.getReceivers() == null && this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_ALL) == null)
			return;
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(this.getHost());
		sender.setPort(this.getPort());
		sender.setUsername(this.getUserName());
		sender.setPassword(this.getPassword());
		MimeMessage mimeMessage = sender.createMimeMessage();
		try{
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,getEncoding());
			helper.setFrom(from);
			helper.setText(message.getMessageText());
			String pValue = null;
			
			//设置接件人
			
			pValue = this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_ALL);
			String[] receivers = null;
			if(pValue != null){							
				if(Boolean.valueOf(pValue)){			//如果有all参数,则all优先
					receivers = this.getAllReceivers();
				}
			}
			else{
				receivers = message.getReceivers().split(",");
			}
			if(receivers == null && receivers.length > 0 )	//如果处理后仍没有接件人,则返回
				return;
			
			helper.setTo(receivers);
			
			
			//设置邮件标题
			pValue = this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_SUBJECT);
			if(pValue != null)
				helper.setSubject(pValue);
			
			//设置抄送人
			pValue = this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_CC);
			if(pValue != null){
				String[] cc = pValue.split(",");
				helper.setCc(cc);
			}

			//设置暗送人
			pValue = this.getParameter(message.getMessageParameters(), MESSAGE_PARAMETER_BCC);
			if(pValue != null){
				String[] bcc = pValue.split(",");
				helper.setBcc(bcc);
			}
		}
		catch (MessagingException e) {
			new BusinessException(I18NUtil.getString("发送邮件失败"));
		}
		sender.send(mimeMessage);
		this.sentProcess(message);
	}
	
	
	public String[] getAllReceivers() {
		List<String> receivers = new ArrayList<String>();
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		List<HiUser> users = userMgr.getObjects();
		String userMail = null;
		for (HiUser user : users) {
			userMail = user.getMail();
			if(userMail != null && userMail.indexOf("@") > 0)
				receivers.add(userMail);
		}
		return receivers.toArray(new String[receivers.size()]);
	}
	
	public String getReceivers(String ids) {
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		StringBuffer sb = new StringBuffer("");
		String[] users = ids.split(",");
		for (String userId : users) {
			HiUser  user = (HiUser)userMgr.getObjectById(new Integer(userId));
			String userMail = user.getMail();
			if(userMail != null && userMail.indexOf("@") > 0)
				sb.append(userMail).append(",");
		}
		return sb.toString();
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost(){
		return host==null?"smtp.cltc.com.cn":host;
	}
	
	public String getUserName(){
		return userName==null?"zhanghao":userName;
	}
	public String getPassword(){
		return password==null?"111111":password;
	}
	public String getFrom(){
		return from==null?"zhanghao@cltc.com.cn":from;
	}
	
	public String getEncoding(){
		return encoding==null?"UTF-8":encoding;
	}

	public int getPort(){
		return port==0 ? 25 : port;
	}
	
	
	public static void main(String[] args) {
		JavaMailMessageProvider provider  = new JavaMailMessageProvider();
		Message message = new Message();
		message.setSender("zhanghao@cltc.com.cn");
		message.setReceivers("zhanghao@cltc.com.cn");
		message.setMessageText("test text");
		List<MessageParameter> list = new ArrayList<MessageParameter>();
		
		MessageParameter subject = new MessageParameter();
		subject.setParameterKey(MESSAGE_PARAMETER_SUBJECT);
		subject.setParameterValue("测试邮件");
		list.add(subject);
		
		MessageParameter cc = new MessageParameter();
		cc.setParameterKey(MESSAGE_PARAMETER_CC);
		cc.setParameterValue("zhanghao@cltc.com.cn");
		list.add(cc);
		
		MessageParameter bcc = new MessageParameter();
		bcc.setParameterKey(MESSAGE_PARAMETER_BCC);
		bcc.setParameterValue("hao_zhang_pk@qq.com");
		list.add(bcc);
		
		message.setMessageParameters(list);
		
		provider.sendMessage(message);
	}


}
