/**
 * 
 */
package org.hi.framework.web.taglib.component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei.li
 * 
 */
public class TagInfoBean {
	private Map parameters;
	
	private String name;
	
	private String dateFormat;
	
	private String url;

	private String defaultValue;
	
	private boolean isLabel;

	private String type;
	
	private boolean multiple;
	
	private String onEvent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public boolean isLabel() {
		return isLabel;
	}

	public void setLabel(boolean isLabel) {
		this.isLabel = isLabel;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOnEvent() {
		return onEvent;
	}

	public void setOnEvent(String onEvent) {
		this.onEvent = onEvent;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}


}
