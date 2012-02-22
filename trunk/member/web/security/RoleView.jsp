<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">角色查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="角色名称" entity="Role"/>：</dt><dd>${role.roleName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="Role"/>：</dt><dd>${role.displayRef}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Role"/>：</dt><dd>${role.description}</dd>
		</dl>
		
		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="权限信息"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="用户信息"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="权限" entity="RoleAuthority"/></th>
								<th><hi:text key="部门" entity="RoleAuthority"/></th>
								<th><hi:text key="范围" entity="RoleAuthority"/></th>
							</tr>
						</thead>
						<tbody>
							
							<c:forEach var="item" items="${roleAuthorities}"  varStatus="roleAuthorityIndex">
							<tr>						
								<td>${item.authority.description}</td>
								<td>${item.org.orgName}</td>
				        		<td><hi:select emu="securityScope" name="roleAuthorities[${roleAuthorityIndex.count-1}].scope" isLabel="true"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="用户名" entity="Role"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${userRoles}" >
							<tr>						
								<td>${item.securityUser.fullName}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>				
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>