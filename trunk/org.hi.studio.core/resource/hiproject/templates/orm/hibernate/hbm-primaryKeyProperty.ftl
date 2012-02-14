<#if entity.entityType == 1>        <id name="id" type="integer">
            <column name="${property.fieldName}"/>
            <generator class="native"/>
        </id>
        <version name="version" type="integer" column="version"/></#if><#if entity.entityType == 3>
		<key foreign-key="none" column="${property.fieldName}"/></#if>