package org.hi.framework.dao.ibatis;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
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
import org.hi.metadata.hsc.HSC;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.constant.FieldType;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.ExtendEntity;
import org.hi.metadata.hsc.context.service.Field;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;


/**
 * 
 * �����ǽӿ�<code>DAO</code>���ʵ�����е�һ�����Ƕ�Ibatis��DAO��ʵ�֡�
 * <p> ����̳�Spring��<code>SqlMapClientDaoSupport</code>��������DAOʵ�ֵķ�����࣬������
 * һ��SessionFactory���ò������ṩһ��<code>SqlMapClientTemplate</code>ʵ�� 
 * ����<code>SqlMapClientTemplate</code>�����ǣ�����DAO�е����ݷ��ʣ��޷���ں�̨����Ibatis
 * Session.�Զ�����Spring�����ĺ�EJB���������񡣽��ɿ�ʽ<code>IbatisException</code>ת����Spring�ṩ
 * ��ͨ��<code>DataAccessException</code>��νṹ
 * <p>��������е�ʵ�ֽ��ܵ���ƽ̨*.hsc�ļ�(��������������Ԫ�ļ�)����,ʵ����ʵ�������ӹ�ϵ���̳й�ϵ��lookup��ϵ
 * ��ȡ��*.hsc��Щmatedata�ļ����Ӷ�ʵ�������ӻ�ɾ������ʱ�ӱ�ļ�¼Ҳ��һ�����ӻ�ɾ��,����ɾ�ӱ��¼ʱ���ȱ��еļ�¼Ҳ��һ������ɾ��
 * @author ���
 * @author ����ȫ
 * @since 2006-10-15
 * @see org.hi.framework.dao.DAO
 * @see org.springframework.orm.ibatis.support.SqlMapClientDaoSupport
 * @see org.springframework.orm.ibatis.SqlMapClientTemplate
 * @see org.springframework.orm.ibatis.SqlMapClientCallback
 */



public class BaseDAOIbatis extends SqlMapClientDaoSupport implements DAO {
	public static final String ID_PREFIX_GET = "get";
	public static final String ID_PREFIX_DEL = "del";
	public static final String ID_PREFIX_INS = "ins";
	public static final String ID_PREFIX_UPDATE = "update";
	public static final String ID_PREFIX_LIST = "list";
	public static final String ID_PREFIX_COUNT = "count";
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * ibatis�Ĺ���
	 */
	private HiSqlMapClientFactoryBean sessionFactory; 
	
