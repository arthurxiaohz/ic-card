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
	
	/*��ȡ���ж��ŷ���״̬�Ͷ���ID�ķ���*/
	 public void getAnswer(AnswerBean answerBean)
    {
        super.getAnswer(answerBean);
        
         
        /*����Id*/
        String seqIdString = answerBean.getSeqId();
        
        
         /*����״̬ ,0��ʾ�ύ��APIƽ̨�ɹ�*/
        int status = answerBean.getStatus();
        
        /*���ж���ID������Ψһ��ʶһ�����ж���*/
        String msgId = answerBean.getMsgId();
        
        //�˴�������ն��ŷ���״̬�Ͷ���ID�Ĵ�����루��:�����յ�����Ϣ����⴦��
        
    }
    
    
    /*�������ж��ŵķ���*/
   public void getUpMsg(UpMsgBean upMsgBean) {
   	
       	super.getUpMsg(upMsgBean);
       
	      String sequenceId = upMsgBean.getSequenceId();
	
	      /* ���ͺ��� */
	      String sendNum = upMsgBean.getSendNum();
	
	      /* ���պ��� */
	      String receiveNum = upMsgBean.getReceiveNum();
	
	      /* ���ж��ŵ���ʱ�� */
	      String msgRecTime = upMsgBean.getMsgRecTime();
	
	      /* �������� */
	      String msgContent = upMsgBean.getMsgContent();
	      
	      //�˴�����������ж��ŵĴ������
        
    }
    
   	/*��ȡ���ж��Ż�ִ�ķ���*/
    public void getReturnMsg(ReturnMsgBean returnMsgBean)
    {
        
         super.getReturnMsg(returnMsgBean);
        
        String sequenceId = returnMsgBean.getSequenceId();
        
        /* ���ŵ�msgId */
        String msgId = returnMsgBean.getMsgId();
        
        /* ���ͺ��� */
        String sendNum = returnMsgBean.getSendNum();
        
        /* ���պ��� */
        String receiveNum = returnMsgBean.getReceiveNum();
        
        /* �����ύʱ�� */
        String submitTime = returnMsgBean.getSubmitTime();
        
        /* �����·�ʱ�� */
        String sendTime = returnMsgBean.getSendTime();
        
        /* ����״̬ */
        String msgStatus = returnMsgBean.getMsgStatus();
        
        /* ���Ŵ������ */
        int msgErrStatus = returnMsgBean.getMsgErrStatus();
        
        //�˴�������ն��Ż�ִ�Ĵ������
    }
    
    
   

}
