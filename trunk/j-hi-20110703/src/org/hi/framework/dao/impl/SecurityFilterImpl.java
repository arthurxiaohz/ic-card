package org.hi.framework.dao.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.acegisecurity.ConfigAttribute;
import org.acegisecurity.ConfigAttributeDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.tree.Component;
import org.hi.base.tree.ComponentImpl;
import org.hi.base.tree.TreeManager;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.SecurityFilter;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.acegi.MethodConfigAttributeDefHolder;
import org.hi.framework.security.constant.ScurityScopeType;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.SecurityScope;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.service.Manager;

/**
 * 专用于安全的过滤器,该类理论上来说应对用户不可见
 * <p>目的:是在终端用户调用列表页面显示数据时,根据当前用户所拥有的权限及权限的范围对所要显示的数据
 * 进行过滤,对于请求列表页面系统仅提供一个方法<code>BaseManager.getList(PageInfo pageInfo)</code>
 * 系统会在这个方法中创建并调用该类的<code>getSeurityFilter()</code>方法.并将该过滤器实例与
 * pageInfo参数中的filter合并/连接,形成完成的过滤条件,通过过滤条件从数据库中获取数据,最终该过
 * 滤后的数据显示给终端用户
 * <p>原理:在该类中有隐藏一个代理Filter,根据用户对权限所持有的范围该代理filter的实例有可能是
 * <code>SimpleFilter</code>或是<code>InFilter</code>.方法<code>getSeurityFilter()
 * </code>是主调用入口,由该方法判断代理过滤器的具体类型,并创建它或是返回空,即不对数据做安全部分的筛选.
 * <p>代理Filter的规则:<br>
 * <ul>用户级：返回SimpleFilter,当前用户所创建的记录项</ul>
 * <ul>当前部门级：返回SimpleFilter,当前户所在部门内的所有人员所创建的记录项</ul>
 * <ul>部门级：返回InFilter,根据当前户所拥有的权限中指定的部门作为参考,以此做为IN操作的过滤条件</ul>
 * <ul>部门及子部门级：返回InFilter,根据当前户所拥有的权限中指定的部门作为参考,系统会将该部门
 * 下的所有子孙部门均添加到IN操作的过滤条件中</ul>
 * <ul>系统级：返回null,不对数据做过滤</ul>
 * 上述五种权限范围不逐级递增的,因此对于部门级与部门及子部门级,无论终端用户是否配置当前部门与否,
 * 系统均会将用户当前部门添加到IN的查询条件中
 * <p>系统约定：为了使应用系统能够实现安全性的数据过滤(即,使本类可用),需要在业务表中加入creator
 * 字段,对应的POJO属性为<code>private HiUser creator;</code>
 * <p>最后,在处理部门及子部门级的范围时.因为部门是树型结构,要找到指定部门的所有子孙部门,具体的实
 * 现方式参见<code>org.hi.common.tree.TreeManager</code>
 * @see org.hi.framework.dao.impl.SimpleFilter
 * @see org.hi.framework.dao.impl.InFilter
 * @see org.hi.framework.paging.PageInfo
 * @see org.hi.framework.service.impl.ManagerImpl#getList(PageInfo pageInfo)
 * @see org.hi.base.tree.TreeManager
 * @see org.hi.base.tree.Component
 * @see org.hi.base.tree.ComponentImpl
 * @author 张昊
 * @since 2006-01-27
 *
 */
class SecurityFilterImpl implements SecurityFilter {

	private static final long serialVersionUID = -4305546800166951484L;
	protected final Log log = LogFactory.getLog(getClass());
	
