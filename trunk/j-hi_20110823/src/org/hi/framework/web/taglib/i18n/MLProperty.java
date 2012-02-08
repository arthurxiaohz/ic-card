package org.hi.framework.web.taglib.i18n;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.i18n.util.I18NUtil;

import com.opensymphony.util.TextUtils;
import com.opensymphony.webwork.views.jsp.PropertyTag;

/**
 * property支持多语言的标签
 * @author xiao
 *
 */
public class MLProperty extends PropertyTag {
	
	 private String value;
	 
	 
	 public int doStartTag()throws JspException
	 {
		 this.component = getBean(getStack(), (HttpServletRequest)this.pageContext.getRequest(), (HttpServletResponse)this.pageContext.getResponse());
		   populateParams();
		 String returnStr  = this.component.getStack().findValue(value, String.class).toString();
		String languageCode = I18NUtil.getUserLanguageCode();
		 try {
			pageContext.getOut().print(TextUtils.htmlEncode(  I18NUtil.getStringByLanguage(returnStr, languageCode)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     return 6;
	 }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		super.setValue(value);
		this.value = value;
	}
	 
	 public static void main (String[] args)
	 {
		 String  abc  = "<ml><value>fssasdfsadf</value><languageCode>zh_cn</languageCode></ml><ml><value>asdf</value><languageCode>en_us</languageCode></ml>   ";
		 List<MLBean> result = new ArrayList<MLBean>();
			List<String> subValues = StringUtils.subStringList(abc, "<ml>", "</ml>");
			for (String subValue : subValues) {
				String subXML = "<ml>"+subValue+"</ml>";
				try {
					Object obj = BeanUtil.getXML2Bean(subXML, MLBean.class);
					result.add((MLBean)obj);
					
					System.out.println(((MLBean)obj).getVl());
					System.out.println(((MLBean)obj).getLg());
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			
		} 
 
	 
}
	