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

//预支付交易处理

public class PrepaidRequestAction extends BaseAction{

	public static ThreadPoolTaskExecutor threadPool4Monitor;
	// ================================================================================================================================
	// 下面的常量设置用于用户页面重定向
	// Html头
	public static final String sHTMLS = "<html><head></head><body OnLoad=\"OnLoadEvent();\" >";
	// 第一个Form，将来可以在页面中添加提示信息
	public static final String sFORM1S = "<form name='processing' >";
	public static final String sFORM1E = "</form>";
	// 第二个Form，提交请求数据
	// //Form头
	public static final String sFORM2S1 = "<form name=\"downloadForm\" action=\"";
	public static final String sFORM2S2 = "\" method=\"POST\">";
	// //隐藏域
	public static final String sINPUT1 = "  <input type=\"hidden\" name=\"";
	public static final String sINPUT2 = "\" value=\"";
	public static final String sINPUT3 = "\">";
	// //Form尾
	public static final String sFORM2E = "</form>";
	// JavaScript脚本
	public static final String sSCRIPT = "<SCRIPT LANGUAGE=\"Javascript\"> function OnLoadEvent(){ document.downloadForm.submit(); } </SCRIPT>";
	// Html尾
	public static final String sHTMLE = "</body></html>";
	static{
		threadPool4Monitor = (ThreadPoolTaskExecutor)SpringContextHolder.getBean(ThreadPool.class);
	}
	
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
			TblTxPayMentOrder.setTxAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//精确到分
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setShowUrl(ShowUrl);
			TblTxPayMentOrder.setTxBody(TxBody);
			TblTxPayMentOrder.setTxStatus(1);
			TblTxPayMentOrder.setBgNotifyUrl(BGNotifyURL);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.保存session
			request.getSession(true).setAttribute("plTxTraceNo", plTxTraceNo);
			
		}
		return SUCCESS;
		
	}
	
	//预支付 确认
	public String upfrontCostAffirm() throws Exception {
		
		//1.取得请求信息
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		//修改对应交易记录状态    
		//先查询支付订单表

		Filter filter = FilterFactory.getSimpleFilter("mchtTxTraceNo",request.getParameter("plTxTraceNo"), Filter.OPERATOR_EQ);
		
		//Filter Filter = PageInfoUtil.populateFilter(tblTxPayMentOrderPageInfo);
		System.out.println(filter);
		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		List list  = TblTxPayMentOrderManagerImpl.getObjects(TblTxPayMentOrder.class,filter);
		
		//更新支付订单表
		String PlTxTime = DateTimeUtil.getCurrDateTime();
		TblTxPayMentOrder TblTxPayMentOrder = (TblTxPayMentOrder)list.get(0);
		TblTxPayMentOrder.setTxStatus(2);
		TblTxPayMentOrder.setPlTxTime(PlTxTime);
		TblTxPayMentOrder.setErrorCode("0000");
		TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		TblTxPayMentOrder.setLastUpdatedBy(Integer.valueOf(request.getParameter("username")));
		
		TblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(TblTxPayMentOrder);
		
		//组装返回
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
		 
		//记录商户响应信息表
		 TblTxPayMentResponseManager  tblTxPayMentResponseMan = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
			
		 TblTxPayMentResponse  tblTxPayMentResponse= new  TblTxPayMentResponse();
			
			//String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			tblTxPayMentResponse.setTxTypeId(TblTxPayMentOrder.getTxTypeId());
			tblTxPayMentResponse.setMchtNo(TblTxPayMentOrder.getMchtNo());
			tblTxPayMentResponse.setPayDatetime(TblTxPayMentOrder.getPlTxTime());				//商户交易日期
			tblTxPayMentResponse.setMerchantOrderNo(TblTxPayMentOrder.getMchtTxTraceNo());
			tblTxPayMentResponse.setOrderAmount(new BigDecimal(TblTxPayMentOrder.getTxAmount()).movePointLeft(2).intValue());		//精确到分

			tblTxPayMentResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			tblTxPayMentResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			tblTxPayMentResponseMan.saveTblTxPayMentResponse(tblTxPayMentResponse);
		 
		 //记录支付结果通知表并通知商户
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
			
			// 取得组织银行报文的银行服务类
			BankComService tBankCom = new BankComService();
			
			tInputParams.setProperty("Version", "V1.0");
		    tInputParams.setProperty("TxType", TblTxPayMentOrder.getTxTypeId());
		    tInputParams.setProperty("TxInfo",sendMsg);
		    tInputParams.setProperty("Signature","");			//TODO 签名
	        // 组成没有name属性,没有ID属性的form表单
	        StringBuffer tFormBuffer = tBankCom.buildForm(TblTxPayMentOrder.getNotifyUrl(), tInputParams);
			
			//将浏览器导向商户接收交易结果地址
			redirect(response , TblTxPayMentOrder.getNotifyUrl() , tFormBuffer.toString());	
		}
		
		return SUCCESS;
		}

	
	//记录短信信息，并发送
	public void saveSms(String id,String phoneNo) throws Exception {
		
		//先查询支付订单表

		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
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
			
		send(smsBean);
		
	}
		
	public static void main(String args[]){
		String a = "MchtTxTraceNo=1221314|TxAmount=123|MerchantNo=2342|TxDate=20120202|TxTime=121212|TxBody=百度一下|ShowUrl=http://www.baidu.com|UseCoupon=|CouponMsg=|NotifyURL=|BGNotifyURL=";
		try {
			String tPlainByBase64 = Base64.encode(a.getBytes("UTF-8"));
			
			System.out.println(tPlainByBase64);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送消息
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
			System.out.println("***Exception JmsSender.send() *** 发送消息发生异常: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** 发送消息发生异常: " + te.getMessage());
		}

	}
	
	/**
	 * 发送消息
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
			System.out.println("***Exception JmsSender.send() *** 发送消息发生异常: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** 发送消息发生异常: " + te.getMessage());
		}

	}
	
	/**
	 * 把用户页面重定向到商户接收交易结果地址
	 * 
	 * @param res
	 * @param url
	 *            重定向的URL
	 * @param params
	 *            重定向所需要的参数
	 * 
	 * @throws IOException
	 */
	protected void redirect(HttpServletResponse res, String url, String form)
			throws IOException {

		res.setContentType("UTF-8");
		ServletOutputStream out = res.getOutputStream();

		StringBuffer resBuff = new StringBuffer();

		// Html头
		resBuff.append(sHTMLS);

		// Form定义
		resBuff.append(sFORM1S).append(sFORM1E).append(sFORM2S1).append(url)
				.append(sFORM2S2).append(form);

		// JavaScript
		resBuff.append(sFORM2E).append(sSCRIPT).append(sHTMLE);

		out.write(resBuff.toString().getBytes("UTF-8"));
		out.flush();
		out.close();

	}
	
}
