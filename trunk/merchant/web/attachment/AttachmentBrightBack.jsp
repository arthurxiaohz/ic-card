<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
window.parent.jQuery.bringBack({
	id:"${attachment.id}",
	fileName:"${attachment.fileName}", 
	attachmentPath:"${attachment.attachmentPath}",
	attachmentSize:"${attachment.attachmentSize}",
	imageICO:"${attachment.imageICO}"
});
</script>

