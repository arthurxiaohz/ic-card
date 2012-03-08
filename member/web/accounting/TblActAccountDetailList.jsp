<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblActAccountDetailList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblActAccountDetailList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="账号" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.actAccount.f_accountNo" value="${pageInfo.actAccount.f_accountNo}"/>
			</li>	  
			<li>
				<label><hi:text key="账户分类" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.actAccount.f_accountCatalog" value="${pageInfo.actAccount.f_accountCatalog}"/>
			</li>	  
			<li>
				<label><hi:text key="开户方" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.actAccount.f_accountParty" value="${pageInfo.actAccount.f_accountParty}"/>
			</li>	  
			<li>
				<label><hi:text key="开户名称" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.actAccount.f_accountName" value="${pageInfo.actAccount.f_accountName}"/>
			</li>	  
			<li>
				<label><hi:text key="凭证类型" entity="TblActAccountDetail"/>:</label>
				<hi:search name="pageInfo.f_voucherType" emu="voucherType"/>
			</li>	  
			<li>
				<label><hi:text key="凭证号" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.f_voucherNo" value="${pageInfo.f_voucherNo}"/>
			</li>	  
			<li>
				<label><hi:text key="金额" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.f_amount" value="${pageInfo.f_amount}"/>
			</li>	  
			<li>
				<label><hi:text key="借贷方向" entity="TblActAccountDetail"/>:</label>
				<hi:search name="pageInfo.f_debitOrCredit" emu="debitOrCredit"/>
			</li>	  
			<li>
				<label><hi:text key="余额" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.f_balance" value="${pageInfo.f_balance}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="截止日期" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.f_expiredDate" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_expiredDate}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_expiredDate_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_expiredDate01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_expiredDate01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_expiredDate01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="结算状态" entity="TblActAccountDetail"/>:</label>
				<hi:search name="pageInfo.f_settleStatus" emu="settleStatus"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblActAccountDetail"/>:</label>
				<input type="text" name="pageInfo.f_createdDateTime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDateTime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDateTime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDateTime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDateTime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDateTime01_op" value="&lt;=">
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
				<authz:authorize ifAnyGranted="TBLACTACCOUNTDETAIL_SAVE"><li><a class="add" href="<hi:url>tblActAccountDetailEdit.action?tblActAccountDetail.id=-1</hi:url>" target="navTab" rel="tblActAccountDetail"><span><hi:text key="新建" parameterLanguageKeys="账户明细"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLACTACCOUNTDETAIL_DEL"><li><a class="delete" href="<hi:url>tblActAccountDetailRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', accountNo:'',accountCatalog:'',accountPartyType:'',accountParty:'',accountName:'',voucherType:'',voucherNo:'',amount:'',debitOrCredit:'',balance:'',remark:'',expiredDate:'',settleStatus:'',createdDateTime:'',lastUpdatedDatetime:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="actAccount.accountNo" class="${pageInfo.sorterName eq 'actAccount.accountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="账号" entity="TblActAccountDetail"/></th>
				<th orderField="actAccount.accountCatalog" class="${pageInfo.sorterName eq 'actAccount.accountCatalog' ? pageInfo.sorterDirection : ''}"><hi:text key="账户分类" entity="TblActAccountDetail"/></th>
				<th orderField="actAccount.accountPartyType" class="${pageInfo.sorterName eq 'actAccount.accountPartyType' ? pageInfo.sorterDirection : ''}"><hi:text key="开户方类型" entity="TblActAccountDetail"/></th>
				<th orderField="actAccount.accountParty" class="${pageInfo.sorterName eq 'actAccount.accountParty' ? pageInfo.sorterDirection : ''}"><hi:text key="开户方" entity="TblActAccountDetail"/></th>
				<th orderField="actAccount.accountName" class="${pageInfo.sorterName eq 'actAccount.accountName' ? pageInfo.sorterDirection : ''}"><hi:text key="开户名称" entity="TblActAccountDetail"/></th>
				<th orderField="voucherType" class="${pageInfo.sorterName eq 'voucherType' ? pageInfo.sorterDirection : ''}"><hi:text key="凭证类型" entity="TblActAccountDetail"/></th>
				<th orderField="voucherNo" class="${pageInfo.sorterName eq 'voucherNo' ? pageInfo.sorterDirection : ''}"><hi:text key="凭证号" entity="TblActAccountDetail"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="金额" entity="TblActAccountDetail"/></th>
				<th orderField="debitOrCredit" class="${pageInfo.sorterName eq 'debitOrCredit' ? pageInfo.sorterDirection : ''}"><hi:text key="借贷方向" entity="TblActAccountDetail"/></th>
				<th orderField="balance" class="${pageInfo.sorterName eq 'balance' ? pageInfo.sorterDirection : ''}"><hi:text key="余额" entity="TblActAccountDetail"/></th>
				<th orderField="remark" class="${pageInfo.sorterName eq 'remark' ? pageInfo.sorterDirection : ''}"><hi:text key="备注" entity="TblActAccountDetail"/></th>
				<th orderField="expiredDate" class="${pageInfo.sorterName eq 'expiredDate' ? pageInfo.sorterDirection : ''}"><hi:text key="截止日期" entity="TblActAccountDetail"/></th>
				<th orderField="settleStatus" class="${pageInfo.sorterName eq 'settleStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="结算状态" entity="TblActAccountDetail"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblActAccountDetail"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblActAccountDetail"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblActAccountDetails}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td><authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"><a href="<hi:url>actAccountView.action?actAccount.id=${item.actAccount.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.actAccount.accountNo}
					<authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"><a href="<hi:url>actAccountView.action?actAccount.id=${item.actAccount.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
				    <hi:select emu="accountCatalog" name="tblActAccountDetails[${s.index}].actAccount.accountCatalog" isLabel="true"/>
					<authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"><a href="<hi:url>actAccountView.action?actAccount.id=${item.actAccount.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
				    <hi:select emu="accountPartyType" name="tblActAccountDetails[${s.index}].actAccount.accountPartyType" isLabel="true"/>
					<authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"><a href="<hi:url>actAccountView.action?actAccount.id=${item.actAccount.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.actAccount.accountParty}
					<authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"><a href="<hi:url>actAccountView.action?actAccount.id=${item.actAccount.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.actAccount.accountName}
					<authz:authorize ifAnyGranted="ACTACCOUNT_VIEW"></a></authz:authorize>
					</td>
				    <td><hi:select emu="voucherType" name="tblActAccountDetails[${s.index}].voucherType" isLabel="true"/></td>
				    <td>${item.voucherNo}</td>
				    <td>${item.amount}</td>
				    <td><hi:select emu="debitOrCredit" name="tblActAccountDetails[${s.index}].debitOrCredit" isLabel="true"/></td>
				    <td>${item.balance}</td>
				    <td>${item.remark}</td>
					<td><fmt:formatDate value="${item.expiredDate}" pattern="yyyy-MM-dd"/></td>
				    <td><hi:select emu="settleStatus" name="tblActAccountDetails[${s.index}].settleStatus" isLabel="true"/></td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLACTACCOUNTDETAIL_DEL">
				      <a class="btnDel" href="<hi:url>tblActAccountDetailRemove.action?ajax=1&tblActAccountDetail.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="账户明细"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLACTACCOUNTDETAIL_VIEW">
				      <a class="btnView" href="<hi:url>tblActAccountDetailView.action?tblActAccountDetail.id=${item.id}</hi:url>" target="navTab" rel="tblActAccountDetail" title="<hi:text key="查看" parameterLanguageKeys="账户明细"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLACTACCOUNTDETAIL_SAVE">
				      <a class="btnEdit" href="<hi:url>tblActAccountDetailEdit.action?tblActAccountDetail.id=${item.id}</hi:url>" target="navTab" rel="tblActAccountDetail" title="<hi:text key="编辑" parameterLanguageKeys="账户明细"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', accountNo:'${item.actAccount.accountNo}',accountCatalog:'<hi:select emu="accountCatalog" name="tblActAccountDetails[${s.index}].actAccount.accountCatalog" isLabel="true"/>',accountPartyType:'<hi:select emu="accountPartyType" name="tblActAccountDetails[${s.index}].actAccount.accountPartyType" isLabel="true"/>',accountParty:'${item.actAccount.accountParty}',accountName:'${item.actAccount.accountName}',voucherType:'<hi:select emu="voucherType" name="tblActAccountDetails[${s.index}].voucherType" isLabel="true"/>',voucherNo:'${item.voucherNo}',amount:'${item.amount}',debitOrCredit:'<hi:select emu="debitOrCredit" name="tblActAccountDetails[${s.index}].debitOrCredit" isLabel="true"/>',balance:'${item.balance}',remark:'${item.remark}',expiredDate:'${item.expiredDate}',settleStatus:'<hi:select emu="settleStatus" name="tblActAccountDetails[${s.index}].settleStatus" isLabel="true"/>',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
