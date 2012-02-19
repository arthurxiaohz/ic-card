<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="staff"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="员工编号" entity="Staff"/>：</dt><dd>${staff.useNum}</dd>
		</dl>
		<dl>
			<dt><hi:text key="籍贯" entity="Staff"/>：</dt><dd>${staff.nativePlace}</dd>
		</dl>
		<dl>
			<dt><hi:text key="学历" entity="Staff"/>：</dt><dd><hi:select emu="degree" name="staff.degree" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="专业" entity="Staff"/>：</dt><dd>${staff.specialty}</dd>
		</dl>
		<dl>
			<dt><hi:text key="入场时间" entity="Staff"/>：</dt><dd><fmt:formatDate value="${staff.jobDate}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="婚姻状态" entity="Staff"/>：</dt><dd><hi:select emu="marriedStatus" name="staff.marry" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="个人爱好" entity="Staff"/>：</dt><dd>${staff.interest}</dd>
		</dl>
		<dl>
			<dt><hi:text key="工作岗位" entity="Staff"/>：</dt><dd>${staff.jobPosition.name}</dd>
		</dl>
		<dl>
			<dt><hi:text key="员工照片" entity="Staff"/>：</dt>
			<dd>
				<c:if test="${not empty staff.photo_attachment}">
				<a href="<hi:url>attachmentView.action?attachment.id=${staff.photo_attachment.id}</hi:url>" target="_blank">
					${staff.photo_attachment.fileNameImage}
				</a>
				</c:if>
			</dd>				  
		</dl>
		<dl>
			<dt><hi:text key="工作状态" entity="Staff"/>：</dt><dd><hi:select emu="employedStatus" name="staff.employedStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="民族" entity="Staff"/>：</dt><dd>${staff.nation.chineseName}</dd>
		</dl>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="Experience"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="朋友"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="开始时间" entity="Experience"/></th>
								<th><hi:text key="结束时间" entity="Experience"/></th>
								<th><hi:text key="地点" entity="Experience"/></th>
								<th><hi:text key="任务" entity="Experience"/></th>
								<th><hi:text key="证明人" entity="Experience"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${staff.experiences}">
							<tr>						
								<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${item.place}</td>
								<td>${item.task}</td>
								<td>${item.people}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="姓名" entity="Friends"/></th>
								<th><hi:text key="年龄" entity="Friends"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${staff.friendss}">
							<tr>						
								<td>${item.name}</td>
								<td>${item.age}</td>
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
