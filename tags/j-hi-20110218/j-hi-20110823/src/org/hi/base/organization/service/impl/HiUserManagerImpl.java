package org.hi.base.organization.service.impl;

import java.util.List;

import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
import org.hi.SpringContextHolder;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.security.service.UserGroupManager;
import org.hi.framework.security.service.UserRoleManager;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.base.organization.service.HiUserManager;

public class HiUserManagerImpl extends ManagerImpl implements HiUserManager{
    
    protected void preSaveObject(Object obj) {
    	HiUser user = (HiUser)obj;
    	if(user.getCreator() == null)
    		user.setCreator(UserContextHelper.getUser());
    	
//		如果用户没有密码，并且环境配置有缺省密码，则为该用户加缺省密码
		if((user.getPassword() == null  || user.getPassword().equals("")) && HiConfigHolder.getUserPassword() != null){
			String _password = HiConfigHolder.getUserPassword();
			MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder)SpringContextHolder.getBean("passwordEncoder");
			String password = passwordEncoder.encodePassword(_password, null);
			user.setPassword(password);
			
		}
		
    	super.preSaveObject(obj);

    }
 
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
    	//删除与该用户相关的权限与角色
    	HiUser user = (HiUser)obj;
    	UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
    	UserAuthorityManager userAuthMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
    	UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
    	
    	userGroupMgr.removeUserGroupByUser(user.getId());
    	userRoleMgr.removeUserRoleByUser(user.getId());
    	userAuthMgr.removeUserAuthorityByUser(user.getId());
    	
        super.postRemoveObject(obj);
        
    }
    
    public void saveHiUser(HiUser HiUser){
    	saveObject(HiUser);
    
    }

    public void removeHiUserById(Integer id){
    	removeObjectById(id);
    	
    }

    public HiUser getHiUserById(Integer id){
   		return (HiUser) getObjectById(id);
    }

    public List<HiUser> getHiUserList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityHiUser(HiUser hiUser){
    	saveObject(hiUser);
    }
    public void removeSecurityHiUserById(Integer id){
    	removeObjectById(id);
    }
    public HiUser getSecurityHiUserById(Integer id){
    	return (HiUser) getObjectById(id);
    }
    public List<HiUser> getSecurityHiUserList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }     
    
    public String getAllOrgHTML() {
    	HiOrgManager orgManager = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		String result="";
		List orglist=orgManager.getObjects();
		result=result+"<select name=\"leftorg\" id=\"leftorg\" size=\"15\" style=\"width:200px\" multiple ondblclick=\"getalluserbyorgid(this.value)\">";
		for(int i=0;i<orglist.size();i++){
			HiOrg org=(HiOrg)orglist.get(i);
			result=result+"<option value=\""+org.getId()+"\">"+org.getOrgName()+"</option>";
		}
		result=result+"</select>";
		System.out.println(result);
		return result;
	}
	public String getAllUserByOrgIdHTML(String orgid) {
		List userlist=this.getAllUserByOrgId(orgid);
		String result="";
		result=result+"<select name=\"left\" id=\"left\" size=\"15\" style=\"width:200px\" multiple>";
		result=result+"<option value=\"0\">全部</option>";
		for(int i=0;i<userlist.size();i++){
			HiUser user=(HiUser)userlist.get(i);
			result=result+"<option value=\""+user.getId()+"\">"+user.getFullName()+"</option>";
		}
		result=result+"</select>";
		System.out.println(result);
		return result;
	}
	public List getAllUserByOrgId(String orgid) {
		Filter filter=FilterFactory.getSimpleFilter("org.id",new Integer(orgid));
		return this.getObjects(filter);
	}
	public String getAllUserHTML() {
		List userlist=this.getObjects();
		String result="";
		result=result+"<select name=\"left\" id=\"left\" size=\"15\" style=\"width:200px\" multiple>";
		result=result+"<option value=\"0\">全部</option>";
		for(int i=0;i<userlist.size();i++){
			HiUser user=(HiUser)userlist.get(i);
			result=result+"<option value=\""+user.getId()+"\">"+user.getFullName()+"</option>";
		}
		result=result+"</select>";
		System.out.println(result);
		return result;
	}
}
