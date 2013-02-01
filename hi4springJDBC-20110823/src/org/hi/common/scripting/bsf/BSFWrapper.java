/*    */ package org.hi.common.scripting.bsf;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.apache.bsf.BSFException;
/*    */ import org.apache.bsf.BSFManager;
/*    */ 
/*    */ public class BSFWrapper extends ClassLoader
/*    */ {
/* 12 */   BSFManager bsfManager = new BSFManager();
/*    */   String language;
/*    */   Map<String, Object> model;
/*    */ 
/*    */   BSFWrapper(String language, Map<String, Object> model)
/*    */     throws BSFException
/*    */   {
/* 17 */     BSFWrapper(language, model);
/*    */   }
/*    */ 
/*    */   BSFWrapper(String language, String name, Object obj) throws BSFException {
/* 21 */     Map model = new HashMap();
/* 22 */     model.put(name, obj);
/* 23 */     BSFWrapper(language, model);
/*    */   }
/*    */ 
/*    */   BSFWrapper(String language) throws BSFException
/*    */   {
/* 28 */     BSFWrapper(language, null);
/*    */   }
/*    */ 
/*    */   private void BSFWrapper(String language, Map<String, Object> model) throws BSFException {
/* 32 */     this.model = model;
/* 33 */     this.language = (language == null ? "beanshell" : language);
/* 34 */     Package[] packages = getPackages();
/* 35 */     for (Package importPackage : packages) {
/* 36 */       String pagkageName = importPackage.getName();
/* 37 */       this.bsfManager.setClassPath(pagkageName);
/*    */     }
/*    */ 
/* 40 */     if (model != null) {
/* 41 */       Set keySet = model.keySet();
/* 42 */       for (String key : keySet)
/* 43 */         this.bsfManager.declareBean(key, model.get(key), model.get(key).getClass());
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setClassPath(String classPath)
/*    */   {
/* 53 */     this.bsfManager.setClassPath(classPath);
/*    */   }
/*    */ 
/*    */   public Object eval(String script)
/*    */     throws BSFException
/*    */   {
/* 63 */     return this.bsfManager.eval(this.language, "", 0, 0, script);
/*    */   }
/*    */ 
/*    */   public Map<String, Object> getModel()
/*    */   {
/* 72 */     return this.model;
/*    */   }
/*    */ 
/*    */   public void put(String key, Object value) throws BSFException {
/* 76 */     if (this.model == null)
/* 77 */       this.model = new HashMap();
/* 78 */     this.model.put(key, value);
/* 79 */     this.bsfManager.declareBean(key, value, value.getClass());
/*    */   }
/*    */ 
/*    */   public void remove(String key) throws BSFException {
/* 83 */     if ((this.model == null) || (this.model.size() == 0))
/* 84 */       return;
/* 85 */     this.model.remove(key);
/* 86 */     this.bsfManager.undeclareBean(key);
/*    */   }
/*    */ 
/*    */   public Object get(String key) {
/* 90 */     return this.model.get(key);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.scripting.bsf.BSFWrapper
 * JD-Core Version:    0.6.0
 */