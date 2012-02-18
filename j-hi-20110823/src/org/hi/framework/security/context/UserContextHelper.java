package org.hi.framework.security.context;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;

/**
 * ������һ��������,���еĳ�Ա�������Ǿ�̬��,Ŀ��ֻ�Ǹ�����Ļ�ȡ�뵱ǰ�û���ص���Ϣ.
 * ��ԭ����ͨ��Acegi�ṩ��<code>SecurityContextHolder</code>��û�ȡ���߳�Ϊkey��һ��
 * <code>SecurityContext</code>ʵ��
 * @see org.hi.framework.security.context.UserContext
 * @see org.acegisecurity.context.SecurityContextHolder
 * @see org.acegisecurity.context.SecurityContext
 * @author ���
 * @since 2007-1-21
 *
 */
public class UserContextHelper {
    
    /**
     * ��ǰ��¼�û���������
     * @return ���ص�ǰ�û���������
     */
    public static UserContext getUserContext(){
    	return getAuthentication() != null && getAuthentication().getPrincipal() instanceof UserContext ? (UserContext)(getAuthentication().getPrincipal()) : null ;
    }
    
    /**
     * @return
     * @see org.acegisecurity.context.SecurityContextHolder#getContext()
     */
    public static SecurityContext getContext(){
    	return SecurityContextHolder.getContext();
    }
       
    /**
     * @return
     * @see org.acegisecurity.context.SecurityContext#getAuthentication()
     */
    public static Authentication getAuthentication(){
    	return getContext() == null ? null :getContext().getAuthentication();
    }
    
	/**
	 * ��ǰ�û��Ļ�����Ϣ,HiUser��POJO
	 * @return ���ص�ǰ�û��Ļ�����Ϣ
	 */
    public static HiUser getUser(){
    	return getUserContext() == null ? null : getUserContext().getUser();
    }
    
	/**
	 * ��ǰ�û����ڲ��ŵ���Ϣ
	 * @return ���ص�ǰ�û����ڵĲ���
	 */
    public static HiOrg getOrg(){
    	return getUserContext() == null ? null : getUserContext().getOrg();
    }
    
	/**
	 * ��õ�ǰ�û���IDֵ
	 * @return ���ص�ǰ�û���IDֵ
	 */
    public static Integer getUserId(){
    	return getUserContext() == null ? null : getUserContext().getUserId();
    }
 
	/**
	 * ��õ�ǰ�û����ڲ��ŵĲ��Ź����ߵ�IDֵ
	 * @return ��ǰ�û��Ĳ����쵼��IDֵ
	 */
    public static Integer getOrgId(){
    	return getUserContext() == null ? null : getUserContext().getOrgId();
    }
    
	/**
	 * ��õ�ǰ�û�������
	 * @return ���ص�ǰ�û�������
	 */
    public static String getUserName(){
    	return getUserContext() == null ? null : getUserContext().getUserName();
    }
    
	/**
	 * ��õ�ǰ�û����ڲ��ŵĲ�������
	 * @return ��ǰ�û��Ĳ��ŵĲ�������
	 */    
    public static String getOrgName(){
    	return getUserContext() == null ? null : getUserContext().getOrgName();
    }
}
