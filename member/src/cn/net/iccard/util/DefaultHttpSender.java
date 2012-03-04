package cn.net.iccard.util;



import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.Timestamp;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class DefaultHttpSender {
	/**
	 * ��ȡ�̻��ķ������ȴ�ʱ��.
	 * ����������ʱ�䣬���ӽ��Ͽ�.
	 */
	private int maxReadWaitTime = 20000;
	
	/**
	 * ������ӵȴ�ʱ��.
	 * ��������ʱ���ڲ������ӵ��̻���web�������������ٳ�������.
	 */
	private int connectTimeout = 20000;
	
	/**
	 * �����ύhttp����.
	 */
	private HttpClient client;
	
	/**
	 * �ڹ��캯���г�ʼ��HttpClientʵ��.
	 */
	public DefaultHttpSender() {
		client = new HttpClient(new MultiThreadedHttpConnectionManager());
		client.getHttpConnectionManager().getParams().setConnectionTimeout(
				getConnectTimeout());
		client.getHttpConnectionManager().getParams().setSoTimeout(
				getMaxReadWaitTime());
		client.getParams().setParameter(
				  HttpMethodParams.RETRY_HANDLER, 
				  new DefaultHttpMethodRetryHandler(0, false));
	}
	
	/**
	 * @return the maxReadWaitTime
	 */
	public int getMaxReadWaitTime() {
		return maxReadWaitTime;
	}

	/**
	 * @param maxReadWaitTime the maxReadWaitTime to set
	 */
	public void setMaxReadWaitTime(int maxReadWaitTime) {
		this.maxReadWaitTime = maxReadWaitTime;
	}

	/**
	 * @return the connectTimeout
	 */
	public int getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * @param connectTimeout the connectTimeout to set
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	
	public boolean postHttpData(HttpPostRequest request) {
		boolean flag = false;
		
		PostMethod method = null;
		InputStream is = null;
		ReadableByteChannel readChannel = null;
		int statusCode = 0;
		String fullUrl = request.getFullUrl();
		
		StringBuffer stlog = new StringBuffer();
		stlog.append("PostHttpData Url: ").append(fullUrl).append("\n");
		try {
			method = (PostMethod) request.getHttpMethod();
			//��Ӧ�������ر�����
			method.setRequestHeader("Connection","close");
			NameValuePair[] nvPair = ((PostMethod)method).getParameters();
			method.setRequestBody(nvPair);

			stlog.append("Post datas: ");
			
			for(int i=0; i<nvPair.length; i++) {
				stlog.append(nvPair[i].getName()).append("=").append(nvPair[i].getValue()).append(";");
			}
			stlog.append("\n");
			
			stlog.append("Posting...\n");
			statusCode = client.executeMethod(method);
			stlog.append("fullUrl=").append(fullUrl).append("; HTTP send:[statusCode=").append(statusCode).append("]");
			
			is = method.getResponseBodyAsStream();
			readChannel = Channels.newChannel(is);
			ByteBuffer buffer = ByteBuffer.allocate(2000);
			readChannel.read(buffer);
			String responseContent = new String(buffer.array(), "utf-8");
			
			
			// ����÷���״̬Ϊ200ʱ�� ��Ϊ�̻����سɹ�����
			if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
				flag = true;
			} else {
				flag = true;
			}
		} catch (Throwable te) {
			stlog.append("Catch Exception: " + te.getMessage());
			
		} finally {
			try {
				if (readChannel != null) {
					try {
						readChannel.close();
					} catch (Throwable te) {
					}
				}
				if (is != null) {
					try {
						is.close();
					} catch (Throwable te) {
					}
				}
				if (method != null) {
					method.releaseConnection();
				}
				client.getHttpConnectionManager().closeIdleConnections(0);
			} catch (Throwable te) {
			}
		}
		
		return flag;
	}
}
