/*     */ package org.hi.framework.dao.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.framework.dao.DAO;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.HiDialect;
/*     */ import org.hi.framework.service.Manager;
/*     */ 
/*     */ public abstract class AbstractFilter
/*     */   implements Filter
/*     */ {
/*  21 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*  26 */   protected List<FilterBean> conditions = new ArrayList();
/*     */ 
/*  28 */   protected List<List<FilterBean>> filterGroup = new ArrayList();
/*     */   protected String aliasName;
/*     */ 
/*     */   public String getAliasName()
/*     */   {
/*  34 */     return this.aliasName;
/*     */   }
/*     */ 
/*     */   public void setAliasName(String aliasName) {
/*  38 */     this.aliasName = aliasName;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  42 */     StringBuffer strBuf = new StringBuffer();
/*  43 */     for (List group : this.filterGroup) {
/*  44 */       if (this.filterGroup.size() > 1)
/*  45 */         strBuf.append("[");
/*  46 */       for (FilterBean filterBean : group) {
/*  47 */         strBuf.append("[");
/*  48 */         strBuf.append("name:").append(filterBean.getFieldName()).append(",");
/*  49 */         strBuf.append("operater:").append(filterBean.getOperater()).append(",");
/*  50 */         strBuf.append("value:").append(filterBean.getValue() == null ? "null" : filterBean.getValue().toString()).append(",");
/*  51 */         strBuf.append("realtion:").append(filterBean.getRelations()).append(",");
/*  52 */         strBuf.append("not:").append(filterBean.isNot()).append(",");
/*  53 */         strBuf.append("likeControler:").append(filterBean.getLikeControler());
/*  54 */         strBuf.append("]");
/*     */       }
/*  56 */       if (this.filterGroup.size() > 1) {
/*  57 */         strBuf.append("]");
/*     */       }
/*     */     }
/*  60 */     if (this.filterGroup.size() == 0) {
/*  61 */       for (FilterBean filterBean : this.conditions) {
/*  62 */         strBuf.append("[");
/*  63 */         strBuf.append("name:").append(filterBean.getFieldName()).append(",");
/*  64 */         strBuf.append("operater:").append(filterBean.getOperater()).append(",");
/*  65 */         strBuf.append("value:").append(filterBean.getValue() == null ? "null" : filterBean.getValue().toString()).append(",");
/*  66 */         strBuf.append("realtion:").append(filterBean.getRelations()).append(",");
/*  67 */         strBuf.append("not:").append(filterBean.isNot()).append(",");
/*  68 */         strBuf.append("likeControler:").append(filterBean.getLikeControler());
/*  69 */         strBuf.append("]");
/*     */       }
/*     */     }
/*     */ 
/*  73 */     return strBuf.toString();
/*     */   }
/*     */ 
/*     */   public List<FilterBean> getConditions()
/*     */   {
/*  80 */     return this.conditions;
/*     */   }
/*     */ 
/*     */   public Filter addFilter(Filter otherFilter)
/*     */   {
/*  87 */     return addFilter(otherFilter, "AND");
/*     */   }
/*     */ 
/*     */   public Filter addFilter(Filter otherFilter, String relation)
/*     */   {
/*  94 */     if ((otherFilter == null) || (otherFilter.getConditions() == null) || (otherFilter.getConditions().size() < 1))
/*  95 */       return this;
/*  96 */     if ((otherFilter.getAliasName() != null) && (!otherFilter.getAliasName().trim().equals(""))) {
/*  97 */       this.aliasName = otherFilter.getAliasName();
/*     */     }
/*  99 */     if (relation == null) {
/* 100 */       relation = "AND";
/*     */     }
/* 102 */     String otherStr = otherFilter.toString();
/* 103 */     List conditions = otherFilter.getConditions();
/*     */ 
/* 105 */     if ((this.filterGroup.size() == 0) && (this.conditions.size() != 0)) {
/* 106 */       List mainConditions = new ArrayList();
/* 107 */       mainConditions.addAll(this.conditions);
/* 108 */       this.filterGroup.add(mainConditions);
/*     */     }
/*     */ 
/* 111 */     List otherGroup = otherFilter.getFilterGroup();
/* 112 */     if (otherGroup.size() > 1) {
/* 113 */       for (List group : otherGroup)
/* 114 */         this.filterGroup.add(group);
/*     */     }
/*     */     else {
/* 117 */       this.filterGroup.add(conditions);
/*     */     }
/* 119 */     for (int i = 0; i < conditions.size(); i++) {
/* 120 */       FilterBean filterBean = (FilterBean)conditions.get(i);
/*     */ 
/* 122 */       if (i == 0) {
/* 123 */         filterBean.setRelations(relation);
/*     */       }
/* 125 */       this.conditions.add(filterBean);
/*     */     }
/*     */ 
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */   public void removeFilter(Filter subFilter)
/*     */   {
/* 133 */     if ((subFilter == null) || (subFilter.getConditions() == null) || (subFilter.getConditions().size() < 1))
/* 134 */       return;
/* 135 */     if ((this.conditions == null) || (this.conditions.size() < 1)) {
/* 136 */       return;
/*     */     }
/* 138 */     for (Iterator iterator = subFilter.getConditions().iterator(); iterator.hasNext(); ) {
/* 139 */       FilterBean subFilterBean = (FilterBean)iterator.next();
/*     */ 
/* 141 */       for (Iterator iterator2 = this.conditions.iterator(); iterator2.hasNext(); ) {
/* 142 */         FilterBean filterBean = (FilterBean)iterator2.next();
/*     */ 
/* 144 */         if (!subFilterBean.equals(filterBean))
/*     */         {
/*     */           continue;
/*     */         }
/* 148 */         iterator2.remove();
/* 149 */         this.conditions.remove(filterBean);
/*     */ 
/* 152 */         for (Iterator iterator3 = this.filterGroup.iterator(); iterator3.hasNext(); ) {
/* 153 */           List filterBeanList = (List)iterator3.next();
/* 154 */           for (FilterBean gFilterBean : filterBeanList)
/* 155 */             if (gFilterBean == filterBean) {
/* 156 */               iterator3.remove();
/* 157 */               this.filterGroup.remove(filterBeanList);
/*     */             }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<List<FilterBean>> getFilterGroup()
/*     */   {
/* 170 */     return this.filterGroup;
/*     */   }
/*     */ 
/*     */   public String getSQL(Manager manager) {
/* 174 */     if (manager == null)
/* 175 */       return null;
/* 176 */     if (manager.getDAO().getDialect() == null) {
/* 177 */       return null;
/*     */     }
/* 179 */     return manager.getDAO().getDialect().getFilterSQL(this, manager);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.AbstractFilter
 * JD-Core Version:    0.6.0
 */