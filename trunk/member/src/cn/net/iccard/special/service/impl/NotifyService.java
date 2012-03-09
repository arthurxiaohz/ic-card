package cn.net.iccard.special.service.impl;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import cn.net.iccard.tx.model.special.ThreadPool;
import cn.net.iccard.util.ConnectionUtil;
import cn.net.iccard.util.NoteMessage;
import cn.net.iccard.util.NotifyBean;
import cn.net.iccard.util.SmsBean;

public class NotifyService {
	
	public static ThreadPoolTaskExecutor threadPool4Monitor;
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
	static{
		threadPool4Monitor = (ThreadPoolTaskExecutor)SpringContextHolder.getBean(ThreadPool.class);
	}
	
	/**
	 * ������Ϣ
	 * 
	 * @param message
	 */
	public static void send(final NotifyBean message) {

		try {
			threadPool4Monitor.execute(new Runnable() {
				public void run() {

					ConnectionUtil.sendReqToMcht(message);
				
				}
			});

		} catch (Exception e) {
			System.out.println("***Exception JmsSender.send() *** ������Ϣ�����쳣: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** ������Ϣ�����쳣: " + te.getMessage());
		}

	}
	
	/**
	 * ������Ϣ
	 * 
	 * @param message
	 */
	public static void send(final SmsBean message) {

		try {
			threadPool4Monitor.execute(new Runnable() {
				public void run() {

					NoteMessage.sendShortMessage(message);
				
				}
			});

		} catch (Exception e) {
			System.out.println("***Exception JmsSender.send() *** ������Ϣ�����쳣: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** ������Ϣ�����쳣: " + te.getMessage());
		}

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
}
