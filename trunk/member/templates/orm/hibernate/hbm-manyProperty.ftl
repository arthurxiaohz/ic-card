
        <bag name="${child.childEntityName?uncap_first}s" cascade="all,delete-orphan"  order-by="id" >
            <key foreign-key="none">
                <column name="${child.childForeignKey}" not-null="false"/>
            </key>
            <one-to-many class="${allServices["${child.childServiceName}"].packageName}.model.${child.childEntityName?cap_first}" />
        </bag>