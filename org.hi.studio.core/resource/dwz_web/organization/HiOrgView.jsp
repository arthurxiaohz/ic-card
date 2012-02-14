<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">部门查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="部门名称" entity="HiOrg"/>：</dt><dd>${hiOrg.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门编号" entity="HiOrg"/>：</dt><dd>${hiOrg.orgNum}</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门经理" entity="HiOrg"/>：</dt><dd>${hiOrg.manager.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="上级部门" entity="HiOrg"/>：</dt><dd>${hiOrg.parentOrg.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="HiOrg"/>：</dt><dd>${hiOrg.address}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="HiOrg"/>：</dt><dd>${hiOrg.description}</dd>
		</dl>			
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>	