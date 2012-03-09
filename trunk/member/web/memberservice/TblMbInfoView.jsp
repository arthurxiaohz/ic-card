<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员信息"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="证件类型" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.certificateTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="卡号" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.cardNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证状态" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.realNameStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证时间" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.realNameTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="注册时间" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.registerTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="注册方式" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.registerWay}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbInfo"/>：</dt><dd><fmt:formatDate value="${tblMbInfo.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbInfo"/>：</dt><dd><fmt:formatDate value="${tblMbInfo.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="国家" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.country}</dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.timeZone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号可用" entity="TblMbInfo"/>：</dt><dd><hi:select emu="yesNo" name="tblMbInfo.accountEnabled" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="加锁" entity="TblMbInfo"/>：</dt><dd><hi:select emu="yesNo" name="tblMbInfo.accountLocked" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="用效期至" entity="TblMbInfo"/>：</dt><dd><fmt:formatDate value="${tblMbInfo.expiredDate}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="是否过期" entity="TblMbInfo"/>：</dt><dd><hi:select emu="yesNo" name="tblMbInfo.credentialsExpired" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.org.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="TblMbInfo"/>：</dt><dd><hi:select emu="gender" name="tblMbInfo.gender" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.address}</dd>
		</dl>
		<dl>
			<dt><hi:text key="电话" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.phone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.mobile}</dd>
		</dl>
		<dl>
			<dt><hi:text key="邮编" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.zip}</dd>
		</dl>
		<dl>
			<dt><hi:text key="身份证" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.sSN}</dd>
		</dl>
		<dl>
			<dt><hi:text key="E-Mail" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.mail}</dd>
		</dl>
		<dl>
			<dt><hi:text key="用户类型" entity="TblMbInfo"/>：</dt><dd><hi:select emu="userType" name="tblMbInfo.userMgrType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="提醒方式" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.notifyMode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.description}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
