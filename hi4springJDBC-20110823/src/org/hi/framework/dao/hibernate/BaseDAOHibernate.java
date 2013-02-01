/*      */ package org.hi.framework.dao.hibernate;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.hi.common.util.BeanUtil;
/*      */ import org.hi.common.util.StringUtils;
/*      */ import org.hi.framework.dao.DAO;
/*      */ import org.hi.framework.dao.Filter;
/*      */ import org.hi.framework.dao.HiDialect;
/*      */ import org.hi.framework.dao.Sorter;
/*      */ import org.hi.framework.dao.impl.FilterBean;
/*      */ import org.hi.framework.dao.impl.LikeFilter;
/*      */ import org.hi.framework.paging.Page;
/*      */ import org.hi.framework.paging.PageInfo;
/*      */ import org.hi.framework.paging.impl.PageImpl;
/*      */ import org.hibernate.HibernateException;
/*      */ import org.hibernate.Query;
/*      */ import org.hibernate.Session;
/*      */ import org.hibernate.engine.SessionFactoryImplementor;
/*      */ import org.springframework.orm.hibernate3.HibernateCallback;
/*      */ import org.springframework.orm.hibernate3.HibernateTemplate;
/*      */ import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*      */ 
/*      */ public class BaseDAOHibernate extends HibernateDaoSupport
/*      */   implements DAO
/*      */ {
/*   59 */   protected final Log log = LogFactory.getLog(getClass());
/*      */ 
/*      */   public void saveObject(Object obj)
/*      */   {
/*   65 */     Session session = getHibernateSession();
/*   66 */     if (session != null)
/*   67 */       session.saveOrUpdate(obj);
/*      */     else
/*   69 */       getHibernateTemplate().saveOrUpdate(obj);
/*      */   }
/*      */ 
/*      */   public void saveObjects(Collection coll, int mode)
/*      */   {
/*   77 */     Session session = getHibernateSession();
/*   78 */     if (session != null) {
/*   79 */       for (Iterator it = coll.iterator(); it.hasNext(); ) {
/*   80 */         session.saveOrUpdate(it.next());
/*      */       }
/*      */     }
/*      */     else
/*   84 */       getHibernateTemplate().saveOrUpdateAll(coll);
/*      */   }
/*      */ 
/*      */   public void removeObjectById(Class clazz, Serializable id)
/*      */   {
/*   91 */     Session session = getHibernateSession();
/*   92 */     if (session != null)
/*   93 */       session.delete(getObjectById(clazz, id));
/*      */     else
/*   95 */       getHibernateTemplate().delete(getObjectById(clazz, id));
/*      */   }
/*      */ 
/*      */   public void removeObject(Object obj)
/*      */   {
/*  102 */     Session session = getHibernateSession();
/*  103 */     if (session != null)
/*  104 */       session.delete(obj);
/*      */     else
/*  106 */       getHibernateTemplate().delete(obj);
/*      */   }
/*      */ 
/*      */   public Object getObjectById(Class clazz, Serializable id)
/*      */   {
/*  113 */     Session session = getHibernateSession();
/*  114 */     if (session != null) {
/*  115 */       return session.get(clazz, id);
/*      */     }
/*  117 */     return getHibernateTemplate().get(clazz, id);
/*      */   }
/*      */ 
/*      */   public Object getUniqueObject(Class clazz, Filter filter)
/*      */   {
/*  124 */     Session session = getHibernateSession();
/*  125 */     if (session != null) {
/*  126 */       return processUnique(session, clazz, filter);
/*      */     }
/*  128 */     HibernateTemplate ht = getHibernateTemplate();
/*  129 */     Object result = ht.execute(new HibernateCallback(clazz, filter)
/*      */     {
/*      */       public Object doInHibernate(Session session) throws HibernateException, SQLException {
/*  132 */         return BaseDAOHibernate.this.processUnique(session, this.val$clazz, this.val$filter);
/*      */       }
/*      */     });
/*  135 */     return result;
/*      */   }
/*      */ 
/*      */   Object processUnique(Session session, Class clazz, Filter filter)
/*      */   {
/*  146 */     Query[] queries = setupQuery(session, clazz, filter, null, null);
/*  147 */     Query query = queries[0];
/*  148 */     long startTime = System.currentTimeMillis();
/*  149 */     Object result = query.uniqueResult();
/*  150 */     long endTime = System.currentTimeMillis();
/*  151 */     if (this.log.isDebugEnabled()) {
/*  152 */       this.log.debug("Query string: " + query.getQueryString() + "\n\t use:" + (
/*  153 */         endTime - startTime) + "ms");
/*      */     }
/*  155 */     return result;
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz)
/*      */   {
/*  163 */     return getHibernateTemplate().loadAll(clazz);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter)
/*      */   {
/*  170 */     return getObjects(clazz, filter, null, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter, Sorter soter)
/*      */   {
/*  177 */     return getObjects(clazz, filter, soter, null);
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  185 */     Session session = getHibernateSession();
/*  186 */     if (session != null) {
/*  187 */       return processFind(session, clazz, filter, sorter, page);
/*      */     }
/*      */ 
/*  190 */     HibernateTemplate ht = getHibernateTemplate();
/*  191 */     List result = ht.executeFind(new HibernateCallback(clazz, filter, sorter, page)
/*      */     {
/*      */       public Object doInHibernate(Session session) throws HibernateException, SQLException {
/*  194 */         return BaseDAOHibernate.this.processFind(session, this.val$clazz, this.val$filter, this.val$sorter, this.val$page);
/*      */       }
/*      */     });
/*  197 */     return result;
/*      */   }
/*      */ 
/*      */   public List getObjects(Class clazz, PageInfo pageInfo)
/*      */   {
/*  205 */     if (pageInfo == null) {
/*  206 */       return new ArrayList();
/*      */     }
/*  208 */     Filter filter = null;
/*  209 */     Sorter sorter = null;
/*  210 */     Page page = null;
/*  211 */     filter = pageInfo.getFilter();
/*  212 */     sorter = pageInfo.getSorter();
/*  213 */     page = pageInfo.getPage();
/*      */ 
/*  215 */     return getObjects(clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   List processFind(Session session, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  231 */     Query[] querys = setupQuery(session, clazz, filter, sorter, page);
/*  232 */     return executQuery(querys, page);
/*      */   }
/*      */ 
/*      */   List executQuery(Query[] querys, Page page)
/*      */   {
/*  242 */     Query query = querys[0];
/*  243 */     Query countQuery = querys[1];
/*      */ 
/*  245 */     if ((page != null) && (countQuery != null)) {
/*  246 */       int count = 0;
/*  247 */       List countResult = countQuery.list();
/*      */ 
/*  249 */       if ((countResult != null) && (countResult.size() != 0)) {
/*  250 */         if (countResult.size() > 1) {
/*  251 */           count = countResult.size();
/*      */         } else {
/*  253 */           Object result = countResult.get(0);
/*  254 */           if ((result instanceof Integer))
/*  255 */             count = ((Integer)result).intValue();
/*  256 */           else if ((result instanceof Long))
/*  257 */             count = ((Long)result).intValue();
/*  258 */           else if ((result instanceof BigDecimal))
/*  259 */             count = ((BigDecimal)result).intValue();
/*  260 */           else if ((result instanceof BigInteger))
/*  261 */             count = ((BigInteger)result).intValue();
/*      */           else {
/*  263 */             count = ((Number)result).intValue();
/*      */           }
/*      */         }
/*      */ 
/*  267 */         count = (page.getMaxRecords() != 0) && (count > page.getMaxRecords()) ? page.getMaxRecords() : count;
/*      */ 
/*  269 */         page.setTotalRecords(count);
/*      */ 
/*  271 */         int totoalPage = 0;
/*  272 */         totoalPage = count % page.getPageSize() > 0 ? count / page.getPageSize() + 1 : count / page.getPageSize();
/*  273 */         page.setTotalPage(totoalPage);
/*      */       }
/*      */ 
/*  276 */       query.setFirstResult(page.getStartRowPosition());
/*      */ 
/*  278 */       if ((page.getMaxRecords() != 0) && (page.getStartRowPosition() + page.getPageSize() > page.getMaxRecords()))
/*  279 */         query.setMaxResults(page.getMaxRecords() - page.getStartRowPosition());
/*      */       else {
/*  281 */         query.setMaxResults(page.getPageSize());
/*      */       }
/*      */     }
/*  284 */     long startTime = System.currentTimeMillis();
/*  285 */     List result = query.list();
/*  286 */     long endTime = System.currentTimeMillis();
/*  287 */     if (this.log.isDebugEnabled()) {
/*  288 */       this.log.debug("Query string: " + query.getQueryString() + "\n\t use:" + (
/*  289 */         endTime - startTime) + "ms");
/*      */     }
/*  291 */     return result;
/*      */   }
/*      */ 
/*      */   private Query[] setupQuery(Session session, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  305 */     StringBuffer mainSb = new StringBuffer();
/*  306 */     StringBuffer countSb = new StringBuffer();
/*  307 */     String orderSt = "";
/*      */ 
/*  309 */     String aliasName = clazz.getSimpleName().toLowerCase() + "_1";
/*  310 */     if ((filter != null) && (filter.getAliasName() != null) && (!filter.getAliasName().trim().equals(""))) {
/*  311 */       aliasName = filter.getAliasName();
/*      */     }
/*  313 */     countSb.append("select count(*) ");
/*  314 */     mainSb.append("from ").append(clazz.getName()).append(" " + aliasName + " ");
/*      */ 
/*  317 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  318 */       mainSb.append(" where ");
/*  319 */       List filterBeans = filter.getConditions();
/*      */ 
/*  321 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/*  323 */       if (filterGroup.size() < 2)
/*  324 */         setupConditions(mainSb, filterBeans, aliasName, null);
/*      */       else {
/*  326 */         for (int i = 0; i < filterGroup.size(); i++) {
/*  327 */           List filtergroup = (List)filterGroup.get(i);
/*  328 */           setupConditions(mainSb, filtergroup, aliasName, Integer.valueOf(i));
/*  329 */           mainSb.append(") ");
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  335 */     countSb.append(mainSb);
/*      */ 
/*  337 */     String countHql = countSb.toString();
/*  338 */     SessionFactoryImplementor sessionFactory = (SessionFactoryImplementor)session.getSessionFactory();
/*      */ 
/*  341 */     if ((sessionFactory.getDialect() instanceof HibernateHiDialect)) {
/*  342 */       HibernateHiDialect dialect = (HibernateHiDialect)sessionFactory.getDialect();
/*  343 */       countHql = dialect.getMaxRecode(countHql, filter, page);
/*      */     }
/*      */ 
/*  347 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/*  348 */       orderSt = " order by " + aliasName + "." + sorter.toString();
/*      */     }
/*      */ 
/*  351 */     Query countQuery = null; Query query = null;
/*  352 */     if (page != null)
/*  353 */       countQuery = session.createQuery(countHql);
/*  354 */     query = session.createQuery(orderSt);
/*      */ 
/*  357 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  358 */       IntWrapper mainIntWrapper = new IntWrapper(null);
/*  359 */       IntWrapper countIntWrapper = new IntWrapper(null);
/*  360 */       List filterBeans = filter.getConditions();
/*  361 */       for (Iterator i = filterBeans.iterator(); i.hasNext(); ) {
/*  362 */         FilterBean filterBean = (FilterBean)i.next();
/*      */ 
/*  364 */         if (filterBean.getValue() == null) {
/*      */           continue;
/*      */         }
/*  367 */         String operater = filterBean.getOperater();
/*      */ 
/*  370 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  371 */           String val = (String)filterBean.getValue();
/*      */ 
/*  373 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  374 */             val = "%" + val;
/*  375 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  376 */             val = val + "%";
/*  377 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  378 */             val = "%" + val + "%";
/*      */           else {
/*  380 */             val = "%" + val + "%";
/*      */           }
/*  382 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/*  385 */         setParameter(query, mainIntWrapper, filterBean.getValue());
/*  386 */         if (page != null) {
/*  387 */           setParameter(countQuery, countIntWrapper, filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/*  391 */     Query[] querys = { query, countQuery };
/*  392 */     return querys;
/*      */   }
/*      */ 
/*      */   private void setupConditions(StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*      */   {
/*  397 */     for (int i = 0; i < filterBeans.size(); i++) {
/*  398 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*  399 */       String operater = filterBean.getOperater();
/*  400 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0)) {
/*  401 */         mainSb.append("( ");
/*      */       }
/*  403 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0)) {
/*  404 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*      */       }
/*  406 */       if (i > 0) {
/*  407 */         mainSb.append(filterBean.getRelations()).append(" ");
/*      */       }
/*  409 */       if ((aliasName != null) && (!aliasName.trim().equals(""))) {
/*  410 */         mainSb.append(aliasName + ".");
/*      */       }
/*  412 */       mainSb.append(filterBean.getFieldName()).append(" ");
/*      */ 
/*  416 */       Object val = filterBean.getValue();
/*  417 */       if (val == null) {
/*  418 */         if (operater.equals("="))
/*  419 */           mainSb.append("IS NULL ");
/*      */         else
/*  421 */           mainSb.append("IS NOT NULL ");
/*      */       }
/*      */       else
/*      */       {
/*  425 */         mainSb.append(operater).append(" ");
/*      */ 
/*  427 */         if (filterBean.isNot()) {
/*  428 */           mainSb.append("NOT ");
/*      */         }
/*  430 */         if (operater.equals("IN")) {
/*  431 */           mainSb.append("(");
/*  432 */           Collection coll = (Collection)filterBean.getValue();
/*  433 */           for (int j = 0; j < coll.size(); j++) {
/*  434 */             if (j > 0)
/*  435 */               mainSb.append(",");
/*  436 */             mainSb.append("?");
/*      */           }
/*  438 */           mainSb.append(") ");
/*      */         }
/*      */         else {
/*  441 */           mainSb.append("? ");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void setParameter(Query query, IntWrapper index, Object value)
/*      */   {
/*  450 */     if ((value instanceof Collection)) {
/*  451 */       Collection values = (Collection)value;
/*  452 */       for (Iterator i = values.iterator(); i.hasNext(); ) {
/*  453 */         Object val = i.next();
/*  454 */         setParameterSingle(query, index.getInt(), val);
/*  455 */         index.IntAddOne();
/*      */       }
/*      */     }
/*      */     else {
/*  459 */       setParameterSingle(query, index.getInt(), value);
/*  460 */       index.IntAddOne();
/*      */     }
/*      */   }
/*      */ 
/*      */   private Query setParameterSingle(Query query, int index, Object value)
/*      */   {
/*      */     Query result;
/*      */     Query result;
/*  467 */     if ((value instanceof Boolean)) {
/*  468 */       result = query.setBoolean(index, ((Boolean)value).booleanValue());
/*      */     }
/*      */     else
/*      */     {
/*      */       Query result;
/*  469 */       if ((value instanceof Byte)) {
/*  470 */         result = query.setByte(index, ((Byte)value).byteValue());
/*      */       }
/*      */       else
/*      */       {
/*      */         Query result;
/*  471 */         if ((value instanceof Character)) {
/*  472 */           result = query.setCharacter(index, ((Character)value).charValue());
/*      */         }
/*      */         else
/*      */         {
/*      */           Query result;
/*  473 */           if ((value instanceof Double)) {
/*  474 */             result = query.setDouble(index, ((Double)value).doubleValue());
/*      */           }
/*      */           else
/*      */           {
/*      */             Query result;
/*  475 */             if ((value instanceof Float)) {
/*  476 */               result = query.setFloat(index, ((Float)value).floatValue());
/*      */             }
/*      */             else
/*      */             {
/*      */               Query result;
/*  477 */               if ((value instanceof Integer)) {
/*  478 */                 result = query.setInteger(index, ((Integer)value).intValue());
/*      */               }
/*      */               else
/*      */               {
/*      */                 Query result;
/*  479 */                 if ((value instanceof Long)) {
/*  480 */                   result = query.setLong(index, ((Long)value).longValue());
/*      */                 }
/*      */                 else
/*      */                 {
/*      */                   Query result;
/*  481 */                   if ((value instanceof Short)) {
/*  482 */                     result = query.setShort(index, ((Short)value).shortValue());
/*      */                   }
/*      */                   else
/*      */                   {
/*      */                     Query result;
/*  483 */                     if ((value instanceof String)) {
/*  484 */                       result = query.setString(index, (String)value);
/*      */                     }
/*      */                     else
/*      */                     {
/*      */                       Query result;
/*  485 */                       if ((value instanceof byte[])) {
/*  486 */                         result = query.setBinary(index, (byte[])value);
/*      */                       }
/*      */                       else
/*      */                       {
/*      */                         Query result;
/*  487 */                         if ((value instanceof BigDecimal)) {
/*  488 */                           result = query.setBigDecimal(index, (BigDecimal)value);
/*      */                         }
/*      */                         else
/*      */                         {
/*      */                           Query result;
/*  489 */                           if ((value instanceof BigInteger)) {
/*  490 */                             result = query.setBigInteger(index, (BigInteger)value);
/*      */                           }
/*      */                           else
/*      */                           {
/*      */                             Query result;
/*  491 */                             if ((value instanceof java.sql.Date)) {
/*  492 */                               result = query.setDate(index, (java.sql.Date)value);
/*      */                             }
/*      */                             else
/*      */                             {
/*      */                               Query result;
/*  493 */                               if ((value instanceof Time)) {
/*  494 */                                 result = query.setTime(index, (Time)value);
/*      */                               }
/*      */                               else
/*      */                               {
/*      */                                 Query result;
/*  495 */                                 if ((value instanceof Timestamp)) {
/*  496 */                                   result = query.setTimestamp(index, (Timestamp)value);
/*      */                                 }
/*      */                                 else
/*      */                                 {
/*      */                                   Query result;
/*  497 */                                   if ((value instanceof java.util.Date)) {
/*  498 */                                     result = query.setDate(index, (java.util.Date)value);
/*      */                                   }
/*      */                                   else
/*      */                                   {
/*      */                                     Query result;
/*  499 */                                     if ((value instanceof Locale))
/*  500 */                                       result = query.setLocale(index, (Locale)value);
/*      */                                     else
/*  502 */                                       result = query.setParameter(index, value); 
/*      */                                   }
/*      */                                 }
/*      */                               }
/*      */                             }
/*      */                           }
/*      */                         }
/*      */                       }
/*      */                     }
/*      */                   }
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  504 */     return result;
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz)
/*      */   {
/*  511 */     return getObjectCount(clazz, null);
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz, Filter filter)
/*      */   {
/*  519 */     Session session = getHibernateSession();
/*  520 */     if (session != null) {
/*  521 */       return processCount(session, clazz, filter);
/*      */     }
/*      */ 
/*  524 */     HibernateTemplate ht = getHibernateTemplate();
/*  525 */     Object result = ht.execute(new HibernateCallback(clazz, filter)
/*      */     {
/*      */       public Object doInHibernate(Session session) throws HibernateException, SQLException {
/*  528 */         return Integer.valueOf(BaseDAOHibernate.this.processCount(session, this.val$clazz, this.val$filter));
/*      */       }
/*      */     });
/*  532 */     return ((Integer)result).intValue();
/*      */   }
/*      */ 
/*      */   protected int getHQLObjectCount(String hql)
/*      */   {
/*  541 */     return getHQLObjectCount(hql, null);
/*      */   }
/*      */ 
/*      */   private int getHQLObjectCount(String hql, Filter filter)
/*      */   {
/*  550 */     Session session = getHibernateSession();
/*  551 */     if (session != null) {
/*  552 */       return processCount(session, hql, filter);
/*      */     }
/*  554 */     HibernateTemplate ht = getHibernateTemplate();
/*  555 */     Object result = ht.execute(new HibernateCallback(hql, filter)
/*      */     {
/*      */       public Object doInHibernate(Session session) throws HibernateException, SQLException {
/*  558 */         return Integer.valueOf(BaseDAOHibernate.this.processCount(session, this.val$hql, this.val$filter));
/*      */       }
/*      */     });
/*  561 */     return ((Integer)result).intValue();
/*      */   }
/*      */ 
/*      */   int processCount(Session session, Object obj, Filter filter)
/*      */   {
/*  566 */     Query[] querys = (Query[])null;
/*  567 */     if ((obj instanceof Class)) {
/*  568 */       Class clazz = (Class)obj;
/*      */ 
/*  570 */       querys = setupQuery(session, clazz, filter, null, new PageImpl());
/*      */     }
/*  572 */     if ((obj instanceof String)) {
/*  573 */       String hql = (String)obj;
/*      */ 
/*  576 */       querys = setupQuery(session, hql, filter, null, new PageImpl());
/*      */     }
/*      */ 
/*  579 */     return executQuery(querys);
/*      */   }
/*      */ 
/*      */   int executQuery(Query[] querys) {
/*  583 */     Query countQuery = querys[1];
/*      */ 
/*  585 */     int count = 0;
/*  586 */     if (countQuery != null) {
/*  587 */       List countResult = countQuery.list();
/*      */ 
/*  589 */       if ((countResult != null) && (countResult.size() != 0)) {
/*  590 */         if (countResult.size() > 1) {
/*  591 */           count = countResult.size();
/*      */         } else {
/*  593 */           Object result = countResult.get(0);
/*  594 */           if ((result instanceof Integer)) {
/*  595 */             count = ((Integer)result).intValue();
/*      */           }
/*  597 */           if ((result instanceof Long)) {
/*  598 */             count = ((Long)result).intValue();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  603 */     return count;
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql)
/*      */   {
/*  619 */     return getHQLObjects(hql, null, null, null, null, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, Page page)
/*      */   {
/*  634 */     return getHQLObjects(hql, null, null, null, null, page);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, String propertyNames, Class clazz)
/*      */   {
/*  655 */     return getHQLObjects(hql, propertyNames, clazz, null, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, String propertyNames, Class clazz, Page page)
/*      */   {
/*  678 */     return getHQLObjects(hql, propertyNames, clazz, null, null, page);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, Filter filter)
/*      */   {
/*  695 */     return getHQLObjects(hql, null, null, filter, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter)
/*      */   {
/*  716 */     return getHQLObjects(hql, propertyNames, clazz, filter, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, Filter filter, Sorter sorter)
/*      */   {
/*  734 */     return getHQLObjects(hql, null, null, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter, Sorter sorter)
/*      */   {
/*  757 */     return getHQLObjects(hql, propertyNames, clazz, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  784 */     return getHQLObjects(hql, null, null, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  809 */     List result = new ArrayList();
/*  810 */     if ((hql == null) || (hql.trim().equals(""))) {
/*  811 */       return result;
/*      */     }
/*      */ 
/*  814 */     Session session = getHibernateSession();
/*      */     List hqlResult;
/*      */     List hqlResult;
/*  815 */     if (session != null) {
/*  816 */       hqlResult = processFind(session, hql, filter, sorter, page);
/*      */     }
/*      */     else {
/*  819 */       HibernateTemplate ht = getHibernateTemplate();
/*  820 */       hqlResult = ht.executeFind(new HibernateCallback(hql, filter, sorter, page)
/*      */       {
/*      */         public Object doInHibernate(Session session) throws HibernateException, SQLException {
/*  823 */           return BaseDAOHibernate.this.processFind(session, this.val$hql, this.val$filter, this.val$sorter, this.val$page);
/*      */         }
/*      */       });
/*      */     }
/*  828 */     if (propertyNames == null) {
/*  829 */       return hqlResult;
/*      */     }
/*      */ 
/*  832 */     String[] propertyNamesArray = StringUtils.strToStrArray(propertyNames);
/*  833 */     for (Iterator iter = hqlResult.iterator(); iter.hasNext(); ) {
/*  834 */       Object bean = null;
/*      */       try {
/*  836 */         bean = clazz.newInstance();
/*      */       } catch (InstantiationException e) {
/*  838 */         e.printStackTrace();
/*      */       } catch (IllegalAccessException e) {
/*  840 */         e.printStackTrace();
/*      */       }
/*      */ 
/*  843 */       Object obj = iter.next();
/*  844 */       Object[] valueArray = (Object[])null;
/*  845 */       if (obj.getClass().isArray()) {
/*  846 */         valueArray = (Object[])obj;
/*      */       }
/*      */       else {
/*  849 */         valueArray = new Object[1];
/*  850 */         valueArray[0] = obj;
/*      */       }
/*      */ 
/*  853 */       for (int i = 0; i < valueArray.length; i++) {
/*  854 */         BeanUtil.ognlPropertyValue(bean, propertyNamesArray[i], valueArray[i]);
/*      */       }
/*  856 */       result.add(bean);
/*      */     }
/*      */ 
/*  859 */     return result;
/*      */   }
/*      */ 
/*      */   List processFind(Session session, String hql, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  864 */     Query[] querys = setupQuery(session, hql, filter, sorter, page);
/*  865 */     return executQuery(querys, page);
/*      */   }
/*      */ 
/*      */   private Query[] setupQuery(Session session, String hql, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  870 */     StringBuffer mainSb = new StringBuffer();
/*  871 */     StringBuffer countSb = new StringBuffer();
/*  872 */     String orderSt = "";
/*      */ 
/*  874 */     mainSb.append(hql);
/*      */ 
/*  876 */     countSb.append("select count(*) ");
/*  877 */     if (!StringUtils.trimLeft(hql).startsWith("from")) {
/*  878 */       countSb.append("from ");
/*      */     }
/*      */ 
/*  881 */     if ((filter != null) && (filter.getConditions().size() > 0))
/*      */     {
/*  883 */       if (StringUtils.isInclude(hql, "where"))
/*  884 */         mainSb.append(" and ");
/*      */       else {
/*  886 */         mainSb.append(" where ");
/*      */       }
/*  888 */       List filterBeans = filter.getConditions();
/*      */ 
/*  890 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/*  892 */       String aliasName = "";
/*  893 */       if ((filter != null) && (filter.getAliasName() != null) && (!filter.getAliasName().trim().equals(""))) {
/*  894 */         aliasName = filter.getAliasName();
/*      */       }
/*  896 */       if (filterGroup.size() < 2)
/*  897 */         setupConditions(mainSb, filterBeans, aliasName, null);
/*      */       else {
/*  899 */         for (int i = 0; i < filterGroup.size(); i++) {
/*  900 */           List filtergroup = (List)filterGroup.get(i);
/*  901 */           setupConditions(mainSb, filtergroup, aliasName, Integer.valueOf(i));
/*  902 */           mainSb.append(") ");
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  909 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/*  910 */       orderSt = " order by ";
/*      */ 
/*  912 */       if ((filter != null) && (filter.getAliasName() != null)) {
/*  913 */         orderSt = orderSt + filter.getAliasName() + ".";
/*      */       }
/*  915 */       orderSt = orderSt + sorter.toString();
/*      */     }
/*      */ 
/*  920 */     Query countQuery = null; Query query = null;
/*  921 */     String mainString = mainSb.toString();
/*  922 */     if (page != null) {
/*  923 */       String countString = mainString.toString();
/*  924 */       if (!StringUtils.trimLeft(hql).startsWith("from"))
/*  925 */         countString = mainString.substring(mainString.indexOf("from") + 4);
/*  926 */       countQuery = session.createQuery(countString);
/*      */     }
/*  928 */     query = session.createQuery(mainString + orderSt);
/*      */ 
/*  931 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  932 */       IntWrapper mainIntWrapper = new IntWrapper(null);
/*  933 */       IntWrapper countIntWrapper = new IntWrapper(null);
/*  934 */       List filterBeans = filter.getConditions();
/*  935 */       for (Iterator i = filterBeans.iterator(); i.hasNext(); ) {
/*  936 */         FilterBean filterBean = (FilterBean)i.next();
/*  937 */         String operater = filterBean.getOperater();
/*      */ 
/*  940 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  941 */           String val = (String)filterBean.getValue();
/*      */ 
/*  943 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  944 */             val = "%" + val;
/*  945 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  946 */             val = val + "%";
/*  947 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  948 */             val = "%" + val + "%";
/*  949 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/*  952 */         setParameter(query, mainIntWrapper, filterBean.getValue());
/*  953 */         if (page != null) {
/*  954 */           setParameter(countQuery, countIntWrapper, filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/*  958 */     Query[] querys = { query, countQuery };
/*  959 */     return querys;
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, PageInfo pageInfo)
/*      */   {
/*  977 */     return getHQLObjects(hql, null, null, pageInfo);
/*      */   }
/*      */ 
/*      */   protected List getHQLObjects(String hql, String propertyNames, Class clazz, PageInfo pageInfo)
/*      */   {
/*  997 */     if (pageInfo == null) {
/*  998 */       return new ArrayList();
/*      */     }
/* 1000 */     Filter filter = null;
/* 1001 */     Sorter sorter = null;
/* 1002 */     Page page = null;
/* 1003 */     filter = pageInfo.getFilter();
/* 1004 */     sorter = pageInfo.getSorter();
/* 1005 */     page = pageInfo.getPage();
/* 1006 */     return getHQLObjects(hql, propertyNames, clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   protected Session getHibernateSession() {
/* 1010 */     return null;
/*      */   }
/*      */ 
/*      */   public HiDialect getDialect()
/*      */   {
/*      */     SessionFactoryImplementor sessionFactory;
/*      */     SessionFactoryImplementor sessionFactory;
/* 1030 */     if (getHibernateSession() == null)
/* 1031 */       sessionFactory = (SessionFactoryImplementor)getHibernateTemplate().getSessionFactory();
/*      */     else {
/* 1033 */       sessionFactory = (SessionFactoryImplementor)getHibernateSession().getSessionFactory();
/*      */     }
/* 1035 */     if ((sessionFactory.getDialect() instanceof HibernateHiDialect)) {
/* 1036 */       return (HibernateHiDialect)sessionFactory.getDialect();
/*      */     }
/* 1038 */     return null;
/*      */   }
/*      */ 
/*      */   private class IntWrapper
/*      */   {
/* 1017 */     int i = 0;
/*      */ 
/*      */     private IntWrapper() {  } 
/* 1019 */     int getInt() { return this.i; }
/*      */ 
/*      */     void IntAddOne()
/*      */     {
/* 1023 */       this.i += 1;
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.BaseDAOHibernate
 * JD-Core Version:    0.6.0
 */