package org.hi.base.menu.strutsmenu;

import java.util.Map;

import org.hi.framework.dao.Filter;

/**
 * 该接口是菜单树的过滤接口，即在当前节点收集下级节点的数据之前,调用该接口方法<code>MenuFilterProcessor</code>以
 * 返回一个过滤器，该过滤器会自动的参与到对下级节点的数据收集中去，以实现条件过滤.
 * 
 * <p>该接口与<code>MenuCollectionProcessor</code>区别在于该接口是在收集数据之前调用，返回一个过滤器
 * @author 张昊
 * @since 2011-0218
 *
 */
public interface MenuFilterProcessor {
	/**
	 * 该方法会在收集数据之前调用,是一个回调接口，根据返回的过滤器，在收集时会将该过滤自动加入查询条件之中去
	 * @param parameters 该参数是一个Map,是request对象中的参数转换得来的，因此可能过url动态的传入数据，从而在该方法中使用
	 * @return 返回一个过滤器
	 */
	public Filter getFilter(Map<String, String> parameters);
}
