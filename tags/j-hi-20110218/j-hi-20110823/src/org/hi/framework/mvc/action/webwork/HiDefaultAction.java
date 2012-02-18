package org.hi.framework.mvc.action.webwork;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.hi.framework.web.BusinessException;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.util.I18NUtil;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlContextState;
import com.opensymphony.xwork.util.OgnlValueStack;

public class HiDefaultAction extends BaseAction {
	
	private String actionName;
	private String actionMethod;
	private String resultType = "dispatcher";
	private String resultValue;
	

	public String execute() throws Exception {
		BaseAction action = null;
		String type = SUCCESS;
		try {
            Class clazz = Class.forName(actionName);
            action = (BaseAction) clazz.newInstance();
        } catch (Exception e) {
           throw new BusinessException(I18NUtil.getStringByParameter("Action����ʧ��", actionName));
        }
        if(action!=null) {
        	ActionContext ac =  ActionContext.getContext();
            final Map parameters = ac.getParameters();
            if (parameters != null) {
            	Map contextMap = ac.getContextMap();
                try {
                	OgnlContextState.setCreatingNullObjects(contextMap, true);
                	OgnlContextState.setDenyMethodExecution(contextMap, true);
                	OgnlContextState.setReportingConversionErrors(contextMap, true);

                    OgnlValueStack stack = ac.getValueStack();
                    stack.push(action);
                    setParameters(action, stack, parameters);
                } finally {
                	OgnlContextState.setCreatingNullObjects(contextMap, false);
                	OgnlContextState.setDenyMethodExecution(contextMap, false);
                	OgnlContextState.setReportingConversionErrors(contextMap, false);
                }
                
                if(actionMethod == null)
                	type = action.execute();
                else{
                	Method method = action.getClass().getMethod(actionMethod, new Class[]{});
                	type = (String)method.invoke(action, new Object[]{});
                }
            }
        }
        
		return type;
	}
	protected void setParameters(Object action, OgnlValueStack stack, final Map parameters) {
        for (Iterator iterator = (new TreeMap(parameters)).entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String name = entry.getKey().toString();

            Object value = entry.getValue();
            try {
                stack.setValue(name, value);
            } catch (Exception e) {
                throw new BusinessException(I18NUtil.getStringByParameter("Action����ֵʱ����", name));
            }
        }
    }
	
	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return the actionMethod
	 */
	public String getActionMethod() {
		return actionMethod;
	}

	/**
	 * @param actionMethod the actionMethod to set
	 */
	public void setActionMethod(String actionMethod) {
		this.actionMethod = actionMethod;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * @return the resultValue
	 */
	public String getResultValue() {
		return resultValue;
	}

	/**
	 * @param resultValue the resultValue to set
	 */
	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}


}
