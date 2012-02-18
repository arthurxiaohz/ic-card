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
 * ר���ڰ�ȫ�Ĺ�����,������������˵Ӧ���û����ɼ�
 * <p>Ŀ��:�����ն��û������б�ҳ����ʾ����ʱ,���ݵ�ǰ�û���ӵ�е�Ȩ�޼�Ȩ�޵ķ�Χ����Ҫ��ʾ������
 * ���й���,���������б�ҳ��ϵͳ���ṩһ������<code>BaseManager.getList(PageInfo pageInfo)</code>
 * ϵͳ������������д��������ø����<code>getSeurityFilter()</code>����.�����ù�����ʵ����
 * pageInfo�����е�filter�ϲ�/����,�γ���ɵĹ�������,ͨ���������������ݿ��л�ȡ����,���ոù�
 * �˺��������ʾ���ն��û�
 * <p>ԭ��:�ڸ�����������һ������Filter,�����û���Ȩ�������еķ�Χ�ô���filter��ʵ���п�����
 * <code>SimpleFilter</code>����<code>InFilter</code>.����<code>getSeurityFilter()
 * </code>�����������,�ɸ÷����жϴ���������ľ�������,�����������Ƿ��ؿ�,��������������ȫ���ֵ�ɸѡ.
 * <p>����Filter�Ĺ���:<br>
 * <ul>�û���������SimpleFilter,��ǰ�û��������ļ�¼��</ul>
 * <ul>��ǰ���ż�������SimpleFilter,��ǰ�����ڲ����ڵ�������Ա�������ļ�¼��</ul>
 * <ul>���ż�������InFilter,���ݵ�ǰ����ӵ�е�Ȩ����ָ���Ĳ�����Ϊ�ο�,�Դ���ΪIN�����Ĺ�������</ul>
 * <ul>���ż��Ӳ��ż�������InFilter,���ݵ�ǰ����ӵ�е�Ȩ����ָ���Ĳ�����Ϊ�ο�,ϵͳ�Ὣ�ò���
 * �µ��������ﲿ�ž���ӵ�IN�����Ĺ���������</ul>
 * <ul>ϵͳ��������null,��������������</ul>
 * ��������Ȩ�޷�Χ���𼶵�����,��˶��ڲ��ż��벿�ż��Ӳ��ż�,�����ն��û��Ƿ����õ�ǰ�������,
 * ϵͳ���Ὣ�û���ǰ������ӵ�IN�Ĳ�ѯ������
 * <p>ϵͳԼ����Ϊ��ʹӦ��ϵͳ�ܹ�ʵ�ְ�ȫ�Ե����ݹ���(��,ʹ�������),��Ҫ��ҵ����м���creator
 * �ֶ�,��Ӧ��POJO����Ϊ<code>private HiUser creator;</code>
 * <p>���,�ڴ����ż��Ӳ��ż��ķ�Χʱ.��Ϊ���������ͽṹ,Ҫ�ҵ�ָ�����ŵ��������ﲿ��,�����ʵ
 * �ַ�ʽ�μ�<code>org.hi.common.tree.TreeManager</code>
 * @see org.hi.framework.dao.impl.SimpleFilter
 * @see org.hi.framework.dao.impl.InFilter
 * @see org.hi.framework.paging.PageInfo
 * @see org.hi.framework.service.impl.ManagerImpl#getList(PageInfo pageInfo)
 * @see org.hi.base.tree.TreeManager
 * @see org.hi.base.tree.Component
 * @see org.hi.base.tree.ComponentImpl
 * @author ���
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
	 * ��ð�ȫ������
	 * <p>�ڲ�����ԭ��:���ȴ�<code>UserContextHelper</code>��ȡ�õ�ǰ�û�,�жϵ�ǰ�û������е�Ȩ���жԵ�ǰ����
	 * ����Ҫ��Ȩ��<code>MethodConfigAttributeDefHolder</code>�������ǰ�û���Ȩ�޵������ʷ�Χ.
	 * ���������ʷ�Χ,����������Filter,���շ��ش���Filter.����Filter�Ĺ���μ����˵��
	 * @return
	 * @see org.hi.framework.security.context.UserContextHelper
	 * @see org.hi.framework.security.context.UserContext
	 * @see org.hi.framework.security.acegi.MethodConfigAttributeDefHolder
	 */
	public Filter getSeurityFilter(){
		UserContext userContext = UserContextHelper.getUserContext();
		
		/*������û��ǳ�������Ա,������ݲ�������*/
		if(userContext.isSupperManager())
			return null;
		
		/*�õ���ǰ�û���ӵ��Ȩ�޵����Χ��ֵ*/
		int maxScopeLevel = this.getMaxScopeLevel();  
		
		/*�����ǰ�û���ӵ��Ȩ�޵ķ�Χ��ϵͳ��,������ݲ�������*/
		if(maxScopeLevel == SecurityScope.SECURITYSCOPE_SYSTEM_LEVEL)
				return null;
		
		/*�������Χ��ֵ,��������Filter��ʵ��*/
		this.setAgentFilter(maxScopeLevel);
		
		/*�����ǰ�û���ӵ��Ȩ�޵ķ�Χ���û���,��POJO�е�creator�����ǵ�ǰ�û����й���*/
		if(maxScopeLevel == SecurityScope.SECURITYSCOPE_USER_LEVEL)
			return this.agentFilter.addCondition("creator.id", userContext.getUser().getId());
		
		HiOrg org = userContext.getOrg();
		
		/*�����ǰ�û���ӵ��Ȩ�޵ķ�Χ�ǵ�ǰ���ż�,��POJO�е�creator.org�����ǵ�ǰ�û������Ĳ��Ž��й���*/
		if(maxScopeLevel == SecurityScope.SECURITYSCOPE_CURRENTORG_LEVEL){
			if(org == null)
				log.error("user: " + userContext.getUserName() +" org is null");
			return this.agentFilter.addCondition("creator.org.id", userContext.getOrg().getId());
		}
		
		Set<HiOrg> filterConditions = null;
		
		if(org == null)
			log.error("user: " + userContext.getUserName() +" org is null");
		
		/*�����ǰ�û���ӵ��Ȩ�޵ķ�Χ���ڵ�ǰ���ż�,�����ҵ��������������Ĳ���*/
		filterConditions = processOrgAndSubOrgLevelFilter(org);
	
		if(filterConditions.size() >  0){
			Set<Integer> orgIds = new LinkedHashSet<Integer>();
			for (HiOrg _org : filterConditions) {
				orgIds.add(_org.getId());
			}
			return this.agentFilter.addCondition("creator.org.id", orgIds);
		}
		
		/*������ж�û��ƥ��,��ϵͳ��Ϊ�ǹ��õ�,������������ȫ�ԵĹ�������*/
		return null;
	}
	
	/**
	 * ���Ȩ�޷�Χ�ǲ��ż����ż��Ӳ��ż�,���ȡ��������Ȩ�޷�Χ�Ĳ��Ų�������ǰ����
	 * @param org �û����ڵĵ�ǰ����
	 * @return �����������������в���,������ǰ����
	 */
	protected Set<HiOrg> processOrgAndSubOrgLevelFilter(HiOrg org){
		Set<HiOrg> result = null;
		result = getAuthOrg();
		if(!result.contains(org))
			result.add(org);
		return result;
	}
	
	/**
	 * �������Ȩ�޷�Χ��ֵ,��������Filter��ʵ��,������Χ��ֵ�Ǵ��ڵ�ǰ���ż�,�򴴽�InFilter
	 * ʵ��,���򴴽�SimpleFilterʵ��
	 * @param maxScopeLevel ���Ȩ�޷�Χ��ֵ
	 */
	protected void setAgentFilter(int maxScopeLevel){
		
		if(maxScopeLevel > SecurityScope.SECURITYSCOPE_CURRENTORG_LEVEL)
			this.agentFilter = new InFilter();
		else
			this.agentFilter = new SimpleFilter();
	}
	
	/**
	 * ���ݵ�ǰ���÷����������ļ�������Ҫ��Ȩ��,�뵱ǰ�û������е�Ȩ����ƥ��,���������������û�
	 * Ȩ���еķ�Χ�ǲ��ż����û�Ȩ����ָ���Ĳ�����ӵ�������,����ǲ��ż��Ӳ��ż����û�Ȩ��
	 * ��ָ���Ĳ����µ��������ﲿ�Ű����ò���һ����ӵ�������
	 * @return �����������������в���,��һ��������ǰ�û����ڵĲ���
	 */
	private Set<HiOrg> getAuthOrg(){
		Set<HiOrg> result = new LinkedHashSet<HiOrg>();
		ConfigAttributeDefinition config = MethodConfigAttributeDefHolder.getConfigAttributeDefinition();
		Map<String, List<UserAuthority>> userAuthorities = UserContextHelper.getUserContext().getAuthorityNameList();
		
		/*��ѯ����ǰ���÷����������ļ����趨��Ȩ��*/
		for (Iterator i = config.getConfigAttributes(); i.hasNext();) {
			ConfigAttribute configAttribute = (ConfigAttribute) i.next();
			String attribute =  configAttribute.getAttribute();
			List authoryites = userAuthorities.get(attribute);
			if(authoryites == null)
				continue;
			
			/*��ѯ���÷���Ȩ�������뵱ǰ�û���ӵ�е�Ȩ����ƥ��������û�Ȩ��*/
			for (Iterator iter = authoryites.iterator(); iter.hasNext();) {
				UserAuthority userAuthority = (UserAuthority) iter.next();
				
				/*������û�Ȩ���еķ�Χ�ǲ��ż�*/
				if(userAuthority.getScope() == SecurityScope.SECURITYSCOPE_ORG_LEVEL){
					HiOrg filterOrg = userAuthority.getOrg();
					if(filterOrg == null)
						continue;
					
					if(filterOrg != null && !result.contains(filterOrg))
						result.add(filterOrg);
				}
				
				/*������û�Ȩ���еķ�Χ�ǲ��ż��Ӳ��ż�*/
				if(userAuthority.getScope() == SecurityScope.SECURITYSCOPE_ORGANDSUBORG_LEVEL){
					HiOrg org = userAuthority.getOrg();
					if(org == null)
						continue;
					
//					ComponentImpl parentComponent = (ComponentImpl)getTreeManager().getTreeMap().get(org.getComponentName());
//					List<Component> components = parentComponent.getAllComponents();
					
					List components = getTreeManager().getChildren(org);
					/*��ѯ���û�Ȩ����ָ�������µ��������ﲿ��,������ָ������*/
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
	 * ���ݵ�ǰ���÷����������ļ�������Ҫ��Ȩ��,�뵱ǰ�û������е�Ȩ����ƥ��,�ҵ����û���ӵ��Ȩ�޵����Χ
	 * ����ڰ�ȫ�����ļ���û�����õ�ǰ���÷�����Ȩ��,�򱾷������ؽ���ϵͳ���ķ�Χ.�����ǰ�û���û����֮��ƥ���Ȩ��
	 * �򷵻��û���
	 * @see org.hi.framework.security.constant.ScurityScopeType
	 * @return
	 */
	protected int getMaxScopeLevel(){
		ConfigAttributeDefinition config = MethodConfigAttributeDefHolder.getConfigAttributeDefinition();
		
		if(config == null || config.size()== 0)
			return SecurityScope.SECURITYSCOPE_SYSTEM_LEVEL;
		
		Map<String, List<UserAuthority>> userAuthorities = UserContextHelper.getUserContext().getAuthorityNameList();
		int maxScopeLevel = 0;
		
		/*���ݵ�ǰ���÷����������ļ�������Ҫ��Ȩ��,�뵱ǰ�û������е�Ȩ����ƥ��,�ҵ����û���ӵ��Ȩ�޵����Χ*/
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
