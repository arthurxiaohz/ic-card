package cn.net.iccard.special.action;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.special.service.IPrepaidResponseService;
import cn.net.iccard.special.service.impl.NotifyService;
import cn.net.iccard.special.service.impl.PrepaidResponseService;
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

//预支付交易处理

public class PrepaidRequestAction extends BaseAction{

	private IPrepaidResponseService prepaidResponseService = (IPrepaidResponseService) SpringContextHolder
	.getBean(PrepaidResponseService.class);
	
	//接收商户请求处理
	public String getMchtRequest() throws Exception {
		

	   
		//1.取得商户请求
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
		String msg = request.getParameter("TxInfo");			//报文域
		String Signature = request.getParameter("Signature");	//报文签名
		String TxType = request.getParameter("TxType");			//交易类型
		
		  byte[] tPlainByBase64 = Base64.decode(msg);
	        msg = new String(tPlainByBase64,"UTF-8");
		
		// 解析银行回应交易结果字段
        String[] tPlainStr = StringUtil.split(msg, "|");
        Properties tBankPlain = new Properties();
        String[] tStrTemp = null;
        for (int i = 0; i < tPlainStr.length; i++) {
            tStrTemp = StringUtil.split(tPlainStr[i], "=");
            tBankPlain.setProperty(tStrTemp[0], tStrTemp[1]);
        }
      
		if(TxType.equals("TX11")){
			
			//解析txinfo
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //商户交易流水号
			String TxAmount = tBankPlain.getProperty("TxAmount");				//交易金额
			String MerchantNo = tBankPlain.getProperty("MerchantNo");			//商户代码
			String TxDate = tBankPlain.getProperty("TxDate");					//交易日期
			String TxTime = tBankPlain.getProperty("TxTime");					///交易时间
			String TxBody = tBankPlain.getProperty("TxBody");					//商品描述
			System.out.println(TxBody);
			String ShowUrl = tBankPlain.getProperty("ShowUrl");					//商品展示URL 
			String UseCoupon = tBankPlain.getProperty("UseCoupon");				//	是否使用优惠券					
			String CouponMsg = tBankPlain.getProperty("CouponMsg");					//	优惠券信息
			String NotifyURL = tBankPlain.getProperty("NotifyURL");				//交易结果通知地址
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//交易结果后台通知地址
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//扩展域
			String certID = tBankPlain.getProperty("CertID");						//商户证书ID
			//String cert = thnCertID.getProperty(certID);
			
			//1.验证商户请求报文
			
			//2.记录请求表
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//商户交易流水号
			tblTxPayMentRequest.setMchtNo(MerchantNo);				//商户号	
			tblTxPayMentRequest.setAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());				//交易金额
			tblTxPayMentRequest.setMchtTxTime(TxDate+TxTime);				//商户交易日期
			tblTxPayMentRequest.setTxTypeId(TxType);				//交易类型
			tblTxPayMentRequest.setMchtRawMessage(msg);						//原始交易报文
			tblTxPayMentRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			//tblTxPayMentRequest.setLastUpdatedBy();     	//最后修改人
			tblTxPayMentRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			tblTxPayMentRequestMgr.saveTblTxPayMentRequest(tblTxPayMentRequest);
			
			
			//3.记录订单表
			TblTxPayMentOrderManager TblTxPayMentOrderMan = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
			
			TblTxPayMentOrder TblTxPayMentOrder= new TblTxPayMentOrder();
			
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			TblTxPayMentOrder.setPlTxTraceNo(plTxTraceNo);
			TblTxPayMentOrder.setTxTypeId("TX11");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//商户交易日期
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setOrderAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//精确到分
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setShowUrl(ShowUrl);
			TblTxPayMentOrder.setTxBody(TxBody);
			TblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAY);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.保存session
			request.getSession(true).setAttribute("plTxTraceNo", plTxTraceNo);
			
		}else if(TxType.equals("TX21")){
			
			//撤销
			//解析
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //商户交易流水号
			String OrigMchtTxTraceNo = tBankPlain.getProperty("OrigMchtTxTraceNo");		//原商户交易流水号
			String TxAmount = tBankPlain.getProperty("TxAmount");						//交易金额
			String MerchantNo = tBankPlain.getProperty("MerchantNo");					//商户代码
			String OrigTxDate = tBankPlain.getProperty("OrigTxDate");					///原交易日期
			String OrigTxTime = tBankPlain.getProperty("OrigTxTime");					//原交易时间
			String TxDate = tBankPlain.getProperty("TxDate");							//交易日期
			String TxTime = tBankPlain.getProperty("TxTime");							//交易时间				
			String NotifyURL = tBankPlain.getProperty("NotifyURL");					//	交易结果通知地址
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//交易结果后台通知地址
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//扩展域
			String certID = tBankPlain.getProperty("CertID");						//商户证书ID
			//校验
			//记录
			//2.记录请求表
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//商户交易流水号
			tblTxPayMentRequest.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
			tblTxPayMentRequest.setMchtNo(MerchantNo);				//商户号	
			tblTxPayMentRequest.setAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());				//交易金额
			tblTxPayMentRequest.setMchtTxTime(TxDate+TxTime);				//商户交易日期
			tblTxPayMentRequest.setTxTypeId(TxType);				//交易类型
			tblTxPayMentRequest.setMchtRawMessage(msg);						//原始交易报文
			tblTxPayMentRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			//tblTxPayMentRequest.setLastUpdatedBy();     	//最后修改人
			tblTxPayMentRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			tblTxPayMentRequestMgr.saveTblTxPayMentRequest(tblTxPayMentRequest);
			
			//查询原交易是否存在
			
			
			//3.记录订单表
			TblTxPayMentOrderManager TblTxPayMentOrderMan = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
			
			TblTxPayMentOrder TblTxPayMentOrder= new TblTxPayMentOrder();
			
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			TblTxPayMentOrder.setPlTxTraceNo(plTxTraceNo);
			TblTxPayMentOrder.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
			TblTxPayMentOrder.setLastMchtTxTime(OrigTxDate+OrigTxTime);
			TblTxPayMentOrder.setTxTypeId("TX21");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//商户交易日期
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setOrderAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//精确到分
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_WAITREVOCATION);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.保存session
			request.getSession(true).setAttribute("plTxTraceNo", plTxTraceNo);
		}else if(TxType.equals("TX23")){
			
			//退款
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //商户交易流水号
			String OrigMchtTxTraceNo = tBankPlain.getProperty("OrigMchtTxTraceNo");		//原商户交易流水号
			String TxAmount = tBankPlain.getProperty("TxAmount");						//交易金额
			String MerchantNo = tBankPlain.getProperty("MerchantNo");					//商户代码
			String OrigTxDate = tBankPlain.getProperty("OrigTxDate");					///原交易日期
			String OrigTxTime = tBankPlain.getProperty("OrigTxTime");					//原交易时间
			String TxDate = tBankPlain.getProperty("TxDate");							//交易日期
			String TxTime = tBankPlain.getProperty("TxTime");							//交易时间				
			String NotifyURL = tBankPlain.getProperty("NotifyURL");					//	交易结果通知地址
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//交易结果后台通知地址
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//扩展域
			String certID = tBankPlain.getProperty("CertID");						//商户证书ID
			
			//2.记录请求表
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//商户交易流水号
			tblTxPayMentRequest.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
			tblTxPayMentRequest.setMchtNo(MerchantNo);				//商户号	
			tblTxPayMentRequest.setAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());				//交易金额
			tblTxPayMentRequest.setMchtTxTime(TxDate+TxTime);				//商户交易日期
			tblTxPayMentRequest.setTxTypeId(TxType);				//交易类型
			tblTxPayMentRequest.setMchtRawMessage(msg);						//原始交易报文
			tblTxPayMentRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			//tblTxPayMentRequest.setLastUpdatedBy();     	//最后修改人
			tblTxPayMentRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			tblTxPayMentRequestMgr.saveTblTxPayMentRequest(tblTxPayMentRequest);
			
			
			//3.记录订单表
			TblTxPayMentOrderManager TblTxPayMentOrderMan = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
			
			TblTxPayMentOrder TblTxPayMentOrder= new TblTxPayMentOrder();
			
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			TblTxPayMentOrder.setPlTxTraceNo(plTxTraceNo);
			TblTxPayMentOrder.setTxTypeId("TX23");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			TblTxPayMentOrder.setMchtTxTime(TxDate+TxTime);				//商户交易日期
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setOrderAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//精确到分
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setLastMchtTxTraceNo(OrigMchtTxTraceNo);
			TblTxPayMentOrder.setLastMchtTxTime(OrigTxDate+OrigTxTime);
			TblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_WAITBACK);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.保存session
			request.getSession(true).setAttribute("id", TblTxPayMentOrder.getId());
		}
		return SUCCESS;
		
	}
	
