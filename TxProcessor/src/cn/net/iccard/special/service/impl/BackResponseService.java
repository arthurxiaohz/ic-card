package cn.net.iccard.special.service.impl;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContextHelper;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.ICommonAccountResponse;
import cn.net.iccard.accounting.tx.IClearingAccountService;
import cn.net.iccard.accounting.tx.impl.ClearingAccountService;
import cn.net.iccard.accounting.tx.impl.PaymentClearingAccountRequest;
import cn.net.iccard.accounting.tx.impl.RefundClearingAccountRequest;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.service.ActAccountManager;
import cn.net.iccard.bm.mcht.model.MchtFeeType;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager;

import cn.net.iccard.member.model.PointRuleType;
import cn.net.iccard.member.model.PointTxType;
import cn.net.iccard.member.model.TblMbPoint;
import cn.net.iccard.member.model.TblMbPointDetail;
import cn.net.iccard.member.model.TblMbPointRule;
import cn.net.iccard.member.service.TblMbPointDetailManager;
import cn.net.iccard.member.service.TblMbPointManager;
import cn.net.iccard.member.service.TblMbPointRuleManager;
import cn.net.iccard.special.service.IBackResponseService;
import cn.net.iccard.special.service.IPayResponseService;
import cn.net.iccard.tx.model.OrderTxStatus;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;
import cn.net.iccard.util.Base64;
import cn.net.iccard.util.DateTimeUtil;
import cn.net.iccard.util.NotifyBean;

public class BackResponseService implements IBackResponseService {

	private IClearingAccountService ClearingAccountService = (IClearingAccountService) SpringContextHolder
	.getBean(ClearingAccountService.class);
	
