package org.hi.common.tools.highcharts;

import javax.servlet.http.HttpServletRequest;

/**
 * 图型处理器接口,该接口的作用在于在页面标签上指定该接口的实现类,例如<p>
 * &lt;hi:chart processor="org.hi.TestProcessor"/&gt;其中TestPorcessor就是该接口的实现类.
 * 该接口的主要目的是通过实现该接口,从而获取一个图型执行器.处理器与执行器的区别在于,处理器提供了页面端的调用,即在
 * &lt;hi:chart&gt;标签中定义该处理器类的全限定名,而处理器的主要目的就是将数据封装为一个执行器,底层引擎会根据该执行器
 * 封装的数据返回一个符合Highchart要求的JSON对象.
 * 该接口的实现类用例如下：<p>
 * &nbsp;&nbsp;&nbsp; public ChartExecutor getExecutor(HttpServletRequest request) {<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;String[] categoriesArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;List&lt;String&gt; categories = Arrays.asList(categoriesArray);<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;ColumnExecutor executor = new ColumnExecutor("各城市湿度统计",categories,"Temperature (°C)", "°C");<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] tokyo = {7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] newYork = {-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] berlin = {-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Double[] london = {3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8};<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("东京", Arrays.asList(tokyo));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("纽约", Arrays.asList(newYork));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("波兰", Arrays.asList(berlin));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;executor.addSerieElement("伦郭", Arrays.asList(london));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;return executor;<br>&nbsp;&nbsp; &nbsp;}
 * @author 张昊
 * @since 2011-08-18
 * @see org.hi.common.tools.highcharts.ChartExecutor
 */
public interface ChartProcessor {

	/**
	 * 通过该方法将图型数据封装到执行器中,并将该执行器的对象返回
	 * @param request 一个HttpServletRequest对象,可以通过该对象获取待封装的参数
	 * @return 返回图型执行器
	 */
	public ChartExecutor getExecutor(HttpServletRequest request);

}
