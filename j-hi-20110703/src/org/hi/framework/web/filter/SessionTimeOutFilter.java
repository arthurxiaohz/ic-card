package org.hi.framework.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hi.common.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 通过<code>session</code>属性值是否存在,来判断用户登录是否超时
 * @author 张昊
 * @since 2007-8-9
 *
 */
public class SessionTimeOutFilter extends OncePerRequestFilter {
	
	private String sessionAttributeKey;
	private String redirectURI;
	private String uncludeURIs;

	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Object obj = session.getAttribute(sessionAttributeKey);
		String requestURI = request.getRequestURI();
		Set<String> uncludes = new HashSet<String>();
		
		if(uncludeURIs == null)
			uncludes.add(redirectURI);
		else
			paserUnclude(uncludes);
			
		if(obj != null || uncludes.contains(requestURI))
			return true;
		return false;
	}
	
	private void paserUnclude(Set uncludes){
		String[] uris = StringUtils.strToStrArray(uncludeURIs);
		for (int i = 0; i < uris.length; i++) {
			uncludes.add(uris[i]);
		}
	}
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if(!shouldNotFilter(request))
			response.sendRedirect(redirectURI);
		
	}

	/**
	 * 如果在session中没有找到该与给定的键所对应的属性值,系统要转回的页面URI地址
	 * @param redirectURI 转回的URI地址
	 */
	public void setRedirectURI(String redirectURI) {
		this.redirectURI = redirectURI;
	}

	/**
	 * 设置session属性的键的名称,通过该键名还查找该属性的值
	 * @param sessionAttributeKey session属性的键值
	 */
	public void setSessionAttributeKey(String sessionAttributeKey) {
		this.sessionAttributeKey = sessionAttributeKey;
	}

	/**
	 * 不包括session判断的URI
	 * @param uncludeURIs
	 */
	public void setUncludeURIs(String uncludeURIs) {
		this.uncludeURIs = uncludeURIs;
	}



}
