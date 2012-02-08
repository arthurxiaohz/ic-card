package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.model.UserRole;
import org.springframework.dao.DataAccessException;

/**
 * ��ȫ�������ӿڸýӿ���SPI,Ŀ����ͨ�������û��ʺŵõ��û���Ϣ,�����û�������Ϣ,���û�ӵ�еĽ�ɫ,���û�ӵ��
 * ���û�Ȩ��,���û����ڵ��û��鼰���û�����������Ϣ.
 * �ýӿ��Ǻ�˷���ӿ�,������ͨ��<code>UserContextHelper</code>�ൽ����������Ϣ
 * @author ���
 * @since 2007-1-27
 * @see org.hi.framework.security.context.UserContextHelper
 *
 */
public interface SecurityManager {
	/**
	 * ͨ���������û��ʺŵõ����û��Ļ�����Ϣ
	 * @param username �û��ʺ�
	 * @return ����������ʺŶ�Ӧ��<code>HiUser</code>ʵ��
	 */
	public HiUser getUser(String username);
	
	/**
	 * ͨ�������û�ʵ���õ����û���ӵ�е�Ȩ��
	 * @param user �û�ʵ��
	 * @return ���ظ����û���ӵ�е�Ȩ��
	 * @throws DataAccessException ������û�û���κ�Ȩ�޽��׳����쳣
	 */
	public List<UserAuthority> getUserAuthorities(HiUser user) throws DataAccessException;
	
	/**
	 * ͨ�������û�ʵ���õ����û���ӵ�еĽ�ɫ
	 * @param user �û�ʵ��
	 * @return ���ظ����û���ӵ�еĽ�ɫ
	 */
	public List<UserRole> getUserRoles(HiUser user);
	
	/**
	 * ͨ�������û�ʵ���õ����û����ڵ��û���
	 * @param user �û�ʵ��
	 * @return ���ظ����û����ڵ��û���
	 */
	public List<UserGroup> getUserGroups(HiUser user);
	
	/**
	 * ͨ�������û�ʵ���õ����û����û�������
	 * @param user �û�ʵ��
	 * @return ���ظ����û����û�������

	 */
	public UserContext getUserContext(String username);
	
}
