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
 * ͨ��<code>session</code>����ֵ�Ƿ����,���ж��û���¼�Ƿ�ʱ
 * @author ���
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
	 * �����session��û���ҵ���������ļ�����Ӧ������ֵ,ϵͳҪת�ص�ҳ��URI��ַ
	 * @param redirectURI ת�ص�URI��ַ
	 */
	public void setRedirectURI(String redirectURI) {
		this.redirectURI = redirectURI;
	}

	/**
	 * ����session���Եļ�������,ͨ���ü��������Ҹ����Ե�ֵ
	 * @param sessionAttributeKey session���Եļ�ֵ
	 */
	public void setSessionAttributeKey(String sessionAttributeKey) {
		this.sessionAttributeKey = sessionAttributeKey;
	}

	/**
	 * ������session�жϵ�URI
	 * @param uncludeURIs
	 */
	public void setUncludeURIs(String uncludeURIs) {
		this.uncludeURIs = uncludeURIs;
	}



}
