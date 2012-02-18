package org.hi.common.tools.highcharts;

import org.hi.common.tools.highcharts.context.HighChart;

/**
 * ͼ��ִ�����ӿ�,�ýӿڹ淶ͼ��ִ�����Ĵ�����ʽ,��Բ�ͬ��ͼ�����ͻ��в�ͬ��ͼ��ִ����.
 * �������ͼ��ִ����ΪPieExecutor,����ͼ��ִ����ΪLineExecutor,����ͼ��ִ����ΪColumnExecutor.��Щ��ƽ̨���ݾ���ͼ��
 * ���ṩ��ȱʡִ����,ͨ��ʵ�ָýӿ���Ҳ����ͨ����չ�ķ�ʽ�������Լ���ִ����
 * @author ���
 * @since 2011-08-18
 * @see org.hi.common.tools.highcharts.ChartProcessor
 * @see org.hi.common.tools.highcharts.impl.PieExecutor
 * @see org.hi.common.tools.highcharts.impl.LineExecutor
 * @see org.hi.common.tools.highcharts.impl.ColumnExecutor
 */
public interface ChartExecutor {

	/**
	 * ��ȡ��ִ��������Ӧ��Highcharts��JSON����
	 * @param containerName  ��������,��Ӧ&lt;hi:chart&gt;��ǩ�е�idֵ
	 * @return ����Highcharts��JSON����
	 */
	public String toChartJson(String containerName);
	
	/**
	 * ���ش������,�ö����java�ṹ����Highcharts��JSON�ṹ����ȫ��ͬ,
	 * ͨ���Ըô����������ֵ�����ͻ�Ӱ��Highcharts��JSON����
	 * @return ����HighChart�������
	 * @see org.hi.common.tools.highcharts.context.HighChart
	 */
	public HighChart getProxyObject();
}
