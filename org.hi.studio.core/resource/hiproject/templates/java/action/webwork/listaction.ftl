package ${service.packageName}.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import ${service.packageName}.action.${entity.entityName?cap_first}PageInfo;
import ${service.packageName}.model.${entity.entityName?cap_first};
import ${service.packageName}.service.${entity.entityName?cap_first}Manager;

public class ${entity.entityName?cap_first}ListAction extends BaseAction{
	private ${entity.entityName?cap_first} ${entity.entityName?uncap_first};
	private ${entity.entityName?cap_first}PageInfo pageInfo;
	private List<${entity.entityName?cap_first}> ${entity.entityName?uncap_first}s;
	
	public String execute() throws Exception {
		${entity.entityName?cap_first}Manager ${entity.entityName?uncap_first}Mgr = (${entity.entityName?cap_first}Manager)SpringContextHolder.getBean(${entity.entityName?cap_first}.class);
		pageInfo = pageInfo == null ? new ${entity.entityName?cap_first}PageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		${entity.entityName?uncap_first}s = ${entity.entityName?uncap_first}Mgr.getSecurity${entity.entityName?cap_first}List(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public ${entity.entityName?cap_first} get${entity.entityName?cap_first}() {
		return ${entity.entityName?uncap_first};
	}

	public void set${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first}) {
		this.${entity.entityName?uncap_first} = ${entity.entityName?uncap_first};
	}
	
	public List<${entity.entityName?cap_first}> get${entity.entityName?cap_first}s() {
		return ${entity.entityName?uncap_first}s;
	}

	public void set${entity.entityName?cap_first}s(List<${entity.entityName?cap_first}> ${entity.entityName?uncap_first}s) {
		this.${entity.entityName?uncap_first}s = ${entity.entityName?uncap_first}s;
	}

	public ${entity.entityName?cap_first}PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(${entity.entityName?cap_first}PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
