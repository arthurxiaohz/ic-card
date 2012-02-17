<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>XTree (with Velocity) Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

 <link rel="stylesheet" type="text/css" media="screen"
        href="/css/global.css" />
    <link rel="stylesheet" type="text/css" media="screen"
        href="/css/xtree.css"/>
    
    <script type="text/javascript" src="/js/xtree.js"></script>
    <script type="text/javascript" src="/js/xmlextras.js"></script>
    <script type="text/javascript" src="/js/xloadtree.js"></script>
</head>
<body class="Container">


<div>

<script type="text/javascript">
<menu:useMenuDisplayer name="Velocity" config="/templates/xloadtree.html"  bundle="">
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



</body>
</html>

