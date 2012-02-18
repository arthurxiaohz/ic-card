package org.hi.framework.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.hi.common.util.DesUtils;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;

public class URLTag extends BodyTagSupport {
	private String encrypt="true";
	
	public int doEndTag() throws JspException {
		
		BodyContent bodyContent = getBodyContent();
		String url = bodyContent.getString();
		
		if(encrypt != null && encrypt.equals("false")) //如果不让该url加密
			return writerBody(url);

		if(!HiConfigHolder.getPublished() || !HiConfigHolder.getUrlEncrypt()){ //如果不是发布模式或不做加密
			return writerBody(url);
		}
		
		if (!StringUtils.isIncludes(url, "?"))
			return writerBody(url);
		
		String[] divs = url.split("[?]");
		String div1;
		try{
			DesUtils des = new DesUtils();
			div1 = des.encrypt(divs[1]); //加密处理
		}
		catch(Exception e){
			throw new JspException(e);
		}
		
		String newUrl = divs[0]+"?"+div1;
		bodyContent.clearBody();

		return writerBody(newUrl);

	}
	
	private int writerBody(String bodyStr) throws JspException{
		JspWriter jspOut = pageContext.getOut();
		try {
			jspOut.print(bodyStr);
		} catch (IOException e) {
			throw new JspException(e);
		}
		return super.doEndTag();
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}
	
	
}
