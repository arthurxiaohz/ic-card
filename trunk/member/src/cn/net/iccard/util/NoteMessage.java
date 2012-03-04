package cn.net.iccard.util;

import org.hi.base.sysapp.AppSettingHelper;

import com.linkage.netmsg.NetMsgclient;
import com.linkage.netmsg.server.ReceiveMsg;

import cn.net.iccard.tx.model.TblTxPayMentOrder;

public class NoteMessage {

	 static NetMsgclient client   = new NetMsgclient();


	/**
	 * 创建发送短信的内容
	 * @param trans
	 * @return
	 */
	private String createSmsMessage(TblTxPayMentOrder trans){
		String merchantOrderDate = DateUtil.date2showString(trans.getCreatedDatetime());
		String merchantAmount = MoneyUtil.parseFromReadableAmountToRMB(trans.getTxAmount().toString());
		String merchantOrderNo = trans.getMchtNo();
		return "《您于"+merchantOrderDate+"提交了一笔"+merchantAmount+"元的订单，订单号为"+merchantOrderNo+"，对应的短信验证码为"+trans.getVerifyCode()+"，请牢记放款确认码"+trans.getConfirmCode()+"，用于确认收货》";
	}
	
	/**
	 * 发送日志
	 * @param log
	 */
	private Boolean sendShortMessage(SmsBean sms){
		
		
		/*发送下行短信*/
      	client.sendMsg(client, 0, sms.getPhoneNo(), sms.getSmsContent(), 1);
      	
      	
		return true;
	}
	
	//初始化连接
	public static void initMsgConnect() throws Exception{
		
		  String msgIpValue = AppSettingHelper.getValue("MSGHOST"," WEB_HOSTING");
		  String msgPortValue = AppSettingHelper.getValue("MSGHOST"," WEB_PORT");
		  String msgUsrNameValue = AppSettingHelper.getValue("MSGHOST"," WEB_USERNAME");
		  String msgPassWordValue = AppSettingHelper.getValue("MSGHOST"," WEB_PASSWORD");
		  
		  ReceiveMsg receiveMsg = new ReceiveDemo();
		  
		  /*初始化参数*/
        client = client.initParameters(msgIpValue,Integer.parseInt(msgPortValue), msgUsrNameValue,msgPassWordValue,receiveMsg);
        
        /*登录认证*/
        boolean isLogin = client.anthenMsg(client);
        if(isLogin){
        	System.out.println("login sucess");
        }else{
        	throw new Exception();
        }
	}
	
	
	
}