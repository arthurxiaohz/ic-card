<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户手续费配置"/></h2>
<form action="tblMchtFeeConfigSave.action?navTabId=tblMchtFeeConfigList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="手续费类型" entity="TblMchtFeeConfig"/>：</dt><dd><hi:select emu="mchtFeeType" name="tblMchtFeeConfig.mchtFeeType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="参数值" entity="TblMchtFeeConfig"/>：</dt><dd><input type="text" name="tblMchtFeeConfig.ruleValue" class="textInput float" value="${tblMchtFeeConfig.ruleValue}" alt="<hi:text key="请输浮点数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="单笔最低收费" entity="TblMchtFeeConfig"/>：</dt><dd><input type="text" name="tblMchtFeeConfig.minVal" class="textInput integer" value="${tblMchtFeeConfig.minVal}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="单笔最高收费" entity="TblMchtFeeConfig"/>：</dt><dd><input type="text" name="tblMchtFeeConfig.maxVal" class="textInput integer" value="${tblMchtFeeConfig.maxVal}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款是否退还手续费" entity="TblMchtFeeConfig"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtFeeConfig.isFeeReturn"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtFeeConfig"/>：</dt>
			<dd>
				<input type="text" name="tblMchtFeeConfig.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtFeeConfig.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMchtFeeConfig"/>：</dt>
			<dd>
				<input type="text" name="tblMchtFeeConfig.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtFeeConfig.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMchtFeeConfig.id" value="${tblMchtFeeConfig.id}"/>
				<input type="hidden" name="tblMchtFeeConfig.tblMchtInfo.id" value="${tblMchtFeeConfig.tblMchtInfo.id}"/>
				<input type="hidden" name="tblMchtFeeConfig.lastUpdatedBy.id" value="${tblMchtFeeConfig.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMchtFeeConfig.creator.id" value="${tblMchtFeeConfig.creator.id}"/>
				<input type="hidden" name="tblMchtFeeConfig.version" value="${tblMchtFeeConfig.version}"/>

		<div class="divider"></div>
			</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
