package cn.net.iccard.special.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.framework.service.Manager;


/**
 * Ԥ֧��ȷ��
 * 
 * 
 */
public interface IPrepaidResponseService  extends Manager {



	/**
	 * Ԥ֧��ȷ��
	 * 
	 * @return
	 */
	String savePrepaidResponse(
			HttpServletRequest  pageRequest,HttpServletResponse response)throws Exception;

	

}
