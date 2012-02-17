        <many-to-one name="${property.fieldName}" class="${allServices["${property.lookupEntity.lkServiceName}"].packageName}.model.${property.lookupEntity.lkEntityName?cap_first}" outer-join="auto"  not-null="false" not-found="ignore" fetch="select" foreign-key="none">
            <column name="${property.fieldName}"  not-null="false"/>
        </many-to-one>
        