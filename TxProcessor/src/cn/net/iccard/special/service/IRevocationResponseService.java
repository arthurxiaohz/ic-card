package cn.net.iccard.special.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 * ����
 * 
 * 
 */
public interface IRevocationResponseService  extends Manager {



	/**
	 * ����
	 * 
	 * @return
	 */
	String saveRevocationResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;

	

}
