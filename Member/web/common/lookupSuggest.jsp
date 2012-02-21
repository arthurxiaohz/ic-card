<%@page import="org.hi.framework.web.PageInfoView"%>
<%@page import="org.hi.common.util.JSONObject"%>
<%@page import="org.hi.framework.web.PageInfoUtil"%>
<%@page import="org.hi.framework.paging.PageInfo"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.hi.common.util.StringUtils"%>
<%@page import="org.hi.common.util.BeanUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.hi.framework.service.impl.ManagerImpl"%>
<%@page import="org.hi.framework.service.Manager"%>
<%@page import="org.hi.SpringContextHolder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%response.setContentType("text/xml");
	String className = (String)request.getParameter("className");
	String inputValue = (String)request.getParameter("inputValue");
	String lookupSearchFields = (String)request.getParameter("lookupSearchFields");
	String lookupPrivileges = (String)request.getParameter("lookupPrivileges");
	String filterJson = (String)request.getParameter("filter");
	PageInfo sarchPageInfo = null;
	if(filterJson != null && !filterJson.trim().equals("")){
		String pageInfoClass = className.replaceAll(".model.",".action.") + "PageInfo";
		PageInfoView pageInfo = (PageInfoView)JSONObject.json2Bean(filterJson, Class.forName(pageInfoClass));
		sarchPageInfo = PageInfoUtil.populate(pageInfo, null);
	}
	ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
	List reslut = bMgr.getObjectsForLookup(Class.forName(className),inputValue, lookupSearchFields,lookupPrivileges, sarchPageInfo);
	JSONObject jsonObject = new JSONObject("beans", reslut);
	out.print(jsonObject.getJSON());
	//out.print(BeanUtil.getCollection2XML(reslut, "beans", "bean"));
 %>

