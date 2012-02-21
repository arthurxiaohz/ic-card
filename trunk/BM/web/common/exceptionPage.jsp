<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.hi.framework.web.BusinessException"%>
<%@page import="org.hi.framework.web.taglib.component.bean.Token"%>
<% 

	if(session.getAttribute(Token.TOKEN_LIST_NAME) != null){
		Token token = (Token)session.getAttribute(Token.TOKEN_LIST_NAME);
		token.delEndToken();
	}
%>
{
	"statusCode":"300", 
	"message":<c:if test="${exception!=null}">"${exception.message }"</c:if>,
	"forwardUrl":"",
	"navTabId":"",
	"callbackType":""
}

