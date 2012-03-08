package cn.net.iccard.tx.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import cn.net.iccard.special.action.PrepaidRequestAction;


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
		System.out.println("--------PhoneServlet----doGet-----start-------------");
		response.setContentType("text/xml; charset=GBK");// 设置字符编码和头部信息
		response.setHeader("Cache-Control", "no-cache");
		
		// 主键id
		String id = request.getParameter("tblTxPayMentOrderid");
		String phoneNo = request.getParameter("phoneNo");
		System.out.println(id);
		
		PrepaidRequestAction prepaidRequestAction = new PrepaidRequestAction();
		try {
			prepaidRequestAction.saveSms(id, phoneNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		// 设置要返回的字符串
//		PrintWriter out = response.getWriter();
//		out.println("<response>");
//		out.println("<passed>" + passed + "</passed>");
//		out.println("<message>" + message + "</message>");
//		out.println("</response>");
//		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
