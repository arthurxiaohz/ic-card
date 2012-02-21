
	  <action name="${entity.entityName?uncap_first}List"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}ListAction">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}List.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}Save"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}SaveAction">
			<result name="success" type="redirect-action">${entity.entityName?uncap_first}List</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}Edit"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}ViewAction">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}Edit.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}View"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}ViewAction">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}View.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>		
		
		<action name="${entity.entityName?uncap_first}Remove"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}RemoveAction">
			<result name="success" type="redirect-action">${entity.entityName?uncap_first}List</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
		<action name="${entity.entityName?uncap_first}RemoveAll"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}RemoveAllAction">
			<result name="success" type="redirect-action">${entity.entityName?uncap_first}List</result>
			<interceptor-ref name="modelParamsStack" />
		</action>
		
	  	<action name="${entity.entityName?uncap_first}Lookup"
			class="${service.packageName}.action.webwork.${entity.entityName?cap_first}ListAction">
			<result name="success">/${service.serviceName}/${entity.entityName?cap_first}List.jsp</result>
			<interceptor-ref name="modelParamsStack" />
		</action>		
		