<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlSettleApplyList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlSettleApplyList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="商户号" entity="TblStlSettleApply"/>:</label>
				<input type="text" name="pageInfo.tblMchtInfo.f_mchtNo" value="${pageInfo.tblMchtInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户名称" entity="TblStlSettleApply"/>:</label>
				<input type="text" name="pageInfo.tblMchtInfo.f_mchtName" value="${pageInfo.tblMchtInfo.f_mchtName}"/>
			</li>	  
			<li>
				<label><hi:text key="状态" entity="TblStlSettleApply"/>:</label>
				<hi:search name="pageInfo.f_settleApplyStatus" emu="settleApplyStatus"/>
			</li>	  
			<li>
				<label><hi:text key="结算日" entity="TblStlSettleApply"/>:</label>
				<input type="text" name="pageInfo.tblStlSettleBatch.f_settleDate" value="${pageInfo.tblStlSettleBatch.f_settleDate}"/>
			</li>	  
			<li>
				<label><hi:text key="结算批次号" entity="TblStlSettleApply"/>:</label>
				<input type="text" name="pageInfo.tblStlSettleBatch.f_settleBatchNo" value="${pageInfo.tblStlSettleBatch.f_settleBatchNo}"/>
			</li>	  
			<li>

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
				<authz:authorize ifAnyGranted="TBLSTLSETTLEAPPLY_SAVE"><li><a class="add" href="<hi:url>tblStlSettleApplyEdit.action?tblStlSettleApply.id=-1</hi:url>" target="navTab" rel="tblStlSettleApply"><span><hi:text key="新建" parameterLanguageKeys="结算申请"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLSETTLEAPPLY_DEL"><li><a class="delete" href="<hi:url>tblStlSettleApplyRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', mchtNo:'',mchtName:'',availableBalance:'',amount:'',settleApplyStatus:'',remark:'',settleDate:'',settleBatchNo:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>
		</ul>
		<authz:authorize ifAnyGranted="SETTLE"><li><a class="btnAttach" href="<hi:url>settle.action?ajax=1</hi:url>" target="navTabTodo" title="<hi:text key="确实要结算吗?"/>"><span>结算</span></a></li></authz:authorize>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="28"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="tblMchtInfo.mchtNo" class="${pageInfo.sorterName eq 'tblMchtInfo.mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblStlSettleApply"/></th>
				<th orderField="tblMchtInfo.mchtName" class="${pageInfo.sorterName eq 'tblMchtInfo.mchtName' ? pageInfo.sorterDirection : ''}"><hi:text key="商户名称" entity="TblStlSettleApply"/></th>
				<th orderField="availableBalance" class="${pageInfo.sorterName eq 'availableBalance' ? pageInfo.sorterDirection : ''}"><hi:text key="账户可用余额" entity="TblStlSettleApply"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="申请结算金额" entity="TblStlSettleApply"/></th>
				<th orderField="settleApplyStatus" class="${pageInfo.sorterName eq 'settleApplyStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="状态" entity="TblStlSettleApply"/></th>
				<th orderField="remark" class="${pageInfo.sorterName eq 'remark' ? pageInfo.sorterDirection : ''}"><hi:text key="备注" entity="TblStlSettleApply"/></th>
				<th orderField="tblStlSettleBatch.settleDate" class="${pageInfo.sorterName eq 'tblStlSettleBatch.settleDate' ? pageInfo.sorterDirection : ''}"><hi:text key="结算日" entity="TblStlSettleApply"/></th>
				<th orderField="tblStlSettleBatch.settleBatchNo" class="${pageInfo.sorterName eq 'tblStlSettleBatch.settleBatchNo' ? pageInfo.sorterDirection : ''}"><hi:text key="结算批次号" entity="TblStlSettleApply"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlSettleApplys}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.mchtNo}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.mchtName}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td>${item.availableBalance}</td>
				    <td>${item.amount}</td>
				    <td><hi:select emu="settleApplyStatus" name="tblStlSettleApplys[${s.index}].settleApplyStatus" isLabel="true"/></td>
				    <td>${item.remark}</td>
				    <td><authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_VIEW"><a href="<hi:url>tblStlSettleBatchView.action?tblStlSettleBatch.id=${item.tblStlSettleBatch.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblStlSettleBatch.settleDate}
					<authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_VIEW"><a href="<hi:url>tblStlSettleBatchView.action?tblStlSettleBatch.id=${item.tblStlSettleBatch.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblStlSettleBatch.settleBatchNo}
					<authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_VIEW"></a></authz:authorize>
					</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEAPPLY_DEL">
				      <a class="btnDel" href="<hi:url>tblStlSettleApplyRemove.action?ajax=1&tblStlSettleApply.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="结算申请"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEAPPLY_VIEW">
				      <a class="btnView" href="<hi:url>tblStlSettleApplyView.action?tblStlSettleApply.id=${item.id}</hi:url>" target="navTab" rel="tblStlSettleApply" title="<hi:text key="查看" parameterLanguageKeys="结算申请"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEAPPLY_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlSettleApplyEdit.action?tblStlSettleApply.id=${item.id}</hi:url>" target="navTab" rel="tblStlSettleApply" title="<hi:text key="编辑" parameterLanguageKeys="结算申请"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', mchtNo:'${item.tblMchtInfo.mchtNo}',mchtName:'${item.tblMchtInfo.mchtName}',availableBalance:'${item.availableBalance}',amount:'${item.amount}',settleApplyStatus:'<hi:select emu="settleApplyStatus" name="tblStlSettleApplys[${s.index}].settleApplyStatus" isLabel="true"/>',remark:'${item.remark}',settleDate:'${item.tblStlSettleBatch.settleDate}',settleBatchNo:'${item.tblStlSettleBatch.settleBatchNo}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
