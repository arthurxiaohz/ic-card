package org.hi.framework.security.model;

import org.hi.framework.security.model.original.PrivilegeResourceAbstract;


public class PrivilegeResource extends PrivilegeResourceAbstract{

	public void setAuthorityName(String authorityName){
		authorityName = authorityName == null ? null : authorityName.trim();
		super.setAuthorityName(authorityName);
	}
	
	
	public void setViewLayer(String viewLayer){
		viewLayer = viewLayer == null ? null : viewLayer.trim();
		super.setViewLayer(viewLayer);
	}
	
	
	 public void setVeiwExtAuthNames(String veiwExtAuthNames){
		 veiwExtAuthNames = veiwExtAuthNames == null ? null : veiwExtAuthNames.trim();
		 super.setVeiwExtAuthNames(veiwExtAuthNames);
	 }
	 
	 public void setBusinessLayer(String businessLayer){
		 businessLayer = businessLayer == null ? null : businessLayer.trim();
		 super.setBusinessLayer(businessLayer);
	 }
	 
	 public void setBizExtAuthNames(String bizExtAuthNames){
		 bizExtAuthNames = bizExtAuthNames == null ? null : bizExtAuthNames.trim();
		 super.setBusinessLayer(bizExtAuthNames);
	 }
}