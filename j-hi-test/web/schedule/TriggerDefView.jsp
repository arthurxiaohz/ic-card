<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">触发器查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="触发名称" entity="TriggerDef"/>：</dt><dd>${triggerDef.triggerName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="工作项" entity="TriggerDef"/>：</dt><dd>${triggerDef.jobDetail.jobName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开始时间" entity="TriggerDef"/>：</dt><dd><fmt:formatDate value="${triggerDef.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="截止时间" entity="TriggerDef"/>：</dt><dd><fmt:formatDate value="${triggerDef.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="表达式" entity="TriggerDef"/>：</dt><dd>${triggerDef.cronExpression}</dd>
		</dl>
		<dl>
			<dt><hi:text key="激活" entity="TriggerDef"/>：</dt><dd><hi:select emu="yesNo" name="triggerDef.enabled" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TriggerDef"/>：</dt><dd>${triggerDef.description}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建人" entity="TriggerDef"/>：</dt><dd>${triggerDef.creator.fullName}</dd>
		</dl>		
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>