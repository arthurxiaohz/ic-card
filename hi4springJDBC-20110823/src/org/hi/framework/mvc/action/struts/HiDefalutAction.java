/*     */ package org.hi.framework.mvc.action.struts;
/*     */ 
/*     */ import com.opensymphony.xwork2.ActionContext;
/*     */ import com.opensymphony.xwork2.util.OgnlContextState;
/*     */ import com.opensymphony.xwork2.util.ValueStack;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class HiDefalutAction extends BaseAction
/*     */ {
/*     */   private String actionName;
/*     */   private String actionMethod;
/*  26 */   private String resultType = "dispatcher";
/*     */   private String resultValue;
/*     */ 
/*     */   public String transfor()
/*     */     throws Exception
/*     */   {
/*  30 */     BaseAction action = null;
/*  31 */     String type = "success";
/*     */     try {
/*  33 */       Class clazz = Class.forName(this.actionName);
/*  34 */       action = (BaseAction)clazz.newInstance();
/*     */     } catch (Exception e) {
/*  36 */       throw new BusinessException(I18NUtil.getStringByParameter("Action加载失败", this.actionName));
/*     */     }
/*  38 */     if (action != null) {
/*  39 */       ActionContext ac = ActionContext.getContext();
/*  40 */       Map parameters = ac.getParameters();
/*  41 */       if (parameters != null) {
/*  42 */         Map contextMap = ac.getContextMap();
/*     */         try {
/*  44 */           OgnlContextState.setCreatingNullObjects(contextMap, true);
/*  45 */           OgnlContextState.setDenyMethodExecution(contextMap, true);
/*  46 */           OgnlContextState.setReportingConversionErrors(contextMap, true);
/*     */ 
/*  48 */           ValueStack stack = ac.getValueStack();
/*  49 */           stack.push(action);
/*  50 */           setParameters(action, stack, parameters);
/*     */         } finally {
/*  52 */           OgnlContextState.setCreatingNullObjects(contextMap, false);
/*  53 */           OgnlContextState.setDenyMethodExecution(contextMap, false);
/*  54 */           OgnlContextState.setReportingConversionErrors(contextMap, false);
/*     */         }
/*  56 */         if (this.actionMethod == null) {
/*  57 */           type = action.execute();
/*     */         } else {
/*  59 */           Method method = action.getClass().getMethod(this.actionMethod, new Class[0]);
/*  60 */           type = (String)method.invoke(action, new Object[0]);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  65 */     return type;
/*     */   }
/*     */   protected void setParameters(Object action, ValueStack stack, Map parameters) {
/*  68 */     for (Iterator iterator = new TreeMap(parameters).entrySet().iterator(); iterator.hasNext(); ) {
/*  69 */       Map.Entry entry = (Map.Entry)iterator.next();
/*  70 */       String name = entry.getKey().toString();
/*     */ 
/*  72 */       Object value = entry.getValue();
/*     */       try {
/*  74 */         stack.setValue(name, value);
/*     */       } catch (Exception e) {
/*  76 */         throw new BusinessException(I18NUtil.getStringByParameter("Action对象赋值时出错", name));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getActionName()
/*     */   {
/*  84 */     return this.actionName;
/*     */   }
/*     */ 
/*     */   public void setActionName(String actionName)
/*     */   {
/*  90 */     this.actionName = actionName;
/*     */   }
/*     */ 
/*     */   public String getActionMethod()
/*     */   {
/*  96 */     return this.actionMethod;
/*     */   }
/*     */ 
/*     */   public void setActionMethod(String actionMethod)
/*     */   {
/* 102 */     this.actionMethod = actionMethod;
/*     */   }
/*     */ 
/*     */   public String getResultType()
/*     */   {
/* 108 */     return this.resultType;
/*     */   }
/*     */ 
/*     */   public void setResultType(String resultType)
/*     */   {
/* 114 */     this.resultType = resultType;
/*     */   }
/*     */ 
/*     */   public String getResultValue()
/*     */   {
/* 120 */     return this.resultValue;
/*     */   }
/*     */ 
/*     */   public void setResultValue(String resultValue)
/*     */   {
/* 126 */     this.resultValue = resultValue;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.mvc.action.struts.HiDefalutAction
 * JD-Core Version:    0.6.0
 */