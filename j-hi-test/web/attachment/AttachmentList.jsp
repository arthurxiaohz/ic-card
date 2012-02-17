<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<%
String attachDesc = request.getParameter("from");
if (attachDesc == null )
	attachDesc = "attachment";
String attachmentType= request.getParameter("saveType");
if (attachmentType== null )
	attachmentType ="1";
%>

<h2 class="contentTitle">请选择需要上传的附件</h2>
<form name="saveForm" action="attachmentSave.action?ajax=0" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this, $.bringBack)">


<input type="hidden" name="attachment.attachDesc" value="<%=attachDesc%>" />
<input type="hidden" name="attachment.attachmentType" value="<%=attachmentType%>" />
<input type="hidden" name="attachment.id" value="${attachment.id}"/>
<input type="hidden" name="attachment.version" value="${attachment.version}"/>

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>附件：</dt><dd><input type="file" name="image" class="required" size="30" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">上传</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" onclick="javascript:$.bringBack({id:'-1', fileName:'', attachmentPath:'',attachmentSize:'',imageICO:''})"><hi:text key="重置"/></button></div></div></li>
		</ul>
	</div>
</div>
</form>
