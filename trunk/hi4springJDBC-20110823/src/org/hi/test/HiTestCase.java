/*    */ package org.hi.test;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import javax.xml.parsers.DocumentBuilder;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import junit.framework.TestCase;
/*    */ import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
/*    */ import org.hi.framework.spring.ContextLoader;
/*    */ import org.springframework.mock.web.MockServletConfig;
/*    */ import org.springframework.mock.web.MockServletContext;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ import org.xml.sax.ErrorHandler;
/*    */ import org.xml.sax.SAXException;
/*    */ import org.xml.sax.SAXParseException;
/*    */ 
/*    */ public abstract class HiTestCase extends TestCase
/*    */ {
/*    */   private String webContextPath;
/*    */   protected WebApplicationContext appContext;
/*    */ 
/*    */   protected void setUp()
/*    */     throws Exception
/*    */   {
/* 35 */     super.setUp();
/*    */ 
/* 37 */     File classFile = new File(getClass().getClassLoader().getResource("").toURI());
/* 38 */     this.webContextPath = classFile.getParentFile().getParentFile().getPath();
/* 39 */     File webXMLFile = new File(this.webContextPath + "/WEB-INF/web.xml");
/*    */ 
/* 42 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 43 */     dbf.setValidating(false);
/* 44 */     dbf.setNamespaceAware(false);
/* 45 */     dbf.setIgnoringComments(true);
/* 46 */     dbf.setIgnoringElementContentWhitespace(false);
/* 47 */     dbf.setCoalescing(false);
/* 48 */     dbf.setExpandEntityReferences(true);
/* 49 */     DocumentBuilder db = dbf.newDocumentBuilder();
/* 50 */     db.setEntityResolver(new XMLMapperEntityResolver());
/* 51 */     db.setErrorHandler(new ErrorHandler() {
/*    */       public void error(SAXParseException exception) throws SAXException {
/* 53 */         throw exception;
/*    */       }
/*    */ 
/*    */       public void fatalError(SAXParseException exception) throws SAXException {
/* 57 */         throw exception;
/*    */       }
/*    */ 
/*    */       public void warning(SAXParseException exception)
/*    */         throws SAXException
/*    */       {
/*    */       }
/*    */     });
/* 63 */     URLConnection urlConnection = webXMLFile.toURI().toURL().openConnection();
/* 64 */     urlConnection.setUseCaches(false);
/* 65 */     Document doc = db.parse(urlConnection.getInputStream());
/* 66 */     NodeList paramElements = doc.getElementsByTagName("context-param");
/* 67 */     if (paramElements == null) {
/* 68 */       throw new Exception("not found file:web.xml!");
/*    */     }
/* 70 */     String contextClass = null;
/* 71 */     String contextConfigLocation = null;
/* 72 */     for (int i = 0; i < paramElements.getLength(); i++) {
/* 73 */       if (!(paramElements.item(i) instanceof Element))
/*    */         continue;
/* 75 */       Element element = (Element)paramElements.item(i);
/*    */ 
/* 77 */       NodeList paramContext = element.getChildNodes();
/* 78 */       for (int j = 0; j < paramContext.getLength(); j++) {
/* 79 */         if (!(paramContext.item(j) instanceof Element)) {
/*    */           continue;
/*    */         }
/* 82 */         Element param = (Element)paramContext.item(j);
/* 83 */         String content = param.getTextContent().trim();
/* 84 */         if (content != null) {
/* 85 */           if (content.equals("contextClass"))
/* 86 */             contextClass = element.getElementsByTagName("param-value").item(0).getTextContent().trim();
/* 87 */           if (content.equals("contextConfigLocation")) {
/* 88 */             contextConfigLocation = element.getElementsByTagName("param-value").item(0).getTextContent().trim();
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 93 */     ContextLoader cl = new ContextLoader();
/*    */ 
/* 95 */     MockServletContext msc = new MockServletContext("file:" + this.webContextPath);
/* 96 */     msc.addInitParameter("contextConfigLocation", contextConfigLocation);
/* 97 */     msc.addInitParameter("contextClass", contextClass);
/* 98 */     MockServletConfig msg = new MockServletConfig(msc);
/* 99 */     this.appContext = cl.initWebApplicationContext(msc);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.test.HiTestCase
 * JD-Core Version:    0.6.0
 */