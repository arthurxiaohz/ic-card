package org.hi.framework.service;

/**
 * 该接口是一个统一的回调接口声明,作用是在调用任何<code>Manager.saveObject()</code>方法之前都会调
 * 用该接口的具体类以实现对保存之前的统一处理.举个例子比如在您的系统中每一张表都要加一个updateDate字段
 * 即最后一次该记录的修改时间,如果不提供该接口,您可能要在每一个manager类的保存方法中都要通过具体的代码
 * 来实现，这样大大增加了开发的工作量,如果使用该回调接口,就可以将离散的代码形成一个切向,由该接口的具体统
 * 一实体.我们提供了一个该接口实现类的具体用例请参见<code>org.hi.framework.service.impl.SimplePreSaveObjectCallback</code>
 * <p>该接口实现类的具体配置在WEB-INF/config/appContext.xml文件,<br>
 * &nbsp;&nbsp; &lt;bean id="org.hi.framework.service.PreSaveObjectCallback" class="org.hi.framework.service.impl.SimplePreSaveObjectCallback"/&gt;<br><br>
 * @author 张昊
 * @since 2011-5-26
 * @see org.hi.framework.service.impl.SimplePreSaveObjectCallback
 * @see org.hi.framework.service.impl.AbstractBaseManager.preSaveObject()
 *
 */
public interface PreSaveObjectCallback {
	/**
	 * 保存给定对象之前的回调方法
	 * @param obj 待保存对象
	 */
	public void savePreObjectProcess(Object obj);
}