	TblTxPayMentOrderManager tblTxPayMentOrderManagerImpl = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);

	TblTxPayMentResponseManager  tblTxPayMentResponseMan = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
	
	TblMchtFeeConfigManager  tblMchtFeeConfigMan = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);

	ActAccountManager  actAccountMan = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
	
	//积分规则
	TblMbPointRuleManager  tblMbPointRuleMan = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
	
	//清分流水表
	TblStlCleaningDetailManager tblStlCleaningDetailMan = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
	
	//积分明细表
	TblMbPointDetailManager  tblMbPointDetailMan = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
	
	//会员积分表
	TblMbPointManager tblMbPointMan = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
	
	//hiuser
	HiUserManager hiMan = (HiUserManager)SpringContextHolder.getBean(HiUser.class);

	public String saveBackResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response) throws Exception {
		
		System.out.println(pageRequest.getParameter("orderId"));
		//修改对应交易记录状态    
		//先查询支付订单表
	    TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder) tblTxPayMentOrderManagerImpl.getObjectById(pageRequest.getParameter("orderId"));
		
		//更新支付订单表
		String PlTxTime = DateTimeUtil.getCurrDateTime();
	
		if(tblTxPayMentOrder.getTxStatus()==OrderTxStatus.ORDERTXSTATUS_WAITBACK){
			
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_BACKSUCCESS);
			tblTxPayMentOrder.setErrorCode("0004");		//退款成功
		}
		
		tblTxPayMentOrder.setPlTxTime(PlTxTime);
		tblTxPayMentOrder.setCreator(UserContextHelper.getUser());
		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		tblTxPayMentOrder.setLastUpdatedBy(UserContextHelper.getUser().getId());
		tblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(tblTxPayMentOrder);
		
		
		//查询订单表原始订单
		Filter lastOrderfilter = FilterFactory.getSimpleFilter("mchtNo", tblTxPayMentOrder.getMchtNo(), Filter.OPERATOR_EQ);
		lastOrderfilter.addCondition("mchtTxTraceNo", tblTxPayMentOrder.getLastMchtTxTraceNo(), Filter.OPERATOR_EQ)
					.addCondition("mchtTxTime", tblTxPayMentOrder.getLastMchtTxTime(), Filter.OPERATOR_EQ);
		
		List<TblTxPayMentOrder> tblTxPayMentOrderList  = tblTxPayMentOrderManagerImpl.getObjects(lastOrderfilter);	
		
		TblTxPayMentOrder lastOrder = (TblTxPayMentOrder)tblTxPayMentOrderList.get(0);		
		
		//更新原订单
		lastOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_FAIL);
		lastOrder.setPlTxTime(PlTxTime);
		lastOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		lastOrder.setLastUpdatedBy(UserContextHelper.getUser().getId());
		tblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(lastOrder);
		
		//查询商户手续费配置表
		Filter filter = FilterFactory.getSimpleFilter("mchtNo", tblTxPayMentOrder.getMchtNo(), Filter.OPERATOR_EQ);

		List<TblMchtFeeConfig> tblMchtFeeList  = tblMchtFeeConfigMan.getObjects(filter);
		
		TblMchtFeeConfig tblMchtFee = (TblMchtFeeConfig)tblMchtFeeList.get(0);
		
		//记录清分流水表
		//查询原清分记录
		Filter oldCleanfilter = FilterFactory.getSimpleFilter("plTxTraceNo", lastOrder.getPlTxTraceNo(), Filter.OPERATOR_EQ);

		List<TblStlCleaningDetail> oldCleanDetailList  = tblStlCleaningDetailMan.getObjects(oldCleanfilter);
		
		TblStlCleaningDetail oldClean = (TblStlCleaningDetail)oldCleanDetailList.get(0);
		
		//记录积分明细表--扣减积分
			//查询hiuser表
		Filter hifilter = FilterFactory.getSimpleFilter("userName", tblTxPayMentOrder.getUserName(), Filter.OPERATOR_GREATER_EQ);
		
		List<HiUser> hiList  = hiMan.getObjects(hifilter);
		
		HiUser hiuser = (HiUser)hiList.get(0);
		
		TblMbPointDetail tblMbPointDetail = new TblMbPointDetail();
		tblMbPointDetail.setTblMbInfo(hiuser);
		tblMbPointDetail.setPoint(oldClean.getBalance());
		tblMbPointDetail.setPointTxType(PointTxType.POINTTXTYPE_REFUNDPOINT);
		tblMbPointDetail.setVoucherNo(tblTxPayMentOrder.getId());
		tblMbPointDetail.setCreatedDateTime(new Timestamp(System.currentTimeMillis())); //创建时间
		tblMbPointDetail.setLastUpdatedBy(hiuser);
		tblMbPointDetail.setCreator(hiuser);
		tblMbPointDetail.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
		tblMbPointDetailMan.saveTblMbPointDetail(tblMbPointDetail);
		
		//更新会员积分表
		Filter pointbalfilter = FilterFactory.getSimpleFilter("tblMbInfo", hiuser.getId(), Filter.OPERATOR_GREATER_EQ);
		
		List<TblMbPoint> pointbalList  = tblMbPointMan.getObjects(pointbalfilter);
		
		TblMbPoint pointbal = (TblMbPoint)pointbalList.get(0);
		pointbal.setBalance(pointbal.getBalance()-oldClean.getBalance());
		tblMbPointMan.saveTblMbPoint(pointbal);
		
		//记录清分流水表
		TblStlCleaningDetail tblStlCleaningDetail = new TblStlCleaningDetail();
		tblStlCleaningDetail.setPlTxTraceNo(tblTxPayMentOrder.getPlTxTraceNo());
		tblStlCleaningDetail.setMchtOrderId(tblTxPayMentOrder.getMchtTxTraceNo());
		tblStlCleaningDetail.setRefundOrderId(lastOrder.getMchtTxTraceNo());
		tblStlCleaningDetail.setRefundOrderAmt(tblTxPayMentOrder.getOrderAmount());
		
		//tblStlCleaningDetail.setOrderAmount(tblTxPayMentOrder.getOrderAmount());
		//tblStlCleaningDetail.setMchtSettleAmount(tblTxPayMentOrder.getOrderAmount()-mchtFee);
		tblStlCleaningDetail.setTransTime(tblTxPayMentOrder.getPlTxTime());		//交易完成时间
		tblStlCleaningDetail.setUserName(tblTxPayMentOrder.getUserName());
		tblStlCleaningDetail.setBackBalance(oldClean.getBalance());			//积分
		tblStlCleaningDetail.setMchtNo(tblTxPayMentOrder.getMchtNo());
		tblStlCleaningDetail.setMchtName(tblTxPayMentOrder.getMchtName());
		
		if(tblMchtFee.getIsFeeReturn() == YesNo.YESNO_YES){
			tblStlCleaningDetail.setRefundFee(oldClean.getFee());			//退手续费
		}else{
			tblStlCleaningDetail.setRefundFee(0);
		}
		tblStlCleaningDetail.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
		tblStlCleaningDetail.setLastUpdatedBy(hiuser.getId());
		tblStlCleaningDetail.setCreator(hiuser);
		tblStlCleaningDetail.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
		tblStlCleaningDetail.setRefundAmt(oldClean.getPayAmount());
		//tblStlCleaningDetail.setPayAmount(tblTxPayMentOrder.getPayAmount());
		tblStlCleaningDetailMan.saveTblStlCleaningDetail(tblStlCleaningDetail);
	
		//查询id
		Filter cleanfilter = FilterFactory.getSimpleFilter("plTxTraceNo", tblStlCleaningDetail.getPlTxTraceNo(), Filter.OPERATOR_GREATER_EQ);
		
		List<TblStlCleaningDetail> cleanList  = tblStlCleaningDetailMan.getObjects(cleanfilter);
		
		TblStlCleaningDetail cleanDetail = (TblStlCleaningDetail)cleanList.get(0);
		 
		//调用账户系统
		RefundClearingAccountRequest refundClearingAccountRequest = new RefundClearingAccountRequest();
		refundClearingAccountRequest.setAmount(tblStlCleaningDetail.getPayAmount());
		refundClearingAccountRequest.setBizLogId(cleanDetail.getId());
		refundClearingAccountRequest.setMchtFee(oldClean.getFee());
		refundClearingAccountRequest.setMchtNo(tblStlCleaningDetail.getMchtNo());
		refundClearingAccountRequest.setMchtOrderAmount(oldClean.getOrderAmount());
		refundClearingAccountRequest.setUserName(tblStlCleaningDetail.getUserName());
		boolean flag = false;
		if(tblMchtFee.getIsFeeReturn() == YesNo.YESNO_YES){
			flag = true;
		}
		refundClearingAccountRequest.setFeeReturn(flag);
		ICommonAccountResponse accountResponse = ClearingAccountService.doRefundAccountClearing(refundClearingAccountRequest);
		
		if(!accountResponse.getRespCode().equals(EAccountResponse.S0000)){
			throw new Exception("账户处理失败");
		}
		//组装返回
		 StringBuffer tPlain = new StringBuffer(400);
		 tPlain.append("PlTxTraceNo="+tblTxPayMentOrder.getPlTxTraceNo()+"|"+
					"MchtTxTraceNo=" +tblTxPayMentOrder.getMchtTxTraceNo()+"|" +
					"MerchantNo=" + tblTxPayMentOrder.getMchtNo()+"|" +
					"PlTxDate=" + PlTxTime.substring(0, 8)+"|" +
					"PlTxTime=" + PlTxTime.substring(8, 14)+"|" +
					"ResponseCode="+tblTxPayMentOrder.getErrorCode()+"|" +
					"TxAmount="+new BigDecimal(tblTxPayMentOrder.getOrderAmount()).movePointLeft(2));
		
		 
		 String sendMsg = Base64.encode(tPlain.toString().getBytes("UTF-8"));
		 
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
	
		if(tblTxPayMentOrder.getNotifyUrl()!= null &&!tblTxPayMentOrder.getNotifyUrl().equals("")){
			
			//Properties tInputParams = new Properties();
			
			// 取得组织银行报文的银行服务类
//			BankComService tBankCom = new BankComService();
//			
//			tInputParams.setProperty("Version", "V1.0");
//		    tInputParams.setProperty("TxType", tblTxPayMentOrder.getTxTypeId());
//		    tInputParams.setProperty("TxInfo",sendMsg);
//		    tInputParams.setProperty("Signature","");			//TODO 签名
		    
		    StringBuffer s = new StringBuffer("");
		    
		    s.append("  <input type=\"hidden\" name=\"").append("Version").append("\" value=\"").append("V1.0").append("\">");
		    s.append("  <input type=\"hidden\" name=\"").append("TxType").append("\" value=\"").append(tblTxPayMentOrder.getTxTypeId()).append("\">");
		    s.append("  <input type=\"hidden\" name=\"").append("TxInfo").append("\" value=\"").append(sendMsg).append("\">");
		    s.append("  <input type=\"hidden\" name=\"").append("Signature").append("\" value=\"").append("").append("\">");

	        // 组成没有name属性,没有ID属性的form表单
	        //StringBuffer tFormBuffer = tBankCom.buildForm(tblTxPayMentOrder.getNotifyUrl(), tInputParams);
			
			//将浏览器导向商户接收交易结果地址
	        NotifyService.redirect(response , tblTxPayMentOrder.getNotifyUrl() , s.toString());	
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
