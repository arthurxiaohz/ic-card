<#if property.isPrimaryKey><#include "hbm-primaryKeyProperty.ftl"/><#else>    
        <property name="${property.fieldName}" type="<#if fieldType == 1>string</#if><#if fieldType == 2 || fieldType == 7>integer</#if><#if fieldType == 3>double</#if><#if fieldType == 4>date</#if><#if fieldType == 5>timestamp</#if><#if fieldType == 9>org.hi.framework.dao.hibernate.StringClobType</#if>">
            <column name="${property.fieldName}" <#if fieldType == 1 || fieldType=3>length="${property.length?c}"</#if><#if property.isFull> not-null="true"</#if>/>
        </property></#if>
