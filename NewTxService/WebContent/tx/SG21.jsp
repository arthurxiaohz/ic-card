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

if(javaTrim(document.f.BankID.value)==''){
	alert("请选择支付银行");
	document.f.BankID.focus();
	return false;
}

if(checkspace(document.f.CertificateTypeID.value)){
	alert("请选择证件类型");
	document.f.CertificateTypeID.focus();
	return false;
}

if(checkspace(document.f.AllinpayNo.value)){
	alert("请输入通联会员号");
	document.f.AllinpayNo.focus();
	return false;
}

if(document.f.AllinpayNo.value.length !=18){
	alert("通联会员号长度不正确");
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
                <p align="center"><b>基金支付代扣签约（SG21）</b></p>
				<table cellspacing="2" cellpadding="2" border="1" style="font-size:12px" bordercolor="#808080" >
					<tr bgcolor="#8080FF"><td align="center" style="font-size:14px" height="25"><b>字段名</b></td><td align="center" style="font-size:14px"><b>字段值</b></td><td align="center" style="font-size:14px"><b>字段说明</b></td></tr>
					<tr><td width="150"><b>报文版本</b></td><td><input type="hidden" name="Version" size="50" value="1.0" > <input type="Text" name="Version" size="50" value="1.0"  disabled></td> <td>报文版本</td></tr>
					<tr><td><b>交易类型 </b></td><td><input type="hidden" name="TxType" size="50" value="SG21" > <input type="Text" name="TxType" size="50" value="SG21" disabled></td> <td>交易类型：SG21</td></tr>
					 <tr><td><b>基金销售机构代码</b></td><td> <input type="Text" name="FSINo" size="50" value="100000050380000"></td> <td>基金销售机构代码(15位)</td></tr>
                    <tr><td><b>交易发生时间</b></td><td> <input type="Text" name="TxTime" size="50" value="<%=com.hitrust.tech.util.DateTimeUtil.getCurrDateTime()%>"></td><td>交易发生时间(yyyyMMddHHmmss)</td></tr>
                    <tr><td><b>基金销售机构交易流水号</b></td><td><input type="Text" name="TxTraceNo" size="50" value="<%=com.hitrust.tech.util.GUID.generateGUID()%>"></td><td>基金销售机构交易流水号(32位)</td></tr>
                    <tr><td><b>支付银行</b></td><td><input type="Text" name="BankID" size="50" value="14404930" >	</td><td>光大银行：03030000</td></tr>
                   	<tr><td><b>银行卡号</b></td><td> <input type="Text" name="CardNo" size="50" value="622991000100015421" ></td><td>银行卡号(1-32位)</td></tr>
                    <tr><td><b>证件类型</b></td><td> 
	 						<select name="CertificateTypeID" >  
	                   			 <option >-------请选择证件类型-------</option>
	                   			 <option value="0">暂住证</option> 
	                   		 	 <option value="1" selected>身份证</option> 
	                             <option value="2">户口本</option>                                                                                                           
	                             <option value="3">军官证 </option>                                                                                                                                              
	                             <option value="4">警官证 </option> 
	                             <option value="5">士兵证 </option>    
	                             <option value="6">文职干部证 </option>                                                                                                           
	                             <option value="7">护照</option>                                                                                                                                              
	                             <option value="8">港澳台同胞回乡证</option> 
	                    </select>
						</td><td></td></tr>
                     <tr><td><b>证件号码</b></td><td> <input type="Text" name="CertificateNo" size="50" value="41030319720710233"></td><td>证件号码(1-25位)</td></tr>
					<tr><td><b>签约认购/申购代扣协议号</b></td><td> <input type="Text" name="WithholdingAgreementNo"size="50" value="12345678901234567890"  ></td><td>签约认购/申购代扣协议号(1-30位)</td></tr>
					<tr><td><b>通联会员号</b></td><td> <input type="Text" name="AllinpayNo" size="50" value="201003221656316478" ></td><td>通联会员号(18位)</td></tr>
					 <tr><td><b>交易结果通知地址</b></td><td> <input type="Text" name="NotifyURL" size="50" value="http://116.236.252.102:5022/FPSSimulator/ReceiveNotify"></td><td>交易结果通知地址(1-200位)(可为空)</td></tr> 
              </table>
                <br>
                <input type="hidden" name="TxTypeName" value="基金支付代扣签约">
                <input type="Submit" value="  提交  " onclick="goProcess();return false;">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="Submit" value="  返回  " onclick="goback()">
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