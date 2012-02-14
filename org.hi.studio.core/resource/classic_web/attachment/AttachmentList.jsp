<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="attachment/Attachment.js"></script>
</head>
<body>
<script>
function checkAttachmentValue(image)
{
 if (document.saveForm.image.value=="")
 {
   alert(<hi:text key="请先选择需要上传的文件!" entity="attachment"/>")
   return false;
 }
 return true;
}
</script>
<%
String attachDesc = request.getParameter("from");
if (attachDesc == null )
	attachDesc = "attachment";
String attachmentType= request.getParameter("saveType");
if (attachmentType== null )
	attachmentType ="1";


%>
  <form name="saveForm" action="attachmentSave.action" method="post" onsubmit="return checkAttachmentValue('image')" enctype="multipart/form-data" >
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="请选择需要上传的附件" entity="attachment"/></td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">
		    
        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
			   <td width="15%" class="EditTableLabel"  id="volumeDocument.attachmentLabel"><hi:text key="附件" entity="attachment"/>:</td>
				  <td width="35%" colspan="3"  class="EditTableData">
				  <input type="file" name="image" size="30" /> 
				    
				  </td>
			  </tr>
			   
			    <input type="hidden" id="attachment.attachDesc" name="attachment.attachDesc" value="<%=attachDesc%>" >
			    <input type="hidden" id="attachment.attachmentType" name="attachment.attachmentType" value="<%=attachmentType%>" >
				<input type="hidden" id="attachment.id" name="attachment.id" value="<ws:property value="attachment.id"/>">
				<input type="hidden" id="attachment.version" name="attachment.version" value="<ws:property value="attachment.version"/>">
			  </table>
			</td>
		  </tr>
		  <tfoot>
			<tr>
			  <td colspan="4">
			    &nbsp;
			  </td>
			</tr>
		  </tfoot>
		</table>  <!-- fields to edit end -->
		<!-- orderDetail edit -->
				
	
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="submit" id="save" value="<hi:text key="上传" entity="attachment"/>" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"/>" class="Button2" onclick="javascript:window.close()"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>