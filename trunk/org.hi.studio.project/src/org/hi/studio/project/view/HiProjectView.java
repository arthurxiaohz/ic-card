/*     */ package org.hi.studio.project.view;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.jface.action.Action;
/*     */ import org.eclipse.jface.action.IMenuListener;
/*     */ import org.eclipse.jface.action.IMenuManager;
/*     */ import org.eclipse.jface.action.IToolBarManager;
/*     */ import org.eclipse.jface.action.MenuManager;
/*     */ import org.eclipse.jface.action.Separator;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.jface.viewers.DoubleClickEvent;
/*     */ import org.eclipse.jface.viewers.IDoubleClickListener;
/*     */ import org.eclipse.jface.viewers.ISelection;
/*     */ import org.eclipse.jface.viewers.ISelectionChangedListener;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.jface.viewers.SelectionChangedEvent;
/*     */ import org.eclipse.jface.viewers.TreeViewer;
/*     */ import org.eclipse.jface.wizard.WizardDialog;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Menu;
/*     */ import org.eclipse.ui.IActionBars;
/*     */ import org.eclipse.ui.IViewSite;
/*     */ import org.eclipse.ui.IWorkbench;
/*     */ import org.eclipse.ui.IWorkbenchPage;
/*     */ import org.eclipse.ui.IWorkbenchPartSite;
/*     */ import org.eclipse.ui.IWorkbenchWindow;
/*     */ import org.eclipse.ui.PartInitException;
/*     */ import org.eclipse.ui.PlatformUI;
/*     */ import org.eclipse.ui.ide.IDE;
/*     */ import org.eclipse.ui.part.DrillDownAdapter;
/*     */ import org.eclipse.ui.part.ViewPart;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.studio.core.constants.ImageConstants;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.log.LogMessage;
/*     */ import org.hi.studio.core.tree.HiNameSorter;
/*     */ import org.hi.studio.core.tree.HiTreeObject;
/*     */ import org.hi.studio.core.tree.HiTreeParent;
/*     */ import org.hi.studio.core.tree.HiViewContentProvider;
/*     */ import org.hi.studio.core.tree.HiViewLabelProvider;
/*     */ import org.hi.studio.core.utils.FileUtil;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.core.utils.ImageUtil;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.hi.studio.generator.utils.EnvironmentUtil;
/*     */ import org.hi.studio.generator.utils.GenerateUtil;
/*     */ import org.hi.studio.generator.utils.XWorkUtil;
/*     */ import org.hi.studio.hsceditor.editorinput.HiEditorInput;
/*     */ import org.hi.studio.hsceditor.util.HiServiceRender;
/*     */ import org.hi.studio.hsceditor.visual.dialog.ServiceEditDialog;
/*     */ import org.hi.studio.hsceditor.visual.editor.VisualDBSerializer;
/*     */ import org.hi.studio.hsceditor.visual.generate.HiServiceGenerator;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ import org.hi.studio.project.HiProjectPlugin;
/*     */ import org.hi.studio.project.wizard.NewHiProjectWizard;
/*     */ 
/*     */ public class HiProjectView extends ViewPart
/*     */ {
/*     */   private TreeViewer viewer;
/*     */   private DrillDownAdapter drillDownAdapter;
/*     */   private Action refreshAction;
/*     */   private Action addServiceAction;
/*     */   private Action addProjectAction;
/*     */   private Action deleteProjectAction;
/*     */   private Action doubleClickAction;
/*     */   private Action generateAllAction;
/*     */   private Action generateHscAction;
/*     */   private Action deleteHscAction;
/*     */   private Action generateEntityAction;
/*     */   static HiProjectView instance;
/*     */ 
/*     */   public static void refresh()
/*     */   {
/*  90 */     Display.getDefault().asyncExec(new Runnable()
/*     */     {
/*     */       public void run() {
/*  93 */         if (HiProjectView.instance != null) {
/*  94 */           HiTreeParent root = HiServiceRender.renderWorkspaceTree();
/*     */ 
/*  96 */           HiProjectView.getInstance().viewer.setInput(root);
/*     */         }
/*     */       }
/*     */     });
/* 101 */     HiProjectUtil.refreshWorkspace();
/*     */   }
/*     */ 
/*     */   public static HiProjectView getInstance() {
/* 105 */     return instance;
/*     */   }
/*     */ 
/*     */   public HiProjectView()
/*     */   {
/* 111 */     instance = this;
/*     */   }
/*     */ 
/*     */   public void createPartControl(Composite parent)
/*     */   {
/* 119 */     this.viewer = new TreeViewer(parent, 772);
/* 120 */     this.drillDownAdapter = new DrillDownAdapter(this.viewer);
/* 121 */     this.viewer.setContentProvider(new HiViewContentProvider());
/* 122 */     this.viewer.setLabelProvider(new HiViewLabelProvider());
/* 123 */     this.viewer.setSorter(new HiNameSorter());
/*     */ 
/* 125 */     getSite().setSelectionProvider(this.viewer);
/*     */ 
/* 127 */     HiTreeParent root = HiServiceRender.renderWorkspaceTree();
/*     */ 
/* 129 */     this.viewer.setInput(root);
/* 130 */     makeActions();
/* 131 */     hookContextMenu();
/* 132 */     hookClickAction();
/* 133 */     contributeToActionBars();
/*     */   }
/*     */ 
/*     */   private void hookContextMenu() {
/* 137 */     MenuManager menuMgr = new MenuManager("#PopupMenu");
/* 138 */     menuMgr.setRemoveAllWhenShown(true);
/* 139 */     menuMgr.addMenuListener(new IMenuListener() {
/*     */       public void menuAboutToShow(IMenuManager manager) {
/* 141 */         HiProjectView.this.fillContextMenu(manager);
/*     */       }
/*     */     });
/* 144 */     Menu menu = menuMgr.createContextMenu(this.viewer.getControl());
/* 145 */     this.viewer.getControl().setMenu(menu);
/* 146 */     getSite().registerContextMenu(menuMgr, this.viewer);
/*     */   }
/*     */ 
/*     */   private void contributeToActionBars() {
/* 150 */     IActionBars bars = getViewSite().getActionBars();
/* 151 */     fillLocalPullDown(bars.getMenuManager());
/* 152 */     fillLocalToolBar(bars.getToolBarManager());
/*     */   }
/*     */ 
/*     */   private void fillLocalPullDown(IMenuManager manager) {
/* 156 */     manager.add(this.refreshAction);
/* 157 */     manager.add(new Separator());
/*     */   }
/*     */ 
/*     */   private void fillContextMenu(IMenuManager manager)
/*     */   {
/* 163 */     ISelection selection = this.viewer.getSelection();
/* 164 */     Object obj = ((IStructuredSelection)selection).getFirstElement();
/*     */ 
/* 168 */     if (obj == null)
/*     */     {
/* 170 */       manager.add(this.addProjectAction);
/* 171 */       return;
/*     */     }
/*     */ 
/* 174 */     if ((((HiTreeObject)obj).getTreeObj() instanceof IProject))
/*     */     {
/* 176 */       manager.add(this.addProjectAction);
/*     */ 
/* 178 */       manager.add(this.addServiceAction);
/* 179 */       manager.add(this.refreshAction);
/*     */ 
/* 182 */       manager.add(this.generateAllAction);
/*     */ 
/* 185 */       manager.add(this.deleteProjectAction);
/*     */     }
/*     */ 
/* 190 */     if ((((HiTreeObject)obj).getTreeObj() instanceof RootModel))
/*     */     {
/* 193 */       manager.add(this.generateHscAction);
/* 194 */       manager.add(this.deleteHscAction);
/*     */     }
/*     */ 
/* 199 */     if ((((HiTreeObject)obj).getTreeObj() instanceof TableModel))
/*     */     {
/* 202 */       manager.add(this.generateEntityAction);
/*     */     }
/*     */ 
/* 206 */     manager.add(new Separator());
/*     */   }
/*     */ 
/*     */   private void fillLocalToolBar(IToolBarManager manager) {
/* 210 */     manager.add(this.refreshAction);
/* 211 */     manager.add(new Separator());
/* 212 */     this.drillDownAdapter.addNavigationActions(manager);
/*     */   }
/*     */ 
/*     */   private void makeActions()
/*     */   {
/* 217 */     this.addServiceAction = new Action()
/*     */     {
/*     */       public void run() {
/* 220 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 221 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/* 222 */         IProject prj = (IProject)((HiTreeParent)obj).getTreeObj();
/* 223 */         String hiPath = prj.getFolder(".hi").getLocation()
/* 224 */           .toOSString();
/*     */ 
/* 226 */         String serviceName = "newservice";
/* 227 */         String packageName = EnvironmentUtil.getCurrentEnvironment()
/* 228 */           .getGenerate().getOrgPackage() + 
/* 229 */           "." + serviceName;
/*     */ 
/* 231 */         Map serviceMap = 
/* 232 */           VisualDBSerializer.parseServiceList(hiPath);
/* 233 */         Iterator iterator = serviceMap.keySet().iterator();
/* 234 */         Integer basedata = Integer.valueOf(100000);
/* 235 */         while (iterator.hasNext()) {
/* 236 */           RootModel model = (RootModel)serviceMap.get((String)iterator.next());
/*     */ 
/* 238 */           if ((model.getBaseData() == null) || 
/* 239 */             (model.getBaseData().equals("")))
/*     */             continue;
/* 241 */           if (Integer.valueOf(basedata.intValue()).intValue() <= 
/* 241 */             Integer.valueOf(model.getBaseData()).intValue()) {
/* 242 */             basedata = Integer.valueOf(Integer.valueOf(model.getBaseData()).intValue() + 100000);
/*     */           }
/*     */         }
/* 245 */         String baseDataName = basedata.toString();
/* 246 */         String descName = "newservice";
/*     */ 
/* 248 */         ServiceEditDialog serviceEditDialog = new ServiceEditDialog(Display.getDefault().getActiveShell(), serviceName, packageName, baseDataName, descName, true);
/*     */ 
/* 250 */         if (serviceEditDialog.open() == 0)
/*     */           try {
/* 252 */             IFile hiFile = prj.getFolder(".hi").getFile(serviceEditDialog.getHiServiceName() + ".hmc");
/*     */ 
/* 254 */             RootModel root = new RootModel();
/* 255 */             root.setBaseData(serviceEditDialog.getHiBasicData());
/* 256 */             root.setDescription(serviceEditDialog.getHiDesc());
/* 257 */             root.setPackageName(serviceEditDialog.getHiPackage());
/* 258 */             root.setServiceName(serviceEditDialog.getHiServiceName());
/* 259 */             hiFile.create(VisualDBSerializer.serialize(root), true, null);
/*     */ 
/* 261 */             HiEditorInput hiInput = new HiEditorInput(hiFile);
/* 262 */             hiInput.setBaseData(serviceEditDialog.getHiBasicData());
/* 263 */             hiInput.setDesc(serviceEditDialog.getHiDesc());
/* 264 */             hiInput.setPackageName(serviceEditDialog.getHiPackage());
/* 265 */             hiInput.setServiceName(serviceEditDialog.getHiServiceName());
/*     */ 
/* 267 */             HiProjectView.refresh();
/*     */ 
/* 269 */             IWorkbenchPage page = HiProjectPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
/* 270 */             IDE.openEditor(page, hiInput, "org.hi.studio.hsceditor.editor");
/*     */           } catch (Exception e) {
/* 272 */             ExceptionManager.logError(e, "");
/*     */           }
/*     */       }
/*     */     };
/* 280 */     this.addServiceAction.setText("创建Hi平台服务");
/* 281 */     this.addServiceAction.setToolTipText("创建Hi平台服务");
/* 282 */     this.addServiceAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_ADDSERVICE));
/*     */ 
/* 284 */     this.addProjectAction = new Action()
/*     */     {
/*     */       public void run()
/*     */       {
/* 295 */         NewHiProjectWizard wizard = new NewHiProjectWizard();
/*     */ 
/* 297 */         WizardDialog dlg = new WizardDialog(
/* 298 */           PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
/*     */ 
/* 300 */         dlg.open();
/*     */       }
/*     */     };
/* 309 */     this.addProjectAction.setText("创建Hi工程");
/* 310 */     this.addProjectAction.setToolTipText("创建Hi工程");
/* 311 */     this.addProjectAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_PROJECT));
/*     */ 
/* 313 */     this.deleteProjectAction = new Action() {
/*     */       public void run() {
/* 315 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 316 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/* 317 */         IProject model = (IProject)((HiTreeParent)obj).getTreeObj();
/*     */         try
/*     */         {
/* 320 */           if (MessageDialog.openConfirm(null, "是否要删除工程", "删除工程会导致工程数据不完整，且无法恢复！确认删除")) {
/* 321 */             model.delete(true, null);
/* 322 */             HiProjectView.refresh();
/*     */           }
/*     */         }
/*     */         catch (CoreException e) {
/* 326 */           LogMessage.logError("删除工程失败", e);
/*     */         }
/*     */       }
/*     */     };
/* 332 */     this.deleteProjectAction.setText("删除Hi工程");
/* 333 */     this.deleteProjectAction.setToolTipText("删除Hi工程");
/* 334 */     this.deleteProjectAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_DELETE));
/*     */ 
/* 337 */     this.refreshAction = new Action()
/*     */     {
/*     */       public void run()
/*     */       {
/* 343 */         HiProjectView.refresh();
/*     */       }
/*     */     };
/* 346 */     this.refreshAction.setText("刷新");
/* 347 */     this.refreshAction.setToolTipText("刷新");
/* 348 */     this.refreshAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_REFRESH));
/*     */ 
/* 351 */     this.generateAllAction = new Action() {
/*     */       public void run() {
/* 353 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 354 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/* 355 */         HiTreeParent treeObj = (HiTreeParent)obj;
/* 356 */         HiTreeObject[] childs = treeObj.getChildren();
/* 357 */         for (HiTreeObject hiTreeObject : childs) {
/* 358 */           RootModel root = (RootModel)hiTreeObject.getTreeObj();
/*     */           try {
/* 360 */             HiServiceGenerator.generate(root);
/*     */           } catch (Exception e) {
/* 362 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */ 
/* 366 */         GenerateUtil.generateAll(HiProjectUtil.getCurrentProject());
/*     */ 
/* 368 */         HiProjectUtil.refreshWorkspace();
/*     */       }
/*     */     };
/* 372 */     this.generateAllAction.setText("生成工程下的所有代码");
/* 373 */     this.generateAllAction.setToolTipText("生成工程下的所有代码");
/* 374 */     this.generateAllAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_GENERATE));
/*     */ 
/* 376 */     this.generateHscAction = new Action()
/*     */     {
/*     */       public void run() {
/* 379 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 380 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/*     */         try
/*     */         {
/* 383 */           IFile modelFile = 
/* 384 */             HiProjectUtil.getCurrentProject().getFile(".hi/" + ((HiTreeParent)obj).toString());
/*     */ 
/* 386 */           if ((modelFile.exists()) && 
/* 387 */             (modelFile.findMarkers("org.eclipse.core.resources.problemmarker", false, 0).length > 0)) {
/* 388 */             MessageDialog.openError(null, "模型文件有错,不能生成代码", "模型文件有错,不能生成代码");
/* 389 */             return;
/*     */           }
/*     */ 
/* 393 */           FileInputStream fis = new FileInputStream(((HiTreeParent)obj).getName());
/* 394 */           RootModel tempModel = VisualDBSerializer.deserialize(fis);
/*     */ 
/* 401 */           HiServiceGenerator.generate(tempModel);
/*     */ 
/* 403 */           IFolder descfolder = 
/* 404 */             HiProjectUtil.getWebContentDir(
/* 405 */             HiProjectUtil.getCurrentProject());
/* 406 */           IFile original = descfolder.getFile("WEB-INF/metadata/" + 
/* 407 */             tempModel.getServiceName() + ".hsc.xml");
/*     */ 
/* 410 */           GenerateUtil.generateHsc(original.getLocation().toString());
/*     */ 
/* 412 */           HiProjectUtil.refreshWorkspace();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 416 */           ExceptionManager.logError(e, "");
/*     */         }
/*     */       }
/*     */     };
/* 423 */     this.generateHscAction.setText("从模型生成代码");
/* 424 */     this.generateHscAction.setToolTipText("从模型生成代码");
/* 425 */     this.generateHscAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_GENERATE));
/*     */ 
/* 428 */     this.deleteHscAction = new Action()
/*     */     {
/*     */       public void run() {
/* 431 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 432 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/* 433 */         RootModel model = (RootModel)((HiTreeParent)obj).getTreeObj();
/* 434 */         String packageName = model.getPackageName();
/* 435 */         String serviceName = model.getServiceName();
/*     */ 
/* 437 */         String filename = ((HiTreeParent)obj).getName();
/* 438 */         if (MessageDialog.openConfirm(null, "删除服务:" + serviceName + "及对应生成的代码", "删除服务:" + serviceName + "及对应生成的代码"))
/*     */         {
/* 440 */           String packagePath = HiProjectUtil.getCurrentProject().getLocation().toOSString() + 
/* 441 */             "/src/" + StringUtil.replace(packageName, ".", File.separator);
/* 442 */           String serviceWebPath = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject()).getLocation().toOSString() + 
/* 443 */             "/" + serviceName;
/* 444 */           String xworkIncludeFilename = HiProjectUtil.getCurrentProject().getLocation().toOSString() + 
/* 445 */             "/src/xwork-" + serviceName + ".xml";
/* 446 */           String xworkFileName = HiProjectUtil.getCurrentProject().getLocation().toOSString() + 
/* 447 */             "/src/xwork.xml";
/*     */ 
/* 449 */           FileUtil.deltree(packagePath);
/* 450 */           FileUtil.deltree(serviceWebPath);
/*     */ 
/* 452 */           File xworkIncludeFile = new File(xworkIncludeFilename);
/* 453 */           if (xworkIncludeFile.exists()) {
/* 454 */             xworkIncludeFile.delete();
/* 455 */             XWorkUtil.deleteXWorkIncludeFile(xworkFileName, "xwork-" + serviceName + ".xml");
/*     */           }
/*     */ 
/* 458 */           ((HiTreeParent)obj).getParent().removeChild((HiTreeParent)obj);
/* 459 */           File hscFile = new File(filename);
/* 460 */           if (hscFile.exists()) {
/* 461 */             hscFile.delete();
/*     */           }
/*     */ 
/* 464 */           HiProjectView.this.viewer.refresh();
/* 465 */           HiProjectUtil.refreshWorkspace();
/*     */         }
/*     */       }
/*     */     };
/* 471 */     this.deleteHscAction.setText("删除服务");
/* 472 */     this.deleteHscAction.setToolTipText("删除服务");
/* 473 */     this.deleteHscAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_DELETE));
/*     */ 
/* 475 */     this.generateEntityAction = new Action()
/*     */     {
/*     */       public void run() {
/* 478 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 479 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/*     */ 
/* 482 */         List entityList = ((IStructuredSelection)selection).toList();
/* 483 */         String entityNames = "";
/* 484 */         for (Iterator it = entityList.iterator(); it.hasNext(); ) {
/* 485 */           Object treeObj = it.next();
/* 486 */           entityNames = entityNames + "," + treeObj.toString();
/*     */         }
/*     */         try
/*     */         {
/* 490 */           FileInputStream fis = new FileInputStream(((HiTreeParent)obj).getParent().getName());
/* 491 */           RootModel tempModel = VisualDBSerializer.deserialize(fis);
/*     */ 
/* 494 */           HiServiceGenerator.generate(tempModel);
/*     */ 
/* 496 */           IFolder descfolder = 
/* 497 */             HiProjectUtil.getWebContentDir(
/* 498 */             HiProjectUtil.getCurrentProject());
/* 499 */           IFile original = descfolder.getFile("WEB-INF/metadata/" + 
/* 500 */             tempModel.getServiceName() + ".hsc.xml");
/*     */ 
/* 503 */           GenerateUtil.generateHsc(original.getLocation().toString(), entityNames);
/*     */ 
/* 505 */           HiProjectUtil.refreshWorkspace();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 509 */           ExceptionManager.logError(e, "");
/*     */         }
/*     */       }
/*     */     };
/* 513 */     this.generateEntityAction.setText("从实体生成代码");
/* 514 */     this.generateEntityAction.setToolTipText("从实体生成代码");
/* 515 */     this.generateEntityAction.setImageDescriptor(ImageUtil.getInstance().getImageDescriptor(ImageConstants.IMAGE_GENERATE));
/*     */ 
/* 517 */     this.doubleClickAction = new Action() {
/*     */       public void run() {
/* 519 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 520 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/* 521 */         HiTreeObject treeObj = (HiTreeObject)obj;
/* 522 */         if (!(treeObj.getTreeObj() instanceof RootModel))
/*     */         {
/* 524 */           return;
/*     */         }
/*     */ 
/* 530 */         IWorkbenchPage page = 
/* 531 */           PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
/*     */ 
/* 533 */         IProject prj = HiProjectUtil.getCurrentProject();
/*     */ 
/* 535 */         IFile hiFile = prj.getFolder(".hi").getFile(treeObj.toString());
/*     */ 
/* 537 */         HiEditorInput hiInput = new HiEditorInput(hiFile);
/*     */         try
/*     */         {
/* 540 */           IDE.openEditor(page, hiInput, "org.hi.studio.hsceditor.editor", true);
/*     */         } catch (PartInitException e) {
/* 542 */           ExceptionManager.logError(e, "doubleClickAction error");
/*     */         }
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */   private void hookClickAction()
/*     */   {
/* 551 */     this.viewer.addDoubleClickListener(new IDoubleClickListener() {
/*     */       public void doubleClick(DoubleClickEvent event) {
/* 553 */         HiProjectView.this.doubleClickAction.run();
/*     */       }
/*     */     });
/* 558 */     this.viewer.addSelectionChangedListener(new ISelectionChangedListener() {
/*     */       public void selectionChanged(SelectionChangedEvent event) {
/* 560 */         ISelection selection = HiProjectView.this.viewer.getSelection();
/* 561 */         Object obj = ((IStructuredSelection)selection).getFirstElement();
/* 562 */         if (obj != null)
/*     */         {
/* 564 */           Object treeObj = ((HiTreeObject)obj).getTreeObj();
/*     */ 
/* 566 */           if ((treeObj instanceof RootModel))
/* 567 */             treeObj = ((HiTreeObject)obj).getParent().getTreeObj();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void setFocus()
/*     */   {
/* 584 */     this.viewer.getControl().setFocus();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.view.HiProjectView
 * JD-Core Version:    0.6.0
 */