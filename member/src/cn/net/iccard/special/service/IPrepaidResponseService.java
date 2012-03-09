package cn.net.iccard.special.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 * 预支付确认
 * 
 * 
 */
public interface IPrepaidResponseService  extends Manager {



	/**
	 * 预支付确认
	 * 
	 * @return
	 */
	String savePrepaidResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;

	

}
