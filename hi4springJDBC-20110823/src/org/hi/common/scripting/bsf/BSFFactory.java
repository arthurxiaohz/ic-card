/*    */ package org.hi.common.scripting.bsf;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.bsf.BSFException;
/*    */ 
/*    */ public class BSFFactory
/*    */ {
/*    */   public static final String BSF_LANGUAGE_JAVASCRIPT = "javascript";
/*    */   public static final String BSF_LANGUAGE_JACL = "jacl";
/*    */   public static final String BSF_LANGUAGE_NETREXX = "netrexx";
/*    */   public static final String BSF_LANGUAGE_JAVA = "java";
/*    */   public static final String BSF_LANGUAGE_JAVACLASS = "javaclass";
/*    */   public static final String BSF_LANGUAGE_BML = "bml";
/*    */   public static final String BSF_LANGUAGE_VBSCRIPT = "vbscript";
/*    */   public static final String BSF_LANGUAGE_JSCRIPT = "jscript";
/*    */   public static final String BSF_LANGUAGE_PERLSCRIPT = "perlscript";
/*    */   public static final String BSF_LANGUAGE_PERL = "perl";
/*    */   public static final String BSF_LANGUAGE_JPYTHON = "jpython";
/*    */   public static final String BSF_LANGUAGE_JYTHON = "jython";
/*    */   public static final String BSF_LANGUAGE_LOTSSCRIPT = "lotusscript";
/*    */   public static final String BSF_LANGUAGE_XSLT = "xslt";
/*    */   public static final String BSF_LANGUAGE_PNUTS = "pnuts";
/*    */   public static final String BSF_LANGUAGE_BEANBASIC = "beanbasic";
/*    */   public static final String BSF_LANGUAGE_BEANSHELL = "beanshell";
/*    */   public static final String BSF_LANGUAGE_JRBY = "ruby";
/*    */   public static final String BSF_LANGUAGE_JUDOSCRIPT = "judoscript";
/*    */   public static final String BSF_LANGUAGE_GROOVY = "groovy";
/*    */   public static final String BSF_LANGUAGE_OBJECTSCRIPT = "objectscript";
/*    */   public static final String BSF_LANGUAGE_PROLOG = "prolog";
/*    */   public static final String BSF_LANGUAGE_REXX = "rexx";
/*    */ 
/*    */   public static BSFWrapper createBSF(String language, Map<String, Object> model)
/*    */     throws BSFException
/*    */   {
/* 34 */     return new BSFWrapper(language, model);
/*    */   }
/*    */ 
/*    */   public static BSFWrapper createBSF(String language, String name, Object obj) throws BSFException {
/* 38 */     return new BSFWrapper(language, name, obj);
/*    */   }
/*    */ 
/*    */   public static BSFWrapper createBSF(String language) throws BSFException {
/* 42 */     return new BSFWrapper(language);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.scripting.bsf.BSFFactory
 * JD-Core Version:    0.6.0
 */