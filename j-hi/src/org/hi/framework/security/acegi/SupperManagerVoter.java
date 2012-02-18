package org.hi.framework.security.acegi;

import org.acegisecurity.Authentication;
import org.acegisecurity.ConfigAttribute;
import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.vote.AccessDecisionVoter;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.context.UserContext;

/**
 * ��<code>AccessDecisionVoter</code>�ӿڵ�ʵ����,ʵ�ֳ�������Ա�ı����
 * <p>Ŀ�����жϵ�ǰ�û��Ƿ�Ϊ��������Ա,�������Ͷ���޳�Ʊ,����Ͷ���Ʊ.
 * ���մﵽ��Ч����,�����ǰ�û��ǳ�������Ա�����κ�Ȩ������
 * 
 * @see org.acegisecurity.vote.AccessDecisionVoter
 * @author ���
 * @since 2007-1-23
 *
 */
public class SupperManagerVoter implements AccessDecisionVoter {

	/* (non-Javadoc)
	 * @see org.acegisecurity.vote.AccessDecisionVoter#supports(org.acegisecurity.ConfigAttribute)
	 */
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.vote.AccessDecisionVoter#supports(java.lang.Class)
	 */
	public boolean supports(Class clazz) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.vote.AccessDecisionVoter#vote(org.acegisecurity.Authentication, java.lang.Object, org.acegisecurity.ConfigAttributeDefinition)
	 */
	public int vote(Authentication authentication, Object object, ConfigAttributeDefinition config) {
		UserContext userContext =  null;
		try{
			userContext = (UserContext)authentication.getDetails();
		}
		catch(ClassCastException e){
			return AccessDecisionVoter.ACCESS_ABSTAIN;
		}
		HiUser user = userContext.getUser();
		if(user.isSupperManager())
			return AccessDecisionVoter.ACCESS_GRANTED;
		else
			return AccessDecisionVoter.ACCESS_ABSTAIN;
	}

}
