/*     */ package org.hi.studio.hsceditor.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.hi.generator.ant.EnvironmentTask;
/*     */ import org.hi.generator.ant.HiGeneraterToolTask;
/*     */ import org.hi.metadata.hsc.context.ServiceFactory;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.metadata.hsc.util.ServiceFilenameFilter;
/*     */ import org.hi.studio.core.constants.ImageConstants;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.tree.HiTreeObject;
/*     */ import org.hi.studio.core.tree.HiTreeParent;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.hsceditor.visual.editor.VisualDBSerializer;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class HiServiceRender
/*     */ {
/*     */   public static Map sysServiceInstance;
/*     */ 
/*     */   public static HiTreeParent renderWorkspaceTree()
/*     */   {
/*  52 */     HiTreeParent parent = new HiTreeParent("");
/*     */ 
/*  54 */     IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
/*  55 */     for (int i = 0; i < projects.length; i++) {
/*  56 */       IProject project = projects[i];
/*     */ 
/*  59 */       if (!project.getFolder(".hi").exists()) {
/*     */         continue;
/*     */       }
/*  62 */       Map serviceMap = VisualDBSerializer.parseServiceList(project.getFolder(".hi").getLocation().toOSString());
/*     */ 
/*  64 */       HiTreeParent projectObj = renderServiceTree(project.getName(), serviceMap);
/*  65 */       projectObj.setTreeObj(project);
/*  66 */       projectObj.setImagePath(ImageConstants.IMAGE_PROJECT);
/*     */ 
/*  68 */       parent.addChild(projectObj);
/*     */     }
/*     */ 
/*  73 */     return parent;
/*     */   }
/*     */ 
/*     */   private static HiTreeParent renderServiceTree(String rootName, Map<String, RootModel> serviceMap)
/*     */   {
/*  81 */     HiTreeParent root = new HiTreeParent(rootName);
/*     */ 
/*  84 */     for (Iterator it = serviceMap.keySet().iterator(); it.hasNext(); )
/*     */     {
/*  86 */       String key = (String)it.next();
/*  87 */       RootModel model = (RootModel)serviceMap.get(key);
/*     */ 
/*  89 */       HiTreeParent serviceNode = renderTableTree(model.getPackageName(), model.getChildren());
/*  90 */       serviceNode.setName(key);
/*     */ 
/*  92 */       serviceNode.setImagePath(ImageConstants.IMAGE_SERVICE);
/*     */ 
/*  94 */       serviceNode.setTreeObj(model);
/*     */ 
/*  97 */       root.addChild(serviceNode);
/*     */     }
/*     */ 
/* 100 */     return root;
/*     */   }
/*     */ 
/*     */   private static HiTreeParent renderTableTree(String sercieName, List<AbstractDBEntityModel> tableList)
/*     */   {
/* 108 */     HiTreeParent serviceNode = new HiTreeParent(sercieName);
/*     */ 
/* 110 */     for (Iterator it = tableList.iterator(); it.hasNext(); ) {
/* 111 */       TableModel model = (TableModel)it.next();
/* 112 */       HiTreeParent tableNode = null;
/* 113 */       if ((model instanceof EnumerationModel)) {
/* 114 */         tableNode = new HiTreeParent(((EnumerationModel)model).getEnumName());
/* 115 */         tableNode.setImagePath(ImageConstants.IMAGE_ENUMERATION);
/*     */       } else {
/* 117 */         tableNode = renderColumnTree(model.getLogicalName(), model.getColumns());
/* 118 */         tableNode.setTreeObj(model);
/* 119 */         tableNode.setImagePath(ImageConstants.IMAGE_ENTITY);
/*     */       }
/* 121 */       tableNode.setTreeObj(model);
/*     */ 
/* 124 */       serviceNode.addChild(tableNode);
/*     */     }
/*     */ 
/* 127 */     return serviceNode;
/*     */   }
/*     */ 
/*     */   private static HiTreeParent renderColumnTree(String tableName, ColumnModel[] columns)
/*     */   {
/* 135 */     HiTreeParent tableNode = new HiTreeParent(tableName);
/*     */ 
/* 137 */     for (int i = 0; i < columns.length; i++) {
/* 138 */       ColumnModel model = columns[i];
/* 139 */       HiTreeObject treeObject = new HiTreeObject(model.getColumnName());
/* 140 */       treeObject.setTreeObj(model);
/* 141 */       treeObject.setImagePath(ImageConstants.IMAGE_FIELD);
/*     */ 
/* 144 */       tableNode.addChild(treeObject);
/*     */     }
/*     */ 
/* 147 */     return tableNode;
/*     */   }
/*     */ 
/*     */   public static HiTreeParent renderServiceTree(IProject prj, boolean isEnumeration, boolean isExtend)
/*     */   {
/* 161 */     HiGeneraterToolTask task = new HiGeneraterToolTask();
/* 162 */     String webPath = HiProjectUtil.getWebContentDir(prj).getLocation().toOSString();
/* 163 */     String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/* 165 */     EnvironmentTask environmentTask = task.createEnvironment();
/* 166 */     environmentTask.setEnvironmentFile(environmentFile);
/*     */ 
/* 168 */     HiTreeParent root = null;
/*     */     try
/*     */     {
/* 172 */       root = new HiTreeParent("");
/* 173 */       Map serviceMap = ServiceFactory.loadAllService(task.getEnvironment());
/* 174 */       if (isEnumeration) {
/* 175 */         Map enumMap = ServiceFactory.loadAllEnumeration(task.getEnvironment());
/* 176 */         for (Iterator it = enumMap.keySet().iterator(); it.hasNext(); ) {
/* 177 */           String key = (String)it.next();
/* 178 */           Entity enumEntity = (Entity)enumMap.get(key);
/*     */ 
/* 180 */           HiTreeObject tableNode = new HiTreeObject(enumEntity.getEntityName());
/* 181 */           tableNode.setTreeObj(enumEntity);
/* 182 */           tableNode.setImagePath(ImageConstants.IMAGE_ENUMERATION);
/*     */ 
/* 185 */           root.addChild(tableNode);
/*     */         }
/*     */       }
/*     */       else {
/* 189 */         for (Iterator it = serviceMap.keySet().iterator(); it.hasNext(); )
/*     */         {
/* 191 */           String key = (String)it.next();
/* 192 */           ExceptionManager.logError("key===" + key);
/*     */ 
/* 194 */           Service service = (Service)serviceMap.get(key);
/*     */ 
/* 197 */           HiTreeParent serviceNode = renderServiceTableTree(service.getPackageName(), service.getEntity(), isExtend, serviceMap);
/*     */ 
/* 199 */           serviceNode.setName(key);
/* 200 */           serviceNode.setImagePath(ImageConstants.IMAGE_SERVICE);
/*     */ 
/* 202 */           serviceNode.setTreeObj(service);
/*     */ 
/* 205 */           root.addChild(serviceNode);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 210 */       ExceptionManager.logError(e, "");
/*     */     }
/*     */ 
/* 214 */     return root;
/*     */   }
/*     */ 
/*     */   private static HiTreeParent renderServiceTableTree(String sercieName, List<Entity> tableList, boolean isExtend, Map<String, Service> serviceMap)
/*     */   {
/* 223 */     HiTreeParent serviceNode = new HiTreeParent(sercieName);
/*     */ 
/* 225 */     for (Iterator it = tableList.iterator(); it.hasNext(); ) {
/* 226 */       Entity model = (Entity)it.next();
/*     */ 
/* 230 */       if (model.getEntityType() == 2)
/*     */         continue;
/*     */       HiTreeObject tableNode;
/*     */       HiTreeObject tableNode;
/* 233 */       if (isExtend) {
/* 234 */         tableNode = new HiTreeObject(model.getEntityName());
/*     */       }
/*     */       else {
/* 237 */         model = ServiceTool.getParentEntityByEntity(model, serviceMap);
/*     */ 
/* 239 */         tableNode = renderServiceColumnTree(model.getEntityName(), model.getField());
/*     */       }
/*     */ 
/* 243 */       tableNode.setTreeObj(model);
/* 244 */       tableNode.setImagePath(ImageConstants.IMAGE_ENTITY);
/*     */ 
/* 247 */       serviceNode.addChild(tableNode);
/*     */     }
/*     */ 
/* 252 */     return serviceNode;
/*     */   }
/*     */ 
/*     */   private static HiTreeParent renderServiceColumnTree(String tableName, List<Field> columns)
/*     */   {
/* 260 */     HiTreeParent tableNode = new HiTreeParent(tableName);
/*     */ 
/* 262 */     for (int i = 0; i < columns.size(); i++) {
/* 263 */       Field model = (Field)columns.get(i);
/*     */ 
/* 265 */       if (model.isIsListDisplay()) {
/* 266 */         HiTreeObject treeObject = new HiTreeObject(model.getFieldName());
/* 267 */         treeObject.setTreeObj(model);
/* 268 */         treeObject.setImagePath(ImageConstants.IMAGE_FIELD);
/*     */ 
/* 271 */         tableNode.addChild(treeObject);
/*     */       }
/*     */     }
/*     */ 
/* 275 */     return tableNode;
/*     */   }
/*     */ 
/*     */   private static Map<String, Service> loadServiceMap(String servicePath)
/*     */     throws JAXBException, IOException
/*     */   {
/* 283 */     if (sysServiceInstance != null) {
/* 284 */       return sysServiceInstance;
/*     */     }
/*     */ 
/* 287 */     Map result = new HashMap();
/*     */ 
/* 289 */     List systemServices = loadService(servicePath);
/*     */ 
/* 291 */     for (Iterator iter = systemServices.iterator(); iter.hasNext(); ) {
/* 292 */       Service service = (Service)iter.next();
/* 293 */       result.put(service.getServiceName(), service);
/*     */     }
/*     */ 
/* 296 */     sysServiceInstance = result;
/* 297 */     return sysServiceInstance;
/*     */   }
/*     */ 
/*     */   private static List<Service> loadService(String servicePath) throws FileNotFoundException, JAXBException {
/* 301 */     List result = new ArrayList();
/*     */ 
/* 304 */     String dirStr = servicePath;
/*     */ 
/* 306 */     File customerDir = new File(dirStr);
/*     */ 
/* 308 */     File[] customerFiles = customerDir.listFiles(new ServiceFilenameFilter());
/* 309 */     if (customerFiles != null)
/*     */     {
/* 311 */       for (int i = 0; i < customerFiles.length; i++) {
/* 312 */         Service service = ServiceFactory.loadService(customerFiles[i].toString());
/* 313 */         result.add(service);
/*     */       }
/*     */     }
/* 316 */     return result;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.HiServiceRender
 * JD-Core Version:    0.6.0
 */