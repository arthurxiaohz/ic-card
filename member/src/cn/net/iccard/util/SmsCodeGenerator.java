package cn.net.iccard.util;


import java.util.Random;


public class SmsCodeGenerator {
	
	private static SmsCodeGenerator instance;
	
	private static String base = "1A2BC3DE4FG5HI6J7K8LM9NOPQ0RSTUVWXYZ";

	/**
	 * 单例.
	 * 
	 * @return
	 */
	public static SmsCodeGenerator getInstance() {
		if(null == instance){
			instance=new SmsCodeGenerator();
		}
		return instance;
	}

	/**
	 * 生成指定长度的随机数
	 * @param length
	 * @return
	 */
	public String getRandomSmsCode(int length) { 
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }   

	

}
