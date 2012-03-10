package cn.net.iccard.special.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hi.SpringContextHolder;

import org.hi.framework.web.struts.BaseAction;


import cn.net.iccard.special.service.IMbInfoService;
import cn.net.iccard.special.service.IPayResponseService;
import cn.net.iccard.special.service.impl.MbInfoService;
import cn.net.iccard.special.service.impl.PayResponseService;

public class PayResponseAction extends BaseAction{
	
	private IPayResponseService payResponseService = (IPayResponseService) SpringContextHolder
	.getBean(PayResponseService.class);

	
	
	/**
	 * »∑»œ÷ß∏∂
	 */
	public String savePayResponse() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		
		int id = Integer.valueOf(request.getParameter("tblTxPayMentOrder.id"));
		
		payResponseService.savePayResponse(id);
		
		return returnCommand();
	}
	
	
	
	
}
