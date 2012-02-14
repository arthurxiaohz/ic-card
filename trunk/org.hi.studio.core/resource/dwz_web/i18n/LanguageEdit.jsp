<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
 
<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="多语言信息"/></h2>
<form action="languageSave.action?navTabId=languageList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="Key值" entity="Language"/>：</dt><dd><input type="text" name="language.keyStr"   <c:if test="${language.isSystem==1}" > readonly="true" </c:if> class="textInput required" value="${language.keyStr}" /></dd>
		</dl>
	 
		<dl> 
			<dt><hi:text key="实体" entity="Language"/>：</dt><dd><input type="text" name="language.entity"  <c:if test="${language.isSystem==1}" > readonly="true" </c:if> class="textInput" value="${language.entity}" /></dd>
		</dl>
		  
		
				<input type="hidden" name="language.id" value="${language.id}"/>
				<input type="hidden" name="language.creator.id" value="${language.creator.id}"/>
				<input type="hidden" name="language.version" value="${language.version}"/>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="多语言值"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:150px;">
				<div>
					<table class="list nowrap" width="100%" >
						<thead>
							<tr>
								<th type="text" class="" name="languageCode" size="12"><hi:text key="语言代码" entity="LanguageStr"/></th>
								<th type="text" class="" name="value" size="12"><hi:text key="值" entity="LanguageStr"/></th>
								 
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${language.languageStrs}"  varStatus="s">
							<tr>
							<input type="hidden" name="language.languageStrs[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="language.languageStrs[${s.index}].version" value="${item.version}"/>
								<td>
									<input type="text" class=" required" name="language.languageStrs[${s.index}].languageCode" value="${item.languageCode}" readonly="true" size="12"/>
								</td>
								<td>
									<input type="text" class=" required" name="language.languageStrs[${s.index}].value" value="${item.value}" size="12"/>
								</td>
								
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
