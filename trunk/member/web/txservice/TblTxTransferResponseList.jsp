<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblTxTransferResponseList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblTxTransferResponseList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="返回接口的版本号" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_versionNo" value="${pageInfo.f_versionNo}"/>
			</li>	  
			<li>
				<label><hi:text key="签名内容" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_signMsg" value="${pageInfo.f_signMsg}"/>
			</li>	  
			<li>
				<label><hi:text key="转账结果" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_transferResult" value="${pageInfo.f_transferResult}"/>
			</li>	  
			<li>
				<label><hi:text key="平台交易流水号" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_plTxTraceNo" value="${pageInfo.f_plTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户订单号" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_merchantOrderNo" value="${pageInfo.f_merchantOrderNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户转账金额" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_transferAmount" value="${pageInfo.f_transferAmount}"/>
			</li>	  
			<li>
				<label><hi:text key="交易类型" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_txTypeId" value="${pageInfo.f_txTypeId}"/>
			</li>	  
			<li>
				<label><hi:text key="支付完成时间" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_payDatetime" value="${pageInfo.f_payDatetime}"/>
			</li>	  
			<li>
				<label><hi:text key="扩展参数1" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_ext1" value="${pageInfo.f_ext1}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="扩展参数2" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_ext2" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_ext2}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_ext2_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_ext201" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_ext201}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_ext201_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblTxTransferResponse"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
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
				<authz:authorize ifAnyGranted="TBLTXTRANSFERRESPONSE_SAVE"><li><a class="add" href="<hi:url>tblTxTransferResponseEdit.action?tblTxTransferResponse.id=-1</hi:url>" target="navTab" rel="tblTxTransferResponse"><span><hi:text key="新建" parameterLanguageKeys="转账结果通知"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLTXTRANSFERRESPONSE_DEL"><li><a class="delete" href="<hi:url>tblTxTransferResponseRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', versionNo:'',signMsg:'',transferResult:'',plTxTraceNo:'',merchantOrderNo:'',transferAmount:'',txTypeId:'',payDatetime:'',ext1:'',ext2:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:'',errorCode:'',context:'',responseContent:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="versionNo" class="${pageInfo.sorterName eq 'versionNo' ? pageInfo.sorterDirection : ''}"><hi:text key="返回接口的版本号" entity="TblTxTransferResponse"/></th>
				<th orderField="signMsg" class="${pageInfo.sorterName eq 'signMsg' ? pageInfo.sorterDirection : ''}"><hi:text key="签名内容" entity="TblTxTransferResponse"/></th>
				<th orderField="transferResult" class="${pageInfo.sorterName eq 'transferResult' ? pageInfo.sorterDirection : ''}"><hi:text key="转账结果" entity="TblTxTransferResponse"/></th>
				<th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台交易流水号" entity="TblTxTransferResponse"/></th>
				<th orderField="merchantOrderNo" class="${pageInfo.sorterName eq 'merchantOrderNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户订单号" entity="TblTxTransferResponse"/></th>
				<th orderField="transferAmount" class="${pageInfo.sorterName eq 'transferAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="商户转账金额" entity="TblTxTransferResponse"/></th>
				<th orderField="txTypeId" class="${pageInfo.sorterName eq 'txTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblTxTransferResponse"/></th>
				<th orderField="payDatetime" class="${pageInfo.sorterName eq 'payDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="支付完成时间" entity="TblTxTransferResponse"/></th>
				<th orderField="ext1" class="${pageInfo.sorterName eq 'ext1' ? pageInfo.sorterDirection : ''}"><hi:text key="扩展参数1" entity="TblTxTransferResponse"/></th>
				<th orderField="ext2" class="${pageInfo.sorterName eq 'ext2' ? pageInfo.sorterDirection : ''}"><hi:text key="扩展参数2" entity="TblTxTransferResponse"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblTxTransferResponse"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblTxTransferResponse"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblTxTransferResponse"/></th>
				<th orderField="errorCode" class="${pageInfo.sorterName eq 'errorCode' ? pageInfo.sorterDirection : ''}"><hi:text key="错误代码" entity="TblTxTransferResponse"/></th>
				<th orderField="context" class="${pageInfo.sorterName eq 'context' ? pageInfo.sorterDirection : ''}"><hi:text key="报文内容" entity="TblTxTransferResponse"/></th>
				<th orderField="responseContent" class="${pageInfo.sorterName eq 'responseContent' ? pageInfo.sorterDirection : ''}"><hi:text key="商户返回结果" entity="TblTxTransferResponse"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblTxTransferResponses}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.versionNo}</td>
				    <td>${item.signMsg}</td>
				    <td>${item.transferResult}</td>
				    <td>${item.plTxTraceNo}</td>
				    <td>${item.merchantOrderNo}</td>
				    <td>${item.transferAmount}</td>
				    <td>${item.txTypeId}</td>
				    <td>${item.payDatetime}</td>
				    <td>${item.ext1}</td>
					<td><fmt:formatDate value="${item.ext2}" pattern="yyyy-MM-dd"/></td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    <td>${item.errorCode}</td>
				    <td>${item.context}</td>
				    <td>${item.responseContent}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLTXTRANSFERRESPONSE_DEL">
				      <a class="btnDel" href="<hi:url>tblTxTransferResponseRemove.action?ajax=1&tblTxTransferResponse.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="转账结果通知"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXTRANSFERRESPONSE_VIEW">
				      <a class="btnView" href="<hi:url>tblTxTransferResponseView.action?tblTxTransferResponse.id=${item.id}</hi:url>" target="navTab" rel="tblTxTransferResponse" title="<hi:text key="查看" parameterLanguageKeys="转账结果通知"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXTRANSFERRESPONSE_SAVE">
				      <a class="btnEdit" href="<hi:url>tblTxTransferResponseEdit.action?tblTxTransferResponse.id=${item.id}</hi:url>" target="navTab" rel="tblTxTransferResponse" title="<hi:text key="编辑" parameterLanguageKeys="转账结果通知"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', versionNo:'${item.versionNo}',signMsg:'${item.signMsg}',transferResult:'${item.transferResult}',plTxTraceNo:'${item.plTxTraceNo}',merchantOrderNo:'${item.merchantOrderNo}',transferAmount:'${item.transferAmount}',txTypeId:'${item.txTypeId}',payDatetime:'${item.payDatetime}',ext1:'${item.ext1}',ext2:'${item.ext2}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}',errorCode:'${item.errorCode}',context:'${item.context}',responseContent:'${item.responseContent}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
