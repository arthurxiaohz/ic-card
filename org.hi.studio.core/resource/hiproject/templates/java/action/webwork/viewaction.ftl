package ${service.packageName}.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import ${service.packageName}.model.${entity.entityName?cap_first};
import ${service.packageName}.service.${entity.entityName?cap_first}Manager;

public class ${entity.entityName?cap_first}ViewAction extends BaseAction{
	private ${entity.entityName?cap_first} ${entity.entityName?uncap_first};
	
	public String execute() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		${entity.entityName?uncap_first} = ${entity.entityName?uncap_first}Mgr.get${entity.entityName?cap_first}ById(${entity.entityName?uncap_first}.getId());
		return returnCommand();
	}
	
	public ${entity.entityName?cap_first} get${entity.entityName?cap_first}() {
		return ${entity.entityName?uncap_first};
	}

	public void set${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first}) {
		this.${entity.entityName?uncap_first} = ${entity.entityName?uncap_first};
	}
}
