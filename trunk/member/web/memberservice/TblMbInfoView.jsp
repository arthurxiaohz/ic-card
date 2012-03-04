<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员信息"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.plNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台会员号" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.certificateTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="证件号码" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.certificateNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="真实姓名" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.realName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.sex}</dd>
		</dl>
		<dl>
			<dt><hi:text key="住址" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.address}</dd>
		</dl>
		<dl>
			<dt><hi:text key="邮政编码" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.zipCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.mobile}</dd>
		</dl>
		<dl>
			<dt><hi:text key="固定电话" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.phone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="Email地址" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.email}</dd>
		</dl>
		<dl>
			<dt><hi:text key="登录密码" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.password}</dd>
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
			<dt><hi:text key="最后修改人" entity="TblMbInfo"/>：</dt><dd>${tblMbInfo.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
