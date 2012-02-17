<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">枚举实体查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="枚举名称" entity="Enumeration"/>：</dt><dd>${enumeration.enName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="Enumeration"/>：</dt><dd>${enumeration.displayRef}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Enumeration"/>：</dt><dd>${enumeration.description}</dd>
		</dl>
		
		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="枚举值"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="枚举值名称" entity="EnumerationValue"/></th>
								<th><hi:text key="显示信息" entity="EnumerationValue"/></th>
								<th><hi:text key="描述" entity="EnumerationValue"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${enumeration.enumerationValues}">
							<tr>						
								<td>${item.valueName}</td>
								<td>${item.displayRef}</td>
								<td>${item.description}</td>
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