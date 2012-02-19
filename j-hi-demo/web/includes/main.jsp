<%@ taglib uri="http://acegisecurity.org/authz" prefix="authz" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="ws" %>
<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>

<%// �Ƿ��ѷ����Ŀ���,��Ŀ�������Ϊtrue��ر���Щ���ն��û����ɼ��Ĺ��ܰ�ť %>
<ws:set name="published" value="@org.hi.framework.HiConfigHolder@getPublished()" />
<%// ��������Ա���͵�ֵ,��Щ����ֻ�Գ�������Ա���� %>
<ws:set name="administratorType" value="@org.hi.base.organization.model.UserType@USERTYPE_ADMINISTRATOR" />
<%// ��ǰ�û���������Ϣ,����ͨ���ñ�����ȡ %>
<ws:set name="currentUser" value="@org.hi.framework.security.context.UserContextHelper@getUser()" />
<%// ��ǰ�û��Ƿ��ǳ�������Ա,��Щ����ֻ�Գ�������Ա���� %>
<ws:set name="isSupperManager" value="#currentUser.isSupperManager()" />
<ws:set name="contextName" value="@org.hi.framework.HiConfigHolder@getWebContextName()" />
<%// ��ǰ�û���IDֵ,����ͨ���ñ�����ȡ %>
<ws:set name="currentId" value="@org.hi.framework.security.context.UserContextHelper@getUserId()" />
<script>
	var contextName = '<ws:property value="contextName" />';
</script>