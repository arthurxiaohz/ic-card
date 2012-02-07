<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="触发器"/></h2>
<form action="triggerDefSave.action?navTabId=triggerDefList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="triggerDef.id" value="${triggerDef.id}"/>
<input type="hidden" name="triggerDef.version" value="${triggerDef.version}"/>
<input type="hidden" name="triggerDef.creator.id" value="${triggerDef.creator.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="触发名称" entity="TriggerDef"/>：</dt><dd><input type="text" name="triggerDef.triggerName" class="textInput" value="${triggerDef.triggerName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="工作项" entity="TriggerDef"/>：</dt>
			<dd>
				<input type="hidden" name="triggerDef.jobDetail.id" value="${triggerDef.jobDetail.id}"/>
			<input type="text" name="triggerDef.jobDetailName" class="textInput" value="${triggerDef.jobDetail.jobClassName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="开始时间" entity="TriggerDef"/>：</dt>
			<dd>
				<input type="text" name="triggerDef.startTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${triggerDef.startTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="截止时间" entity="TriggerDef"/>：</dt>
			<dd>
				<input type="text" name="triggerDef.endTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${triggerDef.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="表达式" entity="TriggerDef"/>：</dt><dd><input type="text" name="triggerDef.cronExpression" class="textInput" value="${triggerDef.cronExpression}" /></dd>
		</dl>
			<dl>
			<dt><hi:text key="激活" entity="TriggerDef"/>：</dt><dd><hi:select emu="yesNo" name="triggerDef.enabled"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TriggerDef"/>：</dt><dd><input type="text" name="triggerDef.description" class="textInput" value="${triggerDef.description}" /></dd>
		</dl>		
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  
</div>
</form>