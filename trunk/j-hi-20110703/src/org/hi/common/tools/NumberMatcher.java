package org.hi.common.tools;

import java.util.regex.Pattern;


/**
 * ��ֵƥ����,ʵ��<code>Matcher</code>�ӿ�.
 * <p>ģ��ͨ�������
 *<UL>
 *<LI>* ����������0-9������</LI>
 *<LI>������һ��0-9������</LI>
 *<LI>- �����x��y֮�����ֵ����</LI></UL>
 *<P>���磺<FONT face=����>32-5.5* ,��һλ��3,�ڶ�λ��2��5���е�����һ������,����λ��С����,����λ��5����5�Ժ�����������</FONT></P>
 *<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp; 2?6����һλ��2,�ڶ�λ���������֣�����λ��6</P>
 *<P>&nbsp;</P>&nbsp;
 * @author ���
 * @since 2007-11-22
 * @see org.hi.common.tools.Matcher
 *
 */
public class NumberMatcher implements Matcher {


	/* (non-Javadoc)
	 * @see org.hi.common.tools.Matcher#isPattern(java.lang.String)
	 */
	public boolean isPattern(String pattern) {
		return (pattern.indexOf('*') != -1 || pattern.indexOf('?') != -1 || pattern.indexOf('-') != -1);
	}

	/**
	 * ͨ��������ģ���ж϶���ֵ�Ƿ����ģ����ƥ��
	 * @param pattern ģ��
	 * @param value ��ƥ��Ķ���,�����ͱ�����<code>Number</code>������
	 * @return ���������ģ��ƥ�䷵��true,���򷵻�false
	 * @see java.lang.Number
	 */
	public boolean match(String pattern, Object value) {
		if(!(value instanceof Number))
			return false;
		
		String str = ((Number)value).toString();

		if(pattern == null || pattern.trim().equals("") || str == null || str.trim().equals(""))
			return false;
		
		if(!Pattern.matches("[\\d|\\.]*",str))
			return false;
		
		pattern = pattern.replaceAll("[.]", "\\\\.");
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < pattern.length(); i++) {
			char subChar = pattern.charAt(i);
			switch(subChar){
				case '*':
					sb.append("\\d*");
					break;
				case '?':
					sb.append("\\d{1}");
					break;
				default:
					sb.append(subChar);
			}
		}
		
		String[] patterns = sb.toString().split("-");
		if(patterns.length <= 1)
			pattern = patterns[0];
		else{
			sb = new StringBuffer("");
			for (int i = 0; i < patterns.length; i++) {
				String element = patterns[i];
				if(i != 0)
					sb.append(element.charAt(0) + "]{1}" + element.substring(1));
				if(i != patterns.length - 1){
					sb.append(element.substring(0, element.length() - 1) + "[" + element.charAt(element.length()-1) + "-");
				}
			}
		}
		pattern = sb.toString();
//		System.out.println(pattern);
		return Pattern.matches(pattern,str);
	}
	
	
	public static void main(String[] args){
		NumberMatcher matcher = new NumberMatcher();
		System.out.println(matcher.match("34-5.5*", new Double(34.5345)));
		
//		System.out.println(Pattern.matches("34\\d*5","34345"));;
	}

}
