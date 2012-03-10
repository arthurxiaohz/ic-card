package cn.net.iccard.txsimulator;



import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

/**
 * get global unique serial no
 */
public class GUID {
	

	private static String tHexServerIP = null;
	private static final SecureRandom tSecureRandom = new SecureRandom();

	/**
	 * get global unique serial no
	 * @return String global unique serial no
	 */
	public static final String generateGUID() {
		Object tObject = new Object();
		StringBuffer tStringBuffer = new StringBuffer(16);
		if (tHexServerIP == null) {
			InetAddress tInetAddress = null;
			try {
				tInetAddress = InetAddress.getLocalHost();
			} catch (UnknownHostException uhe) {
				
				return null;
			}
			byte tServerIP[] = tInetAddress.getAddress();
			tHexServerIP = hexFormat(getInt(tServerIP), 8);
		}
		String tHashCode = hexFormat(System.identityHashCode(tObject), 8);
		tStringBuffer.append(tHexServerIP);
		tStringBuffer.append(tHashCode);
		long tTimeNow = System.currentTimeMillis();
		int tTimeLow = (int) tTimeNow & -1;
		int tNode = tSecureRandom.nextInt();
		StringBuffer tGuid = new StringBuffer(32);
		tGuid.append(hexFormat(tTimeLow, 8));
		tGuid.append(tStringBuffer.toString());
		tGuid.append(hexFormat(tNode, 8));
		return tGuid.toString();
	}

	private static int getInt(byte bytes[]) {
		int i = 0;
		int j = 24;
		for (int k = 0; j >= 0; k++) {
			int l = bytes[k] & 0xff;
			i += l << j;
			j -= 8;
		}

		return i;
	}

	private static String hexFormat(int i, int j) {
		String tString = Integer.toHexString(i);
		return padHex(tString, j) + tString;
	}

	private static String padHex(String s, int i) {
		StringBuffer tStringBuffer = new StringBuffer();
		if (s.length() < i) {
			for (int j = 0; j < i - s.length(); j++)
				tStringBuffer.append('0');

		}
		return tStringBuffer.toString();
	}
	
	public static void main(String args[]){
		System.out.println(System.currentTimeMillis());
		System.out.println(GUID.generateGUID());
		for (int i = 0; i < 1; i++) {
			System.out.println(GUID.generateGUID());
			
		}
		System.out.println(System.currentTimeMillis());
	}
}