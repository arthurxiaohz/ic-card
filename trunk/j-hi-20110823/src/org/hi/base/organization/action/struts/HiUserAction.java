package org.hi.base.organization.action.struts;

import java.util.List;

import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

import org.hi.base.organization.action.HiUserPageInfo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;

public class HiUserAction extends BaseAction{
	private HiUser hiUser;
	private HiUserPageInfo pageInfo;
	private List<HiUser> hiUsers;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı�����Ա
	 */
	public String saveHiUser() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		Filter filter = FilterFactory.getSimpleFilter("userName", hiUser.getUserName(), Filter.OPERATOR_EQ);
		List<HiUser> users = hiUserMgr.getObjects(filter);
		if((hiUser.getId() == null && users.size() >0) || (hiUser.getId() != null && users.size() >1))
			throw new BusinessException(I18NUtil.getString("�ʺ��ظ�") + "!");
		
		if(super.perExecute(hiUser)!= null) return returnCommand();
		
		hiUserMgr.saveHiUser(hiUser);
		super.postExecute(hiUser);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����Ա
	 */
	public String removeHiUser() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		hiUserMgr.removeHiUserById(hiUser.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��Ա
	 */
	public String removeAllHiUser() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer hiUserid = new Integer( ids[i] );
				hiUserMgr.removeHiUserById(hiUserid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��Ա
	 */
	public String viewHiUser() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		hiUser = hiUserMgr.getHiUserById(hiUser.getId());
		return returnCommand();
	}
	
	/**
	 * ��Ա�б�
	 */
	public String hiUserList() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		pageInfo = pageInfo == null ? new HiUserPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		hiUsers = hiUserMgr.getSecurityHiUserList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	/**
	 * �õ���ǰ�û�
	 */
	public String currentUser() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		hiUser = hiUserMgr.getHiUserById(UserContextHelper.getUser().getId());
		return returnCommand();
	}
	/**
	 * �����û�����
	 * @return
	 * @throws Exception
	 */
	public String saveUserPassword() throws Exception{
		if(super.perExecute(hiUser)!= null) return returnCommand();
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		
		Filter filter = FilterFactory.getSimpleFilter("userName", hiUser.getUserName(), Filter.OPERATOR_EQ);
		List<HiUser> users = hiUserMgr.getObjects(filter);
		if(users.size() >1)
			throw new BusinessException(I18NUtil.getString("�ʺ��ظ�") + "!");
		
		MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder)SpringContextHolder.getBean("passwordEncoder");
		String newPassword = getRequest().getParameter("hiUser.newPassword");
		String password = passwordEncoder.encodePassword(newPassword, null);
		
		if(!newPassword.equals("") && !newPassword.equals(hiUser.getPassword())){
			hiUser.setPassword(password);
		}
		
		hiUserMgr.saveObject(hiUser);
		super.postExecute(hiUser);
		
//		����û�Ϊ��ǰ���µ�ǰ�û������е�����
		HiUser currentUser = UserContextHelper.getUser();
		if(currentUser.getId().equals(hiUser.getId())){
			UserContext userContext = UserContextHelper.getUserContext();
			userContext.setUser(hiUser);
		}
		
		return returnCommand();
	}
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}
	
	public List<HiUser> getHiUsers() {
		return hiUsers;
	}

	public void setHiUsers(List<HiUser> hiUsers) {
		this.hiUsers = hiUsers;
	}

	public HiUserPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HiUserPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
