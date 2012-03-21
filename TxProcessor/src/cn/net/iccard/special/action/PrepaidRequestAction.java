package cn.net.iccard.special.action;


import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;
import cn.net.iccard.special.service.IPrepaidResponseService;
import cn.net.iccard.special.service.impl.NotifyService;
import cn.net.iccard.special.service.impl.PrepaidResponseService;
import cn.net.iccard.special.validator.StandardCheck;
import cn.net.iccard.tx.model.OrderTxStatus;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.model.TblTxSmsLog;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;
import cn.net.iccard.tx.service.TblTxSmsLogManager;
import cn.net.iccard.util.Base64;
import cn.net.iccard.util.NoteMessage;
import cn.net.iccard.util.PLTraceNoGererator;
import cn.net.iccard.util.SmsBean;
import cn.net.iccard.util.SmsCodeGenerator;
import cn.net.iccard.util.StringUtil;

//Ԥ֧�����״���

public class PrepaidRequestAction extends BaseAction{

	private IPrepaidResponseService prepaidResponseService = (IPrepaidResponseService) SpringContextHolder
	.getBean(PrepaidResponseService.class);
	
	TblMchtInfoManager  tblMchtInfoMan = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
	
	TblTxPayMentOrderManager tblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
	
	public static final String Key = "1234567890";
	
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
		
	    String md5Msg =  msg+"|Key="+Key;
	    String sendMsg1 = Base64.encode(md5Msg.getBytes("UTF-8"));
	    String SignaturePl = MD5Encode(sendMsg1.toString());
	    
	    if(!SignaturePl.equals(Signature)){
	    	request.setAttribute("error", "��ǩʧ��");
	    }
	        
