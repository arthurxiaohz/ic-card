/*     */ package org.hi.studio.core.utils;
/*     */ 
/*     */ import freemarker.template.Configuration;
/*     */ import freemarker.template.Template;
/*     */ import freemarker.template.TemplateException;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IResource;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IAdaptable;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.core.runtime.IProgressMonitor;
/*     */ import org.eclipse.jface.viewers.ISelection;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.ui.IEditorPart;
/*     */ import org.eclipse.ui.IWorkbench;
/*     */ import org.eclipse.ui.IWorkbenchPage;
/*     */ import org.eclipse.ui.IWorkbenchPart;
/*     */ import org.eclipse.ui.IWorkbenchWindow;
/*     */ import org.eclipse.wst.common.componentcore.ComponentCore;
/*     */ import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
/*     */ import org.eclipse.wst.common.componentcore.resources.IVirtualFolder;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.plugin.HiCorePlugin;
/*     */ import org.hi.studio.core.template.FreemarkerTempalte;
/*     */ import org.hi.studio.core.template.TemplateHelp;
/*     */ 
/*     */ public class HiProjectUtil
/*     */ {
/*  43 */   static IProject currentProject = null;
/*     */ 
/*     */   public static void refreshWorkspace()
/*     */   {
/*     */     try {
/*  48 */       ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
/*  49 */         2, null);
/*     */     } catch (Exception e) {
/*  51 */       ExceptionManager.logError(e, "Refresh the project ");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void populateHiProject(IProject pj, IProgressMonitor monitor, String ormType, String viewType, String pageFrameType, String dbType)
/*     */   {
/*  60 */     monitor.beginTask("", 2);
/*     */ 
/*  62 */     IFolder webFolder = getWebContentDir(pj);
/*     */     try
/*     */     {
/*  65 */       monitor.worked(1);
/*     */ 
/*  67 */       String source = HiCorePlugin.getCurrentPluginDirectory() + 
/*  68 */         "/resource/hiproject";
/*     */ 
/*  71 */       String prjDest = pj.getLocation().toOSString();
/*     */ 
/*  73 */       FileUtil.copyDirectory(source, prjDest);
/*     */ 
/*  82 */       source = HiCorePlugin.getCurrentPluginDirectory() + "/resource/" + pageFrameType.toLowerCase() + "_web";
/*  83 */       String webDest = pj.getLocation().toOSString() + "/" + webFolder.getName();
/*     */ 
/*  86 */       FileUtil.copyDirectory(source, webDest);
/*     */ 
/*  90 */       String srcDest = prjDest + "/src";
/*     */ 
/*  92 */       String viewSource = "";
/*  93 */       String integrationSource = "";
/*     */ 
/*  98 */       Map valueMap = new HashMap();
/*  99 */       valueMap.put("ormType", ormType);
/* 100 */       valueMap.put("pageFrameType", pageFrameType);
/* 101 */       valueMap.put("viewType", viewType);
/* 102 */       TemplateHelp template = new FreemarkerTempalte();
/* 103 */       template.setMap(valueMap);
/*     */ 
/* 105 */       viewSource = HiCorePlugin.getCurrentPluginDirectory() + "/resource/diff/src/" + viewType.toLowerCase();
/* 106 */       template.setTemplateDir(viewSource);
/* 107 */       TemplateUtil.batchGenerator(template, viewSource, srcDest);
/*     */ 
/* 111 */       integrationSource = HiCorePlugin.getCurrentPluginDirectory() + "/resource/diff/web/" + ormType.toLowerCase();
/* 112 */       FileUtil.copyDirectory(integrationSource, webDest);
/*     */ 
/* 114 */       String configTemplateDir = HiCorePlugin.getCurrentPluginDirectory() + "/resource/hiconfig";
/* 115 */       template.setTemplateDir(configTemplateDir);
/*     */ 
/* 117 */       FileWriter configWriter = new FileWriter(new File(srcDest + "/hiFrameworkConfig.properties"));
/* 118 */       template.process("hiFrameworkConfig.ftl", configWriter);
/*     */ 
/* 121 */       FileWriter mainWriter = new FileWriter(new File(webDest + "/includes/main.jsp"));
/* 122 */       template.process("main.ftl", mainWriter);
/*     */ 
/* 124 */       FileWriter webWriter = new FileWriter(new File(webDest + "/WEB-INF/web.xml"));
/* 125 */       template.process("web.ftl", webWriter);
/*     */ 
/* 128 */       String baseDir = HiCorePlugin.getCurrentPluginDirectory();
/* 129 */       String commonJar = baseDir + "/resource/jar/common";
/* 130 */       String jarLib = webDest + "/WEB-INF/lib";
/* 131 */       FileUtil.copyDirectory(commonJar, jarLib);
/* 132 */       String viewTypeJar = baseDir + "/resource/jar/" + viewType.toLowerCase();
/* 133 */       FileUtil.copyDirectory(viewTypeJar, jarLib);
/* 134 */       String ormTypeJar = baseDir + "/resource/jar/" + ormType.toLowerCase();
/* 135 */       FileUtil.copyDirectory(ormTypeJar, jarLib);
/* 136 */       String dbTypeJar = baseDir + "/resource/jar/" + dbType.toLowerCase();
/* 137 */       FileUtil.copyDirectory(dbTypeJar, jarLib);
/*     */ 
/* 139 */       IFolder hiFolder = pj.getFolder(".hi");
/* 140 */       hiFolder.create(true, true, null);
/*     */ 
/* 143 */       refreshWorkspace();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       ExceptionManager.logError(e, 
/* 149 */         "HiCoreFacetInstallDelegate.execute error");
/*     */     } finally {
/* 151 */       monitor.done();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static IFolder getWebContentDir(IProject pj)
/*     */   {
/* 160 */     IVirtualComponent vc = ComponentCore.createComponent(pj);
/* 161 */     return (IFolder)vc.getRootFolder().getUnderlyingFolder();
/*     */   }
/*     */ 
/*     */   public static String getRsourceFolder()
/*     */   {
/* 168 */     return "";
/*     */   }
/*     */ 
/*     */   public static IProject getCurrentProject()
/*     */   {
/* 176 */     getStandardDisplay().syncExec(new Runnable()
/*     */     {
/*     */       public void run() {
/* 179 */         IWorkbenchPart part = HiProjectUtil.getActivePage().getActivePart();
/* 180 */         Object selection = null;
/* 181 */         if ((part instanceof IEditorPart))
/* 182 */           selection = ((IEditorPart)part).getEditorInput();
/*     */         else {
/* 184 */           selection = HiProjectUtil.getCurrentSelection().getFirstElement();
/*     */         }
/* 186 */         if (selection == null) {
/* 187 */           return;
/*     */         }
/* 189 */         if (!(selection instanceof IAdaptable)) {
/* 190 */           return;
/*     */         }
/* 192 */         IResource resource = (IResource)((IAdaptable)selection)
/* 193 */           .getAdapter(IResource.class);
/* 194 */         if (resource == null) {
/* 195 */           return;
/*     */         }
/* 197 */         HiProjectUtil.currentProject = resource.getProject();
/*     */       }
/*     */     });
/* 201 */     return currentProject;
/*     */   }
/*     */ 
/*     */   public static Display getStandardDisplay() {
/* 205 */     Display display = Display.getCurrent();
/* 206 */     if (display == null)
/* 207 */       display = Display.getDefault();
/* 208 */     return display;
/*     */   }
/*     */ 
/*     */   public static IWorkbenchPage getActivePage() {
/* 212 */     IWorkbenchWindow window = HiCorePlugin.getDefault().getWorkbench()
/* 213 */       .getActiveWorkbenchWindow();
/*     */ 
/* 215 */     IWorkbenchPage page = null;
/* 216 */     if (window != null) {
/* 217 */       page = window.getActivePage();
/*     */     }
/*     */ 
/* 220 */     return page;
/*     */   }
/*     */ 
/*     */   public static IStructuredSelection getCurrentSelection()
/*     */   {
/* 228 */     ISelection sel = getActivePage().getSelection();
/* 229 */     if ((sel != null) && ((sel instanceof IStructuredSelection))) {
/* 230 */       return (IStructuredSelection)sel;
/*     */     }
/* 232 */     return null;
/*     */   }
/*     */ 
/*     */   public static void generateConnectionPropertiese(String webPath, String driverClass, String url, String username, String password, String dialect, String testsql)
/*     */   {
/*     */     try
/*     */     {
/* 244 */       Properties prop = new Properties();
/* 245 */       String fileName = webPath + "/WEB-INF/config/hiconnection.properties";
/*     */ 
/* 247 */       FileOutputStream outStream = new FileOutputStream(fileName);
/* 248 */       prop.setProperty("connection.driver_class", driverClass);
/* 249 */       prop.setProperty("connection.url", url);
/* 250 */       prop.setProperty("connection.username", username);
/* 251 */       prop.setProperty("connection.password", password);
/* 252 */       prop.setProperty("connection.dialect", dialect);
/* 253 */       prop.setProperty("connection.testsql", testsql);
/*     */ 
/* 255 */       prop.store(outStream, "hiconnection.properties");
/* 256 */       outStream.close();
/*     */     } catch (Exception e) {
/* 258 */       ExceptionManager.logError(e, "generate hiconnection.properties errror");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String getPropertyByKey(String webPath, String key)
/*     */   {
/* 267 */     String resultStr = "";
/*     */     try
/*     */     {
/* 270 */       String fileName = webPath + "/WEB-INF/config/hiconnection.properties";
/*     */ 
/* 272 */       FileInputStream inStream = new FileInputStream(fileName);
/* 273 */       Properties prop = new Properties();
/* 274 */       prop.load(inStream);
/* 275 */       if (prop.get(key) != null) {
/* 276 */         resultStr = (String)prop.get(key);
/*     */       }
/* 278 */       inStream.close();
/*     */     } catch (IOException e) {
/* 280 */       ExceptionManager.logError(e, "");
/*     */     }
/*     */ 
/* 283 */     return resultStr;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 287 */     Map valueMap = new HashMap();
/* 288 */     valueMap.put("ormType", "hibernate");
/* 289 */     valueMap.put("pageFrameType", "dwz");
/* 290 */     valueMap.put("viewType", "struts");
/*     */     try
/*     */     {
/* 295 */       Configuration config = new Configuration();
/* 296 */       config.setDirectoryForTemplateLoading(new File("/"));
/* 297 */       config.setDefaultEncoding("UTF-8");
/* 298 */       Template template = config.getTemplate("hiFrameworkConfig.ftl");
/* 299 */       FileWriter writer = new FileWriter(new File("D:\\hiFrameworkConfig2.properties"));
/* 300 */       template.process(valueMap, writer);
/* 301 */       writer.close();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 305 */       e.printStackTrace();
/*     */     }
/*     */     catch (TemplateException e) {
/* 308 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.utils.HiProjectUtil
 * JD-Core Version:    0.6.0
 */