	/**
	 * @param sqlMapClient
	 */
	public void setSessionFactory(SqlMapClient sqlMapClient){
		setSqlMapClient(sqlMapClient);
		sessionFactory = (HiSqlMapClientFactoryBean)SpringContextHolder.getBean("&sessionFactory");
	}
	
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectById(java.lang.Class, java.io.Serializable)
	 */
	public Object getObjectById(Class clazz, Serializable id) {
		if(id == null || Integer.parseInt(id.toString()) < 0)
			return null;
		
		BaseObject bo = null;
		List<Entity> entitis = getSuperClassName(clazz, null, null);
		if(entitis.size() <=1){
			String name = ID_PREFIX_GET+clazz.getSimpleName();
			bo = (BaseObject)getSqlMapClientTemplate().queryForObject(name, id);
		}
		else{
			Filter filter = FilterFactory.getSimpleFilter("id", id, Filter.OPERATOR_EQ);
			List<Object> result = this.getObjects(clazz, filter);
			if(result.size() > 0)
				bo = (BaseObject)result.get(0);
		}
		
		if(bo != null) bo.setDirty(false);
		return bo;
	}

	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectCount(java.lang.Class)
	 */
	public int getObjectCount(Class clazz) {
		return this.getObjectCount(clazz, null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectCount(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public int getObjectCount(Class clazz, Filter filter) {
		return (Integer)getSqlMapClientTemplate().queryForObject(ID_PREFIX_GET+clazz.getSimpleName()+ID_PREFIX_COUNT,new Integer(1));
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class)
	 */
	public List getObjects(Class clazz) {
		return this.getObjects(clazz,null,null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public List getObjects(Class clazz, Filter filter) {
		return this.getObjects(clazz, filter, null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter)
	 */
	public List getObjects(Class clazz, Filter filter, Sorter soter) {
		return this.getObjects(clazz, filter, soter, null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter, org.hi.framework.paging.Page)
	 */
	public List getObjects(final Class clazz,final Filter filter, final Sorter sorter, final Page page) {
		long startTime = System.currentTimeMillis(); 
		List result = getSqlMapClientTemplate().executeWithListResult(new SqlMapClientCallback(){
			 public Object doInSqlMapClient(SqlMapExecutor sqlExecutor)
             throws  SQLException {
                 return processFind(sqlExecutor, clazz, filter, sorter, page);
			 }
		});
		if(log.isTraceEnabled()){
			long endTime = System.currentTimeMillis();
			log.debug("Query  use:" + (endTime - startTime) + "ms");
		}
        return result;
	}
    List processFind(SqlMapExecutor sqlExecutor, Class clazz, Filter filter, Sorter sorter, Page page) throws SQLException{
    		Query[] querys = setupQuery(sqlExecutor, clazz, filter, sorter, page);
    		Query selectQuery = querys[0];//��ѯ�������
    		Query countQuery = querys[1];//��ѯ�������
    		if(sessionFactory.isSqlShow()){
    			System.out.println(selectQuery);
    			if(countQuery != null)
    				System.out.println(countQuery);
    		}
    		int skip =0;
    		int max = 0;
    		if(page != null && countQuery != null){
    			int count = 0;
    			String name = ID_PREFIX_COUNT+clazz.getSimpleName();
    			List countResult = (List) sqlExecutor.queryForList(name,countQuery);//��������
    			if(countResult != null && countResult.size() != 0){
    				if (countResult.size() > 1 ) 
    					count = countResult.size();
    				else{
    					Object result = countResult.get(0);
       					if (result instanceof Integer) 
    						count = ((Integer)result).intValue();
    					else if (result instanceof Long) 
    						count = ((Long) result).intValue();
    					else if(result instanceof BigDecimal)
    						count = ((BigDecimal) result).intValue();
    					else if(result instanceof BigInteger)
    						count = ((BigInteger) result).intValue();
    					else
    						count = ((Number) result).intValue();
    				}
    				
    				//�����ʵ��¼������޼�¼����ȡ����޼�¼��
    				count = page.getMaxRecords() != 0 && count > page.getMaxRecords() ? page.getMaxRecords() : count;
    					
    				page.setTotalRecords(count);		//���ò�ѯ������ܼ�¼��
    				
    				int totoalPage = 0;
    				totoalPage= count%page.getPageSize() > 0 ? count/page.getPageSize() + 1  : count/page.getPageSize();
    				page.setTotalPage(totoalPage);						//���ò�ѯ�������ҳ��
    			}
    			
    			skip =page.getStartRowPosition(); 	//���÷��صĵ�һ����¼��λ��
    			
    			if(page.getMaxRecords() != 0 && (page.getStartRowPosition() + page.getPageSize()) > page.getMaxRecords())
    				max =page.getMaxRecords() - page.getStartRowPosition();
    			else
    				max =page.getPageSize();			//���÷��صļ�¼��
    		}
    		String name = ID_PREFIX_LIST+clazz.getSimpleName();
    		if(page == null)
    			return (List) sqlExecutor.queryForList(name,selectQuery);//��ҳ����
    		return (List) sqlExecutor.queryForList(name,selectQuery, skip, max);//������ҳ����
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
    					domainEntity = HSCHelper.getEntity(sessionFactory.getServletContext().getRealPath(""), dominClazz);//���domain matedataʵ����Ϣ
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
					domainEntity = HSCHelper.getEntity(sessionFactory.getServletContext().getRealPath(""), dominClazz);
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
    
    
    private Query[] setupQuery(SqlMapExecutor sqlExecutor, Class clazz, Filter filter, 
			Sorter sorter, Page page){
    	
		StringBuffer mainSb = new StringBuffer(); //��SQL��䣨ͳ�����ѯ���ã�
		Query countSb = new Query(); //ͳ�Ƽ�¼����SQL���
		Query selectSb = new Query(); //��ѯ��¼����SQL���
		String orderSt = "";	//������ַ���
		
		Entity entity=null;
		try {
			
			entity = HSCHelper.getEntity(sessionFactory.getServletContext().getRealPath(""), clazz);//ͨ��class���ʵ����
		} catch (Exception e) {
			log.error("not found Entity Define by className:" + clazz.getName());
		}
		String tableName = entity.getTableName(); //���ʵ��ı���
		String	aliasName = filter == null || filter.getAliasName() == null ? tableName : filter.getAliasName();//���ñ���
		
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
		if(sessionFactory.getDialect() instanceof IbatisHiDialect) {
			IbatisHiDialect dialect = (IbatisHiDialect)sessionFactory.getDialect();
			dialect.getMaxRecode(countSb, filter, page);
		}
		
		Query selectQuery = selectSb.append(orderSt);
		
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
				
				setParameter(selectQuery, filterBean.getFieldName() + i,filterBean.getValue());  //ΪSQL��Query����,��������ռλ����ֵ
				if(page != null)
					setParameter(countSb, filterBean.getFieldName() + i,filterBean.getValue());
				
			}
		}
		/*����ͳ�Ʒ��ز�ѯ��¼������Ҫ��ѯ��Queryʵ��*/
		Query countQuery = null;
		if (page != null) 
			countQuery = countSb;
		Query[] querySql = {selectQuery,countQuery};
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

	public List getObjects(Class clazz, PageInfo pageInfo) { 
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
		for (Entity entity : entitis) //����ɾ���̳е����ȶ���
			getSqlMapClientTemplate().delete(ID_PREFIX_DEL+entity.getEntityName(),id);
        
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
		
		Map<String, Object> map = this.objectToRow(obj);
		if(!(obj instanceof BaseObject)) return;
		BaseObject bo = (BaseObject)obj;
		
		if(!bo.isCascadeDirty()) return; //�������û�иı�(������ϸ)���������ݿ�ͨ��
		
		//��õ�ǰPOJO���и�������ƣ������䱾��
		List<Entity> entites = getSuperClassName(bo, null, null);
		
		if(bo.getPrimarykey() == null){
			for (Entity entity : entites) {
				
				Object primarykey =getSqlMapClientTemplate().insert(ID_PREFIX_INS+entity.getEntityName(), map);
				if(primarykey != null){
					BeanUtil.setPropertyValue(bo, "id", Integer.parseInt(primarykey.toString()));
					bo.setVersion(new Integer(1)); //����ʱȱʡversionΪ1
				}
			}
		}else{
			Serializable primaryKey = bo.getPrimarykey();
			BaseObject pObj = (BaseObject)this.getObjectById(obj.getClass(), primaryKey);
			if(pObj.getVersion()> bo.getVersion()){
				log.error("Object " + obj + "save database is dirty!");
				return;
			}
			for (Entity entity : entites) {
				getSqlMapClientTemplate().update(ID_PREFIX_UPDATE+entity.getEntityName(), map);
			}
		}
		
		this.saveSubObject(bo);	//������ϸ
	}
	 /**
     * ��ð�����ǰ�����ڵ��������ȶ���ʵ��
     */
	
	private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity){
		if(entitis == null)
			entitis = new ArrayList<Entity>();
		
		String servletRootPath = sessionFactory.getServletContext().getRealPath("");
		Entity entity = null;
		try {
			if(obj != null){
				if(obj instanceof BaseObject)
					entity = HSCHelper.getEntity(servletRootPath, obj.getClass());//��ø������͵�ʵ��
				if(obj instanceof Class)
					entity = HSCHelper.getEntity(servletRootPath, (Class)obj);
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
		} catch (Exception e) {}
		
		if(entity != null)
			entitis.add(entity);
		
		return entitis;
	}
	/**
     * ���������ת����map������
     */
	protected  Map<String, Object> objectToRow(Object obj) {
		Map<String, Object> rowMap= new HashMap<String, Object>();
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
				
				 rowMap.put(propertyName, propertyValue);
				 continue;
			 }
			 //�����baseObject���� ��ôvalueֵ�����������id
			 if(BaseObject.class.isAssignableFrom(propertyClss)){
				 
				 BaseObject baseObj = (BaseObject)propertyValue;
				 rowMap.put(propertyName, baseObj == null ? null : baseObj.getPrimarykey());
				 continue;
			 }
		}
		return rowMap;
	}

	 /**
     * �����������������ӱ����
     */
	
	protected  void saveSubObject(BaseObject parentObj) {
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parentObj);//������и�������
		for (int i = 0; i < propertyDescriptors.length; i++) {
			Class propertyClss = propertyDescriptors[i].getPropertyType();//������Ե�����
			if(!List.class.isAssignableFrom(propertyClss))//�������list���͵Ļ�����
				continue;
			
			String propertyName = propertyDescriptors[i].getName();//������Ե�����
			
			List _propertyValues = (List)BeanUtil.getPropertyValue(parentObj, propertyName);//���list������ֵ
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
				List<Entity> itemEntitys = HSC.getItemEntities(parentObj.getClass());
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
					if(!_parentClassName.equals(parentObj.getClass().getSimpleName()))
						continue;
					BeanUtil.setPropertyValue(baseObject, field.getFieldName(), parentObj);
				}
				this.saveObject(baseObject);
			}
		}
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
	
      /**
       * ����������������ֵ����query��
       */
      private void setParameter(Query query,String parameterName, Object value) {
//      	�ж�value�������Ƿ���һ������,IN��������ֵ����һ������
    	  if(value instanceof Collection){
      		Collection values = (Collection)value;
      		int j = 0;
      		for (Iterator i = values.iterator(); i.hasNext();) {
  				Object val = (Object) i.next();
  				setParameterSingle(query,parameterName+j, val);
  				j++;
  			}
      	}
      	else{
      		 setParameterSingle(query, parameterName, value);
      	}
      }
      
      private void setParameterSingle(Query query,String parameterName, Object value) {
          if (value instanceof Boolean) {
        	  query.putParameter(parameterName, ((Boolean) value).booleanValue());
          } else if (value instanceof Byte) {
          	 query.putParameter(parameterName, ((Byte) value).byteValue());
          } else if (value instanceof Character) {
          	 query.putParameter(parameterName, ((Character) value).charValue());
          } else if (value instanceof Double) {
          	 query.putParameter(parameterName, ((Double) value).doubleValue());
          } else if (value instanceof Float) {
          	 query.putParameter(parameterName, ((Float) value).floatValue());
          } else if (value instanceof Integer) {
          	 query.putParameter(parameterName, ((Integer) value).intValue());
          } else if (value instanceof Long) {
          	 query.putParameter(parameterName, ((Long) value).longValue());
          } else if (value instanceof Short) {
          	 query.putParameter(parameterName, ((Short) value).shortValue());
          } else if (value instanceof String) {
          	 query.putParameter(parameterName, (String) value);
          } else if (value instanceof byte[]) {
          	 query.putParameter(parameterName, (byte[]) value);
          } else if (value instanceof BigDecimal) {
          	 query.putParameter(parameterName, (BigDecimal) value);
          } else if (value instanceof BigInteger) {
          	 query.putParameter(parameterName, (BigInteger) value);
          } else if (value instanceof Date) {
          	 query.putParameter(parameterName, (Date) value);
          } else if (value instanceof Time) {
          	 query.putParameter(parameterName, (Time) value);
          } else if (value instanceof Timestamp) {
          	 query.putParameter(parameterName, (Timestamp) value);
          } else if (value instanceof java.util.Date) {
          	 query.putParameter(parameterName, (java.util.Date) value);
          } else if (value instanceof Locale) {
          	 query.putParameter(parameterName, (Locale) value);
          } else {
          	 query.putParameter(parameterName, value);
          }
      }
      
      /**
       * ���ݸ�����SQL�������ݿ��з�����SQL��һ�µĽ����
       * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.id and org.id = 2
       * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������SQL��˵��ֻ��������HiUser����Ϣ
       * @param sql SQL���,ע���SQL������select������ֻ��һ��ʵ��Ľ�����б�
       * @return ����ָ�����Ͷ����<code>List</code>����
  	 * @see #getSQLObjects(String, String, Class)
  	 */  
      
    protected List<Object> getSQLObjects(String sql){
      	return this.getSQLObjects(sql, null, null, null, null, null);
    }
    
    /**
     * ���ݸ�����SQL�������ݿ��з�����SQL��һ�µĽ����,�������page��Ϊnull�������page��
 	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�
      * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.id and org.id = 2
      * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������SQL��˵��ֻ��������HiUser����Ϣ,
      * @param SQL  SQL���,ע���SQL������select������ֻ��һ��ʵ��Ľ�����б�
      * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
      * @return ��ָ�����Ͷ����<code>List</code>����
      * @see #getSQLObjects(String, String, Class,Page)
      */
    
    protected List<Object> getSQLObjects(String sql, Page page){
      	return this.getSQLObjects(sql, null, null, null, null, page);
    }
    
    /**
	 * ���ݸ�����SQL��估�������б�����ݿ��з���ָ�����ͽ����
	 * <p>Ŀ�ģ�ͨ��SQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see #getSQLObjects(String, String, Class, Filter, Sorter, Page)
	 */   
    
    protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz){
      	return this.getSQLObjects(sql, propertyNames, clazz, null, null);
    }
    
    /**
	 * ���ݸ�����SQL��估�������б�����ݿ��з���ָ�����ͽ����,�������page��Ϊnull�������page��
 	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�
	 * <p>Ŀ�ģ�ͨ��SQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
     * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
     * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
     * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
     * @return ����ָ�����Ͷ����<code>List</code>����
     */
    
    protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Page page){
      	return this.getSQLObjects(sql, propertyNames, clazz, null, null, page);
    }
    
    /**
	 * ���ݸ�����SQL��估�����������ݿ��з�����SQL��һ�µĽ����
     * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������SQL��˵��ֻ��������HiUser����Ϣ,
     * Ҳ����˵��ֻ����һ��ʵ������
     * <p>ע��:<code>getSQLObjects(String, filer)</code>������<code>getSQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getSQLObjects(String)</code>������SQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param SQL SQL���,ע���SQL������select������ֻ��һ��ʵ��Ľ�����б�
	 * @param filter ����ѯ�Ĺ�����
     * @return ����SQL����������һ�µĶ���<code>List</code>����
     * @see #getSQLObjects(String, String, Class, Filter)
     */
    
    protected List<Object> getSQLObjects(String sql, Filter filter){
      	return getSQLObjects(sql, null, null, filter, null);
    }
    
	/**
	 * ���ݸ�����SQL��估�������б������������ݿ��з���ָ�����ͽ����
	 * <p>Ŀ�ģ�ͨ��SQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * 
	 * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param filter ����ѯ�Ĺ�����
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see #getSQLObjects(String, String, Class, Filter, Sorter, Page)
	 */ 
    
    protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter){
      	return getSQLObjects(sql, propertyNames, clazz, filter, null);
    }
    
