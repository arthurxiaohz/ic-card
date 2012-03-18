package cn.net.iccard.special.service.impl;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContextHelper;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.tx.IAccountTransferResponse;
import cn.net.iccard.accounting.tx.IAccountTxService;
import cn.net.iccard.accounting.tx.impl.AccountPayableTransferRequest;
import cn.net.iccard.accounting.tx.impl.AccountTxService;
import cn.net.iccard.bm.accounting.model.AccountCatalog;
import cn.net.iccard.bm.accounting.model.AccountPartyType;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.model.BizType;
import cn.net.iccard.bm.accounting.service.ActAccountManager;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;

import cn.net.iccard.special.service.IPrepaidResponseService;
import cn.net.iccard.tx.model.OrderTxStatus;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;
import cn.net.iccard.util.BankComService;
import cn.net.iccard.util.Base64;
import cn.net.iccard.util.DateTimeUtil;
import cn.net.iccard.util.NotifyBean;

public class PrepaidResponseService implements IPrepaidResponseService {

	private IAccountTxService accountTxService = (IAccountTxService) SpringContextHolder
	.getBean(AccountTxService.class);
	
	TblTxPayMentOrderManager tblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);

	TblTxPayMentResponseManager  tblTxPayMentResponseMan = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
	
	TblMchtInfoManager  tblMchtInfoMan = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);

	ActAccountManager  actAccountMan = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
	
	public String savePrepaidResponse(HttpServletRequest pageRequest,HttpServletResponse response) throws Exception {

		//修改对应交易记录状态    
		//先查询支付订单表
		
		System.out.println(pageRequest.getParameter("orderId"));
	    TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder) tblTxPayMentOrderManagerImpl.getObjectById(pageRequest.getParameter("orderId"));
		
		//更新支付订单表
		String PlTxTime = DateTimeUtil.getCurrDateTime();
		String nowDate = DateTimeUtil.getToday();
		if(tblTxPayMentOrder.getTxStatus()==OrderTxStatus.ORDERTXSTATUS_PREPAY){
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAYSUCCESS);
			tblTxPayMentOrder.setErrorCode("0001");		//预支付成功
		}else{
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PAYSUCCESS);
			tblTxPayMentOrder.setErrorCode("0002");		//预支付成功
		}
		tblTxPayMentOrder.setCreator(UserContextHelper.getUser());
		tblTxPayMentOrder.setPlTxTime(PlTxTime);
		tblTxPayMentOrder.setPayAmount(tblTxPayMentOrder.getOrderAmount());
		//查询商户信息表
		Filter filter = FilterFactory.getSimpleFilter("mchtNo", tblTxPayMentOrder.getMchtNo(), Filter.OPERATOR_EQ);

		List<TblMchtInfo> tblMchtInfoList  = tblMchtInfoMan.getObjects(filter);
		
		TblMchtInfo tblmchtinfo = (TblMchtInfo)tblMchtInfoList.get(0);
		int days  =  tblmchtinfo.getDays();
		
		tblTxPayMentOrder.setOrderExpireDatetime(DateTimeUtil.getBeforeAfterDate(nowDate,days));
		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		tblTxPayMentOrder.setLastUpdatedBy(UserContextHelper.getUser().getId());
		
		//调用账户系统
		//查询会员担保账户及会员的虚拟账户号
		Filter mchtfilter = FilterFactory.getSimpleFilter("accountParty", UserContextHelper.getUser().getUserName(), Filter.OPERATOR_EQ);
		mchtfilter.addCondition("accountPartyType", AccountPartyType.ACCOUNTPARTYTYPE_MEMBER, Filter.OPERATOR_EQ)
					.addCondition("accountCatalog", AccountCatalog.ACCOUNTCATALOG_GUARANTEEACCOUNT, Filter.OPERATOR_EQ);
		
		List<ActAccount> mchtActAccountList  = actAccountMan.getObjects(mchtfilter);	
		
		ActAccount mchtActAccount = (ActAccount)mchtActAccountList.get(0);		//会员担保账户
		
		Filter memberfilter = FilterFactory.getSimpleFilter("accountParty", tblTxPayMentOrder.getUserName(), Filter.OPERATOR_EQ);
		memberfilter.addCondition("accountPartyType", AccountPartyType.ACCOUNTPARTYTYPE_MEMBER, Filter.OPERATOR_EQ)
					.addCondition("AccountCatalog", AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT, Filter.OPERATOR_EQ);
		
		List<ActAccount> memberActAccountList  = actAccountMan.getObjects(memberfilter);	
		
		ActAccount memberActAccount = (ActAccount)memberActAccountList.get(0);		//会员虚拟账户
		
		AccountPayableTransferRequest accountPayableTransferRequest = new AccountPayableTransferRequest();
		accountPayableTransferRequest.setAccountIdFrom(memberActAccount.getId());
		accountPayableTransferRequest.setAccountIdTo(mchtActAccount.getId());
		accountPayableTransferRequest.setAmount(tblTxPayMentOrder.getOrderAmount());
		accountPayableTransferRequest.setBizLogId(tblTxPayMentOrder.getId());
		accountPayableTransferRequest.setBizType(BizType.BIZTYPE_PREPAID);
		accountPayableTransferRequest.setExpiredDate(tblTxPayMentOrder.getOrderExpireDatetime());
		//accountPayableTransferRequest.setMchtOrderAmount(tblTxPayMentOrder.getOrderAmount());
		accountPayableTransferRequest.setRemark("预支付成功");
		IAccountTransferResponse transferResponse = accountTxService.transfer(accountPayableTransferRequest);
		
