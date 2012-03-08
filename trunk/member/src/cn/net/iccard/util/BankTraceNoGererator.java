package cn.net.iccard.util;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class BankTraceNoGererator {
	private static int serialNo = 1;
	
	/**
	 * ������ˮ��
	 * @param systemNo
	 * @return
	 */
	public synchronized static String generateALiPayTraceNo(String systemNo){
		//��ˮ�Ź���yyyyMMddHHmmss+systemNo+serialNo(14+2+4)
		//1. ȡ�õ�ǰʱ��
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		String yyyyMMddHHmmss = df.format(cal.getTime());

		//2. ϵͳ��Ŵ��� 	
		if (null == systemNo || systemNo.length()!=2){
			systemNo = "xx";
		}
		
		//3. serialNo����
		String serialNoStr = new StringBuffer("0000").append(serialNo).toString();
		serialNoStr = serialNoStr.substring(serialNoStr.length()-4);


		//4. ����serialNo
		serialNo += 1;
		if (serialNo > 9999) {
			serialNo = 1;
		}
		
		//5. ������ˮ��
		return new StringBuffer(yyyyMMddHHmmss).append(systemNo).append(serialNoStr).toString();
	}
}
