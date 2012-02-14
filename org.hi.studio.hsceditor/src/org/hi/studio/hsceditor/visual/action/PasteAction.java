/*     */ package org.hi.studio.hsceditor.visual.action;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.GraphicalViewer;
/*     */ import org.eclipse.gef.RootEditPart;
/*     */ import org.eclipse.gef.commands.Command;
/*     */ import org.eclipse.gef.commands.CommandStack;
/*     */ import org.eclipse.gef.ui.actions.Clipboard;
/*     */ import org.eclipse.gef.ui.actions.SelectionAction;
/*     */ import org.eclipse.ui.ISharedImages;
/*     */ import org.eclipse.ui.IWorkbench;
/*     */ import org.eclipse.ui.IWorkbenchPart;
/*     */ import org.eclipse.ui.PlatformUI;
/*     */ import org.eclipse.ui.actions.ActionFactory;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.util.EntityBasedataGeneratorUtil;
/*     */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ICloneableModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class PasteAction extends SelectionAction
/*     */ {
/*     */   public PasteAction(VisualDBEditor editor)
/*     */   {
/*  32 */     super(editor);
/*  33 */     setId(ActionFactory.PASTE.getId());
/*  34 */     setActionDefinitionId(ActionFactory.PASTE.getId());
/*  35 */     setText(DBPlugin.getResourceString("action.paste"));
/*  36 */     ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
/*  37 */     setImageDescriptor(sharedImages.getImageDescriptor("IMG_TOOL_PASTE"));
/*  38 */     setDisabledImageDescriptor(sharedImages.getImageDescriptor("IMG_TOOL_PASTE_DISABLED"));
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  43 */     List model = (List)Clipboard.getDefault().getContents();
/*  44 */     if (model == null) {
/*  45 */       return;
/*     */     }
/*  47 */     CommandStack stack = (CommandStack)((VisualDBEditor)getWorkbenchPart())
/*  48 */       .getAdapter(CommandStack.class);
/*  49 */     stack.execute(new PasteCommand(model));
/*     */   }
/*     */ 
/*     */   private RootModel getRootModel() {
/*  53 */     GraphicalViewer viewer = 
/*  54 */       (GraphicalViewer)getWorkbenchPart().getAdapter(GraphicalViewer.class);
/*  55 */     RootModel root = (RootModel)viewer.getRootEditPart().getContents().getModel();
/*  56 */     return root;
/*     */   }
/*     */ 
/*     */   private Rectangle getNewRectangle(Rectangle rect)
/*     */   {
/*  98 */     Rectangle newRect = new Rectangle();
/*  99 */     rect.x += 5;
/* 100 */     rect.y += 5;
/* 101 */     newRect.width = rect.width;
/* 102 */     newRect.height = rect.height;
/* 103 */     return newRect;
/*     */   }
/*     */ 
/*     */   protected boolean calculateEnabled() {
/* 107 */     Object obj = Clipboard.getDefault().getContents();
/* 108 */     if (obj == null) {
/* 109 */       return false;
/*     */     }
/* 111 */     if ((obj instanceof List))
/*     */     {
/* 113 */       List list = (List)obj;
/*     */ 
/* 115 */       for (int i = 0; i < list.size(); i++) {
/* 116 */         Object element = list.get(i);
/* 117 */         if (ICloneableModel.class.isAssignableFrom(element.getClass())) {
/* 118 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */ 
/*     */   private class PasteCommand extends Command
/*     */   {
/*     */     private List<ICloneableModel> target;
/*     */ 
/*     */     public PasteCommand()
/*     */     {
/*  64 */       this.target = target;
/*     */     }
/*     */ 
/*     */     public void execute()
/*     */     {
/*  72 */       List copied = new ArrayList();
/*  73 */       for (int i = 0; i < this.target.size(); i++) {
/*  74 */         ICloneableModel obj = (ICloneableModel)this.target.get(i);
/*  75 */         AbstractDBEntityModel entity = (AbstractDBEntityModel)obj;
/*  76 */         entity.setConstraint(PasteAction.this.getNewRectangle(entity.getConstraint()));
/*     */ 
/*  78 */         PasteAction.this.getRootModel().addChild((AbstractDBEntityModel)obj);
/*     */ 
/*  81 */         ((TableModel)entity).setEntityBaseData(EntityBasedataGeneratorUtil.generateEntityBasedata(PasteAction.this.getRootModel()).toString());
/*     */ 
/*  83 */         copied.add(obj.clone());
/*     */       }
/*  85 */       Clipboard.getDefault().setContents(copied);
/*     */     }
/*     */ 
/*     */     public void undo() {
/*  89 */       for (int i = 0; i < this.target.size(); i++) {
/*  90 */         ICloneableModel obj = (ICloneableModel)this.target.get(i);
/*  91 */         PasteAction.this.getRootModel().removeChild((AbstractDBEntityModel)obj);
/*     */       }
/*  93 */       Clipboard.getDefault().setContents(this.target);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.PasteAction
 * JD-Core Version:    0.6.0
 */