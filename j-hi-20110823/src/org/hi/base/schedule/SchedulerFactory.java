package org.hi.base.schedule;


/**
 * ��������������Ľӿ�,��Ŀ���Ǵ���һ������������������������ȵ�������.
 * ����������Ĵ�������������ʵ��֮,�Ա�֤���ò�ͬ�����ܵĲ�����
 * �ڸýӿڽ��ṩ�Դ����������������������ڽ��й���,��ͨ��<code>start()</code>��ʼ�������
 * <code>stop()</code>ֹͣ�������
 * 
 * @author ���
 * @since 2007-9-19
 *
 */
public interface SchedulerFactory {
	
	/**
	 * �������������������,�÷�����Ϊ����ʱ����,��������ʱ����
	 * ͨ�����ø÷���ʵ�ָ����������������
	 * @throws Exception
	 */
	public void restart() throws Exception;
	
	/**
	 * ��������������Ƿ���������
	 * @return �����������������������򷵻�true,���򷵻�false
	 * @throws Exception
	 */
	public boolean isRunning() throws Exception;
	
	/**
	 * �������������
	 * @throws Exception
	 */
	public void start() throws Exception;
	
	/**
	 *  ֹͣ���������
	 * @throws Exception
	 */
	public void stop() throws Exception;
	
	/**
	 *  �ر����������
	 * @throws Exception
	 */
	public void shutdown() throws Exception;
}