//		if(!transferResponse.getRespCode().equals(EAccountResponse.S0000)){
//			throw new Exception("账户处理失败");
//		}
		//tblTxPayMentOrder.setVoucherNo(transferResponse.getVoucherNo());
		tblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(tblTxPayMentOrder);
		
		
		//组装返回
		 StringBuffer tPlain = new StringBuffer(400);
		 tPlain.append("PlTxTraceNo="+tblTxPayMentOrder.getPlTxTraceNo()+"|"+
					"MchtTxTraceNo=" +tblTxPayMentOrder.getMchtTxTraceNo()+"|" +
					"MerchantNo=" + tblTxPayMentOrder.getMchtNo()+"|" +
					"PlTxDate=" + PlTxTime.substring(0, 8)+"|" +
					"PlTxTime=" + PlTxTime.substring(8, 14)+"|" +
					"TxDate=" + tblTxPayMentOrder.getMchtTxTime().substring(0, 8)+"|" +
					"TxTime=" + tblTxPayMentOrder.getMchtTxTime().substring(8,12)+"|" +
					"ResponseCode="+tblTxPayMentOrder.getErrorCode()+"|" +
					"TxAmount="+new BigDecimal(tblTxPayMentOrder.getOrderAmount()).movePointLeft(2));
		
		 
		 String sendMsg = Base64.encode(tPlain.toString().getBytes("UTF-8"));
		 /*
		//记录商户响应信息表
		 TblTxPayMentResponse  tblTxPayMentResponse= new  TblTxPayMentResponse();
			
		//String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
		tblTxPayMentResponse.setTxTypeId(tblTxPayMentOrder.getTxTypeId());
		tblTxPayMentResponse.setMchtNo(tblTxPayMentOrder.getMchtNo());
		tblTxPayMentResponse.setPayDatetime(tblTxPayMentOrder.getPlTxTime());				//商户交易日期
		tblTxPayMentResponse.setMerchantOrderNo(tblTxPayMentOrder.getMchtTxTraceNo());
		tblTxPayMentResponse.setOrderAmount(new BigDecimal(tblTxPayMentOrder.getOrderAmount()).intValue());		//精确到分

		tblTxPayMentResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
		tblTxPayMentResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
		tblTxPayMentResponseMan.saveTblTxPayMentResponse(tblTxPayMentResponse);
		
		try{
			 //记录支付结果通知表并通知商户
			if(tblTxPayMentOrder.getBgNotifyUrl()!= null &&!tblTxPayMentOrder.getBgNotifyUrl().equals("")){
			
				NotifyBean notifyBean = new NotifyBean();
				notifyBean.setMchtTxURL(tblTxPayMentOrder.getBgNotifyUrl());
				notifyBean.setSendMsg(sendMsg);
				notifyBean.setSignature("");
				notifyBean.setTxType(tblTxPayMentOrder.getTxTypeId());
				NotifyService.send(notifyBean);
			 
		}
		}catch(Exception e){
			e.printStackTrace();
		}
			*/
		if(tblTxPayMentOrder.getNotifyUrl()!= null &&!tblTxPayMentOrder.getNotifyUrl().equals("")){
			
			Properties tInputParams = new Properties();
			
			// 取得组织银行报文的银行服务类
			BankComService tBankCom = new BankComService();
			
			tInputParams.setProperty("Version", "V1.0");
		    tInputParams.setProperty("TxType", tblTxPayMentOrder.getTxTypeId());
		    tInputParams.setProperty("TxInfo",sendMsg);
		    tInputParams.setProperty("Signature","");			//TODO 签名
		    
			/*
		    StringBuffer s = new StringBuffer("");
		    
		    s.append("  <input type=\"hidden\" name=\"").append("Version").append("\" value=\"").append("V1.0").append("\">");
		    s.append("  <input type=\"hidden\" name=\"").append("TxType").append("\" value=\"").append(tblTxPayMentOrder.getTxTypeId()).append("\">");
		    s.append("  <input type=\"hidden\" name=\"").append("TxInfo").append("\" value=\"").append(sendMsg).append("\">");
		    s.append("  <input type=\"hidden\" name=\"").append("Signature").append("\" value=\"").append("").append("\">");
*/
	        // 组成没有name属性,没有ID属性的form表单
	        StringBuffer tFormBuffer = tBankCom.buildForm(tblTxPayMentOrder.getNotifyUrl(), tInputParams);
			
	        pageRequest.getSession(true).setAttribute("formname", "form1");
	        pageRequest.getSession(true).setAttribute("formcontents", tFormBuffer.toString());
	        //pageRequest.setAttribute("formname", "form1");
	        //pageRequest.setAttribute("formcontents", tFormBuffer.toString());
			//将浏览器导向商户接收交易结果地址
	        //NotifyService.redirect(response , tblTxPayMentOrder.getNotifyUrl() , tFormBuffer.toString());	
		}
		
		return "success";
		
	}
	
	public DAO getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getList(PageInfo arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Class getModelClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObjectById(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(Filter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(PageInfo arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(Filter arg0, Sorter arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(Filter arg0, Sorter arg1, Page arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUniqueObject(Filter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeObject(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	public void removeObjectById(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}

	public void saveObject(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setDAO(DAO arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
