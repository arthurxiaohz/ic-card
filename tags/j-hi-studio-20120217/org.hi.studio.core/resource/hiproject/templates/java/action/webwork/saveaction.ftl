package ${service.packageName}.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import ${service.packageName}.model.${entity.entityName?cap_first};
import ${service.packageName}.service.${entity.entityName?cap_first}Manager;
import org.hi.framework.web.SynchronizationData;

public class ${entity.entityName?cap_first}SaveAction extends BaseAction implements SynchronizationData{
	private ${entity.entityName?cap_first} ${entity.entityName?uncap_first};
	
	public String execute() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		if(super.perExecute(${entity.entityName?uncap_first})!= null) return returnCommand();
		${entity.entityName?uncap_first}Mgr.save${entity.entityName?cap_first}(${entity.entityName?uncap_first});
		super.postExecute(${entity.entityName?uncap_first});
		return returnCommand();
	}
	
	public ${entity.entityName?cap_first} get${entity.entityName?cap_first}() {
		return ${entity.entityName?uncap_first};
	}

	public void set${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first}) {
		this.${entity.entityName?uncap_first} = ${entity.entityName?uncap_first};
	}

}
