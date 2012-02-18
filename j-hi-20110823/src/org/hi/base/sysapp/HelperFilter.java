package org.hi.base.sysapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hi.SpringContextHolder;
import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.service.HelperManager;
import org.hi.common.tools.Matcher;
import org.hi.common.tools.StringMatcher;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.impl.FilterFactory;
import org.springframework.beans.factory.InitializingBean;

public class HelperFilter implements InitializingBean, Filter {
	public static final String SESSION_NAME_HELPER_LAST_URL = "session_name_helper_last_url";
	private String include;
	private String[] includeArray = {"*"};
	private String uninclude;
	private String[] unincludeArray;
	private boolean collect = false;
	
	public void afterPropertiesSet() throws Exception {
		if(include != null)
			includeArray = StringUtils.strToStrArray(include);
		if(uninclude != null)
			unincludeArray = StringUtils.strToStrArray(uninclude);
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		String urlQueryString  = ((HttpServletRequest)request).getQueryString();
		String url = ((HttpServletRequest)request).getRequestURI();
		boolean receiver = false;
		Matcher matcher = new StringMatcher();
		
//		���ڰ�����������
		for (int i = 0; i < includeArray.length; i++) {
			String _include = includeArray[i];
			if(matcher.match(_include, url)){	//���ƥ��
				receiver = true;
				break;
			}
		}
		
//		���ڲ�������������
		if(unincludeArray != null){
			for (int i = 0; i < unincludeArray.length; i++) {
				String _uninclude = unincludeArray[i];
				if(matcher.match(_uninclude, url)){	//���ƥ��
					receiver = false;
					break;
				}
			}
		}
//		��ȡ���һ�������URL
		if(urlQueryString != null)
			url += "?"+urlQueryString;	//ƴ��������URL
		if(receiver)
			((HttpServletRequest)request).getSession(true).setAttribute(SESSION_NAME_HELPER_LAST_URL, url); //������Ͼͽ�url�ŵ�session��
		
		
		
		//		ֻ���ǿ���ģʽ���Ҵ򿪰���ʱ���Ż�ɼ�URL
		if(!HiConfigHolder.getPublished() && HiConfigHolder.getHelper().equals("true")){
			
//			����ɼ���ʽ��true������
			if(!collect){
			
				org.hi.framework.dao.Filter filter = FilterFactory.getSimpleFilter("urlAction", ((HttpServletRequest)request).getRequestURI());
				HelperManager hMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
				List<Helper> helpers = hMgr.getObjects(filter);
				
				if(helpers != null && helpers.size() > 0)	//����ڱ����Ѵ����򲻱���
					receiver = false;
				
				if(receiver){
					Helper helper = new Helper();
					helper.setUrlAction(url);
					helper.setTitle(((HttpServletRequest)request).getRequestURI());
					hMgr.saveHelper(helper);
				}
			}
			
		}
		
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public String getUninclude() {
		return uninclude;
	}

	public void setUninclude(String uninclude) {
		this.uninclude = uninclude;
	}

	public boolean isCollect() {
		return collect;
	}

	public void setCollect(boolean collect) {
		this.collect = collect;
	}
	
}
