package org.hi.framework.service;

/**
 * �ýӿ���һ��ͳһ�Ļص��ӿ�����,�������ڵ����κ�<code>Manager.removeObject()</code>����֮�󶼻��
 * �øýӿڵľ�������ʵ�ֶ�ɾ��֮���ͳһ����.������Ҫ��ÿһ��manager���ɾ�������ж�Ҫͨ������Ĵ���
 * ��ʵ�֣�������������˿����Ĺ�����,���ʹ�øûص��ӿ�,�Ϳ��Խ���ɢ�Ĵ����γ�һ������,�ɸýӿڵľ���ͳ
 * һʵ��.�����ṩ��һ���ýӿ�ʵ����ľ���������μ�<code>org.hi.framework.service.impl.SimplePostRemoveObjectCallback</code>
 * <p>�ýӿ�ʵ����ľ���������WEB-INF/config/appContext.xml�ļ�,<br>
 * &lt;bean id="org.hi.framework.service.PostRemoveObjectCallback" class="org.hi.framework.service.impl.SimplePostRemoveObjectCallback"/&gt;
 * @author ���
 * @since 2011-5-26
 * @see org.hi.framework.service.impl.SimplePostRemoveObjectCallback
 * @see org.hi.framework.service.impl.AbstractBaseManager.postRemoveObject()
 *
 */
public interface PostRemoveObjectCallback {
	/**
	 * ɾ����������֮��Ļص�����
	 * @param obj ��ɾ���Ķ���
	 */
	public void removePostObjectProcess(Object obj);
}
