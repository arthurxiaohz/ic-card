package cn.net.iccard.special.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;

import org.hi.framework.web.struts.BaseAction;


import cn.net.iccard.special.service.IBackResponseService;
import cn.net.iccard.special.service.impl.BackResponseService;

public class BackResponseAction extends BaseAction{
	
	private IBackResponseService backResponseService = (IBackResponseService) SpringContextHolder
	.getBean(BackResponseService.class);

	
	
	/**
	 * ÍË¿îÈ·ÈÏ
	 */
	public String saveBack() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		
		backResponseService.saveBackResponse(request, response);
		
		return returnCommand();
	}
	
	
	
	
}
