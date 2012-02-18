package org.hi.common.tools.highcharts;

import javax.servlet.http.HttpServletRequest;

/**
 * ͼ�ʹ������ӿ�,�ýӿڵ�����������ҳ���ǩ��ָ���ýӿڵ�ʵ����,����<p>
 * &lt;hi:chart processor="org.hi.TestProcessor"/&gt;����TestPorcessor���Ǹýӿڵ�ʵ����.
 * �ýӿڵ���ҪĿ����ͨ��ʵ�ָýӿ�,�Ӷ���ȡһ��ͼ��ִ����.��������ִ��������������,�������ṩ��ҳ��˵ĵ���,����
 * &lt;hi:chart&gt;��ǩ�ж���ô��������ȫ�޶���,������������ҪĿ�ľ��ǽ����ݷ�װΪһ��ִ����,�ײ��������ݸ�ִ����
 * ��װ�����ݷ���һ������HighchartҪ���JSON����.
 * �ýӿڵ�ʵ�����������£�<p>
 * &nbsp;&nbsp;&nbsp; public ChartExecutor getExecutor(HttpServletRequest request) {<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;String[] categoriesArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;List&lt;String&gt; categories = Arrays.asList(categoriesArray);<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;ColumnExecutor executor = new ColumnExecutor("������ʪ��ͳ��",categories,"Temperature (��C)", "��C");<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] tokyo = {7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] newYork = {-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] berlin = {-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] london = {3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("����", Arrays.asList(tokyo));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("ŦԼ", Arrays.asList(newYork));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("����", Arrays.asList(berlin));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("�׹�", Arrays.asList(london));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;return executor;<br>&nbsp;&nbsp; &nbsp;}
 * @author ���
 * @since 2011-08-18
 * @see org.hi.common.tools.highcharts.ChartExecutor
 */
public interface ChartProcessor {

	/**
	 * ͨ���÷�����ͼ�����ݷ�װ��ִ������,������ִ�����Ķ��󷵻�
	 * @param request һ��HttpServletRequest����,����ͨ���ö����ȡ����װ�Ĳ���
	 * @return ����ͼ��ִ����
	 */
	public ChartExecutor getExecutor(HttpServletRequest request);

}
