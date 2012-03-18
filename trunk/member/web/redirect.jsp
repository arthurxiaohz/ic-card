<%@ page language="java" errorPage="/error/error.jsp"
	pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>

	<% 
		String charset = (String)session.getAttribute("codetype");
		if(charset!=null && !"".equals(charset.trim())){	
		  response.setCharacterEncoding(charset.trim());
		}	
	%>
	
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT language="JavaScript">
	function sendForm() {
		var a = document.all.formcontents.value;
		document.all.form1.submit();
		return true;
	}

</SCRIPT>

</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="return sendForm();">

${formcontents}

<input type="hidden" name="formname" value="<%request.getAttribute("formname"); %>>" />
<input type="hidden" name="formcontents" value="<%request.getAttribute("formcontents"); %>" />
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <table width="322" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr> 
            <td height="100"> 
                <div align="center"> 
                    <table width="250" border="0" cellspacing="2" cellpadding="0">

                        <tr> 
                            <td width="19">&nbsp;</td>                            
                            <td width="231" class="txt">正在跳转到指定银行页面，请稍候......</td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>

    </table>
</body>
</html>