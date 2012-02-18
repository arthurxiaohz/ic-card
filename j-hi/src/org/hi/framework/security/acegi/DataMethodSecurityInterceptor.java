package org.hi.framework.security.acegi;

import java.io.IOException;
import java.util.List;

import org.acegisecurity.intercept.ObjectDefinitionSource;
import org.acegisecurity.intercept.method.MethodDefinitionSource;
import org.acegisecurity.intercept.method.MethodDefinitionSourceEditor;
import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;

public class DataMethodSecurityInterceptor extends MethodSecurityInterceptor {
	
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
		Filter filter = FilterFactory.getSimpleFilter("businessLayer", null, Filter.OPERATOR_NOT_EQ).addCondition("businessLayer", "", Filter.OPERATOR_NOT_EQ, Filter.RELATION_AND);
		List<PrivilegeResource> privilegeResources = prMgr.getObjects(filter);
		if(privilegeResources.size() == 0)
			return;
		
		MethodDefinitionSourceEditor mdsEditor = new MethodDefinitionSourceEditor();
		StringBuffer sb = new StringBuffer();
		for (PrivilegeResource privilegeResource : privilegeResources) {
			sb.append(privilegeResource.getBusinessLayer()).append("=").append(privilegeResource.getAuthorityName());
			if(privilegeResource.getBizExtAuthNames() != null && !privilegeResource.getBizExtAuthNames().trim().equals("")){
				sb.append(",").append(privilegeResource.getBizExtAuthNames());
			}
			sb.append("\n");
		}
		
		mdsEditor.setAsText(sb.toString());
		this.setObjectDefinitionSource((MethodDefinitionSource) mdsEditor.getValue());
		isComplete = true;
	}
	
	public ObjectDefinitionSource obtainObjectDefinitionSource(){
		if(!isComplete)
			return new SetupDefinitionSource();
		return super.obtainObjectDefinitionSource();
		 
	 }
}
