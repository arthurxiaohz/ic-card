package org.hi.framework.dao.springjdbc;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterBean;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.LikeFilter;
import org.hi.framework.model.BaseObject;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.paging.impl.PageImpl;
import org.hi.metadata.hsc.HSC;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.constant.FieldType;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.ExtendEntity;
import org.hi.metadata.hsc.context.service.Field;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * 本类是接口DAO多个底层实现类中的一个,是对ORM工具SpringJDBC的DAO的实现。本类继承自SpringJDBCDaoSuppert而后者是DAO实现的服务基类,
 * 它带有一个SessionFactory引用并且它提供对数据库连接的定义,最终该类还是继承Spring提供的JdbcDaoSupport用以调用JDBC最底层的Connection.
 * 
 * 众所周知,springJDBC没有提供ORM的映射配置文件，所以的映射关系必须通过RowMapper接口来手动编程实现,为了降低这些无味的劳动,本类提供了动态Mapping的解决方案.
 * 其原理是通过平台的hmc文件将关系型数据库的结果与POJO映射在一起.同时传统的springJDBC也同时不支持数据库端的分页功能,本类弥补了这个的缺陷，通过方言以实现跨数据
 * 库的分页查询功能
 * @author 张昊
 * @since 2011-4-14
 * @see org.hi.framework.dao.DAO
 * @see org.hi.framework.dao.springjdbc.SpringJDBCDaoSuppert
 * @see org.springframework.jdbc.core.support.JdbcDaoSupport
 * @see org.springframework.jdbc.core.RowMapper
 * @see org.hi.framework.dao.springjdbc.SpringJDBCHiDialect
 *
 */
public class BaseDAOSpringJDBC extends SpringJDBCDaoSuppert implements DAO {
	private static ThreadLocal<ArrayList<POJOInfo>> contextHolder = new ThreadLocal<ArrayList<POJOInfo>>(){
		protected ArrayList<POJOInfo> initialValue() {
			return new ArrayList<POJOInfo>();
		}
	};
	protected final Log log = LogFactory.getLog(getClass());

	
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectById(java.lang.Class, java.io.Serializable)
	 */
	public Object getObjectById(Class clazz, Serializable id) {
		contextHolder.remove();
		Object obj = getObject(clazz, id, 0, null);
		return obj;
	}
	
