/**
 * 
 */
package org.hi.framework.web.taglib.component.bean;

import java.util.Map;

import org.hi.framework.web.taglib.component.TagInfoBean;

/**
 * @author wei.li
 * 
 */
public class SelectTagBean extends TagInfoBean {

	private Map mapping;
	private String lookup;
	private boolean isBr;
	private boolean allSelected;
	public Map getMapping() {
		return mapping;
	}

	public void setMapping(Map mapping) {
		this.mapping = mapping;
	}

	public String getLookup() {
		return lookup;
	}

	public void setLookup(String lookup) {
		this.lookup = lookup;
	}

	public boolean isBr() {
		return isBr;
	}

	public void setBr(boolean isBr) {
		this.isBr = isBr;
	}

	public boolean isAllSelected() {
		return allSelected;
	}

	public void setAllSelected(boolean allSelected) {
		this.allSelected = allSelected;
	}

}
