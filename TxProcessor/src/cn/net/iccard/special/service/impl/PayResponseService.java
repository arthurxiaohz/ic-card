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
	
	//���ֹ���
	TblMbPointRuleManager  tblMbPointRuleMan = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
	
	//�����ˮ��
	TblStlCleaningDetailManager tblStlCleaningDetailMan = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
	
	//������ϸ��
	TblMbPointDetailManager  tblMbPointDetailMan = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
	
	//��Ա���ֱ�
	TblMbPointManager tblMbPointMan = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
	
	//hiuser
	HiUserManager hiMan = (HiUserManager)SpringContextHolder.getBean(HiUser.class);

	public String savePayResponse(int id) throws Exception {

		//�޸Ķ�Ӧ���׼�¼״̬    
		//�Ȳ�ѯ֧��������
	    TblTxPayMentOrder tblTxPayMentOrder  = (TblTxPayMentOrder) tblTxPayMentOrderManagerImpl.getObjectById(id);
		
		//����֧��������
		String PlTxTime = DateTimeUtil.getCurrDateTime();
	
		if(tblTxPayMentOrder.getTxStatus()==OrderTxStatus.ORDERTXSTATUS_PREPAY){
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PREPAYSUCCESS);
			tblTxPayMentOrder.setErrorCode("0001");		//Ԥ֧���ɹ�
		}else{
			tblTxPayMentOrder.setTxStatus(OrderTxStatus.ORDERTXSTATUS_PAYSUCCESS);
			tblTxPayMentOrder.setErrorCode("0002");		//ȷ��֧���ɹ�
		}
		
		tblTxPayMentOrder.setPlTxTime(PlTxTime);
		tblTxPayMentOrder.setCreator(UserContextHelper.getUser());
		tblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));
		tblTxPayMentOrder.setLastUpdatedBy(UserContextHelper.getUser().getId());
		tblTxPayMentOrderManagerImpl.saveTblTxPayMentOrder(tblTxPayMentOrder);
		
		//��¼�����ˮ��
		//��ѯ�̻����������ñ�
		Filter filter = FilterFactory.getSimpleFilter("mchtNo", tblTxPayMentOrder.getMchtNo(), Filter.OPERATOR_EQ);

		List<TblMchtFeeConfig> tblMchtFeeList  = tblMchtFeeConfigMan.getObjects(filter);
		
		TblMchtFeeConfig tblMchtFee = (TblMchtFeeConfig)tblMchtFeeList.get(0);
		
		int mchtFee = 0;
		if(tblMchtFee.getMchtFeeType() == MchtFeeType.MCHTFEETYPE_BYRATE){
			//������
			mchtFee = ((new BigDecimal(tblTxPayMentOrder.getOrderAmount()).multiply(new BigDecimal(tblMchtFee.getRuleValue()).movePointLeft(2))).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();   //���С��
			
			//��ѯ��ֵ�Ƿ���������
			if(mchtFee > tblMchtFee.getMaxVal()){
				mchtFee = tblMchtFee.getMaxVal();
			}else if(mchtFee<tblMchtFee.getMinVal()){
				mchtFee = tblMchtFee.getMinVal();
			}
			
		}else if(tblMchtFee.getMchtFeeType() == MchtFeeType.MCHTFEETYPE_BYTRANS){
			//�̶����
			mchtFee = tblMchtFee.getRuleValue().intValue();
		}
		
		//�������
		Date nowDate = new Timestamp(System.currentTimeMillis());
		Filter pointfilter = FilterFactory.getSimpleFilter("minAmount", tblTxPayMentOrder.getPayAmount(), Filter.OPERATOR_GREATER_EQ);
		
		pointfilter.addCondition("maxAmount", tblTxPayMentOrder.getPayAmount(), Filter.OPERATOR_LESS_EQ)
				.addCondition("startDatetime", nowDate, Filter.OPERATOR_GREATER_EQ)
				.addCondition("endDatetime", nowDate, Filter.OPERATOR_LESS_EQ);

		List<TblMbPointRule> pointConfigList  = tblMbPointRuleMan.getObjects(pointfilter);
		
		TblMbPointRule pointConfig = (TblMbPointRule)pointConfigList.get(0);
		
		int point = 0;
		if(pointConfig.getPointRuleType()== PointRuleType.POINTRULETYPE_BYRATE){
			//������
			point = ((new BigDecimal(tblTxPayMentOrder.getPayAmount()).multiply(new BigDecimal(pointConfig.getRuleValue()).movePointLeft(2))).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();   //���С��
			
		}else if(pointConfig.getPointRuleType() == PointRuleType.POINTRULETYPE_BYTRANS){
			//�̶����
			point = pointConfig.getRuleValue().intValue();
		}
		
		//��¼������ϸ��
			//��ѯhiuser��
		Filter hifilter = FilterFactory.getSimpleFilter("userName", tblTxPayMentOrder.getUserName(), Filter.OPERATOR_GREATER_EQ);
		
		List<HiUser> hiList  = hiMan.getObjects(hifilter);
		
		HiUser hiuser = (HiUser)hiList.get(0);
		
		TblMbPointDetail tblMbPointDetail = new TblMbPointDetail();
		tblMbPointDetail.setTblMbInfo(hiuser);
		tblMbPointDetail.setPoint(point);
		tblMbPointDetail.setPointTxType(PointTxType.POINTTXTYPE_TXPOINT);
		tblMbPointDetail.setVoucherNo(tblTxPayMentOrder.getId());
		tblMbPointDetail.setCreatedDateTime(new Timestamp(System.currentTimeMillis())); //����ʱ��
		tblMbPointDetail.setLastUpdatedBy(hiuser);
		tblMbPointDetail.setCreator(hiuser);
		tblMbPointDetail.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
		tblMbPointDetailMan.saveTblMbPointDetail(tblMbPointDetail);
		
		//���»�Ա���ֱ�
		Filter pointbalfilter = FilterFactory.getSimpleFilter("tblMbInfo", hiuser.getId(), Filter.OPERATOR_GREATER_EQ);
		
		List<TblMbPoint> pointbalList  = tblMbPointMan.getObjects(pointbalfilter);
		
		TblMbPoint pointbal = (TblMbPoint)pointbalList.get(0);
		pointbal.setBalance(pointbal.getBalance()+point);
		tblMbPointMan.saveTblMbPoint(pointbal);
		
		//��¼�����ˮ��
		TblStlCleaningDetail tblStlCleaningDetail = new TblStlCleaningDetail();
		tblStlCleaningDetail.setPlTxTraceNo(tblTxPayMentOrder.getPlTxTraceNo());
		tblStlCleaningDetail.setMchtOrderId(tblTxPayMentOrder.getMchtTxTraceNo());
		tblStlCleaningDetail.setOrderAmount(tblTxPayMentOrder.getOrderAmount());
		tblStlCleaningDetail.setMchtSettleAmount(tblTxPayMentOrder.getOrderAmount()-mchtFee);
		tblStlCleaningDetail.setTransTime(tblTxPayMentOrder.getPlTxTime());		//�������ʱ��
		tblStlCleaningDetail.setUserName(tblTxPayMentOrder.getUserName());
		tblStlCleaningDetail.setBalance(point);			//����
		tblStlCleaningDetail.setMchtNo(tblTxPayMentOrder.getMchtNo());
		tblStlCleaningDetail.setMchtName(tblTxPayMentOrder.getMchtName());
		tblStlCleaningDetail.setFee(mchtFee);			//������
		tblStlCleaningDetail.setPayAmount(tblTxPayMentOrder.getPayAmount());
		tblStlCleaningDetail.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
		tblStlCleaningDetail.setLastUpdatedBy(hiuser.getId());
		tblStlCleaningDetail.setCreator(hiuser);
		tblStlCleaningDetail.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
		tblStlCleaningDetailMan.saveTblStlCleaningDetail(tblStlCleaningDetail);
	
		
		//��ѯid
		Filter cleanfilter = FilterFactory.getSimpleFilter("plTxTraceNo", tblStlCleaningDetail.getPlTxTraceNo(), Filter.OPERATOR_GREATER_EQ);
		
		List<TblStlCleaningDetail> cleanList  = tblStlCleaningDetailMan.getObjects(cleanfilter);
		
		TblStlCleaningDetail cleanDetail = (TblStlCleaningDetail)cleanList.get(0);
		 
		//�����˻�ϵͳ
		PaymentClearingAccountRequest paymentClearingAccountRequest = new PaymentClearingAccountRequest();
		paymentClearingAccountRequest.setAmount(tblStlCleaningDetail.getPayAmount());
		paymentClearingAccountRequest.setBizLogId(cleanDetail.getId());
		paymentClearingAccountRequest.setMchtFee(mchtFee);
		paymentClearingAccountRequest.setMchtNo(tblStlCleaningDetail.getMchtNo());
		paymentClearingAccountRequest.setMchtOrderAmount(tblStlCleaningDetail.getOrderAmount());
		paymentClearingAccountRequest.setUserName(tblStlCleaningDetail.getUserName());
		ICommonAccountResponse accountResponse = ClearingAccountService.doPaymentAccountClearing(paymentClearingAccountRequest);
		
		if(!accountResponse.getRespCode().equals(EAccountResponse.S0000)){
			throw new Exception("�˻�����ʧ��");
		}
		//��װ����
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
		 
		//��¼�̻���Ӧ��Ϣ��
		 TblTxPayMentResponse  tblTxPayMentResponse= new  TblTxPayMentResponse();
			
		//String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
		tblTxPayMentResponse.setTxTypeId(tblTxPayMentOrder.getTxTypeId());
		tblTxPayMentResponse.setMchtNo(tblTxPayMentOrder.getMchtNo());
		tblTxPayMentResponse.setPayDatetime(tblTxPayMentOrder.getPlTxTime());				//�̻���������
		tblTxPayMentResponse.setMerchantOrderNo(tblTxPayMentOrder.getMchtTxTraceNo());
		tblTxPayMentResponse.setOrderAmount(new BigDecimal(tblTxPayMentOrder.getOrderAmount()).intValue());		//��ȷ����

		tblTxPayMentResponse.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
		tblTxPayMentResponse.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
		
		tblTxPayMentResponseMan.saveTblTxPayMentResponse(tblTxPayMentResponse);
		/*
		try{
			 //��¼֧�����֪ͨ��֪ͨ�̻�
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
