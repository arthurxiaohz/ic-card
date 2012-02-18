package org.hi.framework.mvc.action.struts;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.StrutsResultSupport;
import org.apache.struts2.dispatcher.mapper.ActionMapper;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;

public class CommonStrutsResult extends StrutsResultSupport{

	private String resultType = "dispatcher";
	
	 protected ActionMapper actionMapper;
	 
	 @Inject
	    public void setActionMapper(ActionMapper mapper) {
	        this.actionMapper = mapper;
	    }

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
		redirect(finalLocation,invocation);
	}
	
	private void redirect(String finalLocation, ActionInvocation invocation) throws Exception {
		 ActionContext ctx = invocation.getInvocationContext();
	        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
	        HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);

	        if (isPathUrl(finalLocation)) {
	            if (!finalLocation.startsWith("/")) {
	                ActionMapping mapping = actionMapper.getMapping(
	                        request, Dispatcher.getInstance().getConfigurationManager()); 
	                String namespace = null;
	                if (mapping != null) {
	                    namespace = mapping.getNamespace();
	                }

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
