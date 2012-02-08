package org.hi.common.tools;

/**
 * ����ƥ�����Ĳ��Խӿ�.
 * <p>�����˼����,ͨ�������Ķ�����ģ����ƥ��.ģ�屾����ṩ��ͬ��ͨ���
 * @author ���
 * @since 2007-11-22
 *
 */
public interface Matcher {
	
	/**
	 * �����Ĳ����Ƿ����ģ���ʽ
	 * @param pattern ��ȷ�ϵ�ģ��
	 * @return �������ģ���ʽ����true,���򷵻�false
	 */
	boolean isPattern(String pattern);
	
	/**
	 * ͨ��������ģ���ж϶���ֵ�Ƿ����ģ����ƥ��
	 * @param pattern ����ģ��
	 * @param value ��ƥ��Ķ���
	 * @return ���������ģ��ƥ�䷵��true,���򷵻�false
	 */
	boolean match(String pattern, Object value);
}
