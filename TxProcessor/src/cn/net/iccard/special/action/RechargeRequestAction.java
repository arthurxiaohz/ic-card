package cn.net.iccard.special.action;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import com.alipay.services.AlipayService;

import cn.net.iccard.member.model.RechargeTxStatus;
import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import cn.net.iccard.member.service.TblMbInfoManager;
import cn.net.iccard.member.service.TblMbRechargeOrderManager;
import cn.net.iccard.member.service.TblMbTransactionRequestManager;
import cn.net.iccard.member.service.impl.TblMbInfoManagerImpl;
import cn.net.iccard.member.service.impl.TblMbRechargeOrderManagerImpl;
import cn.net.iccard.special.service.IRechargeResponseService;
import cn.net.iccard.special.service.impl.RechargeService;
import cn.net.iccard.util.BankTraceNoGererator;
import cn.net.iccard.util.DateUtil;
import cn.net.iccard.util.PLTraceNoGererator;

//��ֵ����

public class RechargeRequestAction extends BaseAction{
	
	private IRechargeResponseService rechargeResponseService = (IRechargeResponseService) SpringContextHolder
	.getBean(RechargeService.class);


	
	//���ճֿ���������
	public String getMemberRequest() throws Exception {
		
		//1.ȡ�óֿ�������
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		
//		    Filter filter = FilterFactory.getSimpleFilter("userName", hiUser.getUserName(), Filter.OPERATOR_EQ);
		    
		    Filter filter = FilterFactory.getSimpleFilter("userName", UserContextHelper.getUser().getUserName(), Filter.OPERATOR_EQ);
		    
		//��ѯ������Ϣ
//		    TblMbInfoPageInfo TblMbInfo = new TblMbInfoPageInfo();
//		    TblMbInfo.setF_plNo(org.hi.framework.security.context.UserContextHelper.getUser().getUserName());
//			
//			Filter Filter = PageInfoUtil.populateFilter(TblMbInfo);
			System.out.println(filter);
			TblMbInfoManager TblMbInfoManager =(TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
			List list  = TblMbInfoManager.getObjects(filter);
			
			//��¼��ֵ���󣬲���������
			TblMbInfo tblMbInfo = (TblMbInfo)list.get(0);
			TblMbRechargeOrderManager TblMbRechargeOrderManagerImpl = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
			TblMbRechargeOrder tblMbRechargeOrder = new TblMbRechargeOrder();
			
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			
			tblMbRechargeOrder.setPlTxTraceNo(plTxTraceNo);
			tblMbRechargeOrder.setUserName(UserContextHelper.getUser().getUserName());
			tblMbRechargeOrder.setAccountNo(tblMbInfo.getCardNo());
			tblMbRechargeOrder.setPan(tblMbInfo.getCardNo());
			tblMbRechargeOrder.setChinfo(UserContextHelper.getUser().getFullName());
			tblMbRechargeOrder.setTxTypeId("TX51");
			tblMbRechargeOrder.setTxAmount(Integer.valueOf(new BigDecimal(request.getParameter("tblMbRechargeOrder.txAmount")).movePointRight(2).toString()));
			tblMbRechargeOrder.setMchtTxTime(DateUtil.getCurrDateTime());
			
			tblMbRechargeOrder.setTxStatus(RechargeTxStatus.RECHARGETXSTATUS_PAYPROCESS);
			tblMbRechargeOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			//tblTxPayMentRequest.setLastUpdatedBy();     	//����޸���
			tblMbRechargeOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblMbRechargeOrderManagerImpl.saveTblMbRechargeOrder(tblMbRechargeOrder);
			
			
			//2.��¼���������
			TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);

			TblMbTransactionRequest mbTransactionRequest = new TblMbTransactionRequest();
			String requestId = BankTraceNoGererator.generateALiPayTraceNo("02");
			
			mbTransactionRequest.setOrderId(requestId);		//���ض�����
			mbTransactionRequest.setTrancode("TX51");		//��������
			//mbTransactionRequest.setMchtNo(mchtNo);
			mbTransactionRequest.setPan(tblMbInfo.getCardNo());
			mbTransactionRequest.setChinfo(UserContextHelper.getUser().getFullName());
			mbTransactionRequest.setPlTxTraceNo(plTxTraceNo);
			mbTransactionRequest.setTxStatus(RechargeTxStatus.RECHARGETXSTATUS_PAYPROCESS);
			mbTransactionRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			//tblTxPayMentRequest.setLastUpdatedBy();     	//����޸���
			mbTransactionRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			tblMbTransactionRequestMgr.saveTblMbTransactionRequest(mbTransactionRequest);
			/*
			//������������������
			Map<String, String> sParaTemp = new HashMap<String, String>();
			
			 sParaTemp.put("payment_type", "1");
		     sParaTemp.put("out_trade_no", requestId);
		     sParaTemp.put("subject", "��ֵ");
		     sParaTemp.put("total_fee", request.getParameter("tblMbRechargeOrder.txAmount"));
		     ServletOutputStream out = response.getOutputStream();
			//����֧����
			String sHtmlText = AlipayService.create_direct_pay_by_user(sParaTemp,requestId);
			out.write(sHtmlText.toString().getBytes("UTF-8"));
			out.flush();
			out.close();
			*/
			request.setAttribute("out_trade_no", requestId);
			request.setAttribute("total_fee", request.getParameter("tblMbRechargeOrder.txAmount"));
			
			//��ֵ�ɹ�
			RechargeService RechargeService = new RechargeService();
			RechargeService.saveRechargeResponse(request, response);
			
			return returnCommand();
		}
		
	/**
	 * ��ֵ�ɹ�
	 */
	public String saveRecharge(HttpServletRequest request,HttpServletResponse response) throws Exception {

//		HttpServletRequest request = getRequest();
//		HttpServletResponse response = getResponse();
		
		rechargeResponseService.saveRechargeResponse(request, response);
		
		return returnCommand();
	}
	
}