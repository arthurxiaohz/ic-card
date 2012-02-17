<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">用户查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="帐号" entity="HiUser"/>：</dt><dd>${hiUser.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="国家" entity="HiUser"/>：</dt><dd>${hiUser.country}</dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="HiUser"/>：</dt><dd>${hiUser.timeZone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号可用" entity="HiUser"/>：</dt><dd><hi:select emu="yesNo" name="hiUser.accountEnabled" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="加锁" entity="HiUser"/>：</dt><dd><hi:select emu="yesNo" name="hiUser.accountLocked" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="用效期至" entity="HiUser"/>：</dt><dd><fmt:formatDate value="${hiUser.expiredDate}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="是否过期" entity="HiUser"/>：</dt><dd><hi:select emu="yesNo" name="hiUser.credentialsExpired" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="HiUser"/>：</dt><dd>${hiUser.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="HiUser"/>：</dt><dd>${hiUser.org.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="HiUser"/>：</dt><dd><hi:select emu="gender" name="hiUser.gender" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="HiUser"/>：</dt><dd>${hiUser.address}</dd>
		</dl>
		<dl>
		    <dt><hi:text key="电话" entity="HiUser"/>：</dt><dd>${hiUser.phone}</dd>
		</dl>	
		<dl>
			<dt><hi:text key="手机" entity="HiUser"/>：</dt><dd>${hiUser.mobile}</dd>
		</dl>
		<dl>
			<dt><hi:text key="邮编" entity="HiUser"/>：</dt><dd>${hiUser.zip}</dd>
		</dl>	
		<dl>
			<dt><hi:text key="身份证" entity="HiUser"/>：</dt><dd>${hiUser.SSN}</dd>
		</dl>
		<dl>
			<dt><hi:text key="E-Mail" entity="HiUser"/>：</dt><dd>${hiUser.mail}</dd>
		</dl>	
		<dl>
			<dt><hi:text key="用户类型" entity="HiUser"/>：</dt><dd><hi:select emu="userType" name="hiUser.userMgrType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="提醒方式" entity="HiUser"/>：</dt><dd>${hiUser.notifyMode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="HiUser"/>：</dt><dd>${hiUser.description}</dd>
		</dl>	
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>