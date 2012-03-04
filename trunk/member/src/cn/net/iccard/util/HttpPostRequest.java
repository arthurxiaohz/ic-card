package cn.net.iccard.util;



import java.io.Serializable;

import org.apache.commons.httpclient.HttpMethod;


public class HttpPostRequest implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 6893487641794366406L;
	
	/**
	 * HttpMethod: GetMethod, PostMethod, HeadMethod etc.
	 */
	private HttpMethod httpMethod;
	
	private String fullUrl;
	

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	
}
