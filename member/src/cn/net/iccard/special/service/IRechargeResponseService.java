package cn.net.iccard.special.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 *��ֵ�ɹ�
 * 
 * 
 */
public interface IRechargeResponseService  extends Manager {



	/**
	 * ��ֵ�ɹ�
	 * 
	 * @return
	 */
	String saveRechargeResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;


	

}
