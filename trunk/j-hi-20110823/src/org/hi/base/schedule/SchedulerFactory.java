package org.hi.base.schedule;


/**
 * 任务调度器工厂的接口,其目的是创建一个任务调度器及管理该任务调度的生命期.
 * 任务调度器的创建由其子孙类实现之,以保证采用不同任务框架的差异性
 * 在该接口仅提供对创建后的任务调度器的生命期进行管理,如通过<code>start()</code>开始任务调度
 * <code>stop()</code>停止任务调用
 * 
 * @author 张昊
 * @since 2007-9-19
 *
 */
public interface SchedulerFactory {
	
	/**
	 * 重新启动该任务调度器,该方法是为运行时调用,即在运行时可以
	 * 通过调用该方法实现该任务调试器的重启
	 * @throws Exception
	 */
	public void restart() throws Exception;
	
	/**
	 * 检测该任务调度器是否正在运行
	 * @return 如果该任务调度器正在运行则返回true,否则返回false
	 * @throws Exception
	 */
	public boolean isRunning() throws Exception;
	
	/**
	 * 启动任务调度器
	 * @throws Exception
	 */
	public void start() throws Exception;
	
	/**
	 *  停止任务调度器
	 * @throws Exception
	 */
	public void stop() throws Exception;
	
	/**
	 *  关闭任务调度器
	 * @throws Exception
	 */
	public void shutdown() throws Exception;
}
