<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%-- tpl:insert page="/theme/A_blue.htpl" --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/theme/blue.css" type="text/css">
		<%-- tpl:put name="headarea" --%>
		<title>交易模拟系统</title>
		<%-- /tpl:put --%>

		<script language="JavaScript" type="text/javascript">

function gosuc(){
	

	f.submit();

}
function gofail(){
	
	var text = document.getElementById("failTxInfo").value;
	var textsig = document.getElementById("failSignature").value;
	document.f.TxInfo.value= text;
	document.f.Signature.value= textsig;
	f.submit();

}

</script>
	</head>
	<body>

		<table width="760" cellspacing="0" cellpadding="0" border="0"
			align="center">
			<tbody>
				<tr>
					<td valign="top">
						<table class="header" cellspacing="0" cellpadding="0" border="0"
							width="100%">
							<tbody>
								<tr>

									<td align="center" style="color: white; font-size: 30px">
										银行模拟系统
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top" class="nav_head" height="20"></td>
				</tr>
				<tr class="content-area">
					<td valign="top" height="350" align="center">
						<%-- tpl:put name="bodyarea" --%>
						<form action='<%=request.getAttribute("NotifyURL")%>' name="f"
							method="post">
							
							<input type='hidden' name='total_fee' id="total_fee"
								value='<%=request.getAttribute("total_fee")%>' />
							<input type='hidden' name='out_trade_no' id="out_trade_no"
								value='<%=request.getAttribute("out_trade_no")%>' />
								<input type='hidden' name='orderId' id="orderId"
								value='<%=request.getAttribute("orderId")%>' />
							
							<br>
							<p align="center">
								<b>充值</b>
							</p>
							<table cellspacing="2" cellpadding="2" border="1"
								style="font-size: 12px" bordercolor="#808080">
								<tr bgcolor="#8080FF">
									<td align="center" style="font-size: 16px" height="25" width="200">
										<b>字段名</b>
									</td>
									<td align="center" style="font-size: 16px" width="600">
										<b>字段值</b>
									</td>
									
								</tr>
								
								<tr>
									<td>
										<b>金额</b>
									</td>
									<td>
										<%=(String) request.getAttribute("total_fee")%>
									</td>
									</tr>
									<tr>
									<td>
										<b>流水号</b>
									</td>
									<td>
										<%=(String) request.getAttribute("out_trade_no")%>
									</td>
									
								</tr>
							
							</table>
							<hr>
							<input type="button" value="成功" style="width: 100" onClick="return gosuc();"
								>
							
						</form>

					</td>
				</tr>
				<tr>
					<td valign="top" height="20" class="footer"></td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
<%-- /tpl:insert --%>