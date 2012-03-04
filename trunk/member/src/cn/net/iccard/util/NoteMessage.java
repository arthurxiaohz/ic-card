package cn.net.iccard.util;

import org.hi.base.sysapp.AppSettingHelper;

import com.linkage.netmsg.NetMsgclient;
import com.linkage.netmsg.server.ReceiveMsg;

import cn.net.iccard.tx.model.TblTxPayMentOrder;

public class NoteMessage {

	 static NetMsgclient client   = new NetMsgclient();


	/**
	 * �������Ͷ��ŵ�����
	 * @param trans
	 * @return
	 */
	private String createSmsMessage(TblTxPayMentOrder trans){
		String merchantOrderDate = DateUtil.date2showString(trans.getCreatedDatetime());
		String merchantAmount = MoneyUtil.parseFromReadableAmountToRMB(trans.getTxAmount().toString());
		String merchantOrderNo = trans.getMchtNo();
		return "������"+merchantOrderDate+"�ύ��һ��"+merchantAmount+"Ԫ�Ķ�����������Ϊ"+merchantOrderNo+"����Ӧ�Ķ�����֤��Ϊ"+trans.getVerifyCode()+"�����μǷſ�ȷ����"+trans.getConfirmCode()+"������ȷ���ջ���";
	}
	
	/**
	 * ������־
	 * @param log
	 */
	private Boolean sendShortMessage(SmsBean sms){
		
		
		/*�������ж���*/
      	client.sendMsg(client, 0, sms.getPhoneNo(), sms.getSmsContent(), 1);
      	
      	
		return true;
	}
	
	//��ʼ������
	public static void initMsgConnect() throws Exception{
		
		  String msgIpValue = AppSettingHelper.getValue("MSGHOST"," WEB_HOSTING");
		  String msgPortValue = AppSettingHelper.getValue("MSGHOST"," WEB_PORT");
		  String msgUsrNameValue = AppSettingHelper.getValue("MSGHOST"," WEB_USERNAME");
		  String msgPassWordValue = AppSettingHelper.getValue("MSGHOST"," WEB_PASSWORD");
		  
		  ReceiveMsg receiveMsg = new ReceiveDemo();
		  
		  /*��ʼ������*/
        client = client.initParameters(msgIpValue,Integer.parseInt(msgPortValue), msgUsrNameValue,msgPassWordValue,receiveMsg);
        
        /*��¼��֤*/
        boolean isLogin = client.anthenMsg(client);
        if(isLogin){
        	System.out.println("login sucess");
        }else{
        	throw new Exception();
        }
	}
	
	
	
}