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
 *  ����û���
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
		response.setContentType("text/xml; charset=utf-8");// �����ַ������ͷ����Ϣ
		response.setHeader("Cache-Control", "no-cache");
		// ��������
		String operatorId = request.getParameter("operatorId");
		
		
		String passed = "";
		
//		Map resMap = resVO.getMap();
//		String passed = (String) resMap.get("flag");
		
		String message ="���û�������ʹ��";
		if(passed.equals("true")){
			message ="���û����Ѵ��ڣ�����������";
		}
		// ����Ҫ���ص��ַ���
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
