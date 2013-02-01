/*    */ package org.hi.framework.web.webwork;
/*    */ 
/*    */ import com.opensymphony.webwork.ServletActionContext;
/*    */ import com.opensymphony.xwork.ActionInvocation;
/*    */ import com.opensymphony.xwork.Result;
/*    */ import com.opensymphony.xwork.util.OgnlValueStack;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.jxls.transformer.XLSTransformer;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ 
/*    */ public class ExcelResult
/*    */   implements Result
/*    */ {
/*    */   private XLSTransformer transFormer;
/*    */   private String filename;
/*    */   private String templetFile;
/*    */   private String contenttype;
/*    */   private Map<String, Object> model;
/*    */ 
/*    */   public void execute(ActionInvocation invocation)
/*    */     throws Exception
/*    */   {
/* 33 */     if (this.contenttype == null)
/* 34 */       this.contenttype = "application/vnd.ms-excel";
/* 35 */     if (this.transFormer == null)
/* 36 */       this.transFormer = 
/* 37 */         ((XLSTransformer)invocation.getStack()
/* 37 */         .findValue("transFormer"));
/* 38 */     if (this.filename == null)
/* 39 */       this.filename = ((String)invocation.getStack().findValue("filename"));
/* 40 */     if (this.templetFile == null)
/* 41 */       this.templetFile = ((String)invocation.getStack().findValue("templetFile"));
/* 42 */     if (this.model == null) {
/* 43 */       this.model = ((Map)invocation.getStack().findValue("model"));
/*    */     }
/*    */ 
/* 46 */     HttpServletResponse response = ServletActionContext.getResponse();
/* 47 */     response.setContentType(this.contenttype);
/* 48 */     response.setHeader("Content-Disposition", "attachment;Filename=" + 
/* 49 */       this.filename);
/* 50 */     OutputStream os = response.getOutputStream();
/*    */ 
/* 52 */     OutputStream out = response.getOutputStream();
/* 53 */     InputStream is = new BufferedInputStream(new FileInputStream(this.templetFile));
/*    */ 
/* 55 */     HSSFWorkbook workBook = this.transFormer.transformXLS(is, this.model);
/* 56 */     workBook.write(out);
/*    */ 
/* 58 */     is.close();
/* 59 */     out.flush();
/* 60 */     out.close();
/* 61 */     os.flush();
/* 62 */     os.close();
/*    */   }
/*    */ 
/*    */   public void setTransFormer(XLSTransformer transFormer) {
/* 66 */     this.transFormer = transFormer;
/*    */   }
/*    */ 
/*    */   public void setFilename(String filename) {
/* 70 */     this.filename = filename;
/*    */   }
/*    */ 
/*    */   public void setTempletFile(String templetFile) {
/* 74 */     this.templetFile = templetFile;
/*    */   }
/*    */ 
/*    */   public void setContenttype(String contenttype) {
/* 78 */     this.contenttype = contenttype;
/*    */   }
/*    */ 
/*    */   public void setModel(Map<String, Object> model) {
/* 82 */     this.model = model;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.webwork.ExcelResult
 * JD-Core Version:    0.6.0
 */