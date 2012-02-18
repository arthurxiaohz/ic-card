package org.hi.base.organization.model;

import org.hi.base.organization.model.original.HiOrgAbstract;
import org.hi.base.tree.Component;


public class HiOrg extends HiOrgAbstract implements Component{

	public String getComponentName() {
		return this.orgName + ":" + this.id;
	}


	public Component getTarget() {
		return this;
	}


	public Component getTargetParent() {
		return this.parentOrg;
	}
	
    public String getDataSymbol(){
    	return this.orgNum;
    }
}