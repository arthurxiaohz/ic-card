<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="Experience"/></h2>
<form action="experienceSave.action?navTabId=experienceList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="开始时间" entity="Experience"/>：</dt>
			<dd>
				<input type="text" name="experience.startTime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${experience.startTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="结束时间" entity="Experience"/>：</dt>
			<dd>
				<input type="text" name="experience.endTime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${experience.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="地点" entity="Experience"/>：</dt><dd><input type="text" name="experience.place" class="textInput required" value="${experience.place}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="任务" entity="Experience"/>：</dt><dd><input type="text" name="experience.task" class="textInput required" value="${experience.task}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="证明人" entity="Experience"/>：</dt><dd><input type="text" name="experience.people" class="textInput required" value="${experience.people}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="experience.id" value="${experience.id}"/>
				<input type="hidden" name="experience.staff.id" value="${experience.staff.id}"/>
				<input type="hidden" name="experience.creator.id" value="${experience.creator.id}"/>
				<input type="hidden" name="experience.version" value="${experience.version}"/>

		<div class="divider"></div>
			</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
