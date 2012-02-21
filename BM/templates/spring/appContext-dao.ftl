
   <!-- ===================== ${entity.entityName?cap_first} Manager And DAO Configration==================== -->  
    <bean id="${service.packageName}.dao.${entity.entityName?cap_first}DAOImpl" class="${service.packageName}.dao.<#noparse>${hi.orm.package}</#noparse>.${entity.entityName?cap_first}DAO<#noparse>${hi.orm.type}</#noparse>">
        <property name="sessionFactory" ref="sessionFactory" />
    </bean>
    <bean id="${service.packageName}.dao.${entity.entityName?cap_first}DAO" class="org.springframework.aop.framework.ProxyFactoryBean">
        <property name="proxyInterfaces" value="${service.packageName}.dao.${entity.entityName?cap_first}DAO" />
        <property name="interceptorNames">
            <list>
                <value>${service.packageName}.dao.${entity.entityName?cap_first}DAOImpl</value>
            </list>
        </property>
    </bean>
    