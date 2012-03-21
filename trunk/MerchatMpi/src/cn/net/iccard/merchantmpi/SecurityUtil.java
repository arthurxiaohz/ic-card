package cn.net.iccard.merchantmpi;

import java.security.MessageDigest;

public class SecurityUtil {

	
	/**
	 * ��������MD5ժҪ
	 * 
	 * @param aData
	 *            Դ����
	 * @return ժҪ���
	 * @throws SecurityException
	 * @author nilomiao
	 * @since 2009-11-27
	 */
	public static String MD5Encode(String aData) throws SecurityException {
		String resultString = null;
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = bytes2HexString(md.digest(aData.getBytes("UTF-8")));
        } catch (Exception e) {
        	e.printStackTrace();
			throw new SecurityException("MD5����ʧ��");
        }
        return resultString;
	}
        
        public static String bytes2HexString(byte[] b) {
    		String ret = "";
    		for (int i = 0; i < b.length; i++) {
    			String hex = Integer.toHexString(b[i] & 0xFF);
    			if (hex.length() == 1) {
    				hex = '0' + hex;
    			}
    			ret += hex.toUpperCase();
    		}
    		return ret;
    	}
}
