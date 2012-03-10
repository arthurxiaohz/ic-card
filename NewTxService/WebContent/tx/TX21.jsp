<%@ page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<%-- tpl:insert page="/theme/A_blue.htpl" --%>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/blue.css" type="text/css">
<%-- tpl:put name="headarea" --%>
		<title>交易模拟系统</title>
	<%-- /tpl:put --%>

<script language="JavaScript" type="text/javascript">
<!--

function checkspace(checkstr) {
	  var str = '';
	  for(i = 0; i < checkstr.length; i++) {
	    str = str + ' ';
	  }
	  return (str == checkstr);
}

   
//判断输入的字符是否为整数    
function isNumber(obj)
{
	
	if(javaTrim(obj.value)==''){
	
	return false;
	}
	var l = obj.value.length;
	var count=0;

	for(var i=0; i < l; i++){
		var digit = obj.value.charAt(i);
		if( digit == "." ){
			count++;
			if(count>1){
				
				return false;
			}
		}else
		if( (digit != "," && digit < "0") || (digit != "," && digit > "9") ){
			
			return false;
		}
	}
	return true;
}



function javaTrim(string)
{
	var length1, i, j;
	var string1 = "";
	
	length1 = string.length;
	for (i = 0 ; i < length1 ; i++)
	{  //除去左边空格
		if(string.charAt(i) != " ")
		{//除去左边空格后
			for (j = i ; j < length1 ; j++) 
				string1 = string1 + string.charAt(j);
				break;	
		}
	}	
	length1 = string1.length;
	string = string1;
	string1 = "";
	for (i = length1 - 1 ; i >= 0 ; i--) 
	{  //除去右边空格
		if(string.charAt(i) != " ") 
		{//除去右边空格后
			for (j = 0 ; j <= i ; j++) 
				string1 = string1 + string.charAt(j);
				break;	
		}
	}
	string = string1;	
	return(string);	
}


function goProcess(){
	   
var CertificateNo = document.f.CertificateNo.value;	   
var CertificateTypeID = document.f.CertificateTypeID.value;	   


if(!checkspace(document.f.AllinpayNo.value)){
	
	if(javaTrim(document.f.MchtTxTraceNo.value)==''){
		alert("请填写商户流水号");
		document.f.MchtTxTraceNo.focus();
		return false;
	}
	if(javaTrim(document.f.OrigMchtTxTraceNo.value)==''){
		alert("请填写商户流水号");
		document.f.MchtTxTraceNo.focus();
		return false;
	}
	
	if(javaTrim(document.f.TxAmount.value)==''){
		alert("请填写交易金额");
		return false;
	}
	
		if(javaTrim(document.f.MerchantNo.value)==''){
		alert("请填写商户代码");
		return false;
	}
	
	if(javaTrim(document.f.TxDate.value)==''){
		alert("请填写交易日期");
		return false;
	}
	
	if(javaTrim(document.f.TxTime.value)==''){
		alert("请填写交易时间");
		return false;
	}
	
	if(javaTrim(document.f.OrigTxDate.value)==''){
		alert("请填写交易日期");
		return false;
	}
	
	if(javaTrim(document.f.OrigTxTime.value)==''){
		alert("请填写交易时间");
		return false;
	}
	


}
    
    f.submit();
}

	function goback(){
	    f.action="../index.jsp";
	    f.submit();
	}
	

	
	
//-->
</script>
</head>
<body>
<table width="760" cellspacing="0" cellpadding="0" border="0" align="center">
   <tbody>
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
      <form action="<%=request.getContextPath()%>/TxControl" name="f" method="post">
                <br>
                <p align="center"><b>撤销（TX21）</b></p>
				<table cellspacing="2" cellpadding="2" border="1" style="font-size:12px" bordercolor="#808080">
					<tr bgcolor="#8080FF"><td align="center" style="font-size:14px" height="25"><b>字段名</b></td><td align="center" style="font-size:14px"><b>字段值</b></td><td align="center" style="font-size:14px"><b>字段说明</b></td></tr>
					<tr><td width="150"><b>报文版本</b></td><td><input type="hidden" name="Version" size="50" value="1.0"> <input type="Text" name="Version" size="50" value="1.0" disabled></td> <td>报文版本</td></tr>
					<tr><td><b>交易类型 </b></td><td> <input type="hidden" name="TxType" size="50" value="TX21"> <input type="Text" name="TxType" size="50" value="TX21" disabled></td> <td>交易类型：TX21</td></tr>
					<tr><td><b>商户号</b></td><td> <input type="Text" name="MerchantNo" size="50" value="100000000000000000"></td> <td></td></tr>
                    <tr><td><b>交易日期</b></td><td> <input type="Text" name="TxDate" size="50" value="<%=cn.net.iccard.txsimulator.DateTimeUtil.getToday()%>"></td><td>交易发生时间(yyyyMMdd)</td></tr>
                     <tr><td><b>交易时间</b></td><td> <input type="Text" name="TxTime" size="50" value="<%=cn.net.iccard.txsimulator.DateTimeUtil.getCurrDateTime().substring(8, 14)%>"></td><td>交易发生时间(HHmmss)</td></tr>
                    <tr><td><b>原交易日期</b></td><td> <input type="Text" name="OrigTxDate" size="50" value="<%=cn.net.iccard.txsimulator.DateTimeUtil.getToday()%>"></td><td>交易发生时间(yyyyMMdd)</td></tr>
                     <tr><td><b>原交易时间</b></td><td> <input type="Text" name="OrigTxTime" size="50" value="<%=cn.net.iccard.txsimulator.DateTimeUtil.getCurrDateTime().substring(8, 14)%>"></td><td>交易发生时间(HHmmss)</td></tr>
                   
                    <tr><td><b>商户交易流水号</b></td><td><input type="Text" name="MchtTxTraceNo" size="50" value="<%=cn.net.iccard.txsimulator.GUID.generateGUID()%>"></td><td>商户交易流水号(32位)</td></tr>
                   		 <tr><td><b>原商户交易流水号</b></td><td><input type="Text" name="OrigMchtTxTraceNo" size="50" value="<%=cn.net.iccard.txsimulator.GUID.generateGUID()%>"></td><td>商户交易流水号(32位)</td></tr>
                   					
					<tr><td><b>交易金额</b></td><td> <input type="Text" name="TxAmount" size="50" value="2.00"></td><td>单位（元）</td></tr>
					<tr><td><b>交易结果通知地址</b></td><td><input type="Text" name="NotifyURL" size="50" value="">	</td><td></td></tr>
					<tr><td><b>交易结果后台通知地址</b></td><td> <input type="Text" name="BGNotifyURL" size="50" value=""></td><td></td></tr>
					<tr><td><b>扩展域</b></td><td> <input type="Text" name="ExtendInfo" size="50" value=""></td><td></td></tr>
               <tr><td><b>提交地址</b></td><td> <input type="Text" name="sendurl" size="50" value=""></td><td></td></tr>
               		
                </table>
                <br>
                <input type="hidden" name="TxTypeName" value="预支付请求">
                <input type="submit" value="  提交  " onClick="goProcess();return false;">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="  返回  " onClick="return goback();">
			</form>

         <%-- /tpl:put --%>
         </td>
      </tr>
      <tr>
         <td valign="top" height="20" class="footer"></td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>