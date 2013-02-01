/*     */ package org.hi.framework.web.webwork;
/*     */ 
/*     */ import com.opensymphony.webwork.ServletActionContext;
/*     */ import com.opensymphony.xwork.ActionContext;
/*     */ import com.opensymphony.xwork.ActionInvocation;
/*     */ import com.opensymphony.xwork.ActionProxy;
/*     */ import com.opensymphony.xwork.ActionSupport;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.web.Action;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.taglib.component.bean.Token;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public abstract class BaseAction extends ActionSupport
/*     */   implements Action
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String lookup;
/*     */   private String workflow;
/*     */   private Object errorObject;
/*     */   protected static final String DOWNLOAD = "download";
/*     */   protected static final String AUTO = "auto";
/*  46 */   private String ftpip = "127.0.0.1";
/*  47 */   private String ftpUser = "xiao";
/*  48 */   private String ftpPassword = "xiao";
/*  49 */   private String ftpRoot = "";
/*     */   private ActionProxy proxy;
/* 222 */   private int statusCode = 200;
/*     */   private String tipsMessage;
/*     */   private String forwardUrl;
/*     */   private String ajax;
/*     */ 
/*     */   public ActionProxy getProxy()
/*     */   {
/*  54 */     if (this.proxy == null)
/*  55 */       this.proxy = ActionContext.getContext().getActionInvocation().getProxy();
/*  56 */     return this.proxy;
/*     */   }
/*     */   public String getLookup() {
/*  59 */     return this.lookup;
/*     */   }
/*     */ 
/*     */   public void setLookup(String lookup) {
/*  63 */     this.lookup = lookup;
/*     */   }
/*     */ 
/*     */   public HttpServletRequest getRequest() {
/*  67 */     return ServletActionContext.getRequest();
/*     */   }
/*     */ 
/*     */   public HttpServletResponse getResponse() {
/*  71 */     return ServletActionContext.getResponse();
/*     */   }
/*     */ 
/*     */   public HttpSession getSession()
/*     */   {
/*  76 */     return ServletActionContext.getRequest().getSession(true);
/*     */   }
/*     */ 
/*     */   public String getParameter(String name) {
/*  80 */     return getRequest().getParameter(name);
/*     */   }
/*     */ 
/*     */   public Object getErrorObject() {
/*  84 */     return this.errorObject;
/*     */   }
/*     */ 
/*     */   public void setErrorObject(Object errorObject) {
/*  88 */     this.errorObject = errorObject;
/*     */   }
/*     */ 
/*     */   protected Date getDateFromStr(String sendTime_str)
/*     */   {
/*  96 */     Date returnDate = null;
/*  97 */     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*  98 */     if ((sendTime_str == null) || (sendTime_str.equals("")))
/*     */     {
/* 100 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 104 */       returnDate = df.parse(sendTime_str);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       returnDate = null;
/*     */     }
/*     */ 
/* 111 */     return returnDate;
/*     */   }
/*     */ 
/*     */   public String saveFile(File file, String fileName, String moduleName)
/*     */     throws IOException
/*     */   {
/* 117 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/* 118 */     String prefix = ServletActionContext.getServletContext().getRealPath("/");
/* 119 */     String dateString = new Long(new Date().getTime()).toString();
/* 120 */     String fileNameExt = fileName.substring(fileName.lastIndexOf("."));
/* 121 */     fileName = dateString + fileNameExt;
/*     */ 
/* 124 */     String filePath = HiConfigHolder.getRootUpload() + "/" + 
/* 125 */       moduleName + "/" + formatter.format(new Date()) + 
/* 126 */       "/" + fileName;
/* 127 */     File dest = new File(prefix + "/" + filePath);
/*     */ 
/* 129 */     FileUtils.copyFile(file, dest);
/*     */ 
/* 131 */     return filePath;
/*     */   }
/*     */ 
/*     */   public String perExecute(Object obj)
/*     */     throws Exception
/*     */   {
/* 173 */     if (getErrorObject() != null) {
/* 174 */       throw new BusinessException(I18NUtil.getString("该页面中的数据已经被改写，请重新刷新页面后重新编辑该记录"));
/*     */     }
/* 176 */     Token token = null;
/* 177 */     if (getSession().getAttribute("session.token") == null) {
/* 178 */       token = new Token();
/* 179 */       getSession().setAttribute("session.token", token);
/*     */     }
/*     */     else {
/* 182 */       token = (Token)getSession().getAttribute("session.token");
/*     */     }
/* 184 */     boolean hasToken = token.isTokenStringValid(getRequest().getParameter("token"));
/*     */ 
/* 186 */     return hasToken ? null : getRequest().getParameter("token");
/*     */   }
/*     */ 
/*     */   public String postExecute(Object obj) throws Exception {
/* 190 */     return null;
/*     */   }
/*     */ 
/*     */   public String getWorkflow() {
/* 194 */     return this.workflow;
/*     */   }
/*     */ 
/*     */   public void setWorkflow(String workflow) {
/* 198 */     this.workflow = workflow;
/*     */   }
/*     */ 
/*     */   protected String returnCommand()
/*     */   {
/* 204 */     return returnCommand(null);
/*     */   }
/*     */   protected String returnCommand(String message) {
/* 207 */     String viewMode = HiConfigHolder.getViewMode();
/*     */ 
/* 209 */     if (viewMode.equals("dwz")) {
/* 210 */       if (((this.ajax == null) || (!this.ajax.trim().equals("1"))) && (message == null))
/* 211 */         return "success";
/* 212 */       if (message == null) {
/* 213 */         return ajaxForwardSuccess(I18NUtil.getString("操作成功"));
/*     */       }
/* 215 */       return ajaxForwardError(message);
/*     */     }
/*     */ 
/* 218 */     return "success";
/*     */   }
/*     */ 
/*     */   public void setAjax(String ajax)
/*     */   {
/* 228 */     this.ajax = ajax;
/*     */   }
/*     */ 
/*     */   public int getStatusCode() {
/* 232 */     return this.statusCode;
/*     */   }
/*     */ 
/*     */   public void setStatusCode(int statusCode) {
/* 236 */     this.statusCode = statusCode;
/*     */   }
/*     */ 
/*     */   public String getTipsMessage() {
/* 240 */     return this.tipsMessage;
/*     */   }
/*     */ 
/*     */   public void setTipsMessage(String tipsMessage) {
/* 244 */     this.tipsMessage = tipsMessage;
/*     */   }
/*     */ 
/*     */   public String getForwardUrl() {
/* 248 */     return this.forwardUrl;
/*     */   }
/*     */ 
/*     */   public void setForwardUrl(String forwardUrl) {
/* 252 */     this.forwardUrl = forwardUrl;
/*     */   }
/*     */   public String getTargetType() {
/* 255 */     if ((this.lookup != null) && (this.lookup.length() > 0)) {
/* 256 */       return "dialog";
/*     */     }
/* 258 */     return "navTab";
/*     */   }
/*     */ 
/*     */   private String ajaxForward(int statusCode, String message) {
/* 262 */     this.statusCode = statusCode;
/* 263 */     this.tipsMessage = message;
/* 264 */     return "ajaxDone";
/*     */   }
/*     */   protected String ajaxForwardSuccess(String message) {
/* 267 */     return ajaxForward(200, message);
/*     */   }
/*     */   protected String ajaxForwardError(String message) {
/* 270 */     return ajaxForward(300, message);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.webwork.BaseAction
 * JD-Core Version:    0.6.0
 */