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

//��ֵ����

public class RechargeRequestAction extends BaseAction{
	private TblTxPayMentRequest tblTxPayMentRequest;
	private TblTxPayMentRequestPageInfo pageInfo;
	private List<TblTxPayMentRequest> tblTxPayMentRequests;
	private String orderIndexs;
	

	
	//���ճֿ���������
	public void getMemberRequest() throws Exception {
		
		//1.ȡ�óֿ�������
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
		    
		//��ѯ������Ϣ
//		    TblMbInfoPageInfo TblMbInfo = new TblMbInfoPageInfo();
//		    TblMbInfo.setF_plNo(org.hi.framework.security.context.UserContextHelper.getUser().getUserName());
//			
//			Filter Filter = PageInfoUtil.populateFilter(TblMbInfo);
			System.out.println(filter);
			TblMbInfoManagerImpl TblMbInfoManagerImpl =(TblMbInfoManagerImpl)SpringContextHolder.getBean(TblMbInfoManager.class);
			List list  = TblMbInfoManagerImpl.getObjects(TblMbInfo.class,filter);
			
			//��¼��ֵ���󣬲���������
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
			tblMbRechargeOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			//tblTxPayMentRequest.setLastUpdatedBy();     	//����޸���
			tblMbRechargeOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			TblMbRechargeOrderManagerImpl.saveTblMbRechargeOrder(tblMbRechargeOrder);
			
			
			//2.��¼���������
			TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);

			TblMbTransactionRequest mbTransactionRequest = new TblMbTransactionRequest();
			String requestId = PLTraceNoGererator.generatePLTraceNo("01");
			
			mbTransactionRequest.setTrancode("TX51");		//��������
			//mbTransactionRequest.setMchtNo(mchtNo);
			mbTransactionRequest.setPan(tblMbInfo.getCardNo());
			mbTransactionRequest.setChinfo(UserContextHelper.getUser().getFullName());
			mbTransactionRequest.setPlTxTraceNo(plTxTraceNo);
			mbTransactionRequest.setTxStatus("1");
			mbTransactionRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //����ʱ��
			//tblTxPayMentRequest.setLastUpdatedBy();     	//����޸���
			mbTransactionRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//����޸�ʱ��
			
			tblMbTransactionRequestMgr.saveTblMbTransactionRequest(mbTransactionRequest);
			
			//������������������
			Map<String, String> sParaTemp = new HashMap<String, String>();
			//����֧����
			String sHtmlText = AlipayService.create_direct_pay_by_user(sParaTemp);
		}
		
	
	//Ԥ֧�� ȷ��
	public void upfrontCostAffirm() throws Exception {
		

	   
		//1.ȡ��������Ϣ
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		 try {
		      request.setCharacterEncoding("GBK");
		      String contentType = new StringBuffer("text/html; charset=").append("GBK").toString();
		      response.setContentType(contentType);
		    } catch (Exception e) {
		      //logger.error("", e);
		    }
			
		//ȡ��������Ϣ�������˻�ϵͳ���пۿ�ۿ�ɹ���
		String msg = request.getParameter("TxInfo");			//������
		String Signature = request.getParameter("Signature");	//����ǩ��
		String TxType = request.getParameter("TxType");			//��������
		
		//�޸Ķ�Ӧ���׼�¼״̬    
		//�Ȳ�ѯ֧��������
		
		TblTxPayMentOrderPageInfo tblTxPayMentOrderPageInfo= new TblTxPayMentOrderPageInfo();
		
		tblTxPayMentOrderPageInfo.setF_mchtTxTraceNo(request.getParameter("plTxTraceNo"));
		
		Filter Filter = PageInfoUtil.populateFilter(tblTxPayMentOrderPageInfo);
		System.out.println(Filter);
		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		List list  = TblTxPayMentOrderManagerImpl.getObjects(TblTxPayMentOrder.class,Filter);
		
		//����֧��������
		TblTxPayMentOrder TblTxPayMentOrder = (TblTxPayMentOrder)list.get(0);
		TblTxPayMentOrder.setTxStatus(2);
		TblTxPayMentOrder.setLastUpdatedBy(Integer.valueOf(request.getParameter("username")));
		
		//��¼֧�����֪ͨ��֪ͨ�̻�
		
		
		
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