    /**
	 * ���ݸ�����SQL��估�������������������ݿ��з�����SQL��һ�µĽ����
     * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������SQL��˵��ֻ��������HiUser����Ϣ,
     * Ҳ����˵��ֻ����һ��ʵ������
     * <p>ע��:<code>getSQLObjects(String, filer)</code>������<code>getSQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getSQLObjects(String)</code>������SQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param SQL SQL���,ע���SQL������select������ֻ��һ��ʵ��Ľ�����б�
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
     * @return ����SQL����������һ�µĶ���<code>List</code>����
     * @see #getSQLObjects(String, String, Class, Filter, Sorter)
     */ 
    
    protected List<Object> getSQLObjects(String sql, Filter filter, Sorter sorter){
      	return getSQLObjects(sql, null, null, filter, sorter, null);
    }   
  	
	/**
	 * ���ݸ�����SQL��估�������б��������������������ݿ��з���ָ�����ͽ����
	 * <p>Ŀ�ģ�ͨ��SQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * 
	 * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @see #getSQLObjects(String, String, Class, Filter, Sorter, Page)
	 */
    
    protected List<Object> getSQLObjects(String sql, String propertyNames, Class clazz, Filter filter, Sorter sorter){
    	return getSQLObjects(sql, propertyNames, clazz, filter, sorter, null);
    }
    
