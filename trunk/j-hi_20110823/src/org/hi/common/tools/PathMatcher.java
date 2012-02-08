package org.hi.common.tools;

import org.springframework.util.AntPathMatcher;

/**
 * �ļ�·��ƥ����,ʵ��<code>Matcher</code>�ӿ�.�������spring��
 * AntPathMatcher����һ��򵥵ķ�װ,����ʵ�����ص���μ�spring
 * @author ���
 * @since 2007-11-22
 * @see org.hi.common.tools.Matcher
 * @see org.springframework.util.AntPathMatcher
 *
 */
public class PathMatcher implements Matcher {
	AntPathMatcher pathMatcher;
	
	public PathMatcher(){
		pathMatcher = new AntPathMatcher();
	}
	
	/**
	 * �����ļ�·���ָ���,ȱʡΪ /
	 * @param pathSeparator �ļ�·���ָ���
	 */
	public void setPathSeparator(String pathSeparator) {
		pathMatcher.setPathSeparator(pathSeparator);
	}
	
	/* (non-Javadoc)
	 * @see org.hi.common.tools.Matcher#isPattern(java.lang.String)
	 */
	public boolean isPattern(String str) {
		return pathMatcher.isPattern(str);
	}

	/* (non-Javadoc)
	 * @see org.hi.common.tools.Matcher#match(java.lang.String, java.lang.Object)
	 */
	public boolean match(String pattern, Object value) {
		
		if(!(value instanceof String))
			return false;
		
		String str = (String)value;
		
		return pathMatcher.match(pattern, str);
	}

}
