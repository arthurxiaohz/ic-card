package org.hi.common.scripting.bsh;

import java.util.Map;

import bsh.EvalError;

/**
 * BeanShell包装器的工作厂类,用于创建BeanShell包装器类
 * @author 张昊
 * @since 2007-10-24
 *
 */
public class BeanShellFactory {

	public static BeanShellWrapper createBeanShell(Map<String, Object> model) throws EvalError{
		return new BeanShellWrapper(model);
	}
	
	public static BeanShellWrapper createBeanShell(String name, Object obj) throws EvalError{
		return new BeanShellWrapper(name, obj);
	}
	
	public static BeanShellWrapper createBeanShell() throws EvalError{
		return new BeanShellWrapper();
	}
	

}
