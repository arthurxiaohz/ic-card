/*      */ package org.hi.framework.dao.ibatis;
/*      */ 
/*      */ import com.ibatis.sqlmap.client.SqlMapClient;
/*      */ import com.ibatis.sqlmap.client.SqlMapExecutor;
/*      */ import java.beans.PropertyDescriptor;
/*      */ import java.io.PrintStream;
/*      */ import java.io.Serializable;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import javax.servlet.ServletContext;
/*      */ import org.apache.commons.beanutils.PropertyUtils;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.hi.SpringContextHolder;
/*      */ import org.hi.common.util.BeanUtil;
/*      */ import org.hi.common.util.StringUtils;
/*      */ import org.hi.framework.dao.DAO;
/*      */ import org.hi.framework.dao.Filter;
/*      */ import org.hi.framework.dao.HiDialect;
/*      */ import org.hi.framework.dao.Sorter;
/*      */ import org.hi.framework.dao.impl.FilterBean;
/*      */ import org.hi.framework.dao.impl.FilterFactory;
/*      */ import org.hi.framework.dao.impl.LikeFilter;
/*      */ import org.hi.framework.model.BaseObject;
/*      */ import org.hi.framework.paging.Page;
/*      */ import org.hi.framework.paging.PageInfo;
/*      */ import org.hi.metadata.hsc.HSCHelper;
/*      */ import org.hi.metadata.hsc.context.service.Entity;
/*      */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*      */ import org.hi.metadata.hsc.context.service.Field;
/*      */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*      */ import org.springframework.orm.ibatis.SqlMapClientCallback;
/*      */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*      */ import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/*      */ 
/*      */ public class BaseDAOIbatis extends SqlMapClientDaoSupport
/*      */   implements DAO
/*      */ {
/*      */   public static final String ID_PREFIX_GET = "get";
/*      */   public static final String ID_PREFIX_DEL = "del";
/*      */   public static final String ID_PREFIX_INS = "ins";
/*      */   public static final String ID_PREFIX_UPDATE = "update";
/*      */   public static final String ID_PREFIX_LIST = "list";
/*      */   public static final String ID_PREFIX_COUNT = "count";
/*   78 */   protected final Log log = LogFactory.getLog(getClass());
/*      */   private HiSqlMapClientFactoryBean sessionFactory;
/*      */ 
/*      */   public void setSessionFactory(SqlMapClient sqlMapClient)
/*      */   {
/*   89 */     setSqlMapClient(sqlMapClient);
/*   90 */     this.sessionFactory = ((HiSqlMapClientFactoryBean)SpringContextHolder.getBean("&sessionFactory"));
/*      */   }
/*      */ 
/*      */   public Object getObjectById(Class clazz, Serializable id)
/*      */   {
/*   98 */     if ((id == null) || (Integer.parseInt(id.toString()) < 0)) {
/*   99 */       return null;
/*      */     }
/*  101 */     BaseObject bo = null;
/*  102 */     List entitis = getSuperClassName(clazz, null, null);
/*  103 */     if (entitis.size() <= 1) {
/*  104 */       String name = "get" + clazz.getSimpleName();
/*  105 */       bo = (BaseObject)getSqlMapClientTemplate().queryForObject(name, id);
/*      */     }
/*      */     else {
/*  108 */       Filter filter = FilterFactory.getSimpleFilter("id", id, "=");
/*  109 */       List result = getObjects(clazz, filter);
/*  110 */       if (result.size() > 0) {
/*  111 */         bo = (BaseObject)result.get(0);
/*      */       }
/*      */     }
/*  114 */     if (bo != null) bo.setDirty(false);
/*  115 */     return bo;
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz)
/*      */   {
/*  123 */     return getObjectCount(clazz, null);
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz, Filter filter)
/*      */   {
/*  130 */     return ((Integer)getSqlMapClientTemplate().queryForObject("get" + clazz.getSimpleName() + "count", new Integer(1))).intValue();
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz)
/*      */   {
/*  137 */     return getObjects(clazz, null, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter)
/*      */   {
/*  144 */     return getObjects(clazz, filter, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter, Sorter soter)
/*      */   {
/*  151 */     return getObjects(clazz, filter, soter, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  158 */     long startTime = System.currentTimeMillis();
/*  159 */     List result = getSqlMapClientTemplate().executeWithListResult(new SqlMapClientCallback(clazz, filter, sorter, page)
/*      */     {
/*      */       public Object doInSqlMapClient(SqlMapExecutor sqlExecutor) throws SQLException {
/*  162 */         return BaseDAOIbatis.this.processFind(sqlExecutor, this.val$clazz, this.val$filter, this.val$sorter, this.val$page);
/*      */       }
/*      */     });
/*  165 */     if (this.log.isTraceEnabled()) {
/*  166 */       long endTime = System.currentTimeMillis();
/*  167 */       this.log.debug("Query  use:" + (endTime - startTime) + "ms");
/*      */     }
/*  169 */     return result;
/*      */   }
/*      */   List processFind(SqlMapExecutor sqlExecutor, Class clazz, Filter filter, Sorter sorter, Page page) throws SQLException {
/*  172 */     Query[] querys = setupQuery(sqlExecutor, clazz, filter, sorter, page);
/*  173 */     Query selectQuery = querys[0];
/*  174 */     Query countQuery = querys[1];
/*  175 */     if (this.sessionFactory.isSqlShow()) {
/*  176 */       System.out.println(selectQuery);
/*  177 */       if (countQuery != null)
/*  178 */         System.out.println(countQuery);
/*      */     }
/*  180 */     int skip = 0;
/*  181 */     int max = 0;
/*  182 */     if ((page != null) && (countQuery != null)) {
/*  183 */       int count = 0;
/*  184 */       String name = "count" + clazz.getSimpleName();
/*  185 */       List countResult = sqlExecutor.queryForList(name, countQuery);
/*  186 */       if ((countResult != null) && (countResult.size() != 0)) {
/*  187 */         if (countResult.size() > 1) {
/*  188 */           count = countResult.size();
/*      */         } else {
/*  190 */           Object result = countResult.get(0);
/*  191 */           if ((result instanceof Integer))
/*  192 */             count = ((Integer)result).intValue();
/*  193 */           else if ((result instanceof Long))
/*  194 */             count = ((Long)result).intValue();
/*  195 */           else if ((result instanceof BigDecimal))
/*  196 */             count = ((BigDecimal)result).intValue();
/*  197 */           else if ((result instanceof BigInteger))
/*  198 */             count = ((BigInteger)result).intValue();
/*      */           else {
/*  200 */             count = ((Number)result).intValue();
/*      */           }
/*      */         }
/*      */ 
/*  204 */         count = (page.getMaxRecords() != 0) && (count > page.getMaxRecords()) ? page.getMaxRecords() : count;
/*      */ 
/*  206 */         page.setTotalRecords(count);
/*      */ 
/*  208 */         int totoalPage = 0;
/*  209 */         totoalPage = count % page.getPageSize() > 0 ? count / page.getPageSize() + 1 : count / page.getPageSize();
/*  210 */         page.setTotalPage(totoalPage);
/*      */       }
/*      */ 
/*  213 */       skip = page.getStartRowPosition();
/*      */ 
/*  215 */       if ((page.getMaxRecords() != 0) && (page.getStartRowPosition() + page.getPageSize() > page.getMaxRecords()))
/*  216 */         max = page.getMaxRecords() - page.getStartRowPosition();
/*      */       else
/*  218 */         max = page.getPageSize();
/*      */     }
/*  220 */     String name = "list" + clazz.getSimpleName();
/*  221 */     if (page == null)
/*  222 */       return sqlExecutor.queryForList(name, selectQuery);
/*  223 */     return sqlExecutor.queryForList(name, selectQuery, skip, max);
/*      */   }
/*      */ 
/*      */   private Map<String, DomainORInfo> getDomainInfo(Class clazz, Filter filter, Sorter sorter, List<Entity> entities)
/*      */   {
/*  232 */     Map result = new HashMap();
/*      */     String[] domainProperty;
/*  233 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  234 */       List filterBeans1 = filter.getConditions();
/*  235 */       for (int i = 0; i < filterBeans1.size(); i++) {
/*  236 */         FilterBean filterBean = (FilterBean)filterBeans1.get(i);
/*  237 */         if (!filterBean.getFieldName().contains(".")) {
/*      */           continue;
/*      */         }
/*  240 */         domainProperty = filterBean.getFieldName().split("[.]");
/*  241 */         PropertyDescriptor domainPropertyDescriptor = null;
/*  242 */         Entity domainEntity = null;
/*  243 */         Class dominClazz = clazz;
/*  244 */         for (int j = 0; j < domainProperty.length - 1; j++)
/*      */         {
/*      */           try {
/*  247 */             domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[j]);
/*  248 */             dominClazz = domainPropertyDescriptor.getPropertyType();
/*  249 */             domainEntity = HSCHelper.getEntity(this.sessionFactory.getServletContext().getRealPath(""), dominClazz); } catch (Exception e) {
/*  250 */             continue;
/*      */           }
/*  252 */           DomainORInfo domainInfo = new DomainORInfo();
/*  253 */           domainInfo.setTableName(domainEntity.getTableName());
/*  254 */           domainInfo.setPropertyName(domainProperty[j]);
/*      */ 
/*  256 */           if (j > 0) {
/*  257 */             domainInfo.setResourcePropertyName(domainProperty[(j - 1)]);
/*      */           }
/*      */ 
/*  260 */           if ((entities.size() > 1) && (j <= 0)) {
/*  261 */             String fieldName = filterBean.getFieldName();
/*  262 */             if (fieldName.contains("."))
/*  263 */               fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  264 */             for (int z = entities.size() - 1; z >= 0; z--) {
/*  265 */               List allFields = ((Entity)entities.get(z)).getField();
/*  266 */               for (Field field : allFields) {
/*  267 */                 if (field.getFieldName().equals(fieldName)) {
/*  268 */                   domainInfo.setResourcePropertyName(((Entity)entities.get(z)).getTableName());
/*  269 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*  274 */           result.put(domainProperty[j], domainInfo);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  280 */     if ((sorter != null) && (sorter.getSorts().size() > 0)) {
/*  281 */       Map sorterMap = sorter.getSorts();
/*  282 */       Set keyValue = sorterMap.keySet();
/*  283 */       for (String string : keyValue) {
/*  284 */         if (!string.contains("."))
/*      */           continue;
/*  286 */         String[] domainProperty = string.split("[.]");
/*  287 */         PropertyDescriptor domainPropertyDescriptor = null;
/*      */ 
/*  289 */         Class dominClazz = clazz;
/*  290 */         for (int i = 0; i < domainProperty.length - 1; i++) {
/*      */           try {
/*  292 */             domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[i]);
/*  293 */             dominClazz = domainPropertyDescriptor.getPropertyType();
/*  294 */             domainEntity = HSCHelper.getEntity(this.sessionFactory.getServletContext().getRealPath(""), dominClazz);
/*      */           }
/*      */           catch (Exception e)
/*      */           {
/*      */             Entity domainEntity;
/*  295 */             continue;
/*      */           }
/*      */           Entity domainEntity;
/*  297 */           DomainORInfo domainInfo = new DomainORInfo();
/*  298 */           domainInfo.setTableName(domainEntity.getTableName());
/*  299 */           domainInfo.setPropertyName(domainProperty[i]);
/*  300 */           if (i > 0) {
/*  301 */             domainInfo.setResourcePropertyName(domainProperty[(i - 1)]);
/*      */           }
/*      */ 
/*  304 */           if ((entities.size() > 1) && (i <= 0)) {
/*  305 */             String fieldName = string;
/*  306 */             if (fieldName.contains("."))
/*  307 */               fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  308 */             for (int z = entities.size() - 1; z >= 0; z--) {
/*  309 */               List allFields = ((Entity)entities.get(z)).getField();
/*  310 */               for (Field field : allFields) {
/*  311 */                 if (field.getFieldName().equals(fieldName)) {
/*  312 */                   domainInfo.setResourcePropertyName(((Entity)entities.get(z)).getTableName());
/*  313 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*  318 */           result.put(domainProperty[i], domainInfo);
/*      */         }
/*      */       }
/*      */     }
/*  322 */     return result;
/*      */   }
/*      */ 
/*      */   private Query[] setupQuery(SqlMapExecutor sqlExecutor, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  329 */     StringBuffer mainSb = new StringBuffer();
/*  330 */     Query countSb = new Query();
/*  331 */     Query selectSb = new Query();
/*  332 */     String orderSt = "";
/*      */ 
/*  334 */     Entity entity = null;
/*      */     try
/*      */     {
/*  337 */       entity = HSCHelper.getEntity(this.sessionFactory.getServletContext().getRealPath(""), clazz);
/*      */     } catch (Exception e) {
/*  339 */       this.log.error("not found Entity Define by className:" + clazz.getName());
/*      */     }
/*  341 */     String tableName = entity.getTableName();
/*  342 */     String aliasName = (filter == null) || (filter.getAliasName() == null) ? tableName : filter.getAliasName();
/*      */ 
/*  344 */     List entities = getSuperClassName(entity, null, null);
/*      */ 
/*  346 */     Map domainInfos = getDomainInfo(clazz, filter, sorter, entities);
/*      */ 
/*  348 */     selectSb.append("select ");
/*  349 */     for (int i = 0; i < entities.size(); i++) {
/*  350 */       if (i > 0) {
/*  351 */         selectSb.append(",");
/*      */       }
/*  353 */       selectSb.append(((Entity)entities.get(i)).getTableName()).append(".* ");
/*      */     }
/*      */ 
/*  356 */     countSb.append("select count(*) ");
/*      */ 
/*  359 */     mainSb.append("from ");
/*      */ 
/*  361 */     for (int i = 0; i < entities.size(); i++) {
/*  362 */       if (i > 0)
/*  363 */         mainSb.append(",");
/*  364 */       mainSb.append(((Entity)entities.get(i)).getTableName()).append(" ").append(((Entity)entities.get(i)).getTableName()).append(" ");
/*      */     }
/*      */ 
/*  368 */     for (Map.Entry entry : domainInfos.entrySet()) {
/*  369 */       DomainORInfo domainORInfo = (DomainORInfo)entry.getValue();
/*  370 */       mainSb.append(",").append(domainORInfo.getTableName()).append(" ")
/*  371 */         .append(domainORInfo.getPropertyName()).append(" ");
/*      */     }
/*      */ 
/*  374 */     if ((domainInfos.size() > 0) || (entities.size() > 1)) {
/*  375 */       mainSb.append(" where ");
/*      */     }
/*      */ 
/*  378 */     String[] keySet = (String[])domainInfos.keySet().toArray(new String[domainInfos.keySet().size()]);
/*  379 */     int andSetp = 0;
/*  380 */     for (int i = 0; i < keySet.length; i++) {
/*  381 */       if (andSetp > 0) {
/*  382 */         mainSb.append(" and ");
/*      */       }
/*  384 */       DomainORInfo domainORInfo = (DomainORInfo)domainInfos.get(keySet[i]);
/*  385 */       mainSb.append(domainORInfo.getResourcePropertyName() == null ? aliasName : domainORInfo.getResourcePropertyName()).append(".").append(domainORInfo.getPropertyName())
/*  386 */         .append("=").append(domainORInfo.getPropertyName()).append(".").append("id ");
/*  387 */       andSetp++;
/*      */     }
/*  389 */     if (entities.size() > 1)
/*  390 */       for (int i = 0; i < entities.size() - 1; i++) {
/*  391 */         if (andSetp > 0)
/*  392 */           mainSb.append(" and ");
/*  393 */         mainSb.append(tableName).append(".id = ")
/*  394 */           .append(((Entity)entities.get(i)).getTableName()).append(".id ");
/*  395 */         andSetp++;
/*      */       }
/*      */     List filtergroup;
/*  401 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  402 */       if (andSetp == 0)
/*  403 */         mainSb.append(" where ");
/*      */       else
/*  405 */         mainSb.append(" and ");
/*  406 */       List filterBeans = filter.getConditions();
/*      */ 
/*  408 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/*  410 */       if (filterGroup.size() < 2)
/*  411 */         setupConditions(entities, mainSb, filterBeans, aliasName, null);
/*      */       else {
/*  413 */         for (int i = 0; i < filterGroup.size(); i++) {
/*  414 */           filtergroup = (List)filterGroup.get(i);
/*  415 */           setupConditions(entities, mainSb, filtergroup, aliasName, Integer.valueOf(i));
/*  416 */           mainSb.append(") ");
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  422 */     selectSb.append(mainSb);
/*      */ 
/*  424 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/*  425 */       orderSt = " order by ";
/*      */ 
/*  427 */       Map sorts = sorter.getSorts();
/*  428 */       int _step = 0;
/*  429 */       for (Map.Entry entry : sorts.entrySet()) {
/*  430 */         String properyName = (String)entry.getKey();
/*  431 */         if (!properyName.contains(".")) {
/*  432 */           String _aliasName = aliasName;
/*  433 */           for (Entity _entity : entities) {
/*      */             try {
/*  435 */               Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), _entity, properyName);
/*  436 */               if ((field != null) && (field.getFieldType() != 6))
/*  437 */                 _aliasName = _entity.getTableName();
/*      */             }
/*      */             catch (Exception localException1)
/*      */             {
/*      */             }
/*      */           }
/*  443 */           properyName = _aliasName + "." + properyName;
/*      */         }
/*      */         else {
/*  446 */           String[] domainProperty = properyName.split("[.]");
/*  447 */           properyName = domainProperty[(domainProperty.length - 2)] + "." + domainProperty[(domainProperty.length - 1)];
/*      */         }
/*  449 */         if (_step > 0) {
/*  450 */           orderSt = orderSt + ", ";
/*      */         }
/*  452 */         orderSt = orderSt + properyName + " " + (String)entry.getValue();
/*      */ 
/*  454 */         _step++;
/*      */       }
/*      */     }
/*      */ 
/*  458 */     countSb.append(mainSb);
/*      */ 
/*  461 */     if ((this.sessionFactory.getDialect() instanceof IbatisHiDialect)) {
/*  462 */       IbatisHiDialect dialect = this.sessionFactory.getDialect();
/*  463 */       dialect.getMaxRecode(countSb, filter, page);
/*      */     }
/*      */ 
/*  466 */     Query selectQuery = selectSb.append(orderSt);
/*      */ 
/*  469 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  470 */       List filterBeans = filter.getConditions();
/*  471 */       for (int i = 0; i < filterBeans.size(); i++) {
/*  472 */         FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*      */ 
/*  474 */         if (filterBean.getValue() == null) {
/*      */           continue;
/*      */         }
/*  477 */         String operater = filterBean.getOperater();
/*      */ 
/*  480 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  481 */           String val = (String)filterBean.getValue();
/*      */ 
/*  483 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  484 */             val = "%" + val;
/*  485 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  486 */             val = val + "%";
/*  487 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  488 */             val = "%" + val + "%";
/*      */           else {
/*  490 */             val = "%" + val + "%";
/*      */           }
/*  492 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/*  495 */         setParameter(selectQuery, filterBean.getFieldName() + i, filterBean.getValue());
/*  496 */         if (page != null) {
/*  497 */           setParameter(countSb, filterBean.getFieldName() + i, filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  502 */     Query countQuery = null;
/*  503 */     if (page != null)
/*  504 */       countQuery = countSb;
/*  505 */     Query[] querySql = { selectQuery, countQuery };
/*  506 */     return querySql;
/*      */   }
/*      */ 
/*      */   private void setupConditions(List<Entity> entities, StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*      */   {
/*  511 */     for (int i = 0; i < filterBeans.size(); i++) {
/*  512 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*  513 */       String operater = filterBean.getOperater();
/*  514 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0))
/*  515 */         mainSb.append("( ");
/*  516 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0))
/*  517 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*  518 */       if (i > 0) {
/*  519 */         mainSb.append(" ").append(filterBean.getRelations()).append(" ");
/*      */       }
/*  521 */       if ((aliasName != null) && (!aliasName.trim().equals("")))
/*      */       {
/*  524 */         String tableName = aliasName;
/*  525 */         if (entities.size() > 1) {
/*  526 */           String fieldName = filterBean.getFieldName();
/*  527 */           if (fieldName.contains("."))
/*  528 */             fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  529 */           for (int j = entities.size() - 1; j >= 0; j--) {
/*  530 */             List allFields = ((Entity)entities.get(j)).getField();
/*  531 */             for (Field field : allFields) {
/*  532 */               if (field.getFieldName().equals(fieldName)) {
/*  533 */                 tableName = ((Entity)entities.get(j)).getTableName();
/*  534 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  541 */         if (!filterBean.getFieldName().contains(".")) {
/*  542 */           mainSb.append(tableName + ".");
/*  543 */           mainSb.append(filterBean.getFieldName()).append(" ");
/*      */         }
/*      */         else {
/*  546 */           String[] fieldNames = filterBean.getFieldName().split("[.]");
/*  547 */           mainSb.append(fieldNames[(fieldNames.length - 2)] + "." + fieldNames[(fieldNames.length - 1)]).append(" ");
/*      */         }
/*      */       }
/*      */ 
/*  551 */       Object val = filterBean.getValue();
/*  552 */       if (val == null) {
/*  553 */         if (operater.equals("="))
/*  554 */           mainSb.append("IS NULL ");
/*      */         else
/*  556 */           mainSb.append("IS NOT NULL ");
/*      */       }
/*      */       else {
/*  559 */         mainSb.append(operater).append(" ");
/*      */ 
/*  561 */         if (filterBean.isNot()) {
/*  562 */           mainSb.append("NOT ");
/*      */         }
/*      */ 
/*  565 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  566 */           val = (String)filterBean.getValue();
/*      */ 
/*  568 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  569 */             val = "%" + val;
/*  570 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  571 */             val = val + "%";
/*  572 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  573 */             val = "%" + val + "%";
/*  574 */           filterBean.setValue(val);
/*      */         }
/*  576 */         if (operater.equals("IN")) {
/*  577 */           mainSb.append("(");
/*  578 */           List coll = (List)filterBean.getValue();
/*  579 */           for (int j = 0; j < coll.size(); j++) {
/*  580 */             if (j > 0)
/*  581 */               mainSb.append(",");
/*  582 */             mainSb.append("?");
/*      */           }
/*      */ 
/*  585 */           mainSb.append(") ");
/*      */         }
/*  588 */         else if ((filterBean.getValue() instanceof BaseObject)) {
/*  589 */           mainSb.append(((BaseObject)filterBean.getValue()).getPrimarykey());
/*      */         } else {
/*  591 */           mainSb.append("?");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, PageInfo pageInfo) {
/*  597 */     if (pageInfo == null)
/*  598 */       return new ArrayList();
/*  599 */     Filter filter = null;
/*  600 */     Sorter sorter = null;
/*  601 */     Page page = null;
/*  602 */     filter = pageInfo.getFilter();
/*  603 */     sorter = pageInfo.getSorter();
/*  604 */     page = pageInfo.getPage();
/*  605 */     return getObjects(clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   public Object getUniqueObject(Class clazz, Filter filter)
/*      */   {
/*  612 */     List list = getObjects(clazz, filter);
/*  613 */     if ((list == null) || (list.size() <= 0))
/*  614 */       return null;
/*  615 */     return list.get(0);
/*      */   }
/*      */ 
/*      */   public void removeObject(Object obj)
/*      */   {
/*  622 */     if (obj == null)
/*  623 */       return;
/*  624 */     BaseObject baseObj = (BaseObject)obj;
/*  625 */     Serializable id = baseObj.getPrimarykey();
/*  626 */     removeSubObject(baseObj);
/*  627 */     List entitis = getSuperClassName(obj, null, null);
/*  628 */     for (Entity entity : entitis)
/*  629 */       getSqlMapClientTemplate().delete("del" + entity.getEntityName(), id);
/*      */   }
/*      */ 
/*      */   public void removeObjectById(Class clazz, Serializable id)
/*      */   {
/*  637 */     Object obj = getObjectById(clazz, id);
/*  638 */     removeObject(obj);
/*      */   }
/*      */ 
/*      */   protected void removeSubObject(BaseObject parentObj)
/*      */   {
/*  644 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);
/*  645 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  646 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  647 */       if ((propertyClss == null) || 
/*  648 */         (!List.class.isAssignableFrom(propertyClss))) {
/*      */         continue;
/*      */       }
/*  651 */       String propertyName = propertyDescriptors[i].getName();
/*  652 */       List propertyValues = (List)BeanUtil.getPropertyValue(parentObj, propertyName);
/*  653 */       if ((propertyValues == null) || (propertyValues.size() <= 0)) {
/*      */         continue;
/*      */       }
/*  656 */       for (BaseObject subObject : propertyValues)
/*  657 */         removeObject(subObject);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void saveObject(Object obj)
/*      */   {
/*  667 */     Map map = objectToRow(obj);
/*  668 */     if (!(obj instanceof BaseObject)) return;
/*  669 */     BaseObject bo = (BaseObject)obj;
/*      */ 
/*  671 */     if (!bo.isCascadeDirty()) return;
/*      */ 
/*  674 */     List entites = getSuperClassName(bo, null, null);
/*      */ 
/*  676 */     if (bo.getPrimarykey() == null) {
/*  677 */       for (Entity entity : entites)
/*      */       {
/*  679 */         Object primarykey = getSqlMapClientTemplate().insert("ins" + entity.getEntityName(), map);
/*  680 */         if (primarykey != null) {
/*  681 */           BeanUtil.setPropertyValue(bo, "id", Integer.valueOf(Integer.parseInt(primarykey.toString())));
/*  682 */           bo.setVersion(new Integer(1));
/*      */         }
/*      */       }
/*      */     } else {
/*  686 */       Serializable primaryKey = bo.getPrimarykey();
/*  687 */       BaseObject pObj = (BaseObject)getObjectById(obj.getClass(), primaryKey);
/*  688 */       if (pObj.getVersion().intValue() > bo.getVersion().intValue()) {
/*  689 */         this.log.error("Object " + obj + "save database is dirty!");
/*  690 */         return;
/*      */       }
/*  692 */       for (Entity entity : entites) {
/*  693 */         getSqlMapClientTemplate().update("update" + entity.getEntityName(), map);
/*      */       }
/*      */     }
/*      */ 
/*  697 */     saveSubObject(bo);
/*      */   }
/*      */ 
/*      */   private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity)
/*      */   {
/*  704 */     if (entitis == null) {
/*  705 */       entitis = new ArrayList();
/*      */     }
/*  707 */     String servletRootPath = this.sessionFactory.getServletContext().getRealPath("");
/*  708 */     Entity entity = null;
/*      */     try {
/*  710 */       if (obj != null) {
/*  711 */         if ((obj instanceof BaseObject))
/*  712 */           entity = HSCHelper.getEntity(servletRootPath, obj.getClass());
/*  713 */         if ((obj instanceof Class))
/*  714 */           entity = HSCHelper.getEntity(servletRootPath, (Class)obj);
/*  715 */         if ((obj instanceof Entity))
/*  716 */           entity = (Entity)obj;
/*      */       }
/*      */       else {
/*  719 */         entity = superEntity;
/*      */       }
/*  721 */       ExtendEntity extendEntity = entity.getExtendEntity();
/*  722 */       if ((extendEntity != null) && (extendEntity.getExtendEntityName() != null) && (!extendEntity.getExtendEntityName().trim().equals("")))
/*      */       {
/*  724 */         getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
/*      */       }
/*      */     } catch (Exception localException) {
/*      */     }
/*  728 */     if (entity != null) {
/*  729 */       entitis.add(entity);
/*      */     }
/*  731 */     return entitis;
/*      */   }
/*      */ 
/*      */   protected Map<String, Object> objectToRow(Object obj)
/*      */   {
/*  737 */     Map rowMap = new HashMap();
/*  738 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);
/*  739 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  740 */       if (propertyDescriptors[i].getWriteMethod() == null)
/*      */         continue;
/*  742 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  743 */       String propertyName = propertyDescriptors[i].getName();
/*  744 */       Object propertyValue = BeanUtil.getPropertyValue(obj, propertyName);
/*  745 */       if (propertyClss == null)
/*      */         continue;
/*  747 */       if ((!BaseObject.class.isAssignableFrom(propertyClss)) && (!Collection.class.isAssignableFrom(propertyClss)))
/*      */       {
/*  749 */         rowMap.put(propertyName, propertyValue);
/*      */       }
/*      */       else
/*      */       {
/*  753 */         if (!BaseObject.class.isAssignableFrom(propertyClss))
/*      */           continue;
/*  755 */         BaseObject baseObj = (BaseObject)propertyValue;
/*  756 */         rowMap.put(propertyName, baseObj == null ? null : baseObj.getPrimarykey());
/*      */       }
/*      */     }
/*      */ 
/*  760 */     return rowMap;
/*      */   }
/*      */ 
/*      */   protected void saveSubObject(BaseObject parentObj)
/*      */   {
/*  768 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);
/*  769 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  770 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  771 */       if (!List.class.isAssignableFrom(propertyClss)) {
/*      */         continue;
/*      */       }
/*  774 */       String propertyName = propertyDescriptors[i].getName();
/*  775 */       List propertyValues = (List)BeanUtil.getPropertyValue(parentObj, propertyName);
/*  776 */       if ((propertyValues == null) || (propertyValues.size() <= 0))
/*      */         continue;
/*  778 */       for (BaseObject baseObject : propertyValues) {
/*  779 */         Entity subEntity = null;
/*      */         try {
/*  781 */           subEntity = HSCHelper.getEntity(this.sessionFactory.getServletContext().getRealPath(""), baseObject.getClass());
/*  782 */           List fields = subEntity.getField();
/*  783 */           for (Field field : fields)
/*  784 */             if (field.isIsParent()) {
/*  785 */               String _parentClassName = field.getLookupEntity().getLkEntityName();
/*  786 */               if (!_parentClassName.equals(parentObj.getClass().getSimpleName()))
/*      */                 continue;
/*  788 */               BeanUtil.setPropertyValue(baseObject, field.getFieldName(), parentObj);
/*      */             }
/*      */         } catch (Exception localException) {
/*      */         }
/*  791 */         saveObject(baseObject);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void setParameter(Query query, String parameterName, Object value)
/*      */   {
/*  839 */     if ((value instanceof Collection)) {
/*  840 */       Collection values = (Collection)value;
/*  841 */       int j = 0;
/*  842 */       for (Iterator i = values.iterator(); i.hasNext(); ) {
/*  843 */         Object val = i.next();
/*  844 */         setParameterSingle(query, parameterName + j, val);
/*  845 */         j++;
/*      */       }
/*      */     }
/*      */     else {
/*  849 */       setParameterSingle(query, parameterName, value);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void setParameterSingle(Query query, String parameterName, Object value) {
/*  854 */     if ((value instanceof Boolean))
/*  855 */       query.putParameter(parameterName, Boolean.valueOf(((Boolean)value).booleanValue()));
/*  856 */     else if ((value instanceof Byte))
/*  857 */       query.putParameter(parameterName, Byte.valueOf(((Byte)value).byteValue()));
/*  858 */     else if ((value instanceof Character))
/*  859 */       query.putParameter(parameterName, Character.valueOf(((Character)value).charValue()));
/*  860 */     else if ((value instanceof Double))
/*  861 */       query.putParameter(parameterName, Double.valueOf(((Double)value).doubleValue()));
/*  862 */     else if ((value instanceof Float))
/*  863 */       query.putParameter(parameterName, Float.valueOf(((Float)value).floatValue()));
/*  864 */     else if ((value instanceof Integer))
/*  865 */       query.putParameter(parameterName, Integer.valueOf(((Integer)value).intValue()));
/*  866 */     else if ((value instanceof Long))
/*  867 */       query.putParameter(parameterName, Long.valueOf(((Long)value).longValue()));
/*  868 */     else if ((value instanceof Short))
/*  869 */       query.putParameter(parameterName, Short.valueOf(((Short)value).shortValue()));
/*  870 */     else if ((value instanceof String))
/*  871 */       query.putParameter(parameterName, (String)value);
/*  872 */     else if ((value instanceof byte[]))
/*  873 */       query.putParameter(parameterName, (byte[])value);
/*  874 */     else if ((value instanceof BigDecimal))
/*  875 */       query.putParameter(parameterName, (BigDecimal)value);
/*  876 */     else if ((value instanceof BigInteger))
/*  877 */       query.putParameter(parameterName, (BigInteger)value);
/*  878 */     else if ((value instanceof java.sql.Date))
/*  879 */       query.putParameter(parameterName, (java.sql.Date)value);
/*  880 */     else if ((value instanceof Time))
/*  881 */       query.putParameter(parameterName, (Time)value);
/*  882 */     else if ((value instanceof Timestamp))
/*  883 */       query.putParameter(parameterName, (Timestamp)value);
/*  884 */     else if ((value instanceof java.util.Date))
/*  885 */       query.putParameter(parameterName, (java.util.Date)value);
/*  886 */     else if ((value instanceof Locale))
/*  887 */       query.putParameter(parameterName, (Locale)value);
/*      */     else
/*  889 */       query.putParameter(parameterName, value);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql)
/*      */   {
/*  903 */     return getSQLObjects(sql, null, null, null, null, null);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, Page page)
/*      */   {
/*  918 */     return getSQLObjects(sql, null, null, null, null, page);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz)
/*      */   {
/*  933 */     return getSQLObjects(sql, propertyNames, clazz, null, null);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Page page)
/*      */   {
/*  949 */     return getSQLObjects(sql, propertyNames, clazz, null, null, page);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, Filter filter)
/*      */   {
/*  967 */     return getSQLObjects(sql, null, null, filter, null);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter)
/*      */   {
/*  985 */     return getSQLObjects(sql, propertyNames, clazz, filter, null);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, Filter filter, Sorter sorter)
/*      */   {
/* 1004 */     return getSQLObjects(sql, null, null, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter, Sorter sorter)
/*      */   {
/* 1024 */     return getSQLObjects(sql, propertyNames, clazz, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/* 1049 */     List result = new ArrayList();
/* 1050 */     if ((sql == null) || (sql.trim().equals(""))) {
/* 1051 */       return result;
/*      */     }
/* 1053 */     long startTime = System.currentTimeMillis();
/*      */ 
/* 1055 */     SqlMapClientTemplate sm = getSqlMapClientTemplate();
/* 1056 */     SqlMapClient sqlMapper = sm.getSqlMapClient();
/* 1057 */     List sqlResult = sm.executeWithListResult(new SqlMapClientCallback(sql, filter, sorter, page)
/*      */     {
/*      */       public Object doInSqlMapClient(SqlMapExecutor sqlExecutor) throws SQLException {
/* 1060 */         return BaseDAOIbatis.this.processFind(sqlExecutor, this.val$sql, this.val$filter, this.val$sorter, this.val$page);
/*      */       }
/*      */     });
/* 1064 */     if (this.log.isDebugEnabled()) {
/* 1065 */       long endTime = System.currentTimeMillis();
/* 1066 */       this.log.debug("Query  use:" + (endTime - startTime) + "ms");
/*      */     }
/*      */ 
/* 1069 */     if (clazz == null) {
/* 1070 */       return sqlResult;
/*      */     }
/*      */ 
/* 1074 */     for (Iterator iter = sqlResult.iterator(); iter.hasNext(); ) {
/* 1075 */       Object bean = null;
/* 1076 */       bean = BeanUtil.CreateObject(clazz.getName());
/*      */ 
/* 1078 */       Map resultRow = (Map)iter.next();
/*      */ 
/* 1080 */       if (propertyNames == null) {
/* 1081 */         for (Map.Entry entry : resultRow.entrySet())
/* 1082 */           BeanUtil.ognlPropertyValue(bean, (String)entry.getKey(), entry.getValue());
/*      */       }
/*      */       else {
/* 1085 */         String[] propertyNamesArray = StringUtils.strToStrArray(propertyNames);
/* 1086 */         int _step = 0;
/* 1087 */         for (Map.Entry entry : resultRow.entrySet()) {
/* 1088 */           BeanUtil.ognlPropertyValue(bean, propertyNamesArray[_step], entry.getValue());
/* 1089 */           _step++;
/*      */         }
/*      */       }
/* 1092 */       result.add(bean);
/*      */     }
/* 1094 */     return result;
/*      */   }
/*      */ 
/*      */   List<Object> processFind(SqlMapExecutor sqlExecutor, String sql, Filter filter, Sorter sorter, Page page) throws SQLException {
/* 1098 */     Query[] querys = setupQuery(sqlExecutor, sql, filter, sorter, page);
/* 1099 */     Query selectQuery = querys[0];
/* 1100 */     Query countQuery = querys[1];
/* 1101 */     if (this.sessionFactory.isSqlShow()) {
/* 1102 */       System.out.println(selectQuery);
/* 1103 */       if (countQuery != null)
/* 1104 */         System.out.println(countQuery);
/*      */     }
/* 1106 */     int skip = 0;
/* 1107 */     int max = 0;
/* 1108 */     if ((page != null) && (countQuery != null)) {
/* 1109 */       int count = 0;
/* 1110 */       String name = "countCommon";
/* 1111 */       List countResult = sqlExecutor.queryForList(name, countQuery);
/* 1112 */       if ((countResult != null) && (countResult.size() != 0)) {
/* 1113 */         if (countResult.size() > 1) {
/* 1114 */           count = countResult.size();
/*      */         } else {
/* 1116 */           Object result = countResult.get(0);
/* 1117 */           if ((result instanceof Integer))
/* 1118 */             count = ((Integer)result).intValue();
/* 1119 */           else if ((result instanceof Long))
/* 1120 */             count = ((Long)result).intValue();
/* 1121 */           else if ((result instanceof BigDecimal))
/* 1122 */             count = ((BigDecimal)result).intValue();
/* 1123 */           else if ((result instanceof BigInteger))
/* 1124 */             count = ((BigInteger)result).intValue();
/*      */           else {
/* 1126 */             count = ((Number)result).intValue();
/*      */           }
/*      */         }
/*      */ 
/* 1130 */         count = (page.getMaxRecords() != 0) && (count > page.getMaxRecords()) ? page.getMaxRecords() : count;
/*      */ 
/* 1132 */         page.setTotalRecords(count);
/*      */ 
/* 1134 */         int totoalPage = 0;
/* 1135 */         totoalPage = count % page.getPageSize() > 0 ? count / page.getPageSize() + 1 : count / page.getPageSize();
/* 1136 */         page.setTotalPage(totoalPage);
/*      */       }
/*      */ 
/* 1139 */       skip = page.getStartRowPosition();
/*      */ 
/* 1141 */       if ((page.getMaxRecords() != 0) && (page.getStartRowPosition() + page.getPageSize() > page.getMaxRecords()))
/* 1142 */         max = page.getMaxRecords() - page.getStartRowPosition();
/*      */       else
/* 1144 */         max = page.getPageSize();
/*      */     }
/* 1146 */     String name = "listCommon";
/* 1147 */     if (page == null)
/* 1148 */       return sqlExecutor.queryForList(name, selectQuery);
/* 1149 */     return sqlExecutor.queryForList(name, selectQuery, skip, max);
/*      */   }
/*      */ 
/*      */   private Query[] setupQuery(SqlMapExecutor sqlExecutor, String sql, Filter filter, Sorter sorter, Page page) {
/* 1153 */     Query selectSb = new Query();
/* 1154 */     Query countSb = new Query();
/* 1155 */     String orderSt = "";
/*      */ 
/* 1157 */     selectSb.append(sql);
/*      */ 
/* 1159 */     countSb.append("select count(*) ");
/* 1160 */     if (!StringUtils.trimLeft(sql).startsWith("from")) {
/* 1161 */       countSb.append("from ");
/*      */     }
/*      */ 
/* 1164 */     if ((filter != null) && (filter.getConditions().size() > 0))
/*      */     {
/* 1166 */       if (StringUtils.isInclude(sql, "where"))
/* 1167 */         selectSb.append(" and ");
/*      */       else {
/* 1169 */         selectSb.append(" where ");
/*      */       }
/* 1171 */       List filterBeans = filter.getConditions();
/*      */ 
/* 1173 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/* 1175 */       String aliasName = null;
/* 1176 */       if ((filter.getAliasName() != null) && (!filter.getAliasName().trim().equals(""))) {
/* 1177 */         aliasName = filter.getAliasName();
/*      */       }
/* 1179 */       if (filterGroup.size() < 2)
/* 1180 */         setupConditions(selectSb, filterBeans, aliasName, null);
/*      */       else {
/* 1182 */         for (int i = 0; i < filterGroup.size(); i++) {
/* 1183 */           List filtergroup = (List)filterGroup.get(i);
/* 1184 */           setupConditions(selectSb, filtergroup, aliasName, Integer.valueOf(i));
/* 1185 */           selectSb.append(") ");
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1192 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/* 1193 */       orderSt = " order by ";
/*      */ 
/* 1195 */       if ((filter != null) && (filter.getAliasName() != null)) {
/* 1196 */         orderSt = orderSt + filter.getAliasName() + ".";
/*      */       }
/* 1198 */       orderSt = orderSt + sorter.toString();
/*      */     }
/*      */ 
/* 1203 */     if (page != null) {
/* 1204 */       String selectString = selectSb.toString();
/* 1205 */       if (!StringUtils.trimLeft(sql).startsWith("from"))
/* 1206 */         countSb = countSb.append(selectString.substring(selectString.indexOf("from") + 4));
/*      */     }
/* 1208 */     selectSb.append(orderSt);
/*      */ 
/* 1211 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/* 1212 */       List filterBeans = filter.getConditions();
/* 1213 */       for (Iterator i = filterBeans.iterator(); i.hasNext(); ) {
/* 1214 */         FilterBean filterBean = (FilterBean)i.next();
/* 1215 */         String operater = filterBean.getOperater();
/*      */ 
/* 1218 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/* 1219 */           String val = (String)filterBean.getValue();
/*      */ 
/* 1221 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/* 1222 */             val = "%" + val;
/* 1223 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/* 1224 */             val = val + "%";
/* 1225 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/* 1226 */             val = "%" + val + "%";
/*      */           else {
/* 1228 */             val = "%" + val + "%";
/*      */           }
/* 1230 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/* 1233 */         setParameter(selectSb, filterBean.getFieldName(), filterBean.getValue());
/* 1234 */         if (page != null) {
/* 1235 */           setParameter(countSb, filterBean.getFieldName(), filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/* 1239 */     Query[] querys = { selectSb, countSb };
/* 1240 */     return querys;
/*      */   }
/*      */ 
/*      */   private void setupConditions(Query mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*      */   {
/* 1245 */     for (int i = 0; i < filterBeans.size(); i++) {
/* 1246 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/* 1247 */       String operater = filterBean.getOperater();
/* 1248 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0)) {
/* 1249 */         mainSb.append("( ");
/*      */       }
/* 1251 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0)) {
/* 1252 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*      */       }
/* 1254 */       if (i > 0) {
/* 1255 */         mainSb.append(" ").append(filterBean.getRelations()).append(" ");
/*      */       }
/* 1257 */       if ((aliasName != null) && (!aliasName.trim().equals(""))) {
/* 1258 */         mainSb.append(aliasName + ".");
/*      */       }
/* 1260 */       mainSb.append(filterBean.getFieldName()).append(" ");
/*      */ 
/* 1262 */       Object val = filterBean.getValue();
/* 1263 */       if (val == null) {
/* 1264 */         if (operater.equals("="))
/* 1265 */           mainSb.append("IS NULL ");
/*      */         else
/* 1267 */           mainSb.append("IS NOT NULL ");
/*      */       }
/*      */       else
/*      */       {
/* 1271 */         mainSb.append(operater).append(" ");
/*      */ 
/* 1273 */         if (filterBean.isNot()) {
/* 1274 */           mainSb.append("NOT ");
/*      */         }
/*      */ 
/* 1277 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/* 1278 */           val = (String)filterBean.getValue();
/*      */ 
/* 1280 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/* 1281 */             val = "%" + val;
/* 1282 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/* 1283 */             val = val + "%";
/* 1284 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/* 1285 */             val = "%" + val + "%";
/* 1286 */           filterBean.setValue(val);
/*      */         }
/* 1288 */         if (operater.equals("IN")) {
/* 1289 */           mainSb.append("(");
/* 1290 */           Collection coll = (Collection)filterBean.getValue();
/* 1291 */           for (int j = 0; j < coll.size(); j++) {
/* 1292 */             if (j > 0)
/* 1293 */               mainSb.append(",");
/* 1294 */             mainSb.append("?");
/*      */           }
/* 1296 */           mainSb.append(") ");
/*      */         }
/*      */         else {
/* 1299 */           mainSb.append("? ");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, PageInfo pageInfo)
/*      */   {
/* 1320 */     return getSQLObjects(sql, null, null, pageInfo);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz, PageInfo pageInfo)
/*      */   {
/* 1340 */     if (pageInfo == null) {
/* 1341 */       return new ArrayList();
/*      */     }
/* 1343 */     Filter filter = null;
/* 1344 */     Sorter sorter = null;
/* 1345 */     Page page = null;
/* 1346 */     filter = pageInfo.getFilter();
/* 1347 */     sorter = pageInfo.getSorter();
/* 1348 */     page = pageInfo.getPage();
/* 1349 */     return getSQLObjects(sql, propertyNames, clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   public HiDialect getDialect()
/*      */   {
/* 1354 */     if ((this.sessionFactory.getDialect() instanceof IbatisHiDialect)) {
/* 1355 */       return this.sessionFactory.getDialect();
/*      */     }
/* 1357 */     return null;
/*      */   }
/*      */ 
/*      */   class DomainORInfo
/*      */   {
/*      */     String tableName;
/*      */     String propertyName;
/*      */     String resourcePropertyName;
/*      */ 
/*      */     DomainORInfo()
/*      */     {
/*      */     }
/*      */ 
/*      */     public String getTableName()
/*      */     {
/*  815 */       return this.tableName;
/*      */     }
/*      */     public void setTableName(String tableName) {
/*  818 */       this.tableName = tableName;
/*      */     }
/*      */     public String getPropertyName() {
/*  821 */       return this.propertyName;
/*      */     }
/*      */     public void setPropertyName(String propertyName) {
/*  824 */       this.propertyName = propertyName;
/*      */     }
/*      */     public String getResourcePropertyName() {
/*  827 */       return this.resourcePropertyName;
/*      */     }
/*      */     public void setResourcePropertyName(String resourcePropertyName) {
/*  830 */       this.resourcePropertyName = resourcePropertyName;
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.BaseDAOIbatis
 * JD-Core Version:    0.6.0
 */