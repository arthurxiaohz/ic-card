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
	 * 新增/修改保存会员信息
	 */
	public String saveTblMbInfo() throws Exception {
//		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
//		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
//		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
//		super.postExecute(tblMbInfo);
		HttpServletRequest request = getRequest();
		
		//发送到线下查询
		
		boolean flag = mbInfoService.savePageAccountForMemeber(request);
		if(!flag){
			request.setAttribute("error", "用户名重复");
			return ERROR;
		}else{
			request.setAttribute("success", "用户名注册成功，请登录");
			return SUCCESS;
		}
		
		//return returnCommand();
	}
	
	
	
	
}
