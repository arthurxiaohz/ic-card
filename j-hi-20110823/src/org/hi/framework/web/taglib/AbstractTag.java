/**
 * 
 */
package org.hi.framework.web.taglib;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.tagext.TagSupport;

import org.hi.common.util.BeanUtil;

/**
 * @author wei.li
 * 
 */
public abstract class AbstractTag extends TagSupport {
    protected Map parameters = new HashMap();
	protected String cssClass;

	protected String cssStyle;
	
	protected String id;
	
	protected String size = "15";

	protected String title;

	protected String disabled;

	protected String label;

	protected String labelPosition;

	protected String requiredposition;

	protected String name;

	protected String required;

	protected String tabindex;

	protected String value;

	protected String template;

	protected String theme;

	protected String templateDir;

	protected String onclick;

	protected String ondblclick;

	protected String onmousedown;

	protected String onmouseup;

	protected String onmouseover;

	protected String onmousemove;

	protected String onmouseout;

	protected String onfocus;

	protected String onblur;

	protected String onkeypress;

	protected String onkeydown;

	protected String onkeyup;

	protected String onselect;

	protected String onchange;

	protected String accesskey;

	protected String tooltip;

	protected String tooltipConfig;

	public String getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelPosition() {
		return labelPosition;
	}

	public void setLabelPosition(String labelPosition) {
		this.labelPosition = labelPosition;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	} 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return ondblclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		return onkeypress;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return onkeyup;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		return onmousemove;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		return onmouseup;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getOnselect() {
		return onselect;
	}

	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getRequiredposition() {
		return requiredposition;
	}

	public void setRequiredposition(String requiredposition) {
		this.requiredposition = requiredposition;
	}

	public String getTabindex() {
		return tabindex;
	}

	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getTooltipConfig() {
		return tooltipConfig;
	}

	public void setTooltipConfig(String tooltipConfig) {
		this.tooltipConfig = tooltipConfig;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
    protected String findString(String expr) {
        return (String) findValue(expr, String.class);
    }
    
    protected String findValue(String expr, Class toType){
    	return expr;
    }
    
   public void evaluateParams() {
	   
	   addParameter("templateDir", getTemplateDir());
	   
       if (this.name != null) {
           addParameter("name", findString(this.name));
       }
       
       if (this.id != null){
    	   addParameter("id", findString(this.id));
       }
       
        if (label != null) {
            addParameter("label", findString(label));
        }

        if (labelPosition != null) {
            addParameter("labelposition", findString(labelPosition));
        }

        if (requiredposition != null) {
            addParameter("requiredposition", findString(requiredposition));
        }

        if (required != null) {
            addParameter("required", findValue(required, Boolean.class));
        }

        if (disabled != null) {
            addParameter("disabled", findValue(disabled, Boolean.class));
        }

        if (tabindex != null) {
            addParameter("tabindex", findString(tabindex));
        }

        if (onclick != null) {
            addParameter("onclick", findString(onclick));
        }

        if (ondblclick != null) {
            addParameter("ondblclick", findString(ondblclick));
        }

        if (onmousedown != null) {
            addParameter("onmousedown", findString(onmousedown));
        }

        if (onmouseup != null) {
            addParameter("onmouseup", findString(onmouseup));
        }

        if (onmouseover != null) {
            addParameter("onmouseover", findString(onmouseover));
        }

        if (onmousemove != null) {
            addParameter("onmousemove", findString(onmousemove));
        }

        if (onmouseout != null) {
            addParameter("onmouseout", findString(onmouseout));
        }

        if (onfocus != null) {
            addParameter("onfocus", findString(onfocus));
        }

        if (onblur != null) {
            addParameter("onblur", findString(onblur));
        }

        if (onkeypress != null) {
            addParameter("onkeypress", findString(onkeypress));
        }

        if (onkeydown != null) {
            addParameter("onkeydown", findString(onkeydown));
        }

        if (onkeyup != null) {
            addParameter("onkeyup", findString(onkeyup));
        }

        if (onselect != null) {
            addParameter("onselect", findString(onselect));
        }

        if (onchange != null) {
            addParameter("onchange", findString(onchange));
        }
        
        if (accesskey != null) {
        	addParameter("accesskey", findString(accesskey));
        }

        if (cssClass != null) {
            addParameter("class", findString(cssClass));
        }

        if (cssStyle != null) {
            addParameter("style", findString(cssStyle));
        }

        if (title != null) {
            addParameter("title", findString(title));
        }
   }

   /**
    * Get's the parameters.
    * @return the parameters. Is never <tt>null</tt>.
    */
   public Map getParameters() {
       return parameters;
   }

   /**
    * Add's all the given parameters to this componenets own parameters.
    * @param params the parameters to add.
    */
   public void addAllParameters(Map params) {
       parameters.putAll(params);
   }

   /**
    * Add's the given key and value to this components own parameter.
    * <p/>
    * If the provided key is <tt>null</tt> nothing happends.
    * If the provided value is <tt>null</tt> any existing parameter with
    * the given key name is removed.
    * @param key  the key of the new parameter to add.
    * @param value the value assoicated with the key.
    */
   public void addParameter(String key, Object value) {
       if (key != null) {
           Map params = getParameters();

           if (value == null) {
               params.remove(key);
           } else {
               params.put(key, value);
           }
       }
   }
   
   public Object getParameter(String parameterName){
	   return getParameter(parameterName, null);
   }
   public Object getParameter(String parameterName,String prefix){
		Object value = pageContext.getRequest().getParameter(parameterName);
		if( value != null)
			return value;
		
		if(parameterName.indexOf(".") > 0){
			String attributeName = parameterName.substring(0, parameterName.indexOf("."));
			if(attributeName != null && pageContext.getRequest().getAttribute(attributeName) !=null){
				value = BeanUtil.getPropertyValue(pageContext.getRequest().getAttribute(attributeName), parameterName.substring(parameterName.indexOf(".") +1));
			}
		}
		
		if( value != null)
			return value;
			
		if(prefix == null)
			return null;
		
		Object attribute = pageContext.getRequest().getAttribute(prefix);
		return BeanUtil.getPropertyValue(attribute, parameterName);
		
		
		
  }
}
