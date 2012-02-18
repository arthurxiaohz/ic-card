package org.hi.base.menu.strutsmenu;

import java.util.Collection;
import java.util.Map;

/**
 * 在菜单树的集合处理器，因为树型结构每一层的节点都会收集下一级节点的集合，可以通过该接口对收集的集合
 * 进行过滤或添加。简单的说该接口是一个回调接口，每次收集下级节点的数据时均会调用该接口的方法，从而树
 * 的数据更有可控性
 * <p>该接口与<code>MenuFilterProcessor</code>区别在于该接口是在收集数据之后调用，返回一个集合
 * @author 张昊
 * @since 2011-0218
 * @see org.hi.base.menu.strutsmenu.MenuFilterProcessor
 *
 */
public interface MenuCollectionProcessor {
	/**
	 * 在收集完下级节点的数据之后，会调用该方法以实现对收集后的数据的再处理
	 * @param coll 当前节点下一级节点的数据集合
	 * @param parameters 该参数是一个Map,是request对象中的参数转换得来的，因此可能过url动态的传入数据，从而在该方法中使用
	 * @return 返回处理过的一个集合对象
	 */
	public Collection getCollection(Collection coll, Map<String, String> parameters);
}
