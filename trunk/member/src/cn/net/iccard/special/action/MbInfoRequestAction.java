package cn.net.iccard.special.action;


import javax.servlet.http.HttpServletRequest;

import org.hi.SpringContextHolder;

import org.hi.framework.web.struts.BaseAction;


import cn.net.iccard.special.service.IMbInfoService;
import cn.net.iccard.special.service.impl.MbInfoService;

public class MbInfoRequestAction extends BaseAction{
	
	private IMbInfoService mbInfoService = (IMbInfoService) SpringContextHolder
	.getBean(MbInfoService.class);

	
	
	/**
	 * ����/�޸ı����Ա��Ϣ
	 */
	public String saveTblMbInfo() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		
		//���͵����²�ѯ
		
		mbInfoService.savePageAccountForMemeber(request);
		
		return returnCommand();
	}
	
	
	
	
}
