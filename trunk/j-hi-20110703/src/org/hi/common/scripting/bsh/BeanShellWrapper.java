package org.hi.common.scripting.bsh;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import bsh.BshClassManager;
import bsh.EvalError;
import bsh.Interpreter;
import bsh.NameSpace;

/**
 * 该类是BeanShell的包装器,目的是使调用BeanShell的java脚本更方便.
 * 该包装器主要包装的对象是<code>Interpreter</code>类，该类实现对字符串型
 * 的java代码或表达式动态执行.
 * <p>例如：
 *  BeanShellFactory.createBeanShell().eval("1 == 1");
 * @author 张昊
 * @since 2007-10-24
 * @see bsh.Interpreter
 *
 */
public class BeanShellWrapper extends ClassLoader {

	Interpreter interpreter = new Interpreter();
	BshClassManager classMgr = BshClassManager.createClassManager(this.interpreter);
	NameSpace nameSpace = new NameSpace(classMgr, "improt_package"+hashCode());
	Map<String, Object> model;
	BeanShellWrapper(Map<String, Object> model) throws EvalError{
		BeanShellWrapper(model);
	}
	
	BeanShellWrapper(String name, Object obj) throws EvalError{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(name, obj);
		BeanShellWrapper(model);
	}
	

	BeanShellWrapper() throws EvalError{
		BeanShellWrapper(null);
	}
	
	private void BeanShellWrapper(final Map<String, Object> model) throws EvalError{
		this.model = model;
		Package[] packages = this.getPackages();
		for (Package importPackage : packages) {
			String pagkageName = importPackage.getName();
			nameSpace.importPackage(pagkageName);
		}
		
		if(model != null){
			Set<String> keySet = model.keySet();
			for (String key : keySet) {
				this.interpreter.set(key, model.get(key));
			}
		}
	}
	
	/**
	 * 为命名空间添加导用的包名
	 * @param pagkageName 包名
	 */
	public void importPackage(String pagkageName){
		nameSpace.importPackage(pagkageName);
	}
	
	/**
	 * 执行给定的java脚本,并将执行后的结果返回
	 * @param script 脚本字符串
	 * @return 返回动态执行后的结果
	 * @throws EvalError
	 */
	public Object eval(String script) throws EvalError{
		return this.interpreter.eval(script);
	}
	
	/**
	 * 获取数据模型,一组数据模型就是一个Map
	 * 可以理解为键是变量名,而值则是该变量所引用的对象
	 * @return 返回数据模型
	 */
	public Map<String, Object> getModel(){
		return this.model;
	}
	
	public void put(String key, Object value) throws EvalError{
		if(this.model == null)
			this.model = new HashMap<String, Object>();
		this.model.put(key, value);
		this.interpreter.set(key, value);
	}
	
	public void remove(String key){
		if(this.model == null || this.model.size() == 0)
			return;
		
		this.model.remove(key);
	}
	
	public Object get(String key){
		return this.model.get(key);
	}
	
}
