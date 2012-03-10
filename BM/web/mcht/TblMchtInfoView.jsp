<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="商户号" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.mchtName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblMchtInfo"/>：</dt><dd><hi:select emu="mchtStatus" name="tblMchtInfo.status" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户类别" entity="TblMchtInfo"/>：</dt><dd><hi:select emu="mchtType" name="tblMchtInfo.mchtType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="座机" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.landline}</dd>
		</dl>
		<dl>
			<dt><hi:text key="移动电话" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.mobile}</dd>
		</dl>
		<dl>
			<dt><hi:text key="传真" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.fax}</dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.address}</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付自动确认期" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.days}</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户账号" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.bankAccountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户名称" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.bankAccountName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行行号" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.bankNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行名称" entity="TblMchtInfo"/>：</dt><dd>${tblMchtInfo.bankName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtInfo"/>：</dt><dd><fmt:formatDate value="${tblMchtInfo.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="商户手续费配置"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="商户证书"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="商户支付配置"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="手续费类型" entity="TblMchtFeeConfig"/></th>
								<th><hi:text key="参数值" entity="TblMchtFeeConfig"/></th>
								<th><hi:text key="单笔最低收费" entity="TblMchtFeeConfig"/></th>
								<th><hi:text key="单笔最高收费" entity="TblMchtFeeConfig"/></th>
								<th><hi:text key="退款是否退还手续费" entity="TblMchtFeeConfig"/></th>
								<th><hi:text key="创建时间" entity="TblMchtFeeConfig"/></th>
								<th><hi:text key="最后修改时间" entity="TblMchtFeeConfig"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtFeeConfigs}">
							<tr>						
				        		<td><hi:select emu="mchtFeeType" name="item.mchtFeeType" isLabel="true"/></td>
								<td>${item.ruleValue}</td>
								<td>${item.minVal}</td>
								<td>${item.maxVal}</td>
				        		<td><hi:select emu="yesNo" name="item.isFeeReturn" isLabel="true"/></td>
								<td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="证书序列号" entity="TblMchtCertificate"/></th>
								<th><hi:text key="颁发者DN" entity="TblMchtCertificate"/></th>
								<th><hi:text key="证书DN" entity="TblMchtCertificate"/></th>
								<th><hi:text key="证书有效期开始时间" entity="TblMchtCertificate"/></th>
								<th><hi:text key="证书有效期结束时间" entity="TblMchtCertificate"/></th>
								<th><hi:text key="创建时间" entity="TblMchtCertificate"/></th>
								<th><hi:text key="最后修改时间" entity="TblMchtCertificate"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtCertificates}">
							<tr>						
								<td>${item.certSn}</td>
								<td>${item.issuerCertDn}</td>
								<td>${item.certDn}</td>
								<td>${item.startTime}</td>
								<td>${item.endTime}</td>
								<td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="是否允许接入支付平台" entity="TblMchtPaymentConfig"/></th>
								<th><hi:text key="创建时间" entity="TblMchtPaymentConfig"/></th>
								<th><hi:text key="最后修改时间" entity="TblMchtPaymentConfig"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtPaymentConfigs}">
							<tr>						
				        		<td><hi:select emu="yesNo" name="item.authorized" isLabel="true"/></td>
								<td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
