/*    */ package org.hi.framework.web.struts;
/*    */ 
/*    */ import com.opensymphony.xwork2.ActionInvocation;
/*    */ import com.opensymphony.xwork2.Result;
/*    */ import com.opensymphony.xwork2.util.ValueStack;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.jxls.transformer.XLSTransformer;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ import org.apache.struts2.ServletActionContext;
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
/* 34 */     if (this.contenttype == null)
/* 35 */       this.contenttype = "application/vnd.ms-excel";
/* 36 */     if (this.transFormer == null)
/* 37 */       this.transFormer = 
/* 38 */         ((XLSTransformer)invocation.getStack()
/* 38 */         .findValue("transFormer"));
/* 39 */     if (this.filename == null)
/* 40 */       this.filename = ((String)invocation.getStack().findValue("filename"));
/* 41 */     if (this.templetFile == null)
/* 42 */       this.templetFile = ((String)invocation.getStack().findValue("templetFile"));
/* 43 */     if (this.model == null) {
/* 44 */       this.model = ((Map)invocation.getStack().findValue("model"));
/*    */     }
/*    */ 
/* 47 */     HttpServletResponse response = ServletActionContext.getResponse();
/* 48 */     response.setContentType(this.contenttype);
/* 49 */     response.setHeader("Content-Disposition", "attachment;Filename=" + 
/* 50 */       this.filename);
/* 51 */     OutputStream os = response.getOutputStream();
/*    */ 
/* 53 */     OutputStream out = response.getOutputStream();
/* 54 */     InputStream is = new BufferedInputStream(new FileInputStream(this.templetFile));
/*    */ 
/* 56 */     HSSFWorkbook workBook = this.transFormer.transformXLS(is, this.model);
/* 57 */     workBook.write(out);
/*    */ 
/* 59 */     is.close();
/* 60 */     out.flush();
/* 61 */     out.close();
/* 62 */     os.flush();
/* 63 */     os.close();
/*    */   }
/*    */ 
/*    */   public void setTransFormer(XLSTransformer transFormer) {
/* 67 */     this.transFormer = transFormer;
/*    */   }
/*    */ 
/*    */   public void setFilename(String filename) {
/* 71 */     this.filename = filename;
/*    */   }
/*    */ 
/*    */   public void setTempletFile(String templetFile) {
/* 75 */     this.templetFile = templetFile;
/*    */   }
/*    */ 
/*    */   public void setContenttype(String contenttype) {
/* 79 */     this.contenttype = contenttype;
/*    */   }
/*    */ 
/*    */   public void setModel(Map<String, Object> model) {
/* 83 */     this.model = model;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.struts.ExcelResult
 * JD-Core Version:    0.6.0
 */