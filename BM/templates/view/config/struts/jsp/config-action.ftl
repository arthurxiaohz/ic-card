
	  <action name="${entity.entityName?uncap_first}List"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="${entity.entityName?uncap_first}List">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}List.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}Save"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="save${entity.entityName?cap_first}">
			<result name="success" type="redirect-action">${entity.entityName?uncap_first}List</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
					
		<action name="${entity.entityName?uncap_first}Edit"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="view${entity.entityName?cap_first}">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}Edit.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}View"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="view${entity.entityName?cap_first}">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}View.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>		
		
		<action name="${entity.entityName?uncap_first}Remove"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="remove${entity.entityName?cap_first}">
			<result name="success" type="redirect-action">${entity.entityName?uncap_first}List</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}RemoveAll"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="removeAll${entity.entityName?cap_first}">
			<result name="success" type="redirect-action">${entity.entityName?uncap_first}List</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
	  	<action name="${entity.entityName?uncap_first}Lookup"
			class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action" method="${entity.entityName?uncap_first}List">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}List.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>		
		