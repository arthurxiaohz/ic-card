<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商服操作员"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="商户号" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="国家" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.country}</dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.timeZone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号可用" entity="TblMchtUser"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtUser.accountEnabled" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="加锁" entity="TblMchtUser"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtUser.accountLocked" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="用效期至" entity="TblMchtUser"/>：</dt><dd><fmt:formatDate value="${tblMchtUser.expiredDate}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="是否过期" entity="TblMchtUser"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtUser.credentialsExpired" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.org.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="TblMchtUser"/>：</dt><dd><hi:select emu="gender" name="tblMchtUser.gender" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.address}</dd>
		</dl>
		<dl>
			<dt><hi:text key="电话" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.phone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.mobile}</dd>
		</dl>
		<dl>
			<dt><hi:text key="邮编" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.zip}</dd>
		</dl>
		<dl>
			<dt><hi:text key="身份证" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.sSN}</dd>
		</dl>
		<dl>
			<dt><hi:text key="E-Mail" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.mail}</dd>
		</dl>
		<dl>
			<dt><hi:text key="用户类型" entity="TblMchtUser"/>：</dt><dd><hi:select emu="userType" name="tblMchtUser.userMgrType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="提醒方式" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.notifyMode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblMchtUser"/>：</dt><dd>${tblMchtUser.description}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
