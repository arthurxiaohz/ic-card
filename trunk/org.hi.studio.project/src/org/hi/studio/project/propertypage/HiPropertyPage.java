/*     */ package org.hi.studio.project.propertypage;
/*     */ 
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.events.SelectionListener;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.eclipse.ui.dialogs.PropertyPage;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Connection;
/*     */ import org.hi.metadata.hsc.context.environment.Database;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.plugin.HiCorePlugin;
/*     */ import org.hi.studio.core.utils.FileUtil;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.db.DbUtil;
/*     */ import org.hi.studio.project.base.DataBaseHelper;
/*     */ import org.hi.studio.project.utils.GuiHelper;
/*     */ 
/*     */ public class HiPropertyPage extends PropertyPage
/*     */   implements SelectionListener
/*     */ {
/*     */   private Combo dbtypeCombo;
/*     */   private Text urlTxt;
/*     */   private Text nameTxt;
/*     */   private Text pwdTxt;
/*     */   private Text driverTxt;
/*  38 */   private Text dialectTxt = null;
/*     */   private Text appNameText;
/*     */   private Text orgPackageText;
/*     */   private Text templetDirText;
/*     */   private Text srcOutputText;
/*     */   private Text standardOutputText;
/*  45 */   private String appName = ""; private String orgPackage = ""; private String templetDir = ""; private String srcOutput = ""; private String standardOutput = ""; private String ormType = ""; private String viewType = ""; private String pageFrameType = "";
/*     */ 
/*  64 */   private Button testbt = null;
/*     */   private Button initBtn;
/*  66 */   private String[] dbtypestr = DataBaseHelper.DBTYPESTR;
/*     */ 
/*  71 */   private String[] driverstr = DataBaseHelper.DRIVERSTR;
/*  72 */   private String[] urlstr = DataBaseHelper.URLSTR;
/*  73 */   private String[] testsqlstr = DataBaseHelper.TESTSQLSTR;
/*     */ 
/*  75 */   private String dbtype = ""; private String url = ""; private String driver = ""; private String username = ""; private String password = ""; private String testsql = "";
/*  76 */   private String dialect = DataBaseHelper.getDefaultDialect();
/*     */ 
/*     */   public String getOrmType()
/*     */   {
/*  49 */     return this.ormType;
/*     */   }
/*     */ 
/*     */   public void setOrmType(String ormType) {
/*  53 */     this.ormType = ormType;
/*     */   }
/*     */ 
/*     */   public String getViewType() {
/*  57 */     return this.viewType;
/*     */   }
/*     */ 
/*     */   public void setViewType(String viewType) {
/*  61 */     this.viewType = viewType;
/*     */   }
/*     */ 
/*     */   public boolean performOk()
/*     */   {
/*     */     try
/*     */     {
/*  89 */       String url = this.urlTxt.getText();
/*  90 */       String username = this.nameTxt.getText();
/*  91 */       String password = this.pwdTxt.getText();
/*     */ 
/*  93 */       if (username.trim().equals(""))
/*     */       {
/*  95 */         MessageDialog.openError(null, "用户名不能为空", "用户名不能为空");
/*  96 */         return false;
/*     */       }
/*     */ 
/*  99 */       String driverClass = this.driverTxt.getText();
/* 100 */       String dialet = this.dialectTxt.getText();
/*     */ 
/* 111 */       String dbType = this.dbtypestr[this.dbtypeCombo.getSelectionIndex()];
/*     */ 
/* 116 */       if ((getElement() instanceof IProject))
/*     */       {
/* 118 */         IFolder webFolder = HiProjectUtil.getWebContentDir((IProject)getElement());
/* 119 */         String webPath = webFolder.getLocation().toString();
/* 120 */         String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/* 122 */         Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/* 123 */         env.getDatabase().setDbtype(dbType);
/* 124 */         env.getDatabase().getConnection().setDriverClass(driverClass);
/* 125 */         env.getDatabase().getConnection().setPassword(password);
/* 126 */         env.getDatabase().getConnection().setUrl(url);
/* 127 */         env.getDatabase().getConnection().setUsername(username);
/*     */ 
/* 130 */         env.getGenerate().setAppName(this.appNameText.getText());
/* 131 */         env.getGenerate().setOrgPackage(this.orgPackageText.getText());
/* 132 */         env.getGenerate().setSrcOutput(this.srcOutputText.getText());
/* 133 */         env.getGenerate().setStandardOutput(this.standardOutputText.getText());
/* 134 */         env.getGenerate().setTempletDir(this.templetDirText.getText());
/*     */ 
/* 139 */         EnvironmentFactory.writeEnvironmentXML(environmentFile, env);
/* 140 */         HiProjectUtil.generateConnectionPropertiese(webPath, driverClass, url, username, password, dialet, this.testsql);
/*     */ 
/* 142 */         String baseDir = HiCorePlugin.getCurrentPluginDirectory();
/* 143 */         String jarLib = webPath + "/WEB-INF/lib";
/* 144 */         String dbTypeJar = baseDir + "/resource/jar/" + dbType.toLowerCase();
/* 145 */         FileUtil.copyDirectory(dbTypeJar, jarLib);
/*     */       }
/*     */ 
/* 149 */       ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
/* 150 */         2, null);
/*     */     }
/*     */     catch (Exception e) {
/* 153 */       ExceptionManager.logError(e, "");
/*     */     }
/*     */ 
/* 156 */     return true;
/*     */   }
/*     */ 
/*     */   public String getAppName()
/*     */   {
/* 161 */     return this.appName;
/*     */   }
/*     */ 
/*     */   public void setAppName(String appName) {
/* 165 */     this.appName = appName;
/*     */   }
/*     */ 
/*     */   public String getOrgPackage() {
/* 169 */     return this.orgPackage;
/*     */   }
/*     */ 
/*     */   public void setOrgPackage(String orgPackage) {
/* 173 */     this.orgPackage = orgPackage;
/*     */   }
/*     */ 
/*     */   public String getTempletDir() {
/* 177 */     return this.templetDir;
/*     */   }
/*     */ 
/*     */   public void setTempletDir(String templetDir) {
/* 181 */     this.templetDir = templetDir;
/*     */   }
/*     */ 
/*     */   public String getSrcOutput() {
/* 185 */     return this.srcOutput;
/*     */   }
/*     */ 
/*     */   public void setSrcOutput(String srcOutput) {
/* 189 */     this.srcOutput = srcOutput;
/*     */   }
/*     */ 
/*     */   public String getStandardOutput() {
/* 193 */     return this.standardOutput;
/*     */   }
/*     */ 
/*     */   public void setStandardOutput(String standardOutput) {
/* 197 */     this.standardOutput = standardOutput;
/*     */   }
/*     */ 
/*     */   public void setDriver(String driver)
/*     */   {
/* 203 */     this.driver = driver;
/*     */   }
/*     */ 
/*     */   private void initData() {
/* 207 */     if ((getElement() instanceof IProject))
/*     */       try
/*     */       {
/* 210 */         IFolder webFolder = HiProjectUtil.getWebContentDir((IProject)getElement());
/* 211 */         String webPath = webFolder.getLocation().toString();
/* 212 */         String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/* 214 */         Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/*     */ 
/* 216 */         setDbtype(env.getDatabase().getDbtype());
/* 217 */         setDriver(env.getDatabase().getConnection().getDriverClass());
/*     */ 
/* 220 */         setDialect(HiProjectUtil.getPropertyByKey(webPath, "connection.dialect"));
/*     */ 
/* 223 */         setUrl(env.getDatabase().getConnection().getUrl());
/* 224 */         setUsername(env.getDatabase().getConnection().getUsername());
/* 225 */         setPassword(env.getDatabase().getConnection().getPassword());
/*     */ 
/* 227 */         setAppName(env.getGenerate().getAppName());
/* 228 */         setOrgPackage(env.getGenerate().getOrgPackage());
/* 229 */         setTempletDir(env.getGenerate().getTempletDir());
/* 230 */         setSrcOutput(env.getGenerate().getSrcOutput());
/* 231 */         setStandardOutput(env.getGenerate().getStandardOutput());
/*     */ 
/* 234 */         setOrmType(env.getGenerate().getOrmType());
/* 235 */         setViewType(env.getGenerate().getViewType());
/* 236 */         setPageFrameType(env.getGenerate().getPageFrameType());
/*     */       }
/*     */       catch (Exception e) {
/* 239 */         ExceptionManager.logError(e, "");
/*     */       }
/*     */   }
/*     */ 
/*     */   protected Control createContents(Composite parent)
/*     */   {
/* 247 */     initData();
/*     */ 
/* 251 */     setTitle("HI平台设置");
/* 252 */     Group area = GuiHelper.createSwordGroup(parent, 0, 
/* 253 */       new GridData(1808), new GridLayout(2, false), "数据库设置");
/* 254 */     GuiHelper.createSwordLabel(area, 0, "数据库类型：");
/* 255 */     this.dbtypeCombo = GuiHelper.createSwordCombo(area, 2056, 
/* 256 */       gdhfill(), null);
/* 257 */     this.dbtypeCombo.setItems(this.dbtypestr);
/* 258 */     this.dbtypeCombo.setText(getDbtype());
/* 259 */     this.dbtypeCombo.addSelectionListener(this);
/* 260 */     GuiHelper.createSwordLabel(area, 0, "数据库URL：");
/* 261 */     this.urlTxt = 
/* 262 */       GuiHelper.createSwordText(area, 2048, gdhfill());
/* 263 */     this.urlTxt.setText(getUrl());
/*     */ 
/* 273 */     GuiHelper.createSwordLabel(area, 0, "数据库驱动：");
/* 274 */     this.driverTxt = GuiHelper.createSwordText(area, 2048, 
/* 275 */       gdhfill());
/* 276 */     this.driverTxt.setText(getDriver());
/*     */ 
/* 278 */     GuiHelper.createSwordLabel(area, 0, "方言类名称：");
/* 279 */     this.dialectTxt = GuiHelper.createSwordText(area, 2048, 
/* 280 */       gdhfill());
/* 281 */     this.dialectTxt.setText(getDialect());
/*     */ 
/* 283 */     GuiHelper.createSwordLabel(area, 0, "数据库用户名：");
/* 284 */     this.nameTxt = GuiHelper.createSwordText(area, 2048, 
/* 285 */       gdhfill());
/* 286 */     this.nameTxt.setText(getUsername());
/* 287 */     GuiHelper.createSwordLabel(area, 0, "数据库密码：");
/* 288 */     this.pwdTxt = GuiHelper.createSwordText(area, 4196352, 
/* 289 */       gdhfill());
/* 290 */     this.pwdTxt.setText(getPassword());
/* 291 */     this.testbt = GuiHelper.createSwordButton(area, 0, 
/* 292 */       "测试数据库连接", null);
/* 293 */     this.testbt.addSelectionListener(this);
/*     */ 
/* 295 */     this.initBtn = GuiHelper.createSwordButton(area, 0, 
/* 296 */       "初始化数据库", null);
/* 297 */     this.initBtn.setEnabled(false);
/* 298 */     this.initBtn.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e)
/*     */       {
/* 303 */         HiPropertyPage.this.dbtype = HiPropertyPage.this.dbtypeCombo.getText();
/* 304 */         HiPropertyPage.this.url = HiPropertyPage.this.urlTxt.getText();
/* 305 */         HiPropertyPage.this.driver = HiPropertyPage.this.driverTxt.getText();
/* 306 */         HiPropertyPage.this.username = HiPropertyPage.this.nameTxt.getText();
/* 307 */         HiPropertyPage.this.password = HiPropertyPage.this.pwdTxt.getText();
/* 308 */         DbUtil.initPlatform(DbUtil.getConnection(HiPropertyPage.this.driver, HiPropertyPage.this.url, HiPropertyPage.this.username, HiPropertyPage.this.password), 
/* 309 */           HiPropertyPage.this.dbtypestr[HiPropertyPage.this.dbtypeCombo.getSelectionIndex()]);
/*     */       }
/*     */     });
/* 316 */     Group generatorGroup = GuiHelper.createSwordGroup(parent, 0, 
/* 317 */       new GridData(1808), new GridLayout(2, false), "生成器设置");
/* 318 */     GuiHelper.createSwordLabel(generatorGroup, 0, "应用名：");
/* 319 */     this.appNameText = GuiHelper.createSwordText(generatorGroup, 2048, 
/* 320 */       gdhfill());
/* 321 */     this.appNameText.setText(getAppName());
/* 322 */     GuiHelper.createSwordLabel(generatorGroup, 0, "包名：");
/* 323 */     this.orgPackageText = GuiHelper.createSwordText(generatorGroup, 2048, 
/* 324 */       gdhfill());
/* 325 */     this.orgPackageText.setText(getOrgPackage());
/* 326 */     GuiHelper.createSwordLabel(generatorGroup, 0, "模板路径：");
/* 327 */     this.templetDirText = GuiHelper.createSwordText(generatorGroup, 2048, 
/* 328 */       gdhfill());
/* 329 */     this.templetDirText.setText(getTempletDir());
/* 330 */     this.templetDirText.setEditable(false);
/* 331 */     GuiHelper.createSwordLabel(generatorGroup, 0, "源文件路径：");
/* 332 */     this.srcOutputText = GuiHelper.createSwordText(generatorGroup, 2048, 
/* 333 */       gdhfill());
/* 334 */     this.srcOutputText.setText(getSrcOutput());
/* 335 */     GuiHelper.createSwordLabel(generatorGroup, 0, "默认路径：");
/* 336 */     this.standardOutputText = GuiHelper.createSwordText(generatorGroup, 2048, 
/* 337 */       gdhfill());
/* 338 */     this.standardOutputText.setText(getStandardOutput());
/*     */ 
/* 341 */     GuiHelper.createSwordLabel(generatorGroup, 0, "ORM类型设置：");
/* 342 */     GuiHelper.createSwordLabel(generatorGroup, 0, getOrmType());
/*     */ 
/* 344 */     GuiHelper.createSwordLabel(generatorGroup, 0, "WEB类型设置：");
/* 345 */     GuiHelper.createSwordLabel(generatorGroup, 0, getViewType());
/*     */ 
/* 347 */     GuiHelper.createSwordLabel(generatorGroup, 0, " 页面框架设置：");
/* 348 */     GuiHelper.createSwordLabel(generatorGroup, 0, getPageFrameType());
/*     */ 
/* 359 */     return parent;
/*     */   }
/*     */ 
/*     */   public void widgetDefaultSelected(SelectionEvent e)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void widgetSelected(SelectionEvent e) {
/* 367 */     if (e.getSource().equals(this.dbtypeCombo))
/*     */     {
/* 369 */       this.driverTxt.setText(this.driverstr[this.dbtypeCombo.getSelectionIndex()]);
/*     */ 
/* 371 */       this.urlTxt.setText(this.urlstr[this.dbtypeCombo.getSelectionIndex()]);
/* 372 */       this.dialectTxt.setText(DataBaseHelper.getDialect(getOrmType())[this.dbtypeCombo.getSelectionIndex()]);
/* 373 */       this.testsql = this.testsqlstr[this.dbtypeCombo.getSelectionIndex()];
/*     */     }
/*     */ 
/* 381 */     if (e.getSource().equals(this.testbt))
/* 382 */       testConn(this.driverTxt.getText(), this.urlTxt.getText(), this.nameTxt
/* 383 */         .getText(), this.pwdTxt.getText());
/*     */   }
/*     */ 
/*     */   private boolean testConn(String driver, String url, String name, String pwd)
/*     */   {
/* 390 */     if (DbUtil.canConncet(driver, url, name, pwd)) {
/* 391 */       setMessage("连接成功。");
/* 392 */       setErrorMessage(null);
/* 393 */       this.initBtn.setEnabled(true);
/* 394 */       return true;
/*     */     }
/* 396 */     setErrorMessage("连接失败，请检测输入数据或数据库状态。");
/* 397 */     return false;
/*     */   }
/*     */ 
/*     */   public String getDbtype()
/*     */   {
/* 403 */     return this.dbtype;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/* 407 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setDbtype(String dbtype) {
/* 411 */     this.dbtype = dbtype;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/* 415 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public void setDialect(String dialect) {
/* 419 */     this.dialect = dialect;
/*     */   }
/*     */ 
/*     */   public String getDriver() {
/* 423 */     return this.driver;
/*     */   }
/*     */ 
/*     */   public String getUsername() {
/* 427 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username) {
/* 431 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/* 435 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/* 439 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getDialect() {
/* 443 */     return this.dialect;
/*     */   }
/*     */ 
/*     */   protected static GridData gdhfill() {
/* 447 */     return new GridData(768);
/*     */   }
/*     */ 
/*     */   public String getPageFrameType() {
/* 451 */     return this.pageFrameType;
/*     */   }
/*     */ 
/*     */   public void setPageFrameType(String pageFrameType) {
/* 455 */     this.pageFrameType = pageFrameType;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.propertypage.HiPropertyPage
 * JD-Core Version:    0.6.0
 */