package cn.net.iccard.util;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class BankTraceNoGererator {
	private static int serialNo = 1;
	
	/**
	 * 生成流水号
	 * @param systemNo
	 * @return
	 */
	public synchronized static String generateALiPayTraceNo(String systemNo){
		//流水号规则：yyyyMMddHHmmss+systemNo+serialNo(14+2+4)
		//1. 取得当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		String yyyyMMddHHmmss = df.format(cal.getTime());

		//2. 系统编号处理 	
		if (null == systemNo || systemNo.length()!=2){
			systemNo = "xx";
		}
		
		//3. serialNo处理
		String serialNoStr = new StringBuffer("0000").append(serialNo).toString();
		serialNoStr = serialNoStr.substring(serialNoStr.length()-4);


		//4. 更新serialNo
		serialNo += 1;
		if (serialNo > 9999) {
			serialNo = 1;
		}
		
		//5. 返回流水号
		return new StringBuffer(yyyyMMddHHmmss).append(systemNo).append(serialNoStr).toString();
	}
}
