<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="excelReportDesignList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="excelReportDesignList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="报表名称" entity="ExcelReportDesign"/>:</label>
				<input type="text" name="pageInfo.f_reportName" value="${pageInfo.f_reportName}"/>
			</li>	  
			<li>
				<label><hi:text key="报表编号" entity="ExcelReportDesign"/>:</label>
				<input type="text" name="pageInfo.f_reportNum" value="${pageInfo.f_reportNum}"/>
			</li>	 
		</ul>
		<div class="subBar">
			<div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="查询"/></button></div></div>
		</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<c:if test="${empty lookup}">
		<ul class="toolBar">
		    <li><a class="add" href="<hi:url>excelReportDesignEdit.action?excelReportDesign.id=-1</hi:url>" target="navTab" rel="ExcelReportDesign"><span><hi:text key="新建" parameterLanguageKeys="报表设计"/></span></a></li>
			<li><a class="delete" href="<hi:url>excelReportDesignRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li>
		</ul>
		</c:if>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="reportName" class="${pageInfo.sorterName eq 'reportName' ? pageInfo.sorterDirection : ''}"><hi:text key="报表名称" entity="ExcelReportDesign"/></th>
				<th orderField="reportNum" class="${pageInfo.sorterName eq 'reportNum' ? pageInfo.sorterDirection : ''}"><hi:text key="报表编号" entity="ExcelReportDesign"/></th>
				<th orderField="createDate" class="${pageInfo.sorterName eq 'createDate' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="ExcelReportDesign"/></th>
				<th orderField="enabled" class="${pageInfo.sorterName eq 'enabled' ? pageInfo.sorterDirection : ''}"><hi:text key="激活" entity="ExcelReportDesign"/></th>
				<th orderField="description" class="${pageInfo.sorterName eq 'description' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="ExcelReportDesign"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${excelReportDesigns}" varStatus="excelReportDesign">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.reportName}</td>
				    <td>${item.reportNum}</td>
				    <td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd"/></td>
				    <td><hi:select emu="yesNo" name="excelReportDesigns[${excelReportDesign.index}].enabled" isLabel="true"/></td>
				    <td>${item.description}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				      <a class="btnDel" href="<hi:url>excelReportDesignRemove.action?ajax=1&excelReportDesign.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="Excel报表设计"/>"><hi:text key="删除"/></a>
				      <a class="btnView" href="<hi:url>excelReportDesignView.action?excelReportDesign.id=${item.id}</hi:url>" target="navTab" rel="ExcelReportDesign" title="<hi:text key="查看" parameterLanguageKeys="Excel报表设计"/>"><hi:text key="查看"/></a>
				      <a class="btnEdit" href="<hi:url>excelReportDesignEdit.action?excelReportDesign.id=${item.id}</hi:url>" target="navTab" rel="ExcelReportDesign" title="<hi:text key="编辑" parameterLanguageKeys="Excel报表设计"/>"><hi:text key="编辑"/></a>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', reportName:'${item.reportName}',createDate:'${item.createDate}',enabled:'${item.enabled}',description:'${item.description}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
	<div class="panelBar">
		<div class="pages">
			<span><hi:text key="每页"/></span>
			<c:set var="pageSizeList" value="${fn:split('10|20|50|100', '|')}"/>  
			<select name="pageInfo.pageSize" onchange="dwzPageBreak({targetType:'${targetType}', numPerPage:this.value})">
				<c:forEach var="item" items="${pageSizeList}">
				<option value="${item}" ${item eq pageInfo.pageSize ? 'selected="selected"' : ''}>${item}</option>
				</c:forEach>
			</select>
			<span><hi:text key="条"/>，<hi:text key="共"/>${pageInfo.totalRecords}<hi:text key="条"/></span>
		</div>
		<div class="pagination" targetType="${targetType}" totalCount="${pageInfo.totalRecords}" numPerPage="${pageInfo.pageSize}" pageNumShown="${pageInfo.middlePageNum*2}" currentPage="${pageInfo.currentPage}"></div>
	</div>
</div>	