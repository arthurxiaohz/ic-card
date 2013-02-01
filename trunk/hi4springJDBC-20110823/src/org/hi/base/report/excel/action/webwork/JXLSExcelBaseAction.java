/*     */ package org.hi.base.report.excel.action.webwork;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import net.sf.jxls.transformer.XLSTransformer;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*     */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public abstract class JXLSExcelBaseAction extends ReportBaseAction
/*     */ {
/*     */   public static final String DEFAULT_CONTENT_TYPE = "application/vnd.ms-excel";
/*  37 */   private XLSTransformer transFormer = new XLSTransformer();
/*     */   private String filename;
/*     */   private String templetFile;
/*     */   private String contenttype;
/*     */   private Map<String, Object> model;
/*     */ 
/*     */   public String getContenttype()
/*     */   {
/*  48 */     if (this.contenttype == null)
/*  49 */       this.contenttype = "application/vnd.ms-excel";
/*  50 */     return this.contenttype;
/*     */   }
/*     */ 
/*     */   public String getFilename() {
/*  54 */     return this.filename;
/*     */   }
/*     */ 
/*     */   public Map<String, Object> getModel() {
/*  58 */     return this.model;
/*     */   }
/*     */ 
/*     */   public String getTempletFile() {
/*  62 */     return this.templetFile;
/*     */   }
/*     */ 
/*     */   public XLSTransformer getTransFormer() {
/*  66 */     if (this.transFormer == null)
/*  67 */       this.transFormer = new XLSTransformer();
/*  68 */     return this.transFormer;
/*     */   }
/*     */ 
/*     */   public final String execute() throws Exception
/*     */   {
/*  73 */     String actionName = getClass().getName();
/*  74 */     ExcelReportDesignManager erdMgr = (ExcelReportDesignManager)
/*  75 */       SpringContextHolder.getBean(ExcelReportDesign.class);
/*     */ 
/*  78 */     Filter filter = FilterFactory.getSimpleFilter("actionName", actionName, 
/*  79 */       "=").addCondition("enabled", Integer.valueOf(3200), 
/*  80 */       "=");
/*     */ 
/*  82 */     List erds = erdMgr.getObjects(filter);
/*  83 */     if (erds.size() == 0) {
/*  84 */       throw new BusinessException(I18NUtil.getStringByParameter("未找到Action", "ExcelReportDesign", actionName));
/*     */     }
/*     */ 
/*  87 */     prepare();
/*     */ 
/*  89 */     ExcelReportDesign drd = (ExcelReportDesign)erds.get(0);
/*  90 */     this.model = new HashMap();
/*  91 */     mergedOutputModel(this.model);
/*     */ 
/*  93 */     this.filename = drd.getTemplate().substring(drd.getTemplate().lastIndexOf("/"), drd.getTemplate().length());
/*     */ 
/*  95 */     this.templetFile = (getRequest().getSession().getServletContext().getRealPath("/") + drd.getTemplate());
/*  96 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   void mergedOutputModel(Map<String, Object> model)
/*     */   {
/* 101 */     HttpServletRequest request = getRequest();
/* 102 */     HttpSession session = getSession();
/* 103 */     Object value = null;
/*     */ 
/* 106 */     for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
/* 107 */       String parameterName = (String)en.nextElement();
/*     */ 
/* 109 */       if (request.getParameter(parameterName) != null)
/* 110 */         value = getParameter(parameterName);
/* 111 */       if (request.getParameterValues(parameterName) != null) {
/* 112 */         value = request.getParameterValues(parameterName);
/*     */       }
/* 114 */       if (value != null) {
/* 115 */         model.put(parameterName, value);
/*     */       }
/* 117 */       value = null;
/*     */     }
/*     */ 
/* 121 */     for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
/* 122 */       String attributeName = (String)en.nextElement();
/* 123 */       value = request.getAttribute(attributeName);
/* 124 */       if (value != null) {
/* 125 */         model.put(attributeName, value);
/*     */       }
/*     */     }
/*     */ 
/* 129 */     for (Enumeration en = session.getAttributeNames(); en.hasMoreElements(); ) {
/* 130 */       String attributeName = (String)en.nextElement();
/* 131 */       value = session.getAttribute(attributeName);
/* 132 */       if (value != null) {
/* 133 */         model.put(attributeName, value);
/*     */       }
/*     */     }
/*     */ 
/* 137 */     PropertyDescriptor[] actionProperties = 
/* 138 */       PropertyUtils.getPropertyDescriptors(this);
/* 139 */     for (PropertyDescriptor actionDescriptor : actionProperties) {
/* 140 */       String propertyName = actionDescriptor.getName();
/* 141 */       value = BeanUtil.getPropertyValue(this, propertyName);
/* 142 */       if (value != null)
/* 143 */         model.put(propertyName, value);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.JXLSExcelBaseAction
 * JD-Core Version:    0.6.0
 */