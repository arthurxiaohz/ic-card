package cn.net.iccard.special.servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import cn.net.iccard.special.action.PrepaidRequestAction;
import cn.net.iccard.special.action.RechargeRequestAction;
import cn.net.iccard.special.service.impl.RechargeService;


/**
 *  接收alipay后台通知
 * 
 * 
 */
public class AlipayNotifyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3040647823052494949L;
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------AlipayNotifyServlet----doGet-----start-------------");
		
		
		// 主键id
		String id = request.getParameter("tblTxPayMentOrderid");
		String phoneNo = request.getParameter("phoneNo");
		System.out.println(id);
		
		RechargeService rechargeResponseService = new RechargeService();
		try {
			rechargeResponseService.saveRechargeResponse (request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 RequestDispatcher rd =request.getRequestDispatcher("chargeSuccess.jsp");
	    rd.forward(request, response);
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
