package cn.net.iccard.util;



import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Properties;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 * SSL���ӷ�����
 * �����ṩSSL���ӵĽ����������շ�
 */
public class SSLConnectionManager {
	static org.apache.commons.logging.Log logger =
		org.apache.commons.logging.LogFactory.getLog(SSLConnectionManager.class.getName());
    
    private static final String ibmJavaVmVendor  = "IBM Corporation";
   // private static final String sunJavaVmVendor  = "Sun Microsystems Inc.";
    

    /**
     * �����������ͱ��
     */
    public static final String HTTPPKG_CONTENTTYPE = "Content-Type";
    
    public static final String HTTPPKG_ACCEPT = "accept";
    
    /**
     * JDK provider
     */
    private  static int   iProviderType = 0; //0-Sun,1-IBM
    
    /**
     * ���ŵķ�����֤�����
     */
    private static final TrustManager[] iTrustManager = new TrustManager[] { new SampleTrustManager() };

    /**
     * Ĭ��SSLSocketFactory
     */
    private static final SSLSocketFactory iDefaultSSLSocketFactory = initSSLSocketFactory();
    
    /**
     * ������URL
     */
    private URL iServerURL = null;
    
    /**
     * Socket
     */
    private Socket iSocket = null;
    
    /**
     * �����
     */
    private OutputStream iOutputStream = null;

    /**
     * ������
     */
    private BufferedInputStream iBufferedInputStream = null;


    /**
     * ���췽��
     */
    public SSLConnectionManager() {

    }

    /**
     * ȡ�����ʵ��
     * @return
     */
    public static SSLConnectionManager getInstance() {
        return new SSLConnectionManager();
    }
    
    /**
     * ��ʼ��SSLSocketFactory����
     * @return Ĭ��SSLSocketFactory����
     */
    private static SSLSocketFactory initSSLSocketFactory() {
		logger.debug("initSSLSocketFactory() start...");
        SSLSocketFactory tSSLSocketFactory = null;
        //1����ʼ��SSL����
        getVendorType();
        try {
            SSLContext tDefaultSSLContext = null;
            if(iProviderType == 1) {
                Class tClass = Class.forName("com.ibm.jsse2.IBMJSSEProvider2");
                java.security.Security.addProvider((Provider)tClass.newInstance());
                tDefaultSSLContext = SSLContext.getInstance("TLS","IBMJSSE2");
            }
            else {
                Class tClass = Class.forName("com.sun.net.ssl.internal.ssl.Provider");
                java.security.Security.addProvider((Provider)tClass.newInstance());
                tDefaultSSLContext = SSLContext.getInstance("TLS","SunJSSE");
            }
            
            tDefaultSSLContext.init(null, iTrustManager, null);
            tSSLSocketFactory = tDefaultSSLContext.getSocketFactory();
            
			logger.debug("initSSLSocketFactory() end.");
        }
        catch (Exception e) {
			logger.fatal("SSLConnectionManager::initSSLSocketFactory() - Create SSLSocketFactory error:[" + e.getMessage() + "]");
			logger.fatal("", e);
        }
        
        return tSSLSocketFactory;
    }


