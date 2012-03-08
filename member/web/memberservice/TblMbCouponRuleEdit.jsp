<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员优惠券规则"/></h2>
<form action="tblMbCouponRuleSave.action?navTabId=tblMbCouponRuleList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="帐号" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="hidden" name="tblMbCouponRule.tblMbInfo.id" value="${tblMbCouponRule.tblMbInfo.id}"/>
				<input type="text" class="textInput" name="tblMbCouponRule.hi_tblMbInfo.userName" value="${tblMbCouponRule.tblMbInfo.userName}"
					autocomplete="off" lookupGroup="tblMbCouponRule" lookupName="tblMbInfo" suggestClass="org.hi.base.organization.model.HiUser" searchFields="userName,fullName"/>
				<a class="btnLook" href="<hi:url>hiUserLookup.action?lookup=1</hi:url>" lookupGroup="tblMbCouponRule" lookupName="tblMbInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblMbCouponRule.hi_tblMbInfo.fullName" value="${tblMbCouponRule.tblMbInfo.fullName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="hidden" name="tblMbCouponRule.tblMchtInfo.id" value="${tblMbCouponRule.tblMchtInfo.id}"/>
				<input type="text" class="textInput" name="tblMbCouponRule.hi_tblMchtInfo.mchtNo" value="${tblMbCouponRule.tblMchtInfo.mchtNo}"
					autocomplete="off" lookupGroup="tblMbCouponRule" lookupName="tblMchtInfo" suggestClass="cn.net.iccard.bm.mcht.model.TblMchtInfo" searchFields="mchtNo,mchtName"/>
				<a class="btnLook" href="<hi:url>tblMchtInfoLookup.action?lookup=1</hi:url>" lookupGroup="tblMbCouponRule" lookupName="tblMchtInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblMbCouponRule.hi_tblMchtInfo.mchtName" value="${tblMbCouponRule.tblMchtInfo.mchtName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户类别" entity="TblMbCouponRule"/>：</dt><dd><hi:select emu="mchtType" name="tblMbCouponRule.mchtType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="商品类别" entity="TblMbCouponRule"/>：</dt><dd><hi:select emu="merchandiseCategory" name="tblMbCouponRule.merchandiseCategory"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="商品编号" entity="TblMbCouponRule"/>：</dt><dd><input type="text" name="tblMbCouponRule.merchandiseNo" class="textInput" value="${tblMbCouponRule.merchandiseNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券类型" entity="TblMbCouponRule"/>：</dt><dd><hi:select emu="couponType" name="tblMbCouponRule.couponType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="优惠券金额" entity="TblMbCouponRule"/>：</dt><dd><input type="text" name="tblMbCouponRule.amount" class="textInput integer" value="${tblMbCouponRule.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期开始时间" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbCouponRule.startDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCouponRule.startDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期结束时间" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbCouponRule.endDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCouponRule.endDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbCouponRule.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCouponRule.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbCouponRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbCouponRule.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCouponRule.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMbCouponRule.id" value="${tblMbCouponRule.id}"/>
				<input type="hidden" name="tblMbCouponRule.lastUpdatedBy.id" value="${tblMbCouponRule.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbCouponRule.creator.id" value="${tblMbCouponRule.creator.id}"/>
				<input type="hidden" name="tblMbCouponRule.version" value="${tblMbCouponRule.version}"/>

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
