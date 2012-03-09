package cn.net.iccard.special.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 *充值成功
 * 
 * 
 */
public interface IRechargeResponseService  extends Manager {



	/**
	 * 充值成功
	 * 
	 * @return
	 */
	String saveRechargeResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;


	

}