    /**
     * �������󲢽��շ�����������
     * �����ص㣺
     *   1��ʹ���Ѿ������õķ���������
     *   2��ʹ�� key=value�ķ�ʽ��������
     * 
     * @param aData �����͵�����
     * @param aProp ������ͷ�趨
     * 
     * @return String ������
     * @throws PlHttpConnectionException
     */
    public String sendData(ArrayList aData, Properties aProp) throws PlHttpConnectionException {
        String tReturn = null;
        //1����鷢������
        logger.debug("Verify request data......");
        if (aData == null || aData.size() < 1) {
            throw new PlHttpConnectionException("Request data invalid.");
        }

        //2�����URL����
		logger.debug("Check if the server connection is created......");
        if (iOutputStream == null) {
            throw new PlHttpConnectionException("!!! Server connection is not created!!!");
        }

        //3����������������Ϣ
		logger.debug("Arrange request data......");
        StringBuffer tSb = new StringBuffer();
        for (int i = 0; i < aData.size(); i++) {
            HttpPostObj tObj = (HttpPostObj) aData.get(i);
            tSb.append(tObj.getKey());
            tSb.append("=");
            tSb.append(tObj.getValue());
            if (i + 1 >= aData.size()) {
                break;
            }
            else {
                tSb.append("&");
            }
        }
        
        try {
			byte[] b = tSb.toString().getBytes("UTF-8");

            //4����������
			logger.debug("Send request to server......");
            try {
                sendRequest(b, aProp);
            }
            catch (Exception e) {
//				logger.error("", e);
                throw new PlHttpConnectionException("Send reques data error:" + e.getMessage());
            }
    
            //5�����շ�������Ӧ
			logger.debug("Receive response message......");
            try {
                tReturn = receiveResponse();
            }
            catch (Exception ex) {
                //���ͳɹ�����ʧ����Ϊ��ʱ
//				logger.error("", ex);
                throw new PlHttpConnectionException("Receive response message error:" + ex.getMessage());
            }
        }
        catch (Exception ex) {
            //6�����ͳɹ�����ʧ����Ϊ��ʱ
			logger.error("", ex);
			throw new PlHttpConnectionException(ex);
        }
        finally {
			logger.debug("Received server response message=[" + tReturn + "]");
            closeConnection();
        }
       
        return tReturn;
    }

    /**
     * �������󲢽��շ�����������
     * �����ص㣺
     *   1�����½�������������
     *   2�����͵��������ݲ�һ����key=value��ʽ����Ϊ�����͵��������ⲿ������룩
     * 
     * @param aServerUrl ������URL
     * @param aOutputData ���͸�����������
     * @param aConnTimeOut 
     * @param aReadTimeOut
     * @param aProp ������ͷ�趨
     * 
     * @return String ���ش�������ȡ���ַ���,������� null-----Ϊ��ʱ
     * @throws PlHttpConnectionException �׳��쳣��Ϊ�Ƿ���ʧ�ܡ�
     */
    public String sendData(String aServerUrl, byte[] aOutputData, String aConnTimeOut, String aReadTimeOut, Properties aProp)
            throws PlHttpConnectionException {
        String tReturn = null;

        try {
            //1��������������������
			logger.debug("Create connection to server......");
            createHttpsConnectionWithoutVerify(aServerUrl, aConnTimeOut, aReadTimeOut);

            //2����������
			logger.debug("Send request to server......");
            try {
                sendRequest(aOutputData, aProp);
            }
            catch (Exception e) {
                throw new PlHttpConnectionException("Send request error:" + e.getMessage());
            }
    
            //3�����շ�������Ӧ
			logger.debug("Read server response message......");
            try {
                tReturn = receiveResponse();
            }
            catch (Exception ex) {
                //���ͳɹ�����ʧ����Ϊ��ʱ
                throw new PlHttpConnectionException("Read server response message error:" + ex.getMessage());
            }
        }
        catch (Exception ex) {
            //4�����ͳɹ�����ʧ����Ϊ��ʱ
			logger.error(ex);
			throw new PlHttpConnectionException(ex);
        }
        finally {
			logger.debug("Received server response message=[" + tReturn + "]");
            closeConnection();
        }

        return tReturn;
    }
    
    /**
     * ������Ϣ��������
     * 
     * @param aOutputData ���͸�����������
     * 
     * @throws Exception �׳��쳣��Ϊ�Ƿ���ʧ�ܡ�
     * 
     */
    private void sendRequest(byte[] aOutputData) throws Exception {
        byte tNewLine[] = {'\r', '\n'}; 
        StringBuffer tHttpRequest = new StringBuffer("")
            .append("POST ").append(iServerURL.getPath()).append(" HTTP/1.1\r\n")
            .append("User-Agent: Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1;InfoPath.2)\r\n")
            .append("Host: ").append(iServerURL.getHost()).append("\r\n")
            .append("Accept: text/html\r\n")
            .append("Content-Type: application/x-www-form-urlencoded\r\n")
            .append("Content-Length: ").append(aOutputData.length).append("\r\n")
            .append("\r\n");
        
        iOutputStream.write(tHttpRequest.toString().getBytes());
        iOutputStream.write(aOutputData);
        iOutputStream.write(tNewLine);
        iOutputStream.flush();
    }

