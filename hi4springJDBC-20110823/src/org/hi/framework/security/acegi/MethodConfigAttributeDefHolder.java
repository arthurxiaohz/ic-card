/*     */ package org.hi.framework.security.acegi;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.acegisecurity.Authentication;
/*     */ import org.acegisecurity.ConfigAttribute;
/*     */ import org.acegisecurity.ConfigAttributeDefinition;
/*     */ import org.acegisecurity.RunAsManager;
/*     */ import org.acegisecurity.SecurityConfig;
/*     */ import org.acegisecurity.intercept.web.FilterInvocation;
/*     */ import org.aopalliance.intercept.MethodInvocation;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ 
/*     */ public final class MethodConfigAttributeDefHolder
/*     */   implements RunAsManager
/*     */ {
/*  36 */   private static ThreadLocal<ConfigAttributeDefinition> authorityHolder = new ThreadLocal();
/*     */ 
/*     */   public Authentication buildRunAs(Authentication authentication, Object object, ConfigAttributeDefinition config)
/*     */   {
/*  49 */     if ((UserContextHelper.getUser().getUserMgrType() != null) && (UserContextHelper.getUser().getUserMgrType().intValue() == 1400)) {
/*  50 */       return null;
/*     */     }
/*     */ 
/*  53 */     if ((object instanceof FilterInvocation)) {
/*  54 */       authorityHolder.set(config);
/*     */     }
/*     */ 
/*  57 */     if ((object instanceof MethodInvocation)) {
/*  58 */       ConfigAttributeDefinition urlDef = (ConfigAttributeDefinition)authorityHolder.get();
/*  59 */       authorityHolder.set(config);
/*     */ 
/*  61 */       if (urlDef != null)
/*     */       {
/*  63 */         for (Iterator i = urlDef.getConfigAttributes(); i.hasNext(); ) {
/*  64 */           ConfigAttribute configAttribute = (ConfigAttribute)i.next();
/*  65 */           if (config.contains(configAttribute)) {
/*  66 */             authorityHolder.set(urlDef);
/*  67 */             break;
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  73 */       MethodInvocation mi = (MethodInvocation)object;
/*  74 */       String methodName = mi.getMethod().getName();
/*     */ 
/*  77 */       if ((StringUtils.isInclude(methodName, "getSecurity")) && (StringUtils.isInclude(methodName, "List"))) {
/*  78 */         Object[] args = mi.getArguments();
/*     */ 
/*  80 */         if ((args == null) || (args.length > 2)) {
/*  81 */           return null;
/*     */         }
/*  83 */         if ((args[0] instanceof PageInfo)) {
/*  84 */           PageInfo pageInfo = (PageInfo)args[0];
/*  85 */           Filter securityFilter = null;
/*     */ 
/*  87 */           if (args.length == 1) {
/*  88 */             securityFilter = FilterFactory.getSecurityFilter();
/*     */           }
/*  90 */           if ((args.length > 1) && ((args[1] instanceof Filter))) {
/*  91 */             securityFilter = (Filter)args[1];
/*     */           }
/*     */ 
/*  94 */           pageInfo.setFilter(securityFilter);
/*     */         }
/*     */       }
/*  97 */       authorityHolder.remove();
/*     */     }
/*  99 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean supports(ConfigAttribute attribute)
/*     */   {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean supports(Class clazz)
/*     */   {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   public static ConfigAttributeDefinition getConfigAttributeDefinition()
/*     */   {
/* 123 */     return (ConfigAttributeDefinition)authorityHolder.get();
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public static void setConfigAttributeDefinition(ConfigAttributeDefinition config)
/*     */   {
/* 132 */     authorityHolder.set(config);
/*     */   }
/*     */ 
/*     */   public static void createConfigAttributeDefinition(String attributes) {
/* 136 */     if ((attributes == null) || (attributes.equals("")))
/* 137 */       return;
/* 138 */     List attributeList = StringUtils.strToArrayList(attributes);
/* 139 */     ConfigAttributeDefinition cad = new ConfigAttributeDefinition();
/*     */ 
/* 141 */     for (String attribute : attributeList) {
/* 142 */       SecurityConfig sc = new SecurityConfig(attribute);
/* 143 */       if (!cad.contains(sc))
/* 144 */         cad.addConfigAttribute(sc);
/*     */     }
/* 146 */     setConfigAttributeDefinition(cad);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.MethodConfigAttributeDefHolder
 * JD-Core Version:    0.6.0
 */