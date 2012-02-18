package org.hi.framework.web.struts;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;


public class ExcelResult implements Result {

	private XLSTransformer transFormer;

	private String filename;
	
	private String templetFile;

	private String contenttype;
	
	private Map<String, Object> model;

	@SuppressWarnings("unchecked")
	public void execute(ActionInvocation invocation) throws Exception {
		if (contenttype == null)
			contenttype = "application/vnd.ms-excel";
		if (transFormer == null)
			transFormer = (XLSTransformer) invocation.getStack().findValue(
					"transFormer");
		if(filename==null) 
			filename = (String)invocation.getStack().findValue("filename");
		if(templetFile==null)
			templetFile = (String)invocation.getStack().findValue("templetFile");
		if(model==null)
			model = (Map<String, Object>)invocation.getStack().findValue("model");

		//设置response
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(contenttype);
		response.setHeader("Content-Disposition", "attachment;Filename="
				+ filename);
		OutputStream os = response.getOutputStream();
		//设置模版的输出流
		OutputStream out = response.getOutputStream();
		InputStream is = new BufferedInputStream(new FileInputStream(templetFile));
		//得到jxls
		HSSFWorkbook workBook = transFormer.transformXLS(is, model);
		workBook.write(out);
		//善后
		is.close();
		out.flush();
		out.close();
		os.flush();
		os.close();
	}

	public void setTransFormer(XLSTransformer transFormer) {
		this.transFormer = transFormer;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public void setTempletFile(String templetFile){
		this.templetFile = templetFile;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

}
