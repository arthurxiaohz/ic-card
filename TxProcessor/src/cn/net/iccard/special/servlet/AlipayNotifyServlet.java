package cn.net.iccard.special.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import cn.net.iccard.special.action.PrepaidRequestAction;
import cn.net.iccard.special.action.RechargeRequestAction;


/**
 *  ����alipay��̨֪ͨ
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
		
		
		// ����id
		String id = request.getParameter("tblTxPayMentOrderid");
		String phoneNo = request.getParameter("phoneNo");
		System.out.println(id);
		
		RechargeRequestAction rechargeRequestAction = new RechargeRequestAction();
		try {
			rechargeRequestAction.saveRecharge(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		// ����Ҫ���ص��ַ���
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
