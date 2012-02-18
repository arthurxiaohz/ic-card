package org.hi.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class StringUtils {

	  /**
	   * ǰ����ʶ
	  */
	  public static final int BEFORE = 1;

	  /**
	   * ��̱�ʶ
	  */
	  public static final int AFTER = 2;

	  public static final String DEFAULT_PATH_SEPARATOR = ",";


	  /**
	   * ��һ���м�����ŷָ������ַ���ת��ΪArrayList����
	   * @param str ��ת���ķ�������
	   * @return ArrayList����
	   */
	  public static ArrayList strToArrayList(String str) {
	    return strToArrayListManager(str, DEFAULT_PATH_SEPARATOR);
	  }

	  /**
	   * ���ַ������󰴸����ķָ���separatorת��ΪArrayList����
	   * @param str ��ת�����ַ�������
	   * @param separator �ַ��ͷָ���
	   * @return ArrayList����
	   */
	  public static ArrayList<String> strToArrayList(String str, String separator) {
	    return strToArrayListManager(str, separator);
	  }

	  private static ArrayList<String> strToArrayListManager(String str,String separator) {

	    StringTokenizer strTokens = new StringTokenizer(str, separator);
	    ArrayList<String> list = new ArrayList<String>();

	    while (strTokens.hasMoreTokens()) {
	      list.add(strTokens.nextToken().trim());
	    }

	    return list;
	  }

	  /**
	   * ��һ���м�����ŷָ������ַ���ת��Ϊ�ַ����������
	   * @param str ��ת���ķ�������
	   * @return �ַ�������
	   */
	  public static String[] strToStrArray(String str) {
	    return strToStrArrayManager(str, DEFAULT_PATH_SEPARATOR);
	  }

	  /**
	   * ���ַ������󰴸����ķָ���separatorת��Ϊ�ַ����������
	   * @param str ��ת���ķ�������
	   * @param separator �ַ��ͷָ���
	   * @return �ַ�������
	   */
	  public static String[] strToStrArray(String str, String separator) {
	    return strToStrArrayManager(str, separator);
	  }

	  private static String[] strToStrArrayManager(
	      String str,
	      String separator) {

	    StringTokenizer strTokens = new StringTokenizer(str, separator);
	    String[] strArray = new String[strTokens.countTokens()];
	    int i = 0;

	    while (strTokens.hasMoreTokens()) {
	      strArray[i] = strTokens.nextToken().trim();
	      i++;
	    }

	    return strArray;
	  }

	  public static Set<String> strToSet(String str){
		  return strToSet(str, DEFAULT_PATH_SEPARATOR);
	  }
	  
	  public static Set<String> strToSet(String str, String separator){
		  String[] values = strToStrArray(str, separator);
		  Set<String> result = new LinkedHashSet<String>();
		  for (int i = 0; i < values.length; i++) {
			  result.add(values[i]);
		}
		  return result;
	  }
	  
	  /**
	   * ��һ�����飬�ö��ŷָ���Ϊһ���ַ���
	 * @param array
	 * @return
	 */
	public static String ArrayToStr(Object[] array){
	      if(array == null || array.length <0) return null;
	      String str = "";
	      int _step = 0;
	      for(int i = 0; i<array.length; i++){
	         if(_step>0)
	             str += ",";
	         str += (String)array[i];
	          _step++;
	      }
	      return str;
	  }
	  
	public static String CollectionToStr(Collection<String> coll){
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (String string : coll) {
			if(i > 0)
				sb.append(",");
			i++;
			sb.append(string);
		}
		return sb.toString();
	}
	  
	  /**
	   * ת�������ַ����ı����ʽ
	   * @param inputString ��ת���ַ�������
	   * @param inencoding ��ת���ַ����ı����ʽ
	   * @param outencoding ׼��ת��Ϊ�ı����ʽ
	   * @return ָ���������ַ������ַ�������
	   */
	  public static String encodingTransfer(String inputString,String inencoding,String outencoding)
	  {
	    if (inputString==null || inputString.length() ==0) return inputString;
	    try
	    {
	      return new String( inputString.getBytes( outencoding), inencoding);
	    }
	    catch (Exception e)
	    {
	      return inputString;
	    }
	  }


	  /**
	   * ɾ���ַ�����ָ�����ַ�
	   * ֻҪ��delStrs�����г��ֵ��ַ���������inputString��Ҳ���ֶ��Ὣ����ɾ��
	   * @param inputString ����ɾ��������ַ���
	   * @param delStrs ��Ϊɾ���ַ��Ĳ������ݣ��ö��ŷָ������Ҫɾ�����ſ���������ַ����ټ�һ������
	   * @return ����һ����inputStringΪ��������delStrs�������ַ���
	   */
	  public static String delString(String inputString,String delStrs)
	  {
	    if (inputString==null || inputString.length() ==0)  return inputString;

	    String[] strs = strToStrArray(delStrs);
	    for(int i = 0 ;i <strs.length ; i++){
	      if(strs[i].equals(""))
	        inputString = inputString.replaceAll(" ","");
	      else
	      {
	        if(strs[i].compareTo("a")>=0)
	          inputString = replace(inputString,strs[i],"");
	        else
	          inputString = inputString.replaceAll("\\"+strs[i],"");
	      }
	    }
	    if(subCount(delStrs,",")>strs.length)
	      inputString = inputString.replaceAll("\\,","");

	    return inputString;
	  }

	  /**
	   * ȥ����߶���Ŀո�
	   * @param value ��ȥ��߿ո���ַ���
	   * @return ȥ����߿ո����ַ���
	   */
	  public static String trimLeft(String value) {
	    String result = value;
	    if(result == null) return result;
	    char ch[] = result.toCharArray();
	    int index = -1;
	    for(int i=0; i < ch.length ; i++) {
	      if(Character.isWhitespace(ch[i])) {
	        index = i;
	      }
	      else {
	        break;
	      }
	    }
	    if(index != -1) {
	      result = result.substring(index+1);
	    }
	    return result;
	  }

	  /**
	   * ȥ���ұ߶���Ŀո�
	   * @param value ��ȥ�ұ߿ո���ַ���
	   * @return ȥ���ұ߿ո����ַ���
	   */
	  public static String trimRight(String value) {
	    String result = value;
	    if(result == null) return result;
	    char ch[] = result.toCharArray();
	    int endIndex = -1;
	    for(int i=ch.length-1; i > -1; i--) {
	      if(Character.isWhitespace(ch[i])) {
	        endIndex = i;
	      }
	      else {
	        break;
	      }
	    }
	    if(endIndex != -1) {
	      result = result.substring(0, endIndex);
	    }
	    return result;
	  }


	  /**
	   * �ж�һ���ַ������Ƿ������һ���ַ���
	   * @param parentStr	����
	   * @param subStr	�Ӵ�
	   * @return ������������Ӵ������ݷ����棬���򷵻ؼ�
	   */
	  public static boolean isInclude(String parentStr, String subStr) {
		  return parentStr.indexOf(subStr) >= 0;
	  }


	  /**
	   * �ж�һ���ַ������Ƿ������һ���ַ���������κ�һ��
	   * @param parentStr	����
	   * @param subStrs	�Ӵ�����(�Զ��ŷָ����ַ���)
	   * @return ������������Ӵ������ݷ����棬���򷵻ؼ�
	   */
	  public static boolean isIncludes(String parentStr, String subStrs) {
	    String[] subStrArray = strToStrArray(subStrs);
	    for(int j = 0 ; j<subStrArray.length ; j++){
	      String subStr = subStrArray[j];
	      if(isInclude(parentStr,subStr))
	        return true;
	      else
	        continue;
	    }
	    return false;
	  }

	  /**
	   * �ж�һ�����ַ����ڸ������ظ����ֵĴ���
	   * @param parentStr	����
	   * @param subStr	�Ӵ�
	   * @return ���ַ����ڸ��ַ������صó��ֵĴ���
	   */
	  public static int subCount(String parentStr, String subStr) {
	    int count = 0;

	    for (int i = 0; i < (parentStr.length() - subStr.length());i++) {
	      String tempString = parentStr.substring(i, i + subStr.length());
	      if (subStr.equals(tempString)) {
	        count++;
	      }
	    }

	    return count;
	  }
	  
	  /**
	 * �õ����ַ����дӿ�ʼ�ַ�������ֹ�ַ����м���Ӵ� 
	 * @param parentStr ����
	 * @param startStr ��ʼ��
	 * @param endStr ��ֹ��
	 * @return ���ؿ�ʼ�����ֹ��֮����Ӵ�
	 */
	public static String subString(String parentStr, String startStr, String endStr){
	  		return parentStr.substring(parentStr.indexOf(startStr)+startStr.length(),parentStr.indexOf(endStr));
	  }
	
	/** �õ����ַ����дӿ�ʼ�ַ�������ֹ�ַ����м���Ӵ��ļ���
	 * @param parentStr ����
	 * @param startStr ��ʼ��
	 * @param endStr ��ֹ��
	 * @return ���ؿ�ʼ�����ֹ��֮����Ӵ��ļ���
	 */
	public static List<String> subStringList(String parentStr, String startStr, String endStr){
		List<String> result = new ArrayList<String>();
		List<String> elements = dividToList(parentStr, startStr, endStr);
		for (String element : elements) {
			if (!isIncludes(element, startStr) || !isIncludes(element, endStr)) 
				continue;
			result.add(subString(element,startStr,endStr));
		}
		return result;
		
	}

	  /**
	   * ��ָ����Stringת��ΪUnicode�ĵȼ�ֵ
	   *
	   * ����֪ʶ��
	   *   ���е�ת���ַ������� '\' ��ͷ�ĵڶ����ַ�
	   *   0-9  :�˽���
	   *   u    :��Unicodeת�⣬���ȹ̶�Ϊ6λ
	   *   Other:��Ϊ������ĸ�е�һ�� b,t,n,f,r,",\  �������㣬�����һ���������
	   *  �ṩ�˽���Ҳ��Ϊ�˺�C���Լ���.
	   * b,t,n,f,r ����Ϊ�����ַ�.���ϵ���˼Ϊ:�����������ķ�����ϣ����Щ��Ϣ��α���ʽ�����߱���ʾ.
	   * ������д�ڴ��������λ�ã�ֻҪת����ǺϷ���.
	   * ����:
	   * int c=0\u003b
	   * ����Ĵ�����Ա���ͨ������ͬ��int c=0; \u003bҲ����';'��Unicode����
	   *
	   * @param str ��ת��ΪUnicode�ĵȼ��ַ���
	   * @return Unicode���ַ���
	   */
	  public static String getUnicodeStr(String inStr){
	   char[] myBuffer = inStr.toCharArray();
	    StringBuffer sb = new StringBuffer();

	   for (int i = 0; i < inStr.length(); i++) {
	    byte b = (byte) myBuffer[i];
	    short s = (short) myBuffer[i];
	    String hexB = Integer.toHexString(b);
	    String hexS = Integer.toHexString(s);
	    /*
	    //���Ϊ��д
	    String hexB = Integer.toHexString(b).toUpperCase();
	    String hexS = Integer.toHexString(s).toUpperCase();
	    //print char
	    sb.append("char[");
	    sb.append(i);
	    sb.append("]='");
	    sb.append(myBuffer[i]);
	    sb.append("'\t");

	    //byte value
	    sb.append("byte=");
	    sb.append(b);
	    sb.append(" \\u");
	    sb.append(hexB);
	    sb.append('\t');
	    */

	    //short value
	    sb.append(" \\u");
	    sb.append(fillStr(hexS,"0",4,AFTER));
	    //sb.append('\t');
	    //Unicode Block
	    //sb.append(Character.UnicodeBlock.of(myBuffer[i]));
	   }

	    return sb.toString();

	  }


	  /**
	   *�ж�һ���ַ����Ƿ��ǺϷ���Java��ʶ��
	   * @param s	���жϵ��ַ���
	   * @return	�������s��һ���Ϸ���Java��ʶ�������棬���򷵻ؼ�
	   */
	  public static boolean isJavaIdentifier(String s){
	    if(s.length()==0 || Character.isJavaIdentifierStart(s.charAt(0)))
	      return false;
	    for(int i = 0;i<s.length();i++)
	      if(!Character.isJavaIdentifierPart(s.charAt(i)))
	        return false;
	    return true;
	  }



	  /**
	   *�滻�ַ����������������ַ�
	   * ����:  replaceAll("\com\hi\platform\base\\util",'\\','/');
	   * ���صĽ��Ϊ: /com/hi/platform/base/util
	   * @param str	���滻���ַ���
	   * @param oldchar ���滻���ַ�
	   * @param newchar �滻Ϊ���ַ�
	   * @return ��str�е�����oldchar�ַ�ȫ���滻Ϊnewchar,����������滻����ַ���
	   */
	  public static String replaceAll(String str,char oldchar,char newchar){
	    char[] chars = str.toCharArray();
	    for(int i = 0 ; i<chars.length;i++){
	      if(chars[i]==oldchar)
	        chars[i] = newchar;
	    }
	    return new String(chars);
	  }

	  /**
	   * ���inStr�ַ�����û�и���length�ĳ��ȣ�����fill��䣬��ָ��direction�ķ���
	   * ���inStr�ַ������ȴ���length��ֱ�ط���inStr����������
	   * @param inStr ��������ַ���
	   * @param fill �Ը��ַ�����Ϊ����ַ���
	   * @param length ����Ҫ��ĳ���
	   * @param direction ��䷽�������AFTER����ں��棬���������ǰ��
	   * @return ����һ��ָ������������ַ���
	   */
	  public static String fillStr(String inStr,String fill,int length,int direction){
	    if(inStr==null || inStr.length() > length || inStr.length()==0) return inStr;

	    StringBuffer tempStr = new StringBuffer("");
	    for (int i = 0 ; i<length-inStr.length() ; i++ ){
	      tempStr.append(fill);
	    }

	    if(direction == AFTER)
	      return new String(tempStr.toString()+inStr);
	    else
	      return new String(inStr+tempStr.toString());
	  }

	/**
	 * �ַ����滻
	 * @param str Դ�ַ���
	 * @param pattern ���滻���ַ���
	 * @param replace �滻Ϊ���ַ���
	 * @return
	 */
	public static String replace(String str, String pattern, String replace){
	    int s = 0;
	    int e = 0;
	    StringBuffer result = new StringBuffer();
	    while((e = str.indexOf(pattern,s)) >= 0){
	        result.append(str.substring(s,e));
	        result.append(replace);
	        s = e + pattern.length();
	    }
	    result.append(str.substring(s));
	        
	    return result.toString();
	}

    /**
     * �ָ��ַ�����һ������
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static List<String> dividToList(String str, String start, String end) {
        if (str == null || str.length() == 0)
            return null;

        int s = 0;
        int e = 0;
        List<String> result = new ArrayList<String>();
        if (isInclude(str, start) && isInclude(str, end)) {
            while ((e = str.indexOf(start, s)) >= 0) {
                result.add(str.substring(s, e));
                s = str.indexOf(end, e) + end.length();
                result.add(str.substring(e, s));
            }
            if (s < str.length())
                result.add(str.substring(s));

            if (s == 0)
                result.add(str);
        } else
            result.add(str);

        return result;
    }
	    

	/**
	 * ����ĸ��д
	 * @param string
	 * @return
	 */
	public static String upperFrist(String string){
		if(string == null)
			return null;
		String upper = string.toUpperCase();
		return upper.substring(0,1) + string.substring(1);
	}
	
	/**
	 * ����ĸСд
	 * @param string
	 * @return
	 */
	public static String lowerFrist(String string){
		if(string == null)
			return null;
		String lower = string.toLowerCase();
		return lower.substring(0,1) + string.substring(1);
	}
	
	public static String URLEncode(String string, String encode){
		try {
			return URLEncoder.encode(string, encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	  /**
	   * ��һ���������͵Ķ���ת��Ϊָ����ʽ���ַ���
	   * @param date ��ת��������
	   * @param format ת��Ϊ�ַ�������Ӧ��ʽ
	   * ���磺DateToStr(new Date() ,"yyyy.MM.dd G 'at' hh:mm:ss a zzz");
	   * @return һ���ַ���<p>
	   * 
	   * <table border="0" cellspacing="3" cellpadding="0">
	   *     <tr bgcolor="#ccccff">
	   *         <th align="left">Letter
	   *         <th align="left">Date or Time Component
	   *         <th align="left">Presentation
	   *         <th align="left">Examples
	   *     <tr>
	   *         <td><code>G</code>
	   *         <td>Era designator
	   *         <td><a href="#text">Text</a>
	   *         <td><code>AD</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td>Year
	   *         <td><a href="#year">Year</a>
	   *         <td><code>1996</code>; <code>96</code>
	   *     <tr>
	   *         <td><code>M</code>
	   *         <td>Month in year
	   *         <td><a href="#month">Month</a>
	   *         <td><code>July</code>; <code>Jul</code>; <code>07</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>w</code>
	   *         <td>Week in year
	   *         <td><a href="#number">Number</a>
	   *         <td><code>27</code>
	   *     <tr>
	   *         <td><code>W</code>
	   *         <td>Week in month
	   *         <td><a href="#number">Number</a>
	   *         <td><code>2</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>D</code>
	   *         <td>Day in year
	   *         <td><a href="#number">Number</a>
	   *         <td><code>189</code>
	   *     <tr>
	   *         <td><code>d</code>
	   *         <td>Day in month
	   *         <td><a href="#number">Number</a>
	   *         <td><code>10</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>F</code>
	   *         <td>Day of week in month
	   *         <td><a href="#number">Number</a>
	   *         <td><code>2</code>
	   *     <tr>
	   *         <td><code>E</code>
	   *         <td>Day in week
	   *         <td><a href="#text">Text</a>
	   *         <td><code>Tuesday</code>; <code>Tue</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>a</code>
	   *         <td>Am/pm marker
	   *         <td><a href="#text">Text</a>
	   *         <td><code>PM</code>
	   *     <tr>
	   *         <td><code>H</code>
	   *         <td>Hour in day (0-23)
	   *         <td><a href="#number">Number</a>
	   *         <td><code>0</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>k</code>
	   *         <td>Hour in day (1-24)
	   *         <td><a href="#number">Number</a>
	   *         <td><code>24</code>
	   *     <tr>
	   *         <td><code>K</code>
	   *         <td>Hour in am/pm (0-11)
	   *         <td><a href="#number">Number</a>
	   *         <td><code>0</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>h</code>
	   *         <td>Hour in am/pm (1-12)
	   *         <td><a href="#number">Number</a>
	   *         <td><code>12</code>
	   *     <tr>
	   *         <td><code>m</code>
	   *         <td>Minute in hour
	   *         <td><a href="#number">Number</a>
	   *         <td><code>30</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>s</code>
	   *         <td>Second in minute
	   *         <td><a href="#number">Number</a>
	   *         <td><code>55</code>
	   *     <tr>
	   *         <td><code>S</code>
	   *         <td>Millisecond
	   *         <td><a href="#number">Number</a>
	   *         <td><code>978</code>
	   *     <tr bgcolor="#eeeeff">
	   *         <td><code>z</code>
	   *         <td>Time zone
	   *         <td><a href="#timezone">General time zone</a>
	   *         <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code>
	   *     <tr>
	   *         <td><code>Z</code>
	   *         <td>Time zone
	   *         <td><a href="#rfc822timezone">RFC 822 time zone</a>
	   *         <td><code>-0800</code>
	   * </table>
	   */
	  public static String DateToStr( Date date , String format){
	    SimpleDateFormat formatter = new SimpleDateFormat (format);
	    return formatter.format(date);
	  }
	
	public static void  main(String[] args){
		String test = "{js}commonEditAction.hi?bo=HiUser&amp;recodeNum={js}[#himenuitemid];alert([#himenuitemid])";
		System.out.println(StringUtils.subString(test, "{","}"));
	}
}
