<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>系统</title>
<%@ include file="/includes/styles.jsp"%>
<script type="text/javascript">
$(function(){
	DWZ.init("styles/dwz/dwz.frag.xml", {
//		loginUrl:"loginsub.jsp", loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"login.jsp",	// 跳到登录页面
		pageInfo:{pageNum:"pageInfo.currentPage", numPerPage:"pageInfo.pageSize", orderField:"pageInfo.sorterName", orderDirection:"pageInfo.sorterDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"styles/dwz/themes"});
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
	
		<div id="container">
			<div id="navTab" class="tabsPage">
				
				<div class="navTab-panel tabsPageContent">
					<div>