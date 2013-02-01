/*      */ package org.hi.framework.dao.springjdbc;
/*      */ 
/*      */ import java.beans.PropertyDescriptor;
/*      */ import java.io.PrintStream;
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.ParameterizedType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import javax.servlet.ServletContext;
/*      */ import org.apache.commons.beanutils.PropertyUtils;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.hi.SpringContextHolder;
/*      */ import org.hi.common.util.BeanUtil;
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
/*      */ import org.hi.framework.paging.impl.PageImpl;
/*      */ import org.hi.metadata.hsc.HSCHelper;
/*      */ import org.hi.metadata.hsc.context.service.Entity;
/*      */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*      */ import org.hi.metadata.hsc.context.service.Field;
/*      */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*      */ import org.springframework.dao.EmptyResultDataAccessException;
/*      */ import org.springframework.jdbc.core.JdbcTemplate;
/*      */ import org.springframework.jdbc.core.PreparedStatementCreator;
/*      */ import org.springframework.jdbc.core.RowMapper;
/*      */ import org.springframework.jdbc.core.RowMapperResultSetExtractor;
/*      */ import org.springframework.jdbc.support.GeneratedKeyHolder;
/*      */ import org.springframework.jdbc.support.KeyHolder;
/*      */ 
/*      */ public class BaseDAOSpringJDBC extends SpringJDBCDaoSuppert
/*      */   implements DAO
/*      */ {
/*   60 */   private static ThreadLocal<ArrayList<POJOInfo>> contextHolder = new ThreadLocal() {
/*      */     protected ArrayList<BaseDAOSpringJDBC.POJOInfo> initialValue() {
/*   62 */       return new ArrayList();
/*      */     }
/*   60 */   };
/*      */ 
/*   65 */   protected final Log log = LogFactory.getLog(getClass());
/*      */ 
/*      */   public Object getObjectById(Class clazz, Serializable id)
/*      */   {
/*   73 */     contextHolder.remove();
/*   74 */     Object obj = getObject(clazz, id, 0, null);
/*   75 */     return obj;
/*      */   }
/*      */ 
/*      */   private Object getObject(Class clazz, Serializable id, int level, Object obj) {
/*   79 */     if (level > 1) return null;
/*      */ 
/*   82 */     POJOInfo info = new POJOInfo(id, clazz);
/*   83 */     int index = ((ArrayList)contextHolder.get()).indexOf(info);
/*   84 */     if (index >= 0) {
/*   85 */       return ((POJOInfo)((ArrayList)contextHolder.get()).get(index)).pojo;
/*      */     }
/*      */ 
/*   88 */     if (!BaseObject.class.isAssignableFrom(clazz)) return null;
/*      */ 
/*   90 */     String sql = "select * from " + getEntity(clazz).getTableName() + " where id = " + id;
/*      */     try {
/*   92 */       long startTime = System.currentTimeMillis();
/*   93 */       Object result = getJdbcTemplate().queryForObject(sql, new SpringJDBCHiRowMapper(clazz, obj, level, null));
/*   94 */       long endTime = System.currentTimeMillis();
/*      */ 
/*   96 */       if (this.sessionFactory.isSqlShow()) {
/*   97 */         System.out.println(sql + "  ms=" + (endTime - startTime));
/*      */       }
/*      */ 
/*  101 */       info.setPojo(result);
/*  102 */       ((ArrayList)contextHolder.get()).add(info);
/*      */ 
/*  104 */       return result;
/*      */     } catch (EmptyResultDataAccessException e) {
/*      */     }
/*  107 */     return null;
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz)
/*      */   {
/*  115 */     return getObjectCount(clazz, null);
/*      */   }
/*      */ 
/*      */   public int getObjectCount(Class clazz, Filter filter)
/*      */   {
/*  122 */     contextHolder.remove();
/*  123 */     SpringJDBCQuery[] queries = setupQuery(clazz, filter, null, new PageImpl());
/*      */ 
/*  125 */     if (queries[1] == null) return 0;
/*      */ 
/*  127 */     return getObjectCount(queries[1]);
/*      */   }
/*      */ 
/*      */   private int getObjectCount(SpringJDBCQuery countQuery) {
/*  131 */     String sql = countQuery.getQuerySql();
/*  132 */     Object[] args = countQuery.getParameterObjects();
/*  133 */     long startTime = System.currentTimeMillis();
/*  134 */     int result = getJdbcTemplate().queryForInt(sql, args);
/*  135 */     long endTime = System.currentTimeMillis();
/*      */ 
/*  137 */     if (this.sessionFactory.isSqlShow()) {
/*  138 */       System.out.println(sql + "  ms=" + (endTime - startTime));
/*      */     }
/*  140 */     return result;
/*      */   }
/*      */ 
/*      */   public List<Object> getObjects(Class clazz)
/*      */   {
/*  148 */     return getObjects(clazz, null, null);
/*      */   }
/*      */ 
/*      */   public List<Object> getObjects(Class clazz, Filter filter)
/*      */   {
/*  155 */     return getObjects(clazz, filter, null);
/*      */   }
/*      */ 
/*      */   public List<Object> getObjects(Class clazz, PageInfo pageInfo)
/*      */   {
/*  162 */     if (pageInfo == null)
/*  163 */       return new ArrayList();
/*  164 */     Filter filter = null;
/*  165 */     Sorter sorter = null;
/*  166 */     Page page = null;
/*  167 */     filter = pageInfo.getFilter();
/*  168 */     sorter = pageInfo.getSorter();
/*  169 */     page = pageInfo.getPage();
/*  170 */     return getObjects(clazz, filter, sorter, page);
/*      */   }
/*      */ 
/*      */   public List<Object> getObjects(Class clazz, Filter filter, Sorter sorter) {
/*  174 */     return getObjects(clazz, filter, sorter, null);
/*      */   }
/*      */ 
/*      */   public List<Object> getObjects(Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  181 */     contextHolder.remove();
/*  182 */     SpringJDBCQuery[] querys = setupQuery(clazz, filter, sorter, page);
/*  183 */     SpringJDBCQuery selectQuery = querys[0];
/*  184 */     SpringJDBCQuery countQuery = querys[1];
/*      */ 
/*  186 */     int skip = 0;
/*  187 */     int max = 0;
/*  188 */     if ((page != null) && (countQuery != null)) {
/*  189 */       int count = getObjectCount(countQuery);
/*      */ 
/*  192 */       count = (page.getMaxRecords() != 0) && (count > page.getMaxRecords()) ? page.getMaxRecords() : count;
/*      */ 
/*  194 */       page.setTotalRecords(count);
/*      */ 
/*  196 */       int totoalPage = 0;
/*  197 */       totoalPage = count % page.getPageSize() > 0 ? count / page.getPageSize() + 1 : count / page.getPageSize();
/*  198 */       page.setTotalPage(totoalPage);
/*      */ 
/*  200 */       skip = page.getStartRowPosition();
/*      */ 
/*  202 */       if ((page.getMaxRecords() != 0) && (page.getStartRowPosition() + page.getPageSize() > page.getMaxRecords())) {
/*  203 */         max = page.getMaxRecords() - page.getStartRowPosition();
/*      */       }
/*      */       else {
/*  206 */         max = page.getPageSize();
/*      */       }
/*  208 */       page.setEndRowPosition(skip + max);
/*      */     }
/*  210 */     SpringJDBCHiDialect dialect = this.sessionFactory.getDialect();
/*  211 */     String sql = dialect.getLimitString(selectQuery.getQuerySql(), page);
/*      */ 
/*  213 */     long startTime = System.currentTimeMillis();
/*  214 */     List result = (List)getJdbcTemplate().query(sql, selectQuery.getParameterObjects(), 
/*  215 */       new HiRowMapperResultSetExtractor(new SpringJDBCHiRowMapper(clazz, null, 0, page)));
/*  216 */     long endTime = System.currentTimeMillis();
/*      */ 
/*  218 */     if (this.sessionFactory.isSqlShow()) {
/*  219 */       System.out.println(sql + "  ms=" + (endTime - startTime));
/*      */     }
/*  221 */     return result;
/*      */   }
/*      */ 
/*      */   public Object getUniqueObject(Class clazz, Filter filter)
/*      */   {
/*  229 */     List list = getObjects(clazz, filter);
/*  230 */     if ((list == null) || (list.size() <= 0))
/*  231 */       return null;
/*  232 */     return list.get(0);
/*      */   }
/*      */ 
/*      */   public void removeObject(Object obj)
/*      */   {
/*  239 */     if (obj == null)
/*  240 */       return;
/*  241 */     BaseObject baseObj = (BaseObject)obj;
/*  242 */     Serializable id = baseObj.getPrimarykey();
/*  243 */     removeSubObject(baseObj);
/*  244 */     List entitis = getSuperClassName(obj, null, null);
/*  245 */     for (Entity entity : entitis) {
/*  246 */       String sql = "delete from " + entity.getTableName() + " where id = " + id;
/*      */ 
/*  248 */       long startTime = System.currentTimeMillis();
/*  249 */       getJdbcTemplate().execute(sql);
/*  250 */       long endTime = System.currentTimeMillis();
/*      */ 
/*  252 */       if (this.sessionFactory.isSqlShow())
/*  253 */         System.out.println(sql + "  ms=" + (endTime - startTime));
/*      */     }
/*      */   }
/*      */ 
/*      */   public void removeObjectById(Class clazz, Serializable id)
/*      */   {
/*  262 */     Object obj = getObjectById(clazz, id);
/*  263 */     removeObject(obj);
/*      */   }
/*      */ 
/*      */   protected void removeSubObject(BaseObject parentObj)
/*      */   {
/*  269 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);
/*  270 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  271 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  272 */       if ((propertyClss == null) || 
/*  273 */         (!List.class.isAssignableFrom(propertyClss))) {
/*      */         continue;
/*      */       }
/*  276 */       String propertyName = propertyDescriptors[i].getName();
/*  277 */       List propertyValues = (List)BeanUtil.getPropertyValue(parentObj, propertyName);
/*  278 */       if ((propertyValues == null) || (propertyValues.size() <= 0)) {
/*      */         continue;
/*      */       }
/*  281 */       for (BaseObject subObject : propertyValues)
/*  282 */         removeObject(subObject);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void saveObject(Object obj)
/*      */   {
/*  291 */     if (obj == null) return;
/*  292 */     if (!(obj instanceof BaseObject)) return;
/*  293 */     BaseObject bo = (BaseObject)obj;
/*      */ 
/*  295 */     if (!bo.isCascadeDirty()) return;
/*      */ 
/*  298 */     List entites = getSuperClassName(bo, null, null);
/*      */     try {
/*  300 */       if (bo.getPrimarykey() == null) {
/*  301 */         for (Entity entity : entites) {
/*  302 */           bo.setVersion(Integer.valueOf(0));
/*  303 */           Map propertyValues = objectToRow(obj);
/*  304 */           insertObject(bo, entity, propertyValues);
/*      */         }
/*      */       }
/*      */       else
/*  308 */         for (Entity entity : entites) {
/*  309 */           bo.setVersion(Integer.valueOf(bo.getVersion().intValue() + 1));
/*  310 */           Map propertyValues = objectToRow(obj);
/*  311 */           updateObject(bo, entity, propertyValues);
/*      */         }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  316 */       e.printStackTrace();
/*  317 */       this.log.error("not found hsc.xml for class:" + bo.getClass().getName());
/*      */     }
/*      */ 
/*  321 */     saveItemObjects(bo);
/*      */   }
/*      */ 
/*      */   protected void insertObject(BaseObject obj, Entity entity, Map<String, ValueClass2JDBCType> propertyValues) {
/*  325 */     KeyHolder keyHolder = new GeneratedKeyHolder();
/*  326 */     getJdbcTemplate().update(new PreparedStatementCreator(entity, obj, propertyValues)
/*      */     {
/*      */       public PreparedStatement createPreparedStatement(Connection con) throws SQLException
/*      */       {
/*  330 */         String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*  331 */         Entity parentEntity = null;
/*      */         try {
/*  333 */           parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, this.val$entity));
/*      */         } catch (Exception e) {
/*  335 */           BaseDAOSpringJDBC.this.log.error("not found hsc.xml for class:" + this.val$obj.getClass().getName());
/*  336 */           e.printStackTrace();
/*      */         }
/*      */ 
/*  339 */         List values = new ArrayList();
/*  340 */         int primaryKeyIndex = 0;
/*  341 */         String primaryKeyName = null;
/*      */ 
/*  343 */         StringBuffer sqlSb = new StringBuffer("insert into " + this.val$entity.getTableName() + " (");
/*      */ 
/*  345 */         int stepFlage = 0;
/*  346 */         for (Field field : this.val$entity.getField()) {
/*  347 */           if (BeanUtil.hasPropertyName(this.val$obj, field.getFieldName())) {
/*  348 */             if (stepFlage > 0) {
/*  349 */               sqlSb.append(",");
/*      */             }
/*  351 */             sqlSb.append(field.getFieldName());
/*      */ 
/*  353 */             values.add((ValueClass2JDBCType)this.val$propertyValues.get(field.getFieldName()));
/*      */ 
/*  355 */             if (field.isIsPrimaryKey()) {
/*  356 */               primaryKeyIndex = stepFlage;
/*  357 */               primaryKeyName = field.getFieldName();
/*      */ 
/*  359 */               if (parentEntity == null) {
/*  360 */                 sqlSb.append(",version");
/*  361 */                 values.add((ValueClass2JDBCType)this.val$propertyValues.get("version"));
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/*  366 */             stepFlage++;
/*      */           }
/*      */         }
/*  369 */         sqlSb.append(") values(");
/*      */ 
/*  372 */         stepFlage = 0;
/*  373 */         for (Field field : this.val$entity.getField()) {
/*  374 */           if (BeanUtil.hasPropertyName(this.val$obj, field.getFieldName())) {
/*  375 */             if (stepFlage > 0) {
/*  376 */               sqlSb.append(",");
/*      */             }
/*  378 */             sqlSb.append("?");
/*      */ 
/*  380 */             if ((field.isIsPrimaryKey()) && (parentEntity == null)) {
/*  381 */               sqlSb.append(",?");
/*      */             }
/*  383 */             stepFlage++;
/*      */           }
/*      */         }
/*      */ 
/*  387 */         SpringJDBCHiDialect dialect = BaseDAOSpringJDBC.this.sessionFactory.getDialect();
/*  388 */         sqlSb.append(")");
/*  389 */         String sql = dialect.insertSql(sqlSb.toString(), this.val$entity.getEntityName(), values);
/*  390 */         PreparedStatement ps = con.prepareStatement(sql, 1);
/*      */ 
/*  392 */         stepFlage = 0;
/*  393 */         for (ValueClass2JDBCType valueClass : values) {
/*  394 */           Object value = valueClass.getValue();
/*  395 */           if ((stepFlage == primaryKeyIndex) && (valueClass.getPropertyName().equals(primaryKeyName))) {
/*  396 */             Number _id = dialect.getSelectKey(this.val$entity.getEntityName(), BaseDAOSpringJDBC.this.getJdbcTemplate().getDataSource());
/*  397 */             if (_id != null) {
/*  398 */               BeanUtil.setPropertyValue(this.val$obj, primaryKeyName, _id);
/*  399 */               ps.setInt(stepFlage + 1, _id.intValue());
/*      */             }
/*      */           }
/*  402 */           else if (value == null) {
/*  403 */             ps.setNull(stepFlage + 1, valueClass.getJDBCType());
/*      */           }
/*  405 */           else if ((value instanceof Integer)) {
/*  406 */             ps.setInt(stepFlage + 1, ((Integer)value).intValue());
/*  407 */           } else if ((value instanceof Long)) {
/*  408 */             ps.setLong(stepFlage + 1, ((Long)value).longValue());
/*  409 */           } else if ((value instanceof String)) {
/*  410 */             ps.setString(stepFlage + 1, value.toString());
/*  411 */           } else if ((value instanceof Double)) {
/*  412 */             ps.setDouble(stepFlage + 1, ((Double)value).doubleValue());
/*  413 */           } else if ((value instanceof java.util.Date)) {
/*  414 */             ps.setDate(stepFlage + 1, new java.sql.Date(((java.util.Date)value).getTime()));
/*  415 */           } else if ((value instanceof java.sql.Date)) {
/*  416 */             ps.setDate(stepFlage + 1, (java.sql.Date)value);
/*  417 */           } else if ((value instanceof Timestamp)) {
/*  418 */             ps.setTimestamp(stepFlage + 1, (Timestamp)value);
/*      */           } else {
/*  420 */             ps.setObject(stepFlage + 1, value);
/*      */           }
/*  422 */           stepFlage++;
/*      */         }
/*      */ 
/*  425 */         return ps;
/*      */       }
/*      */     }
/*      */     , keyHolder);
/*      */ 
/*  430 */     if (obj.getPrimarykey() == null)
/*  431 */       BeanUtil.setPropertyValue(obj, "id", Integer.valueOf(keyHolder.getKey().intValue()));
/*      */   }
/*      */ 
/*      */   protected void updateObject(BaseObject obj, Entity entity, Map<String, ValueClass2JDBCType> propertyValues) {
/*  435 */     getJdbcTemplate().update(new PreparedStatementCreator(entity, obj, propertyValues)
/*      */     {
/*      */       public PreparedStatement createPreparedStatement(Connection con) throws SQLException
/*      */       {
/*  439 */         String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*  440 */         Entity parentEntity = null;
/*      */         try {
/*  442 */           parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, this.val$entity));
/*      */         } catch (Exception e) {
/*  444 */           BaseDAOSpringJDBC.this.log.error("not found hsc.xml for class:" + this.val$obj.getClass().getName());
/*  445 */           e.printStackTrace();
/*      */         }
/*      */ 
/*  448 */         List values = new ArrayList();
/*  449 */         ValueClass2JDBCType primaryKeyObject = null;
/*      */ 
/*  451 */         StringBuffer sqlSb = new StringBuffer("update " + this.val$entity.getTableName() + " set ");
/*      */ 
/*  453 */         int stepFlage = 0;
/*  454 */         for (Field field : this.val$entity.getField()) {
/*  455 */           if (!BeanUtil.hasPropertyName(this.val$obj, field.getFieldName()))
/*      */             continue;
/*  457 */           if (field.isIsPrimaryKey()) {
/*  458 */             primaryKeyObject = (ValueClass2JDBCType)this.val$propertyValues.get(field.getFieldName());
/*      */ 
/*  460 */             if (parentEntity == null) {
/*  461 */               if (stepFlage > 0) {
/*  462 */                 sqlSb.append(",");
/*      */               }
/*  464 */               sqlSb.append("version").append("=?");
/*  465 */               values.add((ValueClass2JDBCType)this.val$propertyValues.get("version"));
/*  466 */               stepFlage++;
/*  467 */               continue;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*  472 */           if (stepFlage > 0) {
/*  473 */             sqlSb.append(",");
/*      */           }
/*  475 */           sqlSb.append(field.getFieldName()).append("=?");
/*  476 */           values.add((ValueClass2JDBCType)this.val$propertyValues.get(field.getFieldName()));
/*      */ 
/*  478 */           stepFlage++;
/*      */         }
/*      */ 
/*  482 */         sqlSb.append(" where " + primaryKeyObject.getPropertyName() + " = ?");
/*      */ 
/*  484 */         PreparedStatement ps = con.prepareStatement(sqlSb.toString());
/*  485 */         stepFlage = 0;
/*  486 */         for (ValueClass2JDBCType valueClass : values) {
/*  487 */           Object value = valueClass.getValue();
/*      */ 
/*  489 */           if (value == null) {
/*  490 */             ps.setNull(stepFlage + 1, valueClass.getJDBCType());
/*      */           }
/*  492 */           else if ((value instanceof Integer))
/*  493 */             ps.setInt(stepFlage + 1, ((Integer)value).intValue());
/*  494 */           else if ((value instanceof Long))
/*  495 */             ps.setLong(stepFlage + 1, ((Long)value).longValue());
/*  496 */           else if ((value instanceof String))
/*  497 */             ps.setString(stepFlage + 1, value.toString());
/*  498 */           else if ((value instanceof Double))
/*  499 */             ps.setDouble(stepFlage + 1, ((Double)value).doubleValue());
/*  500 */           else if ((value instanceof java.util.Date))
/*  501 */             ps.setDate(stepFlage + 1, new java.sql.Date(((java.util.Date)value).getTime()));
/*  502 */           else if ((value instanceof java.sql.Date))
/*  503 */             ps.setDate(stepFlage + 1, (java.sql.Date)value);
/*  504 */           else if ((value instanceof Timestamp))
/*  505 */             ps.setTimestamp(stepFlage + 1, (Timestamp)value);
/*      */           else {
/*  507 */             ps.setObject(stepFlage + 1, value);
/*      */           }
/*  509 */           stepFlage++;
/*      */         }
/*      */ 
/*  512 */         ps.setInt(stepFlage + 1, Integer.parseInt(primaryKeyObject.getValue().toString()));
/*  513 */         return ps;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   protected void saveItemObjects(BaseObject masterObj)
/*      */   {
/*  522 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(masterObj);
/*  523 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  524 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  525 */       if (!List.class.isAssignableFrom(propertyClss)) {
/*      */         continue;
/*      */       }
/*  528 */       String propertyName = propertyDescriptors[i].getName();
/*  529 */       List propertyValues = (List)BeanUtil.getPropertyValue(masterObj, propertyName);
/*  530 */       if ((propertyValues == null) || (propertyValues.size() <= 0))
/*      */         continue;
/*  532 */       for (BaseObject baseObject : propertyValues) {
/*  533 */         Entity subEntity = null;
/*      */         try {
/*  535 */           subEntity = HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), baseObject.getClass());
/*  536 */           List fields = subEntity.getField();
/*  537 */           for (Field field : fields)
/*  538 */             if (field.isIsParent()) {
/*  539 */               String _parentClassName = field.getLookupEntity().getLkEntityName();
/*  540 */               if (!_parentClassName.equals(masterObj.getClass().getSimpleName()))
/*      */                 continue;
/*  542 */               BeanUtil.setPropertyValue(baseObject, field.getFieldName(), masterObj);
/*      */             }
/*      */         } catch (Exception localException) {
/*      */         }
/*  545 */         saveObject(baseObject);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   protected Map<String, ValueClass2JDBCType> objectToRow(Object obj)
/*      */   {
/*  553 */     Map rowMap = new HashMap();
/*  554 */     PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);
/*  555 */     for (int i = 0; i < propertyDescriptors.length; i++) {
/*  556 */       if (propertyDescriptors[i].getWriteMethod() == null)
/*      */         continue;
/*  558 */       Class propertyClss = propertyDescriptors[i].getPropertyType();
/*  559 */       String propertyName = propertyDescriptors[i].getName();
/*  560 */       Object propertyValue = BeanUtil.getPropertyValue(obj, propertyName);
/*  561 */       if (propertyClss == null)
/*      */         continue;
/*  563 */       if ((!BaseObject.class.isAssignableFrom(propertyClss)) && (!Collection.class.isAssignableFrom(propertyClss)))
/*      */       {
/*  565 */         rowMap.put(propertyName, new ValueClass2JDBCType(propertyClss, propertyValue, propertyName));
/*      */       }
/*      */       else
/*      */       {
/*  569 */         if (!BaseObject.class.isAssignableFrom(propertyClss))
/*      */           continue;
/*  571 */         BaseObject baseObj = (BaseObject)propertyValue;
/*  572 */         rowMap.put(propertyName, new ValueClass2JDBCType(Integer.class, baseObj == null ? null : baseObj.getPrimarykey(), propertyName));
/*      */       }
/*      */     }
/*      */ 
/*  576 */     return rowMap;
/*      */   }
/*      */ 
/*      */   private SpringJDBCQuery[] setupQuery(Class clazz, Filter filter, Sorter sorter, Page page)
/*      */   {
/*  581 */     StringBuffer mainSb = new StringBuffer();
/*  582 */     SpringJDBCQuery countSb = new SpringJDBCQuery();
/*  583 */     SpringJDBCQuery selectSb = new SpringJDBCQuery();
/*  584 */     String orderSt = "";
/*      */ 
/*  586 */     Entity entity = null;
/*  587 */     String tableName = null; String aliasName = null;
/*      */     try {
/*  589 */       entity = getEntity(clazz);
/*  590 */       tableName = entity.getTableName();
/*  591 */       aliasName = (filter == null) || (filter.getAliasName() == null) ? tableName : filter.getAliasName();
/*      */     } catch (Exception e) {
/*  593 */       this.log.error("not found Entity Define by className:" + clazz.getName());
/*      */     }
/*      */ 
/*  596 */     List entities = getSuperClassName(entity, null, null);
/*      */ 
/*  598 */     Map domainInfos = getDomainInfo(clazz, filter, sorter, entities);
/*      */ 
/*  600 */     selectSb.append("select ");
/*  601 */     for (int i = 0; i < entities.size(); i++) {
/*  602 */       if (i > 0) {
/*  603 */         selectSb.append(",");
/*      */       }
/*  605 */       selectSb.append(((Entity)entities.get(i)).getTableName()).append(".* ");
/*      */     }
/*      */ 
/*  608 */     countSb.append("select count(*) ");
/*      */ 
/*  611 */     mainSb.append("from ");
/*      */ 
/*  613 */     for (int i = 0; i < entities.size(); i++) {
/*  614 */       if (i > 0)
/*  615 */         mainSb.append(",");
/*  616 */       mainSb.append(((Entity)entities.get(i)).getTableName()).append(" ").append(((Entity)entities.get(i)).getTableName()).append(" ");
/*      */     }
/*      */ 
/*  620 */     for (Map.Entry entry : domainInfos.entrySet()) {
/*  621 */       DomainORInfo domainORInfo = (DomainORInfo)entry.getValue();
/*  622 */       mainSb.append(",").append(domainORInfo.getTableName()).append(" ")
/*  623 */         .append(domainORInfo.getPropertyName()).append(" ");
/*      */     }
/*      */ 
/*  626 */     if ((domainInfos.size() > 0) || (entities.size() > 1)) {
/*  627 */       mainSb.append(" where ");
/*      */     }
/*      */ 
/*  630 */     String[] keySet = (String[])domainInfos.keySet().toArray(new String[domainInfos.keySet().size()]);
/*  631 */     int andSetp = 0;
/*  632 */     for (int i = 0; i < keySet.length; i++) {
/*  633 */       if (andSetp > 0) {
/*  634 */         mainSb.append(" and ");
/*      */       }
/*  636 */       DomainORInfo domainORInfo = (DomainORInfo)domainInfos.get(keySet[i]);
/*  637 */       mainSb.append(domainORInfo.getResourcePropertyName() == null ? aliasName : domainORInfo.getResourcePropertyName()).append(".").append(domainORInfo.getPropertyName())
/*  638 */         .append("=").append(domainORInfo.getPropertyName()).append(".").append("id ");
/*  639 */       andSetp++;
/*      */     }
/*  641 */     if (entities.size() > 1)
/*  642 */       for (int i = 0; i < entities.size() - 1; i++) {
/*  643 */         if (andSetp > 0)
/*  644 */           mainSb.append(" and ");
/*  645 */         mainSb.append(tableName).append(".id = ")
/*  646 */           .append(((Entity)entities.get(i)).getTableName()).append(".id ");
/*  647 */         andSetp++;
/*      */       }
/*      */     List filtergroup;
/*  653 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  654 */       if (andSetp == 0)
/*  655 */         mainSb.append(" where ");
/*      */       else
/*  657 */         mainSb.append(" and ");
/*  658 */       List filterBeans = filter.getConditions();
/*      */ 
/*  660 */       List filterGroup = filter.getFilterGroup();
/*      */ 
/*  662 */       if (filterGroup.size() < 2)
/*  663 */         setupConditions(entities, mainSb, filterBeans, aliasName, null);
/*      */       else {
/*  665 */         for (int i = 0; i < filterGroup.size(); i++) {
/*  666 */           filtergroup = (List)filterGroup.get(i);
/*  667 */           setupConditions(entities, mainSb, filtergroup, aliasName, Integer.valueOf(i));
/*  668 */           mainSb.append(") ");
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  674 */     selectSb.append(mainSb);
/*      */ 
/*  676 */     if ((sorter != null) && (!sorter.getSorts().isEmpty())) {
/*  677 */       orderSt = " order by ";
/*      */ 
/*  679 */       Map sorts = sorter.getSorts();
/*  680 */       int _step = 0;
/*  681 */       for (Map.Entry entry : sorts.entrySet()) {
/*  682 */         String properyName = (String)entry.getKey();
/*  683 */         if (!properyName.contains(".")) {
/*  684 */           String _aliasName = aliasName;
/*  685 */           for (Entity _entity : entities) {
/*      */             try {
/*  687 */               Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), _entity, properyName);
/*  688 */               if ((field != null) && (field.getFieldType() != 6))
/*  689 */                 _aliasName = _entity.getTableName();
/*      */             }
/*      */             catch (Exception localException1)
/*      */             {
/*      */             }
/*      */           }
/*  695 */           properyName = _aliasName + "." + properyName;
/*      */         }
/*      */         else {
/*  698 */           String[] domainProperty = properyName.split("[.]");
/*  699 */           properyName = domainProperty[(domainProperty.length - 2)] + "." + domainProperty[(domainProperty.length - 1)];
/*      */         }
/*  701 */         if (_step > 0) {
/*  702 */           orderSt = orderSt + ", ";
/*      */         }
/*  704 */         orderSt = orderSt + properyName + " " + (String)entry.getValue();
/*      */ 
/*  706 */         _step++;
/*      */       }
/*      */     }
/*      */ 
/*  710 */     countSb.append(mainSb);
/*      */ 
/*  713 */     if ((this.sessionFactory.getDialect() instanceof SpringJDBCHiDialect)) {
/*  714 */       SpringJDBCHiDialect dialect = this.sessionFactory.getDialect();
/*  715 */       dialect.getMaxRecode(countSb, filter, page);
/*      */     }
/*      */ 
/*  718 */     SpringJDBCQuery selectQuery = selectSb.append(orderSt);
/*      */ 
/*  721 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  722 */       List filterBeans = filter.getConditions();
/*  723 */       for (int i = 0; i < filterBeans.size(); i++) {
/*  724 */         FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*      */ 
/*  726 */         if (filterBean.getValue() == null) {
/*      */           continue;
/*      */         }
/*  729 */         String operater = filterBean.getOperater();
/*      */ 
/*  732 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  733 */           String val = (String)filterBean.getValue();
/*      */ 
/*  735 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  736 */             val = "%" + val;
/*  737 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  738 */             val = val + "%";
/*  739 */           else if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  740 */             val = "%" + val + "%";
/*      */           else {
/*  742 */             val = "%" + val + "%";
/*      */           }
/*  744 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/*  747 */         selectQuery.putParameter(filterBean.getFieldName() + i, filterBean.getValue());
/*  748 */         if (page != null) {
/*  749 */           countSb.putParameter(filterBean.getFieldName() + i, filterBean.getValue());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  754 */     SpringJDBCQuery countQuery = null;
/*  755 */     if (page != null)
/*  756 */       countQuery = countSb;
/*  757 */     SpringJDBCQuery[] querySql = { selectQuery, countQuery };
/*  758 */     return querySql;
/*      */   }
/*      */ 
/*      */   private void setupConditions(List<Entity> entities, StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex)
/*      */   {
/*  764 */     for (int i = 0; i < filterBeans.size(); i++) {
/*  765 */       FilterBean filterBean = (FilterBean)filterBeans.get(i);
/*  766 */       String operater = filterBean.getOperater();
/*  767 */       if ((groupIndex != null) && (groupIndex.intValue() == 0) && (i == 0))
/*  768 */         mainSb.append("( ");
/*  769 */       if ((groupIndex != null) && (groupIndex.intValue() != 0) && (i == 0))
/*  770 */         mainSb.append(filterBean.getRelations()).append(" ( ");
/*  771 */       if (i > 0) {
/*  772 */         mainSb.append(" ").append(filterBean.getRelations()).append(" ");
/*      */       }
/*  774 */       if ((aliasName != null) && (!aliasName.trim().equals("")))
/*      */       {
/*  777 */         String tableName = aliasName;
/*  778 */         if (entities.size() > 1) {
/*  779 */           String fieldName = filterBean.getFieldName();
/*  780 */           if (fieldName.contains("."))
/*  781 */             fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  782 */           for (int j = entities.size() - 1; j >= 0; j--) {
/*  783 */             List allFields = ((Entity)entities.get(j)).getField();
/*  784 */             for (Field field : allFields) {
/*  785 */               if (field.getFieldName().equals(fieldName)) {
/*  786 */                 tableName = ((Entity)entities.get(j)).getTableName();
/*  787 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  794 */         if (!filterBean.getFieldName().contains(".")) {
/*  795 */           mainSb.append(tableName + ".");
/*  796 */           mainSb.append(filterBean.getFieldName()).append(" ");
/*      */         }
/*      */         else {
/*  799 */           String[] fieldNames = filterBean.getFieldName().split("[.]");
/*  800 */           mainSb.append(fieldNames[(fieldNames.length - 2)] + "." + fieldNames[(fieldNames.length - 1)]).append(" ");
/*      */         }
/*      */       }
/*      */ 
/*  804 */       Object val = filterBean.getValue();
/*  805 */       if (val == null) {
/*  806 */         if (operater.equals("="))
/*  807 */           mainSb.append("IS NULL ");
/*      */         else
/*  809 */           mainSb.append("IS NOT NULL ");
/*      */       }
/*      */       else {
/*  812 */         mainSb.append(operater).append(" ");
/*      */ 
/*  814 */         if (filterBean.isNot()) {
/*  815 */           mainSb.append("NOT ");
/*      */         }
/*      */ 
/*  818 */         if ((operater.equals("LIKE")) && ((filterBean.getValue() instanceof String))) {
/*  819 */           val = (String)filterBean.getValue();
/*      */ 
/*  821 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
/*  822 */             val = "%" + val;
/*  823 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
/*  824 */             val = val + "%";
/*  825 */           if (filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
/*  826 */             val = "%" + val + "%";
/*  827 */           filterBean.setValue(val);
/*      */         }
/*      */ 
/*  830 */         if (operater.equals("IN")) {
/*  831 */           mainSb.append("(");
/*  832 */           List coll = (List)filterBean.getValue();
/*  833 */           for (int j = 0; j < coll.size(); j++) {
/*  834 */             if (j > 0)
/*  835 */               mainSb.append(",");
/*  836 */             mainSb.append("?");
/*      */           }
/*      */ 
/*  839 */           mainSb.append(") ");
/*      */         }
/*  842 */         else if ((filterBean.getValue() instanceof BaseObject)) {
/*  843 */           mainSb.append(((BaseObject)filterBean.getValue()).getPrimarykey());
/*      */         } else {
/*  845 */           mainSb.append("?");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private Map<String, DomainORInfo> getDomainInfo(Class clazz, Filter filter, Sorter sorter, List<Entity> entities)
/*      */   {
/*  855 */     Map result = new HashMap();
/*      */     String[] domainProperty;
/*  856 */     if ((filter != null) && (filter.getConditions().size() > 0)) {
/*  857 */       List filterBeans1 = filter.getConditions();
/*  858 */       for (int i = 0; i < filterBeans1.size(); i++) {
/*  859 */         FilterBean filterBean = (FilterBean)filterBeans1.get(i);
/*  860 */         if (!filterBean.getFieldName().contains(".")) {
/*      */           continue;
/*      */         }
/*  863 */         domainProperty = filterBean.getFieldName().split("[.]");
/*  864 */         PropertyDescriptor domainPropertyDescriptor = null;
/*  865 */         Entity domainEntity = null;
/*  866 */         Class dominClazz = clazz;
/*  867 */         for (int j = 0; j < domainProperty.length - 1; j++)
/*      */         {
/*      */           try {
/*  870 */             domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[j]);
/*  871 */             dominClazz = domainPropertyDescriptor.getPropertyType();
/*  872 */             domainEntity = getEntity(dominClazz); } catch (Exception e) {
/*  873 */             continue;
/*      */           }
/*  875 */           DomainORInfo domainInfo = new DomainORInfo();
/*  876 */           domainInfo.setTableName(domainEntity.getTableName());
/*  877 */           domainInfo.setPropertyName(domainProperty[j]);
/*      */ 
/*  879 */           if (j > 0) {
/*  880 */             domainInfo.setResourcePropertyName(domainProperty[(j - 1)]);
/*      */           }
/*      */ 
/*  883 */           if ((entities.size() > 1) && (j <= 0)) {
/*  884 */             String fieldName = filterBean.getFieldName();
/*  885 */             if (fieldName.contains("."))
/*  886 */               fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  887 */             for (int z = entities.size() - 1; z >= 0; z--) {
/*  888 */               List allFields = ((Entity)entities.get(z)).getField();
/*  889 */               for (Field field : allFields) {
/*  890 */                 if (field.getFieldName().equals(fieldName)) {
/*  891 */                   domainInfo.setResourcePropertyName(((Entity)entities.get(z)).getTableName());
/*  892 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*  897 */           result.put(domainProperty[j], domainInfo);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  903 */     if ((sorter != null) && (sorter.getSorts().size() > 0)) {
/*  904 */       Map sorterMap = sorter.getSorts();
/*  905 */       Set keyValue = sorterMap.keySet();
/*  906 */       for (String string : keyValue) {
/*  907 */         if (!string.contains("."))
/*      */           continue;
/*  909 */         String[] domainProperty = string.split("[.]");
/*  910 */         PropertyDescriptor domainPropertyDescriptor = null;
/*      */ 
/*  912 */         Class dominClazz = clazz;
/*  913 */         for (int i = 0; i < domainProperty.length - 1; i++) {
/*      */           try {
/*  915 */             domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[i]);
/*  916 */             dominClazz = domainPropertyDescriptor.getPropertyType();
/*  917 */             domainEntity = getEntity(dominClazz);
/*      */           }
/*      */           catch (Exception e)
/*      */           {
/*      */             Entity domainEntity;
/*  918 */             continue;
/*      */           }
/*      */           Entity domainEntity;
/*  920 */           DomainORInfo domainInfo = new DomainORInfo();
/*  921 */           domainInfo.setTableName(domainEntity.getTableName());
/*  922 */           domainInfo.setPropertyName(domainProperty[i]);
/*  923 */           if (i > 0) {
/*  924 */             domainInfo.setResourcePropertyName(domainProperty[(i - 1)]);
/*      */           }
/*      */ 
/*  927 */           if ((entities.size() > 1) && (i <= 0)) {
/*  928 */             String fieldName = string;
/*  929 */             if (fieldName.contains("."))
/*  930 */               fieldName = fieldName.substring(0, fieldName.indexOf("."));
/*  931 */             for (int z = entities.size() - 1; z >= 0; z--) {
/*  932 */               List allFields = ((Entity)entities.get(z)).getField();
/*  933 */               for (Field field : allFields) {
/*  934 */                 if (field.getFieldName().equals(fieldName)) {
/*  935 */                   domainInfo.setResourcePropertyName(((Entity)entities.get(z)).getTableName());
/*  936 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*  941 */           result.put(domainProperty[i], domainInfo);
/*      */         }
/*      */       }
/*      */     }
/*  945 */     return result;
/*      */   }
/*      */ 
/*      */   private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity)
/*      */   {
/*  952 */     if (entitis == null) {
/*  953 */       entitis = new ArrayList();
/*      */     }
/*  955 */     String servletRootPath = SpringContextHolder.getServletContext().getRealPath("");
/*  956 */     Entity entity = null;
/*      */     try {
/*  958 */       if (obj != null) {
/*  959 */         if ((obj instanceof BaseObject))
/*  960 */           entity = getEntity(obj.getClass());
/*  961 */         if ((obj instanceof Class))
/*  962 */           entity = getEntity((Class)obj);
/*  963 */         if ((obj instanceof Entity))
/*  964 */           entity = (Entity)obj;
/*      */       }
/*      */       else {
/*  967 */         entity = superEntity;
/*      */       }
/*  969 */       ExtendEntity extendEntity = entity.getExtendEntity();
/*  970 */       if ((extendEntity != null) && (extendEntity.getExtendEntityName() != null) && (!extendEntity.getExtendEntityName().trim().equals("")))
/*      */       {
/*  972 */         getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
/*      */       }
/*      */     } catch (Exception e) {
/*  975 */       e.printStackTrace();
/*  976 */       this.log.error("not found hsc.xml for class:" + obj.getClass().getName());
/*      */     }
/*      */ 
/*  979 */     if (entity != null) {
/*  980 */       entitis.add(entity);
/*      */     }
/*  982 */     return entitis;
/*      */   }
/*      */ 
/*      */   private Entity getEntity(Class clazz) {
/*  986 */     Entity entity = null;
/*      */     try {
/*  988 */       entity = HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), clazz);
/*      */     } catch (Exception e) {
/*  990 */       this.log.error("not found hsc.xml for class:" + clazz.getName());
/*  991 */       e.printStackTrace();
/*      */     }
/*  993 */     return entity;
/*      */   }
/*      */ 
/*      */   public HiDialect getDialect()
/*      */   {
/* 1239 */     if ((this.sessionFactory.getDialect() instanceof SpringJDBCHiDialect)) {
/* 1240 */       return this.sessionFactory.getDialect();
/*      */     }
/* 1242 */     return null;
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
/* 1015 */       return this.tableName;
/*      */     }
/*      */     public void setTableName(String tableName) {
/* 1018 */       this.tableName = tableName;
/*      */     }
/*      */     public String getPropertyName() {
/* 1021 */       return this.propertyName;
/*      */     }
/*      */     public void setPropertyName(String propertyName) {
/* 1024 */       this.propertyName = propertyName;
/*      */     }
/*      */     public String getResourcePropertyName() {
/* 1027 */       return this.resourcePropertyName;
/*      */     }
/*      */     public void setResourcePropertyName(String resourcePropertyName) {
/* 1030 */       this.resourcePropertyName = resourcePropertyName;
/*      */     }
/*      */   }
/*      */ 
/*      */   class HiRowMapperResultSetExtractor extends RowMapperResultSetExtractor
/*      */   {
/*      */     private RowMapper rowMapper;
/*      */ 
/*      */     public HiRowMapperResultSetExtractor(RowMapper rowMapper)
/*      */     {
/* 1187 */       super();
/* 1188 */       this.rowMapper = rowMapper;
/*      */     }
/*      */     public Object extractData(ResultSet rs) throws SQLException {
/* 1191 */       List results = new LinkedList();
/* 1192 */       int rowNum = 0;
/* 1193 */       while (rs.next()) {
/* 1194 */         Object obj = this.rowMapper.mapRow(rs, rowNum++);
/* 1195 */         if (obj != null)
/* 1196 */           results.add(obj);
/*      */       }
/* 1198 */       return results;
/*      */     }
/*      */   }
/*      */   public class POJOInfo {
/*      */     private Serializable primarykey;
/*      */     private Class clazz;
/*      */     private Object pojo;
/*      */ 
/* 1208 */     public POJOInfo(Serializable primarykey, Class clazz) { this.primarykey = primarykey;
/* 1209 */       this.clazz = clazz; }
/*      */ 
/*      */     public Serializable getPrimarykey() {
/* 1212 */       return this.primarykey;
/*      */     }
/*      */     public void setPrimarykey(Serializable primarykey) {
/* 1215 */       this.primarykey = primarykey;
/*      */     }
/*      */     public Class getClazz() {
/* 1218 */       return this.clazz;
/*      */     }
/*      */     public void setClazz(Class clazz) {
/* 1221 */       this.clazz = clazz;
/*      */     }
/*      */     public Object getPojo() {
/* 1224 */       return this.pojo;
/*      */     }
/*      */     public void setPojo(Object pojo) {
/* 1227 */       this.pojo = pojo;
/*      */     }
/*      */     public boolean equals(Object obj) {
/* 1230 */       if (!(obj instanceof POJOInfo))
/* 1231 */         return false;
/* 1232 */       POJOInfo info = (POJOInfo)obj;
/* 1233 */       return (this.clazz.equals(info.clazz)) && (this.primarykey.equals(info.primarykey));
/*      */     }
/*      */   }
/*      */ 
/*      */   class SpringJDBCHiRowMapper
/*      */     implements RowMapper
/*      */   {
/*      */     private Class clazz;
/*      */     private Object obj;
/*      */     private int level;
/*      */     private Page page;
/*      */ 
/*      */     SpringJDBCHiRowMapper(Class clazz, Object obj, int level, Page page)
/*      */     {
/* 1042 */       this.clazz = clazz;
/* 1043 */       this.obj = obj;
/* 1044 */       this.level = level;
/* 1045 */       this.page = page;
/*      */     }
/*      */ 
/*      */     public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
/* 1049 */       SpringJDBCHiDialect dialect = BaseDAOSpringJDBC.this.sessionFactory.getDialect();
/* 1050 */       if (!dialect.inResult(rowNum, this.page)) {
/* 1051 */         return null;
/*      */       }
/* 1053 */       if ((this.obj == null) || (rowNum > 0)) {
/* 1054 */         this.obj = BeanUtil.CreateObject(this.clazz.getName());
/*      */       }
/* 1056 */       for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
/* 1057 */         int rsColIndex = i + 1;
/* 1058 */         String fieldName = rs.getMetaData().getColumnName(rsColIndex);
/*      */ 
/* 1061 */         PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(this.clazz);
/* 1062 */         String propertyName = null;
/* 1063 */         for (int j = 0; j < properties.length; j++) {
/* 1064 */           propertyName = properties[j].getName();
/* 1065 */           if (propertyName.toUpperCase().equals(fieldName.toUpperCase()))
/*      */             break;
/*      */         }
/* 1068 */         if (propertyName == null) propertyName = fieldName;
/*      */ 
/* 1070 */         Class propertyClass = BeanUtil.getProperyClass(this.obj, propertyName);
/* 1071 */         Object value = null;
/* 1072 */         if (propertyClass.equals(Integer.class))
/* 1073 */           value = rs.getObject(rsColIndex) == null ? null : Integer.valueOf(rs.getInt(rsColIndex));
/* 1074 */         if (propertyClass.equals(String.class))
/* 1075 */           value = rs.getString(rsColIndex);
/* 1076 */         if (propertyClass.equals(java.util.Date.class))
/* 1077 */           value = rs.getDate(rsColIndex);
/* 1078 */         if (propertyClass.equals(Timestamp.class))
/* 1079 */           value = rs.getTimestamp(rsColIndex);
/* 1080 */         if (propertyClass.equals(Double.class))
/* 1081 */           value = rs.getObject(rsColIndex) == null ? null : Double.valueOf(rs.getDouble(rsColIndex));
/* 1082 */         if (propertyClass.equals(Long.class))
/* 1083 */           value = rs.getObject(rsColIndex) == null ? null : Long.valueOf(rs.getLong(rsColIndex));
/* 1084 */         if (propertyClass.equals(Short.class))
/* 1085 */           value = rs.getObject(rsColIndex) == null ? null : Short.valueOf(rs.getShort(rsColIndex));
/* 1086 */         if (propertyClass.equals(Float.class))
/* 1087 */           value = rs.getObject(rsColIndex) == null ? null : Float.valueOf(rs.getFloat(rsColIndex));
/* 1088 */         if (propertyClass.equals(Byte.class))
/* 1089 */           value = Byte.valueOf(rs.getByte(rsColIndex));
/* 1090 */         if (propertyClass.equals(BigDecimal.class))
/* 1091 */           value = rs.getBigDecimal(rsColIndex);
/* 1092 */         if (propertyClass.equals(BigInteger.class)) {
/* 1093 */           value = rs.getObject(rsColIndex) == null ? null : new BigInteger(rs.getString(rsColIndex));
/*      */         }
/* 1095 */         if (BaseObject.class.isAssignableFrom(propertyClass)) {
/* 1096 */           String domainObjectId = rs.getString(rsColIndex);
/* 1097 */           if (domainObjectId != null)
/*      */           {
/* 1100 */             boolean isParentField = false;
/*      */             try {
/* 1102 */               Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), this.obj.getClass(), propertyName);
/* 1103 */               isParentField = field.isIsParent();
/*      */             }
/*      */             catch (Exception e) {
/* 1106 */               BaseDAOSpringJDBC.this.log.error("not found hsc.xml for class:" + this.obj.getClass().getName());
/* 1107 */               e.printStackTrace();
/*      */             }
/*      */ 
/* 1111 */             if (!isParentField) {
/* 1112 */               value = BaseDAOSpringJDBC.this.getObject(propertyClass, Integer.valueOf(rs.getInt(rsColIndex)), this.level + 1, BeanUtil.CreateObject(propertyClass.getName()));
/*      */             }
/*      */           }
/*      */         }
/* 1116 */         BeanUtil.setPropertyValue(this.obj, propertyName, value);
/*      */       }
/*      */ 
/* 1120 */       Class superclass = getSuperClass(this.clazz);
/* 1121 */       if (superclass != null) {
/* 1122 */         BaseDAOSpringJDBC.this.getObject(superclass, ((BaseObject)this.obj).getPrimarykey(), 0, this.obj);
/*      */       }
/*      */ 
/* 1127 */       String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/* 1128 */       PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(this.obj);
/* 1129 */       for (int i = 0; i < propertyDescriptors.length; i++) {
/* 1130 */         Class propertyClss = propertyDescriptors[i].getPropertyType();
/* 1131 */         if (!List.class.isAssignableFrom(propertyClss)) {
/*      */           continue;
/*      */         }
/* 1134 */         String propertyName = propertyDescriptors[i].getName();
/* 1135 */         Method method = propertyDescriptors[i].getReadMethod();
/* 1136 */         Type returnType = method.getGenericReturnType();
/* 1137 */         if ((returnType instanceof ParameterizedType)) {
/* 1138 */           Type[] types = ((ParameterizedType)returnType).getActualTypeArguments();
/* 1139 */           if ((types != null) && (types.length > 0)) {
/* 1140 */             Class itemClass = (Class)types[0];
/*      */ 
/* 1142 */             Entity itemEntity = null;
/* 1143 */             String item2MasterPropertyName = null;
/*      */             try {
/* 1145 */               itemEntity = HSCHelper.getEntity(servletRootDir, itemClass);
/* 1146 */               for (Field field : itemEntity.getField())
/* 1147 */                 if (field.isIsParent()) {
/* 1148 */                   item2MasterPropertyName = field.getFieldName();
/* 1149 */                   break;
/*      */                 }
/*      */             }
/*      */             catch (Exception e)
/*      */             {
/* 1154 */               BaseDAOSpringJDBC.this.log.error("not found item hsc.xml for class:" + itemClass.getName());
/* 1155 */               e.printStackTrace();
/*      */             }
/*      */ 
/* 1158 */             Filter filter = FilterFactory.getSimpleFilter(item2MasterPropertyName, ((BaseObject)this.obj).getPrimarykey(), "=");
/* 1159 */             Object itemValues = BaseDAOSpringJDBC.this.getObjects(itemClass, filter);
/* 1160 */             for (Iterator localIterator2 = ((Collection)itemValues).iterator(); localIterator2.hasNext(); ) { Object itemObj = localIterator2.next();
/* 1161 */               BeanUtil.setPropertyValue(itemObj, item2MasterPropertyName, this.obj);
/*      */             }
/* 1163 */             BeanUtil.setPropertyValue(this.obj, propertyName, itemValues);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 1168 */       return this.obj;
/*      */     }
/*      */ 
/*      */     private Class getSuperClass(Class clazz) {
/* 1172 */       Class superclass = clazz.getSuperclass();
/* 1173 */       if (clazz == null)
/* 1174 */         return null;
/* 1175 */       if ((superclass.equals(BaseObject.class)) || (superclass.equals(Object.class)))
/* 1176 */         return null;
/* 1177 */       if (Modifier.isAbstract(superclass.getModifiers())) {
/* 1178 */         return getSuperClass(superclass);
/*      */       }
/* 1180 */       return superclass;
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.BaseDAOSpringJDBC
 * JD-Core Version:    0.6.0
 */