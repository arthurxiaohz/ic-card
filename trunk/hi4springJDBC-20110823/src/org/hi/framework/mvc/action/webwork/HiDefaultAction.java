/*     */ package org.hi.framework.mvc.action.webwork;
/*     */ 
/*     */ import com.opensymphony.xwork.ActionContext;
/*     */ import com.opensymphony.xwork.util.OgnlContextState;
/*     */ import com.opensymphony.xwork.util.OgnlValueStack;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.webwork.BaseAction;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class HiDefaultAction extends BaseAction
/*     */ {
/*     */   private String actionName;
/*     */   private String actionMethod;
/*  20 */   private String resultType = "dispatcher";
/*     */   private String resultValue;
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  25 */     BaseAction action = null;
/*  26 */     String type = "success";
/*     */     try {
/*  28 */       Class clazz = Class.forName(this.actionName);
/*  29 */       action = (BaseAction)clazz.newInstance();
/*     */     } catch (Exception e) {
/*  31 */       throw new BusinessException(I18NUtil.getStringByParameter("Action加载失败", this.actionName));
/*     */     }
/*  33 */     if (action != null) {
/*  34 */       ActionContext ac = ActionContext.getContext();
/*  35 */       Map parameters = ac.getParameters();
/*  36 */       if (parameters != null) {
/*  37 */         Map contextMap = ac.getContextMap();
/*     */         try {
/*  39 */           OgnlContextState.setCreatingNullObjects(contextMap, true);
/*  40 */           OgnlContextState.setDenyMethodExecution(contextMap, true);
/*  41 */           OgnlContextState.setReportingConversionErrors(contextMap, true);
/*     */ 
/*  43 */           OgnlValueStack stack = ac.getValueStack();
/*  44 */           stack.push(action);
/*  45 */           setParameters(action, stack, parameters);
/*     */         } finally {
/*  47 */           OgnlContextState.setCreatingNullObjects(contextMap, false);
/*  48 */           OgnlContextState.setDenyMethodExecution(contextMap, false);
/*  49 */           OgnlContextState.setReportingConversionErrors(contextMap, false);
/*     */         }
/*     */ 
/*  52 */         if (this.actionMethod == null) {
/*  53 */           type = action.execute();
/*     */         } else {
/*  55 */           Method method = action.getClass().getMethod(this.actionMethod, new Class[0]);
/*  56 */           type = (String)method.invoke(action, new Object[0]);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  61 */     return type;
/*     */   }
/*     */   protected void setParameters(Object action, OgnlValueStack stack, Map parameters) {
/*  64 */     for (Iterator iterator = new TreeMap(parameters).entrySet().iterator(); iterator.hasNext(); ) {
/*  65 */       Map.Entry entry = (Map.Entry)iterator.next();
/*  66 */       String name = entry.getKey().toString();
/*     */ 
/*  68 */       Object value = entry.getValue();
/*     */       try {
/*  70 */         stack.setValue(name, value);
/*     */       } catch (Exception e) {
/*  72 */         throw new BusinessException(I18NUtil.getStringByParameter("Action对象赋值时出错", name));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getActionName()
/*     */   {
/*  81 */     return this.actionName;
/*     */   }
/*     */ 
/*     */   public void setActionName(String actionName)
/*     */   {
/*  88 */     this.actionName = actionName;
/*     */   }
/*     */ 
/*     */   public String getActionMethod()
/*     */   {
/*  95 */     return this.actionMethod;
/*     */   }
/*     */ 
/*     */   public void setActionMethod(String actionMethod)
/*     */   {
/* 102 */     this.actionMethod = actionMethod;
/*     */   }
/*     */ 
/*     */   public String getResultType()
/*     */   {
/* 109 */     return this.resultType;
/*     */   }
/*     */ 
/*     */   public void setResultType(String resultType)
/*     */   {
/* 116 */     this.resultType = resultType;
/*     */   }
/*     */ 
/*     */   public String getResultValue()
/*     */   {
/* 123 */     return this.resultValue;
/*     */   }
/*     */ 
/*     */   public void setResultValue(String resultValue)
/*     */   {
/* 130 */     this.resultValue = resultValue;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.mvc.action.webwork.HiDefaultAction
 * JD-Core Version:    0.6.0
 */