package cn.net.iccard.special.service;

import javax.servlet.http.HttpServletRequest;

import org.hi.framework.service.Manager;


/**
 * 页面开户
 * 
 * 
 */
public interface IMbInfoService  extends Manager {



	/**
	 * 会员开户
	 * 
	 * @return
	 */
	boolean savePageAccountForMemeber(
			HttpServletRequest  pageRequest);

	

}
