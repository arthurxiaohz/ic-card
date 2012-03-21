package cn.net.iccard.special.service.impl;


import java.io.Serializable;
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
import cn.net.iccard.accounting.tx.IAccountDebitCreditResponse;
import cn.net.iccard.accounting.tx.IAccountTxService;
import cn.net.iccard.accounting.tx.impl.AccountDebitCreditRequest;
import cn.net.iccard.accounting.tx.impl.AccountTxService;
import cn.net.iccard.bm.accounting.model.AccountCatalog;
import cn.net.iccard.bm.accounting.model.AccountPartyType;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.model.BizType;
import cn.net.iccard.bm.accounting.service.ActAccountManager;


import cn.net.iccard.member.model.RechargeTxStatus;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import cn.net.iccard.member.model.TblMbTransactionResponse;
import cn.net.iccard.member.service.TblMbRechargeOrderManager;
import cn.net.iccard.member.service.TblMbTransactionRequestManager;
import cn.net.iccard.member.service.TblMbTransactionResponseManager;
import cn.net.iccard.special.service.IRechargeResponseService;
import cn.net.iccard.util.DateTimeUtil;

public class RechargeService implements IRechargeResponseService {

	private TblMbTransactionResponseManager tblMbTranscationResponseMan = (TblMbTransactionResponseManager) SpringContextHolder
	.getBean(TblMbTransactionResponse.class);
	private TblMbTransactionRequestManager tblMbTranscationRequestMan = (TblMbTransactionRequestManager) SpringContextHolder
	.getBean(TblMbTransactionRequest.class);
	private TblMbRechargeOrderManager tblMbRechargeOrderMan = (TblMbRechargeOrderManager) SpringContextHolder
	.getBean(TblMbRechargeOrder.class);
	private IAccountTxService accountTxService = (IAccountTxService) SpringContextHolder
	.getBean(AccountTxService.class);
	ActAccountManager  actAccountMan = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
	
	
	public String saveRechargeResponse(HttpServletRequest pageRequest,
			HttpServletResponse response) throws Exception {
		//记录银行响应信息
		String PlTxTime = DateTimeUtil.getCurrDateTime();
		String orderId = (String) pageRequest.getParameter("out_trade_no");
		
		String txAmount = (String) pageRequest.getParameter("total_fee");
		
		System.out.println(orderId);
		//更新网关请求表
		Filter requestfilter = FilterFactory.getSimpleFilter("orderId", orderId, Filter.OPERATOR_EQ);
		
		List<TblMbTransactionRequest> mbTransactionRequestList  = tblMbTranscationRequestMan.getObjects(requestfilter);	
		
		TblMbTransactionRequest mbTransactionRequest = (TblMbTransactionRequest)mbTransactionRequestList.get(0);
		mbTransactionRequest.setTxStatus(RechargeTxStatus.RECHARGETXSTATUS_PAYSUCCESS);
		mbTransactionRequest.setPlTxTime(PlTxTime);
		mbTransactionRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		tblMbTranscationRequestMan.saveTblMbTransactionRequest(mbTransactionRequest);
		
		//更新充值表
		Filter rechargefilter = FilterFactory.getSimpleFilter("plTxTraceNo", mbTransactionRequest.getPlTxTraceNo(), Filter.OPERATOR_EQ);
		
		List<TblMbRechargeOrder> mbRechargeOrderList  = tblMbRechargeOrderMan.getObjects(rechargefilter);	
		
		TblMbRechargeOrder mbRechargeOrder = (TblMbRechargeOrder)mbRechargeOrderList.get(0);		
		mbRechargeOrder.setTxStatus(RechargeTxStatus.RECHARGETXSTATUS_PAYSUCCESS);
		mbRechargeOrder.setPlTxTime(PlTxTime);
		mbRechargeOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		
		//记录网关响应信息
		TblMbTransactionResponse  tblMbTransactionResponse= new  TblMbTransactionResponse();
		tblMbTransactionResponse.setOrdedId(orderId);
		tblMbTransactionResponse.setOrgOrdedId(mbRechargeOrder.getPlTxTraceNo());
		tblMbTransactionResponse.setAmount(new BigDecimal(txAmount).movePointRight(2).intValue());
		tblMbTransactionResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
		tblMbTransactionResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
		tblMbTranscationResponseMan.saveTblMbTransactionResponse(tblMbTransactionResponse);
			
		//处理银行结果
		
		//调账户系统
		//查询会员
		Filter memberfilter = FilterFactory.getSimpleFilter("accountParty", mbRechargeOrder.getUserName(), Filter.OPERATOR_EQ);
		memberfilter.addCondition("accountPartyType", AccountPartyType.ACCOUNTPARTYTYPE_MEMBER, Filter.OPERATOR_EQ)
					.addCondition("AccountCatalog", AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT, Filter.OPERATOR_EQ);
		List<ActAccount> memberActAccountList  = actAccountMan.getObjects(memberfilter);	
		
		ActAccount memberActAccount = (ActAccount)memberActAccountList.get(0);		//会员虚拟账户
		
		AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();
		accountDebitCreditRequest.setAccountId(memberActAccount.getId());
		accountDebitCreditRequest.setAmount(new BigDecimal(txAmount).movePointRight(2).intValue());
		accountDebitCreditRequest.setBizLogId(mbRechargeOrder.getId());
		accountDebitCreditRequest.setBizType(BizType.BIZTYPE_BANKCHARGE);
		//accountDebitCreditRequest.setMchtOrderAmount(new BigDecimal(txAmount).movePointRight(2).intValue());
		accountDebitCreditRequest.setRemark("充值成功");
		IAccountDebitCreditResponse transferResponse = accountTxService.debit(accountDebitCreditRequest);
		
		mbRechargeOrder.setVoucherNo(transferResponse.getVoucherNo());
		tblMbRechargeOrderMan.saveTblMbRechargeOrder(mbRechargeOrder);
		return null;
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
