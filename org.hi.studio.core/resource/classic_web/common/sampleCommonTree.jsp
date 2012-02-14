<%@page import="org.hi.base.menu.strutsmenu.HiMenuComponent"%>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>
<% HiMenuComponent menu = (HiMenuComponent)request.getAttribute("com.hi.tree.menu"); %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>XTree (with Velocity) Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

 <link rel="stylesheet" type="text/css" media="screen" href="css/global.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/xtree.css"/>
    
    <script type="text/javascript" src="js/xtree.js"></script>
    <script type="text/javascript" src="js/xmlextras.js"></script>
    <script type="text/javascript" src="js/xloadtree.js"></script>
    <script type="text/javascript">
    	<%out.println(request.getAttribute("javascript"));%>
    </script>
</head>
<body class="Container">


<div>
<script type="text/javascript">
<menu:useMenuDisplayer name="Velocity" config="/templates/xtree.html"  bundle="">
if (document.getElementById) {
    <hi:displayMenu name="com.hi.tree.menu"/>
} else {
  var msg = "Your browser does not support document.getElementById().\n";
    msg += "You must use a modern browser for this menu.";
  alert(msg);
}

</menu:useMenuDisplayer>
</script>
</div>

<%if(menu.getDefine().getCheckbox()){ %>
<input type='button' name='button1' value='button1' onclick='bringBackCheckBox(selectedcb())' / >
<%} %>
</body>
</html>

