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
 


	
	if(javaTrim(document.f.MchtTxTraceNo.value)==''){
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
	if(javaTrim(document.f.TxBody.value)==''){
		alert("请填写商品描述");
		return false;
	}
	if(javaTrim(document.f.ShowUrl.value)==''){
		alert("请填写商品展示地址");
		return false;
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
         <td valign="top" height="350" align="center">
         <%-- tpl:put name="bodyarea" --%>
			<form action="<%=request.getContextPath()%>/TxControl" name="f" method="post">
                <br>
                <p align="center"><b>撤销成功（TX21）</b></p>
				
                <br>
                撤销成功！
                &nbsp;&nbsp;&nbsp;&nbsp;
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