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
 * �����ǽӿ�DAO����ײ�ʵ�����е�һ��,�Ƕ�ORM����SpringJDBC��DAO��ʵ�֡�����̳���SpringJDBCDaoSuppert��������DAOʵ�ֵķ������,
 * ������һ��SessionFactory���ò������ṩ�����ݿ����ӵĶ���,���ո��໹�Ǽ̳�Spring�ṩ��JdbcDaoSupport���Ե���JDBC��ײ��Connection.
 * 
 * ������֪,springJDBCû���ṩORM��ӳ�������ļ������Ե�ӳ���ϵ����ͨ��RowMapper�ӿ����ֶ����ʵ��,Ϊ�˽�����Щ��ζ���Ͷ�,�����ṩ�˶�̬Mapping�Ľ������.
 * ��ԭ����ͨ��ƽ̨��hmc�ļ�����ϵ�����ݿ�Ľ����POJOӳ����һ��.ͬʱ��ͳ��springJDBCҲͬʱ��֧�����ݿ�˵ķ�ҳ����,�����ֲ��������ȱ�ݣ�ͨ��������ʵ�ֿ�����
 * ��ķ�ҳ��ѯ����
 * @author ���
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
		
//		����������о�ֱ�Ӵӻ�����ȡ
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
			
//			���뻺��
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
		SpringJDBCQuery selectQuery = querys[0];//��ѯ�������
		SpringJDBCQuery countQuery = querys[1];//��ѯ�������

		int skip =0;
		int max = 0;
		if(page != null && countQuery != null){
			int count = getObjectCount(countQuery); //��������
			
			//�����ʵ��¼������޼�¼����ȡ����޼�¼��
			count = page.getMaxRecords() != 0 && count > page.getMaxRecords() ? page.getMaxRecords() : count;
				
			page.setTotalRecords(count);		//���ò�ѯ������ܼ�¼��
			
			int totoalPage = 0;
			totoalPage= count%page.getPageSize() > 0 ? count/page.getPageSize() + 1  : count/page.getPageSize();
			page.setTotalPage(totoalPage);						//���ò�ѯ�������ҳ��
			
			skip =page.getStartRowPosition(); 	//���÷��صĵ�һ����¼��λ��
			
			if(page.getMaxRecords() != 0 && (page.getStartRowPosition() + page.getPageSize()) > page.getMaxRecords()){
				max =page.getMaxRecords() - page.getStartRowPosition();
			}
			else
				max =page.getPageSize();			//���÷��صļ�¼��

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
		this.removeSubObject(baseObj);//ɾ���ӱ����
		List<Entity> entitis = this.getSuperClassName(obj, null, null);//�����������
		for (Entity entity : entitis){ //����ɾ���̳е����ȶ���
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
     * ɾ�����Ӷ���
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
		
		if(!bo.isCascadeDirty()) return; //�������û�иı�(������ϸ)���������ݿ�ͨ��
		
		//��õ�ǰPOJO���и�ʵ������ƣ������䱾��
		List<Entity> entites = getSuperClassName(bo, null, null);
		try{
			if(bo.getPrimarykey() == null){
				for (Entity entity : entites) {
					bo.setVersion(0);					//���ֹ���
					Map<String, ValueClass2JDBCType> propertyValues = objectToRow(obj);
					insertObject(bo, entity, propertyValues);			//insert
				}
			}
			else{
				for (Entity entity : entites) {
					bo.setVersion(bo.getVersion() + 1); //���ֹ���
					Map<String, ValueClass2JDBCType> propertyValues = objectToRow(obj);
					updateObject(bo, entity, propertyValues);			//update
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("not found hsc.xml for class:" + bo.getClass().getName());
		}
		
		
		saveItemObjects(bo);			//����д�save֮
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
				
				List<ValueClass2JDBCType> values = new ArrayList<ValueClass2JDBCType>();		//�洢���������ֵ
				int primaryKeyIndex = 0;
				String primaryKeyName = null;
				
				StringBuffer sqlSb = new StringBuffer("insert into "+entity.getTableName()+" (");
//				�����ֶ���
				int stepFlage = 0;
				for(Field field : entity.getField()){
					if(BeanUtil.hasPropertyName(obj, field.getFieldName())){	//����ʵ�������������������
						if(stepFlage >0)
							sqlSb.append(",");
					
						sqlSb.append(field.getFieldName());
						
						values.add(propertyValues.get(field.getFieldName()));
						
						if(field.isIsPrimaryKey()){
							primaryKeyIndex = stepFlage;	//�������Field������
							primaryKeyName = field.getFieldName();
							
							if(parentEntity == null){	//���Ϊ��˵����ʵ�岻�Ǽ̳�ʵ��,��version
								sqlSb.append(","+BaseObject.VERSION);
								values.add(propertyValues.get(BaseObject.VERSION));
							}
							
						}
						
						stepFlage++;
					}
				}
				sqlSb.append(") values(");
				
//				����ֵ��ռλ��
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
				
				List<ValueClass2JDBCType> values = new ArrayList<ValueClass2JDBCType>();		//�洢���������ֵ
				ValueClass2JDBCType primaryKeyObject = null;
				
				StringBuffer sqlSb = new StringBuffer("update "+entity.getTableName()+" set ");
//				�����ֶ���
				int stepFlage = 0;
				for(Field field : entity.getField()){
					if(BeanUtil.hasPropertyName(obj, field.getFieldName())){	//����ʵ�������������������
						
						if(field.isIsPrimaryKey()){
							primaryKeyObject = propertyValues.get(field.getFieldName());	//��������Ķ���ֵ
							
							if(parentEntity == null){	//���Ϊ��˵����ʵ�岻�Ǽ̳�ʵ��,��version
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
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(masterObj);//������и�������
		for (int i = 0; i < propertyDescriptors.length; i++) {
			Class propertyClss = propertyDescriptors[i].getPropertyType();//������Ե�����
			if(!List.class.isAssignableFrom(propertyClss))//�������list���͵Ļ�����
				continue;
			
			String propertyName = propertyDescriptors[i].getName();//������Ե�����
			List _propertyValues = (List)BeanUtil.getPropertyValue(masterObj, propertyName);//���list������ֵ
			if(_propertyValues == null || _propertyValues.size() <= 0)
				continue;
			
			//��������е�Ԫ�ز���BaseObject��
			Object element = _propertyValues.get(0);
			if(!(element instanceof BaseObject))
				continue;
			List<BaseObject> propertyValues = (List<BaseObject>)_propertyValues;
			
			//�жϸ���ʵ�����Ƿ��������ʵ��
			Entity subEntity = null;
			try{
				if(HSC.getEntity(element.getClass()) == null)	//���Ԫ������Ӧ��ʵ�岻���ھ�����
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
			
			
			for (BaseObject baseObject : propertyValues) {//���list�е�ʵ�� ѭ������
				List<Field> fields = subEntity.getField();//���ʵ�����������
				for (Field field : fields) {
					if(!field.isIsParent()) continue;
					String _parentClassName = field.getLookupEntity().getLkEntityName();//�������������
					if(!_parentClassName.equals(masterObj.getClass().getSimpleName()))
						continue;
					BeanUtil.setPropertyValue(baseObject, field.getFieldName(), masterObj);
				}
				this.saveObject(baseObject);
			}
		}
	}
	/**
     * ���������ת����map������
     */
	protected  Map<String, ValueClass2JDBCType> objectToRow(Object obj) {
		Map<String, ValueClass2JDBCType> rowMap= new HashMap<String, ValueClass2JDBCType>();
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);//��ö����������������
		for (int i = 0; i < propertyDescriptors.length; i++) {
			if(propertyDescriptors[i].getWriteMethod() == null) // ���û��set������˵��û�����������ݿ��ֶζ�Ӧ������
				continue;
			Class propertyClss = propertyDescriptors[i].getPropertyType();//������Ե�����
			String propertyName = propertyDescriptors[i].getName();//������Ե�����
			Object propertyValue = BeanUtil.getPropertyValue(obj, propertyName);//�������ֵ
			if(propertyClss == null) continue;
			//�������baseObject���� ���� �������� 
			if(!BaseObject.class.isAssignableFrom(propertyClss) && !Collection.class.isAssignableFrom(propertyClss)){//������������ ���Ҳ�������
				
				 rowMap.put(propertyName, new ValueClass2JDBCType(propertyClss, propertyValue, propertyName));
				 continue;
			 }
			 //�����baseObject���� ��ôvalueֵ�����������id
			 if(BaseObject.class.isAssignableFrom(propertyClss)){
				 
				 BaseObject baseObj = (BaseObject)propertyValue;
				 rowMap.put(propertyName, new ValueClass2JDBCType(Integer.class, baseObj == null ? null : baseObj.getPrimarykey(), propertyName));
				 continue;
			 }
		}
		return rowMap;
	}

	private SpringJDBCQuery[] setupQuery(Class clazz, Filter filter,Sorter sorter, Page page){
    	
		StringBuffer mainSb = new StringBuffer(); //��SQL��䣨ͳ�����ѯ���ã�
		SpringJDBCQuery countSb = new SpringJDBCQuery(); //ͳ�Ƽ�¼����SQL���
		SpringJDBCQuery selectSb = new SpringJDBCQuery(); //��ѯ��¼����SQL���
		String orderSt = "";	//������ַ���
		
		Entity entity = null;
		String tableName = null,aliasName = null;
		try {
			entity = getEntity(clazz);//ͨ��class���ʵ����
			tableName = entity.getTableName(); //���ʵ��ı���
			aliasName = filter == null || filter.getAliasName() == null ? tableName : filter.getAliasName();//���ñ���
		} catch (Exception e) {
			log.error("not found Entity Define by className:" + clazz.getName());
		}
		
		List<Entity> entities = this.getSuperClassName(entity, null, null);//��ð���ʵ�����ڵ���������ʵ��
		
		Map<String, DomainORInfo> domainInfos = this.getDomainInfo(clazz, filter, sorter, entities);
		
		selectSb.append("select ");
		for (int i = 0; i < entities.size(); i++) {			//����м̳�Ҫ�Ӽ̳б�������ֶ�
			if(i > 0)
				selectSb.append(",");
			
			selectSb.append(entities.get(i).getTableName()).append(".* ");
		}
		
		countSb.append("select count(*) ");
	
		//��sql�������ݿ��
		mainSb.append("from ");
		//���Լ����̳б�
		for (int i = 0; i < entities.size(); i++) {			//����м̳�Ҫ�Ӽ̳б��
			if(i > 0)
				mainSb.append(",");
			mainSb.append(entities.get(i).getTableName()).append(" ").append(entities.get(i).getTableName()).append(" ");
		}
		
		//��domain�ı�
		for (Map.Entry<String, DomainORInfo> entry : domainInfos.entrySet()){
			DomainORInfo domainORInfo = entry.getValue();
			mainSb.append(",").append(domainORInfo.getTableName()).append(" ")//�ӱ���
			.append(domainORInfo.getPropertyName()).append(" ");//��������
		}
		
		if(domainInfos.size() > 0 ||  entities.size() > 1)
			mainSb.append(" where ");
		
		//��sql�������ݿ������
		String[] keySet = domainInfos.keySet().toArray(new String[domainInfos.keySet().size()]);
		int andSetp = 0; //��where�����and���ۼ���
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
		
		
		/*SQL�Ĺ��˲���*/
		if(filter != null && filter.getConditions().size() > 0){
			if(andSetp == 0)
				mainSb.append(" where ");
			else
				mainSb.append(" and ");
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			if(filterGroup.size() < 2) //���filter����ֻ�����Լ���û��ͨ��addFilter�������ӵ�
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
		/*SQL�����򲿷�*/
		if(sorter != null && !sorter.getSorts().isEmpty()){
			orderSt = " order by "; 
			
			Map<String, String> sorts = sorter.getSorts();
			int _step = 0;
			for (Map.Entry<String, String> entry : sorts.entrySet()){
				String properyName = entry.getKey();
				if(!properyName.contains(".")){
					String _aliasName = aliasName;
					for (Entity _entity : entities) { //�����ʵ��̳�
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
		
		/*Ϊcount������޼�¼�����������������ļ����ٶ�*/
		if(sessionFactory.getDialect() instanceof SpringJDBCHiDialect) {
			SpringJDBCHiDialect dialect = (SpringJDBCHiDialect)sessionFactory.getDialect();
			dialect.getMaxRecode(countSb, filter, page);
		}
		
		SpringJDBCQuery selectQuery = selectSb.append(orderSt);
		
		/*���������������ռλ���������Ӧ��ֵ*/
		if(filter != null  && filter.getConditions().size() > 0){
			List<FilterBean> filterBeans = filter.getConditions();
			for (int i = 0; i< filterBeans.size(); i++) {
				FilterBean filterBean =  filterBeans.get(i);
				
				if(filterBean.getValue() == null)
					continue;
				
				String operater = filterBean.getOperater();
				
				/*�����ֵ���������ַ��������Ҳ�������like����ֵ�����˼Ӱٷֺţ�%��*/
				if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
					String val = (String)filterBean.getValue();
					//�ж�like�Ŀ��Ʒ�
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
				
				selectQuery.putParameter(filterBean.getFieldName() + i,filterBean.getValue());  //ΪSQL��Query����,��������ռλ����ֵ
				if(page != null)
					countSb.putParameter(filterBean.getFieldName() + i,filterBean.getValue());
				
			}
		}
		/*����ͳ�Ʒ��ز�ѯ��¼������Ҫ��ѯ��Queryʵ��*/
		SpringJDBCQuery countQuery = null;
		if (page != null) 
			countQuery = countSb;
		SpringJDBCQuery[] querySql = {selectQuery,countQuery};
		return querySql;
	}

    
    private void setupConditions(List<Entity> entities,StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex){
		/*ΪSQL����������������ռλ��*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //����ǵ�һ��������,������ǰ��Ӹ����� group��Ҫ����Ϊ�����������
				mainSb.append("( ");
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //������ǵ�һ��������,���ڹ�ϵ�����������
				mainSb.append(filterBean.getRelations()).append(" ( ");
			if(i > 0 )
				mainSb.append(" ").append(filterBean.getRelations()).append(" ");			//�����������֮��Ĺ�ϵ��
			
			if(aliasName != null && !aliasName.trim().equals("")){
				
				//��ȡ�������ı�ı���
				String tableName = aliasName;
				if(entities.size() > 1){
					String fieldName = filterBean.getFieldName();
					if(fieldName.contains("."))
						fieldName = fieldName.substring(0, fieldName.indexOf("."));
					entityLabel:for(int j=entities.size()-1;j>=0;j--){			//����м̳�Ҫ�Ӽ̳б��
						List<Field> allFields=entities.get(j).getField();
						for (Field field : allFields) {
							if(field.getFieldName().equals(fieldName)){
								tableName = entities.get(j).getTableName();
						        break entityLabel;
							}
						}
					}
				}
				
				//�Բ�ѯ���������ֶεĴ���
				if(!filterBean.getFieldName().contains(".")){
					mainSb.append(tableName + ".");
					mainSb.append(filterBean.getFieldName()).append(" ");
				}
				else{
					String[] fieldNames = filterBean.getFieldName().split("[.]");//��ֻ���"."����������
					mainSb.append(fieldNames[fieldNames.length - 2] + "." + fieldNames[fieldNames.length - 1]).append(" ");//�������Եĺ�����a.b
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
			mainSb.append(operater).append(" "); 				//��Ӳ�����
			
			if(filterBean.isNot())					
				mainSb.append("NOT ");							//���NOT������
			
			/*�����ֵ���������ַ��������Ҳ�������like����ֵ�����˼Ӱٷֺţ�%��*/
			if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
				val = (String)filterBean.getValue();
				//�ж�like�Ŀ��Ʒ�
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
					val = "%" + val;
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
					val =  val + "%";
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
					val =  "%" + val + "%";
				filterBean.setValue(val);
			}
			
			if(operater.equals(Filter.OPERATOR_IN)){		//	�����������IN����ÿһ��ֵ��Ӧһ������ռλ��
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
     * ͨ��Filter��Sorter����̳дӶ�����������֮ǰ�Ĺ�����ϵ
     * ����װ�õ�ʵ����Ϣ�����װ��map
     */
    private Map<String,DomainORInfo> getDomainInfo(Class clazz, Filter filter, Sorter sorter, List<Entity> entities){
    	Map<String ,DomainORInfo> result = new HashMap<String ,DomainORInfo>();		//��Map��Ŀ����ȷ����Ӧ��������Ϣֻ��һ��
    	if(filter != null && filter.getConditions().size() > 0){//�����������Ϊ��
    		List<FilterBean> filterBeans1 = filter.getConditions();//������й�������
        	for (int i = 0; i<filterBeans1.size(); i++) {
    			FilterBean filterBean = (FilterBean) filterBeans1.get(i);
    			if(!filterBean.getFieldName().contains("."))//������������в�����"."  ����
    				continue;

    			String[] domainProperty = filterBean.getFieldName().split("[.]");//��"."���в����������
    			PropertyDescriptor domainPropertyDescriptor = null;
    			Entity domainEntity = null;
    			Class dominClazz = clazz;
    			for (int j = 0; j < domainProperty.length - 1 ; j++) {
    				try {
    					//
    					domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[j]);
    					dominClazz = domainPropertyDescriptor.getPropertyType();//���ʵ������
    					domainEntity = getEntity( dominClazz);//���domain matedataʵ����Ϣ
    				} catch (Exception e) {continue;}

    				DomainORInfo domainInfo = new DomainORInfo();
    				domainInfo.setTableName(domainEntity.getTableName());//���ñ���  
    				domainInfo.setPropertyName(domainProperty[j]);//������������
    				
    				if(j > 0)  //��ʾ�ж��������Ϊ��.
    					domainInfo.setResourcePropertyName(domainProperty[j-1]);//��������벿�ֵı���
    				
    				//û�м������б�̳У�����ڱ�ʵ�����Ҳ�����ǰ�����ԣ���������ʵ������ƥ�䣬������������resourcePropertyName
    				if(entities.size() > 1 && j <= 0){
    					String fieldName = filterBean.getFieldName();
    					if(fieldName.contains("."))
    						fieldName = fieldName.substring(0, fieldName.indexOf("."));
    					entityLabel:for(int z=entities.size()-1; z>=0; z--){			//����м̳�Ҫ�Ӽ̳б��
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
    	
    	//ѭ���Ժ���"."���������ƽ��в��
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
			for (int i = 0; i < domainProperty.length - 1 ; i++) {//���domin�����Զ�Ӧ��ʵ��
				try {
					domainPropertyDescriptor = PropertyUtils.getPropertyDescriptor(BeanUtil.CreateObject(dominClazz.getName()), domainProperty[i]);
					dominClazz = domainPropertyDescriptor.getPropertyType();
					domainEntity =getEntity(dominClazz);
				} catch (Exception e) {continue;}
				//��ʼ��װdomainORInfo
				DomainORInfo domainInfo = new DomainORInfo();
				domainInfo.setTableName(domainEntity.getTableName());
				domainInfo.setPropertyName(domainProperty[i]);
				if(i > 0)
					domainInfo.setResourcePropertyName(domainProperty[i-1]);
				
				//û�м������б�̳У�����ڱ�ʵ�����Ҳ�����ǰ�����ԣ���������ʵ������ƥ�䣬������������resourcePropertyName
				if(entities.size() > 1 && i <= 0){
					String fieldName = string;
					if(fieldName.contains("."))
						fieldName = fieldName.substring(0, fieldName.indexOf("."));
					entityLabel:for(int z=entities.size()-1; z>=0; z--){			//����м̳�Ҫ�Ӽ̳б��
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
     * ��ð�����ǰ�����ڵ��������ȶ���ʵ��
     */	
	private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity){
		if(entitis == null)
			entitis = new ArrayList<Entity>();
		
		String servletRootPath = SpringContextHolder.getServletContext().getRealPath("");
		Entity entity = null;
		try {
			if(obj != null){
				if(obj instanceof BaseObject)
					entity = getEntity(obj.getClass());//��ø������͵�ʵ��
				if(obj instanceof Class)
					entity = getEntity((Class)obj);
				if(obj instanceof Entity)
					entity = (Entity)obj;
			}
			else
				entity = superEntity;
			
			ExtendEntity extendEntity = entity.getExtendEntity();//��ü̳е�ʵ��
			if(extendEntity != null  && extendEntity.getExtendEntityName() != null && !extendEntity.getExtendEntityName().trim().equals("")){
				//�������ʵ�������
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
     * ��filter�е����Է�װ��java�� �������ݵĴ���
     */
	
	class DomainORInfo{
		/**
		 * where����=�Ҳ�ı���
		 */
		String tableName;
		/**
		 * where����=�Ҳ�������
		 */
		String propertyName;
		/**
		 * where����=����������
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
			if(!dialect.inResult(rowNum, page))  //�Ƿ��������֮�У�������Է�����Ҫ�����sqlserver2000����Ϊtop������������
				return null;
			
			if(obj == null || rowNum > 0)
				obj = BeanUtil.CreateObject(clazz.getName());
			
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				int rsColIndex = i + 1;
				String fieldName = rs.getMetaData().getColumnName(rsColIndex);
				
				//ͨ�����ַ��ҵ�������Ӧ������
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
					
//					�жϸ������ǲ�����ʵ�������
					boolean isParentField = false;
					try{
						Field field = HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), obj.getClass(), propertyName);
						isParentField = field.isIsParent();			//����ʵ��try���ڣ���Ϊ������ס��ָ���쳣
					}
					catch (Exception e) {
						log.error("not found hsc.xml for class:" + obj.getClass().getName());
						e.printStackTrace();
					}
					
//					���������ʵ�������ʱ��������������������Ҵӣ���������������ѭ��֮��
					if(!isParentField)
						value = getObject(propertyClass, rs.getInt(rsColIndex), level+1, BeanUtil.CreateObject(propertyClass.getName()));
				}
			}
			
			BeanUtil.setPropertyValue(obj, propertyName, value);
		}
	
		//ʵ��̳еĸ�ʵ��
		Class superclass = getSuperClass(clazz);
		if(superclass != null)
			getObject(superclass, ((BaseObject)obj).getPrimarykey(), 0, obj);

		
		//��ʵ���б�
		
		String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);//������и�������
		for (int i = 0; i < propertyDescriptors.length; i++) {
			Class propertyClss = propertyDescriptors[i].getPropertyType();//������Ե�����
			if(!List.class.isAssignableFrom(propertyClss))
				continue;
			
				String propertyName = propertyDescriptors[i].getName();
				Method method = propertyDescriptors[i].getReadMethod();
				Type returnType = method.getGenericReturnType();
				if (returnType instanceof ParameterizedType) {
					Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();
					if(types != null && types.length > 0){
						Class itemClass = (Class)types[0];		//��ü���Ԫ�ص�����
						
						Entity itemEntity = null;
						String item2MasterPropertyName = null;
						try{
							itemEntity = HSCHelper.getEntity(servletRootDir, itemClass);	//ͨ����ʵ���ҵ���ʵ���������item2MasterPropertyName
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
							BeanUtil.setPropertyValue(itemObj, item2MasterPropertyName, obj); //ѭ����ʵ��POJO���丳��ʵ���POJO����
						}
						BeanUtil.setPropertyValue(obj, propertyName, itemValues);	//Ϊ��ʵ��POJO����ʵ���POJO����
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