<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>
		<property name="dialect"><#if environment.database.dbtype == 'MSSQL'>org.hibernate.dialect.SQLServerDialect</#if><#if environment.database.dbtype == 'MYSQL'>hibernate.dialect org.hibernate.dialect.MySQLDialect</#if><#if environment.database.dbtype == 'ORACLE'>hibernate.dialect org.hibernate.dialect.Oracle9Dialect</#if></property>
		<property name="connection.driver_class">${environment.database.connection.driverClass}</property>
		<property name="connection.username">${environment.database.connection.username}</property>
		<property name="connection.password">${environment.database.connection.password}</property>
		<property name="connection.url">${environment.database.connection.url}</property>		
	</session-factory>
</hibernate-configuration>