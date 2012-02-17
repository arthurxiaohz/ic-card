<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="Experience"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="开始时间" entity="Experience"/>：</dt><dd><fmt:formatDate value="${experience.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="结束时间" entity="Experience"/>：</dt><dd><fmt:formatDate value="${experience.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="地点" entity="Experience"/>：</dt><dd>${experience.place}</dd>
		</dl>
		<dl>
			<dt><hi:text key="任务" entity="Experience"/>：</dt><dd>${experience.task}</dd>
		</dl>
		<dl>
			<dt><hi:text key="证明人" entity="Experience"/>：</dt><dd>${experience.people}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
