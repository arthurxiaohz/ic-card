package cn.net.iccard.txsimulator;


import java.io.IOException;
import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
public class TxControl extends HttpServlet {
	
	// ================================================================================================================================
	// 下面的常量设置用于用户页面重定向
	// Html头
	public static final String sHTMLS = "<html><head></head><body OnLoad=\"OnLoadEvent();\" >";
	// 第一个Form，将来可以在页面中添加提示信息
	public static final String sFORM1S = "<form name='processing' >";
	public static final String sFORM1E = "</form>";
	// 第二个Form，提交请求数据
	// //Form头
	public static final String sFORM2S1 = "<form name=\"downloadForm\" action=\"";
	public static final String sFORM2S2 = "\" method=\"POST\">";
	// //隐藏域
	public static final String sINPUT1 = "  <input type=\"hidden\" name=\"";
	public static final String sINPUT2 = "\" value=\"";
	public static final String sINPUT3 = "\">";
	// //Form尾
	public static final String sFORM2E = "</form>";
	// JavaScript脚本
	public static final String sSCRIPT = "<SCRIPT LANGUAGE=\"Javascript\"> function OnLoadEvent(){ document.downloadForm.submit(); } </SCRIPT>";
	// Html尾
	public static final String sHTMLE = "</body></html>";
	
    /**
     * 执行交易请求处理
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       //  取得交易处理对象
        System.out.println("get transaction process object......");
        System.out.println("TxType=[" + req.getParameter("TxType") + "]");
        System.out.println("TxTraceNo=[" + req.getParameter("TxTraceNo") + "]");
        System.out.println("TxTypeName=[" + new String(req.getParameter("TxTypeName").getBytes("UTF-8")) + "]");
      
        //组装提交
        StringBuffer tPlain = new StringBuffer(400);
        if(req.getParameter("TxType").equals("TX11")){
        	tPlain.append("MchtTxTraceNo=" +req.getParameter("MchtTxTraceNo")+"|" +
					"TxAmount=" + req.getParameter("TxAmount")+"|" +
					"MerchantNo=" + req.getParameter("MerchantNo")+"|" +
					"TxDate=" + req.getParameter("TxDate")+"|" +
					"TxTime=" + req.getParameter("TxTime")+"|" +
					"TxBody=" + req.getParameter("TxBody")+"|" +
					"ShowUrl="+req.getParameter("ShowUrl")+"|" +
					"UseCoupon="+""+"|" +
					"CouponMsg="+""+"|" +
					"NotifyURL="+req.getParameter("NotifyURL")+"|" +
					"BGNotifyURL="+req.getParameter("BGNotifyURL")+"|" +
					"ExtendInfo="+req.getParameter("ExtendInfo")+"|" +
					"CertID="+"");
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
					"CertID="+"");
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
					"CertID="+"");
        }
        
        String sendMsg = Base64.encode(tPlain.toString().getBytes("UTF-8"));
    	Properties tInputParams = new Properties();
		
		// 取得组织银行报文的银行服务类
		BankComService tBankCom = new BankComService();
		
		tInputParams.setProperty("Version", "V1.0");
	    tInputParams.setProperty("TxType", req.getParameter("TxType"));
	    tInputParams.setProperty("TxInfo",sendMsg);
	    tInputParams.setProperty("Signature","");			//TODO 签名
        // 组成没有name属性,没有ID属性的form表单
        //StringBuffer tFormBuffer = tBankCom.buildForm(req.getParameter("sendurl") , tInputParams);
		
	    StringBuffer s = new StringBuffer("");
	    
	    s.append("  <input type=\"hidden\" name=\"").append("Version").append("\" value=\"").append("V1.0").append("\">");
	    s.append("  <input type=\"hidden\" name=\"").append("TxType").append("\" value=\"").append(req.getParameter("TxType")).append("\">");
	    s.append("  <input type=\"hidden\" name=\"").append("TxInfo").append("\" value=\"").append(sendMsg).append("\">");
	    s.append("  <input type=\"hidden\" name=\"").append("Signature").append("\" value=\"").append("").append("\">");
        System.out.println(s.toString());
        System.out.println( req.getParameter("sendurl"));
        
		//将浏览器导向商户接收交易结果地址
        redirect(res , req.getParameter("sendurl") , s.toString());	
        
    }
    
    /**
	 * 把用户页面重定向到商户接收交易结果地址
	 * 
	 * @param res
	 * @param url
	 *            重定向的URL
	 * @param params
	 *            重定向所需要的参数
	 * 
	 * @throws IOException
	 */
	public static void redirect(HttpServletResponse res, String url, String form)
			throws IOException {

		res.setContentType("UTF-8");
		ServletOutputStream out = res.getOutputStream();

		StringBuffer resBuff = new StringBuffer();

		// Html头
		resBuff.append(sHTMLS);

		// Form定义
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
     * 执行交易请求处理
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	this.doPost(req, res);
    }

}
