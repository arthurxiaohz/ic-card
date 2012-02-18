package org.hi.framework.mvc.action.webwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.webwork.dispatcher.WebWorkResultSupport;
import com.opensymphony.webwork.dispatcher.mapper.ActionMapper;
import com.opensymphony.webwork.dispatcher.mapper.ActionMapperFactory;
import com.opensymphony.webwork.dispatcher.mapper.ActionMapping;
import com.opensymphony.webwork.views.util.UrlHelper;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.config.entities.ResultConfig;

public class CommonWebworkResult extends WebWorkResultSupport{

	private String resultType = "dispatcher";
	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		resultType = (String)invocation.getStack().findValue("resultType");
		if(resultType.equals("redirect")) {
			redirect(finalLocation,invocation);
		}else if(resultType.equals("redirect-action")){//²»ÄÜÖ´ÐÐ
			redirectAction(finalLocation,invocation);
		}else {
			dispatcher(finalLocation,invocation);
		}
	}

	private void redirectAction(String finalLocation,ActionInvocation invocation) throws Exception{
		String actionName = null;
	    String namespace = null;
	    String method = null;
	    List prohibitedResultParam = Arrays.asList(new String[] {
	    		DEFAULT_PARAM, "namespace", "method", "encode", "parse", "location", 
	    		"prependServletContext" });
		
	    actionName = conditionalParse(actionName, invocation);
        if (namespace == null) {
            namespace = invocation.getProxy().getNamespace();
        } else {
            namespace = conditionalParse(namespace, invocation);
        }
        if (method == null) {
        	method = "";
        }
        else {
        	method = conditionalParse(method, invocation);
        }
        
        Map requestParameters = new HashMap();
        ResultConfig resultConfig = (ResultConfig) invocation.getProxy().getConfig().getResults().get(
        		invocation.getResultCode());
        Map resultConfigParams = resultConfig.getParams();
        for (Iterator i = resultConfigParams.entrySet().iterator(); i.hasNext(); ) {
        	Map.Entry e = (Map.Entry) i.next();
        	if (! prohibitedResultParam.contains(e.getKey())) {
        		requestParameters.put(e.getKey().toString(), 
        				e.getValue() == null ? "": 
        					conditionalParse(e.getValue().toString(), invocation));
        	}
        }
        
        ActionMapper mapper = ActionMapperFactory.getMapper();
        StringBuffer tmpLocation = new StringBuffer(mapper.getUriFromActionMapping(new ActionMapping(actionName, namespace, method, null)));
        UrlHelper.buildParametersString(requestParameters, tmpLocation, "&");
        
        location = tmpLocation.toString();
        redirect(finalLocation,invocation);
	}
	
	private void redirect(String finalLocation, ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);

        if (isPathUrl(finalLocation)) {
            if (!finalLocation.startsWith("/")) {
                String namespace = ActionMapperFactory.getMapper().getMapping(request).getNamespace();

                if ((namespace != null) && (namespace.length() > 0) && (!"/".equals(namespace))) {
                    finalLocation = namespace + "/" + finalLocation;
                } else {
                    finalLocation = "/" + finalLocation;
                }
            }

            finalLocation = response.encodeRedirectURL(finalLocation);
        }

        response.sendRedirect(finalLocation);
	}
	
	private static boolean isPathUrl(String url) {
        return (url.indexOf(':') == -1);
    }
	
	private void dispatcher(String finalLocation, ActionInvocation invocation) throws Exception {
		PageContext pageContext = ServletActionContext.getPageContext();

        if (pageContext != null) {
            pageContext.include(finalLocation);
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            RequestDispatcher dispatcher = request.getRequestDispatcher(finalLocation);

            // if the view doesn't exist, let's do a 404
            if (dispatcher == null) {
                response.sendError(404, "result '" + finalLocation + "' not found");

                return;
            }

            // If we're included, then include the view
            // Otherwise do forward 
            // This allow the page to, for example, set content type 
            if (!response.isCommitted() && (request.getAttribute("javax.servlet.include.servlet_path") == null)) {
                request.setAttribute("webwork.view_uri", finalLocation);
                request.setAttribute("webwork.request_uri", request.getRequestURI());

                dispatcher.forward(request, response);
            } else {
                dispatcher.include(request, response);
            }
        }
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
	

}
