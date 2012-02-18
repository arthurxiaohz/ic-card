package org.hi.common.tools;

import org.springframework.util.AntPathMatcher;

/**
 * 文件路径匹配器,实现<code>Matcher</code>接口.该类仅是spring的
 * AntPathMatcher类做一层简单的封装,具体实现与特点请参见spring
 * @author 张昊
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
	 * 设置文件路径分隔符,缺省为 /
	 * @param pathSeparator 文件路径分隔符
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
