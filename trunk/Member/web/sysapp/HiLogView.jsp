<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">系统日志查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="操作人" entity="HiLog"/>：</dt><dd>${hiLog.operator.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="操作时间" entity="HiLog"/>：</dt><dd><fmt:formatDate value="${hiLog.operateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="动作" entity="HiLog"/>：</dt><dd>${hiLog.action}</dd>
		</dl>
		<dl class="nowrap">
			<dt><hi:text key="操作内容" entity="HiLog"/>：</dt><dd>${hiLog.actionContext}</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>