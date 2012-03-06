package cn.net.iccard.util;



import java.util.ArrayList;

import org.hi.base.sysapp.AppSettingHelper;



/**
 * 基金销售机构通讯工具类，封装了与通联基金支付服务系统通信机制
 * @author guoyonggang
 */
public class ConnectionUtil {


	/**
     * 发送交易请求报文到商户
     * 
     * @param sendMsg 发送到服务器的签名加密报文
     * @param txType 交易类型代码
     * @return
     * @throws Exception
     */
    public static void sendReqToMcht(NotifyBean message){
        try {
           System.out.println("send request to server begin......");

            // 1. 通讯数据准备
            // 取得连接超时时间和读超时时间
            String connTimeOut =  AppSettingHelper.getValue("mchtconnection","timeout");
            String readTimeOut = AppSettingHelper.getValue("mchtconnection","timeout");
            String Version = AppSettingHelper.getValue("mchtconnection","Version");
            // 2. 发送交易请求到支付平台
            // 组织请求数据
            HttpPostObj tObj1 = new HttpPostObj("Version", Version);
            HttpPostObj tObj2 = new HttpPostObj("TxType", message.getTxType());
            HttpPostObj tObj3 = new HttpPostObj("TxInfo", message.getSendMsg());
            HttpPostObj tObj4 = new HttpPostObj("Signature", message.getSignature());
            
            ArrayList msgList = new ArrayList();
            msgList.add(tObj1);
            msgList.add(tObj2);
            msgList.add(tObj3);
            msgList.add(tObj4);
            // 建立银行连接，发送请求并接收交易结果
            SSLConnectionManager sslConnectionManager = new SSLConnectionManager();
            sslConnectionManager.createHttpsConnectionWithoutVerify(message.getMchtTxURL(), connTimeOut, readTimeOut);
            String resMsg = sslConnectionManager.sendData(msgList, null);
            sslConnectionManager.closeConnection();

           System.out.println("send request to server end.");


        } catch (Exception e) {
        	System.out.println("send request to server error");
            //throw e;// 发送交易请求失败
        }
    }
}
