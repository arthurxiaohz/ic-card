package org.hi.common.tools.highcharts.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.hi.common.tools.highcharts.ChartExecutor;
import org.hi.common.tools.highcharts.ChartProcessor;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.web.taglib.AbstractTag;
import org.hi.framework.web.taglib.component.builder.BuilderTools;

public class ChartTag extends AbstractTag{
	
	private String processor;
	
	public int doEndTag() throws JspException {
		evaluateParams();
		
		ChartProcessor chartProcessor = (ChartProcessor)BeanUtil.CreateObject(processor);
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		JspWriter jspOut = pageContext.getOut();
		StringBuffer outSb = new StringBuffer();
		
		outSb.append("<script type=\"text/javascript\">");
		
		outSb.append("var "+ this.id +";");
		outSb.append("function show"+this.id+"() {");
		
		outSb.append(id).append(" = new Highcharts.Chart(");
		ChartExecutor executor = chartProcessor.getExecutor(request);
		
		outSb.append(executor.toChartJson(this.id));
		outSb.append(");};");
		
		outSb.append("$(function(){	setTimeout(\"show"+this.id+"()\",100);});");
		outSb.append("</script>");
		if(this.getCssStyle() == null){
			 addParameter("style", "width: 800px; height: 400px; margin: 0 auto");
		}
		outSb.append("<div "+BuilderTools.getParameters(this.parameters) + " ></div>");
		try {
			pageContext.getOut().print(outSb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

}
