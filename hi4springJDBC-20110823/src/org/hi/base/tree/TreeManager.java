/*     */ package org.hi.base.tree;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections.map.LinkedMap;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class TreeManager
/*     */ {
/*  23 */   private static Log log = LogFactory.getLog(TreeManager.class);
/*     */   List<Component> targets;
/*  29 */   private ManagerImpl businessManager = new ManagerImpl();
/*     */   private Class targetClass;
/*     */   protected LinkedMap treeMap;
/*     */   private ComponentImpl _component;
/*     */ 
/*     */   void addComponent(ComponentImpl component)
/*     */   {
/*  40 */     if (!this.treeMap.containsKey(component.getComponentName())) {
/*  41 */       if (this._component != null) {
/*  42 */         synchronized (this._component) {
/*  43 */           this._component = component;
/*     */         }
/*     */       }
/*  46 */       this._component = component;
/*     */ 
/*  48 */       if (!component.allComponents.contains(component)) {
/*  49 */         component.allComponents.add(component);
/*     */       }
/*  51 */       List children = getChildren(component);
/*  52 */       if (children != null) {
/*  53 */         for (Iterator it = children.iterator(); it.hasNext(); ) {
/*  54 */           ComponentImpl child = (ComponentImpl)it.next();
/*  55 */           component.addComponent(child);
/*     */         }
/*     */       }
/*     */     }
/*  59 */     else if (log.isDebugEnabled()) {
/*  60 */       log.warn("Menu '" + component.getComponentName() + 
/*  61 */         "' already exists in tree manager");
/*     */     }
/*     */ 
/*  65 */     this.treeMap.put(component.getComponentName(), component);
/*     */   }
/*     */ 
/*     */   void loadTree()
/*     */   {
/*  73 */     this.treeMap = new LinkedMap();
/*  74 */     for (Iterator iter = this.targets.iterator(); iter.hasNext(); ) {
/*  75 */       Component target = (Component)iter.next();
/*  76 */       ComponentImpl component = new ComponentImpl(target, this);
/*  77 */       addComponent(component);
/*     */     }
/*     */   }
/*     */ 
/*     */   List<ComponentImpl> getChildren(ComponentImpl component)
/*     */   {
/*  87 */     Component parent = component.getTarget();
/*  88 */     List children = new ArrayList();
/*  89 */     for (Iterator iter = this.targets.iterator(); iter.hasNext(); ) {
/*  90 */       Component child = (Component)iter.next();
/*  91 */       if ((child.getTargetParent() != null) && (child.getTargetParent().equals(parent))) {
/*  92 */         ComponentImpl childImpl = new ComponentImpl(child, this);
/*  93 */         children.add(childImpl);
/*     */       }
/*     */     }
/*  96 */     return children;
/*     */   }
/*     */ 
/*     */   public List<Component> getChildren(Component component)
/*     */   {
/* 106 */     ComponentImpl parentComponent = (ComponentImpl)getTreeMap().get(component.getComponentName());
/* 107 */     List components = parentComponent.getAllComponents();
/* 108 */     return components;
/*     */   }
/*     */ 
/*     */   public List<Component> getSibling(Component component)
/*     */   {
/* 117 */     List siblings = new ArrayList();
/* 118 */     Component parentComponent = component.getTargetParent();
/* 119 */     if (parentComponent == null)
/* 120 */       return siblings;
/* 121 */     for (Component sibling : this.targets)
/*     */     {
/* 123 */       if (sibling.equals(component)) {
/*     */         continue;
/*     */       }
/* 126 */       if (sibling.getTargetParent().equals(parentComponent))
/* 127 */         siblings.add(sibling);
/*     */     }
/* 129 */     return siblings;
/*     */   }
/*     */ 
/*     */   public void initLoadTargets()
/*     */   {
/* 136 */     List result = this.businessManager.getObjects(this.targetClass);
/* 137 */     this.targets = result;
/* 138 */     loadTree();
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public List<Component> getTargets()
/*     */   {
/* 146 */     return this.targets;
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public void setTargets(List<Component> targets)
/*     */   {
/* 154 */     this.targets = targets;
/*     */   }
/*     */ 
/*     */   synchronized ComponentImpl get_component()
/*     */   {
/* 159 */     return this._component;
/*     */   }
/*     */ 
/*     */   LinkedMap getTreeMap()
/*     */   {
/* 168 */     return this.treeMap;
/*     */   }
/*     */ 
/*     */   public Class getTargetClass()
/*     */   {
/* 177 */     return this.targetClass;
/*     */   }
/*     */ 
/*     */   public void setTargetClass(Class targetClass)
/*     */   {
/* 182 */     this.targetClass = targetClass;
/*     */   }
/*     */ 
/*     */   public ManagerImpl getBusinessManager() {
/* 186 */     return this.businessManager;
/*     */   }
/*     */ 
/*     */   public void setBusinessManager(ManagerImpl businessManager)
/*     */   {
/* 194 */     this.businessManager = businessManager;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.tree.TreeManager
 * JD-Core Version:    0.6.0
 */