package org.hi.framework.service;

/**
 * �ýӿ���һ��ͳһ�Ļص��ӿ�����,�������ڵ����κ�<code>Manager.saveObject()</code>����֮ǰ�����
 * �øýӿڵľ�������ʵ�ֶԱ���֮ǰ��ͳһ����.�ٸ����ӱ���������ϵͳ��ÿһ�ű�Ҫ��һ��updateDate�ֶ�
 * �����һ�θü�¼���޸�ʱ��,������ṩ�ýӿ�,������Ҫ��ÿһ��manager��ı��淽���ж�Ҫͨ������Ĵ���
 * ��ʵ�֣�������������˿����Ĺ�����,���ʹ�øûص��ӿ�,�Ϳ��Խ���ɢ�Ĵ����γ�һ������,�ɸýӿڵľ���ͳ
 * һʵ��.�����ṩ��һ���ýӿ�ʵ����ľ���������μ�<code>org.hi.framework.service.impl.SimplePreSaveObjectCallback</code>
 * <p>�ýӿ�ʵ����ľ���������WEB-INF/config/appContext.xml�ļ�,<br>
 * &nbsp;&nbsp; &lt;bean id="org.hi.framework.service.PreSaveObjectCallback" class="org.hi.framework.service.impl.SimplePreSaveObjectCallback"/&gt;<br><br>
 * @author ���
 * @since 2011-5-26
 * @see org.hi.framework.service.impl.SimplePreSaveObjectCallback
 * @see org.hi.framework.service.impl.AbstractBaseManager.preSaveObject()
 *
 */
public interface PreSaveObjectCallback {
	/**
	 * �����������֮ǰ�Ļص�����
	 * @param obj ���������
	 */
	public void savePreObjectProcess(Object obj);
}
