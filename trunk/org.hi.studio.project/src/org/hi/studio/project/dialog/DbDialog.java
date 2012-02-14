/*     */ package org.hi.studio.project.dialog;
/*     */ 
/*     */ import org.eclipse.jface.dialogs.TitleAreaDialog;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.events.SelectionListener;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.studio.generator.db.DbUtil;
/*     */ import org.hi.studio.project.base.DataBaseHelper;
/*     */ import org.hi.studio.project.utils.GuiHelper;
/*     */ 
/*     */ public class DbDialog extends TitleAreaDialog
/*     */   implements SelectionListener
/*     */ {
/*  26 */   private Combo dbtypeCombo = null;
/*     */   private Text urlTxt;
/*     */   private Text nameTxt;
/*     */   private Text pwdTxt;
/*     */   private Text driverTxt;
/*  27 */   private Text dialectTxt = null;
/*  28 */   private Button testbt = null;
/*     */   private Button initBtn;
/*  30 */   private String[] dbtypestr = DataBaseHelper.DBTYPESTR;
/*  31 */   private String[] testsqlstr = DataBaseHelper.TESTSQLSTR;
/*  32 */   private String[] driverstr = DataBaseHelper.DRIVERSTR;
/*  33 */   private String[] urlstr = DataBaseHelper.URLSTR;
/*     */   private String dbtype;
/*     */   private String url;
/*     */   private String driver;
/*     */   private String name;
/*  36 */   private String pwd = ""; private String ormType = ""; private String testsql = "";
/*  37 */   private String dialect = DataBaseHelper.getDefaultDialect();
/*     */ 
/*     */   public void setDriver(String driver) {
/*  40 */     this.driver = driver;
/*     */   }
/*     */ 
/*     */   public DbDialog(Shell parentShell) {
/*  44 */     super(parentShell);
/*     */   }
/*     */ 
/*     */   protected Control createDialogArea(Composite parent)
/*     */   {
/*  52 */     setTitle("设置数据库连接");
/*  53 */     setMessage("支持三种数据库，可进行连接测试");
/*  54 */     Composite area = GuiHelper.createSwordComp(parent, 0, 
/*  55 */       new GridData(1808), new GridLayout(2, false));
/*  56 */     GuiHelper.createSwordLabel(area, 0, "数据库类型：");
/*  57 */     this.dbtypeCombo = GuiHelper.createSwordCombo(area, 2056, 
/*  58 */       gdhfill(), null);
/*  59 */     this.dbtypeCombo.addSelectionListener(this);
/*  60 */     this.dbtypeCombo.setItems(this.dbtypestr);
/*  61 */     this.dbtypeCombo.setText(getDbtype());
/*     */ 
/*  63 */     GuiHelper.createSwordLabel(area, 0, "数据库URL：");
/*  64 */     this.urlTxt = 
/*  65 */       GuiHelper.createSwordText(area, 2048, gdhfill());
/*  66 */     this.urlTxt.setText(getUrl());
/*     */ 
/*  75 */     GuiHelper.createSwordLabel(area, 0, "数据库驱动：");
/*  76 */     this.driverTxt = GuiHelper.createSwordText(area, 2048, 
/*  77 */       gdhfill());
/*  78 */     this.driverTxt.setText(getDriver());
/*     */ 
/*  80 */     GuiHelper.createSwordLabel(area, 0, "方言类名称：");
/*  81 */     this.dialectTxt = GuiHelper.createSwordText(area, 2048, 
/*  82 */       gdhfill());
/*  83 */     this.dialectTxt.setText(getDialect());
/*     */ 
/*  85 */     GuiHelper.createSwordLabel(area, 0, "数据库用户名：");
/*  86 */     this.nameTxt = GuiHelper.createSwordText(area, 2048, 
/*  87 */       gdhfill());
/*  88 */     this.nameTxt.setText(getName());
/*  89 */     GuiHelper.createSwordLabel(area, 0, "数据库密码：");
/*  90 */     this.pwdTxt = GuiHelper.createSwordText(area, 4196352, 
/*  91 */       gdhfill());
/*  92 */     this.pwdTxt.setText(getPwd());
/*  93 */     this.testbt = GuiHelper.createSwordButton(area, 0, 
/*  94 */       "测试数据库连接", null);
/*  95 */     this.testbt.addSelectionListener(this);
/*     */ 
/*  97 */     this.initBtn = GuiHelper.createSwordButton(area, 0, 
/*  98 */       "初始化数据库", null);
/*  99 */     this.initBtn.setEnabled(false);
/* 100 */     this.initBtn.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e)
/*     */       {
/* 105 */         DbDialog.this.dbtype = DbDialog.this.dbtypeCombo.getText();
/* 106 */         DbDialog.this.url = DbDialog.this.urlTxt.getText();
/* 107 */         DbDialog.this.driver = DbDialog.this.driverTxt.getText();
/* 108 */         DbDialog.this.name = DbDialog.this.nameTxt.getText();
/* 109 */         DbDialog.this.pwd = DbDialog.this.pwdTxt.getText();
/* 110 */         DbUtil.initPlatform(DbUtil.getConnection(DbDialog.this.driver, DbDialog.this.url, DbDialog.this.name, DbDialog.this.pwd), 
/* 111 */           DbDialog.this.dbtypestr[DbDialog.this.dbtypeCombo.getSelectionIndex()]);
/*     */       }
/*     */     });
/* 117 */     setDbSelectValue();
/*     */ 
/* 119 */     return area;
/*     */   }
/*     */ 
/*     */   protected void okPressed()
/*     */   {
/* 124 */     this.dbtype = this.dbtypeCombo.getText();
/* 125 */     this.url = this.urlTxt.getText();
/* 126 */     this.driver = this.driverTxt.getText();
/* 127 */     this.name = this.nameTxt.getText();
/* 128 */     this.pwd = this.pwdTxt.getText();
/* 129 */     this.dialect = this.dialectTxt.getText();
/* 130 */     if (this.url.equals(""))
/* 131 */       setErrorMessage("请填写URL");
/* 132 */     else if (this.name.trim().equals("")) {
/* 133 */       setErrorMessage("请填写用户名");
/*     */     }
/* 137 */     else if (testConn(this.driver, this.url, this.name, this.pwd))
/* 138 */       super.okPressed();
/*     */   }
/*     */ 
/*     */   public void widgetDefaultSelected(SelectionEvent e)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setDbSelectValue()
/*     */   {
/* 150 */     this.driverTxt.setText(this.driverstr[this.dbtypeCombo.getSelectionIndex()]);
/* 151 */     this.urlTxt.setText(this.urlstr[this.dbtypeCombo.getSelectionIndex()]);
/* 152 */     this.dialectTxt.setText(DataBaseHelper.getDialect(getOrmType())[this.dbtypeCombo.getSelectionIndex()]);
/* 153 */     this.testsql = this.testsqlstr[this.dbtypeCombo.getSelectionIndex()];
/*     */   }
/*     */ 
/*     */   public void widgetSelected(SelectionEvent e) {
/* 157 */     if (e.getSource().equals(this.dbtypeCombo)) {
/* 158 */       setDbSelectValue();
/*     */     }
/*     */ 
/* 165 */     if (e.getSource().equals(this.testbt))
/* 166 */       testConn(this.driverTxt.getText(), this.urlTxt.getText(), this.nameTxt
/* 167 */         .getText(), this.pwdTxt.getText());
/*     */   }
/*     */ 
/*     */   private boolean testConn(String driver, String url, String name, String pwd)
/*     */   {
/* 174 */     if (DbUtil.canConncet(driver, url, name, pwd)) {
/* 175 */       setMessage("连接成功。");
/* 176 */       setErrorMessage(null);
/* 177 */       this.initBtn.setEnabled(true);
/* 178 */       return true;
/*     */     }
/* 180 */     setErrorMessage("连接失败，请检测输入数据或数据库状态。");
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */   public String getOrmType()
/*     */   {
/* 187 */     return this.ormType;
/*     */   }
/*     */ 
/*     */   public void setOrmType(String ormType) {
/* 191 */     this.ormType = ormType;
/*     */   }
/*     */ 
/*     */   public String getDbtype() {
/* 195 */     return this.dbtype;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/* 199 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setDbtype(String dbtype) {
/* 203 */     this.dbtype = dbtype;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/* 207 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 211 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public void setPwd(String pwd) {
/* 215 */     this.pwd = pwd;
/*     */   }
/*     */ 
/*     */   public void setDialect(String dialect) {
/* 219 */     this.dialect = dialect;
/*     */   }
/*     */ 
/*     */   public String getDriver() {
/* 223 */     return this.driver;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 227 */     return this.name;
/*     */   }
/*     */ 
/*     */   public String getPwd() {
/* 231 */     return this.pwd;
/*     */   }
/*     */ 
/*     */   public String getDialect() {
/* 235 */     return this.dialect;
/*     */   }
/*     */ 
/*     */   protected static GridData gdhfill() {
/* 239 */     return new GridData(768);
/*     */   }
/*     */ 
/*     */   public String getTestsql() {
/* 243 */     return this.testsql;
/*     */   }
/*     */ 
/*     */   public void setTestsql(String testsql) {
/* 247 */     this.testsql = testsql;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.dialog.DbDialog
 * JD-Core Version:    0.6.0
 */