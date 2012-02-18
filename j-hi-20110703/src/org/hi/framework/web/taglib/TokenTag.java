/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.hi.framework.web.taglib;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.hi.framework.web.taglib.component.bean.Token;


public class TokenTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String mothed="post";
	public int doEndTag() throws JspException {
		JspWriter jspOut = pageContext.getOut();
		try {
			if( mothed.equals("get"))
				jspOut.print(Token.TOKEN_STRING_NAME+"="+new Token().getTokenString(pageContext.getSession()));
			else
				jspOut.print("<input type=\"hidden\" name=\""+Token.TOKEN_STRING_NAME+"\" value=\""+new Token().getTokenString(pageContext.getSession())+"\">");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	public void release() {
		session=null;
		mothed = null;
		super.release();
	}
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getMothed() {
		return mothed;
	}
	public void setMothed(String mothed) {
		this.mothed = mothed;
	}


}
