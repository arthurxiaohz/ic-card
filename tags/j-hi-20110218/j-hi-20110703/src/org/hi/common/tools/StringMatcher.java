package org.hi.common.tools;

import java.util.regex.Pattern;

/**
 * 字符匹配器,实现<code>Matcher</code>接口.
 * <p>模板通配符规则：
 *<UL>
 *<LI>* 代表任意多个字符</LI>
 *<LI>？代表一个字符</LI>
 *<P>例如：<FONT face=宋体>org.hi.* ,前七位是org.hi.以后任意多个字符</FONT></P>
 *<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp; 2?6，第一位是2,第二位是任意字符，第三位是6</P>
 *<P>&nbsp;</P>&nbsp;
 * @author 张昊
 * @since 2007-11-23
 * @see org.hi.common.tools.Matcher
 *
 */
public class StringMatcher implements Matcher{

	/* (non-Javadoc)
	 * @see org.hi.common.tools.Matcher#isPattern(java.lang.String)
	 */
	public boolean isPattern(String pattern) {
		return (pattern.indexOf('*') != -1 || pattern.indexOf('?') != -1);
	}
	/**
	 * 通过给定的模板判断对象值是否与该模板相匹配
	 * @param pattern 模板
	 * @param value 待匹配的对象,其类型必须是<code>String</code>的子类
	 * @return 如果对象与模板匹配返回true,否则返回false
	 * @see java.lang.String
	 */
	public boolean match(String pattern, Object value) {
		if(!(value instanceof String))
			return false;
		
		String str = (String)value;
		
		if(pattern == null || pattern.trim().equals("") || str == null || str.trim().equals(""))
			return false;
		
		pattern = pattern.replaceAll("[.]", "\\\\.");
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < pattern.length(); i++) {
			char subChar = pattern.charAt(i);
			switch(subChar){
				case '*':
					sb.append(".*");
					break;
				case '?':
					sb.append(".{1}");
					break;
				default:
					sb.append(subChar);
			}
		}
		
		pattern = sb.toString();
		return Pattern.matches(pattern,str);
	}
	
//	public static void main(String[] args){
//	Matcher matcher = new StringMatcher();
//	System.out.println(matcher.match("appContext-*.xml", "appContext-attachment.xml"));
//	}

}
