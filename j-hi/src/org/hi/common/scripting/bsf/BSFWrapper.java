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
	 * Ϊ�����ռ���ӵ��õİ���
	 * @param classPath ����
	 */
	public void setClassPath(String classPath){
		this.bsfManager.setClassPath(classPath);
	}
	
	/**
	 * ִ�и����Ľű�,����ִ�к�Ľ������
	 * @param script �ű��ַ���
	 * @return ���ض�ִ̬�к�Ľ��
	 * @throws BSFException
	 */
	public Object eval(String script) throws BSFException{
		return this.bsfManager.eval(this.language, "", 0, 0, script);
	}
	
	/**
	 * ��ȡ����ģ��,һ������ģ�;���һ��Map
	 * �������Ϊ���Ǳ�����,��ֵ���Ǹñ��������õĶ���
	 * @return ��������ģ��
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
