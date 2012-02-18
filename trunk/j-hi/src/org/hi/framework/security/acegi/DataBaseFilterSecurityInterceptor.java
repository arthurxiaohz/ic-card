package org.hi.framework.security.acegi;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.intercept.ObjectDefinitionSource;
import org.acegisecurity.intercept.web.FilterInvocationDefinitionSource;
import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
import org.hi.SpringContextHolder;
import org.hi.common.util.StringUtils;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;
import org.hi.framework.util.DataInputStreamUtil;
import org.hi.framework.web.ServletContext;
import org.springframework.core.io.Resource;

public class DataBaseFilterSecurityInterceptor extends
		FilterSecurityInterceptor {
	
	private boolean load = true;
	private boolean isComplete = false;
	
	public void setLoad(boolean load) throws IOException {
		this.load = load;
		this.setObjectDefinitionSource();
	}
	
	protected void setObjectDefinitionSource() throws IOException{
		if(!load)
			return;
		
		PrivilegeResourceManager prMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		Filter filter = FilterFactory.getSimpleFilter("viewLayer", null, Filter.OPERATOR_NOT_EQ).addCondition("viewLayer", "", Filter.OPERATOR_NOT_EQ, Filter.RELATION_AND);
		List<PrivilegeResource> privilegeResources = prMgr.getObjects(filter);
		if(privilegeResources.size() == 0)
			return;
		
		HiFilterInvocationDefinitionSourceEditor fidsEditor = new HiFilterInvocationDefinitionSourceEditor();
		StringBuffer sb = new StringBuffer();
		for (PrivilegeResource privilegeResource : privilegeResources) {
			sb.append(privilegeResource.getViewLayer()).append("=").append(privilegeResource.getAuthorityName());
			if(privilegeResource.getVeiwExtAuthNames() != null && !privilegeResource.getVeiwExtAuthNames().trim().equals("")){
				sb.append(",").append(privilegeResource.getVeiwExtAuthNames());
			}
			sb.append("\n");
		}

		fidsEditor.setAsText(sb.toString());
		this.setObjectDefinitionSource((FilterInvocationDefinitionSource) fidsEditor.getValue());
		isComplete = true;
	}
	
	public ObjectDefinitionSource obtainObjectDefinitionSource(){
		if(!isComplete)
			return new SetupDefinitionSource();
		return super.obtainObjectDefinitionSource();
		 
	 }
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    	ServletContext.setRequest((HttpServletRequest)request);
    	ServletContext.setResponse((HttpServletResponse)response);
    	super.doFilter(request, response, chain);
    }
}
