/*     */ package org.hi.studio.project.wizard;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Map;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.core.runtime.IProgressMonitor;
/*     */ import org.eclipse.core.runtime.Path;
/*     */ import org.eclipse.jface.wizard.IWizardPage;
/*     */ import org.eclipse.jst.common.project.facet.core.JavaFacetInstallConfig;
/*     */ import org.eclipse.jst.servlet.ui.project.facet.WebProjectWizard;
/*     */ import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
/*     */ import org.eclipse.wst.common.frameworks.internal.datamodel.DataModelImpl;
/*     */ import org.eclipse.wst.common.project.facet.core.IFacetedProject;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Connection;
/*     */ import org.hi.metadata.hsc.context.environment.Database;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.project.view.HiProjectView;
/*     */ 
/*     */ public class NewHiProjectWizard extends WebProjectWizard
/*     */ {
/*  27 */   final String SOURCE_PATH = "WEB-INF/classes";
/*     */ 
/*     */   public NewHiProjectWizard()
/*     */   {
/*  31 */     setWindowTitle("HI工程创建向导");
/*     */ 
/*  33 */     Map map = (Map)this.model
/*  34 */       .getProperty("IFacetProjectCreationDataModelProperties.FACET_DM_MAP");
/*  35 */     if (map != null)
/*     */     {
/*  37 */       DataModelImpl webImpl = (DataModelImpl)map.get("jst.web");
/*     */ 
/*  39 */       webImpl.setStringProperty(
/*  40 */         "IJ2EEFacetInstallDataModelProperties.CONFIG_FOLDER", "web");
/*     */     }
/*     */   }
/*     */ 
/*     */   public NewHiProjectWizard(IDataModel model) {
/*  45 */     super(model);
/*     */   }
/*     */ 
/*     */   protected IWizardPage createFirstPage()
/*     */   {
/*  50 */     return new NewHiFirstPage(this.model, "first.page");
/*     */   }
/*     */ 
/*     */   public boolean performFinish()
/*     */   {
/*  55 */     Map map = (Map)this.model
/*  56 */       .getProperty("IFacetProjectCreationDataModelProperties.FACET_DM_MAP");
/*  57 */     if (map != null)
/*     */     {
/*  59 */       DataModelImpl webImpl = (DataModelImpl)map.get("jst.web");
/*  60 */       String webContentName = webImpl.getStringProperty("IJ2EEFacetInstallDataModelProperties.CONFIG_FOLDER");
/*     */ 
/*  63 */       DataModelImpl impl = (DataModelImpl)map.get("jst.java");
/*  64 */       if (impl != null)
/*     */       {
/*  68 */         JavaFacetInstallConfig config = (JavaFacetInstallConfig)impl
/*  69 */           .getProperty("IJavaFacetInstallDataModelProperties.JAVA_FACET_INSTALL_CONFIG");
/*     */ 
/*  71 */         config.setDefaultOutputFolder(
/*  72 */           new Path(webContentName + 
/*  72 */           File.separator + "WEB-INF/classes"));
/*  73 */         impl.setProperty(
/*  74 */           "IJavaFacetInstallDataModelProperties.JAVA_FACET_INSTALL_CONFIG", 
/*  75 */           config);
/*  76 */         map.put("jst.java", impl);
/*     */       }
/*     */     }
/*     */ 
/*  80 */     this.model.setProperty(
/*  81 */       "IFacetProjectCreationDataModelProperties.FACET_DM_MAP", map);
/*  82 */     return super.performFinish();
/*     */   }
/*     */ 
/*     */   protected void performFinish(IProgressMonitor monitor)
/*     */     throws CoreException
/*     */   {
/*  88 */     super.performFinish(monitor);
/*     */ 
/*  90 */     NewHiFirstPage firstPage = (NewHiFirstPage)getPage("first.page");
/*     */ 
/*  92 */     String ormType = firstPage.getOrmType();
/*  93 */     String viewType = firstPage.getViewType();
/*  94 */     String pageFrameType = firstPage.getPageFrameType();
/*     */ 
/*  97 */     HiProjectUtil.populateHiProject(getFacetedProject().getProject(), monitor, ormType, viewType, pageFrameType, firstPage.getDbtype());
/*     */ 
/* 100 */     IFolder webFolder = HiProjectUtil.getWebContentDir(getFacetedProject().getProject());
/* 101 */     String webPath = webFolder.getLocation().toString();
/* 102 */     String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */     try
/*     */     {
/* 109 */       String driverClass = firstPage.getDriver();
/* 110 */       String url = firstPage.getUrl();
/* 111 */       String username = firstPage.getUsername();
/* 112 */       String password = firstPage.getPwd();
/* 113 */       String dialect = firstPage.getDialect();
/* 114 */       String packageName = firstPage.getPackageName();
/* 115 */       String testsql = firstPage.getTestsql();
/*     */ 
/* 118 */       Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/*     */ 
/* 122 */       env.getGenerate().setOrmType(firstPage.getOrmType());
/* 123 */       env.getGenerate().setViewType(firstPage.getViewType());
/* 124 */       env.getGenerate().setPageFrameType(firstPage.getPageFrameType());
/*     */ 
/* 127 */       env.getDatabase().setDbtype(firstPage.getDbtype());
/* 128 */       env.getDatabase().getConnection().setDriverClass(driverClass);
/* 129 */       env.getDatabase().getConnection().setPassword(password);
/* 130 */       env.getDatabase().getConnection().setUrl(url);
/* 131 */       env.getDatabase().getConnection().setUsername(username);
/* 132 */       env.getGenerate().setOrgPackage(packageName);
/*     */ 
/* 135 */       String servicePath = webFolder.getName() + "/WEB-INF/metadata";
/* 136 */       env.setDir(servicePath);
/*     */ 
/* 138 */       Generate generate = env.getGenerate();
/* 139 */       getFacetedProject().getProject().getLocation().toString();
/*     */ 
/* 141 */       generate.setSrcOutput("src");
/*     */ 
/* 143 */       generate.setStandardOutput(webFolder.getName());
/*     */ 
/* 145 */       generate.setTempletDir("templates");
/*     */ 
/* 147 */       EnvironmentFactory.writeEnvironmentXML(environmentFile, env);
/* 148 */       HiProjectUtil.generateConnectionPropertiese(webPath, driverClass, url, username, password, dialect, testsql);
/*     */     }
/*     */     catch (Exception e) {
/* 151 */       ExceptionManager.logError(e, "");
/*     */     }
/*     */ 
/* 155 */     HiProjectUtil.refreshWorkspace();
/* 156 */     HiProjectView.getInstance(); HiProjectView.refresh();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.wizard.NewHiProjectWizard
 * JD-Core Version:    0.6.0
 */