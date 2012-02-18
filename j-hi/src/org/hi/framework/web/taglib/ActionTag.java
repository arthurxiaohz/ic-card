package org.hi.framework.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.hi.common.util.DesUtils;
import org.hi.framework.HiConfigHolder;

public class ActionTag extends BodyTagSupport {
	private String encrypt="true";
	private String formName;
	private String resultType;
	private String resultValue;
	private String clazz;
	private String method;
	
	public int doEndTag() throws JspException {
		boolean _encrypt = true;
		
		if(encrypt != null && encrypt.equals("false")) //如果加密
			_encrypt = false;

		if(!HiConfigHolder.getPublished() || !HiConfigHolder.getUrlEncrypt()){ //如果不是发布模式或不做加密
			_encrypt = false;
		}
		
		String context = null;
		
		String _resultType = resultType==null || resultType.equals("") ? "" : "&resultType=" + resultType;
		String _actionMethod = method == null || method.equals("") ? "" : "&actionMethod=" + method;
		context = "actionName=" + clazz + "&resultValue=" + resultValue + _resultType + _actionMethod;
		if(_encrypt)	//如果要求加密
			context = encrypt(context);
		if(formName == null){
			
			context = HiConfigHolder.getMVCActionName() + "?" + context;
		}
		else{
			context = "commonAction('"+formName+"','"+HiConfigHolder.getMVCActionName() + "?" + context+"')";
		}
		

		return writerBody(context);

	}
	
	private String encrypt(String context)throws JspException{
		try{
			DesUtils des = new DesUtils();
			return des.encrypt(context);
		}
		catch (Exception e) {
			throw new JspException(e);
		}
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

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
