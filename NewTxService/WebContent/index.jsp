<%@ page 
language="java"
contentType="text/html; charset=GB2312"
pageEncoding="GB2312"
%>

<%-- tpl:insert page="/theme/A_blue.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/blue.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>交易模拟系统</title>
<%-- /tpl:put --%>

<script language="JavaScript" type="text/javascript">
<!--

	function goTx(page){
	    f.action="tx/" + page + ".jsp";
	    f.submit();
	}
	
	function goError(){
	    f.action="ExceptionPage.jsp";
	    f.submit();
	}
//-->
</script>
</head>
<body>
<table width="760px" cellspacing="0" cellpadding="0" border="0" align="center">
   <tbody>
   <tr>
   	<td>	
   		
   	</td>
   </tr>
      <tr>
         <td valign="top">
         <table class="header" cellspacing="0" cellpadding="0" border="0" width="100%">
            <tbody>
               <tr>
                  <td align="center" style="color:white; font-size:30px">交易模拟系统</td>
               </tr>
            </tbody>
         </table>
         </td>
      </tr>
      <tr>
         <td valign="top" class="nav_head" height="20"></td>
      </tr>
      <tr class="content-area">
         <td valign="top" height="350">
         <%-- tpl:put name="bodyarea" --%>
			<form action="#" name="f"  method="post">
			<table align="center"  width="100%" >
        <tr  >
        <td valign="top" align="center">
        <br><p align="center"><b>交易模拟测试</b></p>
				<table  cellspacing="2" cellpadding="2" border="1" style="font-size:12px" width="90%">
					<tr><td rowspan="6" align="center">商户交易</td>    <td>预支付				</td> <td align="center">TX11</td> <td align="center"><input type="submit" value="测试TX11" style="width:100"  onclick="goTx('TX11')"></td></tr>
					<tr>                                   				 <td>撤销      	    </td> <td align="center">TX21</td> <td align="center"><input type="submit" value="测试TX21" style="width:100"  onclick="goTx('TX21')"></td></tr>
					<tr>                                   				 <td>退款		</td> <td align="center">TX23</td> <td align="center"><input type="submit" value="测试TX23" style="width:100"  onclick="goTx('TX23')"></td></tr>
				</table>
        </td>
      </tr>
       <tr>
      	<td>&nbsp;</td>
      </tr>
       <tr>
      	<td>&nbsp;</td>
      </tr>
       <tr>
      	<td>&nbsp;</td>
      </tr>
       <tr>
      	<td>&nbsp;</td>
      </tr>
      <tr>
         <td valign="top" height="20" class="footer"></td>
      </tr>
</table></form></td></tr></tbody></table>
</body>
</html><%-- /tpl:insert --%>