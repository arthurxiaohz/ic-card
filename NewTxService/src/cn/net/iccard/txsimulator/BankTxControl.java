package cn.net.iccard.txsimulator;


import java.io.IOException;
import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.FactoryConfigurationError;




/**
 * 
 */
public class BankTxControl extends HttpServlet {
	
	// ================================================================================================================================
	// ����ĳ������������û�ҳ���ض���
	// Htmlͷ
	public static final String sHTMLS = "<html><head></head><body OnLoad=\"OnLoadEvent();\" >";
	// ��һ��Form������������ҳ���������ʾ��Ϣ
	public static final String sFORM1S = "<form name='processing' >";
	public static final String sFORM1E = "</form>";
	// �ڶ���Form���ύ��������
	// //Formͷ
	public static final String sFORM2S1 = "<form name=\"downloadForm\" action=\"";
	public static final String sFORM2S2 = "\" method=\"POST\">";
	// //������
	public static final String sINPUT1 = "  <input type=\"hidden\" name=\"";
	public static final String sINPUT2 = "\" value=\"";
	public static final String sINPUT3 = "\">";
	// //Formβ
	public static final String sFORM2E = "</form>";
	// JavaScript�ű�
	public static final String sSCRIPT = "<SCRIPT LANGUAGE=\"Javascript\"> function OnLoadEvent(){ document.downloadForm.submit(); } </SCRIPT>";
	// Htmlβ
	public static final String sHTMLE = "</body></html>";
	
    /**
     * ִ�н���������
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       //  ȡ�ý��״������
        System.out.println("get transaction process object......");
        System.out.println("total_fee=[" + req.getParameter("total_fee") + "]");
      
        req.setAttribute("total_fee", req.getParameter("total_fee"));
        req.setAttribute("out_trade_no", req.getParameter("out_trade_no"));
        req.setAttribute("NotifyURL", req.getParameter("notify_url"));
        req.setAttribute("orderId", req.getParameter("orderId"));
        
		
     // 3.ҳ����ת
		String url = "tx/BT11.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, res);
		
    }
    
    /**
	 * ���û�ҳ���ض����̻����ս��׽����ַ
	 * 
	 * @param res
	 * @param url
	 *            �ض����URL
	 * @param params
	 *            �ض�������Ҫ�Ĳ���
	 * 
	 * @throws IOException
	 */
	public static void redirect(HttpServletResponse res, String url, String form)
			throws IOException {

		res.setContentType("UTF-8");
		ServletOutputStream out = res.getOutputStream();

		StringBuffer resBuff = new StringBuffer();

		// Htmlͷ
		resBuff.append(sHTMLS);

		// Form����
		resBuff.append(sFORM1S).append(sFORM1E).append(sFORM2S1).append(url)
				.append(sFORM2S2).append(form);

		// JavaScript
		resBuff.append(sFORM2E).append(sSCRIPT).append(sHTMLE);

		out.write(resBuff.toString().getBytes("UTF-8"));
		out.flush();
		out.close();

	}

    /**
     * ִ�н���������
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	this.doPost(req, res);
    }

}