	/**
	 * ���ݸ�����SQL��估�������б��������������������ݿ��з���ָ����Ӧ�Ľ��,�������page��Ϊnull�������page��
	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�<p>����ݹ�����������������50����¼��ÿҳ10������ǰҪ��ѯ
	 * ���ǵ���ҳ����ô���ص�<code>List</code>����ֻ��10����¼��������������ǰ��21������30����¼
	 * <p>ע�⣺����page�Ĳ���ֻ����ǰ����ʾ�б�ҳ����ʹ�ã����Ƽ����÷�������ҵ���߼����ϣ���Ϊ����
	 * �п��ܻ���ʧ�����������������ݡ����ں������ݵĲ�ѯ��ò�Ҫ��ORM��Щ�������Ŀ���Ƽ��ͳ��JDBC��
	 * �洢�������ϵķ�ʽʵ�֣���Ч����Ҫ��ʹ���м��Ŀ��ܶ�
	 * 
	 * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
	 * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 */
    protected List<Object> getSQLObjects(final String sql, String propertyNames, Class clazz,final Filter filter,final Sorter sorter,final Page page){
  		
  		List result = new ArrayList();
    	if(sql == null || sql.trim().equals(""))
    		return result;
    	
    	long startTime = System.currentTimeMillis(); 
    	List sqlResult;
    	SqlMapClientTemplate sm =  getSqlMapClientTemplate();
		SqlMapClient sqlMapper = sm.getSqlMapClient();
		sqlResult = sm.executeWithListResult(new SqlMapClientCallback(){
			 public Object doInSqlMapClient(SqlMapExecutor sqlExecutor)
	            throws  SQLException {
					return processFind(sqlExecutor, sql, filter, sorter, page);
				}
		});
		
		if(log.isDebugEnabled()){
			long endTime = System.currentTimeMillis();
			log.debug("Query  use:" + (endTime - startTime) + "ms");
		}
		
        if( clazz == null)
        	return sqlResult;
        
        //��sql���صĽ������װΪ���󼯺�
        String[] propertyNamesArray;
        for (Iterator iter = sqlResult.iterator(); iter.hasNext();) {
        	Object bean = null;
			bean = BeanUtil.CreateObject(clazz.getName());
			
			Map<String, Object> resultRow = (Map<String, Object>)iter.next();
			
			if(propertyNames == null){
				for (Map.Entry<String, Object> entry : resultRow.entrySet())
					BeanUtil.ognlPropertyValue(bean, entry.getKey(),entry.getValue());		//ͨ��OGNL�����Ͷ�����㸳ֵ
		    }
			else{
				propertyNamesArray = StringUtils.strToStrArray(propertyNames);
				int _step = 0;
				for (Map.Entry<String, Object> entry : resultRow.entrySet()){
					BeanUtil.ognlPropertyValue(bean, propertyNamesArray[_step], entry.getValue());		//ͨ��OGNL�����Ͷ�����㸳ֵ
					_step++;
				}
			}
			result.add(bean);
        }
    	return result;
  	}
  	
