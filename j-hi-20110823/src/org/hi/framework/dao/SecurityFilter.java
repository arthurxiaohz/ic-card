package org.hi.framework.dao;

/**
 * 该接口继承<code>Filter</code>接口，本接口的目标通过提供统一数据级权限过滤方法
 * <code>getSeurityFilter()</code>实现数据级权限过滤.默认平台提供一个缺省实现
 * 类<code>SecurityFilterImpl</code>,如果您的业务需求平台该实现类无法满足,可以
 * 通过实现该接口自己扩展之.
 * <p>
 * 注意：该接口的实体来不支持有参的构建函数,即不推荐实现类有自己的构建函数.
 * 一但扩展接口,并且在平台配置文件中部署后,则所有数据级权限过滤均按该过滤器执行,
 * 即平台提供的缺省实现过滤器<code>SecurityFilterImpl</code>将被忽略
 * @author 张昊
 * @since 2007-09-15
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.impl.SecurityFilterImpl
 *
 */
public interface SecurityFilter extends Filter {

	/**
	 * 获得数据级权限过滤的过滤器
	 * @return 返回数据级权限过滤的过滤器
	 */
	public Filter getSeurityFilter();
}
