<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="staff"/></h2>
<form action="staffSave.action?navTabId=staffList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="员工编号" entity="Staff"/>：</dt><dd><input type="text" name="staff.useNum" class="textInput" value="${staff.useNum}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="籍贯" entity="Staff"/>：</dt><dd><input type="text" name="staff.nativePlace" class="textInput" value="${staff.nativePlace}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="学历" entity="Staff"/>：</dt><dd><hi:select emu="degree" name="staff.degree"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="专业" entity="Staff"/>：</dt><dd><input type="text" name="staff.specialty" class="textInput" value="${staff.specialty}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="入场时间" entity="Staff"/>：</dt>
			<dd>
				<input type="text" name="staff.jobDate" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${staff.jobDate}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="婚姻状态" entity="Staff"/>：</dt><dd><hi:select emu="marriedStatus" name="staff.marry"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="个人爱好" entity="Staff"/>：</dt><dd><input type="text" name="staff.interest" class="textInput" value="${staff.interest}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="工作岗位" entity="Staff"/>：</dt>
			<dd>
				<input type="hidden" name="staff.jobPosition.id" value="${staff.jobPosition.id}"/>
				<input type="text" class="textInput" name="staff.hi_jobPosition.name" value="${staff.jobPosition.name}"
					autocomplete="off" lookupGroup="staff" lookupName="jobPosition" suggestClass="org.hi.test.model.JobPosition" searchFields="name"/>
				<a class="btnLook" href="<hi:url>jobPositionLookup.action?lookup=1</hi:url>" lookupGroup="staff" lookupName="jobPosition"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="员工照片" entity="Staff"/>：</dt>
			<dd>
				<input type="hidden" name="staff.photo_attachment.id" value="${staff.photo_attachment.id}"/>
				<input type="text" class="textInput" name="staff.hi_photo_attachment.fileName" value="${staff.photo_attachment.fileName}" readonly="readonly"/>
				<a class="btnAttach" href="<hi:url>attachmentLookup.action?lookup=1&from=attachment&saveType=1</hi:url>" lookupGroup="staff" lookupName="photo_attachment" width="560" height="300" title="<hi:text key="附件"/>"><hi:text key="附件"/></a>
				<c:if test="${not empty staff.photo_attachment}">
				<a class="btnView" href="attachmentView.action?attachment.id=${staff.photo_attachment.id}" target="_blank">
					<hi:text key="查看"/>
				</a>
				</c:if>			
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="工作状态" entity="Staff"/>：</dt><dd><hi:select emu="employedStatus" name="staff.employedStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="民族" entity="Staff"/>：</dt>
			<dd>
				<input type="hidden" name="staff.nation.id" value="${staff.nation.id}"/>
				<input type="text" class="textInput" name="staff.hi_nation.chineseName" value="${staff.nation.chineseName}"
					autocomplete="off" lookupGroup="staff" lookupName="nation" suggestClass="org.hi.test.model.Nation" searchFields="chineseName"/>
				<a class="btnLook" href="<hi:url>nationLookup.action?lookup=1</hi:url>" lookupGroup="staff" lookupName="nation"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
				<input type="hidden" name="staff.id" value="${staff.id}"/>
				<input type="hidden" name="staff.photo_attachment" value="${staff.photo_attachment}"/>
				<input type="hidden" name="staff.creator.id" value="${staff.creator.id}"/>
				<input type="hidden" name="staff.version" value="${staff.version}"/>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="Experience"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:150px;">
				<div>
					<table class="list nowrap" width="100%" itemDetail="staff.experiences">
						<thead>
							<tr>
								<th type="datetime" class=" required date" name="startTime" size="12"><hi:text key="开始时间" entity="Experience"/></th>
								<th type="datetime" class=" required date" name="endTime" size="12"><hi:text key="结束时间" entity="Experience"/></th>
								<th type="text" class=" required" name="place" size="12" maxlength="30"><hi:text key="地点" entity="Experience"/></th>
								<th type="text" class=" required" name="task" size="12" maxlength="30"><hi:text key="任务" entity="Experience"/></th>
								<th type="text" class=" required" name="people" size="12" maxlength="30"><hi:text key="证明人" entity="Experience"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${staff.experiences}"  varStatus="s">
							<tr>
							<input type="hidden" name="staff.experiences[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="staff.experiences[${s.index}].version" value="${item.version}"/>
								<td>
									<input type="text" class="date required" name="staff.experiences[${s.index}].startTime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.startTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td>
									<input type="text" class="date required" name="staff.experiences[${s.index}].endTime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td>
									<input type="text" class=" required" name="staff.experiences[${s.index}].place" value="${item.place}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class=" required" name="staff.experiences[${s.index}].task" value="${item.task}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class=" required" name="staff.experiences[${s.index}].people" value="${item.people}" size="12" maxlength="30"/>
								</td>
								<td><a href="<hi:url>experienceRemove.action?ajax=1&experience.id=${item.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
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
