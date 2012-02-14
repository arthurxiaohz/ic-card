<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee 
	http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">

	<!-- Context Configuration locations for Spring XML files -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/config/appContext*.xml,classpath*:/org/**/appContext*.xml,classpath*:/test/**/appContext*.xml,classpath*:/com/**/appContext*.xml,classpath*:/org/bpmwf/**/appContext*.xml</param-value>
	</context-param>
	<context-param>
		<param-name>contextClass</param-name>
		<param-value>org.hi.framework.spring.XmlWebApplicationContext</param-value>
	</context-param>	
	<!-- menu   -->
		<context-param>
        <param-name>menuConfigLocation</param-name>
        <param-value>
            /WEB-INF/menu-config.xml
        </param-value>
    </context-param>
<!-- 
    <filter>
        <filter-name>sessionTimeOutFilter</filter-name>
        <filter-class>org.hi.framework.web.filter.SessionTimeOutFilter</filter-class>
        <init-param>
            <param-name>sessionAttributeKey</param-name>
            <param-value>abc</param-value>
        </init-param>
        <init-param>
            <param-name>redirectURI</param-name>
            <param-value>/login.jsp</param-value>
        </init-param>   
        <init-param>
            <param-name>unincludeURIs</param-name>
            <param-value>/login.jsp,/index.jsp</param-value>
        </init-param>                
    </filter> 
 -->    
    <filter>
        <filter-name>securityFilter</filter-name>
        <filter-class>org.acegisecurity.util.FilterToBeanProxy</filter-class>
        <init-param>
            <param-name>targetClass</param-name>
            <param-value>org.acegisecurity.util.FilterChainProxy</param-value>
        </init-param>
    </filter>    
	<filter>
		<filter-name>CharacterEncodingFilter</filter-name>
		<filter-class>
			org.springframework.web.filter.CharacterEncodingFilter
		</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<#if ormType == "hibernate">
	<filter>
		<filter-name>hibernateFilter</filter-name>
		<filter-class>org.springframework.orm.hibernate3.support.OpenSessionInViewFilter</filter-class>
		<init-param>
			<param-name>sessionFactoryBeanName</param-name>
			<param-value>sessionFactory</param-value>
		</init-param>		
	</filter>
	</#if>
	
	<#if viewType == "webwork">
	<filter>
		<filter-name>ActionContextCleanUp</filter-name>
		<filter-class>
			com.opensymphony.webwork.dispatcher.ActionContextCleanUp
		</filter-class>
	</filter>
	
	<filter>
		<filter-name>webwork</filter-name>
		<filter-class>
			com.opensymphony.webwork.dispatcher.FilterDispatcher
		</filter-class>
	</filter>
	<#elseif viewType == "struts">
	<filter>
		<filter-name>ActionContextCleanUp</filter-name>
		<filter-class>org.apache.struts2.dispatcher.ActionContextCleanUp</filter-class>
	</filter>

	<filter>
		<filter-name>struts2Filter</filter-name>
		<filter-class>org.apache.struts2.dispatcher.FilterDispatcher</filter-class>
	</filter>
	</#if>


    <filter-mapping>
        <filter-name>securityFilter</filter-name>
        <url-pattern>/j_security_check</url-pattern>
    </filter-mapping>
    
    <filter-mapping>
        <filter-name>securityFilter</filter-name>
        <url-pattern>/j_acegi_logout</url-pattern>
    </filter-mapping>
    
    <filter-mapping>
        <filter-name>securityFilter</filter-name>
        <url-pattern>*.action</url-pattern>
    </filter-mapping>    
    <filter-mapping>
        <filter-name>securityFilter</filter-name>
        <url-pattern>*.jsp</url-pattern>
    </filter-mapping>

    

<!--     
   	<filter-mapping>
		<filter-name>sessionTimeOutFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping> 
-->	   
	<filter-mapping>
		<filter-name>CharacterEncodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	<#if ormType == "hibernate">
	<filter-mapping>
		<filter-name>hibernateFilter</filter-name>
		<url-pattern>*.jsp</url-pattern>
	</filter-mapping>
	<filter-mapping>
		<filter-name>hibernateFilter</filter-name>
		<url-pattern>*.action</url-pattern>
	</filter-mapping>	
	
	</#if>
	<#if viewType == "webwork">
	<filter-mapping>
		<filter-name>ActionContextCleanUp</filter-name>
		<url-pattern>*.action</url-pattern>
	</filter-mapping>
	
	<filter-mapping>
		<filter-name>webwork</filter-name>
		<url-pattern>*.action</url-pattern>
	</filter-mapping>
	<#elseif viewType == "struts">
	<filter-mapping>
		<filter-name>ActionContextCleanUp</filter-name>
		<url-pattern>*.action</url-pattern>
	</filter-mapping>
	
	<filter-mapping>
		<filter-name>struts2Filter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	</#if>
	<listener>
		<listener-class>org.hi.framework.spring.ContextLoaderListener</listener-class>
	</listener>
	<!-- menu listener -->
	  <listener>
        <listener-class>net.sf.navigator.menu.MenuContextListener</listener-class>
    </listener>
    <listener>  
        <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>  
    </listener>
    
	<welcome-file-list>
		<welcome-file>login.jsp</welcome-file>
	</welcome-file-list>
	

	<jsp-config>
	<#if viewType == "webwork">
		<taglib>
			<taglib-uri>webwork</taglib-uri>
			<taglib-location>
				/WEB-INF/lib/webwork-2.2.4.jar
			</taglib-location>
		</taglib>
	<#elseif viewType == "struts">	
		<taglib>
			<taglib-uri>struts</taglib-uri>
			<taglib-location>
				/WEB-INF/lib/struts2-core-2.0.14.jar
			</taglib-location>
		</taglib>
	</#if>

   <taglib>
		<taglib-uri>hi</taglib-uri>
		<taglib-location>/WEB-INF/tld/hi.tld</taglib-location>
	</taglib>

	</jsp-config>
</web-app>