  	List<Object> processFind(SqlMapExecutor sqlExecutor, String sql, Filter filter, Sorter sorter, Page page) throws SQLException{
		Query[] querys = setupQuery(sqlExecutor, sql, filter, sorter, page);
		Query selectQuery = querys[0];
		Query countQuery = querys[1];
		if(sessionFactory.isSqlShow()){
			System.out.println(selectQuery);
			if(countQuery != null)
				System.out.println(countQuery);
		}
		int skip =0;
		int max = 0;
		if(page != null && countQuery != null){
			int count = 0;
			String name = "countCommon";
			List countResult = (List) sqlExecutor.queryForList(name,countQuery);
			if(countResult != null && countResult.size() != 0){
				if (countResult.size() > 1 ) 
					count = countResult.size();
				else{
					Object result = countResult.get(0);
   					if (result instanceof Integer) 
						count = ((Integer)result).intValue();
					else if (result instanceof Long) 
						count = ((Long) result).intValue();
					else if(result instanceof BigDecimal)
						count = ((BigDecimal) result).intValue();
					else if(result instanceof BigInteger)
						count = ((BigInteger) result).intValue();
					else
						count = ((Number) result).intValue();
				}
				
				//�����ʵ��¼������޼�¼����ȡ����޼�¼��
				count = page.getMaxRecords() != 0 && count > page.getMaxRecords() ? page.getMaxRecords() : count;
					
				page.setTotalRecords(count);		//���ò�ѯ������ܼ�¼��
				
				int totoalPage = 0;
				totoalPage= count%page.getPageSize() > 0 ? count/page.getPageSize() + 1  : count/page.getPageSize();
				page.setTotalPage(totoalPage);						//���ò�ѯ�������ҳ��
			}
			
			skip =page.getStartRowPosition(); 	//���÷��صĵ�һ����¼��λ��
			
			if(page.getMaxRecords() != 0 && (page.getStartRowPosition() + page.getPageSize()) > page.getMaxRecords())
				max =page.getMaxRecords() - page.getStartRowPosition();
			else
				max =page.getPageSize();			//���÷��صļ�¼��
		}
		String name = "listCommon";
		if(page == null)
			return (List) sqlExecutor.queryForList(name,selectQuery);
		return (List) sqlExecutor.queryForList(name,selectQuery, skip, max);
	}
  	
