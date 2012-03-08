<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbCouponRuleList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbCouponRuleList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="帐号" entity="TblMbCouponRule"/>:</label>
				<input type="text" name="pageInfo.tblMbInfo.f_userName" value="${pageInfo.tblMbInfo.f_userName}"/>
			</li>	  
			<li>
				<label><hi:text key="姓名" entity="TblMbCouponRule"/>:</label>
				<input type="text" name="pageInfo.tblMbInfo.f_fullName" value="${pageInfo.tblMbInfo.f_fullName}"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblMbCouponRule"/>:</label>
				<input type="text" name="pageInfo.tblMchtInfo.f_mchtNo" value="${pageInfo.tblMchtInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户名称" entity="TblMbCouponRule"/>:</label>
				<input type="text" name="pageInfo.tblMchtInfo.f_mchtName" value="${pageInfo.tblMchtInfo.f_mchtName}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="有效期开始时间" entity="TblMbCouponRule"/>:</label>
				<input type="text" name="pageInfo.f_startDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_startDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_startDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_startDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_startDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_startDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="有效期结束时间" entity="TblMbCouponRule"/>:</label>
				<input type="text" name="pageInfo.f_endDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_endDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_endDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_endDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_endDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_endDatetime01_op" value="&lt;=">
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
				<authz:authorize ifAnyGranted="TBLMBCOUPONRULE_SAVE"><li><a class="add" href="<hi:url>tblMbCouponRuleEdit.action?tblMbCouponRule.id=-1</hi:url>" target="navTab" rel="tblMbCouponRule"><span><hi:text key="新建" parameterLanguageKeys="会员优惠券规则"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBCOUPONRULE_DEL"><li><a class="delete" href="<hi:url>tblMbCouponRuleRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', userName:'',fullName:'',mchtNo:'',mchtName:'',mchtType:'',merchandiseCategory:'',merchandiseNo:'',couponType:'',amount:'',startDatetime:'',endDatetime:'',createdDateTime:'',lastUpdatedDatetime:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="28"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="tblMbInfo.userName" class="${pageInfo.sorterName eq 'tblMbInfo.userName' ? pageInfo.sorterDirection : ''}"><hi:text key="帐号" entity="TblMbCouponRule"/></th>
				<th orderField="tblMbInfo.fullName" class="${pageInfo.sorterName eq 'tblMbInfo.fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="姓名" entity="TblMbCouponRule"/></th>
				<th orderField="tblMchtInfo.mchtNo" class="${pageInfo.sorterName eq 'tblMchtInfo.mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblMbCouponRule"/></th>
				<th orderField="tblMchtInfo.mchtName" class="${pageInfo.sorterName eq 'tblMchtInfo.mchtName' ? pageInfo.sorterDirection : ''}"><hi:text key="商户名称" entity="TblMbCouponRule"/></th>
				<th orderField="mchtType" class="${pageInfo.sorterName eq 'mchtType' ? pageInfo.sorterDirection : ''}"><hi:text key="商户类别" entity="TblMbCouponRule"/></th>
				<th orderField="merchandiseCategory" class="${pageInfo.sorterName eq 'merchandiseCategory' ? pageInfo.sorterDirection : ''}"><hi:text key="商品类别" entity="TblMbCouponRule"/></th>
				<th orderField="merchandiseNo" class="${pageInfo.sorterName eq 'merchandiseNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商品编号" entity="TblMbCouponRule"/></th>
				<th orderField="couponType" class="${pageInfo.sorterName eq 'couponType' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券类型" entity="TblMbCouponRule"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券金额" entity="TblMbCouponRule"/></th>
				<th orderField="startDatetime" class="${pageInfo.sorterName eq 'startDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="有效期开始时间" entity="TblMbCouponRule"/></th>
				<th orderField="endDatetime" class="${pageInfo.sorterName eq 'endDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="有效期结束时间" entity="TblMbCouponRule"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbCouponRule"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMbCouponRule"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbCouponRules}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td><authz:authorize ifAnyGranted="HIUSER_VIEW"><a href="<hi:url>hiUserView.action?hiUser.id=${item.tblMbInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMbInfo.userName}
					<authz:authorize ifAnyGranted="HIUSER_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="HIUSER_VIEW"><a href="<hi:url>hiUserView.action?hiUser.id=${item.tblMbInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMbInfo.fullName}
					<authz:authorize ifAnyGranted="HIUSER_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.mchtNo}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.mchtName}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><hi:select emu="mchtType" name="tblMbCouponRules[${s.index}].mchtType" isLabel="true"/></td>
				    <td><hi:select emu="merchandiseCategory" name="tblMbCouponRules[${s.index}].merchandiseCategory" isLabel="true"/></td>
				    <td>${item.merchandiseNo}</td>
				    <td><hi:select emu="couponType" name="tblMbCouponRules[${s.index}].couponType" isLabel="true"/></td>
				    <td>${item.amount}</td>
				    <td><fmt:formatDate value="${item.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBCOUPONRULE_DEL">
				      <a class="btnDel" href="<hi:url>tblMbCouponRuleRemove.action?ajax=1&tblMbCouponRule.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="会员优惠券规则"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBCOUPONRULE_VIEW">
				      <a class="btnView" href="<hi:url>tblMbCouponRuleView.action?tblMbCouponRule.id=${item.id}</hi:url>" target="navTab" rel="tblMbCouponRule" title="<hi:text key="查看" parameterLanguageKeys="会员优惠券规则"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBCOUPONRULE_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbCouponRuleEdit.action?tblMbCouponRule.id=${item.id}</hi:url>" target="navTab" rel="tblMbCouponRule" title="<hi:text key="编辑" parameterLanguageKeys="会员优惠券规则"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', userName:'${item.tblMbInfo.userName}',fullName:'${item.tblMbInfo.fullName}',mchtNo:'${item.tblMchtInfo.mchtNo}',mchtName:'${item.tblMchtInfo.mchtName}',mchtType:'<hi:select emu="mchtType" name="tblMbCouponRules[${s.index}].mchtType" isLabel="true"/>',merchandiseCategory:'<hi:select emu="merchandiseCategory" name="tblMbCouponRules[${s.index}].merchandiseCategory" isLabel="true"/>',merchandiseNo:'${item.merchandiseNo}',couponType:'<hi:select emu="couponType" name="tblMbCouponRules[${s.index}].couponType" isLabel="true"/>',amount:'${item.amount}',startDatetime:'${item.startDatetime}',endDatetime:'${item.endDatetime}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
