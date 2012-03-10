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
	static{
		threadPool4Monitor = (ThreadPoolTaskExecutor)SpringContextHolder.getBean(ThreadPool.class);
	}
	
	/**
	 * 发送消息
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
			System.out.println("***Exception JmsSender.send() *** 发送消息发生异常: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** 发送消息发生异常: " + te.getMessage());
		}

	}
	
	/**
	 * 发送消息
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
			System.out.println("***Exception JmsSender.send() *** 发送消息发生异常: " + e.getMessage());
		} catch (Throwable te) {
			System.out.println("***Throwable JmsSender.send() *** 发送消息发生异常: " + te.getMessage());
		}

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

		out.write(resBuff.toString().getBytes("UTF-8"));
		out.flush();
		out.close();

	}
}
