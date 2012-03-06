package cn.net.iccard.util;



import java.util.ArrayList;

import org.hi.base.sysapp.AppSettingHelper;



/**
 * �������ۻ���ͨѶ�����࣬��װ����ͨ������֧������ϵͳͨ�Ż���
 * @author guoyonggang
 */
public class ConnectionUtil {


	/**
     * ���ͽ��������ĵ��̻�
     * 
     * @param sendMsg ���͵���������ǩ�����ܱ���
     * @param txType �������ʹ���
     * @return
     * @throws Exception
     */
    public static void sendReqToMcht(NotifyBean message){
        try {
           System.out.println("send request to server begin......");

            // 1. ͨѶ����׼��
            // ȡ�����ӳ�ʱʱ��Ͷ���ʱʱ��
            String connTimeOut =  AppSettingHelper.getValue("mchtconnection","timeout");
            String readTimeOut = AppSettingHelper.getValue("mchtconnection","timeout");
            String Version = AppSettingHelper.getValue("mchtconnection","Version");
            // 2. ���ͽ�������֧��ƽ̨
            // ��֯��������
            HttpPostObj tObj1 = new HttpPostObj("Version", Version);
            HttpPostObj tObj2 = new HttpPostObj("TxType", message.getTxType());
            HttpPostObj tObj3 = new HttpPostObj("TxInfo", message.getSendMsg());
            HttpPostObj tObj4 = new HttpPostObj("Signature", message.getSignature());
            
            ArrayList msgList = new ArrayList();
            msgList.add(tObj1);
            msgList.add(tObj2);
            msgList.add(tObj3);
            msgList.add(tObj4);
            // �����������ӣ��������󲢽��ս��׽��
            SSLConnectionManager sslConnectionManager = new SSLConnectionManager();
            sslConnectionManager.createHttpsConnectionWithoutVerify(message.getMchtTxURL(), connTimeOut, readTimeOut);
            String resMsg = sslConnectionManager.sendData(msgList, null);
            sslConnectionManager.closeConnection();

           System.out.println("send request to server end.");


        } catch (Exception e) {
        	System.out.println("send request to server error");
            //throw e;// ���ͽ�������ʧ��
        }
    }
}
