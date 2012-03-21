<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户"/></h2>
<form action="tblMchtInfoSave.action?navTabId=tblMchtInfoList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="商户号" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.mchtNo" class="textInput required" value="${tblMchtInfo.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.mchtName" class="textInput" value="${tblMchtInfo.mchtName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblMchtInfo"/>：</dt><dd><hi:select emu="mchtStatus" name="tblMchtInfo.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="商户类别" entity="TblMchtInfo"/>：</dt><dd><hi:select emu="mchtType" name="tblMchtInfo.mchtType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="座机" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.landline" class="textInput" value="${tblMchtInfo.landline}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="移动电话" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.mobile" class="textInput" value="${tblMchtInfo.mobile}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="传真" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.fax" class="textInput" value="${tblMchtInfo.fax}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.address" class="textInput" value="${tblMchtInfo.address}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付自动确认期" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.days" class="textInput integer" value="${tblMchtInfo.days}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户账号" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.bankAccountNo" class="textInput" value="${tblMchtInfo.bankAccountNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户名称" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.bankAccountName" class="textInput" value="${tblMchtInfo.bankAccountName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行行号" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.bankNo" class="textInput" value="${tblMchtInfo.bankNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行名称" entity="TblMchtInfo"/>：</dt><dd><input type="text" name="tblMchtInfo.bankName" class="textInput" value="${tblMchtInfo.bankName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMchtInfo.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtInfo.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMchtInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMchtInfo.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtInfo.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMchtInfo.id" value="${tblMchtInfo.id}"/>
				<input type="hidden" name="tblMchtInfo.feeFlag" value="${tblMchtInfo.feeFlag}"/>
				<input type="hidden" name="tblMchtInfo.lastUpdatedBy.id" value="${tblMchtInfo.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMchtInfo.creator.id" value="${tblMchtInfo.creator.id}"/>
				<input type="hidden" name="tblMchtInfo.deleted" value="${tblMchtInfo.deleted}"/>
				<input type="hidden" name="tblMchtInfo.version" value="${tblMchtInfo.version}"/>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="商户手续费配置"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="商户证书"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="商户支付配置"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="商户结算周期配置"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:150px;">
				<div>
					<table class="list nowrap" width="100%" itemDetail="tblMchtInfo.tblMchtFeeConfigs">
						<thead>
							<tr>
								<th type="enum" name="mchtFeeType" enumName="mchtFeeType" size="12"><hi:text key="手续费类型" entity="TblMchtFeeConfig"/></th>
								<th type="text" class=" float" name="ruleValue" size="12"><hi:text key="参数值" entity="TblMchtFeeConfig"/></th>
								<th type="text" class=" integer" name="minVal" size="12"><hi:text key="单笔最低收费" entity="TblMchtFeeConfig"/></th>
								<th type="text" class=" integer" name="maxVal" size="12"><hi:text key="单笔最高收费" entity="TblMchtFeeConfig"/></th>
								<th type="enum" name="isFeeReturn" enumName="yesNo" size="12"><hi:text key="退款是否退还手续费" entity="TblMchtFeeConfig"/></th>
								<th type="datetime" class=" date" name="createdDateTime" size="12"><hi:text key="创建时间" entity="TblMchtFeeConfig"/></th>
								<th type="datetime" class=" date" name="lastUpdatedDatetime" size="12"><hi:text key="最后修改时间" entity="TblMchtFeeConfig"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtFeeConfigs}"  varStatus="s">
							<tr>
							<input type="hidden" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].version" value="${item.version}"/>
								<td>
									<hi:select emu="mchtFeeType" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].mchtFeeType" />
								</td>
								<td>
									<input type="text" class=" float" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].ruleValue" value="${item.ruleValue}" size="12" alt="<hi:text key="请输浮点数"/>"/>
								</td>
								<td>
									<input type="text" class=" integer" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].minVal" value="${item.minVal}" size="12" alt="<hi:text key="请输入整数"/>"/>
								</td>
								<td>
									<input type="text" class=" integer" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].maxVal" value="${item.maxVal}" size="12" alt="<hi:text key="请输入整数"/>"/>
								</td>
								<td>
									<hi:select emu="yesNo" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].isFeeReturn" />
								</td>
								<td>
									<input type="text" class="date" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].createdDateTime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td>
									<input type="text" class="date" name="tblMchtInfo.tblMchtFeeConfigs[${s.index}].lastUpdatedDatetime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td><a href="<hi:url>tblMchtFeeConfigRemove.action?ajax=1&tblMchtFeeConfig.id=${item.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>								
				<div>
					<table class="list nowrap" width="100%" itemDetail="tblMchtInfo.tblMchtCertificates">
						<thead>
							<tr>
								<th type="text" class="" name="certSn" size="12" maxlength="100"><hi:text key="证书序列号" entity="TblMchtCertificate"/></th>
								<th type="text" class="" name="issuerCertDn" size="12" maxlength="30"><hi:text key="颁发者DN" entity="TblMchtCertificate"/></th>
								<th type="text" class="" name="certDn" size="12" maxlength="30"><hi:text key="证书DN" entity="TblMchtCertificate"/></th>
								<th type="text" class="" name="startTime" size="12" maxlength="30"><hi:text key="证书有效期开始时间" entity="TblMchtCertificate"/></th>
								<th type="text" class="" name="endTime" size="12" maxlength="30"><hi:text key="证书有效期结束时间" entity="TblMchtCertificate"/></th>
								<th type="datetime" class=" date" name="createdDateTime" size="12"><hi:text key="创建时间" entity="TblMchtCertificate"/></th>
								<th type="datetime" class=" date" name="lastUpdatedDatetime" size="12"><hi:text key="最后修改时间" entity="TblMchtCertificate"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtCertificates}"  varStatus="s">
							<tr>
							<input type="hidden" name="tblMchtInfo.tblMchtCertificates[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="tblMchtInfo.tblMchtCertificates[${s.index}].version" value="${item.version}"/>
								<td>
									<input type="text" class="" name="tblMchtInfo.tblMchtCertificates[${s.index}].certSn" value="${item.certSn}" size="12" maxlength="100"/>
								</td>
								<td>
									<input type="text" class="" name="tblMchtInfo.tblMchtCertificates[${s.index}].issuerCertDn" value="${item.issuerCertDn}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="" name="tblMchtInfo.tblMchtCertificates[${s.index}].certDn" value="${item.certDn}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="" name="tblMchtInfo.tblMchtCertificates[${s.index}].startTime" value="${item.startTime}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="" name="tblMchtInfo.tblMchtCertificates[${s.index}].endTime" value="${item.endTime}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="date" name="tblMchtInfo.tblMchtCertificates[${s.index}].createdDateTime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td>
									<input type="text" class="date" name="tblMchtInfo.tblMchtCertificates[${s.index}].lastUpdatedDatetime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td><a href="<hi:url>tblMchtCertificateRemove.action?ajax=1&tblMchtCertificate.id=${item.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>								
				<div>
					<table class="list nowrap" width="100%" itemDetail="tblMchtInfo.tblMchtPaymentConfigs">
						<thead>
							<tr>
								<th type="enum" name="authorized" enumName="yesNo" size="12"><hi:text key="是否允许接入支付平台" entity="TblMchtPaymentConfig"/></th>
								<th type="enum" name="signType" enumName="signType" size="12"><hi:text key="签名方式" entity="TblMchtPaymentConfig"/></th>
								<th type="text" class="" name="md5" size="12" maxlength="30"><hi:text key="MD5" entity="TblMchtPaymentConfig"/></th>
								<th type="datetime" class=" date" name="createdDateTime" size="12"><hi:text key="创建时间" entity="TblMchtPaymentConfig"/></th>
								<th type="datetime" class=" date" name="lastUpdatedDatetime" size="12"><hi:text key="最后修改时间" entity="TblMchtPaymentConfig"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtPaymentConfigs}"  varStatus="s">
							<tr>
							<input type="hidden" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].version" value="${item.version}"/>
								<td>
									<hi:select emu="yesNo" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].authorized" />
								</td>
								<td>
									<hi:select emu="signType" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].signType" />
								</td>
								<td>
									<input type="text" class="" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].md5" value="${item.md5}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="date" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].createdDateTime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td>
									<input type="text" class="date" name="tblMchtInfo.tblMchtPaymentConfigs[${s.index}].lastUpdatedDatetime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td><a href="<hi:url>tblMchtPaymentConfigRemove.action?ajax=1&tblMchtPaymentConfig.id=${item.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>								
				<div>
					<table class="list nowrap" width="100%" itemDetail="tblMchtInfo.tblMchtSettleCycleConfigs">
						<thead>
							<tr>
								<th type="text" class=" integer" name="settleInterval" size="12"><hi:text key="结算频度间隔" entity="TblMchtSettleCycleConfig"/></th>
								<th type="text" class=" integer" name="threshold" size="12"><hi:text key="最小结算金额" entity="TblMchtSettleCycleConfig"/></th>
								<th type="text" class=" integer" name="excessReserve" size="12"><hi:text key="备付金" entity="TblMchtSettleCycleConfig"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMchtInfo.tblMchtSettleCycleConfigs}"  varStatus="s">
							<tr>
							<input type="hidden" name="tblMchtInfo.tblMchtSettleCycleConfigs[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="tblMchtInfo.tblMchtSettleCycleConfigs[${s.index}].version" value="${item.version}"/>
								<td>
									<input type="text" class=" integer" name="tblMchtInfo.tblMchtSettleCycleConfigs[${s.index}].settleInterval" value="${item.settleInterval}" size="12" alt="<hi:text key="请输入整数"/>"/>
								</td>
								<td>
									<input type="text" class=" integer" name="tblMchtInfo.tblMchtSettleCycleConfigs[${s.index}].threshold" value="${item.threshold}" size="12" alt="<hi:text key="请输入整数"/>"/>
								</td>
								<td>
									<input type="text" class=" integer" name="tblMchtInfo.tblMchtSettleCycleConfigs[${s.index}].excessReserve" value="${item.excessReserve}" size="12" alt="<hi:text key="请输入整数"/>"/>
								</td>
								<td><a href="<hi:url>tblMchtSettleCycleConfigRemove.action?ajax=1&tblMchtSettleCycleConfig.id=${item.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
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
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
