/*     */ package org.hi.studio.hsceditor.visual.action;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.eclipse.draw2d.IFigure;
/*     */ import org.eclipse.draw2d.geometry.Dimension;
/*     */ import org.eclipse.draw2d.geometry.Insets;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.eclipse.draw2d.graph.DirectedGraph;
/*     */ import org.eclipse.draw2d.graph.DirectedGraphLayout;
/*     */ import org.eclipse.draw2d.graph.Edge;
/*     */ import org.eclipse.draw2d.graph.EdgeList;
/*     */ import org.eclipse.draw2d.graph.Node;
/*     */ import org.eclipse.draw2d.graph.NodeList;
/*     */ import org.eclipse.gef.EditDomain;
/*     */ import org.eclipse.gef.EditPart;
/*     */ import org.eclipse.gef.GraphicalViewer;
/*     */ import org.eclipse.gef.commands.Command;
/*     */ import org.eclipse.gef.commands.CommandStack;
/*     */ import org.eclipse.gef.commands.CompoundCommand;
/*     */ import org.eclipse.jface.action.Action;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.visual.editpart.AbstractDBEntityEditPart;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ 
/*     */ public class AutoLayoutAction extends Action
/*     */ {
/*     */   private GraphicalViewer viewer;
/*     */ 
/*     */   public AutoLayoutAction(GraphicalViewer viewer)
/*     */   {
/*  34 */     super(DBPlugin.getResourceString("action.autoLayout"));
/*  35 */     this.viewer = viewer;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  40 */     CompoundCommand commands = new CompoundCommand();
/*  41 */     List models = this.viewer.getContents().getChildren();
/*  42 */     NodeList graphNodes = new NodeList();
/*  43 */     EdgeList graphEdges = new EdgeList();
/*     */ 
/*  45 */     for (int i = 0; i < models.size(); i++) {
/*  46 */       Object obj = models.get(i);
/*  47 */       if ((obj instanceof AbstractDBEntityEditPart)) {
/*  48 */         AbstractDBEntityEditPart editPart = (AbstractDBEntityEditPart)obj;
/*  49 */         AbstractDBEntityModel model = (AbstractDBEntityModel)editPart.getModel();
/*  50 */         EntityNode node = new EntityNode(null);
/*  51 */         node.model = model;
/*  52 */         node.width = editPart.getFigure().getSize().width;
/*  53 */         node.height = editPart.getFigure().getSize().height;
/*  54 */         graphNodes.add(node);
/*     */       }
/*     */     }
/*     */ 
/*  58 */     for (int i = 0; i < graphNodes.size(); i++) {
/*  59 */       EntityNode node = (EntityNode)graphNodes.get(i);
/*  60 */       List conns = node.model.getModelSourceConnections();
/*  61 */       for (int j = 0; j < conns.size(); j++) {
/*  62 */         AbstractDBConnectionModel conn = (AbstractDBConnectionModel)conns.get(j);
/*  63 */         if (conn.getSource() == conn.getTarget())
/*     */         {
/*     */           continue;
/*     */         }
/*  67 */         int k = 0;
/*     */         while (true) { ConnectionEdge edge = (ConnectionEdge)graphEdges.get(k);
/*  69 */           if (edge.model == conn)
/*     */             break;
/*  67 */           k++; if (k < graphEdges.size())
/*     */           {
/*     */             continue;
/*     */           }
/*     */ 
/*  73 */           EntityNode source = getNode(graphNodes, conn.getSource());
/*  74 */           EntityNode target = getNode(graphNodes, conn.getTarget());
/*  75 */           if ((source == null) || (target == null)) break;
/*  76 */           ConnectionEdge edge = new ConnectionEdge(source, target);
/*  77 */           edge.model = conn;
/*  78 */           graphEdges.add(edge);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  83 */     DirectedGraph graph = new DirectedGraph();
/*  84 */     graph.setDefaultPadding(new Insets(40));
/*  85 */     graph.nodes = graphNodes;
/*  86 */     graph.edges = graphEdges;
/*  87 */     new DirectedGraphLayout().visit(graph);
/*  88 */     for (int i = 0; i < graph.nodes.size(); i++) {
/*  89 */       EntityNode node = (EntityNode)graph.nodes.getNode(i);
/*  90 */       commands.add(new LayoutCommand(node.model, node.x, node.y));
/*     */     }
/*     */ 
/*  93 */     this.viewer.getEditDomain().getCommandStack().execute(commands);
/*     */   }
/*     */ 
/*     */   private static EntityNode getNode(NodeList list, AbstractDBEntityModel model) {
/*  97 */     for (int i = 0; i < list.size(); i++) {
/*  98 */       EntityNode node = (EntityNode)list.get(i);
/*  99 */       if (node.model == model) {
/* 100 */         return node;
/*     */       }
/*     */     }
/* 103 */     return null;
/*     */   }
/*     */ 
/*     */   private class ConnectionEdge extends Edge
/*     */   {
/*     */     private AbstractDBConnectionModel model;
/*     */ 
/*     */     public ConnectionEdge(AutoLayoutAction.EntityNode source, AutoLayoutAction.EntityNode target)
/*     */     {
/* 113 */       super(target);
/*     */     }
/*     */   }
/*     */   private class EntityNode extends Node { private AbstractDBEntityModel model;
/*     */ 
/*     */     private EntityNode() {  } }
/*     */ 
/*     */   private class LayoutCommand extends Command { private AbstractDBEntityModel target;
/*     */     private int x;
/*     */     private int y;
/*     */     private int oldX;
/*     */     private int oldY;
/*     */ 
/* 130 */     public LayoutCommand(AbstractDBEntityModel target, int x, int y) { this.target = target;
/* 131 */       this.x = x;
/* 132 */       this.y = y;
/* 133 */       this.oldX = target.getConstraint().x;
/* 134 */       this.oldY = target.getConstraint().y; }
/*     */ 
/*     */     public void execute()
/*     */     {
/* 138 */       this.target.setConstraint(new Rectangle(this.x, this.y, -1, -1));
/*     */     }
/*     */ 
/*     */     public void undo() {
/* 142 */       this.target.setConstraint(new Rectangle(this.oldX, this.oldY, -1, -1));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.AutoLayoutAction
 * JD-Core Version:    0.6.0
 */