	    System.out.println(msg);
		// �������л�Ӧ���׽���ֶ�
        String[] tPlainStr = StringUtil.split(msg, "|");
        Properties tBankPlain = new Properties();
        String[] tStrTemp = null;
        for (int i = 0; i < tPlainStr.length; i++) {
        	System.out.println(tPlainStr[i]);
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
			//1.1��֤���ĸ�ʽ
			//1.1.1У�齻�׽��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxAmount, 2);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "���׽���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
		
			//1.1.2У�齻������
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxDate, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�������ڸ�ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.3У�齻��ʱ��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxTime, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.2��֤��������
			//1.2.1 У���̻���
			TblMchtInfo tblmchtinfo = null;
			try{
				 tblmchtinfo = StandardCheck.isMcht(MerchantNo, tblMchtInfoMan);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�̻��Ŵ�������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.2.2У���̻������Ƿ��ظ�
			try{
				 List<TblTxPayMentOrder> list = StandardCheck.isOrderNo(MerchantNo, MchtTxTraceNo, TxDate+TxTime, tblTxPayMentOrderManagerImpl);
				 if(list.size() > 0 ){
					 throw new Exception("trace no is error");
				 }
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "��ˮ�Ŵ�������ϵ�̻�");
				return SUCCESS;
			}
			
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
			TblTxPayMentOrder.setMchtName(tblmchtinfo.getMchtName());
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//�̻���������
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setOrderAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//��ȷ����
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setShowUrl(ShowUrl);
			TblTxPayMentOrder.setTxBody(TxBody);
			TblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAY);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.����session
			request.getSession(true).setAttribute("id", TblTxPayMentOrder.getId());
			
		}else if(TxType.equals("TX21")){
			
			//����
			//����
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //�̻�������ˮ��
			String OrigMchtTxTraceNo = tBankPlain.getProperty("OrigMchtTxTraceNo");		//ԭ�̻�������ˮ��
			String TxAmount = tBankPlain.getProperty("TxAmount");						//���׽��
			String MerchantNo = tBankPlain.getProperty("MerchantNo");					//�̻�����
			String OrigTxDate = tBankPlain.getProperty("OrigTxDate");					///ԭ��������
			String OrigTxTime = tBankPlain.getProperty("OrigTxTime");					//ԭ����ʱ��
			String TxDate = tBankPlain.getProperty("TxDate");							//��������
			String TxTime = tBankPlain.getProperty("TxTime");							//����ʱ��				
			String NotifyURL = tBankPlain.getProperty("NotifyURL");					//	���׽��֪ͨ��ַ
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//���׽����̨֪ͨ��ַ
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//��չ��
			String certID = tBankPlain.getProperty("CertID");						//�̻�֤��ID
			//У��
			
			//1.��֤�̻�������
			//1.1��֤���ĸ�ʽ
			//1.1.1У�齻�׽��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxAmount, 2);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "���׽���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
		
			//1.1.2У�齻������
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxDate, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�������ڸ�ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.3У�齻��ʱ��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxTime, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.4У��ԭ��������
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, OrigTxDate, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�������ڸ�ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.5У��ԭ����ʱ��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, OrigTxTime, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.6ԭ����ʱ�䲻���뽻��ʱ����ͬ
			try{
				if((TxDate+TxTime).equals(OrigTxDate+OrigTxTime)){
					throw new Exception("date is error");
				}
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.2��֤��������
			//1.2.1 У���̻���
			TblMchtInfo tblmchtinfo = null;
			try{
				 tblmchtinfo = StandardCheck.isMcht(MerchantNo, tblMchtInfoMan);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�̻��Ŵ�������ϵ�̻�");
				return SUCCESS;
			}
			 int mchtAmount = new BigDecimal(TxAmount).movePointRight(2).intValue();
			 int oldAmount = 0;
			
			//1.2.2У���̻������Ƿ��ظ�
			try{
				  List<TblTxPayMentOrder> list = StandardCheck.isOrderNo(MerchantNo, MchtTxTraceNo, TxDate+TxTime, tblTxPayMentOrderManagerImpl);
				 if(list.size() >0 ){
					 throw new Exception("trace no is error");
				 }
				 
				 List<TblTxPayMentOrder>  oldlist  =  StandardCheck.isOrderNo(MerchantNo, OrigMchtTxTraceNo, OrigTxDate+OrigTxTime, tblTxPayMentOrderManagerImpl);
				 if(oldlist.size() != 1 ){
					 throw new Exception("trace no is error");
				 }
				 TblTxPayMentOrder oldOrder =  (TblTxPayMentOrder)oldlist.get(0);
				 
				 oldAmount = oldOrder.getOrderAmount();
				 
				 //���ԭ����״̬��ΪԤ֧���ɹ���Ƿ�
				 if(oldOrder.getTxStatus()!=OrderTxStatus.ORDERTXSTATUS_PREPAYSUCCESS){
					 request.setAttribute("error", "��ǰ����״̬��������������ϵ�̻�");
						return SUCCESS;
				 }
				 
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "��ˮ�Ŵ�������ϵ�̻�");
				return SUCCESS;
			}
			
			if(mchtAmount!=oldAmount){
				request.setAttribute("error", "���������ԭ������һ�£�����ϵ�̻�");
				return SUCCESS;
			}
			
			//��¼
			//2.��¼�����
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//�̻�������ˮ��
			tblTxPayMentRequest.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
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
			TblTxPayMentOrder.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
			TblTxPayMentOrder.setLastMchtTxTime(OrigTxDate+OrigTxTime);
			TblTxPayMentOrder.setTxTypeId("TX21");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			TblTxPayMentOrder.setMchtName(tblmchtinfo.getMchtName());
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//�̻���������
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setOrderAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//��ȷ����
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_WAITREVOCATION);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.����session
			request.getSession(true).setAttribute("id", TblTxPayMentOrder.getId());
		}else if(TxType.equals("TX23")){
			
			//�˿�
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //�̻�������ˮ��
			String OrigMchtTxTraceNo = tBankPlain.getProperty("OrigMchtTxTraceNo");		//ԭ�̻�������ˮ��
			String TxAmount = tBankPlain.getProperty("TxAmount");						//���׽��
			String MerchantNo = tBankPlain.getProperty("MerchantNo");					//�̻�����
			String OrigTxDate = tBankPlain.getProperty("OrigTxDate");					///ԭ��������
			String OrigTxTime = tBankPlain.getProperty("OrigTxTime");					//ԭ����ʱ��
			String TxDate = tBankPlain.getProperty("TxDate");							//��������
			String TxTime = tBankPlain.getProperty("TxTime");							//����ʱ��				
			String NotifyURL = tBankPlain.getProperty("NotifyURL");					//	���׽��֪ͨ��ַ
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//���׽����̨֪ͨ��ַ
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//��չ��
			String certID = tBankPlain.getProperty("CertID");						//�̻�֤��ID
			
			//1.��֤�̻�������
			//1.1��֤���ĸ�ʽ
			//1.1.1У�齻�׽��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxAmount, 2);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "���׽���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
		
			//1.1.2У�齻������
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxDate, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�������ڸ�ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.3У�齻��ʱ��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, TxTime, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.4У��ԭ��������
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, OrigTxDate, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�������ڸ�ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.5У��ԭ����ʱ��
			try{
				StandardCheck.isNumer(StandardCheck.orderAmountPattern, OrigTxTime, 0);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.1.6ԭ����ʱ�䲻���뽻��ʱ����ͬ
			try{
				if((TxDate+TxTime).equals(OrigTxDate+OrigTxTime)){
					throw new Exception("date is error");
				}
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "����ʱ���ʽ��������ϵ�̻�");
				return SUCCESS;
			}
			
			//1.2��֤��������
			//1.2.1 У���̻���
			TblMchtInfo tblmchtinfo = null;
			try{
				 tblmchtinfo = StandardCheck.isMcht(MerchantNo, tblMchtInfoMan);
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "�̻��Ŵ�������ϵ�̻�");
				return SUCCESS;
			}
			 int mchtAmount = new BigDecimal(TxAmount).movePointRight(2).intValue();
			 int oldAmount = 0;
			
			//1.2.2У���̻������Ƿ��ظ�
			try{
				  List<TblTxPayMentOrder> list = StandardCheck.isOrderNo(MerchantNo, MchtTxTraceNo, TxDate+TxTime, tblTxPayMentOrderManagerImpl);
				 if(list.size() >0 ){
					 throw new Exception("trace no is error");
				 }
				 
				 List<TblTxPayMentOrder>  oldlist  =  StandardCheck.isOrderNo(MerchantNo, OrigMchtTxTraceNo, OrigTxDate+OrigTxTime, tblTxPayMentOrderManagerImpl);
				 if(oldlist.size() != 1 ){
					 throw new Exception("trace no is error");
				 }
				 TblTxPayMentOrder oldOrder =  (TblTxPayMentOrder)oldlist.get(0);
				 
				 oldAmount = oldOrder.getOrderAmount();
				 
				 //���ԭ����״̬Ϊ��Ϊȷ��֧����Ƿ�
				 if(oldOrder.getTxStatus()!=OrderTxStatus.ORDERTXSTATUS_PAYSUCCESS){
					 request.setAttribute("error", "��ǰ����״̬�������˿����ϵ�̻�");
						return SUCCESS;
				 }
			}catch(Exception e){
				System.out.println(e);
				request.setAttribute("error", "��ˮ�Ŵ�������ϵ�̻�");
				return SUCCESS;
			}
			
			if(mchtAmount!=oldAmount){
				request.setAttribute("error", "�˿�����ԭ������һ�£�����ϵ�̻�");
				return SUCCESS;
			}
			
			//2.��¼�����
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//�̻�������ˮ��
			tblTxPayMentRequest.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
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
			TblTxPayMentOrder.setTxTypeId("TX23");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			TblTxPayMentOrder.setMchtName(tblmchtinfo.getMchtName());
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//�̻���������
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setOrderAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//��ȷ����
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
			TblTxPayMentOrder.setLastMchtTxTime(OrigTxDate+OrigTxTime);
			TblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_WAITBACK);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.����session
			request.getSession(true).setAttribute("id", TblTxPayMentOrder.getId());
		}
		return SUCCESS;
		
	}
	
