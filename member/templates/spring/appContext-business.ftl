    <bean id="${service.packageName}.model.${entity.entityName?cap_first}" parent="txProxyTemplate">
        <property name="target">
            <bean class="${service.packageName}.service.impl.${entity.entityName?cap_first}ManagerImpl">
                <property name="DAO" ref="${service.packageName}.dao.${entity.entityName?cap_first}DAO"/>
                <property name="modelClass" value="${service.packageName}.model.${entity.entityName?cap_first}"/>
            </bean>
        </property>
    </bean>
