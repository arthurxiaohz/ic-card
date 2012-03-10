package cn.net.iccard.special.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 * ³·Ïú
 * 
 * 
 */
public interface IRevocationResponseService  extends Manager {



	/**
	 * ³·Ïú
	 * 
	 * @return
	 */
	String saveRevocationResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;

	

}