//	//Ԥ֧�� ȷ��
//	public String upfrontCostAffirm() throws Exception {
//		
//		//1.ȡ��������Ϣ
//		HttpServletRequest request = getRequest();
//		
//		HttpServletResponse response = getResponse();
//		
//		
//		//getRecvMap(request);
//		//�޸Ķ�Ӧ���׼�¼״̬    
//		//�Ȳ�ѯ֧��������
//		
//		System.out.println(request.getParameter("orderId"));
//		TblTxPayMentOrderManager tblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
//		TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder) tblTxPayMentOrderManagerImpl.getObjectById(request.getParameter("orderId"));
//		
//		//����֧��������
//		String PlTxTime = DateTimeUtil.getCurrDateTime();
//		if(tblTxPayMentOrder.getTxStatus()==OrderTxStatus.ORDERTXSTATUS_PREPAY){
//			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAYSUCCESS);
//			tblTxPayMentOrder.setErrorCode("0001");		//Ԥ֧���ɹ�
//		}else{
//			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PAYSUCCESS);
//			tblTxPayMentOrder.setErrorCode("0002");		//���ɹ�
//		}
//		
//		tblTxPayMentOrder.setPlTxTime(PlTxTime);
//		
//		
//		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
//		tblTxPayMentOrder.setLastUpdatedBy(UserContextHelper.getUser().getId());
//		
//		tblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(tblTxPayMentOrder);
//		
//		//��װ����
//		 StringBuffer tPlain = new StringBuffer(400);
//		 tPlain.append("PlTxTraceNo="+tblTxPayMentOrder.getPlTxTraceNo()+"|"+
//					"MchtTxTraceNo=" +tblTxPayMentOrder.getMchtTxTraceNo()+"|" +
//					"MerchantNo=" + tblTxPayMentOrder.getMchtNo()+"|" +
//					"PlTxDate=" + PlTxTime.substring(0, 8)+"|" +
//					"PlTxTime=" + PlTxTime.substring(8, 14)+"|" +
//					"TxDate=" + tblTxPayMentOrder.getMchtTxTime().substring(0, 8)+"|" +
//					"TxTime=" + tblTxPayMentOrder.getMchtTxTime().substring(8,12)+"|" +
//					"ResponseCode="+tblTxPayMentOrder.getErrorCode()+"|" +
//					"TxAmount="+new BigDecimal(tblTxPayMentOrder.getOrderAmount()).movePointLeft(2));
//		
//		 
//		 String sendMsg = Base64.encode(tPlain.toString().getBytes("UTF-8"));
//		 
//		//��¼�̻���Ӧ��Ϣ��
//		 TblTxPayMentResponseManager  tblTxPayMentResponseMan = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
//			
//		 TblTxPayMentResponse  tblTxPayMentResponse= new  TblTxPayMentResponse();
//			
//			//String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
//			tblTxPayMentResponse.setTxTypeId(tblTxPayMentOrder.getTxTypeId());
//			tblTxPayMentResponse.setMchtNo(tblTxPayMentOrder.getMchtNo());
//			tblTxPayMentResponse.setPayDatetime(tblTxPayMentOrder.getPlTxTime());				//�̻���������
//			tblTxPayMentResponse.setMerchantOrderNo(tblTxPayMentOrder.getMchtTxTraceNo());
//			tblTxPayMentResponse.setOrderAmount(new BigDecimal(tblTxPayMentOrder.getOrderAmount()).movePointLeft(2).intValue());		//��ȷ����
//
//			tblTxPayMentResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
//			tblTxPayMentResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
//			
//			tblTxPayMentResponseMan.saveTblTxPayMentResponse(tblTxPayMentResponse);
//		 
//		 //��¼֧�����֪ͨ��֪ͨ�̻�
//		if(tblTxPayMentOrder.getBgNotifyUrl()!= null &&!tblTxPayMentOrder.getBgNotifyUrl().equals("")){
//		
//			NotifyBean notifyBean = new NotifyBean();
//			notifyBean.setMchtTxURL(tblTxPayMentOrder.getBgNotifyUrl());
//			notifyBean.setSendMsg(sendMsg);
//			notifyBean.setSignature("");
//			notifyBean.setTxType(tblTxPayMentOrder.getTxTypeId());
//			NotifyService.send(notifyBean);
//		 
//		}
//		
//		if(tblTxPayMentOrder.getNotifyUrl()!= null &&!tblTxPayMentOrder.getNotifyUrl().equals("")){
//			
//			Properties tInputParams = new Properties();
//			
//			// ȡ����֯���б��ĵ����з�����
//			BankComService tBankCom = new BankComService();
//			
//			tInputParams.setProperty("Version", "V1.0");
//		    tInputParams.setProperty("TxType", tblTxPayMentOrder.getTxTypeId());
//		    tInputParams.setProperty("TxInfo",sendMsg);
//		    tInputParams.setProperty("Signature","");			//TODO ǩ��
//	        // ���û��name����,û��ID���Ե�form��
//	        StringBuffer tFormBuffer = tBankCom.buildForm(tblTxPayMentOrder.getNotifyUrl(), tInputParams);
//			
//			//������������̻����ս��׽����ַ
//	        NotifyService.redirect(response , tblTxPayMentOrder.getNotifyUrl() , tFormBuffer.toString());	
//		}
//		
//		return SUCCESS;
//		}