	/**
	 * ������Ϣ��������
	 * 
	 * @param aOutputData ���͸�����������
	 * @param aProp ����ͷ�趨
	 * 
	 * @throws Exception �׳��쳣��Ϊ�Ƿ���ʧ�ܡ�
	 */
	private void sendRequest(byte[] aOutputData, Properties aProp) throws Exception {
		if (aProp == null) {
			sendRequest(aOutputData);
			return;
		}
		
		String tContentType = aProp.getProperty(HTTPPKG_CONTENTTYPE);
		if (tContentType == null || tContentType.equals("")) tContentType = "application/x-www-form-urlencoded";
		
		String tAccept = aProp.getProperty(HTTPPKG_ACCEPT);
		if (tAccept == null || tAccept.equals("")) tAccept = "text/html";
		
//		byte tNewLine[] = {'\r', '\n'}; 
		
		StringBuffer tHttpRequest = new StringBuffer("")
			.append("POST ").append(iServerURL.getPath()).append(" HTTP/1.1\r\n")
			.append("User-Agent: Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1;InfoPath.2)\r\n")
            .append("Host: ").append(iServerURL.getHost()).append("\r\n")
			.append("Accept: ").append(tAccept).append("\r\n")
			.append("Content-Type: ").append(tContentType).append("\r\n")
			.append("Content-Length: ").append(aOutputData.length).append("\r\n")
			.append("\r\n");
        
		iOutputStream.write(tHttpRequest.toString().getBytes());
		iOutputStream.write(aOutputData);
//		iOutputStream.write(tNewLine);
		iOutputStream.flush();
	}

    /**
     * ���շ�������Ӧ��Ϣ
     * @return String ���ش�������ȡ���ַ���
     * @throws PlHttpConnectionException �׳��쳣��Ϊ�Ƿ���ʧ�ܡ�
     */
    private String receiveResponse() throws Exception {
        StringBuffer tReturnMsg = new StringBuffer();
        int tContentLength = -1;
        
        //1����ȡ��Ӧ��
        String tResponseCode = readLine(iBufferedInputStream);
		logger.debug("HTML Response Code = [" + tResponseCode + "]");
        if ((tResponseCode == null) || 
			((tResponseCode.indexOf("HTTP/1.1 100") != 0) && 
			 (tResponseCode.indexOf("HTTP/1.1 200") != 0) && 
			 (tResponseCode.indexOf("HTTP/1.0 100") != 0) && 
			 (tResponseCode.indexOf("HTTP/1.0 200") != 0))){
				throw new PlHttpConnectionException("Server response error code=[" + tResponseCode + "]"); 
			 }
        
        //2������HTTP/1.1 100 Conitnue
        if (tResponseCode.indexOf("HTTP/1.1 100") == 0) {
            //2.1 ��ȡ����HTTP Header
            while (true) {
                String tTemp = readLine(iBufferedInputStream);
				logger.debug("HTML HEAD = [" + tTemp + "]");
                if ("".equals(tTemp))
                    break;
            }
            
            //2.2 ��ȡ��ʽ��Ӧ��
            tResponseCode = readLine(iBufferedInputStream);
			logger.debug("HTML Response Code = [" + tResponseCode + "]");
            if ((tResponseCode == null) || (tResponseCode.indexOf("HTTP/1.1 200") != 0))
                throw new PlHttpConnectionException("Server response error code=[" + tResponseCode + "]"); 
        }
        
        //3����ȡHTTP Header
        while (true) {
            String tTemp = readLine(iBufferedInputStream);
			logger.debug("HTML HEAD = [" + tTemp + "]");
            if ("".equals(tTemp))
                break;
            if (tTemp.toLowerCase().indexOf("content-length: ") != -1) {
                tContentLength = Integer.parseInt(tTemp.substring(16));
            }
        }
		logger.debug("Content-Length = [" + tContentLength + "]");
        
        //4����ȡ��Ӧ��Ϣ
        if (tContentLength != -1) {
            //4.1��HEAD���Ѿ�ָ�����ݳ���
            String tTemp = read(iBufferedInputStream, tContentLength);
			logger.debug("HTML BODY = [" + tTemp + "]");
			logger.debug("HTML BODY Len = [" + tTemp.length() + "]");
            tReturnMsg.append(tTemp);
        }
        else {
            //4.2������Transfer-Encoding: chunked���д���
            while (true) {
                //4.2.1����ȡ��Ӧ��Ϣ����
                int tLen = Integer.parseInt(readLine(iBufferedInputStream), 16);
				logger.debug("HTML Length = [" + tLen + "]");
                if (tLen <= 0)
                    break;
        
                //4.2.2����ȡHTML Body
                String tTemp = read(iBufferedInputStream, tLen);
				logger.debug("HTML BODY = [" + tTemp + "]");
				logger.debug("HTML BODY Len = [" + tTemp.length() + "]");
                tReturnMsg.append(tTemp);
                
                //4.2.3����ȡ�հ���
                readLine(iBufferedInputStream);
            }
        }
        
        return tReturnMsg.toString();
    }
    
