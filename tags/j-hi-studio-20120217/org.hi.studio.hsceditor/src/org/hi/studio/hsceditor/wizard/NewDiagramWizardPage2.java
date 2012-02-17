/*     */ package org.hi.studio.hsceditor.wizard;
/*     */ 
/*     */ import java.net.URL;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.ResourceBundle;
/*     */ import org.eclipse.jface.wizard.WizardPage;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.FileDialog;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.MessageBox;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*     */ import org.hi.studio.hsceditor.dialect.IDialect;
/*     */ import org.hi.studio.hsceditor.dialect.ISchemaLoader;
/*     */ import org.hi.studio.hsceditor.util.DatabaseInfo;
/*     */ import org.hi.studio.hsceditor.util.JarClassLoader;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ 
/*     */ public class NewDiagramWizardPage2 extends WizardPage
/*     */ {
/*     */   private JarClassLoader classLoader;
/*     */   private DatabaseInfo dbinfo;
/*     */   private Button view;
/*     */   private Text jarFile;
/*     */   private Combo driver;
/*     */   private org.eclipse.swt.widgets.List list;
/*     */   private Text catalog;
/*     */   private Text schema;
/*     */   private Text password;
/*     */   private Text user;
/*     */   private Text databaseURI;
/*  49 */   private URL[] classpathes = new URL[0];
/*  50 */   private ResourceBundle url = ResourceBundle.getBundle("org.hi.studio.hsceditor.wizard.databaseURI");
/*     */   private Text filter;
/*  53 */   private ArrayList<String> tableNames = new ArrayList();
/*     */   private RootModel model;
/*     */ 
/*     */   public NewDiagramWizardPage2()
/*     */   {
/*  58 */     this(null);
/*     */   }
/*     */ 
/*     */   public NewDiagramWizardPage2(RootModel model) {
/*  62 */     super(DBPlugin.getResourceString("wizard.new.import.title"));
/*  63 */     setTitle(DBPlugin.getResourceString("wizard.new.import.title"));
/*  64 */     setMessage(DBPlugin.getResourceString("wizard.new.import.message"));
/*  65 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public void createControl(Composite parent)
/*     */   {
/*  70 */     Composite container = new Composite(parent, 0);
/*  71 */     GridLayout layout = new GridLayout();
/*  72 */     layout.numColumns = 3;
/*  73 */     container.setLayout(layout);
/*  74 */     container.setLayoutData(new GridData(1808));
/*     */ 
/*  76 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.jarFile"), false);
/*     */ 
/*  78 */     this.jarFile = new Text(container, 2052);
/*  79 */     this.jarFile.setEditable(false);
/*  80 */     this.jarFile.setLayoutData(new GridData(768));
/*     */ 
/*  82 */     Button button = new Button(container, 8);
/*  83 */     button.setText(DBPlugin.getResourceString("button.browse"));
/*  84 */     button.addSelectionListener(new SelectionAdapter() {
/*     */       public void widgetSelected(SelectionEvent e) {
/*  86 */         NewDiagramWizardPage2.this.handleBrowse();
/*     */       }
/*     */     });
/*  90 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.driver"), false);
/*     */ 
/*  92 */     this.driver = new Combo(container, 8);
/*  93 */     this.driver.setLayoutData(new GridData(768));
/*  94 */     this.driver.addModifyListener(new ModifyListener() {
/*     */       public void modifyText(ModifyEvent e) {
/*  96 */         if (Collections.list(NewDiagramWizardPage2.this.url.getKeys()).contains(NewDiagramWizardPage2.this.driver.getText())) {
/*  97 */           String template = NewDiagramWizardPage2.this.url.getString(NewDiagramWizardPage2.this.driver.getText());
/*  98 */           NewDiagramWizardPage2.this.databaseURI.setText(template);
/*     */         }
/*     */       }
/*     */     });
/* 102 */     this.driver.add("sun.jdbc.odbc.JdbcOdbc");
/* 103 */     this.driver.select(0);
/*     */ 
/* 105 */     new Label(container, 0);
/*     */ 
/* 107 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.uri"), false);
/*     */ 
/* 109 */     this.databaseURI = new Text(container, 2052);
/* 110 */     this.databaseURI.setLayoutData(new GridData(768));
/* 111 */     new Label(container, 0);
/*     */ 
/* 113 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.user"), false);
/*     */ 
/* 115 */     this.user = new Text(container, 2052);
/* 116 */     this.user.setLayoutData(new GridData(768));
/* 117 */     new Label(container, 0);
/*     */ 
/* 119 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.pass"), false);
/*     */ 
/* 121 */     this.password = new Text(container, 4196352);
/* 122 */     this.password.setLayoutData(new GridData(768));
/* 123 */     new Label(container, 0);
/*     */ 
/* 125 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.schema"), false);
/*     */ 
/* 127 */     this.schema = new Text(container, 2052);
/* 128 */     this.schema.setLayoutData(new GridData(768));
/* 129 */     new Label(container, 0);
/*     */ 
/* 131 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.catalog"), false);
/*     */ 
/* 133 */     this.catalog = new Text(container, 2052);
/* 134 */     this.catalog.setLayoutData(new GridData(768));
/*     */ 
/* 136 */     new Label(container, 0);
/*     */ 
/* 138 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.view"), false);
/* 139 */     this.view = new Button(container, 32);
/* 140 */     new Label(container, 0);
/*     */ 
/* 142 */     new Label(container, 0);
/* 143 */     Button load = new Button(container, 8);
/* 144 */     load.setText(DBPlugin.getResourceString("wizard.new.import.loadTables"));
/* 145 */     load.addSelectionListener(new SelectionAdapter() {
/*     */       public void widgetSelected(SelectionEvent e) {
/*     */         try {
/* 148 */           NewDiagramWizardPage2.this.loadTables();
/*     */         } catch (Exception ex) {
/* 150 */           ex.printStackTrace();
/* 151 */           MessageBox msg = new MessageBox(NewDiagramWizardPage2.this.getShell());
/* 152 */           msg.setMessage(ex.getMessage());
/* 153 */           msg.open();
/*     */         }
/*     */       }
/*     */     });
/* 158 */     new Label(container, 0);
/*     */ 
/* 160 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.filter"), false);
/* 161 */     this.filter = new Text(container, 2048);
/* 162 */     this.filter.setLayoutData(new GridData(768));
/* 163 */     this.filter.addModifyListener(new ModifyListener() {
/*     */       public void modifyText(ModifyEvent e) {
/* 165 */         String filterText = NewDiagramWizardPage2.this.filter.getText();
/* 166 */         NewDiagramWizardPage2.this.list.removeAll();
/* 167 */         for (String tableName : NewDiagramWizardPage2.this.tableNames)
/* 168 */           if (tableName.startsWith(filterText))
/* 169 */             NewDiagramWizardPage2.this.list.add(tableName);
/*     */       }
/*     */     });
/* 174 */     new Label(container, 0);
/*     */ 
/* 176 */     UIUtils.createLabel(container, DBPlugin.getResourceString("wizard.new.import.tables"), false);
/* 177 */     this.list = new org.eclipse.swt.widgets.List(container, 2562);
/* 178 */     this.list.setLayoutData(new GridData(1808));
/*     */ 
/* 180 */     if (this.model != null) {
/* 181 */       this.jarFile.setText(this.model.getJarFile());
/* 182 */       loadJdbcDriver();
/* 183 */       this.driver.setText(this.model.getJdbcDriver());
/* 184 */       this.databaseURI.setText(this.model.getJdbcUrl());
/* 185 */       this.user.setText(this.model.getJdbcUser());
/* 186 */       this.password.setText(this.model.getJdbcPassword());
/* 187 */       this.catalog.setText(this.model.getJdbcCatalog());
/* 188 */       this.schema.setText(this.model.getJdbcSchema());
/* 189 */       this.view.setSelection(this.model.isIncludeView());
/*     */     }
/*     */ 
/* 192 */     setControl(container);
/*     */   }
/*     */ 
/*     */   private void loadTables() throws Exception {
/* 196 */     if (this.classLoader != null) {
/* 197 */       Class driverClass = this.classLoader.loadClass(this.driver.getText());
/* 198 */       this.dbinfo = new DatabaseInfo(driverClass);
/* 199 */       this.dbinfo.setURI(this.databaseURI.getText());
/* 200 */       this.dbinfo.setUser(this.user.getText());
/* 201 */       this.dbinfo.setPassword(this.password.getText());
/* 202 */       this.dbinfo.setCatalog(this.catalog.getText());
/* 203 */       this.dbinfo.setSchema(this.schema.getText());
/* 204 */       this.dbinfo.setEnableView(this.view.getSelection());
/*     */ 
/* 206 */       this.list.removeAll();
/* 207 */       this.tableNames.clear();
/* 208 */       this.filter.setText("");
/*     */ 
/* 210 */       for (String tableName : this.dbinfo.loadTables()) {
/* 211 */         this.list.add(tableName);
/* 212 */         this.tableNames.add(tableName);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void loadJdbcDriver() {
/*     */     try {
/* 219 */       URL jarURL = new URL("file:///" + this.jarFile.getText());
/* 220 */       URL[] clspath = new URL[this.classpathes.length + 1];
/* 221 */       clspath[0] = jarURL;
/* 222 */       for (int i = 0; i < this.classpathes.length; i++) {
/* 223 */         clspath[(i + 1)] = this.classpathes[i];
/*     */       }
/* 225 */       this.classLoader = new JarClassLoader(clspath);
/* 226 */       java.util.List list = this.classLoader.getJDBCDriverClass(this.jarFile.getText());
/* 227 */       this.driver.removeAll();
/* 228 */       for (Class item : list)
/*     */       {
/* 230 */         if (Arrays.binarySearch(this.driver.getItems(), item.getName()) < 0) {
/* 231 */           this.driver.add(item.getName());
/*     */         }
/*     */       }
/* 234 */       this.driver.add("sun.jdbc.odbc.JdbcOdbc");
/* 235 */       this.driver.select(0);
/*     */     } catch (Exception e1) {
/* 237 */       DBPlugin.logException(e1);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void handleBrowse()
/*     */   {
/* 245 */     FileDialog dialog = new FileDialog(getShell());
/* 246 */     if (dialog.open() == null) {
/* 247 */       return;
/*     */     }
/* 249 */     this.jarFile.setText(dialog.getFilterPath() + System.getProperty("file.separator") + dialog.getFileName());
/* 250 */     loadJdbcDriver();
/*     */   }
/*     */ 
/*     */   public void importTables(RootModel root) throws SQLException {
/* 254 */     root.setJarFile(this.jarFile.getText());
/* 255 */     root.setJdbcDriver(this.driver.getText());
/* 256 */     root.setJdbcUrl(this.databaseURI.getText());
/* 257 */     root.setJdbcUser(this.user.getText());
/* 258 */     root.setJdbcPassword(this.password.getText());
/* 259 */     root.setJdbcCatalog(this.catalog.getText());
/* 260 */     root.setJdbcSchema(this.schema.getText());
/* 261 */     root.setIncludeView(this.view.getSelection());
/*     */ 
/* 263 */     if (this.list.getSelection().length == 0) {
/* 264 */       return;
/*     */     }
/*     */ 
/* 267 */     IDialect dialect = DialectProvider.getDialect(root.getDialectName());
/* 268 */     ISchemaLoader loader = dialect.getSchemaLoader();
/* 269 */     Connection conn = null;
/*     */     try {
/* 271 */       conn = this.dbinfo.connect();
/* 272 */       loader.loadSchema(root, DialectProvider.getDialect(root.getDialectName()), 
/* 273 */         conn, this.list.getSelection(), this.dbinfo.getCatalog(), this.dbinfo.getSchema());
/*     */     } catch (Exception ex) {
/* 275 */       DBPlugin.logException(ex);
/*     */     } finally {
/* 277 */       if (conn != null)
/* 278 */         conn.close();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.wizard.NewDiagramWizardPage2
 * JD-Core Version:    0.6.0
 */