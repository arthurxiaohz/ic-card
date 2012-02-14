<%@ taglib uri="http://acegisecurity.org/authz" prefix="authz" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<#if viewType == "webwork">
<%@ taglib uri="/webwork" prefix="ws" %>
<#elseif viewType == "struts">
<%@ taglib uri="/struts-tags" prefix="ws" %>
</#if>
<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>

<%// 是否已发布的开关,其目的是如果为true则关闭那些对终端用户不可见的功能按钮 %>
<ws:set name="published" value="@org.hi.framework.HiConfigHolder@getPublished()" />
<%// 超级管理员类型的值,有些功能只对超级管理员开放 %>
<ws:set name="administratorType" value="@org.hi.base.organization.model.UserType@USERTYPE_ADMINISTRATOR" />
<%// 当前用户的所有信息,可以通过该变量获取 %>
<ws:set name="currentUser" value="@org.hi.framework.security.context.UserContextHelper@getUser()" />
<%// 当前用户是否是超级管理员,有些功能只对超级管理员开放 %>
<ws:set name="isSupperManager" value="#currentUser.isSupperManager()" />
<ws:set name="contextName" value="@org.hi.framework.HiConfigHolder@getWebContextName()" />
<%// 当前用户的ID值,可以通过该变量获取 %>
<ws:set name="currentId" value="@org.hi.framework.security.context.UserContextHelper@getUserId()" />
<script>
	var contextName = '<ws:property value="contextName" />';
</script>