package org.hi.framework.web.taglib.i18n;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;
import org.hi.i18n.util.I18NUtil;

import com.opensymphony.util.TextUtils;
import com.opensymphony.webwork.views.jsp.PropertyTag;

/**
 * property支持多语言的标签
 * @author xiao
 *
 */
public class MLText extends PropertyTag {
	
	 private String value;
	 
	 LanguageCodeManager languageCodeMgr= (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
	 
	 public int doStartTag()throws JspException
	 {
		 List<LanguageCode> allLanguageCodes = languageCodeMgr.getObjects();
		 
		 this.component = getBean(getStack(), (HttpServletRequest)this.pageContext.getRequest(), (HttpServletResponse)this.pageContext.getResponse());
		 populateParams();
		 String textValue  = this.component.getStack().findValue(value, String.class).toString();
		 String returnHTML = "<input type=\"text\" class=\"EditTableDataText\" id=\"" + value +"\" name=\""+ value +"\" value=\""+TextUtils.htmlEncode(textValue) +"\">";
		 String languageCode = I18NUtil.getUserLanguageCode();
		 
		 if(allLanguageCodes != null && allLanguageCodes.size() > 0 )
		 {
			 StringBuffer sb=new StringBuffer(); // 首先增加显示的文本框 和图片 并给图片增加事件
			 sb.append(  "<input type=\"text\"  id=\"" + value+".mlstring."+ languageCode+".display\" value=\"" + I18NUtil.getStringByLanguage(textValue, languageCode) +"\"  onchange=\"setMlStringByLangCode(this,'"+ value+"','"+ languageCode +"')\"  >" );
			 sb.append(  "<a href=\"#\"> <image src=\"images/mls.png\"  border=0; onclick=\"showMlStringForm('timezone.description');\" /></a>" );
			 sb.append("<br>");
			 sb.append("<div class=\"SuggestList\" id=\"" + value+".form\">");
			 sb.append("<div class=\"SuggestMain\" >");
			 sb.append("<ul>");
			 sb.append("<table class=\"mlform_table\" >");
			 sb.append("<input type=\"hidden\" name=\""+ value + "\" value=\""+ textValue +"\" />" );  
			 
			 // 根据语言编码显示文本框
			 for (LanguageCode languageCodeBean : allLanguageCodes) {
				 sb.append("<tr><td>");
				 sb.append(languageCodeBean.getDescription()+":");
				 sb.append("</td>");
				 sb.append("<td><input type=\"text\" id=\""+ value+".mlstring."+ languageCodeBean.getLanguageCode() +"\" name=\""+ value +".mlstring\" value=\""+ I18NUtil.getStringByLanguage(textValue, languageCodeBean.getLanguageCode()) +"\" /></td>");
				 sb.append("</tr>");
			}
			 // 显示按钮
			 sb.append("<tr>");
			 sb.append("<td>	<input type=\"button\" value=\"OK\" onclick=\"setMlString('"+value+"')\"/></td>");
			 sb.append("<td>	<input type=\"button\" value=\"Cancel\" onclick=\"hideMlStringForm('"+value+"')\"/></td>");
			 sb.append("</tr>");
				
			 sb.append("</table>");
			 sb.append("</ul>");
			 sb.append("</div>" );
			 sb.append("</div>");
			 
			 returnHTML =  sb.toString();
		 }
		 
		 
		 try {
			pageContext.getOut().print( returnHTML);
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
	