	private Filter agentFilter;
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object)
	 */
	public Filter addCondition(String name, Object val) {
		return agentFilter.addCondition(name, val);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object, java.lang.String)
	 */
	public Filter addCondition(String name, Object val, String op) {
		return agentFilter.addCondition(name, val, op);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object, java.lang.String, java.lang.String)
	 */
	public Filter addCondition(String name, Object val, String op,
			String relation) {
		return agentFilter.addCondition(name, val, op, relation);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addFilter(org.hi.framework.dao.Filter)
	 */
	public Filter addFilter(Filter otherfilter) {
		return agentFilter.addFilter(otherfilter);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addFilter(org.hi.framework.dao.Filter, java.lang.String)
	 */
	public Filter addFilter(Filter otherFilter, String relation) {
		return agentFilter.addFilter(otherFilter, relation);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#getConditions()
	 */
	public List<FilterBean> getConditions() {
		return agentFilter.getConditions();
	}

	public String toString(){
		return agentFilter.toString();
	}
	public List<List<FilterBean>> getFilterGroup(){
		return agentFilter.getFilterGroup();
	}
	
	/**
	 * 获得安全过滤器
	 * <p>内部处理原理:首先从<code>UserContextHelper</code>中取得当前用户,判断当前用户所持有的权限中对当前方法
	 * 所需要的权限<code>MethodConfigAttributeDefHolder</code>计算出当前用户对权限的最大访问范围.
	 * 根据最大访问范围,创建出代理Filter,最终返回代理Filter.代理Filter的规则参见类的说明
	 * @return
	 * @see org.hi.framework.security.context.UserContextHelper
	 * @see org.hi.framework.security.context.UserContext
	 * @see org.hi.framework.security.acegi.MethodConfigAttributeDefHolder
	 */
	public Filter getSeurityFilter(){
		UserContext userContext = UserContextHelper.getUserContext();
		
		/*如果该用户是超级管理员,则对数据不做过滤*/
		if(userContext.isSupperManager())
			return null;
		
		/*得到当前用户所拥有权限的最大范围的值*/
		int maxScopeLevel = this.getMaxScopeLevel();  
		
		/*如果当前用户所拥有权限的范围是系统级,则对数据不做过滤*/
		if(maxScopeLevel == SecurityScope.SECURITYSCOPE_SYSTEM_LEVEL)
				return null;
		
		/*根据最大范围的值,创建代理Filter的实例*/
		this.setAgentFilter(maxScopeLevel);
		
		/*如果当前用户所拥有权限的范围是用户级,则按POJO中的creator属性是当前用户进行过滤*/
		if(maxScopeLevel == SecurityScope.SECURITYSCOPE_USER_LEVEL)
			return this.agentFilter.addCondition("creator.id", userContext.getUser().getId());
		
		HiOrg org = userContext.getOrg();
		
		/*如果当前用户所拥有权限的范围是当前部门级,则按POJO中的creator.org属性是当前用户所属的部门进行过滤*/
		if(maxScopeLevel == SecurityScope.SECURITYSCOPE_CURRENTORG_LEVEL){
			if(org == null)
				log.error("user: " + userContext.getUserName() +" org is null");
			return this.agentFilter.addCondition("creator.org.id", userContext.getOrg().getId());
		}
		
		Set<HiOrg> filterConditions = null;
		
		if(org == null)
			log.error("user: " + userContext.getUserName() +" org is null");
		
		/*如果当前用户所拥有权限的范围大于当前部门级,则先找到所有满足条件的部门*/
		filterConditions = processOrgAndSubOrgLevelFilter(org);
	
		if(filterConditions.size() >  0){
			Set<Integer> orgIds = new LinkedHashSet<Integer>();
			for (HiOrg _org : filterConditions) {
				orgIds.add(_org.getId());
			}
			return this.agentFilter.addCondition("creator.org.id", orgIds);
		}
		
		/*如果所有都没有匹配,则系统认为是共用的,不对数据做安全性的过滤限制*/
		return null;
	}
	
	/**
	 * 如果权限范围是部门级或部门及子部门级,则获取所有满足权限范围的部门并包括当前部门
	 * @param org 用户所在的当前部门
	 * @return 返回满足条件的所有部门,包括当前部门
	 */
	protected Set<HiOrg> processOrgAndSubOrgLevelFilter(HiOrg org){
		Set<HiOrg> result = null;
		result = getAuthOrg();
		if(!result.contains(org))
			result.add(org);
		return result;
	}
	
	/**
	 * 根据最大权限范围的值,创建代理Filter的实例,如果最大范围的值是大于当前部门级,则创建InFilter
	 * 实例,否则创建SimpleFilter实例
	 * @param maxScopeLevel 最大权限范围的值
	 */
	protected void setAgentFilter(int maxScopeLevel){
		
		if(maxScopeLevel > SecurityScope.SECURITYSCOPE_CURRENTORG_LEVEL)
			this.agentFilter = new InFilter();
		else
			this.agentFilter = new SimpleFilter();
	}
	
	/**
	 * 根据当前调用方法在配置文件中所需要的权限,与当前用户所持有的权限做匹配,如果满足的条件的用户
	 * 权限中的范围是部门级则将用户权限中指定的部门添加到集合中,如果是部门及子部门级则将用户权限
	 * 中指定的部门下的所有子孙部门包括该部门一并添加到集合中
	 * @return 返回满足条件的所有部门,不一定包含当前用户所在的部门
	 */
	private Set<HiOrg> getAuthOrg(){
		Set<HiOrg> result = new LinkedHashSet<HiOrg>();
		ConfigAttributeDefinition config = MethodConfigAttributeDefHolder.getConfigAttributeDefinition();
		Map<String, List<UserAuthority>> userAuthorities = UserContextHelper.getUserContext().getAuthorityNameList();
		
		/*轮询所当前调用方法在配置文件中设定的权限*/
		for (Iterator i = config.getConfigAttributes(); i.hasNext();) {
			ConfigAttribute configAttribute = (ConfigAttribute) i.next();
			String attribute =  configAttribute.getAttribute();
			List authoryites = userAuthorities.get(attribute);
			if(authoryites == null)
				continue;
			
			/*轮询调用方法权限属性与当前用户所拥有的权限相匹配的所有用户权限*/
			for (Iterator iter = authoryites.iterator(); iter.hasNext();) {
				UserAuthority userAuthority = (UserAuthority) iter.next();
				
				/*如果该用户权限中的范围是部门级*/
				if(userAuthority.getScope() == SecurityScope.SECURITYSCOPE_ORG_LEVEL){
					HiOrg filterOrg = userAuthority.getOrg();
					if(filterOrg == null)
						continue;
					
					if(filterOrg != null && !result.contains(filterOrg))
						result.add(filterOrg);
				}
				
				/*如果该用户权限中的范围是部门及子部门级*/
				if(userAuthority.getScope() == SecurityScope.SECURITYSCOPE_ORGANDSUBORG_LEVEL){
					HiOrg org = userAuthority.getOrg();
					if(org == null)
						continue;
					
//					ComponentImpl parentComponent = (ComponentImpl)getTreeManager().getTreeMap().get(org.getComponentName());
//					List<Component> components = parentComponent.getAllComponents();
					
					List components = getTreeManager().getChildren(org);
					/*轮询在用户权限中指定部门下的所有子孙部门,包括该指定部门*/
					for (Iterator iterator = components.iterator(); iterator.hasNext();) {
						Component component = (Component) iterator.next();
						HiOrg filterOrg = (HiOrg)component.getTarget();
						if(!result.contains(filterOrg))
							result.add(filterOrg);
					}
					
				}
				
			}
		}
	
		return result;
	}
	
	/**
	 * 根据当前调用方法在配置文件中所需要的权限,与当前用户所持有的权限做匹配,找到该用户所拥有权限的最大范围
	 * 如果在安全配置文件中没有配置当前调用方法的权限,则本方法返回将是系统级的范围.如果当前用户中没有与之相匹配的权限
	 * 则返回用户级
	 * @see org.hi.framework.security.constant.ScurityScopeType
	 * @return
	 */
	protected int getMaxScopeLevel(){
		ConfigAttributeDefinition config = MethodConfigAttributeDefHolder.getConfigAttributeDefinition();
		
		if(config == null || config.size()== 0)
			return SecurityScope.SECURITYSCOPE_SYSTEM_LEVEL;
		
		Map<String, List<UserAuthority>> userAuthorities = UserContextHelper.getUserContext().getAuthorityNameList();
		int maxScopeLevel = 0;
		
		/*根据当前调用方法在配置文件中所需要的权限,与当前用户所持有的权限做匹配,找到该用户所拥有权限的最大范围*/
		for (Iterator i = config.getConfigAttributes(); i.hasNext();) {
			ConfigAttribute configAttribute = (ConfigAttribute) i.next();
			String attribute =  configAttribute.getAttribute();
			List authoryites = userAuthorities.get(attribute);
			if(authoryites == null)
				continue;
			
			for (Iterator iter = authoryites.iterator(); iter.hasNext();) {
				UserAuthority userAuthority = (UserAuthority) iter.next();
				if(userAuthority.getScope() == null)
					continue;
				int scope = userAuthority.getScope();
				if(scope > maxScopeLevel)
					maxScopeLevel = scope;
			}
		}
		if(maxScopeLevel == 0)
			maxScopeLevel = SecurityScope.SECURITYSCOPE_USER_LEVEL;
		
		return maxScopeLevel;
	}

	TreeManager getTreeManager() {
		return (TreeManager)SpringContextHolder.getBean("treeManagerHiOrgListener");
	}

	public String getAliasName() {
		return null;
	}

	public void setAliasName(String aliasName) {
	}

	
	/**
	 * @deprecated
	 */
	public void removeFilter(Filter subFilter) {
		new UnsupportedOperationException();
		
	}

	public String getSQL(Manager manager) {
		
		return agentFilter.getSQL(manager);
	}


}
