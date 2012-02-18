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
		
		if(!HiConfigHolder.getPublished() || !HiConfigHolder.getUrlEncrypt()){ //如果不是发布模式或不做加密
			super.before(invocation);
			return;
		}
		
        ActionContext ac = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)ac.getContext().get(WebWorkStatics.HTTP_REQUEST);
        String urlQueryString = request.getQueryString();
        if(urlQueryString == null || urlQueryString.equals("")){ //如果URL没有?后面的参数
        	super.before(invocation);
        	return;
        }
        if(StringUtils.isIncludes(urlQueryString, "=,&")){ //如果包含=&url关键字就代表没有加过密,所以不做处理
        	super.before(invocation);
        	return;
        }
        
        DesUtils des = new DesUtils(); 
        String parametersStr = des.decrypt(urlQueryString);  //解密处理
        String[] parameterStr = parametersStr.split("[&]"); //分隔多个参数
        final Map<String, String> parameters = ac.getParameters();
        for (int i = 0; i < parameterStr.length; i++) {
        	String[] keyValue = parameterStr[i].split("[=]"); //分隔键和值
        	
        	
        	if(keyValue.length < 2) //这说明只有name没有值如abc=
        		continue;
        	
        	String key = keyValue[0];
        	String value = keyValue[1];
        	if(key == null || value == null || key.length() == 0 || value.length() == 0)
        		continue;
        	parameters.put(key, value);
		}
        parameters.remove(urlQueryString);  //将参数Map中的加密后的key删除,因为URL:xxx?79606f42a2e744ecc0这样写只有key无value
        parameters.put(BaseAction.UNCODE_PARAMETER_KEY, urlQueryString); //将加密的一组keyvalue加到parameters中

        
        super.before(invocation);
	}
}
