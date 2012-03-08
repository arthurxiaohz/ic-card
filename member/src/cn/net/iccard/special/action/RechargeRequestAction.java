package cn.net.iccard.special.action;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.alipay.services.AlipayService;

import cn.net.iccard.member.action.TblMbInfoPageInfo;
import cn.net.iccard.member.model.RechargeTxStatus;
import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import cn.net.iccard.member.service.TblMbInfoManager;
import cn.net.iccard.member.service.TblMbRechargeOrderManager;
import cn.net.iccard.member.service.TblMbTransactionRequestManager;
import cn.net.iccard.member.service.impl.TblMbInfoManagerImpl;
import cn.net.iccard.member.service.impl.TblMbRechargeOrderManagerImpl;
import cn.net.iccard.tx.action.TblTxPayMentOrderPageInfo;
import cn.net.iccard.tx.action.TblTxPayMentRequestPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;
import cn.net.iccard.tx.service.impl.TblTxPayMentOrderManagerImpl;
import cn.net.iccard.tx.service.impl.TblTxPayMentRequestManagerImpl;
import cn.net.iccard.util.DateUtil;
import cn.net.iccard.util.PLTraceNoGererator;
import cn.net.iccard.util.StringUtil;

//充值处理

public class RechargeRequestAction extends BaseAction{
	private TblTxPayMentRequest tblTxPayMentRequest;
	private TblTxPayMentRequestPageInfo pageInfo;
	private List<TblTxPayMentRequest> tblTxPayMentRequests;
	private String orderIndexs;
	

	
	//接收持卡人请求处理
	public void getMemberRequest() throws Exception {
		
		//1.取得持卡人请求
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		 try {
		      request.setCharacterEncoding("GBK");
		      String contentType = new StringBuffer("text/html; charset=").append("GBK").toString();
		      response.setContentType(contentType);
		    } catch (Exception e) {
		      //logger.error("", e);
		    }
//		    Filter filter = FilterFactory.getSimpleFilter("userName", hiUser.getUserName(), Filter.OPERATOR_EQ);
		    
		    Filter filter = FilterFactory.getSimpleFilter("plNo", UserContextHelper.getUser().getUserName(), Filter.OPERATOR_EQ);
		    
		//查询个人信息
//		    TblMbInfoPageInfo TblMbInfo = new TblMbInfoPageInfo();
//		    TblMbInfo.setF_plNo(org.hi.framework.security.context.UserContextHelper.getUser().getUserName());
//			
//			Filter Filter = PageInfoUtil.populateFilter(TblMbInfo);
			System.out.println(filter);
			TblMbInfoManagerImpl TblMbInfoManagerImpl =(TblMbInfoManagerImpl)SpringContextHolder.getBean(TblMbInfoManager.class);
			List list  = TblMbInfoManagerImpl.getObjects(TblMbInfo.class,filter);
			
			//记录充值请求，并请求到银行
			TblMbInfo tblMbInfo = (TblMbInfo)list.get(0);
			TblMbRechargeOrderManagerImpl TblMbRechargeOrderManagerImpl = (TblMbRechargeOrderManagerImpl)SpringContextHolder.getBean(TblMbRechargeOrderManager.class);
			TblMbRechargeOrder tblMbRechargeOrder = new TblMbRechargeOrder();
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			tblMbRechargeOrder.setPlTxTraceNo(plTxTraceNo);
			tblMbRechargeOrder.setUserName(UserContextHelper.getUser().getUserName());
			tblMbRechargeOrder.setAccountNo(tblMbInfo.getCardNo());
			tblMbRechargeOrder.setPan(tblMbInfo.getCardNo());
			tblMbRechargeOrder.setChinfo(UserContextHelper.getUser().getFullName());
			tblMbRechargeOrder.setTxTypeId("TX51");
			tblMbRechargeOrder.setTxAmount(Integer.valueOf(request.getParameter("TxAmount")));
			tblMbRechargeOrder.setMchtTxTime(DateUtil.getCurrDateTime());
			
			tblMbRechargeOrder.setTxStatus(RechargeTxStatus.RECHARGETXSTATUS_PAYPROCESS);
			tblMbRechargeOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			//tblTxPayMentRequest.setLastUpdatedBy();     	//最后修改人
			tblMbRechargeOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			TblMbRechargeOrderManagerImpl.saveTblMbRechargeOrder(tblMbRechargeOrder);
			
			
			//2.记录网关请求表
			TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);

			TblMbTransactionRequest mbTransactionRequest = new TblMbTransactionRequest();
			String requestId = PLTraceNoGererator.generatePLTraceNo("01");
			
			mbTransactionRequest.setTrancode("TX51");		//交易类型
			//mbTransactionRequest.setMchtNo(mchtNo);
			mbTransactionRequest.setPan(tblMbInfo.getCardNo());
			mbTransactionRequest.setChinfo(UserContextHelper.getUser().getFullName());
			mbTransactionRequest.setPlTxTraceNo(plTxTraceNo);
			mbTransactionRequest.setTxStatus("1");
			mbTransactionRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			//tblTxPayMentRequest.setLastUpdatedBy();     	//最后修改人
			mbTransactionRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			tblMbTransactionRequestMgr.saveTblMbTransactionRequest(mbTransactionRequest);
			
			//把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			//请求到支付宝
			String sHtmlText = AlipayService.create_direct_pay_by_user(sParaTemp);
		}
		
	
	//预支付 确认
	public void upfrontCostAffirm() throws Exception {
		

	   
		//1.取得请求信息
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		 try {
		      request.setCharacterEncoding("GBK");
		      String contentType = new StringBuffer("text/html; charset=").append("GBK").toString();
		      response.setContentType(contentType);
		    } catch (Exception e) {
		      //logger.error("", e);
		    }
			
		//取得请求信息，调用账户系统进行扣款，扣款成功后
		String msg = request.getParameter("TxInfo");			//报文域
		String Signature = request.getParameter("Signature");	//报文签名
		String TxType = request.getParameter("TxType");			//交易类型
		
		//修改对应交易记录状态    
		//先查询支付订单表
		
		TblTxPayMentOrderPageInfo tblTxPayMentOrderPageInfo= new TblTxPayMentOrderPageInfo();
		
		tblTxPayMentOrderPageInfo.setF_mchtTxTraceNo(request.getParameter("plTxTraceNo"));
		
		Filter Filter = PageInfoUtil.populateFilter(tblTxPayMentOrderPageInfo);
		System.out.println(Filter);
		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		List list  = TblTxPayMentOrderManagerImpl.getObjects(TblTxPayMentOrder.class,Filter);
		
		//更新支付订单表
		TblTxPayMentOrder TblTxPayMentOrder = (TblTxPayMentOrder)list.get(0);
		TblTxPayMentOrder.setTxStatus(2);
		TblTxPayMentOrder.setLastUpdatedBy(Integer.valueOf(request.getParameter("username")));
		
		//记录支付结果通知表并通知商户
		
		
		
		}
		
	
	public TblTxPayMentRequest getTblTxPayMentRequest() {
		return tblTxPayMentRequest;
	}

	public void setTblTxPayMentRequest(TblTxPayMentRequest tblTxPayMentRequest) {
		this.tblTxPayMentRequest = tblTxPayMentRequest;
	}
	
	public List<TblTxPayMentRequest> getTblTxPayMentRequests() {
		return tblTxPayMentRequests;
	}

	public void setTblTxPayMentRequests(List<TblTxPayMentRequest> tblTxPayMentRequests) {
		this.tblTxPayMentRequests = tblTxPayMentRequests;
	}

	public TblTxPayMentRequestPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxPayMentRequestPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
