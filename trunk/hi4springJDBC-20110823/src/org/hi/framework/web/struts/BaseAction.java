/*     */ package org.hi.framework.web.struts;
/*     */ 
/*     */ import com.opensymphony.xwork2.ActionContext;
/*     */ import com.opensymphony.xwork2.ActionInvocation;
/*     */ import com.opensymphony.xwork2.ActionProxy;
/*     */ import com.opensymphony.xwork2.ActionSupport;
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
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.web.Action;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.taglib.component.bean.Token;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public abstract class BaseAction extends ActionSupport
/*     */   implements Action
/*     */ {
/*     */   private String lookup;
/*     */   private String workflow;
/*     */   private Object errorObject;
/*     */   protected static final String DOWNLOAD = "download";
/*     */   protected static final String AUTO = "auto";
/*  43 */   private String ftpip = "127.0.0.1";
/*  44 */   private String ftpUser = "xiao";
/*  45 */   private String ftpPassword = "xiao";
/*  46 */   private String ftpRoot = "";
/*     */   private ActionProxy proxy;
/* 221 */   private int statusCode = 200;
/*     */   private String tipsMessage;
/*     */   private String forwardUrl;
/*     */   private String ajax;
/*     */ 
/*     */   public ActionProxy getProxy()
/*     */   {
/*  50 */     if (this.proxy == null)
/*  51 */       this.proxy = ActionContext.getContext().getActionInvocation().getProxy();
/*  52 */     return this.proxy;
/*     */   }
/*     */ 
/*     */   public String getLookup() {
/*  56 */     return this.lookup;
/*     */   }
/*     */ 
/*     */   public void setLookup(String lookup) {
/*  60 */     this.lookup = lookup;
/*     */   }
/*     */ 
/*     */   public HttpServletRequest getRequest() {
/*  64 */     return ServletActionContext.getRequest();
/*     */   }
/*     */ 
/*     */   public HttpServletResponse getResponse() {
/*  68 */     return ServletActionContext.getResponse();
/*     */   }
/*     */ 
/*     */   public HttpSession getSession()
/*     */   {
/*  73 */     return ServletActionContext.getRequest().getSession(true);
/*     */   }
/*     */ 
/*     */   public String getParameter(String name) {
/*  77 */     return getRequest().getParameter(name);
/*     */   }
/*     */ 
/*     */   public Object getErrorObject() {
/*  81 */     return this.errorObject;
/*     */   }
/*     */ 
/*     */   public void setErrorObject(Object errorObject) {
/*  85 */     this.errorObject = errorObject;
/*     */   }
/*     */ 
/*     */   protected Date getDateFromStr(String sendTime_str)
/*     */   {
/*  93 */     Date returnDate = null;
/*  94 */     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*  95 */     if ((sendTime_str == null) || (sendTime_str.equals("")))
/*     */     {
/*  97 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 101 */       returnDate = df.parse(sendTime_str);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 105 */       returnDate = null;
/*     */     }
/*     */ 
/* 108 */     return returnDate;
/*     */   }
/*     */ 
/*     */   public String saveFile(File file, String fileName, String moduleName)
/*     */     throws IOException
/*     */   {
/* 114 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/* 115 */     String prefix = ServletActionContext.getServletContext().getRealPath("/");
/* 116 */     String dateString = new Long(new Date().getTime()).toString();
/* 117 */     String fileNameExt = fileName.substring(fileName.lastIndexOf("."));
/* 118 */     fileName = dateString + fileNameExt;
/*     */ 
/* 121 */     String filePath = HiConfigHolder.getRootUpload() + "/" + 
/* 122 */       moduleName + "/" + formatter.format(new Date()) + 
/* 123 */       "/" + fileName;
/* 124 */     File dest = new File(prefix + "/" + filePath);
/*     */ 
/* 126 */     FileUtils.copyFile(file, dest);
/*     */ 
/* 128 */     return filePath;
/*     */   }
/*     */ 
/*     */   public String perExecute(Object obj)
/*     */     throws Exception
/*     */   {
/* 172 */     if (getErrorObject() != null) {
/* 173 */       throw new BusinessException(I18NUtil.getString("该页面中的数据已经被改写，请重新刷新页面后重新编辑该记录"));
/*     */     }
/* 175 */     Token token = null;
/* 176 */     if (getSession().getAttribute("session.token") == null) {
/* 177 */       token = new Token();
/* 178 */       getSession().setAttribute("session.token", token);
/*     */     }
/*     */     else {
/* 181 */       token = (Token)getSession().getAttribute("session.token");
/*     */     }
/* 183 */     boolean hasToken = token.isTokenStringValid(getRequest().getParameter("token"));
/*     */ 
/* 185 */     return hasToken ? null : getRequest().getParameter("token");
/*     */   }
/*     */ 
/*     */   public String postExecute(Object obj) throws Exception {
/* 189 */     return null;
/*     */   }
/*     */ 
/*     */   public String getWorkflow() {
/* 193 */     return this.workflow;
/*     */   }
/*     */ 
/*     */   public void setWorkflow(String workflow) {
/* 197 */     this.workflow = workflow;
/*     */   }
/*     */ 
/*     */   protected String returnCommand()
/*     */   {
/* 203 */     return returnCommand(null);
/*     */   }
/*     */   protected String returnCommand(String message) {
/* 206 */     String viewMode = HiConfigHolder.getViewMode();
/*     */ 
/* 208 */     if (viewMode.equals("dwz")) {
/* 209 */       if (((this.ajax == null) || (!this.ajax.trim().equals("1"))) && (message == null))
/* 210 */         return "success";
/* 211 */       if (message == null) {
/* 212 */         return ajaxForwardSuccess(I18NUtil.getString("操作成功"));
/*     */       }
/* 214 */       return ajaxForwardError(message);
/*     */     }
/*     */ 
/* 217 */     return "success";
/*     */   }
/*     */ 
/*     */   public void setAjax(String ajax)
/*     */   {
/* 229 */     this.ajax = ajax;
/*     */   }
/*     */ 
/*     */   public int getStatusCode() {
/* 233 */     return this.statusCode;
/*     */   }
/*     */ 
/*     */   public void setStatusCode(int statusCode) {
/* 237 */     this.statusCode = statusCode;
/*     */   }
/*     */ 
/*     */   public String getTipsMessage() {
/* 241 */     return this.tipsMessage;
/*     */   }
/*     */ 
/*     */   public void setTipsMessage(String tipsMessage) {
/* 245 */     this.tipsMessage = tipsMessage;
/*     */   }
/*     */ 
/*     */   public String getForwardUrl() {
/* 249 */     return this.forwardUrl;
/*     */   }
/*     */ 
/*     */   public void setForwardUrl(String forwardUrl) {
/* 253 */     this.forwardUrl = forwardUrl;
/*     */   }
/*     */   public String getTargetType() {
/* 256 */     if ((this.lookup != null) && (this.lookup.length() > 0)) {
/* 257 */       return "dialog";
/*     */     }
/* 259 */     return "navTab";
/*     */   }
/*     */ 
/*     */   private String ajaxForward(int statusCode, String message) {
/* 263 */     this.statusCode = statusCode;
/* 264 */     this.tipsMessage = message;
/* 265 */     return "ajaxDone";
/*     */   }
/*     */   protected String ajaxForwardSuccess(String message) {
/* 268 */     return ajaxForward(200, message);
/*     */   }
/*     */   protected String ajaxForwardError(String message) {
/* 271 */     return ajaxForward(300, message);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.struts.BaseAction
 * JD-Core Version:    0.6.0
 */