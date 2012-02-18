package org.hi.framework.security.context;

import javax.servlet.http.HttpServletRequest;

import org.hi.framework.dao.Filter;
import org.hi.framework.security.model.UserAuthority;

/**
 * �ýӿ����Զ���Ȩ�޷�Χ��Ȩ�޴�����,���ڶ����ɫ��Ȩ���û���Ȩʱ,����ڷ�Χ������ѡ���Զ���Ȩ�޷�Χʱ
 * �ͻ���ҳ���������Ȩ�޴��������ı���,�ڸ��ı���������ýӿ������ȫ�޶���.��ԭ������˵,Ȩ�޴������޷���
 * �ص��ýӿڵ����������Է���һ��������,ϵͳ���Զ����ù������Զ����Ϊ���ݿ�Ĳ�ѯ����.
 * @author ���
 * @since 2011-8-15
 * @org.hi.framework.security.context.PrivilegeProcessorFactory
 *
 */
public interface PrivilegeProcessor {
	/**
	 * ���Ȩ�޷�Χ���Զ���Ȩ�޷�Χ,ϵͳ���Զ����ø÷���,��ͨ���÷������صĹ���������������ѯ
	 * @param request Http��Request����,�Է��㶯̬��ȡһЩ��̬�Ĳ�ѯֵ
	 * @param userAuthority ��Ȩ�޴���������Ӧ���û�Ȩ��,�ڸò���������Ի�ǰ��ȡȨ����Ϣ
	 * @return ����һ��Ȩ�޵Ĺ�����
	 */
	public Filter getPrivilegeFilter(HttpServletRequest request, UserAuthority userAuthority);
}
