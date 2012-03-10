package cn.net.iccard.special.service.impl;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.SpringContextHolder;
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
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.service.ActAccountManager;
import cn.net.iccard.bm.mcht.model.MchtFeeType;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;
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
import cn.net.iccard.special.service.IPayResponseService;
import cn.net.iccard.tx.model.OrderTxStatus;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;
import cn.net.iccard.util.Base64;
import cn.net.iccard.util.DateTimeUtil;
import cn.net.iccard.util.NotifyBean;

public class PayResponseService implements IPayResponseService {

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

	public String savePayResponse(int id) throws Exception {

		//修改对应交易记录状态    
		//先查询支付订单表
	    TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder) tblTxPayMentOrderManagerImpl.getObjectById(id);
		
		//更新支付订单表
		String PlTxTime = DateTimeUtil.getCurrDateTime();
	
		if(tblTxPayMentOrder.getTxStatus()==OrderTxStatus.ORDERTXSTATUS_PREPAY){
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAYSUCCESS);
			tblTxPayMentOrder.setErrorCode("0001");		//预支付成功
		}else{
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PAYSUCCESS);
			tblTxPayMentOrder.setErrorCode("0002");		//确认支付成功
		}
		
		tblTxPayMentOrder.setPlTxTime(PlTxTime);
		tblTxPayMentOrder.setCreator(UserContextHelper.getUser());
		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		tblTxPayMentOrder.setLastUpdatedBy(UserContextHelper.getUser().getId());
		tblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(tblTxPayMentOrder);
		
		//记录清分流水表
		//查询商户手续费配置表
		Filter filter = FilterFactory.getSimpleFilter("mchtNo", tblTxPayMentOrder.getMchtNo(), Filter.OPERATOR_EQ);

		List<TblMchtFeeConfig> tblMchtFeeList  = tblMchtFeeConfigMan.getObjects(filter);
		
		TblMchtFeeConfig tblMchtFee = (TblMchtFeeConfig)tblMchtFeeList.get(0);
		
		int mchtFee = 0;
		if(tblMchtFee.getMchtFeeType() == MchtFeeType.MCHTFEETYPE_BYRATE){
			//按比例
			mchtFee = ((new BigDecimal(tblTxPayMentOrder.getOrderAmount()).multiply(new BigDecimal(tblMchtFee.getRuleValue()).movePointLeft(2))).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();   //舍掉小数
			
			//查询该值是否在区间内
			if(mchtFee > tblMchtFee.getMaxVal()){
				mchtFee = tblMchtFee.getMaxVal();
			}else if(mchtFee<tblMchtFee.getMinVal()){
				mchtFee = tblMchtFee.getMinVal();
			}
			
		}else if(tblMchtFee.getMchtFeeType() == MchtFeeType.MCHTFEETYPE_BYTRANS){
			//固定金额
			mchtFee = tblMchtFee.getRuleValue().intValue();
		}
		
		//计算积分
		Date nowDate = new Timestamp(System.currentTimeMillis());
		Filter pointfilter = FilterFactory.getSimpleFilter("minAmount", tblTxPayMentOrder.getPayAmount(), Filter.OPERATOR_GREATER_EQ);
		
		pointfilter.addCondition("maxAmount", tblTxPayMentOrder.getPayAmount(), Filter.OPERATOR_LESS_EQ)
				.addCondition("startDatetime", nowDate, Filter.OPERATOR_GREATER_EQ)
				.addCondition("endDatetime", nowDate, Filter.OPERATOR_LESS_EQ);

		List<TblMbPointRule> pointConfigList  = tblMbPointRuleMan.getObjects(pointfilter);
		
		TblMbPointRule pointConfig = (TblMbPointRule)pointConfigList.get(0);
		
		int point = 0;
		if(pointConfig.getPointRuleType()== PointRuleType.POINTRULETYPE_BYRATE){
			//按比例
			point = ((new BigDecimal(tblTxPayMentOrder.getPayAmount()).multiply(new BigDecimal(pointConfig.getRuleValue()).movePointLeft(2))).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();   //舍掉小数
			
		}else if(pointConfig.getPointRuleType() == PointRuleType.POINTRULETYPE_BYTRANS){
			//固定金额
			point = pointConfig.getRuleValue().intValue();
		}
		
		//记录积分明细表
			//查询hiuser表
		Filter hifilter = FilterFactory.getSimpleFilter("userName", tblTxPayMentOrder.getUserName(), Filter.OPERATOR_GREATER_EQ);
		
		List<HiUser> hiList  = hiMan.getObjects(hifilter);
		
		HiUser hiuser = (HiUser)hiList.get(0);
		
		TblMbPointDetail tblMbPointDetail = new TblMbPointDetail();
		tblMbPointDetail.setTblMbInfo(hiuser);
		tblMbPointDetail.setPoint(point);
		tblMbPointDetail.setPointTxType(PointTxType.POINTTXTYPE_TXPOINT);
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
		pointbal.setBalance(pointbal.getBalance()+point);
		tblMbPointMan.saveTblMbPoint(pointbal);
		
		//记录清分流水表
		TblStlCleaningDetail tblStlCleaningDetail = new TblStlCleaningDetail();
		tblStlCleaningDetail.setPlTxTraceNo(tblTxPayMentOrder.getPlTxTraceNo());
		tblStlCleaningDetail.setMchtOrderId(tblTxPayMentOrder.getMchtTxTraceNo());
		tblStlCleaningDetail.setOrderAmount(tblTxPayMentOrder.getOrderAmount());
		tblStlCleaningDetail.setMchtSettleAmount(tblTxPayMentOrder.getOrderAmount()-mchtFee);
		tblStlCleaningDetail.setTransTime(tblTxPayMentOrder.getPlTxTime());		//交易完成时间
		tblStlCleaningDetail.setUserName(tblTxPayMentOrder.getUserName());
		tblStlCleaningDetail.setBalance(point);			//积分
		tblStlCleaningDetail.setMchtNo(tblTxPayMentOrder.getMchtNo());
		tblStlCleaningDetail.setMchtName(tblTxPayMentOrder.getMchtName());
		tblStlCleaningDetail.setFee(mchtFee);			//手续费
		tblStlCleaningDetail.setPayAmount(tblTxPayMentOrder.getPayAmount());
		tblStlCleaningDetail.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
		tblStlCleaningDetail.setLastUpdatedBy(hiuser.getId());
		tblStlCleaningDetail.setCreator(hiuser);
		tblStlCleaningDetail.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
		tblStlCleaningDetailMan.saveTblStlCleaningDetail(tblStlCleaningDetail);
	
		
		//查询id
		Filter cleanfilter = FilterFactory.getSimpleFilter("plTxTraceNo", tblStlCleaningDetail.getPlTxTraceNo(), Filter.OPERATOR_GREATER_EQ);
		
		List<TblStlCleaningDetail> cleanList  = tblStlCleaningDetailMan.getObjects(cleanfilter);
		
		TblStlCleaningDetail cleanDetail = (TblStlCleaningDetail)cleanList.get(0);
		 
		//调用账户系统
		PaymentClearingAccountRequest paymentClearingAccountRequest = new PaymentClearingAccountRequest();
		paymentClearingAccountRequest.setAmount(tblStlCleaningDetail.getPayAmount());
		paymentClearingAccountRequest.setBizLogId(cleanDetail.getId());
		paymentClearingAccountRequest.setMchtFee(mchtFee);
		paymentClearingAccountRequest.setMchtNo(tblStlCleaningDetail.getMchtNo());
		paymentClearingAccountRequest.setMchtOrderAmount(tblStlCleaningDetail.getOrderAmount());
		paymentClearingAccountRequest.setUserName(tblStlCleaningDetail.getUserName());
		ICommonAccountResponse accountResponse = ClearingAccountService.doPaymentAccountClearing(paymentClearingAccountRequest);
		
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
					"TxDate=" + tblTxPayMentOrder.getMchtTxTime().substring(0, 8)+"|" +
					"TxTime=" + tblTxPayMentOrder.getMchtTxTime().substring(8,12)+"|" +
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
		/*
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
