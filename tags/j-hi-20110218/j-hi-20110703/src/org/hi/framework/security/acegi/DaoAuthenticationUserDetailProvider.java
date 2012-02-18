package org.hi.framework.security.acegi;

import org.acegisecurity.Authentication;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.acegisecurity.userdetails.UserDetails;

/**
 * 该类继承<code>DaoAuthenticationProvider</code>类,其目的是覆盖父的
 * <code>createSuccessAuthentication(principal, authentication, user)</code>方法,将从数据访问层
 * 得到的用户信息对象赋给<code>Authentication</code>子孙类<code>UsernamePasswordAuthenticationToken</code>
 * 的details属性
 * @author 张昊
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
