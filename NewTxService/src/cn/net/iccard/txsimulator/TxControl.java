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

import cn.net.iccard.merchantmpi.SecurityUtil;





/**
 * 
 */
public class TxControl extends HttpServlet {
	
	// ================================================================================================================================
	// ����ĳ������������û�ҳ���ض���
	// Htmlͷ
	public static final String sHTMLS = "<html><head></head><body OnLoad=\"document.downloadForm.submit();\" >";
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
	
	//key 
	public static final String Key = "1234567890";
	
    /**
     * ִ�н���������
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       //  ȡ�ý��״������
        System.out.println("get transaction process object......");
        System.out.println("TxType=[" + req.getParameter("TxType") + "]");
        System.out.println("TxTraceNo=[" + req.getParameter("TxTraceNo") + "]");
        //System.out.println("TxTypeName=[" + new String(req.getParameter("TxTypeName").getBytes("UTF-8")) + "]");
      System.out.println(req.getParameter("TxBody"));
    
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes("iso8859-1")));
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes("iso8859-1"),"UTF-8"));
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes("iso8859-1"),"GBK"));
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes("GBK")));
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes("utf-8")));
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes("utf-8"),"GBK"));  
//      System.out.println("111111"+new String (req.getParameter("TxBody").getBytes(),"UTF-8"));
      
        //��װ�ύ
        StringBuffer tPlain = new StringBuffer(400);		//md5������
        StringBuffer mPlain = new StringBuffer(400);		//����
        
        if(req.getParameter("TxType").equals("TX11")){
        	
        	tPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"TxDate=" + req.getParameter("TxDate")+"|" +
					"TxTime=" + req.getParameter("TxTime")+"|" +
					"TxBody=" + new String (req.getParameter("TxBody").getBytes("iso8859-1"),"UTF-8")+"|" +
					"ShowUrl="+req.getParameter("ShowUrl")+"|" +
					"UseCoupon="+req.getParameter("UseCoupon")+"|" +
					"CouponMsg="+req.getParameter("CouponMsg")+"|" +
					"UnCouponMsg="+req.getParameter("UnCouponMsg")+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo")+"|" +
					"Key="+Key);
        	
        	mPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"TxDate=" + req.getParameter("TxDate")+"|" +
					"TxTime=" + req.getParameter("TxTime")+"|" +
					"TxBody=" + new String (req.getParameter("TxBody").getBytes("iso8859-1"),"UTF-8")+"|" +
					"ShowUrl="+req.getParameter("ShowUrl")+"|" +
					"UseCoupon="+req.getParameter("UseCoupon")+"|" +
					"CouponMsg="+req.getParameter("CouponMsg")+"|" +
					"UnCouponMsg="+req.getParameter("UnCouponMsg")+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo"));
        	
        }else if(req.getParameter("TxType").equals("TX21")){
        	
        	tPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"OrigMchtTxTraceNo=" + req.getParameter("OrigMchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"OrigTxDate=" + req.getParameter("OrigTxDate")+"|" +
					"OrigTxTime=" + req.getParameter("OrigTxTime")+"|" +
					"TxDate="+req.getParameter("TxDate")+"|" +
					"TxTime="+req.getParameter("TxTime")+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo")+"|" +
					"Key="+Key);
        	
        	mPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"OrigMchtTxTraceNo=" + req.getParameter("OrigMchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"OrigTxDate=" + req.getParameter("OrigTxDate")+"|" +
					"OrigTxTime=" + req.getParameter("OrigTxTime")+"|" +
					"TxDate="+req.getParameter("TxDate")+"|" +
					"TxTime="+req.getParameter("TxTime")+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo"));
        	
        }else if(req.getParameter("TxType").equals("TX23")){
        	
        	tPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"OrigMchtTxTraceNo=" + req.getParameter("OrigMchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"OrigTxDate=" + req.getParameter("OrigTxDate")+"|" +
					"OrigTxTime=" + req.getParameter("OrigTxTime")+"|" +
					"TxDate="+req.getParameter("TxDate")+"|" +
					"TxTime="+req.getParameter("TxTime")+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo")+"|" +
					"Key="+Key);
        	
        	mPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"OrigMchtTxTraceNo=" + req.getParameter("OrigMchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"OrigTxDate=" + req.getParameter("OrigTxDate")+"|" +
					"OrigTxTime=" + req.getParameter("OrigTxTime")+"|" +
					"TxDate="+req.getParameter("TxDate")+"|" +
					"TxTime="+req.getParameter("TxTime")+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo"));
        }
        
        String sendMsg = Base64.encode(mPlain.toString().getBytes("UTF-8"));
        String sendMsg1 = Base64.encode(tPlain.toString().getBytes("UTF-8"));
    	//Properties tInputParams = new Properties();
        System.out.println(tPlain.toString());
		// ȡ����֯���б��ĵ����з�����
		
        // ���û��name����,û��ID���Ե�form��
        //StringBuffer tFormBuffer = tBankCom.buildForm(req.getParameter("sendurl") , tInputParams);
		
	   // StringBuffer s = new StringBuffer("");
//        req.setAttribute("", arg1);
//        req.setAttribute("", arg1);
        
        String Signature = SecurityUtil.MD5Encode(sendMsg1.toString());
        req.setAttribute("TxInfo",  sendMsg);
        req.setAttribute("Signature",  Signature);
        req.setAttribute("SERVER_URL", req.getParameter("sendurl"));
        RequestDispatcher rd =req.getRequestDispatcher("tx/Direct"+req.getParameter("TxType")+".jsp");
    	rd.forward(req, res);
//        System.out.println(s.toString());
//        System.out.println( req.getParameter("sendurl"));
        
		//������������̻����ս��׽����ַ
      //  redirect(res , req.getParameter("sendurl") , s.toString());	
        
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
		
		System.out.println(resBuff.toString());
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
