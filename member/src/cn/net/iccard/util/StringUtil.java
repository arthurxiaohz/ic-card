package cn.net.iccard.util;




import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;
/**
 * Utils for String process
 */
public class StringUtil {
	

	/**
	 * split string with empty field kept.
	 * 
	 * Example: if: String test = "a|b||c||"; then: String[] result =
	 * {"a","b","","c","",""};
	 * 
	 * @param sourceString
	 * @param delimiter
	 * @return String[]
	 * 
	 * @author gyg
	 */
	public static String[] split(String sourceString, String delimiter) {
		// check input parameters
		if (sourceString == null)
			return (new String[0]);
		if (delimiter == null)
			return null;
		if ((sourceString.trim()).equals(""))
			return (new String[0]);

		// define variables
		String str = null;
		int intPos = 0;
		ArrayList arrayList = new ArrayList();
		String[] strRet = new String[1];

		// begin split
		intPos = sourceString.indexOf(delimiter);
		String strTemp = "";
		while (intPos != -1) {
			if (intPos != 0) {
				// process ESC
				if (sourceString.substring(intPos - 1, intPos).equals("\\")) {
					strTemp = strTemp + sourceString.substring(0, intPos - 1)
							+ delimiter;
					sourceString = sourceString.substring(intPos + 1);
					intPos = sourceString.indexOf(delimiter);
					continue;
				}
			}

			str = strTemp.equals("") ? sourceString.substring(0, intPos).trim()
					: strTemp + sourceString.substring(0, intPos).trim();
			sourceString = sourceString.substring(intPos + 1);
			arrayList.add(str);
			strTemp = "";
			intPos = sourceString.indexOf(delimiter);
		}
		arrayList.add(sourceString.trim());

		// transfer ArrayList to String[]
		strRet = new String[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			strRet[i] = (String) arrayList.get(i);
		}

		return strRet;
	}

	/**
	 * split string ignore empty fields
	 * 
	 * Example: if: String test = "a|b||c||"; then: String[] result =
	 * {"a","b","c"};
	 * 
	 * @param sourceString
	 * @param delimiter
	 * 
	 * @return String[]
	 * @author gyg
	 */
	public static String[] splitIgnoreEmptyFields(String sourceString,
			String delimiter) {
		// check input parameters
		if (sourceString == null)
			return (new String[0]);
		if (delimiter == null)
			return null;
		if ((sourceString.trim()).equals(""))
			return (new String[0]);

		// begin split the input string
		StringTokenizer st = new StringTokenizer(sourceString, delimiter);
		String[] tResult = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			tResult[i++] = st.nextToken();
		}

