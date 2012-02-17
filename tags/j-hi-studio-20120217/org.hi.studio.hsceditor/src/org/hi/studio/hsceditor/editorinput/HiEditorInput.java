/*    */ package org.hi.studio.hsceditor.editorinput;
/*    */ 
/*    */ import org.eclipse.core.resources.IFile;
/*    */ import org.eclipse.ui.part.FileEditorInput;
/*    */ 
/*    */ public class HiEditorInput extends FileEditorInput
/*    */ {
/*  8 */   private String serviceName = "";
/*  9 */   private String packageName = "";
/* 10 */   private String baseData = "";
/* 11 */   private String desc = "";
/*    */ 
/*    */   public String getDesc() {
/* 14 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 18 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public String getServiceName() {
/* 22 */     return this.serviceName;
/*    */   }
/*    */ 
/*    */   public void setServiceName(String serviceName) {
/* 26 */     this.serviceName = serviceName;
/*    */   }
/*    */ 
/*    */   public String getPackageName() {
/* 30 */     return this.packageName;
/*    */   }
/*    */ 
/*    */   public void setPackageName(String packageName) {
/* 34 */     this.packageName = packageName;
/*    */   }
/*    */ 
/*    */   public String getBaseData() {
/* 38 */     return this.baseData;
/*    */   }
/*    */ 
/*    */   public void setBaseData(String baseData) {
/* 42 */     this.baseData = baseData;
/*    */   }
/*    */ 
/*    */   public HiEditorInput(IFile file) {
/* 46 */     super(file);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.editorinput.HiEditorInput
 * JD-Core Version:    0.6.0
 */