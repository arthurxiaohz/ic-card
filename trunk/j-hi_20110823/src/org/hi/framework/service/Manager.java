package org.hi.framework.service;

import java.io.Serializable;
import java.util.List;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

/**
 * �ýӿ���ҵ���߼����ҵ������������ӿ�,�ýӿ���ʵ��ҵ���߼��ĺ���.�������༰���������ͨ��ʵ�ָýӿ�
 * ��ɸ��ӵ�ҵ���߼�,ȱʡ�ĸýӿ��н������˶Զ��������ɾ���顢�Ĺ���,��ͨ����Щ��ϸ���ȵĹ��ܼ���ʵ��
 * �൱���ӵ�ҵ����.
 * <p>��һ���������п���ͨ��<code>SpringContextHolder</code>���еľ�̬����<code>getBean()</code>����
 * �����Ĺ������Ӷ�ʵ�ֽ�Ϊ���ӵ�ҵ���߼�.�ýӿڵľ���ҵ���ʵ���ӱ������Spring�������ļ�(appContext-***.xml)
 * һ�������Ӧ,��:<p>
 * <P>&lt;bean id="org.hi.base.organization.model.HiOrg" parent="txProxyTemplate"&gt;<BR>&nbsp;&nbsp;&nbsp;&lt;property name="target"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;bean class="org.hi.base.organization.service.impl.HiOrgManagerImpl"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="DAO" ref="org.hi.base.organization.dao.HiOrgDAO"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="modelClass" value="org.hi.base.organization.model.HiOrg"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/bean&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;/property&gt;<P>&lt;/bean&gt;</P>
 * ͨ�����ÿ��Կ���Spring��DAO����Ҫ�����POJO�����������Ϣһ��ע�뵽��ǰ��������,���ᷢ����������parent="txProxyTemplate"
 * ���������Լ̳���һ��bean����,�ö�����һ�����������Bean�����ڲ�ͬ������֮����÷���ʱ���������ع���,��/WEB-INFO/config/appContext.xml
 * �ļ��е���������:<p>
 * &nbsp;&lt;bean id="txProxyTemplate" abstract="true"<BR>&nbsp;&nbsp;&nbsp; class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean"&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="transactionManager" ref="transactionManager"/&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="transactionAttributes"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;props&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="save*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="delete*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="create*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="remove*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="*"&gt;PROPAGATION_REQUIRED,readOnly&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/props&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="preInterceptors"&gt;<BR>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&lt;list&gt;<BR>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&lt;ref bean="contactManagerSecurity"/&gt;<BR>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&lt;/list&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&lt;/bean&gt;
 * <p>�ڸ��������лῴ��abstract��������true����Spring����������Ϊ�ǳ���ı���Ҫ��������bean���̳�֮,�ڹ�������ֻ�з�����Ϊsave* delete* create* remove*
 * �ķ����ſ��Զ����ݿ����и�д����,������������ֻ������ֻ����.�±�ΪSpring�Ե����񴫲���Ϊ������<p>
 * <TABLE cellSpacing=0 cellPadding=0 width=586 border=1><TBODY><TR><TD vAlign=top width=180><P align=center>������Ϊ</P></TD><TD vAlign=top width=406><P align=center>˵��</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_MANDATORY</P></TD><TD vAlign=top width=406><P>��������Ҫ�����������С�������񲻴��ڣ����׳��쳣</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_REQUIRED</P></TD><TD vAlign=top width=406><P>��ǰ��������������һ�������С����һ�����е��������������У��÷�������������������С������Ҫ��ʼһ���µ�����</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_REQUIRES_NEW</P></TD><TD vAlign=top width=406><P>��ǰ�����������������Լ��������С���ǰ��������ʱ������һ���µ��������һ���������������У����������������������ڼ䱻����</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_NESTED</P></TD><TD vAlign=top width=406><P>����ڽ������Ѿ�����һ��������ô�������Ӧ��������һ��Ƕ������֮�С�һ��Ƕ�׵�������Դӷ����Ƕ�׵����񴦵������ύ��ع������û��������Ƕ�������У��Ǿ�Ҫ��PROPAGATION_REQUIRED����Ϊ</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_SUPPORTS</P></TD><TD vAlign=top width=406><P>��ǰ��������Ҫ�����������������һ�������Ѿ������У��������Ҳ�������������������</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_NOT_SUPPORTED</P></TD><TD vAlign=top width=406><P>��ǰ������Ӧ�������������С����һ�����е��������������У���������ڸ÷����������ڼ����</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_NEVER</P></TD><TD vAlign=top width=406><P>��ǰ�ķ�����Ӧ��������һ�������С������ǰ����һ����������׳�һ���쳣</P></TD></TR></TBODY></TABLE>
 * <p>ͨ���÷�ʽ��һ���̵߳��ù����У����ܻ����n����������n*n�������������Ƕ�����ͬһ���������֮��,������
 * ʵ���˿�Ҳ��ͬ��ҵ�������(��Ӧ��ͬ�����ݿ��)��������֮�������һ����.
 * @author ���
 * @since 2006-11-15
 * @see org.hi.framework.dao.DAO
 * @see org.hi.SpringContextHolder
 */
