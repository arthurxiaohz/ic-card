/*      */ package org.hi.framework.dao.ibatis3;
/*      */ 
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
/*      */ import org.apache.ibatis.exceptions.TooManyResultsException;
/*      */ import org.apache.ibatis.session.SqlSession;
/*      */ import org.apache.ibatis.session.SqlSessionFactory;
/*      */ import org.hi.SpringContextHolder;
/*      */ import org.hi.common.util.BeanUtil;
/*      */ import org.hi.common.util.StringUtils;
/*      */ import org.hi.framework.dao.DAO;
/*      */ import org.hi.framework.dao.Filter;
/*      */ import org.hi.framework.dao.HiDialect;
/*      */ import org.hi.framework.dao.Sorter;
/*      */ import org.hi.framework.dao.ibatis.IbatisHiDialect;
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
/*      */ 
/*      */ public class BaseDAOIbatis extends Ibatis3DaoSupport
/*      */   implements DAO
/*      */ {
/*      */   public static final String ID_PREFIX_GET = "get";
/*      */   public static final String ID_PREFIX_DEL = "del";
/*      */   public static final String ID_PREFIX_INS = "ins";
/*      */   public static final String ID_PREFIX_UPDATE = "update";
/*      */   public static final String ID_PREFIX_LIST = "list";
/*      */   public static final String ID_PREFIX_COUNT = "count";
/*      */   public static final String ID_SUFFIX_QUERYSQL = "querySql";
/*      */   public static final String ID_SUFFIX_QUERYCOUNT = "queryCount";
/*   73 */   protected final Log log = LogFactory.getLog(getClass());
/*      */   private SpringSqlSessionFactoryBuilder clientFactory;
/*      */   private SqlSessionFactory sessionFactory;
/*      */   SqlSession session;
/*      */ 
/*      */   public void setSessionFactory(SqlSessionFactory sessionFactory)
/*      */   {
/*   88 */     super.setSessionFactory(sessionFactory);
/*   89 */     this.clientFactory = ((SpringSqlSessionFactoryBuilder)SpringContextHolder.getBean("&sessionFactory"));
/*      */   }
/*      */ 
/*      */   public Object getObjectById(Class clazz, Serializable id)
/*      */   {
/*   94 */     if ((id == null) || (Integer.parseInt(id.toString()) < 0)) {
/*   95 */       return null;
/*      */     }
/*   97 */     BaseObject bo = null;
/*   98 */     List entitis = getSuperClassName(clazz, null, null);
/*   99 */     if (entitis.size() <= 1) {
/*  100 */       String name = "get" + clazz.getSimpleName();
/*      */       try {
/*  102 */         bo = (BaseObject)execute(new SqlSessionCallback(clazz, name, id)
/*      */         {
/*      */           public Object doInSqlSession(SqlSession session) throws SQLException {
/*  105 */             return (BaseObject)session.selectOne(this.val$clazz.getSimpleName() + "." + this.val$name, this.val$id);
/*      */           } } );
/*      */       } catch (SQLException e) {
/*  109 */         e.printStackTrace();
/*      */       }
/*      */     } else {
/*  112 */       Filter filter = FilterFactory.getSimpleFilter("id", id, "=");
/*  113 */       List result = getObjects(clazz, filter);
/*  114 */       if (result.size() > 0) {
/*  115 */         bo = (BaseObject)result.get(0);
/*      */       }
/*      */     }
/*  118 */     if (bo != null) bo.setDirty(false);
/*  119 */     return bo;
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz)
/*      */   {
/*  124 */     return getObjectCount(clazz, null);
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz, Filter filter) {
/*  128 */     return ((Integer)openSession().selectOne("get" + clazz.getSimpleName() + "count", new Integer(1))).intValue();
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz) {
/*  132 */     return getObjects(clazz, null, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter) {
/*  136 */     return getObjects(clazz, filter, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter, Sorter soter) {
/*  140 */     return getObjects(clazz, filter, soter, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  146 */     List result = new ArrayList();
/*      */     try {
/*  148 */       result = (List)execute(new SqlSessionCallback(clazz, filter, sorter, page)
/*      */       {
/*      */         public Object doInSqlSession(SqlSession session) throws SQLException {
/*  151 */           return BaseDAOIbatis.this.processFind(session, this.val$clazz, this.val$filter, this.val$sorter, this.val$page);
/*      */         } } );
/*      */     } catch (SQLException e) {
/*  155 */       e.printStackTrace();
/*      */     }
/*  157 */     return result;
/*      */   }
/*      */   List processFind(SqlSession session, Class clazz, Filter filter, Sorter sorter, Page page) throws SQLException {
/*  160 */     Query[] querys = setupQuery(session, clazz, filter, sorter, page);
/*  161 */     Query selectQuery = querys[0];
/*  162 */     Query countQuery = querys[1];
/*  163 */     if (this.clientFactory.isSqlShow()) {
/*  164 */       System.out.println(selectQuery);
/*  165 */       if (countQuery != null)
/*  166 */         System.out.println(countQuery);
/*      */     }
/*  168 */     int skip = 0;
/*  169 */     int max = 0;
/*  170 */     if ((page != null) && (countQuery != null)) {
/*  171 */       int count = 0;
/*  172 */       String name = "count" + clazz.getSimpleName();
/*      */ 
/*  174 */       List countResult = new ArrayList();
/*      */ 
/*  176 */       countResult = session.selectList(clazz.getSimpleName() + "." + name, countQuery);
/*      */ 
/*  178 */       if ((countResult != null) && (countResult.size() != 0)) {
/*  179 */         if (countResult.size() > 1) {
/*  180 */           count = countResult.size();
/*      */         } else {
/*  182 */           Object result = countResult.get(0);
/*  183 */           if ((result instanceof Integer))
/*  184 */             count = ((Integer)result).intValue();
/*  185 */           else if ((result instanceof Long))
/*  186 */             count = ((Long)result).intValue();
/*  187 */           else if ((result instanceof BigDecimal))
/*  188 */             count = ((BigDecimal)result).intValue();
/*  189 */           else if ((result instanceof BigInteger))
/*  190 */             count = ((BigInteger)result).intValue();
/*      */           else {
/*  192 */             count = ((Number)result).intValue();
/*      */           }
/*      */         }
/*      */ 
/*  196 */         count = (page.getMaxRecords() != 0) && (count > page.getMaxRecords()) ? page.getMaxRecords() : count;
/*      */ 
/*  198 */         page.setTotalRecords(count);
/*      */ 
/*  200 */         int totoalPage = 0;
/*  201 */         totoalPage = count % page.getPageSize() > 0 ? count / page.getPageSize() + 1 : count / page.getPageSize();
/*  202 */         page.setTotalPage(totoalPage);
/*      */       }
/*      */ 
/*  205 */       skip = page.getStartRowPosition();
/*      */ 
/*  207 */       if ((page.getMaxRecords() != 0) && (page.getStartRowPosition() + page.getPageSize() > page.getMaxRecords()))
/*  208 */         max = page.getMaxRecords() - page.getStartRowPosition();
/*      */       else
/*  210 */         max = page.getPageSize();
/*      */     }
/*  212 */     String name = "list" + clazz.getSimpleName();
/*  213 */     List lastResult = new ArrayList();
/*  214 */     if (page == null)
/*      */     {
/*  216 */       lastResult = session.selectList(clazz.getSimpleName() + "." + name, selectQuery);
/*  217 */       return lastResult;
/*      */     }
/*  219 */     int _skip = skip;
/*  220 */     int _max = max;
/*  221 */     lastResult = session.selectList(clazz.getSimpleName() + "." + name, selectQuery, _skip, _max);
/*  222 */     return lastResult;
/*      */   }
/*      */ 
/*      */   private Map<String, DomainORInfo> getDomainInfo(Class clazz, Filter filter, Sorter sorter, List<Entity> entities)
/*      */   {
/*  228 */     Map result = new HashMap();
/*      */     String[] domainProperty;
/*  229 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  230 */       List filterBeans1 = filter.getConditions();
/*  231 */       for (int i = 0; i < filterBeans1.size(); i++) {
/*  232 */         FilterBean filterBean = (FilterBean)filterBeans1.get(i);
/*  233 */         if (!filterBean.getFieldName().contains(".")) {
/*      */           continue;
/*      */         }
/*  236 */         domainProperty = filterBean.getFieldName().split("[.]");
/*  237 */         PropertyDescriptor domainPropertyDescriptor = null;
/*  238 */         Entity domainEntity = null;
/*  239 */         Class dominClazz = clazz;
/*  240 */         for (int j = 0; j < domainProperty.length - 1; j++) {
/*      */           try {
/*  242 */             domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[j]);
/*  243 */             dominClazz = domainPropertyDescriptor.getPropertyType();
/*  244 */             domainEntity = HSCHelper.getEntity(this.clientFactory.getServletContext().getRealPath(""), dominClazz); } catch (Exception e) {
/*  245 */             continue;
/*      */           }
/*  247 */           DomainORInfo domainInfo = new DomainORInfo();
/*  248 */           domainInfo.setTableName(domainEntity.getTableName());
/*  249 */           domainInfo.setPropertyName(domainProperty[j]);
/*      */ 
/*  251 */           if (j > 0) {
/*  252 */             domainInfo.setResourcePropertyName(domainProperty[(j - 1)]);
/*      */           }
/*      */ 
/*  255 */           if ((entities.size() > 1) && (j <= 0)) {
/*  256 */             String fieldName = filterBean.getFieldName();
/*  257 */             if (fieldName.contains("."))
/*  258 */               fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  259 */             for (int z = entities.size() - 1; z >= 0; z--) {
/*  260 */               List allFields = ((Entity)entities.get(z)).getField();
/*  261 */               for (Field field : allFields) {
/*  262 */                 if (field.getFieldName().equals(fieldName)) {
/*  263 */                   domainInfo.setResourcePropertyName(((Entity)entities.get(z)).getTableName());
/*  264 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*  269 */           result.put(domainProperty[j], domainInfo);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  274 */     if ((sorter != null) && (sorter.getSorts().size() > 0)) {
/*  275 */       Map sorterMap = sorter.getSorts();
/*  276 */       Set keyValue = sorterMap.keySet();
/*  277 */       for (String string : keyValue) {
/*  278 */         if (!string.contains("."))
/*      */           continue;
/*  280 */         String[] domainProperty = string.split("[.]");
/*  281 */         PropertyDescriptor domainPropertyDescriptor = null;
/*      */ 
/*  283 */         Class dominClazz = clazz;
/*  284 */         for (int i = 0; i < domainProperty.length - 1; i++) {
/*      */           try {
/*  286 */             domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[i]);
/*  287 */             dominClazz = domainPropertyDescriptor.getPropertyType();
/*  288 */             domainEntity = HSCHelper.getEntity(this.clientFactory.getServletContext().getRealPath(""), dominClazz);
/*      */           }
/*      */           catch (Exception e)
/*      */           {
/*      */             Entity domainEntity;
/*  289 */             continue;
/*      */           }
/*      */           Entity domainEntity;
/*  291 */           DomainORInfo domainInfo = new DomainORInfo();
/*  292 */           domainInfo.setTableName(domainEntity.getTableName());
/*  293 */           domainInfo.setPropertyName(domainProperty[i]);
/*  294 */           if (i > 0) {
/*  295 */             domainInfo.setResourcePropertyName(domainProperty[(i - 1)]);
/*      */           }
/*      */ 
/*  298 */           if ((entities.size() > 1) && (i <= 0)) {
/*  299 */             String fieldName = string;
/*  300 */             if (fieldName.contains("."))
/*  301 */               fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  302 */             for (int z = entities.size() - 1; z >= 0; z--) {
/*  303 */               List allFields = ((Entity)entities.get(z)).getField();
/*  304 */               for (Field field : allFields) {
/*  305 */                 if (field.getFieldName().equals(fieldName)) {
/*  306 */                   domainInfo.setResourcePropertyName(((Entity)entities.get(z)).getTableName());
/*  307 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*  312 */           result.put(domainProperty[i], domainInfo);
/*      */         }
/*      */       }
/*      */     }
/*  316 */     return result;
/*      */   }
/*      */ 
/*      */   private Query[] setupQuery(SqlSession session, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  323 */     StringBuffer mainSb = new StringBuffer();
/*  324 */     Query countSb = new Query();
/*  325 */     Query selectSb = new Query();
/*  326 */     String orderSt = "";
/*      */ 
/*  328 */     Entity entity = null;
/*      */     try
/*      */     {
/*  331 */       entity = HSCHelper.getEntity(this.clientFactory.getServletContext().getRealPath(""), clazz);
/*      */     } catch (Exception localException) {
/*      */     }
/*  334 */     String tableName = entity.getTableName();
/*  335 */     String aliasName = (filter == null) || (filter.getAliasName() == null) ? tableName : filter.getAliasName();
/*      */ 
/*  337 */     List entities = getSuperClassName(entity, null, null);
/*      */ 
/*  339 */     Map domainInfos = getDomainInfo(clazz, filter, sorter, entities);
/*      */ 
/*  341 */     selectSb.append("select ");
/*  342 */     for (int i = 0; i < entities.size(); i++) {
/*  343 */       if (i > 0) {
/*  344 */         selectSb.append(",");
/*      */       }
/*  346 */       selectSb.append(((Entity)entities.get(i)).getTableName()).append(".* ");
/*      */     }
/*      */ 
/*  349 */     countSb.append("select count(*) ");
/*      */ 
/*  352 */     mainSb.append("from ");
/*      */ 
/*  354 */     for (int i = 0; i < entities.size(); i++) {
/*  355 */       if (i > 0)
/*  356 */         mainSb.append(",");
/*  357 */       mainSb.append(((Entity)entities.get(i)).getTableName()).append(" ").append(((Entity)entities.get(i)).getTableName()).append(" ");
/*      */     }
/*      */ 
/*  361 */     for (Map.Entry entry : domainInfos.entrySet()) {
/*  362 */       DomainORInfo domainORInfo = (DomainORInfo)entry.getValue();
/*  363 */       mainSb.append(",").append(domainORInfo.getTableName()).append(" ")
/*  364 */         .append(domainORInfo.getPropertyName()).append(" ");
/*      */     }
/*      */ 
/*  367 */     if ((domainInfos.size() > 0) || (entities.size() > 1)) {
/*  368 */       mainSb.append(" where ");
/*      */     }
/*      */ 
/*  371 */     String[] keySet = (String[])domainInfos.keySet().toArray(new String[domainInfos.keySet().size()]);
/*  372 */     int andSetp = 0;
/*  373 */     for (int i = 0; i < keySet.length; i++) {
/*  374 */       if (andSetp > 0) {
/*  375 */         mainSb.append(" and ");
/*      */       }
/*  377 */       DomainORInfo domainORInfo = (DomainORInfo)domainInfos.get(keySet[i]);
/*  378 */       mainSb.append(domainORInfo.getResourcePropertyName() == null ? aliasName : domainORInfo.getResourcePropertyName()).append(".").append(domainORInfo.getPropertyName())
/*  379 */         .append("=").append(domainORInfo.getPropertyName()).append(".").append("id ");
/*  380 */       andSetp++;
/*      */     }
/*  382 */     if (entities.size() > 1)
/*  383 */       for (int i = 0; i < entities.size() - 1; i++) {
/*  384 */         if (andSetp > 0)
/*  385 */           mainSb.append(" and ");
/*  386 */         mainSb.append(tableName).append(".id = ")
/*  387 */           .append(((Entity)entities.get(i)).getTableName()).append(".id ");
/*  388 */         andSetp++;
/*      */       }
/*      */     List filtergroup;
/*  394 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  395 */       if (andSetp == 0)
/*  396 */         mainSb.append(" where ");
/*      */       else
/*  398 */         mainSb.append(" and ");
/*  399 */       List filterBeans = filter.getConditions();
/*      */ 
/*  401 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/*  403 */       if (filterGroup.size() < 2)
/*  404 */         setupConditions(entities, mainSb, filterBeans, aliasName, null);
/*      */       else {
/*  406 */         for (int i = 0; i < filterGroup.size(); i++) {
/*  407 */           filtergroup = (List)filterGroup.get(i);
/*  408 */           setupConditions(entities, mainSb, filtergroup, aliasName, Integer.valueOf(i));
/*  409 */           mainSb.append(") ");
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  415 */     selectSb.append(mainSb);
/*      */ 
/*  417 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/*  418 */       orderSt = " order by ";
/*      */ 
/*  420 */       Map sorts = sorter.getSorts();
/*  421 */       int _step = 0;
/*  422 */       for (Map.Entry entry : sorts.entrySet()) {
/*  423 */         String properyName = (String)entry.getKey();
/*  424 */         if (!properyName.contains(".")) {
/*  425 */           String _aliasName = aliasName;
/*  426 */           for (Entity _entity : entities) {
/*      */             try {
/*  428 */               Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), _entity, properyName);
/*  429 */               if ((field != null) && (field.getFieldType() != 6))
/*  430 */                 _aliasName = _entity.getTableName();
/*      */             }
/*      */             catch (Exception localException1)
/*      */             {
/*      */             }
/*      */           }
/*  436 */           properyName = _aliasName + "." + properyName;
/*      */         }
/*      */         else {
/*  439 */           String[] domainProperty = properyName.split("[.]");
/*  440 */           properyName = domainProperty[(domainProperty.length - 2)] + "." + domainProperty[(domainProperty.length - 1)];
/*      */         }
/*  442 */         if (_step > 0) {
/*  443 */           orderSt = orderSt + ", ";
/*      */         }
/*  445 */         orderSt = orderSt + properyName + " " + (String)entry.getValue();
/*      */ 
/*  447 */         _step++;
/*      */       }
/*      */     }
/*      */ 
/*  451 */     countSb.append(mainSb);
/*      */ 
/*  453 */     if ((getDialect() instanceof IbatisHiDialect)) {
/*  454 */       IbatisHiDialect dialect = (IbatisHiDialect)getDialect();
/*  455 */       dialect.getMaxRecode(countSb, filter, page);
/*      */     }
/*      */ 
/*  458 */     Query selectQuery = selectSb.append(orderSt);
/*  459 */     selectQuery.setEntity(entity);
/*      */ 
/*  462 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  463 */       List filterBeans = filter.getConditions();
/*  464 */       for (int i = 0; i < filterBeans.size(); i++) {
/*  465 */         FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*      */ 
/*  467 */         if (filterBean.getValue() == null) {
/*      */           continue;
/*      */         }
/*  470 */         String operater = filterBean.getOperater();
/*      */ 
/*  473 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  474 */           String val = (String)filterBean.getValue();
/*      */ 
/*  476 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  477 */             val = "%" + val;
/*  478 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  479 */             val = val + "%";
/*  480 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  481 */             val = "%" + val + "%";
/*      */           else {
/*  483 */             val = "%" + val + "%";
/*      */           }
/*  485 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/*  488 */         setParameter(selectQuery, filterBean.getFieldName(), filterBean.getValue());
/*  489 */         if (page != null) {
/*  490 */           setParameter(countSb, filterBean.getFieldName(), filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  495 */     Query countQuery = null;
/*  496 */     if (page != null) {
/*  497 */       countQuery = countSb;
/*  498 */       countQuery.setEntity(entity);
/*      */     }
/*      */ 
/*  501 */     selectQuery.setClazz(clazz);
/*  502 */     Query[] querySql = { selectQuery, countQuery };
/*  503 */     return querySql;
/*      */   }
/*      */ 
/*      */   private void setupConditions(List<Entity> entities, StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*      */   {
/*  508 */     for (int i = 0; i < filterBeans.size(); i++) {
/*  509 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*  510 */       String operater = filterBean.getOperater();
/*  511 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0))
/*  512 */         mainSb.append("( ");
/*  513 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0))
/*  514 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*  515 */       if (i > 0) {
/*  516 */         mainSb.append(" ").append(filterBean.getRelations()).append(" ");
/*      */       }
/*  518 */       if ((aliasName != null) && (!aliasName.trim().equals("")))
/*      */       {
/*  521 */         String tableName = aliasName;
/*  522 */         if (entities.size() > 1) {
/*  523 */           String fieldName = filterBean.getFieldName();
/*  524 */           if (fieldName.contains("."))
/*  525 */             fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  526 */           for (int j = entities.size() - 1; j >= 0; j--) {
/*  527 */             List allFields = ((Entity)entities.get(j)).getField();
/*  528 */             for (Field field : allFields) {
/*  529 */               if (field.getFieldName().equals(fieldName)) {
/*  530 */                 tableName = ((Entity)entities.get(j)).getTableName();
/*  531 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  538 */         if (!filterBean.getFieldName().contains(".")) {
/*  539 */           mainSb.append(tableName + ".");
/*  540 */           mainSb.append(filterBean.getFieldName()).append(" ");
/*      */         }
/*      */         else {
/*  543 */           String[] fieldNames = filterBean.getFieldName().split("[.]");
/*  544 */           mainSb.append(fieldNames[(fieldNames.length - 2)] + "." + fieldNames[(fieldNames.length - 1)]).append(" ");
/*      */         }
/*      */       }
/*      */ 
/*  548 */       Object val = filterBean.getValue();
/*  549 */       if (val == null) {
/*  550 */         if (operater.equals("="))
/*  551 */           mainSb.append("IS NULL ");
/*      */         else
/*  553 */           mainSb.append("IS NOT NULL ");
/*      */       }
/*      */       else {
/*  556 */         mainSb.append(operater).append(" ");
/*      */ 
/*  558 */         if (filterBean.isNot()) {
/*  559 */           mainSb.append("NOT ");
/*      */         }
/*      */ 
/*  562 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  563 */           val = (String)filterBean.getValue();
/*      */ 
/*  565 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  566 */             val = "%" + val;
/*  567 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  568 */             val = val + "%";
/*  569 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  570 */             val = "%" + val + "%";
/*  571 */           filterBean.setValue(val);
/*      */         }
/*  573 */         if (operater.equals("IN")) {
/*  574 */           mainSb.append("(");
/*  575 */           List coll = (List)filterBean.getValue();
/*  576 */           for (int j = 0; j < coll.size(); j++) {
/*  577 */             if (j > 0)
/*  578 */               mainSb.append(",");
/*  579 */             mainSb.append("?");
/*      */           }
/*      */ 
/*  582 */           mainSb.append(") ");
/*      */         }
/*  585 */         else if ((filterBean.getValue() instanceof BaseObject)) {
/*  586 */           mainSb.append(((BaseObject)filterBean.getValue()).getPrimarykey());
/*      */         } else {
/*  588 */           mainSb.append("?");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, PageInfo pageInfo) {
/*  594 */     if (pageInfo == null)
/*  595 */       return new ArrayList();
/*  596 */     Filter filter = null;
/*  597 */     Sorter sorter = null;
/*  598 */     Page page = null;
/*  599 */     filter = pageInfo.getFilter();
/*  600 */     sorter = pageInfo.getSorter();
/*  601 */     page = pageInfo.getPage();
/*  602 */     return getObjects(clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   public Object getUniqueObject(Class clazz, Filter filter) {
/*  606 */     List list = getObjects(clazz, filter);
/*  607 */     if ((list == null) || (list.size() <= 0))
/*  608 */       return null;
/*  609 */     return list.get(0);
/*      */   }
/*      */ 
/*      */   public void removeObject(Object obj) {
/*  613 */     if (obj == null)
/*  614 */       return;
/*  615 */     BaseObject baseObj = (BaseObject)obj;
/*  616 */     Serializable id = baseObj.getPrimarykey();
/*  617 */     removeSubObject(baseObj);
/*  618 */     List entitis = getSuperClassName(obj, null, null);
/*  619 */     for (Entity entity : entitis) {
/*  620 */       String entityName = entity.getEntityName();
/*      */       try {
/*  622 */         execute(new SqlSessionCallback(entityName, id)
/*      */         {
/*      */           public Object doInSqlSession(SqlSession session) throws SQLException {
/*  625 */             return Integer.valueOf(session.delete(this.val$entityName + "." + "del" + this.val$entityName, this.val$id));
/*      */           } } );
/*      */       }
/*      */       catch (SQLException e) {
/*  630 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public void removeObjectById(Class clazz, Serializable id) {
/*  636 */     Object obj = getObjectById(clazz, id);
/*  637 */     removeObject(obj);
/*      */   }
/*      */ 
/*      */   protected void removeSubObject(BaseObject parentObj) {
/*  641 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);
/*  642 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  643 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  644 */       if ((propertyClss == null) || 
/*  645 */         (!List.class.isAssignableFrom(propertyClss))) {
/*      */         continue;
/*      */       }
/*  648 */       String propertyName = propertyDescriptors[i].getName();
/*  649 */       List propertyValues = (List)BeanUtil.getPropertyValue(parentObj, propertyName);
/*  650 */       if ((propertyValues == null) || (propertyValues.size() <= 0)) {
/*      */         continue;
/*      */       }
/*  653 */       for (BaseObject subObject : propertyValues)
/*  654 */         removeObject(subObject);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void saveObject(Object obj)
/*      */   {
/*  661 */     Map map = objectToRow(obj);
/*  662 */     if (!(obj instanceof BaseObject)) return;
/*  663 */     BaseObject bo = (BaseObject)obj;
/*      */ 
/*  665 */     if (!bo.isCascadeDirty()) return;
/*      */ 
/*  668 */     List entites = getSuperClassName(bo, null, null);
/*      */ 
/*  670 */     if (bo.getPrimarykey() == null) {
/*  671 */       for (Entity entity : entites) {
/*  672 */         Object primarykey = null;
/*      */         try {
/*  674 */           primarykey = execute(new SqlSessionCallback(entity, map)
/*      */           {
/*      */             public Object doInSqlSession(SqlSession session) throws SQLException {
/*  677 */               session.insert(this.val$entity.getEntityName() + "." + "ins" + this.val$entity.getEntityName(), this.val$map);
/*  678 */               return this.val$map.get("id");
/*      */             } } );
/*      */         } catch (SQLException e) {
/*  682 */           e.printStackTrace();
/*      */         }
/*      */ 
/*  685 */         if (primarykey != null) {
/*  686 */           BeanUtil.setPropertyValue(bo, "id", Integer.valueOf(Integer.parseInt(primarykey.toString())));
/*  687 */           bo.setVersion(new Integer(1));
/*      */         }
/*      */       }
/*      */     } else {
/*  691 */       Serializable primaryKey = bo.getPrimarykey();
/*  692 */       BaseObject pObj = (BaseObject)getObjectById(obj.getClass(), primaryKey);
/*  693 */       if (pObj.getVersion().intValue() > bo.getVersion().intValue()) {
/*  694 */         this.log.error("Object " + obj + "save database is dirty!");
/*  695 */         return;
/*      */       }
/*  697 */       for (Entity entity : entites) {
/*      */         try {
/*  699 */           execute(new SqlSessionCallback(entity, map)
/*      */           {
/*      */             public Object doInSqlSession(SqlSession session) throws SQLException {
/*  702 */               return Integer.valueOf(session.update(this.val$entity.getEntityName() + "." + "update" + this.val$entity.getEntityName(), this.val$map));
/*      */             } } );
/*      */         } catch (SQLException e) {
/*  706 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*      */     try
/*      */     {
/*  712 */       saveSubObject(bo);
/*      */     } catch (SQLException e) {
/*  714 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity) {
/*  719 */     if (entitis == null) {
/*  720 */       entitis = new ArrayList();
/*      */     }
/*  722 */     String servletRootPath = this.clientFactory.getServletContext().getRealPath("");
/*  723 */     Entity entity = null;
/*      */     try {
/*  725 */       if (obj != null) {
/*  726 */         if ((obj instanceof BaseObject))
/*  727 */           entity = HSCHelper.getEntity(servletRootPath, obj.getClass());
/*  728 */         if ((obj instanceof Class))
/*  729 */           entity = HSCHelper.getEntity(servletRootPath, (Class)obj);
/*  730 */         if ((obj instanceof Entity))
/*  731 */           entity = (Entity)obj;
/*      */       }
/*      */       else {
/*  734 */         entity = superEntity;
/*      */       }
/*  736 */       ExtendEntity extendEntity = entity.getExtendEntity();
/*  737 */       if ((extendEntity != null) && (extendEntity.getExtendEntityName() != null) && (!extendEntity.getExtendEntityName().trim().equals("")))
/*  738 */         getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
/*      */     }
/*      */     catch (Exception localException) {
/*      */     }
/*  742 */     if (entity != null) {
/*  743 */       entitis.add(entity);
/*      */     }
/*  745 */     return entitis;
/*      */   }
/*      */ 
/*      */   protected Map<String, Object> objectToRow(Object obj)
/*      */   {
/*  751 */     Map rowMap = new HashMap();
/*  752 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);
/*  753 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  754 */       if (propertyDescriptors[i].getWriteMethod() == null)
/*      */         continue;
/*  756 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  757 */       String propertyName = propertyDescriptors[i].getName();
/*  758 */       Object propertyValue = BeanUtil.getPropertyValue(obj, propertyName);
/*  759 */       if ((!BaseObject.class.isAssignableFrom(propertyClss)) && (!Collection.class.isAssignableFrom(propertyClss))) {
/*  760 */         rowMap.put(propertyName, propertyValue);
/*      */       }
/*      */       else {
/*  763 */         if (!BaseObject.class.isAssignableFrom(propertyClss))
/*      */           continue;
/*  765 */         BaseObject baseObj = (BaseObject)propertyValue;
/*  766 */         rowMap.put(propertyName, baseObj == null ? null : baseObj.getPrimarykey());
/*      */       }
/*      */     }
/*      */ 
/*  770 */     return rowMap;
/*      */   }
/*      */ 
/*      */   protected void saveSubObject(BaseObject parentObj)
/*      */     throws SQLException
/*      */   {
/*  779 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);
/*  780 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  781 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  782 */       if (!List.class.isAssignableFrom(propertyClss)) {
/*      */         continue;
/*      */       }
/*  785 */       String propertyName = propertyDescriptors[i].getName();
/*  786 */       List propertyValues = (List)BeanUtil.getPropertyValue(parentObj, propertyName);
/*  787 */       if ((propertyValues == null) || (propertyValues.size() <= 0))
/*      */         continue;
/*  789 */       for (BaseObject baseObject : propertyValues) {
/*  790 */         Entity subEntity = null;
/*      */         try {
/*  792 */           subEntity = HSCHelper.getEntity(this.clientFactory.getServletContext().getRealPath(""), baseObject.getClass());
/*  793 */           List fields = subEntity.getField();
/*  794 */           for (Field field : fields)
/*  795 */             if (field.isIsParent()) {
/*  796 */               String _parentClassName = field.getLookupEntity().getLkEntityName();
/*  797 */               if (!_parentClassName.equals(parentObj.getClass().getSimpleName()))
/*      */                 continue;
/*  799 */               BeanUtil.setPropertyValue(baseObject, field.getFieldName(), parentObj);
/*      */             }
/*      */         } catch (Exception localException) {
/*      */         }
/*  802 */         saveObject(baseObject);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void setParameter(Query query, String parameterName, Object value)
/*      */   {
/*  840 */     if ((value instanceof Collection)) {
/*  841 */       Collection values = (Collection)value;
/*  842 */       for (Iterator i = values.iterator(); i.hasNext(); ) {
/*  843 */         Object val = i.next();
/*  844 */         setParameterSingle(query, parameterName, val);
/*      */       }
/*      */     }
/*      */     else {
/*  848 */       setParameterSingle(query, parameterName, value);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void setParameterSingle(Query query, String parameterName, Object value)
/*      */   {
/*  854 */     parameterName = parameterName.replaceAll("[.]", "#");
/*  855 */     if ((value instanceof Boolean))
/*  856 */       query.putParameter(parameterName, Boolean.valueOf(((Boolean)value).booleanValue()));
/*  857 */     else if ((value instanceof Byte))
/*  858 */       query.putParameter(parameterName, Byte.valueOf(((Byte)value).byteValue()));
/*  859 */     else if ((value instanceof Character))
/*  860 */       query.putParameter(parameterName, Character.valueOf(((Character)value).charValue()));
/*  861 */     else if ((value instanceof Double))
/*  862 */       query.putParameter(parameterName, Double.valueOf(((Double)value).doubleValue()));
/*  863 */     else if ((value instanceof Float))
/*  864 */       query.putParameter(parameterName, Float.valueOf(((Float)value).floatValue()));
/*  865 */     else if ((value instanceof Integer))
/*  866 */       query.putParameter(parameterName, Integer.valueOf(((Integer)value).intValue()));
/*  867 */     else if ((value instanceof Long))
/*  868 */       query.putParameter(parameterName, Long.valueOf(((Long)value).longValue()));
/*  869 */     else if ((value instanceof Short))
/*  870 */       query.putParameter(parameterName, Short.valueOf(((Short)value).shortValue()));
/*  871 */     else if ((value instanceof String))
/*  872 */       query.putParameter(parameterName, (String)value);
/*  873 */     else if ((value instanceof byte[]))
/*  874 */       query.putParameter(parameterName, (byte[])value);
/*  875 */     else if ((value instanceof BigDecimal))
/*  876 */       query.putParameter(parameterName, (BigDecimal)value);
/*  877 */     else if ((value instanceof BigInteger))
/*  878 */       query.putParameter(parameterName, (BigInteger)value);
/*  879 */     else if ((value instanceof java.sql.Date))
/*  880 */       query.putParameter(parameterName, (java.sql.Date)value);
/*  881 */     else if ((value instanceof Time))
/*  882 */       query.putParameter(parameterName, (Time)value);
/*  883 */     else if ((value instanceof Timestamp))
/*  884 */       query.putParameter(parameterName, (Timestamp)value);
/*  885 */     else if ((value instanceof java.util.Date))
/*  886 */       query.putParameter(parameterName, (java.util.Date)value);
/*  887 */     else if ((value instanceof Locale))
/*  888 */       query.putParameter(parameterName, (Locale)value);
/*      */     else
/*  890 */       query.putParameter(parameterName, value);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, Class clazz) throws SQLException {
/*  894 */     return getSQLObjects(sql, null, clazz, null, null, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql)
/*      */     throws SQLException
/*      */   {
/*  912 */     return getSQLObjects(sql, null, null, null, null, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, Class calzz, Page page)
/*      */     throws SQLException
/*      */   {
/*  929 */     return getSQLObjects(sql, null, calzz, null, null, page);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz)
/*      */     throws SQLException
/*      */   {
/*  952 */     return getSQLObjects(sql, propertyNames, clazz, null, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz, Page page)
/*      */     throws SQLException
/*      */   {
/*  976 */     return getSQLObjects(sql, propertyNames, clazz, null, null, page);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, Filter filter)
/*      */     throws SQLException
/*      */   {
/*  995 */     return getSQLObjects(sql, null, null, filter, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter)
/*      */     throws SQLException
/*      */   {
/* 1018 */     return getSQLObjects(sql, propertyNames, clazz, filter, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, Class clazz, Filter filter, Sorter sorter)
/*      */     throws SQLException
/*      */   {
/* 1038 */     return getSQLObjects(sql, null, clazz, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter, Sorter sorter)
/*      */     throws SQLException
/*      */   {
/* 1063 */     return getSQLObjects(sql, propertyNames, clazz, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */     throws SQLException
/*      */   {
/* 1115 */     List result = new ArrayList();
/* 1116 */     if ((sql == null) || (sql.trim().equals(""))) {
/* 1117 */       return result;
/*      */     }
/*      */ 
/* 1120 */     List sqlResult = (List)execute(new SqlSessionCallback(sql, filter, sorter, page, clazz) {
/*      */       public Object doInSqlSession(SqlSession session) throws SQLException {
/* 1122 */         return BaseDAOIbatis.this.processFind(session, this.val$sql, this.val$filter, this.val$sorter, this.val$page, this.val$clazz);
/*      */       }
/*      */     });
/* 1126 */     if ((clazz == null) || (propertyNames == null)) {
/* 1127 */       return sqlResult;
/*      */     }
/*      */ 
/* 1131 */     for (Iterator iter = sqlResult.iterator(); iter.hasNext(); ) {
/* 1132 */       Object bean = null;
/* 1133 */       bean = BeanUtil.CreateObject(clazz.getName());
/*      */ 
/* 1135 */       Map resultRow = (Map)iter.next();
/*      */ 
/* 1137 */       if (propertyNames == null) {
/* 1138 */         for (Map.Entry entry : resultRow.entrySet())
/* 1139 */           BeanUtil.ognlPropertyValue(bean, (String)entry.getKey(), entry.getValue());
/*      */       }
/*      */       else {
/* 1142 */         String[] propertyNamesArray = StringUtils.strToStrArray(propertyNames);
/* 1143 */         int _step = 0;
/* 1144 */         for (Map.Entry entry : resultRow.entrySet()) {
/* 1145 */           BeanUtil.ognlPropertyValue(bean, propertyNamesArray[_step], entry.getValue());
/* 1146 */           _step++;
/*      */         }
/*      */       }
/* 1149 */       result.add(bean);
/*      */     }
/* 1151 */     return result;
/*      */   }
/*      */ 
/*      */   List processFind(SqlSession session, String sql, Filter filter, Sorter sorter, Page page, Class clazz) throws SQLException {
/* 1155 */     Query[] querys = setupQuery(session, sql, filter, sorter, page, clazz);
/* 1156 */     Query selectQuery = querys[0];
/* 1157 */     Query countQuery = querys[1];
/* 1158 */     if (this.clientFactory.isSqlShow()) {
/* 1159 */       System.out.println(selectQuery);
/* 1160 */       if (countQuery != null)
/* 1161 */         System.out.println(countQuery);
/*      */     }
/* 1163 */     int skip = 0;
/* 1164 */     int max = 0;
/* 1165 */     if ((page != null) && (countQuery != null)) {
/* 1166 */       int count = 0;
/* 1167 */       String name = "hi.commonCount";
/* 1168 */       List countResult = new ArrayList();
/* 1169 */       countResult = session.selectList("hi.commonCount", countQuery);
/* 1170 */       if ((countResult != null) && (countResult.size() != 0)) {
/* 1171 */         if (countResult.size() > 1) {
/* 1172 */           count = countResult.size();
/*      */         } else {
/* 1174 */           Object result = countResult.get(0);
/* 1175 */           if ((result instanceof Integer))
/* 1176 */             count = ((Integer)result).intValue();
/* 1177 */           else if ((result instanceof Long))
/* 1178 */             count = ((Long)result).intValue();
/* 1179 */           else if ((result instanceof BigDecimal))
/* 1180 */             count = ((BigDecimal)result).intValue();
/* 1181 */           else if ((result instanceof BigInteger))
/* 1182 */             count = ((BigInteger)result).intValue();
/*      */           else {
/* 1184 */             count = ((Number)result).intValue();
/*      */           }
/*      */         }
/*      */ 
/* 1188 */         count = (page.getMaxRecords() != 0) && (count > page.getMaxRecords()) ? page.getMaxRecords() : count;
/*      */ 
/* 1190 */         page.setTotalRecords(count);
/*      */ 
/* 1192 */         int totoalPage = 0;
/* 1193 */         totoalPage = count % page.getPageSize() > 0 ? count / page.getPageSize() + 1 : count / page.getPageSize();
/* 1194 */         page.setTotalPage(totoalPage);
/*      */       }
/*      */ 
/* 1197 */       skip = page.getStartRowPosition();
/* 1198 */       if ((page.getMaxRecords() != 0) && (page.getStartRowPosition() + page.getPageSize() > page.getMaxRecords()))
/* 1199 */         max = page.getMaxRecords() - page.getStartRowPosition();
/*      */       else
/* 1201 */         max = page.getPageSize();
/*      */     }
/* 1203 */     String name = "hi.commonList";
/* 1204 */     List lastResult = new ArrayList();
/* 1205 */     if (page == null)
/*      */     {
/* 1207 */       lastResult = session.selectList("hi.commonList", selectQuery);
/*      */     } else {
/* 1209 */       int _skip = skip;
/* 1210 */       int _max = max;
/* 1211 */       lastResult = session.selectList("hi.commonList", selectQuery, _skip, _max);
/*      */     }
/* 1213 */     return lastResult;
/*      */   }
/*      */ 
/*      */   private Query[] setupQuery(SqlSession session, String sql, Filter filter, Sorter sorter, Page page, Class clazz) {
/* 1217 */     Query selectSb = new Query();
/* 1218 */     Query countSb = new Query();
/* 1219 */     String orderSt = "";
/*      */ 
/* 1221 */     selectSb.append(sql);
/*      */ 
/* 1223 */     countSb.append("select count(*) ");
/* 1224 */     if (!StringUtils.trimLeft(sql).startsWith("from")) {
/* 1225 */       countSb.append("from ");
/*      */     }
/*      */ 
/* 1228 */     if ((filter != null) && (filter.getConditions().size() > 0))
/*      */     {
/* 1230 */       if (StringUtils.isInclude(sql, "where"))
/* 1231 */         selectSb.append(" and ");
/*      */       else {
/* 1233 */         selectSb.append(" where ");
/*      */       }
/* 1235 */       List filterBeans = filter.getConditions();
/*      */ 
/* 1237 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/* 1239 */       String aliasName = null;
/* 1240 */       if ((filter.getAliasName() != null) && (!filter.getAliasName().trim().equals(""))) {
/* 1241 */         aliasName = filter.getAliasName();
/*      */       }
/* 1243 */       if (filterGroup.size() < 2)
/* 1244 */         setupConditions(selectSb, filterBeans, aliasName, null);
/*      */       else {
/* 1246 */         for (int i = 0; i < filterGroup.size(); i++) {
/* 1247 */           List filtergroup = (List)filterGroup.get(i);
/* 1248 */           setupConditions(selectSb, filtergroup, aliasName, Integer.valueOf(i));
/* 1249 */           selectSb.append(") ");
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1256 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/* 1257 */       orderSt = " order by ";
/*      */ 
/* 1259 */       if ((filter != null) && (filter.getAliasName() != null)) {
/* 1260 */         orderSt = orderSt + filter.getAliasName() + ".";
/*      */       }
/* 1262 */       orderSt = orderSt + sorter.toString();
/*      */     }
/*      */ 
/* 1267 */     if (page != null) {
/* 1268 */       String selectString = selectSb.toString();
/* 1269 */       if (!StringUtils.trimLeft(sql).startsWith("from"))
/* 1270 */         countSb = countSb.append(selectString.substring(selectString.indexOf("from") + 4));
/*      */     }
/* 1272 */     selectSb.append(orderSt);
/*      */ 
/* 1275 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/* 1276 */       List filterBeans = filter.getConditions();
/* 1277 */       for (Iterator i = filterBeans.iterator(); i.hasNext(); ) {
/* 1278 */         FilterBean filterBean = (FilterBean)i.next();
/* 1279 */         String operater = filterBean.getOperater();
/*      */ 
/* 1282 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/* 1283 */           String val = (String)filterBean.getValue();
/*      */ 
/* 1285 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/* 1286 */             val = "%" + val;
/* 1287 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/* 1288 */             val = val + "%";
/* 1289 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/* 1290 */             val = "%" + val + "%";
/*      */           else {
/* 1292 */             val = "%" + val + "%";
/*      */           }
/* 1294 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/* 1297 */         setParameter(selectSb, filterBean.getFieldName(), filterBean.getValue());
/* 1298 */         if (page != null) {
/* 1299 */           setParameter(countSb, filterBean.getFieldName(), filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/* 1303 */     selectSb.setClazz(clazz);
/* 1304 */     Query[] querys = { selectSb, countSb };
/* 1305 */     return querys;
/*      */   }
/*      */ 
/*      */   private void setupConditions(Query mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*      */   {
/* 1310 */     for (int i = 0; i < filterBeans.size(); i++) {
/* 1311 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/* 1312 */       String operater = filterBean.getOperater();
/* 1313 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0)) {
/* 1314 */         mainSb.append("( ");
/*      */       }
/* 1316 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0)) {
/* 1317 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*      */       }
/* 1319 */       if (i > 0) {
/* 1320 */         mainSb.append(" ").append(filterBean.getRelations()).append(" ");
/*      */       }
/* 1322 */       if ((aliasName != null) && (!aliasName.trim().equals(""))) {
/* 1323 */         mainSb.append(aliasName + ".");
/*      */       }
/* 1325 */       mainSb.append(filterBean.getFieldName()).append(" ");
/*      */ 
/* 1327 */       Object val = filterBean.getValue();
/* 1328 */       if (val == null) {
/* 1329 */         if (operater.equals("="))
/* 1330 */           mainSb.append("IS NULL ");
/*      */         else
/* 1332 */           mainSb.append("IS NOT NULL ");
/*      */       }
/*      */       else
/*      */       {
/* 1336 */         mainSb.append(operater).append(" ");
/*      */ 
/* 1338 */         if (filterBean.isNot()) {
/* 1339 */           mainSb.append("NOT ");
/*      */         }
/*      */ 
/* 1342 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/* 1343 */           val = (String)filterBean.getValue();
/*      */ 
/* 1345 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/* 1346 */             val = "%" + val;
/* 1347 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/* 1348 */             val = val + "%";
/* 1349 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/* 1350 */             val = "%" + val + "%";
/* 1351 */           filterBean.setValue(val);
/*      */         }
/* 1353 */         if (operater.equals("IN")) {
/* 1354 */           mainSb.append("(");
/* 1355 */           Collection coll = (Collection)filterBean.getValue();
/* 1356 */           for (int j = 0; j < coll.size(); j++) {
/* 1357 */             if (j > 0)
/* 1358 */               mainSb.append(",");
/* 1359 */             mainSb.append("?");
/*      */           }
/* 1361 */           mainSb.append(") ");
/*      */         }
/*      */         else {
/* 1364 */           mainSb.append("? ");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, PageInfo pageInfo)
/*      */     throws SQLException
/*      */   {
/* 1386 */     return getSQLObjects(sql, null, null, pageInfo);
/*      */   }
/*      */ 
/*      */   protected List getSQLObjects(String sql, String propertyNames, Class clazz, PageInfo pageInfo)
/*      */     throws SQLException
/*      */   {
/* 1407 */     if (pageInfo == null) {
/* 1408 */       return new ArrayList();
/*      */     }
/* 1410 */     Filter filter = null;
/* 1411 */     Sorter sorter = null;
/* 1412 */     Page page = null;
/* 1413 */     filter = pageInfo.getFilter();
/* 1414 */     sorter = pageInfo.getSorter();
/* 1415 */     page = pageInfo.getPage();
/* 1416 */     return getSQLObjects(sql, propertyNames, clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   protected Object getSQLObject(String sql, String propertyNames, Class clazz, Filter filter)
/*      */     throws SQLException
/*      */   {
/* 1422 */     List list = getSQLObjects(sql, propertyNames, clazz, filter);
/* 1423 */     if (list.size() == 1) {
/* 1424 */       return list.get(0);
/*      */     }
/* 1426 */     if (list.size() > 1) {
/* 1427 */       throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
/*      */     }
/*      */ 
/* 1430 */     return null;
/*      */   }
/*      */ 
/*      */   protected Object getSQLObject(String sql, Class clazz) throws SQLException
/*      */   {
/* 1435 */     return getSQLObject(sql, null, clazz, null);
/*      */   }
/*      */ 
/*      */   protected Object getSQLObject(String sql, Class clazz, Filter filter) throws SQLException {
/* 1439 */     return getSQLObject(sql, null, clazz, filter);
/*      */   }
/*      */ 
/*      */   public HiDialect getDialect()
/*      */   {
/* 1444 */     if ((this.clientFactory.getDialet() instanceof IbatisHiDialect)) {
/* 1445 */       return this.clientFactory.getDialet();
/*      */     }
/* 1447 */     return null;
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
/*  817 */       return this.tableName;
/*      */     }
/*      */     public void setTableName(String tableName) {
/*  820 */       this.tableName = tableName;
/*      */     }
/*      */     public String getPropertyName() {
/*  823 */       return this.propertyName;
/*      */     }
/*      */     public void setPropertyName(String propertyName) {
/*  826 */       this.propertyName = propertyName;
/*      */     }
/*      */     public String getResourcePropertyName() {
/*  829 */       return this.resourcePropertyName;
/*      */     }
/*      */     public void setResourcePropertyName(String resourcePropertyName) {
/*  832 */       this.resourcePropertyName = resourcePropertyName;
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.BaseDAOIbatis
 * JD-Core Version:    0.6.0
 */