    /**
     * ���������ж�ȡһ��
     * @param aBufferedInputStream ������
     * @return ��ȡ���ַ�
     * @throws IOException 
     */
    private String readLine(BufferedInputStream aBufferedInputStream) throws IOException {
        byte[] tTemp = new byte[10240];
        int i = 0;
        while (true) {
            aBufferedInputStream.read(tTemp, i, 1);
            if (tTemp[i] == '\r')
                continue;
            if (tTemp[i] == '\n')
                break;
            i++;
        }
        
        return new String(tTemp, 0, i, "UTF-8");
    }

    /**
     * ���������ж�ȡָ�����ȵ��ַ�
     * @param aBufferedInputStream
     * @return ��ȡ���ַ�
     * @throws IOException 
     */
    private String read(BufferedInputStream aBufferedInputStream, int aLen) throws IOException {
        byte[] tTemp = new byte[aLen];
        int tReadedSize = 0;
        
        while (true) {
            int tLen = aBufferedInputStream.read(tTemp, tReadedSize, aLen - tReadedSize);
            if (tLen == -1)
                break;
            
            tReadedSize = tReadedSize + tLen;
            if (tReadedSize == aLen)
                break;
        }
        return new String(tTemp, "UTF-8");
    }

	/**
	 * ������������������(��������Server�������з�������֤)<br>
	 * 
	 * @param aServerURL ������URL
	 * @param aConnTimeOut ���ӳ�ʱʱ�䣨���룩
	 * @param aReadTimeOut ��ȡ��ʱʱ�䣨���룩
	 * @throws PlHttpConnectionException
	 */
	public void createHttpsConnectionWithoutVerify(String aServerURL, String aConnTimeOut, String aReadTimeOut)
			throws PlHttpConnectionException {
		createSSLConnection(aServerURL, Integer.parseInt(aConnTimeOut), Integer.parseInt(aReadTimeOut), null);
	}

