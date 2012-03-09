package cn.net.iccard.special.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;

import org.hi.framework.web.struts.BaseAction;


import cn.net.iccard.special.service.IRevocationResponseService;
import cn.net.iccard.special.service.impl.RevocationResponseService;

public class RevocationResponseAction extends BaseAction{
	
	private IRevocationResponseService revocationResponse = (IRevocationResponseService) SpringContextHolder
	.getBean(RevocationResponseService.class);

	
	/**
	 * 处理撤销确认
	 */
	public String saveRevocationResponse() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		
		revocationResponse.saveRevocationResponse(request, response);
		
		return returnCommand();
	}
	
	
	
	
}
