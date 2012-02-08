package org.hi.framework.service;

import java.io.Serializable;
import java.util.List;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

/**
 * 该接口是业务逻辑层的业务管理器声明接口,该接口是实现业务逻辑的核心.所有子类及其子孙类均通过实现该接口
 * 完成复杂的业务逻辑,缺省的该接口中仅声明了对对象的增、删、查、改功能,而通过这些较细粒度的功能即可实现
 * 相当复杂的业务功能.
 * <p>在一个管理器中可以通过<code>SpringContextHolder</code>类中的静态方法<code>getBean()</code>调用
 * 其它的管理器从而实现较为复杂的业务逻辑.该接口的具体业务的实现子表均会与Spring的配置文件(appContext-***.xml)
 * 一部分相对应,如:<p>
 * <P>&lt;bean id="org.hi.base.organization.model.HiOrg" parent="txProxyTemplate"&gt;<BR>&nbsp;&nbsp;&nbsp;&lt;property name="target"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;bean class="org.hi.base.organization.service.impl.HiOrgManagerImpl"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="DAO" ref="org.hi.base.organization.dao.HiOrgDAO"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="modelClass" value="org.hi.base.organization.model.HiOrg"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/bean&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;/property&gt;<P>&lt;/bean&gt;</P>
 * 通过配置可以看出Spring将DAO与所要管理的POJO对象的类型信息一并注入到当前管理器中,还会发现在配置中parent="txProxyTemplate"
 * 的属性用以继承另一个bean对象,该对象是一个事务代理工厂Bean用以在不同管理器之间调用方法时的事务拦截功能,在/WEB-INFO/config/appContext.xml
 * 文件中的配置如下:<p>
 * &nbsp;&lt;bean id="txProxyTemplate" abstract="true"<BR>&nbsp;&nbsp;&nbsp; class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean"&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="transactionManager" ref="transactionManager"/&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="transactionAttributes"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;props&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="save*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="delete*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="create*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="remove*"&gt;PROPAGATION_REQUIRED&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;prop key="*"&gt;PROPAGATION_REQUIRED,readOnly&lt;/prop&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/props&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="preInterceptors"&gt;<BR>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&lt;list&gt;<BR>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&lt;ref bean="contactManagerSecurity"/&gt;<BR>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&lt;/list&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&lt;/bean&gt;
 * <p>在该配置体中会看到abstract的属性是true即它Spring的容器中认为是抽象的必须要有其它的bean来继承之,在管理器中只有方法名为save* delete* create* remove*
 * 的方法才可以对数据库表进行改写操作,其它方法则不能只可以是只读的.下表为Spring对的事务传播行为的描述<p>
 * <TABLE cellSpacing=0 cellPadding=0 width=586 border=1><TBODY><TR><TD vAlign=top width=180><P align=center>传播行为</P></TD><TD vAlign=top width=406><P align=center>说明</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_MANDATORY</P></TD><TD vAlign=top width=406><P>方法必须要在事务中运行。如果事务不存在，则抛出异常</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_REQUIRED</P></TD><TD vAlign=top width=406><P>当前方法必须运行在一个事务中。如果一个现有的事务正在运行中，该方法将运行在这个事务中。否则就要开始一个新的事务</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_REQUIRES_NEW</P></TD><TD vAlign=top width=406><P>当前方法必须运行在它自己的事务中。当前方法运行时将启动一个新的事务。如果一个现有事务在运行，这个事务将在这个方法运行期间被挂起</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_NESTED</P></TD><TD vAlign=top width=406><P>如果在进程中已经存在一个事务，那么这个方法应该运行在一个嵌套事务之中。一个嵌套的事务可以从放入该嵌套的事务处单独的提交或回滚，如果没有事务在嵌套事务中，那就要有PROPAGATION_REQUIRED的行为</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_SUPPORTS</P></TD><TD vAlign=top width=406><P>当前方法不需要事务处理环境，但如果有一个事务已经在运行，这个方法也可以在这个事务中运行</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_NOT_SUPPORTED</P></TD><TD vAlign=top width=406><P>当前方法不应该在事务中运行。如果一个现有的事务正在运行中，这个事务将在该方法的运行期间挂起</P></TD></TR><TR><TD vAlign=top width=180><P>PROPAGATION_NEVER</P></TD><TD vAlign=top width=406><P>当前的方法不应该运行在一个事务中。如果当前存在一个事务，则会抛出一个异常</P></TD></TR></TBODY></TABLE>
 * <p>通过该方式在一个线程调用过程中（可能会调用n个管理器的n*n个方法）但它们都处在同一个事务管理之下,这样就
 * 实现了跨也不同的业务管理器(对应不同的数据库表)方法调用之间的事务一致性.
 * @author 张昊
 * @since 2006-11-15
 * @see org.hi.framework.dao.DAO
 * @see org.hi.SpringContextHolder
 */
public interface Manager {
	public static final String SPRING_BEAN_ID = "org.hi.framework.service.Manager";
	
	/**
	 * 设置DAO对象
	 * @param dao DAO对象
	 */
	public void setDAO(DAO dao);
	
	/**
	 * 获得DAO对象
	 * @return 返回DAO对象
	 */
	public DAO getDAO();

	public Class getModelClass();
	/**
	 * 将POJO对象,update或insert到数据库中,<code>preSaveObject(obj)</code>方法与<code>postSaveObject(obj)</code>
	 * 在执行该方法之前或之后会被调用 
	 * @param obj 表现层的POJO对象
	 * 
	 */
	public void saveObject(Object obj);

	/**
	 * 从数据库删除给定的对象
	 * @param obj 待删除的对象
	 */
	public void removeObject(Object obj);

	/**
	 * 通过给定的ID值,从数据库删除与ID值对象的记录
	 * @param id 待删除的对象主键ID值
	 */
	public void removeObjectById(Serializable id);

	/**
	 * 通过给定的ID值,从数据库获得该对象
	 * @param id 待返回对象的ID值
	 * @return 返回与ID值对应的POJO对象
	 */
	public Object getObjectById(Serializable id);

	/**
	 * 根据给定的过滤器且该过滤器的属性名对应数据库是唯一索引,
	 * 从数据中取得满足过滤条件的唯一一条记录,返回POJO对象
	 * @param filter 属性名为唯一索引的过滤器
	 * @return 返回满足唯一索此过滤器的一个POJO对象
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
	 * 本方法的作用是为列表页面提供最终的显示数据,目的是用于用户部门级权限的数据过滤
	 * 如果您需要自己调整权限规则，可以过载该方法<code>getList(PageInfo, Filter)</code>,
	 * 其中Filter为权限过滤的规则
	 * <p>
	 * 注意：为了开发规范,系统仅提供这一个用于终端显示数据的方法,所有<code>getObject(...)</code>
	 * 方法只用于逻辑层的调用
	 * <p>
	 * 原因：因为该方法会被<code>ResourceBindleMethodSecurityInterceptor</code>拦截器所调用
	 * 而该拦截器的调用<code>MethodConfigAttributeDefHolder</code>类中的<code>buildRunAs()</code>方法
	 * 该方法会自动封装<code>SecurityFilter</code>对象，并将该对象与<code>PageInfo</code>中的<code>Filter</code>
	 * 对象进行合并，形成一个大的<code>Filter</code>对象
	 * @param pageInfo
	 * @return
	 * @see org.hi.framework.security.acegi.ResourceBindleMethodSecurityInterceptor
	 * @see org.hi.framework.security.acegi.MethodConfigAttributeDefHolder
	 * @see org.hi.framework.dao.impl.SecurityFilter
	 */
	public List getList(PageInfo pageInfo);

}