package cn.net.iccard.special.service;

import javax.servlet.http.HttpServletRequest;

import org.hi.framework.service.Manager;


/**
 * ҳ�濪��
 * 
 * 
 */
public interface IMbInfoService  extends Manager {



	/**
	 * ��Ա����
	 * 
	 * @return
	 */
	boolean savePageAccountForMemeber(
			HttpServletRequest  pageRequest);

	

}
