package cn.net.iccard.tx.action.special;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
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
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import cn.net.iccard.tx.model.TblTxSmsLog;
import cn.net.iccard.tx.model.special.ThreadPool;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;
import cn.net.iccard.tx.service.TblTxSmsLogManager;
import cn.net.iccard.tx.service.impl.TblTxPayMentOrderManagerImpl;
import cn.net.iccard.tx.service.impl.TblTxPayMentRequestManagerImpl;
import cn.net.iccard.util.BankComService;
import cn.net.iccard.util.Base64;
import cn.net.iccard.util.ConnectionUtil;
import cn.net.iccard.util.DateTimeUtil;
import cn.net.iccard.util.NoteMessage;
import cn.net.iccard.util.NotifyBean;
import cn.net.iccard.util.PLTraceNoGererator;
import cn.net.iccard.util.SmsBean;
import cn.net.iccard.util.SmsCodeGenerator;
import cn.net.iccard.util.StringUtil;

//Ԥ֧�����״���

public class PrepaidRequestAction extends BaseAction{

	public static ThreadPoolTaskExecutor threadPool4Monitor;
	// ================================================================================================================================
	// ����ĳ������������û�ҳ���ض���
	// Htmlͷ
	public static final String sHTMLS = "<html><head></head><body OnLoad=\"OnLoadEvent();\" >";
	// ��һ��Form������������ҳ���������ʾ��Ϣ
	public static final String sFORM1S = "<form name='processing' >";
	public static final String sFORM1E = "</form>";
	// �ڶ���Form���ύ��������
	// //Formͷ
	public static final String sFORM2S1 = "<form name=\"downloadForm\" action=\"";
	public static final String sFORM2S2 = "\" method=\"POST\">";
	// //������
	public static final String sINPUT1 = "  <input type=\"hidden\" name=\"";
	public static final String sINPUT2 = "\" value=\"";
	public static final String sINPUT3 = "\">";
	// //Formβ
	public static final String sFORM2E = "</form>";
	// JavaScript�ű�
	public static final String sSCRIPT = "<SCRIPT LANGUAGE=\"Javascript\"> function OnLoadEvent(){ document.downloadForm.submit(); } </SCRIPT>";
	// Htmlβ
	public static final String sHTMLE = "</body></html>";
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
			tblTxPayMentRequest.setAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());				//���׽��
			tblTxPayMentRequest.setMchtTxTime(TxDate+TxTime);				//�̻���������
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
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//�̻���������
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setTxAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//��ȷ����
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setShowUrl(ShowUrl);
			TblTxPayMentOrder.setTxBody(TxBody);
			TblTxPayMentOrder.setTxStatus(1);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.����session
			request.getSession(true).setAttribute("plTxTraceNo", plTxTraceNo);
			
		}
		return SUCCESS;
		
	}
	
	//Ԥ֧�� ȷ��
	public String upfrontCostAffirm() throws Exception {
		
		//1.ȡ��������Ϣ
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		//�޸Ķ�Ӧ���׼�¼״̬    
		//�Ȳ�ѯ֧��������

		Filter filter = FilterFactory.getSimpleFilter("mchtTxTraceNo",request.getParameter("plTxTraceNo"), Filter.OPERATOR_EQ);
		
		//Filter Filter = PageInfoUtil.populateFilter(tblTxPayMentOrderPageInfo);
		System.out.println(filter);
		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		List list  = TblTxPayMentOrderManagerImpl.getObjects(TblTxPayMentOrder.class,filter);
		
		//����֧��������
		String PlTxTime = DateTimeUtil.getCurrDateTime();
		TblTxPayMentOrder TblTxPayMentOrder = (TblTxPayMentOrder)list.get(0);
		TblTxPayMentOrder.setTxStatus(2);
		TblTxPayMentOrder.setPlTxTime(PlTxTime);
		TblTxPayMentOrder.setErrorCode("0000");
		TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		TblTxPayMentOrder.setLastUpdatedBy(Integer.valueOf(request.getParameter("username")));
		
		TblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(TblTxPayMentOrder);
		
		//��װ����
		 StringBuffer tPlain = new StringBuffer(400);
		 tPlain.append("PlTxTraceNo="+TblTxPayMentOrder.getPlTxTraceNo()+"|"+
					"MchtTxTraceNo=" +TblTxPayMentOrder.getMchtTxTraceNo()+"|" +
					"MerchantNo=" + TblTxPayMentOrder.getMchtNo()+"|" +
					"PlTxDate=" + PlTxTime.substring(0, 8)+"|" +
					"PlTxTime=" + PlTxTime.substring(8, 14)+"|" +
					"TxDate=" + TblTxPayMentOrder.getMchtTxTime().substring(0, 8)+"|" +
					"TxTime=" + TblTxPayMentOrder.getMchtTxTime().substring(8,12)+"|" +
					"ResponseCode="+TblTxPayMentOrder.getErrorCode()+"|" +
					"TxAmount="+new BigDecimal(TblTxPayMentOrder.getTxAmount()).movePointLeft(2));
		
		 
		 String sendMsg = Base64.encode(tPlain.toString().getBytes("UTF-8"));
		 
		//��¼�̻���Ӧ��Ϣ��
		 TblTxPayMentResponseManager  tblTxPayMentResponseMan = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
			
		 TblTxPayMentResponse  tblTxPayMentResponse= new  TblTxPayMentResponse();
			
			//String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			tblTxPayMentResponse.setTxTypeId(TblTxPayMentOrder.getTxTypeId());
			tblTxPayMentResponse.setMchtNo(TblTxPayMentOrder.getMchtNo());
			tblTxPayMentResponse.setPayDatetime(TblTxPayMentOrder.getPlTxTime());				//�̻���������
			tblTxPayMentResponse.setMerchantOrderNo(TblTxPayMentOrder.getMchtTxTraceNo());
			tblTxPayMentResponse.setOrderAmount(new BigDecimal(TblTxPayMentOrder.getTxAmount()).movePointLeft(2).intValue());		//��ȷ����

			tblTxPayMentResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			tblTxPayMentResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			tblTxPayMentResponseMan.saveTblTxPayMentResponse(tblTxPayMentResponse);
		 
		 //��¼֧�����֪ͨ��֪ͨ�̻�
		if(TblTxPayMentOrder.getBgNotifyUrl()!= null &&!TblTxPayMentOrder.getBgNotifyUrl().equals("")){
		
			NotifyBean notifyBean = new NotifyBean();
			notifyBean.setMchtTxURL(TblTxPayMentOrder.getBgNotifyUrl());
			notifyBean.setSendMsg(sendMsg);
			notifyBean.setSignature("");
			notifyBean.setTxType(TblTxPayMentOrder.getTxTypeId());
			send(notifyBean);
		 
		}
		
		if(TblTxPayMentOrder.getNotifyUrl()!= null &&!TblTxPayMentOrder.getNotifyUrl().equals("")){
			
			Properties tInputParams = new Properties();
			
			// ȡ����֯���б��ĵ����з�����
			BankComService tBankCom = new BankComService();
			
			tInputParams.setProperty("Version", "V1.0");
		    tInputParams.setProperty("TxType", TblTxPayMentOrder.getTxTypeId());
		    tInputParams.setProperty("TxInfo",sendMsg);
		    tInputParams.setProperty("Signature","");			//TODO ǩ��
	        // ���û��name����,û��ID���Ե�form��
	        StringBuffer tFormBuffer = tBankCom.buildForm(TblTxPayMentOrder.getNotifyUrl(), tInputParams);
			
			//������������̻����ս��׽����ַ
			redirect(response , TblTxPayMentOrder.getNotifyUrl() , tFormBuffer.toString());	
		}
		
		return SUCCESS;
		}

	
	//��¼������Ϣ��������
	public void saveSms(String id,String phoneNo) throws Exception {
		
		//�Ȳ�ѯ֧��������

		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder)TblTxPayMentOrderManagerImpl.getObjectById(id);
		
		//����֧��������
		//tblTxPayMentOrder.setTxStatus(2);
		tblTxPayMentOrder.setPayerPhone(phoneNo);
		tblTxPayMentOrder.setVerifyCode(SmsCodeGenerator.getInstance().getRandomSmsCode(6));
		tblTxPayMentOrder.setConfirmCode(SmsCodeGenerator.getInstance().getRandomSmsCode(10));
		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		
		//��¼���ŷ�����־��
		String message = NoteMessage.createSmsMessage(tblTxPayMentOrder);
		
		TblTxSmsLogManager tblTxSmsLogMan = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		
		TblTxSmsLog tblTxSmsLog= new TblTxSmsLog();
		
		tblTxSmsLog.setSeqNo(tblTxPayMentOrder.getPlTxTraceNo());
		tblTxSmsLog.setPhoneNum(phoneNo);
		tblTxSmsLog.setPhoneMessage(message);
		
		tblTxSmsLog.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
		tblTxSmsLog.setLastUpdatedDdatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
		
		tblTxSmsLogMan.saveTblTxSmsLog(tblTxSmsLog);
		
		//���͵�����ƽ̨
		SmsBean smsBean = new SmsBean();
		smsBean.setPhoneNo(phoneNo);
		smsBean.setSmsContent(message);
			
		send(smsBean);
		
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
	
	/**
	 * ������Ϣ
	 * 
	 * @param message
	 */
	public static void send(final SmsBean message) {

		try {
			threadPool4Monitor.execute(new Runnable() {
				public void run() {

					NoteMessage.sendShortMessage(message);
				
				}
			});

		} catch (Exception e) {
			System.out.println("***Exception JmsSender.send() *** ������Ϣ�����쳣: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** ������Ϣ�����쳣: " + te.getMessage());
		}

	}
	
	/**
	 * ���û�ҳ���ض����̻����ս��׽����ַ
	 * 
	 * @param res
	 * @param url
	 *            �ض����URL
	 * @param params
	 *            �ض�������Ҫ�Ĳ���
	 * 
	 * @throws IOException
	 */
	protected void redirect(HttpServletResponse res, String url, String form)
			throws IOException {

		res.setContentType("UTF-8");
		ServletOutputStream out = res.getOutputStream();

		StringBuffer resBuff = new StringBuffer();

		// Htmlͷ
		resBuff.append(sHTMLS);

		// Form����
		resBuff.append(sFORM1S).append(sFORM1E).append(sFORM2S1).append(url)
				.append(sFORM2S2).append(form);

		// JavaScript
		resBuff.append(sFORM2E).append(sSCRIPT).append(sHTMLE);

		out.write(resBuff.toString().getBytes("UTF-8"));
		out.flush();
		out.close();

	}
	
}
