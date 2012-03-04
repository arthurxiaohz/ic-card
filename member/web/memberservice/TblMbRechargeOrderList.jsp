<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbRechargeOrderList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbRechargeOrderList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="平台交易流水号" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_plTxTraceNo" value="${pageInfo.f_plTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="平台会员号" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_plNo" value="${pageInfo.f_plNo}"/>
			</li>	  
			<li>
				<label><hi:text key="账户类型" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_accountType" value="${pageInfo.f_accountType}"/>
			</li>	  
			<li>
				<label><hi:text key="账户号码" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_accountNo" value="${pageInfo.f_accountNo}"/>
			</li>	  
			<li>
				<label><hi:text key="持卡人卡号" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_pan" value="${pageInfo.f_pan}"/>
			</li>	  
			<li>
				<label><hi:text key="持卡人个人信息" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_chinfo" value="${pageInfo.f_chinfo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易类型" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_txTypeId" value="${pageInfo.f_txTypeId}"/>
			</li>	  
			<li>
				<label><hi:text key="交易发生时间" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_mchtTxTime" value="${pageInfo.f_mchtTxTime}"/>
			</li>	  
			<li>
				<label><hi:text key="交易金额" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_txAmount" value="${pageInfo.f_txAmount}"/>
			</li>	  
			<li>
				<label><hi:text key="交易IP地址" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_txIp" value="${pageInfo.f_txIp}"/>
			</li>	  
			<li>
				<label><hi:text key="交易完成时间" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_plTxTime" value="${pageInfo.f_plTxTime}"/>
			</li>	  
			<li>
				<label><hi:text key="交易状态" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_txStatus" value="${pageInfo.f_txStatus}"/>
			</li>	  
			<li>
				<label><hi:text key="异常代码" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_errorCode" value="${pageInfo.f_errorCode}"/>
			</li>	  
			<li>
				<label><hi:text key="实名认证状态" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_errorMsg" value="${pageInfo.f_errorMsg}"/>
			</li>	  
			<li>
				<label><hi:text key="结算批次号" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_settleBatchNo" value="${pageInfo.f_settleBatchNo}"/>
			</li>	  
			<li>
				<label><hi:text key="结算状态" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_settleStatus" value="${pageInfo.f_settleStatus}"/>
			</li>	  
			<li>
				<label><hi:text key="结算日期" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_settleDate" value="${pageInfo.f_settleDate}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
			</li>	  
			<li>
				<label><hi:text key="银行交易状态" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_bankTxStatus" value="${pageInfo.f_bankTxStatus}"/>
			</li>	  
			<li>
				<label><hi:text key="对账批次号" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_checkBatchNo" value="${pageInfo.f_checkBatchNo}"/>
			</li>	  
			<li>
				<label><hi:text key="对账状态" entity="TblMbRechargeOrder"/>:</label>
				<input type="text" name="pageInfo.f_checkStatus" value="${pageInfo.f_checkStatus}"/>
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
				<authz:authorize ifAnyGranted="TBLMBRECHARGEORDER_SAVE"><li><a class="add" href="<hi:url>tblMbRechargeOrderEdit.action?tblMbRechargeOrder.id=-1</hi:url>" target="navTab" rel="tblMbRechargeOrder"><span><hi:text key="新建" parameterLanguageKeys="充值订单"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBRECHARGEORDER_DEL"><li><a class="delete" href="<hi:url>tblMbRechargeOrderRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', plTxTraceNo:'',plNo:'',accountType:'',accountNo:'',pan:'',chinfo:'',txTypeId:'',mchtTxTime:'',txAmount:'',txIp:'',plTxTime:'',txStatus:'',errorCode:'',errorMsg:'',settleBatchNo:'',settleStatus:'',settleDate:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:'',bankTxStatus:'',checkBatchNo:'',checkStatus:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台交易流水号" entity="TblMbRechargeOrder"/></th>
				<th orderField="plNo" class="${pageInfo.sorterName eq 'plNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台会员号" entity="TblMbRechargeOrder"/></th>
				<th orderField="accountType" class="${pageInfo.sorterName eq 'accountType' ? pageInfo.sorterDirection : ''}"><hi:text key="账户类型" entity="TblMbRechargeOrder"/></th>
				<th orderField="accountNo" class="${pageInfo.sorterName eq 'accountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="账户号码" entity="TblMbRechargeOrder"/></th>
				<th orderField="pan" class="${pageInfo.sorterName eq 'pan' ? pageInfo.sorterDirection : ''}"><hi:text key="持卡人卡号" entity="TblMbRechargeOrder"/></th>
				<th orderField="chinfo" class="${pageInfo.sorterName eq 'chinfo' ? pageInfo.sorterDirection : ''}"><hi:text key="持卡人个人信息" entity="TblMbRechargeOrder"/></th>
				<th orderField="txTypeId" class="${pageInfo.sorterName eq 'txTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblMbRechargeOrder"/></th>
				<th orderField="mchtTxTime" class="${pageInfo.sorterName eq 'mchtTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易发生时间" entity="TblMbRechargeOrder"/></th>
				<th orderField="txAmount" class="${pageInfo.sorterName eq 'txAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="交易金额" entity="TblMbRechargeOrder"/></th>
				<th orderField="txIp" class="${pageInfo.sorterName eq 'txIp' ? pageInfo.sorterDirection : ''}"><hi:text key="交易IP地址" entity="TblMbRechargeOrder"/></th>
				<th orderField="plTxTime" class="${pageInfo.sorterName eq 'plTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易完成时间" entity="TblMbRechargeOrder"/></th>
				<th orderField="txStatus" class="${pageInfo.sorterName eq 'txStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="交易状态" entity="TblMbRechargeOrder"/></th>
				<th orderField="errorCode" class="${pageInfo.sorterName eq 'errorCode' ? pageInfo.sorterDirection : ''}"><hi:text key="异常代码" entity="TblMbRechargeOrder"/></th>
				<th orderField="errorMsg" class="${pageInfo.sorterName eq 'errorMsg' ? pageInfo.sorterDirection : ''}"><hi:text key="实名认证状态" entity="TblMbRechargeOrder"/></th>
				<th orderField="settleBatchNo" class="${pageInfo.sorterName eq 'settleBatchNo' ? pageInfo.sorterDirection : ''}"><hi:text key="结算批次号" entity="TblMbRechargeOrder"/></th>
				<th orderField="settleStatus" class="${pageInfo.sorterName eq 'settleStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="结算状态" entity="TblMbRechargeOrder"/></th>
				<th orderField="settleDate" class="${pageInfo.sorterName eq 'settleDate' ? pageInfo.sorterDirection : ''}"><hi:text key="结算日期" entity="TblMbRechargeOrder"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbRechargeOrder"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMbRechargeOrder"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblMbRechargeOrder"/></th>
				<th orderField="bankTxStatus" class="${pageInfo.sorterName eq 'bankTxStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="银行交易状态" entity="TblMbRechargeOrder"/></th>
				<th orderField="checkBatchNo" class="${pageInfo.sorterName eq 'checkBatchNo' ? pageInfo.sorterDirection : ''}"><hi:text key="对账批次号" entity="TblMbRechargeOrder"/></th>
				<th orderField="checkStatus" class="${pageInfo.sorterName eq 'checkStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="对账状态" entity="TblMbRechargeOrder"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbRechargeOrders}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.plTxTraceNo}</td>
				    <td>${item.plNo}</td>
				    <td>${item.accountType}</td>
				    <td>${item.accountNo}</td>
				    <td>${item.pan}</td>
				    <td>${item.chinfo}</td>
				    <td>${item.txTypeId}</td>
				    <td>${item.mchtTxTime}</td>
				    <td>${item.txAmount}</td>
				    <td>${item.txIp}</td>
				    <td>${item.plTxTime}</td>
				    <td>${item.txStatus}</td>
				    <td>${item.errorCode}</td>
				    <td>${item.errorMsg}</td>
				    <td>${item.settleBatchNo}</td>
				    <td>${item.settleStatus}</td>
				    <td>${item.settleDate}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    <td>${item.bankTxStatus}</td>
				    <td>${item.checkBatchNo}</td>
				    <td>${item.checkStatus}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBRECHARGEORDER_DEL">
				      <a class="btnDel" href="<hi:url>tblMbRechargeOrderRemove.action?ajax=1&tblMbRechargeOrder.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="充值订单"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBRECHARGEORDER_VIEW">
				      <a class="btnView" href="<hi:url>tblMbRechargeOrderView.action?tblMbRechargeOrder.id=${item.id}</hi:url>" target="navTab" rel="tblMbRechargeOrder" title="<hi:text key="查看" parameterLanguageKeys="充值订单"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBRECHARGEORDER_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbRechargeOrderEdit.action?tblMbRechargeOrder.id=${item.id}</hi:url>" target="navTab" rel="tblMbRechargeOrder" title="<hi:text key="编辑" parameterLanguageKeys="充值订单"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', plTxTraceNo:'${item.plTxTraceNo}',plNo:'${item.plNo}',accountType:'${item.accountType}',accountNo:'${item.accountNo}',pan:'${item.pan}',chinfo:'${item.chinfo}',txTypeId:'${item.txTypeId}',mchtTxTime:'${item.mchtTxTime}',txAmount:'${item.txAmount}',txIp:'${item.txIp}',plTxTime:'${item.plTxTime}',txStatus:'${item.txStatus}',errorCode:'${item.errorCode}',errorMsg:'${item.errorMsg}',settleBatchNo:'${item.settleBatchNo}',settleStatus:'${item.settleStatus}',settleDate:'${item.settleDate}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}',bankTxStatus:'${item.bankTxStatus}',checkBatchNo:'${item.checkBatchNo}',checkStatus:'${item.checkStatus}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
