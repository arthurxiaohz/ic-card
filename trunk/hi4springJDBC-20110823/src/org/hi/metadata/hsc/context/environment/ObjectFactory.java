/*     */ package org.hi.metadata.hsc.context.environment;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  34 */   private static final QName _Password_QNAME = new QName("", "password");
/*  35 */   private static final QName _TempletDir_QNAME = new QName("", "templetDir");
/*  36 */   private static final QName _StandardOutput_QNAME = new QName("", "standardOutput");
/*  37 */   private static final QName _DriverClass_QNAME = new QName("", "driverClass");
/*  38 */   private static final QName _HomePath_QNAME = new QName("", "homePath");
/*  39 */   private static final QName _AppName_QNAME = new QName("", "appName");
/*  40 */   private static final QName _Username_QNAME = new QName("", "username");
/*  41 */   private static final QName _Url_QNAME = new QName("", "url");
/*  42 */   private static final QName _SrcOutput_QNAME = new QName("", "srcOutput");
/*  43 */   private static final QName _OrgPackage_QNAME = new QName("", "orgPackage");
/*  44 */   private static final QName _LibraryDir_QNAME = new QName("", "libraryDir");
/*  45 */   private static final QName _Dbtype_QNAME = new QName("", "dbtype");
/*     */ 
/*     */   public Generate createGenerate()
/*     */   {
/*  59 */     return new Generate();
/*     */   }
/*     */ 
/*     */   public Environment createEnvironment()
/*     */   {
/*  67 */     return new Environment();
/*     */   }
/*     */ 
/*     */   public Connection createConnection()
/*     */   {
/*  75 */     return new Connection();
/*     */   }
/*     */ 
/*     */   public Database createDatabase()
/*     */   {
/*  83 */     return new Database();
/*     */   }
/*     */ 
/*     */   public JavaEnvironment createJavaEnvironment()
/*     */   {
/*  91 */     return new JavaEnvironment();
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="password")
/*     */   public JAXBElement<String> createPassword(String value)
/*     */   {
/* 100 */     return new JAXBElement(_Password_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="templetDir")
/*     */   public JAXBElement<String> createTempletDir(String value)
/*     */   {
/* 109 */     return new JAXBElement(_TempletDir_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="standardOutput")
/*     */   public JAXBElement<String> createStandardOutput(String value)
/*     */   {
/* 118 */     return new JAXBElement(_StandardOutput_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="driverClass")
/*     */   public JAXBElement<String> createDriverClass(String value)
/*     */   {
/* 127 */     return new JAXBElement(_DriverClass_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="homePath")
/*     */   public JAXBElement<String> createHomePath(String value)
/*     */   {
/* 136 */     return new JAXBElement(_HomePath_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="appName")
/*     */   public JAXBElement<String> createAppName(String value)
/*     */   {
/* 145 */     return new JAXBElement(_AppName_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="username")
/*     */   public JAXBElement<String> createUsername(String value)
/*     */   {
/* 154 */     return new JAXBElement(_Username_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="url")
/*     */   public JAXBElement<String> createUrl(String value)
/*     */   {
/* 163 */     return new JAXBElement(_Url_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="srcOutput")
/*     */   public JAXBElement<String> createSrcOutput(String value)
/*     */   {
/* 172 */     return new JAXBElement(_SrcOutput_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="orgPackage")
/*     */   public JAXBElement<String> createOrgPackage(String value)
/*     */   {
/* 181 */     return new JAXBElement(_OrgPackage_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="libraryDir")
/*     */   public JAXBElement<String> createLibraryDir(String value)
/*     */   {
/* 190 */     return new JAXBElement(_LibraryDir_QNAME, String.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="", name="dbtype")
/*     */   public JAXBElement<String> createDbtype(String value)
/*     */   {
/* 199 */     return new JAXBElement(_Dbtype_QNAME, String.class, null, value);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.environment.ObjectFactory
 * JD-Core Version:    0.6.0
 */