    private Query[] setupQuery(SqlMapExecutor sqlExecutor, String sql, Filter filter, Sorter sorter, Page page){
		Query selectSb = new Query(); //��SQL���
		Query countSb = new Query(); //ͳ�Ƽ�¼����SQL���
		String orderSt = "";	//������ַ���
		
		selectSb.append(sql);
		
		countSb.append("select count(*) ");
		if(!StringUtils.trimLeft(sql).startsWith("from"))
			countSb.append("from ");
		
		/*SQL�Ĺ��˲���*/
		if(filter != null && filter.getConditions().size() > 0){
			
			if(StringUtils.isInclude(sql, "where"))
				selectSb.append(" and ");
			else
				selectSb.append(" where ");
			
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			String aliasName = null;
			if(filter.getAliasName() != null && !filter.getAliasName().trim().equals(""))
				aliasName = filter.getAliasName();
			
			if(filterGroup.size() < 2) //���filter����ֻ�����Լ���û��ͨ��addFilter�������ӵ�
				setupConditions(selectSb, filterBeans, aliasName, null);
			else{
				for(int i = 0; i < filterGroup.size(); i++){
					List<FilterBean> filtergroup = filterGroup.get(i);
					setupConditions(selectSb, filtergroup, aliasName, i);
					selectSb.append(") ");
				}
			}

		}
		
		/*SQL�����򲿷�*/
		if(sorter != null && !sorter.getSorts().isEmpty()){
			orderSt = " order by "; 
			
			if(filter != null && filter.getAliasName() != null)
				orderSt+=filter.getAliasName() + "." ;
			
			orderSt+=sorter.toString();
		}
		
		
		/*����ͳ�Ʒ��ز�ѯ��¼������Ҫ��ѯ��Queryʵ��*/
		if (page != null) {
			String selectString = selectSb.toString();
			if(!StringUtils.trimLeft(sql).startsWith("from"))
				countSb = countSb.append(selectString.substring(selectString.indexOf("from") + 4));
		}
		selectSb.append(orderSt);
		
		/*���������������ռλ���������Ӧ��ֵ*/
		if(filter != null  && filter.getConditions().size() > 0){
			List<FilterBean> filterBeans = filter.getConditions();
			for (Iterator i = filterBeans.iterator(); i.hasNext();) {
				FilterBean filterBean = (FilterBean) i.next();
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
				
				setParameter(selectSb, filterBean.getFieldName(), filterBean.getValue());  //ΪSQL��Query����,��������ռλ����ֵ
				if(page != null)
					setParameter(countSb,filterBean.getFieldName(), filterBean.getValue());
			}
		}
		
		Query[] querys = {selectSb, countSb};
		return querys;
	}
    
