package org.hi.framework.security.acegi;

import org.acegisecurity.Authentication;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.acegisecurity.userdetails.UserDetails;

/**
 * ����̳�<code>DaoAuthenticationProvider</code>��,��Ŀ���Ǹ��Ǹ���
 * <code>createSuccessAuthentication(principal, authentication, user)</code>����,�������ݷ��ʲ�
 * �õ����û���Ϣ���󸳸�<code>Authentication</code>������<code>UsernamePasswordAuthenticationToken</code>
 * ��details����
 * @author ���
 * @since 2007-6-20
 * @see org.acegisecurity.providers.dao.DaoAuthenticationProvider
 * @see org.acegisecurity.Authentication
 * @see org.acegisecurity.providers.UsernamePasswordAuthenticationToken
 *
 */
public class DaoAuthenticationUserDetailProvider extends DaoAuthenticationProvider {

    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication,
            UserDetails user) {
            // Ensure we return the original credentials the user supplied,
            // so subsequent attempts are successful even with encoded passwords.
            // Also ensure we return the original getDetails(), so that future
            // authentication events after cache expiry contain the details
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal,
                    authentication.getCredentials(), user.getAuthorities());
            result.setDetails(user);

            return result;
        }
	
}