		return tResult;
	}

	/**
	 * 判断传入的字符串格式 只允许数字�1�7�小数点后带丄1�7位或两位的数字字符串
	 * 
	 * @param String
	 *            str
	 * @return boolean
	 */
	public static boolean IsNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				if (str.charAt(i) == '.' && i != 0 && i < str.length() - 1
						&& str.length() >= 3 && (str.length() - i <= 3)) {
					continue;
				}

				return false;
			}

		}
		return true;
	}

	/**
	 * 将传入的金额转换为如ￄ1�7,888.00格式
	 * 
	 * @param account
	 *            金额数量
	 * @return
	 */
	public static String numberFormat(long account) {
		Locale locale = Locale.CHINA;
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		return nf.format(account);
	}

	/**
	 * 将传入的金额转换为如ￄ1�7,888.00格式
	 * 
	 * @param account
	 *            金额数量
	 * @return
	 */
	public static String numberFormat(int account) {
		Locale locale = Locale.CHINA;
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

		return nf.format(account);
	}

	/**
	 * 将传入的金额转换为如ￄ1�7,888.00格式
	 * 
	 * @param account
	 *            金额数量
	 * @return
	 */
	public static String numberFormat(Object account) {
		Locale locale = Locale.CHINA;

		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

		return nf.format(account);
	}

	/**
	 * 将传入的金额转换为如ￄ1�7,888.00格式
	 * 
	 * @param account
	 *            金额数量
	 * @return
	 */
	public static String numberFormat(double account) {
		Locale locale = Locale.CHINA;

		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

		return nf.format(account);
	}

	/**
	 * add by wangzeng 判断字符串是否为中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		str = toGb2312(str);
		byte b[];
		try {
			b = str.getBytes("ISO8859_1");
			for (int i = 0; i < b.length; i++) {
				byte b1 = b[i];
				if (b1 < 0 || b1 == 63) {
					return true;
				}

			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * add by wangzeng
	 * 
	 * 用getBytes(encoding)：返回字符串的一个byte数组 当b[0]丄1�7 63时，应该是转码错评1�7 A、不乱码的汉字字符串＄1�7
	 * 1、encoding用GB2312时，每byte是负数； 2、encoding用ISO8859_1时，b[i]全是63〄1�7 B、乱码的汉字字符串：
	 * 1、encoding用ISO8859_1时，每byte也是负数＄1�7 2、encoding用GB2312时，b[i]大部分是63〄1�7 C、英文字符串
	 * 1、encoding用ISO8859_1和GB2312时，每byte都大亄1�7�1�7 <p/>
	 * 总结：给定一个字符串，用getBytes("iso8859_1") 1、如果b[i]朄1�7，不用转码； A-2
	 * 2、如果b[i]全大亄1�7�那么为英文字符串，不用转码＄1�7 B-1 3、如果b[i]有小亄1�7�，那么已经乱码，要转码〄1�7 C-1
	 */
	public static String toGb2312(String str) {
		if (str == null) {
			return null;
		}
		String retStr = str;
		byte b[];
		try {
			b = str.getBytes("ISO8859_1");
			for (int i = 0; i < b.length; i++) {
				byte b1 = b[i];
				if (b1 == 63) {
					break;
				} else if (b1 > 0) {
					continue;// 2
				} else if (b1 < 0) { // 不可能为0＄1�7�字符串结束笄1�7
					retStr = new String(b, "GB2312");
					break;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			// To change body of catch statement use File | Settings | File
			// Templates.
		}
		return retStr;
	}

	public static String splitString(String str, String beginTag, String endTag) {
		String result = "";
		String[] r1 = str.split(beginTag);
		String[] r2 = r1[1].split(endTag);
		result = r2[0];
		return result;
	}
	
	public static String splString(String str, String beginTag, String endTag) {
		String result = "";
		try{
			String[] r1 = str.split(beginTag);
			String[] r2 = r1[1].split(endTag);
			result = r2[0];
		}catch(Exception e){
			//logger.error("splString fail:",e);
		}
		return result;
	}
	
	public static String tagString(String str, String beginTag, String endTag) {
		String result = "";
		String[] r1 = str.split(beginTag);
		String[] r2 = r1[1].split(endTag);
		result = beginTag + r2[0] + endTag;
		return result;
	}
	/**
	 * 将相关字符串前面，补0，补为制定的位数 如果大于等于指定的位数，返回原�1�7�1�7
	 * 
	 * @author kyle
	 * @param num
	 * @param str
	 * @return
	 */
	public static String addZero(int num, String str) {
		StringBuffer bf = new StringBuffer(str);
		int strLenght = str.length();
		// System.out.println("------strLenght=["+Integer.toString(strLenght)+"]-------");
		if (strLenght >= num) {
			return str;
		} else {
			for (int i = strLenght; i < num; i++) {

				StringBuffer bf1 = new StringBuffer("0");
				// System.out.println("------i=["+Integer.toString(i)+"]-------");
				// System.out.println("------bf1.toString=["+bf1.toString()+"]-------");
				bf = bf1.append(bf);

			}
			return bf.toString();
		}
	}

	/**
	 * @author kyle 设置金额精确到小数点后两佄1�7
	 * @param args
	 * @throws Exception
	 * @throws Exception
	 */
	public static String getFormatValue(Object value) {
		String formatvalue = "";
		try {
			DecimalFormat myformat1 = new DecimalFormat("#0.00");
			formatvalue = myformat1.format(value);

		} catch (IllegalArgumentException ex) {
//			if (logger.isErrorEnabled()) {
//				logger.error("IllegalArgumentException fail:", ex);
//			}
			throw ex;
		}
		return formatvalue;
	}

	public static void main(String args[]) {
		// String aaa = "ff.bb.vv";
		// String[] aaas = split(aaa, ".");
		// for (int i = 0; i < aaas.length; i++) {
		// System.out.println(aaas[i]);
		// }
		// System.out.println(new BigDecimal("010.01").movePointRight(2));
		// System.out.println("." + IsNum("."));
		// System.out.println(".1" +IsNum(".1"));
		// System.out.println(".01" + IsNum(".01"));
		// System.out.println(".001" + IsNum(".001"));
		// System.out.println("0.1" + IsNum("0.1"));
		// System.out.println("0.11" + IsNum("0.11"));
		// System.out.println("0.111" + IsNum("0.111"));
		// System.out.println("0" + IsNum("0"));
		// System.out.println("a" + IsNum("a"));
		// System.out.println("-1" + IsNum("-1"));
		// System.out.println("999999999999" + IsNum("999999999999"));
		// System.out.println("1." + IsNum("1."));
		// System.out.println("11." + IsNum("11."));
		// System.out.println("111." + IsNum("111."));
		// System.out.println("111.1" + IsNum("111.1"));
		// System.out.println("111.11" + IsNum("111.11"));
		StringUtil stringUtil = new StringUtil();
		String str = stringUtil.addZero(2, "3");
		System.out.println("------str=[" + str + "]-------");
	}
}
