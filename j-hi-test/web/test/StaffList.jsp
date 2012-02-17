<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="staffList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="staffList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="员工编号" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.f_useNum" value="${pageInfo.f_useNum}"/>
			</li>	  
			<li>
				<label><hi:text key="籍贯" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.f_nativePlace" value="${pageInfo.f_nativePlace}"/>
			</li>	  
			<li>
				<label><hi:text key="学历" entity="Staff"/>:</label>
				<hi:search name="pageInfo.f_degree" emu="degree"/>
			</li>	  
			<li>
				<label><hi:text key="专业" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.f_specialty" value="${pageInfo.f_specialty}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="入场时间" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.f_jobDate" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_jobDate}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_jobDate_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_jobDate01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_jobDate01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_jobDate01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="婚姻状态" entity="Staff"/>:</label>
				<hi:search name="pageInfo.f_marry" emu="marriedStatus"/>
			</li>	  
			<li>
				<label><hi:text key="个人爱好" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.f_interest" value="${pageInfo.f_interest}"/>
			</li>	  
			<li>
				<label><hi:text key="工作岗位" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.jobPosition.f_name" value="${pageInfo.jobPosition.f_name}"/>
			</li>	  
			<li>
				<label><hi:text key="工作状态" entity="Staff"/>:</label>
				<hi:search name="pageInfo.f_employedStatus" emu="employedStatus"/>
			</li>	  
			<li>
				<label><hi:text key="民族" entity="Staff"/>:</label>
				<input type="text" name="pageInfo.nation.f_chineseName" value="${pageInfo.nation.f_chineseName}"/>
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
		<ul class="toolBar">
		<c:choose>
			<c:when test="${empty lookup}">
				<authz:authorize ifAnyGranted="STAFF_SAVE"><li><a class="add" href="<hi:url>staffEdit.action?staff.id=-1</hi:url>" target="navTab" rel="staff"><span><hi:text key="新建" parameterLanguageKeys="staff"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="STAFF_DEL"><li><a class="delete" href="<hi:url>staffRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', useNum:'',nativePlace:'',degree:'',specialty:'',jobDate:'',marry:'',interest:'',name:'',photo:'',employedStatus:'',chineseName:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="useNum" class="${pageInfo.sorterName eq 'useNum' ? pageInfo.sorterDirection : ''}"><hi:text key="员工编号" entity="Staff"/></th>
				<th orderField="nativePlace" class="${pageInfo.sorterName eq 'nativePlace' ? pageInfo.sorterDirection : ''}"><hi:text key="籍贯" entity="Staff"/></th>
				<th orderField="degree" class="${pageInfo.sorterName eq 'degree' ? pageInfo.sorterDirection : ''}"><hi:text key="学历" entity="Staff"/></th>
				<th orderField="specialty" class="${pageInfo.sorterName eq 'specialty' ? pageInfo.sorterDirection : ''}"><hi:text key="专业" entity="Staff"/></th>
				<th orderField="jobDate" class="${pageInfo.sorterName eq 'jobDate' ? pageInfo.sorterDirection : ''}"><hi:text key="入场时间" entity="Staff"/></th>
				<th orderField="marry" class="${pageInfo.sorterName eq 'marry' ? pageInfo.sorterDirection : ''}"><hi:text key="婚姻状态" entity="Staff"/></th>
				<th orderField="interest" class="${pageInfo.sorterName eq 'interest' ? pageInfo.sorterDirection : ''}"><hi:text key="个人爱好" entity="Staff"/></th>
				<th orderField="jobPosition.name" class="${pageInfo.sorterName eq 'jobPosition.name' ? pageInfo.sorterDirection : ''}"><hi:text key="工作岗位" entity="Staff"/></th>
				<th orderField="photo_attachment.fileName" class="${pageInfo.sorterName eq 'photo_attachment.fileName' ? pageInfo.sorterDirection : ''}"><hi:text key="员工照片" entity="Staff"/></th>
				<th orderField="employedStatus" class="${pageInfo.sorterName eq 'employedStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="工作状态" entity="Staff"/></th>
				<th orderField="nation.chineseName" class="${pageInfo.sorterName eq 'nation.chineseName' ? pageInfo.sorterDirection : ''}"><hi:text key="民族" entity="Staff"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${staffs}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.useNum}</td>
				    <td>${item.nativePlace}</td>
				    <td><hi:select emu="degree" name="staffs[${s.index}].degree" isLabel="true"/></td>
				    <td>${item.specialty}</td>
				    <td><fmt:formatDate value="${item.jobDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><hi:select emu="marriedStatus" name="staffs[${s.index}].marry" isLabel="true"/></td>
				    <td>${item.interest}</td>
				    <td><authz:authorize ifAnyGranted="JOBPOSITION_VIEW"><a href="<hi:url>jobPositionView.action?jobPosition.id=${item.jobPosition.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.jobPosition.name}
					<authz:authorize ifAnyGranted="JOBPOSITION_VIEW"></a></authz:authorize>
					</td>
				    <td>
						<c:if test="${not empty item.photo_attachment}">
				   		<a href="<hi:url>attachmentView.action?attachment.id=${item.photo_attachment.id}</hi:url>" target="_blank">${item.photo_attachment.fileNameImage}</a>
				     	</c:if>
				   </td>		    
				    <td><hi:select emu="employedStatus" name="staffs[${s.index}].employedStatus" isLabel="true"/></td>
				    <td><authz:authorize ifAnyGranted="NATION_VIEW"><a href="<hi:url>nationView.action?nation.id=${item.nation.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.nation.chineseName}
					<authz:authorize ifAnyGranted="NATION_VIEW"></a></authz:authorize>
					</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="STAFF_DEL">
				      <a class="btnDel" href="<hi:url>staffRemove.action?ajax=1&staff.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="staff"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="STAFF_VIEW">
				      <a class="btnView" href="<hi:url>staffView.action?staff.id=${item.id}</hi:url>" target="navTab" rel="staff" title="<hi:text key="查看" parameterLanguageKeys="staff"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="STAFF_SAVE">
				      <a class="btnEdit" href="<hi:url>staffEdit.action?staff.id=${item.id}</hi:url>" target="navTab" rel="staff" title="<hi:text key="编辑" parameterLanguageKeys="staff"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', useNum:'${item.useNum}',nativePlace:'${item.nativePlace}',degree:'<hi:select emu="degree" name="staffs[${s.index}].degree" isLabel="true"/>',specialty:'${item.specialty}',jobDate:'${item.jobDate}',marry:'<hi:select emu="marriedStatus" name="staffs[${s.index}].marry" isLabel="true"/>',interest:'${item.interest}',name:'${item.jobPosition.name}',photo:'${item.photo_attachment.fileName}',employedStatus:'<hi:select emu="employedStatus" name="staffs[${s.index}].employedStatus" isLabel="true"/>',chineseName:'${item.nation.chineseName}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
