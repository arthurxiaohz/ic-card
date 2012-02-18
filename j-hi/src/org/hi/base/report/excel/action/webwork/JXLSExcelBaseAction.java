package org.hi.base.report.excel.action.webwork;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.beanutils.PropertyUtils;
import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.service.ExcelReportDesignManager;
import org.hi.common.util.BeanUtil;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.web.BusinessException;
import org.hi.i18n.util.I18NUtil;

/**
 * ����̳�<code>ReportBaseAction</code>����ʵ��Excel�ı���չʾ
 * 
 * @author ���
 * @since 2007-10-23
 * @see org.hi.base.report.excel.action.webwork.ReportBaseAction
 * 
 */

public abstract class JXLSExcelBaseAction extends ReportBaseAction {
	public static final String DEFAULT_CONTENT_TYPE = "application/vnd.ms-excel";
	private XLSTransformer transFormer = new XLSTransformer();
	
	private String filename;
	
	private String templetFile;

	private String contenttype;
	
	private Map<String, Object> model;
	
	public String getContenttype() {
		if(contenttype==null)
			contenttype = DEFAULT_CONTENT_TYPE;
		return contenttype;
	}

	public String getFilename() {
		return filename;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public String getTempletFile() {
		return templetFile;
	}

	public XLSTransformer getTransFormer() {
		if(transFormer==null)
			transFormer = new XLSTransformer();
		return transFormer;
	}


	public final String execute() throws Exception {
		String actionName = this.getClass().getName();
		ExcelReportDesignManager erdMgr = (ExcelReportDesignManager) SpringContextHolder
				.getBean(ExcelReportDesign.class);

		// action���ȫ�޶���Ϊ��ǰaction�����ǿ��õı���ģ��
		Filter filter = FilterFactory.getSimpleFilter("actionName", actionName,
				Filter.OPERATOR_EQ).addCondition("enabled", YesNo.YESNO_YES,
				Filter.OPERATOR_EQ);
		;
		List erds = erdMgr.getObjects(filter);
		if (erds.size() == 0)
			throw new BusinessException(I18NUtil.getStringByParameter("δ�ҵ�Action", "ExcelReportDesign", actionName));

		// �ص�������,�ռ�actoin�е����Զ���
		prepare();

		ExcelReportDesign drd = (ExcelReportDesign) erds.get(0);
		model = new HashMap<String, Object>();
		mergedOutputModel(model);
		//�õ�ģ����
		filename = drd.getTemplate().substring(drd.getTemplate().lastIndexOf("/"), drd.getTemplate().length());
		//�õ�ģ��ȫ·��
		templetFile = this.getRequest().getSession().getServletContext().getRealPath("/") + drd.getTemplate();
		return returnCommand();
	}
	
	void mergedOutputModel(Map<String, Object> model) {

		HttpServletRequest request = this.getRequest();
		HttpSession session = this.getSession();
		Object value = null;

		// request parameter ����
		for (Enumeration en = request.getParameterNames(); en.hasMoreElements();) {
			String parameterName = (String) en.nextElement();

			if (request.getParameter(parameterName) != null)
				value = getParameter(parameterName);
			if (request.getParameterValues(parameterName) != null)
				value = request.getParameterValues(parameterName);

			if (value != null)
				model.put(parameterName, value);

			value = null;
		}

		// request Attribute ����
		for (Enumeration en = request.getAttributeNames(); en.hasMoreElements();) {
			String attributeName = (String) en.nextElement();
			value = request.getAttribute(attributeName);
			if (value != null)
				model.put(attributeName, value);
		}

		// session Attribute ����
		for (Enumeration en = session.getAttributeNames(); en.hasMoreElements();) {
			String attributeName = (String) en.nextElement();
			value = session.getAttribute(attributeName);
			if (value != null)
				model.put(attributeName, value);
		}

		// ��ǰaction �������� �� ����
		PropertyDescriptor[] actionProperties = PropertyUtils
				.getPropertyDescriptors(this);
		for (PropertyDescriptor actionDescriptor : actionProperties) {
			String propertyName = actionDescriptor.getName();
			value = BeanUtil.getPropertyValue(this, propertyName);
			if (value != null)
				model.put(propertyName, value);
		}

	}

	// public abstract void prepare();

}
