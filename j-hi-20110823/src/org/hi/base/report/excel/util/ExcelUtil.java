package org.hi.base.report.excel.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 张昊
 *
 */
public class ExcelUtil {
	private static Map<Character, Integer> alphabetic = null;
	
	/**
	 * 最大列数
	 */
	public static final Integer MAX_COLUMN = 255;
	/**
	 * 最大行数
	 */
	public static final Integer MAX_ROW = 65535;
	public static final int EXCEL_HEX = 26;
	
	static{
		if(alphabetic == null){
			alphabetic = new LinkedHashMap<Character, Integer>();
			for (int i = 65; i < 91; i++) {
				alphabetic.put((char)i, i-64);
			}
		}
	}
	
	 
	public static Integer getInteger(String colName){
		if(colName == null || colName.trim().equals(""))
			return null;
		int result = 0;
		for (int i = 0; i < colName.length(); i++) {
			Integer val = alphabetic.get(colName.charAt(i));
			
			if(val == null)
				return null;
			
			result += Hex(colName.length() - i - 1 ,val);
		}
		
		return result;
	}
	
	private static int Hex(int digit, int number){
		return (int) (number * Math.pow(EXCEL_HEX, digit));
	}
	
	public static boolean isChristcross(String str){
		if(str == null || str.trim().equals(""))
			return false;
		
		for (int i = 0; i < str.length(); i++) {
			if(alphabetic.get(str.charAt(i)) == null)
				return false;
		}
		return true;
	}
	
	/*
	 * 判断是否数字
	 */
	public static boolean isNumber(String str){
		if(str == null || str.trim().equals(""))
			return false;
		try{
			Integer.parseInt(str);
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args){
//		System.out.println("张昊".toUpperCase());;
//		System.out.println(getInteger("IU"));
		System.out.println(isNumber("12"));
	}
}
