package cn.net.iccard.tx.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 *  检查用户名
 * 
 * 
 */
public class PhoneServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3040647823052494949L;
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------CheckNameServlet----doGet-----start-------------");
		response.setContentType("text/xml; charset=utf-8");// 设置字符编码和头部信息
		response.setHeader("Cache-Control", "no-cache");
		// 机构类型
		String operatorId = request.getParameter("operatorId");
		
		
		String passed = "";
		
//		Map resMap = resVO.getMap();
//		String passed = (String) resMap.get("flag");
		
		String message ="该用户名可以使用";
		if(passed.equals("true")){
			message ="该用户名已存在，请重新输入";
		}
		// 设置要返回的字符串
		PrintWriter out = response.getWriter();
		out.println("<response>");
		out.println("<passed>" + passed + "</passed>");
		out.println("<message>" + message + "</message>");
		out.println("</response>");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
