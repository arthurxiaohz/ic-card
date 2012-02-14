/*     */ package org.hi.studio.project.wizard;
/*     */ 
/*     */ import org.eclipse.jst.servlet.ui.project.facet.WebProjectFirstPage;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
/*     */ import org.hi.studio.core.utils.ImageUtil;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.hi.studio.project.base.DataBaseHelper;
/*     */ import org.hi.studio.project.dialog.DbDialog;
/*     */ import org.hi.studio.project.dialog.ImageDialog;
/*     */ import org.hi.studio.project.utils.GuiHelper;
/*     */ 
/*     */ public class NewHiFirstPage extends WebProjectFirstPage
/*     */ {
/*  29 */   private String dbtype = "MSSQL";
/*  30 */   private String dialect = "";
/*  31 */   private String driver = "";
/*  32 */   private String username = "";
/*  33 */   private String pwd = "";
/*  34 */   private String url = "";
/*  35 */   private String testsql = "";
/*  36 */   private String packageName = "org.hi";
/*  37 */   private String authorName = "";
/*     */ 
/*  40 */   private String ormType = "";
/*  41 */   private String viewType = "";
/*     */ 
/*  43 */   private String pageFrameType = "";
/*     */   private Text packageText;
/*     */   private Text authorText;
/*  70 */   private Combo generatorOrmCombo = null; private Combo generatorWebCombo = null;
/*     */ 
/*  72 */   private Combo pageTypeCombo = null;
/*     */ 
/*  74 */   private String[] ormTypeStr = DataBaseHelper.ORMTYPESTR;
/*  75 */   private String[] webTypeViewStr = DataBaseHelper.WEBTYPEVIEWSTR;
/*  76 */   private String[] webTypeStr = DataBaseHelper.WEBTYPESTR;
/*  77 */   private String[] pageTypeViewStr = DataBaseHelper.PAGETYPEVIEWSTR;
/*  78 */   private String[] pageTypeStr = DataBaseHelper.PAGETYPESTR;
/*     */   private Image image;
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
/*     */   public String getViewType()
/*     */   {
/*  58 */     return this.viewType;
/*     */   }
/*     */ 
/*     */   public void setViewType(String viewType) {
/*  62 */     this.viewType = viewType;
/*     */   }
/*     */ 
/*     */   public String getPackageName()
/*     */   {
/*  82 */     return this.packageName;
/*     */   }
/*     */ 
/*     */   public void setPackageName(String packageName) {
/*  86 */     this.packageName = packageName;
/*     */   }
/*     */ 
/*     */   public String getAuthorName() {
/*  90 */     return this.authorName;
/*     */   }
/*     */ 
/*     */   public void setAuthorName(String authorName) {
/*  94 */     this.authorName = authorName;
/*     */   }
/*     */ 
/*     */   public NewHiFirstPage(IDataModel model, String pageName) {
/*  98 */     super(model, pageName);
/*  99 */     setTitle("创建HI工程");
/* 100 */     setDescription("HI工程描述");
/*     */   }
/*     */ 
/*     */   protected void createProjectGroup(Composite parent)
/*     */   {
/* 105 */     super.createProjectGroup(parent);
/*     */ 
/* 107 */     Group hiGroup = new Group(parent, 0);
/* 108 */     hiGroup.setLayout(new GridLayout(5, false));
/* 109 */     hiGroup.setText("hi工程信息");
/* 110 */     hiGroup.setLayoutData(new GridData(768));
/*     */ 
/* 113 */     Label authorLabel = new Label(hiGroup, 0);
/* 114 */     authorLabel.setText("作者:");
/* 115 */     this.authorText = GuiHelper.createSwordText(hiGroup, 2048, new GridData(768));
/* 116 */     this.authorText.setText(System.getProperty("user.name"));
/* 117 */     this.authorText.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e)
/*     */       {
/* 121 */         NewHiFirstPage.this.setAuthorName(NewHiFirstPage.this.authorText.getText());
/*     */       }
/*     */     });
/* 126 */     Label authorCom = new Label(hiGroup, 0);
/* 127 */     authorCom.setText("包名:");
/* 128 */     this.packageText = GuiHelper.createSwordText(hiGroup, 2048, new GridData(768));
/* 129 */     this.packageText.setText(this.packageName);
/* 130 */     this.packageText.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e)
/*     */       {
/* 134 */         if (StringUtil.isErrorPackage(NewHiFirstPage.this.packageText.getText())) {
/* 135 */           NewHiFirstPage.this.setErrorMessage("包名有误");
/*     */         } else {
/* 137 */           NewHiFirstPage.this.setPackageName(NewHiFirstPage.this.packageText.getText());
/* 138 */           NewHiFirstPage.this.setErrorMessage(null);
/*     */         }
/*     */       }
/*     */     });
/* 143 */     new Label(hiGroup, 0);
/*     */ 
/* 147 */     GuiHelper.createSwordLabel(hiGroup, 0, "ORM设置：");
/* 148 */     this.generatorOrmCombo = GuiHelper.createSwordCombo(hiGroup, 2056, 
/* 149 */       gdhfill(), null);
/* 150 */     this.generatorOrmCombo.setItems(this.ormTypeStr);
/*     */ 
/* 153 */     this.generatorOrmCombo.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e)
/*     */       {
/* 157 */         NewHiFirstPage.this.setOrmType(NewHiFirstPage.this.generatorOrmCombo.getText());
/*     */       }
/*     */     });
/* 163 */     this.generatorOrmCombo.setText(this.ormTypeStr[0]);
/*     */ 
/* 165 */     GuiHelper.createSwordLabel(hiGroup, 0, "表现层设置：");
/* 166 */     this.generatorWebCombo = GuiHelper.createSwordCombo(hiGroup, 2056, 
/* 167 */       gdhfill(), null);
/* 168 */     this.generatorWebCombo.setItems(this.webTypeViewStr);
/*     */ 
/* 170 */     this.generatorWebCombo.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e)
/*     */       {
/* 175 */         NewHiFirstPage.this.setViewType(NewHiFirstPage.this.webTypeStr[NewHiFirstPage.this.generatorWebCombo.getSelectionIndex()]);
/*     */       }
/*     */     });
/* 179 */     this.generatorWebCombo.setText(this.webTypeViewStr[0]);
/*     */ 
/* 182 */     new Label(hiGroup, 0);
/* 183 */     Label frameLabel = new Label(hiGroup, 0);
/* 184 */     frameLabel.setText("页面框架：");
/*     */ 
/* 186 */     this.pageTypeCombo = GuiHelper.createSwordCombo(hiGroup, 2056, 
/* 187 */       gdhfill(), null);
/* 188 */     this.pageTypeCombo.setItems(this.pageTypeViewStr);
/*     */ 
/* 191 */     this.pageTypeCombo.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e)
/*     */       {
/* 195 */         NewHiFirstPage.this.setPageFrameType(NewHiFirstPage.this.pageTypeStr[NewHiFirstPage.this.pageTypeCombo.getSelectionIndex()]);
/*     */ 
/* 197 */         if (NewHiFirstPage.this.pageTypeStr[NewHiFirstPage.this.pageTypeCombo.getSelectionIndex()].equals("classic"))
/* 198 */           NewHiFirstPage.this.image = ImageUtil.getInstance().getImage("icons/classic.jpg");
/*     */         else
/* 200 */           NewHiFirstPage.this.image = ImageUtil.getInstance().getImage("icons/dwz.jpg");
/*     */       }
/*     */     });
/* 205 */     this.pageTypeCombo.setText(this.pageTypeViewStr[0]);
/*     */ 
/* 207 */     Button preView = GuiHelper.createSwordButton(hiGroup, 0, 
/* 208 */       "预览", null);
/* 209 */     preView.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 212 */         ImageDialog imageDialog = new ImageDialog(null, NewHiFirstPage.this.image);
/* 213 */         imageDialog.open();
/*     */       }
/*     */     });
/* 218 */     new Label(hiGroup, 0);
/* 219 */     Button dbcfg = GuiHelper.createSwordButton(hiGroup, 0, 
/* 220 */       "设置数据库连接", null);
/* 221 */     dbcfg.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 224 */         DbDialog dialog = new DbDialog(null);
/* 225 */         dialog.setDbtype(NewHiFirstPage.this.dbtype);
/* 226 */         dialog.setDialect(NewHiFirstPage.this.dialect);
/* 227 */         dialog.setDriver(NewHiFirstPage.this.driver);
/* 228 */         dialog.setName(NewHiFirstPage.this.username);
/* 229 */         dialog.setPwd(NewHiFirstPage.this.pwd);
/* 230 */         dialog.setUrl(NewHiFirstPage.this.url);
/* 231 */         dialog.setOrmType(NewHiFirstPage.this.ormType);
/*     */ 
/* 234 */         dialog.open();
/* 235 */         NewHiFirstPage.this.dbtype = dialog.getDbtype();
/* 236 */         NewHiFirstPage.this.dialect = dialog.getDialect();
/* 237 */         NewHiFirstPage.this.driver = dialog.getDriver();
/* 238 */         NewHiFirstPage.this.username = dialog.getName();
/* 239 */         NewHiFirstPage.this.pwd = dialog.getPwd();
/* 240 */         NewHiFirstPage.this.url = dialog.getUrl();
/* 241 */         NewHiFirstPage.this.testsql = dialog.getTestsql();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public String getDbtype()
/*     */   {
/* 249 */     return this.dbtype;
/*     */   }
/*     */ 
/*     */   public void setDbtype(String dbtype) {
/* 253 */     this.dbtype = dbtype;
/*     */   }
/*     */ 
/*     */   public String getDialect() {
/* 257 */     return this.dialect;
/*     */   }
/*     */ 
/*     */   public void setDialect(String dialect) {
/* 261 */     this.dialect = dialect;
/*     */   }
/*     */ 
/*     */   public String getDriver() {
/* 265 */     return this.driver;
/*     */   }
/*     */ 
/*     */   public void setDriver(String driver) {
/* 269 */     this.driver = driver;
/*     */   }
/*     */ 
/*     */   public String getUsername() {
/* 273 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username) {
/* 277 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public String getPwd() {
/* 281 */     return this.pwd;
/*     */   }
/*     */ 
/*     */   public void setPwd(String pwd) {
/* 285 */     this.pwd = pwd;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/* 289 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/* 293 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public String getPageFrameType() {
/* 297 */     return this.pageFrameType;
/*     */   }
/*     */ 
/*     */   public void setPageFrameType(String pageFrameType) {
/* 301 */     this.pageFrameType = pageFrameType;
/*     */   }
/*     */ 
/*     */   public String getTestsql() {
/* 305 */     return this.testsql;
/*     */   }
/*     */ 
/*     */   public void setTestsql(String testsql) {
/* 309 */     this.testsql = testsql;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.wizard.NewHiFirstPage
 * JD-Core Version:    0.6.0
 */