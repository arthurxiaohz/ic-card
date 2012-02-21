<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="多语言信息"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="Key值" entity="Language"/>：</dt><dd>${language.keyStr}</dd>
		</dl>
		<dl>
			<dt><hi:text key="服务" entity="Language"/>：</dt><dd>${language.service}</dd>
		</dl>
		<dl>
			<dt><hi:text key="实体" entity="Language"/>：</dt><dd>${language.entity}</dd>
		</dl>
		<dl>
			<dt><hi:text key="系统参数" entity="Language"/>：</dt><dd>${language.isSystem}</dd>
		</dl>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="多语言值"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="语言代码" entity="LanguageStr"/></th>
								<th><hi:text key="值" entity="LanguageStr"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${language.languageStrs}">
							<tr>						
								<td>${item.languageCode}</td>
								<td>${item.value}</td>
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
