<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户手续费配置"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="手续费类型" entity="TblMchtFeeConfig"/>：</dt><dd><hi:select emu="mchtFeeType" name="tblMchtFeeConfig.mchtFeeType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="参数值" entity="TblMchtFeeConfig"/>：</dt><dd>${tblMchtFeeConfig.ruleValue}</dd>
		</dl>
		<dl>
			<dt><hi:text key="单笔最低收费" entity="TblMchtFeeConfig"/>：</dt><dd>${tblMchtFeeConfig.minVal}</dd>
		</dl>
		<dl>
			<dt><hi:text key="单笔最高收费" entity="TblMchtFeeConfig"/>：</dt><dd>${tblMchtFeeConfig.maxVal}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款是否退还手续费" entity="TblMchtFeeConfig"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtFeeConfig.isFeeReturn" isLabel="true"/></dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