//	//预支付 确认
//	public String upfrontCostAffirm() throws Exception {
//		
//		//1.取得请求信息
//		HttpServletRequest request = getRequest();
//		
//		HttpServletResponse response = getResponse();
//		
//		
//		//getRecvMap(request);
//		//修改对应交易记录状态    
//		//先查询支付订单表
//		
//		System.out.println(request.getParameter("orderId"));
//		TblTxPayMentOrderManager tblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
//		TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder) tblTxPayMentOrderManagerImpl.getObjectById(request.getParameter("orderId"));
//		
//		//更新支付订单表
//		String PlTxTime = DateTimeUtil.getCurrDateTime();
//		if(tblTxPayMentOrder.getTxStatus()==OrderTxStatus.ORDERTXSTATUS_PREPAY){
//			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAYSUCCESS);
//			tblTxPayMentOrder.setErrorCode("0001");		//预支付成功
//		}else{
//			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PAYSUCCESS);
//			tblTxPayMentOrder.setErrorCode("0002");		//付成功
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
//		//组装返回
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
//		//记录商户响应信息表
//		 TblTxPayMentResponseManager  tblTxPayMentResponseMan = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
//			
//		 TblTxPayMentResponse  tblTxPayMentResponse= new  TblTxPayMentResponse();
//			
//			//String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
//			tblTxPayMentResponse.setTxTypeId(tblTxPayMentOrder.getTxTypeId());
//			tblTxPayMentResponse.setMchtNo(tblTxPayMentOrder.getMchtNo());
//			tblTxPayMentResponse.setPayDatetime(tblTxPayMentOrder.getPlTxTime());				//商户交易日期
//			tblTxPayMentResponse.setMerchantOrderNo(tblTxPayMentOrder.getMchtTxTraceNo());
//			tblTxPayMentResponse.setOrderAmount(new BigDecimal(tblTxPayMentOrder.getOrderAmount()).movePointLeft(2).intValue());		//精确到分
//
//			tblTxPayMentResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
//			tblTxPayMentResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
//			
//			tblTxPayMentResponseMan.saveTblTxPayMentResponse(tblTxPayMentResponse);
//		 
//		 //记录支付结果通知表并通知商户
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
//			// 取得组织银行报文的银行服务类
//			BankComService tBankCom = new BankComService();
//			
//			tInputParams.setProperty("Version", "V1.0");
//		    tInputParams.setProperty("TxType", tblTxPayMentOrder.getTxTypeId());
//		    tInputParams.setProperty("TxInfo",sendMsg);
//		    tInputParams.setProperty("Signature","");			//TODO 签名
//	        // 组成没有name属性,没有ID属性的form表单
//	        StringBuffer tFormBuffer = tBankCom.buildForm(tblTxPayMentOrder.getNotifyUrl(), tInputParams);
//			
//			//将浏览器导向商户接收交易结果地址
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
	//记录短信信息，并发送
	public void saveSms(String id,String phoneNo) throws Exception {
		
		//先查询支付订单表

		TblTxPayMentOrderManager TblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrderManager.class);
		TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder)TblTxPayMentOrderManagerImpl.getObjectById(id);
		
		//更新支付订单表
		//tblTxPayMentOrder.setTxStatus(2);
		tblTxPayMentOrder.setPayerPhone(phoneNo);
		tblTxPayMentOrder.setVerifyCode(SmsCodeGenerator.getInstance().getRandomSmsCode(6));
		tblTxPayMentOrder.setConfirmCode(SmsCodeGenerator.getInstance().getRandomSmsCode(10));
		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		
		//记录短信发送日志表
		String message = NoteMessage.createSmsMessage(tblTxPayMentOrder);
		
		TblTxSmsLogManager tblTxSmsLogMan = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		
		TblTxSmsLog tblTxSmsLog= new TblTxSmsLog();
		
		tblTxSmsLog.setSeqNo(tblTxPayMentOrder.getPlTxTraceNo());
		tblTxSmsLog.setPhoneNum(phoneNo);
		tblTxSmsLog.setPhoneMessage(message);
		
		tblTxSmsLog.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
		tblTxSmsLog.setLastUpdatedDdatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
		
		tblTxSmsLogMan.saveTblTxSmsLog(tblTxSmsLog);
		
		//发送到短信平台
		SmsBean smsBean = new SmsBean();
		smsBean.setPhoneNo(phoneNo);
		smsBean.setSmsContent(message);
			
		NotifyService.send(smsBean);
		
	}
	
	/**
	 * 预支付确认
	 */
	public String savePrepaid() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		
		prepaidResponseService.savePrepaidResponse(request, response);
		
		return returnCommand();
	}
	
}
