package cn.net.iccard.special.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 * �˿�
 * 
 * 
 */
public interface IBackResponseService  extends Manager {



	/**
	 * �˿�
	 * 
	 * @return
	 */
	String saveBackResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;


	

}
