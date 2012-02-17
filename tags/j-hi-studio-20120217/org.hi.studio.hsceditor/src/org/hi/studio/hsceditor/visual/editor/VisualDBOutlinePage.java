/*     */ package org.hi.studio.hsceditor.visual.editor;
/*     */ 
/*     */ import org.eclipse.draw2d.LightweightSystem;
/*     */ import org.eclipse.draw2d.Viewport;
/*     */ import org.eclipse.draw2d.parts.ScrollableThumbnail;
/*     */ import org.eclipse.gef.EditDomain;
/*     */ import org.eclipse.gef.EditPartViewer;
/*     */ import org.eclipse.gef.GraphicalViewer;
/*     */ import org.eclipse.gef.editparts.ScalableRootEditPart;
/*     */ import org.eclipse.gef.ui.parts.ContentOutlinePage;
/*     */ import org.eclipse.gef.ui.parts.SelectionSynchronizer;
/*     */ import org.eclipse.gef.ui.parts.TreeViewer;
/*     */ import org.eclipse.jface.viewers.IStructuredSelection;
/*     */ import org.eclipse.swt.custom.SashForm;
/*     */ import org.eclipse.swt.events.DisposeEvent;
/*     */ import org.eclipse.swt.events.DisposeListener;
/*     */ import org.eclipse.swt.events.MouseAdapter;
/*     */ import org.eclipse.swt.events.MouseEvent;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Canvas;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.ui.part.IPageSite;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.util.UIUtils;
/*     */ import org.hi.studio.hsceditor.visual.action.DommainEditAction;
/*     */ import org.hi.studio.hsceditor.visual.editpart.TableEditPart;
/*     */ import org.hi.studio.hsceditor.visual.editpart.tree.AbstractDBTreeEditPart;
/*     */ import org.hi.studio.hsceditor.visual.editpart.tree.FolderTreeEditPart.FolderModel;
/*     */ import org.hi.studio.hsceditor.visual.editpart.tree.VisualDBTreeEditPartFactory;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.DommainModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class VisualDBOutlinePage extends ContentOutlinePage
/*     */ {
/*     */   private GraphicalViewer graphicalViewer;
/*     */   private EditDomain editDomain;
/*     */   private RootModel rootModel;
/*     */   private SelectionSynchronizer selectionSynchronizer;
/*     */   private Composite composite;
/*     */   private SashForm sashForm;
/*     */   private DisposeListener disposeListener;
/*     */   private ScrollableThumbnail thumbnail;
/*  64 */   private static String filterText = "";
/*     */ 
/*     */   public VisualDBOutlinePage(GraphicalViewer viewer, EditDomain domain, RootModel root, SelectionSynchronizer selectionSynchronizer)
/*     */   {
/*  68 */     super(new TreeViewer());
/*  69 */     this.graphicalViewer = viewer;
/*  70 */     this.editDomain = domain;
/*  71 */     this.rootModel = root;
/*  72 */     this.selectionSynchronizer = selectionSynchronizer;
/*     */   }
/*     */ 
/*     */   public static String getFilterText()
/*     */   {
/*  81 */     return filterText;
/*     */   }
/*     */ 
/*     */   public void createControl(Composite parent) {
/*  85 */     this.composite = new Composite(parent, 0);
/*  86 */     this.composite.setLayout(new GridLayout(1, false));
/*     */ 
/* 107 */     this.sashForm = new SashForm(this.composite, 512);
/* 108 */     this.sashForm.setLayoutData(new GridData(1808));
/*     */ 
/* 110 */     EditPartViewer viewer = getViewer();
/* 111 */     viewer.createControl(this.sashForm);
/* 112 */     viewer.setEditDomain(this.editDomain);
/* 113 */     viewer.setEditPartFactory(new VisualDBTreeEditPartFactory());
/* 114 */     viewer.setContents(this.rootModel);
/* 115 */     this.selectionSynchronizer.addViewer(viewer);
/* 116 */     viewer.getControl().addMouseListener(new MouseAdapter() {
/*     */       public void mouseDoubleClick(MouseEvent e) {
/* 118 */         IStructuredSelection sel = (IStructuredSelection)VisualDBOutlinePage.this.getViewer().getSelection();
/* 119 */         Object obj = sel.getFirstElement();
/* 120 */         if (obj != null) {
/* 121 */           AbstractDBTreeEditPart editPart = (AbstractDBTreeEditPart)obj;
/* 122 */           Object model = editPart.getModel();
/*     */ 
/* 124 */           if ((model instanceof FolderTreeEditPart.FolderModel)) {
/* 125 */             ((FolderTreeEditPart.FolderModel)model).doEdit();
/*     */           }
/* 127 */           else if ((model instanceof TableModel)) {
/* 128 */             TableModel table = (TableModel)model;
/* 129 */             if (table.isLinkedTable()) {
/* 130 */               UIUtils.openAlertDialog(DBPlugin.getResourceString("error.edit.linkedTable"));
/* 131 */               return;
/*     */             }
/* 133 */             TableEditPart.openTableEditDialog(VisualDBOutlinePage.this.getViewer(), table, VisualDBOutlinePage.this.rootModel);
/*     */           }
/* 135 */           else if ((model instanceof DommainModel)) {
/* 136 */             new DommainEditAction((GraphicalViewer)
/* 137 */               UIUtils.getActiveEditor().getAdapter(GraphicalViewer.class), 
/* 138 */               (DommainModel)model).run();
/*     */           }
/* 140 */           else if ((model instanceof ColumnModel)) {
/* 141 */             TableModel parent = null;
/* 142 */             for (AbstractDBEntityModel entity : VisualDBOutlinePage.this.rootModel.getChildren()) {
/* 143 */               if ((entity instanceof TableModel)) {
/* 144 */                 TableModel table = (TableModel)entity;
/* 145 */                 for (ColumnModel column : table.getColumns()) {
/* 146 */                   if (column == model) {
/* 147 */                     parent = table;
/* 148 */                     break;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 153 */             if (parent != null) {
/* 154 */               if (parent.isLinkedTable()) {
/* 155 */                 UIUtils.openAlertDialog(DBPlugin.getResourceString("error.edit.linkedTable"));
/* 156 */                 return;
/*     */               }
/* 158 */               TableEditPart.openTableEditDialog(
/* 159 */                 VisualDBOutlinePage.this.getViewer(), parent, VisualDBOutlinePage.this.rootModel, (ColumnModel)model);
/*     */             }
/*     */           }
/* 162 */           else if ((model instanceof IndexModel)) {
/* 163 */             TableModel parent = null;
/* 164 */             for (AbstractDBEntityModel entity : VisualDBOutlinePage.this.rootModel.getChildren()) {
/* 165 */               if ((entity instanceof TableModel)) {
/* 166 */                 TableModel table = (TableModel)entity;
/* 167 */                 for (IndexModel index : table.getIndices()) {
/* 168 */                   if (index == model) {
/* 169 */                     parent = table;
/* 170 */                     break;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 175 */             if (parent != null)
/* 176 */               TableEditPart.openTableEditDialog(
/* 177 */                 VisualDBOutlinePage.this.getViewer(), parent, VisualDBOutlinePage.this.rootModel, (IndexModel)model);
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/* 184 */     Canvas canvas = new Canvas(this.sashForm, 2048);
/*     */ 
/* 186 */     LightweightSystem lws = new LightweightSystem(canvas);
/*     */ 
/* 188 */     ScalableRootEditPart rootEditPart = 
/* 189 */       (ScalableRootEditPart)this.graphicalViewer.getRootEditPart();
/* 190 */     this.thumbnail = new ScrollableThumbnail((Viewport)rootEditPart.getFigure());
/* 191 */     this.thumbnail.setSource(rootEditPart.getLayer("Printable Layers"));
/* 192 */     lws.setContents(this.thumbnail);
/*     */ 
/* 194 */     this.disposeListener = new DisposeListener() {
/*     */       public void widgetDisposed(DisposeEvent e) {
/* 196 */         if (VisualDBOutlinePage.this.thumbnail != null) {
/* 197 */           VisualDBOutlinePage.this.thumbnail.deactivate();
/* 198 */           VisualDBOutlinePage.this.thumbnail = null;
/*     */         }
/*     */       }
/*     */     };
/* 202 */     this.graphicalViewer.getControl().addDisposeListener(this.disposeListener);
/* 203 */     getSite().setSelectionProvider(getViewer());
/*     */   }
/*     */ 
/*     */   public Control getControl() {
/* 207 */     return this.composite;
/*     */   }
/*     */ 
/*     */   public void dispose() {
/* 211 */     this.selectionSynchronizer.removeViewer(getViewer());
/* 212 */     if ((this.graphicalViewer.getControl() != null) && (!this.graphicalViewer.getControl().isDisposed())) {
/* 213 */       this.graphicalViewer.getControl().removeDisposeListener(this.disposeListener);
/*     */     }
/* 215 */     super.dispose();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editor.VisualDBOutlinePage
 * JD-Core Version:    0.6.0
 */