//	protected Map<String, String> getRecvMap(final HttpServletRequest request) {
//		Map<String, String> receiverMap = request.getParameterMap();
//		Map<String, String> resultMap = new HashMap<String, String>();
//		Iterator<String> it = receiverMap.keySet().iterator();
//		StringBuffer stf = new StringBuffer();
//		stf.append("\n =============== request map start ====");
//		while (it.hasNext()) {
//			String key = it.next();
//			Object value = receiverMap.get(key);
//			if (value instanceof String[]) {
//				String temp = ((String[]) value)[0];
//				resultMap.put(key, temp);
//				
//				stf.append("\n " + key + "	=" + temp);
//			}
//		}
//		stf.append("\n =============== request map end =======\n");
//		System.out.println(stf.toString());
//		return resultMap;
//	}
	//��¼������Ϣ��������
	public void saveSms(String id,String phoneNo) throws Exception {
		
		//�Ȳ�ѯ֧��������

		TblTxPayMentOrderManager TblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrderManager.class);
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
			
		NotifyService.send(smsBean);
		
	}
	
	/**
	 * Ԥ֧��ȷ��
	 */
	public String savePrepaid() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		
		try{
			String return1  = prepaidResponseService.savePrepaidResponse(request, response);
		}catch(Exception e){
			//e.getMessage();
			return returnCommand(e.getMessage());
		}
		return returnCommand();
	}
	
	
	public static String MD5Encode(String aData) throws SecurityException {
		String resultString = null;
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = bytes2HexString(md.digest(aData.getBytes("UTF-8")));
        } catch (Exception e) {
        	e.printStackTrace();
			throw new SecurityException("MD5����ʧ��");
        }
        return resultString;
	}
        
        public static String bytes2HexString(byte[] b) {
    		String ret = "";
    		for (int i = 0; i < b.length; i++) {
    			String hex = Integer.toHexString(b[i] & 0xFF);
    			if (hex.length() == 1) {
    				hex = '0' + hex;
    			}
    			ret += hex.toUpperCase();
    		}
    		return ret;
    	}
}
