/*     */ package org.hi.studio.hsceditor.visual.editor;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.EventObject;
/*     */ import java.util.List;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.runtime.IProgressMonitor;
/*     */ import org.eclipse.core.runtime.NullProgressMonitor;
/*     */ import org.eclipse.gef.DefaultEditDomain;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.GraphicalViewer;
/*     */ import org.eclipse.gef.commands.CommandStack;
/*     */ import org.eclipse.gef.editparts.ScalableRootEditPart;
/*     */ import org.eclipse.gef.editparts.ZoomManager;
/*     */ import org.eclipse.gef.palette.ConnectionCreationToolEntry;
/*     */ import org.eclipse.gef.palette.CreationToolEntry;
/*     */ import org.eclipse.gef.palette.MarqueeToolEntry;
/*     */ import org.eclipse.gef.palette.PaletteDrawer;
/*     */ import org.eclipse.gef.palette.PaletteEntry;
/*     */ import org.eclipse.gef.palette.PaletteGroup;
/*     */ import org.eclipse.gef.palette.PaletteRoot;
/*     */ import org.eclipse.gef.palette.SelectionToolEntry;
/*     */ import org.eclipse.gef.requests.SimpleFactory;
/*     */ import org.eclipse.gef.ui.actions.ActionRegistry;
/*     */ import org.eclipse.gef.ui.actions.DeleteAction;
/*     */ import org.eclipse.gef.ui.actions.DeleteRetargetAction;
/*     */ import org.eclipse.gef.ui.actions.PrintAction;
/*     */ import org.eclipse.gef.ui.actions.RedoRetargetAction;
/*     */ import org.eclipse.gef.ui.actions.UndoRetargetAction;
/*     */ import org.eclipse.gef.ui.actions.ZoomInAction;
/*     */ import org.eclipse.gef.ui.actions.ZoomOutAction;
/*     */ import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
/*     */ import org.eclipse.jface.action.IAction;
/*     */ import org.eclipse.jface.action.MenuManager;
/*     */ import org.eclipse.jface.action.Separator;
/*     */ import org.eclipse.jface.resource.ImageDescriptor;
/*     */ import org.eclipse.jface.viewers.ISelection;
/*     */ import org.eclipse.jface.viewers.ISelectionChangedListener;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.jface.viewers.SelectionChangedEvent;
/*     */ import org.eclipse.swt.events.MouseAdapter;
/*     */ import org.eclipse.swt.events.MouseEvent;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.ui.IEditorInput;
/*     */ import org.eclipse.ui.IFileEditorInput;
/*     */ import org.eclipse.ui.IWorkbenchPart;
/*     */ import org.eclipse.ui.actions.ActionFactory;
/*     */ import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.editorinput.HiEditorInput;
/*     */ import org.hi.studio.hsceditor.validator.DiagramErrors;
/*     */ import org.hi.studio.hsceditor.validator.DiagramErrors.DiagramError;
/*     */ import org.hi.studio.hsceditor.validator.DiagramValidator;
/*     */ import org.hi.studio.hsceditor.visual.action.AbstractDBAction;
/*     */ import org.hi.studio.hsceditor.visual.action.AutoLayoutAction;
/*     */ import org.hi.studio.hsceditor.visual.action.CopyAction;
/*     */ import org.hi.studio.hsceditor.visual.action.DeleteMarkerAction;
/*     */ import org.hi.studio.hsceditor.visual.action.DommainEditAction;
/*     */ import org.hi.studio.hsceditor.visual.action.GenerateAction;
/*     */ import org.hi.studio.hsceditor.visual.action.GeneratorEntityAction;
/*     */ import org.hi.studio.hsceditor.visual.action.ImportFromDiagramAction;
/*     */ import org.hi.studio.hsceditor.visual.action.ImportFromJDBCAction;
/*     */ import org.hi.studio.hsceditor.visual.action.PasteAction;
/*     */ import org.hi.studio.hsceditor.visual.action.SaveAsImageAction;
/*     */ import org.hi.studio.hsceditor.visual.action.SelectedTablesDDLAction;
/*     */ import org.hi.studio.hsceditor.visual.action.ToggleModelAction;
/*     */ import org.hi.studio.hsceditor.visual.action.ValidateAction;
/*     */ import org.hi.studio.hsceditor.visual.editpart.DBEditPartFactory;
/*     */ import org.hi.studio.hsceditor.visual.editpart.IDoubleClickSupport;
/*     */ import org.hi.studio.hsceditor.visual.generate.GeneratorProvider;
/*     */ import org.hi.studio.hsceditor.visual.generate.HiServiceGenerator;
/*     */ import org.hi.studio.hsceditor.visual.generate.IGenerator;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class VisualDBEditor extends GraphicalEditorWithPalette
/*     */ {
/*  86 */   private boolean savePreviouslyNeeded = false;
/*  87 */   private List<IAction> dbActions = new ArrayList();
/*     */   private VisualDBOutlinePage outlinePage;
/*     */ 
/*     */   public VisualDBEditor()
/*     */   {
/*  92 */     setEditDomain(new DefaultEditDomain(this));
/*  93 */     getActionRegistry().registerAction(new UndoRetargetAction());
/*  94 */     getActionRegistry().registerAction(new RedoRetargetAction());
/*  95 */     getActionRegistry().registerAction(new DeleteRetargetAction());
/*     */   }
/*     */ 
/*     */   protected PaletteRoot getPaletteRoot() {
/*  99 */     PaletteRoot root = new PaletteRoot();
/*     */ 
/* 101 */     PaletteGroup tools = new PaletteGroup(DBPlugin.getResourceString("palette.tools"));
/* 102 */     tools.add(new SelectionToolEntry());
/* 103 */     tools.add(new MarqueeToolEntry());
/*     */ 
/* 105 */     PaletteDrawer drawer = new PaletteDrawer(DBPlugin.getResourceString("HI平台"));
/*     */ 
/* 107 */     drawer.add(createEntityEntry(
/* 108 */       DBPlugin.getResourceString("menu.entity"), DBPlugin.getResourceString("menu.entity.desc"), TableModel.class, "icons/table.gif"));
/* 109 */     drawer.add(createEntityEntry(
/* 110 */       DBPlugin.getResourceString("menu.enumration"), DBPlugin.getResourceString("menu.enumration.desc"), EnumerationModel.class, "icons/table.gif"));
/* 111 */     drawer.add(createConnectionEntry(
/* 112 */       DBPlugin.getResourceString("menu.reference"), DBPlugin.getResourceString("menu.reference.desc"), ForeignKeyModel.class, "icons/reference.gif"));
/*     */ 
/* 114 */     root.add(tools);
/* 115 */     root.add(drawer);
/*     */ 
/* 117 */     return root;
/*     */   }
/*     */ 
/*     */   protected void setInput(IEditorInput input) {
/* 121 */     super.setInput(input);
/* 122 */     setPartName(input.getName());
/*     */   }
/*     */ 
/*     */   protected void initializeGraphicalViewer()
/*     */   {
/* 127 */     GraphicalViewer viewer = getGraphicalViewer();
/*     */ 
/* 129 */     ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
/* 130 */     viewer.setEditPartFactory(new DBEditPartFactory());
/* 131 */     viewer.setRootEditPart(rootEditPart);
/*     */ 
/* 134 */     ZoomManager manager = rootEditPart.getZoomManager();
/*     */ 
/* 137 */     double[] zoomLevels = { 
/* 138 */       0.25D, 0.5D, 0.75D, 1.0D, 1.5D, 2.0D, 2.5D, 3.0D, 4.0D, 5.0D, 10.0D, 20.0D };
/*     */ 
/* 140 */     manager.setZoomLevels(zoomLevels);
/*     */ 
/* 143 */     List zoomContributions = new ArrayList();
/* 144 */     zoomContributions.add(ZoomManager.FIT_ALL);
/* 145 */     zoomContributions.add(ZoomManager.FIT_HEIGHT);
/* 146 */     zoomContributions.add(ZoomManager.FIT_WIDTH);
/* 147 */     manager.setZoomLevelContributions(zoomContributions);
/*     */ 
/* 149 */     getActionRegistry().registerAction(new ZoomInAction(manager));
/* 150 */     getActionRegistry().registerAction(new ZoomOutAction(manager));
/*     */ 
/* 152 */     PrintAction printAction = new PrintAction(this);
/* 153 */     printAction.setText(DBPlugin.getResourceString("action.print"));
/* 154 */     printAction.setImageDescriptor(DBPlugin.getImageDescriptor("icons/print.gif"));
/* 155 */     getActionRegistry().registerAction(printAction);
/*     */ 
/* 157 */     HiEditorInput hiInput = null;
/* 158 */     if ((getEditorInput() instanceof HiEditorInput)) {
/* 159 */       hiInput = (HiEditorInput)getEditorInput();
/*     */     }
/*     */ 
/* 162 */     IFile file = ((IFileEditorInput)getEditorInput()).getFile();
/*     */ 
/* 164 */     RootModel root = null;
/*     */     try
/*     */     {
/* 167 */       root = VisualDBSerializer.deserialize(file.getContents());
/* 168 */       if (root == null) {
/* 169 */         root = new RootModel();
/*     */       }
/*     */ 
/* 172 */       String serivceName = file.getName();
/* 173 */       if (serivceName.indexOf(".") > 0) {
/* 174 */         serivceName = serivceName.substring(0, serivceName.indexOf("."));
/* 175 */         root.setServiceName(serivceName);
/*     */       }
/*     */ 
/* 178 */       if (hiInput != null)
/*     */       {
/* 180 */         if ((root.getPackageName() == null) || 
/* 181 */           (root.getPackageName().equals("")))
/*     */         {
/* 183 */           root.setPackageName(hiInput.getPackageName());
/*     */         }
/*     */ 
/* 186 */         if ((root.getBaseData() == null) || 
/* 187 */           (root.getBaseData().equals("")))
/*     */         {
/* 203 */           root.setBaseData(hiInput.getBaseData());
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 208 */       DBPlugin.logException(ex);
/* 209 */       root = new RootModel();
/* 210 */       root.setDialectName(org.hi.studio.hsceditor.dialect.DialectProvider.getDialectNames()[0]);
/*     */     }
/* 212 */     viewer.setContents(root);
/*     */ 
/* 214 */     DeleteAction deleteAction = new DeleteAction(this);
/* 215 */     deleteAction.setSelectionProvider(getGraphicalViewer());
/* 216 */     getActionRegistry().registerAction(deleteAction);
/* 217 */     getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener(deleteAction) {
/*     */       public void selectionChanged(SelectionChangedEvent event) {
/* 219 */         this.val$deleteAction.update();
/*     */       }
/*     */     });
/* 228 */     MenuManager menuMgr = new MenuManager();
/* 229 */     menuMgr.add(getActionRegistry().getAction(ActionFactory.UNDO.getId()));
/* 230 */     menuMgr.add(getActionRegistry().getAction(ActionFactory.REDO.getId()));
/*     */ 
/* 232 */     menuMgr.add(new Separator());
/*     */ 
/* 234 */     GeneratorEntityAction generateAction = new GeneratorEntityAction(this, null);
/* 235 */     getActionRegistry().registerAction(generateAction);
/* 236 */     getSelectionActions().add(generateAction.getId());
/* 237 */     menuMgr.add(generateAction);
/*     */ 
/* 240 */     PasteAction pasteAction = new PasteAction(this);
/* 241 */     getActionRegistry().registerAction(pasteAction);
/* 242 */     getSelectionActions().add(pasteAction.getId());
/* 243 */     menuMgr.add(pasteAction);
/*     */ 
/* 245 */     CopyAction copyAction = new CopyAction(this, pasteAction);
/* 246 */     getActionRegistry().registerAction(copyAction);
/* 247 */     getSelectionActions().add(copyAction.getId());
/* 248 */     menuMgr.add(copyAction);
/*     */ 
/* 251 */     menuMgr.add(getActionRegistry().getAction(ActionFactory.DELETE.getId()));
/* 252 */     menuMgr.add(new Separator());
/* 253 */     menuMgr.add(new AutoLayoutAction(viewer));
/* 254 */     menuMgr.add(new DommainEditAction(viewer));
/*     */ 
/* 256 */     menuMgr.add(new ToggleModelAction(viewer));
/* 257 */     menuMgr.add(new Separator());
/* 258 */     menuMgr.add(getActionRegistry().getAction("org.eclipse.gef.zoom_in"));
/* 259 */     menuMgr.add(getActionRegistry().getAction("org.eclipse.gef.zoom_out"));
/* 260 */     menuMgr.add(new Separator());
/* 261 */     menuMgr.add(new SaveAsImageAction(viewer));
/* 262 */     menuMgr.add(getActionRegistry().getAction(ActionFactory.PRINT.getId()));
/* 263 */     menuMgr.add(new Separator());
/*     */ 
/* 265 */     MenuManager validation = new MenuManager(DBPlugin.getResourceString("action.validation"));
/* 266 */     validation.add(new ValidateAction(viewer));
/* 267 */     validation.add(new DeleteMarkerAction(viewer));
/* 268 */     menuMgr.add(validation);
/*     */ 
/* 270 */     MenuManager importMenu = new MenuManager(DBPlugin.getResourceString("action.import"));
/* 271 */     importMenu.add(new ImportFromJDBCAction(viewer));
/* 272 */     importMenu.add(new ImportFromDiagramAction(viewer));
/* 273 */     menuMgr.add(importMenu);
/*     */ 
/* 275 */     MenuManager generate = new MenuManager(DBPlugin.getResourceString("action.export"));
/* 276 */     IGenerator[] generaters = GeneratorProvider.getGeneraters();
/* 277 */     for (int i = 0; i < generaters.length; i++) {
/* 278 */       generate.add(new GenerateAction(generaters[i], viewer, this));
/*     */     }
/* 280 */     menuMgr.add(generate);
/* 281 */     menuMgr.add(new SelectedTablesDDLAction(viewer));
/*     */ 
/* 283 */     viewer.setContextMenu(menuMgr);
/*     */ 
/* 285 */     viewer.getControl().addMouseListener(new MouseAdapter() {
/*     */       public void mouseDoubleClick(MouseEvent e) {
/* 287 */         IStructuredSelection selection = (IStructuredSelection)VisualDBEditor.this.getGraphicalViewer().getSelection();
/* 288 */         Object obj = selection.getFirstElement();
/* 289 */         if ((obj != null) && ((obj instanceof IDoubleClickSupport)))
/* 290 */           ((IDoubleClickSupport)obj).doubleClicked();
/*     */       }
/*     */     });
/* 295 */     this.outlinePage = 
/* 296 */       new VisualDBOutlinePage(viewer, getEditDomain(), root, getSelectionSynchronizer());
/*     */   }
/*     */ 
/*     */   public void doSave(IProgressMonitor monitor) {
/* 300 */     RootModel model = (RootModel)getGraphicalViewer().getContents().getModel();
/* 301 */     IFile file = ((IFileEditorInput)getEditorInput()).getFile();
/*     */     try
/*     */     {
/* 306 */       file.deleteMarkers("org.eclipse.core.resources.problemmarker", false, 0);
/* 307 */       DiagramErrors errors = new DiagramValidator(model).doValidate();
/* 308 */       for (DiagramErrors.DiagramError error : errors.getErrors()) {
/* 309 */         error.addMarker(file);
/*     */       }
/*     */ 
/* 313 */       HiServiceGenerator.generate(model);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 317 */       DBPlugin.logException(ex);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 323 */       file.setContents(VisualDBSerializer.serialize(model), true, true, monitor);
/*     */     } catch (Exception ex) {
/* 325 */       DBPlugin.logException(ex);
/*     */     }
/*     */ 
/* 328 */     getCommandStack().markSaveLocation();
/*     */   }
/*     */ 
/*     */   public void doSaveAs() {
/* 332 */     doSave(new NullProgressMonitor());
/*     */   }
/*     */ 
/*     */   public boolean isSaveAsAllowed() {
/* 336 */     return true;
/*     */   }
/*     */ 
/*     */   public void commandStackChanged(EventObject event) {
/* 340 */     if (isDirty()) {
/* 341 */       if (!savePreviouslyNeeded()) {
/* 342 */         setSavePreviouslyNeeded(true);
/* 343 */         firePropertyChange(257);
/*     */       }
/*     */     } else {
/* 346 */       setSavePreviouslyNeeded(false);
/* 347 */       firePropertyChange(257);
/*     */     }
/* 349 */     super.commandStackChanged(event);
/*     */   }
/*     */ 
/*     */   private void setSavePreviouslyNeeded(boolean value) {
/* 353 */     this.savePreviouslyNeeded = value;
/*     */   }
/*     */ 
/*     */   private boolean savePreviouslyNeeded() {
/* 357 */     return this.savePreviouslyNeeded;
/*     */   }
/*     */ 
/*     */   public void selectionChanged(IWorkbenchPart part, ISelection selection) {
/* 361 */     super.selectionChanged(part, selection);
/* 362 */     for (int i = 0; i < this.dbActions.size(); i++) {
/* 363 */       AbstractDBAction action = (AbstractDBAction)this.dbActions.get(i);
/* 364 */       action.update((IStructuredSelection)selection);
/*     */     }
/*     */   }
/*     */ 
/*     */   private PaletteEntry createConnectionEntry(String itemName, String itemDesc, Class<?> clazz, String icon)
/*     */   {
/* 377 */     ImageDescriptor image = null;
/* 378 */     if (icon != null) {
/* 379 */       image = DBPlugin.getImageDescriptor(icon);
/*     */     }
/*     */ 
/* 382 */     ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry(
/* 383 */       itemName, itemDesc, new SimpleFactory(clazz), image, image);
/* 384 */     return entry;
/*     */   }
/*     */ 
/*     */   private PaletteEntry createEntityEntry(String itemName, String itemDesc, Class<?> clazz, String icon)
/*     */   {
/* 396 */     ImageDescriptor image = null;
/* 397 */     if (icon != null) {
/* 398 */       image = DBPlugin.getImageDescriptor(icon);
/*     */     }
/*     */ 
/* 401 */     CreationToolEntry entry = new CreationToolEntry(
/* 402 */       itemName, itemDesc, new SimpleFactory(clazz), image, image);
/*     */ 
/* 404 */     return entry;
/*     */   }
/*     */ 
/*     */   public Object getAdapter(Class type)
/*     */   {
/* 409 */     if (type == IContentOutlinePage.class) {
/* 410 */       return this.outlinePage;
/*     */     }
/*     */ 
/* 414 */     return super.getAdapter(type);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editor.VisualDBEditor
 * JD-Core Version:    0.6.0
 */