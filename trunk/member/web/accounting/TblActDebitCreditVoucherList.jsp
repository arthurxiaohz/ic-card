<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblActDebitCreditVoucherList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblActDebitCreditVoucherList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="凭证号" entity="TblActDebitCreditVoucher"/>:</label>
				<input type="text" name="pageInfo.f_voucherNo" value="${pageInfo.f_voucherNo}"/>
			</li>	  
			<li>
				<label><hi:text key="账号" entity="TblActDebitCreditVoucher"/>:</label>
				<input type="text" name="pageInfo.actAccount.f_accountNo" value="${pageInfo.actAccount.f_accountNo}"/>
			</li>	   
			<li>
				<label><hi:text key="借贷方向" entity="TblActDebitCreditVoucher"/>:</label>
				<hi:search name="pageInfo.f_debitOrCredit" emu="debitOrCredit"/>
			</li>	  
			<li>
				<label><hi:text key="业务类型" entity="TblActDebitCreditVoucher"/>:</label>
				<hi:search name="pageInfo.f_bizType" emu="bizType"/>
			</li>	  
			<li>
				<label><hi:text key="业务流水" entity="TblActDebitCreditVoucher"/>:</label>
				<input type="text" name="pageInfo.f_bizLogId" value="${pageInfo.f_bizLogId}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblActDebitCreditVoucher"/>:</label>
				<input type="text" name="pageInfo.f_createdDateTime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDateTime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDateTime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDateTime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDateTime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDateTime01_op" value="&lt;=">
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
				<authz:authorize ifAnyGranted="TBLACTDEBITCREDITVOUCHER_SAVE"><li><a class="add" href="<hi:url>tblActDebitCreditVoucherEdit.action?tblActDebitCreditVoucher.id=-1</hi:url>" target="navTab" rel="tblActDebitCreditVoucher"><span><hi:text key="新建" parameterLanguageKeys="借贷凭证"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLACTDEBITCREDITVOUCHER_DEL"><li><a class="delete" href="<hi:url>tblActDebitCreditVoucherRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', voucherNo:'',accountNo:'',amount:'',debitOrCredit:'',bizType:'',bizLogId:'',remark:'',createdDateTime:'',lastUpdatedDatetime:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="voucherNo" class="${pageInfo.sorterName eq 'voucherNo' ? pageInfo.sorterDirection : ''}"><hi:text key="凭证号" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="actAccount.accountNo" class="${pageInfo.sorterName eq 'actAccount.accountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="账号" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="金额" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="debitOrCredit" class="${pageInfo.sorterName eq 'debitOrCredit' ? pageInfo.sorterDirection : ''}"><hi:text key="借贷方向" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="bizType" class="${pageInfo.sorterName eq 'bizType' ? pageInfo.sorterDirection : ''}"><hi:text key="业务类型" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="bizLogId" class="${pageInfo.sorterName eq 'bizLogId' ? pageInfo.sorterDirection : ''}"><hi:text key="业务流水" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="remark" class="${pageInfo.sorterName eq 'remark' ? pageInfo.sorterDirection : ''}"><hi:text key="备注" entity="TblActDebitCreditVoucher"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblActDebitCreditVoucher"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblActDebitCreditVouchers}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.voucherNo}</td>
				    <td><authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"><a href="<hi:url>actAccountView.action?actAccount.id=${item.actAccount.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.actAccount.accountNo}
					<authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"></a></authz:authorize>
					</td>
				    <td>${item.amount/100}</td>
				    <td><hi:select emu="debitOrCredit" name="tblActDebitCreditVouchers[${s.index}].debitOrCredit" isLabel="true"/></td>
				    <td><hi:select emu="bizType" name="tblActDebitCreditVouchers[${s.index}].bizType" isLabel="true"/></td>
				    <td>${item.bizLogId}</td>
				    <td>${item.remark}</td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLACTDEBITCREDITVOUCHER_DEL">
				      <a class="btnDel" href="<hi:url>tblActDebitCreditVoucherRemove.action?ajax=1&tblActDebitCreditVoucher.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="借贷凭证"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLACTDEBITCREDITVOUCHER_VIEW">
				      <a class="btnView" href="<hi:url>tblActDebitCreditVoucherView.action?tblActDebitCreditVoucher.id=${item.id}</hi:url>" target="navTab" rel="tblActDebitCreditVoucher" title="<hi:text key="查看" parameterLanguageKeys="借贷凭证"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLACTDEBITCREDITVOUCHER_SAVE">
				      <a class="btnEdit" href="<hi:url>tblActDebitCreditVoucherEdit.action?tblActDebitCreditVoucher.id=${item.id}</hi:url>" target="navTab" rel="tblActDebitCreditVoucher" title="<hi:text key="编辑" parameterLanguageKeys="借贷凭证"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', voucherNo:'${item.voucherNo}',accountNo:'${item.actAccount.accountNo}',amount:'${item.amount}',debitOrCredit:'<hi:select emu="debitOrCredit" name="tblActDebitCreditVouchers[${s.index}].debitOrCredit" isLabel="true"/>',bizType:'<hi:select emu="bizType" name="tblActDebitCreditVouchers[${s.index}].bizType" isLabel="true"/>',bizLogId:'${item.bizLogId}',remark:'${item.remark}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
