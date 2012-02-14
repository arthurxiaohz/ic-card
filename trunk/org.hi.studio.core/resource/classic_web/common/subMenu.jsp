
<%@ taglib uri="/WEB-INF/tld/struts-menu.tld" prefix="menu" %>
<%@ taglib uri="/WEB-INF/tld/hi.tld" prefix="hi" %>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<menu:useMenuDisplayer name="Velocity" config="/templates/xloadsub.html"
  bundle="">
    <hi:displayMenu name="com.hi.tree.menu"/>
</menu:useMenuDisplayer>
