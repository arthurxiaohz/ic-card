/*     */ package org.hi.common.scripting.bsh;
/*     */ 
/*     */ import bsh.BshClassManager;
/*     */ import bsh.EvalError;
/*     */ import bsh.Interpreter;
/*     */ import bsh.NameSpace;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class BeanShellWrapper extends ClassLoader
/*     */ {
/*  25 */   Interpreter interpreter = new Interpreter();
/*  26 */   BshClassManager classMgr = BshClassManager.createClassManager(this.interpreter);
/*  27 */   NameSpace nameSpace = new NameSpace(this.classMgr, "improt_package" + hashCode());
/*     */   Map<String, Object> model;
/*     */ 
/*     */   BeanShellWrapper(Map<String, Object> model)
/*     */     throws EvalError
/*     */   {
/*  30 */     BeanShellWrapper(model);
/*     */   }
/*     */ 
/*     */   BeanShellWrapper(String name, Object obj) throws EvalError {
/*  34 */     Map model = new HashMap();
/*  35 */     model.put(name, obj);
/*  36 */     BeanShellWrapper(model);
/*     */   }
/*     */ 
/*     */   BeanShellWrapper() throws EvalError
/*     */   {
/*  41 */     BeanShellWrapper(null);
/*     */   }
/*     */ 
/*     */   private void BeanShellWrapper(Map<String, Object> model) throws EvalError {
/*  45 */     this.model = model;
/*  46 */     Package[] packages = getPackages();
/*  47 */     for (Package importPackage : packages) {
/*  48 */       String pagkageName = importPackage.getName();
/*  49 */       this.nameSpace.importPackage(pagkageName);
/*     */     }
/*     */ 
/*  52 */     if (model != null) {
/*  53 */       Set keySet = model.keySet();
/*  54 */       for (String key : keySet)
/*  55 */         this.interpreter.set(key, model.get(key));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void importPackage(String pagkageName)
/*     */   {
/*  65 */     this.nameSpace.importPackage(pagkageName);
/*     */   }
/*     */ 
/*     */   public Object eval(String script)
/*     */     throws EvalError
/*     */   {
/*  75 */     return this.interpreter.eval(script);
/*     */   }
/*     */ 
/*     */   public Map<String, Object> getModel()
/*     */   {
/*  84 */     return this.model;
/*     */   }
/*     */ 
/*     */   public void put(String key, Object value) throws EvalError {
/*  88 */     if (this.model == null)
/*  89 */       this.model = new HashMap();
/*  90 */     this.model.put(key, value);
/*  91 */     this.interpreter.set(key, value);
/*     */   }
/*     */ 
/*     */   public void remove(String key) {
/*  95 */     if ((this.model == null) || (this.model.size() == 0)) {
/*  96 */       return;
/*     */     }
/*  98 */     this.model.remove(key);
/*     */   }
/*     */ 
/*     */   public Object get(String key) {
/* 102 */     return this.model.get(key);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.scripting.bsh.BeanShellWrapper
 * JD-Core Version:    0.6.0
 */