	/**
	 * ������������������(��������Server�������з�������֤)
	 * 
	 * @param aServerURL         ������URL
	 * @param aConnTimeOut       ���ӳ�ʱʱ�䣨���룩
	 * @param aClientKey         SSL�ͻ���֤��
	 */
	private void createSSLConnection(String aServerURL, int aConnTimeOut, int aReadTimeOut, KeyManager[] aClientKey) throws PlHttpConnectionException {
		SSLSocketFactory tSSLSocketFactory = null;

		try {
			if (aClientKey == null) {
				tSSLSocketFactory = iDefaultSSLSocketFactory;
			}
			else {
				SSLContext tSSLContext = null;
				if(iProviderType == 1) 
					tSSLContext = SSLContext.getInstance("TLS","IBMJSSE2");
				else
					tSSLContext = SSLContext.getInstance("TLS","SunJSSE");
                
				tSSLContext.init(aClientKey, iTrustManager, null);
				tSSLSocketFactory = tSSLContext.getSocketFactory();
			}
		}
		catch (Exception e) {
			logger.error("", e);
			throw new PlHttpConnectionException("Init SSL env error: - " + e.getLocalizedMessage());
		}
        
        
		//2�����߷�����
		try {
			iServerURL = new URL(aServerURL);
			logger.info("URL = [" + aServerURL + "]");

			int tPort = iServerURL.getDefaultPort();
			if (iServerURL.getPort() != -1)
				tPort = iServerURL.getPort();
            
			logger.info("tPort = [" + tPort + "]");
			
			if (iServerURL.getProtocol().equalsIgnoreCase("https")) {
				InetSocketAddress tServerSocketAddress = new InetSocketAddress(InetAddress.getByName(iServerURL.getHost()), tPort);
				SSLSocket tSSLSocket = (SSLSocket) tSSLSocketFactory.createSocket();
				//tSSLSocket.startHandshake();
				tSSLSocket.connect(tServerSocketAddress, aConnTimeOut);
				iSocket = tSSLSocket;
			}
			else if (iServerURL.getProtocol().equalsIgnoreCase("http")) {
				InetSocketAddress tServerSocketAddress = new InetSocketAddress(InetAddress.getByName(iServerURL.getHost()), tPort);
				iSocket = new Socket();
				iSocket.connect(tServerSocketAddress, aConnTimeOut);
			}
			else {
				throw new PlHttpConnectionException("!!! URL invalid !!!");
			}
			
			iSocket.setSoTimeout(aReadTimeOut);
			iBufferedInputStream = new BufferedInputStream(iSocket.getInputStream());
			iOutputStream = iSocket.getOutputStream();
		}
		catch (Exception e) {
			logger.error("", e);
			throw new PlHttpConnectionException("Connect to server error: - " + e.getLocalizedMessage());
		}
	}

    /**
     * �ر�URL���Ӻ������
     */
    public void closeConnection() {
        if (iOutputStream != null) {
            try {
                iOutputStream.close();
            }
            catch (Exception e) {
            }
            iOutputStream = null;
        }
        
        if (iBufferedInputStream != null) {
            try {
                iBufferedInputStream.close();
            }
            catch (Exception e) {
            }
            iBufferedInputStream = null;
        }
        
        if (iSocket != null) {
            try {
                iSocket.close();
            }
            catch (Exception e) {
            }
            iSocket = null;
        }
    }
    
	private static int getVendorType() {
//		  Properties tSysProperties = System.getProperties();
//		  String tJvmVendor=tSysProperties.getProperty("java.vm.vendor");
		String tJvmVendor=System.getProperty("java.vm.vendor");
		
		logger.debug("Current Jvm Vendor is :[" + tJvmVendor + "]");
        
		if (tJvmVendor.equals(ibmJavaVmVendor)) {
			iProviderType = 1;
		}else {
			iProviderType = 0;
		}
        
		logger.debug("Current Jvm Vendor Type is :[" + iProviderType + "]");
        
		return iProviderType;
	}
    
