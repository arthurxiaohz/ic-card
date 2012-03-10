package cn.net.iccard.special.service;


import org.hi.framework.service.Manager;


/**
 * 确认支付
 * 
 * 
 */
public interface IPayResponseService  extends Manager {



	/**
	 * 确认支付
	 * 
	 * @return
	 */
	String savePayResponse(int id)throws Exception;


	

}