    private void setupConditions(Query mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex){
		/*ΪSQL����������������ռλ��*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //����ǵ�һ��������,������ǰ��Ӹ�����
				mainSb.append("( ");
			
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //������ǵ�һ��������,���ڹ�ϵ�����������
				mainSb.append(filterBean.getRelations()).append(" ( ");
			
			if(i > 0 )
				mainSb.append(" ").append(filterBean.getRelations()).append(" ");			//�����������֮��Ĺ�ϵ��
			
			if(aliasName != null && !aliasName.trim().equals(""))
				mainSb.append(aliasName + ".");

			mainSb.append(filterBean.getFieldName()).append(" ");				//��Ӳ�ѯ���ֶ���
			
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
			else
				mainSb.append("? ");								//������λ����Ϊ����ռλ��
			
		}
	}
	

	/**
	 * ���ݸ�����SQL�������ݿ��з�����SQL��һ�µĽ����
	 * <p>����page��pageInfo����������pageInfo�Ƕ�filter/sorter/page����һ���װ
	 * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param clazz ����װ������
	 * @param pageInfo ����ѯ��ҳ����Ϣ
     * @return ����ָ�����Ͷ����<code>List</code>����
     * @see org.hi.framework.paging.PageInfo
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * @see #getObjects(Class, PageInfo)
	 * @see #getSQLObjects(String, String, Class, PageInfo)
	 */	
	protected List getSQLObjects(String sql, PageInfo pageInfo){
		return getSQLObjects(sql, null, null, pageInfo);
	}
	
	/**
	 * ���ݸ�����SQL��估�������б�����ݿ��з���ָ�����ͽ������������Ĳ���ԭ����<code>getObjects(clazz, page)</code>
	 * ������ͬ
	 * <p>����page��pageInfo����������pageInfo�Ƕ�filter/sorter/page����һ���װ
	 * @param SQL SQL���,ע���SQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param pageInfo ����ѯ��ҳ����Ϣ
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.paging.PageInfo
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * @see #getObjects(Class, PageInfo)
	 */	
	protected List getSQLObjects(String sql, String propertyNames, Class clazz, PageInfo pageInfo){
		if(pageInfo == null)
			return new ArrayList();
		
		Filter filter = null;
		Sorter sorter = null;
		Page page = null;
		filter = pageInfo.getFilter();
		sorter = pageInfo.getSorter();
		page = pageInfo.getPage();
		return getSQLObjects(sql, propertyNames, clazz, filter, sorter, page);
    }


	public HiDialect getDialect() {
		if(sessionFactory.getDialect() instanceof IbatisHiDialect) {
			return (IbatisHiDialect)sessionFactory.getDialect();
		}
		return null;
	}
}
