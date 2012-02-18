package org.hi.framework.security.model;

import org.acegisecurity.GrantedAuthority;
import org.hi.framework.security.model.original.AuthorityAbstract;


public class Authority extends AuthorityAbstract implements GrantedAuthority{
	
	//---------------------------------------------------------------------
	// Implementation of GrantedAuthority interface
	//---------------------------------------------------------------------
 
/* (non-Javadoc)
 * @see org.acegisecurity.GrantedAuthority#getAuthority()
 */
public String getAuthority() {
	return authorityName;
}

public void setAuthorityName(String authorityName){
	authorityName = authorityName == null ? null : authorityName.trim();
	super.setAuthorityName(authorityName);
}

}