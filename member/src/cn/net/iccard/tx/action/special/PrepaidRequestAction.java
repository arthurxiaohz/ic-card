package cn.net.iccard.tx.action.special;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import cn.net.iccard.tx.action.TblTxPayMentOrderPageInfo;
import cn.net.iccard.tx.action.TblTxPayMentRequestPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.model.special.ThreadPool;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;
import cn.net.iccard.tx.service.impl.TblTxPayMentOrderManagerImpl;
import cn.net.iccard.tx.service.impl.TblTxPayMentRequestManagerImpl;
import cn.net.iccard.util.Base64;
import cn.net.iccard.util.ConnectionUtil;
import cn.net.iccard.util.NotifyBean;
import cn.net.iccard.util.PLTraceNoGererator;
import cn.net.iccard.util.StringUtil;

//Ԥ֧�����״���

public class PrepaidRequestAction extends BaseAction{

	public static ThreadPoolTaskExecutor threadPool4Monitor;
	
	static{
		threadPool4Monitor = (ThreadPoolTaskExecutor)SpringContextHolder.getBean(ThreadPool.class);
	}
	
	//�����̻�������
	public String getMchtRequest() throws Exception {
		

	   
		//1.ȡ���̻�����
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
//		 try {
//		      request.setCharacterEncoding("UTF-8");
//		      String contentType = new StringBuffer("text/html; charset=").append("UTF-8").toString();
//		      response.setContentType(contentType);
//		    } catch (Exception e) {
//		      //logger.error("", e);
//		    }
		System.out.println("1111111111");
		String msg = request.getParameter("TxInfo");			//������
		String Signature = request.getParameter("Signature");	//����ǩ��
		String TxType = request.getParameter("TxType");			//��������
		
		  byte[] tPlainByBase64 = Base64.decode(msg);
	        msg = new String(tPlainByBase64,"UTF-8");
		
		// �������л�Ӧ���׽���ֶ�
        String[] tPlainStr = StringUtil.split(msg, "|");
        Properties tBankPlain = new Properties();
        String[] tStrTemp = null;
        for (int i = 0; i < tPlainStr.length; i++) {
            tStrTemp = StringUtil.split(tPlainStr[i], "=");
            tBankPlain.setProperty(tStrTemp[0], tStrTemp[1]);
        }
      
		if(TxType.equals("TX11")){
			
			//����txinfo
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //�̻�������ˮ��
			String TxAmount = tBankPlain.getProperty("TxAmount");				//���׽��
			String MerchantNo = tBankPlain.getProperty("MerchantNo");			//�̻�����
			String TxDate = tBankPlain.getProperty("TxDate");					//��������
			String TxTime = tBankPlain.getProperty("TxTime");					///����ʱ��
			String TxBody = tBankPlain.getProperty("TxBody");					//��Ʒ����
			System.out.println(TxBody);
			String ShowUrl = tBankPlain.getProperty("ShowUrl");					//��ƷչʾURL 
			String UseCoupon = tBankPlain.getProperty("UseCoupon");				//	�Ƿ�ʹ���Ż�ȯ					
			String CouponMsg = tBankPlain.getProperty("CouponMsg");					//	�Ż�ȯ��Ϣ
			String NotifyURL = tBankPlain.getProperty("NotifyURL");				//���׽��֪ͨ��ַ
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//���׽����̨֪ͨ��ַ
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//��չ��
			String certID = tBankPlain.getProperty("CertID");						//�̻�֤��ID
			//String cert = thnCertID.getProperty(certID);
			
			//1.��֤�̻�������
			
			//2.��¼�����
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//�̻�������ˮ��
			tblTxPayMentRequest.setMchtNo(MerchantNo);				//�̻���	
			tblTxPayMentRequest.setAmount(TxAmount);				//���׽��
			tblTxPayMentRequest.setMchtTxTime(TxTime);				//�̻���������
			tblTxPayMentRequest.setTxTypeId(TxType);				//��������
			tblTxPayMentRequest.setMchtRawMessage(msg);						//ԭʼ���ױ���
			tblTxPayMentRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			//tblTxPayMentRequest.setLastUpdatedBy();     	//����޸���
			tblTxPayMentRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			tblTxPayMentRequestMgr.saveTblTxPayMentRequest(tblTxPayMentRequest);
			
			
			//3.��¼������
			TblTxPayMentOrderManager TblTxPayMentOrderMan = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
			
			TblTxPayMentOrder TblTxPayMentOrder= new TblTxPayMentOrder();
			
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			TblTxPayMentOrder.setPlTxTraceNo(plTxTraceNo);
			TblTxPayMentOrder.setTxTypeId("TX11");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setTxAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//��ȷ����
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setShowUrl(ShowUrl);
			TblTxPayMentOrder.setTxBody(TxBody);
			TblTxPayMentOrder.setTxStatus(1);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.����session
			request.getSession(true).setAttribute("plTxTraceNo", plTxTraceNo);
			
		}
		return SUCCESS;
		
	}
	
	//Ԥ֧�� ȷ��
	public void upfrontCostAffirm() throws Exception {
		

	   
		//1.ȡ��������Ϣ
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		 try {
		      request.setCharacterEncoding("GBK");
		      String contentType = new StringBuffer("text/html; charset=").append("GBK").toString();
		      response.setContentType(contentType);
		    } catch (Exception e) {
		      //logger.error("", e);
		    }
			
		//ȡ��������Ϣ�������˻�ϵͳ���пۿ�ۿ�ɹ���
		String msg = request.getParameter("TxInfo");			//������
		String Signature = request.getParameter("Signature");	//����ǩ��
		String TxType = request.getParameter("TxType");			//��������
		
		//�޸Ķ�Ӧ���׼�¼״̬    
		//�Ȳ�ѯ֧��������

		Filter filter = FilterFactory.getSimpleFilter("mchtTxTraceNo",request.getParameter("plTxTraceNo"), Filter.OPERATOR_EQ);
		
		//Filter Filter = PageInfoUtil.populateFilter(tblTxPayMentOrderPageInfo);
		System.out.println(filter);
		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		List list  = TblTxPayMentOrderManagerImpl.getObjects(TblTxPayMentOrder.class,filter);
		
		//����֧��������
		TblTxPayMentOrder TblTxPayMentOrder = (TblTxPayMentOrder)list.get(0);
		TblTxPayMentOrder.setTxStatus(2);
		TblTxPayMentOrder.setLastUpdatedBy(Integer.valueOf(request.getParameter("username")));
		
		//��¼֧�����֪ͨ��֪ͨ�̻�
		NotifyBean notifyBean = new NotifyBean();
//		notifyBean.setMchtTxURL(mchtTxURL)
//		send();
		
		
		}
		
	public static void main(String args[]){
		String a = "MchtTxTraceNo=1221314|TxAmount=123|MerchantNo=2342|TxDate=20120202|TxTime=121212|TxBody=�ٶ�һ��|ShowUrl=http://www.baidu.com|UseCoupon=|CouponMsg=|NotifyURL=|BGNotifyURL=";
		try {
			String tPlainByBase64 = Base64.encode(a.getBytes("UTF-8"));
			
			System.out.println(tPlainByBase64);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ������Ϣ
	 * 
	 * @param message
	 */
	public static void send(final NotifyBean message) {

		try {
			threadPool4Monitor.execute(new Runnable() {
				public void run() {

					ConnectionUtil.sendReqToMcht(message);
				
				}
			});

		} catch (Exception e) {
			System.out.println("***Exception JmsSender.send() *** ������Ϣ�����쳣: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** ������Ϣ�����쳣: " + te.getMessage());
		}

	}
	
	
	
}
