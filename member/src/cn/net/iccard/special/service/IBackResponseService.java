package cn.net.iccard.special.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 * ÍË¿î
 * 
 * 
 */
public interface IBackResponseService  extends Manager {



	/**
	 * ÍË¿î
	 * 
	 * @return
	 */
	String saveBackResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;


	

}
