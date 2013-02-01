/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import javax.servlet.jsp.tagext.TagSupport;
/*     */ import net.sf.navigator.displayer.MenuDisplayer;
/*     */ import net.sf.navigator.menu.MenuComponent;
/*     */ import net.sf.navigator.menu.MenuRepository;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.struts.util.RequestUtils;
/*     */ import org.hi.base.menu.strutsmenu.AbstractMenuTreeManager;
/*     */ import org.hi.base.menu.strutsmenu.SysMenuTreeManager;
/*     */ import org.hi.base.menu.strutsmenu.WebDynamicTreeManager;
/*     */ 
/*     */ public class DisplayMenuTag extends TagSupport
/*     */ {
/*  54 */   private Log log = LogFactory.getLog(DisplayMenuTag.class);
/*     */   protected static final String PRIVATE_REPOSITORY = "net.sf.navigator.repositoryKey";
/*  60 */   protected static ResourceBundle messages = ResourceBundle.getBundle("net.sf.navigator.taglib.LocalStrings");
/*     */   private String name;
/*     */   private String target;
/*     */   private String menuName;
/*     */   private String cssStyle;
/*     */   private String type;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  86 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setCssStyle(String cssStyle)
/*     */   {
/*  91 */     this.cssStyle = cssStyle;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  98 */     if (this.log.isDebugEnabled()) {
/*  99 */       this.log.debug("setting name to: " + name);
/*     */     }
/*     */ 
/* 102 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public void setMenuName(String menuName) {
/* 106 */     this.menuName = menuName;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 110 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getTarget()
/*     */   {
/* 117 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target)
/*     */   {
/* 124 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public int doStartTag() throws JspException
/*     */   {
/* 129 */     MenuDisplayer displayer = 
/* 130 */       (MenuDisplayer)this.pageContext.getAttribute("net.sf.navigator.taglib.DISPLAYER");
/*     */ 
/* 132 */     if (displayer == null) {
/* 133 */       throw new JspException("Could not retrieve the menu displayer.");
/*     */     }
/*     */ 
/* 136 */     this.pageContext.getRequest().setAttribute("cssStyle", this.cssStyle);
/*     */ 
/* 138 */     MenuRepository repository = 
/* 139 */       (MenuRepository)this.pageContext.getAttribute("net.sf.navigator.repositoryKey");
/*     */ 
/* 141 */     if (repository == null) {
/* 142 */       throw new JspException("Could not obtain the menu repository");
/*     */     }
/*     */ 
/* 145 */     MenuComponent menu = 
/* 146 */       (MenuComponent)this.pageContext.findAttribute(this.name);
/*     */ 
/* 148 */     if ((menu == null) && (this.menuName != null)) {
/* 149 */       AbstractMenuTreeManager treemgr = null;
/* 150 */       if (this.type.equals("sys"))
/* 151 */         treemgr = new SysMenuTreeManager();
/*     */       else
/* 153 */         treemgr = new WebDynamicTreeManager();
/*     */       try
/*     */       {
/* 156 */         ServletRequest request = this.pageContext.getRequest();
/* 157 */         HashMap parMap = new HashMap();
/* 158 */         Enumeration enumeration = request.getParameterNames();
/* 159 */         while (enumeration.hasMoreElements()) {
/* 160 */           String element = (String)enumeration.nextElement();
/* 161 */           if ((("type".equals(element) ? 0 : 1) & ("menuName".equals(element) ? 0 : 1)) != 0) {
/* 162 */             parMap.put(element, request.getParameter(element));
/*     */           }
/*     */         }
/*     */ 
/* 166 */         this.pageContext.setAttribute(this.name, treemgr.getMenu(this.menuName, parMap, (HttpServletRequest)this.pageContext.getRequest()));
/*     */       } catch (Exception e) {
/* 168 */         e.printStackTrace();
/*     */       }
/* 170 */       menu = (MenuComponent)this.pageContext.findAttribute(this.name);
/*     */     }
/*     */ 
/* 173 */     if (menu != null)
/*     */     {
/*     */       try {
/* 176 */         if (this.target != null) {
/* 177 */           displayer.setTarget(this.target);
/*     */         }
/*     */ 
/*     */         try
/*     */         {
/* 184 */           setPageLocation(menu);
/*     */         } catch (MalformedURLException m) {
/* 186 */           this.log.error("Incorrect action or forward: " + m.getMessage());
/* 187 */           this.log.warn("Menu '" + menu.getName() + "' location set to #");
/* 188 */           menu.setLocation("#");
/*     */         }
/*     */ 
/* 191 */         displayer.display(menu);
/* 192 */         displayer.setTarget(null);
/*     */       }
/*     */       catch (Exception e) {
/* 195 */         e.printStackTrace();
/* 196 */         throw new JspException(e);
/*     */       }
/*     */     } else {
/* 199 */       String error = messages.getString("menu.not.found") + 
/* 200 */         " " + this.name;
/* 201 */       this.log.warn(error);
/*     */       try {
/* 203 */         this.pageContext.getOut().write(error);
/*     */       } catch (IOException io) {
/* 205 */         throw new JspException(error);
/*     */       }
/*     */     }
/*     */ 
/* 209 */     return 0;
/*     */   }
/*     */ 
/*     */   protected void setPageLocation(MenuComponent menu)
/*     */     throws MalformedURLException, JspException
/*     */   {
/* 232 */     HttpServletRequest request = 
/* 233 */       (HttpServletRequest)this.pageContext.getRequest();
/* 234 */     setLocation(menu);
/* 235 */     String url = menu.getLocation();
/*     */ 
/* 238 */     if ((url != null) && (url.indexOf("${") > -1)) {
/* 239 */       String queryString = null;
/*     */ 
/* 241 */       if (url.indexOf("?") > -1) {
/* 242 */         queryString = url.substring(url.indexOf("?") + 1);
/* 243 */         url = url.substring(0, url.indexOf(queryString));
/*     */       }
/*     */ 
/* 246 */       StringBuffer sb = new StringBuffer();
/*     */ 
/* 249 */       if (queryString != null) {
/* 250 */         sb = parseString(queryString, request);
/* 251 */         menu.setUrl(url + sb.toString());
/*     */       }
/*     */       else {
/* 254 */         sb = parseString(url, request);
/* 255 */         menu.setUrl(sb.toString());
/*     */       }
/*     */     } else {
/* 258 */       menu.setUrl(url);
/*     */     }
/*     */ 
/* 262 */     MenuComponent[] subMenus = menu.getMenuComponents();
/*     */ 
/* 264 */     if (subMenus.length > 0)
/* 265 */       for (int i = 0; i < subMenus.length; i++)
/* 266 */         setPageLocation(subMenus[i]);
/*     */   }
/*     */ 
/*     */   protected void setLocation(MenuComponent menu)
/*     */     throws MalformedURLException
/*     */   {
/* 272 */     HttpServletRequest request = 
/* 273 */       (HttpServletRequest)this.pageContext.getRequest();
/*     */ 
/* 278 */     if (menu.getLocation() == null)
/*     */       try {
/* 280 */         if (menu.getPage() != null)
/*     */         {
/* 282 */           menu.setLocation(request.getContextPath() + 
/* 283 */             getPage(menu.getPage()));
/* 284 */         } else if (menu.getForward() != null) {
/* 285 */           String fwd = 
/* 286 */             RequestUtils.computeURL(this.pageContext, null, 
/* 287 */             null, null, menu.getForward(), null, null, false);
/* 288 */           menu.setLocation(fwd);
/* 289 */         } else if (menu.getAction() != null)
/*     */         {
/* 294 */           String action = 
/* 295 */             RequestUtils.computeURL(this.pageContext, null, null, null, 
/* 296 */             menu.getAction(), null, null, false);
/* 297 */           menu.setLocation(action);
/*     */         }
/*     */       } catch (NoClassDefFoundError e) {
/* 300 */         if (menu.getForward() != null)
/* 301 */           throw new MalformedURLException("forward '" + menu.getForward() + "' invalid - no struts.jar");
/* 302 */         if (menu.getAction() != null)
/* 303 */           throw new MalformedURLException("action '" + menu.getAction() + "' invalid - no struts.jar");
/*     */       }
/*     */   }
/*     */ 
/*     */   protected String getPage(String page)
/*     */   {
/* 317 */     if (page.startsWith("/")) {
/* 318 */       return page;
/*     */     }
/* 320 */     page = "/" + page;
/*     */ 
/* 323 */     return page;
/*     */   }
/*     */ 
/*     */   private StringBuffer parseString(String str, HttpServletRequest request) {
/* 327 */     StringBuffer sb = new StringBuffer();
/*     */ 
/* 329 */     while (str.indexOf("${") >= 0) {
/* 330 */       sb.append(str.substring(0, str.indexOf("${")));
/*     */ 
/* 332 */       String variable = 
/* 333 */         str.substring(str.indexOf("${") + 2, str.indexOf("}"));
/* 334 */       String value = (String)this.pageContext.findAttribute(variable);
/*     */ 
/* 336 */       if (value == null)
/*     */       {
/* 338 */         value = request.getParameter(variable);
/*     */       }
/*     */ 
/* 342 */       if (value == null) {
/* 343 */         this.log.warn("Value for '" + variable + 
/* 344 */           "' not found in pageContext or as a request parameter");
/*     */       }
/*     */ 
/* 347 */       sb.append(value);
/* 348 */       str = str.substring(str.indexOf("}") + 1, str.length());
/*     */     }
/*     */ 
/* 351 */     return sb.append(str);
/*     */   }
/*     */ 
/*     */   public void release() {
/* 355 */     this.name = null;
/* 356 */     this.target = null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.DisplayMenuTag
 * JD-Core Version:    0.6.0
 */