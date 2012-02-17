/*     */ package org.hi.studio.hsceditor.visual.dialog;
/*     */ 
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.jface.dialogs.Dialog;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.utils.EnvironmentUtil;
/*     */ import org.hi.studio.hsceditor.util.FilterUtil;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ 
/*     */ public class ServiceEditDialog extends Dialog
/*     */ {
/*     */   private Text packageText;
/*     */   private Text serviceText;
/*     */   private Text basicDataText;
/*     */   private Text descText;
/*  32 */   private String hiPackage = "";
/*  33 */   private String hiBasicData = "";
/*  34 */   private String hiDesc = "";
/*  35 */   private String hiServiceName = "";
/*  36 */   private boolean isServiceEditable = false;
/*     */ 
/*     */   public String getHiServiceName() {
/*  39 */     return this.hiServiceName;
/*     */   }
/*     */ 
/*     */   public void setHiServiceName(String hiServiceName) {
/*  43 */     this.hiServiceName = hiServiceName;
/*     */   }
/*     */ 
/*     */   public String getHiPackage() {
/*  47 */     return this.hiPackage;
/*     */   }
/*     */ 
/*     */   public void setHiPackage(String hiPackage) {
/*  51 */     this.hiPackage = hiPackage;
/*     */   }
/*     */ 
/*     */   public String getHiBasicData() {
/*  55 */     return this.hiBasicData;
/*     */   }
/*     */ 
/*     */   public void setHiBasicData(String hiBasicData) {
/*  59 */     this.hiBasicData = hiBasicData;
/*     */   }
/*     */ 
/*     */   public String getHiDesc() {
/*  63 */     return this.hiDesc;
/*     */   }
/*     */ 
/*     */   public void setHiDesc(String hiDesc) {
/*  67 */     this.hiDesc = hiDesc;
/*     */   }
/*     */ 
/*     */   public ServiceEditDialog(Shell parentShell, String serviceName, String packageName, String baseData, String desc, boolean isServiceEditable)
/*     */   {
/*  80 */     super(parentShell);
/*     */ 
/*  83 */     setHiServiceName(serviceName);
/*  84 */     setHiPackage(packageName);
/*  85 */     setHiBasicData(baseData);
/*  86 */     setHiDesc(desc);
/*     */ 
/*  88 */     this.isServiceEditable = isServiceEditable;
/*     */   }
/*     */ 
/*     */   protected Point getInitialSize()
/*     */   {
/*  93 */     return new Point(400, 300);
/*     */   }
/*     */ 
/*     */   protected Control createButtonBar(Composite parent) {
/*  97 */     Control result = super.createButtonBar(parent);
/*     */ 
/* 101 */     if (this.isServiceEditable) {
/* 102 */       checkButton();
/*     */     }
/*     */ 
/* 105 */     return result;
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/* 111 */     getShell().setText("HI平台服务");
/*     */ 
/* 113 */     Composite composite = new Composite(parent, 0);
/* 114 */     composite.setLayout(new GridLayout(2, false));
/* 115 */     composite.setLayoutData(new GridData(1808));
/*     */ 
/* 117 */     UIUtils.createLabel(composite, "editor.service.tree.servicename", false);
/* 118 */     this.serviceText = new Text(composite, 2048);
/* 119 */     this.serviceText.setLayoutData(new GridData(768));
/* 120 */     this.serviceText.setText(getHiServiceName());
/*     */ 
/* 122 */     this.serviceText.setEditable(this.isServiceEditable);
/* 123 */     this.serviceText.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e) {
/* 126 */         String packageName = EnvironmentUtil.getCurrentEnvironment()
/* 127 */           .getGenerate().getOrgPackage() + 
/* 128 */           "." + ServiceEditDialog.this.serviceText.getText();
/* 129 */         ServiceEditDialog.this.packageText.setText(packageName);
/*     */ 
/* 131 */         ServiceEditDialog.this.checkButton();
/*     */       }
/*     */     });
/* 136 */     UIUtils.createLabel(composite, "editor.service.tree.package", false);
/* 137 */     this.packageText = new Text(composite, 2048);
/* 138 */     this.packageText.setLayoutData(new GridData(768));
/* 139 */     this.packageText.setText(getHiPackage());
/*     */ 
/* 141 */     UIUtils.createLabel(composite, "editor.service.tree.data", false);
/* 142 */     this.basicDataText = new Text(composite, 2048);
/* 143 */     this.basicDataText.setLayoutData(new GridData(768));
/* 144 */     this.basicDataText.setText(getHiBasicData());
/* 145 */     UIUtils.createLabel(composite, "editor.service.tree.desc", false);
/* 146 */     this.descText = new Text(composite, 2048);
/* 147 */     this.descText.setLayoutData(new GridData(768));
/* 148 */     this.descText.setText(getHiDesc());
/*     */ 
/* 150 */     return composite;
/*     */   }
/*     */ 
/*     */   private void checkButton() {
/* 154 */     String fileName = this.serviceText.getText();
/* 155 */     IFile file = HiProjectUtil.getCurrentProject().getFile(".hi/" + fileName + ".hmc");
/*     */ 
/* 157 */     if ((file.exists()) || 
/* 158 */       (FilterUtil.validate(fileName)))
/* 159 */       getButton(0).setEnabled(false);
/*     */     else
/* 161 */       getButton(0).setEnabled(true);
/*     */   }
/*     */ 
/*     */   protected void okPressed()
/*     */   {
/* 168 */     setHiBasicData(this.basicDataText.getText());
/* 169 */     setHiDesc(this.descText.getText());
/* 170 */     setHiPackage(this.packageText.getText());
/* 171 */     setHiServiceName(this.serviceText.getText());
/*     */ 
/* 173 */     super.okPressed();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.dialog.ServiceEditDialog
 * JD-Core Version:    0.6.0
 */