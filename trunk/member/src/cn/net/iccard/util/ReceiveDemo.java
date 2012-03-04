package cn.net.iccard.util;
import com.linkage.netmsg.server.AnswerBean;
import com.linkage.netmsg.server.ReceiveMsg;
import com.linkage.netmsg.server.ReturnMsgBean;
import com.linkage.netmsg.server.UpMsgBean;

/**
 * @(#)ReceiveMsgImpl.java 2009-11-30
 *
 * Copyright 2009 LINKAGE, Inc. All rights reserved.
 * LINKAGE PROPRIETARY/CONFIDtheENTIAL. Use is subject to license terms.
 */

/**
 * @description 
 * 
 * @author li
 * @date 2009-11-30
 * @version 1.0.0
 * @since 1.0
 */
public class ReceiveDemo extends ReceiveMsg{
	
	/*获取下行短信返回状态和短信ID的方法*/
	 public void getAnswer(AnswerBean answerBean)
    {
        super.getAnswer(answerBean);
        
         
        /*序列Id*/
        String seqIdString = answerBean.getSeqId();
        
        
         /*短信状态 ,0表示提交至API平台成功*/
        int status = answerBean.getStatus();
        
        /*下行短信ID，用来唯一标识一条下行短信*/
        String msgId = answerBean.getMsgId();
        
        //此处加入接收短信返回状态和短信ID的处理代码（即:将接收到的信息做入库处理）
        
    }
    
    
    /*接收上行短信的方法*/
   public void getUpMsg(UpMsgBean upMsgBean) {
   	
       	super.getUpMsg(upMsgBean);
       
	      String sequenceId = upMsgBean.getSequenceId();
	
	      /* 发送号码 */
	      String sendNum = upMsgBean.getSendNum();
	
	      /* 接收号码 */
	      String receiveNum = upMsgBean.getReceiveNum();
	
	      /* 上行短信到达时间 */
	      String msgRecTime = upMsgBean.getMsgRecTime();
	
	      /* 短信内容 */
	      String msgContent = upMsgBean.getMsgContent();
	      
	      //此处加入接收上行短信的处理代码
        
    }
    
   	/*获取下行短信回执的方法*/
    public void getReturnMsg(ReturnMsgBean returnMsgBean)
    {
        
         super.getReturnMsg(returnMsgBean);
        
        String sequenceId = returnMsgBean.getSequenceId();
        
        /* 短信的msgId */
        String msgId = returnMsgBean.getMsgId();
        
        /* 发送号码 */
        String sendNum = returnMsgBean.getSendNum();
        
        /* 接收号码 */
        String receiveNum = returnMsgBean.getReceiveNum();
        
        /* 短信提交时间 */
        String submitTime = returnMsgBean.getSubmitTime();
        
        /* 短信下发时间 */
        String sendTime = returnMsgBean.getSendTime();
        
        /* 短信状态 */
        String msgStatus = returnMsgBean.getMsgStatus();
        
        /* 短信错误代码 */
        int msgErrStatus = returnMsgBean.getMsgErrStatus();
        
        //此处加入接收短信回执的处理代码
    }
    
    
   

}
