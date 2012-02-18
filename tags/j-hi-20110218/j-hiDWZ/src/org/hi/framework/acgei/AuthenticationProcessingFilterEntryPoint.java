/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hi.framework.acgei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.ui.AuthenticationEntryPoint;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.acegisecurity.util.PortMapper;
import org.acegisecurity.util.PortMapperImpl;
import org.acegisecurity.util.PortResolver;
import org.acegisecurity.util.PortResolverImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.web.BusinessException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;


/**
 * <p>Used by the <code>SecurityEnforcementFilter</code> to commence authentication via the {@link
 * AuthenticationProcessingFilter}. This object holds the location of the login form, relative to the web app context
 * path, and is used to commence a redirect to that form.</p>
 *  <p>By setting the <em>forceHttps</em> property to true, you may configure the class to force the protocol used
 * for the login form to be <code>HTTPS</code>, even if the original intercepted request for a resource used the
 * <code>HTTP</code> protocol. When this happens, after a successful login (via HTTPS), the original resource will
 * still be accessed as HTTP, via the original request URL. For the forced HTTPS feature to work, the {@link
 * PortMapper} is consulted to determine the HTTP:HTTPS pairs.</p>
 *
 * @author Ben Alex
 * @author colin sampaleanu
 * @author Omri Spector
 * @version $Id: AuthenticationProcessingFilterEntryPoint.java 1737 2006-11-14 01:09:35 +0000 (Tue, 14 Nov 2006) benalex $
 */
public class AuthenticationProcessingFilterEntryPoint implements AuthenticationEntryPoint, InitializingBean {
    //~ Static fields/initializers =====================================================================================

    private static final Log logger = LogFactory.getLog(AuthenticationProcessingFilterEntryPoint.class);

    //~ Instance fields ================================================================================================

    private PortMapper portMapper = new PortMapperImpl();
    private PortResolver portResolver = new PortResolverImpl();
    private String loginFormUrl;
    private boolean forceHttps = false;
    private boolean serverSideRedirect = false;

    //~ Methods ========================================================================================================

    public void afterPropertiesSet() throws Exception {
        Assert.hasLength(loginFormUrl, "loginFormUrl must be specified");
        Assert.notNull(portMapper, "portMapper must be specified");
        Assert.notNull(portResolver, "portResolver must be specified");
    }

    public void commence(ServletRequest request, ServletResponse response, AuthenticationException authException)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = portResolver.getServerPort(request);
        String contextPath = req.getContextPath();

        boolean inHttp = "http".equals(scheme.toLowerCase());
        boolean inHttps = "https".equals(scheme.toLowerCase());

        boolean includePort = true;

        String redirectUrl = null;
        boolean doForceHttps = false;
        Integer httpsPort = null;

        if (inHttp && (serverPort == 80)) {
            includePort = false;
        } else if (inHttps && (serverPort == 443)) {
            includePort = false;
        }

        if (forceHttps && inHttp) {
            httpsPort = (Integer) portMapper.lookupHttpsPort(new Integer(serverPort));
        
            if (httpsPort != null) {
                doForceHttps = true;
                if (httpsPort.intValue() == 443) {
                    includePort = false;
                } else {
                    includePort = true;
                }
            }
            
        }
  
        if ( serverSideRedirect ) {

            if ( doForceHttps ) {
          
                // before doing server side redirect, we need to do client redirect to https.
              
                String servletPath = req.getServletPath();
                String pathInfo = req.getPathInfo();
                String query = req.getQueryString();

                redirectUrl = "https://" + serverName + ((includePort) ? (":" + httpsPort) : "") + contextPath
                  + servletPath + (pathInfo == null ? "" : pathInfo ) + (query == null ? "" : "?"+query );

            } else {

                if (logger.isDebugEnabled()) {
                  logger.debug("Server side forward to: " + loginFormUrl);
                }

                RequestDispatcher dispatcher = req.getRequestDispatcher( loginFormUrl );

                dispatcher.forward( request, response );
                
                return;

            }

        } else {

            if ( doForceHttps ) {

                redirectUrl = "https://" + serverName + ((includePort) ? (":" + httpsPort) : "") + contextPath
                    + loginFormUrl;

            } else {

                redirectUrl = scheme + "://" + serverName + ((includePort) ? (":" + serverPort) : "") + contextPath
                  + loginFormUrl;

            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Redirecting to: " + redirectUrl);
        }
        
//-------------        for DWZ    ------------------//
        
        if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest)request).getHeader("X-Requested-With")) || request.getParameter("ajax") != null) {
			PrintWriter out = response.getWriter(); 
			out.println("{\"statusCode\":\"301\",\"message\":\"Session Timeout! Please re-sign in!\"}");
			throw new BusinessException("Session Timeout");
//			throw new BusinessException("{\"statusCode\":\"301\",\"message\":\"Session Timeout! Please re-sign in!\"}");
		} 
        else {
        ((HttpServletResponse) response).sendRedirect(((HttpServletResponse) response).encodeRedirectURL(redirectUrl));
		}
    }

    public boolean getForceHttps() {
        return forceHttps;
    }

    public String getLoginFormUrl() {
        return loginFormUrl;
    }

    public PortMapper getPortMapper() {
        return portMapper;
    }

    public PortResolver getPortResolver() {
        return portResolver;
    }

    public boolean isServerSideRedirect() {
       return serverSideRedirect;
    }

    /**
     * Set to true to force login form access to be via https. If this value is ture (the default is false),
     * and the incoming request for the protected resource which triggered the interceptor was not already
     * <code>https</code>, then
     *
     * @param forceHttps
     */
    public void setForceHttps(boolean forceHttps) {
        this.forceHttps = forceHttps;
    }

    /**
     * The URL where the <code>AuthenticationProcessingFilter</code> login page can be found. Should be
     * relative to the web-app context path, and include a leading <code>/</code>
     *
     * @param loginFormUrl
     */
    public void setLoginFormUrl(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }

    public void setPortMapper(PortMapper portMapper) {
        this.portMapper = portMapper;
    }

    public void setPortResolver(PortResolver portResolver) {
        this.portResolver = portResolver;
    }
 
    /**
     * Tells if we are to do a server side include of the <code>loginFormUrl</code> instead of a 302
     * redirect.
     * 
     * @param serverSideRedirect
     */
    public void setServerSideRedirect(boolean serverSideRedirect) {
        this.serverSideRedirect = serverSideRedirect;
    }

}
