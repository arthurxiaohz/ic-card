package org.hi.framework.web.webwork;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hi.common.util.DesUtils;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;

import com.opensymphony.webwork.WebWorkStatics;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.NoParameters;

public class ParametersInterceptor extends
		com.opensymphony.xwork.interceptor.ParametersInterceptor {
	protected void before(ActionInvocation invocation) throws Exception {
		if ((invocation.getAction() instanceof NoParameters)) {
			super.before(invocation);
			return;
		}
		
		if(!HiConfigHolder.getPublished() || !HiConfigHolder.getUrlEncrypt()){ //������Ƿ���ģʽ��������
			super.before(invocation);
			return;
		}
		
        ActionContext ac = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)ac.getContext().get(WebWorkStatics.HTTP_REQUEST);
        String urlQueryString = request.getQueryString();
        if(urlQueryString == null || urlQueryString.equals("")){ //���URLû��?����Ĳ���
        	super.before(invocation);
        	return;
        }
        if(StringUtils.isIncludes(urlQueryString, "=,&")){ //�������=&url�ؼ��־ʹ���û�мӹ���,���Բ�������
        	super.before(invocation);
        	return;
        }
        
        DesUtils des = new DesUtils(); 
        String parametersStr = des.decrypt(urlQueryString);  //���ܴ���
        String[] parameterStr = parametersStr.split("[&]"); //�ָ��������
        final Map<String, String> parameters = ac.getParameters();
        for (int i = 0; i < parameterStr.length; i++) {
        	String[] keyValue = parameterStr[i].split("[=]"); //�ָ�����ֵ
        	
        	
        	if(keyValue.length < 2) //��˵��ֻ��nameû��ֵ��abc=
        		continue;
        	
        	String key = keyValue[0];
        	String value = keyValue[1];
        	if(key == null || value == null || key.length() == 0 || value.length() == 0)
        		continue;
        	parameters.put(key, value);
		}
        parameters.remove(urlQueryString);  //������Map�еļ��ܺ��keyɾ��,��ΪURL:xxx?79606f42a2e744ecc0����дֻ��key��value
        parameters.put(BaseAction.UNCODE_PARAMETER_KEY, urlQueryString); //�����ܵ�һ��keyvalue�ӵ�parameters��

        
        super.before(invocation);
	}
}
