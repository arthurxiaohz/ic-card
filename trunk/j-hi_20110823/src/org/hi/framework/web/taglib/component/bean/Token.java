package org.hi.framework.web.taglib.component.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Token implements Serializable{
	public static final String TOKEN_LIST_NAME = "session.token";
	public static final String TOKEN_STRING_NAME = "token";
	private List<String> tokenValues = new ArrayList<String>();
	
	protected String generateTokenString(HttpSession session) {
		return System.currentTimeMillis() + session.getId();
	}
    
	/**
	 * ����sessionȡ��session+sessonId��tokenStr
	 */
	public String getTokenString(HttpSession session) {
		String tokenStr = generateTokenString(session);
		return tokenStr;
	}
	/**
	 * ɾ��token
	 */
	public void delEndToken(){
		if(tokenValues.size() > 0)
			tokenValues.remove(tokenValues.size() - 1);
	}
	/**
	 * 
	 * @param tokenStr
	 * @return
	 */
    public  boolean isTokenStringValid(String tokenStr) {
    	if(tokenStr == null)
    		return true;
    	
        if(tokenValues.contains(tokenStr))
      	   return false;
         else{
        	 tokenValues.add(tokenStr);
        	 return true;
         }
    }
}
