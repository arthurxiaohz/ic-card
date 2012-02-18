package org.hi.common.tools;

import java.util.regex.Pattern;

/**
 * �ַ�ƥ����,ʵ��<code>Matcher</code>�ӿ�.
 * <p>ģ��ͨ�������
 *<UL>
 *<LI>* �����������ַ�</LI>
 *<LI>������һ���ַ�</LI>
 *<P>���磺<FONT face=����>org.hi.* ,ǰ��λ��org.hi.�Ժ��������ַ�</FONT></P>
 *<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp; 2?6����һλ��2,�ڶ�λ�������ַ�������λ��6</P>
 *<P>&nbsp;</P>&nbsp;
 * @author ���
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
	 * ͨ��������ģ���ж϶���ֵ�Ƿ����ģ����ƥ��
	 * @param pattern ģ��
	 * @param value ��ƥ��Ķ���,�����ͱ�����<code>String</code>������
	 * @return ���������ģ��ƥ�䷵��true,���򷵻�false
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
