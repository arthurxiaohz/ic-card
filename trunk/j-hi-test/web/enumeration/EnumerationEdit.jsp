<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="枚举实体"/></h2>
<form action="enumerationSave.action?navTabId=enumerationList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="枚举名称" entity="Enumeration"/>：</dt><dd><input type="text" name="enumeration.enName" class="textInput required" value="${enumeration.enName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信心" entity="Enumeration"/>：</dt><dd><input type="text" name="enumeration.displayRef" class="textInput required" value="${enumeration.displayRef}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Enumeration"/>：</dt><dd><input type="text" name="enumeration.description" class="textInput required" value="${enumeration.description}" /></dd>
		</dl>
				<input type="hidden" name="enumeration.id" value="${enumeration.id}"/>
				<input type="hidden" name="enumeration.enumerationType" value="${enumeration.enumerationType}"/>
				<input type="hidden" name="enumeration.version" value="${enumeration.version}">
				<input type="hidden" name="enumeration.creator.id" value="${enumeration.creator.id}">

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
					<table class="list nowrap" width="100%" itemDetail="enumeration.enumerationValues">
						<thead>
							<tr>
								<th type="text" class=" required" name="valueName" size="12"><hi:text key="枚举值名称" entity="EnumerationValue"/></th>
								<th type="text"class=" required"  name="displayRef" size="12"><hi:text key="显示信息" entity="EnumerationValue"/></th>
								<th type="text" class=" required" name="description" size="12"><hi:text key="描述" entity="EnumerationValue"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="enumerationValue" items="${enumeration.enumerationValues}"  varStatus="enumerationValueIndex">
							<tr>
							<input type="hidden" name="enumeration.enumerationValues[${enumerationValueIndex.index}].version" value="${enumerationValue.version}"/>
							<input type="hidden" name="enumeration.enumerationValues[${enumerationValueIndex.index}].id" value="${enumerationValue.id}"/>
								<td>
									<input type="text" class=" required" name="enumeration.enumerationValues[${enumerationValueIndex.index}].valueName" value="${enumerationValue.valueName}" size="12"/>
								</td>
								<td>
									<input type="text" class=" required" name="enumeration.enumerationValues[${enumerationValueIndex.index}].displayRef" value="${enumerationValue.valueName}" size="12"/>
								</td>
								<td>
									<input type="text" class=" required" name="enumeration.enumerationValues[${enumerationValueIndex.index}].description" value="${enumerationValue.displayRef}" size="12"/>
								</td>
								<td><a href="<hi:url>enumerationValueRemove.action?ajax=1&enumerationValue.id=${enumerationValue.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
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
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  
</div>
</form>