package org.hi.common.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.hi.framework.web.BusinessException;
import org.hi.i18n.util.I18NUtil;

/**
 * ������������ת��Ϊ���Ĵ�д����
 * @author ���
 * @since 2009-01-05
 *
 */
public class ChineseNumber {
	private static final String[] BEFORE_SCALE =  {"��","Ǫ","��","ʰ","��","Ǫ","��","ʰ","��","Ǫ","��","ʰ",""};
	private static final String[] AFTER_SCALE = {"��","��"};
	private static final String DEFAULT_PATH_SEPARATOR = ".";
	 
	private static final Map<String, String> NUMBER_MAPPING= new HashMap<String, String>();
	static{
		NUMBER_MAPPING.put("0", "��");
		NUMBER_MAPPING.put("1", "Ҽ");
		NUMBER_MAPPING.put("2", "��");
		NUMBER_MAPPING.put("3", "��");
		NUMBER_MAPPING.put("4", "��");
		NUMBER_MAPPING.put("5", "��");
		NUMBER_MAPPING.put("6", "½");
		NUMBER_MAPPING.put("7", "��");
		NUMBER_MAPPING.put("8", "��");
		NUMBER_MAPPING.put("9", "��");
	}
	
	public static String getChineseNumber(String number){
		return getChineseNumber(number, null, null);
	}
	public static String getChineseNumber(String number,String unit, String postfix){
		
		String[] numbers = StringUtils.strToStrArray(number,DEFAULT_PATH_SEPARATOR);
		if(numbers.length > 2)
			new BusinessException(I18NUtil.getString("���ָ�ʽ����!"));
		
		int length = numbers[0].length();
		int isZero = 0;
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < length; i++) {
			String digit = String.valueOf(numbers[0].charAt(i));
			
			boolean allZero = true;	//�����̵�ȫ������,������
			for (int j = i; j < length; j++) {
				if(numbers[0].charAt(j) != '0'){
					allZero = false;
					break;
				}
			}
			
			if(allZero){
				boolean hasValue = false;
				for (int z = i; z >= 0; z--) {
					if(numbers[0].charAt(z) != '0' &&  length -z <= 7 && length -z >=5){
						hasValue = true;
						break;
					}
				}
				
				
				if((length - i > 4 && length  <= 8) || (hasValue && length - i > 4))		//����λ
					result.append(BEFORE_SCALE[8]);
				if(length - i >= 9)
					result.append(BEFORE_SCALE[4]);			//���ڵ�λ
				break;
			}
			
			if(length < 9 && length - i == 5 ){
				if(!digit.equals("0")  && isZero > 0) //|| numbers[0].charAt(i-2) == '0' || numbers[0].charAt(i-2) == '0'))
					result.append(NUMBER_MAPPING.get("0"));
				if(digit.equals("0")){
					result.append(BEFORE_SCALE[8]);
					if(isZero > 0)
						result.append(NUMBER_MAPPING.get("0"));
					continue;
				}
			}
			if(digit.equals("0") &&  length > 9 && length - i == 9){
				result.append(BEFORE_SCALE[4]);//.append(NUMBER_MAPPING.get("0"));;
				continue;
			}
			
			if( isZero <1 || !digit.equals("0")){
				if(digit.equals("0")){
					if(length-i!=6 && length-i!=7)
						result.append(NUMBER_MAPPING.get(digit));
				}else{
					result.append(NUMBER_MAPPING.get(digit));
				}
					
				if(!digit.equals("0") )
						result.append(BEFORE_SCALE[BEFORE_SCALE.length - length + i]);
			}
			

			
			if(digit.equals("0"))
				isZero ++;
			else
				isZero = 0;
		}
		result.append(unit == null ? "Բ" :result.append(unit));

		if(numbers.length == 1){
			result.append(postfix == null ? "��" :result.append(postfix));
			return result.toString();
		}
		
		length = numbers[1].length();
		for (int j = 0; j < length; j++) {
			if(j >2)
				break;
			
			if(numbers[1].charAt(j) == '0')
				continue;
			result.append(NUMBER_MAPPING.get(String.valueOf(numbers[1].charAt(j))));
			result.append(AFTER_SCALE[j]);
		}
		
		result.append(postfix == null ? "��" :result.append(postfix));
		
		return result.toString();
	}
	public static String getChineseNumber(int number){
		return getChineseNumber(new Integer(number));
	}

	public static String getChineseNumber(int number,String unit, String postfix){
		return getChineseNumber(new Integer(number),unit, postfix);
	}
	public static String getChineseNumber(Long number){
		return getChineseNumber(number.toString(),null, null);
	}
	public static String getChineseNumber(Integer number){
		return getChineseNumber(number.toString(), null, null);
	}
	public static String getChineseNumber(Integer number,String unit, String postfix){
		return getChineseNumber(number.toString(), unit, postfix);
	}
	public static String getChineseNumber(Long number,String unit, String postfix){
		return getChineseNumber(number.toString(),unit, postfix);
	}
	public static String getChineseNumber(long number){
		return getChineseNumber(new Long(number));
	}

	public static String getChineseNumber(long number,String unit, String postfix){
		return getChineseNumber(new Long(number),unit, postfix);
	}
	
	public static String getChineseNumber(double number,String unit, String postfix){
		DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance();
		f.applyLocalizedPattern("#.##");
		return getChineseNumber(f.format(number),unit, postfix);
	}
	public static String getChineseNumber(double number){
		return getChineseNumber(number,null, null);
	}
	public static String getChineseNumber(Double number){
		return getChineseNumber(number.doubleValue());
	}
	
	public static String getChineseNumber(Double number,String unit, String postfix){
		return getChineseNumber(number.doubleValue(),unit,postfix);
	}
	public static void main(String[] args) {
		System.out.println(getChineseNumber(205008));
		System.out.println(getChineseNumber(1020090090.99));
//		System.out.println(getChineseNumber(208));
	}

}
