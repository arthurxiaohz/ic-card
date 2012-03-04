<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员信息"/></h2>
<form action="tblMbInfoSave.action?navTabId=tblMbInfoList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.plNo" class="textInput required" value="${tblMbInfo.plNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="平台会员号" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.userName" class="textInput required" value="${tblMbInfo.userName}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.certificateTypeId" class="textInput" value="${tblMbInfo.certificateTypeId}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="证件号码" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.certificateNo" class="textInput" value="${tblMbInfo.certificateNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="真实姓名" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.realName" class="textInput required" value="${tblMbInfo.realName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.sex" class="textInput required" value="${tblMbInfo.sex}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="住址" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.address" class="textInput required" value="${tblMbInfo.address}" maxlength="256"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="邮政编码" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.zipCode" class="textInput required" value="${tblMbInfo.zipCode}" maxlength="6"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.mobile" class="textInput required" value="${tblMbInfo.mobile}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="固定电话" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.phone" class="textInput required" value="${tblMbInfo.phone}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="Email地址" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.email" class="textInput required" value="${tblMbInfo.email}" maxlength="90"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="登录密码" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.password" class="textInput required" value="${tblMbInfo.password}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="卡号" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.cardNo" class="textInput required" value="${tblMbInfo.cardNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证状态" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.realNameStatus" class="textInput required" value="${tblMbInfo.realNameStatus}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证时间" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.realNameTime" class="textInput required" value="${tblMbInfo.realNameTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="注册时间" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.registerTime" class="textInput required" value="${tblMbInfo.registerTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="注册方式" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.registerWay" class="textInput required" value="${tblMbInfo.registerWay}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMbInfo.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbInfo.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMbInfo.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbInfo.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.lastUpdatedBy" class="textInput required" value="${tblMbInfo.lastUpdatedBy}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="tblMbInfo.id" value="${tblMbInfo.id}"/>
				<input type="hidden" name="tblMbInfo.creator.id" value="${tblMbInfo.creator.id}"/>
				<input type="hidden" name="tblMbInfo.deleted" value="${tblMbInfo.deleted}"/>
				<input type="hidden" name="tblMbInfo.version" value="${tblMbInfo.version}"/>

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
