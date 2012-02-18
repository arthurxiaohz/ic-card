package org.hi.base.report.excel.action.struts;

import java.util.Map;

import org.hi.framework.web.struts.BaseAction;


/**
 * ���������б���action�ĳ���.Ҳ��һ��������,���������������õı�������.
 * <p>������Ϊ�����ռ����չʾ����,�����ռ��õ����ݴ��ݵ���Ӧ�ı���������,
 * �����ɱ������潫����չʾ�ɱ���
 * @author ���
 * @since 2007-10-23
 *
 */   

public abstract class ReportBaseAction extends BaseAction{
	
	/**
	 * �÷����ǵײ㷽��,�����ռ�����Ҫչʾ������
	 * @param model ����ģ��,��һ��<code>Map</code>key:������,value:����
	 */
	abstract void mergedOutputModel(Map<String, Object> model);
	
	/**
	 * �ص�����,���ڻ�ȡ��������׼��������.
	 * ��ֻҪʵ�ָ÷����������ݶ���ָ��ǰaction�������м���.
	 * ��Ȼaction����Щ����Ҫ�ṩ�������������,��get/set����
	 */
	public abstract void prepare();
	
	
}