public interface Manager {
	public static final String SPRING_BEAN_ID = "org.hi.framework.service.Manager";
	
	/**
	 * ����DAO����
	 * @param dao DAO����
	 */
	public void setDAO(DAO dao);
	
	/**
	 * ���DAO����
	 * @return ����DAO����
	 */
	public DAO getDAO();

	public Class getModelClass();
	/**
	 * ��POJO����,update��insert�����ݿ���,<code>preSaveObject(obj)</code>������<code>postSaveObject(obj)</code>
	 * ��ִ�и÷���֮ǰ��֮��ᱻ���� 
	 * @param obj ���ֲ��POJO����
	 * 
	 */
	public void saveObject(Object obj);

	/**
	 * �����ݿ�ɾ�������Ķ���
	 * @param obj ��ɾ���Ķ���
	 */
	public void removeObject(Object obj);

	/**
	 * ͨ��������IDֵ,�����ݿ�ɾ����IDֵ����ļ�¼
	 * @param id ��ɾ���Ķ�������IDֵ
	 */
	public void removeObjectById(Serializable id);

	/**
	 * ͨ��������IDֵ,�����ݿ��øö���
	 * @param id �����ض����IDֵ
	 * @return ������IDֵ��Ӧ��POJO����
	 */
	public Object getObjectById(Serializable id);

	/**
	 * ���ݸ����Ĺ������Ҹù���������������Ӧ���ݿ���Ψһ����,
	 * ��������ȡ���������������Ψһһ����¼,����POJO����
	 * @param filter ������ΪΨһ�����Ĺ�����
	 * @return ��������Ψһ���˹�������һ��POJO����
	 */
	public Object getUniqueObject(Filter filter);

	/**
	 * @return
	 */
	public List getObjects();

	/**
	 * @param filter
	 * @return
	 */
	public List getObjects(Filter filter);

	/**
	 * @param filter
	 * @param sorter
	 * @return
	 */
	public List getObjects(Filter filter, Sorter sorter);

	/**
	 * @param filter
	 * @param sorter
	 * @param page
	 * @return
	 */
	public List getObjects(Filter filter, Sorter sorter, Page page);

	/**
	 * @param pageInfo
	 * @return
	 */
	public List getObjects(PageInfo pageInfo);

	/**
	 * ��������������Ϊ�б�ҳ���ṩ���յ���ʾ����,Ŀ���������û����ż�Ȩ�޵����ݹ���
	 * �������Ҫ�Լ�����Ȩ�޹��򣬿��Թ��ظ÷���<code>getList(PageInfo, Filter)</code>,
	 * ����FilterΪȨ�޹��˵Ĺ���
	 * <p>
	 * ע�⣺Ϊ�˿����淶,ϵͳ���ṩ��һ�������ն���ʾ���ݵķ���,����<code>getObject(...)</code>
	 * ����ֻ�����߼���ĵ���
	 * <p>
	 * ԭ����Ϊ�÷����ᱻ<code>ResourceBindleMethodSecurityInterceptor</code>������������
	 * �����������ĵ���<code>MethodConfigAttributeDefHolder</code>���е�<code>buildRunAs()</code>����
	 * �÷������Զ���װ<code>SecurityFilter</code>���󣬲����ö�����<code>PageInfo</code>�е�<code>Filter</code>
	 * ������кϲ����γ�һ�����<code>Filter</code>����
	 * @param pageInfo
	 * @return
	 * @see org.hi.framework.security.acegi.ResourceBindleMethodSecurityInterceptor
	 * @see org.hi.framework.security.acegi.MethodConfigAttributeDefHolder
	 * @see org.hi.framework.dao.impl.SecurityFilter
	 */
	public List getList(PageInfo pageInfo);

}