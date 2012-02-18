package org.hi.framework.security.acegi;

import org.acegisecurity.Authentication;
import org.acegisecurity.ConfigAttribute;
import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.vote.AccessDecisionVoter;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.context.UserContext;

/**
 * 是<code>AccessDecisionVoter</code>接口的实现类,实现超级管理员的表决器
 * <p>目的是判断当前用户是否为超级管理员,如果是则投出赞成票,否则投否决票.
 * 最终达到的效果是,如果当前用户是超级管理员则不受任何权限限制
 * 
 * @see org.acegisecurity.vote.AccessDecisionVoter
 * @author 张昊
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
