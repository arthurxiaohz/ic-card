<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlSettleBatchList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlSettleBatchList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="结算批次号" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_settleNo" value="${pageInfo.f_settleNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.tblMchtInfo.f_id" value="${pageInfo.tblMchtInfo.f_id}"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.tblMchtInfo.f_mchtNo" value="${pageInfo.tblMchtInfo.f_mchtNo}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.lastUpdatedBy.f_id" value="${pageInfo.lastUpdatedBy.f_id}"/>
			</li>	  
			<li>
				<label><hi:text key="支付总比数" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_orderCount" value="${pageInfo.f_orderCount}"/>
			</li>	  
			<li>
				<label><hi:text key="支付总金额" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_balance" value="${pageInfo.f_balance}"/>
			</li>	  
			<li>
				<label><hi:text key="支付总手续费" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_fee" value="${pageInfo.f_fee}"/>
			</li>	  
			<li>
				<label><hi:text key="退款总笔数" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_refundCount" value="${pageInfo.f_refundCount}"/>
			</li>	  
			<li>
				<label><hi:text key="退款总金额" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_refundBalance" value="${pageInfo.f_refundBalance}"/>
			</li>	  
			<li>
				<label><hi:text key="退款总手续费" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_refundFee" value="${pageInfo.f_refundFee}"/>
			</li>	  
			<li>
				<label><hi:text key="结算金额" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_settleAmount" value="${pageInfo.f_settleAmount}"/>
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
				<authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_SAVE"><li><a class="add" href="<hi:url>tblStlSettleBatchEdit.action?tblStlSettleBatch.id=-1</hi:url>" target="navTab" rel="tblStlSettleBatch"><span><hi:text key="新建" parameterLanguageKeys="结算批次"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_DEL"><li><a class="delete" href="<hi:url>tblStlSettleBatchRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', settleNo:'',mchtNo:'',mchtName:'',bankNo:'',bankName:'',bankAccountNo:'',bankAccountName:'',createdDatetime:'',lastUpdatedDatetime:'',orderCount:'',balance:'',fee:'',refundCount:'',refundBalance:'',refundFee:'',settleAmount:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="settleNo" class="${pageInfo.sorterName eq 'settleNo' ? pageInfo.sorterDirection : ''}"><hi:text key="结算批次号" entity="TblStlSettleBatch"/></th>
				<th orderField="tblMchtInfo.mchtNo" class="${pageInfo.sorterName eq 'tblMchtInfo.mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblStlSettleBatch"/></th>
				<th orderField="tblMchtInfo.mchtName" class="${pageInfo.sorterName eq 'tblMchtInfo.mchtName' ? pageInfo.sorterDirection : ''}"><hi:text key="商户名称" entity="TblStlSettleBatch"/></th>
				<th orderField="tblMchtInfo.bankNo" class="${pageInfo.sorterName eq 'tblMchtInfo.bankNo' ? pageInfo.sorterDirection : ''}"><hi:text key="开户行行号" entity="TblStlSettleBatch"/></th>
				<th orderField="tblMchtInfo.bankName" class="${pageInfo.sorterName eq 'tblMchtInfo.bankName' ? pageInfo.sorterDirection : ''}"><hi:text key="开户行名称" entity="TblStlSettleBatch"/></th>
				<th orderField="tblMchtInfo.bankAccountNo" class="${pageInfo.sorterName eq 'tblMchtInfo.bankAccountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="银行账户账号" entity="TblStlSettleBatch"/></th>
				<th orderField="tblMchtInfo.bankAccountName" class="${pageInfo.sorterName eq 'tblMchtInfo.bankAccountName' ? pageInfo.sorterDirection : ''}"><hi:text key="银行账户名称" entity="TblStlSettleBatch"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblStlSettleBatch"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblStlSettleBatch"/></th>
				<th orderField="orderCount" class="${pageInfo.sorterName eq 'orderCount' ? pageInfo.sorterDirection : ''}"><hi:text key="支付总比数" entity="TblStlSettleBatch"/></th>
				<th orderField="balance" class="${pageInfo.sorterName eq 'balance' ? pageInfo.sorterDirection : ''}"><hi:text key="支付总金额" entity="TblStlSettleBatch"/></th>
				<th orderField="fee" class="${pageInfo.sorterName eq 'fee' ? pageInfo.sorterDirection : ''}"><hi:text key="支付总手续费" entity="TblStlSettleBatch"/></th>
				<th orderField="refundCount" class="${pageInfo.sorterName eq 'refundCount' ? pageInfo.sorterDirection : ''}"><hi:text key="退款总笔数" entity="TblStlSettleBatch"/></th>
				<th orderField="refundBalance" class="${pageInfo.sorterName eq 'refundBalance' ? pageInfo.sorterDirection : ''}"><hi:text key="退款总金额" entity="TblStlSettleBatch"/></th>
				<th orderField="refundFee" class="${pageInfo.sorterName eq 'refundFee' ? pageInfo.sorterDirection : ''}"><hi:text key="退款总手续费" entity="TblStlSettleBatch"/></th>
				<th orderField="settleAmount" class="${pageInfo.sorterName eq 'settleAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="结算金额" entity="TblStlSettleBatch"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlSettleBatchs}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.settleNo}</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.mchtNo}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.mchtName}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.bankNo}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.bankName}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.bankAccountNo}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"><a href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.tblMchtInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMchtInfo.bankAccountName}
					<authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW"></a></authz:authorize>
					</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.orderCount}</td>
				    <td>${item.balance}</td>
				    <td>${item.fee}</td>
				    <td>${item.refundCount}</td>
				    <td>${item.refundBalance}</td>
				    <td>${item.refundFee}</td>
				    <td>${item.settleAmount}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_DEL">
				      <a class="btnDel" href="<hi:url>tblStlSettleBatchRemove.action?ajax=1&tblStlSettleBatch.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="结算批次"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_VIEW">
				      <a class="btnView" href="<hi:url>tblStlSettleBatchView.action?tblStlSettleBatch.id=${item.id}</hi:url>" target="navTab" rel="tblStlSettleBatch" title="<hi:text key="查看" parameterLanguageKeys="结算批次"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlSettleBatchEdit.action?tblStlSettleBatch.id=${item.id}</hi:url>" target="navTab" rel="tblStlSettleBatch" title="<hi:text key="编辑" parameterLanguageKeys="结算批次"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', settleNo:'${item.settleNo}',mchtNo:'${item.tblMchtInfo.mchtNo}',mchtName:'${item.tblMchtInfo.mchtName}',bankNo:'${item.tblMchtInfo.bankNo}',bankName:'${item.tblMchtInfo.bankName}',bankAccountNo:'${item.tblMchtInfo.bankAccountNo}',bankAccountName:'${item.tblMchtInfo.bankAccountName}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',orderCount:'${item.orderCount}',balance:'${item.balance}',fee:'${item.fee}',refundCount:'${item.refundCount}',refundBalance:'${item.refundBalance}',refundFee:'${item.refundFee}',settleAmount:'${item.settleAmount}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
