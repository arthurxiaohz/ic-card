package org.hi.framework.service;

/**
 * 该接口是一个统一的回调接口声明,作用是在调用任何<code>Manager.removeObject()</code>方法之后都会调
 * 用该接口的具体类以实现对删除之后的统一处理.您可能要在每一个manager类的删除方法中都要通过具体的代码
 * 来实现，这样大大增加了开发的工作量,如果使用该回调接口,就可以将离散的代码形成一个切向,由该接口的具体统
 * 一实体.我们提供了一个该接口实现类的具体用例请参见<code>org.hi.framework.service.impl.SimplePostRemoveObjectCallback</code>
 * <p>该接口实现类的具体配置在WEB-INF/config/appContext.xml文件,<br>
 * &lt;bean id="org.hi.framework.service.PostRemoveObjectCallback" class="org.hi.framework.service.impl.SimplePostRemoveObjectCallback"/&gt;
 * @author 张昊
 * @since 2011-5-26
 * @see org.hi.framework.service.impl.SimplePostRemoveObjectCallback
 * @see org.hi.framework.service.impl.AbstractBaseManager.postRemoveObject()
 *
 */
public interface PostRemoveObjectCallback {
	/**
	 * 删除给定对象之后的回调方法
	 * @param obj 待删除的对象
	 */
	public void removePostObjectProcess(Object obj);
}
