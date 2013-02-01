/*     */ package org.hi.framework.dao.impl;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.acegisecurity.ConfigAttribute;
/*     */ import org.acegisecurity.ConfigAttributeDefinition;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.tree.Component;
/*     */ import org.hi.base.tree.TreeManager;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.SecurityFilter;
/*     */ import org.hi.framework.security.acegi.MethodConfigAttributeDefHolder;
/*     */ import org.hi.framework.security.context.UserContext;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.service.Manager;
/*     */ 
/*     */ class SecurityFilterImpl
/*     */   implements SecurityFilter
/*     */ {
/*     */   private static final long serialVersionUID = -4305546800166951484L;
/*  67 */   protected final Log log = LogFactory.getLog(getClass());
/*     */   private Filter agentFilter;
/*     */ 
/*     */   public Filter addCondition(String name, Object val)
/*     */   {
/*  75 */     return this.agentFilter.addCondition(name, val);
/*     */   }
/*     */ 
/*     */   public Filter addCondition(String name, Object val, String op)
/*     */   {
/*  82 */     return this.agentFilter.addCondition(name, val, op);
/*     */   }
/*     */ 
/*     */   public Filter addCondition(String name, Object val, String op, String relation)
/*     */   {
/*  90 */     return this.agentFilter.addCondition(name, val, op, relation);
/*     */   }
/*     */ 
/*     */   public Filter addFilter(Filter otherfilter)
/*     */   {
/*  97 */     return this.agentFilter.addFilter(otherfilter);
/*     */   }
/*     */ 
/*     */   public Filter addFilter(Filter otherFilter, String relation)
/*     */   {
/* 104 */     return this.agentFilter.addFilter(otherFilter, relation);
/*     */   }
/*     */ 
/*     */   public List<FilterBean> getConditions()
/*     */   {
/* 111 */     return this.agentFilter.getConditions();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 115 */     return this.agentFilter.toString();
/*     */   }
/*     */   public List<List<FilterBean>> getFilterGroup() {
/* 118 */     return this.agentFilter.getFilterGroup();
/*     */   }
/*     */ 
/*     */   public Filter getSeurityFilter()
/*     */   {
/* 132 */     UserContext userContext = UserContextHelper.getUserContext();
/*     */ 
/* 135 */     if (userContext.isSupperManager()) {
/* 136 */       return null;
/*     */     }
/*     */ 
/* 139 */     int maxScopeLevel = getMaxScopeLevel();
/*     */ 
/* 142 */     if (maxScopeLevel == 2904) {
/* 143 */       return null;
/*     */     }
/*     */ 
/* 146 */     setAgentFilter(maxScopeLevel);
/*     */ 
/* 149 */     if (maxScopeLevel == 2900) {
/* 150 */       return this.agentFilter.addCondition("creator.id", userContext.getUser().getId());
/*     */     }
/* 152 */     HiOrg org = userContext.getOrg();
/*     */ 
/* 155 */     if (maxScopeLevel == 2901) {
/* 156 */       if (org == null)
/* 157 */         this.log.error("user: " + userContext.getUserName() + " org is null");
/* 158 */       return this.agentFilter.addCondition("creator.org.id", userContext.getOrg().getId());
/*     */     }
/*     */ 
/* 161 */     Set filterConditions = null;
/*     */ 
/* 163 */     if (org == null) {
/* 164 */       this.log.error("user: " + userContext.getUserName() + " org is null");
/*     */     }
/*     */ 
/* 167 */     filterConditions = processOrgAndSubOrgLevelFilter(org);
/*     */ 
/* 169 */     if (filterConditions.size() > 0) {
/* 170 */       Set orgIds = new LinkedHashSet();
/* 171 */       for (HiOrg _org : filterConditions) {
/* 172 */         orgIds.add(_org.getId());
/*     */       }
/* 174 */       return this.agentFilter.addCondition("creator.org.id", orgIds);
/*     */     }
/*     */ 
/* 178 */     return null;
/*     */   }
/*     */ 
/*     */   protected Set<HiOrg> processOrgAndSubOrgLevelFilter(HiOrg org)
/*     */   {
/* 187 */     Set result = null;
/* 188 */     result = getAuthOrg();
/* 189 */     if (!result.contains(org))
/* 190 */       result.add(org);
/* 191 */     return result;
/*     */   }
/*     */ 
/*     */   protected void setAgentFilter(int maxScopeLevel)
/*     */   {
/* 201 */     if (maxScopeLevel > 2901)
/* 202 */       this.agentFilter = new InFilter();
/*     */     else
/* 204 */       this.agentFilter = new SimpleFilter();
/*     */   }
/*     */ 
/*     */   private Set<HiOrg> getAuthOrg()
/*     */   {
/* 214 */     Set result = new LinkedHashSet();
/* 215 */     ConfigAttributeDefinition config = MethodConfigAttributeDefHolder.getConfigAttributeDefinition();
/* 216 */     Map userAuthorities = UserContextHelper.getUserContext().getAuthorityNameList();
/*     */ 
/* 219 */     for (Iterator i = config.getConfigAttributes(); i.hasNext(); ) {
/* 220 */       ConfigAttribute configAttribute = (ConfigAttribute)i.next();
/* 221 */       String attribute = configAttribute.getAttribute();
/* 222 */       List authoryites = (List)userAuthorities.get(attribute);
/* 223 */       if (authoryites == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 227 */       for (Iterator iter = authoryites.iterator(); iter.hasNext(); ) {
/* 228 */         UserAuthority userAuthority = (UserAuthority)iter.next();
/*     */ 
/* 231 */         if (userAuthority.getScope().intValue() == 2902) {
/* 232 */           HiOrg filterOrg = userAuthority.getOrg();
/* 233 */           if (filterOrg == null) {
/*     */             continue;
/*     */           }
/* 236 */           if ((filterOrg != null) && (!result.contains(filterOrg))) {
/* 237 */             result.add(filterOrg);
/*     */           }
/*     */         }
/*     */ 
/* 241 */         if (userAuthority.getScope().intValue() == 2903) {
/* 242 */           HiOrg org = userAuthority.getOrg();
/* 243 */           if (org == null)
/*     */           {
/*     */             continue;
/*     */           }
/*     */ 
/* 249 */           List components = getTreeManager().getChildren(org);
/*     */ 
/* 251 */           for (Iterator iterator = components.iterator(); iterator.hasNext(); ) {
/* 252 */             Component component = (Component)iterator.next();
/* 253 */             HiOrg filterOrg = (HiOrg)component.getTarget();
/* 254 */             if (!result.contains(filterOrg)) {
/* 255 */               result.add(filterOrg);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 263 */     return result;
/*     */   }
/*     */ 
/*     */   protected int getMaxScopeLevel()
/*     */   {
/* 274 */     ConfigAttributeDefinition config = MethodConfigAttributeDefHolder.getConfigAttributeDefinition();
/*     */ 
/* 276 */     if ((config == null) || (config.size() == 0)) {
/* 277 */       return 2904;
/*     */     }
/* 279 */     Map userAuthorities = UserContextHelper.getUserContext().getAuthorityNameList();
/* 280 */     int maxScopeLevel = 0;
/*     */ 
/* 283 */     for (Iterator i = config.getConfigAttributes(); i.hasNext(); ) {
/* 284 */       ConfigAttribute configAttribute = (ConfigAttribute)i.next();
/* 285 */       String attribute = configAttribute.getAttribute();
/* 286 */       List authoryites = (List)userAuthorities.get(attribute);
/* 287 */       if (authoryites == null) {
/*     */         continue;
/*     */       }
/* 290 */       for (Iterator iter = authoryites.iterator(); iter.hasNext(); ) {
/* 291 */         UserAuthority userAuthority = (UserAuthority)iter.next();
/* 292 */         if (userAuthority.getScope() == null)
/*     */           continue;
/* 294 */         int scope = userAuthority.getScope().intValue();
/* 295 */         if (scope > maxScopeLevel)
/* 296 */           maxScopeLevel = scope;
/*     */       }
/*     */     }
/* 299 */     if (maxScopeLevel == 0) {
/* 300 */       maxScopeLevel = 2900;
/*     */     }
/* 302 */     return maxScopeLevel;
/*     */   }
/*     */ 
/*     */   TreeManager getTreeManager() {
/* 306 */     return (TreeManager)SpringContextHolder.getBean("treeManagerHiOrgListener");
/*     */   }
/*     */ 
/*     */   public String getAliasName() {
/* 310 */     return null;
/*     */   }
/*     */ 
/*     */   public void setAliasName(String aliasName)
/*     */   {
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public void removeFilter(Filter subFilter)
/*     */   {
/* 321 */     new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   public String getSQL(Manager manager)
/*     */   {
/* 327 */     return this.agentFilter.getSQL(manager);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.SecurityFilterImpl
 * JD-Core Version:    0.6.0
 */