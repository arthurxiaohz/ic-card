<%@ page language="java" errorPage="/error/error.jsp"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<script language="JavaScript" type="text/javascript">


function goback(){
    window.opener=null;
    window.open('', '_self', ''); 
    window.close(); 

}
</script>
<html>
<head>

<title>

</title>


<link rel="stylesheet" type="text/css" media="all"
			href="<c:url value='styles/hiucc.css'/>" />
</head><body>
<form action="" name="f"> 
<table width="322" border="0" cellspacing="0" cellpadding="0"
			align="center">
  <tr>
    <td height="13"><img src="button/pic_notice_top.gif" width="322" height="13"></td>
  </tr>
  <tr >
    <td align="left" background="button/pic_notice_bg.gif"> &nbsp;<img src="button/pic_notice.gif" width="28" height="28"><span class="bold_left"><fmt:message key="view.return.message"></fmt:message></span><br/></td>
  </tr>
  <tr>
    <td height="60" align="right" background="button/pic_notice_bg.gif">
	<table width="90%" border="0" cellspacing="0" cellpadding="0">
         <tr>
          <td align="left">充值成功！</td>
        </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td height="13"><img src="button/pic_notice_bottom.gif" width="322" height="13"> </td>
  </tr>
  
</table>

<br>
         <td align="center">
        	 
         </td><center><input type="submit" value="  关闭  " onClick="return goback();"></center>
	</form>
</body>
</html>
