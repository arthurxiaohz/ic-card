package org.hi.framework.web.taglib;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.sf.navigator.displayer.MenuDisplayer;
import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.MenuRepository;
import net.sf.navigator.taglib.UseMenuDisplayerTag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.RequestUtils;
import org.hi.base.menu.strutsmenu.AbstractMenuTreeManager;
import org.hi.base.menu.strutsmenu.SysMenuTreeManager;
import org.hi.base.menu.strutsmenu.WebDynamicTreeManager;

/**
 *
 * <p>The major behavior of this tag is to set the value for the usage in the
 * HTML hyperlink 'href' attribute. The value is determined by the following
 * attributes defined in menu-config.xml, in this prioritize order:
 * 'location', 'page', 'forward', 'action'.
 *
 * <p>You can now define a 'forward' or  'action' attribute in the
 * &lt;Item&gt; element in your menu-config.xml. The 'action' attribute takes
 * the value of a Logical Struts Action name for which to look up the
 * context-relative URI. The resultant URI will carry the Context
 * Path (if any), Module Prefix (if any), Session ID (if any),
 * and Servlet Mapping (path mapping or extension mapping). Here is
 * an example:
 * <pre>
 * &lt;Menu name="indexMenuMore" title="More Examples"&gt;
 *   &lt;Item name="actionExample"  title="Example - 'action' attribute"
 *         <B>action="/menu/bullet"</B>/&gt;
 *   &lt;Item name="pageExample" title="Example - 'page' attribute"
 *         <B>page="/bulletmenu.jsp"</B>/&gt;
 * &lt;/Menu&gt;
 * </pre>
 * @author ssayles, mraible
 * @version $Revision: 1.1 $ $Date: 2009/05/01 05:53:51 $
 */
public class DisplayMenuTag extends TagSupport {
	//~ Instance fields ========================================================

	private Log log = LogFactory.getLog(DisplayMenuTag.class);
	
    protected static final String PRIVATE_REPOSITORY =
        "net.sf.navigator.repositoryKey";

    protected static ResourceBundle messages =
        ResourceBundle.getBundle("net.sf.navigator.taglib.LocalStrings");
    
	/** Holds value of property name. */
	private String name;

	/** Holds value of property target. */
	private String target;

	private String menuName;
	
	private String cssStyle;
	
	//~ Constructors ===========================================================
	
	private String type;
	/** Creates new DisplayMenuTag */
	public DisplayMenuTag() {
	}
	
	//~ Methods ================================================================


