<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>
<html>
<head>
    <title>XTree (with Velocity) Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        
    <link rel="stylesheet" type="text/css" media="screen" 
        href="css/menuExpandable.css" />    

    <script type="text/javascript" src="js/menuExpandable.js"></script>
    
</head>
<body class="SysMenuContainer">
<div>
<menu:useMenuDisplayer name="ListMenu" bundle="">
    <hi:displayMenu name="com.hi.tree.menu"/>
</menu:useMenuDisplayer>
</div>
</body>
</html>

