package org.hi.framework.dao;

/**
 * �ýӿڼ̳�<code>Filter</code>�ӿڣ����ӿڵ�Ŀ��ͨ���ṩͳһ���ݼ�Ȩ�޹��˷���
 * <code>getSeurityFilter()</code>ʵ�����ݼ�Ȩ�޹���.Ĭ��ƽ̨�ṩһ��ȱʡʵ��
 * ��<code>SecurityFilterImpl</code>,�������ҵ������ƽ̨��ʵ�����޷�����,����
 * ͨ��ʵ�ָýӿ��Լ���չ֮.
 * <p>
 * ע�⣺�ýӿڵ�ʵ������֧���вεĹ�������,�����Ƽ�ʵ�������Լ��Ĺ�������.
 * һ����չ�ӿ�,������ƽ̨�����ļ��в����,���������ݼ�Ȩ�޹��˾����ù�����ִ��,
 * ��ƽ̨�ṩ��ȱʡʵ�ֹ�����<code>SecurityFilterImpl</code>��������
 * @author ���
 * @since 2007-09-15
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.impl.SecurityFilterImpl
 *
 */
public interface SecurityFilter extends Filter {

	/**
	 * ������ݼ�Ȩ�޹��˵Ĺ�����
	 * @return �������ݼ�Ȩ�޹��˵Ĺ�����
	 */
	public Filter getSeurityFilter();
}