    /**
     * ����������
     * 
     * ���������ӳ�ʱ�Ͷ���ʱ�������޸���Ӧ�Ĳ���ֵ����SUN JDK 1.4.2�£�����ʱ��������Ч��
     * 
     * @param args
     * @throws Exception
     */
    public static void main( String args[] ) throws Exception {
		try {
			System.setProperty("log4j.configuration", "E:\\1-BJ-Source\\2.Projects\\31.BJP06013\\v1.0\\06.Implementation_Artifact_Set\\6.config\\log4j.properties");
			String tString = "";
			byte[] tData = tString.getBytes();
			SSLConnectionManager tSSLConnectionManager = new SSLConnectionManager();
			String tResp = tSSLConnectionManager.sendData("http://www.163.com/", tData, "100", "1", null);
			System.out.println("Resp = [" + tResp + "]");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        
/*
        try {
            String tString = "MD=Test&ItReq=<CUPSecure></CUPSecure>&TermUrl=http://sss";
            byte[] tData = tString.getBytes();
            SSLConnectionManager tSSLConnectionManager = new SSLConnectionManager();
            tSSLConnectionManager.sendData("http://192.168.0.2:9001/CUPSecureSC/page/help.htm", tData, "10", "30");
            tSSLConnectionManager.sendData("http://192.168.0.2:9009/CUPSecureSC/servlet/TransactionServlet", tData, "10", "30");
            tSSLConnectionManager.sendData("https://192.168.0.2:7002/CUPSecureSC/page/help.htm", tData, "10", "30");
            tSSLConnectionManager.sendData("https://www.hitrustpay.com:9001/index/h_index.jsp", tData, "10", "30");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
*/
        //MPI Testing
        /*
        try {
            String tServerURL = "https://www.3dsecuretestfacility.com:9660/cth/md/HiTRUST_MPI_1.0.2";
            //String tServerURL = "https://www.hitrust.com.cn";
            String tCert = 
            "-----BEGIN CERTIFICATE-----\n" +
            "MIICUzCCAbygAwIBAgIUDc3s+oWCmCt3lsCQK4daLUq8y44wDQYJKoZIhvcNAQEFBQAwRzELMAkGA1" +
            "UEBhMCVVMxEDAOBgNVBAoTB0NhcmFkYXMxFTATBgNVBAsTDENhcmFkYXMgTGFiczEPMA0GA1UEAxMG" +
            "Q1RIIENBMB4XDTA2MDYzMDAyNDAyNVoXDTA4MDYyOTAyNDAyNVowczEQMA4GA1UEChMHaGl0cnVzdD" +
            "ERMA8GA1UECBMIc2hhbmdoYWkxETAPBgNVBAcTCHNoYW5naGFpMQswCQYDVQQGEwJDTjEaMBgGA1UE" +
            "AxMRSGlUUlVTVF9NUElfMS4wLjIxEDAOBgNVBAsTB2hpdHJ1c3QwgZ8wDQYJKoZIhvcNAQEBBQADgY" +
            "0AMIGJAoGBAOKSHqzQGr+FN6Y+9Gh239e80nJ8RAM6jPkybWLLQ2Bj7krUyOelNLD/12CysKOKl7dw" +
            "VNrJU0il5T/9gWgMwFd06TZsTRoEJ0jSw8axECY3jSpDRuZHLGBsd81GEKECAFAXJ9CV/QxnrHe5gB" +
            "l3BbegHW17Je4oLKO9t6vHSU2rAgMBAAGjEDAOMAwGA1UdEwEB/wQCMAAwDQYJKoZIhvcNAQEFBQAD" +
            "gYEApWesQXq1DamDJFUathJ43sOAe6jf8AAgXyqP84LyYq7UPJOYHJLeDnlmA2R1+Lw5uqvUZlGV7x" +
            "s52TNSMMu73JDGW6kGGEh9GwSDY6+y253Xc1ZIHDJPCNHjIlcjTXmK5Tg584S2AjiJPRDsNOMRR3rc" +
            "JqEQFs9qBkALHbQz3e4=\n" +
            "-----END CERTIFICATE-----\n" +
            "-----BEGIN CERTIFICATE-----\n" +
            "MIICLzCCAZigAwIBAgIUDCoCMPC4RFdRjyNgFsUrfBQO9OUwDQYJKoZIhvcNAQEF" +
            "BQAwSTELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0NhcmFkYXMxFTATBgNVBAsTDENh" +
            "cmFkYXMgTGFiczERMA8GA1UEAxMIQ1RIIFJPT1QwHhcNMDUwOTI3MTc0NTQwWhcN" +
            "MDkwOTI2MTc0NTQwWjBHMQswCQYDVQQGEwJVUzEQMA4GA1UEChMHQ2FyYWRhczEV" +
            "MBMGA1UECxMMQ2FyYWRhcyBMYWJzMQ8wDQYDVQQDEwZDVEggQ0EwgZ8wDQYJKoZI" +
            "hvcNAQEBBQADgY0AMIGJAoGBALBOKXF4jod6D/NNKWNKCHB1SMZ/CdxT+p+JXICE" +
            "loIGvrthQXtzs52H7C1xagSXpBXwRT4cwIJgNhz4oSQlGipwwJXDs3JPmiTE39t2" +
            "9vOgPJ7NHIdUNqVyR/ExedOCVt187vLqpUrRcY2xyt+Dcu0uXJAP6xv3QNkf2m2A" +
            "oAPXAgMBAAGjFjAUMBIGA1UdEwEB/wQIMAYBAf8CAQAwDQYJKoZIhvcNAQEFBQAD" +
            "gYEAAN+yrscL1NQp04TTDRESIEnaQrpd2GJSMUiwWkEt7JEzySiQkXWWkbG+urlL" +
            "Zhp98mLM53W7FwR36fUxIeGO9xhxz76AVZjq+UyptZNhmI3uAFP1nMw+CbWQhG41" +
            "DmXmHBr79NWBvydRH4KwjeP7fpVBpfmA1L9CtyNSJj/eCNE=\n" +
            "-----END CERTIFICATE-----\n";
               
            String tPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOKSHqzQGr+FN6Y+9Gh239e80nJ8RAM6jPkybWLLQ2Bj7krUyOelNLD/12CysKOKl7dwVNrJU0il5T/9gWgMwFd06TZsTRoEJ0jSw8axECY3jSpDRuZHLGBsd81GEKECAFAXJ9CV/QxnrHe5gBl3BbegHW17Je4oLKO9t6vHSU2rAgMBAAECgYBPDRBq10kd3YsnE/wOnrtG+HisvTK1ta4OHEwSFj1x2iwAK/HU8M1LnFg3QuFiji6VMDpLA8dtJ4SvKPIHrbtFoDwiL7lxAmxGyuDlg6waki8bYOxpzz4khCdBnhqVs7iRlZ4x1zMm5Ly+9xop6pe9RsMlE0Jn6Pc+2etJTn/A0QJBAPjzO7yK8C9JezHOxzmrvcoJajYwbmnwWgwy+KxOldKoLxPGOT414RPXa5mD88eEozhcyMmU6BHNn6IObE7UqecCQQDo/KWrFTRhHHw+6K2kYXMVNPXEf1dJ5mzyiBL9cR+lrer7GVFr60kQe6/aHIN/Kkra+TpgBepw7l4KfEW+FK2dAkEAiIyJyIoA4j8Q1qoPtr9P04DEhEKeXXdbPPO8WG6mWSys3dDNVyUgdsyjFUo+LcK/8EtcSs1lWVaK5823dKnLIwJAB1dWnQJpCRpNq+nG9uP/LU7i45Mjm/d/vVCeUJAM8Dp/qfPNRfo+7h8HlnbJies6OpYZycbF8VMBcZEi3W9nXQJAWgQC6DPjTGfkqmACSl2emoaLcofAseAJQrIRxDltTL0qji2qKdcb2v3639xQIU3t1KZOC/fA6TF9YU7dwePrSg==";
            char[] tPassword = { '1', '2', '3', '4', '5', '6' };
            String tString = "MD=Test&CvReqItReq=123&TermUrl=http://192.168.0.1";
            byte[] tData = tString.getBytes();
            HttpPostObj tObj = new HttpPostObj("CvReq", "Test");// ͳһ�ؼ���
            ArrayList tList = new ArrayList();
            tList.add(tObj);

            SSLConnectionManager tSSLConnectionManager = new SSLConnectionManager();
            tSSLConnectionManager.createHttpsConnectionWithBothVerify(tServerURL, "30", "30", 1, tPassword, tPrivateKey, tCert, null);
            //System.out.println(tSSLConnectionManager.sendData(tList));
            tSSLConnectionManager.closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
    }
}
