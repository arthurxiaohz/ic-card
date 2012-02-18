package org.hi.common.scripting.bsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.bsf.BSFException;
import org.apache.bsf.BSFManager;

public class BSFWrapper extends ClassLoader {
	
	BSFManager bsfManager = new BSFManager();
	String language;
	Map<String, Object> model;
	
	BSFWrapper(String language, Map<String, Object> model) throws BSFException{
		BSFWrapper(language, model);
	}
	
	BSFWrapper(String language, String name, Object obj) throws BSFException{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(name, obj);
		BSFWrapper(language, model);
	}
	

	BSFWrapper(String language) throws BSFException{
		BSFWrapper(language, null);
	}
	
	private void BSFWrapper(final String language, final Map<String, Object> model) throws BSFException{
		this.model = model;
		this.language = language == null ? BSFFactory.BSF_LANGUAGE_BEANSHELL : language;
		Package[] packages = this.getPackages();
		for (Package importPackage : packages) {
			String pagkageName = importPackage.getName();
			bsfManager.setClassPath(pagkageName);
		}
		
		if(model != null){
			Set<String> keySet = model.keySet();
			for (String key : keySet) {
				this.bsfManager.declareBean(key, model.get(key), model.get(key).getClass());
			}
		}
	}
	
	/**
	 * 为命名空间添加导用的包名
	 * @param classPath 包名
	 */
	public void setClassPath(String classPath){
		this.bsfManager.setClassPath(classPath);
	}
	
	/**
	 * 执行给定的脚本,并将执行后的结果返回
	 * @param script 脚本字符串
	 * @return 返回动态执行后的结果
	 * @throws BSFException
	 */
	public Object eval(String script) throws BSFException{
		return this.bsfManager.eval(this.language, "", 0, 0, script);
	}
	
	/**
	 * 获取数据模型,一组数据模型就是一个Map
	 * 可以理解为键是变量名,而值则是该变量所引用的对象
	 * @return 返回数据模型
	 */
	public Map<String, Object> getModel(){
		return this.model;
	}
	
	public void put(String key, Object value) throws BSFException{
		if(this.model == null)
			this.model = new HashMap<String, Object>();
		this.model.put(key, value);
		this.bsfManager.declareBean(key, value, value.getClass());
	}
	
	public void remove(String key) throws BSFException{
		if(this.model == null || this.model.size() == 0)
			return;
		this.model.remove(key);
		this.bsfManager.undeclareBean(key);
	}
	
	public Object get(String key){
		return this.model.get(key);
	}
}
