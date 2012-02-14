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
  <form name="saveForm" action="attachmentSave.action" method="post" onsubmit="return checkValue('')">
   <script>
	 if (window.opener != undefined)
	 {
      lookupAttachment('<ws:property value="attachment.id"/>','<ws:property  value="attachment.fileName"/>','<ws:property   value="attachment.attachmentPath"/>','<ws:property  value="attachment.attachDesc"/>','<ws:property  value="attachment.attachmentSize"/>',"<ws:property  value="attachment.imageICO"/>")
      
     }
    </script>
  </form>
</body>
</html>