	/** Getter for property name.
	 * @return Value of property name.
	 */
	public String getName() {
		return name;
	}


	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	/** Setter for property name.
	 * @param name New value of property name.
	 */
	public void setName(String name) {
		if (log.isDebugEnabled()) {
			log.debug("setting name to: " + name);
		}

		this.name = name;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** Getter for property target.
	 * @return Value of property target.
	 */
	public String getTarget() {
		return target;
	}

	/** Setter for property target.
	 * @param target New value of property target.
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	
	public int doStartTag() throws JspException {
        MenuDisplayer displayer =
            (MenuDisplayer) pageContext.getAttribute(UseMenuDisplayerTag.DISPLAYER_KEY);

    if (displayer == null) {
        throw new JspException("Could not retrieve the menu displayer.");
    }

    pageContext.getRequest().setAttribute("cssStyle", cssStyle);
    // This is set by the parent tag - UseMenuDisplayerTag
    MenuRepository repository =
        (MenuRepository) pageContext.getAttribute(PRIVATE_REPOSITORY);

    if (repository == null) {
        throw new JspException("Could not obtain the menu repository");
    }

		MenuComponent menu =
			(MenuComponent) pageContext.findAttribute(this.name);
		
		if(menu == null && menuName != null){
			AbstractMenuTreeManager treemgr = null;
			if(type.equals("sys"))
				treemgr=new SysMenuTreeManager();
			else
				treemgr = new WebDynamicTreeManager();
			try {
				//¼ÓURL²ÎÊý
				ServletRequest request = pageContext.getRequest();
				HashMap parMap = new HashMap();
				Enumeration enumeration = request.getParameterNames();
				while (enumeration.hasMoreElements()) {
					String element = (String) enumeration.nextElement();
					if ( !"type".equals(element) & !"menuName".equals(element))
					parMap.put(element, request.getParameter(element));
				}
				
				
				pageContext.setAttribute(this.name,treemgr.getMenu(menuName,parMap,(HttpServletRequest)pageContext.getRequest()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			menu = (MenuComponent) pageContext.findAttribute(this.name);
		}
		
        if (menu != null) {
            try {
                // use the overridden target
                if (target != null) {
                    displayer.setTarget(this.target);
                }

                // set the location value to use
                // the context relative page attribute
                // if specified in the menu
                try {
                    setPageLocation(menu);
                } catch (MalformedURLException m) {
                    log.error("Incorrect action or forward: " + m.getMessage());
                    log.warn("Menu '" + menu.getName() + "' location set to #");
                    menu.setLocation("#");
                } 

                displayer.display(menu);
                displayer.setTarget(null);
            } catch (Exception e) {
                // don't swallow the exception
                e.printStackTrace();
                throw new JspException(e);
            }
        } else {
            String error = messages.getString("menu.not.found") +
                    " " + this.name;
            log.warn(error);
            try {
                pageContext.getOut().write(error);
            } catch (IOException io) {
                throw new JspException(error);
            }
        }

        return SKIP_BODY;
    }

    /**
     * Sets the value for the menu location to the
     * appropriate value if location is null.  If location
     * is null, and the page attribute exists, it's value
     * will be set to the the value for page prepended with
     * the context path of the application.
     *
     * If the page is null, and the forward attribute exists,
     * it's value will be looked up in struts-config.xml.
     *
     *                                     FIXME - ssayles - 121102
     * Ideally, this should happen at menu initialization but
     * I was unable to find a reliable way to get the context path
     * outside of a request.  The performance impact is probably
     * negligable, but it would be better to check for this only once.
     *
     * @param menu The menu component to set the location for.
     */
    protected void setPageLocation(MenuComponent menu)
    throws MalformedURLException, JspException {
        HttpServletRequest request =
            (HttpServletRequest) pageContext.getRequest();
    	setLocation(menu);
        String url = menu.getLocation();

        // Check if there are parameters on the value
        if ((url != null) && (url.indexOf("${") > -1)) {
            String queryString = null;

            if (url.indexOf("?") > -1) {
                queryString = url.substring(url.indexOf("?") + 1);
                url = url.substring(0, url.indexOf(queryString));
            }

            StringBuffer sb = new StringBuffer();

            // variable is in the URL
            if (queryString != null) {
                sb = parseString(queryString, request);
                menu.setUrl(url + sb.toString());
            } else {
                // parse the URL, rather than the queryString
                sb = parseString(url, request);
                menu.setUrl(sb.toString());
            }
        } else {
            menu.setUrl(url);
        }

        // do all contained menus
        MenuComponent[] subMenus = menu.getMenuComponents();

        if (subMenus.length > 0) {
            for (int i = 0; i < subMenus.length; i++) {
                setPageLocation(subMenus[i]);
            }
        }
    }
    
    protected void setLocation(MenuComponent menu) throws MalformedURLException {
        HttpServletRequest request =
            (HttpServletRequest) pageContext.getRequest();

        // if the location attribute is null,
        // then set it with a context relative page
        // attribute if it exists
        if (menu.getLocation() == null) {
            try {
                if (menu.getPage() != null) {
                    // are we sure we'll get an HttpServletRequest?
                    menu.setLocation(request.getContextPath() +
                                     getPage(menu.getPage()));
                } else if (menu.getForward() != null) {
                    String fwd =
                            RequestUtils.computeURL(pageContext, null,
                                    null, null, menu.getForward(), null, null, false);
                    menu.setLocation(fwd);
                } else if (menu.getAction() != null) {
                    // generate Struts Action URL,
                    // this will append Context Path (if any),
                    // Servlet Mapping (path mapping or extension mapping)
                    // Module Prefix (if any) & Session ID (if any)
                    String action =
                            RequestUtils.computeURL(pageContext, null, null, null,
                                    menu.getAction(), null, null, false);
                    menu.setLocation(action);
                }
            } catch (NoClassDefFoundError e) {
                if (menu.getForward() != null) {
                    throw new MalformedURLException("forward '" + menu.getForward() + "' invalid - no struts.jar");
                } else if (menu.getAction() != null) {
                    throw new MalformedURLException("action '" + menu.getAction() + "' invalid - no struts.jar");
                }
            }
        }
   
    }

    /**
     * Returns the value with page prepended with a "/"
     * if it is not already.
     *
     * @param page The value for the page.
     */
    protected String getPage(String page) {
        if (page.startsWith("/")) {
            return page;
        } else {
            page = "/" + page;
        }

        return page;
    }
    
    private StringBuffer parseString(String str, HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();

        while (str.indexOf("${") >= 0) {
            sb.append(str.substring(0, str.indexOf("${")));

            String variable =
                    str.substring(str.indexOf("${") + 2, str.indexOf("}"));
            String value = (String) pageContext.findAttribute(variable);

            if (value == null) {
                // look for it as a request parameter
                value = request.getParameter(variable);
            }

            // is value still null?!
            if (value == null) {
                log.warn("Value for '" + variable +
                        "' not found in pageContext or as a request parameter");
            }

            sb.append(value);
            str = str.substring(str.indexOf("}") + 1, str.length());
        }

        return sb.append(str);
    }

    public void release() {
        this.name = null;
        this.target = null;
    }
}