	private Object getObject(Class clazz, Serializable id, int level, Object obj){
		if(level > 1) return null;
		
//		如果缓存中有就直接从缓存中取
		POJOInfo info = new POJOInfo(id, clazz);
		int index = contextHolder.get().indexOf(info);
		if(index >= 0){
			return contextHolder.get().get(index).pojo;
		}
		
		if(!(BaseObject.class.isAssignableFrom(clazz))) return null;
		
		String sql = "select * from " + this.getEntity(clazz).getTableName() + " where id = " + id;
		try{
			long startTime = System.currentTimeMillis();
			Object result = this.getJdbcTemplate().queryForObject(sql,new SpringJDBCHiRowMapper(clazz, obj, level, null));
			long endTime = System.currentTimeMillis();
			
			if(sessionFactory.isSqlShow()){
				System.out.println(sql + "  ms=" + (endTime - startTime) );
			}
			
//			加入缓存
			info.setPojo(result);
			contextHolder.get().add(info);
			
			return result;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectCount(java.lang.Class)
	 */
	public int getObjectCount(Class clazz) {
		return getObjectCount(clazz, null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectCount(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public int getObjectCount(Class clazz, Filter filter) {
		contextHolder.remove();
		SpringJDBCQuery[]  queries = setupQuery(clazz, filter, null, new PageImpl());
		
		if(queries[1] == null)	return 0;
		
		return getObjectCount(queries[1]);
	}
	
	private int getObjectCount(SpringJDBCQuery countQuery){
		String sql = countQuery.getQuerySql();
		Object[] args = countQuery.getParameterObjects();
		long startTime = System.currentTimeMillis();
		int result = this.getJdbcTemplate().queryForInt(sql, args);
		long endTime = System.currentTimeMillis();
		
		if(sessionFactory.isSqlShow()){
			System.out.println(sql + "  ms=" + (endTime - startTime) );
		}
		return result;
		
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class)
	 */
	public List<Object> getObjects(Class clazz) {
		return this.getObjects(clazz,null,null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public List<Object> getObjects(Class clazz, Filter filter) {
		return this.getObjects(clazz,filter,null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.paging.PageInfo)
	 */
	public List<Object> getObjects(Class clazz, PageInfo pageInfo) {
		if(pageInfo == null)
			return new ArrayList();
		Filter filter = null;
		Sorter sorter = null;
		Page page = null;
		filter = pageInfo.getFilter();
		sorter = pageInfo.getSorter();
		page = pageInfo.getPage();
		return getObjects(clazz, filter, sorter, page);
	}

	public List<Object> getObjects(Class clazz, Filter filter, Sorter sorter) {
		return this.getObjects(clazz, filter, sorter, null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter, org.hi.framework.paging.Page)
	 */
	public List<Object> getObjects(Class clazz, Filter filter, Sorter sorter,Page page) {
		contextHolder.remove();
		SpringJDBCQuery[] querys = setupQuery(clazz, filter, sorter, page);
		SpringJDBCQuery selectQuery = querys[0];//查询属性语句
		SpringJDBCQuery countQuery = querys[1];//查询行数语句

		int skip =0;
		int max = 0;
		if(page != null && countQuery != null){
			int count = getObjectCount(countQuery); //查找行数
			
			//如果真实记录数最大限记录数就取最大限记录数
			count = page.getMaxRecords() != 0 && count > page.getMaxRecords() ? page.getMaxRecords() : count;
				
			page.setTotalRecords(count);		//设置查询结果的总记录数
			
			int totoalPage = 0;
			totoalPage= count%page.getPageSize() > 0 ? count/page.getPageSize() + 1  : count/page.getPageSize();
			page.setTotalPage(totoalPage);						//设置查询结果的总页数
			
			skip =page.getStartRowPosition(); 	//设置返回的第一条记录的位置
			
			if(page.getMaxRecords() != 0 && (page.getStartRowPosition() + page.getPageSize()) > page.getMaxRecords()){
				max =page.getMaxRecords() - page.getStartRowPosition();
			}
			else
				max =page.getPageSize();			//设置返回的记录数

			page.setEndRowPosition(skip + max);
		}
		SpringJDBCHiDialect dialect = sessionFactory.getDialect();
		String sql = dialect.getLimitString(selectQuery.getQuerySql(), page);
		
		long startTime = System.currentTimeMillis();
		List<Object> result = (List<Object>) this.getJdbcTemplate().query(sql, selectQuery.getParameterObjects(), 
				new HiRowMapperResultSetExtractor(new SpringJDBCHiRowMapper(clazz, null, 0, page)));
		long endTime = System.currentTimeMillis();
		
		if(sessionFactory.isSqlShow()){
			System.out.println(sql + "  ms=" + (endTime - startTime) );
		}
		return result;
		
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getUniqueObject(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public Object getUniqueObject(Class clazz, Filter filter) {
		List list = getObjects(clazz, filter);
		if(list == null || list.size() <= 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#removeObject(java.lang.Object)
	 */
	public void removeObject(Object obj) {
		if(obj == null)
			return;
		BaseObject baseObj = (BaseObject)obj;
		Serializable id = baseObj.getPrimarykey();
		this.removeSubObject(baseObj);//删除从表对象
		List<Entity> entitis = this.getSuperClassName(obj, null, null);//获得所有祖先
		for (Entity entity : entitis){ //级联删除继承的祖先对象
			String sql = "delete from " + entity.getTableName() + " where id = " + id; 
			
			long startTime = System.currentTimeMillis();
			this.getJdbcTemplate().execute(sql);
			long endTime = System.currentTimeMillis();
			
			if(sessionFactory.isSqlShow()){
				System.out.println(sql + "  ms=" + (endTime - startTime) );
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#removeObjectById(java.lang.Class, java.io.Serializable)
	 */
	public void removeObjectById(Class clazz, Serializable id) {
		Object obj = this.getObjectById(clazz, id);
		removeObject(obj);
	}
	 /**
     * 删除孩子对象
     */
	protected void removeSubObject(BaseObject parentObj){
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);
		for (int i = 0; i < propertyDescriptors.length; i++) {
			Class propertyClss = propertyDescriptors[i].getPropertyType();
			if(propertyClss == null) continue;
			if(!List.class.isAssignableFrom(propertyClss))
				continue;
			
			String propertyName = propertyDescriptors[i].getName();
			List<BaseObject> propertyValues = (List<BaseObject>)BeanUtil.getPropertyValue(parentObj, propertyName);
			if(propertyValues == null || propertyValues.size() <= 0)
				continue;
			
			for (BaseObject subObject : propertyValues) {
				removeObject(subObject);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#saveObject(java.lang.Object)
	 */
	public void saveObject(Object obj) {
		if(obj == null) return;
		if(!(obj instanceof BaseObject)) return;
		BaseObject bo = (BaseObject)obj;
		
		if(!bo.isCascadeDirty()) return; //如果数据没有改变(包括明细)将不与数据库通信
		
		//获得当前POJO所有父实体的名称（包括其本身）
		List<Entity> entites = getSuperClassName(bo, null, null);
		try{
			if(bo.getPrimarykey() == null){
				for (Entity entity : entites) {
					bo.setVersion(0);					//赋乐观锁
					Map<String, ValueClass2JDBCType> propertyValues = objectToRow(obj);
					insertObject(bo, entity, propertyValues);			//insert
				}
			}
			else{
				for (Entity entity : entites) {
					bo.setVersion(bo.getVersion() + 1); //赋乐观锁
					Map<String, ValueClass2JDBCType> propertyValues = objectToRow(obj);
					updateObject(bo, entity, propertyValues);			//update
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("not found hsc.xml for class:" + bo.getClass().getName());
		}
		
		
		saveItemObjects(bo);			//如果有从save之
	}
	
	protected void insertObject(final BaseObject obj, final Entity entity, final Map<String, ValueClass2JDBCType> propertyValues){
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		this.getJdbcTemplate().update(new PreparedStatementCreator(){

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
				Entity parentEntity = null;
				try {
					parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
				} catch (Exception e) {
					log.error("not found hsc.xml for class:" + obj.getClass().getName());
					e.printStackTrace();
				} 
				
				List<ValueClass2JDBCType> values = new ArrayList<ValueClass2JDBCType>();		//存储到待保存的值
				int primaryKeyIndex = 0;
				String primaryKeyName = null;
				
				StringBuffer sqlSb = new StringBuffer("insert into "+entity.getTableName()+" (");
//				赋表字段名
				int stepFlage = 0;
				for(Field field : entity.getField()){
					if(BeanUtil.hasPropertyName(obj, field.getFieldName())){	//定义实体域名如果类属性中有
						if(stepFlage >0)
							sqlSb.append(",");
					
						sqlSb.append(field.getFieldName());
						
						values.add(propertyValues.get(field.getFieldName()));
						
						if(field.isIsPrimaryKey()){
							primaryKeyIndex = stepFlage;	//获得主键Field的索引
							primaryKeyName = field.getFieldName();
							
							if(parentEntity == null){	//如果为空说明该实体不是继承实体,加version
								sqlSb.append(","+BaseObject.VERSION);
								values.add(propertyValues.get(BaseObject.VERSION));
							}
							
						}
						
						stepFlage++;
					}
				}
				sqlSb.append(") values(");
				
//				赋表值的占位符
				stepFlage = 0;
				for(Field field : entity.getField()){
					if(BeanUtil.hasPropertyName(obj, field.getFieldName())){
						if(stepFlage >0)
							sqlSb.append(",");
						
						sqlSb.append("?");

						if(field.isIsPrimaryKey() && parentEntity == null)
							sqlSb.append(",?");
						
						stepFlage++;
					}
				}
				
				SpringJDBCHiDialect dialect = sessionFactory.getDialect();
				sqlSb.append(")");
				String sql = dialect.insertSql(sqlSb.toString(),entity.getEntityName(), values);
				PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				
				stepFlage = 0;
				for (ValueClass2JDBCType valueClass : values) {
					Object value = valueClass.getValue();
					if(stepFlage == primaryKeyIndex && valueClass.getPropertyName().equals(primaryKeyName) && value == null){
						Number _id = dialect.getSelectKey(entity.getEntityName(), getJdbcTemplate().getDataSource());
						if(_id != null){
							BeanUtil.setPropertyValue(obj, primaryKeyName, _id);
							ps.setInt(stepFlage + 1, _id.intValue());
						}
					}
					else if(value == null){
						ps.setNull(stepFlage + 1, valueClass.getJDBCType());
					}
					else if( value instanceof Integer)
						ps.setInt(stepFlage + 1, ((Integer)value).intValue());
					else if( value instanceof Long)
						ps.setLong(stepFlage + 1, ((Long)value).longValue());
					else if (value instanceof String)
						ps.setString(stepFlage + 1, value.toString());
					else if (value instanceof Double)
						ps.setDouble(stepFlage + 1, ((Double) value).doubleValue());
					else if (value instanceof Date)
						ps.setDate(stepFlage + 1, new java.sql.Date(((Date)value).getTime()));
					else if (value instanceof java.sql.Date)
						ps.setDate(stepFlage + 1, (java.sql.Date)value);
					else if (value instanceof Timestamp)
						ps.setTimestamp(stepFlage + 1, (Timestamp)value);
					else
						ps.setObject(stepFlage + 1, value);
					
					stepFlage++;
				}
				
				return ps;
			}
			
		}, keyHolder);
		
		if(obj.getPrimarykey() == null)
			BeanUtil.setPropertyValue(obj, "id", keyHolder.getKey().intValue());
	}
	
	protected void updateObject(final BaseObject obj, final Entity entity, final Map<String, ValueClass2JDBCType> propertyValues){
		this.getJdbcTemplate().update(new PreparedStatementCreator(){

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
				Entity parentEntity = null;
				try {
					parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
				} catch (Exception e) {
					log.error("not found hsc.xml for class:" + obj.getClass().getName());
					e.printStackTrace();
				} 
				
				List<ValueClass2JDBCType> values = new ArrayList<ValueClass2JDBCType>();		//存储到待保存的值
				ValueClass2JDBCType primaryKeyObject = null;
				
				StringBuffer sqlSb = new StringBuffer("update "+entity.getTableName()+" set ");
//				赋表字段名
				int stepFlage = 0;
				for(Field field : entity.getField()){
					if(BeanUtil.hasPropertyName(obj, field.getFieldName())){	//定义实体域名如果类属性中有
						
						if(field.isIsPrimaryKey()){
							primaryKeyObject = propertyValues.get(field.getFieldName());	//获得主键的对象值
							
							if(parentEntity == null){	//如果为空说明该实体不是继承实体,加version
								if(stepFlage >0)
									sqlSb.append(",");
								
								sqlSb.append(BaseObject.VERSION).append("=?");
								values.add(propertyValues.get(BaseObject.VERSION));
								stepFlage++;
								continue;
							}
							
						}
						
						if(stepFlage >0)
							sqlSb.append(",");
						
						sqlSb.append(field.getFieldName()).append("=?");
						values.add(propertyValues.get(field.getFieldName()));
						
						stepFlage++;
					}
				}
				
				sqlSb.append(" where " + primaryKeyObject.getPropertyName() + " = ?");
				
				PreparedStatement ps=con.prepareStatement(sqlSb.toString());
				stepFlage = 0;
				for (ValueClass2JDBCType valueClass : values) {
					Object value = valueClass.getValue();
					
					if(value == null){
						ps.setNull(stepFlage + 1, valueClass.getJDBCType());
					}
					else if( value instanceof Integer)
						ps.setInt(stepFlage + 1, ((Integer)value).intValue());
					else if( value instanceof Long)
						ps.setLong(stepFlage + 1, ((Long)value).longValue());
					else if (value instanceof String)
						ps.setString(stepFlage + 1, value.toString());
					else if (value instanceof Double)
						ps.setDouble(stepFlage + 1, ((Double) value).doubleValue());
					else if (value instanceof Date)
						ps.setDate(stepFlage + 1, new java.sql.Date(((Date)value).getTime()));
					else if (value instanceof java.sql.Date)
						ps.setDate(stepFlage + 1, (java.sql.Date)value);
					else if (value instanceof Timestamp)
						ps.setTimestamp(stepFlage + 1, (Timestamp)value);
					else
						ps.setObject(stepFlage + 1, value);
					
					stepFlage++;
				}
				
				ps.setInt(stepFlage + 1, Integer.parseInt(primaryKeyObject.getValue().toString()));
				return ps;

			}
			
		});
		
	}
	
	protected void saveItemObjects(BaseObject masterObj){
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(masterObj);//获得所有父表属性
		for (int i = 0; i < propertyDescriptors.length; i++) {
			Class propertyClss = propertyDescriptors[i].getPropertyType();//获得属性的类型
			if(!List.class.isAssignableFrom(propertyClss))//如果不是list类型的活跳过
				continue;
			
			String propertyName = propertyDescriptors[i].getName();//获得属性的名称
			List _propertyValues = (List)BeanUtil.getPropertyValue(masterObj, propertyName);//获得list里所有值
			if(_propertyValues == null || _propertyValues.size() <= 0)
				continue;
			
			//如果集合中的元素不是BaseObject的
			Object element = _propertyValues.get(0);
			if(!(element instanceof BaseObject))
				continue;
			List<BaseObject> propertyValues = (List<BaseObject>)_propertyValues;
			
			//判断该主实体下是否有这个从实体
			Entity subEntity = null;
			try{
				if(HSC.getEntity(element.getClass()) == null)	//如果元素所对应的实体不存在就跳过
					continue;
				List<Entity> itemEntitys = HSC.getItemEntities(masterObj.getClass());
				for (Entity itemEntity : itemEntitys) {
					if(HSC.getEntityClass(itemEntity).equals(element.getClass())){
						subEntity = itemEntity;
						break;
					}
				}
			} catch (Exception e) {}
			if(subEntity == null)
				continue;
			
			
			for (BaseObject baseObject : propertyValues) {//获得list中的实体 循环保存
				List<Field> fields = subEntity.getField();//获得实体的所有属性
				for (Field field : fields) {
					if(!field.isIsParent()) continue;
					String _parentClassName = field.getLookupEntity().getLkEntityName();//获得祖先类名称
					if(!_parentClassName.equals(masterObj.getClass().getSimpleName()))
						continue;
					BeanUtil.setPropertyValue(baseObject, field.getFieldName(), masterObj);
				}
				this.saveObject(baseObject);
			}
		}
	}
	/**
     * 将对象参数转换成map做参数
     */
	protected  Map<String, ValueClass2JDBCType> objectToRow(Object obj) {
		Map<String, ValueClass2JDBCType> rowMap= new HashMap<String, ValueClass2JDBCType>();
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);//获得对象的所有属性描述
		for (int i = 0; i < propertyDescriptors.length; i++) {
			if(propertyDescriptors[i].getWriteMethod() == null) // 如果没有set方法就说明没有属性与数据库字段对应，忽略
				continue;
			Class propertyClss = propertyDescriptors[i].getPropertyType();//获得属性的类型
			String propertyName = propertyDescriptors[i].getName();//获得属性的名字
			Object propertyValue = BeanUtil.getPropertyValue(obj, propertyName);//获得属性值
			if(propertyClss == null) continue;
			//如果不是baseObject子类 或者 集合类型 
			if(!BaseObject.class.isAssignableFrom(propertyClss) && !Collection.class.isAssignableFrom(propertyClss)){//如果不是类对象 并且不是数组
				
				 rowMap.put(propertyName, new ValueClass2JDBCType(propertyClss, propertyValue, propertyName));
				 continue;
			 }
			 //如果是baseObject类型 那么value值方对象的主键id
			 if(BaseObject.class.isAssignableFrom(propertyClss)){
				 
				 BaseObject baseObj = (BaseObject)propertyValue;
				 rowMap.put(propertyName, new ValueClass2JDBCType(Integer.class, baseObj == null ? null : baseObj.getPrimarykey(), propertyName));
				 continue;
			 }
		}
		return rowMap;
	}

	private SpringJDBCQuery[] setupQuery(Class clazz, Filter filter,Sorter sorter, Page page){
    	
		StringBuffer mainSb = new StringBuffer(); //主SQL语句（统计与查询共用）
		SpringJDBCQuery countSb = new SpringJDBCQuery(); //统计记录数的SQL语句
		SpringJDBCQuery selectSb = new SpringJDBCQuery(); //查询记录数的SQL语句
		String orderSt = "";	//排序的字符串
		
		Entity entity = null;
		String tableName = null,aliasName = null;
		try {
			entity = getEntity(clazz);//通过class获得实体类
			tableName = entity.getTableName(); //获得实体的表名
			aliasName = filter == null || filter.getAliasName() == null ? tableName : filter.getAliasName();//设置别名
		} catch (Exception e) {
			log.error("not found Entity Define by className:" + clazz.getName());
		}
		
		List<Entity> entities = this.getSuperClassName(entity, null, null);//获得包括实体在内的所有祖先实体
		
		Map<String, DomainORInfo> domainInfos = this.getDomainInfo(clazz, filter, sorter, entities);
		
		selectSb.append("select ");
		for (int i = 0; i < entities.size(); i++) {			//如果有继承要加继承表的所有字段
			if(i > 0)
				selectSb.append(",");
			
			selectSb.append(entities.get(i).getTableName()).append(".* ");
		}
		
		countSb.append("select count(*) ");
	
		//加sql部分数据库表
		mainSb.append("from ");
		//加自己及继承表
		for (int i = 0; i < entities.size(); i++) {			//如果有继承要加继承表的
			if(i > 0)
				mainSb.append(",");
			mainSb.append(entities.get(i).getTableName()).append(" ").append(entities.get(i).getTableName()).append(" ");
		}
		
		//加domain的表
		for (Map.Entry<String, DomainORInfo> entry : domainInfos.entrySet()){
			DomainORInfo domainORInfo = entry.getValue();
			mainSb.append(",").append(domainORInfo.getTableName()).append(" ")//加表名
			.append(domainORInfo.getPropertyName()).append(" ");//加属性名
		}
		
		if(domainInfos.size() > 0 ||  entities.size() > 1)
			mainSb.append(" where ");
		
		//加sql部分数据库表连接
		String[] keySet = domainInfos.keySet().toArray(new String[domainInfos.keySet().size()]);
		int andSetp = 0; //在where后面加and的累加器
		for (int i = 0; i < keySet.length; i++) {
			if(andSetp > 0)
				mainSb.append(" and ");

			DomainORInfo domainORInfo = domainInfos.get(keySet[i]);			
			mainSb.append(domainORInfo.getResourcePropertyName() == null ? aliasName : domainORInfo.getResourcePropertyName()).append(".").append(domainORInfo.getPropertyName())
			.append("=").append(domainORInfo.getPropertyName()).append(".").append("id ");
			andSetp ++;
		}
		if(entities.size() > 1){
			for (int i = 0; i < entities.size() - 1; i++) {	
				if(andSetp > 0)
					mainSb.append(" and ");
				mainSb.append(tableName).append(".id = ")
				.append(entities.get(i).getTableName()).append(".id ");
				andSetp ++;
			}
		}
		
		
		/*SQL的过滤部分*/
		if(filter != null && filter.getConditions().size() > 0){
			if(andSetp == 0)
				mainSb.append(" where ");
			else
				mainSb.append(" and ");
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			if(filterGroup.size() < 2) //如果filter组中只有它自己，没有通过addFilter方法连接的
				setupConditions(entities, mainSb, filterBeans, aliasName, null);
			else{
				for(int i = 0; i < filterGroup.size(); i++){
					List<FilterBean> filtergroup = filterGroup.get(i);
					setupConditions(entities, mainSb, filtergroup, aliasName, i);
					mainSb.append(") ");
				}
			}
		}			
		
		
		selectSb.append(mainSb);
		/*SQL的排序部分*/
		if(sorter != null && !sorter.getSorts().isEmpty()){
			orderSt = " order by "; 
			
			Map<String, String> sorts = sorter.getSorts();
			int _step = 0;
			for (Map.Entry<String, String> entry : sorts.entrySet()){
				String properyName = entry.getKey();
				if(!properyName.contains(".")){
					String _aliasName = aliasName;
					for (Entity _entity : entities) { //如果是实体继承
						try {
							Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), _entity, properyName);
							if(field != null && field.getFieldType() != FieldType.FIELD_TYPE_LOOKUP){
								_aliasName = _entity.getTableName();
								break;
							}
						} catch (Exception e) {}
						
					}
					properyName = _aliasName + "."  + properyName;
				}
				else{
					String[] domainProperty = properyName.split("[.]");
					properyName = domainProperty[domainProperty.length - 2] + "." + domainProperty[domainProperty.length - 1];
				}
				if(_step > 0)
					orderSt += ", ";

				orderSt += properyName + " " + entry.getValue();
				
				_step++;
			}

		}
		countSb.append(mainSb);
		
		/*为count加最大限记录数，提升大数据量的检索速度*/
		if(sessionFactory.getDialect() instanceof SpringJDBCHiDialect) {
			SpringJDBCHiDialect dialect = (SpringJDBCHiDialect)sessionFactory.getDialect();
			dialect.getMaxRecode(countSb, filter, page);
		}
		
		SpringJDBCQuery selectQuery = selectSb.append(orderSt);
		
		/*向过滤条件的引用占位符中添加相应的值*/
		if(filter != null  && filter.getConditions().size() > 0){
			List<FilterBean> filterBeans = filter.getConditions();
			for (int i = 0; i< filterBeans.size(); i++) {
				FilterBean filterBean =  filterBeans.get(i);
				
				if(filterBean.getValue() == null)
					continue;
				
				String operater = filterBean.getOperater();
				
				/*如果是值的类型是字符串，并且操作符是like则在值的两端加百分号（%）*/
				if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
					String val = (String)filterBean.getValue();
					//判断like的控制符
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
						val = "%" + val;
					else if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
						val =  val + "%";
					else if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
						val =  "%" + val + "%";	
					else
						val =  "%" + val + "%";
					
					filterBean.setValue(val);
				}
				
				selectQuery.putParameter(filterBean.getFieldName() + i,filterBean.getValue());  //为SQL的Query对象,设置引用占位符的值
				if(page != null)
					countSb.putParameter(filterBean.getFieldName() + i,filterBean.getValue());
				
			}
		}
		/*创建统计返回查询记录数与需要查询的Query实例*/
		SpringJDBCQuery countQuery = null;
		if (page != null) 
			countQuery = countSb;
		SpringJDBCQuery[] querySql = {selectQuery,countQuery};
		return querySql;
	}

    
    private void setupConditions(List<Entity> entities,StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex){
		/*为SQL条件部分设置引用占位符*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //如果是第一个条件组,则在最前面加个括号 group主要就是为了添加括号用
				mainSb.append("( ");
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //如果不是第一个条件组,则在关系符后面加括号
				mainSb.append(filterBean.getRelations()).append(" ( ");
			if(i > 0 )
				mainSb.append(" ").append(filterBean.getRelations()).append(" ");			//添加两个条件之间的关系符
			
			if(aliasName != null && !aliasName.trim().equals("")){
				
				//获取待级联的表的别名
				String tableName = aliasName;
				if(entities.size() > 1){
					String fieldName = filterBean.getFieldName();
					if(fieldName.contains("."))
						fieldName = fieldName.substring(0, fieldName.indexOf("."));
					entityLabel:for(int j=entities.size()-1;j>=0;j--){			//如果有继承要加继承表的
						List<Field> allFields=entities.get(j).getField();
						for (Field field : allFields) {
							if(field.getFieldName().equals(fieldName)){
								tableName = entities.get(j).getTableName();
						        break entityLabel;
							}
						}
					}
				}
				
				//对查询条件级联字段的处理
				if(!filterBean.getFieldName().contains(".")){
					mainSb.append(tableName + ".");
					mainSb.append(filterBean.getFieldName()).append(" ");
				}
				else{
					String[] fieldNames = filterBean.getFieldName().split("[.]");//拆分还有"."的属性名称
					mainSb.append(fieldNames[fieldNames.length - 2] + "." + fieldNames[fieldNames.length - 1]).append(" ");//留下属性的后两个a.b
				}
				
			}
			Object val = filterBean.getValue();
			if(val == null){
				if (operater.equals(Filter.OPERATOR_EQ))
					mainSb.append("IS NULL ");
				else
					mainSb.append("IS NOT NULL ");
				continue;
			}
			mainSb.append(operater).append(" "); 				//添加操作符
			
			if(filterBean.isNot())					
				mainSb.append("NOT ");							//添加NOT操作符
			
			/*如果是值的类型是字符串，并且操作符是like则在值的两端加百分号（%）*/
			if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
				val = (String)filterBean.getValue();
				//判断like的控制符
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
					val = "%" + val;
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
					val =  val + "%";
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
					val =  "%" + val + "%";
				filterBean.setValue(val);
			}
			
			if(operater.equals(Filter.OPERATOR_IN)){		//	如果操作符是IN，则每一个值对应一个引用占位符
				mainSb.append("(");
				Collection coll = (Collection)filterBean.getValue();
				for(int j = 0; j < coll.size(); j++){
					if(j > 0)
						mainSb.append(",");
					mainSb.append("?");
					
				}
				mainSb.append(") ");
			}
			else{
				if(filterBean.getValue() instanceof BaseObject)
					mainSb.append(((BaseObject)filterBean.getValue()).getPrimarykey());
				else
		            mainSb.append("?");		
			}
		}
	}
    
	/**
     * 通过Filter和Sorter及表继承从而处理出表与表之前的关联关系
     * 将封装好的实体信息对象封装成map
     */
    private Map<String,DomainORInfo> getDomainInfo(Class clazz, Filter filter, Sorter sorter, List<Entity> entities){
    	Map<String ,DomainORInfo> result = new HashMap<String ,DomainORInfo>();		//用Map的目的是确保相应的属性信息只有一个
    	if(filter != null && filter.getConditions().size() > 0){//如果过滤器不为空
    		List<FilterBean> filterBeans1 = filter.getConditions();//获得所有过滤条件
        	for (int i = 0; i<filterBeans1.size(); i++) {
    			FilterBean filterBean = (FilterBean) filterBeans1.get(i);
    			if(!filterBean.getFieldName().contains("."))//如果属性名称中不包括"."  跳过
    				continue;

    			String[] domainProperty = filterBean.getFieldName().split("[.]");//用"."进行拆分属性名字
    			PropertyDescriptor domainPropertyDescriptor = null;
    			Entity domainEntity = null;
    			Class dominClazz = clazz;
    			for (int j = 0; j < domainProperty.length - 1 ; j++) {
    				try {
    					//
    					domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[j]);
    					dominClazz = domainPropertyDescriptor.getPropertyType();//获得实体类型
    					domainEntity = getEntity( dominClazz);//获得domain matedata实体信息
    				} catch (Exception e) {continue;}

    				DomainORInfo domainInfo = new DomainORInfo();
    				domainInfo.setTableName(domainEntity.getTableName());//设置表名  
    				domainInfo.setPropertyName(domainProperty[j]);//设置属性名字
    				
    				if(j > 0)  //表示有多表级联，因为加.
    					domainInfo.setResourcePropertyName(domainProperty[j-1]);//表连接左半部分的别名
    				
    				//没有级联但有表继承，如果在本实体中找不到当前的属性，则在祖先实体中做匹配，并将表名赋给resourcePropertyName
    				if(entities.size() > 1 && j <= 0){
    					String fieldName = filterBean.getFieldName();
    					if(fieldName.contains("."))
    						fieldName = fieldName.substring(0, fieldName.indexOf("."));
    					entityLabel:for(int z=entities.size()-1; z>=0; z--){			//如果有继承要加继承表的
    						List<Field> allFields=entities.get(z).getField();
    						for (Field field : allFields) {
    							if(field.getFieldName().equals(fieldName)){
    								domainInfo.setResourcePropertyName(entities.get(z).getTableName());
    						        break entityLabel;
    							}
    						}
    					}
    				}	
    				result.put(domainProperty[j], domainInfo);
    	    	}
        	}
        }
    	
    	//循环对含有"."的属性名称进行拆分
    	if(sorter!=null && sorter.getSorts().size()>0){
    		Map<String,String> sorterMap = sorter.getSorts();
    		Set<String> keyValue = sorterMap.keySet();
    		for (String string : keyValue) {
				if(!string.contains("."))
					continue;
			String[] domainProperty = string.split("[.]");
			PropertyDescriptor domainPropertyDescriptor = null;
			Entity domainEntity;
			Class dominClazz = clazz;
			for (int i = 0; i < domainProperty.length - 1 ; i++) {//获得domin类属性对应的实体
				try {
					domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[i]);
					dominClazz = domainPropertyDescriptor.getPropertyType();
					domainEntity =getEntity(dominClazz);
				} catch (Exception e) {continue;}
				//开始封装domainORInfo
				DomainORInfo domainInfo = new DomainORInfo();
				domainInfo.setTableName(domainEntity.getTableName());
				domainInfo.setPropertyName(domainProperty[i]);
				if(i > 0)
					domainInfo.setResourcePropertyName(domainProperty[i-1]);
				
				//没有级联但有表继承，如果在本实体中找不到当前的属性，则在祖先实体中做匹配，并将表名赋给resourcePropertyName
				if(entities.size() > 1 && i <= 0){
					String fieldName = string;
					if(fieldName.contains("."))
						fieldName = fieldName.substring(0, fieldName.indexOf("."));
					entityLabel:for(int z=entities.size()-1; z>=0; z--){			//如果有继承要加继承表的
						List<Field> allFields=entities.get(z).getField();
						for (Field field : allFields) {
							if(field.getFieldName().equals(fieldName)){
								domainInfo.setResourcePropertyName(entities.get(z).getTableName());
						        break entityLabel;
							}
						}
					}
				}					
				result.put(domainProperty[i], domainInfo);
	    		}
    		}
    	}
    	return result;
    }	
	
	 /**
     * 获得包括当前类在内的所有祖先对象实体
     */	
	private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity){
		if(entitis == null)
			entitis = new ArrayList<Entity>();
		
		String servletRootPath = SpringContextHolder.getServletContext().getRealPath("");
		Entity entity = null;
		try {
			if(obj != null){
				if(obj instanceof BaseObject)
					entity = getEntity(obj.getClass());//获得给定类型的实体
				if(obj instanceof Class)
					entity = getEntity((Class)obj);
				if(obj instanceof Entity)
					entity = (Entity)obj;
			}
			else
				entity = superEntity;
			
			ExtendEntity extendEntity = entity.getExtendEntity();//获得继承的实体
			if(extendEntity != null  && extendEntity.getExtendEntityName() != null && !extendEntity.getExtendEntityName().trim().equals("")){
				//获得祖先实体的名字
				getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("not found hsc.xml for class:" + obj.getClass().getName());
		}
		
		if(entity != null)
			entitis.add(entity);
		
		return entitis;
	}
	
	private Entity getEntity(Class clazz){
		Entity entity = null;
		try {
			entity = HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), clazz);
		} catch (Exception e) {
			log.error("not found hsc.xml for class:" + clazz.getName());
			e.printStackTrace();
		}
		return entity;
	}
	
	
	 /**
     * 将filter中的属性封装成java类 方便数据的传输
     */
	
	class DomainORInfo{
		/**
		 * where条件=右侧的表名
		 */
		String tableName;
		/**
		 * where条件=右侧属性名
		 */
		String propertyName;
		/**
		 * where条件=左侧的属性名
		 */
		String resourcePropertyName;
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public String getPropertyName() {
			return propertyName;
		}
		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
		public String getResourcePropertyName() {
			return resourcePropertyName;
		}
		public void setResourcePropertyName(String resourcePropertyName) {
			this.resourcePropertyName = resourcePropertyName;
		}
	}
	
	
	 class SpringJDBCHiRowMapper implements RowMapper {
		 private Class clazz;
		 private Object obj;
		 private int level;
		 private Page page;
		 
		 SpringJDBCHiRowMapper(Class clazz, Object obj, int level, Page page){
			this.clazz = clazz;
			this.obj = obj;
			this.level = level;
			this.page = page;
		}
		 
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SpringJDBCHiDialect dialect = sessionFactory.getDialect();
			if(!dialect.inResult(rowNum, page))  //是否计入结果集之中，这个方言方法主要是针对sqlserver2000，因为top会有垃圾数据
				return null;
			
			if(obj == null || rowNum > 0)
				obj = BeanUtil.CreateObject(clazz.getName());
			
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				int rsColIndex = i + 1;
				String fieldName = rs.getMetaData().getColumnName(rsColIndex);
				
				//通过表字符找到类所对应的属性
			PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(clazz);
			String propertyName =  null;
			for (int j = 0; j < properties.length; j++) {
				propertyName = properties[j].getName();
				if(propertyName.toUpperCase().equals(fieldName.toUpperCase()))
					break;
			}
			if(propertyName == null) propertyName = fieldName;
			
			Class propertyClass = BeanUtil.getProperyClass(obj, propertyName);
			Object value = null;
			if(propertyClass.equals(Integer.class))
				value = rs.getObject(rsColIndex) == null ? null : rs.getInt(rsColIndex);
			if(propertyClass.equals(String.class))
				value = rs.getString(rsColIndex);
			if(propertyClass.equals(Date.class))
				value = rs.getDate(rsColIndex);
			if(propertyClass.equals(Timestamp.class))
				value = rs.getTimestamp(rsColIndex);
			if(propertyClass.equals(Double.class))
				value = rs.getObject(rsColIndex) == null ? null :rs.getDouble(rsColIndex);
			if(propertyClass.equals(Long.class))
				value = rs.getObject(rsColIndex) == null ? null :rs.getLong(rsColIndex);
			if(propertyClass.equals(Short.class))
				value = rs.getObject(rsColIndex) == null ? null :rs.getShort(rsColIndex);
			if(propertyClass.equals(Float.class))
				value = rs.getObject(rsColIndex) == null ? null :rs.getFloat(rsColIndex);
			if(propertyClass.equals(Byte.class))
				value = rs.getByte(rsColIndex);					
			if(propertyClass.equals(BigDecimal.class))
				value = rs.getBigDecimal(rsColIndex);
			if(propertyClass.equals(BigInteger.class))
				value = rs.getObject(rsColIndex) == null ? null : new BigInteger(rs.getString(rsColIndex));
			//lookup
			if(BaseObject.class.isAssignableFrom(propertyClass)){
				String domainObjectId = rs.getString(rsColIndex);
				if(domainObjectId != null){
					
//					判断该属性是不是主实体的引用
					boolean isParentField = false;
					try{
						Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), obj.getClass(), propertyName);
						isParentField = field.isIsParent();			//将其实在try块内，是为了拦截住空指针异常
					}
					catch (Exception e) {
						log.error("not found hsc.xml for class:" + obj.getClass().getName());
						e.printStackTrace();
					}
					
//					如果不是主实体的引用时才做处理，否则会陷入主找从，而从又找主的死循环之中
					if(!isParentField)
						value = getObject(propertyClass, rs.getInt(rsColIndex), level+1, BeanUtil.CreateObject(propertyClass.getName()));
				}
			}
			
			BeanUtil.setPropertyValue(obj, propertyName, value);
		}
	
		//实体继承的父实体
		Class superclass = getSuperClass(clazz);
		if(superclass != null)
			getObject(superclass, ((BaseObject)obj).getPrimarykey(), 0, obj);

		
		//从实体列表
		
		String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);//获得所有父表属性
		for (int i = 0; i < propertyDescriptors.length; i++) {
			Class propertyClss = propertyDescriptors[i].getPropertyType();//获得属性的类型
			if(!List.class.isAssignableFrom(propertyClss))
				continue;
			
				String propertyName = propertyDescriptors[i].getName();
				Method method = propertyDescriptors[i].getReadMethod();
				Type returnType = method.getGenericReturnType();
				if (returnType instanceof ParameterizedType) {
					Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();
					if(types != null && types.length > 0){
						Class itemClass = (Class)types[0];		//获得集合元素的类型
						
						Entity itemEntity = null;
						String item2MasterPropertyName = null;
						try{
							itemEntity = HSCHelper.getEntity(servletRootDir, itemClass);	//通过从实体找到主实体的属性名item2MasterPropertyName
							for (Field field : itemEntity.getField()) {
								if(field.isIsParent()){
									item2MasterPropertyName = field.getFieldName();
									break;
								}
							}
						}
						catch (Exception e) {
							log.error("not found item hsc.xml for class:" + itemClass.getName());
							e.printStackTrace();
						}
						
						Filter filter = FilterFactory.getSimpleFilter(item2MasterPropertyName, ((BaseObject)obj).getPrimarykey(), Filter.OPERATOR_EQ);
						Collection itemValues = getObjects(itemClass, filter);
						for (Object itemObj : itemValues) {
							BeanUtil.setPropertyValue(itemObj, item2MasterPropertyName, obj); //循环从实体POJO对其赋主实体的POJO对象
						}
						BeanUtil.setPropertyValue(obj, propertyName, itemValues);	//为主实体POJO赋从实体的POJO集合
					}
				}
		}
		
		return obj;
	}
		
		private Class getSuperClass(Class clazz){
			Class superclass = clazz.getSuperclass();
			if(clazz == null)
				return null;
			if(superclass.equals(BaseObject.class) || superclass.equals(Object.class))
				return null;
			if(Modifier.isAbstract(superclass.getModifiers()))
				return getSuperClass(superclass);
			
			return superclass;
		}
	 }
	 
	 class HiRowMapperResultSetExtractor extends RowMapperResultSetExtractor{
		private RowMapper rowMapper;
		public HiRowMapperResultSetExtractor(RowMapper rowMapper) {
			super(rowMapper);
			this.rowMapper = rowMapper;
		}
		public Object extractData(ResultSet rs) throws SQLException {
			List results =  new LinkedList();
			int rowNum = 0;
			while (rs.next()) {
				Object obj = this.rowMapper.mapRow(rs, rowNum++);
				if(obj != null)
				results.add(obj);
			}
			return results;
		}
	 }
	 
	public class POJOInfo {
		 private Serializable primarykey;
		 private Class clazz;
		 private Object pojo;
		
		public POJOInfo(Serializable primarykey, Class clazz){
			this.primarykey = primarykey;
			this.clazz = clazz;
		}
		public Serializable getPrimarykey() {
			return primarykey;
		}
		public void setPrimarykey(Serializable primarykey) {
			this.primarykey = primarykey;
		}
		public Class getClazz() {
			return clazz;
		}
		public void setClazz(Class clazz) {
			this.clazz = clazz;
		}
		public Object getPojo() {
			return pojo;
		}
		public void setPojo(Object pojo) {
			this.pojo = pojo;
		}
		public boolean equals(Object obj) {
			if(!(obj instanceof POJOInfo))
				return false;
			POJOInfo info = (POJOInfo)obj;
			return this.clazz.equals(info.clazz) && this.primarykey.equals(info.primarykey);
		}
		 
	 }

	public HiDialect getDialect() {
		if(sessionFactory.getDialect() instanceof SpringJDBCHiDialect) {
			return (SpringJDBCHiDialect)sessionFactory.getDialect();
		}
		return null;
	}
}
class ValueClass2JDBCType{
	 private Object value;
	 private Class clazz;
	 private String propertyName;
	 private static Map CLASS_TYPE = new HashMap();
	 static{
		 CLASS_TYPE.put(Integer.class, Types.NUMERIC);
		 CLASS_TYPE.put(Double.class, Types.NUMERIC);
		 CLASS_TYPE.put(String.class, Types.LONGVARCHAR);
		 CLASS_TYPE.put(Date.class, Types.DATE);
		 CLASS_TYPE.put(Timestamp.class, Types.DATE);
		  
	 }
	public ValueClass2JDBCType(Class clazz, Object value, String propertyName){
		this.clazz = clazz;
		this.value = value;
		this.propertyName = propertyName;
	}
	public int getJDBCType(){
		return (int) Integer.parseInt(CLASS_TYPE.get(clazz).toString());
	
}
	public Object getValue() {
		return value;
	}
	public Class getClazz() {
		return clazz;
	}
	public String getPropertyName() {
		return propertyName;
	}
	 
}